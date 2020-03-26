package es.uam.app.metamodel.parser.rules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import es.uam.app.actions.metamodels.UpdateAttrType;
import es.uam.app.actions.metamodels.UpdateClassAbstract;
import es.uam.app.actions.metamodels.UpdateClassRemoveSuperType;
import es.uam.app.actions.metamodels.UpdateClassSuperType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.metamodel.parser.NP;
import es.uam.app.metamodel.parser.Sentence;
import es.uam.app.metamodel.parser.Verb;
import es.uam.app.metamodel.parser.Word;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.Feature;
import es.uam.app.projects.emf.metamodel.MetamodelControlInterface;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;

public class B3B5ToBe extends MetamodelRule {

	// <A> is a <B>

	private List<NP[]> A_B;
	private boolean no;

	private final static String structure = "<Object> + to be + <Object>";
	private final static String examples[] = { "Packages can be bulky, heavy or fragile.",
			"Students and teachers are persons.", "Name of person is a text.", "The wife of a man is a woman." };
	private final static String[] VERBS = { "consist of" };

	public B3B5ToBe(Sentence<MetamodelProject> sentence, Verb v) {
		super(sentence, v);
	}

	@Override
	public String toString() {
		String cad = "B3B5ToBe [";
		for (NP[] a_b : A_B) {
			cad += "[A=" + a_b[0] + ", B=" + a_b[1] + "]";
		}
		cad += "]";
		return cad;
	}

	@Override
	public List<Action> evaluete(MetamodelProject proj, int i) throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<>();
		NP A = A_B.get(i)[0];
		NP B = A_B.get(i)[1];

		if (!A.getOf().isEmpty()) {
			for (NP ofNP : A.getOf()) {
				IsClass of = IsClass.getClass(ofNP, proj);
				ret.addAll(withOf(proj, of, A, B));
				super.addIfNecesary(of, ret);
			}
		} else {
			ret.addAll(withoutOf(proj, A, B));
		}
		return ret;
	}

	private List<Action> withOf(MetamodelProject proj, IsClass of, NP A, NP B)
			throws FileNotFoundException, JWNLException {
		List<Action> ret = new ArrayList<Action>();
		EClassifier type = MetamodelControlInterface.getType(B.lemmaUpperCammelCase());

		if (type == null) {
			IsReference ref = IsReference.getReference(A, of, proj, false);
			super.addIfNecesary(ref, ret);
			IsClass bClass = IsClass.getClass(B, proj);
			super.addIfNecesary(bClass, ret);
			if (no) {
				if (ref instanceof ReferenceControl && bClass instanceof ClassControl) {
					if (((ReferenceControl) ret).getType().equals((ClassControl) bClass)) {
						UpdateRefType urt = new UpdateRefType(proj, ref, null, 1);
						ret.add(urt.getAction());
					}
				}
			} else {
				UpdateRefType urt = new UpdateRefType(proj, ref, bClass, B.getMax());
				ret.add(urt.getAction());
			}
		} else {
			IsAttribute att = IsAttribute.getAttribute(A, of, proj);
			super.addIfNecesary(att, ret);

			if (no) {
				if (att instanceof AttributeControl) {
					if (((AttributeControl) att).getType().equals(type)) {
						UpdateAttrType urt = new UpdateAttrType(proj, att, null, 1);
						ret.add(urt.getAction());
					}
				}
			} else {
				UpdateAttrType uat = new UpdateAttrType(proj, att, B.lemmaUpperCammelCase(), att.getMax());
				ret.add(uat.getAction());
			}

		}

		return ret;
	}

	private List<Action> withoutOf(MetamodelProject proj, NP A, NP B) throws FileNotFoundException, JWNLException {

		IsClass aClass = IsClass.getClass(A.lemmaUpperCammelCase(), proj);
		if (!(aClass instanceof ClassControl)) {
			Feature f = proj.getFeature(A.lowerCammelCase());
			if (f != null) {
				ClassControl of = f.getParent();
				return withOf(proj, of, A, B);

			}

			f = proj.getFeature(A.lemmaLowerCammelCase());
			if (f != null) {
				ClassControl of = f.getParent();
				return withOf(proj, of, A, B);

			}
		}
		List<Action> ret = new ArrayList<Action>();
		super.addIfNecesary(aClass, ret);

		if (B.isAbstract() && (B.getNoun() == null || B.getNoun().lemmaEquals("class"))) {
			if (no) {
				UpdateClassAbstract uca = new UpdateClassAbstract(proj, aClass, false);
				ret.add(uca.getAction());
			} else {
				UpdateClassAbstract uca = new UpdateClassAbstract(proj, aClass, true);
				ret.add(uca.getAction());
			}
			return ret;
		}

		IsClass bClass = IsClass.getClass(B.lemmaUpperCammelCase(), proj);
		if (bClass.equals(aClass)) {
			bClass = IsClass.getExactlyClass(B, proj);
			if (bClass.equals(aClass)) {
				aClass = IsClass.getExactlyClass(A, proj);
			}
		}

		super.addIfNecesary(bClass, ret);
		if (no) {
			if (bClass instanceof ClassControl) {
				UpdateClassRemoveSuperType ucrst = new UpdateClassRemoveSuperType(proj, aClass, (ClassControl) bClass);
				ret.add(ucrst.getAction());
			}
		} else {
			if (!aClass.equals(bClass)){
				UpdateClassSuperType ucst = new UpdateClassSuperType(proj, aClass, bClass);
				ret.add(ucst.getAction());
			}
		}
		return ret;

	}

	@Override
	public boolean validate() {
		if (this.isToBe()) {
			List<NP> subj = sentence.getSubj(verb);
			List<NP> dobj = sentence.getRootNP(verb);

			if (subj.isEmpty()) {
				return false;
			}
			if (dobj.isEmpty()) {
				return false;
			}
			no = verb.isNeg();

			A_B = new ArrayList<>();
			for (NP s : subj) {
				for (NP d : dobj) {
					NP[] aux = new NP[2];
					if (this.isToBeReverse()) {
						if (d.getNoun() == null) {
							d.setNoun(s.getNoun());
						}
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
		} else if (this.isType()) {
			List<NP> subj = sentence.getSubj(verb);
			List<NP> dobj;
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

		} else {
			return false;
		}

	}

	private boolean isToBe() {
		if (!verb.getXcomp().isEmpty()) {
			return false;
		}
		for (Word w : verb.getVerb()) {
			if (w.getDependecyTag().equals("cop")) {
				if (verb.isVerbWithPrep()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	private boolean isType() {
		String verbString = verb.getWordsStringWithAux();
		for (String s : VERBS) {
			if (s.equalsIgnoreCase(verbString)) {
				return true;
			}
		}
		return false;
	}

	private boolean isToBeReverse() {
		List<Word> asso = sentence.getAssociates(verb.getRoot());
		for (Word w : asso) {
			if (w.getDependecyTag().equals("aux")) {
				if (w.lemmaEquals("can") || w.lemmaEquals("may"))
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
		return isToBe();
	}

	public static String[] getExamples() {
		return examples;
	}

	public static String getStructure() {
		return structure;
	}

}
