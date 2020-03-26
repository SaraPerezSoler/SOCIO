/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Parameter#getEntity <em>Entity</em>}</li>
 *   <li>{@link generator.Parameter#getDefaultEntity <em>Default Entity</em>}</li>
 *   <li>{@link generator.Parameter#isRequired <em>Required</em>}</li>
 *   <li>{@link generator.Parameter#getPrompts <em>Prompts</em>}</li>
 *   <li>{@link generator.Parameter#isIsList <em>Is List</em>}</li>
 *   <li>{@link generator.Parameter#getPrompLanguage <em>Promp Language</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends Element {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(Entity)
	 * @see generator.GeneratorPackage#getParameter_Entity()
	 * @model
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link generator.Parameter#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Default Entity</b></em>' attribute.
	 * The literals are from the enumeration {@link generator.DefaultEntity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Entity</em>' attribute.
	 * @see generator.DefaultEntity
	 * @see #setDefaultEntity(DefaultEntity)
	 * @see generator.GeneratorPackage#getParameter_DefaultEntity()
	 * @model
	 * @generated
	 */
	DefaultEntity getDefaultEntity();

	/**
	 * Sets the value of the '{@link generator.Parameter#getDefaultEntity <em>Default Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Entity</em>' attribute.
	 * @see generator.DefaultEntity
	 * @see #getDefaultEntity()
	 * @generated
	 */
	void setDefaultEntity(DefaultEntity value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see generator.GeneratorPackage#getParameter_Required()
	 * @model required="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link generator.Parameter#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Prompts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompts</em>' attribute list.
	 * @see generator.GeneratorPackage#getParameter_Prompts()
	 * @model
	 * @generated
	 */
	EList<String> getPrompts();

	/**
	 * Returns the value of the '<em><b>Is List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is List</em>' attribute.
	 * @see #setIsList(boolean)
	 * @see generator.GeneratorPackage#getParameter_IsList()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsList();

	/**
	 * Sets the value of the '{@link generator.Parameter#isIsList <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is List</em>' attribute.
	 * @see #isIsList()
	 * @generated
	 */
	void setIsList(boolean value);

	/**
	 * Returns the value of the '<em><b>Promp Language</b></em>' attribute.
	 * The default value is <code>"EMPTY"</code>.
	 * The literals are from the enumeration {@link generator.Language}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Promp Language</em>' attribute.
	 * @see generator.Language
	 * @see #setPrompLanguage(Language)
	 * @see generator.GeneratorPackage#getParameter_PrompLanguage()
	 * @model default="EMPTY"
	 * @generated
	 */
	Language getPrompLanguage();

	/**
	 * Sets the value of the '{@link generator.Parameter#getPrompLanguage <em>Promp Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Promp Language</em>' attribute.
	 * @see generator.Language
	 * @see #getPrompLanguage()
	 * @generated
	 */
	void setPrompLanguage(Language value);

} // Parameter
