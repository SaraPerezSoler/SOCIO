package es.uam.app.projects.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public interface MetamodelControl extends Controlador{

	final EcoreFactory factory = EcoreFactory.eINSTANCE;
	final EcorePackage ecorePack = EcorePackage.eINSTANCE;
	
	public static List<EClassifier> getTypes() {
		return ecorePack.getEClassifiers();
	}

	public static EClassifier getType(String type) {

		EClassifier type1 = ecorePack.getEClassifier(type);
		if (type1 != null) {
			return type1;
		}
		for (EClassifier ec : ecorePack.getEClassifiers()) {
			// String[] aux = ec.getInstanceTypeName();
			String aux = ec.getInstanceTypeName();
			aux = aux.replace(".", " ");
			String[] aux2 = aux.split(" ");
			if (aux2.length > 0) {
				String typeClass = aux2[aux2.length - 1];
				if (typeClass.compareToIgnoreCase(type) == 0) {
					return ec;
				}
			}
		}
		Map<String, EClassifier> options = getOptions();
		Set<String> keys = options.keySet();
		for (String key : keys) {
			if (key.equalsIgnoreCase(type)) {
				return options.get(key);
			}
		}

		return null;
	}

	public static Map<String, EClassifier> getOptions() {

		Map<String, EClassifier> options = new HashMap<>();
		options.put("numeric", ecorePack.getEClassifier("EInt"));
		options.put("text", ecorePack.getEClassifier("EString"));
		return options;
	}
	

	public default void setAnnotation(String annotation) {
		EAnnotation eannotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eannotation.setSource(annotation);
		if (getObject() instanceof EModelElement) {
			((EModelElement) getObject()).getEAnnotations().add(eannotation);
		}

	}

	public default void removeAnnotation(String start) {
		List<EAnnotation> remove = new ArrayList<EAnnotation>();
		List<EAnnotation> annotations = this.getAnnotations();
		for (EAnnotation a : annotations) {
			if (a.getSource().startsWith(start)) {
				remove.add(a);
			}
		}

		annotations.removeAll(remove);

	}
	
	public default List<EAnnotation> getAnnotations() {

		if (getObject() instanceof EModelElement) {
			return ((EModelElement) getObject()).getEAnnotations();
		}
		return null;

	}
}
