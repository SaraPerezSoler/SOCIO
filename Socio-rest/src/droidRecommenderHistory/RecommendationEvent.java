/**
 */
package droidRecommenderHistory;

import org.eclipse.emf.common.util.EList;

import projectHistory.Action;
import projectHistory.InteractionWithActions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recommendation Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link droidRecommenderHistory.RecommendationEvent#getRecommendation <em>Recommendation</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationEvent#getSelected <em>Selected</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationEvent#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationEvent()
 * @model
 * @generated
 */
public interface RecommendationEvent extends InteractionWithActions {
	/**
	 * Returns the value of the '<em><b>Recommendation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recommendation</em>' reference.
	 * @see #setRecommendation(RecommendationMsg)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationEvent_Recommendation()
	 * @model required="true"
	 * @generated
	 */
	RecommendationMsg getRecommendation();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationEvent#getRecommendation <em>Recommendation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recommendation</em>' reference.
	 * @see #getRecommendation()
	 * @generated
	 */
	void setRecommendation(RecommendationMsg value);

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected</em>' reference.
	 * @see #setSelected(RecommendationResult)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationEvent_Selected()
	 * @model required="true"
	 * @generated
	 */
	RecommendationResult getSelected();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationEvent#getSelected <em>Selected</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' reference.
	 * @see #getSelected()
	 * @generated
	 */
	void setSelected(RecommendationResult value);

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link projectHistory.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationEvent_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getCommands();

	String getElementName();

	String getElementType();

} // RecommendationEvent
