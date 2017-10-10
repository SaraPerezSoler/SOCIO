package es.uam.app.actions;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.actions.metamodels.RemoveAttribute;
import es.uam.app.actions.metamodels.RemoveClass;
import es.uam.app.actions.metamodels.RemoveReference;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public abstract class DeleteMetamodel extends Delete<MetamodelProject>{


	public DeleteMetamodel(MetamodelProject p) {
		super(p);
	}	

	public static DeleteMetamodel createAction(MetamodelProject p, EObject obj){
		if (obj instanceof EClass){
			return new RemoveClass(p,new ClassControl((EClass)obj), true);
		}else if(obj instanceof EAttribute){
			return new RemoveAttribute(p,new AttributeControl((EAttribute)obj), true);
		}else if(obj instanceof EReference){
			return new RemoveReference(p,new ReferenceControl((EReference)obj), true);
		}else{
			return null;
		}
	}
	
	@Override
	public Controlador eobjectToControlador(EObject object) {
		return MetamodelAction.eobjectToControlador(object);
	}
	
}
