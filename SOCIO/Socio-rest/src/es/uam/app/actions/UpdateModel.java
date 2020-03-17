package es.uam.app.actions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.models.UpdateSetAttribute;
import es.uam.app.actions.models.UpdateSetReference;
import es.uam.app.actions.models.UpdateUnsetAttribute;
import es.uam.app.actions.models.UpdateUnsetReferece;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLAttribute;
import modelInfo.NLFeature;
import socioProjects.ModelProject;

public abstract class UpdateModel extends  Update<ModelProject>{

	public UpdateModel(ModelProject p) {
		super(p);

	}
	public static UpdateModel createAction(EObject obj, EObject old, EObject new_, ModelProject p) {
		EObjectControl newC = p.getControl(new_);
		EObjectControl oldC = p.getControl(old);
		EObjectControl elementC = p.getControl(obj);
		NLFeature feature = newC.getFeatureDiff(oldC);
		Object objectNew = newC.getNLFeatureValue(feature);
		Object objectOld = oldC.getNLFeatureValue(feature);
		
		
		if (objectNew instanceof List<?>) {
			List<?> listNew = (List<?>) objectNew;
			List<?> listOld = (List<?>) objectOld;
			if (listNew.size() > listOld.size()) {
				if (feature instanceof NLAttribute) {
					return new UpdateSetAttribute(p, elementC, oldC, newC);
				} else {
					return new UpdateSetReference(p, elementC, oldC, newC);
				}
			} else {
				if (feature instanceof NLAttribute) {
					return new UpdateUnsetAttribute(p, elementC, oldC, newC);
				}else {
					return new UpdateUnsetReferece(p, elementC, oldC, newC);
				}
			}

		}else {
			if (feature instanceof NLAttribute) {
				return new UpdateSetAttribute(p, elementC, oldC, newC);
			} else {
				if (objectNew == null) {
					return new UpdateUnsetReferece(p, elementC, oldC, newC);
				}else {
					return new UpdateSetReference(p, elementC, oldC, newC);
				}
			}
		}

	}

	@Override
	public Controlador eobjectToControlador(EObject object) {
		return new EObjectControl(object, getProject().getNLClass(object.eClass()));
	}
}
