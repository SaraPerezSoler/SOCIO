package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import generator.Action;
import generator.Bot;
import generator.Parameter;
import generator.ParameterToken;
import generator.Text;
import generator.TextInput;
import generator.Token;
import generator.UserInteraction;

public class ParameterStorage extends Evaluator{

	public ParameterStorage(JSONObject object) {
		super(object, "parameterStorage");
		this.text ="Does the bot need persistent parameter storage, is volatile enough or none?";
	}

	@Override
	protected boolean getMultiresponse() {
		return false;
	}

	@Override
	public List<String> evaluate(Bot bot) {
		List<String> ret = new ArrayList<>();
		boolean volatile_=false;
		boolean persistent = false;
		for (UserInteraction flow: bot.getFlows()) {
			List<Parameter> params = new ArrayList<>();
			
			evaluateFlow(flow, volatile_, persistent, params);
			if (persistent == true) {
				ret.add("persistent");
				return ret;
			}
		}
		if (volatile_==true) {
			ret.add("volatile");
		}else {
			ret.add("none");
		}
		
		return ret;
	}
	
	private void evaluateFlow(UserInteraction interaction, boolean volatile_, boolean persistent, List<Parameter> params) {
		List<Parameter> actual = interaction.getIntent().getParameters();
		if (actual == null) {
			actual = new ArrayList<>();
		}
		
		for (Action action: interaction.getTarget().getActions()) {
			if (action instanceof Text) {
				Text textAction = (Text) action;
				for (TextInput input:textAction.getInputs()) {
					for (Token token: input.getTokens()) {
						if (token instanceof ParameterToken) {
							if (params.contains(((ParameterToken)token).getParameter())) {
								persistent = true;
								return;
							}
							if (actual.contains(((ParameterToken)token).getParameter())){
								volatile_ = true;
							}
						}
					}
				}
			}
		}
		
		params.addAll(actual);
		for (UserInteraction son: interaction.getTarget().getOutcoming()) {
			evaluateFlow(son, volatile_, persistent, params);
			if (persistent == true) {
				return;
			}
		}
	}
	
	

}
