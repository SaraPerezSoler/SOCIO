package es.uam.app.plantUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.PackageControl;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import projectHistory.Action;
import projectHistory.Add;
import projectHistory.Delete;
import projectHistory.Update;

public class CreateSortMetamodelUML implements CreateText{

	public static final String NEW_BACKGROUND = "#D7F7BA";
	public static final String NEW_LINES = "#458A03";
	
	public static final String REMOVE_BACKGROUND = "#F59D9D";
	public static final String UPDATE_BACKGROUND = "#F7BE81";

	private static final String NULL_BACKGROUND = "#FFFFFF";
	private static final String NULL_LINES = "#BDBDBD";
	
	private static final String OLD_BACKGROUND = "#E0E6F8";
	private static final String OLD_LINES = "#0B0B61";
	
	private static final String NEW_TAG_COLOR="#688A08";
	private static final String OLD_TAG_COLOR="#8181F7";
	private static final String STANDAR_TAG_COLOR="#F7BE81";
	



	public static final String TAG_START="<<";
	public static final String TAG_END=">>";
	public static final String CLASS_NEW = "New";
	public static final String CLASS_OLD = "Old";
	public static final String CLASS_MOD = "Mod";
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

	public static final String START_CLASS_DIAGRAM = START + "skinparam class {" + ENTR + "BackgroundColor" + TAG_START+ CLASS_NEW + TAG_END
			+ " " + NEW_BACKGROUND + ENTR + "BorderColor" + TAG_START+ CLASS_NEW + TAG_END + " " + NEW_LINES + ENTR + "BackgroundColor"
			+ CLASS_NULL + " " + NULL_BACKGROUND + ENTR + "BorderColor" + CLASS_NULL + " " + NULL_LINES + ENTR
			+ "BackgroundColor" + TAG_START+ CLASS_OLD+ TAG_END + " " + OLD_BACKGROUND + ENTR + "BorderColor" + TAG_START+ CLASS_OLD+ TAG_END + " "
			+ OLD_LINES + ENTR 
			+"HeaderBackgroundColor"+TAG_START+CLASS_MOD+TAG_END+" " +OLD_BACKGROUND+ENTR
			+"BorderColor"+TAG_START+CLASS_MOD+TAG_END+" " +OLD_LINES+ENTR
			+"}" + ENTR
			+ "skinparam nodeSep 50 "+ ENTR /////// configura espacio horizontal
			+ "skinparam rankSep 50 "+ ENTR /////// configura espacio vertical
			+ "hide empty members   "+ ENTR; /////// oculta la cajita de atributos si est� vac�a
	public static final String END = ENTR + "@enduml";

	private static final String CLASS = "Class";
	private static final String ATTR = "Attr";
	private static final String REF = "Ref";

	private static List<Action> adds;
	private static List<Action> deletes;
	private static List<Update> updates;

	private static Map<Controlador, List<Update>> elementUpdateActions;
	private static Map<Controlador, List<Update>> elementUpdateActualActions;

	private static Map<String, List<Controlador>> addControl;
	private static Map<String, List<Controlador>> deleteControl;
	private static Map<String, List<Controlador>> updateControl;
	private static Map<String, List<Controlador>> addActualElements;
	private static Map<String, List<Controlador>> updateActualElements;
	private boolean nullReference = false;

	private PackageControl pc;
	private Map<ClassControl, Boolean> print=new HashMap<>();

	public CreateSortMetamodelUML(PackageControl pck) {
		this.pc = pck;
	}

	public String createUML(List<Action> actions, List<Action> passActions) {
		String cad = START_CLASS_DIAGRAM;

		List<Action> addActual = getAdds(passActions);
		List<Update> updateActual = getUpdates(passActions);
		addActualElements = getControlador(addActual);
		updateActualElements = getUpdateControlador(updateActual);
		elementUpdateActualActions = getControladorActions(updateActual);

		adds = getAdds(actions);
		deletes = getDeletes(actions);
		updates = getUpdates(actions);
		addControl = getControlador(adds);
		deleteControl = getControlador(deletes);
		updateControl = getUpdateControlador(updates);
		elementUpdateActions = getControladorActions(updates);

		for (ClassControl cc : pc.getClasses()) {
			String cad2=getClassText(cc, false);
			cad += cad2;
		}
		// cad += updates();
		cad += deletedElements();
		cad += END;
		return cad;
	}

