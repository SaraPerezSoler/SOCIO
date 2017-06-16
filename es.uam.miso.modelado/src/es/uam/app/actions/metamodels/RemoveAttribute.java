package es.uam.app.actions.metamodels;

import es.uam.app.actions.RemoveMetamodel;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.Controlador;

public class RemoveAttribute extends RemoveMetamodel {

	private AttributeControl atr;
	
	
	
	public RemoveAttribute(MetaModelProject proj, AttributeControl atr) {
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
		
		getProject().removeAttribute(atr, atr.getParent());
		super.execute();

	}

	@Override
	public Controlador getObject() {
		doIt();
		return atr;
	}

	@Override
	public void undoIt(MetaModelProject proj) {
		if (!isExecute() || isUndo()){
			return;
		}
		
		proj.unRemoveAttribute(atr);
		super.undoIt();
	}

	@Override
	public void redoIt(MetaModelProject proj) {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		proj.removeAttribute(atr, atr.getParent());
		super.redoIt();
	}

}
