/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Tool#getAceptedOptions <em>Acepted Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Tool#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Tool#getRefusedOptions <em>Refused Options</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool()
 * @model
 * @generated
 */
public interface Tool extends WithName {
	/**
	 * Returns the value of the '<em><b>Acepted Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Answer}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Answer#getAceptedTools <em>Acepted Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acepted Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_AceptedOptions()
	 * @see recommenderQuestionnaire.Answer#getAceptedTools
	 * @model opposite="aceptedTools" required="true"
	 * @generated
	 */
	EList<Answer> getAceptedOptions();

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Answer}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Answer#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_Unknown()
	 * @see recommenderQuestionnaire.Answer#getUnknown
	 * @model opposite="unknown"
	 * @generated
	 */
	EList<Answer> getUnknown();

	/**
	 * Returns the value of the '<em><b>Refused Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Answer}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Answer#getRefusedTools <em>Refused Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refused Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_RefusedOptions()
	 * @see recommenderQuestionnaire.Answer#getRefusedTools
	 * @model opposite="refusedTools"
	 * @generated
	 */
	EList<Answer> getRefusedOptions();

} // Tool
