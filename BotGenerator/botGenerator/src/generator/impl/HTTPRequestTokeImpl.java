/**
 */
package generator.impl;

import generator.GeneratorPackage;
import generator.HTTPRequestToke;
import generator.HTTPReturnType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HTTP Request Toke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.HTTPRequestTokeImpl#getType <em>Type</em>}</li>
 *   <li>{@link generator.impl.HTTPRequestTokeImpl#getDataKey <em>Data Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HTTPRequestTokeImpl extends TokenImpl implements HTTPRequestToke {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final HTTPReturnType TYPE_EDEFAULT = HTTPReturnType.TEXT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected HTTPReturnType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataKey() <em>Data Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataKey()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataKey() <em>Data Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataKey()
	 * @generated
	 * @ordered
	 */
	protected String dataKey = DATA_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HTTPRequestTokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.HTTP_REQUEST_TOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HTTPReturnType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(HTTPReturnType newType) {
		HTTPReturnType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST_TOKE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDataKey() {
		return dataKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataKey(String newDataKey) {
		String oldDataKey = dataKey;
		dataKey = newDataKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST_TOKE__DATA_KEY, oldDataKey, dataKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.HTTP_REQUEST_TOKE__TYPE:
				return getType();
			case GeneratorPackage.HTTP_REQUEST_TOKE__DATA_KEY:
				return getDataKey();
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
			case GeneratorPackage.HTTP_REQUEST_TOKE__TYPE:
				setType((HTTPReturnType)newValue);
				return;
			case GeneratorPackage.HTTP_REQUEST_TOKE__DATA_KEY:
				setDataKey((String)newValue);
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
			case GeneratorPackage.HTTP_REQUEST_TOKE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GeneratorPackage.HTTP_REQUEST_TOKE__DATA_KEY:
				setDataKey(DATA_KEY_EDEFAULT);
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
			case GeneratorPackage.HTTP_REQUEST_TOKE__TYPE:
				return type != TYPE_EDEFAULT;
			case GeneratorPackage.HTTP_REQUEST_TOKE__DATA_KEY:
				return DATA_KEY_EDEFAULT == null ? dataKey != null : !DATA_KEY_EDEFAULT.equals(dataKey);
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
		result.append(", dataKey: ");
		result.append(dataKey);
		result.append(')');
		return result.toString();
	}

} //HTTPRequestTokeImpl
