package es.uam.app.actions;

import projectHistory.Action;
import projectHistory.impl.ProjectHistoryFactoryImpl;
import socioProjects.Project;

public abstract class Delete <T extends Project> extends ProjectAction<T> {

	public Delete(T project) {
		super(project);
	}

	@Override
	public String getActionName() {
		return "Delete";
	}
	
	@Override
	public Action getAction() {
		projectHistory.Delete ret=ProjectHistoryFactoryImpl.eINSTANCE.createDelete();
		ret.setAction(this);
		return ret;
	}
	
	public String toString(){
		return "Remove-> "+getObject();
	}
}
