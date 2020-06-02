package es.uam.app.actions.models;

import es.uam.app.actions.UpdateModel;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLAttribute;
import modelInfo.NLFeature;
import socioProjects.ModelProject;

public abstract class UpdateFeature extends UpdateModel {
	protected IsEObject object;
	protected String name;
	
	
	public UpdateFeature(ModelProject p, IsEObject object, String name) {
		super(p);
		this.object =  object;
		this.name = name;
	}
	
	public UpdateFeature(ModelProject p, EObjectControl object, EObjectControl oldC, EObjectControl newC) {
		super(p);
		this.setObject(object);
		this.object = object;
		NLFeature feature = oldC.getFeatureDiff(newC);
		this.name = feature.getName();

		this.setNew(newC);
		this.setOld(oldC);
		setExecute(true);
		setUndo(false);
	}

	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		NLAttribute feature = this.getObject().getNLClass().getNLAttribute(name);
		if (feature==null){
			throw new Exception("Problem ocurred in UpdateAttribute: the NLAttribute is not found");
		}
		//
		getProject().restoreFeature(this.getObject(), feature, ((EObjectControl)getOldC()).getNLFeatureValue(feature));
		
		setUndo(true);
		
	}
	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		NLAttribute feature = this.getObject().getNLClass().getNLAttribute(name);
		if (feature==null){
			throw new Exception("Problem ocurred in UpdateAttribute: the NLAttribute is not found");
		}
		getProject().restoreFeature(this.getObject(), feature, ((EObjectControl)getNewC()).getNLFeatureValue(feature));

		setUndo(false);
		
	}
	
	@Override
	public EObjectControl getObject() {
		return (EObjectControl)super.getObject();
	}
	
	protected abstract Object getValue();

}
