/**
 */
package projectHistory.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import es.uam.app.projects.ecore.Controlador;
import java.lang.reflect.InvocationTargetException;
import projectHistory.Action;
import projectHistory.DslHistoryPackage;
import projectHistory.Msg;
import projectHistory.Sentence;
import socioProjects.Project;
import socioProjects.User;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Msg</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.impl.MsgImpl#getUser <em>User</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getText <em>Text</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getDate <em>Date</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getId <em>Id</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getSentences <em>Sentences</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#isUndoable <em>Undoable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MsgImpl extends MinimalEObjectImpl.Container implements Msg {
	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected User user;

	/**
	 * The default value of the '{@link #getMsg() <em>Msg</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected static final String MSG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMsg() <em>Msg</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected String msg = MSG_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommand() <em>Command</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected String command = COMMAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSentences() <em>Sentences</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSentences()
	 * @generated
	 * @ordered
	 */
	protected EList<Sentence> sentences;

	private String projectName;
	
	/**
	 * The default value of the '{@link #isUndoable() <em>Undoable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUndoable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNDOABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUndoable() <em>Undoable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUndoable()
	 * @generated
	 * @ordered
	 */
	protected boolean undoable = UNDOABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MsgImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DslHistoryPackage.Literals.MSG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		if (user != null && user.eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslHistoryPackage.MSG__USER, oldUser, user));
			}
		}
		return user;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		User oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsg(String newMsg) {
		String oldMsg = msg;
		msg = newMsg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__MSG, oldMsg, msg));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(String newCommand) {
		String oldCommand = command;
		command = newCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__COMMAND, oldCommand, command));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sentence> getSentences() {
		if (sentences == null) {
			sentences = new EObjectContainmentEList<Sentence>(Sentence.class, this, DslHistoryPackage.MSG__SENTENCES);
		}
		return sentences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUndoable() {
		return undoable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUndoable(boolean newUndoable) {
		boolean oldUndoable = undoable;
		undoable = newUndoable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DslHistoryPackage.MSG__UNDOABLE, oldUndoable, undoable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getChannel() {
		return user.getChannel();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DslHistoryPackage.MSG__SENTENCES:
				return ((InternalEList<?>)getSentences()).basicRemove(otherEnd, msgs);
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
			case DslHistoryPackage.MSG__USER:
				if (resolve) return getUser();
				return basicGetUser();
			case DslHistoryPackage.MSG__MSG:
				return getMsg();
			case DslHistoryPackage.MSG__COMMAND:
				return getCommand();
			case DslHistoryPackage.MSG__TEXT:
				return getText();
			case DslHistoryPackage.MSG__DATE:
				return getDate();
			case DslHistoryPackage.MSG__ID:
				return getId();
			case DslHistoryPackage.MSG__SENTENCES:
				return getSentences();
			case DslHistoryPackage.MSG__UNDOABLE:
				return isUndoable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DslHistoryPackage.MSG__USER:
				setUser((User)newValue);
				return;
			case DslHistoryPackage.MSG__MSG:
				setMsg((String)newValue);
				return;
			case DslHistoryPackage.MSG__COMMAND:
				setCommand((String)newValue);
				return;
			case DslHistoryPackage.MSG__TEXT:
				setText((String)newValue);
				return;
			case DslHistoryPackage.MSG__DATE:
				setDate((Date)newValue);
				return;
			case DslHistoryPackage.MSG__ID:
				setId((String)newValue);
				return;
			case DslHistoryPackage.MSG__SENTENCES:
				getSentences().clear();
				getSentences().addAll((Collection<? extends Sentence>)newValue);
				return;
			case DslHistoryPackage.MSG__UNDOABLE:
				setUndoable((Boolean)newValue);
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
			case DslHistoryPackage.MSG__USER:
				setUser((User)null);
				return;
			case DslHistoryPackage.MSG__MSG:
				setMsg(MSG_EDEFAULT);
				return;
			case DslHistoryPackage.MSG__COMMAND:
				setCommand(COMMAND_EDEFAULT);
				return;
			case DslHistoryPackage.MSG__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case DslHistoryPackage.MSG__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case DslHistoryPackage.MSG__ID:
				setId(ID_EDEFAULT);
				return;
			case DslHistoryPackage.MSG__SENTENCES:
				getSentences().clear();
				return;
			case DslHistoryPackage.MSG__UNDOABLE:
				setUndoable(UNDOABLE_EDEFAULT);
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
			case DslHistoryPackage.MSG__USER:
				return user != null;
			case DslHistoryPackage.MSG__MSG:
				return MSG_EDEFAULT == null ? msg != null : !MSG_EDEFAULT.equals(msg);
			case DslHistoryPackage.MSG__COMMAND:
				return COMMAND_EDEFAULT == null ? command != null : !COMMAND_EDEFAULT.equals(command);
			case DslHistoryPackage.MSG__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case DslHistoryPackage.MSG__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case DslHistoryPackage.MSG__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DslHistoryPackage.MSG__SENTENCES:
				return sentences != null && !sentences.isEmpty();
			case DslHistoryPackage.MSG__UNDOABLE:
				return undoable != UNDOABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DslHistoryPackage.MSG___GET_CHANNEL:
				return getChannel();
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
		result.append(" (msg: ");
		result.append(msg);
		result.append(", command: ");
		result.append(command);
		result.append(", text: ");
		result.append(text);
		result.append(", date: ");
		result.append(date);
		result.append(", id: ");
		result.append(id);
		result.append(", undoable: ");
		result.append(undoable);
		result.append(')');
		return result.toString();
	}

	@Override
	public void setSentences(Map<String, List<Action>> actions) {
		Set<String> keys = actions.keySet();
		for (String s : keys) {
			Sentence sentence = DslHistoryFactoryImpl.eINSTANCE.createSentence();
			sentence.setSentence(s);
			sentence.getCommands().addAll(actions.get(s));
			this.sentences.add(sentence);
		}
	}

	@Override
	public Map<String, List<Action>> getSentencesMap() {
		Map<String, List<Action>> ret = new HashMap<>();
		for (Sentence sentence : sentences) {
			ret.put(sentence.getSentence(), sentence.getCommands());
		}
		return ret;
	}

	@Override
	public boolean hasElement(String element) {
		Map<String, List<Action>> sentences = getSentencesMap();
		Set<String> sentencesKeySet = sentences.keySet();
		for (String k : sentencesKeySet) {
			List<Action> ams = sentences.get(k);
			for (Action am : ams) {
				if (am.getObject().getName().equalsIgnoreCase(element)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean hasAction(String action) {
		Map<String, List<Action>> sentences = getSentencesMap();
		Set<String> sentencesKeySet = sentences.keySet();
		for (String k : sentencesKeySet) {
			List<Action> ams = sentences.get(k);
			for (Action am : ams) {
				if (am.getActionName().equalsIgnoreCase(action)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Action> getAllActions() {

		List<Action> actions = new ArrayList<Action>();
		for (Sentence s : sentences) {
			actions.addAll(s.getCommands());
		}
		return actions;
	}

	@Override
	public List<Action> getActionsFromObject(Controlador obj) {
		List<Action> ret= new ArrayList<>();
		List<Action> actions=getAllActions();
		for(Action act: actions){
			if (act.getObject().equals(obj)){
				ret.add(act);
			}
		}
		return ret;
	}

	@Override
	public void setProjectName(String projectName) {
		this.projectName=projectName;
		
	}
	
	@Override
	public String getProjectName() {
		if (projectName==null){
			if (this.eContainer()!=null){
				if (this.eContainer().eContainer()!=null){
					if (this.eContainer().eContainer() instanceof Project){
						projectName=((Project)this.eContainer().eContainer()).getName();
					}
				}
			}
				
		}
		return projectName;
		
	}

} // MsgImpl
