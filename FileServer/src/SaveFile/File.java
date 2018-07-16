/**
 */
package SaveFile;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SaveFile.File#getName <em>Name</em>}</li>
 *   <li>{@link SaveFile.File#getExtension <em>Extension</em>}</li>
 *   <li>{@link SaveFile.File#getCreateAt <em>Create At</em>}</li>
 *   <li>{@link SaveFile.File#getTimer <em>Timer</em>}</li>
 * </ul>
 *
 * @see SaveFile.SaveFilePackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see SaveFile.SaveFilePackage#getFile_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link SaveFile.File#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see SaveFile.SaveFilePackage#getFile_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link SaveFile.File#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

	/**
	 * Returns the value of the '<em><b>Create At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create At</em>' attribute.
	 * @see #setCreateAt(Date)
	 * @see SaveFile.SaveFilePackage#getFile_CreateAt()
	 * @model required="true"
	 * @generated
	 */
	Date getCreateAt();

	/**
	 * Sets the value of the '{@link SaveFile.File#getCreateAt <em>Create At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create At</em>' attribute.
	 * @see #getCreateAt()
	 * @generated
	 */
	void setCreateAt(Date value);

	/**
	 * Returns the value of the '<em><b>Timer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer</em>' containment reference.
	 * @see #setTimer(Timer)
	 * @see SaveFile.SaveFilePackage#getFile_Timer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Timer getTimer();

	/**
	 * Sets the value of the '{@link SaveFile.File#getTimer <em>Timer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer</em>' containment reference.
	 * @see #getTimer()
	 * @generated
	 */
	void setTimer(Timer value);
	void addTimer(long duration, TimeUnit unit);

} // File
