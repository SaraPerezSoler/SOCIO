package es.uam.app.parser;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.trees.Tree;

public class NP {

	private Tree t;
	private List<Word> words;
	private Word adj;
	private Word noun;
	private NP of = null;
	private boolean isObject;
	private boolean isSubject;
	private boolean isPlural;

	public NP(Tree t, List<Word> words) {
		super();
		this.t = t;
		this.words = words;
		this.isObject = false;
		this.isSubject = false;
		this.isPlural = false;
		List<Word> delete = new ArrayList<Word>();
		for (Word w : this.words) {
			if (w.hasDependecy()) {
				if (w.getTag().equals("NNS") || w.getTag().equals("NNPS")) {
					this.isPlural = true;
				}

				if (w.getDependecyTag().equals("compound") || w.getDependecyTag().equals("amod")) {
					adj = w;
				} else if (w.getTag().startsWith("NN")) {
					noun = w;
				}
			} else {
				delete.add(w);
			}
		}
		words.removeAll(delete);

	}

	public NP(Tree t, Word word) {
		super();
		this.t = t;
		this.words = new ArrayList<Word>();
		if (word.hasDependecy()) {
			words.add(word);
		}
		this.isObject = false;
		this.isSubject = false;
		this.isPlural = false;

		for (Word w : this.words) {
			if (w.getTag().equals("NNS") || w.getTag().equals("NNPS")) {
				this.isPlural = true;
			}

			if (w.getTag().startsWith("JJ")) {
				adj = w;
			} else if (w.getTag().startsWith("NN")) {
				noun = w;
			}
		}

	}

	public Tree getT() {
		return t;
	}

	public List<Word> getWords() {
		return words;
	}

	@Override
	public String toString() {
		return "NP [words=" + words + ", of=" + of + ", isPlural=" + isPlural + "]";
	}

	public boolean isObject() {
		return isObject;
	}

	public boolean isSubject() {
		return isSubject;
	}

	public Word getNmodOf() {
		for (Word w : words) {
			if (w.getDependecyTag().equals("nmod:of")) {
				return w;
			}
		}
		return null;
	}

	public boolean cointain(Word w) {
		for (Word w1 : words) {
			if (w1.equals(w)) {
				return true;
			}
		}
		return false;

	}

	public boolean isPosessive() {
		if (noun != null) {
			if (noun.getDependecyTag().equals("nmod:poss")) {
				return true;
			}
		}
		return false;
	}

	public Word getNoun() {
		return noun;
	}

	public Word getAdj() {
		return adj;
	}

	public void delete(Word w2) {
		words.remove(w2);
		for (Word w : this.words) {
			if (w.getTag().equals("NNS") || w.getTag().equals("NNPS")) {
				this.isPlural = true;
			}

			if (w.getDependecyTag().equals("compound") || w.getDependecyTag().equals("amod")) {
				adj = w;
			} else if (w.getTag().startsWith("NN")) {
				noun = w;
			}
		}
	}

	public String upperCammelCase() {
		String cad = "";
		for (int i = 0; i < words.size(); i++) {
			if (noun != null && noun.equals(words.get(i))) {
				cad += WordConfigure.startUpperCase(words.get(i).getLemma());
			} else {
				cad += WordConfigure.startUpperCase(words.get(i).getWord());
			}
		}
		return cad;
	}

	public String lowerCammelCase() {
		String cad = "";
		for (int i = 0; i < words.size(); i++) {
			if (noun != null && noun.equals(words.get(i))) {
				cad += WordConfigure.startUpperCase(words.get(i).getLemma());
			} else {
				cad += WordConfigure.startUpperCase(words.get(i).getWord());
			}
		}
		return WordConfigure.startLowerCase(cad);
	}

	public boolean isPlural() {
		return isPlural;
	}

	public NP getOf() {
		return of;
	}

	public void setOf(NP of) {
		this.of = of;
	}

	public void setNoun(Word noun2) {
		this.noun = noun2;
		this.words.add(noun2);

	}

}