package es.uam.app.projects.ecore;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;

public class ParameterControl implements MetamodelControl {
	EParameter eParam;

	public ParameterControl() {
		eParam= factory.createEParameter();
	}
	public ParameterControl(String name) {
		eParam=factory.createEParameter();
		eParam.setName(name);
	}
	public ParameterControl(String name, EClassifier type) {
		eParam=factory.createEParameter();
		eParam.setName(name);
		eParam.setEType(type);
	}
	
	public EParameter getEParameter(){
		return eParam;
	}
	@Override
	public EObject getObject() {
		return eParam;
	}
	
	@Override
	public String getName() {
		return eParam.getName();
	}
	@Override
	public String elementType() {
		return "parameter";
	}
	
	
}
