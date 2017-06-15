package es.uam.app.actions.metamodels;



import es.uam.app.actions.Update;
import es.uam.app.parser.rules.IsReference;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public class ChangeAttrForRef extends Update implements IsReference{

	private RemoveAttribute remove;
	private CreateReference createReference;
	
	private ReferenceControl new_;
	
	public ChangeAttrForRef(Project proj, AttributeControl attr) {
		super(proj);
		this.remove = new RemoveAttribute(proj, attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(), attr.getLowerBound(), attr.getUpperBound());
	}

	public ChangeAttrForRef(Project proj,AttributeControl attr, int min, int max) {
		super(proj);
		this.remove = new RemoveAttribute(proj, attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(),min, max);
	}
	
	public ChangeAttrForRef(Project proj, AttributeControl attr, int min, int max, boolean containment) {
		super(proj);
		this.remove = new RemoveAttribute(proj,attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(),min, max, containment);
	}

	public ChangeAttrForRef(ReferenceControl element, AttributeControl old, ReferenceControl new_) {
		super (null);
		this.remove = new RemoveAttribute(old);
		this.createReference = new CreateReference(element);
		this.new_=new_;
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		remove.doIt();
		createReference.doIt();
		
		
		new_= createReference.getObject().copyObject();
		
		super.execute();
		
	}

	@Override
	public ReferenceControl getObject() {
		return createReference.getObject();
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
	public ReferenceControl getReferenceControl() {
		return getObject();
	}

	@Override
	public void undoIt(Project proj) {
		if (isUndo()|| !isExecute()){
			return;
		}
		createReference.undoIt(proj);
		remove.undoIt(proj);
		super.undoIt();
		
		
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		
		remove.redoIt(proj);
		createReference.redoIt(proj);
		super.redoIt();
		
	}

	

}
