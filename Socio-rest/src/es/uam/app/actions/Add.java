package es.uam.app.actions;

import projectHistory.Action;
import projectHistory.impl.ProjectHistoryFactoryImpl;
import socioProjects.Project;

public abstract class Add <T extends Project> extends ProjectAction<T> {

	public Add(T project) {
		super(project);
	}

	@Override
	public String getActionName() {
		return "Create";
	}
	
	@Override
	public Action getAction() {
		projectHistory.Add ret=ProjectHistoryFactoryImpl.eINSTANCE.createAdd();
		ret.setAction(this);
		return ret;
	}
	public String toString() {
		return "Create-> "+getObject().elementType()+" "+ getObject().getName();
	}
	
	
}
