package es.uam.app.plantUML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;

public class UML {

	public static File write(String path, String text) {
		FileWriter fichero;
		File file=new File(path);
		try {
			fichero = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fichero);
		    pw.print(text);
		    fichero.close();
		    return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	    
	}
	
	public static File getUML(File f){
		
		SourceFileReader reader;
		try {
			reader = new SourceFileReader(f);
			List<GeneratedImage> list = reader.getGeneratedImages();
			if (list.isEmpty()){
				return null;
			}
			return  list.get(0).getPngFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
