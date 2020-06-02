/**
 */
package modelInfo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frequency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.Frequency#getTime <em>Time</em>}</li>
 *   <li>{@link modelInfo.Frequency#getAction <em>Action</em>}</li>
 *   <li>{@link modelInfo.Frequency#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see modelInfo.ModelInfoPackage#getFrequency()
 * @model
 * @generated
 */
public interface Frequency extends Moment {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * The literals are from the enumeration {@link modelInfo.Time}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see modelInfo.Time
	 * @see #setTime(Time)
	 * @see modelInfo.ModelInfoPackage#getFrequency_Time()
	 * @model required="true"
	 * @generated
	 */
	Time getTime();

	/**
	 * Sets the value of the '{@link modelInfo.Frequency#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see modelInfo.Time
	 * @see #getTime()
	 * @generated
	 */
	void setTime(Time value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link modelInfo.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see modelInfo.Action
	 * @see #setAction(Action)
	 * @see modelInfo.ModelInfoPackage#getFrequency_Action()
	 * @model required="true"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link modelInfo.Frequency#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see modelInfo.Action
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link modelInfo.NLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see modelInfo.ModelInfoPackage#getFrequency_Elements()
	 * @model
	 * @generated
	 */
	EList<NLElement> getElements();

} // Frequency
