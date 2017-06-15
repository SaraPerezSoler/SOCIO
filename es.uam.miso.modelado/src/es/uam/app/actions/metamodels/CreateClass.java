package es.uam.app.actions.metamodels;


import es.uam.app.actions.Create;
import es.uam.app.parser.rules.IsClass;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;

public class CreateClass extends Create implements IsClass{

	private String class_;
	private ClassControl object=null;
	private boolean abstract_=false;	
	
	public CreateClass(ClassControl object) {
		super(null);
		this.object=object;
	}
	
	public CreateClass(Project proj, String class_, boolean abs) {
		super(proj);
		this.class_ = class_;
		this.abstract_=abs;
	}

	@Override
	public void doIt() throws Exception{
		if (isExecute()){
			return;
		}
		if (proj.getExactlyClass(class_)==null){
			ClassControl clase=new ClassControl(class_);
			clase.setAbstract(abstract_);
			proj.addClass(clase);
			object=clase;
		}else{
			throw new Exception("Problem ocurred in CreateClass: the class "+class_ +"  already exists");
		}
		super.execute();
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
	public void undoIt(Project proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unAddClass(object);
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.addClass(getObject());
		super.redoIt();
	}
	
	
}
