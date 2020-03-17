/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Simple#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getSimple()
 * @model
 * @generated
 */
public interface Simple extends Entity {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.SimpleInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getSimple_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleInput> getInputs();

} // Simple
