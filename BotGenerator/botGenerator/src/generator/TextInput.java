/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.TextInput#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getTextInput()
 * @model
 * @generated
 */
public interface TextInput extends EObject {
	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Token}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see generator.GeneratorPackage#getTextInput_Tokens()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Token> getTokens();

} // TextInput
