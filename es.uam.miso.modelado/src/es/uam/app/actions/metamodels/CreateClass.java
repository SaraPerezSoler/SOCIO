package es.uam.app.actions.metamodels;


import es.uam.app.actions.CreateMetamodel;
import es.uam.app.parser.rules.IsClass;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;

public class CreateClass extends CreateMetamodel implements IsClass{

	private String class_;
	private ClassControl object=null;
	private boolean abstract_=false;	
	
	public CreateClass(ClassControl object) {
		super(null);
		this.object=object;
	}
	
	public CreateClass(MetaModelProject proj, String class_, boolean abs) {
		super(proj);
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
	public void undoIt(MetaModelProject proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unAddClass(object);
		super.undoIt();
	}

	@Override
	public void redoIt(MetaModelProject proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.addClass(getObject());
		super.redoIt();
	}
	
	
}
