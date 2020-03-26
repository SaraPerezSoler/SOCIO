/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Question</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Question#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Question#isMultiresponse <em>Multiresponse</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Question#getAnswers <em>Answers</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestion()
 * @model
 * @generated
 */
public interface Question extends WithName {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestion_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link recommenderQuestionnaire.Question#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Multiresponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiresponse</em>' attribute.
	 * @see #setMultiresponse(boolean)
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestion_Multiresponse()
	 * @model required="true"
	 * @generated
	 */
	boolean isMultiresponse();

	/**
	 * Sets the value of the '{@link recommenderQuestionnaire.Question#isMultiresponse <em>Multiresponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiresponse</em>' attribute.
	 * @see #isMultiresponse()
	 * @generated
	 */
	void setMultiresponse(boolean value);

	/**
	 * Returns the value of the '<em><b>Answers</b></em>' containment reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Answer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Answers</em>' containment reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestion_Answers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Answer> getAnswers();

} // Question
