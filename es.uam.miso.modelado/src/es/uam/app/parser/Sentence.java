package es.uam.app.parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import es.uam.app.parser.rules.ExtractionRule;

public class Sentence {

	private List<Word> sentence;
	private ParserControl parser = ParserControl.getParser();
	private Tree tree;
	private List<TypedDependency> dependecies;
	private List<NP> concepts = new ArrayList<NP>();
	private List<Verb> verbs = new ArrayList<Verb>();

	private static Map<Class<? extends ExtractionRule>, Constructor<? extends ExtractionRule>> extractionRules = new HashMap<>();
	
	

	public static void registerRule(Class<? extends ExtractionRule> er)
			throws NoSuchMethodException, SecurityException {
		Constructor<? extends ExtractionRule> ruleConstructor = er
				.getConstructor(new Class[] { Sentence.class, Verb.class });
		if (ruleConstructor != null) {
			extractionRules.put(er, ruleConstructor);
		}
	}
	
	public static Map<Class<? extends ExtractionRule>, Constructor<? extends ExtractionRule>> getExtractionRules() {
		return extractionRules;
	}

	public Sentence(String stringSentence) {

		this.sentence = new ArrayList<Word>();
		tree = null;
		String[] split = stringSentence.split(" ");
		boolean splitOption = false;
		List<TaggedWord> sentenceTW = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			if (s.equals("``")) {
				if (i < split.length - 1) {
					splitOption = true;
					String next = split[i + 1];
					sentenceTW.add(new TaggedWord(next, "NNP"));
				}
			} else {
				sentenceTW.add(new TaggedWord(s));
			}
		}
		if (splitOption) {
			tree = parser.parser(sentenceTW);
		} else {
			tree = parser.parser(stringSentence);
		}
		dependecies = parser.getDependecies(tree);
		//System.out.println(dependecies);
		List<Tree> leaves = tree.getLeaves();
		int j = 1;
		for (Tree leaf : leaves) {
			TypedDependency dependency = getDependency(j);
			this.sentence.add(new Word(leaf.value(), j, dependency, leaf));
			j++;
		}
	}

	private TypedDependency getDependency(int pos) {
		for (TypedDependency dep : dependecies) {
			if (dep.dep().index() == pos) {
				return dep;
			}
		}
		return null;
	}

	public Word getWord(Tree t) {
		int i = t.indexLeaves(0, false) - 1;

		for (Word w : sentence) {
			if (w.getPos() == i) {
				return w;
			}
		}
		return null;
	}

	public Tree getTree(Word w) {
		int i = w.getPos();
		List<Tree> leaves = tree.getLeaves();
		for (Tree t : leaves) {
			int j = t.indexLeaves(0, false) - 1;
			if (j == i) {
				return t;
			}
		}
		return null;
	}

	public List<NP> getCandidateConcepts() {

		List<Tree> nps = getNP(tree);
		List<NP> ret = new ArrayList<NP>();

		for (Tree np : nps) {
			List<Word> words = getListWords(np);
			List<Word> wordsSave = new ArrayList<Word>();
			for (Word w : words) {
				if (w.getTag().startsWith("NN") || w.getTag().startsWith("JJ")) {
					wordsSave.add(w);
				}
			}

			ret.add(new NP(np, wordsSave));
		}

		return ret;
	}

	private List<Tree> getNP(Tree t) {
		List<Tree> ret = new ArrayList<>();
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
			if (childrenVp.size() > 1) {
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
		List<Tree> trees = vp.getLeaves();

		List<Word> ret = new ArrayList<Word>();
		for (Tree t : trees) {
			ret.add(getWord(t));
		}
		return ret;
	}

	public List<List<ExtractionRule>> parser()
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
				Word of = null;
				if (c.getNoun() != null) {
					List<Word> asso = this.getAssociates(c.getNoun());
					for (Word w : asso) {
						if (w.getDependecyTag().equalsIgnoreCase("acl:of") || w.getDependecyTag().startsWith("nmod")) {
							of = w;
						}
					}
					if (of != null) {
						NP rNp = getConcept(of);
						if (rNp == null) {
							rNp = new NP(getTree(of), of);
							newConcepts.add(rNp);
						}
						c.setOf(rNp);
					}
				}
			}
		}
		concepts.addAll(newConcepts);

		// Buscar VPs
		verbs = getVerbs();

		Set<Class<? extends ExtractionRule>> keys = extractionRules.keySet();
		// Comprobar verbos concretos
		List<List<ExtractionRule>> ret = new ArrayList<List<ExtractionRule>>();
		for (Verb v : verbs) {
			List<ExtractionRule> ret2 = new ArrayList<>();
			for (Class<? extends ExtractionRule> k : keys) {
				Constructor<? extends ExtractionRule> ruleConstructor = extractionRules.get(k);
				ExtractionRule er = ruleConstructor.newInstance(this, v);
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
		Word w = v.getRoot();
		List<NP> npList = new ArrayList<NP>();

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

	private Word getAssociatesReverse(Word word) {
		for (Word w : sentence) {
			if (word.isAssociate(w)) {
				return w;
			}
		}
		return null;
	}



}
