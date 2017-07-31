package es.uam.app.actions.metamodels;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.IsAttribute;

public class UpdateAttrType extends UpdateMetamodel{

	private IsAttribute attr=null;

	private String type;
	
	private AttributeControl old=null;
	private AttributeControl new_=null;
	private AttributeControl object=null;
	
	private MetaModelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	public UpdateAttrType(MetaModelProject proj, IsAttribute attr, String type) {
		setProject(proj);
	
		this.attr=attr;
		
		this.type = type;
	}
	/*public UpdateAttrType(AttributeControl object, AttributeControl old, AttributeControl new_) {
		super(null);
		this.object=object;
		this.old=old;
		this.new_=new_;
	}*/
	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		AttributeControl attControl=attr.getAttributeControl();
		if (attControl==null){
			throw new Exception("Problem ocurred in UpdateAttrType: the attibute is not found");
		}
		old= attControl.copyObject();
	
		attControl.setType(type);
		
		new_= attControl.copyObject();
		object=attControl;
		
		setExecute(true);
	}

	
	@Override
	public AttributeControl getObject() {
		return object;
	}
	@Override
	public EObject getOld() {
		return old.getObject();
	}
	@Override
	public EObject getNew() {
		return new_.getObject();
	}
	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		object.setType(old.getType());
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		this.object.setType(new_.getType());
		
		setUndo(false);
	}
	public MetaModelProject getProject() {
		return project;
	}
	public void setProject(MetaModelProject project) {
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
