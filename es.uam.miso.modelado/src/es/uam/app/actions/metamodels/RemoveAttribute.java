package es.uam.app.actions.metamodels;

import es.uam.app.actions.DeleteMetamodel;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;
import socioProjects.MetamodelProject;

public class RemoveAttribute extends DeleteMetamodel {

	private AttributeControl atr;
	
	private MetamodelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	public RemoveAttribute(MetamodelProject proj, AttributeControl atr) {
		setProject(proj);
		this.atr = atr;
	}

	/*public RemoveAttribute(AttributeControl attributeControl) {
		super(null);
		this.atr = attributeControl;
	}*/

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		
		getProject().removeAttribute(atr, atr.getParent());
		setExecute(true);

	}

	@Override
	public Controlador getObject() {
		doIt();
		return atr;
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		project.unRemoveAttribute(atr);
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		project.removeAttribute(atr, atr.getParent());
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
