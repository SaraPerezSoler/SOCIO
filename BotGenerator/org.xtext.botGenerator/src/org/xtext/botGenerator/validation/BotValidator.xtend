/*
 * generated by Xtext 2.19.0
 */
package org.xtext.botGenerator.validation

import generator.Bot
import generator.GeneratorPackage
import generator.HTTPRequestToke
import generator.HTTPReturnType
import generator.Intent
import generator.ParameterReferenceToken
import generator.TrainingPhrase
import org.eclipse.xtext.validation.Check
import generator.Element
import java.util.ArrayList
import generator.Parameter
import generator.Simple
import generator.SimpleInput
import generator.HTTPResponse
import generator.BotInteraction
import generator.Language
import generator.SimpleLanguageInput
import generator.IntentLanguageInputs
import generator.PromptLanguage
import generator.TextLanguageInput
import generator.Text
import generator.Action

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class BotValidator extends AbstractBotValidator {

//	public static val INVALID_NAME = 'invalidName'
//
//	@Check
//	def checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
//			warning('Name should start with a capital', 
//					BotPackage.Literals.GREETING__NAME,
//					INVALID_NAME)
//		}
//	}
	@Check
	def checkHTTTPRequestTokenDataKey(HTTPRequestToke httpRequestToken) {
		if (httpRequestToken.type != HTTPReturnType.DATA && !httpRequestToken.dataKey.isEmpty) {
			warning('The data key is only using with the data type of http request',
				GeneratorPackage.Literals.HTTP_REQUEST_TOKE__DATA_KEY, "invalid data key")
		}
	}

	@Check
	def checkParameterReferences(ParameterReferenceToken references) {
		var container = references.eContainer
		if (!(container instanceof TrainingPhrase)) {
			return
		}
		var containercontainer = container.eContainer
		if (!(containercontainer instanceof Intent)) {
			return
		}
		var intent = containercontainer as Intent
		if (!intent.parameters.contains(references.parameter)) {
			error("This parameter is not from the list of intents parameters",
				GeneratorPackage.Literals.PARAMETER_REFERENCE_TOKEN__PARAMETER)
		}
	}

	@Check
	def flowPath(Bot bot) {
		for (var i = 0; i < bot.flows.size; i++) {
			var current = bot.flows.get(i);
			for (var j = i + 1; j < bot.flows.size; j++) {
				var nexts = bot.flows.get(j)
				if (current.intent === nexts.intent) {
					error("Only one path can start with the intent " + current.intent.name,
						GeneratorPackage.Literals.BOT__FLOWS)
				}
			}
		}
	}

	@Check
	def flowPathState(BotInteraction state) {
		for (var i = 0; i < state.outcoming.size; i++) {
			var current = state.outcoming.get(i);
			for (var j = i + 1; j < state.outcoming.size; j++) {
				var nexts = state.outcoming.get(j)
				if (current.intent === nexts.intent) {
					error("Only one path can start with the intent " + current.intent.name,
						GeneratorPackage.Literals.BOT_INTERACTION__OUTCOMING)
				}
			}
		}
	}

	@Check
	def nameUnique(Element e) {
		var container = e.eContainer;
		if (container instanceof Bot) {
			var elements = new ArrayList<Element>();
			elements.addAll(container.intents);
			elements.addAll(container.actions)
			elements.addAll(container.entities)

			for (Element i : elements) {
				if ((!i.equals(e)) && i.name.equals(e.name)) {
					error("There are several elements with the name " + i.name +
						". The name of the elements must be unique", GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def nameUnique(Parameter param) {
		var container = param.eContainer;
		if (container instanceof Intent) {
			for (Parameter p : container.parameters) {
				if ((!param.equals(p)) && param.name.equals(p.name)) {
					error("There are several parameters with the name " + p.name +
						" in this intent. The name of the parameters must be unique",
						GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def nameUnique(SimpleInput input) {
		var container = input.eContainer;
		if (container instanceof SimpleLanguageInput) {
			for (SimpleInput i : container.inputs) {
				if ((!input.equals(i)) && input.name.equals(i.name)) {
					error("There are several entries with the name " + i.name +
						" in this entity. The name of the entries must be unique",
						GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def paramEntity(Parameter param) {
		if (param.entity === null && param.defaultEntity === null) {
			error("The parameter must have a entity", GeneratorPackage.Literals.PARAMETER__ENTITY)
		}
	}

	@Check
	def requestExecution(BotInteraction interaction) {
		for (action : interaction.actions) {
			if (action instanceof HTTPResponse) {
				var index = interaction.actions.indexOf(action)
				if (index == 0) {
					error("Before an HttpResponse must go the HttpRequest which reference",
						GeneratorPackage.Literals.BOT_INTERACTION__ACTIONS)
				} else if (interaction.actions.get(index - 1) !== action.HTTPRequest) {
					error("Before an HttpResponse must go the HttpRequest which reference",
						GeneratorPackage.Literals.BOT_INTERACTION__ACTIONS)
				}
			}
		}
	}

	@Check
	def entityLanguage(Simple entity) {
		var entityLan = new ArrayList<Language>();
		var container = entity.eContainer
		if (container instanceof Bot) {
			for (SimpleLanguageInput input : entity.inputs) {
				if (input.language == Language.EMPTY) {
					input.language = container.languages.get(0);
				}
				if (!entityLan.contains(input.language)) {
					entityLan.add(input.language)
				}
			}
			for (Language lan : container.languages) {
				if (!entityLan.contains(lan)) {
					warning("The chatbot support the language " + lan.literal.toLowerCase().toFirstUpper +
						" and this entity does not have a input in this language",
						GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def entityLanguage(SimpleLanguageInput input) {
		var bot = input.eContainer.eContainer
		var entity = input.eContainer
		if (bot instanceof Bot) {
			if (entity instanceof Simple) {
				if (input.language == Language.EMPTY) {
					input.language = bot.languages.get(0);
				}
				if (!bot.languages.contains(input.language)) {
					error("The input languages must be one of the chatbot languages",
						GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
				}
				for (SimpleLanguageInput input2 : entity.inputs) {
					if (!input.equals(input2) && input.language.equals(input2.language)) {
						error("The intent can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def intentLanguage(Intent intent) {
		var intentLan = new ArrayList<Language>();
		var container = intent.eContainer
		if (container instanceof Bot) {
			for (IntentLanguageInputs input : intent.inputs) {
				if (input.language == Language.EMPTY) {
					input.language = container.languages.get(0);
				}
				if (!intentLan.contains(input.language)) {
					intentLan.add(input.language)
				}
			}
			for (Language lan : container.languages) {
				if (!intentLan.contains(lan)) {
					warning("The chatbot support the language " + lan.literal.toLowerCase().toFirstUpper +
						" and this intent does not have a input in this language",
						GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def intentLanguage(IntentLanguageInputs input) {
		var bot = input.eContainer.eContainer
		var intent = input.eContainer
		if (bot instanceof Bot) {
			if (intent instanceof Intent) {
				if (input.language == Language.EMPTY) {
					input.language = bot.languages.get(0);
				}
				if (!bot.languages.contains(input.language)) {
					error("The input languages must be one of the chatbot languages",
						GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
				}
				for (IntentLanguageInputs input2 : intent.inputs) {
					if (!input.equals(input2) && input.language.equals(input2.language)) {
						error("The intent can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def paramLanguage(PromptLanguage prompt) {
		var bot = prompt.eContainer.eContainer.eContainer
		var param = prompt.eContainer
		if (bot instanceof Bot) {
			if (param instanceof Parameter) {
				if (prompt.language == Language.EMPTY) {
					prompt.language = bot.languages.get(0)
				}
				if (!bot.languages.contains(prompt.language)) {
					error("The prompt language must be some of the chatbot languages",
						GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
				}

				for (PromptLanguage prompt2 : param.prompts) {
					if (!prompt.equals(prompt2) && prompt.language.equals(prompt2.language)) {
						error("The parameter can not have several prompts with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def paramLanguage(Parameter param) {
		var paramLan = new ArrayList<Language>();
		var container = param.eContainer.eContainer
		if (container instanceof Bot) {
			for (PromptLanguage input : param.prompts) {
				if (input.language == Language.EMPTY) {
					input.language = container.languages.get(0);
				}
				if (!paramLan.contains(input.language)) {
					paramLan.add(input.language)
				}
			}
			if (!param.prompts.empty) {
				for (Language lan : container.languages) {
					if (!paramLan.contains(lan)) {
						warning("The chatbot support the language " + lan.literal.toLowerCase().toFirstUpper +
							" and this parameter does not have a prompt in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			}
		}
	}

	@Check
	def textLanguage(TextLanguageInput text) {
		var bot = text.eContainer.eContainer
		var action = text.eContainer
		if (bot instanceof Bot) {
			if (text.language == Language.EMPTY) {
				text.language = bot.languages.get(0)
			}
			if (!bot.languages.contains(text.language)) {
				error("The text language must be some of the chatbot languages",
					GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
			}
			if (action instanceof Text) {
				for (TextLanguageInput text2 : action.inputs) {
					if (!text.equals(text2) && text.language.equals(text2.language)) {
						error("The text response can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			} else if (action instanceof HTTPResponse) {
				for (TextLanguageInput text2 : action.inputs) {
					if (!text.equals(text2) && text.language.equals(text2.language)) {
						error("The http response can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def textLanguage(Action action) {
		var actionLan = new ArrayList<Language>();

		var bot = action.eContainer

		if (bot instanceof Bot) {
			if (action instanceof Text) {
				for (TextLanguageInput input : action.inputs) {
					if (input.language == Language.EMPTY) {
						input.language = bot.languages.get(0);
					}
					if (!actionLan.contains(input.language)) {
						actionLan.add(input.language)
					}
				}
				for (Language lan : bot.languages) {
					if (!actionLan.contains(lan)) {
						warning("The chatbot support the language " + lan.literal.toLowerCase().toFirstUpper +
							" and this text response does not have a input in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			} else if (action instanceof HTTPResponse) {
				for (TextLanguageInput input : action.inputs) {
					if (input.language == Language.EMPTY) {
						input.language = bot.languages.get(0);
					}
					if (!actionLan.contains(input.language)) {
						actionLan.add(input.language)
					}
				}
				for (Language lan : bot.languages) {
					if (!actionLan.contains(lan)) {
						warning("The chatbot support the language " + lan.literal.toLowerCase().toFirstUpper +
							" and this http response does not have a input in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			}
		}
	}
}
