package zipUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/**
 * @author Sara Pérez Soler
 * 
 * A class to take several a Zip file and extract the content files, used in parser service
 * 
 * **/
public class Unzipper {

	private File dest;
	private File src;

	public Unzipper(String fileZip) {
		src = new File(fileZip);
	}

	public File unzip() {
		try {
			if (!src.exists()) {
				return null;
			}
			String srcName = src.getName();
			dest = new File(srcName.substring(0, srcName.indexOf(".")));
			if (dest.exists()) {
				clean();
			}
			dest.mkdir();
			byte[] buffer = new byte[1024];
			ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
			ZipEntry zipEntry = zis.getNextEntry();
			while (zipEntry != null) {
					File newFile = newFile(dest, zipEntry);
					//new File(newFile.getParent()).mkdirs();
					FileOutputStream fos = new FileOutputStream(newFile);
					int len;
					int totalLen = 0;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
						totalLen+=len;
					}
					fos.close();
					zipEntry = zis.getNextEntry();
					if (totalLen<=0) {
						newFile.delete();
					}
			}
			zis.closeEntry();
			zis.close();
			return dest;
		} catch (Exception e) {
			return null;
		}
	}

	public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {

		File destFile = new File(destinationDir, zipEntry.getName());

		String destDirPath = destinationDir.getCanonicalPath();
		String destFilePath = destFile.getCanonicalPath();

		if (!destFilePath.startsWith(destDirPath + File.separator)) {
			throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
		}
		File parent = destFile.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}

		return destFile;
	}

	public void clean() {
		deleteRecursiveFiles(dest);
	}

	private void deleteRecursiveFiles(File f) {
		if (f.isDirectory()) {
			for (File child : f.listFiles()) {
				deleteRecursiveFiles(child);
			}
		}
		f.delete();
	}

}
