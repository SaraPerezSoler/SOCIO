package es.uam.app.actions;

import es.uam.app.parser.rules.IsClass;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;

public class UpdateClassAbstract extends Update {

	private IsClass class_ = null;
	private boolean abstract_=false;
	

	private ClassControl old=null;
	private ClassControl new_=null;
	private ClassControl object=null;
	
	public UpdateClassAbstract(Project proj, IsClass class_, boolean abstract_) {
		super(proj);
		this.class_ =  class_;
		
		this.abstract_=abstract_;
		
	}

	public UpdateClassAbstract(ClassControl object, ClassControl old, ClassControl new_) {
		super(null);
		this.object=object;
		this.old=old;
		this.new_=new_;
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}
		
		ClassControl classClassControl=class_.getClassControl();
		if (classClassControl == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the class is not found");
		}
		
		old=classClassControl.copyObject();
		classClassControl.setAbstract(abstract_);
		new_=classClassControl.copyObject();
		object= classClassControl;
		
		super.execute();

	}


	@Override
	public Controlador getObject() {
		return object;
	}

	@Override
	public Controlador getOld() {
		return old;
	}

	@Override
	public Controlador getNew() {
		return new_;
	}
	
	@Override
	public void undoIt(Project proj) throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		object.setAbstract(old.getAbstract());
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		this.object.setAbstract(new_.getAbstract());
		super.redoIt();
	}

}
