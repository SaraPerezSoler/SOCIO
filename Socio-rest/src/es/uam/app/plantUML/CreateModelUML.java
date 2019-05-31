package es.uam.app.plantUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.model.EObjectControl;
import es.uam.app.projects.emf.model.ModelControl;
import modelInfo.NLAttribute;
import modelInfo.NLFeature;
import modelInfo.NLReference;
import projectHistory.Action;
import projectHistory.Add;
import projectHistory.Delete;
import projectHistory.Update;

public class CreateModelUML implements CreateText {

	public static final String NEW_BACKGROUND = "#D7F7BA";
	public static final String NEW_LINES = "#458A03";

	public static final String REMOVE_BACKGROUND = "#F59D9D";
	public static final String UPDATE_BACKGROUND = "#F7BE81";

	private static final String NULL_BACKGROUND = "#FFFFFF";
	private static final String NULL_LINES = "#BDBDBD";

	private static final String OLD_BACKGROUND = "#E0E6F8";
	private static final String OLD_LINES = "#0B0B61";

//	private static final String NEW_TAG_COLOR = "#688A08";
//	private static final String OLD_TAG_COLOR = "#8181F7";
//	private static final String STANDAR_TAG_COLOR = "#F7BE81";

	public static final String TAG_START = "<<";
	public static final String TAG_END = ">>";
	public static final String CLASS_NEW = "New";
	public static final String CLASS_OLD = "Old";

	public static final String ATTR_NEW_INI = "<b><color:" + NEW_LINES + ">";
	public static final String ATTR_NEW_FIN = "</color></b>";

	public static final String ATTR_OLD_INI = "<b><color:" + OLD_LINES + ">";
	public static final String ATTR_OLD_FIN = "</color></b>";

	public static final String DELETE_NOTE_INI = "note as Delete " + REMOVE_BACKGROUND + ENTR
			+ "This elements have been deleted:" + ENTR;
	public static final String UPDATE_NOTE_INI = "note as Update " + UPDATE_BACKGROUND + ENTR
			+ "This elements have been updated:" + ENTR;
	public static final String NOTE_FIN = "end note" + ENTR;

	public static final String START = "@startuml" + ENTR + ENTR;
	private static final String CLASS_NULL = "<<???>>";

	public static final String START_CLASS_DIAGRAM = START + "skinparam class {" + ENTR + "BackgroundColor" + TAG_START
			+ CLASS_NEW + TAG_END + " " + NEW_BACKGROUND + ENTR + "BorderColor" + TAG_START + CLASS_NEW + TAG_END + " "
			+ NEW_LINES + ENTR + "BackgroundColor" + CLASS_NULL + " " + NULL_BACKGROUND + ENTR + "BorderColor"
			+ CLASS_NULL + " " + NULL_LINES + ENTR + "BackgroundColor" + TAG_START + CLASS_OLD + TAG_END + " "
			+ OLD_BACKGROUND + ENTR + "BorderColor" + TAG_START + CLASS_OLD + TAG_END + " " + OLD_LINES + ENTR + "}"
			+ ENTR + "skinparam nodeSep 30 " + ENTR /////// configura espacio horizontal
			+ "skinparam rankSep 30 " + ENTR /////// configura espacio vertical
			+ "hide empty members   " + ENTR; /////// oculta la cajita de atributos si está vacía
	public static final String END = ENTR + "@enduml";

	private static List<Action> adds;
	private static List<Action> deletes;
	private static List<Update> updates;

	private static Map<EObjectControl, List<Update>> elementUpdateActions;
	private static Map<EObjectControl, List<Update>> elementPastUpdateActions;

	private static List<EObjectControl> addElement;
	private static List<EObjectControl> deleteElement;
	//private static List<EObjectControl> updateElement;
	private static List<EObjectControl> pastAddElements;
	//private static List<EObjectControl> pastupdateElements;

	private ModelControl model;

	public CreateModelUML(ModelControl model) {
		this.model = model;
	}

