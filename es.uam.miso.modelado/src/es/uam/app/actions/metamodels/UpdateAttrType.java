package es.uam.app.actions.metamodels;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.ecore.AttributeControl;
import socioProjects.MetamodelProject;

public class UpdateAttrType extends UpdateMetamodel{

	private IsAttribute attr=null;
	private String type;
	
	
	public UpdateAttrType(MetamodelProject proj, IsAttribute attr, String type) {
		super(proj);
		this.attr=attr;
		this.type = type;
	}
	public UpdateAttrType(MetamodelProject p, AttributeControl attributeControl, AttributeControl oldC,AttributeControl newC) {
		super(p);
		setObject(attributeControl);
		setNew(newC);
		setOld(oldC);
		this.attr=attributeControl;
		this.setExecute(true);
		
	}
	
	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		AttributeControl attControl=attr.getAttributeControl();
		if (attControl==null){
			throw new Exception("Problem ocurred in UpdateAttrType: the attibute is not found");
		}
		setOld(attControl.copyObject());
	
		attControl.setType(type);
		
		setNew(attControl.copyObject());
		setObject(attControl);
		
		setExecute(true);
	}

	
	@Override
	public AttributeControl getObject() {
		return (AttributeControl)super.getObject();
	}
	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getObject().setType(((AttributeControl) getOldC()).getType());
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		this.getObject().setType(((AttributeControl)getNewC()).getType());
		
		setUndo(false);
	}
}
