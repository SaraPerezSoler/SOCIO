/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Intent#getInputs <em>Inputs</em>}</li>
 *   <li>{@link generator.Intent#getParameters <em>Parameters</em>}</li>
 *   <li>{@link generator.Intent#isFallbackIntent <em>Fallback Intent</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getIntent()
 * @model
 * @generated
 */
public interface Intent extends Element {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.IntentLanguageInputs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getIntent_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntentLanguageInputs> getInputs();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see generator.GeneratorPackage#getIntent_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Fallback Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fallback Intent</em>' attribute.
	 * @see #setFallbackIntent(boolean)
	 * @see generator.GeneratorPackage#getIntent_FallbackIntent()
	 * @model required="true"
	 * @generated
	 */
	boolean isFallbackIntent();

	/**
	 * Sets the value of the '{@link generator.Intent#isFallbackIntent <em>Fallback Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fallback Intent</em>' attribute.
	 * @see #isFallbackIntent()
	 * @generated
	 */
	void setFallbackIntent(boolean value);

} // Intent