	public String createUML(List<Action> actions, List<Action> passActions) {
		String cad = START_CLASS_DIAGRAM;

		List<Action> pastAdd = getAdds(passActions);
		List<Update> pastUpdate = getUpdates(passActions);
		pastAddElements = getControlador(pastAdd);
		//pastupdateElements = getUpdateControlador(pastUpdate);
		elementPastUpdateActions = getControladorActions(pastUpdate);

		adds = getAdds(actions);
		deletes = getDeletes(actions);
		updates = getUpdates(actions);
		addElement = getControlador(adds);
		deleteElement = getControlador(deletes);
		//updateElement = getUpdateControlador(updates);
		elementUpdateActions = getControladorActions(updates);

		for (EObjectControl object : model.getAllObjects()) {
			cad += getObjectText(object);
		}
		// cad += updates();
		cad += deletedElements();
		cad += END;
		return cad;
	}

	/*private List<EObjectControl> getUpdateControlador(List<Update> updates2) {
		List<EObjectControl> object = new ArrayList<EObjectControl>();
		for (Update a : updates2) {
			Controlador c = a.getObject();
			if (c instanceof EObjectControl) {
				object.add((EObjectControl) c);
			}
		}
		return object;
	}*/

	private Map<EObjectControl, List<Update>> getControladorActions(List<Update> updates2) {
		Map<EObjectControl, List<Update>> ret = new HashMap<EObjectControl, List<Update>>();

		for (Update a : updates2) {
			EObjectControl c = (EObjectControl) a.getObject();
			List<Update> actions = ret.get(c);
			if (actions == null) {
				actions = new ArrayList<>();
			}
			actions.add(a);
			ret.put(c, actions);
		}
		return ret;
	}

	private String deletedElements() {
		List<EObjectControl> objects = deleteElement;

		if (objects.isEmpty()) {
			return "";
		}
		String cad = DELETE_NOTE_INI;
		for (EObjectControl obj : objects) {
			cad += "The Object <b><u>" + ((EObjectControl) obj).getName() + "</u></b>" + ENTR;
		}

		cad += NOTE_FIN;
		return cad;
	}

	/*
	 * private String updates() { if (updates.isEmpty()) { return ""; } String cad =
	 * UPDATE_NOTE_INI; for (Update u : updates) { cad += u.toString() + "\n"; }
	 * 
	 * cad += NOTE_FIN; return cad; }
	 */

	private List<Action> getAdds(List<Action> actions) {
		List<Action> adds = new ArrayList<Action>();
		for (Action a : actions) {
			if (a instanceof Add) {
				adds.add(a);
			}
		}
		return adds;

	}

	private List<Action> getDeletes(List<Action> actions) {
		List<Action> deletes = new ArrayList<Action>();
		for (Action a : actions) {
			if (a instanceof Delete) {
				deletes.add(a);
			}
		}
		return deletes;
	}

	private List<Update> getUpdates(List<Action> actions) {
		List<Update> updates = new ArrayList<Update>();
		for (Action a : actions) {
			if (a instanceof Update) {
				updates.add((Update) a);
			}
		}
		return updates;
	}

	private List<EObjectControl> getControlador(List<Action> act) {
		List<EObjectControl> object = new ArrayList<EObjectControl>();
		for (Action a : act) {
			Controlador c = a.getObject();
			if (c instanceof EObjectControl) {
				object.add((EObjectControl) c);
			}
		}
		return object;

	}

	private String getObjectText(EObjectControl object) {

		String head = createObjectHead(object);

		String cad = "object " + head + " {" + ENTR;

		Map<NLReference, Object> references = new HashMap<>();
		for (NLFeature feature : object.getNLClass().getFeatures()) {
			if (feature instanceof NLAttribute) {
				cad += getAttributeText(object, (NLAttribute) feature);
			} else {
				Object value = object.getNLFeatureValue(feature);
				if (value == null) {
					cad += getNullReference(object, (NLReference) feature);

				} else {
					references.put((NLReference) feature, value);
				}
			}
		}
		cad += "}" + ENTR;

		for (NLReference rc : references.keySet()) {
			cad += getReference(object, rc, references.get(rc));
		}

		return cad;

	}

