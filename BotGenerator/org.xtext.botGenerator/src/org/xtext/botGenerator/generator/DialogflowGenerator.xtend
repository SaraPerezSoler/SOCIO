package org.xtext.botGenerator.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import generator.Bot
import generator.HTTPRequest
import generator.Entity
import generator.Simple
import generator.Composite
import java.util.List
import generator.CompositeInput
import generator.Token
import generator.Literal
import generator.EntityToken
import generator.UserInteraction
import generator.DefaultEntity
import generator.Parameter
import generator.Text
import generator.Image
import generator.ParameterReferenceToken
import generator.ParameterToken
import generator.TextInput

class DialogflowGenerator {
	String path;
	
	def doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var bot = resource.allContents.filter(Bot).toList.get(0);
		var requests = resource.allContents.filter(HTTPRequest).toList;
		path=bot.name+"Dialogflow"
		fsa.generateFile(path + '/package.json', "{\n \"version\": \"1.0.0\"\n}")

		if (!requests.isEmpty) {
			var request = requests.get(0) as HTTPRequest
			fsa.generateFile(path + '/agent.json', agentJSON(bot, request))
		} else {
			fsa.generateFile(path+ '/agent.json', agentJSON(bot, null))
		}
		var entities = resource.allContents.filter(Entity).toList;
		for (Entity entity : entities) {
			fsa.generateFile(path + '/entities/' + entity.name + '.json', entityFile(entity))
			if (entity instanceof Simple) {
				fsa.generateFile(path+ '/entities/' + entity.name + '_entries_' + bot.languageAbbreviation +
					'.json', entriesFile(entity as Simple))
			} else {
				fsa.generateFile(path + '/entities/' + entity.name + '_entries_' + bot.languageAbbreviation +
					'.json', entriesFile(entity as Composite))
			}
		}
		for (UserInteraction transition : bot.flows) {
			createTransitionFiles(transition, "", fsa, bot)
		}

	}
	def void createTransitionFiles(UserInteraction transition, String prefix, IFileSystemAccess2 fsa, Bot bot) {
		fsa.generateFile(
			path + '/intents/' + prefix + transition.intent.name + '_usersays_' + bot.languageAbbreviation +
				'.json', transition.usersayFile)
		fsa.generateFile(path + '/intents/' + prefix + transition.intent.name + '.json',
			transition.intentFile(prefix, bot))
		if (transition.target !== null) {
			var newPrefix = prefix + transition.intent.name + " - ";
			for (UserInteraction t : transition.target.outcoming) {
				createTransitionFiles(t, newPrefix, fsa, bot)
			}
		}
	}

	def contextName(UserInteraction transition, String prefix) {
		var name = prefix + transition.intent.name + " - " + "followup"
		name = name.replaceAll(" ", "");
		return name
	}

	def contextName(String prefix) {
		var name = prefix + "followup"
		name = name.replaceAll(" ", "");
		return name
	}

	def speechText(Text textAction) {
		var ret = ""
		for (TextInput input : textAction.inputs) {
			ret += "\""
			for (Token token : input.tokens) {
				if (token instanceof Literal) {
					ret += token.text + " "
				} else if (token instanceof ParameterToken) {
					ret += "$" + token.parameter.name + " "
				}
			}
			ret += "\""
			if (!isTheLast(textAction.inputs, input)) {
				ret += ","
			}
			ret += "\n"
		}
		return ret;
	}

	def paramType(Parameter param) {
		if (param.entity !== null) {
			return "@" + param.entity.name
		} else {
			switch (param.defaultEntity) {
				case (DefaultEntity.TEXT):
					return "@sys.any"
				case (DefaultEntity.DATE):
					return "@sys.date"
				case (DefaultEntity.TIME):
					return "@sys.time"
				case (DefaultEntity.NUMBER):
					return "@sys.number-integer"
				case (DefaultEntity.FLOAT):
					return "@sys.number"
			}
		}
	}

	def intentFile(UserInteraction transition, String prefix, Bot bot) '''
		«var webhook =false»
		{
		  "name": "«prefix + transition.intent.name»",
		  "auto": true,
		  «IF transition.src!==null»
		  	"contexts": [«contextName(prefix)»],
		  «ELSE»
		  	"contexts": [],
		  «ENDIF»
		  "responses": [
		    {
		      "resetContexts": false,
		      "affectedContexts": [
		      «IF transition.target!== null»
		      	«IF !transition.target.outcoming.isEmpty»
		      		{
		      		  "name": "«contextName(transition, prefix)»",
		      		  "parameters": {},
		      		  "lifespan": 2
		      		}
		      	«ENDIF»
		      «ENDIF»
		      ],
		      "parameters": [
		        «FOR parameter : transition.intent.parameters»
		        	{
		        	  "required": «parameter.required»,
		        	  "dataType": "«parameter.paramType()»",
		        	  "name": "«parameter.name»",
		        	  "value": "$«parameter.name»",
		        	  "prompts": [
		        	  «FOR prompt :parameter.prompts»
		        	  	{
		        	  	  "lang": "«bot.languageAbbreviation»",
		        	  	  "value": "«prompt»"
		        	  	}«IF !isTheLast(parameter.prompts, prompt)»,«ENDIF»
		        	  «ENDFOR»
		        	  ],
		        	  "isList":«parameter.isList» 
		        	}«IF !isTheLast(transition.intent.parameters, parameter)»,«ENDIF»
		        «ENDFOR»
		       ],
		      "messages": [
		      «IF transition.target!==null»
		      	«FOR action:transition.target.actions»
		      		«IF action instanceof Text»
		    			{
		  			"type": 0,
		  			"lang": "«bot.languageAbbreviation»",
		  			"condition": "",
		  			"speech": [
		  				«action.speechText»
		  			]
					}«IF !transition.target.actions.isTheLast(action)»,«ENDIF»
				«ELSEIF action instanceof Image»
					{
					  "type": 3,
					  "lang": "«bot.languageAbbreviation»",
					  "condition": "",
					  "imageUrl": "«action.URL»"
					}«IF !transition.target.actions.isTheLast(action)»,«ENDIF»
				«ELSEIF action instanceof HTTPRequest»
					«{webhook=true; ""}»
				«ENDIF»
			«ENDFOR »
			
			],
			"defaultResponsePlatforms": {
			},
			"speech": []
			}
		    «ENDIF»
		  ],
		  "priority": 500000,
		  "webhookUsed": «webhook»,
		  "webhookForSlotFilling": false,
		  "fallbackIntent": «transition.intent.fallbackIntent»,
		  "events": [],
		  "conditionalResponses": [],
		  "condition": "",
		  "conditionalFollowupEvents": []
		}
	'''

	def agentJSON(Bot bot, HTTPRequest request) '''
		{
		  "language": "«bot.languageAbbreviation»",
		  «IF request !== null »
		  	"webhook": {
		  	  "url": "«returnText(request.URL)»",
		  	  «IF request.basicAuth !== null»
		  	  	"username": "«returnText(request.basicAuth.key)»",
		  	  «ELSE»
		  	  	"username": "",
		  	  «ENDIF»
		  	  "headers": {
		  	   «FOR  header : request.headers»
		  	   	"«header.key»": "«header.value»"
		  	   «ENDFOR»
		  	  },
		  	  "available": true,
		  	  "useForDomains": false,
		  	  "cloudFunctionsEnabled": false,
		  	  "cloudFunctionsInitialized": false
		  	},
		  «ENDIF»
		  "isPrivate": true,
		  "customClassifierMode": "use.after",
		  "mlMinConfidence": 0.3,
		  "supportedLanguages": [],
		  "onePlatformApiVersion": "v2",
		  "analyzeQueryTextSentiment": false,
		  "enabledKnowledgeBaseNames": [],
		  "knowledgeServiceConfidenceAdjustment": -0.4,
		  "dialogBuilderMode": false,
		  "baseActionPackagesUrl": ""
		}
		
	'''

	def usersayFile(UserInteraction transition) '''
		[
		«FOR phrase : transition.intent.inputs»
			{
			  "data": [
			«FOR token: phrase.tokens»
				«IF token instanceof Literal»
					{
					  "text": "«token.text»",
					  "userDefined": false
					},
				«ELSEIF token instanceof ParameterReferenceToken»
					{
					  "text": "«token.textReference»",
					  "alias": "«token.parameter.name»",
					  "meta": "«token.parameter.paramType»",
					  "userDefined": true
					},
				«ENDIF»
				{
					"text": " ",
					"userDefined": false
				}«IF !transition.intent.inputs.isTheLast(token)»,«ENDIF»
			«ENDFOR»
			],
			"isTemplate": false,
			"count": 0,
			"updated": 0
			}«IF !isTheLast(transition.intent.inputs, phrase)»,«ENDIF»
		 «ENDFOR»
		 ]
	'''

	def returnText(String value) {
		if (value.isEmpty) {
			return '';
		}
		return value
	}

	def languageAbbreviation(Bot bot) {
		var lan = bot.language
		switch (lan) {
			case ENGLISH:
				return 'en'
			case SPANISH:
				return 'es'
			case DANISH:
				return 'da'
			case GERMAN:
				return 'de'
			case FRENCH:
				return 'fr'
			case HINDI:
				return 'hi'
			case INDONESIAN:
				return 'id'
			case ITALIAN:
				return 'it'
			case JAPANESE:
				return 'ja'
			case KOREAN:
				return 'ko'
			case DUTCH:
				return 'nl'
			case NORWEGIAN:
				return 'no'
			case POLISH:
				return 'pl'
			case PORTUGUESE:
				return 'pt'
			case RUSIAN:
				return 'ru'
			case SWEDISH:
				return 'sv'
			case THAI:
				return 'th'
			case TURKISH:
				return 'tr'
			case UKRANIAN:
				return 'uk'
			case CHINESE:
				return 'zh'
		}
	}

	def entityFile(Entity entity) '''
		{
		  "name": "«entity.name»",
		  "isOverridable": true,
		  «IF entity instanceof Simple»
		  	"isEnum": false,
		  «ELSE»
		  	"isEnum": true,
		  «ENDIF»
		  "isRegexp": false,
		  "automatedExpansion": true,
		  "allowFuzzyExtraction": false
		}
	'''

	def entriesFile(Simple entity) '''
		[
			«FOR entry : entity.inputs»
				{
				   "value": "«entry.name»",
				   "synonyms": [
				     "«entry.name»"«IF !entry.values.empty»,«ENDIF»
				     «FOR synonym: entry.values»
				     	"«synonym»"«IF !entry.values.isTheLast(synonym)»,«ENDIF»
				     «ENDFOR»
				   ]
				} «IF !entity.inputs.isTheLast(entity)»,«ENDIF»
			«ENDFOR»
		]
	'''

	def entriesFile(Composite entity) '''
		[
			«FOR entry : entity.inputs»
				{
					"value": "«entry.compositeEntry»",
					"synonyms": [
					 	"«entry.compositeEntry»"
					 ]
				}«IF !entity.inputs.isTheLast(entry)»,«ENDIF»
			«ENDFOR»
		]
	'''

	def static isTheLast(List<?> list, Object object) {
		if (list.indexOf(object) == list.size - 1) {
			return true;
		}
		return false;

	}

	def getCompositeEntry(CompositeInput entry) {
		var ret = "";
		for (Token token : entry.tokens) {
			if (token instanceof Literal) {
				ret += token.text + " "
			} else if (token instanceof EntityToken) {
				ret += "@" + token.entity.name + ":" + token.entity.name + " "
			}
		}
		return ret;
	}
}