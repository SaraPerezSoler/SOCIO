/**
 */
package branchDecision;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import socioProjects.Project;
import socioProjects.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.Preference#getUser <em>User</em>}</li>
 * </ul>
 *
 * @see branchDecision.BranchDecisionPackage#getPreference()
 * @model abstract="true"
 * @generated
 */
public interface Preference extends EObject {
	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see branchDecision.BranchDecisionPackage#getPreference_User()
	 * @model required="true"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link branchDecision.Preference#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	Double[][] getFuzzyPreference(List<Project> branchs) throws Exception;

	EList<Order> getOrder();

} // Preference
