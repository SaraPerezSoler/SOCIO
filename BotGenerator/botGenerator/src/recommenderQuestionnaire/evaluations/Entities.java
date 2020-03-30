package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import generator.Bot;
import generator.Intent;
import generator.Parameter;

public class Entities extends Evaluator{

	public Entities(JSONObject object) {
		super(object, "entities");
		text = "Does the bot use new entities, predefined or none?";
		
	}

	@Override
	protected boolean getMultiresponse() {
		return true;
	}

	@Override
	public List<String> evaluate(Bot bot) {
		List<String> ret = new ArrayList<String>();
		if (!bot.getEntities().isEmpty()) {
			ret.add("pre-defined");
		}
		
		for (Intent intent: bot.getIntents()) {
			for (Parameter param: intent.getParameters()) {
				if (param.getEntity() == null) {
					ret.add("defined");
					break;
				}
			}
			if (ret.contains("defined")) {
				break;
			}
		}
		
		if (ret.isEmpty()) {
			ret.add("none");
		}
		return ret;
	}

}
