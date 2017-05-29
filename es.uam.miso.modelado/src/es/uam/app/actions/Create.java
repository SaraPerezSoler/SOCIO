package es.uam.app.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.ReferenceControl;

public abstract class Create extends ActionModel {

	public static Create createAction(EObject obj){
		if (obj instanceof EClass){
			return new CreateClass(new ClassControl((EClass)obj));
		}else if(obj instanceof EAttribute){
			return new CreateAttribute(new AttributeControl((EAttribute)obj));
		}else if(obj instanceof EReference){
			return new CreateReference(new ReferenceControl((EReference)obj));
		}else{
			return null;
		}
	}
	
	public Create(Project proj) {
		super(proj);
	}
	
	public String toString() {
		return "Create-> "+getObject().elementType()+" "+ getObject().getName();
	}

}
