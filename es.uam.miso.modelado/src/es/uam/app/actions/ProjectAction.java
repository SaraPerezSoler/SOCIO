package es.uam.app.actions;

import es.uam.app.projects.LocalProjects;
import es.uam.app.projects.ecore.Controlador;


public interface ProjectAction<T extends LocalProjects> {
	

	
	public void setProject(T proj);
	public T getProject();
	
	
	public Controlador getObject();
}
