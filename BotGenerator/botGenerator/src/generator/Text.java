/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Text#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getText()
 * @model
 * @generated
 */
public interface Text extends Action {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.TextInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getText_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TextInput> getInputs();

} // Text
