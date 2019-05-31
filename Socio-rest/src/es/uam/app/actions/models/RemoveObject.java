package es.uam.app.actions.models;

import es.uam.app.actions.DeleteModel;
import es.uam.app.projects.emf.model.EObjectControl;
import socioProjects.ModelProject;

public class RemoveObject extends DeleteModel {

	public RemoveObject(ModelProject proj, EObjectControl objectControl) {
		super(proj);
		setObject(objectControl);
	}
	
	public  RemoveObject(ModelProject proj, EObjectControl objectControl, boolean isExecute) {
		super(proj);
		setObject(objectControl);
		setExecute(isExecute);
	}
	
	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		getProject().removeObject(getObject());
		setExecute(true);
	} 
	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unRemoveObject(getObject());
		setUndo(true);

	}
	
	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().removeObject(getObject());
		setUndo(false);

	}
	
	public EObjectControl getObject() {
		return (EObjectControl)super.getObject();
	}





}
