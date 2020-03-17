/**
 */
package generator.impl;

import generator.GeneratorPackage;
import generator.HTTPRequest;
import generator.HTTPResponse;
import generator.TextInput;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HTTP Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.HTTPResponseImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link generator.impl.HTTPResponseImpl#getHTTPRequest <em>HTTP Request</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HTTPResponseImpl extends ActionImpl implements HTTPResponse {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected TextInput inputs;

	/**
	 * The cached value of the '{@link #getHTTPRequest() <em>HTTP Request</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHTTPRequest()
	 * @generated
	 * @ordered
	 */
	protected HTTPRequest httpRequest;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HTTPResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.HTTP_RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TextInput getInputs() {
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputs(TextInput newInputs, NotificationChain msgs) {
		TextInput oldInputs = inputs;
		inputs = newInputs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_RESPONSE__INPUTS, oldInputs, newInputs);
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
	public void setInputs(TextInput newInputs) {
		if (newInputs != inputs) {
			NotificationChain msgs = null;
			if (inputs != null)
				msgs = ((InternalEObject)inputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.HTTP_RESPONSE__INPUTS, null, msgs);
			if (newInputs != null)
				msgs = ((InternalEObject)newInputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.HTTP_RESPONSE__INPUTS, null, msgs);
			msgs = basicSetInputs(newInputs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_RESPONSE__INPUTS, newInputs, newInputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HTTPRequest getHTTPRequest() {
		if (httpRequest != null && httpRequest.eIsProxy()) {
			InternalEObject oldHTTPRequest = (InternalEObject)httpRequest;
			httpRequest = (HTTPRequest)eResolveProxy(oldHTTPRequest);
			if (httpRequest != oldHTTPRequest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST, oldHTTPRequest, httpRequest));
			}
		}
		return httpRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPRequest basicGetHTTPRequest() {
		return httpRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHTTPRequest(HTTPRequest newHTTPRequest) {
		HTTPRequest oldHTTPRequest = httpRequest;
		httpRequest = newHTTPRequest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST, oldHTTPRequest, httpRequest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				return basicSetInputs(null, msgs);
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
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				return getInputs();
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				if (resolve) return getHTTPRequest();
				return basicGetHTTPRequest();
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
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				setInputs((TextInput)newValue);
				return;
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				setHTTPRequest((HTTPRequest)newValue);
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
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				setInputs((TextInput)null);
				return;
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				setHTTPRequest((HTTPRequest)null);
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
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				return inputs != null;
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				return httpRequest != null;
		}
		return super.eIsSet(featureID);
	}

} //HTTPResponseImpl
