package es.uam.app.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import es.uam.app.actions.metamodels.UpdateAttrType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.emf.metamodel.ClassControl;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;

public class AddRule extends MetemodelRule {

	private List<NP[]> dobj_in;
	private static final String[] ADD_WORDS = { "add", "create", "make" };
	private final static String examples[]={"Add person.", "Add work in person.", "Add numeric age in person."};


	public AddRule(Sentence<MetamodelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public List<Action> evaluete(MetamodelProject proj, int i) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
		NP dobj = dobj_in.get(i)[0];
		NP in = dobj_in.get(i)[1];

		if (in == null) {
			IsClass dobjClass = IsClass.getExactlyClass(dobj, proj);
			super.addIfNecesary(dobjClass, ret);
			
		} else {
			IsClass inClass = IsClass.getExactlyClass(in, proj);
			super.addIfNecesary(inClass, ret);

			if (!dobj.getAdj().isEmpty()) {
		
				EClassifier type = dobj.adjType();
				if (type != null) {
					
					IsAttribute inAtt = IsAttribute.getExactlyAttribute(dobj.getNoun().getLemma(), inClass, dobj.getMin(), dobj.getMax(), proj);
					super.addIfNecesary(inAtt, ret);
					UpdateAttrType uat = new UpdateAttrType(proj, inAtt, type.getName(),dobj.getMax());
					ret.add(uat.getAction());

				} else {
					IsClass adjClass = IsClass.getExactlyClass(dobj.getAdjCammelCase(), proj);
					if (adjClass instanceof ClassControl) {
						
						IsReference ref = IsReference.getExactlyReference(dobj.getNoun().getLemma(), inClass, dobj.getMin(), dobj.getMax(), proj, false);
						super.addIfNecesary(ref, ret);

						UpdateRefType urt = new UpdateRefType(proj, ref, adjClass, dobj.getMax());
						ret.add(urt.getAction());
					} else {
						IsAttribute inAtt = IsAttribute.getExactlyAttribute(dobj, inClass, proj);
						super.addIfNecesary(inAtt, ret);
					}
				}

			} else {
				IsAttribute inAtt = IsAttribute.getExactlyAttribute(dobj, inClass, proj);
				super.addIfNecesary(inAtt, ret);
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		String cad = "Add[";
		for (NP[] d_i : dobj_in) {
			cad += "[dobj=" + d_i[0] + ", in=" + d_i[1] + "]";
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
			if (this.isAdd()) {
				List<NP> dobj = sentence.getDobj(verb);
				List<NP> nmod = sentence.getNmod(verb);
				// Si tiene objeto directo
				if (!dobj.isEmpty()) {
					// Se cumple que es una regla valida, ahora solo rellenamos
					// los campos
					dobj_in = new ArrayList<NP[]>();
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
						dobj_in.add(aux);
					}
					return true;
				}
			}
		}
		return false;

	}

	private boolean isAdd() {
		String v = verb.getWordsStringWithAux();

		for (String s : ADD_WORDS) {
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
		if (dobj_in.isEmpty()) {
			return 0;
		}
		return dobj_in.size();
	}

	@Override
	public boolean isPosibility() {
		return isAdd();
	}


	public static String[] getExamples() {
		return examples;
	}

	public static String getStructure() {
		String ret="";
		for (int i=0; i<ADD_WORDS.length; i++){
			ret+=ADD_WORDS[i];
			if (i!= ADD_WORDS.length-1){
				ret+="/";
			}
		}
		ret+=" + <Object>";
		return ret;
	}

}
