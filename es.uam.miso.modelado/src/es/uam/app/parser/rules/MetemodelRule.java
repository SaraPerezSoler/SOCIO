package es.uam.app.parser.rules;

import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import socioProjects.MetamodelProject;

public abstract class MetemodelRule extends ExtractionRule<MetamodelProject>{

	public MetemodelRule(Sentence<MetamodelProject> sentence, Verb v) {
		super(sentence, v);
	}

}
