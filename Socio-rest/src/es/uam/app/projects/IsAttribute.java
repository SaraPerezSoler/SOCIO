package es.uam.app.projects;

import java.io.FileNotFoundException;

import es.uam.app.actions.metamodels.ChangeRefForAttr;
import es.uam.app.actions.metamodels.CreateAttribute;
import es.uam.app.parser.NP;
import es.uam.app.parser.WordConfigure;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.Feature;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import net.didion.jwnl.JWNLException;
import socioProjects.MetamodelProject;

public interface IsAttribute extends IsInterface{

	
	
	public static IsAttribute getAttribute(NP att, IsClass of, MetamodelProject proj) throws FileNotFoundException, JWNLException{
	
		if (of instanceof ClassControl){
			Feature f= proj.getFeature(att.lowerCammelCase(), (ClassControl)of);
			if (f!=null){
				if (f instanceof ReferenceControl){
					return new ChangeRefForAttr(proj, (ReferenceControl)f, att.getMax());
				}else{
					return (AttributeControl)f;
				}
			}
			f= proj.getFeature(att.lemmaLowerCammelCase(), (ClassControl)of);
			if (f!=null){
				if (f instanceof ReferenceControl){
					return new ChangeRefForAttr(proj, (ReferenceControl)f, att.getMax());
				}else{
					return (AttributeControl)f;
				}
			}
			
			return new CreateAttribute(proj,att.lowerCammelCase(), of,att.getMin(), att.getMax());
		}else{
			return new CreateAttribute(proj,att.lowerCammelCase(), of,att.getMin(), att.getMax());
		}
	}
	
	
	public static IsAttribute getAttribute(String att, IsClass of, int min, int max, MetamodelProject proj) throws FileNotFoundException, JWNLException{
		String att2=WordConfigure.startLowerCase(att);
		if (of instanceof ClassControl){
			Feature f= proj.getFeature(att2, (ClassControl)of);
			if (f!=null){
				if (f instanceof ReferenceControl){
					return new ChangeRefForAttr(proj, (ReferenceControl)f, max);
				}else{
					return (AttributeControl)f;
				}
			}
			return new CreateAttribute(proj,att2, of, min, max);
		}else{
			return new CreateAttribute(proj,att2, of, min, max);
		}
	}
	
	public static IsAttribute getExactlyAttribute(NP att, IsClass of, MetamodelProject proj) throws FileNotFoundException, JWNLException{ 
		
		return getExactlyAttribute(att.lowerCammelCase(), of, att.getMin(), att.getMax(), proj);
	}
	
	
	public static IsAttribute getExactlyAttribute(String att, IsClass of, int min, int max, MetamodelProject proj) throws FileNotFoundException, JWNLException{
		String att2=WordConfigure.startLowerCase(att);
		if (of instanceof ClassControl){
			Feature f= proj.getExactlyFeature(att2, (ClassControl)of);
			if (f!=null){
				if (f instanceof ReferenceControl){
					return new ChangeRefForAttr(proj, (ReferenceControl)f, max);
				}else{
					return (AttributeControl)f;
				}
			}
			return new CreateAttribute(proj,att2, of, min, max);
		}else{
			return new CreateAttribute(proj,att2, of, min, max);
		}
	}
	
	public AttributeControl getAttributeControl() throws Exception;
	
	public int getMin();
	public int getMax();
}
