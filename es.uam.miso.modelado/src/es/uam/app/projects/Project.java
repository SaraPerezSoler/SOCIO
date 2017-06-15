package es.uam.app.projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.Diagnostic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeTableXYDataset;

import es.uam.app.actions.ActionModel;
import es.uam.app.main.commands.History.Order;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.User;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.SentencesSplitter;
import es.uam.app.parser.WordConfigure;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.EcoreControl;
import es.uam.app.projects.ecore.Feature;
import es.uam.app.projects.ecore.ReferenceControl;
import es.uam.app.projects.log.HistoryControl;
import es.uam.app.projects.log.RemoveLogControl;
import es.uam.app.uml.UML;
import es.uam.app.words.WordNet;
import net.didion.jwnl.JWNLException;

public class Project {

	private final static String URI = "./projects";
	private static List<Project> proj = new ArrayList<Project>();

	private Stack<ReceivedMessage> undoMsg = new Stack<>();

	private EcoreControl ec;
	private RemoveLogControl rlc;
	private HistoryControl log;
	private String name;

	private Project(EcoreControl ec, RemoveLogControl rlc, HistoryControl log, String name) {
		super();
		this.ec = ec;
		this.rlc = rlc;
		this.log = log;
		this.name = name;
	}

	public static void createProject(String name, ReceivedMessage msg) {

		File dir = new File(URI + "/" + name);
		dir.mkdirs();

		EcoreControl nuevoEc = new EcoreControl(URI + "/" + name + "/" + name + ".ecore", name, name, name);
		HistoryControl nuevoLg = new HistoryControl(URI + "/" + name + "/" + name + "History" + ".xmi", true);
		RemoveLogControl nuevoRm = new RemoveLogControl(URI + "/" + name + "/" + name + "RemoveLog.xmi", true);
		nuevoLg.setCreateMsg(msg);
		Project p = getProject(name);

		if (p != null) {
			p.ec = nuevoEc;
			p.log = nuevoLg;
		} else {
			p = new Project(nuevoEc, nuevoRm, nuevoLg, name);
			proj.add(p);
		}
		p.save();
	}

	public String ecorePath() {
		return this.ec.getPath();
	}

