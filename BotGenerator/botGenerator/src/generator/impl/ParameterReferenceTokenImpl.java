/**
 */
package generator.impl;

import generator.GeneratorPackage;
import generator.Parameter;
import generator.ParameterReferenceToken;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Reference Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.ParameterReferenceTokenImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link generator.impl.ParameterReferenceTokenImpl#getTextReference <em>Text Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterReferenceTokenImpl extends TokenImpl implements ParameterReferenceToken {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter;

	/**
	 * The default value of the '{@link #getTextReference() <em>Text Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextReference()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextReference() <em>Text Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextReference()
	 * @generated
	 * @ordered
	 */
	protected String textReference = TEXT_REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterReferenceTokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.PARAMETER_REFERENCE_TOKEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (Parameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.PARAMETER_REFERENCE_TOKEN__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameter(Parameter newParameter) {
		Parameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.PARAMETER_REFERENCE_TOKEN__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextReference() {
		return textReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextReference(String newTextReference) {
		String oldTextReference = textReference;
		textReference = newTextReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE, oldTextReference, textReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE:
				return getTextReference();
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
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE:
				setTextReference((String)newValue);
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
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__PARAMETER:
				setParameter((Parameter)null);
				return;
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE:
				setTextReference(TEXT_REFERENCE_EDEFAULT);
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
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__PARAMETER:
				return parameter != null;
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE:
				return TEXT_REFERENCE_EDEFAULT == null ? textReference != null : !TEXT_REFERENCE_EDEFAULT.equals(textReference);
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
		result.append(" (textReference: ");
		result.append(textReference);
		result.append(')');
		return result.toString();
	}

} //ParameterReferenceTokenImpl
