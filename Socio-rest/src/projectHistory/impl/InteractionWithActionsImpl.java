/**
 */
package projectHistory.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import projectHistory.Action;
import projectHistory.InteractionWithActions;
import projectHistory.ProjectHistoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction With Actions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.impl.InteractionWithActionsImpl#isUndoable <em>Undoable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InteractionWithActionsImpl extends UserInteractionImpl implements InteractionWithActions {
	/**
	 * The default value of the '{@link #isUndoable() <em>Undoable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUndoable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNDOABLE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isUndoable() <em>Undoable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUndoable()
	 * @generated
	 * @ordered
	 */
	protected boolean undoable = UNDOABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionWithActionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProjectHistoryPackage.Literals.INTERACTION_WITH_ACTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUndoable() {
		return undoable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUndoable(boolean newUndoable) {
		boolean oldUndoable = undoable;
		undoable = newUndoable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__UNDOABLE, oldUndoable, undoable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Action> getAllActions() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__UNDOABLE:
				return isUndoable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__UNDOABLE:
				setUndoable((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__UNDOABLE:
				setUndoable(UNDOABLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__UNDOABLE:
				return undoable != UNDOABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ProjectHistoryPackage.INTERACTION_WITH_ACTIONS___GET_ALL_ACTIONS:
				return getAllActions();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (undoable: ");
		result.append(undoable);
		result.append(')');
		return result.toString();
	}

} //InteractionWithActionsImpl
