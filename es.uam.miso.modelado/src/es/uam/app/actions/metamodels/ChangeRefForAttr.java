package es.uam.app.actions.metamodels;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.parser.rules.IsAttribute;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public class ChangeRefForAttr extends UpdateMetamodel implements IsAttribute{

	private RemoveReference remove;
	private CreateAttribute createAttribute;
	
	private AttributeControl new_=null;
	
	public ChangeRefForAttr(MetaModelProject proj,ReferenceControl ref) {
		super(proj);
		this.remove = new RemoveReference (proj,ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), ref.getLowerBound(), ref.getUpperBound());
	}

	public ChangeRefForAttr(MetaModelProject proj,ReferenceControl ref, int min, int max) {
		super(proj);
		this.remove = new RemoveReference (proj, ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), min, max);
	}

	public ChangeRefForAttr(AttributeControl element, ReferenceControl old, AttributeControl new_) {
		super(null);
		this.createAttribute = new CreateAttribute(element);
		this.remove = new RemoveReference(old);
		this.new_=new_;
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		remove.doIt();
		createAttribute.doIt();
	
		new_= createAttribute.getObject().copyObject();
	
		super.execute();
		
	}

	@Override
	public AttributeControl getObject() {
		return createAttribute.getObject();
	}

	@Override
	public Controlador getOld() {
		return remove.getObject();
	}

	@Override
	public Controlador getNew() {
		return new_;
	}

	@Override
	public AttributeControl getAttributeControl() throws Exception {
		return createAttribute.getAttributeControl();
	}

	@Override
	public void undoIt(MetaModelProject proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		createAttribute.undoIt(proj);
		remove.undoIt(proj);
		this.undoIt();
		
		
	}

	@Override
	public void redoIt(MetaModelProject proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		
		remove.redoIt(proj);
		createAttribute.redoIt(proj);
		this.redoIt();
		
	}

}
