/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Literal#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends Token {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see generator.GeneratorPackage#getLiteral_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link generator.Literal#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Literal
