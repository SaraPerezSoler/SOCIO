/**
 */
package branchDecision.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.Order;
import branchDecision.Preference;
import branchDecision.Round;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.impl.RoundImpl#getRoundId <em>Round Id</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getConsensusMeasure <em>Consensus Measure</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getUserPreferences <em>User Preferences</em>}</li>
 *   <li>{@link branchDecision.impl.RoundImpl#getConsensusOrder <em>Consensus Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoundImpl extends MinimalEObjectImpl.Container implements Round {
	/**
	 * The default value of the '{@link #getRoundId() <em>Round Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundId()
	 * @generated
	 * @ordered
	 */
	protected static final int ROUND_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRoundId() <em>Round Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundId()
	 * @generated
	 * @ordered
	 */
	protected int roundId = ROUND_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getConsensusMeasure() <em>Consensus Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final double CONSENSUS_MEASURE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getConsensusMeasure() <em>Consensus Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusMeasure()
	 * @generated
	 * @ordered
	 */
	protected double consensusMeasure = CONSENSUS_MEASURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUserPreferences() <em>User Preferences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserPreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Preference> userPreferences;

	/**
	 * The cached value of the '{@link #getConsensusOrder() <em>Consensus Order</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsensusOrder()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> consensusOrder;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BranchDecisionPackage.Literals.ROUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRoundId() {
		return roundId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundId(int newRoundId) {
		int oldRoundId = roundId;
		roundId = newRoundId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.ROUND__ROUND_ID, oldRoundId, roundId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConsensusMeasure() {
		return consensusMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsensusMeasure(double newConsensusMeasure) {
		double oldConsensusMeasure = consensusMeasure;
		consensusMeasure = newConsensusMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BranchDecisionPackage.ROUND__CONSENSUS_MEASURE, oldConsensusMeasure, consensusMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Preference> getUserPreferences() {
		if (userPreferences == null) {
			userPreferences = new EObjectResolvingEList<Preference>(Preference.class, this, BranchDecisionPackage.ROUND__USER_PREFERENCES);
		}
		return userPreferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Order> getConsensusOrder() {
		if (consensusOrder == null) {
			consensusOrder = new EObjectContainmentEList<Order>(Order.class, this, BranchDecisionPackage.ROUND__CONSENSUS_ORDER);
		}
		return consensusOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				return ((InternalEList<?>)getConsensusOrder()).basicRemove(otherEnd, msgs);
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
			case BranchDecisionPackage.ROUND__ROUND_ID:
				return getRoundId();
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				return getConsensusMeasure();
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				return getUserPreferences();
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				return getConsensusOrder();
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
			case BranchDecisionPackage.ROUND__ROUND_ID:
				setRoundId((Integer)newValue);
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				setConsensusMeasure((Double)newValue);
				return;
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				getUserPreferences().clear();
				getUserPreferences().addAll((Collection<? extends Preference>)newValue);
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				getConsensusOrder().clear();
				getConsensusOrder().addAll((Collection<? extends Order>)newValue);
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
			case BranchDecisionPackage.ROUND__ROUND_ID:
				setRoundId(ROUND_ID_EDEFAULT);
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				setConsensusMeasure(CONSENSUS_MEASURE_EDEFAULT);
				return;
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				getUserPreferences().clear();
				return;
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				getConsensusOrder().clear();
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
			case BranchDecisionPackage.ROUND__ROUND_ID:
				return roundId != ROUND_ID_EDEFAULT;
			case BranchDecisionPackage.ROUND__CONSENSUS_MEASURE:
				return consensusMeasure != CONSENSUS_MEASURE_EDEFAULT;
			case BranchDecisionPackage.ROUND__USER_PREFERENCES:
				return userPreferences != null && !userPreferences.isEmpty();
			case BranchDecisionPackage.ROUND__CONSENSUS_ORDER:
				return consensusOrder != null && !consensusOrder.isEmpty();
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
		result.append(" (roundId: ");
		result.append(roundId);
		result.append(", consensusMeasure: ");
		result.append(consensusMeasure);
		result.append(')');
		return result.toString();
	}

} //RoundImpl
