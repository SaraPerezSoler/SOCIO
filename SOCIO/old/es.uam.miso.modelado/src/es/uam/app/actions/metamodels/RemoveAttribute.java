package es.uam.app.actions.metamodels;

import es.uam.app.actions.DeleteMetamodel;
import es.uam.app.projects.ecore.AttributeControl;
import socioProjects.MetamodelProject;

public class RemoveAttribute extends DeleteMetamodel {

	
	public RemoveAttribute(MetamodelProject proj, AttributeControl atr) {
		super(proj);
		setObject(atr);
	}

	public RemoveAttribute(MetamodelProject p, AttributeControl attributeControl, boolean isExecute) {
		super(p);
		setObject(attributeControl);
		setExecute(isExecute);
	}

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		
		getProject().removeAttribute(getObject(), getObject().getParent());
		setExecute(true);

	}

	@Override
	public AttributeControl getObject() {
		return (AttributeControl)super.getObject();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unRemoveAttribute(getObject());
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().removeAttribute(getObject(), getObject().getParent());
		setUndo(false);
	}

}
