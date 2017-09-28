/**
 */
package projectHistory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.Update#getOld <em>Old</em>}</li>
 *   <li>{@link projectHistory.Update#getNew <em>New</em>}</li>
 * </ul>
 *
 * @see projectHistory.projectHistoryPackage#getUpdate()
 * @model abstract="true"
 * @generated
 */
public interface Update extends Action {
	/**
	 * Returns the value of the '<em><b>Old</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old</em>' containment reference.
	 * @see #setOld(EObject)
	 * @see projectHistory.projectHistoryPackage#getUpdate_Old()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getOld();

	/**
	 * Sets the value of the '{@link projectHistory.Update#getOld <em>Old</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old</em>' containment reference.
	 * @see #getOld()
	 * @generated
	 */
	void setOld(EObject value);

	/**
	 * Returns the value of the '<em><b>New</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New</em>' containment reference.
	 * @see #setNew(EObject)
	 * @see projectHistory.projectHistoryPackage#getUpdate_New()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getNew();

	/**
	 * Sets the value of the '{@link projectHistory.Update#getNew <em>New</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New</em>' containment reference.
	 * @see #getNew()
	 * @generated
	 */
	void setNew(EObject value);

} // Update
