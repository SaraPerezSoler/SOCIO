/**
 */
package projectHistory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.History#getMsg <em>Msg</em>}</li>
 *   <li>{@link projectHistory.History#getCreateMsg <em>Create Msg</em>}</li>
 * </ul>
 *
 * @see projectHistory.ProjectHistoryPackage#getHistory()
 * @model
 * @generated
 */
public interface History extends EObject {
	/**
	 * Returns the value of the '<em><b>Msg</b></em>' containment reference list.
	 * The list contents are of type {@link projectHistory.Msg}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg</em>' containment reference list.
	 * @see projectHistory.ProjectHistoryPackage#getHistory_Msg()
	 * @model containment="true"
	 * @generated
	 */
	EList<Msg> getMsg();

	/**
	 * Returns the value of the '<em><b>Create Msg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Msg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Msg</em>' containment reference.
	 * @see #setCreateMsg(CreateMsg)
	 * @see projectHistory.ProjectHistoryPackage#getHistory_CreateMsg()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CreateMsg getCreateMsg();

	/**
	 * Sets the value of the '{@link projectHistory.History#getCreateMsg <em>Create Msg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Msg</em>' containment reference.
	 * @see #getCreateMsg()
	 * @generated
	 */
	void setCreateMsg(CreateMsg value);

} // History
