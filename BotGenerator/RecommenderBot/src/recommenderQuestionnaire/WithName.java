/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>With Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.WithName#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getWithName()
 * @model abstract="true"
 * @generated
 */
public interface WithName extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getWithName_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link recommenderQuestionnaire.WithName#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // WithName
