/**
 */
package projectHistory;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction With Actions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.InteractionWithActions#isUndoable <em>Undoable</em>}</li>
 * </ul>
 *
 * @see projectHistory.ProjectHistoryPackage#getInteractionWithActions()
 * @model abstract="true"
 * @generated
 */
public interface InteractionWithActions extends UserInteraction {
	/**
	 * Returns the value of the '<em><b>Undoable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Undoable</em>' attribute.
	 * @see #setUndoable(boolean)
	 * @see projectHistory.ProjectHistoryPackage#getInteractionWithActions_Undoable()
	 * @model required="true"
	 * @generated
	 */
	boolean isUndoable();

	/**
	 * Sets the value of the '{@link projectHistory.InteractionWithActions#isUndoable <em>Undoable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Undoable</em>' attribute.
	 * @see #isUndoable()
	 * @generated
	 */
	void setUndoable(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	List<Action> getAllActions();

	boolean hasElement(String element);

	boolean hasAction(String action);

} // InteractionWithActions
