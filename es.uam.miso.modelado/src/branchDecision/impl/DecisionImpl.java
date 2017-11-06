/**
 */
package branchDecision.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.Decision;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import socioProjects.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Decision</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link branchDecision.impl.DecisionImpl#getName <em>Name</em>}</li>
 * <li>{@link branchDecision.impl.DecisionImpl#getBranchs <em>Branchs</em>}</li>
 * <li>{@link branchDecision.impl.DecisionImpl#getChosenBranch <em>Chosen
 * Branch</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DecisionImpl extends MinimalEObjectImpl.Container implements Decision {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBranchs() <em>Branchs</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBranchs()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> branchs;

	/**
	 * The cached value of the '{@link #getChosenBranch() <em>Chosen
	 * Branch</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChosenBranch()
	 * @generated
	 * @ordered
	 */
	protected Project chosenBranch;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.DECISION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Project> getBranchs() {
		if (branchs == null) {
			branchs = new EObjectContainmentEList<Project>(Project.class, this,
					BranchDecisionPackage.DECISION__BRANCHS);
		}
		return branchs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project getChosenBranch() {
		if (chosenBranch != null && chosenBranch.eIsProxy()) {
			InternalEObject oldChosenBranch = (InternalEObject) chosenBranch;
			chosenBranch = (Project) eResolveProxy(oldChosenBranch);
			if (chosenBranch != oldChosenBranch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BranchDecisionPackage.DECISION__CHOSEN_BRANCH, oldChosenBranch, chosenBranch));
			}
		}
		return chosenBranch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project basicGetChosenBranch() {
		return chosenBranch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setChosenBranch(Project newChosenBranch) {
		Project oldChosenBranch = chosenBranch;
		chosenBranch = newChosenBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.DECISION__CHOSEN_BRANCH,
					oldChosenBranch, chosenBranch));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BranchDecisionPackage.DECISION__BRANCHS:
			return ((InternalEList<?>) getBranchs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BranchDecisionPackage.DECISION__NAME:
			return getName();
		case BranchDecisionPackage.DECISION__BRANCHS:
			return getBranchs();
		case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
			if (resolve)
				return getChosenBranch();
			return basicGetChosenBranch();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BranchDecisionPackage.DECISION__NAME:
			setName((String) newValue);
			return;
		case BranchDecisionPackage.DECISION__BRANCHS:
			getBranchs().clear();
			getBranchs().addAll((Collection<? extends Project>) newValue);
			return;
		case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
			setChosenBranch((Project) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case BranchDecisionPackage.DECISION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case BranchDecisionPackage.DECISION__BRANCHS:
			getBranchs().clear();
			return;
		case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
			setChosenBranch((Project) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case BranchDecisionPackage.DECISION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case BranchDecisionPackage.DECISION__BRANCHS:
			return branchs != null && !branchs.isEmpty();
		case BranchDecisionPackage.DECISION__CHOSEN_BRANCH:
			return chosenBranch != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	public Project getBranch(String branchName) {
		for (Project b : branchs) {
			if (b.getName().equalsIgnoreCase(branchName)) {
				return b;
			}
			if (b.getCompleteName().equalsIgnoreCase(branchName)) {
				return b;
			}
		}
		return null;
	}

	public String decisionInformation() {
		String cad = "Branch group: " + getName();
		cad += "\n\t+ Selected: " + getChosenBranch().getCompleteName();
		cad += "\n\t All branchs:";
		for (Project p : getBranchs()) {
			cad += "\n\t\t+" + p.getCompleteName();
		}
		return cad;
	}

} // DecisionImpl
