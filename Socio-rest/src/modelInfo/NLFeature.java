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
 *   <li>{@link modelInfo.NLFeature#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link modelInfo.NLFeature#getUpperBound <em>Upper Bound</em>}</li>
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
	
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see modelInfo.ModelInfoPackage#getNLFeature_LowerBound()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link modelInfo.NLFeature#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see modelInfo.ModelInfoPackage#getNLFeature_UpperBound()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link modelInfo.NLFeature#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	EStructuralFeature getFeature();

	String getName();

} // NLFeature
