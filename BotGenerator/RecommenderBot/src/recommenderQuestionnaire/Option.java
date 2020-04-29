/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Option#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getAcceptedTools <em>Accepted Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getRefusedTools <em>Refused Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getUnknown <em>Unknown</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='allToolsRegister toolInAcceptedAndRefused toolInRefusedAndUnknown toolInAcceptedAndUnkown'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot allToolsRegister='Tool.allInstances()-&gt;forAll(t |\n\t\t\t\tself.acceptedTools-&gt;includes(t) or self.refusedTools-&gt;includes(t) or self.unknown-&gt;includes(t))' toolInAcceptedAndRefused='Tool.allInstances()-&gt;forAll(t | self.acceptedTools-&gt;includes(t) implies not\n\t\t\t\tself.refusedTools-&gt;includes(t))' toolInRefusedAndUnknown='Tool.allInstances()-&gt;forAll(t | self.refusedTools-&gt;includes(t) implies not\n\t\t\t\tself.unknown-&gt;includes(t))' toolInAcceptedAndUnkown='Tool.allInstances()-&gt;forAll(t | self.acceptedTools-&gt;includes(t) implies not\n\t\t\t\tself.unknown-&gt;includes(t))'"
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link recommenderQuestionnaire.Option#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Accepted Tools</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getAcceptedOptions <em>Accepted Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted Tools</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_AcceptedTools()
	 * @see recommenderQuestionnaire.Tool#getAcceptedOptions
	 * @model opposite="acceptedOptions" required="true"
	 * @generated
	 */
	EList<Tool> getAcceptedTools();

	/**
	 * Returns the value of the '<em><b>Refused Tools</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getRefusedOptions <em>Refused Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refused Tools</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_RefusedTools()
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
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Unknown()
	 * @see recommenderQuestionnaire.Tool#getUnknown
	 * @model opposite="unknown"
	 * @generated
	 */
	EList<Tool> getUnknown();

} // Option
