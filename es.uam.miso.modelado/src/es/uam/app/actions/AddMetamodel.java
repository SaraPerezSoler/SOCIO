package es.uam.app.actions;

import es.uam.app.projects.MetaModelProject;
import projectHistory.impl.AddImpl;

public abstract class AddMetamodel extends AddImpl implements ProjectAction<MetaModelProject> {
	
	public AddMetamodel(){

	}
	
	@Override
	public String getActionName() {
		return "Create";
	}

}
