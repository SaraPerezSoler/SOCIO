package es.uam.app.metamodel.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import es.uam.app.actions.metamodels.RemoveAttribute;
import es.uam.app.actions.metamodels.RemoveClass;
import es.uam.app.actions.metamodels.RemoveReference;
import es.uam.app.actions.metamodels.UpdateClassRemoveSuperType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.metamodel.parser.NP;
import es.uam.app.metamodel.parser.Sentence;
import es.uam.app.metamodel.parser.Verb;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.Feature;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;


public class RemoveRule extends MetamodelRule {

	private static final String[] DELETE_WORDS = { "remove", "delete", "erase" };
	private List<NP[]> dobj_to;
	private final static String examples[]={"Remove person.", "Delete work from person.", "Erase numeric age from person."};
	
	public RemoveRule(Sentence<MetamodelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public List<Action> evaluete(MetamodelProject proj, int i) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
		NP dobj = dobj_to.get(i)[0];
		NP to = dobj_to.get(i)[1];
		if (to != null) {
			IsClass toClass = IsClass.getClass(to, proj);
			if (toClass instanceof ClassControl) {
				Feature f = proj.getFeature(dobj.lowerCammelCase(), (ClassControl) toClass);
				if (f != null) {
					if (f instanceof AttributeControl) {
						RemoveAttribute ra = new RemoveAttribute(proj, (AttributeControl) f);
						ret.add(ra.getAction());
					} else {
						RemoveReference rr = new RemoveReference(proj, (ReferenceControl) f);
						ret.add(rr.getAction());
					}
				}
			}
		} else {

			ClassControl c = proj.getClass(dobj);
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
			} else {
				Feature f = proj.getFeature(dobj.lowerCammelCase());
				if (f != null) {
					if (f instanceof AttributeControl) {
						RemoveAttribute ra = new RemoveAttribute(proj, (AttributeControl) f);
						ret.add(ra.getAction());
					} else {
						RemoveReference rr = new RemoveReference(proj, (ReferenceControl) f);
						ret.add(rr.getAction());
					}
				}
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		String cad = "RemoveRule [";
		for (NP[] d_t : dobj_to) {
			cad += "[dobj=" + d_t[0] + ", to=" + d_t[1] + "]";
		}
		cad += "]";
		return cad;
	}

	@Override
	public boolean validate() {
		List<NP> subj = sentence.getSubj(verb);
		// si no tiene sujeto
		if (subj.isEmpty()) {
			// si el verbo es de los de la lista de add.
			if (this.isDelete()) {
				List<NP> dobj = sentence.getDobj(verb);
				List<NP> nmod = sentence.getNmod(verb);
				// Si tiene objeto directo
				if (!dobj.isEmpty()) {
					// Se cumple que es una regla valida, ahora solo rellenamos
					// los campos
					dobj_to = new ArrayList<NP[]>();
					for (NP d : dobj) {
						NP[] aux = new NP[2];
						// miramos los modificadores buscando las clases
						List<NP> nmodD = sentence.getNps(d, "nmod");

						if (nmodD.isEmpty()) {
							if (!nmod.isEmpty()) {
								for (NP nm : nmod) {
									aux[0] = d;
									aux[1] = nm;
								}
							} else {
								aux[0] = d;
								aux[1] = null;
							}
						} else {
							for (NP nm : nmodD) {
								aux[0] = d;
								aux[1] = nm;
							}
						}
						dobj_to.add(aux);
					}
					return true;
				}
			}
		}
		return false;
	}

	private boolean isDelete() {
		String v = verb.getWordsStringWithAux();

		for (String s : DELETE_WORDS) {
			if (s.equalsIgnoreCase(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public int numEvaluete() {
		if (dobj_to.isEmpty()) {
			return 0;
		}
		return dobj_to.size();
	}

	@Override
	public boolean isPosibility() {
		return isDelete();
	}


	public static String[] getExamples() {
		return examples;
	}
	public static String getStructure() {
		String ret="";
		for (int i=0; i<DELETE_WORDS.length; i++){
			ret+=DELETE_WORDS[i];
			if (i!= DELETE_WORDS.length-1){
				ret+="/";
			}
		}
		ret+=" + <Object>";
		return ret;
	}
}
