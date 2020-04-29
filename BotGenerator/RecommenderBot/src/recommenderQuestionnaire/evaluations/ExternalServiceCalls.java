package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;


import generator.Action;
import generator.Bot;
import generator.HTTPRequest;

public class ExternalServiceCalls extends Evaluator {

	/*public ExternalServiceCalls(JSONObject object) {
		super(object, "ExternalCalls");
	}*/
	
	

	public ExternalServiceCalls(List<String> options) {
		super(options);
		//TODO TEXT
		this.text="Does the chatbot have an external service call, multiple or none?";
	}



	@Override
	protected boolean getMultiresponse() {
		return false;
	}

	@Override
	public List<String> evaluate(Bot bot) {
		List<String>URLS = new ArrayList<>();
		for (Action action: bot.getActions()) {
			if (action instanceof HTTPRequest) {
				if (!URLS.contains(((HTTPRequest)action).getURL())) {
					URLS.add(((HTTPRequest)action).getURL());
				}
			}
		}
		List<String> ret = new ArrayList<>();
		if (URLS.isEmpty()) {
			ret.add("none");
		}else if (URLS.size()==1) {
			ret.add("one");
		}else {
			ret.add("moreThanOne");
		}
		return ret;
	}

}
