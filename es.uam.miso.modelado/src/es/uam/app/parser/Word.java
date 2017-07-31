package es.uam.app.parser;

import edu.stanford.nlp.process.Morphology;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;

public class Word{
	
	private String lemma;
	private String word;
	private Tree wordTree;
	private int pos;
	private TypedDependency dependency;
	
	public Word(String word, int pos, TypedDependency dependency, Tree wordTree) {
		super();
		this.word = word;
		this.pos = pos;
		this.dependency = dependency;
		this.wordTree=wordTree;
		if (dependency==null){
			return;
		}
		Morphology mp=new Morphology();
		lemma= mp.lemma(dependency.dep().value(), dependency.dep().tag());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependency == null) ? 0 : dependency.hashCode());
		result = prime * result + pos;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		result = prime * result + ((wordTree == null) ? 0 : wordTree.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (dependency == null) {
			if (other.dependency != null)
				return false;
		} else if (!dependency.equals(other.dependency))
			return false;
		if (pos != other.pos)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		if (wordTree == null) {
			if (other.wordTree != null)
				return false;
		} else if (!wordTree.equals(other.wordTree))
			return false;
		return true;
	}
	
	
	public boolean equals(Tree obj) {
		if (obj.equals(this.wordTree)){
			return true;
		}
		return false;
	}
	
	
	public boolean equals(TypedDependency obj) {
		if (dependency==null){
			return false;
		}
		if (obj.equals(this.dependency)){
			return true;
		}
		return false;
	}
	
	public String getTag(){
		if (dependency==null){
			return "";
		}
		return this.dependency.dep().tag();
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", wordTree=" + wordTree + ", pos=" + pos + ", dependency=" + dependency + "]";
	}
	
	public String getDependecyTag(){
		if (dependency==null){
			return "";
		}
		if (dependency.reln().getSpecific()!=null){
			return dependency.reln().getShortName()+":"+dependency.reln().getSpecific();
		}
		return dependency.reln().getShortName();
	}

	public int getPos() {
		return this.pos;
	}
	
	public boolean isAssociate (Word other){
		if (dependency==null){
			return false;
		}
		if (other==null){
			return false;
		}
		if (dependency.gov().index()==other.pos){
			return true;
		}
		return false;
	}
	
	public boolean lemmaEquals(String string){
		if (lemma.equalsIgnoreCase(string)){
			return true;
		}
		return false;
	}

	public String getLemma() {
		return lemma.toLowerCase();
	}
	
	public Tree getTree() {
		return wordTree;
	}
	
	public boolean hasDependecy(){
		if (dependency==null){
			return false;
		}
		return true;
	}

	public String getWord(){
		return word.toLowerCase();
	}

	public boolean lemmaEquals(String[] words) {
		for (String w: words){
			if (lemmaEquals(w)){
				return true;
			}
		}
		return false;
	}

}
