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
 *   <li>{@link recommenderQuestionnaire.Tool#getOptions <em>Options</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool()
 * @model
 * @generated
 */
public interface Tool extends WithName {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Answer}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Answer#getTools <em>Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_Options()
	 * @see recommenderQuestionnaire.Answer#getTools
	 * @model opposite="tools" required="true"
	 * @generated
	 */
	EList<Answer> getOptions();

} // Tool
