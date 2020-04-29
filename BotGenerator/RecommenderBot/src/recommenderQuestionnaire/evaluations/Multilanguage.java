package recommenderQuestionnaire.evaluations;

import java.util.List;


import generator.Bot;

public class Multilanguage extends Evaluator implements YesNoAnswer{

	public Multilanguage(List<String> options) {
		super(options);
		//super(object, "multilanguage");
		text= "Is the bot multilanguage?";
	}
	
	@Override
	protected boolean getMultiresponse() {
		return false;
	}

	@Override
	public List<String> evaluate(Bot bot) {
		if (bot.getLanguages().size()>1) {
			return getYes();
		}else {
			return getNo();
		}
	}
	
}
