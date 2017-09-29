/**
 */
package socioProjects.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
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

import es.uam.app.main.SocioData;
import es.uam.app.parser.SentencesSplitter;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.uml.UML;
import projectHistory.Action;
import projectHistory.Add;
import projectHistory.History;
import projectHistory.Msg;
import projectHistory.Update;
import removeLog.Root;
import socioProjects.Project;
import socioProjects.SocioProjectsPackage;
import socioProjects.User;
import socioProjects.Visibility;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link socioProjects.impl.ProjectImpl#getHistory <em>History</em>}</li>
 *   <li>{@link socioProjects.impl.ProjectImpl#getRemove <em>Remove</em>}</li>
 *   <li>{@link socioProjects.impl.ProjectImpl#getModel <em>Model</em>}</li>
 *   <li>{@link socioProjects.impl.ProjectImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link socioProjects.impl.ProjectImpl#getAdmin <em>Admin</em>}</li>
 *   <li>{@link socioProjects.impl.ProjectImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProjectImpl extends MinimalEObjectImpl.Container implements Project {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHistory() <em>History</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHistory()
	 * @generated
	 * @ordered
	 */
	protected History history;

	/**
	 * The cached value of the '{@link #getRemove() <em>Remove</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRemove()
	 * @generated
	 * @ordered
	 */
	protected Root remove;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EObject model;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.PUBLIC;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdmin() <em>Admin</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdmin()
	 * @generated
	 * @ordered
	 */
	protected User admin;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	public static final int DESCENDING = 0;
	public static final int ASCENDING = 1;

	private Stack<Msg> undoMsg = new Stack<>();

	static long lastId = -1;

	public static long getNextId() {
		lastId++;
		return lastId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public History getHistory() {
		return history;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHistory(History newHistory, NotificationChain msgs) {
		History oldHistory = history;
		history = newHistory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__HISTORY, oldHistory, newHistory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistory(History newHistory) {
		if (newHistory != history) {
			NotificationChain msgs = null;
			if (history != null)
				msgs = ((InternalEObject)history).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SocioProjectsPackage.PROJECT__HISTORY, null, msgs);
			if (newHistory != null)
				msgs = ((InternalEObject)newHistory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SocioProjectsPackage.PROJECT__HISTORY, null, msgs);
			msgs = basicSetHistory(newHistory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__HISTORY, newHistory, newHistory));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Root getRemove() {
		return remove;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRemove(Root newRemove, NotificationChain msgs) {
		Root oldRemove = remove;
		remove = newRemove;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__REMOVE, oldRemove, newRemove);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemove(Root newRemove) {
		if (newRemove != remove) {
			NotificationChain msgs = null;
			if (remove != null)
				msgs = ((InternalEObject)remove).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SocioProjectsPackage.PROJECT__REMOVE, null, msgs);
			if (newRemove != null)
				msgs = ((InternalEObject)newRemove).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SocioProjectsPackage.PROJECT__REMOVE, null, msgs);
			msgs = basicSetRemove(newRemove, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__REMOVE, newRemove, newRemove));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SocioProjectsPackage.PROJECT__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(EObject newModel) {
		EObject oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User getAdmin() {
		if (admin != null && admin.eIsProxy()) {
			InternalEObject oldAdmin = (InternalEObject)admin;
			admin = (User)eResolveProxy(oldAdmin);
			if (admin != oldAdmin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SocioProjectsPackage.PROJECT__ADMIN, oldAdmin, admin));
			}
		}
		return admin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetAdmin() {
		return admin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdmin(User newAdmin, NotificationChain msgs) {
		User oldAdmin = admin;
		admin = newAdmin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__ADMIN, oldAdmin, newAdmin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdmin(User newAdmin) {
		if (newAdmin != admin) {
			NotificationChain msgs = null;
			if (admin != null)
				msgs = ((InternalEObject)admin).eInverseRemove(this, SocioProjectsPackage.USER__OWN_PROJECTS, User.class, msgs);
			if (newAdmin != null)
				msgs = ((InternalEObject)newAdmin).eInverseAdd(this, SocioProjectsPackage.USER__OWN_PROJECTS, User.class, msgs);
			msgs = basicSetAdmin(newAdmin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__ADMIN, newAdmin, newAdmin));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.PROJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getPath() {
		return SocioData.PROJECTS_PATH + "/" + getAdmin().getChannel() + "/" + getAdmin().getId() + "/" + getName();
	}

	public String getFilePath() {
		return getPath()+ "/" + getName() + "." + getFileExtension();
	}
	
	public String getPath(User admin) {
		return SocioData.PROJECTS_PATH + "/" + getAdmin().getChannel() + "/" + getAdmin().getId() + "/" + getName();
	}

	public String getFilePath(User admin) {
		return getPath(admin)+ "/" + getName() + "." + getFileExtension();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws Exception
	 * @generated NOT
	 */
	public abstract List<Action> parseSentence(String sentence) throws Exception;

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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws Exception
	 * @generated NOT
	 */
	public File execute(Msg msg) throws Exception {
		List<String> sentences = SentencesSplitter.sentencesSplitter(msg.getText());
		Map<String, List<Action>> actions = new HashMap<>();

		List<Action> allActions = new ArrayList<>();

		for (String s : sentences) {

			List<Action> act = parseSentence(s);

			actions.put(s, act);
			allActions.addAll(act);
		}
		if (allActions.isEmpty()) {
			msg.setUndoable(false);
		} else {
			undoMsg.clear();
		}
		msg.setSentences(actions);
		history.getMsg().add(msg);
		return getPng(allActions);
	}

	private File getPng(List<Action> actions) {
		File txt = UML.write(getPath() + "/" + name + ".txt", createUML(actions));
		File png = UML.getUML(txt);
		return png;
	}

	protected abstract String createUML(List<Action> actions);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws Exception
	 * @generated NOT
	 */
	public File undo() throws Exception {
		List<Msg> list = history.getMsg();
		Collections.reverse(list);
		for (Msg m : list) {
			if (m.isUndoable()) {
				Map<String, List<Action>> sentences = m.getSentencesMap();
				Set<String> keys = sentences.keySet();
				for (String k : keys) {
					List<Action> actions = sentences.get(k);
					for (int i = actions.size() - 1; i >= 0; i--) {
						Action a = actions.get(i);
						a.undoIt();
					}
				}
				undoMsg.push(m);

				history.getMsg().remove(m);
				break;
			}
		}

		return getPng(new ArrayList<Action>());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws Exception
	 * @generated NOT
	 */
	public File redo() throws Exception {
		List<Action> all = new ArrayList<Action>();
		if (!undoMsg.isEmpty()) {
			Msg m = undoMsg.pop();

			Map<String, List<Action>> sentences = m.getSentencesMap();
			Set<String> keys = sentences.keySet();
			for (String k : keys) {
				List<Action> actions = sentences.get(k);
				for (Action a : actions) {
					a.redoIt();
				}
				all.addAll(actions);
			}
			history.getMsg().add(m);
		}
		return getPng(all);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Msg> getHistoryMsg() {
		return history.getMsg();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Msg> getHistoryMsg(Date date, int order) {
		List<Msg> history = getHistoryMsg();
		List<Msg> ret = new ArrayList<>();
		if (order == DESCENDING) {
			Day aux = new Day(date);
			date = aux.getEnd();
			Collections.reverse(history);
			for (Msg msg : history) {
				if (!msg.getDate().after(date)) {
					ret.add(msg);
				}
			}
		} else {
			for (Msg rm : history) {
				if (!rm.getDate().before(date)) {
					ret.add(rm);
				}
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Msg> getHistoryMsg(Date start, Date end, int order) {
		if (end.before(start)) {
			Date aux = start;
			start = end;
			end = aux;
		}

		Day auxDay = new Day(end);
		end = auxDay.getEnd();

		List<Msg> history = getHistoryMsg();
		List<Msg> ret = new ArrayList<>();
		for (Msg rm : history) {
			if (!rm.getDate().before(start) && !rm.getDate().after(end)) {
				ret.add(rm);
			}
		}

		if (order == DESCENDING) {
			Collections.reverse(ret);
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Msg> getHistoryForUser(User u) {
		List<Msg> ret = new ArrayList<>();
		List<Msg> list = getHistoryMsg();
		for (Msg msg : list) {
			if (msg.getUser().equals(u)) {
				ret.add(msg);
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Msg> getHistoryForElement(String element) {
		List<Msg> ret = new ArrayList<>();
		List<Msg> list = getHistoryMsg();

		for (Msg msg : list) {
			if (msg.hasElement(element)) {
				ret.add(msg);
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Msg> getHistoryForAction(String action) {
		List<Msg> ret = new ArrayList<>();
		List<Msg> list = getHistoryMsg();
		for (Msg msg : list) {
			if (msg.hasAction(action)) {
				ret.add(msg);
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * 
	 * @generated NOT
	 */
	public File getStatisticsUserMsg() throws IOException {
		List<Msg> list = getHistoryMsg();

		Map<User, List<Msg>> msg_user = new HashMap<>();

		for (Msg msg : list) {
			List<Msg> userList = msg_user.get(msg.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.add(msg);
			msg_user.put(msg.getUser(), userList);
		}

		Map<String, Map<Date, List<Object>>> user_date_msg = new HashMap<>();
		Set<User> keys = msg_user.keySet();
		for (User key : keys) {
			Map<Date, List<Object>> date_msg = new HashMap<>();

			List<Msg> userList = msg_user.get(key);
			for (Msg rm : userList) {
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * 
	 * @generated NOT
	 */
	public File getStatisticsUserMsg(User u) throws IOException {
		List<Msg> list = getHistoryMsg();

		Map<Date, List<Object>> date_msg = new HashMap<>();
		for (Msg rm : list) {
			if (rm.getUser().equals(u)) {
				List<Object> msgList = date_msg.get(rm.getDate());
				if (msgList == null) {
					msgList = new ArrayList<>();
				}
				msgList.add(rm);
				date_msg.put(rm.getDate(), msgList);
			}
		}

		Map<String, Map<Date, List<Object>>> user_date_msg = new HashMap<>();
		user_date_msg.put(u.getNick(), date_msg);

		return getChart(user_date_msg, u.getNick() + " messages", "Number of messages");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * 
	 * @generated NOT
	 */
	public File getStatisticsUserAction() throws IOException {
		List<Msg> list = getHistoryMsg();

		Map<User, List<Msg>> msg_user = new HashMap<>();

		for (Msg rm : list) {
			List<Msg> userList = msg_user.get(rm.getUser());
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

			List<Msg> userList = msg_user.get(key);
			for (Msg rm : userList) {
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * 
	 * @generated NOT
	 */
	public File getStatisticsUserAction(User u) throws IOException {
		List<Msg> list = getHistoryMsg();

		Map<Date, List<Action>> date_actions = new HashMap<>();
		for (Msg rm : list) {
			if (rm.getUser().equals(u)) {
				List<Action> actionsList = date_actions.get(rm.getDate());
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
			List<Action> actions = date_actions.get(key);
			for (Action am : actions) {
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

		return getChart(actionName_date_actions, u.getNick() + " Actions", "Number of actions");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * @generated NOT
	 */
	public File getStatisticsUserMsgAbs() throws IOException {
		List<Msg> list = getHistoryMsg();
		// List<User>users=log.readAllUsers();

		Map<User, List<Msg>> msg_user = new HashMap<>();

		for (Msg rm : list) {
			List<Msg> userList = msg_user.get(rm.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.add(rm);
			msg_user.put(rm.getUser(), userList);
		}

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		Set<User> users = msg_user.keySet();
		for (User u : users) {
			List<Msg> msgs = msg_user.get(u);
			dataSet.addValue(msgs.size(), "Messages", u.getNick());
		}

		JFreeChart chart = ChartFactory.createBarChart("User messages", "users", "Messages", dataSet,
				PlotOrientation.VERTICAL, false, false, false);
		File jpg = new File(getPath() + "/" + name + "User messages" + ".jpg");
		ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);

		return jpg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * @generated NOT
	 */
	public File getStatisticsUserActionAbs() throws IOException {
		List<Msg> list = getHistoryMsg();
		// List<User>users=log.readAllUsers();

		Map<User, List<Action>> msg_action = new HashMap<>();

		for (Msg rm : list) {
			List<Action> userList = msg_action.get(rm.getUser());
			if (userList == null) {
				userList = new ArrayList<>();
			}
			userList.addAll(rm.getAllActions());
			msg_action.put(rm.getUser(), userList);
		}

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		Set<User> users = msg_action.keySet();
		for (User u : users) {
			List<Action> msgs = msg_action.get(u);
			dataSet.addValue(msgs.size(), "Actions", u.getNick());
		}

		JFreeChart chart = ChartFactory.createBarChart("User actions", "users", "Messages", dataSet,
				PlotOrientation.VERTICAL, false, false, false);
		File jpg = new File(getPath() + "/" + name + "User messages" + ".jpg");
		ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);
		return jpg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * 
	 * @generated NOT
	 */
	public File getStatisticsActions() throws IOException {
		List<Msg> list = getHistoryMsg();

		Map<Date, List<Action>> date_actions = new HashMap<>();

		for (Msg rm : list) {
			List<Action> actions = rm.getAllActions();
			List<Action> actionsList = date_actions.get(rm.getDate());
			if (actionsList == null) {
				actionsList = new ArrayList<>();
			}
			actionsList.addAll(actions);
			date_actions.put(rm.getDate(), actionsList);
		}

		Map<String, Map<Date, List<Object>>> actionName_date_actions = new HashMap<>();
		Set<Date> keys = date_actions.keySet();
		for (Date key : keys) {
			List<Action> actions = date_actions.get(key);
			for (Action am : actions) {
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

	protected abstract List<Controlador> getAllObjects();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws IOException
	 * 
	 * @generated NOT
	 */
	public File percentOfAuthorship() throws IOException {
		List<Controlador> objects = getAllObjects();
		Map<User, Double> user_rate = new HashMap<User, Double>();
		for (Controlador obj : objects) {
			Map<User, Double> user_rate_object = userRateFromObject(obj);
			Set<User> keys = user_rate_object.keySet();
			for (User u : keys) {
				Double rate = user_rate.get(u);
				if (rate == null) {
					rate = user_rate_object.get(u) / objects.size();
				} else {
					rate += user_rate_object.get(u) / objects.size();
				}
				user_rate.put(u, rate);
			}

		}

		DefaultPieDataset data = new DefaultPieDataset();
		Set<User> keys = user_rate.keySet();
		for (User k : keys) {
			Double rate = user_rate.get(k);
			Double rate_short = Math.rint(rate * 10000) / 100;
			data.setValue(k.getNick() + "= " + rate_short + "%", rate);
		}

		// Creando el Grafico
		JFreeChart chart = ChartFactory.createPieChart("Percent of authorship", data, false, false, false);
		// Mostrar Grafico
		File jpg = new File(getPath() + "/" + name + "Percent of authorship.jpg");
		ChartUtilities.saveChartAsJPEG(jpg, chart, 600, 600);

		return jpg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public abstract String validate();

	private Map<Action, User> actionsFromObject(Controlador obj) {
		Map<Action, User> ret = new HashMap<>();
		List<Msg> logMsg = getHistoryMsg();
		for (Msg msg : logMsg) {
			List<Action> actions = msg.getActionsFromObject(obj);
			for (Action act : actions) {
				ret.put(act, msg.getUser());
			}
		}
		return ret;
	}

	private Map<User, Double> userRateFromObject(Controlador obj) {
		Map<Action, User> action_user = actionsFromObject(obj);
		Map<User, Double> user_rate = new HashMap<User, Double>();
		Set<Action> actionSet = action_user.keySet();
		Action[] actionList = new Action[actionSet.size()];
		actionList = actionSet.toArray(actionList);
		List<Action> create = new ArrayList<>();
		List<Action> update = new ArrayList<>();
		for (Action act : actionList) {
			if (act instanceof Add) {
				create.add(act);
			} else if (act instanceof Update) {
				update.add(act);
			}
		}
		if (update.isEmpty()) {
			for (Action act : create) {
				User u = action_user.get(act);
				Double rate = user_rate.get(u);
				if (rate == null) {
					rate = ((double) 1 / create.size());
				} else {
					rate += ((double) 1 / create.size());
				}
				user_rate.put(u, rate);
			}
		} else {
			for (Action act : create) {
				User u = action_user.get(act);
				Double rate = user_rate.get(u);
				if (rate == null) {
					rate = ((double) 1 / create.size()) * 0.5;
				} else {
					rate += ((double) 1 / create.size()) * 0.5;
				}
				user_rate.put(u, rate);
			}

			for (Action act : update) {
				User u = action_user.get(act);
				Double rate = user_rate.get(u);
				if (rate == null) {
					rate = ((double) 1 / update.size()) * 0.5;
				} else {
					rate += ((double) 1 / update.size()) * 0.5;
				}
				user_rate.put(u, rate);
			}
		}
		return user_rate;
	}

	private File getChart(Map<String, Map<Date, List<Object>>> data, String chartName, String yName)
			throws IOException {

		Day last = new Day(new Date());
		Day first = new Day(history.getCreateMsg().getDate());

		TimeTableXYDataset dataset;
		if (first.equals(last) || first.equals(last.previous()) || first.equals(last.previous().previous())) {

			dataset = dateInHours(data, new Hour(new Date()), new Hour(first.getStart()));
		} else {
			dataset = dateInDays(data, last, first);
		}

		JFreeChart chart = ChartFactory.createTimeSeriesChart(chartName, "Date", yName, dataset, true, false, false);
		chart.getXYPlot().setRenderer(new XYSplineRenderer());

		// Mostrar Grafico
		File jpg = new File(getPath() + "/" + name + chartName + ".jpg");
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SocioProjectsPackage.PROJECT__ADMIN:
				if (admin != null)
					msgs = ((InternalEObject)admin).eInverseRemove(this, SocioProjectsPackage.USER__OWN_PROJECTS, User.class, msgs);
				return basicSetAdmin((User)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SocioProjectsPackage.PROJECT__HISTORY:
				return basicSetHistory(null, msgs);
			case SocioProjectsPackage.PROJECT__REMOVE:
				return basicSetRemove(null, msgs);
			case SocioProjectsPackage.PROJECT__ADMIN:
				return basicSetAdmin(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SocioProjectsPackage.PROJECT__NAME:
				return getName();
			case SocioProjectsPackage.PROJECT__HISTORY:
				return getHistory();
			case SocioProjectsPackage.PROJECT__REMOVE:
				return getRemove();
			case SocioProjectsPackage.PROJECT__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case SocioProjectsPackage.PROJECT__VISIBILITY:
				return getVisibility();
			case SocioProjectsPackage.PROJECT__ADMIN:
				if (resolve) return getAdmin();
				return basicGetAdmin();
			case SocioProjectsPackage.PROJECT__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SocioProjectsPackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case SocioProjectsPackage.PROJECT__HISTORY:
				setHistory((History)newValue);
				return;
			case SocioProjectsPackage.PROJECT__REMOVE:
				setRemove((Root)newValue);
				return;
			case SocioProjectsPackage.PROJECT__MODEL:
				setModel((EObject)newValue);
				return;
			case SocioProjectsPackage.PROJECT__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case SocioProjectsPackage.PROJECT__ADMIN:
				setAdmin((User)newValue);
				return;
			case SocioProjectsPackage.PROJECT__ID:
				setId((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SocioProjectsPackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SocioProjectsPackage.PROJECT__HISTORY:
				setHistory((History)null);
				return;
			case SocioProjectsPackage.PROJECT__REMOVE:
				setRemove((Root)null);
				return;
			case SocioProjectsPackage.PROJECT__MODEL:
				setModel((EObject)null);
				return;
			case SocioProjectsPackage.PROJECT__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case SocioProjectsPackage.PROJECT__ADMIN:
				setAdmin((User)null);
				return;
			case SocioProjectsPackage.PROJECT__ID:
				setId(ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SocioProjectsPackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SocioProjectsPackage.PROJECT__HISTORY:
				return history != null;
			case SocioProjectsPackage.PROJECT__REMOVE:
				return remove != null;
			case SocioProjectsPackage.PROJECT__MODEL:
				return model != null;
			case SocioProjectsPackage.PROJECT__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case SocioProjectsPackage.PROJECT__ADMIN:
				return admin != null;
			case SocioProjectsPackage.PROJECT__ID:
				return id != ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SocioProjectsPackage.PROJECT___GET_PATH:
				return getPath();
			case SocioProjectsPackage.PROJECT___PARSE_SENTENCE__STRING:
			try {
				return parseSentence((String)arguments.get(0));
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
			case SocioProjectsPackage.PROJECT___EXECUTE__MSG:
			try {
				execute((Msg)arguments.get(0));
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___UNDO:
			try {
				undo();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___REDO:
			try {
				redo();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_HISTORY_MSG:
				return getHistoryMsg();
			case SocioProjectsPackage.PROJECT___GET_HISTORY_MSG__DATE_INT:
				return getHistoryMsg((Date)arguments.get(0), (Integer)arguments.get(1));
			case SocioProjectsPackage.PROJECT___GET_HISTORY_MSG__DATE_DATE_INT:
				return getHistoryMsg((Date)arguments.get(0), (Date)arguments.get(1), (Integer)arguments.get(2));
			case SocioProjectsPackage.PROJECT___GET_HISTORY_FOR_USER__USER:
				return getHistoryForUser((User)arguments.get(0));
			case SocioProjectsPackage.PROJECT___GET_HISTORY_FOR_ELEMENT__STRING:
				return getHistoryForElement((String)arguments.get(0));
			case SocioProjectsPackage.PROJECT___GET_HISTORY_FOR_ACTION__STRING:
				return getHistoryForAction((String)arguments.get(0));
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_USER_MSG:
			try {
				getStatisticsUserMsg();
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_USER_MSG__USER:
			try {
				getStatisticsUserMsg((User)arguments.get(0));
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_USER_ACTION:
			try {
				getStatisticsUserAction();
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_USER_ACTION__USER:
			try {
				getStatisticsUserAction((User)arguments.get(0));
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_USER_MSG_ABS:
			try {
				getStatisticsUserMsgAbs();
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_USER_ACTION_ABS:
			try {
				getStatisticsUserActionAbs();
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___GET_STATISTICS_ACTIONS:
			try {
				getStatisticsActions();
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___PERCENT_OF_AUTHORSHIP:
			try {
				percentOfAuthorship();
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case SocioProjectsPackage.PROJECT___VALIDATE:
				return validate();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

	public Date getCreateDate() {
		return history.getCreateMsg().getDate();
	}

	public void remove(){
		removeFiles();
		getAdmin().getOwnProjects().remove(this);
		
		
	}
	protected abstract void removeFiles(); 
	
	abstract String getType();

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	public String getProjectData() {
		return getAdmin().getChannel() + "/" + getAdmin().getNick() + "/" + getName() + "\n\t"
				+ formatter.format(getCreateDate()) + ", " + getType() + ", " + getVisibility();
	}

} // ProjectImpl