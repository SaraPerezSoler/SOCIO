/**
 */
package modelInfo;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NL Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.NLFeature#getAsk <em>Ask</em>}</li>
 * </ul>
 *
 * @see modelInfo.ModelInfoPackage#getNLFeature()
 * @model abstract="true"
 * @generated
 */
public interface NLFeature extends NLElement {
	/**
	 * Returns the value of the '<em><b>Ask</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ask</em>' attribute.
	 * @see #setAsk(Boolean)
	 * @see modelInfo.ModelInfoPackage#getNLFeature_Ask()
	 * @model default="null" required="true"
	 * @generated
	 */
	Boolean getAsk();

	/**
	 * Sets the value of the '{@link modelInfo.NLFeature#getAsk <em>Ask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ask</em>' attribute.
	 * @see #getAsk()
	 * @generated
	 */
	void setAsk(Boolean value);
	
	EStructuralFeature getFeature();

	String getName();

} // NLFeature
