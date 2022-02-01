package es.uam.app.actions.models;

import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLAttribute;
import socioProjects.ModelProject;

public  class UpdateSetAttribute extends UpdateAttribute{

	public UpdateSetAttribute(ModelProject p, IsEObject object, String attName, Object value) {
		super(p, object, attName, value);
	}

	public UpdateSetAttribute(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p, object, oldC, newC);
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		
		EObjectControl object = this.object.getEObjectControl();
		
		if (object==null){
			throw new Exception("Problem ocurred in UpdateAttribute: the object is not found");
		}
		
		setOld(object.copyObject());
	
		getProject().setEAttribute(object, name, this.value);
				
		setNew(object.copyObject());
		setObject(object);
		
		setExecute(true);
		
	}

	@Override
	protected Object getValue() {
		EObjectControl newC =((EObjectControl)getNewC());
		NLAttribute attr = newC.getNLClass().getNLAttribute(name);
		return newC.getNLFeatureValue(attr);
	}


}
