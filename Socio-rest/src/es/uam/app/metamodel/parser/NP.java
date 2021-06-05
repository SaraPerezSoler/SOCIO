package es.uam.app.metamodel.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import edu.stanford.nlp.trees.Tree;
import es.uam.app.projects.emf.metamodel.MetamodelControlInterface;

public class NP {

	private final String[] adjToDelete = { "several", "some", "any", "various", "many", "much", "more" };
	private static Text2NumEng text2Num= new Text2NumEng();
	private Tree t;
	private List<Word> words;
	private List<Word> adj = new ArrayList<>();
	private Word noun;
	private List<NP> of = new ArrayList<>();

	private boolean isAbstract = false;
	private int min = 1, max = 1;

	public NP(Tree t, List<Word> words) {
		super();
		this.t = t;
		this.words = words;

		checkWords();

	}

	private void checkWords() {
		adj.clear();

		List<Word> delete = new ArrayList<Word>();
		boolean numAsig = false;
		for (Word w : this.words) {
			if (w.hasDependecy()) {
				if (w.getTag().equals("NNS") || w.getTag().equals("NNPS")) {
					if (numAsig == false) {
						this.max = -1;
					}
				}

				if ((w.getDependecyTag().equals("compound") || w.getDependecyTag().equals("amod") || w.getTag().startsWith("JJ")) && !w.getTag().equals("CD")) {
					if (w.lemmaEquals(adjToDelete)) {
						delete.add(w);
					} else if (w.lemmaEquals("abstract")) {
						delete.add(w);
						isAbstract = true;
					} else {
						adj.add(w);
					}
				} else if (w.getTag().startsWith("NN")) {
					noun = w;
				} else {
					if (w.getTag().equals("CD")) {
						numAsig = true;
						min=text2Num.parserInt(w.getWord());
						max=min;
					}
					delete.add(w);
				}
			} else {
				delete.add(w);
			}
		}
		words.removeAll(delete);

	}

	public NP(Tree t, Word word) {
		super();
		this.words = new ArrayList<Word>();
		if (word.hasDependecy()) {
			words.add(word);
		}

		this.t = t;
		checkWords();

	}

	public Tree getT() {
		return t;
	}

	public List<Word> getWords() {
		return words;
	}

	@Override
	public String toString() {
		return "NP [words=" + words + ", of=" + of + ", min=" + min + ", max=" + max + "]";
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

	public List<Word> getAdj() {
		return adj;
	}

	public void delete(Word w2) {
		words.remove(w2);
		checkWords();
	}

	public String upperCammelCase() {
		String cad = "";
		for (int i = 0; i < words.size(); i++) {
				cad += WordConfigure.startUpperCase(words.get(i).getWord());
		}
		return cad;
	}

	public String lowerCammelCase() {
		String cad = "";
		for (int i = 0; i < words.size(); i++) {
				cad += WordConfigure.startUpperCase(words.get(i).getWord());
		}
		return WordConfigure.startLowerCase(cad);
	}
	
	public String lemmaUpperCammelCase() {
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

	public String lemmaLowerCammelCase() {
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

	public List<NP> getOf() {
		return of;
	}

	public void setOf(NP of) {
		this.of.add(of);
	}

	public void setNoun(Word noun2) {
		this.noun = noun2;
		this.words.add(noun2);

	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public EClassifier adjType() {
		for (Word w : adj) {
			String bAdjLemmaUpper = WordConfigure.startUpperCase(w.getLemma());
			EClassifier type = MetamodelControlInterface.getType(bAdjLemmaUpper);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

	public String getAdjCammelCase() {
		String cad = "";
		for (Word w : adj) {
			cad += WordConfigure.startUpperCase(w.getLemma().toLowerCase());
		}
		if (cad.equals("")){
			return null;
		}
		return cad;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	
	public static String upperCammelCase(String wordsString) {
		String cad = "";
		String [] words = wordsString.split(" ");
		for (int i = 0; i < words.length; i++) {
				cad += WordConfigure.startUpperCase(words[i]);
		}
		return cad;
	}

	public static String lowerCammelCase(String wordsString) {
		String cad = "";
		String [] words = wordsString.split(" ");
		for (int i = 0; i < words.length; i++) {
				cad += WordConfigure.startUpperCase(words[i]);
		}
		return WordConfigure.startLowerCase(cad);
	}
}