package es.uam.app.metamodel.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.json.JSONArray;
import org.json.JSONObject;

import es.uam.app.actions.metamodels.CreateAttribute;
import es.uam.app.actions.metamodels.CreateClass;
import es.uam.app.actions.metamodels.CreateReference;
import es.uam.app.actions.metamodels.UpdateAttrType;
import es.uam.app.actions.metamodels.UpdateClassAbstract;
import es.uam.app.actions.metamodels.UpdateClassSuperType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.metamodel.parser.NP;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.emf.metamodel.MetamodelControl;
import es.uam.app.projects.emf.metamodel.MetamodelControlInterface;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;

public class AddCommandRule {

	private JSONObject objects;

	public AddCommandRule(JSONObject objects) {
		this.objects = objects;
	}

	public List<Action> evaluete(MetamodelProject proj) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
		for (int i = 0; i < objects.names().length(); i++) {
			String key = objects.names().getString(i);
			IsClass keyClass = IsClass.getExactlyClass(NP.upperCammelCase(key), proj);

			keyClass = addIsClass(keyClass, ret);

			JSONObject classObject = objects.getJSONObject(key);

			if (classObject.has(MetamodelControl.ABSTRACT)) {
				boolean abstract_ = classObject.getBoolean(MetamodelControl.ABSTRACT);
				UpdateClassAbstract uca = new UpdateClassAbstract(proj, keyClass, abstract_);
				ret.add(uca.getAction());
			}

			if (classObject.has(MetamodelControl.SUPERCLASSES)) {
				JSONArray superClases = classObject.getJSONArray(MetamodelControl.SUPERCLASSES);
				for (int j = 0; j < superClases.length(); j++) {
					String superClass = superClases.getString(j);
					IsClass superClassClass = IsClass.getExactlyClass(NP.upperCammelCase(superClass), proj);
					superClassClass = addIsClass(superClassClass, ret);
					UpdateClassSuperType ucst = new UpdateClassSuperType(proj, keyClass, superClassClass);
					ret.add(ucst.getAction());
				}
			}
			
			if (classObject.has(MetamodelControl.FEATURES)) {
				JSONObject features = classObject.getJSONObject(MetamodelControl.FEATURES);
				for (int j =0 ; j<features.names().length(); j++) {
					String featureName = features.names().getString(j);
					String type ="";
					int min = 1;
					int max = 1;
					boolean containment = false;
					JSONObject feature = features.getJSONObject(featureName);
					if (feature.has(MetamodelControl.TYPE)) {
						type = feature.getString(MetamodelControl.TYPE);
					}
					if (feature.has(MetamodelControl.CONTAINMENT)) {
						containment = feature.getBoolean(MetamodelControl.CONTAINMENT);
					}
					if (feature.has(MetamodelControl.MIN)) {
						min = feature.getInt(MetamodelControl.MIN);
					}
					if (feature.has(MetamodelControl.MAX)) {
						max = feature.getInt(MetamodelControl.MAX);
					}
					
					if (type.isEmpty()) {
						IsAttribute att = IsAttribute.getExactlyAttribute(NP.lowerCammelCase(featureName), keyClass, min, max, proj);
						att= addIsAttribute(att, ret);
					}else {
						EClassifier primitiveType = MetamodelControlInterface.getType(type);
						if (primitiveType != null) {
							IsAttribute att = IsAttribute.getExactlyAttribute(NP.lowerCammelCase(featureName), keyClass, min, max, proj);
							att= addIsAttribute(att, ret);
							UpdateAttrType uat = new UpdateAttrType(proj, att, type, max);
							ret.add(uat.getAction());
							
						}else {
							IsReference ref = IsReference.getExactlyReference(NP.lowerCammelCase(featureName), keyClass, min, max, proj, containment);
							ref = addIsReference(ref, ret);
							IsClass typeClass = IsClass.getExactlyClass(type, proj);
							typeClass = addIsClass(typeClass, ret);
							UpdateRefType urt = new UpdateRefType(proj, ref, typeClass, max);
							ret.add(urt.getAction());
						}
					}
				}
				
			}
		}

		return ret;
	}

	private IsClass addIsClass(IsClass class_, List<Action> ret) {
		if (class_ instanceof CreateClass) {
			if (ret.contains(((CreateClass) class_).getAction())) {
				class_ = (CreateClass) ret.get(ret.indexOf((Action) class_));
			} else {
				ret.add(((CreateClass)class_).getAction());
			}
		}
		return class_;
	}
	
	private IsReference addIsReference(IsReference ref, List<Action> ret) {
		if (ref instanceof CreateReference) {
			if (ret.contains(((CreateReference) ref).getAction())) {
				ref = (CreateReference) ret.get(ret.indexOf((Action) ref));
			} else {
				ret.add(((CreateReference) ref).getAction());
			}
		}
		return ref;
	}
	
	private IsAttribute addIsAttribute(IsAttribute attr, List<Action> ret) {
		if (attr instanceof CreateAttribute) {
			if (ret.contains(((CreateAttribute) attr).getAction())) {
				attr = (CreateAttribute) ret.get(ret.indexOf((Action) attr));
			} else {
				ret.add(((CreateAttribute) attr).getAction());
			}
		}
		return attr;
	}

}
