package es.uam.app.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import es.uam.app.actions.ActionModel;
import es.uam.app.actions.metamodels.RemoveAttribute;
import es.uam.app.actions.metamodels.RemoveClass;
import es.uam.app.actions.metamodels.RemoveReference;
import es.uam.app.actions.metamodels.UpdateClassRemoveSuperType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Feature;
import es.uam.app.projects.ecore.ReferenceControl;
import net.didion.jwnl.JWNLException;

public class RemoveRule extends MetemodelRule {

	private static final String[] DELETE_WORDS = { "remove", "delete", "erase" };
	private List<NP[]> dobj_to;
	private final static String examples[]={"Remove person.", "Delete work from person.", "Erase numeric age from person."};
	
	public RemoveRule(Sentence<MetaModelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public List<ActionModel> evaluete(MetaModelProject proj, int i) throws FileNotFoundException, JWNLException {
		List<ActionModel> ret = new ArrayList<ActionModel>();
		NP dobj = dobj_to.get(i)[0];
		NP to = dobj_to.get(i)[1];
		if (to != null) {
			IsClass toClass = IsClass.getClass(to, proj);
			if (toClass instanceof ClassControl) {
				Feature f = proj.getFeature(dobj.lowerCammelCase(), (ClassControl) toClass);
				if (f != null) {
					if (f instanceof AttributeControl) {
						RemoveAttribute ra = new RemoveAttribute(proj, (AttributeControl) f);
						ret.add(ra);
					} else {
						RemoveReference rr = new RemoveReference(proj, (ReferenceControl) f);
						ret.add(rr);
					}
				}
			}
		} else {

			ClassControl c = proj.getClass(dobj);
			if (c != null) {
				List<ReferenceControl> references = proj.getRefTo(c);
				for (ReferenceControl r : references) {
					UpdateRefType upr = new UpdateRefType(proj, r, null);
					ret.add(upr);
				}
				List<ClassControl> subTypes = proj.getSubTypesOf(c);
				for (ClassControl subType : subTypes) {
					UpdateClassRemoveSuperType ucrst = new UpdateClassRemoveSuperType(proj, subType, c);
					ret.add(ucrst);
				}

				RemoveClass rc = new RemoveClass(proj, c);
				ret.add(rc);
			} else {
				Feature f = proj.getFeature(dobj.lowerCammelCase());
				if (f != null) {
					if (f instanceof AttributeControl) {
						RemoveAttribute ra = new RemoveAttribute(proj, (AttributeControl) f);
						ret.add(ra);
					} else {
						RemoveReference rr = new RemoveReference(proj, (ReferenceControl) f);
						ret.add(rr);
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
