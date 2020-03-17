/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HTTP Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.HTTPRequest#getURL <em>URL</em>}</li>
 *   <li>{@link generator.HTTPRequest#getBasicAuth <em>Basic Auth</em>}</li>
 *   <li>{@link generator.HTTPRequest#getHeaders <em>Headers</em>}</li>
 *   <li>{@link generator.HTTPRequest#getData <em>Data</em>}</li>
 *   <li>{@link generator.HTTPRequest#getDataType <em>Data Type</em>}</li>
 *   <li>{@link generator.HTTPRequest#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getHTTPRequest()
 * @model
 * @generated
 */
public interface HTTPRequest extends Action {
	/**
	 * Returns the value of the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URL</em>' attribute.
	 * @see #setURL(String)
	 * @see generator.GeneratorPackage#getHTTPRequest_URL()
	 * @model required="true"
	 * @generated
	 */
	String getURL();

	/**
	 * Sets the value of the '{@link generator.HTTPRequest#getURL <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URL</em>' attribute.
	 * @see #getURL()
	 * @generated
	 */
	void setURL(String value);

	/**
	 * Returns the value of the '<em><b>Basic Auth</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Auth</em>' containment reference.
	 * @see #setBasicAuth(KeyValue)
	 * @see generator.GeneratorPackage#getHTTPRequest_BasicAuth()
	 * @model containment="true"
	 * @generated
	 */
	KeyValue getBasicAuth();

	/**
	 * Sets the value of the '{@link generator.HTTPRequest#getBasicAuth <em>Basic Auth</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Auth</em>' containment reference.
	 * @see #getBasicAuth()
	 * @generated
	 */
	void setBasicAuth(KeyValue value);

	/**
	 * Returns the value of the '<em><b>Headers</b></em>' containment reference list.
	 * The list contents are of type {@link generator.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headers</em>' containment reference list.
	 * @see generator.GeneratorPackage#getHTTPRequest_Headers()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValue> getHeaders();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference list.
	 * The list contents are of type {@link generator.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference list.
	 * @see generator.GeneratorPackage#getHTTPRequest_Data()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValue> getData();

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link generator.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see generator.DataType
	 * @see #setDataType(DataType)
	 * @see generator.GeneratorPackage#getHTTPRequest_DataType()
	 * @model required="true"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link generator.HTTPRequest#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see generator.DataType
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * The literals are from the enumeration {@link generator.Method}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see generator.Method
	 * @see #setMethod(Method)
	 * @see generator.GeneratorPackage#getHTTPRequest_Method()
	 * @model required="true"
	 * @generated
	 */
	Method getMethod();

	/**
	 * Sets the value of the '{@link generator.HTTPRequest#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see generator.Method
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(Method value);

} // HTTPRequest
