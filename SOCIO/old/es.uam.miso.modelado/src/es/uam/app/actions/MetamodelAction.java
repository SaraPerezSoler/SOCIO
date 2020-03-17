package es.uam.app.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public interface MetamodelAction {


	public static Controlador eobjectToControlador(EObject object){
		if (object instanceof EClass){
			return new ClassControl((EClass)object);
		}else if (object instanceof EReference){
			return new ReferenceControl((EReference)object);
		}else if (object instanceof EAttribute){
			return new AttributeControl((EAttribute)object);
		}
		return null;
	}
}
