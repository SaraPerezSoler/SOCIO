package es.uam.app.actions.metamodels;

import es.uam.app.actions.Remove;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;

public class RemoveAttribute extends Remove {

	private AttributeControl atr;
	
	
	
	public RemoveAttribute(Project proj, AttributeControl atr) {
		super(proj);
		this.atr = atr;
	}

	public RemoveAttribute(AttributeControl attributeControl) {
		super(null);
		this.atr = attributeControl;
	}

	@Override
	public void doIt() {
		if (isExecute()){
			return;
		}
		
		proj.removeAttribute(atr, atr.getParent());
		super.execute();

	}

	@Override
	public Controlador getObject() {
		doIt();
		return atr;
	}

	@Override
	public void undoIt(Project proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unRemoveAttribute(atr);
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.removeAttribute(atr, atr.getParent());
		super.redoIt();
	}

}
