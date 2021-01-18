package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;

import generator.Bot;

public class Language extends Evaluator {


	public Language(List<String> options) {
		super(options);
		//super(object, "language");
		this.text = "Chatbot languages";
	}

	@Override
	protected boolean getMultiresponse() {
		return true;
	}

	/* returns the list of options the bot satisfy */
	@Override
	public List<String> evaluate(Bot bot) {
		List<String> ret = new ArrayList<String>();
		for (generator.Language lan:bot.getLanguages()) {
			for (String o: getOptions()) {
				if (lan.getLiteral().equalsIgnoreCase(o)) {
					ret.add(o);
					break;
				}
			}	
		}
		return ret;
	}
}
