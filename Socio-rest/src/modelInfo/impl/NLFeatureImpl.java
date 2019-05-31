/**
 */
package modelInfo.impl;

import modelInfo.ModelInfoPackage;
import modelInfo.NLFeature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NL Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.impl.NLFeatureImpl#getAsk <em>Ask</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NLFeatureImpl extends NLElementImpl implements NLFeature {
	/**
	 * The default value of the '{@link #getAsk() <em>Ask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsk()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Boolean ASK_EDEFAULT = null; // TODO The default value literal "null" is not valid.

	/**
	 * The cached value of the '{@link #getAsk() <em>Ask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsk()
	 * @generated
	 * @ordered
	 */
	protected Boolean ask = ASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NLFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAsk() {
		return ask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsk(Boolean newAsk) {
		Boolean oldAsk = ask;
		ask = newAsk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_FEATURE__ASK, oldAsk, ask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelInfoPackage.NL_FEATURE__ASK:
				return getAsk();
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
			case ModelInfoPackage.NL_FEATURE__ASK:
				setAsk((Boolean)newValue);
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
			case ModelInfoPackage.NL_FEATURE__ASK:
				setAsk(ASK_EDEFAULT);
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
			case ModelInfoPackage.NL_FEATURE__ASK:
				return ASK_EDEFAULT == null ? ask != null : !ASK_EDEFAULT.equals(ask);
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
		result.append(" (ask: ");
		result.append(ask);
		result.append(')');
		return result.toString();
	}

} //NLFeatureImpl
