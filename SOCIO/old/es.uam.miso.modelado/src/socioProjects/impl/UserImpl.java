/**
 */
package socioProjects.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import socioProjects.Access;
import socioProjects.Contribution;
import socioProjects.Project;
import socioProjects.SocioProjectsPackage;
import socioProjects.User;
import socioProjects.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link socioProjects.impl.UserImpl#getNick <em>Nick</em>}</li>
 *   <li>{@link socioProjects.impl.UserImpl#getId <em>Id</em>}</li>
 *   <li>{@link socioProjects.impl.UserImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link socioProjects.impl.UserImpl#getOwnProjects <em>Own Projects</em>}</li>
 *   <li>{@link socioProjects.impl.UserImpl#getContributions <em>Contributions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserImpl extends MinimalEObjectImpl.Container implements User {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNick() <em>Nick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNick()
	 * @generated
	 * @ordered
	 */
	protected static final String NICK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNick() <em>Nick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNick()
	 * @generated
	 * @ordered
	 */
	protected String nick = NICK_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannel() <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANNEL_EDEFAULT = null;
	
	private static class userInfo{
		long id;
		String channel;
		
		public userInfo(long id, String channel) {
			super();
			this.id = id;
			this.channel = channel;
		}

		public long getId() {
			return id;
		}

		public String getChannel() {
			return channel;
		}
		
	}
	
	protected static final userInfo[] ROOT_ID ={new userInfo(14419070, "Telegram"), new userInfo(0, "Consola")};
	
	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected String channel = CHANNEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnProjects() <em>Own Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> ownProjects;

	/**
	 * The cached value of the '{@link #getContributions() <em>Contributions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributions()
	 * @generated
	 * @ordered
	 */
	protected EList<Contribution> contributions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.USER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNick(String newNick) {
		String oldNick = nick;
		nick = newNick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.USER__NICK, oldNick, nick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.USER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(String newChannel) {
		String oldChannel = channel;
		channel = newChannel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.USER__CHANNEL, oldChannel, channel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getOwnProjects() {
		if (ownProjects == null) {
			ownProjects = new EObjectWithInverseResolvingEList<Project>(Project.class, this, SocioProjectsPackage.USER__OWN_PROJECTS, SocioProjectsPackage.PROJECT__ADMIN);
		}
		return ownProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributions() {
		if (contributions == null) {
			contributions = new EObjectContainmentEList<Contribution>(Contribution.class, this, SocioProjectsPackage.USER__CONTRIBUTIONS);
		}
		return contributions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canEdit(Project project) {
		if (project.getVisibility()==Visibility.PUBLIC){
			return true;
		}
		if (isAdmin(project)){
			return true;
		}
		Contribution c=getContribution(project);
		if (c!=null){
			if (c.getAccess()==Access.EDIT){
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canRead(Project project) {
		if (project.getVisibility()==Visibility.PROTECTED || project.getVisibility()==Visibility.PUBLIC){
			return true;
		}
		if (isAdmin(project)){
			return true;
		}
		Contribution c=getContribution(project);
		if (c!=null){
			if (c.getAccess()==Access.READ || c.getAccess()==Access.EDIT){
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isAdmin(Project project) {
		if (getOwnProjects().contains(project)){
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeContribution(Project project) {
		Contribution remove=getContribution(project);
		getContributions().remove(remove);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addContribution(Project project, Access access) {
		Contribution aux=getContribution(project);
		if (aux!=null){
			aux.setAccess(access);
		}else{
			Contribution c= SocioProjectsFactoryImpl.eINSTANCE.createContribution();
			c.setAccess(access);
			c.setProject(project);
			getContributions().add(c);
				
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addProject(Project project) {
		if (!ownProjects.contains(project)){
			ownProjects.add(project);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Contribution getContribution(Project project) {
		for (Contribution c: getContributions()){
			if (c.getProject().equals(project)){
				return c;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isRoot() {
		for (userInfo id: ROOT_ID){
			if (getId()==id.getId() && getChannel().equals(id.getChannel())){
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SocioProjectsPackage.USER__OWN_PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnProjects()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SocioProjectsPackage.USER__OWN_PROJECTS:
				return ((InternalEList<?>)getOwnProjects()).basicRemove(otherEnd, msgs);
			case SocioProjectsPackage.USER__CONTRIBUTIONS:
				return ((InternalEList<?>)getContributions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SocioProjectsPackage.USER__NAME:
				return getName();
			case SocioProjectsPackage.USER__NICK:
				return getNick();
			case SocioProjectsPackage.USER__ID:
				return getId();
			case SocioProjectsPackage.USER__CHANNEL:
				return getChannel();
			case SocioProjectsPackage.USER__OWN_PROJECTS:
				return getOwnProjects();
			case SocioProjectsPackage.USER__CONTRIBUTIONS:
				return getContributions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SocioProjectsPackage.USER__NAME:
				setName((String)newValue);
				return;
			case SocioProjectsPackage.USER__NICK:
				setNick((String)newValue);
				return;
			case SocioProjectsPackage.USER__ID:
				setId((Long)newValue);
				return;
			case SocioProjectsPackage.USER__CHANNEL:
				setChannel((String)newValue);
				return;
			case SocioProjectsPackage.USER__OWN_PROJECTS:
				getOwnProjects().clear();
				getOwnProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case SocioProjectsPackage.USER__CONTRIBUTIONS:
				getContributions().clear();
				getContributions().addAll((Collection<? extends Contribution>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SocioProjectsPackage.USER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SocioProjectsPackage.USER__NICK:
				setNick(NICK_EDEFAULT);
				return;
			case SocioProjectsPackage.USER__ID:
				setId(ID_EDEFAULT);
				return;
			case SocioProjectsPackage.USER__CHANNEL:
				setChannel(CHANNEL_EDEFAULT);
				return;
			case SocioProjectsPackage.USER__OWN_PROJECTS:
				getOwnProjects().clear();
				return;
			case SocioProjectsPackage.USER__CONTRIBUTIONS:
				getContributions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SocioProjectsPackage.USER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SocioProjectsPackage.USER__NICK:
				return NICK_EDEFAULT == null ? nick != null : !NICK_EDEFAULT.equals(nick);
			case SocioProjectsPackage.USER__ID:
				return id != ID_EDEFAULT;
			case SocioProjectsPackage.USER__CHANNEL:
				return CHANNEL_EDEFAULT == null ? channel != null : !CHANNEL_EDEFAULT.equals(channel);
			case SocioProjectsPackage.USER__OWN_PROJECTS:
				return ownProjects != null && !ownProjects.isEmpty();
			case SocioProjectsPackage.USER__CONTRIBUTIONS:
				return contributions != null && !contributions.isEmpty();
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
			case SocioProjectsPackage.USER___CAN_EDIT__PROJECT:
				return canEdit((Project)arguments.get(0));
			case SocioProjectsPackage.USER___CAN_READ__PROJECT:
				return canRead((Project)arguments.get(0));
			case SocioProjectsPackage.USER___IS_ADMIN__PROJECT:
				return isAdmin((Project)arguments.get(0));
			case SocioProjectsPackage.USER___REMOVE_CONTRIBUTION__PROJECT:
				removeContribution((Project)arguments.get(0));
				return null;
			case SocioProjectsPackage.USER___ADD_CONTRIBUTION__PROJECT_ACCESS:
				addContribution((Project)arguments.get(0), (Access)arguments.get(1));
				return null;
			case SocioProjectsPackage.USER___ADD_PROJECT__PROJECT:
				addProject((Project)arguments.get(0));
				return null;
			case SocioProjectsPackage.USER___GET_CONTRIBUTION__PROJECT:
				return getContribution((Project)arguments.get(0));
			case SocioProjectsPackage.USER___IS_ROOT:
				return isRoot();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", nick: ");
		result.append(nick);
		result.append(", id: ");
		result.append(id);
		result.append(", channel: ");
		result.append(channel);
		result.append(')');
		return result.toString();
	}

	@Override
	public String userInfo() {
		return this.channel+"/"+this.nick+"\n\t"+this.name+", "+this.id;
	}

} //UserImpl
