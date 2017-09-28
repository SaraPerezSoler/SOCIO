package es.uam.app.actions.metamodels;


import es.uam.app.actions.AddMetamodel;
import es.uam.app.projects.ecore.IsClass;
import socioProjects.MetamodelProject;
import es.uam.app.projects.ecore.ClassControl;

public class CreateClass extends AddMetamodel implements IsClass{

	private String class_;
	private ClassControl object=null;
	private boolean abstract_=false;	
	
	/*public CreateClass(ClassControl object) {
		super(null);
		this.object=object;
	}*/
	
	private MetamodelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	public CreateClass(MetamodelProject proj, String class_, boolean abs) {
		setProject(proj);
		this.class_ = class_;
		this.abstract_=abs;
	}

	@Override
	public void doIt() throws Exception{
		if (isExecute()){
			return;
		}
		if (getProject().getExactlyClass(class_)==null){
			ClassControl clase=new ClassControl(class_);
			clase.setAbstract(abstract_);
			getProject().addClass(clase);
			object=clase;
		}else{
			throw new Exception("Problem ocurred in CreateClass: the class "+class_ +"  already exists");
		}
		setExecute(true);
	}

	@Override
	public ClassControl getObject(){
		
		return object;
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
		
		project.unAddClass(object);
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		project.addClass(getObject());
		setUndo(false);
	}

	public MetamodelProject getProject() {
		return project;
	}

	public void setProject(MetamodelProject project) {
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
