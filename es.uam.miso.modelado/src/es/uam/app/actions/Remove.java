package es.uam.app.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.ReferenceControl;

public abstract class Remove extends ActionModel{

	
	public static Remove createAction(EObject obj){
		if (obj instanceof EClass){
			return new RemoveClass(new ClassControl((EClass)obj));
		}else if(obj instanceof EAttribute){
			return new RemoveAttribute(new AttributeControl((EAttribute)obj));
		}else if(obj instanceof EReference){
			return new RemoveReference(new ReferenceControl((EReference)obj));
		}else{
			return null;
		}
	}

	public Remove(Project proj) {
		super(proj);
	}
	
	public String toString(){
		return "Remove-> "+getObject();
	}
	
}
