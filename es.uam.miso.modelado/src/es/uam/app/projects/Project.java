package es.uam.app.projects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeTableXYDataset;

import es.uam.app.actions.ActionModel;
import es.uam.app.actions.Create;
import es.uam.app.actions.Update;
import es.uam.app.main.commands.History.Order;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.User;
import es.uam.app.parser.SentencesSplitter;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.log.HistoryControl;
import es.uam.app.projects.log.RemoveLogControl;
import es.uam.app.uml.UML;

public abstract class Project {

	protected final static String URI = "./projects";
	private static List<Project> proj = new ArrayList<Project>();

	private Stack<ReceivedMessage> undoMsg = new Stack<>();

	public enum ProjectType {
		METAMODEL, MODEL
	}

	protected RemoveLogControl rlc;
	protected HistoryControl log;
	private String name;

	protected Project(RemoveLogControl rlc, HistoryControl log, String name) {
		super();
		this.rlc = rlc;
		this.log = log;
		this.name = name;
	}

	public static void createProject(String name, ReceivedMessage msg, ProjectType type) {

		File dir = new File(URI + "/" + name);
		dir.mkdirs();

		HistoryControl nuevoLg = new HistoryControl(URI + "/" + name + "/" + name + "History" + ".xmi", true);
		RemoveLogControl nuevoRm = new RemoveLogControl(URI + "/" + name + "/" + name + "RemoveLog.xmi", true);
		nuevoLg.setCreateMsg(msg);
		Project p = getProject(name);

		if (type == ProjectType.METAMODEL) {
			if (p != null) {
				p.setFileProject(MetaModelProject.createFileProject(name, msg));
				p.log = nuevoLg;
			} else {
				p = new MetaModelProject(MetaModelProject.createFileProject(name, msg), nuevoRm, nuevoLg, name);
				proj.add(p);
			}
		}
		p.save();
	}

	public abstract String FilePath();

	public abstract FileProject getFileProject();

	public abstract void setFileProject(FileProject fileProj);
	
	public abstract List<Controlador> getAllObjects();

	private static void cargaProject(String name, ProjectType type) throws FatalException {

		HistoryControl nuevoLg = new HistoryControl(URI + "/" + name + "/" + name + "History" + ".xmi", false);
		RemoveLogControl nuevoRm = new RemoveLogControl(URI + "/" + name + "/" + name + "RemoveLog.xmi", false);

		Project p = getProject(name);

		if (type == ProjectType.METAMODEL) {
			if (p != null) {
				p.setFileProject(MetaModelProject.cargaFileProject(name));
				p.log = nuevoLg;
			} else {
				p = new MetaModelProject(MetaModelProject.cargaFileProject(name), nuevoRm, nuevoLg, name);
				proj.add(p);
			}
		}
		p.save();

	}

