package es.uam.app.metamodel.parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import es.uam.app.metamodel.parser.rules.ExtractionRule;
import socioProjects.Project;

public class Sentence<T extends Project> {

	private List<Word> sentence;
	private ParserControl parser = ParserControl.getParser();
	private Tree tree;
	private List<TypedDependency> dependecies;
	private List<NP> concepts = new ArrayList<NP>();
	private List<Verb> verbs = new ArrayList<Verb>();

	public Sentence(String stringSentence) {

		this.sentence = new ArrayList<>();
		tree = parser.parser(stringSentence);

//		tree = null;
//		String[] split = stringSentence.split(" ");
//		boolean splitOption = false;
//		List<TaggedWord> sentenceTW = new ArrayList<>();
//		for (int i = 0; i < split.length; i++) {
//			String s = split[i];
//			if (s.equals("``")) {
//				if (i < split.length - 1) {
//					splitOption = true;
//					String next = split[i + 1];
//					sentenceTW.add(new TaggedWord(next, "NNP"));
//				}
//			} else {
//				sentenceTW.add(new TaggedWord(s));
//			}
//		}
//		if (splitOption) {
//			tree = parser.parser(sentenceTW);
//		} else {
//			tree = parser.parser(stringSentence);
//		}
		dependecies = parser.getDependecies(tree);
		// System.out.println(dependecies);
		List<Tree> leaves = tree.getLeaves();
		int j = 1;
		for (Tree leaf : leaves) {
			TypedDependency dependency = getDependency(j);
			this.sentence.add(new Word(leaf.value(), j, dependency, leaf));
			j++;
		}
	}

//	private void findSub(Tree tree){
//		if (tree.value().equalsIgnoreCase("SBAR")){
//			List<Tree>leaves=tree.getLeaves();
//			tree.
//			return;
//		}
//		
//		
//	}

	private TypedDependency getDependency(int pos) {
		for (TypedDependency dep : dependecies) {
			if (dep.dep().index() == pos) {
				return dep;
			}
		}
		return null;
	}

	public Word getWord(Tree t) {
		if (t != null) {
			int i = t.indexLeaves(0, false) - 1;

			for (Word w : sentence) {
				if (w.getPos() == i) {
					return w;
				}
			}
		}
		return null;
	}

	public Tree getTree(Word w) {
		if (w != null) {
			int i = w.getPos();
			List<Tree> leaves = tree.getLeaves();
			for (Tree t : leaves) {
				int j = t.indexLeaves(0, false) - 1;
				if (j == i) {
					return t;
				}
			}
		}
		return null;
	}

	private List<NP> getCandidateConcepts() {

		List<Tree> nps = getNP(tree);
		List<NP> ret = new ArrayList<NP>();

		for (Tree np : nps) {

			boolean withcc = false;
			List<Word> words = getListWords(np);

			List<Tree> children = np.getChildrenAsList();
			for (Tree child : children) {
				if (child.label().value().equalsIgnoreCase("CC")) {
					withcc = true;
					List<Tree> leaves = child.getLeaves();
					Word cc = getWord(leaves.get(0));
					List<Word> list = new ArrayList<>();
					for (Word w : words) {
						if (w.equals(cc) && !list.isEmpty()) {
							ret.add(new NP(np, list));
							list = new ArrayList<>();
						} else {
							list.add(w);
						}
					}
					ret.add(new NP(np, list));

				}
			}
			if (withcc == false) {
				ret.add(new NP(np, words));
			}
		}

		return ret;
	}

	private List<Tree> getNP(Tree t) {
		List<Tree> ret = new ArrayList<>();
		if (t == null) {
			return ret;
		}
		boolean isNP = false;
		boolean someChildIsNP = false;
		if (t.label().value().equalsIgnoreCase("NP")) {
			isNP = true;
		}
		if (t.isLeaf()) {
			if (isNP) {
				ret.add(t);
			}
			return ret;
		}
		List<Tree> children = t.getChildrenAsList();
		for (Tree child : children) {
			List<Tree> childNP = getNP(child);
			if (!childNP.isEmpty()) {
				someChildIsNP = true;
				ret.addAll(childNP);
			}
		}

		if (isNP && !someChildIsNP) {
			ret.add(t);
		}
		return ret;
	}

