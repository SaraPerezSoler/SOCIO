/**
 */
package modelInfo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see modelInfo.ModelInfoPackage
 * @generated
 */
public interface ModelInfoFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelInfoFactory eINSTANCE = modelInfo.impl.ModelInfoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>NL Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NL Model</em>'.
	 * @generated
	 */
	NLModel createNLModel();

	/**
	 * Returns a new object of class '<em>NL Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NL Class</em>'.
	 * @generated
	 */
	NLClass createNLClass();

	/**
	 * Returns a new object of class '<em>Default Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Id</em>'.
	 * @generated
	 */
	DefaultId createDefaultId();

	/**
	 * Returns a new object of class '<em>NL Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NL Attribute</em>'.
	 * @generated
	 */
	NLAttribute createNLAttribute();

	/**
	 * Returns a new object of class '<em>NL Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NL Reference</em>'.
	 * @generated
	 */
	NLReference createNLReference();

	/**
	 * Returns a new object of class '<em>Web Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Web Service</em>'.
	 * @generated
	 */
	WebService createWebService();

	/**
	 * Returns a new object of class '<em>Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start</em>'.
	 * @generated
	 */
	Start createStart();

	/**
	 * Returns a new object of class '<em>Frequency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Frequency</em>'.
	 * @generated
	 */
	Frequency createFrequency();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelInfoPackage getModelInfoPackage();

} //ModelInfoFactory
