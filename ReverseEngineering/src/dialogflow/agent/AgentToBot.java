package dialogflow.agent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dialogflow.agent.entities.Entry;
import dialogflow.agent.entities.EntryLanguage;
import dialogflow.agent.intents.Context;
import dialogflow.agent.intents.Data;
import dialogflow.agent.intents.Message;
import dialogflow.agent.intents.Prompt;
import dialogflow.agent.intents.Response;
import dialogflow.agent.intents.UserSaysLanguage;
import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.DefaultEntity;
import generator.Entity;
import generator.GeneratorFactory;
import generator.HTTPRequest;
import generator.HTTPRequestToke;
import generator.HTTPResponse;
import generator.HTTPReturnType;
import generator.Image;
import generator.Intent;
import generator.IntentLanguageInputs;
import generator.KeyValue;
import generator.Language;
import generator.Literal;
import generator.Method;
import generator.Parameter;
import generator.ParameterReferenceToken;
import generator.ParameterToken;
import generator.PromptLanguage;
import generator.Simple;
import generator.SimpleInput;
import generator.SimpleLanguageInput;
import generator.Text;
import generator.TextInput;
import generator.TextLanguageInput;
import generator.TrainingPhrase;
import generator.UserInteraction;

public class AgentToBot {

	private static final int TEXT_TYPE = 0;
	private static final int IMAGE_TYPE = 3;

	public Bot getBot(Agent agent) {
		Bot bot = GeneratorFactory.eINSTANCE.createBot();

		bot.setName(agent.getName());
		bot.getLanguages().add(getLanguage(agent.getLanguage()));
		for (String language : agent.getSupportedLanguages()) {
			bot.getLanguages().add(getLanguage(language));
		}

		for (dialogflow.agent.entities.Entity entity : agent.getEntities()) {
			bot.getEntities().add(entityConversor(entity));
		}
		for (dialogflow.agent.intents.Intent intent : agent.getIntents()) {
			bot.getIntents().add(intentConversor(intent, bot));
			bot.getActions().addAll((actionConversor(intent, bot)));
		}
		bot.getActions().addAll(httpActions(agent, bot));

		for (dialogflow.agent.intents.Intent intent : agent.getIntents()) {
			if (intent.getContext().isEmpty()) {
				bot.getFlows().add(getFlow(intent, agent, bot));
			}
		}

		return bot;
	}

	private UserInteraction getFlow(dialogflow.agent.intents.Intent intent, Agent agent, Bot bot) {
		UserInteraction flow = getInteractionFlow(intent, bot);
		for (Response responses : intent.getResponses()) {
			for (Context context : responses.getAffectedContext()) {
				for (dialogflow.agent.intents.Intent followUp : agent.getIntents(context)) {
					UserInteraction followUpInteraction = getFlow(followUp, agent, bot);
					if (flow.getTarget() != null) {
						flow.getTarget().getOutcoming().add(followUpInteraction);
					}
				}
			}
		}
		return flow;
	}

	private UserInteraction getInteractionFlow(dialogflow.agent.intents.Intent intent, Bot bot) {
		UserInteraction userInteraction = GeneratorFactory.eINSTANCE.createUserInteraction();
		Intent botIntent = bot.getIntent(intent.getName());

		userInteraction.setIntent(botIntent);
		List<Action> actions = bot.getActionStartWith(botIntent.getName());
		Collections.sort(actions, new Comparator<Action>() {

			@Override
			public int compare(Action o1, Action o2) {
				int i1 = Integer.parseInt(o1.getName().substring(o1.getName().length() - 1));
				int i2 = Integer.parseInt(o2.getName().substring(o2.getName().length() - 1));
				return Integer.compare(i1, i2);
			}
		});
		BotInteraction botInteraction = GeneratorFactory.eINSTANCE.createBotInteraction();
		for (Action action : actions) {
			botInteraction.getActions().add(action);
		}

		if (intent.isWebhookUsed()) {
			botInteraction.getActions().add(bot.getAction("HttpRequest"));
			botInteraction.getActions().add(bot.getAction("HttpResponse"));
		}
		userInteraction.setTarget(botInteraction);
		return userInteraction;

	}

	private List<Action> httpActions(Agent agent, Bot bot) {
		List<Action> ret = new ArrayList<>();
		Webhook webhook = agent.getWebhook();
		if (webhook == null) {
			return ret;
		}
		HTTPRequest request = GeneratorFactory.eINSTANCE.createHTTPRequest();
		request.setURL(webhook.getUrl());
		request.setBasicAuth(getKeyValue(webhook.getUrl(), ""));
		for (String key : webhook.getHeaders().keySet()) {
			request.getHeaders().add(getKeyValue(key, webhook.getHeaders().get(key)));
		}
		request.setMethod(Method.POST);
		request.setName("HttpRequest");
		HTTPResponse response = GeneratorFactory.eINSTANCE.createHTTPResponse();
		response.setHTTPRequest(request);
		response.setName("HttpResponse");

		for (Language lan : bot.getLanguages()) {
			TextLanguageInput input = GeneratorFactory.eINSTANCE.createTextLanguageInput();
			input.setLanguage(lan);
			TextInput textInput = GeneratorFactory.eINSTANCE.createTextInput();

			HTTPRequestToke token = GeneratorFactory.eINSTANCE.createHTTPRequestToke();
			token.setType(HTTPReturnType.TEXT);
			textInput.getTokens().add(token);
			input.getInputs().add(textInput);

			response.getInputs().add(input);
		}
		ret.add(request);
		ret.add(response);
		return ret;
	}

