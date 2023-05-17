package zipUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * @author Sara Pérez Soler
 * 
 * A class to take several files and create only one Zip file, used in generation service
 * 
 * **/
public class Zipper {
	private FileOutputStream fos;
	private ZipOutputStream zos;
	private File file;

	public Zipper(String path, String name) {

		try {
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}else {
				if (!dir.isDirectory()) {
					dir.mkdirs();
				}
			}
			file = new File (path + "/" + name + ".zip");
			fos = new FileOutputStream(file);
			zos = new ZipOutputStream(new BufferedOutputStream(fos));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public File getFile() {
		return file;
	}

	/*public void addFile(String path, String fileName) {
		try {
			String srcFile = path + "/" + fileName;

			File fileToZip = new File(srcFile);
			FileInputStream fis;

			fis = new FileInputStream(fileToZip);

			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	public void addFile(String fileName, File f) {
		try {
			FileInputStream input = new FileInputStream(f);
			ZipEntry zipEntry = new ZipEntry(fileName);
			zos.putNextEntry(zipEntry);

			byte[] bytes = input.readAllBytes();
			int length = bytes.length;
			zos.write(bytes, 0, length);
			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*public void addFileToFolder(String path, String folderName, String fileName) {
		try {
			String srcFile = path + "/" + fileName;

			File fileToZip = new File(srcFile);
			FileInputStream fis;

			fis = new FileInputStream(fileToZip);

			ZipEntry zipEntry = new ZipEntry(folderName+"/"+fileToZip.getName());
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	public void addFileToFolder(String folderName, String fileName, File f) {
		try {
			FileInputStream input = new FileInputStream(f);
			ZipEntry zipEntry = new ZipEntry(folderName+fileName);
			zos.putNextEntry(zipEntry);
			byte[] bytes = input.readAllBytes();
			int length = bytes.length;
			zos.write(bytes, 0, length);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			zos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