	private static void cargaProject(String name) throws FatalException {

		EcoreControl nuevoEc = new EcoreControl(URI + "/" + name + "/" + name + ".ecore");
		HistoryControl nuevoLg = new HistoryControl(URI + "/" + name + "/" + name + "History" + ".xmi", false);
		RemoveLogControl nuevoRm = new RemoveLogControl(URI + "/" + name + "/" + name + "RemoveLog.xmi", false);

		Project p = getProject(name);

		if (p != null) {
			p.ec = nuevoEc;
			p.log = nuevoLg;
		} else {
			p = new Project(nuevoEc, nuevoRm, nuevoLg, name);
			proj.add(p);
		}

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
				if (haveEcoreXML(faux)) {

					cargaProject(nameaux);

				}
			}
		}
	}

	private static boolean haveEcoreXML(File dir) {
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

	public String getName() {
		return name;
	}

	public File getPng(List<ActionModel> actions) {
		File txt = UML.write(URI + "/" + name + "/" + name + ".txt", ec.createUML(actions));
		File png = UML.getUML(txt);
		return png;
	}

	public File execute(ReceivedMessage msg) throws Exception {
		List<String> sentences = SentencesSplitter.sentencesSplitter(msg.getText());
		Map<String, List<ActionModel>> actions = new HashMap<>();

		List<ActionModel> allActions = new ArrayList<>();

		for (String s : sentences) {

			Sentence sentenceParse = new Sentence(s);
			List<List<ExtractionRule>> allRules = sentenceParse.parser();
			List<ExtractionRule> rules = decide(allRules);

			List<ActionModel> act = new ArrayList<ActionModel>();

			for (ExtractionRule rule : rules) {
				for (int i = 0; i < rule.numEvaluete(); i++) {
					List<ActionModel> actual = rule.evaluete(this, i);
					for (ActionModel a : actual) {
						a.doIt();
					}

					act.addAll(actual);
				}

			}
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

	private List<ExtractionRule> decide(List<List<ExtractionRule>> allRules) {

		List<ExtractionRule> ret = new ArrayList<>();
		if (allRules.isEmpty()) {
			return ret;
		}

		for (List<ExtractionRule> rulesOptions : allRules) {
			ExtractionRule actual = rulesOptions.get(0);
			for (ExtractionRule er : rulesOptions) {
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
		ec.save();
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
		Sentence sentenceParse = new Sentence(element);
		sentenceParse.parser();
		List<NP> concepts = sentenceParse.getConcepts();
		if (concepts.isEmpty()) {
			return ret;
		}
		for (ReceivedMessage rm : list) {
			if (concepts.get(0).getOf() == null) {
				if (rm.hasElement(concepts.get(0).upperCammelCase(), null)) {
					ret.add(rm);
				}
			} else {
				if (rm.hasElement(concepts.get(0).lowerCammelCase(), concepts.get(0).getOf().upperCammelCase())) {
					ret.add(rm);
				}
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
			Day aux=new Day(date);
			date= aux.getEnd();
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
		
		Day auxDay=new Day(end);
		end=auxDay.getEnd();
		
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
		if (first.equals(last) || first.equals(last.previous()) || first.equals(last.previous().previous())
				|| first.equals(last.previous().previous().previous())) {
			
			dataset=dateInHours(data, new Hour(last.next().getStart()), new Hour(first.getStart()));
		} else {
			dataset=dateInDays(data, last, first);
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
				}else{
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
				}else{
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

	public Feature getFeature(String verb, ClassControl cc) throws FileNotFoundException, JWNLException {

		String feature = WordConfigure.startLowerCase(verb);

		if (cc == null) {
			return getFeature(feature);
		}
		Feature ret = cc.getAttr(feature);
		if (ret == null) {
			ret = cc.getRef(feature);
		}

		if (ret == null) {
			List<String> synonyms;

			synonyms = WordNet.getWordNet().getSynonyms(feature);

			for (String s : synonyms) {
				ret = cc.getAttr(WordConfigure.startLowerCase(s));
				if (ret == null) {
					ret = cc.getRef(WordConfigure.startLowerCase(s));
				}
				if (ret != null) {
					return ret;
				}
			}
		}
		return ret;
	}

	public Feature getFeature(String verb) throws FileNotFoundException, JWNLException {
		String feature = WordConfigure.startLowerCase(verb);
		List<ClassControl> classes = ec.getClasses();
		Feature ret = null;
		for (ClassControl cc : classes) {
			ret = cc.getAttr(feature);
			if (ret == null) {
				ret = cc.getRef(feature);
			}
			if (ret != null) {
				return ret;
			}
		}

		List<String> synonyms;
		synonyms = WordNet.getWordNet().getSynonyms(feature);

		for (String s : synonyms) {
			for (ClassControl cc : classes) {
				ret = cc.getAttr(WordConfigure.startLowerCase(s));
				if (ret == null) {
					ret = cc.getRef(WordConfigure.startLowerCase(s));
				}
				if (ret != null) {
					return ret;
				}
			}
		}

		return null;
	}

	public Feature getExactlyFeature(String verb, ClassControl cc) throws FileNotFoundException, JWNLException {

		String feature = WordConfigure.startLowerCase(verb);

		if (cc == null) {
			return null;
		}
		Feature ret = cc.getAttr(feature);
		if (ret == null) {
			ret = cc.getRef(feature);
		}
		return ret;
	}

	public ClassControl getClass(NP element) throws FileNotFoundException, JWNLException {
		if (element.getAdj() != null && element.getAdj().lemmaEquals("abstract")) {
			return this.getClass(WordConfigure.startUpperCase(element.getNoun().getLemma()));

		} else {

			ClassControl ret = this.getClass(element.upperCammelCase());
			if (ret == null) {
				List<String> nouns;
				if (element.getNoun() != null) {
					nouns = WordNet.getWordNet().getSynonyms(element.getNoun().getLemma());
				} else {
					nouns = new ArrayList<>();
				}
				List<String> adjs;
				if (element.getAdj() != null) {
					adjs = WordNet.getWordNet().getSynonyms(element.getAdj().getLemma());
				} else {
					adjs = new ArrayList<>();
				}
				for (String n : nouns) {
					for (String a : adjs) {
						ret = ec.getClass(WordConfigure.startUpperCase(a) + WordConfigure.startUpperCase(n));
						if (ret != null) {
							return ret;
						}
					}
				}

				for (String n : nouns) {
					ret = ec.getClass(WordConfigure.startUpperCase(n));
					if (ret != null) {
						return ret;
					}
				}

			}
			return ret;
		}
	}

	public ClassControl getClass(String clas) throws FileNotFoundException, JWNLException {
		ClassControl ret = ec.getClass(clas);

		if (ret == null) {
			List<String> synonyms;
			synonyms = WordNet.getWordNet().getSynonyms(clas);

			for (String s : synonyms) {
				ret = ec.getClass(s);
				if (ret != null) {
					return ret;
				}
			}
		}

		return ret;
	}

	public ClassControl getExactlyClass(String clas) throws FileNotFoundException, JWNLException {
		ClassControl ret = ec.getExactlyClass(clas);
		return ret;
	}

	public ClassControl getExactlyClass(NP element) throws FileNotFoundException, JWNLException {
		if (element.getAdj() != null && element.getAdj().lemmaEquals("abstract")) {
			return this.getExactlyClass(WordConfigure.startUpperCase(element.getNoun().getLemma()));

		} else {
			ClassControl ret = this.getExactlyClass(element.upperCammelCase());
			return ret;
		}
	}

	public void addAttribute(AttributeControl attr, ClassControl of) {
		of.addAttrRef(attr.getEAtribute());

	}

	public void addClass(ClassControl clase) {
		ec.addClass(clase);
	}

	public void addReference(ReferenceControl ref, ClassControl of) {
		of.addAttrRef(ref.getEReference());

	}

	public void removeAttribute(AttributeControl atr, ClassControl parent) {

		rlc.addRemove(atr);
		parent.removeAttrRef(atr.getEAtribute());

	}

	public void removeClass(ClassControl class_) {
		rlc.addRemove(class_);
		ec.remove(class_);

	}

	public void removeReference(ReferenceControl ref, ClassControl parent) {
		rlc.addRemove(ref);
		parent.removeAttrRef(ref.getEReference());

	}

	public void unAddAttribute(AttributeControl attr, ClassControl of) {
		of.removeAttrRef(attr.getEAtribute());

	}

	public void unAddClass(ClassControl clase) {
		ec.remove(clase);
	}

	public void unAddReference(ReferenceControl ref, ClassControl of) {
		of.removeAttrRef(ref.getEReference());
	}

	public void unRemoveAttribute(AttributeControl atr) {
		ClassControl parent = ec.getClass(atr.getParentName());
		rlc.deleteRemove(atr);
		parent.addAttrRef(atr.getEAtribute());

	}

	public void unRemoveClass(ClassControl class_) {
		rlc.deleteRemove(class_);
		ec.addClass(class_);

	}

	public void unRemoveReference(ReferenceControl ref) {

		ClassControl type = ec.getClass(ref.getTypeName());
		ClassControl parent = ec.getClass(ref.getParentName());
		if (type != null) {
			ref.setType(type);
		}
		rlc.deleteRemove(ref);
		parent.addAttrRef(ref.getEReference());

	}

	public List<ReferenceControl> getRefTo(ClassControl cc) {
		return ec.getReferencesTo(cc);

	}

	public List<ClassControl> getSubTypesOf(ClassControl c) {
		return ec.getSubTypesOf(c);
	}

	String validateRet;

	public String validate() {

		Diagnostic diagnostic = null;

		diagnostic = ec.validate();

		List<Diagnostic> diagnosticChild = diagnostic.getChildren();
		if (diagnosticChild.isEmpty()) {
			validateRet = getStringDiagnostic(diagnostic);
		} else {
			validateRet = "";
			for (Diagnostic d : diagnosticChild) {
				validateRet += getStringDiagnostic(d) + "\n";
			}
		}
		return validateRet;

	}

	public String getValidateString() {
		return validateRet;
	}

	public String getStringDiagnostic(Diagnostic d) {
		if (d.getSeverity() == Diagnostic.ERROR) {
			return "ERROR: " + d.getMessage();
		} else if (d.getSeverity() == Diagnostic.WARNING) {
			return "WARNING: " + d.getMessage();
		} else {
			return "Validation completed successfully";
		}
	}

}
