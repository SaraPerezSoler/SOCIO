/**
 */
package droidRecommenderHistory.impl;

import droidRecommenderHistory.DroidRecommenderHistoryFactory;
import droidRecommenderHistory.DroidRecommenderHistoryPackage;
import droidRecommenderHistory.RecommendationResult;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recommendation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationResultImpl#getType <em>Type</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationResultImpl#getValues <em>Values</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationResultImpl#getRaitin <em>Raitin</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecommendationResultImpl extends MinimalEObjectImpl.Container implements RecommendationResult {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> values;

	/**
	 * The default value of the '{@link #getRaitin() <em>Raitin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaitin()
	 * @generated
	 * @ordered
	 */
	protected static final double RAITIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRaitin() <em>Raitin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaitin()
	 * @generated
	 * @ordered
	 */
	protected double raitin = RAITIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommendationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DroidRecommenderHistoryPackage.Literals.RECOMMENDATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Object> getValues() {
		if (values == null) {
			values = new EcoreEMap<String,Object>(DroidRecommenderHistoryPackage.Literals.STRING_TO_OBJECT, StringToObjectImpl.class, this, DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRaitin() {
		return raitin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRaitin(double newRaitin) {
		double oldRaitin = raitin;
		raitin = newRaitin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__RAITIN, oldRaitin, raitin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__TYPE:
				return getType();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__VALUES:
				if (coreType) return getValues();
				else return getValues().map();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__RAITIN:
				return getRaitin();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__TYPE:
				setType((String)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__VALUES:
				((EStructuralFeature.Setting)getValues()).set(newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__RAITIN:
				setRaitin((Double)newValue);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__VALUES:
				getValues().clear();
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__RAITIN:
				setRaitin(RAITIN_EDEFAULT);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__VALUES:
				return values != null && !values.isEmpty();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT__RAITIN:
				return raitin != RAITIN_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", raitin: ");
		result.append(raitin);
		result.append(')');
		return result.toString();
	}

	@Override
	public RecommendationResult getACopy() {
		RecommendationResult result = DroidRecommenderHistoryFactory.eINSTANCE.createRecommendationResult();
		result.setRaitin(this.getRaitin());
		result.setType(this.getType());
		for (String key: this.values.keySet()) {
			result.getValues().put(key, this.values.get(key));
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(raitin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecommendationResultImpl other = (RecommendationResultImpl) obj;
		if (Double.doubleToLongBits(raitin) != Double.doubleToLongBits(other.raitin))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

} //RecommendationResultImpl
