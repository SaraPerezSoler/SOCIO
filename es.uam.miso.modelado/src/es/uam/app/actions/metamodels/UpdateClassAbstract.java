package es.uam.app.actions.metamodels;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.ecore.ClassControl;
import socioProjects.MetamodelProject;

public class UpdateClassAbstract extends UpdateMetamodel {

	private IsClass class_ = null;
	private boolean abstract_=false;
	
	public UpdateClassAbstract(MetamodelProject proj, IsClass class_, boolean abstract_) {
		super(proj);
		this.class_ =  class_;
		
		this.abstract_=abstract_;
		
	}

	public UpdateClassAbstract(MetamodelProject p, ClassControl classControl, ClassControl oldC, ClassControl newC) {
		super(p);
		setObject(classControl);
		this.class_=classControl;
		setOld(oldC);
		setNew(newC);
		setExecute(true);
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
		
		setOld(classClassControl.copyObject());
		classClassControl.setAbstract(abstract_);
		setNew(classClassControl.copyObject());
		setObject(classClassControl);
		
		setExecute(true);

	}


	@Override
	public ClassControl getObject() {
		return (ClassControl) super.getObject();
	}
	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getObject().setAbstract(((ClassControl)getOldC()).getAbstract());
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		this.getObject().setAbstract(((ClassControl)getNewC()).getAbstract());
		setUndo(false);
	}
}
