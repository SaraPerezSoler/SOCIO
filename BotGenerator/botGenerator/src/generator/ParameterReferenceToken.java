/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Reference Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.ParameterReferenceToken#getParameter <em>Parameter</em>}</li>
 *   <li>{@link generator.ParameterReferenceToken#getTextReference <em>Text Reference</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getParameterReferenceToken()
 * @model
 * @generated
 */
public interface ParameterReferenceToken extends Token {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see generator.GeneratorPackage#getParameterReferenceToken_Parameter()
	 * @model required="true"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link generator.ParameterReferenceToken#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Text Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Reference</em>' attribute.
	 * @see #setTextReference(String)
	 * @see generator.GeneratorPackage#getParameterReferenceToken_TextReference()
	 * @model required="true"
	 * @generated
	 */
	String getTextReference();

	/**
	 * Sets the value of the '{@link generator.ParameterReferenceToken#getTextReference <em>Text Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Reference</em>' attribute.
	 * @see #getTextReference()
	 * @generated
	 */
	void setTextReference(String value);

} // ParameterReferenceToken
