/**
 */
package SaveFile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see SaveFile.SaveFileFactory
 * @model kind="package"
 * @generated
 */
public interface SaveFilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SaveFile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "SaveFile";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SaveFile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaveFilePackage eINSTANCE = SaveFile.impl.SaveFilePackageImpl.init();

	/**
	 * The meta object id for the '{@link SaveFile.impl.SavedFilesImpl <em>Saved Files</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SaveFile.impl.SavedFilesImpl
	 * @see SaveFile.impl.SaveFilePackageImpl#getSavedFiles()
	 * @generated
	 */
	int SAVED_FILES = 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVED_FILES__FILES = 0;

	/**
	 * The number of structural features of the '<em>Saved Files</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVED_FILES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Saved Files</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVED_FILES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SaveFile.impl.StringToFileImpl <em>String To File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SaveFile.impl.StringToFileImpl
	 * @see SaveFile.impl.SaveFilePackageImpl#getStringToFile()
	 * @generated
	 */
	int STRING_TO_FILE = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FILE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FILE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FILE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SaveFile.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SaveFile.impl.FileImpl
	 * @see SaveFile.impl.SaveFilePackageImpl#getFile()
	 * @generated
	 */
	int FILE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Create At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__CREATE_AT = 2;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__TIMER = 3;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SaveFile.impl.TimerImpl <em>Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SaveFile.impl.TimerImpl
	 * @see SaveFile.impl.SaveFilePackageImpl#getTimer()
	 * @generated
	 */
	int TIMER = 3;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__DURATION = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__UNIT = 1;

	/**
	 * The number of structural features of the '<em>Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SaveFile.TimeUnit <em>Time Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SaveFile.TimeUnit
	 * @see SaveFile.impl.SaveFilePackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 4;

	/**
	 * Returns the meta object for class '{@link SaveFile.SavedFiles <em>Saved Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Saved Files</em>'.
	 * @see SaveFile.SavedFiles
	 * @generated
	 */
	EClass getSavedFiles();

	/**
	 * Returns the meta object for the map '{@link SaveFile.SavedFiles#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Files</em>'.
	 * @see SaveFile.SavedFiles#getFiles()
	 * @see #getSavedFiles()
	 * @generated
	 */
	EReference getSavedFiles_Files();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To File</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="SaveFile.File" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getStringToFile();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToFile()
	 * @generated
	 */
	EAttribute getStringToFile_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToFile()
	 * @generated
	 */
	EReference getStringToFile_Value();

	/**
	 * Returns the meta object for class '{@link SaveFile.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see SaveFile.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link SaveFile.File#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SaveFile.File#getName()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Name();

	/**
	 * Returns the meta object for the attribute '{@link SaveFile.File#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see SaveFile.File#getExtension()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Extension();

	/**
	 * Returns the meta object for the attribute '{@link SaveFile.File#getCreateAt <em>Create At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create At</em>'.
	 * @see SaveFile.File#getCreateAt()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_CreateAt();

	/**
	 * Returns the meta object for the containment reference '{@link SaveFile.File#getTimer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Timer</em>'.
	 * @see SaveFile.File#getTimer()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_Timer();

	/**
	 * Returns the meta object for class '{@link SaveFile.Timer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer</em>'.
	 * @see SaveFile.Timer
	 * @generated
	 */
	EClass getTimer();

	/**
	 * Returns the meta object for the attribute '{@link SaveFile.Timer#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see SaveFile.Timer#getDuration()
	 * @see #getTimer()
	 * @generated
	 */
	EAttribute getTimer_Duration();

	/**
	 * Returns the meta object for the attribute '{@link SaveFile.Timer#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see SaveFile.Timer#getUnit()
	 * @see #getTimer()
	 * @generated
	 */
	EAttribute getTimer_Unit();

	/**
	 * Returns the meta object for enum '{@link SaveFile.TimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Unit</em>'.
	 * @see SaveFile.TimeUnit
	 * @generated
	 */
	EEnum getTimeUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaveFileFactory getSaveFileFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link SaveFile.impl.SavedFilesImpl <em>Saved Files</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SaveFile.impl.SavedFilesImpl
		 * @see SaveFile.impl.SaveFilePackageImpl#getSavedFiles()
		 * @generated
		 */
		EClass SAVED_FILES = eINSTANCE.getSavedFiles();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAVED_FILES__FILES = eINSTANCE.getSavedFiles_Files();

		/**
		 * The meta object literal for the '{@link SaveFile.impl.StringToFileImpl <em>String To File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SaveFile.impl.StringToFileImpl
		 * @see SaveFile.impl.SaveFilePackageImpl#getStringToFile()
		 * @generated
		 */
		EClass STRING_TO_FILE = eINSTANCE.getStringToFile();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_FILE__KEY = eINSTANCE.getStringToFile_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_FILE__VALUE = eINSTANCE.getStringToFile_Value();

		/**
		 * The meta object literal for the '{@link SaveFile.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SaveFile.impl.FileImpl
		 * @see SaveFile.impl.SaveFilePackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__NAME = eINSTANCE.getFile_Name();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__EXTENSION = eINSTANCE.getFile_Extension();

		/**
		 * The meta object literal for the '<em><b>Create At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__CREATE_AT = eINSTANCE.getFile_CreateAt();

		/**
		 * The meta object literal for the '<em><b>Timer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__TIMER = eINSTANCE.getFile_Timer();

		/**
		 * The meta object literal for the '{@link SaveFile.impl.TimerImpl <em>Timer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SaveFile.impl.TimerImpl
		 * @see SaveFile.impl.SaveFilePackageImpl#getTimer()
		 * @generated
		 */
		EClass TIMER = eINSTANCE.getTimer();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER__DURATION = eINSTANCE.getTimer_Duration();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER__UNIT = eINSTANCE.getTimer_Unit();

		/**
		 * The meta object literal for the '{@link SaveFile.TimeUnit <em>Time Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SaveFile.TimeUnit
		 * @see SaveFile.impl.SaveFilePackageImpl#getTimeUnit()
		 * @generated
		 */
		EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

	}

} //SaveFilePackage
