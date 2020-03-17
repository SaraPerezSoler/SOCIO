/**
 */
package socioProjects;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.User#getName <em>Name</em>}</li>
 *   <li>{@link socioProjects.User#getNick <em>Nick</em>}</li>
 *   <li>{@link socioProjects.User#getId <em>Id</em>}</li>
 *   <li>{@link socioProjects.User#getChannel <em>Channel</em>}</li>
 *   <li>{@link socioProjects.User#getOwnProjects <em>Own Projects</em>}</li>
 *   <li>{@link socioProjects.User#getContributions <em>Contributions</em>}</li>
 * </ul>
 *
 * @see socioProjects.SocioProjectsPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see socioProjects.SocioProjectsPackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link socioProjects.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Nick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nick</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nick</em>' attribute.
	 * @see #setNick(String)
	 * @see socioProjects.SocioProjectsPackage#getUser_Nick()
	 * @model required="true"
	 * @generated
	 */
	String getNick();

	/**
	 * Sets the value of the '{@link socioProjects.User#getNick <em>Nick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nick</em>' attribute.
	 * @see #getNick()
	 * @generated
	 */
	void setNick(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see socioProjects.SocioProjectsPackage#getUser_Id()
	 * @model default="-1"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link socioProjects.User#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' attribute.
	 * @see #setChannel(String)
	 * @see socioProjects.SocioProjectsPackage#getUser_Channel()
	 * @model required="true"
	 * @generated
	 */
	String getChannel();

	/**
	 * Sets the value of the '{@link socioProjects.User#getChannel <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' attribute.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(String value);

	/**
	 * Returns the value of the '<em><b>Own Projects</b></em>' reference list.
	 * The list contents are of type {@link socioProjects.Project}.
	 * It is bidirectional and its opposite is '{@link socioProjects.Project#getAdmin <em>Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Own Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Own Projects</em>' reference list.
	 * @see socioProjects.SocioProjectsPackage#getUser_OwnProjects()
	 * @see socioProjects.Project#getAdmin
	 * @model opposite="admin"
	 * @generated
	 */
	EList<Project> getOwnProjects();

	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' containment reference list.
	 * The list contents are of type {@link socioProjects.Contribution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions</em>' containment reference list.
	 * @see socioProjects.SocioProjectsPackage#getUser_Contributions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contribution> getContributions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" projectRequired="true"
	 * @generated
	 */
	boolean canEdit(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" projectRequired="true"
	 * @generated
	 */
	boolean canRead(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" projectRequired="true"
	 * @generated
	 */
	boolean isAdmin(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model projectRequired="true"
	 * @generated
	 */
	void removeContribution(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model projectRequired="true" accessRequired="true"
	 * @generated
	 */
	void addContribution(Project project, Access access);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model projectRequired="true"
	 * @generated
	 */
	void addProject(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" projectRequired="true"
	 * @generated
	 */
	Contribution getContribution(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isRoot();
	
	String userInfo();

} // User
