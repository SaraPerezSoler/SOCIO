/**
 */
package SaveFile;

import java.io.File;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Saved
 * Files</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link SaveFile.SavedFiles#getFiles <em>Files</em>}</li>
 * </ul>
 *
 * @see SaveFile.SaveFilePackage#getSavedFiles()
 * @model
 * @generated
 */
public interface SavedFiles extends EObject {
	/**
	 * Returns the value of the '<em><b>Files</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link SaveFile.File},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Files</em>' map.
	 * @see SaveFile.SaveFilePackage#getSavedFiles_Files()
	 * @model mapType="SaveFile.StringToFile&lt;org.eclipse.emf.ecore.EString,
	 *        SaveFile.File&gt;"
	 * @generated
	 */
	EMap<String, SaveFile.File> getFiles();

	void deleteFile(String key);

	String addFile(File file, String completeName, long duration, SaveFile.TimeUnit unit);
	String addSecondFile(File file, String completeName, long duration, SaveFile.TimeUnit unit);
	File getFile(String key);

} // SavedFiles
