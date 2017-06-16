package es.uam.app.actions.metamodels;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.parser.rules.IsAttribute;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;

public class UpdateAttrType extends UpdateMetamodel{

	private IsAttribute attr=null;

	private String type;
	
	private AttributeControl old=null;
	private AttributeControl new_=null;
	private AttributeControl object=null;
	
	public UpdateAttrType(MetaModelProject proj, IsAttribute attr, String type) {
		super(proj);
	
		this.attr=attr;
		
		this.type = type;
	}
	public UpdateAttrType(AttributeControl object, AttributeControl old, AttributeControl new_) {
		super(null);
		this.object=object;
		this.old=old;
		this.new_=new_;
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
		old= attControl.copyObject();
	
		attControl.setType(type);
		
		new_= attControl.copyObject();
		object=attControl;
		
		super.execute();
	}

	
	@Override
	public AttributeControl getObject() {
		return object;
	}
	@Override
	public Controlador getOld() {
		return old;
	}
	@Override
	public Controlador getNew() {
		return new_;
	}
	
	@Override
	public void undoIt(MetaModelProject proj) throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		object.setType(old.getType());
		super.undoIt();
	}

	@Override
	public void redoIt(MetaModelProject proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		this.object.setType(new_.getType());
		
		super.redoIt();
	}

}
