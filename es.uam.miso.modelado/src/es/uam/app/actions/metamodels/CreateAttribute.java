package es.uam.app.actions.metamodels;

import es.uam.app.actions.AddMetamodel;
import es.uam.app.projects.ecore.IsAttribute;
import es.uam.app.projects.ecore.IsClass;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;

public class CreateAttribute extends AddMetamodel implements IsAttribute {

	private String name;
	private IsClass of = null;
	private int min = 0, max = -1;

	private AttributeControl object = null;

	private MetaModelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;

	public CreateAttribute(MetaModelProject proj, String name, IsClass of, int min, int max) {
		super();
		this.project=proj;
		this.name = name;
		
		this.of =of;
	
		this.min = min;
		this.max = max;
	}

	public CreateAttribute(MetaModelProject proj, String name, IsClass of) {
		super();
		
		this.project=proj;
		this.name = name;
		
		this.of = of;
		
	}

	/*public CreateAttribute(AttributeControl attributeControl) {
		super(null);
		this.object=attributeControl;
		of= attributeControl.getParent();
	}*/

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}
		ClassControl ofClass=of.getClassControl();
		if (ofClass == null) {
			throw new Exception("Problem ocurred in CreateAttribute: the class OfClass is not found");
		}

		if (ofClass.getAttrRef(name) == null) {
			AttributeControl attr = new AttributeControl(name);
			attr.setLowerBound(min);
			attr.setUpperBound(max);
			getProject().addAttribute(attr, ofClass);
			object = attr;
		}else{
			throw new Exception("Problem ocurred in CreateAttribute: the attribute "+name+" in "+ofClass.getName()+" already exists");
		}
		setExecute(true);
	}


	@Override
	public AttributeControl getObject() {
		
		return object;
	}

	@Override
	public AttributeControl getAttributeControl() throws Exception {
		doIt();
		return getObject();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		project.unAddAttribute(object, object.getParent());
		setUndo(true);
		
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		project.addAttribute(object, of.getClassControl());
		
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