	private KeyValue getKeyValue(String key, String value) {
		KeyValue keyValue = GeneratorFactory.eINSTANCE.createKeyValue();
		keyValue.setKey(key);
		Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
		literal.setText(value);
		keyValue.setValue(literal);
		return keyValue;
	}

	private List<Action> actionConversor(dialogflow.agent.intents.Intent intent, Bot bot) {
		List<Action> actions = new ArrayList<>();
		for (Response response : intent.getResponses()) {
			int i = 1;
			Action action = null;
			for (Message msg : response.getMessages()) {
				if (msg.getType() == TEXT_TYPE) {
					action = textActionConversor(intent.getName(), i, msg, bot);
				} else if (msg.getType() == IMAGE_TYPE) {
					action = imageActionConversor(intent.getName(), i, msg, bot);
				}
				if (action != null) {
					actions.add(action);
					if (action.getName().endsWith(i + "")) {
						i++;
					}
				}
			}
		}
		return actions;
	}

	/*
	 * private Text textActionConversor(String name, int i, Message msg, Bot bot) {
	 * 
	 * String actionName = name + "TextResponse" + i; Action ret =
	 * bot.getAction(actionName); Intent intent = bot.getIntent(name); //Comprobar
	 * si existe una action con el nombre, si no existe se crea if (ret == null) {
	 * ret = GeneratorFactory.eINSTANCE.createText(); ret.setName(actionName); }
	 * 
	 * if (ret instanceof Text) {
	 * 
	 * Text text = (Text) ret; //Si la action no tiene una entrada para el lenguaje
	 * se crea una TextLanguageInput textLang =
	 * text.getInput(getLanguage(msg.getLang())); if (textLang == null) { textLang =
	 * GeneratorFactory.eINSTANCE.createTextLanguageInput();
	 * textLang.setLanguage(getLanguage(msg.getLang()));
	 * text.getInputs().add(textLang); for (String textString: msg.getSpeech()) {
	 * textLang.getInputs().add(createTextInputs(textString, intent)); } } else {
	 * //Si si la tiene, comprobamos creamos una nueva action aumentando el contador
	 * return textActionConversor(actionName, i + 1, msg, bot); } } return null; }
	 */

	private Text textActionConversor(String name, int i, Message msg, Bot bot) {

		Intent intent = bot.getIntent(name);
		TextLanguageInput textLang = GeneratorFactory.eINSTANCE.createTextLanguageInput();
		textLang.setLanguage(getLanguage(msg.getLang()));
		if (msg.getSpeech().isEmpty()) {
			textLang.getInputs().add(createTextInputs("", intent));
		}
		for (String textString : msg.getSpeech()) {
			textLang.getInputs().add(createTextInputs(textString, intent));
		}
		Action ret;
		String actionName;
		for (int j = 1; j <= i; j++) {
			actionName = name + "TextResponse" + j;
			ret = bot.getAction(actionName);
			if (ret != null && ret instanceof Text) {
				TextLanguageInput aux = ((Text) ret).getInput(getLanguage(msg.getLang()));
				if (aux == null) {
					((Text) ret).getInputs().add(textLang);
					return ((Text) ret);
				}
			}
		}
		actionName = name + "TextResponse" + i;
		ret = GeneratorFactory.eINSTANCE.createText();
		ret.setName(actionName);
		((Text) ret).getInputs().add(textLang);
		return ((Text) ret);
	}

	private TextInput createTextInputs(String text, Intent intent) {
		TextInput ret = GeneratorFactory.eINSTANCE.createTextInput();

		String input = "";
		for (String split : text.split(" ")) {
			if (split.startsWith("$")) {
				if (!input.isEmpty()) {
					Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
					literal.setText(input);
					ret.getTokens().add(literal);
					input = "";
				}
				Parameter param = intent.getParameter(split.replace("$", ""));
				if (param != null) {
					ParameterToken token = GeneratorFactory.eINSTANCE.createParameterToken();
					token.setParameter(param);
					ret.getTokens().add(token);
				}
			} else {
				input += split + " ";
			}
		}
		if (!input.isEmpty()) {
			Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
			literal.setText(input);
			ret.getTokens().add(literal);
			input = "";
		}
		return ret;
	}

	private Image imageActionConversor(String name, int i, Message msg, Bot bot) {
		String actionName = name + "ImageResponse" + i;
		Action ret = bot.getAction(actionName);
		// Comprobar si existe una action con el nombre, si no existe se crea
		if (ret == null) {
			ret = GeneratorFactory.eINSTANCE.createImage();
			ret.setName(actionName);
			((Image) ret).setURL(msg.getImageUrl());
			return ((Image) ret);
		} else {
			return imageActionConversor(actionName, i + 1, msg, bot);
		}

	}

