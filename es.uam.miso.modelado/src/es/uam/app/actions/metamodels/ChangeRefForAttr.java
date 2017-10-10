package es.uam.app.actions.metamodels;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.actions.metamodels.CreateAttribute;
import es.uam.app.actions.metamodels.RemoveReference;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public class ChangeRefForAttr extends UpdateMetamodel implements IsAttribute{

	private RemoveReference remove;
	private CreateAttribute createAttribute;
	
	public ChangeRefForAttr(MetamodelProject proj,ReferenceControl ref) {
		super(proj);
		this.remove = new RemoveReference (proj,ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), ref.getLowerBound(), ref.getUpperBound());
	}

	public ChangeRefForAttr(MetamodelProject proj,ReferenceControl ref, int min, int max) {
		super(proj);
		this.remove = new RemoveReference (proj, ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), min, max);
	}


	public ChangeRefForAttr(MetamodelProject p, AttributeControl attributeControl, ReferenceControl oldC, AttributeControl newC) {
		super(p);
		this.createAttribute= new CreateAttribute(p, attributeControl);
		this.remove= new RemoveReference(p, oldC, true);
		setOld(oldC);
		setNew(newC);
		setObject(attributeControl);
		this.setExecute(true);
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		remove.doIt();
		createAttribute.doIt();
	
		setObject(createAttribute.getObject());
		setOld(remove.getObject().copyObject());
		setNew(createAttribute.getObject().copyObject());
	
		setExecute(true);
		
	}


	@Override
	public AttributeControl getAttributeControl() throws Exception {
		return createAttribute.getAttributeControl();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		createAttribute.undoIt();
		remove.undoIt();
		this.setUndo(true);
		
		
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		
		remove.redoIt();
		createAttribute.redoIt();
		setUndo(false);
		
	}

	@Override
	public void setProject(MetamodelProject proj) {
		this.createAttribute.setProject(proj);
		this.remove.setProject(proj);
		super.setProject(proj);
	}
	
	@Override
	public void setUndo(boolean isUndo) {
		this.createAttribute.setUndo(isUndo);
		this.remove.setUndo(isUndo);
		super.setUndo(isUndo);
	}

	

	public void setExecute(boolean isExecute) {
		this.createAttribute.setExecute(isExecute);
		this.remove.setExecute(isExecute);
		super.setExecute(isExecute);
	}

}
