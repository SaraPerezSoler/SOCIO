package es.uam.app.actions;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.models.CreateObject;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.model.EObjectControl;
import socioProjects.ModelProject;

public abstract class AddModel extends Add<ModelProject> {

	public AddModel(ModelProject p) {
		super(p);

	}

	public static AddModel createAction(EObject obj, ModelProject p) {
		return new CreateObject(p, p.getControl(obj));
	}

	@Override
	public Controlador eobjectToControlador(EObject object) {

		return new EObjectControl(object, getProject().getNLClass(object.eClass()));

	}
}
