package es.uam.app.actions.models;

import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLReference;
import socioProjects.ModelProject;

public class UpdateSetReference extends UpdateReference {

	public UpdateSetReference(ModelProject p, IsEObject object, String attName, IsEObject value) {
		super(p, object, attName, value);
	}

	public UpdateSetReference(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p, object, oldC, newC);
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}

		EObjectControl object = this.object.getEObjectControl();

		if (object == null) {
			throw new Exception("Problem ocurred in UpdateReference: the object is not found");
		}

		setOld(object.copyObject());
		EObjectControl value = this.value.getEObjectControl();

		if (value == null) {
			throw new Exception("Problem ocurred in UpdateReference: the object is not found");
		}
		getProject().setEReference(object, value, name);

		setNew(object.copyObject());
		setObject(object);

		setExecute(true);

	}

	@Override
	protected Object getValue() {
		EObjectControl newC =((EObjectControl)getNewC());
		NLReference reference = newC.getNLClass().getNLReference(name);
		return newC.getNLFeatureValue(reference);
	}
}
