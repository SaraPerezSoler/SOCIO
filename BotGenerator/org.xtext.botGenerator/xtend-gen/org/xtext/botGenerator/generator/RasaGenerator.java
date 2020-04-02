package org.xtext.botGenerator.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.Composite;
import generator.DataType;
import generator.DefaultEntity;
import generator.Entity;
import generator.HTTPRequest;
import generator.HTTPRequestToke;
import generator.HTTPResponse;
import generator.HTTPReturnType;
import generator.Image;
import generator.Intent;
import generator.IntentLanguageInputs;
import generator.Interaction;
import generator.KeyValue;
import generator.Language;
import generator.Literal;
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
import generator.Token;
import generator.TrainingPhrase;
import generator.UserInteraction;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.botGenerator.generator.DialogflowGenerator;

@SuppressWarnings("all")
public class RasaGenerator {
  private String path;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Bot bot = IteratorExtensions.<Bot>toList(Iterators.<Bot>filter(resource.getAllContents(), Bot.class)).get(0);
    List<Intent> intents = IteratorExtensions.<Intent>toList(Iterators.<Intent>filter(resource.getAllContents(), Intent.class));
    List<Entity> entities = IteratorExtensions.<Entity>toList(Iterators.<Entity>filter(resource.getAllContents(), Entity.class));
    List<Parameter> parameters = IteratorExtensions.<Parameter>toList(Iterators.<Parameter>filter(resource.getAllContents(), Parameter.class));
    List<Action> actions = IteratorExtensions.<Action>toList(Iterators.<Action>filter(resource.getAllContents(), Action.class));
    ArrayList<Interaction> leafs = new ArrayList<Interaction>();
    EList<UserInteraction> _flows = bot.getFlows();
    for (final UserInteraction flow : _flows) {
      this.leafsU(flow, leafs);
    }
    EList<Language> _languages = bot.getLanguages();
    for (final Language lan : _languages) {
      {
        String _name = bot.getName();
        String _plus = (_name + "Rasa");
        String _plus_1 = (_plus + "_");
        String _languageAbbreviation = this.languageAbbreviation(lan);
        String _plus_2 = (_plus_1 + _languageAbbreviation);
        this.path = _plus_2;
        fsa.generateFile((this.path + "/actions.py"), this.actions(intents, entities, actions, lan));
        fsa.generateFile((this.path + "/config.yml"), this.config(lan));
        fsa.generateFile((this.path + "/credentials.yml"), this.credentials());
        fsa.generateFile((this.path + "/domain.yml"), this.domain(intents, parameters, actions, lan));
        fsa.generateFile((this.path + "/endpoints.yml"), this.endpoint());
        fsa.generateFile((this.path + "/data/nlu.md"), this.nlu(intents, lan));
        fsa.generateFile((this.path + "/data/stories.md"), this.stories(leafs));
      }
    }
  }
  
  public String actionName(final Action action) {
    if (((action instanceof Text) || (action instanceof Image))) {
      String _rasaValue = this.getRasaValue(action.getName());
      return ("utter_" + _rasaValue);
    }
    String _rasaValue_1 = this.getRasaValue(action.getName());
    return ("action_" + _rasaValue_1);
  }
  
  public void leafsU(final UserInteraction flow, final List<Interaction> leafs) {
    BotInteraction _target = flow.getTarget();
    boolean _tripleEquals = (_target == null);
    if (_tripleEquals) {
      leafs.add(flow);
    } else {
      this.leafsB(flow.getTarget(), leafs);
    }
  }
  
  public void leafsB(final BotInteraction flow, final List<Interaction> leafs) {
    boolean _isEmpty = flow.getOutcoming().isEmpty();
    if (_isEmpty) {
      leafs.add(flow);
    } else {
      EList<UserInteraction> _outcoming = flow.getOutcoming();
      for (final UserInteraction user : _outcoming) {
        this.leafsU(user, leafs);
      }
    }
  }
  
  public String stories(final List<Interaction> leafs) {
    String ret = "";
    for (int i = 0; (i < leafs.size()); i++) {
      {
        ArrayList<Intent> clean = new ArrayList<Intent>();
        Interaction leaf = leafs.get(i);
        String _ret = ret;
        CharSequence _path = this.path(leaf, i, clean);
        String _plus = (_path + "\n");
        ret = (_ret + _plus);
      }
    }
    return ret;
  }
  
  public CharSequence path(final Interaction flow, final int i, final List<Intent> clean) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("## path_");
    _builder.append(i);
    _builder.newLineIfNotEmpty();
    {
      if ((flow instanceof UserInteraction)) {
        String _flow = this.flow(((UserInteraction) flow), clean);
        _builder.append(_flow);
        _builder.newLineIfNotEmpty();
      } else {
        if ((flow instanceof BotInteraction)) {
          String _flow_1 = this.flow(((BotInteraction) flow), clean);
          _builder.append(_flow_1);
          _builder.newLineIfNotEmpty();
        }
      }
    }
    {
      for(final Intent intent : clean) {
        _builder.append("\t");
        _builder.append("- ");
        String _rasaValue = this.getRasaValue(intent.getName());
        _builder.append(_rasaValue);
        _builder.append("_clean");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String flow(final UserInteraction user, final List<Intent> clean) {
    StringConcatenation _builder = new StringConcatenation();
    {
      BotInteraction _src = user.getSrc();
      boolean _tripleNotEquals = (_src != null);
      if (_tripleNotEquals) {
        String _flow = this.flow(user.getSrc(), clean);
        _builder.append(_flow);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("* ");
    String _rasaValue = this.getRasaValue(user.getIntent().getName());
    _builder.append(_rasaValue);
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = user.getIntent().getParameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("\t");
        _builder.append("- ");
        String _xblockexpression = null;
        {
          clean.add(user.getIntent());
          _xblockexpression = this.getRasaValue(user.getIntent().getName());
        }
        _builder.append(_xblockexpression);
        _builder.append("_form");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("- form{\"name\": \"");
        String _rasaValue_1 = this.getRasaValue(user.getIntent().getName());
        _builder.append(_rasaValue_1);
        _builder.append("_form\"}");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("- form{\"name\": null}");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String flow(final BotInteraction bot, final List<Intent> clean) {
    StringConcatenation _builder = new StringConcatenation();
    {
      UserInteraction _incoming = bot.getIncoming();
      boolean _tripleNotEquals = (_incoming != null);
      if (_tripleNotEquals) {
        String _flow = this.flow(bot.getIncoming(), clean);
        _builder.append(_flow);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Action> _actions = bot.getActions();
      for(final Action action : _actions) {
        _builder.append("\t");
        _builder.append("- ");
        String _actionName = this.actionName(action);
        _builder.append(_actionName);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public CharSequence actions(final List<Intent> intents, final List<Entity> entities, final List<Action> actions, final Language lan) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# This files contains your custom actions which can be used to run");
    _builder.newLine();
    _builder.append("# custom Python code.");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("# See this guide on how to implement these action:");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/core/actions/#custom-actions/");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("# This is a simple example for a custom action which utters \"Hello World!\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# from typing import Any, Text, Dict, List");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("# from rasa_sdk import Action, Tracker");
    _builder.newLine();
    _builder.append("# from rasa_sdk.executor import CollectingDispatcher");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("# class ActionHelloWorld(Action):");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("#     def name(self) -> Text:");
    _builder.newLine();
    _builder.append("#         return \"action_hello_world\"");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("#     def run(self, dispatcher: CollectingDispatcher,");
    _builder.newLine();
    _builder.append("#             tracker: Tracker,");
    _builder.newLine();
    _builder.append("#             domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("#         dispatcher.utter_message(\"Hello World!\")");
    _builder.newLine();
    _builder.append("#");
    _builder.newLine();
    _builder.append("#         return []");
    _builder.newLine();
    _builder.append("from typing import Dict, Text, Any, List, Union, Optional");
    _builder.newLine();
    _builder.newLine();
    _builder.append("from rasa_sdk import ActionExecutionRejection");
    _builder.newLine();
    _builder.append("from rasa_sdk import Action");
    _builder.newLine();
    _builder.append("from rasa_sdk import Tracker");
    _builder.newLine();
    _builder.append("from rasa_sdk.events import SlotSet");
    _builder.newLine();
    _builder.append("from rasa_sdk.executor import CollectingDispatcher");
    _builder.newLine();
    _builder.append("from rasa_sdk.forms import FormAction, REQUESTED_SLOT");
    _builder.newLine();
    _builder.append("from duckling import DucklingWrapper, Dim, Language");
    _builder.newLine();
    _builder.append("import time");
    _builder.newLine();
    _builder.append("import requests");
    _builder.newLine();
    _builder.newLine();
    _builder.append("d = DucklingWrapper()");
    _builder.newLine();
    _builder.append("def time_validate(value:Text):");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("parses = d.parse_time(value)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for parse in parses:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if parse [\'dim\'] == \'time\':");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if parse[\'value\'].get(\'grain\') == \'minute\' or parse[\'value\'].get(\'grain\') == \'hour\': ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return parse [\'value\'][\'value\']");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return None");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("def date_validate(value:Text):");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("parses = d.parse_time(value)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for parse in parses:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if parse [\'dim\'] == \'time\':");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if parse[\'value\'].get(\'grain\') == \'day\' or parse[\'value\'].get(\'grain\') == \'month\' or parse[\'value\'].get(\'grain\') == \'year\': ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return parse [\'value\'][\'value\']");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return None");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      for(final Entity entity : entities) {
        {
          if ((entity instanceof Simple)) {
            {
              EList<SimpleLanguageInput> _inputs = ((Simple)entity).getInputs();
              for(final SimpleLanguageInput simpleLanguage : _inputs) {
                {
                  boolean _equals = simpleLanguage.getLanguage().equals(lan);
                  if (_equals) {
                    String _rasaValue = this.getRasaValue(((Simple)entity).getName());
                    _builder.append(_rasaValue);
                    _builder.append("_db={");
                    _builder.newLineIfNotEmpty();
                    {
                      EList<SimpleInput> _inputs_1 = simpleLanguage.getInputs();
                      for(final SimpleInput input : _inputs_1) {
                        _builder.append("\t");
                        _builder.append("\"");
                        String _lowerCase = input.getName().toLowerCase();
                        _builder.append(_lowerCase, "\t");
                        _builder.append("\":[\"");
                        String _lowerCase_1 = input.getName().toLowerCase();
                        _builder.append(_lowerCase_1, "\t");
                        _builder.append("\"");
                        {
                          EList<String> _values = input.getValues();
                          for(final String value : _values) {
                            _builder.append(",\"");
                            String _lowerCase_2 = value.toLowerCase();
                            _builder.append(_lowerCase_2, "\t");
                            _builder.append("\"");
                          }
                        }
                        _builder.append("]");
                        {
                          boolean _isTheLast = DialogflowGenerator.isTheLast(((Simple)entity).getInputs(), input);
                          boolean _not = (!_isTheLast);
                          if (_not) {
                            _builder.append(",");
                          }
                        }
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("}");
                    _builder.newLine();
                    _builder.newLine();
                    _builder.append("def ");
                    String _rasaValue_1 = this.getRasaValue(((Simple)entity).getName());
                    _builder.append(_rasaValue_1);
                    _builder.append("_validate(value:Text):");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("for input in ");
                    String _rasaValue_2 = this.getRasaValue(((Simple)entity).getName());
                    _builder.append(_rasaValue_2, "\t");
                    _builder.append("_db:");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("if value.lower() in ");
                    String _rasaValue_3 = this.getRasaValue(((Simple)entity).getName());
                    _builder.append(_rasaValue_3, "\t\t");
                    _builder.append("_db[input]:");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t");
                    _builder.append("return input");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("return None");
                    _builder.newLine();
                  }
                }
              }
            }
          } else {
            if ((entity instanceof Composite)) {
              _builder.append("def ");
              String _rasaValue_4 = this.getRasaValue(((Composite)entity).getName());
              _builder.append(_rasaValue_4);
              _builder.append("_validate(value:Text):");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("return None");
              _builder.newLine();
              _builder.append("\t");
              _builder.newLine();
            }
          }
        }
      }
    }
    {
      for(final Intent intent : intents) {
        {
          boolean _isEmpty = intent.getParameters().isEmpty();
          boolean _not_1 = (!_isEmpty);
          if (_not_1) {
            _builder.append("\t");
            _builder.append("class ");
            String _rasaValue_5 = this.getRasaValue(intent.getName());
            _builder.append(_rasaValue_5, "\t");
            _builder.append("Form (FormAction):");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("def name(self):");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("# type: () -> Text");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\"\"\"Unique identifier of the form\"\"\"");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("return \"");
            String _rasaValue_6 = this.getRasaValue(intent.getName());
            _builder.append(_rasaValue_6, "\t\t\t");
            _builder.append("_form\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("@staticmethod");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("def required_slots(tracker: Tracker) -> List[Text]:");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("\"\"\"A list of required slots that the form has to fill\"\"\"");
            _builder.newLine();
            _builder.append("\t\t\t");
            String coma = "";
            _builder.newLineIfNotEmpty();
            _builder.append("return [");
            {
              EList<Parameter> _parameters = intent.getParameters();
              for(final Parameter param : _parameters) {
                {
                  boolean _isRequired = param.isRequired();
                  if (_isRequired) {
                    _builder.append(coma);
                    _builder.append("\"");
                    String _xblockexpression = null;
                    {
                      coma = ",";
                      _xblockexpression = this.getRasaValue(param.getName());
                    }
                    _builder.append(_xblockexpression);
                    _builder.append("\"");
                  }
                }
              }
            }
            _builder.append("]");
            _builder.newLineIfNotEmpty();
            {
              EList<Parameter> _parameters_1 = intent.getParameters();
              for(final Parameter param_1 : _parameters_1) {
                _builder.newLine();
                _builder.append("def validate_");
                String _rasaValue_7 = this.getRasaValue(param_1.getName());
                _builder.append(_rasaValue_7);
                _builder.append("(self, value: Text,dispatcher: CollectingDispatcher,tracker: Tracker,domain: Dict[Text, Any]) -> Dict[Text, Any]:");
                _builder.newLineIfNotEmpty();
                {
                  Entity _entity = param_1.getEntity();
                  boolean _tripleNotEquals = (_entity != null);
                  if (_tripleNotEquals) {
                    _builder.append("\t");
                    _builder.append("parseValue = ");
                    String _rasaValue_8 = this.getRasaValue(param_1.getEntity().getName());
                    _builder.append(_rasaValue_8, "\t");
                    _builder.append("_validate(value)");
                    _builder.newLineIfNotEmpty();
                  } else {
                    DefaultEntity _defaultEntity = param_1.getDefaultEntity();
                    boolean _tripleEquals = (_defaultEntity == DefaultEntity.DATE);
                    if (_tripleEquals) {
                      _builder.append("\t");
                      _builder.append("parseValue = date_validate(value)");
                      _builder.newLine();
                    } else {
                      DefaultEntity _defaultEntity_1 = param_1.getDefaultEntity();
                      boolean _tripleEquals_1 = (_defaultEntity_1 == DefaultEntity.TIME);
                      if (_tripleEquals_1) {
                        _builder.append("\t");
                        _builder.append("parseValue = time_validate(value)");
                        _builder.newLine();
                      } else {
                        DefaultEntity _defaultEntity_2 = param_1.getDefaultEntity();
                        boolean _tripleEquals_2 = (_defaultEntity_2 == DefaultEntity.TEXT);
                        if (_tripleEquals_2) {
                          _builder.append("\t");
                          _builder.append("parseValue = value");
                          _builder.newLine();
                        } else {
                          DefaultEntity _defaultEntity_3 = param_1.getDefaultEntity();
                          boolean _tripleEquals_3 = (_defaultEntity_3 == DefaultEntity.FLOAT);
                          if (_tripleEquals_3) {
                            _builder.append("\t");
                            _builder.append("try:");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("parseValue = float (value)");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("except ValueError:");
                            _builder.newLine();
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("parseValue = None");
                            _builder.newLine();
                          } else {
                            DefaultEntity _defaultEntity_4 = param_1.getDefaultEntity();
                            boolean _tripleEquals_4 = (_defaultEntity_4 == DefaultEntity.NUMBER);
                            if (_tripleEquals_4) {
                              _builder.append("\t");
                              _builder.append("try:");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("parseValue = int (value)");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("except ValueError:");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("parseValue = None");
                              _builder.newLine();
                            }
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("\t");
                _builder.append("if parseValue is None:");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("dispatcher.utter_template(\'utter_wrong_");
                String _rasaValue_9 = this.getRasaValue(param_1.getName());
                _builder.append(_rasaValue_9, "\t\t");
                _builder.append("\', tracker)");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("return {\'");
                String _rasaValue_10 = this.getRasaValue(param_1.getName());
                _builder.append(_rasaValue_10, "\t\t");
                _builder.append("\': None}");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("return {\'");
                String _rasaValue_11 = this.getRasaValue(param_1.getName());
                _builder.append(_rasaValue_11, "\t");
                _builder.append("\': parseValue}");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.newLine();
            _builder.append("def slot_mappings(self):");
            _builder.newLine();
            _builder.newLine();
            _builder.append("        ");
            _builder.append("return {");
            _builder.newLine();
            {
              EList<Parameter> _parameters_2 = intent.getParameters();
              for(final Parameter param_2 : _parameters_2) {
                _builder.append("        \t");
                _builder.append("\"");
                String _rasaValue_12 = this.getRasaValue(param_2.getName());
                _builder.append(_rasaValue_12, "        \t");
                _builder.append("\": [self.from_entity(entity=\"");
                String _rasaValue_13 = this.getRasaValue(param_2.getName());
                _builder.append(_rasaValue_13, "        \t");
                _builder.append("\"),self.from_");
                String _paramType = this.paramType(param_2);
                _builder.append(_paramType, "        \t");
                _builder.append("()],");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("        \t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("def submit(");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("self,");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("dispatcher: CollectingDispatcher,");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("tracker: Tracker,");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("domain: Dict[Text, Any],");
            _builder.newLine();
            _builder.append(") -> List[Dict]:");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("\"\"\"Define what the form has to do");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("after all required slots are filled\"\"\"");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("return []");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("class ");
            String _rasaValue_14 = this.getRasaValue(intent.getName());
            _builder.append(_rasaValue_14, "\t\t");
            _builder.append("Clean (Action):");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("def name(self) -> Text:");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("return \"");
            String _rasaValue_15 = this.getRasaValue(intent.getName());
            _builder.append(_rasaValue_15, "\t\t\t\t");
            _builder.append("_clean\"");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("def run(self, dispatcher: CollectingDispatcher,");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("tracker: Tracker,");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:");
            _builder.newLine();
            _builder.append("return [");
            {
              EList<Parameter> _parameters_3 = intent.getParameters();
              for(final Parameter param_3 : _parameters_3) {
                _builder.append("SlotSet(\"");
                String _rasaValue_16 = this.getRasaValue(param_3.getName());
                _builder.append(_rasaValue_16);
                _builder.append("\", None) ");
                {
                  boolean _isTheLast_1 = DialogflowGenerator.isTheLast(intent.getParameters(), param_3);
                  boolean _not_2 = (!_isTheLast_1);
                  if (_not_2) {
                    _builder.append(",");
                  }
                }
              }
            }
            _builder.append("]            ");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Action action : actions) {
        {
          if ((action instanceof HTTPRequest)) {
            _builder.append("class ");
            String _rasaValue_17 = this.getRasaValue(((HTTPRequest)action).getName());
            _builder.append(_rasaValue_17);
            _builder.append(" (Action):");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("response = None");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("def name(self) -> Text:");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("return \"");
            String _actionName = this.actionName(action);
            _builder.append(_actionName, "\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("def run(self, dispatcher: CollectingDispatcher,");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("tracker: Tracker,");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("url = \'");
            String _uRL = ((HTTPRequest)action).getURL();
            _builder.append(_uRL, "\t\t");
            _builder.append("\'");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            String args = "";
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.newLine();
            {
              KeyValue _basicAuth = ((HTTPRequest)action).getBasicAuth();
              boolean _tripleNotEquals_1 = (_basicAuth != null);
              if (_tripleNotEquals_1) {
                _builder.append("\t\t");
                _builder.append("auth={\'");
                String _key = ((HTTPRequest)action).getBasicAuth().getKey();
                _builder.append(_key, "\t\t");
                _builder.append("\', \'");
                Token _value = ((HTTPRequest)action).getBasicAuth().getValue();
                _builder.append(_value, "\t\t");
                _builder.append("\'}");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                String _xblockexpression_1 = null;
                {
                  String _args = args;
                  args = (_args + ", auth=auth");
                  _xblockexpression_1 = "";
                }
                _builder.append(_xblockexpression_1, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.newLine();
            {
              boolean _isEmpty_1 = ((HTTPRequest)action).getHeaders().isEmpty();
              boolean _not_3 = (!_isEmpty_1);
              if (_not_3) {
                _builder.append("\t\t");
                _builder.append("headers={");
                _builder.newLine();
                {
                  EList<KeyValue> _headers = ((HTTPRequest)action).getHeaders();
                  for(final KeyValue header : _headers) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("\'");
                    String _key_1 = header.getKey();
                    _builder.append(_key_1, "\t\t\t");
                    _builder.append("\':\'");
                    Token _value_1 = header.getValue();
                    _builder.append(_value_1, "\t\t\t");
                    _builder.append("\'");
                    {
                      boolean _isTheLast_2 = DialogflowGenerator.isTheLast(((HTTPRequest)action).getHeaders(), header);
                      boolean _not_4 = (!_isTheLast_2);
                      if (_not_4) {
                        _builder.append(", ");
                      }
                    }
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                String _xblockexpression_2 = null;
                {
                  String _args = args;
                  args = (_args + ", headers=headers");
                  _xblockexpression_2 = "";
                }
                _builder.append(_xblockexpression_2, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.newLine();
            {
              boolean _isEmpty_2 = ((HTTPRequest)action).getData().isEmpty();
              boolean _not_5 = (!_isEmpty_2);
              if (_not_5) {
                _builder.append("\t\t");
                _builder.append("data = {");
                _builder.newLine();
                {
                  EList<KeyValue> _data = ((HTTPRequest)action).getData();
                  for(final KeyValue d : _data) {
                    {
                      Token _value_2 = d.getValue();
                      if ((_value_2 instanceof ParameterToken)) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\'");
                        String _key_2 = d.getKey();
                        _builder.append(_key_2, "\t\t\t");
                        _builder.append("\': tracker.get_slot(\"");
                        Token _value_3 = d.getValue();
                        String _rasaValue_18 = this.getRasaValue(((ParameterToken) _value_3).getParameter().getName());
                        _builder.append(_rasaValue_18, "\t\t\t");
                        _builder.append("\")");
                        {
                          boolean _isTheLast_3 = DialogflowGenerator.isTheLast(((HTTPRequest)action).getData(), d);
                          boolean _not_6 = (!_isTheLast_3);
                          if (_not_6) {
                            _builder.append(", ");
                          }
                        }
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\'");
                        String _key_3 = d.getKey();
                        _builder.append(_key_3, "\t\t\t");
                        _builder.append("\':\'");
                        Token _value_4 = d.getValue();
                        _builder.append(_value_4, "\t\t\t");
                        _builder.append("\'");
                        {
                          boolean _isTheLast_4 = DialogflowGenerator.isTheLast(((HTTPRequest)action).getData(), d);
                          boolean _not_7 = (!_isTheLast_4);
                          if (_not_7) {
                            _builder.append(", ");
                          }
                        }
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t\t");
                {
                  DataType _dataType = ((HTTPRequest)action).getDataType();
                  boolean _tripleEquals_5 = (_dataType == DataType.FORM);
                  if (_tripleEquals_5) {
                    String _xblockexpression_3 = null;
                    {
                      String _args = args;
                      args = (_args + ",data=data");
                      _xblockexpression_3 = "";
                    }
                    _builder.append(_xblockexpression_3, "\t\t");
                  } else {
                    String _xblockexpression_4 = null;
                    {
                      String _args = args;
                      args = (_args + ",json=data");
                      _xblockexpression_4 = "";
                    }
                    _builder.append(_xblockexpression_4, "\t\t");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            String _rasaValue_19 = this.getRasaValue(((HTTPRequest)action).getName());
            _builder.append(_rasaValue_19, "\t\t");
            _builder.append(".response = requests.");
            String _lowerCase_3 = ((HTTPRequest)action).getMethod().getName().toLowerCase();
            _builder.append(_lowerCase_3, "\t\t");
            _builder.append("(url ");
            _builder.append(args, "\t\t");
            _builder.append(") ");
            _builder.newLineIfNotEmpty();
          } else {
            if ((action instanceof HTTPResponse)) {
              _builder.append("class ");
              String _rasaValue_20 = this.getRasaValue(((HTTPResponse)action).getName());
              _builder.append(_rasaValue_20);
              _builder.append(" (Action):");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("def name(self) -> Text:");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return \"");
              String _actionName_1 = this.actionName(action);
              _builder.append(_actionName_1, "\t\t");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("def run(self, dispatcher: CollectingDispatcher,");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("tracker: Tracker,");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("response = ");
              String _rasaValue_21 = this.getRasaValue(((HTTPResponse) action).getHTTPRequest().getName());
              _builder.append(_rasaValue_21, "\t\t");
              _builder.append(".response\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("text = ");
              String _httpResponseText = this.getHttpResponseText(((HTTPResponse) action), lan);
              _builder.append(_httpResponseText, "\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("dispatcher.utter_message(text)");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return []         ");
              _builder.newLine();
              _builder.newLine();
            }
          }
        }
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public String getHttpResponseText(final HTTPResponse action, final Language lan) {
    String ret = "";
    EList<TextLanguageInput> _inputs = action.getInputs();
    for (final TextLanguageInput textLanguage : _inputs) {
      boolean _equals = textLanguage.getLanguage().equals(lan);
      if (_equals) {
        EList<Token> _tokens = textLanguage.getInputs().get(0).getTokens();
        for (final Token token : _tokens) {
          {
            if ((token instanceof Literal)) {
              String _ret = ret;
              String _text = ((Literal)token).getText();
              String _plus = ("\'" + _text);
              String _plus_1 = (_plus + "\'");
              ret = (_ret + _plus_1);
            } else {
              if ((token instanceof ParameterToken)) {
                String _ret_1 = ret;
                String _rasaValue = this.getRasaValue(((ParameterToken)token).getParameter().getName());
                String _plus_2 = ("tracker.get_slot(\"" + _rasaValue);
                String _plus_3 = (_plus_2 + "\")");
                ret = (_ret_1 + _plus_3);
              } else {
                if ((token instanceof HTTPRequestToke)) {
                  HTTPReturnType _type = ((HTTPRequestToke)token).getType();
                  boolean _equals_1 = Objects.equal(_type, HTTPReturnType.TEXT);
                  if (_equals_1) {
                    String _ret_2 = ret;
                    ret = (_ret_2 + "response.text");
                  } else {
                    HTTPReturnType _type_1 = ((HTTPRequestToke)token).getType();
                    boolean _equals_2 = Objects.equal(_type_1, HTTPReturnType.STATUS_CODE);
                    if (_equals_2) {
                      String _ret_3 = ret;
                      ret = (_ret_3 + "response.status_code");
                    } else {
                      HTTPReturnType _type_2 = ((HTTPRequestToke)token).getType();
                      boolean _equals_3 = Objects.equal(_type_2, HTTPReturnType.DATA);
                      if (_equals_3) {
                        boolean _isEmpty = ((HTTPRequestToke)token).getDataKey().isEmpty();
                        boolean _not = (!_isEmpty);
                        if (_not) {
                          String _ret_4 = ret;
                          String _dataKey = ((HTTPRequestToke)token).getDataKey();
                          String _plus_4 = ("response.json()[\'" + _dataKey);
                          String _plus_5 = (_plus_4 + "\']");
                          ret = (_ret_4 + _plus_5);
                        } else {
                          String _ret_5 = ret;
                          ret = (_ret_5 + "response.json()");
                        }
                      }
                    }
                  }
                }
              }
            }
            boolean _isTheLast = DialogflowGenerator.isTheLast(textLanguage.getInputs().get(0).getTokens(), token);
            boolean _not_1 = (!_isTheLast);
            if (_not_1) {
              String _ret_6 = ret;
              ret = (_ret_6 + "+");
            }
          }
        }
      }
    }
    return ret;
  }
  
  public CharSequence domain(final List<Intent> intents, final List<Parameter> parameters, final List<Action> actions, final Language lan) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("intents:");
    _builder.newLine();
    {
      for(final Intent intent : intents) {
        _builder.append("  ");
        _builder.append("- ");
        String _rasaValue = this.getRasaValue(intent.getName());
        _builder.append(_rasaValue, "  ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("entities:");
    _builder.newLine();
    {
      for(final Parameter parameter : parameters) {
        _builder.append("  ");
        _builder.append("- ");
        String _rasaValue_1 = this.getRasaValue(parameter.getName());
        _builder.append(_rasaValue_1, "  ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("slots:");
    _builder.newLine();
    {
      for(final Parameter parameter_1 : parameters) {
        _builder.append("  ");
        String _rasaValue_2 = this.getRasaValue(parameter_1.getName());
        _builder.append(_rasaValue_2, "  ");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("type: unfeaturized");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("auto_fill: false");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("templates:");
    _builder.newLine();
    {
      for(final Parameter parameter_2 : parameters) {
        {
          if ((parameter_2.isRequired() && (!parameter_2.getPrompts().isEmpty()))) {
            _builder.append("  ");
            _builder.append("utter_ask_");
            String _rasaValue_3 = this.getRasaValue(parameter_2.getName());
            _builder.append(_rasaValue_3, "  ");
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            {
              EList<PromptLanguage> _prompts = parameter_2.getPrompts();
              for(final PromptLanguage prompt : _prompts) {
                {
                  boolean _equals = prompt.getLanguage().equals(lan);
                  if (_equals) {
                    {
                      EList<String> _prompts_1 = prompt.getPrompts();
                      for(final String text : _prompts_1) {
                        _builder.append("  ");
                        _builder.append("- text: \"");
                        _builder.append(text, "  ");
                        _builder.append("\"");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
            _builder.append("  ");
            _builder.append("utter_wrong_");
            String _rasaValue_4 = this.getRasaValue(parameter_2.getName());
            _builder.append(_rasaValue_4, "  ");
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("- text: \"I can not understand the ");
            String _name = parameter_2.getName();
            _builder.append(_name, "  ");
            _builder.append(", please try again\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Action action : actions) {
        {
          if ((action instanceof Text)) {
            _builder.append("  ");
            String _actionName = this.actionName(action);
            _builder.append(_actionName, "  ");
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            {
              EList<TextLanguageInput> _inputs = ((Text)action).getInputs();
              for(final TextLanguageInput textLanguageInput : _inputs) {
                {
                  boolean _equals_1 = textLanguageInput.getLanguage().equals(lan);
                  if (_equals_1) {
                    {
                      EList<TextInput> _inputs_1 = textLanguageInput.getInputs();
                      for(final TextInput input : _inputs_1) {
                        _builder.append("  ");
                        _builder.append("- text: \"");
                        String _textActionInput = this.textActionInput(input);
                        _builder.append(_textActionInput, "  ");
                        _builder.append("\"");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          } else {
            if ((action instanceof Image)) {
              _builder.append("  ");
              String _actionName_1 = this.actionName(action);
              _builder.append(_actionName_1, "  ");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("  ");
              _builder.append("- text: ");
              {
                String _caption = ((Image) action).getCaption();
                boolean _tripleNotEquals = (_caption != null);
                if (_tripleNotEquals) {
                  _builder.append("\"");
                  String _caption_1 = ((Image) action).getCaption();
                  _builder.append(_caption_1, "  ");
                  _builder.append("\"");
                } else {
                  _builder.append("\"\"");
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("  ");
              _builder.append("  ");
              _builder.append("image: \"");
              String _uRL = ((Image) action).getURL();
              _builder.append(_uRL, "    ");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("actions:");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Action action_1 : actions) {
        _builder.append("  ");
        _builder.append("- ");
        String _actionName_2 = this.actionName(action_1);
        _builder.append(_actionName_2, "  ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final Intent intent_1 : intents) {
        {
          boolean _isEmpty = intent_1.getParameters().isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("  ");
            _builder.append("- ");
            String _rasaValue_5 = this.getRasaValue(intent_1.getName());
            _builder.append(_rasaValue_5, "  ");
            _builder.append("_clean");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("forms:");
    _builder.newLine();
    {
      for(final Intent intent_2 : intents) {
        {
          boolean _isEmpty_1 = intent_2.getParameters().isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("  ");
            _builder.append("- ");
            String _rasaValue_6 = this.getRasaValue(intent_2.getName());
            _builder.append(_rasaValue_6, "  ");
            _builder.append("_form");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String textActionInput(final TextInput input) {
    String ret = "";
    EList<Token> _tokens = input.getTokens();
    for (final Token token : _tokens) {
      if ((token instanceof Literal)) {
        String _ret = ret;
        String _text = ((Literal)token).getText();
        String _plus = (_text + " ");
        ret = (_ret + _plus);
      } else {
        if ((token instanceof ParameterToken)) {
          String _ret_1 = ret;
          String _rasaValue = this.getRasaValue(((ParameterToken)token).getParameter().getName());
          String _plus_1 = ("{" + _rasaValue);
          String _plus_2 = (_plus_1 + "}");
          String _plus_3 = (_plus_2 + " ");
          ret = (_ret_1 + _plus_3);
        }
      }
    }
    return ret;
  }
  
  public String paramType(final Parameter parameter) {
    boolean _isIsList = parameter.isIsList();
    if (_isIsList) {
      return "list";
    }
    Entity _entity = parameter.getEntity();
    boolean _tripleNotEquals = (_entity != null);
    if (_tripleNotEquals) {
      return "text";
    } else {
      DefaultEntity _defaultEntity = parameter.getDefaultEntity();
      if (_defaultEntity != null) {
        switch (_defaultEntity) {
          case TEXT:
            return "text";
          case DATE:
            return "text";
          case TIME:
            return "text";
          case NUMBER:
            return "float";
          case FLOAT:
            return "float";
          default:
            break;
        }
      }
    }
    return null;
  }
  
  public CharSequence nlu(final List<Intent> intents, final Language lan) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Intent intent : intents) {
        _builder.append("## intent:");
        String _rasaValue = this.getRasaValue(intent.getName());
        _builder.append(_rasaValue);
        _builder.newLineIfNotEmpty();
        {
          EList<IntentLanguageInputs> _inputs = intent.getInputs();
          for(final IntentLanguageInputs intentLanguageInput : _inputs) {
            {
              boolean _equals = intentLanguageInput.getLanguage().equals(lan);
              if (_equals) {
                {
                  EList<TrainingPhrase> _inputs_1 = intentLanguageInput.getInputs();
                  for(final TrainingPhrase input : _inputs_1) {
                    _builder.append("- ");
                    String _generate = this.generate(input);
                    _builder.append(_generate);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public String generate(final TrainingPhrase phrase) {
    String ret = "";
    EList<Token> _tokens = phrase.getTokens();
    for (final Token token : _tokens) {
      if ((token instanceof Literal)) {
        String _ret = ret;
        String _text = ((Literal)token).getText();
        String _plus = (_text + " ");
        ret = (_ret + _plus);
      } else {
        if ((token instanceof ParameterReferenceToken)) {
          String _ret_1 = ret;
          String _textReference = ((ParameterReferenceToken)token).getTextReference();
          String _plus_1 = ("[" + _textReference);
          String _plus_2 = (_plus_1 + "]");
          String _plus_3 = (_plus_2 + "(");
          String _name = ((ParameterReferenceToken)token).getParameter().getName();
          String _plus_4 = (_plus_3 + _name);
          String _plus_5 = (_plus_4 + ")");
          String _plus_6 = (_plus_5 + " ");
          ret = (_ret_1 + _plus_6);
        }
      }
    }
    return ret;
  }
  
  public String getRasaValue(final String name) {
    return name.replaceAll(" ", "_");
  }
  
  public CharSequence endpoint() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# This file contains the different endpoints your bot can use.");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# Server where the models are pulled from.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/user-guide/running-the-server/#fetching-models-from-a-server/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#models:");
    _builder.newLine();
    _builder.append("#  url: http://my-server.com/models/default_core@latest");
    _builder.newLine();
    _builder.append("#  wait_time_between_pulls:  10   # [optional](default: 100)");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# Server which runs your custom actions.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/core/actions/#custom-actions/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#action_endpoint:");
    _builder.newLine();
    _builder.append("#  url: \"http://localhost:5055/webhook\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# Tracker store which is used to store the conversations.");
    _builder.newLine();
    _builder.append("# By default the conversations are stored in memory.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/api/tracker-stores/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#tracker_store:");
    _builder.newLine();
    _builder.append("#    type: redis");
    _builder.newLine();
    _builder.append("#    url: <host of the redis instance, e.g. localhost>");
    _builder.newLine();
    _builder.append("#    port: <port of your redis instance, usually 6379>");
    _builder.newLine();
    _builder.append("#    db: <number of your database within redis, e.g. 0>");
    _builder.newLine();
    _builder.append("#    password: <password used for authentication>");
    _builder.newLine();
    _builder.append("#    use_ssl: <whether or not the communication is encrypted, default false>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#tracker_store:");
    _builder.newLine();
    _builder.append("#    type: mongod");
    _builder.newLine();
    _builder.append("#    url: <url to your mongo instance, e.g. mongodb://localhost:27017>");
    _builder.newLine();
    _builder.append("#    db: <name of the db within your mongo instance, e.g. rasa>");
    _builder.newLine();
    _builder.append("#    username: <username used for authentication>");
    _builder.newLine();
    _builder.append("#    password: <password used for authentication>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# Event broker which all conversation events should be streamed to.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/api/event-brokers/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#event_broker:");
    _builder.newLine();
    _builder.append("#  url: localhost");
    _builder.newLine();
    _builder.append("#  username: username");
    _builder.newLine();
    _builder.append("#  password: password");
    _builder.newLine();
    _builder.append("#  queue: queue");
    _builder.newLine();
    _builder.append("action_endpoint:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("url: http://localhost:5055/webhook");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence config(final Language lan) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# Configuration for Rasa NLU.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/nlu/components/");
    _builder.newLine();
    _builder.append("language: ");
    String _languageAbbreviation = this.languageAbbreviation(lan);
    _builder.append(_languageAbbreviation);
    _builder.newLineIfNotEmpty();
    _builder.append("pipeline: supervised_embeddings");
    _builder.newLine();
    _builder.newLine();
    _builder.append("# Configuration for Rasa Core.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/core/policies/");
    _builder.newLine();
    _builder.append("policies:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("- name: MemoizationPolicy");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("- name: KerasPolicy");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("- name: MappingPolicy");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("- name: \"FormPolicy\"");
    _builder.newLine();
    return _builder;
  }
  
  public String languageAbbreviation(final Language lan) {
    if (lan != null) {
      switch (lan) {
        case ENGLISH:
          return "en";
        case SPANISH:
          return "es";
        case DANISH:
          return "da";
        case GERMAN:
          return "de";
        case FRENCH:
          return "fr";
        case HINDI:
          return "hi";
        case INDONESIAN:
          return "id";
        case ITALIAN:
          return "it";
        case JAPANESE:
          return "ja";
        case KOREAN:
          return "ko";
        case DUTCH:
          return "nl";
        case NORWEGIAN:
          return "no";
        case POLISH:
          return "pl";
        case PORTUGUESE:
          return "pt";
        case RUSIAN:
          return "ru";
        case SWEDISH:
          return "sv";
        case THAI:
          return "th";
        case TURKISH:
          return "tr";
        case UKRANIAN:
          return "uk";
        case CHINESE:
          return "zh";
        default:
          return "en";
      }
    } else {
      return "en";
    }
  }
  
  public CharSequence credentials() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("# This file contains the credentials for the voice & chat platforms");
    _builder.newLine();
    _builder.append("# which your bot is using.");
    _builder.newLine();
    _builder.append("# https://rasa.com/docs/rasa/user-guide/messaging-and-voice-channels/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rest:");
    _builder.newLine();
    _builder.append("#  # you don\'t need to provide anything here - this channel doesn\'t");
    _builder.newLine();
    _builder.append("#  # require any credentials");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("#facebook:");
    _builder.newLine();
    _builder.append("#  verify: \"<verify>\"");
    _builder.newLine();
    _builder.append("#  secret: \"<your secret>\"");
    _builder.newLine();
    _builder.append("#  page-access-token: \"<your page access token>\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#slack:");
    _builder.newLine();
    _builder.append("#  slack_token: \"<your slack token>\"");
    _builder.newLine();
    _builder.append("#  slack_channel: \"<the slack channel>\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#socketio:");
    _builder.newLine();
    _builder.append("#  user_message_evt: <event name for user message>");
    _builder.newLine();
    _builder.append("#  bot_message_evt: <event name for but messages>");
    _builder.newLine();
    _builder.append("#  session_persistence: <true/false>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#mattermost:");
    _builder.newLine();
    _builder.append("#  url: \"https://<mattermost instance>/api/v4\"");
    _builder.newLine();
    _builder.append("#  team: \"<mattermost team>\"");
    _builder.newLine();
    _builder.append("#  user: \"<bot username>\"");
    _builder.newLine();
    _builder.append("#  pw: \"<bot token>\"");
    _builder.newLine();
    _builder.append("#  webhook_url: \"<callback URL>\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rasa:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("url: \"http://localhost:5002/api\"");
    _builder.newLine();
    return _builder;
  }
}
