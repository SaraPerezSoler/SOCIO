package es.uam.app.uml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uam.app.actions.ActionModel;
import es.uam.app.actions.Create;
import es.uam.app.actions.Remove;
import es.uam.app.actions.Update;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.PackageControl;
import es.uam.app.projects.ecore.ReferenceControl;

public abstract class CreateUML {

	public static final String GREEN_BACKGROUND = "#D7F7BA";
	public static final String GREEN_LINES = "#458A03";
	public static final String RED_BACKGROUND = "#F59D9D";

	public static final String ORANGE_LINES = "#458A03";
	public static final String ORANGE_BACKGROUND = "#F7BE81";
	
	private static final String WHITE_BACKGROUND = "#FFFFFF";
	private static final String GRAY_LINES = "#BDBDBD";

	public static final String ENTR = "\r\n";

	public static final String CLASS_NEW = "<<New>>";

	public static final String ATTR_NEW_INI = "<b><color:" + GREEN_LINES + ">";
	public static final String ATTR_NEW_FIN = "</color></b>";

	public static final String DELETE_NOTE_INI = "note as Delete " + RED_BACKGROUND + ENTR
			+ "This elements have been deleted:" + ENTR;
	public static final String UPDATE_NOTE_INI = "note as Update " + ORANGE_BACKGROUND + ENTR
			+ "This elements have been updated:" + ENTR;
	public static final String NOTE_FIN = "end note" + ENTR;

	public static final String START = "@startuml" + ENTR + ENTR;
	private static final String CLASS_NULL = "<<???>>";
	
	

	public static final String START_CLASS_DIAGRAM = START + "skinparam class {" + ENTR 
			+ "BackgroundColor" + CLASS_NEW + " " + GREEN_BACKGROUND + ENTR 
			+ "BorderColor" + CLASS_NEW + " " + GREEN_LINES + ENTR 
			+ "BackgroundColor" + CLASS_NULL + " " + WHITE_BACKGROUND + ENTR 
			+ "BorderColor" + CLASS_NULL + " " + GRAY_LINES + ENTR
			+ "}" + ENTR;
	public static final String END = ENTR + "@enduml";

	private static final String CLASS = "Class";
	private static final String ATTR = "Attr";
	private static final String REF = "Ref";

	private static List<ActionModel> adds;
	private static List<ActionModel> deletes;
	private static List<Update> updates;
	private static Map<String, List<Controlador>> addControl;
	private static Map<String, List<Controlador>> deleteControl;
	private static Map<String, List<Controlador>> updateControl;
	private boolean nullReference=false;
	
	
	public String createUML(List<ActionModel> act) {
		String cad = START_CLASS_DIAGRAM;

		getAdds(act);
		getDeletes(act);
		getUpdates(act);
		addControl = getControlador(adds);
		deleteControl = getControlador(deletes);
		updateControl = getUpdateControlador(updates);

		PackageControl pc = this.getPackage();
		for (ClassControl cc : pc.getClasses()) {
			cad += getClassText(cc);
		}
		cad += updates();
		cad += deletedElements();
		cad += END;
		return cad;
	}

	/*
	 * private Map<String, List<Controlador[]>>
	 * getUpdateControlador(List<Update> updates2) { List<Controlador[]>
	 * clas=new ArrayList<Controlador[]>(); List<Controlador[]> attr= new
	 * ArrayList<Controlador[]>(); List<Controlador[]> ref=new
	 * ArrayList<Controlador[]>(); Map<String, List<Controlador[]>>ret= new
	 * HashMap<String, List<Controlador[]>>();
	 * 
	 * for (Update a : updates2){ Controlador[] c= new Controlador[2]; c[0]=
	 * a.getObject(); c[1]=a.getOld(); if (c[0] instanceof ClassControl){
	 * clas.add(c); }else if (c[0] instanceof AttributeControl){ attr.add(c);
	 * }else if (c[0] instanceof ReferenceControl){ ref.add(c); } }
	 * 
	 * ret.put(CLASS, clas); ret.put(ATTR, attr); ret.put(REF, ref); return ret;
	 * }
	 */

