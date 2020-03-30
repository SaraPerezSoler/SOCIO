package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import generator.Bot;

public class Language extends Evaluator {


	public Language(JSONObject object) {
		super(object, "language");
		this.text = "Chat bot languages";
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

	@Override
	protected Map<String, List<String>> getRefused() {
		return this.refused;
	}

	@Override
	protected List<String> getOptions() {
		return this.options;
	}

	@Override
	protected List<String> getTools() {
		return this.tools;
	}

	protected Map<String, List<String>> getAccepted() {
		return accepted;
	}

	protected Map<String, List<String>> getUnknown() {
		return unknown;
	}
}
