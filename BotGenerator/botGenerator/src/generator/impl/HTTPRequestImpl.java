/**
 */
package generator.impl;

import generator.DataType;
import generator.GeneratorPackage;
import generator.HTTPRequest;
import generator.KeyValue;
import generator.Method;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HTTP Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.HTTPRequestImpl#getURL <em>URL</em>}</li>
 *   <li>{@link generator.impl.HTTPRequestImpl#getBasicAuth <em>Basic Auth</em>}</li>
 *   <li>{@link generator.impl.HTTPRequestImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link generator.impl.HTTPRequestImpl#getData <em>Data</em>}</li>
 *   <li>{@link generator.impl.HTTPRequestImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link generator.impl.HTTPRequestImpl#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HTTPRequestImpl extends ActionImpl implements HTTPRequest {
	/**
	 * The default value of the '{@link #getURL() <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURL()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURL() <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURL()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBasicAuth() <em>Basic Auth</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicAuth()
	 * @generated
	 * @ordered
	 */
	protected KeyValue basicAuth;

	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> headers;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> data;

	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final DataType DATA_TYPE_EDEFAULT = DataType.JSON;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType = DATA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final Method METHOD_EDEFAULT = Method.GET;

	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected Method method = METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HTTPRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.HTTP_REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getURL() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setURL(String newURL) {
		String oldURL = url;
		url = newURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST__URL, oldURL, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyValue getBasicAuth() {
		return basicAuth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasicAuth(KeyValue newBasicAuth, NotificationChain msgs) {
		KeyValue oldBasicAuth = basicAuth;
		basicAuth = newBasicAuth;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST__BASIC_AUTH, oldBasicAuth, newBasicAuth);
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
	public void setBasicAuth(KeyValue newBasicAuth) {
		if (newBasicAuth != basicAuth) {
			NotificationChain msgs = null;
			if (basicAuth != null)
				msgs = ((InternalEObject)basicAuth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.HTTP_REQUEST__BASIC_AUTH, null, msgs);
			if (newBasicAuth != null)
				msgs = ((InternalEObject)newBasicAuth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.HTTP_REQUEST__BASIC_AUTH, null, msgs);
			msgs = basicSetBasicAuth(newBasicAuth, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST__BASIC_AUTH, newBasicAuth, newBasicAuth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<KeyValue> getHeaders() {
		if (headers == null) {
			headers = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, GeneratorPackage.HTTP_REQUEST__HEADERS);
		}
		return headers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<KeyValue> getData() {
		if (data == null) {
			data = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, GeneratorPackage.HTTP_REQUEST__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataType(DataType newDataType) {
		DataType oldDataType = dataType;
		dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method getMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMethod(Method newMethod) {
		Method oldMethod = method;
		method = newMethod == null ? METHOD_EDEFAULT : newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_REQUEST__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.HTTP_REQUEST__BASIC_AUTH:
				return basicSetBasicAuth(null, msgs);
			case GeneratorPackage.HTTP_REQUEST__HEADERS:
				return ((InternalEList<?>)getHeaders()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.HTTP_REQUEST__DATA:
				return ((InternalEList<?>)getData()).basicRemove(otherEnd, msgs);
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
			case GeneratorPackage.HTTP_REQUEST__URL:
				return getURL();
			case GeneratorPackage.HTTP_REQUEST__BASIC_AUTH:
				return getBasicAuth();
			case GeneratorPackage.HTTP_REQUEST__HEADERS:
				return getHeaders();
			case GeneratorPackage.HTTP_REQUEST__DATA:
				return getData();
			case GeneratorPackage.HTTP_REQUEST__DATA_TYPE:
				return getDataType();
			case GeneratorPackage.HTTP_REQUEST__METHOD:
				return getMethod();
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
			case GeneratorPackage.HTTP_REQUEST__URL:
				setURL((String)newValue);
				return;
			case GeneratorPackage.HTTP_REQUEST__BASIC_AUTH:
				setBasicAuth((KeyValue)newValue);
				return;
			case GeneratorPackage.HTTP_REQUEST__HEADERS:
				getHeaders().clear();
				getHeaders().addAll((Collection<? extends KeyValue>)newValue);
				return;
			case GeneratorPackage.HTTP_REQUEST__DATA:
				getData().clear();
				getData().addAll((Collection<? extends KeyValue>)newValue);
				return;
			case GeneratorPackage.HTTP_REQUEST__DATA_TYPE:
				setDataType((DataType)newValue);
				return;
			case GeneratorPackage.HTTP_REQUEST__METHOD:
				setMethod((Method)newValue);
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
			case GeneratorPackage.HTTP_REQUEST__URL:
				setURL(URL_EDEFAULT);
				return;
			case GeneratorPackage.HTTP_REQUEST__BASIC_AUTH:
				setBasicAuth((KeyValue)null);
				return;
			case GeneratorPackage.HTTP_REQUEST__HEADERS:
				getHeaders().clear();
				return;
			case GeneratorPackage.HTTP_REQUEST__DATA:
				getData().clear();
				return;
			case GeneratorPackage.HTTP_REQUEST__DATA_TYPE:
				setDataType(DATA_TYPE_EDEFAULT);
				return;
			case GeneratorPackage.HTTP_REQUEST__METHOD:
				setMethod(METHOD_EDEFAULT);
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
			case GeneratorPackage.HTTP_REQUEST__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case GeneratorPackage.HTTP_REQUEST__BASIC_AUTH:
				return basicAuth != null;
			case GeneratorPackage.HTTP_REQUEST__HEADERS:
				return headers != null && !headers.isEmpty();
			case GeneratorPackage.HTTP_REQUEST__DATA:
				return data != null && !data.isEmpty();
			case GeneratorPackage.HTTP_REQUEST__DATA_TYPE:
				return dataType != DATA_TYPE_EDEFAULT;
			case GeneratorPackage.HTTP_REQUEST__METHOD:
				return method != METHOD_EDEFAULT;
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
		result.append(" (URL: ");
		result.append(url);
		result.append(", dataType: ");
		result.append(dataType);
		result.append(", method: ");
		result.append(method);
		result.append(')');
		return result.toString();
	}

} //HTTPRequestImpl
