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
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.ecore.ClassControl;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;


public class B4Contain extends MetemodelRule {

	// <A> contain <B>
	private List<NP[]> A_B;
	private final static String examples[]={"The house is made of rooms.", "Students contains a numeric identifier.",};


	private static final String[] CONTAINS_WORDS = { "contain", "be made of","be made up of", "be made from", " be composed", "include" };
	private static final String[] REVERSE_IF_PASSIVE={ "contain", "include"};
	

	public B4Contain(Sentence<MetamodelProject> sentence, Verb v) {
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
	public List<Action> evaluete(MetamodelProject proj, int i) throws FileNotFoundException, JWNLException {
		
		List<Action> ret = new ArrayList<Action>();
			NP A=A_B.get(i)[0];
			NP B=A_B.get(i)[1];
			IsClass aClass = IsClass.getClass(A, proj);
			super.addIfNecesary(aClass, ret);

			if (!B.getAdj().isEmpty()) {
				EClassifier type = B.adjType();
				// Si B.adjetivo es un tipo definido de ecore.
				if (type != null) {
					// B.noun es un atributo...
					
					IsAttribute att = IsAttribute.getAttribute(B.getNoun().getWord(), aClass, B.getMin(), B.getMax(), proj);
					super.addIfNecesary(att, ret);
					// ...con tipo B.adjetivo.
					UpdateAttrType uat = new UpdateAttrType(proj, att, type.getName(),B.getMax());
					ret.add(uat.getAction());
					// Si B.adjetivo no es un tipo definido de ecore
				} else {
					
					IsClass bClass = IsClass.getClass(B, proj);
					IsClass bClassAux=bClass;
					if (bClass instanceof CreateClass){
						bClass= IsClass.getClass(B.getAdjCammelCase(), proj);
					}
					// Si es una clase del metamodelo
					if (bClass instanceof ClassControl) {
						// B.noun es una referencia...
						IsReference ref = IsReference.getReference(B, aClass, proj, true);
						super.addIfNecesary(ref, ret);
						// ...con tipo B.adjetive
						UpdateRefType urt = new UpdateRefType(proj, ref, bClass, B.getMax());
						ret.add(urt.getAction());
						// Si B.adjetive no es ni un tipo definido de ecore ni
						// una
						// clase creada previamente
					} else {
						bClass = bClassAux;
						super.addIfNecesary(bClass, ret);

						IsReference bRef = IsReference.getReference(B, aClass, proj, true);
						super.addIfNecesary(bRef, ret);
						UpdateRefType urt = new UpdateRefType(proj, bRef, bClass, B.getMax());
						ret.add(urt.getAction());
					}
				}
			} else {
				IsClass bClass = IsClass.getClass(B, proj);
				super.addIfNecesary(bClass, ret);

				IsReference bRef = IsReference.getReference(B, aClass, proj, true);
				super.addIfNecesary(bRef, ret);
				UpdateRefType urt = new UpdateRefType(proj, bRef, bClass, B.getMax());
				ret.add(urt.getAction());
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
						if (verb.hasMayCanAux()){
							s.setMin(0);
						}
						
						aux[0] = d;
						aux[1] = s;
					} else {
						if (verb.hasMayCanAux()){
							d.setMin(0);
						}
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
		String verbString = verb.getWordsStringWithAux();
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
