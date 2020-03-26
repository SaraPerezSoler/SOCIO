/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Entity#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getEntity()
 * @model abstract="true"
 * @generated
 */
public interface Entity extends Element {

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The default value is <code>"EMPTY"</code>.
	 * The literals are from the enumeration {@link generator.Language}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see generator.Language
	 * @see #setLanguage(Language)
	 * @see generator.GeneratorPackage#getEntity_Language()
	 * @model default="EMPTY"
	 * @generated
	 */
	Language getLanguage();

	/**
	 * Sets the value of the '{@link generator.Entity#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see generator.Language
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(Language value);
} // Entity
