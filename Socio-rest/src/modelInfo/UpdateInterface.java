/**
 */
package modelInfo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.UpdateInterface#getMoments <em>Moments</em>}</li>
 * </ul>
 *
 * @see modelInfo.ModelInfoPackage#getUpdateInterface()
 * @model abstract="true"
 * @generated
 */
public interface UpdateInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Moments</b></em>' reference list.
	 * The list contents are of type {@link modelInfo.Moment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moments</em>' reference list.
	 * @see modelInfo.ModelInfoPackage#getUpdateInterface_Moments()
	 * @model
	 * @generated
	 */
	EList<Moment> getMoments();

} // UpdateInterface