	private Intent intentConversor(dialogflow.agent.intents.Intent intent, Bot bot) {
		Intent ret = GeneratorFactory.eINSTANCE.createIntent();
		ret.setName(intent.getName());
		ret.setFallbackIntent(intent.isFallbackIntent());
		for (dialogflow.agent.intents.Response responses : intent.getResponses()) {
			for (dialogflow.agent.intents.Parameter param : responses.getParameters()) {
				ret.getParameters().add(parameterConversor(param, bot));
			}
		}

		for (UserSaysLanguage usersays : intent.getUsersays()) {
			IntentLanguageInputs languageInput = GeneratorFactory.eINSTANCE.createIntentLanguageInputs();
			languageInput.setLanguage(getLanguage(usersays.getLanguage()));
			for (dialogflow.agent.intents.TrainingPhrase phrase : usersays.getPhrases()) {
				TrainingPhrase training = GeneratorFactory.eINSTANCE.createTrainingPhrase();
				for (Data data : phrase.getData()) {
					if (data.isUserDefined()) {
						Parameter param = ret.getParameter(data.getAlias());
						ParameterReferenceToken reference = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
						reference.setTextReference(data.getText());
						reference.setParameter(param);
						training.getTokens().add(reference);
					} else {
						Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
						literal.setText(data.getText());
						training.getTokens().add(literal);
					}
				}
				languageInput.getInputs().add(training);
			}
			ret.getInputs().add(languageInput);
		}

		return ret;
	}

	private Parameter parameterConversor(dialogflow.agent.intents.Parameter param, Bot bot) {
		Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
		parameter.setName(param.getName());
		parameter.setIsList(param.isList());
		parameter.setRequired(param.isRequired());
		for (Prompt prompt : param.getPrompts()) {
			PromptLanguage promptLan = parameter.getPrompt(getLanguage(prompt.getLang()));
			if (promptLan == null) {
				promptLan = GeneratorFactory.eINSTANCE.createPromptLanguage();
				promptLan.setLanguage(getLanguage(prompt.getLang()));
				parameter.getPrompts().add(promptLan);
			}
			promptLan.getPrompts().add(prompt.getValue());
		}
		Entity entity = bot.getEntity(param.getDataType());
		if (entity == null) {
			DefaultEntity default_ = getDefaultEntity(param.getDataType());
			parameter.setDefaultEntity(default_);
		} else {
			parameter.setEntity(entity);
		}
		return parameter;
	}

	private DefaultEntity getDefaultEntity(String dataType) {
		switch (dataType) {
		case "@sys.number-integer":
			return DefaultEntity.NUMBER;
		case "@sys.number":
			return DefaultEntity.FLOAT;
		case "@sys.date":
			return DefaultEntity.DATE;
		case "@sys.time":
			return DefaultEntity.TIME;
		default:
			return DefaultEntity.TEXT;
		}
	}

	private Language getLanguage(String language) {
		switch (language) {
		case "en":
			return Language.ENGLISH;
		case "es":
			return Language.SPANISH;
		case "da":
			return Language.DANISH;
		case "de":
			return Language.GERMAN;
		case "fr":
			return Language.FRENCH;
		case "hi":
			return Language.HINDI;
		case "id":
			return Language.INDONESIAN;
		case "it":
			return Language.ITALIAN;
		case "ja":
			return Language.JAPANESE;
		case "ko":
			return Language.KOREAN;
		case "nl":
			return Language.DUTCH;
		case "no":
			return Language.NORWEGIAN;
		case "pl":
			return Language.POLISH;
		case "pt":
			return Language.PORTUGUESE;
		case "ru":
			return Language.RUSIAN;
		case "sv":
			return Language.SWEDISH;
		case "th":
			return Language.THAI;
		case "tr":
			return Language.TURKISH;
		case "uk":
			return Language.UKRANIAN;
		case "zh":
			return Language.CHINESE;
		default:
			return Language.ENGLISH;
		}
	}

	private Entity entityConversor(dialogflow.agent.entities.Entity entity) {
		if (entity.isEnum() == false) {
			Simple ret = GeneratorFactory.eINSTANCE.createSimple();
			ret.setName(entity.getName());
			for (EntryLanguage entryLan : entity.getEntriesLanguage()) {
				SimpleLanguageInput input = GeneratorFactory.eINSTANCE.createSimpleLanguageInput();
				input.setLanguage(getLanguage(entryLan.getLanguage()));
				for (Entry entry : entryLan.getEntries()) {
					SimpleInput simpleInput = GeneratorFactory.eINSTANCE.createSimpleInput();
					simpleInput.setName(entry.getValue());
					simpleInput.getValues().addAll(entry.getSynonyms());
					input.getInputs().add(simpleInput);
				}
				ret.getInputs().add(input);
			}
			return ret;
		} else {
			// TODO
			return null;
		}
	}

}
