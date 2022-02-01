/**
 */
package removeLog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link removeLog.Root#getElementsDeletes <em>Elements Deletes</em>}</li>
 * </ul>
 *
 * @see removeLog.RemoveLogPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements Deletes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements Deletes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements Deletes</em>' containment reference list.
	 * @see removeLog.RemoveLogPackage#getRoot_ElementsDeletes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getElementsDeletes();

} // Root
