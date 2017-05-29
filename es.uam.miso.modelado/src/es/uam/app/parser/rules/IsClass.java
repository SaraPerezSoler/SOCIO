package es.uam.app.parser.rules;

import java.io.FileNotFoundException;

import es.uam.app.actions.CreateClass;
import es.uam.app.parser.NP;
import es.uam.app.parser.WordConfigure;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;
import net.didion.jwnl.JWNLException;

public interface IsClass {

	
	public static IsClass getClass(NP clas, Project proj) throws FileNotFoundException, JWNLException {
		ClassControl cc= proj.getClass(clas);
		if (cc!=null){
			return cc;
		}
		if (clas.getAdj()!=null && clas.getAdj().lemmaEquals("abstract")){
			String classString=WordConfigure.startUpperCase(clas.getNoun().getLemma());
			return new CreateClass(proj,classString, true);
		}else{
			return new CreateClass(proj,clas.upperCammelCase(), false);
		}
	}
	
	public static IsClass getClass(String clas, Project proj) throws FileNotFoundException, JWNLException {
		ClassControl cc= proj.getClass(clas);
		if (cc!=null){
			return cc;
		}
		
		return new CreateClass(proj,clas, false);
	}
	
	public static IsClass getExactlyClass(NP clas, Project proj) throws FileNotFoundException, JWNLException {
		ClassControl cc= proj.getExactlyClass(clas);
		if (cc!=null){
			return cc;
		}
		if (clas.getAdj()!=null && clas.getAdj().lemmaEquals("abstract")){
			String classString=WordConfigure.startUpperCase(clas.getNoun().getLemma());
			return new CreateClass(proj,classString, true);
		}else{
			return new CreateClass(proj,clas.upperCammelCase(), false);
		}
	}
	
	public static IsClass getExactlyClass(String clas, Project proj) throws FileNotFoundException, JWNLException {
		ClassControl cc= proj.getExactlyClass(clas);
		if (cc!=null){
			return cc;
		}
		
		return new CreateClass(proj,clas, false);
	}
	
	public ClassControl getClassControl() throws Exception;
	@Override
	public boolean equals(Object o);
}
