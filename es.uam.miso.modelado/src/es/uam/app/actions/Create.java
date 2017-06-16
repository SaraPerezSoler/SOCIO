package es.uam.app.actions;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.projects.Project;

public abstract class Create extends ActionModel {

	public static Create createAction(EObject obj){
		Create create= CreateMetamodel.createAction(obj);
		if (create!=null){
			return create;
		}
		return null;
	}
	
	public Create(Project proj) {
		super(proj);
	}
	
	public String getActionName(){
		return ActionModel.ACTION.CREATE.name();
	}
	
	public String toString() {
		return "Create-> "+getObject().elementType()+" "+ getObject().getName();
	}

}
