package es.uam.app.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import es.uam.app.actions.metamodels.CreateClass;
import es.uam.app.actions.metamodels.UpdateAttrType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.IsAttribute;
import es.uam.app.projects.ecore.IsClass;
import es.uam.app.projects.ecore.IsReference;
import net.didion.jwnl.JWNLException;
import projectHistory.impl.ActionImpl;

public class D1ToHave extends MetemodelRule {

	// <A> has <B>

	private List<NP[]> A_B;
	private final static String examples[]={"Bulky packages are characterized by their width, length and height.", "Students have a numeric identifier.", "Medicines have an active ingredient."};

	private static final String[] HAVE_WORDS = { "have", "be characterized by", "be identified by",
			"be recognized by" };

	public D1ToHave(Sentence<MetaModelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public String toString() {
		String ret = "D1ToHave [";

		for (NP[] a_b : A_B) {
			ret += "[A=" + a_b[0] + ", B=" + a_b[0] + "]";
		}
		ret += "]";
		return ret;
	}

	@Override
	public List<ActionImpl> evaluete(MetaModelProject proj, int i) throws FileNotFoundException, JWNLException {

		List<ActionImpl> ret = new ArrayList<ActionImpl>();
		NP A = A_B.get(i)[0];
		NP B = A_B.get(i)[1];
		// A has B// A es una clase del metamodelo
		IsClass aClass = IsClass.getClass(A, proj);
		if (aClass instanceof ActionImpl) {
			ret.add((ActionImpl) aClass);
		}
		// Si B tiene adjetivo
		
		EClassifier type = B.adjType();
		
		// Si B.adjetivo es un tipo definido de ecore.
		if (type != null) {
			// B.noun es un atributo...

			IsAttribute att = IsAttribute.getAttribute(B.getNoun().getLemma(), aClass, B.getMin(), B.getMax(), proj);
			if (att instanceof ActionImpl) {
				ret.add((ActionImpl) att);
			}
			// ...con tipo B.adjetivo.
			UpdateAttrType uat = new UpdateAttrType(proj, att, type.getName());
			ret.add(uat);
			// Si B.adjetivo no es un tipo definido de ecore
		} else {

			IsClass bClass = IsClass.getClass(B, proj);
			if (bClass instanceof CreateClass &&  B.getAdjCammelCase()!=null && !B.getAdjCammelCase().equals("")) {
				bClass = IsClass.getClass(B.getAdjCammelCase(), proj);
			}
			// Si es una clase del metamodelo
			if (bClass instanceof ClassControl) {
				// B.noun es una referencia...
				IsReference ref = IsReference.getReference(B, aClass, proj, false);
				if (ref instanceof ActionImpl) {
					ret.add((ActionImpl) ref);
				}
				// ...con tipo B.adjetive
				UpdateRefType urt = new UpdateRefType(proj, ref, bClass);
				ret.add(urt);
				// Si B.adjetive no es ni un tipo definido de ecore ni
				// una clase creada previamente
			} else {
				// B es un elemento sin definir que primero que pondrá
				// como adjetivo sin tipo
				IsAttribute att = IsAttribute.getAttribute(B, aClass, proj);
				if (att instanceof ActionImpl) {
					ret.add((ActionImpl) att);
				}
			}
		}

		return ret;
	}

	@Override
	public boolean validate() {
		if (isHave()) {
			List<NP> subj = sentence.getSubj(verb);
			List<NP> dobj = null;

			if (sentence.isPassive(verb)) {
				dobj = sentence.getNmod(verb);
			} else {
				dobj = sentence.getDobj(verb);
			}

			if (subj.isEmpty()) {
				return false;
			}
			if (dobj.isEmpty()) {
				return false;
			}
			
			A_B = new ArrayList<>();
			for (NP s : subj) {
				for (NP d : dobj) {
					if (verb.hasMayCanAux()){
						d.setMin(0);
					}
					
					NP[] a_b = new NP[2];
					a_b[0] = s;
					a_b[1] = d;
					A_B.add(a_b);
				}
			}
			return true;
		}
		return false;
	}

	private boolean isHave() {
		String verbString = verb.getWordsStringWithAux();
		for (String s : HAVE_WORDS) {
			if (s.equalsIgnoreCase(verbString)) {
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
		if (A_B.isEmpty()) {
			return 0;
		}
		return A_B.size();
	}

	@Override
	public boolean isPosibility() {
		return isHave();
	}

	public static String[] getExamples() {
		return examples;
	}

	public static String getStructure() {
		String ret="<Object> + ";
		for (int i=0; i<HAVE_WORDS.length; i++){
			ret+=HAVE_WORDS[i];
			if (i!= HAVE_WORDS.length-1){
				ret+="/";
			}
		}
		ret+="+ <Object>";
		return ret;
	}
}
