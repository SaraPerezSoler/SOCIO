package es.uam.app.actions.metamodels;

import es.uam.app.actions.DeleteMetamodel;
import es.uam.app.projects.emf.metamodel.ClassControl;
import socioProjects.MetamodelProject;

public class RemoveClass extends DeleteMetamodel{

	public RemoveClass(MetamodelProject proj, ClassControl class_) {
		super(proj);
		setObject(class_);
	}

	/*public RemoveClass(ClassControl classControl) {
		super(null);
		this.class_ = classControl;
	}*/

	public RemoveClass(MetamodelProject p, ClassControl classControl, boolean isExecute) {
		super(p);
		setObject(classControl);
		setExecute(isExecute);
	}

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		getProject().removeClass(getObject());
		setExecute(true);
	}

	@Override
	public ClassControl getObject() {
		return (ClassControl)super.getObject();
	}

	@Override
	public void undoIt() {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unRemoveClass(getObject());
		setUndo(true);
	}

	@Override
	public void redoIt() {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().removeClass(getObject());
		setUndo(false);
	}
}
