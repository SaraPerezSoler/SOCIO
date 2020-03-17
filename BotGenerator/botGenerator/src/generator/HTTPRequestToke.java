/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HTTP Request Toke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.HTTPRequestToke#getType <em>Type</em>}</li>
 *   <li>{@link generator.HTTPRequestToke#getDataKey <em>Data Key</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getHTTPRequestToke()
 * @model
 * @generated
 */
public interface HTTPRequestToke extends Token {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link generator.HTTPReturnType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see generator.HTTPReturnType
	 * @see #setType(HTTPReturnType)
	 * @see generator.GeneratorPackage#getHTTPRequestToke_Type()
	 * @model required="true"
	 * @generated
	 */
	HTTPReturnType getType();

	/**
	 * Sets the value of the '{@link generator.HTTPRequestToke#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see generator.HTTPReturnType
	 * @see #getType()
	 * @generated
	 */
	void setType(HTTPReturnType value);

	/**
	 * Returns the value of the '<em><b>Data Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Key</em>' attribute.
	 * @see #setDataKey(String)
	 * @see generator.GeneratorPackage#getHTTPRequestToke_DataKey()
	 * @model
	 * @generated
	 */
	String getDataKey();

	/**
	 * Sets the value of the '{@link generator.HTTPRequestToke#getDataKey <em>Data Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Key</em>' attribute.
	 * @see #getDataKey()
	 * @generated
	 */
	void setDataKey(String value);

} // HTTPRequestToke
