/**
 */
package branchDecision;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preference Ordering</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link branchDecision.PreferenceOrdering#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @see branchDecision.BranchDecisionPackage#getPreferenceOrdering()
 * @model
 * @generated
 */
public interface PreferenceOrdering extends Preference {

	/**
	 * Returns the value of the '<em><b>Order</b></em>' containment reference list.
	 * The list contents are of type {@link branchDecision.Order}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' containment reference list.
	 * @see branchDecision.BranchDecisionPackage#getPreferenceOrdering_Order()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Order> getOrder();
} // PreferenceOrdering
