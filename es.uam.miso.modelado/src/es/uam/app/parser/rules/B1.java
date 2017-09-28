package es.uam.app.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.projects.ecore.IsClass;
import es.uam.app.projects.ecore.IsReference;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;

public class B1 extends MetemodelRule {

	// <A> <verb> <B>

	private List<NP[]> A_B;
	private final static String examples[]={"Carriers can handle deliveries.", "The student passed the exams.", "The cheque is sent to the bank."};

	public B1(Sentence<MetamodelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public String toString() {
		String cad= "B1 [";
		for (NP[] a_b: A_B){
			cad+="[A=" + a_b[0] + ", verb=" + verb + ", B=" + a_b[1] + "]";
		}
		
		cad+="]";
		return cad;
	}


	@Override
	public List<Action> evaluete(MetamodelProject proj, int i) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
			NP A = A_B.get(i)[0];
			NP B = A_B.get(i)[1];

			// Comprobamos si exite la clase A, sino ponemos una accion para
			// crearla.
			IsClass classA = IsClass.getClass(A, proj);
			if (classA instanceof Action) {
				ret.add((Action) classA);
			}

			// Comprobamos si exite la clase B, sino ponemos una accion para
			// crearla.
			IsClass classB = IsClass.getClass(B, proj);
			if (classB instanceof Action) {
				ret.add((Action) classB);
			}

			IsReference ref = null;
			if (i > 0) {
				ref = IsReference.getReference(verb.lowerCammelCase() + i, classA, B.getMin(), B.getMax(), proj, false);
			} else {
				ref = IsReference.getReference(verb.lowerCammelCase(), classA, B.getMin(), B.getMax(), proj, false);
			}

			if (ref instanceof Action) {
				ret.add((Action) ref);
			}
			// Se crea la accion para dale Typo a la referencia.
			UpdateRefType urt = new UpdateRefType(proj, ref, classB);
			ret.add(urt);
		return ret;
	}

	@Override
	public boolean validate() {
		List<NP> subj = sentence.getSubj(verb);
		List<NP> dobj = null;
		if (verb.isVerbWithPrep()) {
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
				NP[] aux = new NP[2];
				aux[0] = s;
				aux[1] = d;
				A_B.add(aux);
			}
		}

		return true;
	}

	@Override
	public int getPriority() {
		return 0;
	}
	
	@Override
	public int numEvaluete() {
		if (A_B.isEmpty()){
			return 0;
		}
		return A_B.size();
	}

	@Override
	public boolean isPosibility() {
		return true;
	}

	public static String[] getExamples() {
		return examples;
	}

	public static String getStructure() {
		return "<Object> + <verb> + <Object>";
	}

}
