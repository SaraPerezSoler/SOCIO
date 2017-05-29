package es.uam.app.actions;

import es.uam.app.parser.rules.IsAttribute;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public class ChangeRefForAttr extends Update implements IsAttribute{

	private RemoveReference remove;
	private CreateAttribute createAttribute;
	
	private AttributeControl new_=null;
	
	public ChangeRefForAttr(Project proj,ReferenceControl ref) {
		super(proj);
		this.remove = new RemoveReference (proj,ref);
		this.createAttribute = new CreateAttribute(proj,ref.getName(), ref.getParent(), ref.getLowerBound(), ref.getUpperBound());
	}

	public ChangeRefForAttr(Project proj,ReferenceControl ref, int min, int max) {
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
	public void undoIt(Project proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		createAttribute.undoIt(proj);
		remove.undoIt(proj);
		this.undoIt();
		
		
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		
		remove.redoIt(proj);
		createAttribute.redoIt(proj);
		this.redoIt();
		
	}

}
