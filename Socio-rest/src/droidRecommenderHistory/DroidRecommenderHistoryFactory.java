/**
 */
package droidRecommenderHistory;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage
 * @generated
 */
public interface DroidRecommenderHistoryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DroidRecommenderHistoryFactory eINSTANCE = droidRecommenderHistory.impl.DroidRecommenderHistoryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Recommendation Msg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recommendation Msg</em>'.
	 * @generated
	 */
	RecommendationMsg createRecommendationMsg();

	/**
	 * Returns a new object of class '<em>Recommendation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recommendation Result</em>'.
	 * @generated
	 */
	RecommendationResult createRecommendationResult();

	/**
	 * Returns a new object of class '<em>Recommendation Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recommendation Event</em>'.
	 * @generated
	 */
	RecommendationEvent createRecommendationEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DroidRecommenderHistoryPackage getDroidRecommenderHistoryPackage();

} //DroidRecommenderHistoryFactory
