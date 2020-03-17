/**
 */
package generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HTTP Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.HTTPResponse#getInputs <em>Inputs</em>}</li>
 *   <li>{@link generator.HTTPResponse#getHTTPRequest <em>HTTP Request</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getHTTPResponse()
 * @model
 * @generated
 */
public interface HTTPResponse extends Action {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference.
	 * @see #setInputs(TextInput)
	 * @see generator.GeneratorPackage#getHTTPResponse_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TextInput getInputs();

	/**
	 * Sets the value of the '{@link generator.HTTPResponse#getInputs <em>Inputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inputs</em>' containment reference.
	 * @see #getInputs()
	 * @generated
	 */
	void setInputs(TextInput value);

	/**
	 * Returns the value of the '<em><b>HTTP Request</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>HTTP Request</em>' reference.
	 * @see #setHTTPRequest(HTTPRequest)
	 * @see generator.GeneratorPackage#getHTTPResponse_HTTPRequest()
	 * @model required="true"
	 * @generated
	 */
	HTTPRequest getHTTPRequest();

	/**
	 * Sets the value of the '{@link generator.HTTPResponse#getHTTPRequest <em>HTTP Request</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HTTP Request</em>' reference.
	 * @see #getHTTPRequest()
	 * @generated
	 */
	void setHTTPRequest(HTTPRequest value);

} // HTTPResponse
