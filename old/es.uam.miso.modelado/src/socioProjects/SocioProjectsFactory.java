/**
 */
package socioProjects;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see socioProjects.SocioProjectsPackage
 * @generated
 */
public interface SocioProjectsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SocioProjectsFactory eINSTANCE = socioProjects.impl.SocioProjectsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Socio App</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Socio App</em>'.
	 * @generated
	 */
	SocioApp createSocioApp();

	/**
	 * Returns a new object of class '<em>Model Projec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Projec</em>'.
	 * @generated
	 */
	ModelProjec createModelProjec();

	/**
	 * Returns a new object of class '<em>Metamodel Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel Project</em>'.
	 * @generated NOT
	 */
	MetamodelProject createMetamodelProject();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contribution</em>'.
	 * @generated
	 */
	Contribution createContribution();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SocioProjectsPackage getSocioProjectsPackage();
	

} //SocioProjectsFactory
