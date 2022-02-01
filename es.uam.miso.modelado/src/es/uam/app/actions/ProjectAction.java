package es.uam.app.actions;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.projects.ecore.Controlador;
import projectHistory.Action;
import socioProjects.Project;


public abstract class ProjectAction<T extends Project>{
	
	private T project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	
	private Controlador object;
	public ProjectAction(T project) {
		super();
		this.project = project;
	}

	public void setProject(T proj){
		project=proj;
	}

	public T getProject(){
		return project;
	}
	
	public abstract Controlador eobjectToControlador(EObject object);
	
	public abstract String getActionName();

	public abstract void redoIt() throws Exception;

	public abstract void undoIt()  throws Exception;
	

	public abstract void doIt() throws Exception;
	
	public boolean isUndo() {
		return isUndo;
	}

	public void setUndo(boolean isUndo) {
		this.isUndo = isUndo;
	}
	public boolean isExecute() {
		return isExecute;
	}

	public void setExecute(boolean isExecute) {
		this.isExecute = isExecute;
	}

	public Controlador getObject() {
		return object;
	}

	public void setObject(Controlador object) {
		this.object = object;
	}
	
	public EObject getEObject() {
		return object.getObject();
	}

	public abstract Action getAction();
	
	public abstract String toString();
	
	
}
