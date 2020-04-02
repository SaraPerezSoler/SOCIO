/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prompt Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.PromptLanguage#getPrompts <em>Prompts</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getPromptLanguage()
 * @model
 * @generated
 */
public interface PromptLanguage extends WithLanguage {
	/**
	 * Returns the value of the '<em><b>Prompts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompts</em>' attribute list.
	 * @see generator.GeneratorPackage#getPromptLanguage_Prompts()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getPrompts();

} // PromptLanguage
