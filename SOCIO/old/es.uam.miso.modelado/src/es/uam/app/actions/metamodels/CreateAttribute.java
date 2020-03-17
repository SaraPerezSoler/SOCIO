package es.uam.app.actions.metamodels;

import socioProjects.MetamodelProject;
import es.uam.app.actions.AddMetamodel;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;

public class CreateAttribute extends AddMetamodel implements IsAttribute {

	private String name;
	private IsClass of = null;
	private int min = 0, max = -1;


	public CreateAttribute(MetamodelProject proj, String name, IsClass of, int min, int max) {
		super(proj);
		this.name = name;
		this.of =of;
		this.min = min;
		this.max = max;
	}

	public CreateAttribute(MetamodelProject proj, String name, IsClass of) {
		super(proj);
		this.name = name;
		this.of = of;
		
	}

	/*public CreateAttribute(AttributeControl attributeControl) {
		super(null);
		this.object=attributeControl;
		of= attributeControl.getParent();
	}*/

	public CreateAttribute(MetamodelProject p, AttributeControl attributeControl) {
		super(p);
		setObject(attributeControl);
		this.of=attributeControl.getParent();
		this.name=attributeControl.getName();
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
			throw new Exception("Problem ocurred in CreateAttribute: the class OfClass is not found");
		}

		if (ofClass.getAttrRef(name) == null) {
			AttributeControl attr = new AttributeControl(name);
			attr.setLowerBound(min);
			attr.setUpperBound(max);
			getProject().addAttribute(attr, ofClass);
			setObject(attr);
		}else{
			throw new Exception("Problem ocurred in CreateAttribute: the attribute "+name+" in "+ofClass.getName()+" already exists");
		}
		setExecute(true);
	}


	@Override
	public AttributeControl getObject() {
		
		return (AttributeControl)super.getObject();
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
		
		getProject().unAddAttribute(getObject(), getObject().getParent());
		setUndo(true);
		
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().addAttribute(getObject(), of.getClassControl());
		
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
