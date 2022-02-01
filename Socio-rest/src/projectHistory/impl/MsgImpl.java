/**
 */
package projectHistory.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import es.uam.app.projects.emf.Controlador;
import projectHistory.Action;
import projectHistory.Msg;
import projectHistory.ProjectHistoryFactory;
import projectHistory.ProjectHistoryPackage;
import projectHistory.Sentence;
import projectHistory.UserInteraction;
import socioProjects.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Msg</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.impl.MsgImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getText <em>Text</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getId <em>Id</em>}</li>
 *   <li>{@link projectHistory.impl.MsgImpl#getSentences <em>Sentences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MsgImpl extends InteractionWithActionsImpl implements Msg {
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

	private String project = null;
	private String userToSearch = null;

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
		return ProjectHistoryPackage.Literals.MSG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMsg() {
		return msg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMsg(String newMsg) {
		String oldMsg = msg;
		msg = newMsg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.MSG__MSG, oldMsg, msg));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.MSG__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Sentence> getSentences() {
		if (sentences == null) {
			sentences = new EObjectContainmentEList<Sentence>(Sentence.class, this, ProjectHistoryPackage.MSG__SENTENCES);
		}
		return sentences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.MSG__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
			case ProjectHistoryPackage.MSG__SENTENCES:
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
			case ProjectHistoryPackage.MSG__MSG:
				return getMsg();
			case ProjectHistoryPackage.MSG__TEXT:
				return getText();
			case ProjectHistoryPackage.MSG__ID:
				return getId();
			case ProjectHistoryPackage.MSG__SENTENCES:
				return getSentences();
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
			case ProjectHistoryPackage.MSG__MSG:
				setMsg((String)newValue);
				return;
			case ProjectHistoryPackage.MSG__TEXT:
				setText((String)newValue);
				return;
			case ProjectHistoryPackage.MSG__ID:
				setId((String)newValue);
				return;
			case ProjectHistoryPackage.MSG__SENTENCES:
				getSentences().clear();
				getSentences().addAll((Collection<? extends Sentence>)newValue);
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
			case ProjectHistoryPackage.MSG__MSG:
				setMsg(MSG_EDEFAULT);
				return;
			case ProjectHistoryPackage.MSG__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case ProjectHistoryPackage.MSG__ID:
				setId(ID_EDEFAULT);
				return;
			case ProjectHistoryPackage.MSG__SENTENCES:
				getSentences().clear();
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
			case ProjectHistoryPackage.MSG__MSG:
				return MSG_EDEFAULT == null ? msg != null : !MSG_EDEFAULT.equals(msg);
			case ProjectHistoryPackage.MSG__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case ProjectHistoryPackage.MSG__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ProjectHistoryPackage.MSG__SENTENCES:
				return sentences != null && !sentences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ProjectHistoryPackage.MSG___GET_CHANNEL:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (msg: ");
		result.append(msg);
		result.append(", text: ");
		result.append(text);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

	@Override
	public void setSentences(Map<String, List<Action>> actions) {
		Set<String> keys = actions.keySet();
		for (String s : keys) {
			Sentence sentence = ProjectHistoryFactoryImpl.eINSTANCE.createSentence();
			sentence.setSentence(s);
			sentence.getCommands().addAll(actions.get(s));
			this.getSentences().add(sentence);
		}
	}

	@Override
	public Map<String, List<Action>> getSentencesMap() {
		Map<String, List<Action>> ret = new HashMap<>();
		for (Sentence sentence : getSentences()) {
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
		for (Sentence s : getSentences()) {
			actions.addAll(s.getCommands());
		}
		return actions;
	}

	@Override
	public List<Action> getActionsFromObject(Controlador obj) {
		List<Action> ret = new ArrayList<>();
		List<Action> actions = getAllActions();
		for (Action act : actions) {
			if (act.getObject().equals(obj)) {
				ret.add(act);
			}
		}
		return ret;
	}

	@Override
	public boolean hasText() {
		if (this.getText() != null && !this.getText().isEmpty() && !this.getText().equals(" ")) {
			return true;
		}
		return false;
	}

	@Override
	public void setProject(String proj) {
		this.project = proj;

	}

	@Override
	public String getProject() {

		/*
		 * Si esta guardado en el modelo ya está asignado a un proyecto por lo
		 * que podemos obtener los datos
		 */
		if (this.eContainer() != null) {
			if (this.eContainer().eContainer() != null) {
				if (this.eContainer().eContainer() instanceof Project) {
					return ((Project) this.eContainer().eContainer()).getName();
				}
			}
		}
		/* sino comprobamos si tenemos el campo project guardado */
		if (project != null && !project.isEmpty()) {
			return project;
		}
		return null;
	}

	@Override
	public long getProjectId() {
		if (hasProjectId()) {
			return Long.parseLong(project);
		} else {
			return -1;
		}
	}

	public boolean hasProjectId() {

		/*
		 * Si esta guardado en el modelo ya está asignado a un proyecto por lo
		 * que podemos obtener los datos
		 */
		if (this.eContainer() != null) {
			if (this.eContainer().eContainer() != null) {
				if (this.eContainer().eContainer() instanceof Project) {
					return true;
				}
			}
		}

		/*
		 * Si el campo project tiene datos y comprobamos si es un numero, en
		 * caso contrario no es el id
		 */
		if (project != null && !project.isEmpty()) {

			try {
				Long.parseLong(project);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean hasProjectName() {

		/*
		 * Si esta guardado en el modelo ya está asignado a un proyecto por lo
		 * que podemos obtener los datos
		 */
		if (this.eContainer() != null) {
			if (this.eContainer().eContainer() != null) {
				if (this.eContainer().eContainer() instanceof Project) {
					return true;
				}
			}
		}

		if (project != null && !project.isEmpty()) {
			/*
			 * Si el campo project tiene datos y no son el id presuponemos que
			 * es el nombre
			 */
			if (hasProjectId()) {
				return false;
			}
			return true;
		}
		return false;
	}

	public String getUserToSearch() {
		return userToSearch;
	}

	public void setUserToSearch(String userToSearch) {
		this.userToSearch = userToSearch;
	}

	@Override
	public boolean hasUserToSearch() {
		if (this.getUserToSearch() != null && !this.getUserToSearch().isEmpty()
				&& !this.getUserToSearch().equals(" ")) {
			return true;
		}
		return false;
	}

	@Override
	public UserInteraction getACopy() {
		Msg ret = ProjectHistoryFactory.eINSTANCE.createMsg();
		ret.setDate(this.getDate());
		ret.setId(this.getId());
		ret.setMsg(this.getMsg());
		ret.setProject(this.getProject());
		ret.setSentences(this.getSentencesMap());
		ret.setText(this.getText());
		ret.setUndoable(this.isUndoable());
		ret.setUser(this.getUser());
		ret.setUserToSearch(this.getUserToSearch());
		return ret;
	}


} // MsgImpl
