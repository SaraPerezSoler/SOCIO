/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.EntityToken#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getEntityToken()
 * @model
 * @generated
 */
public interface EntityToken extends Token {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(Entity)
	 * @see generator.GeneratorPackage#getEntityToken_Entity()
	 * @model required="true"
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link generator.EntityToken#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

} // EntityToken
