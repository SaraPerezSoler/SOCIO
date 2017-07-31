package es.uam.app.actions;

import es.uam.app.projects.MetaModelProject;
import projectHistory.impl.UpdateImpl;

public abstract class UpdateMetamodel extends UpdateImpl implements ProjectAction<MetaModelProject> {
	@Override
	public String getActionName() {
		return "Update";
	}
}