	public static Project getProject(String name) {
		for (Project p : proj) {
			if (p.name.equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}

	public static void loadProjects() throws IOException, FatalException {
		File modelDirectory = new File(URI);
		if (!modelDirectory.exists()) {
			modelDirectory.mkdirs();
			return;
		}
		for (String nameaux : modelDirectory.list()) {
			File faux = new File(modelDirectory.getAbsolutePath() + "/" + nameaux);
			if (faux.isDirectory()) {
				if (isMetaModel(faux)) {

					cargaProject(nameaux, ProjectType.METAMODEL);

				} else if (isModel(faux)) {
					cargaProject(nameaux, ProjectType.MODEL);
				}
			}
		}
	}

	private static boolean isMetaModel(File dir) {
		boolean ecore = false;
		boolean xml = false;
		for (File f : dir.listFiles()) {
			if (f.isFile() && f.getName().endsWith(".ecore")) {
				ecore = true;
			} else if (f.isFile() && f.getName().endsWith(".xmi")) {
				xml = true;
			}
		}
		return ecore && xml;
	}

	private static boolean isModel(File dir) {
		return false;
	}

	public String getName() {
		return name;
	}

	public File getPng(List<ActionModel> actions) {
		File txt = UML.write(URI + "/" + name + "/" + name + ".txt", getFileProject().createUML(actions));
		File png = UML.getUML(txt);
		return png;
	}

	public abstract List<ActionModel> parseSentence(String sentece) throws Exception;

	public File execute(ReceivedMessage msg) throws Exception {
		List<String> sentences = SentencesSplitter.sentencesSplitter(msg.getText());
		Map<String, List<ActionModel>> actions = new HashMap<>();

		List<ActionModel> allActions = new ArrayList<>();

		for (String s : sentences) {

			List<ActionModel> act = parseSentence(s);

			actions.put(s, act);
			allActions.addAll(act);
		}
		if (allActions.isEmpty()) {
			msg.setUndoable(false);
		} else {
			undoMsg.clear();
		}
		msg.setSentences(actions);
		log.writeHistoryMsg(msg);
		this.save();
		return getPng(allActions);
	}

	protected <T extends Project> List<ExtractionRule<T>> decide(List<List<ExtractionRule<T>>> allRules) {

		List<ExtractionRule<T>> ret = new ArrayList<>();
		if (allRules.isEmpty()) {
			return ret;
		}

		for (List<ExtractionRule<T>> rulesOptions : allRules) {
			ExtractionRule<T> actual = rulesOptions.get(0);
			for (ExtractionRule<T> er : rulesOptions) {
				if (er.getPriority() > actual.getPriority()) {
					actual = er;
				}
			}
			ret.add(actual);
		}
		return ret;

	}

	public File undo() throws Exception {

		List<ReceivedMessage> list = log.readHistoryMsgs();
		Collections.reverse(list);
		for (ReceivedMessage m : list) {
			if (m.isUndoable()) {
				Map<String, List<ActionModel>> sentences = m.getSentences();
				Set<String> keys = sentences.keySet();
				for (String k : keys) {
					List<ActionModel> actions = sentences.get(k);
					for (int i = actions.size() - 1; i >= 0; i--) {
						ActionModel a = actions.get(i);
						a.undoIt(this);
					}
				}
				undoMsg.push(m);

				log.undoMsg(m);
				break;
			}
		}

		this.save();
		return getPng(new ArrayList<ActionModel>());
	}

	public File redo() throws Exception {
		List<ActionModel> all = new ArrayList<ActionModel>();
		if (!undoMsg.isEmpty()) {
			ReceivedMessage m = undoMsg.pop();

			Map<String, List<ActionModel>> sentences = m.getSentences();
			Set<String> keys = sentences.keySet();
			for (String k : keys) {
				List<ActionModel> actions = sentences.get(k);
				for (ActionModel a : actions) {
					a.redoIt(this);
				}
				all.addAll(actions);
			}
			log.writeHistoryMsg(m);

			this.save();
		}
		return getPng(all);
	}

	private void save() {
		getFileProject().save();
		log.save();
		rlc.save();

	}

	public List<ReceivedMessage> getHistoryUser(String userNick) {
		List<ReceivedMessage> ret = new ArrayList<>();
		List<ReceivedMessage> list = log.readHistoryMsgs();
		for (ReceivedMessage rm : list) {
			if (rm.getUser().getNick().equalsIgnoreCase(userNick)) {
				ret.add(rm);
			}
		}
		return ret;
	}

	public List<ReceivedMessage> getHistoryElement(String element) throws Exception {
		List<ReceivedMessage> ret = new ArrayList<>();
		List<ReceivedMessage> list = log.readHistoryMsgs();

		for (ReceivedMessage rm : list) {
			if (rm.hasElement(element)) {
				ret.add(rm);
			}
		}
		return ret;
	}

	public List<ReceivedMessage> getHistoryAction(String action) {
		List<ReceivedMessage> ret = new ArrayList<>();
		List<ReceivedMessage> list = log.readHistoryMsgs();
		for (ReceivedMessage rm : list) {
			if (rm.hasAction(action)) {
				ret.add(rm);
			}
		}
		return ret;
	}

	public List<ReceivedMessage> getHistory() {
		return log.readHistoryMsgs();
	}

	public List<ReceivedMessage> getHistory(Date date, Order order) {
		List<ReceivedMessage> history = getHistory();
		List<ReceivedMessage> ret = new ArrayList<>();
		if (order == Order.DESCENDING) {
			Day aux = new Day(date);
			date = aux.getEnd();
			Collections.reverse(history);
			for (ReceivedMessage rm : history) {
				if (!rm.getDate().after(date)) {
					ret.add(rm);
				}
			}
		} else {
			for (ReceivedMessage rm : history) {
				if (!rm.getDate().before(date)) {
					ret.add(rm);
				}
			}
		}
		return ret;
	}

	public List<ReceivedMessage> getHistory(Date start, Date end, Order order) {

		if (end.before(start)) {
			Date aux = start;
			start = end;
			end = aux;
		}

		Day auxDay = new Day(end);
		end = auxDay.getEnd();

		List<ReceivedMessage> history = getHistory();
		List<ReceivedMessage> ret = new ArrayList<>();
		for (ReceivedMessage rm : history) {
			if (!rm.getDate().before(start) && !rm.getDate().after(end)) {
				ret.add(rm);
			}
		}

		if (order == Order.DESCENDING) {
			Collections.reverse(ret);
		}
		return ret;
	}

	public File getStatisticsUserMsg() throws IOException {

		List<ReceivedMessage> list = log.readHistoryMsgs();

		Map<User, List<ReceivedMessage>> msg_user = new HashMap<>();

		for (ReceivedMessage rm : list) {
			List<ReceivedMessage> userList = msg_user.get(rm.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.add(rm);
			msg_user.put(rm.getUser(), userList);
		}

		Map<String, Map<Date, List<Object>>> user_date_msg = new HashMap<>();
		Set<User> keys = msg_user.keySet();
		for (User key : keys) {
			Map<Date, List<Object>> date_msg = new HashMap<>();

			List<ReceivedMessage> userList = msg_user.get(key);
			for (ReceivedMessage rm : userList) {
				List<Object> msgList = date_msg.get(rm.getDate());
				if (msgList == null) {
					msgList = new ArrayList<>();
				}
				msgList.add(rm.getDate());
				date_msg.put(rm.getDate(), msgList);
			}
			user_date_msg.put(key.getNick(), date_msg);

		}

		return getChart(user_date_msg, "User messages", "Number of messages");
	}

	public File getStatisticsUserAction() throws IOException {
		List<ReceivedMessage> list = log.readHistoryMsgs();
		// List<User>users=log.readAllUsers();

		Map<User, List<ReceivedMessage>> msg_user = new HashMap<>();

		for (ReceivedMessage rm : list) {
			List<ReceivedMessage> userList = msg_user.get(rm.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.add(rm);
			msg_user.put(rm.getUser(), userList);
		}

		Map<String, Map<Date, List<Object>>> user_date_actions = new HashMap<>();
		Set<User> keys = msg_user.keySet();
		for (User key : keys) {
			Map<Date, List<Object>> date_msg = new HashMap<>();

			List<ReceivedMessage> userList = msg_user.get(key);
			for (ReceivedMessage rm : userList) {
				List<Object> msgList = date_msg.get(rm.getDate());
				if (msgList == null) {
					msgList = new ArrayList<>();
				}
				msgList.addAll(rm.getAllActions());
				date_msg.put(rm.getDate(), msgList);
			}
			user_date_actions.put(key.getNick(), date_msg);

		}

		return getChart(user_date_actions, "Users Actions", "Number of actions");
	}

	public File getStatisticsUserMsgAbs() throws IOException {
		List<ReceivedMessage> list = log.readHistoryMsgs();
		// List<User>users=log.readAllUsers();

		Map<User, List<ReceivedMessage>> msg_user = new HashMap<>();

		for (ReceivedMessage rm : list) {
			List<ReceivedMessage> userList = msg_user.get(rm.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.add(rm);
			msg_user.put(rm.getUser(), userList);
		}

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		Set<User> users = msg_user.keySet();
		for (User u : users) {
			List<ReceivedMessage> msgs = msg_user.get(u);
			dataSet.addValue(msgs.size(), "Messages", u.getNick());
		}

		JFreeChart chart = ChartFactory.createBarChart("User messages", "users", "Messages", dataSet,PlotOrientation.VERTICAL, false, false, false);
		File jpg = new File(URI + "/" + name + "/" + name + "User messages" + ".jpg");
		ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);
		
		return jpg;
	}

	public File getStatisticsUserActionAbs() throws IOException {
		List<ReceivedMessage> list = log.readHistoryMsgs();
		// List<User>users=log.readAllUsers();

		Map<User, List<ActionModel>> msg_action = new HashMap<>();

		for (ReceivedMessage rm : list) {
			List<ActionModel> userList = msg_action.get(rm.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.addAll(rm.getAllActions());
			msg_action.put(rm.getUser(), userList);
		}

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		Set<User> users = msg_action.keySet();
		for (User u : users) {
			List<ActionModel> msgs = msg_action.get(u);
			dataSet.addValue(msgs.size(), "Actions", u.getNick());
		}

		JFreeChart chart = ChartFactory.createBarChart("User actions", "users", "Messages", dataSet,PlotOrientation.VERTICAL, false, false, false);
		File jpg = new File(URI + "/" + name + "/" + name + "User messages" + ".jpg");
		ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);
		return jpg;
	}

	public File getStatisticsActions() throws IOException {
		List<ReceivedMessage> list = log.readHistoryMsgs();
		// List<User>users=log.readAllUsers();

		Map<Date, List<ActionModel>> date_actions = new HashMap<>();

		for (ReceivedMessage rm : list) {
			List<ActionModel> actions = rm.getAllActions();
			List<ActionModel> actionsList = date_actions.get(rm.getDate());
			if (actionsList == null) {
				actionsList = new ArrayList<>();
			}
			actionsList.addAll(actions);
			date_actions.put(rm.getDate(), actionsList);
		}

		Map<String, Map<Date, List<Object>>> actionName_date_actions = new HashMap<>();
		Set<Date> keys = date_actions.keySet();
		for (Date key : keys) {
			List<ActionModel> actions = date_actions.get(key);
			for (ActionModel am : actions) {
				Map<Date, List<Object>> date_actionsAux = actionName_date_actions.get(am.getActionName());
				if (date_actionsAux == null) {
					date_actionsAux = new HashMap<>();
				}
				List<Object> actionsAux = date_actionsAux.get(key);
				if (actionsAux == null) {
					actionsAux = new ArrayList<>();
				}
				actionsAux.add(am);
				date_actionsAux.put(key, actionsAux);
				actionName_date_actions.put(am.getActionName(), date_actionsAux);
			}
		}
		return getChart(actionName_date_actions, "Actions", "Number of actions");

	}

	public File getStatisticsUserMsg(String userNick) throws IOException {
		List<ReceivedMessage> list = log.readHistoryMsgs();

		Map<Date, List<Object>> date_msg = new HashMap<>();
		for (ReceivedMessage rm : list) {
			if (rm.getUser().getNick().equalsIgnoreCase(userNick)) {
				List<Object> msgList = date_msg.get(rm.getDate());
				if (msgList == null) {
					msgList = new ArrayList<>();
				}
				msgList.add(rm);
				date_msg.put(rm.getDate(), msgList);
			}
		}

		Map<String, Map<Date, List<Object>>> user_date_msg = new HashMap<>();
		user_date_msg.put(userNick, date_msg);

		return getChart(user_date_msg, userNick + " messages", "Number of messages");
	}

	public File getStatisticsUserAction(String userNick) throws IOException {
		List<ReceivedMessage> list = log.readHistoryMsgs();

		Map<Date, List<ActionModel>> date_actions = new HashMap<>();
		for (ReceivedMessage rm : list) {
			if (rm.getUser().getNick().equalsIgnoreCase(userNick)) {
				List<ActionModel> actionsList = date_actions.get(rm.getDate());
				if (actionsList == null) {
					actionsList = new ArrayList<>();
				}
				actionsList.addAll(rm.getAllActions());
				date_actions.put(rm.getDate(), actionsList);
			}
		}
		Map<String, Map<Date, List<Object>>> actionName_date_actions = new HashMap<>();
		String allActions = "All actions";
		actionName_date_actions.put(allActions, new HashMap<>());
		Set<Date> keys = date_actions.keySet();
		for (Date key : keys) {
			List<ActionModel> actions = date_actions.get(key);
			for (ActionModel am : actions) {
				Map<Date, List<Object>> date_actionsAux = actionName_date_actions.get(am.getActionName());
				if (date_actionsAux == null) {
					date_actionsAux = new HashMap<>();
				}
				List<Object> actionsAux = date_actionsAux.get(key);
				if (actionsAux == null) {
					actionsAux = new ArrayList<>();
				}
				actionsAux.add(am);
				date_actionsAux.put(key, actionsAux);
				actionName_date_actions.put(am.getActionName(), date_actionsAux);

				Map<Date, List<Object>> date_allActions = actionName_date_actions.get(allActions);
				List<Object> allActionsAux = date_allActions.get(key);
				if (allActionsAux == null) {
					allActionsAux = new ArrayList<>();
				}
				allActionsAux.add(am);
				date_allActions.put(key, allActionsAux);
				actionName_date_actions.put(allActions, date_allActions);

			}
		}

		return getChart(actionName_date_actions, userNick + " Actions", "Number of actions");
	}

	private File getChart(Map<String, Map<Date, List<Object>>> data, String chartName, String yName)
			throws IOException {

		Day last = new Day(new Date());
		Day first = new Day(log.getFirstDate());

		TimeTableXYDataset dataset;
		if (first.equals(last) || first.equals(last.previous()) || first.equals(last.previous().previous())) {

			
			dataset = dateInHours(data, new Hour(new Date()), new Hour(first.getStart()));
		} else {
			dataset = dateInDays(data, last, first);
		}

		JFreeChart chart = ChartFactory.createTimeSeriesChart(chartName, "Date", yName, dataset, true, false, false);
		chart.getXYPlot().setRenderer(new XYSplineRenderer());

		// Mostrar Grafico
		File jpg = new File(URI + "/" + name + "/" + name + chartName + ".jpg");
		ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);

		return jpg;
	}

	private TimeTableXYDataset dateInDays(Map<String, Map<Date, List<Object>>> data, Day last, Day first) {

		TimeTableXYDataset dataset = new TimeTableXYDataset();

		Set<String> stringKeys = data.keySet();
		for (String sk : stringKeys) {

			// Convertir dates a days
			Map<Date, List<Object>> date_objects = data.get(sk);
			Map<Day, List<Object>> day_objects = new HashMap<>();

			Set<Date> dateKeys = date_objects.keySet();
			for (Date dk : dateKeys) {
				Day day = new Day(dk);
				List<Object> dateObjList = date_objects.get(dk);
				List<Object> objList = day_objects.get(day);
				if (objList != null) {
					objList.addAll(dateObjList);
					day_objects.put(day, objList);
				} else {
					day_objects.put(day, dateObjList);
				}

			}

			// guardar los datos en dataSet

			Day current = first;
			while (current.compareTo(last) <= 0) {
				List<Object> objs = day_objects.get(current);
				if (objs == null) {
					dataset.add(current, 0, sk);
				} else {
					dataset.add(current, objs.size(), sk);
				}
				current = (Day) current.next();
			}

		}

		return dataset;

	}

	private TimeTableXYDataset dateInHours(Map<String, Map<Date, List<Object>>> data, Hour last, Hour first) {

		TimeTableXYDataset dataset = new TimeTableXYDataset();

		Set<String> stringKeys = data.keySet();
		for (String sk : stringKeys) {

			// Convertir dates a hours
			Map<Date, List<Object>> date_objects = data.get(sk);
			Map<Hour, List<Object>> hour_objects = new HashMap<>();

			Set<Date> dateKeys = date_objects.keySet();
			for (Date dk : dateKeys) {
				Hour hour = new Hour(dk);
				List<Object> dateObjList = date_objects.get(dk);
				List<Object> objList = hour_objects.get(hour);
				if (objList != null) {
					objList.addAll(dateObjList);
					hour_objects.put(hour, objList);
				} else {
					hour_objects.put(hour, dateObjList);
				}
			}

			// guardar los datos en dataSet

			Hour current = first;
			while (current.compareTo(last) <= 0) {
				List<Object> objs = hour_objects.get(current);
				if (objs == null) {
					dataset.add(current, 0, sk);
				} else {
					dataset.add(current, objs.size(), sk);
				}
				current = (Hour) current.next();
			}

		}

		return dataset;
	}
	

	public File percentOfAuthorship() throws IOException{
		List<Controlador> objects= getAllObjects();
		Map<User, Double> user_rate= new HashMap<User, Double>();
		for (Controlador obj: objects){
			Map<User, Double> user_rate_object= userRateFromObject(obj);
			Set<User> keys= user_rate_object.keySet();
			for (User u: keys){
				Double rate=user_rate.get(u);
				if (rate==null){
					rate=user_rate_object.get(u)/objects.size();
				}else{
					rate+=user_rate_object.get(u)/objects.size();
				}
				user_rate.put(u, rate);
			}
			
		}
		
		
		  DefaultPieDataset data = new DefaultPieDataset();
	      Set<User> keys=user_rate.keySet();
	      for (User k: keys){
	    	  Double rate=user_rate.get(k);
	    	  Double rate_short= Math.rint(rate*10000)/100;
	    	  data.setValue(k.getNick()+"= "+rate_short+"%", rate);
	      }
	 
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart(
	         "Percent of authorship",data, false, false,false);
	     // Mostrar Grafico
			File jpg = new File(URI + "/" + name + "/" + name + "Percent of authorship.jpg");
			ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);

			return jpg;	 
	}
	
	private Map<ActionModel, User> actionsFromObject(Controlador obj) {
		Map<ActionModel, User> ret= new HashMap<>();
		List<ReceivedMessage> logMsg= log.readHistoryMsgs();
		for (ReceivedMessage msg: logMsg){
			List<ActionModel> actions=msg.getActionsFromObject(obj);
			for (ActionModel act: actions){
				ret.put(act, msg.getUser());
			}
		}
		return ret;
	}
	
	private Map<User, Double> userRateFromObject(Controlador obj){
		Map<ActionModel, User> action_user=actionsFromObject(obj);
		Map<User, Double> user_rate=new HashMap<User, Double>();
		Set<ActionModel> actionSet=action_user.keySet();
		ActionModel[] actionList= new ActionModel[actionSet.size()];
		actionList= actionSet.toArray(actionList);
		List<ActionModel> create=new ArrayList<>();
		List<ActionModel> update=new ArrayList<>();
		for (ActionModel act: actionList){
			if (act instanceof Create){
				create.add(act);
			}else if (act instanceof Update){
				update.add(act);
			}
		}
		if (update.isEmpty()){
			for (ActionModel act: create){
				User u=action_user.get(act);
				Double rate=user_rate.get(u);
				if (rate==null){
					rate=((double)1/create.size());
				}else{
					rate+=((double)1/create.size());
				}
				user_rate.put(u, rate);
			}
		}else{
			for (ActionModel act: create){
				User u=action_user.get(act);
				Double rate=user_rate.get(u);
				if (rate==null){
					rate=((double)1/create.size())*0.5;
				}else{
					rate+=((double)1/create.size())*0.5;
				}
				user_rate.put(u, rate);
			}
			
			for (ActionModel act: update){
				User u=action_user.get(act);
				Double rate=user_rate.get(u);
				if (rate==null){
					rate=((double)1/update.size())*0.5;
				}else{
					rate+=((double)1/update.size())*0.5;
				}
				user_rate.put(u, rate);
			}
		}
		return user_rate;
	}
	
	

	public static File getProjectList() {
		String cad = "@startuml\n";
		for (Project p : proj) {
			ReceivedMessage msg = p.log.getCreateMsg();
			cad += "folder " + p.name + "[\n";
			cad += "creation date: " + msg.getDate() + "\n";
			cad += "----\n";
			cad += "creation by: " + msg.getUser().getName() + "\n";
			cad += "----\n";
			cad += "in: " + msg.getChannel() + "\n";
			cad += "]\n";
		}
		cad += "\n@enduml";
		File txt = UML.write(URI + "/ProjectsList.txt", cad);
		File png = UML.getUML(txt);
		return png;
	}

	public abstract String validate();

}
