/**
 */
package socioProjects;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Socio App</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.SocioApp#getProjects <em>Projects</em>}</li>
 *   <li>{@link socioProjects.SocioApp#getUsers <em>Users</em>}</li>
 * </ul>
 *
 * @see socioProjects.SocioProjectsPackage#getSocioApp()
 * @model
 * @generated
 */
public interface SocioApp extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link socioProjects.Project}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see socioProjects.SocioProjectsPackage#getSocioApp_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link socioProjects.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see socioProjects.SocioProjectsPackage#getSocioApp_Users()
	 * @model containment="true"
	 * @generated
	 */
	EList<User> getUsers();

} // SocioApp