	public List<Verb> getVerbs() {
		List<Tree> vps = this.getVP(tree);
		List<Verb> ret = new ArrayList<Verb>();

		for (Tree vp : vps) {
			List<Tree> childrenVp = new ArrayList<>();
			List<Tree> children = vp.getChildrenAsList();
			for (Tree child : children) {
				childrenVp.addAll(getChildrenVP(child));
			}
			if (childrenVp.size() >= 1) {
				for (int i = 0; i < childrenVp.size(); i++) {
					List<Word> verbWords = getListWords(vp);
					for (Tree child : childrenVp) {
						if (childrenVp.indexOf(child) != i) {
							verbWords.removeAll(getListWords(child));
						}
					}
					Verb v = new Verb(vp, verbWords);
					// v.setComposed(true);
					ret.add(v);
				}
			} else {
				if (childrenVp.size() != 0) {

					Verb v = new Verb(vp, getListWords(vp));
					// v.setComposed(true);
					ret.add(v);
				} else {
					ret.add(new Verb(vp, getListWords(vp)));
				}

			}
		}

		return ret;

	}

	private List<Tree> getVP(Tree t) {
		List<Tree> ret = new ArrayList<>();
		if (t == null) {
			return ret;
		}
		if (t.label().value().equalsIgnoreCase("VP")) {
			ret.add(t);
			return ret;
		}
		if (t.isLeaf()) {
			return ret;
		}
		List<Tree> children = t.getChildrenAsList();
		for (Tree child : children) {
			List<Tree> childVP = getVP(child);
			if (!childVP.isEmpty()) {
				ret.addAll(childVP);
			}
		}
		return ret;
	}

	private List<Tree> getChildrenVP(Tree t) {
		List<Tree> ret = new ArrayList<>();
		if (t == null) {
			return ret;
		}
		boolean isVp = false;
		boolean hasChildrenVp = false;
		if (t.label().value().equalsIgnoreCase("VP")) {
			isVp = true;
		}
		if (t.isLeaf()) {
			if (isVp == true) {
				ret.add(t);
			}
			return ret;
		}
		List<Tree> children = t.getChildrenAsList();
		for (Tree child : children) {
			List<Tree> childVP = getChildrenVP(child);
			if (!childVP.isEmpty()) {
				hasChildrenVp = true;
				ret.addAll(childVP);
			}
		}
		if (isVp && !hasChildrenVp) {
			ret.add(t);
		}

		return ret;
	}

	public List<Word> getListWords(Tree vp) {
		List<Word> ret = new ArrayList<Word>();
		if (vp == null) {
			return ret;
		}
		
		List<Tree> trees = vp.getLeaves();
		
		for (Tree t : trees) {
			ret.add(getWord(t));
		}
		return ret;
	}

	public List<List<ExtractionRule<T>>> parser(
			Map<Class<? extends ExtractionRule<T>>, Constructor<? extends ExtractionRule<T>>> extractionRules)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// Buscar NPs
		concepts = getCandidateConcepts();
		List<NP> newConcepts = new ArrayList<NP>();
		// Buscar el genitivo Sajon
		for (NP c : concepts) {
			if (c.isPosessive()) {
				Word w = getAssociatesReverse(c.getNoun());
				NP c2 = getConcept(w);
				if (c2 == null) {
					c2 = new NP(getTree(w), w);
					newConcepts.add(c2);
				}
				c2.setOf(c);
			} else {
				// + buscar of
				List<Word> of = new ArrayList<>();
				if (c.getNoun() != null) {
					List<Word> asso = this.getAssociates(c.getNoun());
					for (Word w : asso) {
						if (w.getDependecyTag().equalsIgnoreCase("acl:of") || w.getDependecyTag().startsWith("nmod")) {
							of.add(w);
						}
					}
					if (!of.isEmpty()) {
						for (Word f : of) {
							NP rNp = getConcept(f);
							if (rNp == null) {
								rNp = new NP(getTree(f), f);
								newConcepts.add(rNp);
							}
							c.setOf(rNp);
						}
					}
				}
			}
		}
		concepts.addAll(newConcepts);

		// Buscar VPs
		verbs = getVerbs();

