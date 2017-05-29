package es.uam.app.parser.rules;

import java.io.FileNotFoundException;

import es.uam.app.actions.ChangeAttrForRef;
import es.uam.app.actions.CreateReference;
import es.uam.app.parser.NP;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Feature;
import es.uam.app.projects.ecore.ReferenceControl;
import net.didion.jwnl.JWNLException;

public interface IsReference {

//	public static IsReference getReference(NP ref, IsClass of, Project proj)
//			throws FileNotFoundException, JWNLException {
//		int min = 0;
//		int max = 1;
//		if (ref.isPlural()) {
//			max = -1;
//		}
//		return getReference(ref.lowerCammelCase(), of, min, max, proj, false);
//	}
//
//	public static IsReference getReference(String ref, IsClass of, int min, int max, Project proj)
//			throws FileNotFoundException, JWNLException {
//		if (of instanceof ClassControl) {
//			Feature f = proj.getFeature(ref, (ClassControl) of);
//			if (f != null) {
//				if (f instanceof ReferenceControl) {
//					return (ReferenceControl) f;
//				} else {
//					return new ChangeAttrForRef(proj, (AttributeControl) f, min, max);
//				}
//			}
//			return new CreateReference(proj, ref, of, min, max);
//		} else {
//			return new CreateReference(proj, ref, of, min, max);
//		}
//	}

	public static IsReference getReference(NP ref, IsClass of, Project proj, boolean containment)
			throws FileNotFoundException, JWNLException {
		int min = 0;
		int max = 1;
		if (ref.isPlural()) {
			max = -1;
		}
		return getReference(ref.lowerCammelCase(), of, min, max, proj, containment);
	}

	public static IsReference getReference(String ref, IsClass of, int min, int max, Project proj, boolean containment)
			throws FileNotFoundException, JWNLException {
		if (of instanceof ClassControl) {
			Feature f = proj.getFeature(ref, (ClassControl) of);
			if (f != null) {
				if (f instanceof ReferenceControl) {
					return (ReferenceControl) f;
				} else {
					return new ChangeAttrForRef(proj, (AttributeControl) f, min, max, containment);
				}
			}
			return new CreateReference(proj, ref, of, min, max, containment);
		} else {
			return new CreateReference(proj, ref, of, min, max, containment);
		}
	}

	public static IsReference getExactlyReference(NP ref, IsClass of, Project proj, boolean containment)
			throws FileNotFoundException, JWNLException {
		int min = 0;
		int max = 1;
		if (ref.isPlural()) {
			max = -1;
		}
		return getExactlyReference(ref.lowerCammelCase(), of, min, max, proj, containment);
	}

	public static IsReference getExactlyReference(String ref, IsClass of, int min, int max, Project proj,
			boolean containment) throws FileNotFoundException, JWNLException {
		if (of instanceof ClassControl) {
			Feature f = proj.getExactlyFeature(ref, (ClassControl) of);
			if (f != null) {
				if (f instanceof ReferenceControl) {
					return (ReferenceControl) f;
				} else {
					return new ChangeAttrForRef(proj, (AttributeControl) f, min, max, containment);
				}
			}
			return new CreateReference(proj, ref, of, min, max, containment);
		} else {
			return new CreateReference(proj, ref, of, min, max, containment);
		}
	}

	public ReferenceControl getReferenceControl() throws Exception;
}