	private Map<String, List<Controlador>> getUpdateControlador(List<Update> updates2) {
		List<Controlador> clas = new ArrayList<Controlador>();
		List<Controlador> attr = new ArrayList<Controlador>();
		List<Controlador> ref = new ArrayList<Controlador>();
		Map<String, List<Controlador>> ret = new HashMap<String, List<Controlador>>();

		for (ActionModel a : updates2) {
			Controlador c = a.getObject();
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

	public abstract PackageControl getPackage();

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

	private String updates() {
		if (updates.isEmpty()) {
			return "";
		}
		String cad = UPDATE_NOTE_INI;
		for (Update u : updates) {
			cad += u.toString() + "\n";
		}

		cad += NOTE_FIN;
		return cad;
	}

	private void getAdds(List<ActionModel> act) {
		adds = new ArrayList<ActionModel>();
		for (ActionModel a : act) {
			if (a instanceof Create) {
				adds.add(a);
			}
		}

	}

	private void getDeletes(List<ActionModel> act) {
		deletes = new ArrayList<ActionModel>();
		for (ActionModel a : act) {
			if (a instanceof Remove) {
				deletes.add(a);
			}
		}
	}

	private void getUpdates(List<ActionModel> act) {
		updates = new ArrayList<Update>();
		for (ActionModel a : act) {
			if (a instanceof Update) {
				updates.add((Update) a);
			}
		}
	}

	private Map<String, List<Controlador>> getControlador(List<ActionModel> act) {
		List<Controlador> clas = new ArrayList<Controlador>();
		List<Controlador> attr = new ArrayList<Controlador>();
		List<Controlador> ref = new ArrayList<Controlador>();
		Map<String, List<Controlador>> ret = new HashMap<String, List<Controlador>>();

		for (ActionModel a : act) {
			Controlador c = a.getObject();
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

	private String getClassText(ClassControl cc) {
		List<Controlador> clas = addControl.get(CLASS);
		String cad = "";
		String name1 = cc.getName();
		if (name1.equals("Class")) {
			name1 = "\"" + cc.getName() + "\"";
		}
		String name = name1;
		for (Controlador c : clas) {
			if (cc.equals(c)) {
				name += CLASS_NEW;
			}
		}

		if (cc.getInterface()) {
			cad += "interface " + name + " {" + ENTR;
		} else {
			if (cc.getAbstract()) {
				cad += "abstract ";
			}
			cad += "class " + name + " {" + ENTR;
		}
		for (AttributeControl ac : cc.getAttributes()) {
			cad += getAttributeText(ac);
		}
		cad += "}" + ENTR;
		for (ClassControl superType : cc.getSuperTypes()) {
			cad += superType.getName() + " <|-- " + name1 + ENTR;
		}
		nullReference=false;
		for (ReferenceControl rc : cc.getReferences()) {
			cad += getReference(rc);
		}
		if (nullReference){
			cad+= ENTR+"class \"Ø\" <<(?,"+GRAY_LINES+") ???>>{"+ENTR+"}"+ENTR;
		}

		return cad;

	}

	private String getAttributeText(AttributeControl ac) {
		List<Controlador> attr = addControl.get(ATTR);
		List<Controlador> attrUpd = updateControl.get(ATTR);
		String cad = "";
		String cadFin = ENTR;

		if (attr.contains(ac) || attrUpd.contains(ac)) {
			cad = ATTR_NEW_INI;
			cadFin = ATTR_NEW_FIN + ENTR;
		}

		String type;
		if (ac.getType() != null) {
			type= ac.getType().getInstanceClass().getSimpleName() + " ";
		}else{
			type= "?? ";
		}

		cad += "[" + ac.getLowerBound() + ",";
		if (ac.getUpperBound() == -1) {
			cad += "* ] ";
		} else {
			cad += ac.getUpperBound() + "] ";
		}
		cad += ac.getName()+": "+type + cadFin;
		return cad;

	}

	private String getReference(ReferenceControl rc) {
		List<Controlador> ref = addControl.get(REF);

		String cad = "";
		String line = "--";

		for (Controlador c : ref) {
			if (rc.equals(c)) {
				line = "-[" + GREEN_LINES + "]-";
			}
		}
		String parentName="";
		if (rc.getParent()==null){
			parentName="null";
		}else{
			parentName=rc.getParent().getName();
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
			cad += type.getName() + " : ";
		}else{
			cad +="Ø : ";
			nullReference=true;
		}
		cad += rc.getName() + ENTR;
		return cad;
	}

}
