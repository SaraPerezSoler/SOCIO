/**
 */
package socioProjects.impl;

import branchDecision.Decision;
import es.uam.app.main.SocioData;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import socioProjects.BranchGroup;
import socioProjects.GroupStatus;
import socioProjects.Project;
import socioProjects.SocioProjectsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.impl.BranchGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link socioProjects.impl.BranchGroupImpl#getCreateAt <em>Create At</em>}</li>
 *   <li>{@link socioProjects.impl.BranchGroupImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link socioProjects.impl.BranchGroupImpl#getFather <em>Father</em>}</li>
 *   <li>{@link socioProjects.impl.BranchGroupImpl#getDecision <em>Decision</em>}</li>
 *   <li>{@link socioProjects.impl.BranchGroupImpl#getBranchs <em>Branchs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BranchGroupImpl extends MinimalEObjectImpl.Container implements BranchGroup {
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
	 * The default value of the '{@link #getCreateAt() <em>Create At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateAt()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATE_AT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateAt() <em>Create At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateAt()
	 * @generated
	 * @ordered
	 */
	protected Date createAt = CREATE_AT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final GroupStatus STATUS_EDEFAULT = GroupStatus.OPEN;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected GroupStatus status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDecision() <em>Decision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecision()
	 * @generated
	 * @ordered
	 */
	protected Decision decision;

	/**
	 * The cached value of the '{@link #getBranchs() <em>Branchs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchs()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> branchs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.BRANCH_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.BRANCH_GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreateAt(Date newCreateAt) {
		Date oldCreateAt = createAt;
		createAt = newCreateAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.BRANCH_GROUP__CREATE_AT, oldCreateAt, createAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setStatus(GroupStatus newStatus) {
		GroupStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.BRANCH_GROUP__STATUS, oldStatus, status));
		if (status == GroupStatus.CLOSE) {
			for (Project p: getBranchs()) {
				p.setOpen(false);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getFather() {
		if (eContainerFeatureID() != SocioProjectsPackage.BRANCH_GROUP__FATHER) return null;
		return (Project)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFather(Project newFather, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFather, SocioProjectsPackage.BRANCH_GROUP__FATHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFather(Project newFather) {
		if (newFather != eInternalContainer() || (eContainerFeatureID() != SocioProjectsPackage.BRANCH_GROUP__FATHER && newFather != null)) {
			if (EcoreUtil.isAncestor(this, newFather))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFather != null)
				msgs = ((InternalEObject)newFather).eInverseAdd(this, SocioProjectsPackage.PROJECT__BRANCHS, Project.class, msgs);
			msgs = basicSetFather(newFather, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.BRANCH_GROUP__FATHER, newFather, newFather));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Decision getDecision() {
		return decision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDecision(Decision newDecision, NotificationChain msgs) {
		Decision oldDecision = decision;
		decision = newDecision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.BRANCH_GROUP__DECISION, oldDecision, newDecision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDecision(Decision newDecision) {
		if (newDecision != decision) {
			NotificationChain msgs = null;
			if (decision != null)
				msgs = ((InternalEObject)decision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SocioProjectsPackage.BRANCH_GROUP__DECISION, null, msgs);
			if (newDecision != null)
				msgs = ((InternalEObject)newDecision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SocioProjectsPackage.BRANCH_GROUP__DECISION, null, msgs);
			msgs = basicSetDecision(newDecision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocioProjectsPackage.BRANCH_GROUP__DECISION, newDecision, newDecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Project> getBranchs() {
		if (branchs == null) {
			branchs = new EObjectWithInverseResolvingEList<Project>(Project.class, this, SocioProjectsPackage.BRANCH_GROUP__BRANCHS, SocioProjectsPackage.PROJECT__BRANCH_GROUP);
		}
		return branchs;
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
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFather((Project)otherEnd, msgs);
			case SocioProjectsPackage.BRANCH_GROUP__BRANCHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBranchs()).basicAdd(otherEnd, msgs);
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
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				return basicSetFather(null, msgs);
			case SocioProjectsPackage.BRANCH_GROUP__DECISION:
				return basicSetDecision(null, msgs);
			case SocioProjectsPackage.BRANCH_GROUP__BRANCHS:
				return ((InternalEList<?>)getBranchs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				return eInternalContainer().eInverseRemove(this, SocioProjectsPackage.PROJECT__BRANCHS, Project.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SocioProjectsPackage.BRANCH_GROUP__NAME:
				return getName();
			case SocioProjectsPackage.BRANCH_GROUP__CREATE_AT:
				return getCreateAt();
			case SocioProjectsPackage.BRANCH_GROUP__STATUS:
				return getStatus();
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				return getFather();
			case SocioProjectsPackage.BRANCH_GROUP__DECISION:
				return getDecision();
			case SocioProjectsPackage.BRANCH_GROUP__BRANCHS:
				return getBranchs();
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
			case SocioProjectsPackage.BRANCH_GROUP__NAME:
				setName((String)newValue);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__CREATE_AT:
				setCreateAt((Date)newValue);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__STATUS:
				setStatus((GroupStatus)newValue);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				setFather((Project)newValue);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__DECISION:
				setDecision((Decision)newValue);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__BRANCHS:
				getBranchs().clear();
				getBranchs().addAll((Collection<? extends Project>)newValue);
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
			case SocioProjectsPackage.BRANCH_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__CREATE_AT:
				setCreateAt(CREATE_AT_EDEFAULT);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				setFather((Project)null);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__DECISION:
				setDecision((Decision)null);
				return;
			case SocioProjectsPackage.BRANCH_GROUP__BRANCHS:
				getBranchs().clear();
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
			case SocioProjectsPackage.BRANCH_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SocioProjectsPackage.BRANCH_GROUP__CREATE_AT:
				return CREATE_AT_EDEFAULT == null ? createAt != null : !CREATE_AT_EDEFAULT.equals(createAt);
			case SocioProjectsPackage.BRANCH_GROUP__STATUS:
				return status != STATUS_EDEFAULT;
			case SocioProjectsPackage.BRANCH_GROUP__FATHER:
				return getFather() != null;
			case SocioProjectsPackage.BRANCH_GROUP__DECISION:
				return decision != null;
			case SocioProjectsPackage.BRANCH_GROUP__BRANCHS:
				return branchs != null && !branchs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", createAt: ");
		result.append(createAt);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

	@Override
	public void addProject(Project p) {
		if (!getBranchs().contains(p)) {
			p.setBranchGroup(this);
			getBranchs().add(p);
		}
	}

	/*Saca el proyecto del branchGroup*/
	@Override
	public void pullProject(Project project) {
		if (getBranchs().contains(project)) {
			project.setBranchGroup(null);
			getBranchs().remove(project);
		}
		
	}

	@Override
	public void remove(SocioData socioData) {
		for (Project p: getBranchs()) {
			p.removeFiles();
			p.removeFromLists(socioData);
		}
	}

	@Override
	public Project getBranch(String name) {
		for (Project p: getBranchs()) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}

} //BranchGroupImpl
