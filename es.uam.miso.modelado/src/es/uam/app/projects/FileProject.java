package es.uam.app.projects;

import java.util.List;

import es.uam.app.actions.ActionModel;

public interface FileProject {
	
	public void save();
	public String createUML(List<ActionModel> actions);
	
}
