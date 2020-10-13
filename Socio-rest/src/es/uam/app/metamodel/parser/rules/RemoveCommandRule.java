package es.uam.app.metamodel.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uam.app.actions.metamodels.RemoveAttribute;
import es.uam.app.actions.metamodels.RemoveClass;
import es.uam.app.actions.metamodels.RemoveReference;
import es.uam.app.actions.metamodels.UpdateClassRemoveSuperType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.Feature;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;

public class RemoveCommandRule {

	private Map<String, List<String>> objects;

	public RemoveCommandRule(Map<String, List<String>> objects) {
		this.objects = objects;
	}

	public List<Action> evaluete(MetamodelProject proj) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
		for (String key : objects.keySet()) {
			for (String obj : objects.get(key)) {
				if (key.equalsIgnoreCase("feature")) {
					ret.addAll(getFeatureAction(obj, proj));
				} else if (key.equalsIgnoreCase("class")) {
					ret.addAll(getClassAction(obj, proj));
				} else {
					List<Action> aux = getFeatureAction(obj, proj);
					if (aux.isEmpty()) {
						aux = getClassAction(obj, proj);
					}
					ret.addAll(aux);
				}
			}
		}
		return ret;
	}

	private List<Action> getFeatureAction(String obj, MetamodelProject proj)
			throws FileNotFoundException, JWNLException {

		List<Action> ret = new ArrayList<Action>();
		String[] split = obj.split("\\.");
		ClassControl from = null;
		if (split.length == 2) {
			from = proj.getClass(split[0]);
		}
		Feature f = null;
		if (from == null) {
			f = proj.getFeature(obj);
		} else {
			f = proj.getFeature(split[1], from);
		}
		if (f != null) {
			if (f instanceof AttributeControl) {
				RemoveAttribute ra = new RemoveAttribute(proj, (AttributeControl) f);
				ret.add(ra.getAction());
			} else {
				RemoveReference rr = new RemoveReference(proj, (ReferenceControl) f);
				ret.add(rr.getAction());
			}
		}
		return ret;
	}

	private List<Action> getClassAction(String obj, MetamodelProject proj) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
		ClassControl c = proj.getClass(obj);
		if (c != null) {
			List<ReferenceControl> references = proj.getRefereceTo(c);
			for (ReferenceControl r : references) {
				UpdateRefType upr = new UpdateRefType(proj, r, null, 1);
				ret.add(upr.getAction());
			}
			List<ClassControl> subTypes = proj.getSubTypesOf(c);
			for (ClassControl subType : subTypes) {
				UpdateClassRemoveSuperType ucrst = new UpdateClassRemoveSuperType(proj, subType, c);
				ret.add(ucrst.getAction());
			}

			RemoveClass rc = new RemoveClass(proj, c);
			ret.add(rc.getAction());
		}
		return ret;
	}
}
