/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Image#getURL <em>URL</em>}</li>
 *   <li>{@link generator.Image#getCaption <em>Caption</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getImage()
 * @model
 * @generated
 */
public interface Image extends Action {
	/**
	 * Returns the value of the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URL</em>' attribute.
	 * @see #setURL(String)
	 * @see generator.GeneratorPackage#getImage_URL()
	 * @model required="true"
	 * @generated
	 */
	String getURL();

	/**
	 * Sets the value of the '{@link generator.Image#getURL <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URL</em>' attribute.
	 * @see #getURL()
	 * @generated
	 */
	void setURL(String value);

	/**
	 * Returns the value of the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caption</em>' attribute.
	 * @see #setCaption(String)
	 * @see generator.GeneratorPackage#getImage_Caption()
	 * @model
	 * @generated
	 */
	String getCaption();

	/**
	 * Sets the value of the '{@link generator.Image#getCaption <em>Caption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caption</em>' attribute.
	 * @see #getCaption()
	 * @generated
	 */
	void setCaption(String value);

} // Image
