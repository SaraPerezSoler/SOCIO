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
 *   <li>{@link recommenderQuestionnaire.Tool#getAcceptedOptions <em>Accepted Options</em>}</li>
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
	 * Returns the value of the '<em><b>Accepted Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getAcceptedTools <em>Accepted Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_AcceptedOptions()
	 * @see recommenderQuestionnaire.Option#getAcceptedTools
	 * @model opposite="acceptedTools" required="true"
	 * @generated
	 */
	EList<Option> getAcceptedOptions();

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_Unknown()
	 * @see recommenderQuestionnaire.Option#getUnknown
	 * @model opposite="unknown"
	 * @generated
	 */
	EList<Option> getUnknown();

	/**
	 * Returns the value of the '<em><b>Refused Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getRefusedTools <em>Refused Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refused Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_RefusedOptions()
	 * @see recommenderQuestionnaire.Option#getRefusedTools
	 * @model opposite="refusedTools"
	 * @generated
	 */
	EList<Option> getRefusedOptions();

} // Tool
