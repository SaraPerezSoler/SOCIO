/**
 */
package droidRecommenderHistory;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recommendation Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link droidRecommenderHistory.RecommendationResult#getType <em>Type</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationResult#getValues <em>Values</em>}</li>
 *   <li>{@link droidRecommenderHistory.RecommendationResult#getRaitin <em>Raitin</em>}</li>
 * </ul>
 *
 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationResult()
 * @model
 * @generated
 */
public interface RecommendationResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationResult_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationResult#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' map.
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationResult_Values()
	 * @model mapType="droidRecommenderHistory.StringToObject&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject&gt;"
	 * @generated
	 */
	EMap<String, Object> getValues();

	/**
	 * Returns the value of the '<em><b>Raitin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raitin</em>' attribute.
	 * @see #setRaitin(double)
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#getRecommendationResult_Raitin()
	 * @model required="true"
	 * @generated
	 */
	double getRaitin();

	/**
	 * Sets the value of the '{@link droidRecommenderHistory.RecommendationResult#getRaitin <em>Raitin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raitin</em>' attribute.
	 * @see #getRaitin()
	 * @generated
	 */
	void setRaitin(double value);

	RecommendationResult getACopy();

} // RecommendationResult
