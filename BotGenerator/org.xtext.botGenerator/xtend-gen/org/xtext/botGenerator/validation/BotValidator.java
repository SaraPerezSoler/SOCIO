/**
 * generated by Xtext 2.19.0
 */
package org.xtext.botGenerator.validation;

import com.google.common.base.Objects;
import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.Element;
import generator.GeneratorPackage;
import generator.HTTPRequest;
import generator.HTTPRequestToke;
import generator.HTTPResponse;
import generator.HTTPReturnType;
import generator.Intent;
import generator.IntentLanguageInputs;
import generator.Language;
import generator.Parameter;
import generator.ParameterReferenceToken;
import generator.PromptLanguage;
import generator.Simple;
import generator.SimpleInput;
import generator.SimpleLanguageInput;
import generator.Text;
import generator.TextLanguageInput;
import generator.TrainingPhrase;
import generator.UserInteraction;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.botGenerator.validation.AbstractBotValidator;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class BotValidator extends AbstractBotValidator {
  @Check
  public void checkHTTTPRequestTokenDataKey(final HTTPRequestToke httpRequestToken) {
    if (((!Objects.equal(httpRequestToken.getType(), HTTPReturnType.DATA)) && (!httpRequestToken.getDataKey().isEmpty()))) {
      this.warning("The data key is only using with the data type of http request", 
        GeneratorPackage.Literals.HTTP_REQUEST_TOKE__DATA_KEY, "invalid data key");
    }
  }
  
  @Check
  public void checkParameterReferences(final ParameterReferenceToken references) {
    EObject container = references.eContainer();
    if ((!(container instanceof TrainingPhrase))) {
      return;
    }
    EObject containercontainer = container.eContainer();
    if ((!(containercontainer instanceof Intent))) {
      return;
    }
    Intent intent = ((Intent) containercontainer);
    boolean _contains = intent.getParameters().contains(references.getParameter());
    boolean _not = (!_contains);
    if (_not) {
      this.error("This parameter is not from the list of intents parameters", 
        GeneratorPackage.Literals.PARAMETER_REFERENCE_TOKEN__PARAMETER);
    }
  }
  
  @Check
  public void flowPath(final Bot bot) {
    for (int i = 0; (i < bot.getFlows().size()); i++) {
      {
        UserInteraction current = bot.getFlows().get(i);
        for (int j = (i + 1); (j < bot.getFlows().size()); j++) {
          {
            UserInteraction nexts = bot.getFlows().get(j);
            Intent _intent = current.getIntent();
            Intent _intent_1 = nexts.getIntent();
            boolean _tripleEquals = (_intent == _intent_1);
            if (_tripleEquals) {
              String _name = current.getIntent().getName();
              String _plus = ("Only one path can start with the intent " + _name);
              this.error(_plus, 
                GeneratorPackage.Literals.BOT__FLOWS);
            }
          }
        }
      }
    }
  }
  
  @Check
  public void flowPathState(final BotInteraction state) {
    for (int i = 0; (i < state.getOutcoming().size()); i++) {
      {
        UserInteraction current = state.getOutcoming().get(i);
        for (int j = (i + 1); (j < state.getOutcoming().size()); j++) {
          {
            UserInteraction nexts = state.getOutcoming().get(j);
            Intent _intent = current.getIntent();
            Intent _intent_1 = nexts.getIntent();
            boolean _tripleEquals = (_intent == _intent_1);
            if (_tripleEquals) {
              String _name = current.getIntent().getName();
              String _plus = ("Only one path can start with the intent " + _name);
              this.error(_plus, 
                GeneratorPackage.Literals.BOT_INTERACTION__OUTCOMING);
            }
          }
        }
      }
    }
  }
  
  @Check
  public void nameUnique(final Element e) {
    EObject container = e.eContainer();
    if ((container instanceof Bot)) {
      ArrayList<Element> elements = new ArrayList<Element>();
      elements.addAll(((Bot)container).getIntents());
      elements.addAll(((Bot)container).getActions());
      elements.addAll(((Bot)container).getEntities());
      for (final Element i : elements) {
        if (((!i.equals(e)) && i.getName().equals(e.getName()))) {
          String _name = i.getName();
          String _plus = ("There are several elements with the name " + _name);
          String _plus_1 = (_plus + 
            ". The name of the elements must be unique");
          this.error(_plus_1, GeneratorPackage.Literals.ELEMENT__NAME);
        }
      }
    }
  }
  
  @Check
  public void nameUnique(final Parameter param) {
    EObject container = param.eContainer();
    if ((container instanceof Intent)) {
      EList<Parameter> _parameters = ((Intent)container).getParameters();
      for (final Parameter p : _parameters) {
        if (((!param.equals(p)) && param.getName().equals(p.getName()))) {
          String _name = p.getName();
          String _plus = ("There are several parameters with the name " + _name);
          String _plus_1 = (_plus + 
            " in this intent. The name of the parameters must be unique");
          this.error(_plus_1, 
            GeneratorPackage.Literals.ELEMENT__NAME);
        }
      }
    }
  }
  
  @Check
  public void nameUnique(final SimpleInput input) {
    EObject container = input.eContainer();
    if ((container instanceof SimpleLanguageInput)) {
      EList<SimpleInput> _inputs = ((SimpleLanguageInput)container).getInputs();
      for (final SimpleInput i : _inputs) {
        if (((!input.equals(i)) && input.getName().equals(i.getName()))) {
          String _name = i.getName();
          String _plus = ("There are several entries with the name " + _name);
          String _plus_1 = (_plus + 
            " in this entity. The name of the entries must be unique");
          this.error(_plus_1, 
            GeneratorPackage.Literals.ELEMENT__NAME);
        }
      }
    }
  }
  
  @Check
  public void paramEntity(final Parameter param) {
    if (((param.getEntity() == null) && (param.getDefaultEntity() == null))) {
      this.error("The parameter must have a entity", GeneratorPackage.Literals.PARAMETER__ENTITY);
    }
  }
  
  @Check
  public void requestExecution(final BotInteraction interaction) {
    EList<Action> _actions = interaction.getActions();
    for (final Action action : _actions) {
      if ((action instanceof HTTPResponse)) {
        int index = interaction.getActions().indexOf(action);
        if ((index == 0)) {
          this.error("Before an HttpResponse must go the HttpRequest which reference", 
            GeneratorPackage.Literals.BOT_INTERACTION__ACTIONS);
        } else {
          Action _get = interaction.getActions().get((index - 1));
          HTTPRequest _hTTPRequest = ((HTTPResponse)action).getHTTPRequest();
          boolean _tripleNotEquals = (_get != _hTTPRequest);
          if (_tripleNotEquals) {
            this.error("Before an HttpResponse must go the HttpRequest which reference", 
              GeneratorPackage.Literals.BOT_INTERACTION__ACTIONS);
          }
        }
      }
    }
  }
  
  @Check
  public void entityLanguage(final Simple entity) {
    ArrayList<Language> entityLan = new ArrayList<Language>();
    EObject container = entity.eContainer();
    if ((container instanceof Bot)) {
      EList<SimpleLanguageInput> _inputs = entity.getInputs();
      for (final SimpleLanguageInput input : _inputs) {
        {
          Language _language = input.getLanguage();
          boolean _equals = Objects.equal(_language, Language.EMPTY);
          if (_equals) {
            input.setLanguage(((Bot)container).getLanguages().get(0));
          }
          boolean _contains = entityLan.contains(input.getLanguage());
          boolean _not = (!_contains);
          if (_not) {
            entityLan.add(input.getLanguage());
          }
        }
      }
      EList<Language> _languages = ((Bot)container).getLanguages();
      for (final Language lan : _languages) {
        boolean _contains = entityLan.contains(lan);
        boolean _not = (!_contains);
        if (_not) {
          String _firstUpper = StringExtensions.toFirstUpper(lan.getLiteral().toLowerCase());
          String _plus = ("The chatbot support the language " + _firstUpper);
          String _plus_1 = (_plus + 
            " and this entity does not have a input in this language");
          this.warning(_plus_1, 
            GeneratorPackage.Literals.ELEMENT__NAME);
        }
      }
    }
  }
  
  @Check
  public void entityLanguage(final SimpleLanguageInput input) {
    EObject bot = input.eContainer().eContainer();
    EObject entity = input.eContainer();
    if ((bot instanceof Bot)) {
      if ((entity instanceof Simple)) {
        Language _language = input.getLanguage();
        boolean _equals = Objects.equal(_language, Language.EMPTY);
        if (_equals) {
          input.setLanguage(((Bot)bot).getLanguages().get(0));
        }
        boolean _contains = ((Bot)bot).getLanguages().contains(input.getLanguage());
        boolean _not = (!_contains);
        if (_not) {
          this.error("The input languages must be one of the chatbot languages", 
            GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
        }
        EList<SimpleLanguageInput> _inputs = ((Simple)entity).getInputs();
        for (final SimpleLanguageInput input2 : _inputs) {
          if (((!input.equals(input2)) && input.getLanguage().equals(input2.getLanguage()))) {
            this.error("The intent can not have several inputs with the same language", 
              GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
          }
        }
      }
    }
  }
  
  @Check
  public void intentLanguage(final Intent intent) {
    ArrayList<Language> intentLan = new ArrayList<Language>();
    EObject container = intent.eContainer();
    if ((container instanceof Bot)) {
      EList<IntentLanguageInputs> _inputs = intent.getInputs();
      for (final IntentLanguageInputs input : _inputs) {
        {
          Language _language = input.getLanguage();
          boolean _equals = Objects.equal(_language, Language.EMPTY);
          if (_equals) {
            input.setLanguage(((Bot)container).getLanguages().get(0));
          }
          boolean _contains = intentLan.contains(input.getLanguage());
          boolean _not = (!_contains);
          if (_not) {
            intentLan.add(input.getLanguage());
          }
        }
      }
      EList<Language> _languages = ((Bot)container).getLanguages();
      for (final Language lan : _languages) {
        boolean _contains = intentLan.contains(lan);
        boolean _not = (!_contains);
        if (_not) {
          String _firstUpper = StringExtensions.toFirstUpper(lan.getLiteral().toLowerCase());
          String _plus = ("The chatbot support the language " + _firstUpper);
          String _plus_1 = (_plus + 
            " and this intent does not have a input in this language");
          this.warning(_plus_1, 
            GeneratorPackage.Literals.ELEMENT__NAME);
        }
      }
    }
  }
  
  @Check
  public void intentLanguage(final IntentLanguageInputs input) {
    EObject bot = input.eContainer().eContainer();
    EObject intent = input.eContainer();
    if ((bot instanceof Bot)) {
      if ((intent instanceof Intent)) {
        Language _language = input.getLanguage();
        boolean _equals = Objects.equal(_language, Language.EMPTY);
        if (_equals) {
          input.setLanguage(((Bot)bot).getLanguages().get(0));
        }
        boolean _contains = ((Bot)bot).getLanguages().contains(input.getLanguage());
        boolean _not = (!_contains);
        if (_not) {
          this.error("The input languages must be one of the chatbot languages", 
            GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
        }
        EList<IntentLanguageInputs> _inputs = ((Intent)intent).getInputs();
        for (final IntentLanguageInputs input2 : _inputs) {
          if (((!input.equals(input2)) && input.getLanguage().equals(input2.getLanguage()))) {
            this.error("The intent can not have several inputs with the same language", 
              GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
          }
        }
      }
    }
  }
  
  @Check
  public void paramLanguage(final PromptLanguage prompt) {
    EObject bot = prompt.eContainer().eContainer().eContainer();
    EObject param = prompt.eContainer();
    if ((bot instanceof Bot)) {
      if ((param instanceof Parameter)) {
        Language _language = prompt.getLanguage();
        boolean _equals = Objects.equal(_language, Language.EMPTY);
        if (_equals) {
          prompt.setLanguage(((Bot)bot).getLanguages().get(0));
        }
        boolean _contains = ((Bot)bot).getLanguages().contains(prompt.getLanguage());
        boolean _not = (!_contains);
        if (_not) {
          this.error("The prompt language must be some of the chatbot languages", 
            GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
        }
        EList<PromptLanguage> _prompts = ((Parameter)param).getPrompts();
        for (final PromptLanguage prompt2 : _prompts) {
          if (((!prompt.equals(prompt2)) && prompt.getLanguage().equals(prompt2.getLanguage()))) {
            this.error("The parameter can not have several prompts with the same language", 
              GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
          }
        }
      }
    }
  }
  
  @Check
  public void paramLanguage(final Parameter param) {
    ArrayList<Language> paramLan = new ArrayList<Language>();
    EObject container = param.eContainer().eContainer();
    if ((container instanceof Bot)) {
      EList<PromptLanguage> _prompts = param.getPrompts();
      for (final PromptLanguage input : _prompts) {
        {
          Language _language = input.getLanguage();
          boolean _equals = Objects.equal(_language, Language.EMPTY);
          if (_equals) {
            input.setLanguage(((Bot)container).getLanguages().get(0));
          }
          boolean _contains = paramLan.contains(input.getLanguage());
          boolean _not = (!_contains);
          if (_not) {
            paramLan.add(input.getLanguage());
          }
        }
      }
      boolean _isEmpty = param.getPrompts().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<Language> _languages = ((Bot)container).getLanguages();
        for (final Language lan : _languages) {
          boolean _contains = paramLan.contains(lan);
          boolean _not_1 = (!_contains);
          if (_not_1) {
            String _firstUpper = StringExtensions.toFirstUpper(lan.getLiteral().toLowerCase());
            String _plus = ("The chatbot support the language " + _firstUpper);
            String _plus_1 = (_plus + 
              " and this parameter does not have a prompt in this language");
            this.warning(_plus_1, 
              GeneratorPackage.Literals.ELEMENT__NAME);
          }
        }
      }
    }
  }
  
  @Check
  public void textLanguage(final TextLanguageInput text) {
    EObject bot = text.eContainer().eContainer();
    EObject action = text.eContainer();
    if ((bot instanceof Bot)) {
      Language _language = text.getLanguage();
      boolean _equals = Objects.equal(_language, Language.EMPTY);
      if (_equals) {
        text.setLanguage(((Bot)bot).getLanguages().get(0));
      }
      boolean _contains = ((Bot)bot).getLanguages().contains(text.getLanguage());
      boolean _not = (!_contains);
      if (_not) {
        this.error("The text language must be some of the chatbot languages", 
          GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
      }
      if ((action instanceof Text)) {
        EList<TextLanguageInput> _inputs = ((Text)action).getInputs();
        for (final TextLanguageInput text2 : _inputs) {
          if (((!text.equals(text2)) && text.getLanguage().equals(text2.getLanguage()))) {
            this.error("The text response can not have several inputs with the same language", 
              GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
          }
        }
      } else {
        if ((action instanceof HTTPResponse)) {
          EList<TextLanguageInput> _inputs_1 = ((HTTPResponse)action).getInputs();
          for (final TextLanguageInput text2_1 : _inputs_1) {
            if (((!text.equals(text2_1)) && text.getLanguage().equals(text2_1.getLanguage()))) {
              this.error("The http response can not have several inputs with the same language", 
                GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE);
            }
          }
        }
      }
    }
  }
  
  @Check
  public void textLanguage(final Action action) {
    ArrayList<Language> actionLan = new ArrayList<Language>();
    EObject bot = action.eContainer();
    if ((bot instanceof Bot)) {
      if ((action instanceof Text)) {
        EList<TextLanguageInput> _inputs = ((Text)action).getInputs();
        for (final TextLanguageInput input : _inputs) {
          {
            Language _language = input.getLanguage();
            boolean _equals = Objects.equal(_language, Language.EMPTY);
            if (_equals) {
              input.setLanguage(((Bot)bot).getLanguages().get(0));
            }
            boolean _contains = actionLan.contains(input.getLanguage());
            boolean _not = (!_contains);
            if (_not) {
              actionLan.add(input.getLanguage());
            }
          }
        }
        EList<Language> _languages = ((Bot)bot).getLanguages();
        for (final Language lan : _languages) {
          boolean _contains = actionLan.contains(lan);
          boolean _not = (!_contains);
          if (_not) {
            String _firstUpper = StringExtensions.toFirstUpper(lan.getLiteral().toLowerCase());
            String _plus = ("The chatbot support the language " + _firstUpper);
            String _plus_1 = (_plus + 
              " and this text response does not have a input in this language");
            this.warning(_plus_1, 
              GeneratorPackage.Literals.ELEMENT__NAME);
          }
        }
      } else {
        if ((action instanceof HTTPResponse)) {
          EList<TextLanguageInput> _inputs_1 = ((HTTPResponse)action).getInputs();
          for (final TextLanguageInput input_1 : _inputs_1) {
            {
              Language _language = input_1.getLanguage();
              boolean _equals = Objects.equal(_language, Language.EMPTY);
              if (_equals) {
                input_1.setLanguage(((Bot)bot).getLanguages().get(0));
              }
              boolean _contains_1 = actionLan.contains(input_1.getLanguage());
              boolean _not_1 = (!_contains_1);
              if (_not_1) {
                actionLan.add(input_1.getLanguage());
              }
            }
          }
          EList<Language> _languages_1 = ((Bot)bot).getLanguages();
          for (final Language lan_1 : _languages_1) {
            boolean _contains_1 = actionLan.contains(lan_1);
            boolean _not_1 = (!_contains_1);
            if (_not_1) {
              String _firstUpper_1 = StringExtensions.toFirstUpper(lan_1.getLiteral().toLowerCase());
              String _plus_2 = ("The chatbot support the language " + _firstUpper_1);
              String _plus_3 = (_plus_2 + 
                " and this http response does not have a input in this language");
              this.warning(_plus_3, 
                GeneratorPackage.Literals.ELEMENT__NAME);
            }
          }
        }
      }
    }
  }
}
