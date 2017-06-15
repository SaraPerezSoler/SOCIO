package es.uam.app.actions.metamodels;

import es.uam.app.actions.Create;
import es.uam.app.parser.rules.IsAttribute;
import es.uam.app.parser.rules.IsClass;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;

public class CreateAttribute extends Create implements IsAttribute {

	private String name;
	private IsClass of = null;
	private int min = 0, max = -1;

	private AttributeControl object = null;

	

	public CreateAttribute(Project proj, String name, IsClass of, int min, int max) {
		super(proj);
		this.name = name;
		
		this.of =of;
	
		this.min = min;
		this.max = max;
	}

	public CreateAttribute(Project proj, String name, IsClass of) {
		super(proj);
		this.name = name;
		
		this.of = of;
		
	}

	public CreateAttribute(AttributeControl attributeControl) {
		super(null);
		this.object=attributeControl;
		of= attributeControl.getParent();
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
			proj.addAttribute(attr, ofClass);
			object = attr;
		}else{
			throw new Exception("Problem ocurred in CreateAttribute: the attribute "+name+" in "+ofClass.getName()+" already exists");
		}
		super.execute();
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
	public void undoIt(Project proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unAddAttribute(object, object.getParent());
		super.undoIt();
		
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.addAttribute(object, of.getClassControl());
		
		super.redoIt();
	}

}
