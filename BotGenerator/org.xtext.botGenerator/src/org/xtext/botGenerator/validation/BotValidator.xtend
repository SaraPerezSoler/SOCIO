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
import generator.Entity
import generator.Language
import generator.Text

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
		if (container instanceof Simple) {
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
	def entityLanguage(Entity entity) {
		if (entity.language !== Language.EMPTY) {
			var container = entity.eContainer
			if (container instanceof Bot) {
				if (!container.languages.contains(entity.language)) {
					error("The entity language must be some of the bot languages",
						GeneratorPackage.Literals.ENTITY__LANGUAGE)
				}
			}
		}
	}

	@Check
	def intentLanguage(Intent intent) {
		if (intent.language !== Language.EMPTY) {
			var container = intent.eContainer
			if (container instanceof Bot) {
				if (!container.languages.contains(intent.language)) {
					error("The intent language must be some of the bot languages",
						GeneratorPackage.Literals.ENTITY__LANGUAGE)
				}
			}
		}
	}

	@Check
	def paramLanguage(Parameter param) {
		if (param.prompLanguage !== Language.EMPTY) {
			var container = param.eContainer.eContainer
			if (container instanceof Bot) {
				if (!container.languages.contains(param.prompLanguage)) {
					error("The prompt language must be some of the bot languages",
						GeneratorPackage.Literals.ENTITY__LANGUAGE)
				}
			}
		}
	}
		@Check
	def textLanguage(Text text) {
		if (text.language !== Language.EMPTY) {
			var container = text.eContainer
			if (container instanceof Bot) {
				if (!container.languages.contains(text.language)) {
					error("The text language must be some of the bot languages",
						GeneratorPackage.Literals.ENTITY__LANGUAGE)
				}
			}
		}
	}
}