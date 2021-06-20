/**
 */
package droidRecommenderHistory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.json.JSONObject;

import projectHistory.UserInteraction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recommendation Msg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link droidRecommenderHistory.RecommendationMsg#getId <em>Id</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationMsg#getElement <em>Element</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationMsg#getElementStatus <em>Element Status</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationMsg#getResults <em>Results</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationMsg#getRecomendationInterface <em>Recomendation Interface</em>}</li>
 * </ul>
 *
 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationMsg()
 * @model
 * @generated
 */
public interface RecommendationMsg extends UserInteraction {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationMsg_Id()
	 * @model required="true"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationMsg#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationMsg_Element()
	 * @model required="true"
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationMsg#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Element Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Status</em>' containment reference.
	 * @see #setElementStatus(EObject)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationMsg_ElementStatus()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getElementStatus();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationMsg#getElementStatus <em>Element Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Status</em>' containment reference.
	 * @see #getElementStatus()
	 * @generated
	 */
	void setElementStatus(EObject value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link droidRecommenderHistory.RecommendationResult}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationMsg_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<RecommendationResult> getResults();

	/**
	 * Returns the value of the '<em><b>Recomendation Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recomendation Interface</em>' attribute.
	 * @see #setRecomendationInterface(String)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationMsg_RecomendationInterface()
	 * @model required="true"
	 * @generated
	 */
	String getRecomendationInterface();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationMsg#getRecomendationInterface <em>Recomendation Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recomendation Interface</em>' attribute.
	 * @see #getRecomendationInterface()
	 * @generated
	 */
	void setRecomendationInterface(String value);

	JSONObject getJSON();

	RecommendationResult getSelected(RecommendationResult selected);

	String getElementName();

	String getElementType();

} // RecommendationMsg
