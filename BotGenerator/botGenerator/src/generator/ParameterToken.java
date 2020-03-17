/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.ParameterToken#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getParameterToken()
 * @model
 * @generated
 */
public interface ParameterToken extends Token {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see generator.GeneratorPackage#getParameterToken_Parameter()
	 * @model required="true"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link generator.ParameterToken#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

} // ParameterToken
