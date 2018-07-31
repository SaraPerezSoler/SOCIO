/**
 */
package branchDecision;

import java.util.Date;
import java.util.List;

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
 *   <li>{@link branchDecision.Decision#getChosenBranch <em>Chosen Branch</em>}</li>
 *   <li>{@link branchDecision.Decision#getStart <em>Start</em>}</li>
 *   <li>{@link branchDecision.Decision#getMergedDate <em>Merged Date</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(Date)
	 * @see branchDecision.BranchDecisionPackage#getDecision_Start()
	 * @model required="true"
	 * @generated
	 */
	Date getStart();

	/**
	 * Sets the value of the '{@link branchDecision.Decision#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Date value);

	/**
	 * Returns the value of the '<em><b>Merged Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merged Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merged Date</em>' attribute.
	 * @see #setMergedDate(Date)
	 * @see branchDecision.BranchDecisionPackage#getDecision_MergedDate()
	 * @model
	 * @generated
	 */
	Date getMergedDate();

	/**
	 * Sets the value of the '{@link branchDecision.Decision#getMergedDate <em>Merged Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merged Date</em>' attribute.
	 * @see #getMergedDate()
	 * @generated
	 */
	void setMergedDate(Date value);

	Project getBranch(String branchName);

	String decisionInformation();
	
	Project getProject();

	List<Project> getBranchs();
	
	String getFilePath();
	void setFilePath(String path);


} // Decision
