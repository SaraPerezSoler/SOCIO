package es.uam.app.actions.metamodels;



import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.actions.metamodels.CreateReference;
import es.uam.app.actions.metamodels.RemoveAttribute;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import socioProjects.MetamodelProject;

public class ChangeAttrForRef extends UpdateMetamodel implements IsReference{

	private RemoveAttribute remove;
	private CreateReference createReference;

	public ChangeAttrForRef(MetamodelProject proj, AttributeControl attr) {
		super(proj);
		this.remove = new RemoveAttribute(proj, attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(), attr.getLowerBound(), attr.getUpperBound());
	}

	public ChangeAttrForRef(MetamodelProject proj,AttributeControl attr, int max) {
		super(proj);
		this.remove = new RemoveAttribute(proj, attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(),attr.getLowerBound(), max);
	}
	
	public ChangeAttrForRef(MetamodelProject proj, AttributeControl attr, int max, boolean containment) {
		super(proj);
		this.remove = new RemoveAttribute(proj,attr);
		this.createReference = new CreateReference(proj, attr.getName(), attr.getParent(),attr.getLowerBound(), max, containment);
	}


	public ChangeAttrForRef(MetamodelProject p, ReferenceControl referenceControl, AttributeControl oldC,
			ReferenceControl newC) {
		super(p);
		this.remove=new RemoveAttribute(p, oldC,true);
		this.createReference= new CreateReference(p, referenceControl);
		setNew(newC);
		setOld(oldC);
		setObject(referenceControl);
		this.setExecute(true);
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		remove.doIt();
		createReference.doIt();
		
		setObject(createReference.getObject());
		setOld(remove.getObject().copyObject());
		setNew(createReference.getObject().copyObject());
		
		setExecute(true);
		
	}
	

	@Override
	public ReferenceControl getReferenceControl() {
		return (ReferenceControl)getObject();
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
	public void setProject(MetamodelProject proj) {
		remove.setProject(proj);
		createReference.setProject(proj);
		super.setProject(proj);
	}

	

	@Override
	public void setUndo(boolean isUndo) {
		this.createReference.setUndo(isUndo);
		this.remove.setUndo(isUndo);
		super.setUndo(isUndo);
	}

	

	public void setExecute(boolean isExecute) {
		this.createReference.setExecute(isExecute);
		this.remove.setExecute(isExecute);
		super.setExecute(isExecute);
	}

	@Override
	public int getMin() {
		return createReference.getMin();
	}

	@Override
	public int getMax() {
		return createReference.getMax();
	}

}
