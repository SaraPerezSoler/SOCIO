/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.SimpleInput#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getSimpleInput()
 * @model
 * @generated
 */
public interface SimpleInput extends Element {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see generator.GeneratorPackage#getSimpleInput_Values()
	 * @model
	 * @generated
	 */
	EList<String> getValues();

} // SimpleInput
