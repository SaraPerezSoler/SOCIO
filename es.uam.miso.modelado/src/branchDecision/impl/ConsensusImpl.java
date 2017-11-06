/**
 */
package branchDecision.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.Consensus;
import branchDecision.Round;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import socioProjects.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consensus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.impl.ConsensusImpl#getConsensusRequired <em>Consensus Required</em>}</li>
 *   <li>{@link branchDecision.impl.ConsensusImpl#getPreferencesRound <em>Preferences Round</em>}</li>
 *   <li>{@link branchDecision.impl.ConsensusImpl#getUsers <em>Users</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsensusImpl extends DecisionImpl implements Consensus {
	/**
	 * The default value of the '{@link #getConsensusRequired() <em>Consensus Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusRequired()
	 * @generated
	 * @ordered
	 */
	protected static final double CONSENSUS_REQUIRED_EDEFAULT = 0.75;

	/**
	 * The cached value of the '{@link #getConsensusRequired() <em>Consensus Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusRequired()
	 * @generated
	 * @ordered
	 */
	protected double consensusRequired = CONSENSUS_REQUIRED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreferencesRound() <em>Preferences Round</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferencesRound()
	 * @generated
	 * @ordered
	 */
	protected EList<Round> preferencesRound;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> users;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsensusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.CONSENSUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConsensusRequired() {
		return consensusRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsensusRequired(double newConsensusRequired) {
		double oldConsensusRequired = consensusRequired;
		consensusRequired = newConsensusRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED, oldConsensusRequired, consensusRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Round> getPreferencesRound() {
		if (preferencesRound == null) {
			preferencesRound = new EObjectContainmentEList<Round>(Round.class, this, BranchDecisionPackage.CONSENSUS__PREFERENCES_ROUND);
		}
		return preferencesRound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getUsers() {
		if (users == null) {
			users = new EObjectResolvingEList<User>(User.class, this, BranchDecisionPackage.CONSENSUS__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BranchDecisionPackage.CONSENSUS__PREFERENCES_ROUND:
				return ((InternalEList<?>)getPreferencesRound()).basicRemove(otherEnd, msgs);
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
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				return getConsensusRequired();
			case BranchDecisionPackage.CONSENSUS__PREFERENCES_ROUND:
				return getPreferencesRound();
			case BranchDecisionPackage.CONSENSUS__USERS:
				return getUsers();
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
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				setConsensusRequired((Double)newValue);
				return;
			case BranchDecisionPackage.CONSENSUS__PREFERENCES_ROUND:
				getPreferencesRound().clear();
				getPreferencesRound().addAll((Collection<? extends Round>)newValue);
				return;
			case BranchDecisionPackage.CONSENSUS__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends User>)newValue);
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
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				setConsensusRequired(CONSENSUS_REQUIRED_EDEFAULT);
				return;
			case BranchDecisionPackage.CONSENSUS__PREFERENCES_ROUND:
				getPreferencesRound().clear();
				return;
			case BranchDecisionPackage.CONSENSUS__USERS:
				getUsers().clear();
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
			case BranchDecisionPackage.CONSENSUS__CONSENSUS_REQUIRED:
				return consensusRequired != CONSENSUS_REQUIRED_EDEFAULT;
			case BranchDecisionPackage.CONSENSUS__PREFERENCES_ROUND:
				return preferencesRound != null && !preferencesRound.isEmpty();
			case BranchDecisionPackage.CONSENSUS__USERS:
				return users != null && !users.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (consensusRequired: ");
		result.append(consensusRequired);
		result.append(')');
		return result.toString();
	}

} //ConsensusImpl
