package es.uam.app.actions;


import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.models.RemoveObject;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.model.EObjectControl;
import socioProjects.ModelProject;

public abstract class DeleteModel extends Delete<ModelProject>{


	public DeleteModel(ModelProject p) {
		super(p);
	}	

	public static DeleteModel createAction(ModelProject p, EObject obj){
		return new RemoveObject(p, p.getControl(obj), true);

	}
	
	@Override
	public Controlador eobjectToControlador(EObject object) {
		return new EObjectControl(object, getProject().getNLClass(object.eClass()));
	}
	
}
