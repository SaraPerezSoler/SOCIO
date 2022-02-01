package es.uam.app.actions.metamodels;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.DeleteMetamodel;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import socioProjects.MetamodelProject;

public class RemoveReference extends DeleteMetamodel{


	public RemoveReference(MetamodelProject  proj, ReferenceControl ref) {
		super(proj);
		setObject(ref);
	}

	public RemoveReference(MetamodelProject p, ReferenceControl referenceControl, boolean isExecute) {
		super(p);
		setObject(referenceControl);
		this.setExecute(isExecute);
	}

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		
		getProject().removeReference(getObject(), getObject().getParent());
		setExecute(true);

	}

	@Override
	public ReferenceControl getObject() {
		return (ReferenceControl)super.getObject();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unRemoveReference(getObject());
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().removeReference(getObject(), getObject().getParent());
		setUndo(false);
	}

	@Override
	public Controlador eobjectToControlador(EObject object) {
		
		return null;
	}	
}
