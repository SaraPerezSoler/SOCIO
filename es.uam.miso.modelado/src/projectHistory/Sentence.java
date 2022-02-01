/**
 */
package projectHistory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sentence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.Sentence#getSentence <em>Sentence</em>}</li>
 *   <li>{@link projectHistory.Sentence#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @see projectHistory.projectHistoryPackage#getSentence()
 * @model
 * @generated
 */
public interface Sentence extends EObject {
	/**
	 * Returns the value of the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence</em>' attribute.
	 * @see #setSentence(String)
	 * @see projectHistory.projectHistoryPackage#getSentence_Sentence()
	 * @model required="true"
	 * @generated
	 */
	String getSentence();

	/**
	 * Sets the value of the '{@link projectHistory.Sentence#getSentence <em>Sentence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' attribute.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(String value);

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link projectHistory.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see projectHistory.projectHistoryPackage#getSentence_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getCommands();

} // Sentence
