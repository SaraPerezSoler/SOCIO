package es.uam.app.projects;

import java.io.FileNotFoundException;

import es.uam.app.actions.metamodels.ChangeAttrForRef;
import es.uam.app.actions.metamodels.CreateReference;
import es.uam.app.metamodel.parser.NP;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.Feature;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import net.didion.jwnl.JWNLException;
import socioProjects.MetamodelProject;

public interface IsReference extends IsInterface{

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

	public static IsReference getReference(NP ref, IsClass of, MetamodelProject proj, boolean containment)
			throws FileNotFoundException, JWNLException {
	
		if (of instanceof ClassControl) {
			Feature f = proj.getFeature(ref.lowerCammelCase(), (ClassControl) of);
			if (f != null) {
				if (f instanceof ReferenceControl) {
					return (ReferenceControl) f;
				} else {
					return new ChangeAttrForRef(proj, (AttributeControl) f, ref.getMax(), containment);
				}
			}
			f = proj.getFeature(ref.lemmaLowerCammelCase(), (ClassControl) of);
			if (f != null) {
				if (f instanceof ReferenceControl) {
					return (ReferenceControl) f;
				} else {
					return new ChangeAttrForRef(proj, (AttributeControl) f, ref.getMax(), containment);
				}
			}
			
			return new CreateReference(proj, ref.lowerCammelCase(), of, ref.getMin(), ref.getMax(), containment);
		} else {
			return new CreateReference(proj, ref.lowerCammelCase(), of, ref.getMin(), ref.getMax(), containment);
		}
	}

	public static IsReference getReference(String ref, IsClass of, int min, int max, MetamodelProject proj, boolean containment)
			throws FileNotFoundException, JWNLException {
		if (of instanceof ClassControl) {
			Feature f = proj.getFeature(ref, (ClassControl) of);
			if (f != null) {
				if (f instanceof ReferenceControl) {
					return (ReferenceControl) f;
				} else {
					return new ChangeAttrForRef(proj, (AttributeControl) f, max, containment);
				}
			}
			return new CreateReference(proj, ref, of, min, max, containment);
		} else {
			return new CreateReference(proj, ref, of, min, max, containment);
		}
	}

	public static IsReference getExactlyReference(NP ref, IsClass of, MetamodelProject proj, boolean containment)
			throws FileNotFoundException, JWNLException {
		
		return getExactlyReference(ref.lowerCammelCase(), of, ref.getMin(), ref.getMax(), proj, containment);
	}

	public static IsReference getExactlyReference(String ref, IsClass of, int min, int max, MetamodelProject proj,
			boolean containment) throws FileNotFoundException, JWNLException {
		if (of instanceof ClassControl) {
			Feature f = proj.getExactlyFeature(ref, (ClassControl) of);
			if (f != null) {
				if (f instanceof ReferenceControl) {
					return (ReferenceControl) f;
				} else {
					return new ChangeAttrForRef(proj, (AttributeControl) f, max, containment);
				}
			}
			return new CreateReference(proj, ref, of, min, max, containment);
		} else {
			return new CreateReference(proj, ref, of, min, max, containment);
		}
	}

	public ReferenceControl getReferenceControl() throws Exception;

	public int getMin();

	public int getMax();
}
