package es.uam.app.actions;


import projectHistory.impl.DeleteImpl;
import socioProjects.MetamodelProject;

public abstract class DeleteMetamodel extends DeleteImpl implements ProjectAction<MetamodelProject>{


	public DeleteMetamodel() {

	}	
	
	@Override
	public String getActionName() {
		return "Remove";
	}
	
}
