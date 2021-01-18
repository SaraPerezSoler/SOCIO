package recommenderQuestionnaire.evaluations;

import java.util.List;

import generator.Bot;
import generator.Intent;
import generator.IntentInput;
import generator.IntentLanguageInputs;
import generator.Literal;
import generator.ParameterReferenceToken;
import generator.Token;
import generator.TrainingPhrase;

public class ParameterExtaction extends Evaluator implements YesNoAnswer {

	public ParameterExtaction(List<String> options) {
		super(options);
		// super(object, "paramExtraction");
		text = "Does the bot need text processing to obtain phrase parameters?";
	}

	@Override
	protected boolean getMultiresponse() {
		return false;
	}

	@Override
	public List<String> evaluate(Bot bot) {

		for (Intent intent : bot.getIntents()) {
			for (IntentLanguageInputs languages : intent.getInputs()) {
				for (IntentInput phrase : languages.getInputs()) {
					if (phrase instanceof TrainingPhrase) {
						boolean text = false;
						boolean param = false;
						for (Token token : ((TrainingPhrase) phrase).getTokens()) {
							if (token instanceof Literal) {
								text = true;
							} else if (token instanceof ParameterReferenceToken) {
								param = true;
							}
							if (param && text) {
								return getYes();
							}
						}
					}
				}
			}
		}
		return getNo();
	}

}
