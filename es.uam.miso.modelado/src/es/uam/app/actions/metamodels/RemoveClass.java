package es.uam.app.actions.metamodels;

import es.uam.app.actions.Remove;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;

public class RemoveClass extends Remove{

	private ClassControl class_;
	
	
	public RemoveClass(Project proj, ClassControl class_) {
		super(proj);
		this.class_ = class_;
	}

	public RemoveClass(ClassControl classControl) {
		super(null);
		this.class_ = classControl;
	}

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		proj.removeClass(class_);
		super.execute();
	}

	@Override
	public Controlador getObject() {
		doIt();
		return class_;
	}

	@Override
	public void undoIt(Project proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unRemoveClass(class_);
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.removeClass(class_);
		super.redoIt();
	}

}
