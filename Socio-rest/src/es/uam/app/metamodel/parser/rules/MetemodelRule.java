package es.uam.app.metamodel.parser.rules;

import java.util.List;

import es.uam.app.actions.ProjectAction;
import es.uam.app.metamodel.parser.Sentence;
import es.uam.app.metamodel.parser.Verb;
import es.uam.app.projects.IsAttribute;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import projectHistory.Action;
import socioProjects.MetamodelProject;

public abstract class MetemodelRule extends ExtractionRule<MetamodelProject>{

	public MetemodelRule(Sentence<MetamodelProject> sentence, Verb v) {
		super(sentence, v);
	}
	
	public List<Action> addIfNecesary(es.uam.app.projects.IsClass classA, List<Action> ret){
		if (classA instanceof ProjectAction) {
			ret.add(((ProjectAction<?>)classA).getAction());
			if (IsClass.getUpdateClassAbstractAction(classA)!=null){
				ret.add(IsClass.getUpdateClassAbstractAction(classA).getAction());
			}
		}
		return ret;
	}
	public List<Action> addIfNecesary(IsReference ref, List<Action> ret){
		if (ref instanceof ProjectAction) {
			ret.add(((ProjectAction<?>)ref).getAction());
		}
		return ret;
	}
	public List<Action> addIfNecesary(IsAttribute att, List<Action> ret){
		if (att instanceof ProjectAction) {
			ret.add(((ProjectAction<?>) att).getAction());
		}
		return ret;
	}

}
