/**
 */
package SaveFile;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SaveFile.Timer#getDuration <em>Duration</em>}</li>
 *   <li>{@link SaveFile.Timer#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see SaveFile.SaveFilePackage#getTimer()
 * @model
 * @generated
 */
public interface Timer extends EObject {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(long)
	 * @see SaveFile.SaveFilePackage#getTimer_Duration()
	 * @model required="true"
	 * @generated
	 */
	long getDuration();

	/**
	 * Sets the value of the '{@link SaveFile.Timer#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(long value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link SaveFile.TimeUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see SaveFile.TimeUnit
	 * @see #setUnit(TimeUnit)
	 * @see SaveFile.SaveFilePackage#getTimer_Unit()
	 * @model required="true"
	 * @generated
	 */
	TimeUnit getUnit();

	/**
	 * Sets the value of the '{@link SaveFile.Timer#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see SaveFile.TimeUnit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(TimeUnit value);

} // Timer
