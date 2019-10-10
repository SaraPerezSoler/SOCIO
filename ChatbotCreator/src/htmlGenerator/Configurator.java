package htmlGenerator;

import java.util.List;

import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;

public class Configurator {

	public static String getSuperClass(List<NLClass> superClasses) {
		if (superClasses == null || superClasses.isEmpty()) {
			return "";
		}
		String text = ": ";
		for (NLClass nlSuper : superClasses) {
			text += getNLClassName(nlSuper) + " ";
		}
		return text;
	}

	public static String getNLClassName(NLClass nlClass) {

		return nlClass.getName();
	}

	public static String getNLClassId(NLClass nlClass) {
		return "Class:" + nlClass.getName();
	}

	public static String getNLFeatureId(NLFeature feature) {
		NLClass nlClass = (NLClass) feature.eContainer();
		String ini = "";
		if (feature instanceof NLAttribute) {
			ini = "Attribute:";
		} else {
			ini = "Reference:";
		}
		return ini + nlClass.getName() + "_" + feature.getName();
	}

	public static String getNLFeature(NLFeature feature) {
		String min = String.valueOf(feature.getFeature().getLowerBound());
		String max;
		int maxInt = feature.getFeature().getUpperBound();
		if (maxInt == -1) {
			max = "*";
		} else {
			max = String.valueOf(maxInt);
		}

		return "[" + min + "," + max + "] " + feature.getName() + ": " + feature.getFeature().getEType().getName();

	}

}
