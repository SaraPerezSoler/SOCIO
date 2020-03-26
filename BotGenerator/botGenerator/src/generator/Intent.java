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
 *   <li>{@link generator.Intent#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getIntent()
 * @model
 * @generated
 */
public interface Intent extends Element {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.TrainingPhrase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getIntent_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TrainingPhrase> getInputs();

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

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The default value is <code>"EMPTY"</code>.
	 * The literals are from the enumeration {@link generator.Language}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see generator.Language
	 * @see #setLanguage(Language)
	 * @see generator.GeneratorPackage#getIntent_Language()
	 * @model default="EMPTY"
	 * @generated
	 */
	Language getLanguage();

	/**
	 * Sets the value of the '{@link generator.Intent#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see generator.Language
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(Language value);

} // Intent
