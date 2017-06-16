package es.uam.app.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import es.uam.app.actions.ActionModel;
import es.uam.app.actions.metamodels.CreateClass;
import es.uam.app.actions.metamodels.UpdateAttrType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.parser.WordConfigure;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.MetamodelControl;
import net.didion.jwnl.JWNLException;

public class B4Contain extends MetemodelRule {

	// <A> contain <B>
	private List<NP[]> A_B;
	private final static String examples[]={"The house is made of rooms.", "Students contains a numeric identifier.",};


	private static final String[] CONTAINS_WORDS = { "contain", "be made of","be made up of", "be made from", " be composed", "include" };
	private static final String[] REVERSE_IF_PASSIVE={ "contain", "include"};
	

	public B4Contain(Sentence<MetaModelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public String toString() {
		String ret= "B4Contain [";
		for (NP[] a_b:A_B){
			ret+="[A=" + a_b[0] + ", B=" + a_b[1] + "]";
		}
		
		ret+="]";
		return ret;
	}

	@Override
	public List<ActionModel> evaluete(MetaModelProject proj, int i) throws FileNotFoundException, JWNLException {
		
		List<ActionModel> ret = new ArrayList<ActionModel>();
			NP A=A_B.get(i)[0];
			NP B=A_B.get(i)[1];
			IsClass aClass = IsClass.getClass(A, proj);
			if (aClass instanceof ActionModel) {
				ret.add((ActionModel) aClass);
			}

			if (B.getAdj() != null) {
				String bAdjLemmaUpper= WordConfigure.startUpperCase(B.getAdj().getLemma());
				EClassifier type = MetamodelControl.getType(bAdjLemmaUpper);
				// Si B.adjetivo es un tipo definido de ecore.
				if (type != null) {
					// B.noun es un atributo...
					int min = 0;
					int max = 1;
					if (B.isPlural()) {
						max = -1;
					}
					IsAttribute att = IsAttribute.getAttribute(B.getNoun().getWord(), aClass, min, max, proj);
					if (att instanceof ActionModel) {
						ret.add((ActionModel) att);
					}
					// ...con tipo B.adjetivo.
					UpdateAttrType uat = new UpdateAttrType(proj, att, bAdjLemmaUpper);
					ret.add(uat);
					// Si B.adjetivo no es un tipo definido de ecore
				} else {

					IsClass bClass = IsClass.getClass(B, proj);
					if (bClass instanceof CreateClass){
						bClass= IsClass.getClass(bAdjLemmaUpper, proj);
					}
					// Si es una clase del metamodelo
					if (bClass instanceof ClassControl) {
						// B.noun es una referencia...
						IsReference ref = IsReference.getReference(B, aClass, proj, true);
						if (ref instanceof ActionModel) {
							ret.add((ActionModel) ref);
						}
						// ...con tipo B.adjetive
						UpdateRefType urt = new UpdateRefType(proj, ref, bClass);
						ret.add(urt);
						// Si B.adjetive no es ni un tipo definido de ecore ni
						// una
						// clase creada previamente
					} else {
						bClass = IsClass.getClass(B, proj);
						if (bClass instanceof ActionModel) {
							ret.add((ActionModel) bClass);
						}

						IsReference bRef = IsReference.getReference(B, aClass, proj, true);
						if (bRef instanceof ActionModel) {
							ret.add((ActionModel) bRef);
						}
						UpdateRefType urt = new UpdateRefType(proj, bRef, bClass);
						ret.add(urt);
					}
				}
			} else {
				IsClass bClass = IsClass.getClass(B, proj);
				if (bClass instanceof ActionModel) {
					ret.add((ActionModel) bClass);
				}

				IsReference bRef = IsReference.getReference(B, aClass, proj, true);
				if (bRef instanceof ActionModel) {
					ret.add((ActionModel) bRef);
				}
				UpdateRefType urt = new UpdateRefType(proj, bRef, bClass);
				ret.add(urt);
			}
		return ret;
	}

	@Override
	public boolean validate() {
		if (this.isContains()) {
			List<NP> subj = null;
			List<NP> dobj = null;

			subj = sentence.getSubj(verb);
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

			A_B = new ArrayList<NP[]>();

			for (NP s : subj) {
				for (NP d : dobj) {
					NP[] aux = new NP[2];
					if (reverse()) {
						aux[0] = d;
						aux[1] = s;
					} else {
						aux[0] = s;
						aux[1] = d;
					}
					A_B.add(aux);
				}
			}

			return true;
		}
		return false;
	}

	private boolean isContains() {
		String verbString = verb.getWordsString();
		for (String s : CONTAINS_WORDS) {
			if (s.equalsIgnoreCase(verbString)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean reverse(){
		String verbString = verb.getWordsString();
		for (String s : REVERSE_IF_PASSIVE) {
			if (s.equalsIgnoreCase(verbString)) {
				if (sentence.isPassive(verb)){
					return true;
				}else{
					return false;
				}
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
		if (A_B.isEmpty()){
			return 0;
		}
		return A_B.size();
	}

	@Override
	public boolean isPosibility() {
		// TODO Auto-generated method stub
		return false;
	}

	public static String[] getExamples() {
		return examples;
	}

	public static String getStructure() {
		String ret="<Object> + ";
		for (int i=0; i<CONTAINS_WORDS.length; i++){
			ret+=CONTAINS_WORDS[i];
			if (i!= CONTAINS_WORDS.length-1){
				ret+="/";
			}
		}
		ret+="+ <Object>";
		return ret;
	}
}
