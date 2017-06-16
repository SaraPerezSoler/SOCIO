package es.uam.app.actions;

import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.Controlador;

public abstract class ActionModel {
	
	public enum ACTION{
		CREATE, UPDATE, REMOVE
	};

	private boolean execute = false;
	private boolean undo = false;
	private boolean redo = false;
	private Project proj = null;

	public ActionModel(Project proj) {
		if (proj == null) {
			execute = true;
		} else {
			this.proj = proj;
		}
	}

	public abstract void doIt() throws Exception;
	public abstract void undoIt(Project proj) throws Exception;
	public abstract void redoIt(Project proj) throws Exception;
	public abstract String getActionName();
	
	protected void execute() {
		execute = true;
	}
	
	protected void undoIt() {
		undo=true;
	}
	
	protected void redoIt() {
		undo=true;
	}

	protected String startUpperCase(String cad) {
		if (cad == null) {
			return null;
		}
		char[] cadChar = cad.toLowerCase().toCharArray();
		cadChar[0] = Character.toUpperCase(cadChar[0]);
		return new String(cadChar);
	}

	public abstract Controlador getObject();

	
	public abstract String toString();
	public boolean isExecute() {
		return execute;
	}

	public boolean isUndo() {
		return undo;
	}

	public boolean isRedo() {
		return redo;
	}

	public Project getProject() {
		return proj;
	}

}
