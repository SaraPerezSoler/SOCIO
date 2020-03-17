package es.uam.app.actions.models;

import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import socioProjects.ModelProject;

public abstract class UpdateAttribute extends UpdateFeature{
	
	
	protected Object value;

	public UpdateAttribute(ModelProject p, IsEObject object, String attName, Object value) {
		super(p, object, attName);
		this.value = value;
		
	}
	
	
	public UpdateAttribute(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p, object, oldC, newC);
		
		this.value = getValue();
		
	}

	
	



	



}
