package es.uam.app.actions;

import es.uam.app.projects.ecore.Controlador;
import socioProjects.Project;


public interface ProjectAction<T extends Project> {
	

	
	public void setProject(T proj);
	public T getProject();
	
	
	public Controlador getObject();
}