	private String selectClassColor(EObjectControl object) {
		if (addElement.contains(object)) {
			return CLASS_NEW;
		} else if (!pastAddElements.contains(object)) {
			return CLASS_OLD;
		} else {
			return "";
		}
	}

	private String getObjectName(EObjectControl object) {
		String name1 = "\"" + object.getName() + " as " + object.getIdString() + "\"";
		return name1;
	}

	private String createObjectHead(EObjectControl cc) {

		return getObjectName(cc) + TAG_START + selectClassColor(cc) + TAG_END;
	}

	private boolean isNewFeature(EObjectControl object, NLFeature attribute) {
		List<Update> updates = elementUpdateActions.get(object);
		return isFeatureInUpdates(object, attribute, updates);
	}

	private boolean isActualFeature(EObjectControl object, NLFeature attribute) {
		List<Update> updates = elementPastUpdateActions.get(object);
		return isFeatureInUpdates(object, attribute, updates);
	}

	private boolean isFeatureInUpdates(EObjectControl object, NLFeature attribute, List<Update> actions) {
		if (actions == null) {
			return false;
		}
		for (Update upd : actions) {
			EObjectControl oldC = (EObjectControl) upd.getOldC();
			EObjectControl newC = (EObjectControl) upd.getNewC();
			if (oldC.getFeatureDiff(newC).equals(attribute)) {
				return true;
			}
		}
		return false;
	}

	private String getAttributeText(EObjectControl object, NLAttribute ac) {

		String cad = "";
		String cadFin = ENTR;

		if (isNewFeature(object, ac)) {
			cad = ATTR_NEW_INI;
			cadFin = ATTR_NEW_FIN + ENTR;
		} else if (!isActualFeature(object, ac)) {
			cad = ATTR_OLD_INI;
			cadFin = ATTR_OLD_FIN + ENTR;
		}

		String value;
		Object val = object.getNLFeatureValue(ac);
		if (val != null) {
			value = val.toString();
		} else {
			value = "null ";
		}

		cad += ac.getName() + " = " + value + cadFin;
		return cad;

	}

	private String getNullReference(EObjectControl object, NLReference feature) {
		String cad = "";
		String cadFin = ENTR;

		if (isNewFeature(object, feature)) {
			cad = ATTR_NEW_INI;
			cadFin = ATTR_NEW_FIN + ENTR;
		} else if (!isActualFeature(object, feature)) {
			cad = ATTR_OLD_INI;
			cadFin = ATTR_OLD_FIN + ENTR;
		}

		cad += "Ref: " + feature.getName() + " = " + null + cadFin;
		return cad;
	}

	private String getReference(EObjectControl object, NLReference rc, Object value) {

		String cad = "";
		String line = "--";

		String nameStart = "";
		String nameEnd = ENTR;

		if (isNewFeature(object, rc)) {
			nameStart = ATTR_NEW_INI;
			nameEnd = ATTR_NEW_FIN + ENTR;
			line = "-[" + NEW_LINES + "]-";
		}

		if (!isActualFeature(object, rc)) {
			line = "-[" + OLD_LINES + "]-";
		}
		if (rc.getReference().isContainment()) {
			line = " *" + line;
		}else {
			line =" " + line + ">";
		}
		String parentName = object.getIdString();
		if (value instanceof List<?>) {
			for (Object obj : (List<?>) value) {
				EObjectControl valueControl = model.getControl((EObject)obj);
				cad += nameStart+ parentName +line+ valueControl.getIdString()+nameEnd;
			}
		} else {
			EObjectControl valueControl = model.getControl((EObject)value);
			cad += nameStart+ parentName +line+ valueControl.getIdString()+nameEnd;
		}

		return cad;
	}

}
