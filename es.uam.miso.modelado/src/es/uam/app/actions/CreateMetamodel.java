package es.uam.app.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.actions.metamodels.CreateAttribute;
import es.uam.app.actions.metamodels.CreateClass;
import es.uam.app.actions.metamodels.CreateReference;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.ReferenceControl;

public abstract class CreateMetamodel extends Create {

	public static CreateMetamodel createAction(EObject obj){
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
	
	public CreateMetamodel(MetaModelProject proj) {
		super(proj);
	}
	
	@Override
	public void redoIt(Project proj) throws Exception {
		if (proj instanceof MetaModelProject){
			redoIt((MetaModelProject)proj);
		}
		
	}
	
	@Override
	public void undoIt(Project proj) throws Exception {
		if (proj instanceof MetaModelProject){
			undoIt((MetaModelProject)proj);
		}
		
	}

	public abstract void redoIt(MetaModelProject proj) throws Exception;

	public abstract void undoIt(MetaModelProject proj) throws Exception;
	
	
	public MetaModelProject getProject() {
		return (MetaModelProject) super.getProject();
	}

}
