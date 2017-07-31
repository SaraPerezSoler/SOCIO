package es.uam.app.projects;

import java.util.List;

import projectHistory.Action;

public interface FileProject {
	
	public void save();
	public String createUML(List<Action> actions);
	
}
