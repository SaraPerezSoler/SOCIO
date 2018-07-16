/**
 */
package SaveFile.impl;

import SaveFile.SaveFileFactory;
import SaveFile.SaveFilePackage;
import SaveFile.SavedFiles;
import es.fileServer.TimerFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Saved
 * Files</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link SaveFile.impl.SavedFilesImpl#getFiles <em>Files</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SavedFilesImpl extends MinimalEObjectImpl.Container implements SavedFiles {
	private static final String FILENAME = "savedFiles.xmi";
	public static ResourceSet resourceSet = getResourceSet();
	public static String PATH;
	public static Resource resource;
	public static SavedFiles savedFiles;

	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			// Especificamos la extension del fichero (para todos los ficheros),
			// y indicamos que
			// es un XMI.
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put("SaveFile", SaveFilePackageImpl.eINSTANCE);
		}
		return resourceSet;
	}

	public static SavedFiles getSavedFiles(String path) throws Exception {
		if (savedFiles == null) {
			PATH = path;
			File dir = new File(PATH);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(PATH + "/" + FILENAME);
			if (file.exists()) {
				try {
					resource = getResourceSet().getResource(URI.createURI(PATH + "/" + FILENAME), true);
					savedFiles = (SavedFiles) resource.getContents().get(0);
					loadTimers();
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("In class SavedFiles: the file " + PATH + "/" + FILENAME + " can be opened: ");
				}
			} else {
				resource = getResourceSet().createResource(URI.createURI(PATH + "/" + FILENAME));
				savedFiles = SaveFileFactory.eINSTANCE.createSavedFiles();
				resource.getContents().add(savedFiles);
			}

			save();
		}
		return savedFiles;
	}

	private static void loadTimers() {
		EMap<String, SaveFile.File> files = savedFiles.getFiles();
		List<String> remove = new ArrayList<>();
		for (String key : files.keySet()) {
			SaveFile.File file = files.get(key);
			// Miramos la fecha de creacion
			Date date = file.getCreateAt();
			// Calculamos el tiempo transcurrido desde su creacion en milisegungos
			long timeElapsed = (new Date()).getTime() - date.getTime();
			// Al timer restamos el tiempo transcurrido y creamos la alerta
			TimeUnit unit = TimeUnit.valueOf(file.getTimer().getUnit().getLiteral());
			long timer = unit.toMillis(file.getTimer().getDuration()) - timeElapsed;
			// Si aun queda tiempo de timer lo ponermos, sino lo eliminamos
			if (timer > 0) {
				new TimerFile(key, savedFiles, TimeUnit.MILLISECONDS, timer);
			} else {
				remove.add(key);
			}
		}
		for (String key : remove) {
			savedFiles.deleteFile(key);
		}
	}

	private static void save() {
		try {
			resource.save(null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected EMap<String, SaveFile.File> files;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SavedFilesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaveFilePackage.Literals.SAVED_FILES;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<String, SaveFile.File> getFiles() {
		if (files == null) {
			files = new EcoreEMap<String, SaveFile.File>(SaveFilePackage.Literals.STRING_TO_FILE,
					StringToFileImpl.class, this, SaveFilePackage.SAVED_FILES__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SaveFilePackage.SAVED_FILES__FILES:
			return ((InternalEList<?>) getFiles()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SaveFilePackage.SAVED_FILES__FILES:
			if (coreType)
				return getFiles();
			else
				return getFiles().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SaveFilePackage.SAVED_FILES__FILES:
			((EStructuralFeature.Setting) getFiles()).set(newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SaveFilePackage.SAVED_FILES__FILES:
			getFiles().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SaveFilePackage.SAVED_FILES__FILES:
			return files != null && !files.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void deleteFile(String key) {

		File f = new File(PATH +"/"+ getFiles().get(key).getName() + "." + getFiles().get(key).getExtension());
		if (f.exists()) {
			f.delete();
		}
		getFiles().removeKey(key);
		save();
	}

	public String addFile(File file, String completeName, long duration, SaveFile.TimeUnit unit) {

		// Guardamos el fichero en la localizacion que queremos asegurando que no
		// sobreescriba ninguno
		String ext = FilenameUtils.getExtension(completeName);
		String name = completeName.replaceAll("." + ext, "");
		String name2=name;
		File f = new File(PATH + "/" + name2 + "." + ext);
		int i = 1;
		
		while (f.exists()) {
			name2 = name + i;
			f = new File(PATH + "/" + name2 + "." + ext);
			i++;
		}
		name = name2;
		file.renameTo(f);
		// Guardamos el fichero en nuesta base de datos
		String id = java.util.UUID.randomUUID().toString();

		SaveFile.File newfile = SaveFileFactory.eINSTANCE.createFile();
		newfile.setName(name);
		newfile.setExtension(ext);
		newfile.addTimer(duration, unit);
		newfile.setCreateAt(new Date());
		getFiles().put(id, newfile);
		new TimerFile(id, this, TimeUnit.valueOf(unit.getLiteral()), duration);
		save();
		return id;
	}

	public File getFile(String key) {
		SaveFile.File file = getFiles().get(key);
		if (file != null) {
			File f = new File(PATH + "/" + file.getName() + "." + file.getExtension());
			if (f.exists()) {
				return f;
			}
		}
		return null;
	}

} // SavedFilesImpl
