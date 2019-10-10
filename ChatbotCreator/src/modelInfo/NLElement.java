/**
 */
package modelInfo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NL Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.NLElement#getName <em>Name</em>}</li>
 *   <li>{@link modelInfo.NLElement#getDescription <em>Description</em>}</li>
 *   <li>{@link modelInfo.NLElement#getSynonyms <em>Synonyms</em>}</li>
 *   <li>{@link modelInfo.NLElement#getCreateTemplates <em>Create Templates</em>}</li>
 *   <li>{@link modelInfo.NLElement#getDeleteTemplates <em>Delete Templates</em>}</li>
 * </ul>
 *
 * @see modelInfo.ModelInfoPackage#getNLElement()
 * @model abstract="true"
 * @generated
 */
public interface NLElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see modelInfo.ModelInfoPackage#getNLElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link modelInfo.NLElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see modelInfo.ModelInfoPackage#getNLElement_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link modelInfo.NLElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Synonyms</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synonyms</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synonyms</em>' attribute list.
	 * @see modelInfo.ModelInfoPackage#getNLElement_Synonyms()
	 * @model
	 * @generated
	 */
	EList<String> getSynonyms();

	/**
	 * Returns the value of the '<em><b>Create Templates</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Templates</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Templates</em>' attribute list.
	 * @see modelInfo.ModelInfoPackage#getNLElement_CreateTemplates()
	 * @model
	 * @generated
	 */
	EList<String> getCreateTemplates();

	/**
	 * Returns the value of the '<em><b>Delete Templates</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Templates</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Templates</em>' attribute list.
	 * @see modelInfo.ModelInfoPackage#getNLElement_DeleteTemplates()
	 * @model
	 * @generated
	 */
	EList<String> getDeleteTemplates();

} // NLElement
