package es.uam.app.actions.models;



import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLReference;
import socioProjects.ModelProject;

public class UpdateUnsetReferece extends UpdateReference {


	public UpdateUnsetReferece(ModelProject p, EObjectControl object, String refName, EObjectControl value) {
		super(p, object, refName, value);
	}

	public UpdateUnsetReferece(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p, object, oldC, newC);
	}

	@Override
	public EObjectControl getObject() {
		return (EObjectControl) super.getObject();
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}
		EObjectControl obj = object.getEObjectControl();
		EObjectControl val = value.getEObjectControl();
		setOld(obj.copyObject());
		getProject().unsetEReference(obj, name, val);

		setNew(obj.copyObject());
		setObject(obj);

		setExecute(true);

	}

	@Override
	protected Object getValue() {
		EObjectControl oldC =((EObjectControl)getOldC());
		NLReference reference = oldC.getNLClass().getNLReference(name);
		return oldC.getNLFeatureValue(reference);
	}

}
