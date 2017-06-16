package es.uam.app.parser.rules;

import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.projects.MetaModelProject;

public abstract class MetemodelRule extends ExtractionRule<MetaModelProject>{

	public MetemodelRule(Sentence<MetaModelProject> sentence, Verb v) {
		super(sentence, v);
	}

}
