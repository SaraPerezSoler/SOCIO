package es.uam.app.actions.models;

import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLAttribute;
import socioProjects.ModelProject;

public class UpdateUnsetAttribute  extends UpdateAttribute {




	public UpdateUnsetAttribute(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p, object, oldC, newC);
	}
	
	public UpdateUnsetAttribute(ModelProject p, IsEObject object, String attName, Object value) {
		super(p, object, attName, value);
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
	
		getProject().unsetEAttribute(object, name, this.value);
				
		setNew(object.copyObject());
		setObject(object);
		
		setExecute(true);
		
	}

	@Override
	protected Object getValue() {
		EObjectControl oldC =((EObjectControl)getOldC());
		NLAttribute attr = oldC.getNLClass().getNLAttribute(name);
		return oldC.getNLFeatureValue(attr);
	}

}
