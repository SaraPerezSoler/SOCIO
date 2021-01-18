package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import generator.Bot;
import generator.RegexInput;
import generator.TrainingPhrase;

public class NLPatternMachine extends Evaluator{

	public NLPatternMachine(List<String> options) {
		super(options);
		text = "Does the chatbot need pattern matching, natural language processing or both?";
	}

	@Override
	protected boolean getMultiresponse() {
		return true;
	}
	
	@Override
	public List<String> evaluate(Bot bot) {
		boolean nl = false;
		boolean regex = false;
		TreeIterator<EObject> objects = bot.eAllContents();
		while (objects.hasNext()) {
			EObject next = objects.next();
			if (next instanceof TrainingPhrase) {
				nl=true;
			}else if (next instanceof RegexInput) {
				regex = true;
			}
			if (nl && regex) {
				break;
			}
		}
		
		List<String> ret = new ArrayList<>();
		if (nl) {
			ret.add("Natural Language Processing (NLP)");
		}
		if (regex) {
			ret.add("Pattern Matching");
		}
		return ret;
	}

}
