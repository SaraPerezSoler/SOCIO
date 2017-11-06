/**
 */
package branchDecision;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.Decision#getName <em>Name</em>}</li>
 *   <li>{@link branchDecision.Decision#getBranchs <em>Branchs</em>}</li>
 *   <li>{@link branchDecision.Decision#getChosenBranch <em>Chosen Branch</em>}</li>
 * </ul>
 *
 * @see branchDecision.BranchDecisionPackage#getDecision()
 * @model abstract="true"
 * @generated
 */
public interface Decision extends EObject {
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
	 * @see branchDecision.BranchDecisionPackage#getDecision_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link branchDecision.Decision#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Branchs</b></em>' containment reference list.
	 * The list contents are of type {@link socioProjects.Project}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branchs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branchs</em>' containment reference list.
	 * @see branchDecision.BranchDecisionPackage#getDecision_Branchs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Project> getBranchs();

	/**
	 * Returns the value of the '<em><b>Chosen Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Branch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Branch</em>' reference.
	 * @see #setChosenBranch(Project)
	 * @see branchDecision.BranchDecisionPackage#getDecision_ChosenBranch()
	 * @model
	 * @generated
	 */
	Project getChosenBranch();

	/**
	 * Sets the value of the '{@link branchDecision.Decision#getChosenBranch <em>Chosen Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Branch</em>' reference.
	 * @see #getChosenBranch()
	 * @generated
	 */
	void setChosenBranch(Project value);

	Project getBranch(String branchName);

	String decisionInformation();

} // Decision
