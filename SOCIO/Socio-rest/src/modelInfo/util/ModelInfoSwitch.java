/**
 */
package modelInfo.util;

import modelInfo.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see modelInfo.ModelInfoPackage
 * @generated
 */
public class ModelInfoSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelInfoPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelInfoSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelInfoPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelInfoPackage.NL_MODEL: {
				NLModel nlModel = (NLModel)theEObject;
				T result = caseNLModel(nlModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.NL_ELEMENT: {
				NLElement nlElement = (NLElement)theEObject;
				T result = caseNLElement(nlElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.NL_CLASS: {
				NLClass nlClass = (NLClass)theEObject;
				T result = caseNLClass(nlClass);
				if (result == null) result = caseNLElement(nlClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.NL_FEATURE: {
				NLFeature nlFeature = (NLFeature)theEObject;
				T result = caseNLFeature(nlFeature);
				if (result == null) result = caseNLElement(nlFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.NL_ATTRIBUTE: {
				NLAttribute nlAttribute = (NLAttribute)theEObject;
				T result = caseNLAttribute(nlAttribute);
				if (result == null) result = caseNLFeature(nlAttribute);
				if (result == null) result = caseNLElement(nlAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.NL_REFERENCE: {
				NLReference nlReference = (NLReference)theEObject;
				T result = caseNLReference(nlReference);
				if (result == null) result = caseNLFeature(nlReference);
				if (result == null) result = caseNLElement(nlReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.UPDATE_INTERFACE: {
				UpdateInterface updateInterface = (UpdateInterface)theEObject;
				T result = caseUpdateInterface(updateInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.WEB_SERVICE: {
				WebService webService = (WebService)theEObject;
				T result = caseWebService(webService);
				if (result == null) result = caseUpdateInterface(webService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.MOMENT: {
				Moment moment = (Moment)theEObject;
				T result = caseMoment(moment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.START: {
				Start start = (Start)theEObject;
				T result = caseStart(start);
				if (result == null) result = caseMoment(start);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelInfoPackage.FREQUENCY: {
				Frequency frequency = (Frequency)theEObject;
				T result = caseFrequency(frequency);
				if (result == null) result = caseMoment(frequency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NL Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NL Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNLModel(NLModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NL Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NL Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNLElement(NLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NL Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NL Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNLClass(NLClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NL Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NL Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNLFeature(NLFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NL Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NL Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNLAttribute(NLAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NL Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NL Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNLReference(NLReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateInterface(UpdateInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWebService(WebService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Moment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Moment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoment(Moment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStart(Start object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frequency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frequency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFrequency(Frequency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelInfoSwitch
