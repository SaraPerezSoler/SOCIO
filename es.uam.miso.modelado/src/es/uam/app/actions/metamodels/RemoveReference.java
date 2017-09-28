package es.uam.app.actions.metamodels;

import es.uam.app.actions.DeleteMetamodel;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public class RemoveReference extends DeleteMetamodel {

	private ReferenceControl ref;

	private MetamodelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	public RemoveReference(MetamodelProject  proj, ReferenceControl ref) {
		setProject(proj);
		this.ref = ref;
	}

	/*public RemoveReference(ReferenceControl referenceControl) {
		super(null);
		this.ref = referenceControl;
	}*/

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		
		getProject().removeReference(ref, ref.getParent());
		setExecute(true);

	}

	@Override
	public Controlador getObject() {
		doIt();
		return ref;
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		project.unRemoveReference(ref);
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		project.removeReference(ref, ref.getParent());
		setUndo(false);
	}

	public MetamodelProject getProject() {
		return project;
	}

	public void setProject(MetamodelProject project) {
		this.project = project;
	}

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
}
