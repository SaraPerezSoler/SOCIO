/**
 */
package socioProjects;

import branchDecision.Decision;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.BranchGroup#getName <em>Name</em>}</li>
 *   <li>{@link socioProjects.BranchGroup#getCreateAt <em>Create At</em>}</li>
 *   <li>{@link socioProjects.BranchGroup#getStatus <em>Status</em>}</li>
 *   <li>{@link socioProjects.BranchGroup#getFather <em>Father</em>}</li>
 *   <li>{@link socioProjects.BranchGroup#getDecision <em>Decision</em>}</li>
 *   <li>{@link socioProjects.BranchGroup#getBranchs <em>Branchs</em>}</li>
 * </ul>
 *
 * @see socioProjects.SocioProjectsPackage#getBranchGroup()
 * @model
 * @generated
 */
public interface BranchGroup extends EObject {
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
	 * @see socioProjects.SocioProjectsPackage#getBranchGroup_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link socioProjects.BranchGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Create At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create At</em>' attribute.
	 * @see #setCreateAt(Date)
	 * @see socioProjects.SocioProjectsPackage#getBranchGroup_CreateAt()
	 * @model required="true"
	 * @generated
	 */
	Date getCreateAt();

	/**
	 * Sets the value of the '{@link socioProjects.BranchGroup#getCreateAt <em>Create At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create At</em>' attribute.
	 * @see #getCreateAt()
	 * @generated
	 */
	void setCreateAt(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"OPEN"</code>.
	 * The literals are from the enumeration {@link socioProjects.GroupStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see socioProjects.GroupStatus
	 * @see #setStatus(GroupStatus)
	 * @see socioProjects.SocioProjectsPackage#getBranchGroup_Status()
	 * @model default="OPEN" required="true"
	 * @generated
	 */
	GroupStatus getStatus();

	/**
	 * Sets the value of the '{@link socioProjects.BranchGroup#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see socioProjects.GroupStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(GroupStatus value);

	/**
	 * Returns the value of the '<em><b>Father</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link socioProjects.Project#getBranchs <em>Branchs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Father</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Father</em>' container reference.
	 * @see #setFather(Project)
	 * @see socioProjects.SocioProjectsPackage#getBranchGroup_Father()
	 * @see socioProjects.Project#getBranchs
	 * @model opposite="branchs" required="true" transient="false"
	 * @generated
	 */
	Project getFather();

	/**
	 * Sets the value of the '{@link socioProjects.BranchGroup#getFather <em>Father</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Father</em>' container reference.
	 * @see #getFather()
	 * @generated
	 */
	void setFather(Project value);

	/**
	 * Returns the value of the '<em><b>Decision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decision</em>' containment reference.
	 * @see #setDecision(Decision)
	 * @see socioProjects.SocioProjectsPackage#getBranchGroup_Decision()
	 * @model containment="true"
	 * @generated
	 */
	Decision getDecision();

	/**
	 * Sets the value of the '{@link socioProjects.BranchGroup#getDecision <em>Decision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decision</em>' containment reference.
	 * @see #getDecision()
	 * @generated
	 */
	void setDecision(Decision value);

	/**
	 * Returns the value of the '<em><b>Branchs</b></em>' reference list.
	 * The list contents are of type {@link socioProjects.Project}.
	 * It is bidirectional and its opposite is '{@link socioProjects.Project#getBranchGroup <em>Branch Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branchs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branchs</em>' reference list.
	 * @see socioProjects.SocioProjectsPackage#getBranchGroup_Branchs()
	 * @see socioProjects.Project#getBranchGroup
	 * @model opposite="branchGroup"
	 * @generated
	 */
	EList<Project> getBranchs();

	void addProject(Project p);

	void removeProject(Project projectImpl);
	
	void remove();

	Project getBranch(String name);


} // BranchGroup