		Set<Class<? extends ExtractionRule<T>>> keys = extractionRules.keySet();
		// Comprobar verbos concretos
		List<List<ExtractionRule<T>>> ret = new ArrayList<List<ExtractionRule<T>>>();
		for (Verb v : verbs) {
			List<ExtractionRule<T>> ret2 = new ArrayList<>();
			for (Class<? extends ExtractionRule<T>> k : keys) {
				Constructor<? extends ExtractionRule<T>> ruleConstructor = extractionRules.get(k);
				ExtractionRule<T> er = ruleConstructor.newInstance(this, v);
				if (er.validate()) {
					ret2.add(er);
				}
			}
			if (!ret2.isEmpty()) {
				ret.add(ret2);
			}
		}
		return ret;
	}

	public List<NP> getSubj(Verb v) {
		return getNps(v, "nsubj");
	}

	public List<NP> getDobj(Verb v) {
		return getNps(v, "dobj");
	}

	public List<NP> getNmod(Verb v) {
		return getNps(v, "nmod");
	}

	public List<NP> getRootNP(Verb v) {
		List<NP> npList = new ArrayList<NP>();
		if (v == null) {
			return npList;
		}
		Word w = v.getRoot();
		

		List<Word> wAsso = getAssociates(w);
		NP concept = getConcept(w);
		if (concept == null) {
			concept = new NP(getTree(w), w);
			concepts.add(concept);
		}
		for (Word w2 : wAsso) {
			if (w2.getDependecyTag().startsWith("conj")) {
				NP conj = getConcept(w2);
				if (conj == null) {
					conj = new NP(getTree(w2), w2);
					concepts.add(conj);

				} else if (concept.equals(conj)) {
					concept.delete(w2);
					conj = new NP(getTree(w2), w2);
					concepts.add(conj);

				}
				npList.add(conj);
			}
		}

		if (npList.contains(concept)) {
			concept.delete(w);
			NP newConcept = new NP(getTree(w), w);
			concepts.add(newConcept);
			npList.add(newConcept);
		} else {
			npList.add(concept);

		}
		return npList;

	}

	private List<NP> getNps(Verb v, String tag) {
		List<Word> asso = getAssociates(v.getRoot());
		List<Word> xcomp = v.getXcomp();
		for (Word w1 : xcomp) {
			asso.addAll(getAssociates(w1));
		}

		List<Word> wordList = new ArrayList<Word>();
		for (Word w : asso) {
			if (w.getDependecyTag().startsWith(tag)) {
				wordList.add(w);
			}
		}
		return getNps(wordList);

	}

	public List<NP> getNps(NP word, String tag) {

		List<Word> asso = getAssociates(word.getNoun());
		asso.addAll(getAssociates(word.getAdj()));
		List<Word> wordList = new ArrayList<Word>();
		for (Word w : asso) {
			if (w.getDependecyTag().startsWith(tag)) {
				wordList.add(w);
			}
		}
		return getNps(wordList);

	}

	private List<NP> getNps(List<Word> wordList) {

		List<NP> npList = new ArrayList<NP>();

		for (Word w : wordList) {
			List<Word> wAsso = getAssociates(w);
			NP concept = getConcept(w);
			if (concept != null) {
				for (Word w2 : wAsso) {
					if (w2.getDependecyTag().startsWith("conj")) {
						NP conj = getConcept(w2);
						if (conj == null) {
							conj = new NP(getTree(w2), w2);
							concepts.add(conj);

						} else if (concept.equals(conj)) {
							concept.delete(w2);
							conj = new NP(getTree(w2), w2);
							concepts.add(conj);

						}
						npList.add(conj);
					}
				}
				if (npList.contains(concept)) {
					concept.delete(w);
					NP newConcept = new NP(getTree(w), w);
					concepts.add(newConcept);
					npList.add(newConcept);
				} else {
					npList.add(concept);
				}

			}
		}
		return npList;
	}

	public boolean isPassive(Verb v) {
		if (v == null) {
			return false;
		}
		List<Word> asso = getAssociates(v.getRoot());
		for (Word w : asso) {
			if (w.getDependecyTag().equals("auxpass")) {
				return true;
			}
		}
		return false;
	}

	private NP getConcept(Word w) {
		for (NP c : concepts) {
			if (c.cointain(w)) {
				return c;
			}
		}
		return null;
	}

	public List<Word> getAssociates(Word word) {
		List<Word> ret = new ArrayList<Word>();
		for (Word w : sentence) {
			if (w.isAssociate(word)) {
				ret.add(w);
			}
		}
		return ret;
	}

	public List<Word> getAssociates(List<Word> words) {
		List<Word> ret = new ArrayList<Word>();

		for (Word w : words) {
			ret.addAll(getAssociates(w));
		}
		return ret;
	}

	private Word getAssociatesReverse(Word word) {
		if (word == null) {
			return null;
		}
		for (Word w : sentence) {
			if (word.isAssociate(w)) {
				return w;
			}
		}
		return null;
	}

	public List<NP> getConcepts() {
		return concepts;
	}

}
