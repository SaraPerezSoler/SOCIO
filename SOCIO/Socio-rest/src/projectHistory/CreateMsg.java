/**
 */
package projectHistory;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import socioProjects.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Msg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.CreateMsg#getUser <em>User</em>}</li>
 *   <li>{@link projectHistory.CreateMsg#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @see projectHistory.ProjectHistoryPackage#getCreateMsg()
 * @model
 * @generated
 */
public interface CreateMsg extends EObject {
	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see projectHistory.ProjectHistoryPackage#getCreateMsg_User()
	 * @model required="true"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link projectHistory.CreateMsg#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see projectHistory.ProjectHistoryPackage#getCreateMsg_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link projectHistory.CreateMsg#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // CreateMsg
