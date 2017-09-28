package es.uam.app.actions;


import projectHistory.impl.AddImpl;
import socioProjects.MetamodelProject;

public abstract class AddMetamodel extends AddImpl implements ProjectAction<MetamodelProject> {
	
	public AddMetamodel(){

	}
	
	@Override
	public String getActionName() {
		return "Create";
	}

}
