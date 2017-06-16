package es.uam.app.actions.metamodels;

import es.uam.app.actions.CreateMetamodel;
import es.uam.app.parser.rules.IsClass;
import es.uam.app.parser.rules.IsReference;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.ReferenceControl;

public class CreateReference extends CreateMetamodel implements IsReference {

	private String name;
	private IsClass of = null;

	private int min = 0;
	private int max = -1;
	private ReferenceControl object;

	private boolean containment = false;

	public CreateReference(MetaModelProject proj, String name, IsClass of) {
		super(proj);
		this.name = name;

		this.of = of;

	}

	public CreateReference(MetaModelProject proj, String name, IsClass of, int min, int max) {
		super(proj);
		this.name = name;

		this.of = of;

		this.min = min;
		this.max = max;
	}

	public CreateReference(MetaModelProject proj, String name, IsClass of, boolean containment) {
		super(proj);
		this.name = name;

		this.of = of;

		this.containment = containment;
	}

	public CreateReference(MetaModelProject proj, String name, IsClass of, int min, int max, boolean containment) {
		super(proj);
		this.name = name;

		this.of = of;

		this.min = min;
		this.max = max;
		this.containment = containment;
	}

	public CreateReference(ReferenceControl referenceControl) {
		super(null);
		this.object = referenceControl;
		this.of=referenceControl.getParent();
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
			object = ref;
		}else{
			throw new Exception("Problem ocurred in CreateReference: the reference "+name+" in "+ofClass.getName()+" already exists");
		}

		super.execute();

	}


	@Override
	public ReferenceControl getObject() {
		
		return object;
	}

	@Override
	public ReferenceControl getReferenceControl() throws Exception {
		doIt();
		return getObject();
	}

	@Override
	public void undoIt(MetaModelProject proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unAddReference(object, object.getParent());
		super.undoIt();
	}

	@Override
	public void redoIt(MetaModelProject proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		
		proj.addReference(object, of.getClassControl());
		super.redoIt();
	}

}
