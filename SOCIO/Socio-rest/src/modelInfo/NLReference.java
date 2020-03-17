/**
 */
package modelInfo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NL Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.NLReference#getReference <em>Reference</em>}</li>
 *   <li>{@link modelInfo.NLReference#getSrcSynonyms <em>Src Synonyms</em>}</li>
 * </ul>
 *
 * @see modelInfo.ModelInfoPackage#getNLReference()
 * @model
 * @generated
 */
public interface NLReference extends NLFeature {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EReference)
	 * @see modelInfo.ModelInfoPackage#getNLReference_Reference()
	 * @model required="true"
	 * @generated
	 */
	EReference getReference();

	/**
	 * Sets the value of the '{@link modelInfo.NLReference#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Src Synonyms</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Synonyms</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Synonyms</em>' attribute list.
	 * @see modelInfo.ModelInfoPackage#getNLReference_SrcSynonyms()
	 * @model
	 * @generated
	 */
	EList<String> getSrcSynonyms();

	boolean isType(EClass eClass);
	boolean isType(NLClass eClass);

	String getName();

} // NLReference
