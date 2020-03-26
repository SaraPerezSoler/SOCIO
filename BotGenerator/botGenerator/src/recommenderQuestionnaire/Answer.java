/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Answer#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Answer#getTools <em>Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Answer#getNotKnowing <em>Not Knowing</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer()
 * @model
 * @generated
 */
public interface Answer extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link recommenderQuestionnaire.Answer#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Tools</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tools</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer_Tools()
	 * @see recommenderQuestionnaire.Tool#getOptions
	 * @model opposite="options" required="true"
	 * @generated
	 */
	EList<Tool> getTools();

	/**
	 * Returns the value of the '<em><b>Not Knowing</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Knowing</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer_NotKnowing()
	 * @model
	 * @generated
	 */
	EList<Tool> getNotKnowing();

} // Answer
