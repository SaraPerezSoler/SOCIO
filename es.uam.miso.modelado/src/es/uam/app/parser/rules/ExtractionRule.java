package es.uam.app.parser.rules;

import java.io.FileNotFoundException;
import java.util.List;

import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.Project;

public abstract class ExtractionRule<T extends Project>{

	protected Sentence<T> sentence;
	protected Verb verb;
	
	public ExtractionRule(Sentence<T> sentence, Verb v) {
		this.sentence=sentence;
		this.verb=v;
	}
	
	
	public abstract int getPriority(); 
	
	public  abstract boolean validate();
	
	public abstract List<Action> evaluete(T proj, int i) throws FileNotFoundException, JWNLException;
	
	public abstract int numEvaluete();
	
	public abstract boolean isPosibility();
	
}
