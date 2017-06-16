package es.uam.app.actions.metamodels;

import es.uam.app.actions.RemoveMetamodel;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public class RemoveReference extends RemoveMetamodel {

	private ReferenceControl ref;

	
	public RemoveReference(MetaModelProject  proj, ReferenceControl ref) {
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
		
		getProject().removeReference(ref, ref.getParent());
		super.execute();

	}

	@Override
	public Controlador getObject() {
		doIt();
		return ref;
	}

	@Override
	public void undoIt(MetaModelProject proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unRemoveReference(ref);
		super.undoIt();
	}

	@Override
	public void redoIt(MetaModelProject proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.removeReference(ref, ref.getParent());
		super.redoIt();
	}
}
