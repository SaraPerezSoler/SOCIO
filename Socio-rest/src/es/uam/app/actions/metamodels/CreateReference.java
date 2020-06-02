package es.uam.app.actions.metamodels;

import es.uam.app.actions.AddMetamodel;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import socioProjects.MetamodelProject;

public class CreateReference extends AddMetamodel implements IsReference {

	private String name;
	private IsClass of = null;

	private int min = 0;
	private int max = -1;
	

	private boolean containment = false;
	
	
	public CreateReference(MetamodelProject proj, String name, IsClass of) {
		super(proj);
		this.name = name;

		this.of = of;

	}

	public CreateReference(MetamodelProject proj, String name, IsClass of, int min, int max) {
		super(proj);
		this.name = name;

		this.of = of;

		this.min = min;
		this.max = max;
	}

	public CreateReference(MetamodelProject proj, String name, IsClass of, boolean containment) {
		super(proj);
		this.name = name;

		this.of = of;

		this.containment = containment;
	}

	public CreateReference(MetamodelProject proj, String name, IsClass of, int min, int max, boolean containment) {
		super(proj);
		this.name = name;

		this.of = of;

		this.min = min;
		this.max = max;
		this.containment = containment;
	}


	public CreateReference(MetamodelProject p, ReferenceControl referenceControl) {
		super(p);
		setObject(referenceControl);
		this.name=referenceControl.getName();
		this.of=referenceControl.getParent();
		this.min=referenceControl.getLowerBound();
		this.max=referenceControl.getUpperBound();
		this.containment=referenceControl.isContainment();
		this.setExecute(true);
		this.setUndo(false);
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}

		ClassControl ofClass=of.getClassControl();
		if (ofClass == null) {
			throw new Exception("Problem ocurred in CreateReference: the class OfClass is not found");
		}
		if (ofClass.getAttrRef(name) == null) {
			ReferenceControl ref = new ReferenceControl(name);
			ref.setLowerBound(min);
			ref.setUpperBound(max);
			ref.setContainment(containment);
			this.getProject().addReference(ref, ofClass);
			setObject(ref);
		}else{
			throw new Exception("Problem ocurred in CreateReference: the reference "+name+" in "+ofClass.getName()+" already exists");
		}

		setExecute(true);

	}


	@Override
	public ReferenceControl getObject() {
		return (ReferenceControl)super.getObject();
	}

	@Override
	public ReferenceControl getReferenceControl() throws Exception {
		doIt();
		return getObject();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unAddReference(getObject(), getObject().getParent());
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		
		getProject().addReference(getObject(), of.getClassControl());
		setUndo(false);
	}

	@Override
	public int getMin() {
		return min;
	}

	@Override
	public int getMax() {
		return max;
	}

}
