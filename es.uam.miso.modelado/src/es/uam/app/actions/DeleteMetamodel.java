package es.uam.app.actions;


import es.uam.app.projects.MetaModelProject;
import projectHistory.impl.DeleteImpl;

public abstract class DeleteMetamodel extends DeleteImpl implements ProjectAction<MetaModelProject>{


	public DeleteMetamodel() {

	}	
	
	@Override
	public String getActionName() {
		return "Remove";
	}
	
}
