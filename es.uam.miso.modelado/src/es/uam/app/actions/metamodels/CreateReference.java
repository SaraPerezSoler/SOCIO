package es.uam.app.actions.metamodels;

import es.uam.app.actions.AddMetamodel;
import es.uam.app.projects.ecore.IsClass;
import es.uam.app.projects.ecore.IsReference;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.ReferenceControl;

public class CreateReference extends AddMetamodel implements IsReference {

	private String name;
	private IsClass of = null;

	private int min = 0;
	private int max = -1;
	private ReferenceControl object;

	private boolean containment = false;

	private MetaModelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	public CreateReference(MetaModelProject proj, String name, IsClass of) {
		setProject(proj);
		this.name = name;

		this.of = of;

	}

	public CreateReference(MetaModelProject proj, String name, IsClass of, int min, int max) {
		setProject(proj);
		this.name = name;

		this.of = of;

		this.min = min;
		this.max = max;
	}

	public CreateReference(MetaModelProject proj, String name, IsClass of, boolean containment) {
		setProject(proj);
		this.name = name;

		this.of = of;

		this.containment = containment;
	}

	public CreateReference(MetaModelProject proj, String name, IsClass of, int min, int max, boolean containment) {
		setProject(proj);
		this.name = name;

		this.of = of;

		this.min = min;
		this.max = max;
		this.containment = containment;
	}

	/*public CreateReference(ReferenceControl referenceControl) {
		super(null);
		this.object = referenceControl;
		this.of=referenceControl.getParent();
	}*/

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

		setExecute(true);

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
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		project.unAddReference(object, object.getParent());
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		
		project.addReference(object, of.getClassControl());
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
