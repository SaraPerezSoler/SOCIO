package es.uam.app.actions.metamodels;

import es.uam.app.actions.Update;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.Controlador;

public class UpdateRefCard extends Update{

	public UpdateRefCard(Project proj) {
		super(proj);
	}

	@Override
	public Controlador getOld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Controlador getNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doIt() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undoIt(Project proj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Controlador getObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
