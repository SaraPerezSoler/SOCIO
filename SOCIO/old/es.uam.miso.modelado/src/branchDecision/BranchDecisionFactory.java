/**
 */
package branchDecision;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see branchDecision.BranchDecisionPackage
 * @generated
 */
public interface BranchDecisionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BranchDecisionFactory eINSTANCE = branchDecision.impl.BranchDecisionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Consensus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consensus</em>'.
	 * @generated
	 */
	Consensus createConsensus();

	/**
	 * Returns a new object of class '<em>Round</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Round</em>'.
	 * @generated
	 */
	Round createRound();

	/**
	 * Returns a new object of class '<em>Preference Ordering</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preference Ordering</em>'.
	 * @generated
	 */
	PreferenceOrdering createPreferenceOrdering();

	/**
	 * Returns a new object of class '<em>Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order</em>'.
	 * @generated
	 */
	Order createOrder();

	/**
	 * Returns a new object of class '<em>Admin Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Admin Choice</em>'.
	 * @generated
	 */
	AdminChoice createAdminChoice();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BranchDecisionPackage getBranchDecisionPackage();

} //BranchDecisionFactory
