package es.uam.app.actions.metamodels;

import es.uam.app.actions.RemoveMetamodel;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;

public class RemoveClass extends RemoveMetamodel{

	private ClassControl class_;
	
	
	public RemoveClass(MetaModelProject proj, ClassControl class_) {
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
		getProject().removeClass(class_);
		super.execute();
	}

	@Override
	public Controlador getObject() {
		doIt();
		return class_;
	}

	@Override
	public void undoIt(MetaModelProject proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unRemoveClass(class_);
		super.undoIt();
	}

	@Override
	public void redoIt(MetaModelProject proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.removeClass(class_);
		super.redoIt();
	}

}
