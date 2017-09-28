package es.uam.app.actions.metamodels;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.IsAttribute;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public class ChangeRefForAttr extends UpdateMetamodel implements IsAttribute{

	private RemoveReference remove;
	private CreateAttribute createAttribute;
	
	private AttributeControl new_=null;
	
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	public ChangeRefForAttr(MetamodelProject proj,ReferenceControl ref) {
		super();
		this.remove = new RemoveReference (proj,ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), ref.getLowerBound(), ref.getUpperBound());
	}

	public ChangeRefForAttr(MetamodelProject proj,ReferenceControl ref, int min, int max) {
		super();
		this.remove = new RemoveReference (proj, ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), min, max);
	}

	/*public ChangeRefForAttr(AttributeControl element, ReferenceControl old, AttributeControl new_) {
		super();
		this.createAttribute = new CreateAttribute(element);
		this.remove = new RemoveReference(old);
		this.new_=new_;
	}*/

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		remove.doIt();
		createAttribute.doIt();
	
		new_= createAttribute.getObject().copyObject();
	
		setExecute(true);
		
	}

	public AttributeControl getObject() {
		return createAttribute.getObject();
	}

	@Override
	public EObject getOld() {
		return remove.getObject().getObject();
	}

	@Override
	public EObject getNew() {
		return new_.getObject();
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
		
	}

	@Override
	public MetamodelProject getProject() {
		return remove.getProject();
	}

	@Override
	public boolean isUndo() {
		return isUndo;
	}

	@Override
	public boolean isExecute() {
		return isExecute;
	}


	public void setUndo(boolean isUndo) {
		this.isUndo = isUndo;
	}

	public void setExecute(boolean isExecute) {
		this.isExecute = isExecute;
	}

}
