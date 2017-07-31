package es.uam.app.actions.metamodels;



import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.IsReference;
import es.uam.app.projects.ecore.ReferenceControl;

public class ChangeAttrForRef extends UpdateMetamodel implements IsReference{

	private RemoveAttribute remove;
	private CreateReference createReference;
	
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	private ReferenceControl new_;
	
	public ChangeAttrForRef(MetaModelProject proj, AttributeControl attr) {
		super();
		this.remove = new RemoveAttribute(proj, attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(), attr.getLowerBound(), attr.getUpperBound());
	}

	public ChangeAttrForRef(MetaModelProject proj,AttributeControl attr, int min, int max) {
		super();
		this.remove = new RemoveAttribute(proj, attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(),min, max);
	}
	
	public ChangeAttrForRef(MetaModelProject proj, AttributeControl attr, int min, int max, boolean containment) {
		super();
		this.remove = new RemoveAttribute(proj,attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(),min, max, containment);
	}

	/*public ChangeAttrForRef(ReferenceControl element, AttributeControl old, ReferenceControl new_) {
		super ();
		this.remove = new RemoveAttribute(old);
		this.createReference = new CreateReference(element);
		this.new_=new_;
	}*/

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		remove.doIt();
		createReference.doIt();
		
		
		new_= createReference.getObject().copyObject();
		
		setExecute(true);
		
	}
	
	

	public ReferenceControl getObject() {
		return createReference.getObject();
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
	public ReferenceControl getReferenceControl() {
		return getObject();
	}

	@Override
	public void undoIt() {
		if (isUndo()|| !isExecute()){
			return;
		}
		createReference.undoIt();
		remove.undoIt();
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		
		remove.redoIt();
		createReference.redoIt();
		setUndo(false);
	}

	

	@Override
	public void setProject(MetaModelProject proj) {
		remove.setProject(proj);
		createReference.setProject(proj);
	}

	

	@Override
	public MetaModelProject getProject() {
		return remove.getProject();
		
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
