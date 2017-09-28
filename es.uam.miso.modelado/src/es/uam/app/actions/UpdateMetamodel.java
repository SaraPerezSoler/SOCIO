package es.uam.app.actions;

import projectHistory.impl.UpdateImpl;
import socioProjects.MetamodelProject;

public abstract class UpdateMetamodel extends UpdateImpl implements ProjectAction<MetamodelProject> {
	@Override
	public String getActionName() {
		return "Update";
	}
}
