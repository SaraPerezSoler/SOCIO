package es.uam.app.actions;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.actions.metamodels.CreateAttribute;
import es.uam.app.actions.metamodels.CreateClass;
import es.uam.app.actions.metamodels.CreateReference;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public abstract class AddMetamodel extends Add<MetamodelProject>{
	
	public AddMetamodel(MetamodelProject p){
		super(p);
		
	}
	
	public static AddMetamodel createAction(EObject obj, MetamodelProject p){
		if (obj instanceof EClass){
			return new CreateClass(p,new ClassControl((EClass)obj));
		}else if(obj instanceof EAttribute){
			return new CreateAttribute(p,new AttributeControl((EAttribute)obj));
		}else if(obj instanceof EReference){
			return new CreateReference(p, new ReferenceControl((EReference)obj));
		}else{
			return null;
		}
	}
	
	@Override
	public Controlador eobjectToControlador(EObject object) {
		return MetamodelAction.eobjectToControlador(object);
	}
}