	private Map<String, List<Controlador>> getUpdateControlador(List<Update> updates2) {
		List<Controlador> clas = new ArrayList<Controlador>();
		List<Controlador> attr = new ArrayList<Controlador>();
		List<Controlador> ref = new ArrayList<Controlador>();
		Map<String, List<Controlador>> ret = new HashMap<String, List<Controlador>>();

		for (Action a : updates2) {
			Controlador c = (Controlador) a.getObject();
			if (c instanceof ClassControl) {
				clas.add(c);
			} else if (c instanceof AttributeControl) {
				attr.add(c);
			} else if (c instanceof ReferenceControl) {
				ref.add(c);
			}
		}

		ret.put(CLASS, clas);
		ret.put(ATTR, attr);
		ret.put(REF, ref);
		return ret;
	}

	private Map<Controlador, List<Update>> getControladorActions(List<Update> updates2) {
		Map<Controlador, List<Update>> ret = new HashMap<Controlador, List<Update>>();

		for (Update a : updates2) {
			Controlador c = a.getObject();
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
		List<Controlador> clas = deleteControl.get(CLASS);
		List<Controlador> attr = deleteControl.get(ATTR);
		List<Controlador> ref = deleteControl.get(REF);
		if (clas.isEmpty() && attr.isEmpty() && ref.isEmpty()) {
			return "";
		}
		String cad = DELETE_NOTE_INI;
		for (Controlador cc : clas) {
			cad += "The Class <b><u>" + ((ClassControl) cc).getName() + "</u></b>" + ENTR;
		}

		for (Controlador ac : attr) {
			cad += "The Attribute <b><u>" + ((AttributeControl) ac).getName() + "</u></b> from "
					+ ((AttributeControl) ac).getParentName() + ENTR;
		}

		for (Controlador rc : ref) {
			cad += "The Reference <b><u>" + ((ReferenceControl) rc).getName() + "</u></b> from "
					+ ((ReferenceControl) rc).getParentName() + ENTR;
		}

		cad += NOTE_FIN;
		return cad;
	}

	/*
	 * private String updates() { if (updates.isEmpty()) { return ""; } String
	 * cad = UPDATE_NOTE_INI; for (Update u : updates) { cad += u.toString() +
	 * "\n"; }
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

	private Map<String, List<Controlador>> getControlador(List<Action> act) {
		List<Controlador> clas = new ArrayList<Controlador>();
		List<Controlador> attr = new ArrayList<Controlador>();
		List<Controlador> ref = new ArrayList<Controlador>();
		Map<String, List<Controlador>> ret = new HashMap<String, List<Controlador>>();

		for (Action a : act) {
			Controlador c = (Controlador) a.getObject();
			if (c instanceof ClassControl) {
				clas.add(c);
			} else if (c instanceof AttributeControl) {
				attr.add(c);
			} else if (c instanceof ReferenceControl) {
				ref.add(c);
			}
		}

		ret.put(CLASS, clas);
		ret.put(ATTR, attr);
		ret.put(REF, ref);
		return ret;

	}

	private String getClassText(ClassControl cc, boolean print) {
		boolean printBefore=false;
		if (this.print.get(cc)==null){
			printBefore=false;
		}else if (this.print.get(cc)==false){
			printBefore=false;
		}else{
			printBefore=true;
		}
		if (this.print.get(cc)!=null && this.print.get(cc)!=false){
			printBefore=true;
		}
		String cad = "";
		boolean old=false;
		if (!hasNewTagUpdate(cc) && !hasActualTagUpdate(cc)){
			old=true;
		}
		String head=createClassHead(cc);
		String name=getClassName(cc);
		String head2= getClassName(cc) + TAG_START+tag(cc)+ CLASS_MOD+ TAG_END;
		String start="";
		String endStart= " {" + ENTR;

		if (cc.getInterface()) {
			start= "interface ";
		} else {
			if (cc.getAbstract()) {
				start= "abstract ";
			}
			start += "class ";
		}
		
		String attr="";
		boolean hasActualAttr=false;
		for (AttributeControl ac : cc.getAttributes()) {
			if (isActualAtr(ac)){
				if (old){
					hasActualAttr=true;
				}
				attr += getAttributeText(ac);
			}
		}
		if (hasActualAttr){
			cad+=start+head2+endStart+attr;
		}else{
			cad+=start+head+endStart+attr;
		}
		cad += "}" + ENTR;

		for (ClassControl superType : cc.getSuperTypes()) {
			
			if (superTypeisNew(cc, superType)){
				old=false;
				cad += superType.getName() + " <|-["+NEW_LINES+"]- " + name + ENTR;
			}else if (superTypeisActual(cc, superType)){
				old=false;
				cad += superType.getName() + " <|-- " + name + ENTR;
			}
			
			if (!hasNewTagUpdate(superType) && !hasActualTagUpdate(superType) && old==false){
				String cad2=getClassText(superType, true)+ENTR+cad;
				cad=cad2;
			}
		}
		
		
		nullReference = false;
		for (ReferenceControl rc : cc.getReferences()) {
			if (isActualRef(rc)){
				old=false;
				cad += getReference(rc);
			}
			
		}
		if (nullReference) {
			cad += ENTR + "class \"�\" <<(?," + NULL_LINES + ") ???>>{" + ENTR + "}" + ENTR;
		}
		if ((old && print==false && hasActualAttr==false)||printBefore){
			return "";
		}
		this.print.put(cc, true);
		return cad;

	}
	private boolean superTypeisNew(ClassControl cc, ClassControl superType){
		List<Controlador> updateNewClass = updateControl.get(CLASS);
		if (updateNewClass.contains(cc)){
			List<Update> actions=elementUpdateActions.get(cc);
			for (Update u: actions){
				if (u.isUpdateSuperType(superType)){
					return true;
				}
			}
		}
		return false;
	}
	private boolean superTypeisActual(ClassControl cc, ClassControl superType){
		List<Controlador> updateActualClass = updateActualElements.get(CLASS);
		if (updateActualClass.contains(cc)){
			List<Update> actions=elementUpdateActualActions.get(cc);
			for (Update u: actions){
				if (u.isUpdateSuperType(superType)){
					return true;
				}
			}
		}
		return false;
	}
	
	private String tagLetter(ClassControl cc){
		if (cc.getAbstract()){
			return "A";
		}else{
			return "C";
		}
	}
	private String tag(ClassControl cc){
		return "("+tagLetter(cc)+", "+selectTagColor(cc)+")";
	}
	
	private String selectTagColor(ClassControl cc){
		if (hasNewTagUpdate(cc)){
			return NEW_TAG_COLOR;
		}else if (hasActualTagUpdate(cc)){
			return STANDAR_TAG_COLOR;
		}else{
			return OLD_TAG_COLOR;
		}
	}
	private String selectClassColor(ClassControl cc){
		List<Controlador> addNewClass = addControl.get(CLASS);
		List<Controlador> addActualClass = addActualElements.get(CLASS);
		if (addNewClass.contains(cc)) {
			return CLASS_NEW;
		}else if (!addActualClass.contains(cc)){
			return CLASS_OLD;
		}else{
			return "";
		}
	}
	
	private String getClassName(ClassControl cc){
		String name1 = cc.getName();
		
		if (name1.equals("Class")) {
			name1 = "\"" + cc.getName() + "\"";
		}
		return name1;
	}
	
	private String createClassHead(ClassControl cc){		
			
		return  getClassName(cc) + TAG_START+tag(cc)+ selectClassColor(cc)+ TAG_END;
	}
	
	
	
	private boolean hasNewTagUpdate(ClassControl cc){
		List<Controlador> addNewClass = addControl.get(CLASS);
		List<Controlador> updateNewClass = updateControl.get(CLASS);
		if (addNewClass.contains(cc)){
			return true;
		}
		if (updateNewClass.contains(cc)){
			List<Update> actions=elementUpdateActions.get(cc);
			for (Update u: actions){
				if (u.isUpdateAbstract()){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasActualTagUpdate(ClassControl cc){
		List<Controlador> addActualClass = addActualElements.get(CLASS);
		List<Controlador> updateActualClass = updateActualElements.get(CLASS);
		if (addActualClass.contains(cc)){
			return true;
		}
		if (updateActualClass.contains(cc)){
			List<Update> actions=elementUpdateActualActions.get(cc);
			for (Update u: actions){
				if (u.isUpdateAbstract()){
					return true;
				}
			}
		}
		return false;
	}

	private String getAttributeText(AttributeControl ac) {
		List<Controlador> attr = addControl.get(ATTR);
		List<Controlador> attrUpd = updateControl.get(ATTR);
		List<Controlador> addActualAttributes = addActualElements.get(ATTR);
		List<Controlador> updateActualAttributes = updateActualElements.get(ATTR);
		String cad = "";
		String cadFin = ENTR;

		if (attr.contains(ac) || attrUpd.contains(ac)) {
			cad = ATTR_NEW_INI;
			cadFin = ATTR_NEW_FIN + ENTR;
		} else if (!addActualAttributes.contains(ac) && !updateActualAttributes.contains(ac)) {
			cad = ATTR_OLD_INI;
			cadFin = ATTR_OLD_FIN + ENTR;
		}

		String type;
		if (ac.getType() != null) {
			type = ac.getType().getInstanceClass().getSimpleName() + " ";
		} else {
			type = "?? ";
		}

		cad += "[" + ac.getLowerBound() + ",";
		if (ac.getUpperBound() == -1) {
			cad += "* ] ";
		} else {
			cad += ac.getUpperBound() + "] ";
		}
		cad += ac.getName() + ": " + type + cadFin;
		return cad;

	}
	private boolean isActualRef(ReferenceControl rc){
		List<Controlador> ref = addControl.get(REF);
		List<Controlador> updateRef=updateControl.get(REF);
		List<Controlador> addActualRef = addActualElements.get(REF);
		List<Controlador> updateActualRef = updateActualElements.get(REF);
		
		if (ref.contains(rc) || updateRef.contains(rc) ||addActualRef.contains(rc) ||updateActualRef.contains(rc)){
			return true;
		}
		
		return false;
	}
	
	private boolean isActualAtr(AttributeControl ac){
		List<Controlador> attr = addControl.get(ATTR);
		List<Controlador> updateAttr=updateControl.get(ATTR);
		List<Controlador> addActualAttr = addActualElements.get(ATTR);
		List<Controlador> updateActualAttr = updateActualElements.get(ATTR);
		
		if (attr.contains(ac) || updateAttr.contains(ac) ||addActualAttr.contains(ac) ||updateActualAttr.contains(ac)){
			return true;
		}
		
		return false;
	}

	private String getReference(ReferenceControl rc) {
		List<Controlador> ref = addControl.get(REF);
		List<Controlador> updateRef=updateControl.get(REF);
		List<Controlador> addActualRef = addActualElements.get(REF);
		List<Controlador> updateActualRef = updateActualElements.get(REF);
		String cad = "";
		String line = "--";
		
		String nameStart = "";
		String nameEnd = ENTR;

		for (Controlador c : ref) {
			if (rc.equals(c)) {
				nameStart=ATTR_NEW_INI;
				nameEnd=ATTR_NEW_FIN+ENTR;
				line = "-[" + NEW_LINES + "]-";
			}
		}
		if (ref.contains(rc) || updateRef.contains(rc)){
			nameStart=ATTR_NEW_INI;
			nameEnd=ATTR_NEW_FIN+ENTR;
			line = "-[" + NEW_LINES + "]-";
		}
		
		if (!addActualRef.contains(rc) && !updateActualRef.contains(rc)) {
			line = "-[" + OLD_LINES + "]-";
		}

		String parentName = "";
		if (rc.getParent() == null) {
			parentName = "null";
		} else {
			parentName = rc.getParent().getName();
			if (parentName.equals("Class")) {
				parentName = "\"" + parentName + "\"";
			}
		}
		if (rc.isContainment()) {
			cad += parentName + " *" + line + "\"" + rc.getLowerBound() + "..";
		} else {
			cad += parentName + " " + line + ">\"" + rc.getLowerBound() + "..";
		}

		if (rc.getUpperBound() == -1) {
			cad += "*";
		} else {
			cad += rc.getUpperBound();
		}
		cad += "\"";
		ClassControl type = rc.getType();
		if (type != null) {
			if (!hasActualTagUpdate(type) && !hasNewTagUpdate(type)){
				String cad2=getClassText(type, true)+ENTR+cad;
				cad=cad2;
			}
			cad += type.getName() + " : ";
		} else {
			cad += "Ø : ";
			nullReference = true;
		}
		cad += nameStart+rc.getName() + nameEnd;
		return cad;
	}

}