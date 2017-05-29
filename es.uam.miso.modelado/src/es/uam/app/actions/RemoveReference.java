package es.uam.app.actions;

import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public class RemoveReference extends Remove {

	private ReferenceControl ref;

	
	public RemoveReference( Project proj, ReferenceControl ref) {
		super(proj);
		this.ref = ref;
	}

	public RemoveReference(ReferenceControl referenceControl) {
		super(null);
		this.ref = referenceControl;
	}

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		
		proj.removeReference(ref, ref.getParent());
		super.execute();

	}

	@Override
	public Controlador getObject() {
		doIt();
		return ref;
	}

	@Override
	public void undoIt(Project proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unRemoveReference(ref);
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.removeReference(ref, ref.getParent());
		super.redoIt();
	}
}
