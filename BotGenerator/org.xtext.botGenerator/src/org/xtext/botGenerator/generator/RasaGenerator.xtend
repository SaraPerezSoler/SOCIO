package org.xtext.botGenerator.generator

import generator.Action
import generator.Bot
import generator.Composite
import generator.DefaultEntity
import generator.Entity
import generator.Image
import generator.Intent
import generator.Literal
import generator.Parameter
import generator.ParameterReferenceToken
import generator.ParameterToken
import generator.Simple
import generator.Text
import generator.TextInput
import generator.TrainingPhrase
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import generator.HTTPRequest
import generator.DataType
import generator.HTTPResponse
import generator.HTTPRequestToke
import generator.HTTPReturnType
import generator.UserInteraction
import java.util.ArrayList
import generator.BotInteraction
import generator.Interaction
import generator.Language
import generator.TextLanguageInput

class RasaGenerator {

	String path;

	def doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var bot = resource.allContents.filter(Bot).toList.get(0);
		var intents = resource.allContents.filter(Intent).toList;
		var entities = resource.allContents.filter(Entity).toList;
		var parameters = resource.allContents.filter(Parameter).toList;
		var actions = resource.allContents.filter(Action).toList;
		var leafs = new ArrayList<Interaction>();
		for (UserInteraction flow : bot.flows) {
			leafsU(flow, leafs)
		}
		for (Language lan : bot.languages) {
			path = bot.name + "Rasa" + "_" + lan.languageAbbreviation
			fsa.generateFile(path + '/actions.py', actions(intents, entities, actions, lan))
			fsa.generateFile(path + '/config.yml', config(lan))
			fsa.generateFile(path + '/credentials.yml', credentials)
			fsa.generateFile(path + '/domain.yml', domain(intents, parameters, actions, lan))
			fsa.generateFile(path + '/endpoints.yml', endpoint)
			fsa.generateFile(path + '/data/nlu.md', nlu(intents, lan))
			fsa.generateFile(path + '/data/stories.md', stories(leafs))
		}
	}

	def String actionName(Action action) {
		if (action instanceof Text || action instanceof Image) {
			return "utter_" + action.name.getRasaValue
		}
		return "action_" + action.name.getRasaValue
	}

	def void leafsU(UserInteraction flow, List<Interaction> leafs) {
		if (flow.target === null) {
			leafs.add(flow)
		} else {
			leafsB(flow.target, leafs)
		}
	}

	def void leafsB(BotInteraction flow, List<Interaction> leafs) {
		if (flow.outcoming.isEmpty) {
			leafs.add(flow)
		} else {
			for (UserInteraction user : flow.outcoming) {
				leafsU(user, leafs)
			}
		}

	}

	def String stories(List<Interaction> leafs) {
		var ret = ""
		for (var i = 0; i < leafs.size; i++) {
			var clean = new ArrayList<Intent>()
			var leaf = leafs.get(i)
			ret += path(leaf, i, clean) + "\n"
		}
		return ret;
	}

	def path(Interaction flow, int i, List<Intent> clean) '''
		## path_«i»
		«IF flow instanceof UserInteraction»
			«flow(flow as UserInteraction, clean)»
		«ELSEIF flow instanceof BotInteraction»
			«flow(flow as BotInteraction, clean)»
		«ENDIF»
		«FOR intent : clean»
			«"\t"»- «intent.name.getRasaValue»_clean
		«ENDFOR»
	'''

	def String flow(UserInteraction user, List<Intent> clean) '''
		«IF user.src!==null»
			«flow(user.src, clean)»
		«ENDIF»
		* «user.intent.name.rasaValue»	
		«IF !user.intent.parameters.isEmpty»
			«"\t"»- «{clean.add(user.intent);user.intent.name.getRasaValue}»_form
			«"\t"»- form{"name": "«user.intent.name.getRasaValue»_form"}
			«"\t"»- form{"name": null}
		«ENDIF»
	'''

	def String flow(BotInteraction bot, List<Intent> clean) '''
		«IF bot.incoming !== null»
			«flow(bot.incoming, clean)»
		«ENDIF»
		«FOR action : bot.actions»
			«"\t"»- «action.actionName»
		«ENDFOR»
	'''

	def actions(List<Intent> intents, List<Entity> entities, List<Action> actions, Language lan) '''
		# This files contains your custom actions which can be used to run
		# custom Python code.
		#
		# See this guide on how to implement these action:
		# https://rasa.com/docs/rasa/core/actions/#custom-actions/
		
		
		# This is a simple example for a custom action which utters "Hello World!"
		
		# from typing import Any, Text, Dict, List
		#
		# from rasa_sdk import Action, Tracker
		# from rasa_sdk.executor import CollectingDispatcher
		#
		#
		# class ActionHelloWorld(Action):
		#
		#     def name(self) -> Text:
		#         return "action_hello_world"
		#
		#     def run(self, dispatcher: CollectingDispatcher,
		#             tracker: Tracker,
		#             domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
		#
		#         dispatcher.utter_message("Hello World!")
		#
		#         return []
		from typing import Dict, Text, Any, List, Union, Optional
		
		from rasa_sdk import ActionExecutionRejection
		from rasa_sdk import Action
		from rasa_sdk import Tracker
		from rasa_sdk.events import SlotSet
		from rasa_sdk.executor import CollectingDispatcher
		from rasa_sdk.forms import FormAction, REQUESTED_SLOT
		from duckling import DucklingWrapper, Dim, Language
		import time
		import requests
		
		d = DucklingWrapper()
		def time_validate(value:Text):
			parses = d.parse_time(value)
			for parse in parses:
				if parse ['dim'] == 'time':
					if parse['value'].get('grain') == 'minute' or parse['value'].get('grain') == 'hour': 
						return parse ['value']['value']
			return None
			
		def date_validate(value:Text):
				parses = d.parse_time(value)
				for parse in parses:
					if parse ['dim'] == 'time':
						if parse['value'].get('grain') == 'day' or parse['value'].get('grain') == 'month' or parse['value'].get('grain') == 'year': 
							return parse ['value']['value']
				return None
				
		«FOR entity : entities»
			«IF entity instanceof Simple»
			«FOR simpleLanguage : entity.inputs»
			«IF simpleLanguage.language.equals(lan)»
				«entity.name.rasaValue»_db={
					«FOR input: simpleLanguage.inputs»
						"«input.name.toLowerCase»":["«input.name.toLowerCase»"«FOR value: input.values»,"«value.toLowerCase»"«ENDFOR»]«IF !DialogflowGenerator.isTheLast(entity.inputs, input)»,«ENDIF»
					«ENDFOR»
				}
				
				def «entity.name.rasaValue»_validate(value:Text):
					for input in «entity.name.rasaValue»_db:
						if value.lower() in «entity.name.rasaValue»_db[input]:
							return input
					return None
			«ENDIF»		
			«ENDFOR»
			«ELSEIF entity instanceof Composite»
				def «entity.name.rasaValue»_validate(value:Text):
					return None
					
			«ENDIF»
		«ENDFOR»
		«FOR intent : intents»
			«IF !intent.parameters.empty»
				class «intent.name.getRasaValue»Form (FormAction):
					def name(self):
						# type: () -> Text
						"""Unique identifier of the form"""
					
						return "«intent.name.getRasaValue»_form"
						
					@staticmethod
					def required_slots(tracker: Tracker) -> List[Text]:
						"""A list of required slots that the form has to fill"""
						«var coma =""»
			return [«FOR param :intent.parameters»«IF param.required»«coma»"«{coma=",";param.name.rasaValue}»"«ENDIF»«ENDFOR»]
			«FOR param :intent.parameters»
				
				def validate_«param.name.getRasaValue»(self, value: Text,dispatcher: CollectingDispatcher,tracker: Tracker,domain: Dict[Text, Any]) -> Dict[Text, Any]:
					«IF param.entity !== null»
						parseValue = «param.entity.name.rasaValue»_validate(value)
					«ELSEIF param.defaultEntity === DefaultEntity.DATE»
						parseValue = date_validate(value)
					«ELSEIF param.defaultEntity === DefaultEntity.TIME»
						parseValue = time_validate(value)
					«ELSEIF param.defaultEntity === DefaultEntity.TEXT»
						parseValue = value
					«ELSEIF param.defaultEntity === DefaultEntity.FLOAT»
						try:
							parseValue = float (value)
						except ValueError:
							parseValue = None
					«ELSEIF param.defaultEntity === DefaultEntity.NUMBER»
						try:
							parseValue = int (value)
						except ValueError:
							parseValue = None
					«ENDIF»
					if parseValue is None:
						dispatcher.utter_template('utter_wrong_«param.name.getRasaValue»', tracker)
						return {'«param.name.getRasaValue»': None}
					return {'«param.name.getRasaValue»': parseValue}
			«ENDFOR»
			
			def slot_mappings(self):
			
			        return {
			        	«FOR param :intent.parameters»
			        		"«param.name.rasaValue»": [self.from_entity(entity="«param.name.rasaValue»"),self.from_«param.paramType»()],
			        	«ENDFOR»
			        	}
			def submit(
			    self,
			    dispatcher: CollectingDispatcher,
			    tracker: Tracker,
			    domain: Dict[Text, Any],
			) -> List[Dict]:
			    """Define what the form has to do
			        after all required slots are filled"""
			    return []
			
					class «intent.name.getRasaValue»Clean (Action):
						def name(self) -> Text:
							return "«intent.name.getRasaValue»_clean"
			
					def run(self, dispatcher: CollectingDispatcher,
							tracker: Tracker,
							domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
			return [«FOR param :intent.parameters»SlotSet("«param.name.rasaValue»", None) «IF !DialogflowGenerator.isTheLast(intent.parameters, param)»,«ENDIF»«ENDFOR»]            
		«ENDIF»
		«ENDFOR»
		«FOR action : actions»
			«IF action instanceof HTTPRequest»
				class «action.name.getRasaValue» (Action):
					response = None
					def name(self) -> Text:
						return "«action.actionName»"
				
						def run(self, dispatcher: CollectingDispatcher,
								tracker: Tracker,
								domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
						url = '«action.URL»'
						«var args =""»
						
						«IF action.basicAuth !== null»
							auth={'«action.basicAuth.key»', '«action.basicAuth.value»'}
							«{args+=", auth=auth"; ""}»
						«ENDIF»
						
						«IF !action.headers.isEmpty»
							headers={
								«FOR header: action.headers»
									'«header.key»':'«header.value»'«IF !DialogflowGenerator.isTheLast(action.headers, header)», «ENDIF»
								«ENDFOR»
							}
							«{args+=", headers=headers"; ""}»
						«ENDIF»
						
						«IF !action.data.isEmpty»
							data = {
								«FOR d : action.data»
									«IF d.value instanceof ParameterToken»
										'«d.key»': tracker.get_slot("«(d.value as ParameterToken).parameter.name.getRasaValue»")«IF !DialogflowGenerator.isTheLast(action.data, d)», «ENDIF»
									«ELSE»
										'«d.key»':'«d.value»'«IF !DialogflowGenerator.isTheLast(action.data, d)», «ENDIF»
									«ENDIF»
								«ENDFOR»
							}
							«IF action.dataType === DataType.FORM»«{args+=",data=data";""}»«ELSE»«{args+=",json=data";""}»«ENDIF»
						«ENDIF»
						«action.name.rasaValue».response = requests.«action.method.getName.toLowerCase»(url «args») 
			«ELSEIF action instanceof HTTPResponse»
				class «action.name.rasaValue» (Action):
					def name(self) -> Text:
						return "«action.actionName»"
					
					def run(self, dispatcher: CollectingDispatcher,
							tracker: Tracker,
							domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
						response = «(action as HTTPResponse).HTTPRequest.name.rasaValue».response			
						text = «getHttpResponseText(action as HTTPResponse, lan)»
						dispatcher.utter_message(text)
						return []         
				
			«ENDIF»
			
		«ENDFOR»
		
	'''

	def getHttpResponseText(HTTPResponse action, Language lan) {
		var ret = ""
		for (TextLanguageInput textLanguage : action.inputs) {
			if (textLanguage.language.equals(lan)) {
				for (token : textLanguage.inputs.get(0).tokens) {
					if (token instanceof Literal) {
						ret += "'" + token.text + "'"
					} else if (token instanceof ParameterToken) {
						ret += "tracker.get_slot(\"" + token.parameter.name.getRasaValue + "\")"
					} else if (token instanceof HTTPRequestToke) {
						if (token.type == HTTPReturnType.TEXT)
							ret += "response.text"
						else if (token.type == HTTPReturnType.STATUS_CODE)
							ret += "response.status_code"
						else if (token.type == HTTPReturnType.DATA) {
							if (!token.dataKey.isEmpty) {
								ret += "response.json()['" + token.dataKey + "']"
							} else {
								ret += "response.json()"
							}
						}
					}
					if (!DialogflowGenerator.isTheLast(textLanguage.inputs.get(0).tokens, token)) {
						ret += "+"
					}

				}
			}
		}

		return ret
	}

	def domain(List<Intent> intents, List<Parameter> parameters, List<Action> actions, Language lan) '''
		intents:
		  «FOR intent : intents»
		  	- «intent.name.getRasaValue»
		  «ENDFOR»
		
		entities:
		  «FOR parameter : parameters»
		  	- «parameter.name.getRasaValue»
		  «ENDFOR»
		
		slots:
		  «FOR parameter : parameters»
		  	«parameter.name.getRasaValue»:
		  	  type: unfeaturized
		  	  auto_fill: false
		  «ENDFOR»
		
		templates:
		  «FOR parameter : parameters»
		  	«IF parameter.isRequired && !parameter.prompts.isEmpty»
		  		utter_ask_«parameter.name.getRasaValue»:
		  		«FOR prompt:parameter.prompts»
		  			«IF prompt.language.equals(lan)»
		  				«FOR text : prompt.prompts»	
		  					- text: "«text»"
		  				«ENDFOR»
		  			«ENDIF»
		  		«ENDFOR»
		  		utter_wrong_«parameter.name.getRasaValue»:
		  		- text: "I can not understand the «parameter.name», please try again"
		  	«ENDIF»
		  «ENDFOR»
		  «FOR action : actions»
		  	«IF action instanceof Text»
		  		«action.actionName»:
		  		«FOR textLanguageInput: action.inputs»
		  			«IF textLanguageInput.language.equals(lan)»
		  				«FOR input : textLanguageInput.inputs»	
		  					- text: "«input.textActionInput»"
		  				«ENDFOR»
		  			«ENDIF»
		  		«ENDFOR»
		  	«ELSEIF action instanceof Image»
		  		«action.actionName»:
		  		- text: «IF (action as Image).caption !== null»"«(action as Image).caption»"«ELSE»""«ENDIF»
		  		  image: "«(action as Image).URL»"
		  	«ENDIF»
		  «ENDFOR»
		
		actions:
		
		  «FOR action : actions»
		  	- «action.actionName»
		  «ENDFOR»
		  «FOR intent : intents»
		  	«IF !intent.parameters.empty»
		  		- «intent.name.getRasaValue»_clean
		  	«ENDIF»
		  «ENDFOR»
		
		forms:
		  «FOR intent : intents»
		  	«IF !intent.parameters.empty»
		  		- «intent.name.getRasaValue»_form
		  	«ENDIF»
		  «ENDFOR»
	'''

	def textActionInput(TextInput input) {
		var ret = ""
		for (token : input.tokens) {
			if (token instanceof Literal) {
				ret += token.text + " "
			} else if (token instanceof ParameterToken) {
				ret += "{" + token.parameter.name.getRasaValue + "}" + " "
			}
		}
		return ret;
	}

	def paramType(Parameter parameter) {
		if (parameter.isList) {
			return "list"
		}
		if (parameter.entity !== null) {
			return "text"
		} else {
			switch (parameter.defaultEntity) {
				case (DefaultEntity.TEXT):
					return "text"
				case (DefaultEntity.DATE):
					return "text"
				case (DefaultEntity.TIME):
					return "text"
				case (DefaultEntity.NUMBER):
					return "float"
				case (DefaultEntity.FLOAT):
					return "float"
			}
		}
	}

	def nlu(List<Intent> intents, Language lan) '''
		«FOR intent : intents»
			## intent:«intent.name.getRasaValue»
			«FOR intentLanguageInput: intent.inputs»
				«IF intentLanguageInput.language.equals(lan)»
					«FOR input : intentLanguageInput.inputs»
						- «input.generate()»
					«ENDFOR»
				«ENDIF»
			«ENDFOR»
			
		«ENDFOR»
	'''

	def generate(TrainingPhrase phrase) {
		var ret = ""
		for (token : phrase.tokens) {
			if (token instanceof Literal) {
				ret += token.text + " "
			} else if (token instanceof ParameterReferenceToken) {
				ret += '[' + token.textReference + ']' + '(' + token.parameter.name + ')' + " "
			}
		}
		return ret;
	}

	def getRasaValue(String name) {
		return name.replaceAll(" ", "_")
	}

	def endpoint() '''
		# This file contains the different endpoints your bot can use.
		
		# Server where the models are pulled from.
		# https://rasa.com/docs/rasa/user-guide/running-the-server/#fetching-models-from-a-server/
		
		#models:
		#  url: http://my-server.com/models/default_core@latest
		#  wait_time_between_pulls:  10   # [optional](default: 100)
		
		# Server which runs your custom actions.
		# https://rasa.com/docs/rasa/core/actions/#custom-actions/
		
		#action_endpoint:
		#  url: "http://localhost:5055/webhook"
		
		# Tracker store which is used to store the conversations.
		# By default the conversations are stored in memory.
		# https://rasa.com/docs/rasa/api/tracker-stores/
		
		#tracker_store:
		#    type: redis
		#    url: <host of the redis instance, e.g. localhost>
		#    port: <port of your redis instance, usually 6379>
		#    db: <number of your database within redis, e.g. 0>
		#    password: <password used for authentication>
		#    use_ssl: <whether or not the communication is encrypted, default false>
		
		#tracker_store:
		#    type: mongod
		#    url: <url to your mongo instance, e.g. mongodb://localhost:27017>
		#    db: <name of the db within your mongo instance, e.g. rasa>
		#    username: <username used for authentication>
		#    password: <password used for authentication>
		
		# Event broker which all conversation events should be streamed to.
		# https://rasa.com/docs/rasa/api/event-brokers/
		
		#event_broker:
		#  url: localhost
		#  username: username
		#  password: password
		#  queue: queue
		action_endpoint:
		    url: http://localhost:5055/webhook
	'''

	def config(Language lan) '''
		# Configuration for Rasa NLU.
		# https://rasa.com/docs/rasa/nlu/components/
		language: «lan.languageAbbreviation»
		pipeline: supervised_embeddings
		
		# Configuration for Rasa Core.
		# https://rasa.com/docs/rasa/core/policies/
		policies:
		  - name: MemoizationPolicy
		  - name: KerasPolicy
		  - name: MappingPolicy
		  - name: "FormPolicy"
	'''

	def languageAbbreviation(Language lan) {
		switch (lan) {
			case Language.ENGLISH:
				return 'en'
			case Language.SPANISH:
				return 'es'
			case Language.DANISH:
				return 'da'
			case Language.GERMAN:
				return 'de'
			case Language.FRENCH:
				return 'fr'
			case Language.HINDI:
				return 'hi'
			case Language.INDONESIAN:
				return 'id'
			case Language.ITALIAN:
				return 'it'
			case Language.JAPANESE:
				return 'ja'
			case Language.KOREAN:
				return 'ko'
			case Language.DUTCH:
				return 'nl'
			case Language.NORWEGIAN:
				return 'no'
			case Language.POLISH:
				return 'pl'
			case Language.PORTUGUESE:
				return 'pt'
			case Language.RUSIAN:
				return 'ru'
			case Language.SWEDISH:
				return 'sv'
			case Language.THAI:
				return 'th'
			case Language.TURKISH:
				return 'tr'
			case Language.UKRANIAN:
				return 'uk'
			case Language.CHINESE:
				return 'zh'
			// FALTAN LENGUAJES!!!!!!!!!!!!!!!!!!!!!!!!!
			default:
				return 'en'
		}
	}

	def credentials() '''
		# This file contains the credentials for the voice & chat platforms
		# which your bot is using.
		# https://rasa.com/docs/rasa/user-guide/messaging-and-voice-channels/
		
		rest:
		#  # you don't need to provide anything here - this channel doesn't
		#  # require any credentials
		
		
		#facebook:
		#  verify: "<verify>"
		#  secret: "<your secret>"
		#  page-access-token: "<your page access token>"
		
		#slack:
		#  slack_token: "<your slack token>"
		#  slack_channel: "<the slack channel>"
		
		#socketio:
		#  user_message_evt: <event name for user message>
		#  bot_message_evt: <event name for but messages>
		#  session_persistence: <true/false>
		
		#mattermost:
		#  url: "https://<mattermost instance>/api/v4"
		#  team: "<mattermost team>"
		#  user: "<bot username>"
		#  pw: "<bot token>"
		#  webhook_url: "<callback URL>"
		
		rasa:
		  url: "http://localhost:5002/api"
	'''
}
