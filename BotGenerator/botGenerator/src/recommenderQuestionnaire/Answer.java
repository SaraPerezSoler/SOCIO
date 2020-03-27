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
 *   <li>{@link recommenderQuestionnaire.Answer#getAceptedTools <em>Acepted Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Answer#getRefusedTools <em>Refused Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Answer#getUnknown <em>Unknown</em>}</li>
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
	 * Returns the value of the '<em><b>Acepted Tools</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getAceptedOptions <em>Acepted Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acepted Tools</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer_AceptedTools()
	 * @see recommenderQuestionnaire.Tool#getAceptedOptions
	 * @model opposite="aceptedOptions" required="true"
	 * @generated
	 */
	EList<Tool> getAceptedTools();

	/**
	 * Returns the value of the '<em><b>Refused Tools</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getRefusedOptions <em>Refused Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refused Tools</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer_RefusedTools()
	 * @see recommenderQuestionnaire.Tool#getRefusedOptions
	 * @model opposite="refusedOptions"
	 * @generated
	 */
	EList<Tool> getRefusedTools();

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getAnswer_Unknown()
	 * @see recommenderQuestionnaire.Tool#getUnknown
	 * @model opposite="unknown"
	 * @generated
	 */
	EList<Tool> getUnknown();

} // Answer
