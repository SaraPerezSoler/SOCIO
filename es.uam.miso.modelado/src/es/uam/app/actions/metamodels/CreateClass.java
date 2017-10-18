package es.uam.app.actions.metamodels;

import socioProjects.MetamodelProject;
import es.uam.app.actions.AddMetamodel;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.ecore.ClassControl;

public class CreateClass extends AddMetamodel implements IsClass{

	private String class_;
	private UpdateClassAbstract abstract_;	
	
	public CreateClass(MetamodelProject proj, String class_, boolean abs) {
		super(proj);
		this.class_ = class_;
		this.abstract_=new UpdateClassAbstract(proj, this, abs);
	}

	public CreateClass(MetamodelProject p, ClassControl classControl) {
		super(p);
		super.setObject(classControl);
		this.class_=classControl.getName();
		setExecute(true);
		setUndo(false);
	}

	@Override
	public void doIt() throws Exception{
		if (isExecute()){
			return;
		}
		if (getProject().getExactlyClass(class_)==null){
			ClassControl clase=new ClassControl(class_);
			getProject().addClass(clase);
			setObject(clase);
		}else{
			throw new Exception("Problem ocurred in CreateClass: the class "+class_ +"  already exists");
		}
		setExecute(true);
	}

	@Override
	public ClassControl getObject(){
		
		return (ClassControl)super.getObject();
	}

	@Override
	public ClassControl getClassControl() throws Exception {
		doIt();
		return getObject();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unAddClass(getObject());
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().addClass(getObject());
		setUndo(false);
	}

	public UpdateClassAbstract getAbstract(){
		return abstract_;
	}

	
}
