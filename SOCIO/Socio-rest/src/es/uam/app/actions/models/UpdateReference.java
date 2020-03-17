package es.uam.app.actions.models;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLClass;
import modelInfo.NLReference;
import socioProjects.ModelProject;

public abstract class UpdateReference extends UpdateFeature {

	protected IsEObject value;

	public UpdateReference(ModelProject p, IsEObject object, String attName, IsEObject value) {
		super(p, object, attName);
		this.value = value;

	}

	/*
	 * public UpdateAttribute(ModelProject p, IsEObject object, NLAttribute attName,
	 * Object value) { super(p);
	 * 
	 * }
	 */

	public UpdateReference(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p, object, oldC, newC);

	
		Object valueObject = getValue();
		if (valueObject instanceof EObject) {
			EObject valueEObject = (EObject) valueObject;
			NLClass nlclass = p.getNLClass(valueEObject.eClass());
			this.value = new EObjectControl(valueEObject, nlclass);
		} else {
			this.value = null;
		}
	}

	@Override
	public EObjectControl getObject() {
		return (EObjectControl)super.getObject();
	}

	

	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		NLReference feature = this.getObject().getNLClass().getNLReference(name);
		if (feature==null){
			throw new Exception("Problem ocurred in UpdateReference: the NLFeature is not found");
		}
		//
		getProject().restoreFeature(getObject(), feature, ((EObjectControl)getOldC()).getNLFeatureValue(feature));
		
		setUndo(true);

	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		NLReference feature = this.getObject().getNLClass().getNLReference(name);
		if (feature==null){
			throw new Exception("Problem ocurred in UpdateReference: the NLFeature is not found");
		}
		getProject().restoreFeature(getObject(),feature, ((EObjectControl)getNewC()).getNLFeatureValue(feature));

		setUndo(false);

	}

}
