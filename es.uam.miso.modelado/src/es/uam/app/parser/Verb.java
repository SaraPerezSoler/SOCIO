package es.uam.app.parser;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.trees.Tree;

public class Verb {

	private Tree vp;
	private List<Word> verb;

	public Verb(Tree vp, List<Word> verb) {
		super();
		this.vp = vp;
		this.verb = verb;

	}

	public List<Word> getVerb() {
		return verb;
	}

	@Override
	public String toString() {
		return "Verb [getVerbWords()=" + getVerbWords() + "]";
	}

	public boolean is(String[] strings) {
		String phrase = "";
		for (int i = 0; i < verb.size(); i++) {
			if (i - 1 == verb.size()) {
				phrase += verb.get(i);
			} else {
				phrase = phrase += verb.get(i) + " ";
			}
		}

		for (String s : strings) {
			if (phrase.contains(s)) {
				return true;
			}
		}
		return false;
	}

	public Word getRoot() {
		Word root = null;
		for (Word w : verb) {
			if (w.getDependecyTag().equals("root")) {
				root = w;
			}
		}
		return root;
	}

	public List<Word> getVerbWords() {
		List<Word> ret = new ArrayList<Word>();
		for (Word w : verb) {
			if (w.getTag().startsWith("VB")) {
				ret.add(w);
			} else if (w.getDependecyTag().equals("case")) {
				ret.add(w);
				break;
			}else if (!w.getDependecyTag().startsWith("aux")){
				break;
			}
		}
		return ret;
	}

	public List<Word> getXcomp() {
		List<Word> xcomp = new ArrayList<Word>();
		for (Word w : verb) {
			if (w.getDependecyTag().equals("xcomp")) {
				xcomp.add(w);
			} else if (w.getDependecyTag().equals("dep")) {
				xcomp.add(w);
			}
		}
		return xcomp;
	}

	public boolean isVerbWithPrep() {
		Word lastVB = null;

		for (Word w : verb) {
			if (w.getTag().startsWith("VB")) {
				lastVB = w;
			}
		}
		Word next;
		if (verb.size() > verb.indexOf(lastVB) + 1) {
			next = verb.get(verb.indexOf(lastVB) + 1);
			int i = 2;
			while (next.getDependecyTag().startsWith("compound") && next.isAssociate(lastVB)) {
				next = verb.get(verb.indexOf(lastVB) + i);
				i++;
			}

			if (next.getDependecyTag().equals("case")) {
				return true;
			}
		}

		return false;

	}

	public String lowerCammelCase() {
	
		return WordConfigure.startLowerCase(upperCammelCase());
	}
	
	public String getWordsString() {
		List<Word> words = getVerbWords();
		String cad = "";
		boolean haveAux=false;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getDependecyTag().startsWith("aux")){
				haveAux=true;
			}else{
				if (haveAux){
					cad += words.get(i).getWord();
				}else{
					cad += words.get(i).getLemma();
				}
			}
			if (i!=words.size()-1 && cad!=""){
				cad+=" ";
			}
		}
		return cad;
	}

	public String getWordsStringWithAux() {
		List<Word> words = getVerbWords();
		String cad = "";
		boolean haveAux=false;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getDependecyTag().startsWith("aux")){
				haveAux=true;
				cad+=words.get(i).getLemma();
			}else{
				if (haveAux){
					cad += words.get(i).getWord();
				}else{
					cad += words.get(i).getLemma();
				}
			}
			if (i!=words.size()-1 && cad!=""){
				cad+=" ";
			}
		}
		return cad;
	}

	public String upperCammelCase() {
		String verb=getWordsString();
		String verbWords[]=verb.split(" ");
		String ret="";
		for (String s: verbWords){
			ret+=WordConfigure.startUpperCase(s);
		}
		return ret;
	}

	public Tree getVp() {
		return vp;
	}


	
	public boolean isNeg(){
		for (Word w : verb) {
			if (w.getDependecyTag().equals("neg")) {
				return true;
			}
		}
		return false;
		
	}

	
}
