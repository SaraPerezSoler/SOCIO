package es.uam.app.actions;

import projectHistory.Action;
import projectHistory.impl.projectHistoryFactoryImpl;
import socioProjects.Project;

public abstract class Add <T extends Project> extends ProjectAction<T> {

	public Add(T project) {
		super(project);
	}

	@Override
	public String getActionName() {
		return "Add";
	}
	
	@Override
	public Action getAction() {
		projectHistory.Add ret=projectHistoryFactoryImpl.eINSTANCE.createAdd();
		ret.setAction(this);
		return ret;
	}
	
	
}
