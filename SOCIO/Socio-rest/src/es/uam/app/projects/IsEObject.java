package es.uam.app.projects;

import es.uam.app.projects.emf.model.EObjectControl;

public interface IsEObject extends IsInterface{

	public EObjectControl getEObjectControl()throws Exception;

}
