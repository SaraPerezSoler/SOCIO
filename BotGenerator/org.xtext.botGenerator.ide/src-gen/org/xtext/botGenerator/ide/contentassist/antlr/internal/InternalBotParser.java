package org.xtext.botGenerator.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.botGenerator.services.BotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBotParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'text'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language:'", "'intents'", "':'", "'flows'", "'entities'", "'actions'", "'-'", "';'", "'{'", "'inputs:'", "'}'", "','", "'parameters:'", "'user'", "'=>'", "'chatbot'", "'('", "')'", "'entity'", "'prompts'", "'['", "']'", "'@'", "'request.'", "'.'", "'Simple'", "'Composite'", "'synonyms'", "'response'", "'text:'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'Fallback'", "'required'", "'isList'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalBotParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBotParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBotParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBot.g"; }


    	private BotGrammarAccess grammarAccess;

    	public void setGrammarAccess(BotGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleBot"
    // InternalBot.g:53:1: entryRuleBot : ruleBot EOF ;
    public final void entryRuleBot() throws RecognitionException {
        try {
            // InternalBot.g:54:1: ( ruleBot EOF )
            // InternalBot.g:55:1: ruleBot EOF
            {
             before(grammarAccess.getBotRule()); 
            pushFollow(FOLLOW_1);
            ruleBot();

            state._fsp--;

             after(grammarAccess.getBotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBot"


    // $ANTLR start "ruleBot"
    // InternalBot.g:62:1: ruleBot : ( ( rule__Bot__Group__0 ) ) ;
    public final void ruleBot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:66:2: ( ( ( rule__Bot__Group__0 ) ) )
            // InternalBot.g:67:2: ( ( rule__Bot__Group__0 ) )
            {
            // InternalBot.g:67:2: ( ( rule__Bot__Group__0 ) )
            // InternalBot.g:68:3: ( rule__Bot__Group__0 )
            {
             before(grammarAccess.getBotAccess().getGroup()); 
            // InternalBot.g:69:3: ( rule__Bot__Group__0 )
            // InternalBot.g:69:4: rule__Bot__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBot"


    // $ANTLR start "entryRuleEntity"
    // InternalBot.g:78:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalBot.g:79:1: ( ruleEntity EOF )
            // InternalBot.g:80:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalBot.g:87:1: ruleEntity : ( ( rule__Entity__Alternatives ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:91:2: ( ( ( rule__Entity__Alternatives ) ) )
            // InternalBot.g:92:2: ( ( rule__Entity__Alternatives ) )
            {
            // InternalBot.g:92:2: ( ( rule__Entity__Alternatives ) )
            // InternalBot.g:93:3: ( rule__Entity__Alternatives )
            {
             before(grammarAccess.getEntityAccess().getAlternatives()); 
            // InternalBot.g:94:3: ( rule__Entity__Alternatives )
            // InternalBot.g:94:4: rule__Entity__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleAction"
    // InternalBot.g:103:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalBot.g:104:1: ( ruleAction EOF )
            // InternalBot.g:105:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalBot.g:112:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:116:2: ( ( ( rule__Action__Alternatives ) ) )
            // InternalBot.g:117:2: ( ( rule__Action__Alternatives ) )
            {
            // InternalBot.g:117:2: ( ( rule__Action__Alternatives ) )
            // InternalBot.g:118:3: ( rule__Action__Alternatives )
            {
             before(grammarAccess.getActionAccess().getAlternatives()); 
            // InternalBot.g:119:3: ( rule__Action__Alternatives )
            // InternalBot.g:119:4: rule__Action__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Action__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEString"
    // InternalBot.g:128:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalBot.g:129:1: ( ruleEString EOF )
            // InternalBot.g:130:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalBot.g:137:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:141:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalBot.g:142:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalBot.g:142:2: ( ( rule__EString__Alternatives ) )
            // InternalBot.g:143:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalBot.g:144:3: ( rule__EString__Alternatives )
            // InternalBot.g:144:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleIntent"
    // InternalBot.g:153:1: entryRuleIntent : ruleIntent EOF ;
    public final void entryRuleIntent() throws RecognitionException {
        try {
            // InternalBot.g:154:1: ( ruleIntent EOF )
            // InternalBot.g:155:1: ruleIntent EOF
            {
             before(grammarAccess.getIntentRule()); 
            pushFollow(FOLLOW_1);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getIntentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntent"


    // $ANTLR start "ruleIntent"
    // InternalBot.g:162:1: ruleIntent : ( ( rule__Intent__Group__0 ) ) ;
    public final void ruleIntent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:166:2: ( ( ( rule__Intent__Group__0 ) ) )
            // InternalBot.g:167:2: ( ( rule__Intent__Group__0 ) )
            {
            // InternalBot.g:167:2: ( ( rule__Intent__Group__0 ) )
            // InternalBot.g:168:3: ( rule__Intent__Group__0 )
            {
             before(grammarAccess.getIntentAccess().getGroup()); 
            // InternalBot.g:169:3: ( rule__Intent__Group__0 )
            // InternalBot.g:169:4: rule__Intent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntent"


    // $ANTLR start "entryRuleTransition"
    // InternalBot.g:178:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalBot.g:179:1: ( ruleTransition EOF )
            // InternalBot.g:180:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalBot.g:187:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:191:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalBot.g:192:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalBot.g:192:2: ( ( rule__Transition__Group__0 ) )
            // InternalBot.g:193:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalBot.g:194:3: ( rule__Transition__Group__0 )
            // InternalBot.g:194:4: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleState"
    // InternalBot.g:203:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalBot.g:204:1: ( ruleState EOF )
            // InternalBot.g:205:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalBot.g:212:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:216:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalBot.g:217:2: ( ( rule__State__Group__0 ) )
            {
            // InternalBot.g:217:2: ( ( rule__State__Group__0 ) )
            // InternalBot.g:218:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalBot.g:219:3: ( rule__State__Group__0 )
            // InternalBot.g:219:4: rule__State__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleState2"
    // InternalBot.g:228:1: entryRuleState2 : ruleState2 EOF ;
    public final void entryRuleState2() throws RecognitionException {
        try {
            // InternalBot.g:229:1: ( ruleState2 EOF )
            // InternalBot.g:230:1: ruleState2 EOF
            {
             before(grammarAccess.getState2Rule()); 
            pushFollow(FOLLOW_1);
            ruleState2();

            state._fsp--;

             after(grammarAccess.getState2Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState2"


    // $ANTLR start "ruleState2"
    // InternalBot.g:237:1: ruleState2 : ( ( rule__State2__Group__0 ) ) ;
    public final void ruleState2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:241:2: ( ( ( rule__State2__Group__0 ) ) )
            // InternalBot.g:242:2: ( ( rule__State2__Group__0 ) )
            {
            // InternalBot.g:242:2: ( ( rule__State2__Group__0 ) )
            // InternalBot.g:243:3: ( rule__State2__Group__0 )
            {
             before(grammarAccess.getState2Access().getGroup()); 
            // InternalBot.g:244:3: ( rule__State2__Group__0 )
            // InternalBot.g:244:4: rule__State2__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState2"


    // $ANTLR start "entryRuleTrainingPhrase"
    // InternalBot.g:253:1: entryRuleTrainingPhrase : ruleTrainingPhrase EOF ;
    public final void entryRuleTrainingPhrase() throws RecognitionException {
        try {
            // InternalBot.g:254:1: ( ruleTrainingPhrase EOF )
            // InternalBot.g:255:1: ruleTrainingPhrase EOF
            {
             before(grammarAccess.getTrainingPhraseRule()); 
            pushFollow(FOLLOW_1);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getTrainingPhraseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrainingPhrase"


    // $ANTLR start "ruleTrainingPhrase"
    // InternalBot.g:262:1: ruleTrainingPhrase : ( ( rule__TrainingPhrase__Group__0 ) ) ;
    public final void ruleTrainingPhrase() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:266:2: ( ( ( rule__TrainingPhrase__Group__0 ) ) )
            // InternalBot.g:267:2: ( ( rule__TrainingPhrase__Group__0 ) )
            {
            // InternalBot.g:267:2: ( ( rule__TrainingPhrase__Group__0 ) )
            // InternalBot.g:268:3: ( rule__TrainingPhrase__Group__0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getGroup()); 
            // InternalBot.g:269:3: ( rule__TrainingPhrase__Group__0 )
            // InternalBot.g:269:4: rule__TrainingPhrase__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrainingPhrase"


    // $ANTLR start "entryRuleParameter"
    // InternalBot.g:278:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalBot.g:279:1: ( ruleParameter EOF )
            // InternalBot.g:280:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBot.g:287:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:291:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalBot.g:292:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalBot.g:292:2: ( ( rule__Parameter__Group__0 ) )
            // InternalBot.g:293:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalBot.g:294:3: ( rule__Parameter__Group__0 )
            // InternalBot.g:294:4: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:303:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBot.g:304:1: ( ruleLiteral EOF )
            // InternalBot.g:305:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBot.g:312:1: ruleLiteral : ( ( rule__Literal__TextAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:316:2: ( ( ( rule__Literal__TextAssignment ) ) )
            // InternalBot.g:317:2: ( ( rule__Literal__TextAssignment ) )
            {
            // InternalBot.g:317:2: ( ( rule__Literal__TextAssignment ) )
            // InternalBot.g:318:3: ( rule__Literal__TextAssignment )
            {
             before(grammarAccess.getLiteralAccess().getTextAssignment()); 
            // InternalBot.g:319:3: ( rule__Literal__TextAssignment )
            // InternalBot.g:319:4: rule__Literal__TextAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Literal__TextAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getTextAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEntityToken"
    // InternalBot.g:328:1: entryRuleEntityToken : ruleEntityToken EOF ;
    public final void entryRuleEntityToken() throws RecognitionException {
        try {
            // InternalBot.g:329:1: ( ruleEntityToken EOF )
            // InternalBot.g:330:1: ruleEntityToken EOF
            {
             before(grammarAccess.getEntityTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleEntityToken();

            state._fsp--;

             after(grammarAccess.getEntityTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntityToken"


    // $ANTLR start "ruleEntityToken"
    // InternalBot.g:337:1: ruleEntityToken : ( ( rule__EntityToken__Group__0 ) ) ;
    public final void ruleEntityToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:341:2: ( ( ( rule__EntityToken__Group__0 ) ) )
            // InternalBot.g:342:2: ( ( rule__EntityToken__Group__0 ) )
            {
            // InternalBot.g:342:2: ( ( rule__EntityToken__Group__0 ) )
            // InternalBot.g:343:3: ( rule__EntityToken__Group__0 )
            {
             before(grammarAccess.getEntityTokenAccess().getGroup()); 
            // InternalBot.g:344:3: ( rule__EntityToken__Group__0 )
            // InternalBot.g:344:4: rule__EntityToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntityToken"


    // $ANTLR start "entryRuleParameterToken"
    // InternalBot.g:353:1: entryRuleParameterToken : ruleParameterToken EOF ;
    public final void entryRuleParameterToken() throws RecognitionException {
        try {
            // InternalBot.g:354:1: ( ruleParameterToken EOF )
            // InternalBot.g:355:1: ruleParameterToken EOF
            {
             before(grammarAccess.getParameterTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterToken();

            state._fsp--;

             after(grammarAccess.getParameterTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterToken"


    // $ANTLR start "ruleParameterToken"
    // InternalBot.g:362:1: ruleParameterToken : ( ( rule__ParameterToken__Group__0 ) ) ;
    public final void ruleParameterToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:366:2: ( ( ( rule__ParameterToken__Group__0 ) ) )
            // InternalBot.g:367:2: ( ( rule__ParameterToken__Group__0 ) )
            {
            // InternalBot.g:367:2: ( ( rule__ParameterToken__Group__0 ) )
            // InternalBot.g:368:3: ( rule__ParameterToken__Group__0 )
            {
             before(grammarAccess.getParameterTokenAccess().getGroup()); 
            // InternalBot.g:369:3: ( rule__ParameterToken__Group__0 )
            // InternalBot.g:369:4: rule__ParameterToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterToken"


    // $ANTLR start "entryRuleParameterRefenceToken"
    // InternalBot.g:378:1: entryRuleParameterRefenceToken : ruleParameterRefenceToken EOF ;
    public final void entryRuleParameterRefenceToken() throws RecognitionException {
        try {
            // InternalBot.g:379:1: ( ruleParameterRefenceToken EOF )
            // InternalBot.g:380:1: ruleParameterRefenceToken EOF
            {
             before(grammarAccess.getParameterRefenceTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterRefenceToken();

            state._fsp--;

             after(grammarAccess.getParameterRefenceTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterRefenceToken"


    // $ANTLR start "ruleParameterRefenceToken"
    // InternalBot.g:387:1: ruleParameterRefenceToken : ( ( rule__ParameterRefenceToken__Group__0 ) ) ;
    public final void ruleParameterRefenceToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:391:2: ( ( ( rule__ParameterRefenceToken__Group__0 ) ) )
            // InternalBot.g:392:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            {
            // InternalBot.g:392:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            // InternalBot.g:393:3: ( rule__ParameterRefenceToken__Group__0 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getGroup()); 
            // InternalBot.g:394:3: ( rule__ParameterRefenceToken__Group__0 )
            // InternalBot.g:394:4: rule__ParameterRefenceToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterRefenceTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterRefenceToken"


    // $ANTLR start "entryRuleHTTPRequestToken"
    // InternalBot.g:403:1: entryRuleHTTPRequestToken : ruleHTTPRequestToken EOF ;
    public final void entryRuleHTTPRequestToken() throws RecognitionException {
        try {
            // InternalBot.g:404:1: ( ruleHTTPRequestToken EOF )
            // InternalBot.g:405:1: ruleHTTPRequestToken EOF
            {
             before(grammarAccess.getHTTPRequestTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleHTTPRequestToken();

            state._fsp--;

             after(grammarAccess.getHTTPRequestTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHTTPRequestToken"


    // $ANTLR start "ruleHTTPRequestToken"
    // InternalBot.g:412:1: ruleHTTPRequestToken : ( ( rule__HTTPRequestToken__Group__0 ) ) ;
    public final void ruleHTTPRequestToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:416:2: ( ( ( rule__HTTPRequestToken__Group__0 ) ) )
            // InternalBot.g:417:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            {
            // InternalBot.g:417:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            // InternalBot.g:418:3: ( rule__HTTPRequestToken__Group__0 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup()); 
            // InternalBot.g:419:3: ( rule__HTTPRequestToken__Group__0 )
            // InternalBot.g:419:4: rule__HTTPRequestToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPRequestToken"


    // $ANTLR start "entryRuleSimple"
    // InternalBot.g:428:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // InternalBot.g:429:1: ( ruleSimple EOF )
            // InternalBot.g:430:1: ruleSimple EOF
            {
             before(grammarAccess.getSimpleRule()); 
            pushFollow(FOLLOW_1);
            ruleSimple();

            state._fsp--;

             after(grammarAccess.getSimpleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // InternalBot.g:437:1: ruleSimple : ( ( rule__Simple__Group__0 ) ) ;
    public final void ruleSimple() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:441:2: ( ( ( rule__Simple__Group__0 ) ) )
            // InternalBot.g:442:2: ( ( rule__Simple__Group__0 ) )
            {
            // InternalBot.g:442:2: ( ( rule__Simple__Group__0 ) )
            // InternalBot.g:443:3: ( rule__Simple__Group__0 )
            {
             before(grammarAccess.getSimpleAccess().getGroup()); 
            // InternalBot.g:444:3: ( rule__Simple__Group__0 )
            // InternalBot.g:444:4: rule__Simple__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Simple__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleComposite"
    // InternalBot.g:453:1: entryRuleComposite : ruleComposite EOF ;
    public final void entryRuleComposite() throws RecognitionException {
        try {
            // InternalBot.g:454:1: ( ruleComposite EOF )
            // InternalBot.g:455:1: ruleComposite EOF
            {
             before(grammarAccess.getCompositeRule()); 
            pushFollow(FOLLOW_1);
            ruleComposite();

            state._fsp--;

             after(grammarAccess.getCompositeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComposite"


    // $ANTLR start "ruleComposite"
    // InternalBot.g:462:1: ruleComposite : ( ( rule__Composite__Group__0 ) ) ;
    public final void ruleComposite() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:466:2: ( ( ( rule__Composite__Group__0 ) ) )
            // InternalBot.g:467:2: ( ( rule__Composite__Group__0 ) )
            {
            // InternalBot.g:467:2: ( ( rule__Composite__Group__0 ) )
            // InternalBot.g:468:3: ( rule__Composite__Group__0 )
            {
             before(grammarAccess.getCompositeAccess().getGroup()); 
            // InternalBot.g:469:3: ( rule__Composite__Group__0 )
            // InternalBot.g:469:4: rule__Composite__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Composite__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComposite"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:478:1: entryRuleSimpleInput : ruleSimpleInput EOF ;
    public final void entryRuleSimpleInput() throws RecognitionException {
        try {
            // InternalBot.g:479:1: ( ruleSimpleInput EOF )
            // InternalBot.g:480:1: ruleSimpleInput EOF
            {
             before(grammarAccess.getSimpleInputRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleInput"


    // $ANTLR start "ruleSimpleInput"
    // InternalBot.g:487:1: ruleSimpleInput : ( ( rule__SimpleInput__Group__0 ) ) ;
    public final void ruleSimpleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:491:2: ( ( ( rule__SimpleInput__Group__0 ) ) )
            // InternalBot.g:492:2: ( ( rule__SimpleInput__Group__0 ) )
            {
            // InternalBot.g:492:2: ( ( rule__SimpleInput__Group__0 ) )
            // InternalBot.g:493:3: ( rule__SimpleInput__Group__0 )
            {
             before(grammarAccess.getSimpleInputAccess().getGroup()); 
            // InternalBot.g:494:3: ( rule__SimpleInput__Group__0 )
            // InternalBot.g:494:4: rule__SimpleInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleInput"


    // $ANTLR start "entryRuleCompositeInput"
    // InternalBot.g:503:1: entryRuleCompositeInput : ruleCompositeInput EOF ;
    public final void entryRuleCompositeInput() throws RecognitionException {
        try {
            // InternalBot.g:504:1: ( ruleCompositeInput EOF )
            // InternalBot.g:505:1: ruleCompositeInput EOF
            {
             before(grammarAccess.getCompositeInputRule()); 
            pushFollow(FOLLOW_1);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCompositeInput"


    // $ANTLR start "ruleCompositeInput"
    // InternalBot.g:512:1: ruleCompositeInput : ( ( rule__CompositeInput__Group__0 ) ) ;
    public final void ruleCompositeInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:516:2: ( ( ( rule__CompositeInput__Group__0 ) ) )
            // InternalBot.g:517:2: ( ( rule__CompositeInput__Group__0 ) )
            {
            // InternalBot.g:517:2: ( ( rule__CompositeInput__Group__0 ) )
            // InternalBot.g:518:3: ( rule__CompositeInput__Group__0 )
            {
             before(grammarAccess.getCompositeInputAccess().getGroup()); 
            // InternalBot.g:519:3: ( rule__CompositeInput__Group__0 )
            // InternalBot.g:519:4: rule__CompositeInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompositeInput"


    // $ANTLR start "entryRuleText"
    // InternalBot.g:528:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // InternalBot.g:529:1: ( ruleText EOF )
            // InternalBot.g:530:1: ruleText EOF
            {
             before(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            ruleText();

            state._fsp--;

             after(grammarAccess.getTextRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalBot.g:537:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:541:2: ( ( ( rule__Text__Group__0 ) ) )
            // InternalBot.g:542:2: ( ( rule__Text__Group__0 ) )
            {
            // InternalBot.g:542:2: ( ( rule__Text__Group__0 ) )
            // InternalBot.g:543:3: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // InternalBot.g:544:3: ( rule__Text__Group__0 )
            // InternalBot.g:544:4: rule__Text__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:553:1: entryRuleHTTPResponse : ruleHTTPResponse EOF ;
    public final void entryRuleHTTPResponse() throws RecognitionException {
        try {
            // InternalBot.g:554:1: ( ruleHTTPResponse EOF )
            // InternalBot.g:555:1: ruleHTTPResponse EOF
            {
             before(grammarAccess.getHTTPResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleHTTPResponse();

            state._fsp--;

             after(grammarAccess.getHTTPResponseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHTTPResponse"


    // $ANTLR start "ruleHTTPResponse"
    // InternalBot.g:562:1: ruleHTTPResponse : ( ( rule__HTTPResponse__Group__0 ) ) ;
    public final void ruleHTTPResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:566:2: ( ( ( rule__HTTPResponse__Group__0 ) ) )
            // InternalBot.g:567:2: ( ( rule__HTTPResponse__Group__0 ) )
            {
            // InternalBot.g:567:2: ( ( rule__HTTPResponse__Group__0 ) )
            // InternalBot.g:568:3: ( rule__HTTPResponse__Group__0 )
            {
             before(grammarAccess.getHTTPResponseAccess().getGroup()); 
            // InternalBot.g:569:3: ( rule__HTTPResponse__Group__0 )
            // InternalBot.g:569:4: rule__HTTPResponse__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPResponse"


    // $ANTLR start "entryRuleHTTPRequest"
    // InternalBot.g:578:1: entryRuleHTTPRequest : ruleHTTPRequest EOF ;
    public final void entryRuleHTTPRequest() throws RecognitionException {
        try {
            // InternalBot.g:579:1: ( ruleHTTPRequest EOF )
            // InternalBot.g:580:1: ruleHTTPRequest EOF
            {
             before(grammarAccess.getHTTPRequestRule()); 
            pushFollow(FOLLOW_1);
            ruleHTTPRequest();

            state._fsp--;

             after(grammarAccess.getHTTPRequestRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHTTPRequest"


    // $ANTLR start "ruleHTTPRequest"
    // InternalBot.g:587:1: ruleHTTPRequest : ( ( rule__HTTPRequest__Group__0 ) ) ;
    public final void ruleHTTPRequest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:591:2: ( ( ( rule__HTTPRequest__Group__0 ) ) )
            // InternalBot.g:592:2: ( ( rule__HTTPRequest__Group__0 ) )
            {
            // InternalBot.g:592:2: ( ( rule__HTTPRequest__Group__0 ) )
            // InternalBot.g:593:3: ( rule__HTTPRequest__Group__0 )
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup()); 
            // InternalBot.g:594:3: ( rule__HTTPRequest__Group__0 )
            // InternalBot.g:594:4: rule__HTTPRequest__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPRequest"


    // $ANTLR start "entryRuleImage"
    // InternalBot.g:603:1: entryRuleImage : ruleImage EOF ;
    public final void entryRuleImage() throws RecognitionException {
        try {
            // InternalBot.g:604:1: ( ruleImage EOF )
            // InternalBot.g:605:1: ruleImage EOF
            {
             before(grammarAccess.getImageRule()); 
            pushFollow(FOLLOW_1);
            ruleImage();

            state._fsp--;

             after(grammarAccess.getImageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImage"


    // $ANTLR start "ruleImage"
    // InternalBot.g:612:1: ruleImage : ( ( rule__Image__Group__0 ) ) ;
    public final void ruleImage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:616:2: ( ( ( rule__Image__Group__0 ) ) )
            // InternalBot.g:617:2: ( ( rule__Image__Group__0 ) )
            {
            // InternalBot.g:617:2: ( ( rule__Image__Group__0 ) )
            // InternalBot.g:618:3: ( rule__Image__Group__0 )
            {
             before(grammarAccess.getImageAccess().getGroup()); 
            // InternalBot.g:619:3: ( rule__Image__Group__0 )
            // InternalBot.g:619:4: rule__Image__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Image__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImage"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:628:1: entryRuleTextInputHttpResponse : ruleTextInputHttpResponse EOF ;
    public final void entryRuleTextInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:629:1: ( ruleTextInputHttpResponse EOF )
            // InternalBot.g:630:1: ruleTextInputHttpResponse EOF
            {
             before(grammarAccess.getTextInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextInputHttpResponseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextInputHttpResponse"


    // $ANTLR start "ruleTextInputHttpResponse"
    // InternalBot.g:637:1: ruleTextInputHttpResponse : ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) ;
    public final void ruleTextInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:641:2: ( ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) )
            // InternalBot.g:642:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            {
            // InternalBot.g:642:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            // InternalBot.g:643:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            {
            // InternalBot.g:643:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) )
            // InternalBot.g:644:4: ( rule__TextInputHttpResponse__TokensAssignment )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:645:4: ( rule__TextInputHttpResponse__TokensAssignment )
            // InternalBot.g:645:5: rule__TextInputHttpResponse__TokensAssignment
            {
            pushFollow(FOLLOW_3);
            rule__TextInputHttpResponse__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }

            // InternalBot.g:648:3: ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            // InternalBot.g:649:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:650:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==64||LA1_0==67) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:650:5: rule__TextInputHttpResponse__TokensAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__TextInputHttpResponse__TokensAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextInputHttpResponse"


    // $ANTLR start "entryRuleTextInputText"
    // InternalBot.g:660:1: entryRuleTextInputText : ruleTextInputText EOF ;
    public final void entryRuleTextInputText() throws RecognitionException {
        try {
            // InternalBot.g:661:1: ( ruleTextInputText EOF )
            // InternalBot.g:662:1: ruleTextInputText EOF
            {
             before(grammarAccess.getTextInputTextRule()); 
            pushFollow(FOLLOW_1);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextInputTextRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextInputText"


    // $ANTLR start "ruleTextInputText"
    // InternalBot.g:669:1: ruleTextInputText : ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) ;
    public final void ruleTextInputText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:673:2: ( ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) )
            // InternalBot.g:674:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            {
            // InternalBot.g:674:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            // InternalBot.g:675:3: ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* )
            {
            // InternalBot.g:675:3: ( ( rule__TextInputText__TokensAssignment ) )
            // InternalBot.g:676:4: ( rule__TextInputText__TokensAssignment )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:677:4: ( rule__TextInputText__TokensAssignment )
            // InternalBot.g:677:5: rule__TextInputText__TokensAssignment
            {
            pushFollow(FOLLOW_4);
            rule__TextInputText__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }

            // InternalBot.g:680:3: ( ( rule__TextInputText__TokensAssignment )* )
            // InternalBot.g:681:4: ( rule__TextInputText__TokensAssignment )*
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:682:4: ( rule__TextInputText__TokensAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==64) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:682:5: rule__TextInputText__TokensAssignment
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__TextInputText__TokensAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextInputText"


    // $ANTLR start "entryRuleKeyValue"
    // InternalBot.g:692:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBot.g:693:1: ( ruleKeyValue EOF )
            // InternalBot.g:694:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_1);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // InternalBot.g:701:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:705:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBot.g:706:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBot.g:706:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBot.g:707:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBot.g:708:3: ( rule__KeyValue__Group__0 )
            // InternalBot.g:708:4: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleData"
    // InternalBot.g:717:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalBot.g:718:1: ( ruleData EOF )
            // InternalBot.g:719:1: ruleData EOF
            {
             before(grammarAccess.getDataRule()); 
            pushFollow(FOLLOW_1);
            ruleData();

            state._fsp--;

             after(grammarAccess.getDataRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalBot.g:726:1: ruleData : ( ( rule__Data__Group__0 ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:730:2: ( ( ( rule__Data__Group__0 ) ) )
            // InternalBot.g:731:2: ( ( rule__Data__Group__0 ) )
            {
            // InternalBot.g:731:2: ( ( rule__Data__Group__0 ) )
            // InternalBot.g:732:3: ( rule__Data__Group__0 )
            {
             before(grammarAccess.getDataAccess().getGroup()); 
            // InternalBot.g:733:3: ( rule__Data__Group__0 )
            // InternalBot.g:733:4: rule__Data__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Data__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleData"


    // $ANTLR start "ruleDefaultEntity"
    // InternalBot.g:742:1: ruleDefaultEntity : ( ( rule__DefaultEntity__Alternatives ) ) ;
    public final void ruleDefaultEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:746:1: ( ( ( rule__DefaultEntity__Alternatives ) ) )
            // InternalBot.g:747:2: ( ( rule__DefaultEntity__Alternatives ) )
            {
            // InternalBot.g:747:2: ( ( rule__DefaultEntity__Alternatives ) )
            // InternalBot.g:748:3: ( rule__DefaultEntity__Alternatives )
            {
             before(grammarAccess.getDefaultEntityAccess().getAlternatives()); 
            // InternalBot.g:749:3: ( rule__DefaultEntity__Alternatives )
            // InternalBot.g:749:4: rule__DefaultEntity__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DefaultEntity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDefaultEntityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefaultEntity"


    // $ANTLR start "ruleHTTPReturnType"
    // InternalBot.g:758:1: ruleHTTPReturnType : ( ( rule__HTTPReturnType__Alternatives ) ) ;
    public final void ruleHTTPReturnType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:762:1: ( ( ( rule__HTTPReturnType__Alternatives ) ) )
            // InternalBot.g:763:2: ( ( rule__HTTPReturnType__Alternatives ) )
            {
            // InternalBot.g:763:2: ( ( rule__HTTPReturnType__Alternatives ) )
            // InternalBot.g:764:3: ( rule__HTTPReturnType__Alternatives )
            {
             before(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 
            // InternalBot.g:765:3: ( rule__HTTPReturnType__Alternatives )
            // InternalBot.g:765:4: rule__HTTPReturnType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__HTTPReturnType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPReturnType"


    // $ANTLR start "ruleLanguage"
    // InternalBot.g:774:1: ruleLanguage : ( ( rule__Language__Alternatives ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:778:1: ( ( ( rule__Language__Alternatives ) ) )
            // InternalBot.g:779:2: ( ( rule__Language__Alternatives ) )
            {
            // InternalBot.g:779:2: ( ( rule__Language__Alternatives ) )
            // InternalBot.g:780:3: ( rule__Language__Alternatives )
            {
             before(grammarAccess.getLanguageAccess().getAlternatives()); 
            // InternalBot.g:781:3: ( rule__Language__Alternatives )
            // InternalBot.g:781:4: rule__Language__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Language__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLanguageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguage"


    // $ANTLR start "ruleDataType"
    // InternalBot.g:790:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:794:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalBot.g:795:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalBot.g:795:2: ( ( rule__DataType__Alternatives ) )
            // InternalBot.g:796:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalBot.g:797:3: ( rule__DataType__Alternatives )
            // InternalBot.g:797:4: rule__DataType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleMethod"
    // InternalBot.g:806:1: ruleMethod : ( ( rule__Method__Alternatives ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:810:1: ( ( ( rule__Method__Alternatives ) ) )
            // InternalBot.g:811:2: ( ( rule__Method__Alternatives ) )
            {
            // InternalBot.g:811:2: ( ( rule__Method__Alternatives ) )
            // InternalBot.g:812:3: ( rule__Method__Alternatives )
            {
             before(grammarAccess.getMethodAccess().getAlternatives()); 
            // InternalBot.g:813:3: ( rule__Method__Alternatives )
            // InternalBot.g:813:4: rule__Method__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Method__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMethodAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "rule__Entity__Alternatives"
    // InternalBot.g:821:1: rule__Entity__Alternatives : ( ( ruleSimple ) | ( ruleComposite ) );
    public final void rule__Entity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:825:1: ( ( ruleSimple ) | ( ruleComposite ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==69) ) {
                alt3=1;
            }
            else if ( (LA3_0==70) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBot.g:826:2: ( ruleSimple )
                    {
                    // InternalBot.g:826:2: ( ruleSimple )
                    // InternalBot.g:827:3: ruleSimple
                    {
                     before(grammarAccess.getEntityAccess().getSimpleParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSimple();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getSimpleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:832:2: ( ruleComposite )
                    {
                    // InternalBot.g:832:2: ( ruleComposite )
                    // InternalBot.g:833:3: ruleComposite
                    {
                     before(grammarAccess.getEntityAccess().getCompositeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleComposite();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getCompositeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Alternatives"


    // $ANTLR start "rule__Action__Alternatives"
    // InternalBot.g:842:1: rule__Action__Alternatives : ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:846:1: ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 76:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 74:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalBot.g:847:2: ( ruleText )
                    {
                    // InternalBot.g:847:2: ( ruleText )
                    // InternalBot.g:848:3: ruleText
                    {
                     before(grammarAccess.getActionAccess().getTextParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleText();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getTextParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:853:2: ( ruleHTTPRequest )
                    {
                    // InternalBot.g:853:2: ( ruleHTTPRequest )
                    // InternalBot.g:854:3: ruleHTTPRequest
                    {
                     before(grammarAccess.getActionAccess().getHTTPRequestParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPRequest();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getHTTPRequestParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:859:2: ( ruleImage )
                    {
                    // InternalBot.g:859:2: ( ruleImage )
                    // InternalBot.g:860:3: ruleImage
                    {
                     before(grammarAccess.getActionAccess().getImageParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleImage();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getImageParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:865:2: ( ruleHTTPResponse )
                    {
                    // InternalBot.g:865:2: ( ruleHTTPResponse )
                    // InternalBot.g:866:3: ruleHTTPResponse
                    {
                     before(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPResponse();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalBot.g:875:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:879:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBot.g:880:2: ( RULE_STRING )
                    {
                    // InternalBot.g:880:2: ( RULE_STRING )
                    // InternalBot.g:881:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:886:2: ( RULE_ID )
                    {
                    // InternalBot.g:886:2: ( RULE_ID )
                    // InternalBot.g:887:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Transition__TargetAlternatives_2_1_0"
    // InternalBot.g:896:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );
    public final void rule__Transition__TargetAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:900:1: ( ( ruleState ) | ( ruleState2 ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBot.g:901:2: ( ruleState )
                    {
                    // InternalBot.g:901:2: ( ruleState )
                    // InternalBot.g:902:3: ruleState
                    {
                     before(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_2_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleState();

                    state._fsp--;

                     after(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:907:2: ( ruleState2 )
                    {
                    // InternalBot.g:907:2: ( ruleState2 )
                    // InternalBot.g:908:3: ruleState2
                    {
                     before(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_2_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleState2();

                    state._fsp--;

                     after(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_2_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__TargetAlternatives_2_1_0"


    // $ANTLR start "rule__TrainingPhrase__TokensAlternatives_1_0"
    // InternalBot.g:917:1: rule__TrainingPhrase__TokensAlternatives_1_0 : ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) );
    public final void rule__TrainingPhrase__TokensAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:921:1: ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            else if ( (LA7_0==60) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBot.g:922:2: ( ruleLiteral )
                    {
                    // InternalBot.g:922:2: ( ruleLiteral )
                    // InternalBot.g:923:3: ruleLiteral
                    {
                     before(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:928:2: ( ruleParameterRefenceToken )
                    {
                    // InternalBot.g:928:2: ( ruleParameterRefenceToken )
                    // InternalBot.g:929:3: ruleParameterRefenceToken
                    {
                     before(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterRefenceToken();

                    state._fsp--;

                     after(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__TokensAlternatives_1_0"


    // $ANTLR start "rule__Parameter__Alternatives_3"
    // InternalBot.g:938:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:942:1: ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=11 && LA8_0<=15)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBot.g:943:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    {
                    // InternalBot.g:943:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    // InternalBot.g:944:3: ( rule__Parameter__EntityAssignment_3_0 )
                    {
                     before(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 
                    // InternalBot.g:945:3: ( rule__Parameter__EntityAssignment_3_0 )
                    // InternalBot.g:945:4: rule__Parameter__EntityAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__EntityAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:949:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    {
                    // InternalBot.g:949:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    // InternalBot.g:950:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    {
                     before(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 
                    // InternalBot.g:951:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    // InternalBot.g:951:4: rule__Parameter__DefaultEntityAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__DefaultEntityAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Alternatives_3"


    // $ANTLR start "rule__CompositeInput__TokensAlternatives_0_0"
    // InternalBot.g:959:1: rule__CompositeInput__TokensAlternatives_0_0 : ( ( ruleLiteral ) | ( ruleEntityToken ) );
    public final void rule__CompositeInput__TokensAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:963:1: ( ( ruleLiteral ) | ( ruleEntityToken ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                alt9=1;
            }
            else if ( (LA9_0==66) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBot.g:964:2: ( ruleLiteral )
                    {
                    // InternalBot.g:964:2: ( ruleLiteral )
                    // InternalBot.g:965:3: ruleLiteral
                    {
                     before(grammarAccess.getCompositeInputAccess().getTokensLiteralParserRuleCall_0_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getCompositeInputAccess().getTokensLiteralParserRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:970:2: ( ruleEntityToken )
                    {
                    // InternalBot.g:970:2: ( ruleEntityToken )
                    // InternalBot.g:971:3: ruleEntityToken
                    {
                     before(grammarAccess.getCompositeInputAccess().getTokensEntityTokenParserRuleCall_0_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEntityToken();

                    state._fsp--;

                     after(grammarAccess.getCompositeInputAccess().getTokensEntityTokenParserRuleCall_0_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__TokensAlternatives_0_0"


    // $ANTLR start "rule__TextInputHttpResponse__TokensAlternatives_0"
    // InternalBot.g:980:1: rule__TextInputHttpResponse__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) );
    public final void rule__TextInputHttpResponse__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:984:1: ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt10=1;
                }
                break;
            case 64:
                {
                alt10=2;
                }
                break;
            case 67:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBot.g:985:2: ( ruleLiteral )
                    {
                    // InternalBot.g:985:2: ( ruleLiteral )
                    // InternalBot.g:986:3: ruleLiteral
                    {
                     before(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:991:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:991:2: ( ruleParameterToken )
                    // InternalBot.g:992:3: ruleParameterToken
                    {
                     before(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterToken();

                    state._fsp--;

                     after(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:997:2: ( ruleHTTPRequestToken )
                    {
                    // InternalBot.g:997:2: ( ruleHTTPRequestToken )
                    // InternalBot.g:998:3: ruleHTTPRequestToken
                    {
                     before(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPRequestToken();

                    state._fsp--;

                     after(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputHttpResponse__TokensAlternatives_0"


    // $ANTLR start "rule__TextInputText__TokensAlternatives_0"
    // InternalBot.g:1007:1: rule__TextInputText__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__TextInputText__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1011:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                alt11=1;
            }
            else if ( (LA11_0==64) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:1012:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1012:2: ( ruleLiteral )
                    // InternalBot.g:1013:3: ruleLiteral
                    {
                     before(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1018:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1018:2: ( ruleParameterToken )
                    // InternalBot.g:1019:3: ruleParameterToken
                    {
                     before(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterToken();

                    state._fsp--;

                     after(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputText__TokensAlternatives_0"


    // $ANTLR start "rule__Data__ValueAlternatives_2_0"
    // InternalBot.g:1028:1: rule__Data__ValueAlternatives_2_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__Data__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1032:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                alt12=1;
            }
            else if ( (LA12_0==64) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBot.g:1033:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1033:2: ( ruleLiteral )
                    // InternalBot.g:1034:3: ruleLiteral
                    {
                     before(grammarAccess.getDataAccess().getValueLiteralParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getDataAccess().getValueLiteralParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1039:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1039:2: ( ruleParameterToken )
                    // InternalBot.g:1040:3: ruleParameterToken
                    {
                     before(grammarAccess.getDataAccess().getValueParameterTokenParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterToken();

                    state._fsp--;

                     after(grammarAccess.getDataAccess().getValueParameterTokenParserRuleCall_2_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__ValueAlternatives_2_0"


    // $ANTLR start "rule__DefaultEntity__Alternatives"
    // InternalBot.g:1049:1: rule__DefaultEntity__Alternatives : ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) );
    public final void rule__DefaultEntity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1053:1: ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt13=1;
                }
                break;
            case 12:
                {
                alt13=2;
                }
                break;
            case 13:
                {
                alt13=3;
                }
                break;
            case 14:
                {
                alt13=4;
                }
                break;
            case 15:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalBot.g:1054:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1054:2: ( ( 'text' ) )
                    // InternalBot.g:1055:3: ( 'text' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1056:3: ( 'text' )
                    // InternalBot.g:1056:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1060:2: ( ( 'number' ) )
                    {
                    // InternalBot.g:1060:2: ( ( 'number' ) )
                    // InternalBot.g:1061:3: ( 'number' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalBot.g:1062:3: ( 'number' )
                    // InternalBot.g:1062:4: 'number'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1066:2: ( ( 'date' ) )
                    {
                    // InternalBot.g:1066:2: ( ( 'date' ) )
                    // InternalBot.g:1067:3: ( 'date' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1068:3: ( 'date' )
                    // InternalBot.g:1068:4: 'date'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1072:2: ( ( 'float' ) )
                    {
                    // InternalBot.g:1072:2: ( ( 'float' ) )
                    // InternalBot.g:1073:3: ( 'float' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1074:3: ( 'float' )
                    // InternalBot.g:1074:4: 'float'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1078:2: ( ( 'time' ) )
                    {
                    // InternalBot.g:1078:2: ( ( 'time' ) )
                    // InternalBot.g:1079:3: ( 'time' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1080:3: ( 'time' )
                    // InternalBot.g:1080:4: 'time'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultEntity__Alternatives"


    // $ANTLR start "rule__HTTPReturnType__Alternatives"
    // InternalBot.g:1088:1: rule__HTTPReturnType__Alternatives : ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) );
    public final void rule__HTTPReturnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1092:1: ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt14=1;
                }
                break;
            case 16:
                {
                alt14=2;
                }
                break;
            case 17:
                {
                alt14=3;
                }
                break;
            case 18:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalBot.g:1093:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1093:2: ( ( 'text' ) )
                    // InternalBot.g:1094:3: ( 'text' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1095:3: ( 'text' )
                    // InternalBot.g:1095:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1099:2: ( ( 'status_code' ) )
                    {
                    // InternalBot.g:1099:2: ( ( 'status_code' ) )
                    // InternalBot.g:1100:3: ( 'status_code' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1101:3: ( 'status_code' )
                    // InternalBot.g:1101:4: 'status_code'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1105:2: ( ( 'image' ) )
                    {
                    // InternalBot.g:1105:2: ( ( 'image' ) )
                    // InternalBot.g:1106:3: ( 'image' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1107:3: ( 'image' )
                    // InternalBot.g:1107:4: 'image'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1111:2: ( ( 'data' ) )
                    {
                    // InternalBot.g:1111:2: ( ( 'data' ) )
                    // InternalBot.g:1112:3: ( 'data' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1113:3: ( 'data' )
                    // InternalBot.g:1113:4: 'data'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPReturnType__Alternatives"


    // $ANTLR start "rule__Language__Alternatives"
    // InternalBot.g:1121:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1125:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) )
            int alt15=20;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt15=1;
                }
                break;
            case 20:
                {
                alt15=2;
                }
                break;
            case 21:
                {
                alt15=3;
                }
                break;
            case 22:
                {
                alt15=4;
                }
                break;
            case 23:
                {
                alt15=5;
                }
                break;
            case 24:
                {
                alt15=6;
                }
                break;
            case 25:
                {
                alt15=7;
                }
                break;
            case 26:
                {
                alt15=8;
                }
                break;
            case 27:
                {
                alt15=9;
                }
                break;
            case 28:
                {
                alt15=10;
                }
                break;
            case 29:
                {
                alt15=11;
                }
                break;
            case 30:
                {
                alt15=12;
                }
                break;
            case 31:
                {
                alt15=13;
                }
                break;
            case 32:
                {
                alt15=14;
                }
                break;
            case 33:
                {
                alt15=15;
                }
                break;
            case 34:
                {
                alt15=16;
                }
                break;
            case 35:
                {
                alt15=17;
                }
                break;
            case 36:
                {
                alt15=18;
                }
                break;
            case 37:
                {
                alt15=19;
                }
                break;
            case 38:
                {
                alt15=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalBot.g:1126:2: ( ( 'en' ) )
                    {
                    // InternalBot.g:1126:2: ( ( 'en' ) )
                    // InternalBot.g:1127:3: ( 'en' )
                    {
                     before(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1128:3: ( 'en' )
                    // InternalBot.g:1128:4: 'en'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1132:2: ( ( 'es' ) )
                    {
                    // InternalBot.g:1132:2: ( ( 'es' ) )
                    // InternalBot.g:1133:3: ( 'es' )
                    {
                     before(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1134:3: ( 'es' )
                    // InternalBot.g:1134:4: 'es'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1138:2: ( ( 'da' ) )
                    {
                    // InternalBot.g:1138:2: ( ( 'da' ) )
                    // InternalBot.g:1139:3: ( 'da' )
                    {
                     before(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1140:3: ( 'da' )
                    // InternalBot.g:1140:4: 'da'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1144:2: ( ( 'de' ) )
                    {
                    // InternalBot.g:1144:2: ( ( 'de' ) )
                    // InternalBot.g:1145:3: ( 'de' )
                    {
                     before(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1146:3: ( 'de' )
                    // InternalBot.g:1146:4: 'de'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1150:2: ( ( 'fr' ) )
                    {
                    // InternalBot.g:1150:2: ( ( 'fr' ) )
                    // InternalBot.g:1151:3: ( 'fr' )
                    {
                     before(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1152:3: ( 'fr' )
                    // InternalBot.g:1152:4: 'fr'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1156:2: ( ( 'hi' ) )
                    {
                    // InternalBot.g:1156:2: ( ( 'hi' ) )
                    // InternalBot.g:1157:3: ( 'hi' )
                    {
                     before(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 
                    // InternalBot.g:1158:3: ( 'hi' )
                    // InternalBot.g:1158:4: 'hi'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:1162:2: ( ( 'id' ) )
                    {
                    // InternalBot.g:1162:2: ( ( 'id' ) )
                    // InternalBot.g:1163:3: ( 'id' )
                    {
                     before(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 
                    // InternalBot.g:1164:3: ( 'id' )
                    // InternalBot.g:1164:4: 'id'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:1168:2: ( ( 'it' ) )
                    {
                    // InternalBot.g:1168:2: ( ( 'it' ) )
                    // InternalBot.g:1169:3: ( 'it' )
                    {
                     before(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 
                    // InternalBot.g:1170:3: ( 'it' )
                    // InternalBot.g:1170:4: 'it'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:1174:2: ( ( 'ja' ) )
                    {
                    // InternalBot.g:1174:2: ( ( 'ja' ) )
                    // InternalBot.g:1175:3: ( 'ja' )
                    {
                     before(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 
                    // InternalBot.g:1176:3: ( 'ja' )
                    // InternalBot.g:1176:4: 'ja'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:1180:2: ( ( 'ko' ) )
                    {
                    // InternalBot.g:1180:2: ( ( 'ko' ) )
                    // InternalBot.g:1181:3: ( 'ko' )
                    {
                     before(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 
                    // InternalBot.g:1182:3: ( 'ko' )
                    // InternalBot.g:1182:4: 'ko'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:1186:2: ( ( 'nl' ) )
                    {
                    // InternalBot.g:1186:2: ( ( 'nl' ) )
                    // InternalBot.g:1187:3: ( 'nl' )
                    {
                     before(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 
                    // InternalBot.g:1188:3: ( 'nl' )
                    // InternalBot.g:1188:4: 'nl'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:1192:2: ( ( 'no' ) )
                    {
                    // InternalBot.g:1192:2: ( ( 'no' ) )
                    // InternalBot.g:1193:3: ( 'no' )
                    {
                     before(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 
                    // InternalBot.g:1194:3: ( 'no' )
                    // InternalBot.g:1194:4: 'no'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:1198:2: ( ( 'pl' ) )
                    {
                    // InternalBot.g:1198:2: ( ( 'pl' ) )
                    // InternalBot.g:1199:3: ( 'pl' )
                    {
                     before(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 
                    // InternalBot.g:1200:3: ( 'pl' )
                    // InternalBot.g:1200:4: 'pl'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:1204:2: ( ( 'pt' ) )
                    {
                    // InternalBot.g:1204:2: ( ( 'pt' ) )
                    // InternalBot.g:1205:3: ( 'pt' )
                    {
                     before(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 
                    // InternalBot.g:1206:3: ( 'pt' )
                    // InternalBot.g:1206:4: 'pt'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:1210:2: ( ( 'ru' ) )
                    {
                    // InternalBot.g:1210:2: ( ( 'ru' ) )
                    // InternalBot.g:1211:3: ( 'ru' )
                    {
                     before(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 
                    // InternalBot.g:1212:3: ( 'ru' )
                    // InternalBot.g:1212:4: 'ru'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:1216:2: ( ( 'sv' ) )
                    {
                    // InternalBot.g:1216:2: ( ( 'sv' ) )
                    // InternalBot.g:1217:3: ( 'sv' )
                    {
                     before(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 
                    // InternalBot.g:1218:3: ( 'sv' )
                    // InternalBot.g:1218:4: 'sv'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:1222:2: ( ( 'th' ) )
                    {
                    // InternalBot.g:1222:2: ( ( 'th' ) )
                    // InternalBot.g:1223:3: ( 'th' )
                    {
                     before(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 
                    // InternalBot.g:1224:3: ( 'th' )
                    // InternalBot.g:1224:4: 'th'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:1228:2: ( ( 'tr' ) )
                    {
                    // InternalBot.g:1228:2: ( ( 'tr' ) )
                    // InternalBot.g:1229:3: ( 'tr' )
                    {
                     before(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 
                    // InternalBot.g:1230:3: ( 'tr' )
                    // InternalBot.g:1230:4: 'tr'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:1234:2: ( ( 'uk' ) )
                    {
                    // InternalBot.g:1234:2: ( ( 'uk' ) )
                    // InternalBot.g:1235:3: ( 'uk' )
                    {
                     before(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 
                    // InternalBot.g:1236:3: ( 'uk' )
                    // InternalBot.g:1236:4: 'uk'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:1240:2: ( ( 'zh' ) )
                    {
                    // InternalBot.g:1240:2: ( ( 'zh' ) )
                    // InternalBot.g:1241:3: ( 'zh' )
                    {
                     before(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 
                    // InternalBot.g:1242:3: ( 'zh' )
                    // InternalBot.g:1242:4: 'zh'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Alternatives"


    // $ANTLR start "rule__DataType__Alternatives"
    // InternalBot.g:1250:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1254:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==39) ) {
                alt16=1;
            }
            else if ( (LA16_0==40) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalBot.g:1255:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1255:2: ( ( 'JSON' ) )
                    // InternalBot.g:1256:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1257:3: ( 'JSON' )
                    // InternalBot.g:1257:4: 'JSON'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1261:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1261:2: ( ( 'FORM' ) )
                    // InternalBot.g:1262:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1263:3: ( 'FORM' )
                    // InternalBot.g:1263:4: 'FORM'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Alternatives"


    // $ANTLR start "rule__Method__Alternatives"
    // InternalBot.g:1271:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1275:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            else if ( (LA17_0==42) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalBot.g:1276:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1276:2: ( ( 'post' ) )
                    // InternalBot.g:1277:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1278:3: ( 'post' )
                    // InternalBot.g:1278:4: 'post'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1282:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1282:2: ( ( 'get' ) )
                    // InternalBot.g:1283:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1284:3: ( 'get' )
                    // InternalBot.g:1284:4: 'get'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Alternatives"


    // $ANTLR start "rule__Bot__Group__0"
    // InternalBot.g:1292:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1296:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1297:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Bot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__0"


    // $ANTLR start "rule__Bot__Group__0__Impl"
    // InternalBot.g:1304:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1308:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1309:1: ( 'Chatbot' )
            {
            // InternalBot.g:1309:1: ( 'Chatbot' )
            // InternalBot.g:1310:2: 'Chatbot'
            {
             before(grammarAccess.getBotAccess().getChatbotKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getChatbotKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__0__Impl"


    // $ANTLR start "rule__Bot__Group__1"
    // InternalBot.g:1319:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1323:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1324:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Bot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__1"


    // $ANTLR start "rule__Bot__Group__1__Impl"
    // InternalBot.g:1331:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1335:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1336:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1336:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1337:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1338:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1338:3: rule__Bot__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__1__Impl"


    // $ANTLR start "rule__Bot__Group__2"
    // InternalBot.g:1346:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1350:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1351:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Bot__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__2"


    // $ANTLR start "rule__Bot__Group__2__Impl"
    // InternalBot.g:1358:1: rule__Bot__Group__2__Impl : ( 'language:' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1362:1: ( ( 'language:' ) )
            // InternalBot.g:1363:1: ( 'language:' )
            {
            // InternalBot.g:1363:1: ( 'language:' )
            // InternalBot.g:1364:2: 'language:'
            {
             before(grammarAccess.getBotAccess().getLanguageKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getLanguageKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__2__Impl"


    // $ANTLR start "rule__Bot__Group__3"
    // InternalBot.g:1373:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1377:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1378:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Bot__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__3"


    // $ANTLR start "rule__Bot__Group__3__Impl"
    // InternalBot.g:1385:1: rule__Bot__Group__3__Impl : ( ( rule__Bot__LanguageAssignment_3 ) ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1389:1: ( ( ( rule__Bot__LanguageAssignment_3 ) ) )
            // InternalBot.g:1390:1: ( ( rule__Bot__LanguageAssignment_3 ) )
            {
            // InternalBot.g:1390:1: ( ( rule__Bot__LanguageAssignment_3 ) )
            // InternalBot.g:1391:2: ( rule__Bot__LanguageAssignment_3 )
            {
             before(grammarAccess.getBotAccess().getLanguageAssignment_3()); 
            // InternalBot.g:1392:2: ( rule__Bot__LanguageAssignment_3 )
            // InternalBot.g:1392:3: rule__Bot__LanguageAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguageAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguageAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__3__Impl"


    // $ANTLR start "rule__Bot__Group__4"
    // InternalBot.g:1400:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1404:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1405:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Bot__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__4"


    // $ANTLR start "rule__Bot__Group__4__Impl"
    // InternalBot.g:1412:1: rule__Bot__Group__4__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1416:1: ( ( 'intents' ) )
            // InternalBot.g:1417:1: ( 'intents' )
            {
            // InternalBot.g:1417:1: ( 'intents' )
            // InternalBot.g:1418:2: 'intents'
            {
             before(grammarAccess.getBotAccess().getIntentsKeyword_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getIntentsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__4__Impl"


    // $ANTLR start "rule__Bot__Group__5"
    // InternalBot.g:1427:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1431:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1432:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Bot__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__5"


    // $ANTLR start "rule__Bot__Group__5__Impl"
    // InternalBot.g:1439:1: rule__Bot__Group__5__Impl : ( ':' ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1443:1: ( ( ':' ) )
            // InternalBot.g:1444:1: ( ':' )
            {
            // InternalBot.g:1444:1: ( ':' )
            // InternalBot.g:1445:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_5()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__5__Impl"


    // $ANTLR start "rule__Bot__Group__6"
    // InternalBot.g:1454:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1458:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:1459:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__6"


    // $ANTLR start "rule__Bot__Group__6__Impl"
    // InternalBot.g:1466:1: rule__Bot__Group__6__Impl : ( ( rule__Bot__IntentsAssignment_6 ) ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1470:1: ( ( ( rule__Bot__IntentsAssignment_6 ) ) )
            // InternalBot.g:1471:1: ( ( rule__Bot__IntentsAssignment_6 ) )
            {
            // InternalBot.g:1471:1: ( ( rule__Bot__IntentsAssignment_6 ) )
            // InternalBot.g:1472:2: ( rule__Bot__IntentsAssignment_6 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_6()); 
            // InternalBot.g:1473:2: ( rule__Bot__IntentsAssignment_6 )
            // InternalBot.g:1473:3: rule__Bot__IntentsAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Bot__IntentsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getIntentsAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__6__Impl"


    // $ANTLR start "rule__Bot__Group__7"
    // InternalBot.g:1481:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1485:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:1486:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__7"


    // $ANTLR start "rule__Bot__Group__7__Impl"
    // InternalBot.g:1493:1: rule__Bot__Group__7__Impl : ( ( rule__Bot__IntentsAssignment_7 )* ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1497:1: ( ( ( rule__Bot__IntentsAssignment_7 )* ) )
            // InternalBot.g:1498:1: ( ( rule__Bot__IntentsAssignment_7 )* )
            {
            // InternalBot.g:1498:1: ( ( rule__Bot__IntentsAssignment_7 )* )
            // InternalBot.g:1499:2: ( rule__Bot__IntentsAssignment_7 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_7()); 
            // InternalBot.g:1500:2: ( rule__Bot__IntentsAssignment_7 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_ID)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBot.g:1500:3: rule__Bot__IntentsAssignment_7
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Bot__IntentsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getIntentsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__7__Impl"


    // $ANTLR start "rule__Bot__Group__8"
    // InternalBot.g:1508:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1512:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:1513:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__8"


    // $ANTLR start "rule__Bot__Group__8__Impl"
    // InternalBot.g:1520:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__Group_8__0 )? ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1524:1: ( ( ( rule__Bot__Group_8__0 )? ) )
            // InternalBot.g:1525:1: ( ( rule__Bot__Group_8__0 )? )
            {
            // InternalBot.g:1525:1: ( ( rule__Bot__Group_8__0 )? )
            // InternalBot.g:1526:2: ( rule__Bot__Group_8__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_8()); 
            // InternalBot.g:1527:2: ( rule__Bot__Group_8__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==48) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalBot.g:1527:3: rule__Bot__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Bot__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBotAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__8__Impl"


    // $ANTLR start "rule__Bot__Group__9"
    // InternalBot.g:1535:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1539:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:1540:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__9"


    // $ANTLR start "rule__Bot__Group__9__Impl"
    // InternalBot.g:1547:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__Group_9__0 )? ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1551:1: ( ( ( rule__Bot__Group_9__0 )? ) )
            // InternalBot.g:1552:1: ( ( rule__Bot__Group_9__0 )? )
            {
            // InternalBot.g:1552:1: ( ( rule__Bot__Group_9__0 )? )
            // InternalBot.g:1553:2: ( rule__Bot__Group_9__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_9()); 
            // InternalBot.g:1554:2: ( rule__Bot__Group_9__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==49) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:1554:3: rule__Bot__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Bot__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBotAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__9__Impl"


    // $ANTLR start "rule__Bot__Group__10"
    // InternalBot.g:1562:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1566:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:1567:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
            {
            pushFollow(FOLLOW_9);
            rule__Bot__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__10"


    // $ANTLR start "rule__Bot__Group__10__Impl"
    // InternalBot.g:1574:1: rule__Bot__Group__10__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1578:1: ( ( 'flows' ) )
            // InternalBot.g:1579:1: ( 'flows' )
            {
            // InternalBot.g:1579:1: ( 'flows' )
            // InternalBot.g:1580:2: 'flows'
            {
             before(grammarAccess.getBotAccess().getFlowsKeyword_10()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getFlowsKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__10__Impl"


    // $ANTLR start "rule__Bot__Group__11"
    // InternalBot.g:1589:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1593:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:1594:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
            {
            pushFollow(FOLLOW_12);
            rule__Bot__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__11"


    // $ANTLR start "rule__Bot__Group__11__Impl"
    // InternalBot.g:1601:1: rule__Bot__Group__11__Impl : ( ':' ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1605:1: ( ( ':' ) )
            // InternalBot.g:1606:1: ( ':' )
            {
            // InternalBot.g:1606:1: ( ':' )
            // InternalBot.g:1607:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_11()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__11__Impl"


    // $ANTLR start "rule__Bot__Group__12"
    // InternalBot.g:1616:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1620:1: ( rule__Bot__Group__12__Impl )
            // InternalBot.g:1621:2: rule__Bot__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__12"


    // $ANTLR start "rule__Bot__Group__12__Impl"
    // InternalBot.g:1627:1: rule__Bot__Group__12__Impl : ( ( ( rule__Bot__Group_12__0 ) ) ( ( rule__Bot__Group_12__0 )* ) ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1631:1: ( ( ( ( rule__Bot__Group_12__0 ) ) ( ( rule__Bot__Group_12__0 )* ) ) )
            // InternalBot.g:1632:1: ( ( ( rule__Bot__Group_12__0 ) ) ( ( rule__Bot__Group_12__0 )* ) )
            {
            // InternalBot.g:1632:1: ( ( ( rule__Bot__Group_12__0 ) ) ( ( rule__Bot__Group_12__0 )* ) )
            // InternalBot.g:1633:2: ( ( rule__Bot__Group_12__0 ) ) ( ( rule__Bot__Group_12__0 )* )
            {
            // InternalBot.g:1633:2: ( ( rule__Bot__Group_12__0 ) )
            // InternalBot.g:1634:3: ( rule__Bot__Group_12__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_12()); 
            // InternalBot.g:1635:3: ( rule__Bot__Group_12__0 )
            // InternalBot.g:1635:4: rule__Bot__Group_12__0
            {
            pushFollow(FOLLOW_13);
            rule__Bot__Group_12__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_12()); 

            }

            // InternalBot.g:1638:2: ( ( rule__Bot__Group_12__0 )* )
            // InternalBot.g:1639:3: ( rule__Bot__Group_12__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_12()); 
            // InternalBot.g:1640:3: ( rule__Bot__Group_12__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==50) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:1640:4: rule__Bot__Group_12__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Bot__Group_12__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_12()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__12__Impl"


    // $ANTLR start "rule__Bot__Group_8__0"
    // InternalBot.g:1650:1: rule__Bot__Group_8__0 : rule__Bot__Group_8__0__Impl rule__Bot__Group_8__1 ;
    public final void rule__Bot__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1654:1: ( rule__Bot__Group_8__0__Impl rule__Bot__Group_8__1 )
            // InternalBot.g:1655:2: rule__Bot__Group_8__0__Impl rule__Bot__Group_8__1
            {
            pushFollow(FOLLOW_9);
            rule__Bot__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__0"


    // $ANTLR start "rule__Bot__Group_8__0__Impl"
    // InternalBot.g:1662:1: rule__Bot__Group_8__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1666:1: ( ( 'entities' ) )
            // InternalBot.g:1667:1: ( 'entities' )
            {
            // InternalBot.g:1667:1: ( 'entities' )
            // InternalBot.g:1668:2: 'entities'
            {
             before(grammarAccess.getBotAccess().getEntitiesKeyword_8_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getEntitiesKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__0__Impl"


    // $ANTLR start "rule__Bot__Group_8__1"
    // InternalBot.g:1677:1: rule__Bot__Group_8__1 : rule__Bot__Group_8__1__Impl rule__Bot__Group_8__2 ;
    public final void rule__Bot__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1681:1: ( rule__Bot__Group_8__1__Impl rule__Bot__Group_8__2 )
            // InternalBot.g:1682:2: rule__Bot__Group_8__1__Impl rule__Bot__Group_8__2
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__1"


    // $ANTLR start "rule__Bot__Group_8__1__Impl"
    // InternalBot.g:1689:1: rule__Bot__Group_8__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1693:1: ( ( ':' ) )
            // InternalBot.g:1694:1: ( ':' )
            {
            // InternalBot.g:1694:1: ( ':' )
            // InternalBot.g:1695:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_8_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__1__Impl"


    // $ANTLR start "rule__Bot__Group_8__2"
    // InternalBot.g:1704:1: rule__Bot__Group_8__2 : rule__Bot__Group_8__2__Impl rule__Bot__Group_8__3 ;
    public final void rule__Bot__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1708:1: ( rule__Bot__Group_8__2__Impl rule__Bot__Group_8__3 )
            // InternalBot.g:1709:2: rule__Bot__Group_8__2__Impl rule__Bot__Group_8__3
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__2"


    // $ANTLR start "rule__Bot__Group_8__2__Impl"
    // InternalBot.g:1716:1: rule__Bot__Group_8__2__Impl : ( ( rule__Bot__EntitiesAssignment_8_2 ) ) ;
    public final void rule__Bot__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1720:1: ( ( ( rule__Bot__EntitiesAssignment_8_2 ) ) )
            // InternalBot.g:1721:1: ( ( rule__Bot__EntitiesAssignment_8_2 ) )
            {
            // InternalBot.g:1721:1: ( ( rule__Bot__EntitiesAssignment_8_2 ) )
            // InternalBot.g:1722:2: ( rule__Bot__EntitiesAssignment_8_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_8_2()); 
            // InternalBot.g:1723:2: ( rule__Bot__EntitiesAssignment_8_2 )
            // InternalBot.g:1723:3: rule__Bot__EntitiesAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__EntitiesAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getEntitiesAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__2__Impl"


    // $ANTLR start "rule__Bot__Group_8__3"
    // InternalBot.g:1731:1: rule__Bot__Group_8__3 : rule__Bot__Group_8__3__Impl ;
    public final void rule__Bot__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1735:1: ( rule__Bot__Group_8__3__Impl )
            // InternalBot.g:1736:2: rule__Bot__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__3"


    // $ANTLR start "rule__Bot__Group_8__3__Impl"
    // InternalBot.g:1742:1: rule__Bot__Group_8__3__Impl : ( ( rule__Bot__EntitiesAssignment_8_3 )* ) ;
    public final void rule__Bot__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1746:1: ( ( ( rule__Bot__EntitiesAssignment_8_3 )* ) )
            // InternalBot.g:1747:1: ( ( rule__Bot__EntitiesAssignment_8_3 )* )
            {
            // InternalBot.g:1747:1: ( ( rule__Bot__EntitiesAssignment_8_3 )* )
            // InternalBot.g:1748:2: ( rule__Bot__EntitiesAssignment_8_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_8_3()); 
            // InternalBot.g:1749:2: ( rule__Bot__EntitiesAssignment_8_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=69 && LA22_0<=70)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBot.g:1749:3: rule__Bot__EntitiesAssignment_8_3
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Bot__EntitiesAssignment_8_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getEntitiesAssignment_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_8__3__Impl"


    // $ANTLR start "rule__Bot__Group_9__0"
    // InternalBot.g:1758:1: rule__Bot__Group_9__0 : rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 ;
    public final void rule__Bot__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1762:1: ( rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 )
            // InternalBot.g:1763:2: rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1
            {
            pushFollow(FOLLOW_9);
            rule__Bot__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__0"


    // $ANTLR start "rule__Bot__Group_9__0__Impl"
    // InternalBot.g:1770:1: rule__Bot__Group_9__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1774:1: ( ( 'actions' ) )
            // InternalBot.g:1775:1: ( 'actions' )
            {
            // InternalBot.g:1775:1: ( 'actions' )
            // InternalBot.g:1776:2: 'actions'
            {
             before(grammarAccess.getBotAccess().getActionsKeyword_9_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getActionsKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__0__Impl"


    // $ANTLR start "rule__Bot__Group_9__1"
    // InternalBot.g:1785:1: rule__Bot__Group_9__1 : rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 ;
    public final void rule__Bot__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1789:1: ( rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 )
            // InternalBot.g:1790:2: rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2
            {
            pushFollow(FOLLOW_16);
            rule__Bot__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__1"


    // $ANTLR start "rule__Bot__Group_9__1__Impl"
    // InternalBot.g:1797:1: rule__Bot__Group_9__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1801:1: ( ( ':' ) )
            // InternalBot.g:1802:1: ( ':' )
            {
            // InternalBot.g:1802:1: ( ':' )
            // InternalBot.g:1803:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_9_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__1__Impl"


    // $ANTLR start "rule__Bot__Group_9__2"
    // InternalBot.g:1812:1: rule__Bot__Group_9__2 : rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 ;
    public final void rule__Bot__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1816:1: ( rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 )
            // InternalBot.g:1817:2: rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3
            {
            pushFollow(FOLLOW_16);
            rule__Bot__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__2"


    // $ANTLR start "rule__Bot__Group_9__2__Impl"
    // InternalBot.g:1824:1: rule__Bot__Group_9__2__Impl : ( ( rule__Bot__ActionsAssignment_9_2 ) ) ;
    public final void rule__Bot__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1828:1: ( ( ( rule__Bot__ActionsAssignment_9_2 ) ) )
            // InternalBot.g:1829:1: ( ( rule__Bot__ActionsAssignment_9_2 ) )
            {
            // InternalBot.g:1829:1: ( ( rule__Bot__ActionsAssignment_9_2 ) )
            // InternalBot.g:1830:2: ( rule__Bot__ActionsAssignment_9_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_9_2()); 
            // InternalBot.g:1831:2: ( rule__Bot__ActionsAssignment_9_2 )
            // InternalBot.g:1831:3: rule__Bot__ActionsAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__ActionsAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getActionsAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__2__Impl"


    // $ANTLR start "rule__Bot__Group_9__3"
    // InternalBot.g:1839:1: rule__Bot__Group_9__3 : rule__Bot__Group_9__3__Impl ;
    public final void rule__Bot__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1843:1: ( rule__Bot__Group_9__3__Impl )
            // InternalBot.g:1844:2: rule__Bot__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__3"


    // $ANTLR start "rule__Bot__Group_9__3__Impl"
    // InternalBot.g:1850:1: rule__Bot__Group_9__3__Impl : ( ( rule__Bot__ActionsAssignment_9_3 )* ) ;
    public final void rule__Bot__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1854:1: ( ( ( rule__Bot__ActionsAssignment_9_3 )* ) )
            // InternalBot.g:1855:1: ( ( rule__Bot__ActionsAssignment_9_3 )* )
            {
            // InternalBot.g:1855:1: ( ( rule__Bot__ActionsAssignment_9_3 )* )
            // InternalBot.g:1856:2: ( rule__Bot__ActionsAssignment_9_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_9_3()); 
            // InternalBot.g:1857:2: ( rule__Bot__ActionsAssignment_9_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==11||LA23_0==17||LA23_0==74||LA23_0==76) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:1857:3: rule__Bot__ActionsAssignment_9_3
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Bot__ActionsAssignment_9_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getActionsAssignment_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__3__Impl"


    // $ANTLR start "rule__Bot__Group_12__0"
    // InternalBot.g:1866:1: rule__Bot__Group_12__0 : rule__Bot__Group_12__0__Impl rule__Bot__Group_12__1 ;
    public final void rule__Bot__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1870:1: ( rule__Bot__Group_12__0__Impl rule__Bot__Group_12__1 )
            // InternalBot.g:1871:2: rule__Bot__Group_12__0__Impl rule__Bot__Group_12__1
            {
            pushFollow(FOLLOW_18);
            rule__Bot__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_12__0"


    // $ANTLR start "rule__Bot__Group_12__0__Impl"
    // InternalBot.g:1878:1: rule__Bot__Group_12__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1882:1: ( ( '-' ) )
            // InternalBot.g:1883:1: ( '-' )
            {
            // InternalBot.g:1883:1: ( '-' )
            // InternalBot.g:1884:2: '-'
            {
             before(grammarAccess.getBotAccess().getHyphenMinusKeyword_12_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getHyphenMinusKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_12__0__Impl"


    // $ANTLR start "rule__Bot__Group_12__1"
    // InternalBot.g:1893:1: rule__Bot__Group_12__1 : rule__Bot__Group_12__1__Impl rule__Bot__Group_12__2 ;
    public final void rule__Bot__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1897:1: ( rule__Bot__Group_12__1__Impl rule__Bot__Group_12__2 )
            // InternalBot.g:1898:2: rule__Bot__Group_12__1__Impl rule__Bot__Group_12__2
            {
            pushFollow(FOLLOW_19);
            rule__Bot__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_12__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_12__1"


    // $ANTLR start "rule__Bot__Group_12__1__Impl"
    // InternalBot.g:1905:1: rule__Bot__Group_12__1__Impl : ( ( rule__Bot__FlowsAssignment_12_1 ) ) ;
    public final void rule__Bot__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1909:1: ( ( ( rule__Bot__FlowsAssignment_12_1 ) ) )
            // InternalBot.g:1910:1: ( ( rule__Bot__FlowsAssignment_12_1 ) )
            {
            // InternalBot.g:1910:1: ( ( rule__Bot__FlowsAssignment_12_1 ) )
            // InternalBot.g:1911:2: ( rule__Bot__FlowsAssignment_12_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_12_1()); 
            // InternalBot.g:1912:2: ( rule__Bot__FlowsAssignment_12_1 )
            // InternalBot.g:1912:3: rule__Bot__FlowsAssignment_12_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__FlowsAssignment_12_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getFlowsAssignment_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_12__1__Impl"


    // $ANTLR start "rule__Bot__Group_12__2"
    // InternalBot.g:1920:1: rule__Bot__Group_12__2 : rule__Bot__Group_12__2__Impl ;
    public final void rule__Bot__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1924:1: ( rule__Bot__Group_12__2__Impl )
            // InternalBot.g:1925:2: rule__Bot__Group_12__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_12__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_12__2"


    // $ANTLR start "rule__Bot__Group_12__2__Impl"
    // InternalBot.g:1931:1: rule__Bot__Group_12__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1935:1: ( ( ';' ) )
            // InternalBot.g:1936:1: ( ';' )
            {
            // InternalBot.g:1936:1: ( ';' )
            // InternalBot.g:1937:2: ';'
            {
             before(grammarAccess.getBotAccess().getSemicolonKeyword_12_2()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getSemicolonKeyword_12_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_12__2__Impl"


    // $ANTLR start "rule__Intent__Group__0"
    // InternalBot.g:1947:1: rule__Intent__Group__0 : rule__Intent__Group__0__Impl rule__Intent__Group__1 ;
    public final void rule__Intent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1951:1: ( rule__Intent__Group__0__Impl rule__Intent__Group__1 )
            // InternalBot.g:1952:2: rule__Intent__Group__0__Impl rule__Intent__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Intent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__0"


    // $ANTLR start "rule__Intent__Group__0__Impl"
    // InternalBot.g:1959:1: rule__Intent__Group__0__Impl : ( ( rule__Intent__NameAssignment_0 ) ) ;
    public final void rule__Intent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1963:1: ( ( ( rule__Intent__NameAssignment_0 ) ) )
            // InternalBot.g:1964:1: ( ( rule__Intent__NameAssignment_0 ) )
            {
            // InternalBot.g:1964:1: ( ( rule__Intent__NameAssignment_0 ) )
            // InternalBot.g:1965:2: ( rule__Intent__NameAssignment_0 )
            {
             before(grammarAccess.getIntentAccess().getNameAssignment_0()); 
            // InternalBot.g:1966:2: ( rule__Intent__NameAssignment_0 )
            // InternalBot.g:1966:3: rule__Intent__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Intent__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__0__Impl"


    // $ANTLR start "rule__Intent__Group__1"
    // InternalBot.g:1974:1: rule__Intent__Group__1 : rule__Intent__Group__1__Impl rule__Intent__Group__2 ;
    public final void rule__Intent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1978:1: ( rule__Intent__Group__1__Impl rule__Intent__Group__2 )
            // InternalBot.g:1979:2: rule__Intent__Group__1__Impl rule__Intent__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__Intent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__1"


    // $ANTLR start "rule__Intent__Group__1__Impl"
    // InternalBot.g:1986:1: rule__Intent__Group__1__Impl : ( ( rule__Intent__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1990:1: ( ( ( rule__Intent__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:1991:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:1991:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            // InternalBot.g:1992:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentAssignment_1()); 
            // InternalBot.g:1993:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==82) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBot.g:1993:3: rule__Intent__FallbackIntentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__FallbackIntentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getFallbackIntentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__1__Impl"


    // $ANTLR start "rule__Intent__Group__2"
    // InternalBot.g:2001:1: rule__Intent__Group__2 : rule__Intent__Group__2__Impl rule__Intent__Group__3 ;
    public final void rule__Intent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2005:1: ( rule__Intent__Group__2__Impl rule__Intent__Group__3 )
            // InternalBot.g:2006:2: rule__Intent__Group__2__Impl rule__Intent__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__Intent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__2"


    // $ANTLR start "rule__Intent__Group__2__Impl"
    // InternalBot.g:2013:1: rule__Intent__Group__2__Impl : ( '{' ) ;
    public final void rule__Intent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2017:1: ( ( '{' ) )
            // InternalBot.g:2018:1: ( '{' )
            {
            // InternalBot.g:2018:1: ( '{' )
            // InternalBot.g:2019:2: '{'
            {
             before(grammarAccess.getIntentAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__2__Impl"


    // $ANTLR start "rule__Intent__Group__3"
    // InternalBot.g:2028:1: rule__Intent__Group__3 : rule__Intent__Group__3__Impl rule__Intent__Group__4 ;
    public final void rule__Intent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2032:1: ( rule__Intent__Group__3__Impl rule__Intent__Group__4 )
            // InternalBot.g:2033:2: rule__Intent__Group__3__Impl rule__Intent__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Intent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__3"


    // $ANTLR start "rule__Intent__Group__3__Impl"
    // InternalBot.g:2040:1: rule__Intent__Group__3__Impl : ( 'inputs:' ) ;
    public final void rule__Intent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2044:1: ( ( 'inputs:' ) )
            // InternalBot.g:2045:1: ( 'inputs:' )
            {
            // InternalBot.g:2045:1: ( 'inputs:' )
            // InternalBot.g:2046:2: 'inputs:'
            {
             before(grammarAccess.getIntentAccess().getInputsKeyword_3()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getInputsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__3__Impl"


    // $ANTLR start "rule__Intent__Group__4"
    // InternalBot.g:2055:1: rule__Intent__Group__4 : rule__Intent__Group__4__Impl rule__Intent__Group__5 ;
    public final void rule__Intent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2059:1: ( rule__Intent__Group__4__Impl rule__Intent__Group__5 )
            // InternalBot.g:2060:2: rule__Intent__Group__4__Impl rule__Intent__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__Intent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__4"


    // $ANTLR start "rule__Intent__Group__4__Impl"
    // InternalBot.g:2067:1: rule__Intent__Group__4__Impl : ( ( rule__Intent__InputsAssignment_4 ) ) ;
    public final void rule__Intent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2071:1: ( ( ( rule__Intent__InputsAssignment_4 ) ) )
            // InternalBot.g:2072:1: ( ( rule__Intent__InputsAssignment_4 ) )
            {
            // InternalBot.g:2072:1: ( ( rule__Intent__InputsAssignment_4 ) )
            // InternalBot.g:2073:2: ( rule__Intent__InputsAssignment_4 )
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_4()); 
            // InternalBot.g:2074:2: ( rule__Intent__InputsAssignment_4 )
            // InternalBot.g:2074:3: rule__Intent__InputsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Intent__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getInputsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__4__Impl"


    // $ANTLR start "rule__Intent__Group__5"
    // InternalBot.g:2082:1: rule__Intent__Group__5 : rule__Intent__Group__5__Impl rule__Intent__Group__6 ;
    public final void rule__Intent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2086:1: ( rule__Intent__Group__5__Impl rule__Intent__Group__6 )
            // InternalBot.g:2087:2: rule__Intent__Group__5__Impl rule__Intent__Group__6
            {
            pushFollow(FOLLOW_23);
            rule__Intent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__5"


    // $ANTLR start "rule__Intent__Group__5__Impl"
    // InternalBot.g:2094:1: rule__Intent__Group__5__Impl : ( ( rule__Intent__Group_5__0 )* ) ;
    public final void rule__Intent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2098:1: ( ( ( rule__Intent__Group_5__0 )* ) )
            // InternalBot.g:2099:1: ( ( rule__Intent__Group_5__0 )* )
            {
            // InternalBot.g:2099:1: ( ( rule__Intent__Group_5__0 )* )
            // InternalBot.g:2100:2: ( rule__Intent__Group_5__0 )*
            {
             before(grammarAccess.getIntentAccess().getGroup_5()); 
            // InternalBot.g:2101:2: ( rule__Intent__Group_5__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==55) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBot.g:2101:3: rule__Intent__Group_5__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Intent__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__5__Impl"


    // $ANTLR start "rule__Intent__Group__6"
    // InternalBot.g:2109:1: rule__Intent__Group__6 : rule__Intent__Group__6__Impl rule__Intent__Group__7 ;
    public final void rule__Intent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2113:1: ( rule__Intent__Group__6__Impl rule__Intent__Group__7 )
            // InternalBot.g:2114:2: rule__Intent__Group__6__Impl rule__Intent__Group__7
            {
            pushFollow(FOLLOW_23);
            rule__Intent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__6"


    // $ANTLR start "rule__Intent__Group__6__Impl"
    // InternalBot.g:2121:1: rule__Intent__Group__6__Impl : ( ( rule__Intent__Group_6__0 )? ) ;
    public final void rule__Intent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2125:1: ( ( ( rule__Intent__Group_6__0 )? ) )
            // InternalBot.g:2126:1: ( ( rule__Intent__Group_6__0 )? )
            {
            // InternalBot.g:2126:1: ( ( rule__Intent__Group_6__0 )? )
            // InternalBot.g:2127:2: ( rule__Intent__Group_6__0 )?
            {
             before(grammarAccess.getIntentAccess().getGroup_6()); 
            // InternalBot.g:2128:2: ( rule__Intent__Group_6__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==56) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBot.g:2128:3: rule__Intent__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__6__Impl"


    // $ANTLR start "rule__Intent__Group__7"
    // InternalBot.g:2136:1: rule__Intent__Group__7 : rule__Intent__Group__7__Impl ;
    public final void rule__Intent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2140:1: ( rule__Intent__Group__7__Impl )
            // InternalBot.g:2141:2: rule__Intent__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__7"


    // $ANTLR start "rule__Intent__Group__7__Impl"
    // InternalBot.g:2147:1: rule__Intent__Group__7__Impl : ( '}' ) ;
    public final void rule__Intent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2151:1: ( ( '}' ) )
            // InternalBot.g:2152:1: ( '}' )
            {
            // InternalBot.g:2152:1: ( '}' )
            // InternalBot.g:2153:2: '}'
            {
             before(grammarAccess.getIntentAccess().getRightCurlyBracketKeyword_7()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__7__Impl"


    // $ANTLR start "rule__Intent__Group_5__0"
    // InternalBot.g:2163:1: rule__Intent__Group_5__0 : rule__Intent__Group_5__0__Impl rule__Intent__Group_5__1 ;
    public final void rule__Intent__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2167:1: ( rule__Intent__Group_5__0__Impl rule__Intent__Group_5__1 )
            // InternalBot.g:2168:2: rule__Intent__Group_5__0__Impl rule__Intent__Group_5__1
            {
            pushFollow(FOLLOW_22);
            rule__Intent__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_5__0"


    // $ANTLR start "rule__Intent__Group_5__0__Impl"
    // InternalBot.g:2175:1: rule__Intent__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Intent__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2179:1: ( ( ',' ) )
            // InternalBot.g:2180:1: ( ',' )
            {
            // InternalBot.g:2180:1: ( ',' )
            // InternalBot.g:2181:2: ','
            {
             before(grammarAccess.getIntentAccess().getCommaKeyword_5_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_5__0__Impl"


    // $ANTLR start "rule__Intent__Group_5__1"
    // InternalBot.g:2190:1: rule__Intent__Group_5__1 : rule__Intent__Group_5__1__Impl ;
    public final void rule__Intent__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2194:1: ( rule__Intent__Group_5__1__Impl )
            // InternalBot.g:2195:2: rule__Intent__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_5__1"


    // $ANTLR start "rule__Intent__Group_5__1__Impl"
    // InternalBot.g:2201:1: rule__Intent__Group_5__1__Impl : ( ( rule__Intent__InputsAssignment_5_1 ) ) ;
    public final void rule__Intent__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2205:1: ( ( ( rule__Intent__InputsAssignment_5_1 ) ) )
            // InternalBot.g:2206:1: ( ( rule__Intent__InputsAssignment_5_1 ) )
            {
            // InternalBot.g:2206:1: ( ( rule__Intent__InputsAssignment_5_1 ) )
            // InternalBot.g:2207:2: ( rule__Intent__InputsAssignment_5_1 )
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_5_1()); 
            // InternalBot.g:2208:2: ( rule__Intent__InputsAssignment_5_1 )
            // InternalBot.g:2208:3: rule__Intent__InputsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent__InputsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getInputsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_5__1__Impl"


    // $ANTLR start "rule__Intent__Group_6__0"
    // InternalBot.g:2217:1: rule__Intent__Group_6__0 : rule__Intent__Group_6__0__Impl rule__Intent__Group_6__1 ;
    public final void rule__Intent__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2221:1: ( rule__Intent__Group_6__0__Impl rule__Intent__Group_6__1 )
            // InternalBot.g:2222:2: rule__Intent__Group_6__0__Impl rule__Intent__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_6__0"


    // $ANTLR start "rule__Intent__Group_6__0__Impl"
    // InternalBot.g:2229:1: rule__Intent__Group_6__0__Impl : ( 'parameters:' ) ;
    public final void rule__Intent__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2233:1: ( ( 'parameters:' ) )
            // InternalBot.g:2234:1: ( 'parameters:' )
            {
            // InternalBot.g:2234:1: ( 'parameters:' )
            // InternalBot.g:2235:2: 'parameters:'
            {
             before(grammarAccess.getIntentAccess().getParametersKeyword_6_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getParametersKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_6__0__Impl"


    // $ANTLR start "rule__Intent__Group_6__1"
    // InternalBot.g:2244:1: rule__Intent__Group_6__1 : rule__Intent__Group_6__1__Impl rule__Intent__Group_6__2 ;
    public final void rule__Intent__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2248:1: ( rule__Intent__Group_6__1__Impl rule__Intent__Group_6__2 )
            // InternalBot.g:2249:2: rule__Intent__Group_6__1__Impl rule__Intent__Group_6__2
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_6__1"


    // $ANTLR start "rule__Intent__Group_6__1__Impl"
    // InternalBot.g:2256:1: rule__Intent__Group_6__1__Impl : ( ( rule__Intent__ParametersAssignment_6_1 ) ) ;
    public final void rule__Intent__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2260:1: ( ( ( rule__Intent__ParametersAssignment_6_1 ) ) )
            // InternalBot.g:2261:1: ( ( rule__Intent__ParametersAssignment_6_1 ) )
            {
            // InternalBot.g:2261:1: ( ( rule__Intent__ParametersAssignment_6_1 ) )
            // InternalBot.g:2262:2: ( rule__Intent__ParametersAssignment_6_1 )
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_6_1()); 
            // InternalBot.g:2263:2: ( rule__Intent__ParametersAssignment_6_1 )
            // InternalBot.g:2263:3: rule__Intent__ParametersAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent__ParametersAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getParametersAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_6__1__Impl"


    // $ANTLR start "rule__Intent__Group_6__2"
    // InternalBot.g:2271:1: rule__Intent__Group_6__2 : rule__Intent__Group_6__2__Impl ;
    public final void rule__Intent__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2275:1: ( rule__Intent__Group_6__2__Impl )
            // InternalBot.g:2276:2: rule__Intent__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_6__2"


    // $ANTLR start "rule__Intent__Group_6__2__Impl"
    // InternalBot.g:2282:1: rule__Intent__Group_6__2__Impl : ( ( rule__Intent__ParametersAssignment_6_2 )* ) ;
    public final void rule__Intent__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2286:1: ( ( ( rule__Intent__ParametersAssignment_6_2 )* ) )
            // InternalBot.g:2287:1: ( ( rule__Intent__ParametersAssignment_6_2 )* )
            {
            // InternalBot.g:2287:1: ( ( rule__Intent__ParametersAssignment_6_2 )* )
            // InternalBot.g:2288:2: ( rule__Intent__ParametersAssignment_6_2 )*
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_6_2()); 
            // InternalBot.g:2289:2: ( rule__Intent__ParametersAssignment_6_2 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_ID)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBot.g:2289:3: rule__Intent__ParametersAssignment_6_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Intent__ParametersAssignment_6_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getParametersAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_6__2__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalBot.g:2298:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2302:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:2303:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // InternalBot.g:2310:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2314:1: ( ( 'user' ) )
            // InternalBot.g:2315:1: ( 'user' )
            {
            // InternalBot.g:2315:1: ( 'user' )
            // InternalBot.g:2316:2: 'user'
            {
             before(grammarAccess.getTransitionAccess().getUserKeyword_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getUserKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // InternalBot.g:2325:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2329:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:2330:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // InternalBot.g:2337:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2341:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:2342:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:2342:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:2343:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:2344:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:2344:3: rule__Transition__IntentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__IntentAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // InternalBot.g:2352:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2356:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:2357:2: rule__Transition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // InternalBot.g:2363:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2367:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:2368:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:2368:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:2369:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:2370:2: ( rule__Transition__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==58) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBot.g:2370:3: rule__Transition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group_2__0"
    // InternalBot.g:2379:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2383:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:2384:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
            {
            pushFollow(FOLLOW_26);
            rule__Transition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0"


    // $ANTLR start "rule__Transition__Group_2__0__Impl"
    // InternalBot.g:2391:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2395:1: ( ( '=>' ) )
            // InternalBot.g:2396:1: ( '=>' )
            {
            // InternalBot.g:2396:1: ( '=>' )
            // InternalBot.g:2397:2: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0__Impl"


    // $ANTLR start "rule__Transition__Group_2__1"
    // InternalBot.g:2406:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2410:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:2411:2: rule__Transition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1"


    // $ANTLR start "rule__Transition__Group_2__1__Impl"
    // InternalBot.g:2417:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2421:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:2422:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:2422:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:2423:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:2424:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:2424:3: rule__Transition__TargetAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__TargetAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1__Impl"


    // $ANTLR start "rule__State__Group__0"
    // InternalBot.g:2433:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2437:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:2438:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // InternalBot.g:2445:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2449:1: ( ( 'chatbot' ) )
            // InternalBot.g:2450:1: ( 'chatbot' )
            {
            // InternalBot.g:2450:1: ( 'chatbot' )
            // InternalBot.g:2451:2: 'chatbot'
            {
             before(grammarAccess.getStateAccess().getChatbotKeyword_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getChatbotKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // InternalBot.g:2460:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2464:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:2465:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // InternalBot.g:2472:1: rule__State__Group__1__Impl : ( '(' ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2476:1: ( ( '(' ) )
            // InternalBot.g:2477:1: ( '(' )
            {
            // InternalBot.g:2477:1: ( '(' )
            // InternalBot.g:2478:2: '('
            {
             before(grammarAccess.getStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // InternalBot.g:2487:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2491:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:2492:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // InternalBot.g:2499:1: rule__State__Group__2__Impl : ( ( rule__State__ActionsAssignment_2 ) ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2503:1: ( ( ( rule__State__ActionsAssignment_2 ) ) )
            // InternalBot.g:2504:1: ( ( rule__State__ActionsAssignment_2 ) )
            {
            // InternalBot.g:2504:1: ( ( rule__State__ActionsAssignment_2 ) )
            // InternalBot.g:2505:2: ( rule__State__ActionsAssignment_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2()); 
            // InternalBot.g:2506:2: ( rule__State__ActionsAssignment_2 )
            // InternalBot.g:2506:3: rule__State__ActionsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__State__ActionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // InternalBot.g:2514:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2518:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // InternalBot.g:2519:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__State__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // InternalBot.g:2526:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2530:1: ( ( ( rule__State__Group_3__0 )* ) )
            // InternalBot.g:2531:1: ( ( rule__State__Group_3__0 )* )
            {
            // InternalBot.g:2531:1: ( ( rule__State__Group_3__0 )* )
            // InternalBot.g:2532:2: ( rule__State__Group_3__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:2533:2: ( rule__State__Group_3__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==55) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBot.g:2533:3: rule__State__Group_3__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__State__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group__4"
    // InternalBot.g:2541:1: rule__State__Group__4 : rule__State__Group__4__Impl rule__State__Group__5 ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2545:1: ( rule__State__Group__4__Impl rule__State__Group__5 )
            // InternalBot.g:2546:2: rule__State__Group__4__Impl rule__State__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__State__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4"


    // $ANTLR start "rule__State__Group__4__Impl"
    // InternalBot.g:2553:1: rule__State__Group__4__Impl : ( ')' ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2557:1: ( ( ')' ) )
            // InternalBot.g:2558:1: ( ')' )
            {
            // InternalBot.g:2558:1: ( ')' )
            // InternalBot.g:2559:2: ')'
            {
             before(grammarAccess.getStateAccess().getRightParenthesisKeyword_4()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__4__Impl"


    // $ANTLR start "rule__State__Group__5"
    // InternalBot.g:2568:1: rule__State__Group__5 : rule__State__Group__5__Impl ;
    public final void rule__State__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2572:1: ( rule__State__Group__5__Impl )
            // InternalBot.g:2573:2: rule__State__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__5"


    // $ANTLR start "rule__State__Group__5__Impl"
    // InternalBot.g:2579:1: rule__State__Group__5__Impl : ( ( rule__State__Group_5__0 )? ) ;
    public final void rule__State__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2583:1: ( ( ( rule__State__Group_5__0 )? ) )
            // InternalBot.g:2584:1: ( ( rule__State__Group_5__0 )? )
            {
            // InternalBot.g:2584:1: ( ( rule__State__Group_5__0 )? )
            // InternalBot.g:2585:2: ( rule__State__Group_5__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_5()); 
            // InternalBot.g:2586:2: ( rule__State__Group_5__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==58) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:2586:3: rule__State__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__5__Impl"


    // $ANTLR start "rule__State__Group_3__0"
    // InternalBot.g:2595:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2599:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:2600:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__State__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__0"


    // $ANTLR start "rule__State__Group_3__0__Impl"
    // InternalBot.g:2607:1: rule__State__Group_3__0__Impl : ( ',' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2611:1: ( ( ',' ) )
            // InternalBot.g:2612:1: ( ',' )
            {
            // InternalBot.g:2612:1: ( ',' )
            // InternalBot.g:2613:2: ','
            {
             before(grammarAccess.getStateAccess().getCommaKeyword_3_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__0__Impl"


    // $ANTLR start "rule__State__Group_3__1"
    // InternalBot.g:2622:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2626:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:2627:2: rule__State__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__1"


    // $ANTLR start "rule__State__Group_3__1__Impl"
    // InternalBot.g:2633:1: rule__State__Group_3__1__Impl : ( ( rule__State__ActionsAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2637:1: ( ( ( rule__State__ActionsAssignment_3_1 ) ) )
            // InternalBot.g:2638:1: ( ( rule__State__ActionsAssignment_3_1 ) )
            {
            // InternalBot.g:2638:1: ( ( rule__State__ActionsAssignment_3_1 ) )
            // InternalBot.g:2639:2: ( rule__State__ActionsAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_3_1()); 
            // InternalBot.g:2640:2: ( rule__State__ActionsAssignment_3_1 )
            // InternalBot.g:2640:3: rule__State__ActionsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__State__ActionsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__1__Impl"


    // $ANTLR start "rule__State__Group_5__0"
    // InternalBot.g:2649:1: rule__State__Group_5__0 : rule__State__Group_5__0__Impl rule__State__Group_5__1 ;
    public final void rule__State__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2653:1: ( rule__State__Group_5__0__Impl rule__State__Group_5__1 )
            // InternalBot.g:2654:2: rule__State__Group_5__0__Impl rule__State__Group_5__1
            {
            pushFollow(FOLLOW_18);
            rule__State__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__0"


    // $ANTLR start "rule__State__Group_5__0__Impl"
    // InternalBot.g:2661:1: rule__State__Group_5__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2665:1: ( ( '=>' ) )
            // InternalBot.g:2666:1: ( '=>' )
            {
            // InternalBot.g:2666:1: ( '=>' )
            // InternalBot.g:2667:2: '=>'
            {
             before(grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_5_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__0__Impl"


    // $ANTLR start "rule__State__Group_5__1"
    // InternalBot.g:2676:1: rule__State__Group_5__1 : rule__State__Group_5__1__Impl ;
    public final void rule__State__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2680:1: ( rule__State__Group_5__1__Impl )
            // InternalBot.g:2681:2: rule__State__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__1"


    // $ANTLR start "rule__State__Group_5__1__Impl"
    // InternalBot.g:2687:1: rule__State__Group_5__1__Impl : ( ( rule__State__OutcomingAssignment_5_1 ) ) ;
    public final void rule__State__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2691:1: ( ( ( rule__State__OutcomingAssignment_5_1 ) ) )
            // InternalBot.g:2692:1: ( ( rule__State__OutcomingAssignment_5_1 ) )
            {
            // InternalBot.g:2692:1: ( ( rule__State__OutcomingAssignment_5_1 ) )
            // InternalBot.g:2693:2: ( rule__State__OutcomingAssignment_5_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_5_1()); 
            // InternalBot.g:2694:2: ( rule__State__OutcomingAssignment_5_1 )
            // InternalBot.g:2694:3: rule__State__OutcomingAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__State__OutcomingAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getOutcomingAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_5__1__Impl"


    // $ANTLR start "rule__State2__Group__0"
    // InternalBot.g:2703:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2707:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:2708:2: rule__State2__Group__0__Impl rule__State2__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__State2__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__0"


    // $ANTLR start "rule__State2__Group__0__Impl"
    // InternalBot.g:2715:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2719:1: ( ( 'chatbot' ) )
            // InternalBot.g:2720:1: ( 'chatbot' )
            {
            // InternalBot.g:2720:1: ( 'chatbot' )
            // InternalBot.g:2721:2: 'chatbot'
            {
             before(grammarAccess.getState2Access().getChatbotKeyword_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getState2Access().getChatbotKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__0__Impl"


    // $ANTLR start "rule__State2__Group__1"
    // InternalBot.g:2730:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2734:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:2735:2: rule__State2__Group__1__Impl rule__State2__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__State2__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__1"


    // $ANTLR start "rule__State2__Group__1__Impl"
    // InternalBot.g:2742:1: rule__State2__Group__1__Impl : ( '(' ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2746:1: ( ( '(' ) )
            // InternalBot.g:2747:1: ( '(' )
            {
            // InternalBot.g:2747:1: ( '(' )
            // InternalBot.g:2748:2: '('
            {
             before(grammarAccess.getState2Access().getLeftParenthesisKeyword_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getState2Access().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__1__Impl"


    // $ANTLR start "rule__State2__Group__2"
    // InternalBot.g:2757:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2761:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:2762:2: rule__State2__Group__2__Impl rule__State2__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__State2__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__2"


    // $ANTLR start "rule__State2__Group__2__Impl"
    // InternalBot.g:2769:1: rule__State2__Group__2__Impl : ( ( rule__State2__ActionsAssignment_2 ) ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2773:1: ( ( ( rule__State2__ActionsAssignment_2 ) ) )
            // InternalBot.g:2774:1: ( ( rule__State2__ActionsAssignment_2 ) )
            {
            // InternalBot.g:2774:1: ( ( rule__State2__ActionsAssignment_2 ) )
            // InternalBot.g:2775:2: ( rule__State2__ActionsAssignment_2 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2()); 
            // InternalBot.g:2776:2: ( rule__State2__ActionsAssignment_2 )
            // InternalBot.g:2776:3: rule__State2__ActionsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__State2__ActionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getActionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__2__Impl"


    // $ANTLR start "rule__State2__Group__3"
    // InternalBot.g:2784:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2788:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:2789:2: rule__State2__Group__3__Impl rule__State2__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__State2__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__3"


    // $ANTLR start "rule__State2__Group__3__Impl"
    // InternalBot.g:2796:1: rule__State2__Group__3__Impl : ( ( rule__State2__Group_3__0 )* ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2800:1: ( ( ( rule__State2__Group_3__0 )* ) )
            // InternalBot.g:2801:1: ( ( rule__State2__Group_3__0 )* )
            {
            // InternalBot.g:2801:1: ( ( rule__State2__Group_3__0 )* )
            // InternalBot.g:2802:2: ( rule__State2__Group_3__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_3()); 
            // InternalBot.g:2803:2: ( rule__State2__Group_3__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==55) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBot.g:2803:3: rule__State2__Group_3__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__State2__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getState2Access().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__3__Impl"


    // $ANTLR start "rule__State2__Group__4"
    // InternalBot.g:2811:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2815:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:2816:2: rule__State2__Group__4__Impl rule__State2__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__State2__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__4"


    // $ANTLR start "rule__State2__Group__4__Impl"
    // InternalBot.g:2823:1: rule__State2__Group__4__Impl : ( ')' ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2827:1: ( ( ')' ) )
            // InternalBot.g:2828:1: ( ')' )
            {
            // InternalBot.g:2828:1: ( ')' )
            // InternalBot.g:2829:2: ')'
            {
             before(grammarAccess.getState2Access().getRightParenthesisKeyword_4()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getState2Access().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__4__Impl"


    // $ANTLR start "rule__State2__Group__5"
    // InternalBot.g:2838:1: rule__State2__Group__5 : rule__State2__Group__5__Impl rule__State2__Group__6 ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2842:1: ( rule__State2__Group__5__Impl rule__State2__Group__6 )
            // InternalBot.g:2843:2: rule__State2__Group__5__Impl rule__State2__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__State2__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__5"


    // $ANTLR start "rule__State2__Group__5__Impl"
    // InternalBot.g:2850:1: rule__State2__Group__5__Impl : ( '{' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2854:1: ( ( '{' ) )
            // InternalBot.g:2855:1: ( '{' )
            {
            // InternalBot.g:2855:1: ( '{' )
            // InternalBot.g:2856:2: '{'
            {
             before(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__5__Impl"


    // $ANTLR start "rule__State2__Group__6"
    // InternalBot.g:2865:1: rule__State2__Group__6 : rule__State2__Group__6__Impl rule__State2__Group__7 ;
    public final void rule__State2__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2869:1: ( rule__State2__Group__6__Impl rule__State2__Group__7 )
            // InternalBot.g:2870:2: rule__State2__Group__6__Impl rule__State2__Group__7
            {
            pushFollow(FOLLOW_30);
            rule__State2__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__6"


    // $ANTLR start "rule__State2__Group__6__Impl"
    // InternalBot.g:2877:1: rule__State2__Group__6__Impl : ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) ) ;
    public final void rule__State2__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2881:1: ( ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) ) )
            // InternalBot.g:2882:1: ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) )
            {
            // InternalBot.g:2882:1: ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) )
            // InternalBot.g:2883:2: ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* )
            {
            // InternalBot.g:2883:2: ( ( rule__State2__Group_6__0 ) )
            // InternalBot.g:2884:3: ( rule__State2__Group_6__0 )
            {
             before(grammarAccess.getState2Access().getGroup_6()); 
            // InternalBot.g:2885:3: ( rule__State2__Group_6__0 )
            // InternalBot.g:2885:4: rule__State2__Group_6__0
            {
            pushFollow(FOLLOW_31);
            rule__State2__Group_6__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_6()); 

            }

            // InternalBot.g:2888:2: ( ( rule__State2__Group_6__0 )* )
            // InternalBot.g:2889:3: ( rule__State2__Group_6__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_6()); 
            // InternalBot.g:2890:3: ( rule__State2__Group_6__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==58) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBot.g:2890:4: rule__State2__Group_6__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__State2__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getState2Access().getGroup_6()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__6__Impl"


    // $ANTLR start "rule__State2__Group__7"
    // InternalBot.g:2899:1: rule__State2__Group__7 : rule__State2__Group__7__Impl ;
    public final void rule__State2__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2903:1: ( rule__State2__Group__7__Impl )
            // InternalBot.g:2904:2: rule__State2__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__7"


    // $ANTLR start "rule__State2__Group__7__Impl"
    // InternalBot.g:2910:1: rule__State2__Group__7__Impl : ( '}' ) ;
    public final void rule__State2__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2914:1: ( ( '}' ) )
            // InternalBot.g:2915:1: ( '}' )
            {
            // InternalBot.g:2915:1: ( '}' )
            // InternalBot.g:2916:2: '}'
            {
             before(grammarAccess.getState2Access().getRightCurlyBracketKeyword_7()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getState2Access().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__7__Impl"


    // $ANTLR start "rule__State2__Group_3__0"
    // InternalBot.g:2926:1: rule__State2__Group_3__0 : rule__State2__Group_3__0__Impl rule__State2__Group_3__1 ;
    public final void rule__State2__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2930:1: ( rule__State2__Group_3__0__Impl rule__State2__Group_3__1 )
            // InternalBot.g:2931:2: rule__State2__Group_3__0__Impl rule__State2__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__State2__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_3__0"


    // $ANTLR start "rule__State2__Group_3__0__Impl"
    // InternalBot.g:2938:1: rule__State2__Group_3__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2942:1: ( ( ',' ) )
            // InternalBot.g:2943:1: ( ',' )
            {
            // InternalBot.g:2943:1: ( ',' )
            // InternalBot.g:2944:2: ','
            {
             before(grammarAccess.getState2Access().getCommaKeyword_3_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getState2Access().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_3__0__Impl"


    // $ANTLR start "rule__State2__Group_3__1"
    // InternalBot.g:2953:1: rule__State2__Group_3__1 : rule__State2__Group_3__1__Impl ;
    public final void rule__State2__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2957:1: ( rule__State2__Group_3__1__Impl )
            // InternalBot.g:2958:2: rule__State2__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_3__1"


    // $ANTLR start "rule__State2__Group_3__1__Impl"
    // InternalBot.g:2964:1: rule__State2__Group_3__1__Impl : ( ( rule__State2__ActionsAssignment_3_1 ) ) ;
    public final void rule__State2__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2968:1: ( ( ( rule__State2__ActionsAssignment_3_1 ) ) )
            // InternalBot.g:2969:1: ( ( rule__State2__ActionsAssignment_3_1 ) )
            {
            // InternalBot.g:2969:1: ( ( rule__State2__ActionsAssignment_3_1 ) )
            // InternalBot.g:2970:2: ( rule__State2__ActionsAssignment_3_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_3_1()); 
            // InternalBot.g:2971:2: ( rule__State2__ActionsAssignment_3_1 )
            // InternalBot.g:2971:3: rule__State2__ActionsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__State2__ActionsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getActionsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_3__1__Impl"


    // $ANTLR start "rule__State2__Group_6__0"
    // InternalBot.g:2980:1: rule__State2__Group_6__0 : rule__State2__Group_6__0__Impl rule__State2__Group_6__1 ;
    public final void rule__State2__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2984:1: ( rule__State2__Group_6__0__Impl rule__State2__Group_6__1 )
            // InternalBot.g:2985:2: rule__State2__Group_6__0__Impl rule__State2__Group_6__1
            {
            pushFollow(FOLLOW_18);
            rule__State2__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_6__0"


    // $ANTLR start "rule__State2__Group_6__0__Impl"
    // InternalBot.g:2992:1: rule__State2__Group_6__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2996:1: ( ( '=>' ) )
            // InternalBot.g:2997:1: ( '=>' )
            {
            // InternalBot.g:2997:1: ( '=>' )
            // InternalBot.g:2998:2: '=>'
            {
             before(grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_6_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_6__0__Impl"


    // $ANTLR start "rule__State2__Group_6__1"
    // InternalBot.g:3007:1: rule__State2__Group_6__1 : rule__State2__Group_6__1__Impl rule__State2__Group_6__2 ;
    public final void rule__State2__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3011:1: ( rule__State2__Group_6__1__Impl rule__State2__Group_6__2 )
            // InternalBot.g:3012:2: rule__State2__Group_6__1__Impl rule__State2__Group_6__2
            {
            pushFollow(FOLLOW_19);
            rule__State2__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_6__1"


    // $ANTLR start "rule__State2__Group_6__1__Impl"
    // InternalBot.g:3019:1: rule__State2__Group_6__1__Impl : ( ( rule__State2__OutcomingAssignment_6_1 ) ) ;
    public final void rule__State2__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3023:1: ( ( ( rule__State2__OutcomingAssignment_6_1 ) ) )
            // InternalBot.g:3024:1: ( ( rule__State2__OutcomingAssignment_6_1 ) )
            {
            // InternalBot.g:3024:1: ( ( rule__State2__OutcomingAssignment_6_1 ) )
            // InternalBot.g:3025:2: ( rule__State2__OutcomingAssignment_6_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_6_1()); 
            // InternalBot.g:3026:2: ( rule__State2__OutcomingAssignment_6_1 )
            // InternalBot.g:3026:3: rule__State2__OutcomingAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__State2__OutcomingAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getOutcomingAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_6__1__Impl"


    // $ANTLR start "rule__State2__Group_6__2"
    // InternalBot.g:3034:1: rule__State2__Group_6__2 : rule__State2__Group_6__2__Impl ;
    public final void rule__State2__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3038:1: ( rule__State2__Group_6__2__Impl )
            // InternalBot.g:3039:2: rule__State2__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_6__2"


    // $ANTLR start "rule__State2__Group_6__2__Impl"
    // InternalBot.g:3045:1: rule__State2__Group_6__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3049:1: ( ( ';' ) )
            // InternalBot.g:3050:1: ( ';' )
            {
            // InternalBot.g:3050:1: ( ';' )
            // InternalBot.g:3051:2: ';'
            {
             before(grammarAccess.getState2Access().getSemicolonKeyword_6_2()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getState2Access().getSemicolonKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_6__2__Impl"


    // $ANTLR start "rule__TrainingPhrase__Group__0"
    // InternalBot.g:3061:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3065:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3066:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__TrainingPhrase__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__0"


    // $ANTLR start "rule__TrainingPhrase__Group__0__Impl"
    // InternalBot.g:3073:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3077:1: ( ( () ) )
            // InternalBot.g:3078:1: ( () )
            {
            // InternalBot.g:3078:1: ( () )
            // InternalBot.g:3079:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3080:2: ()
            // InternalBot.g:3080:3: 
            {
            }

             after(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__0__Impl"


    // $ANTLR start "rule__TrainingPhrase__Group__1"
    // InternalBot.g:3088:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3092:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3093:2: rule__TrainingPhrase__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__1"


    // $ANTLR start "rule__TrainingPhrase__Group__1__Impl"
    // InternalBot.g:3099:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3103:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3104:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3104:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3105:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3105:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3106:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3107:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3107:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_32);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3110:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3111:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3112:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_ID)||LA33_0==60) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBot.g:3112:4: rule__TrainingPhrase__TokensAssignment_1
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__TrainingPhrase__TokensAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // InternalBot.g:3122:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3126:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3127:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // InternalBot.g:3134:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3138:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3139:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3139:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3140:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3141:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3141:3: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // InternalBot.g:3149:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3153:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3154:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // InternalBot.g:3161:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3165:1: ( ( ':' ) )
            // InternalBot.g:3166:1: ( ':' )
            {
            // InternalBot.g:3166:1: ( ':' )
            // InternalBot.g:3167:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__2"
    // InternalBot.g:3176:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3180:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3181:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__Parameter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2"


    // $ANTLR start "rule__Parameter__Group__2__Impl"
    // InternalBot.g:3188:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3192:1: ( ( 'entity' ) )
            // InternalBot.g:3193:1: ( 'entity' )
            {
            // InternalBot.g:3193:1: ( 'entity' )
            // InternalBot.g:3194:2: 'entity'
            {
             before(grammarAccess.getParameterAccess().getEntityKeyword_2()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getEntityKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2__Impl"


    // $ANTLR start "rule__Parameter__Group__3"
    // InternalBot.g:3203:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3207:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:3208:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FOLLOW_35);
            rule__Parameter__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__3"


    // $ANTLR start "rule__Parameter__Group__3__Impl"
    // InternalBot.g:3215:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3219:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:3220:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:3220:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:3221:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:3222:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:3222:3: rule__Parameter__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__3__Impl"


    // $ANTLR start "rule__Parameter__Group__4"
    // InternalBot.g:3230:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3234:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:3235:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__Parameter__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__4"


    // $ANTLR start "rule__Parameter__Group__4__Impl"
    // InternalBot.g:3242:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3246:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:3247:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:3247:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:3248:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:3249:2: ( rule__Parameter__Group_4__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==55) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==83) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // InternalBot.g:3249:3: rule__Parameter__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__4__Impl"


    // $ANTLR start "rule__Parameter__Group__5"
    // InternalBot.g:3257:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3261:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:3262:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__Parameter__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__5"


    // $ANTLR start "rule__Parameter__Group__5__Impl"
    // InternalBot.g:3269:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3273:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:3274:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:3274:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:3275:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:3276:2: ( rule__Parameter__Group_5__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==55) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:3276:3: rule__Parameter__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__5__Impl"


    // $ANTLR start "rule__Parameter__Group__6"
    // InternalBot.g:3284:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3288:1: ( rule__Parameter__Group__6__Impl )
            // InternalBot.g:3289:2: rule__Parameter__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__6"


    // $ANTLR start "rule__Parameter__Group__6__Impl"
    // InternalBot.g:3295:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3299:1: ( ( ';' ) )
            // InternalBot.g:3300:1: ( ';' )
            {
            // InternalBot.g:3300:1: ( ';' )
            // InternalBot.g:3301:2: ';'
            {
             before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__6__Impl"


    // $ANTLR start "rule__Parameter__Group_4__0"
    // InternalBot.g:3311:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3315:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:3316:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FOLLOW_36);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__0"


    // $ANTLR start "rule__Parameter__Group_4__0__Impl"
    // InternalBot.g:3323:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3327:1: ( ( ',' ) )
            // InternalBot.g:3328:1: ( ',' )
            {
            // InternalBot.g:3328:1: ( ',' )
            // InternalBot.g:3329:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4__1"
    // InternalBot.g:3338:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3342:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // InternalBot.g:3343:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FOLLOW_37);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__1"


    // $ANTLR start "rule__Parameter__Group_4__1__Impl"
    // InternalBot.g:3350:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__RequiredAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3354:1: ( ( ( rule__Parameter__RequiredAssignment_4_1 ) ) )
            // InternalBot.g:3355:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            {
            // InternalBot.g:3355:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            // InternalBot.g:3356:2: ( rule__Parameter__RequiredAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_4_1()); 
            // InternalBot.g:3357:2: ( rule__Parameter__RequiredAssignment_4_1 )
            // InternalBot.g:3357:3: rule__Parameter__RequiredAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__RequiredAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getRequiredAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__1__Impl"


    // $ANTLR start "rule__Parameter__Group_4__2"
    // InternalBot.g:3365:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3369:1: ( rule__Parameter__Group_4__2__Impl )
            // InternalBot.g:3370:2: rule__Parameter__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__2"


    // $ANTLR start "rule__Parameter__Group_4__2__Impl"
    // InternalBot.g:3376:1: rule__Parameter__Group_4__2__Impl : ( ( rule__Parameter__Group_4_2__0 )? ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3380:1: ( ( ( rule__Parameter__Group_4_2__0 )? ) )
            // InternalBot.g:3381:1: ( ( rule__Parameter__Group_4_2__0 )? )
            {
            // InternalBot.g:3381:1: ( ( rule__Parameter__Group_4_2__0 )? )
            // InternalBot.g:3382:2: ( rule__Parameter__Group_4_2__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4_2()); 
            // InternalBot.g:3383:2: ( rule__Parameter__Group_4_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==55) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==63) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // InternalBot.g:3383:3: rule__Parameter__Group_4_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_4_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__2__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2__0"
    // InternalBot.g:3392:1: rule__Parameter__Group_4_2__0 : rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1 ;
    public final void rule__Parameter__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3396:1: ( rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1 )
            // InternalBot.g:3397:2: rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1
            {
            pushFollow(FOLLOW_38);
            rule__Parameter__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__0"


    // $ANTLR start "rule__Parameter__Group_4_2__0__Impl"
    // InternalBot.g:3404:1: rule__Parameter__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3408:1: ( ( ',' ) )
            // InternalBot.g:3409:1: ( ',' )
            {
            // InternalBot.g:3409:1: ( ',' )
            // InternalBot.g:3410:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_2_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2__1"
    // InternalBot.g:3419:1: rule__Parameter__Group_4_2__1 : rule__Parameter__Group_4_2__1__Impl rule__Parameter__Group_4_2__2 ;
    public final void rule__Parameter__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3423:1: ( rule__Parameter__Group_4_2__1__Impl rule__Parameter__Group_4_2__2 )
            // InternalBot.g:3424:2: rule__Parameter__Group_4_2__1__Impl rule__Parameter__Group_4_2__2
            {
            pushFollow(FOLLOW_39);
            rule__Parameter__Group_4_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__1"


    // $ANTLR start "rule__Parameter__Group_4_2__1__Impl"
    // InternalBot.g:3431:1: rule__Parameter__Group_4_2__1__Impl : ( 'prompts' ) ;
    public final void rule__Parameter__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3435:1: ( ( 'prompts' ) )
            // InternalBot.g:3436:1: ( 'prompts' )
            {
            // InternalBot.g:3436:1: ( 'prompts' )
            // InternalBot.g:3437:2: 'prompts'
            {
             before(grammarAccess.getParameterAccess().getPromptsKeyword_4_2_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getPromptsKeyword_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__1__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2__2"
    // InternalBot.g:3446:1: rule__Parameter__Group_4_2__2 : rule__Parameter__Group_4_2__2__Impl rule__Parameter__Group_4_2__3 ;
    public final void rule__Parameter__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3450:1: ( rule__Parameter__Group_4_2__2__Impl rule__Parameter__Group_4_2__3 )
            // InternalBot.g:3451:2: rule__Parameter__Group_4_2__2__Impl rule__Parameter__Group_4_2__3
            {
            pushFollow(FOLLOW_5);
            rule__Parameter__Group_4_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__2"


    // $ANTLR start "rule__Parameter__Group_4_2__2__Impl"
    // InternalBot.g:3458:1: rule__Parameter__Group_4_2__2__Impl : ( '[' ) ;
    public final void rule__Parameter__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3462:1: ( ( '[' ) )
            // InternalBot.g:3463:1: ( '[' )
            {
            // InternalBot.g:3463:1: ( '[' )
            // InternalBot.g:3464:2: '['
            {
             before(grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_4_2_2()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_4_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__2__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2__3"
    // InternalBot.g:3473:1: rule__Parameter__Group_4_2__3 : rule__Parameter__Group_4_2__3__Impl rule__Parameter__Group_4_2__4 ;
    public final void rule__Parameter__Group_4_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3477:1: ( rule__Parameter__Group_4_2__3__Impl rule__Parameter__Group_4_2__4 )
            // InternalBot.g:3478:2: rule__Parameter__Group_4_2__3__Impl rule__Parameter__Group_4_2__4
            {
            pushFollow(FOLLOW_40);
            rule__Parameter__Group_4_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__3"


    // $ANTLR start "rule__Parameter__Group_4_2__3__Impl"
    // InternalBot.g:3485:1: rule__Parameter__Group_4_2__3__Impl : ( ( rule__Parameter__PromptsAssignment_4_2_3 ) ) ;
    public final void rule__Parameter__Group_4_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3489:1: ( ( ( rule__Parameter__PromptsAssignment_4_2_3 ) ) )
            // InternalBot.g:3490:1: ( ( rule__Parameter__PromptsAssignment_4_2_3 ) )
            {
            // InternalBot.g:3490:1: ( ( rule__Parameter__PromptsAssignment_4_2_3 ) )
            // InternalBot.g:3491:2: ( rule__Parameter__PromptsAssignment_4_2_3 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_3()); 
            // InternalBot.g:3492:2: ( rule__Parameter__PromptsAssignment_4_2_3 )
            // InternalBot.g:3492:3: rule__Parameter__PromptsAssignment_4_2_3
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__PromptsAssignment_4_2_3();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__3__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2__4"
    // InternalBot.g:3500:1: rule__Parameter__Group_4_2__4 : rule__Parameter__Group_4_2__4__Impl rule__Parameter__Group_4_2__5 ;
    public final void rule__Parameter__Group_4_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3504:1: ( rule__Parameter__Group_4_2__4__Impl rule__Parameter__Group_4_2__5 )
            // InternalBot.g:3505:2: rule__Parameter__Group_4_2__4__Impl rule__Parameter__Group_4_2__5
            {
            pushFollow(FOLLOW_40);
            rule__Parameter__Group_4_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__4"


    // $ANTLR start "rule__Parameter__Group_4_2__4__Impl"
    // InternalBot.g:3512:1: rule__Parameter__Group_4_2__4__Impl : ( ( rule__Parameter__Group_4_2_4__0 )* ) ;
    public final void rule__Parameter__Group_4_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3516:1: ( ( ( rule__Parameter__Group_4_2_4__0 )* ) )
            // InternalBot.g:3517:1: ( ( rule__Parameter__Group_4_2_4__0 )* )
            {
            // InternalBot.g:3517:1: ( ( rule__Parameter__Group_4_2_4__0 )* )
            // InternalBot.g:3518:2: ( rule__Parameter__Group_4_2_4__0 )*
            {
             before(grammarAccess.getParameterAccess().getGroup_4_2_4()); 
            // InternalBot.g:3519:2: ( rule__Parameter__Group_4_2_4__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==55) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBot.g:3519:3: rule__Parameter__Group_4_2_4__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Parameter__Group_4_2_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getParameterAccess().getGroup_4_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__4__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2__5"
    // InternalBot.g:3527:1: rule__Parameter__Group_4_2__5 : rule__Parameter__Group_4_2__5__Impl ;
    public final void rule__Parameter__Group_4_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3531:1: ( rule__Parameter__Group_4_2__5__Impl )
            // InternalBot.g:3532:2: rule__Parameter__Group_4_2__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__5"


    // $ANTLR start "rule__Parameter__Group_4_2__5__Impl"
    // InternalBot.g:3538:1: rule__Parameter__Group_4_2__5__Impl : ( ']' ) ;
    public final void rule__Parameter__Group_4_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3542:1: ( ( ']' ) )
            // InternalBot.g:3543:1: ( ']' )
            {
            // InternalBot.g:3543:1: ( ']' )
            // InternalBot.g:3544:2: ']'
            {
             before(grammarAccess.getParameterAccess().getRightSquareBracketKeyword_4_2_5()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getRightSquareBracketKeyword_4_2_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__5__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2_4__0"
    // InternalBot.g:3554:1: rule__Parameter__Group_4_2_4__0 : rule__Parameter__Group_4_2_4__0__Impl rule__Parameter__Group_4_2_4__1 ;
    public final void rule__Parameter__Group_4_2_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3558:1: ( rule__Parameter__Group_4_2_4__0__Impl rule__Parameter__Group_4_2_4__1 )
            // InternalBot.g:3559:2: rule__Parameter__Group_4_2_4__0__Impl rule__Parameter__Group_4_2_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Parameter__Group_4_2_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_4__0"


    // $ANTLR start "rule__Parameter__Group_4_2_4__0__Impl"
    // InternalBot.g:3566:1: rule__Parameter__Group_4_2_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4_2_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3570:1: ( ( ',' ) )
            // InternalBot.g:3571:1: ( ',' )
            {
            // InternalBot.g:3571:1: ( ',' )
            // InternalBot.g:3572:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_2_4_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_4_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_4__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2_4__1"
    // InternalBot.g:3581:1: rule__Parameter__Group_4_2_4__1 : rule__Parameter__Group_4_2_4__1__Impl ;
    public final void rule__Parameter__Group_4_2_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3585:1: ( rule__Parameter__Group_4_2_4__1__Impl )
            // InternalBot.g:3586:2: rule__Parameter__Group_4_2_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_4__1"


    // $ANTLR start "rule__Parameter__Group_4_2_4__1__Impl"
    // InternalBot.g:3592:1: rule__Parameter__Group_4_2_4__1__Impl : ( ( rule__Parameter__PromptsAssignment_4_2_4_1 ) ) ;
    public final void rule__Parameter__Group_4_2_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3596:1: ( ( ( rule__Parameter__PromptsAssignment_4_2_4_1 ) ) )
            // InternalBot.g:3597:1: ( ( rule__Parameter__PromptsAssignment_4_2_4_1 ) )
            {
            // InternalBot.g:3597:1: ( ( rule__Parameter__PromptsAssignment_4_2_4_1 ) )
            // InternalBot.g:3598:2: ( rule__Parameter__PromptsAssignment_4_2_4_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_4_1()); 
            // InternalBot.g:3599:2: ( rule__Parameter__PromptsAssignment_4_2_4_1 )
            // InternalBot.g:3599:3: rule__Parameter__PromptsAssignment_4_2_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__PromptsAssignment_4_2_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_4__1__Impl"


    // $ANTLR start "rule__Parameter__Group_5__0"
    // InternalBot.g:3608:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3612:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:3613:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FOLLOW_41);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__0"


    // $ANTLR start "rule__Parameter__Group_5__0__Impl"
    // InternalBot.g:3620:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3624:1: ( ( ',' ) )
            // InternalBot.g:3625:1: ( ',' )
            {
            // InternalBot.g:3625:1: ( ',' )
            // InternalBot.g:3626:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_5_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__0__Impl"


    // $ANTLR start "rule__Parameter__Group_5__1"
    // InternalBot.g:3635:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3639:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:3640:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__1"


    // $ANTLR start "rule__Parameter__Group_5__1__Impl"
    // InternalBot.g:3646:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__IsListAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3650:1: ( ( ( rule__Parameter__IsListAssignment_5_1 ) ) )
            // InternalBot.g:3651:1: ( ( rule__Parameter__IsListAssignment_5_1 ) )
            {
            // InternalBot.g:3651:1: ( ( rule__Parameter__IsListAssignment_5_1 ) )
            // InternalBot.g:3652:2: ( rule__Parameter__IsListAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_5_1()); 
            // InternalBot.g:3653:2: ( rule__Parameter__IsListAssignment_5_1 )
            // InternalBot.g:3653:3: rule__Parameter__IsListAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__IsListAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getIsListAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__1__Impl"


    // $ANTLR start "rule__EntityToken__Group__0"
    // InternalBot.g:3662:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3666:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:3667:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__EntityToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__0"


    // $ANTLR start "rule__EntityToken__Group__0__Impl"
    // InternalBot.g:3674:1: rule__EntityToken__Group__0__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3678:1: ( ( '@' ) )
            // InternalBot.g:3679:1: ( '@' )
            {
            // InternalBot.g:3679:1: ( '@' )
            // InternalBot.g:3680:2: '@'
            {
             before(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__0__Impl"


    // $ANTLR start "rule__EntityToken__Group__1"
    // InternalBot.g:3689:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3693:1: ( rule__EntityToken__Group__1__Impl )
            // InternalBot.g:3694:2: rule__EntityToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__1"


    // $ANTLR start "rule__EntityToken__Group__1__Impl"
    // InternalBot.g:3700:1: rule__EntityToken__Group__1__Impl : ( ( rule__EntityToken__EntityAssignment_1 ) ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3704:1: ( ( ( rule__EntityToken__EntityAssignment_1 ) ) )
            // InternalBot.g:3705:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            {
            // InternalBot.g:3705:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            // InternalBot.g:3706:2: ( rule__EntityToken__EntityAssignment_1 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 
            // InternalBot.g:3707:2: ( rule__EntityToken__EntityAssignment_1 )
            // InternalBot.g:3707:3: rule__EntityToken__EntityAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__EntityAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__1__Impl"


    // $ANTLR start "rule__ParameterToken__Group__0"
    // InternalBot.g:3716:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3720:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:3721:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ParameterToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__0"


    // $ANTLR start "rule__ParameterToken__Group__0__Impl"
    // InternalBot.g:3728:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3732:1: ( ( '[' ) )
            // InternalBot.g:3733:1: ( '[' )
            {
            // InternalBot.g:3733:1: ( '[' )
            // InternalBot.g:3734:2: '['
            {
             before(grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__0__Impl"


    // $ANTLR start "rule__ParameterToken__Group__1"
    // InternalBot.g:3743:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3747:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:3748:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
            {
            pushFollow(FOLLOW_42);
            rule__ParameterToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__1"


    // $ANTLR start "rule__ParameterToken__Group__1__Impl"
    // InternalBot.g:3755:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3759:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:3760:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:3760:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:3761:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:3762:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:3762:3: rule__ParameterToken__ParameterAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterToken__ParameterAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__1__Impl"


    // $ANTLR start "rule__ParameterToken__Group__2"
    // InternalBot.g:3770:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3774:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:3775:2: rule__ParameterToken__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__2"


    // $ANTLR start "rule__ParameterToken__Group__2__Impl"
    // InternalBot.g:3781:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3785:1: ( ( ']' ) )
            // InternalBot.g:3786:1: ( ']' )
            {
            // InternalBot.g:3786:1: ( ']' )
            // InternalBot.g:3787:2: ']'
            {
             before(grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__2__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__0"
    // InternalBot.g:3797:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3801:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:3802:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ParameterRefenceToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__0"


    // $ANTLR start "rule__ParameterRefenceToken__Group__0__Impl"
    // InternalBot.g:3809:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3813:1: ( ( '(' ) )
            // InternalBot.g:3814:1: ( '(' )
            {
            // InternalBot.g:3814:1: ( '(' )
            // InternalBot.g:3815:2: '('
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__0__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__1"
    // InternalBot.g:3824:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3828:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:3829:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
            {
            pushFollow(FOLLOW_43);
            rule__ParameterRefenceToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__1"


    // $ANTLR start "rule__ParameterRefenceToken__Group__1__Impl"
    // InternalBot.g:3836:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3840:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:3841:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:3841:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:3842:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:3843:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:3843:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__TextReferenceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__1__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__2"
    // InternalBot.g:3851:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3855:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:3856:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
            {
            pushFollow(FOLLOW_39);
            rule__ParameterRefenceToken__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__2"


    // $ANTLR start "rule__ParameterRefenceToken__Group__2__Impl"
    // InternalBot.g:3863:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3867:1: ( ( ')' ) )
            // InternalBot.g:3868:1: ( ')' )
            {
            // InternalBot.g:3868:1: ( ')' )
            // InternalBot.g:3869:2: ')'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__2__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__3"
    // InternalBot.g:3878:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3882:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:3883:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__ParameterRefenceToken__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__3"


    // $ANTLR start "rule__ParameterRefenceToken__Group__3__Impl"
    // InternalBot.g:3890:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3894:1: ( ( '[' ) )
            // InternalBot.g:3895:1: ( '[' )
            {
            // InternalBot.g:3895:1: ( '[' )
            // InternalBot.g:3896:2: '['
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__3__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__4"
    // InternalBot.g:3905:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3909:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:3910:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__ParameterRefenceToken__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__4"


    // $ANTLR start "rule__ParameterRefenceToken__Group__4__Impl"
    // InternalBot.g:3917:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3921:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:3922:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:3922:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:3923:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:3924:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:3924:3: rule__ParameterRefenceToken__ParameterAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__ParameterAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__4__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__5"
    // InternalBot.g:3932:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3936:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:3937:2: rule__ParameterRefenceToken__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__5"


    // $ANTLR start "rule__ParameterRefenceToken__Group__5__Impl"
    // InternalBot.g:3943:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3947:1: ( ( ']' ) )
            // InternalBot.g:3948:1: ( ']' )
            {
            // InternalBot.g:3948:1: ( ']' )
            // InternalBot.g:3949:2: ']'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__5__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group__0"
    // InternalBot.g:3959:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3963:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:3964:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__HTTPRequestToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__0"


    // $ANTLR start "rule__HTTPRequestToken__Group__0__Impl"
    // InternalBot.g:3971:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3975:1: ( ( 'request.' ) )
            // InternalBot.g:3976:1: ( 'request.' )
            {
            // InternalBot.g:3976:1: ( 'request.' )
            // InternalBot.g:3977:2: 'request.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__0__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group__1"
    // InternalBot.g:3986:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3990:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:3991:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__HTTPRequestToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__1"


    // $ANTLR start "rule__HTTPRequestToken__Group__1__Impl"
    // InternalBot.g:3998:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4002:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4003:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4003:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4004:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4005:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4005:3: rule__HTTPRequestToken__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__1__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group__2"
    // InternalBot.g:4013:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4017:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:4018:2: rule__HTTPRequestToken__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__2"


    // $ANTLR start "rule__HTTPRequestToken__Group__2__Impl"
    // InternalBot.g:4024:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4028:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:4029:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:4029:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:4030:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:4031:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==68) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:4031:3: rule__HTTPRequestToken__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequestToken__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__2__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__0"
    // InternalBot.g:4040:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4044:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:4045:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequestToken__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__0"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__0__Impl"
    // InternalBot.g:4052:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4056:1: ( ( '.' ) )
            // InternalBot.g:4057:1: ( '.' )
            {
            // InternalBot.g:4057:1: ( '.' )
            // InternalBot.g:4058:2: '.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__0__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__1"
    // InternalBot.g:4067:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4071:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:4072:2: rule__HTTPRequestToken__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__1"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__1__Impl"
    // InternalBot.g:4078:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4082:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:4083:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:4083:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:4084:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:4085:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:4085:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__DataKeyAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__1__Impl"


    // $ANTLR start "rule__Simple__Group__0"
    // InternalBot.g:4094:1: rule__Simple__Group__0 : rule__Simple__Group__0__Impl rule__Simple__Group__1 ;
    public final void rule__Simple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4098:1: ( rule__Simple__Group__0__Impl rule__Simple__Group__1 )
            // InternalBot.g:4099:2: rule__Simple__Group__0__Impl rule__Simple__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__Simple__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__0"


    // $ANTLR start "rule__Simple__Group__0__Impl"
    // InternalBot.g:4106:1: rule__Simple__Group__0__Impl : ( () ) ;
    public final void rule__Simple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4110:1: ( ( () ) )
            // InternalBot.g:4111:1: ( () )
            {
            // InternalBot.g:4111:1: ( () )
            // InternalBot.g:4112:2: ()
            {
             before(grammarAccess.getSimpleAccess().getSimpleAction_0()); 
            // InternalBot.g:4113:2: ()
            // InternalBot.g:4113:3: 
            {
            }

             after(grammarAccess.getSimpleAccess().getSimpleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__0__Impl"


    // $ANTLR start "rule__Simple__Group__1"
    // InternalBot.g:4121:1: rule__Simple__Group__1 : rule__Simple__Group__1__Impl rule__Simple__Group__2 ;
    public final void rule__Simple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4125:1: ( rule__Simple__Group__1__Impl rule__Simple__Group__2 )
            // InternalBot.g:4126:2: rule__Simple__Group__1__Impl rule__Simple__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Simple__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__1"


    // $ANTLR start "rule__Simple__Group__1__Impl"
    // InternalBot.g:4133:1: rule__Simple__Group__1__Impl : ( 'Simple' ) ;
    public final void rule__Simple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4137:1: ( ( 'Simple' ) )
            // InternalBot.g:4138:1: ( 'Simple' )
            {
            // InternalBot.g:4138:1: ( 'Simple' )
            // InternalBot.g:4139:2: 'Simple'
            {
             before(grammarAccess.getSimpleAccess().getSimpleKeyword_1()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getSimpleAccess().getSimpleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__1__Impl"


    // $ANTLR start "rule__Simple__Group__2"
    // InternalBot.g:4148:1: rule__Simple__Group__2 : rule__Simple__Group__2__Impl rule__Simple__Group__3 ;
    public final void rule__Simple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4152:1: ( rule__Simple__Group__2__Impl rule__Simple__Group__3 )
            // InternalBot.g:4153:2: rule__Simple__Group__2__Impl rule__Simple__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Simple__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__2"


    // $ANTLR start "rule__Simple__Group__2__Impl"
    // InternalBot.g:4160:1: rule__Simple__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Simple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4164:1: ( ( 'entity' ) )
            // InternalBot.g:4165:1: ( 'entity' )
            {
            // InternalBot.g:4165:1: ( 'entity' )
            // InternalBot.g:4166:2: 'entity'
            {
             before(grammarAccess.getSimpleAccess().getEntityKeyword_2()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getSimpleAccess().getEntityKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__2__Impl"


    // $ANTLR start "rule__Simple__Group__3"
    // InternalBot.g:4175:1: rule__Simple__Group__3 : rule__Simple__Group__3__Impl rule__Simple__Group__4 ;
    public final void rule__Simple__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4179:1: ( rule__Simple__Group__3__Impl rule__Simple__Group__4 )
            // InternalBot.g:4180:2: rule__Simple__Group__3__Impl rule__Simple__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Simple__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__3"


    // $ANTLR start "rule__Simple__Group__3__Impl"
    // InternalBot.g:4187:1: rule__Simple__Group__3__Impl : ( ( rule__Simple__NameAssignment_3 ) ) ;
    public final void rule__Simple__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4191:1: ( ( ( rule__Simple__NameAssignment_3 ) ) )
            // InternalBot.g:4192:1: ( ( rule__Simple__NameAssignment_3 ) )
            {
            // InternalBot.g:4192:1: ( ( rule__Simple__NameAssignment_3 ) )
            // InternalBot.g:4193:2: ( rule__Simple__NameAssignment_3 )
            {
             before(grammarAccess.getSimpleAccess().getNameAssignment_3()); 
            // InternalBot.g:4194:2: ( rule__Simple__NameAssignment_3 )
            // InternalBot.g:4194:3: rule__Simple__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Simple__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__3__Impl"


    // $ANTLR start "rule__Simple__Group__4"
    // InternalBot.g:4202:1: rule__Simple__Group__4 : rule__Simple__Group__4__Impl rule__Simple__Group__5 ;
    public final void rule__Simple__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4206:1: ( rule__Simple__Group__4__Impl rule__Simple__Group__5 )
            // InternalBot.g:4207:2: rule__Simple__Group__4__Impl rule__Simple__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__Simple__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__4"


    // $ANTLR start "rule__Simple__Group__4__Impl"
    // InternalBot.g:4214:1: rule__Simple__Group__4__Impl : ( ':' ) ;
    public final void rule__Simple__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4218:1: ( ( ':' ) )
            // InternalBot.g:4219:1: ( ':' )
            {
            // InternalBot.g:4219:1: ( ':' )
            // InternalBot.g:4220:2: ':'
            {
             before(grammarAccess.getSimpleAccess().getColonKeyword_4()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getSimpleAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__4__Impl"


    // $ANTLR start "rule__Simple__Group__5"
    // InternalBot.g:4229:1: rule__Simple__Group__5 : rule__Simple__Group__5__Impl ;
    public final void rule__Simple__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4233:1: ( rule__Simple__Group__5__Impl )
            // InternalBot.g:4234:2: rule__Simple__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Simple__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__5"


    // $ANTLR start "rule__Simple__Group__5__Impl"
    // InternalBot.g:4240:1: rule__Simple__Group__5__Impl : ( ( rule__Simple__Group_5__0 )? ) ;
    public final void rule__Simple__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4244:1: ( ( ( rule__Simple__Group_5__0 )? ) )
            // InternalBot.g:4245:1: ( ( rule__Simple__Group_5__0 )? )
            {
            // InternalBot.g:4245:1: ( ( rule__Simple__Group_5__0 )? )
            // InternalBot.g:4246:2: ( rule__Simple__Group_5__0 )?
            {
             before(grammarAccess.getSimpleAccess().getGroup_5()); 
            // InternalBot.g:4247:2: ( rule__Simple__Group_5__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:4247:3: rule__Simple__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Simple__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__5__Impl"


    // $ANTLR start "rule__Simple__Group_5__0"
    // InternalBot.g:4256:1: rule__Simple__Group_5__0 : rule__Simple__Group_5__0__Impl rule__Simple__Group_5__1 ;
    public final void rule__Simple__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4260:1: ( rule__Simple__Group_5__0__Impl rule__Simple__Group_5__1 )
            // InternalBot.g:4261:2: rule__Simple__Group_5__0__Impl rule__Simple__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Simple__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_5__0"


    // $ANTLR start "rule__Simple__Group_5__0__Impl"
    // InternalBot.g:4268:1: rule__Simple__Group_5__0__Impl : ( ( rule__Simple__InputsAssignment_5_0 ) ) ;
    public final void rule__Simple__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4272:1: ( ( ( rule__Simple__InputsAssignment_5_0 ) ) )
            // InternalBot.g:4273:1: ( ( rule__Simple__InputsAssignment_5_0 ) )
            {
            // InternalBot.g:4273:1: ( ( rule__Simple__InputsAssignment_5_0 ) )
            // InternalBot.g:4274:2: ( rule__Simple__InputsAssignment_5_0 )
            {
             before(grammarAccess.getSimpleAccess().getInputsAssignment_5_0()); 
            // InternalBot.g:4275:2: ( rule__Simple__InputsAssignment_5_0 )
            // InternalBot.g:4275:3: rule__Simple__InputsAssignment_5_0
            {
            pushFollow(FOLLOW_2);
            rule__Simple__InputsAssignment_5_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAccess().getInputsAssignment_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_5__0__Impl"


    // $ANTLR start "rule__Simple__Group_5__1"
    // InternalBot.g:4283:1: rule__Simple__Group_5__1 : rule__Simple__Group_5__1__Impl ;
    public final void rule__Simple__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4287:1: ( rule__Simple__Group_5__1__Impl )
            // InternalBot.g:4288:2: rule__Simple__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Simple__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_5__1"


    // $ANTLR start "rule__Simple__Group_5__1__Impl"
    // InternalBot.g:4294:1: rule__Simple__Group_5__1__Impl : ( ( rule__Simple__InputsAssignment_5_1 )* ) ;
    public final void rule__Simple__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4298:1: ( ( ( rule__Simple__InputsAssignment_5_1 )* ) )
            // InternalBot.g:4299:1: ( ( rule__Simple__InputsAssignment_5_1 )* )
            {
            // InternalBot.g:4299:1: ( ( rule__Simple__InputsAssignment_5_1 )* )
            // InternalBot.g:4300:2: ( rule__Simple__InputsAssignment_5_1 )*
            {
             before(grammarAccess.getSimpleAccess().getInputsAssignment_5_1()); 
            // InternalBot.g:4301:2: ( rule__Simple__InputsAssignment_5_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:4301:3: rule__Simple__InputsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Simple__InputsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getSimpleAccess().getInputsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_5__1__Impl"


    // $ANTLR start "rule__Composite__Group__0"
    // InternalBot.g:4310:1: rule__Composite__Group__0 : rule__Composite__Group__0__Impl rule__Composite__Group__1 ;
    public final void rule__Composite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4314:1: ( rule__Composite__Group__0__Impl rule__Composite__Group__1 )
            // InternalBot.g:4315:2: rule__Composite__Group__0__Impl rule__Composite__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Composite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__0"


    // $ANTLR start "rule__Composite__Group__0__Impl"
    // InternalBot.g:4322:1: rule__Composite__Group__0__Impl : ( () ) ;
    public final void rule__Composite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4326:1: ( ( () ) )
            // InternalBot.g:4327:1: ( () )
            {
            // InternalBot.g:4327:1: ( () )
            // InternalBot.g:4328:2: ()
            {
             before(grammarAccess.getCompositeAccess().getCompositeAction_0()); 
            // InternalBot.g:4329:2: ()
            // InternalBot.g:4329:3: 
            {
            }

             after(grammarAccess.getCompositeAccess().getCompositeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__0__Impl"


    // $ANTLR start "rule__Composite__Group__1"
    // InternalBot.g:4337:1: rule__Composite__Group__1 : rule__Composite__Group__1__Impl rule__Composite__Group__2 ;
    public final void rule__Composite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4341:1: ( rule__Composite__Group__1__Impl rule__Composite__Group__2 )
            // InternalBot.g:4342:2: rule__Composite__Group__1__Impl rule__Composite__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Composite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__1"


    // $ANTLR start "rule__Composite__Group__1__Impl"
    // InternalBot.g:4349:1: rule__Composite__Group__1__Impl : ( 'Composite' ) ;
    public final void rule__Composite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4353:1: ( ( 'Composite' ) )
            // InternalBot.g:4354:1: ( 'Composite' )
            {
            // InternalBot.g:4354:1: ( 'Composite' )
            // InternalBot.g:4355:2: 'Composite'
            {
             before(grammarAccess.getCompositeAccess().getCompositeKeyword_1()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getCompositeAccess().getCompositeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__1__Impl"


    // $ANTLR start "rule__Composite__Group__2"
    // InternalBot.g:4364:1: rule__Composite__Group__2 : rule__Composite__Group__2__Impl rule__Composite__Group__3 ;
    public final void rule__Composite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4368:1: ( rule__Composite__Group__2__Impl rule__Composite__Group__3 )
            // InternalBot.g:4369:2: rule__Composite__Group__2__Impl rule__Composite__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Composite__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__2"


    // $ANTLR start "rule__Composite__Group__2__Impl"
    // InternalBot.g:4376:1: rule__Composite__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Composite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4380:1: ( ( 'entity' ) )
            // InternalBot.g:4381:1: ( 'entity' )
            {
            // InternalBot.g:4381:1: ( 'entity' )
            // InternalBot.g:4382:2: 'entity'
            {
             before(grammarAccess.getCompositeAccess().getEntityKeyword_2()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getCompositeAccess().getEntityKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__2__Impl"


    // $ANTLR start "rule__Composite__Group__3"
    // InternalBot.g:4391:1: rule__Composite__Group__3 : rule__Composite__Group__3__Impl rule__Composite__Group__4 ;
    public final void rule__Composite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4395:1: ( rule__Composite__Group__3__Impl rule__Composite__Group__4 )
            // InternalBot.g:4396:2: rule__Composite__Group__3__Impl rule__Composite__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Composite__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__3"


    // $ANTLR start "rule__Composite__Group__3__Impl"
    // InternalBot.g:4403:1: rule__Composite__Group__3__Impl : ( ( rule__Composite__NameAssignment_3 ) ) ;
    public final void rule__Composite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4407:1: ( ( ( rule__Composite__NameAssignment_3 ) ) )
            // InternalBot.g:4408:1: ( ( rule__Composite__NameAssignment_3 ) )
            {
            // InternalBot.g:4408:1: ( ( rule__Composite__NameAssignment_3 ) )
            // InternalBot.g:4409:2: ( rule__Composite__NameAssignment_3 )
            {
             before(grammarAccess.getCompositeAccess().getNameAssignment_3()); 
            // InternalBot.g:4410:2: ( rule__Composite__NameAssignment_3 )
            // InternalBot.g:4410:3: rule__Composite__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Composite__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompositeAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__3__Impl"


    // $ANTLR start "rule__Composite__Group__4"
    // InternalBot.g:4418:1: rule__Composite__Group__4 : rule__Composite__Group__4__Impl rule__Composite__Group__5 ;
    public final void rule__Composite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4422:1: ( rule__Composite__Group__4__Impl rule__Composite__Group__5 )
            // InternalBot.g:4423:2: rule__Composite__Group__4__Impl rule__Composite__Group__5
            {
            pushFollow(FOLLOW_47);
            rule__Composite__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__4"


    // $ANTLR start "rule__Composite__Group__4__Impl"
    // InternalBot.g:4430:1: rule__Composite__Group__4__Impl : ( ':' ) ;
    public final void rule__Composite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4434:1: ( ( ':' ) )
            // InternalBot.g:4435:1: ( ':' )
            {
            // InternalBot.g:4435:1: ( ':' )
            // InternalBot.g:4436:2: ':'
            {
             before(grammarAccess.getCompositeAccess().getColonKeyword_4()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getCompositeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__4__Impl"


    // $ANTLR start "rule__Composite__Group__5"
    // InternalBot.g:4445:1: rule__Composite__Group__5 : rule__Composite__Group__5__Impl ;
    public final void rule__Composite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4449:1: ( rule__Composite__Group__5__Impl )
            // InternalBot.g:4450:2: rule__Composite__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composite__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__5"


    // $ANTLR start "rule__Composite__Group__5__Impl"
    // InternalBot.g:4456:1: rule__Composite__Group__5__Impl : ( ( rule__Composite__Group_5__0 )? ) ;
    public final void rule__Composite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4460:1: ( ( ( rule__Composite__Group_5__0 )? ) )
            // InternalBot.g:4461:1: ( ( rule__Composite__Group_5__0 )? )
            {
            // InternalBot.g:4461:1: ( ( rule__Composite__Group_5__0 )? )
            // InternalBot.g:4462:2: ( rule__Composite__Group_5__0 )?
            {
             before(grammarAccess.getCompositeAccess().getGroup_5()); 
            // InternalBot.g:4463:2: ( rule__Composite__Group_5__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_ID)||LA41_0==66) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:4463:3: rule__Composite__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Composite__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompositeAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__5__Impl"


    // $ANTLR start "rule__Composite__Group_5__0"
    // InternalBot.g:4472:1: rule__Composite__Group_5__0 : rule__Composite__Group_5__0__Impl rule__Composite__Group_5__1 ;
    public final void rule__Composite__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4476:1: ( rule__Composite__Group_5__0__Impl rule__Composite__Group_5__1 )
            // InternalBot.g:4477:2: rule__Composite__Group_5__0__Impl rule__Composite__Group_5__1
            {
            pushFollow(FOLLOW_47);
            rule__Composite__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_5__0"


    // $ANTLR start "rule__Composite__Group_5__0__Impl"
    // InternalBot.g:4484:1: rule__Composite__Group_5__0__Impl : ( ( rule__Composite__InputsAssignment_5_0 ) ) ;
    public final void rule__Composite__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4488:1: ( ( ( rule__Composite__InputsAssignment_5_0 ) ) )
            // InternalBot.g:4489:1: ( ( rule__Composite__InputsAssignment_5_0 ) )
            {
            // InternalBot.g:4489:1: ( ( rule__Composite__InputsAssignment_5_0 ) )
            // InternalBot.g:4490:2: ( rule__Composite__InputsAssignment_5_0 )
            {
             before(grammarAccess.getCompositeAccess().getInputsAssignment_5_0()); 
            // InternalBot.g:4491:2: ( rule__Composite__InputsAssignment_5_0 )
            // InternalBot.g:4491:3: rule__Composite__InputsAssignment_5_0
            {
            pushFollow(FOLLOW_2);
            rule__Composite__InputsAssignment_5_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeAccess().getInputsAssignment_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_5__0__Impl"


    // $ANTLR start "rule__Composite__Group_5__1"
    // InternalBot.g:4499:1: rule__Composite__Group_5__1 : rule__Composite__Group_5__1__Impl ;
    public final void rule__Composite__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4503:1: ( rule__Composite__Group_5__1__Impl )
            // InternalBot.g:4504:2: rule__Composite__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composite__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_5__1"


    // $ANTLR start "rule__Composite__Group_5__1__Impl"
    // InternalBot.g:4510:1: rule__Composite__Group_5__1__Impl : ( ( rule__Composite__InputsAssignment_5_1 )* ) ;
    public final void rule__Composite__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4514:1: ( ( ( rule__Composite__InputsAssignment_5_1 )* ) )
            // InternalBot.g:4515:1: ( ( rule__Composite__InputsAssignment_5_1 )* )
            {
            // InternalBot.g:4515:1: ( ( rule__Composite__InputsAssignment_5_1 )* )
            // InternalBot.g:4516:2: ( rule__Composite__InputsAssignment_5_1 )*
            {
             before(grammarAccess.getCompositeAccess().getInputsAssignment_5_1()); 
            // InternalBot.g:4517:2: ( rule__Composite__InputsAssignment_5_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||LA42_0==66) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBot.g:4517:3: rule__Composite__InputsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__Composite__InputsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getCompositeAccess().getInputsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_5__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group__0"
    // InternalBot.g:4526:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4530:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:4531:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__0"


    // $ANTLR start "rule__SimpleInput__Group__0__Impl"
    // InternalBot.g:4538:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4542:1: ( ( () ) )
            // InternalBot.g:4543:1: ( () )
            {
            // InternalBot.g:4543:1: ( () )
            // InternalBot.g:4544:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:4545:2: ()
            // InternalBot.g:4545:3: 
            {
            }

             after(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group__1"
    // InternalBot.g:4553:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4557:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:4558:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__SimpleInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__1"


    // $ANTLR start "rule__SimpleInput__Group__1__Impl"
    // InternalBot.g:4565:1: rule__SimpleInput__Group__1__Impl : ( ( rule__SimpleInput__NameAssignment_1 ) ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4569:1: ( ( ( rule__SimpleInput__NameAssignment_1 ) ) )
            // InternalBot.g:4570:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            {
            // InternalBot.g:4570:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            // InternalBot.g:4571:2: ( rule__SimpleInput__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 
            // InternalBot.g:4572:2: ( rule__SimpleInput__NameAssignment_1 )
            // InternalBot.g:4572:3: rule__SimpleInput__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group__2"
    // InternalBot.g:4580:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4584:1: ( rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 )
            // InternalBot.g:4585:2: rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3
            {
            pushFollow(FOLLOW_49);
            rule__SimpleInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__2"


    // $ANTLR start "rule__SimpleInput__Group__2__Impl"
    // InternalBot.g:4592:1: rule__SimpleInput__Group__2__Impl : ( ( rule__SimpleInput__Group_2__0 )? ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4596:1: ( ( ( rule__SimpleInput__Group_2__0 )? ) )
            // InternalBot.g:4597:1: ( ( rule__SimpleInput__Group_2__0 )? )
            {
            // InternalBot.g:4597:1: ( ( rule__SimpleInput__Group_2__0 )? )
            // InternalBot.g:4598:2: ( rule__SimpleInput__Group_2__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2()); 
            // InternalBot.g:4599:2: ( rule__SimpleInput__Group_2__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==71) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:4599:3: rule__SimpleInput__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleInput__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__2__Impl"


    // $ANTLR start "rule__SimpleInput__Group__3"
    // InternalBot.g:4607:1: rule__SimpleInput__Group__3 : rule__SimpleInput__Group__3__Impl ;
    public final void rule__SimpleInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4611:1: ( rule__SimpleInput__Group__3__Impl )
            // InternalBot.g:4612:2: rule__SimpleInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__3"


    // $ANTLR start "rule__SimpleInput__Group__3__Impl"
    // InternalBot.g:4618:1: rule__SimpleInput__Group__3__Impl : ( ';' ) ;
    public final void rule__SimpleInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4622:1: ( ( ';' ) )
            // InternalBot.g:4623:1: ( ';' )
            {
            // InternalBot.g:4623:1: ( ';' )
            // InternalBot.g:4624:2: ';'
            {
             before(grammarAccess.getSimpleInputAccess().getSemicolonKeyword_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__3__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2__0"
    // InternalBot.g:4634:1: rule__SimpleInput__Group_2__0 : rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 ;
    public final void rule__SimpleInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4638:1: ( rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 )
            // InternalBot.g:4639:2: rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__0"


    // $ANTLR start "rule__SimpleInput__Group_2__0__Impl"
    // InternalBot.g:4646:1: rule__SimpleInput__Group_2__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4650:1: ( ( 'synonyms' ) )
            // InternalBot.g:4651:1: ( 'synonyms' )
            {
            // InternalBot.g:4651:1: ( 'synonyms' )
            // InternalBot.g:4652:2: 'synonyms'
            {
             before(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2__1"
    // InternalBot.g:4661:1: rule__SimpleInput__Group_2__1 : rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 ;
    public final void rule__SimpleInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4665:1: ( rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 )
            // InternalBot.g:4666:2: rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2
            {
            pushFollow(FOLLOW_37);
            rule__SimpleInput__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__1"


    // $ANTLR start "rule__SimpleInput__Group_2__1__Impl"
    // InternalBot.g:4673:1: rule__SimpleInput__Group_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4677:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) )
            // InternalBot.g:4678:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            {
            // InternalBot.g:4678:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            // InternalBot.g:4679:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 
            // InternalBot.g:4680:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            // InternalBot.g:4680:3: rule__SimpleInput__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__ValuesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2__2"
    // InternalBot.g:4688:1: rule__SimpleInput__Group_2__2 : rule__SimpleInput__Group_2__2__Impl ;
    public final void rule__SimpleInput__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4692:1: ( rule__SimpleInput__Group_2__2__Impl )
            // InternalBot.g:4693:2: rule__SimpleInput__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__2"


    // $ANTLR start "rule__SimpleInput__Group_2__2__Impl"
    // InternalBot.g:4699:1: rule__SimpleInput__Group_2__2__Impl : ( ( rule__SimpleInput__Group_2_2__0 )* ) ;
    public final void rule__SimpleInput__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4703:1: ( ( ( rule__SimpleInput__Group_2_2__0 )* ) )
            // InternalBot.g:4704:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            {
            // InternalBot.g:4704:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            // InternalBot.g:4705:2: ( rule__SimpleInput__Group_2_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 
            // InternalBot.g:4706:2: ( rule__SimpleInput__Group_2_2__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==55) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:4706:3: rule__SimpleInput__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__SimpleInput__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__2__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2_2__0"
    // InternalBot.g:4715:1: rule__SimpleInput__Group_2_2__0 : rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 ;
    public final void rule__SimpleInput__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4719:1: ( rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 )
            // InternalBot.g:4720:2: rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2_2__0"


    // $ANTLR start "rule__SimpleInput__Group_2_2__0__Impl"
    // InternalBot.g:4727:1: rule__SimpleInput__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4731:1: ( ( ',' ) )
            // InternalBot.g:4732:1: ( ',' )
            {
            // InternalBot.g:4732:1: ( ',' )
            // InternalBot.g:4733:2: ','
            {
             before(grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2_2__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2_2__1"
    // InternalBot.g:4742:1: rule__SimpleInput__Group_2_2__1 : rule__SimpleInput__Group_2_2__1__Impl ;
    public final void rule__SimpleInput__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4746:1: ( rule__SimpleInput__Group_2_2__1__Impl )
            // InternalBot.g:4747:2: rule__SimpleInput__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2_2__1"


    // $ANTLR start "rule__SimpleInput__Group_2_2__1__Impl"
    // InternalBot.g:4753:1: rule__SimpleInput__Group_2_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4757:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) )
            // InternalBot.g:4758:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            {
            // InternalBot.g:4758:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            // InternalBot.g:4759:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 
            // InternalBot.g:4760:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            // InternalBot.g:4760:3: rule__SimpleInput__ValuesAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__ValuesAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2_2__1__Impl"


    // $ANTLR start "rule__CompositeInput__Group__0"
    // InternalBot.g:4769:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4773:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:4774:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__CompositeInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__0"


    // $ANTLR start "rule__CompositeInput__Group__0__Impl"
    // InternalBot.g:4781:1: rule__CompositeInput__Group__0__Impl : ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4785:1: ( ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) ) )
            // InternalBot.g:4786:1: ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) )
            {
            // InternalBot.g:4786:1: ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) )
            // InternalBot.g:4787:2: ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* )
            {
            // InternalBot.g:4787:2: ( ( rule__CompositeInput__TokensAssignment_0 ) )
            // InternalBot.g:4788:3: ( rule__CompositeInput__TokensAssignment_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 
            // InternalBot.g:4789:3: ( rule__CompositeInput__TokensAssignment_0 )
            // InternalBot.g:4789:4: rule__CompositeInput__TokensAssignment_0
            {
            pushFollow(FOLLOW_48);
            rule__CompositeInput__TokensAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 

            }

            // InternalBot.g:4792:2: ( ( rule__CompositeInput__TokensAssignment_0 )* )
            // InternalBot.g:4793:3: ( rule__CompositeInput__TokensAssignment_0 )*
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 
            // InternalBot.g:4794:3: ( rule__CompositeInput__TokensAssignment_0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_ID)||LA45_0==66) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalBot.g:4794:4: rule__CompositeInput__TokensAssignment_0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__CompositeInput__TokensAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__0__Impl"


    // $ANTLR start "rule__CompositeInput__Group__1"
    // InternalBot.g:4803:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4807:1: ( rule__CompositeInput__Group__1__Impl )
            // InternalBot.g:4808:2: rule__CompositeInput__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__1"


    // $ANTLR start "rule__CompositeInput__Group__1__Impl"
    // InternalBot.g:4814:1: rule__CompositeInput__Group__1__Impl : ( ';' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4818:1: ( ( ';' ) )
            // InternalBot.g:4819:1: ( ';' )
            {
            // InternalBot.g:4819:1: ( ';' )
            // InternalBot.g:4820:2: ';'
            {
             before(grammarAccess.getCompositeInputAccess().getSemicolonKeyword_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getCompositeInputAccess().getSemicolonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__1__Impl"


    // $ANTLR start "rule__Text__Group__0"
    // InternalBot.g:4830:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4834:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:4835:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FOLLOW_50);
            rule__Text__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__0"


    // $ANTLR start "rule__Text__Group__0__Impl"
    // InternalBot.g:4842:1: rule__Text__Group__0__Impl : ( 'text' ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4846:1: ( ( 'text' ) )
            // InternalBot.g:4847:1: ( 'text' )
            {
            // InternalBot.g:4847:1: ( 'text' )
            // InternalBot.g:4848:2: 'text'
            {
             before(grammarAccess.getTextAccess().getTextKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getTextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__0__Impl"


    // $ANTLR start "rule__Text__Group__1"
    // InternalBot.g:4857:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4861:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:4862:2: rule__Text__Group__1__Impl rule__Text__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Text__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__1"


    // $ANTLR start "rule__Text__Group__1__Impl"
    // InternalBot.g:4869:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4873:1: ( ( 'response' ) )
            // InternalBot.g:4874:1: ( 'response' )
            {
            // InternalBot.g:4874:1: ( 'response' )
            // InternalBot.g:4875:2: 'response'
            {
             before(grammarAccess.getTextAccess().getResponseKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getResponseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__1__Impl"


    // $ANTLR start "rule__Text__Group__2"
    // InternalBot.g:4884:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4888:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:4889:2: rule__Text__Group__2__Impl rule__Text__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Text__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__2"


    // $ANTLR start "rule__Text__Group__2__Impl"
    // InternalBot.g:4896:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4900:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:4901:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:4901:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:4902:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:4903:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:4903:3: rule__Text__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Text__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__2__Impl"


    // $ANTLR start "rule__Text__Group__3"
    // InternalBot.g:4911:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4915:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:4916:2: rule__Text__Group__3__Impl rule__Text__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__Text__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__3"


    // $ANTLR start "rule__Text__Group__3__Impl"
    // InternalBot.g:4923:1: rule__Text__Group__3__Impl : ( ':' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4927:1: ( ( ':' ) )
            // InternalBot.g:4928:1: ( ':' )
            {
            // InternalBot.g:4928:1: ( ':' )
            // InternalBot.g:4929:2: ':'
            {
             before(grammarAccess.getTextAccess().getColonKeyword_3()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__3__Impl"


    // $ANTLR start "rule__Text__Group__4"
    // InternalBot.g:4938:1: rule__Text__Group__4 : rule__Text__Group__4__Impl rule__Text__Group__5 ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4942:1: ( rule__Text__Group__4__Impl rule__Text__Group__5 )
            // InternalBot.g:4943:2: rule__Text__Group__4__Impl rule__Text__Group__5
            {
            pushFollow(FOLLOW_51);
            rule__Text__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__4"


    // $ANTLR start "rule__Text__Group__4__Impl"
    // InternalBot.g:4950:1: rule__Text__Group__4__Impl : ( ( 'text:' )? ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4954:1: ( ( ( 'text:' )? ) )
            // InternalBot.g:4955:1: ( ( 'text:' )? )
            {
            // InternalBot.g:4955:1: ( ( 'text:' )? )
            // InternalBot.g:4956:2: ( 'text:' )?
            {
             before(grammarAccess.getTextAccess().getTextKeyword_4()); 
            // InternalBot.g:4957:2: ( 'text:' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==73) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBot.g:4957:3: 'text:'
                    {
                    match(input,73,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getTextAccess().getTextKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__4__Impl"


    // $ANTLR start "rule__Text__Group__5"
    // InternalBot.g:4965:1: rule__Text__Group__5 : rule__Text__Group__5__Impl rule__Text__Group__6 ;
    public final void rule__Text__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4969:1: ( rule__Text__Group__5__Impl rule__Text__Group__6 )
            // InternalBot.g:4970:2: rule__Text__Group__5__Impl rule__Text__Group__6
            {
            pushFollow(FOLLOW_37);
            rule__Text__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__5"


    // $ANTLR start "rule__Text__Group__5__Impl"
    // InternalBot.g:4977:1: rule__Text__Group__5__Impl : ( ( rule__Text__InputsAssignment_5 ) ) ;
    public final void rule__Text__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4981:1: ( ( ( rule__Text__InputsAssignment_5 ) ) )
            // InternalBot.g:4982:1: ( ( rule__Text__InputsAssignment_5 ) )
            {
            // InternalBot.g:4982:1: ( ( rule__Text__InputsAssignment_5 ) )
            // InternalBot.g:4983:2: ( rule__Text__InputsAssignment_5 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_5()); 
            // InternalBot.g:4984:2: ( rule__Text__InputsAssignment_5 )
            // InternalBot.g:4984:3: rule__Text__InputsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Text__InputsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__5__Impl"


    // $ANTLR start "rule__Text__Group__6"
    // InternalBot.g:4992:1: rule__Text__Group__6 : rule__Text__Group__6__Impl ;
    public final void rule__Text__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4996:1: ( rule__Text__Group__6__Impl )
            // InternalBot.g:4997:2: rule__Text__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__6"


    // $ANTLR start "rule__Text__Group__6__Impl"
    // InternalBot.g:5003:1: rule__Text__Group__6__Impl : ( ( rule__Text__Group_6__0 )* ) ;
    public final void rule__Text__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5007:1: ( ( ( rule__Text__Group_6__0 )* ) )
            // InternalBot.g:5008:1: ( ( rule__Text__Group_6__0 )* )
            {
            // InternalBot.g:5008:1: ( ( rule__Text__Group_6__0 )* )
            // InternalBot.g:5009:2: ( rule__Text__Group_6__0 )*
            {
             before(grammarAccess.getTextAccess().getGroup_6()); 
            // InternalBot.g:5010:2: ( rule__Text__Group_6__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==55) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBot.g:5010:3: rule__Text__Group_6__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Text__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getTextAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__6__Impl"


    // $ANTLR start "rule__Text__Group_6__0"
    // InternalBot.g:5019:1: rule__Text__Group_6__0 : rule__Text__Group_6__0__Impl rule__Text__Group_6__1 ;
    public final void rule__Text__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5023:1: ( rule__Text__Group_6__0__Impl rule__Text__Group_6__1 )
            // InternalBot.g:5024:2: rule__Text__Group_6__0__Impl rule__Text__Group_6__1
            {
            pushFollow(FOLLOW_51);
            rule__Text__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_6__0"


    // $ANTLR start "rule__Text__Group_6__0__Impl"
    // InternalBot.g:5031:1: rule__Text__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Text__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5035:1: ( ( ',' ) )
            // InternalBot.g:5036:1: ( ',' )
            {
            // InternalBot.g:5036:1: ( ',' )
            // InternalBot.g:5037:2: ','
            {
             before(grammarAccess.getTextAccess().getCommaKeyword_6_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_6__0__Impl"


    // $ANTLR start "rule__Text__Group_6__1"
    // InternalBot.g:5046:1: rule__Text__Group_6__1 : rule__Text__Group_6__1__Impl ;
    public final void rule__Text__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5050:1: ( rule__Text__Group_6__1__Impl )
            // InternalBot.g:5051:2: rule__Text__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_6__1"


    // $ANTLR start "rule__Text__Group_6__1__Impl"
    // InternalBot.g:5057:1: rule__Text__Group_6__1__Impl : ( ( rule__Text__InputsAssignment_6_1 ) ) ;
    public final void rule__Text__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5061:1: ( ( ( rule__Text__InputsAssignment_6_1 ) ) )
            // InternalBot.g:5062:1: ( ( rule__Text__InputsAssignment_6_1 ) )
            {
            // InternalBot.g:5062:1: ( ( rule__Text__InputsAssignment_6_1 ) )
            // InternalBot.g:5063:2: ( rule__Text__InputsAssignment_6_1 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_6_1()); 
            // InternalBot.g:5064:2: ( rule__Text__InputsAssignment_6_1 )
            // InternalBot.g:5064:3: rule__Text__InputsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Text__InputsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_6__1__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__0"
    // InternalBot.g:5073:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5077:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:5078:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__0"


    // $ANTLR start "rule__HTTPResponse__Group__0__Impl"
    // InternalBot.g:5085:1: rule__HTTPResponse__Group__0__Impl : ( 'HttpResponse' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5089:1: ( ( 'HttpResponse' ) )
            // InternalBot.g:5090:1: ( 'HttpResponse' )
            {
            // InternalBot.g:5090:1: ( 'HttpResponse' )
            // InternalBot.g:5091:2: 'HttpResponse'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__0__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__1"
    // InternalBot.g:5100:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5104:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:5105:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__HTTPResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__1"


    // $ANTLR start "rule__HTTPResponse__Group__1__Impl"
    // InternalBot.g:5112:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5116:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:5117:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:5117:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:5118:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:5119:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:5119:3: rule__HTTPResponse__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__1__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__2"
    // InternalBot.g:5127:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5131:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:5132:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__HTTPResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__2"


    // $ANTLR start "rule__HTTPResponse__Group__2__Impl"
    // InternalBot.g:5139:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5143:1: ( ( ':' ) )
            // InternalBot.g:5144:1: ( ':' )
            {
            // InternalBot.g:5144:1: ( ':' )
            // InternalBot.g:5145:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__2__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__3"
    // InternalBot.g:5154:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5158:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:5159:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__HTTPResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__3"


    // $ANTLR start "rule__HTTPResponse__Group__3__Impl"
    // InternalBot.g:5166:1: rule__HTTPResponse__Group__3__Impl : ( 'HttpRequest:' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5170:1: ( ( 'HttpRequest:' ) )
            // InternalBot.g:5171:1: ( 'HttpRequest:' )
            {
            // InternalBot.g:5171:1: ( 'HttpRequest:' )
            // InternalBot.g:5172:2: 'HttpRequest:'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__3__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__4"
    // InternalBot.g:5181:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5185:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:5186:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__HTTPResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__4"


    // $ANTLR start "rule__HTTPResponse__Group__4__Impl"
    // InternalBot.g:5193:1: rule__HTTPResponse__Group__4__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5197:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) )
            // InternalBot.g:5198:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            {
            // InternalBot.g:5198:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            // InternalBot.g:5199:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_4()); 
            // InternalBot.g:5200:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            // InternalBot.g:5200:3: rule__HTTPResponse__HTTPRequestAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__HTTPRequestAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__4__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__5"
    // InternalBot.g:5208:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5212:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:5213:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
            {
            pushFollow(FOLLOW_53);
            rule__HTTPResponse__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__5"


    // $ANTLR start "rule__HTTPResponse__Group__5__Impl"
    // InternalBot.g:5220:1: rule__HTTPResponse__Group__5__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5224:1: ( ( ';' ) )
            // InternalBot.g:5225:1: ( ';' )
            {
            // InternalBot.g:5225:1: ( ';' )
            // InternalBot.g:5226:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__5__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__6"
    // InternalBot.g:5235:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5239:1: ( rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 )
            // InternalBot.g:5240:2: rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7
            {
            pushFollow(FOLLOW_54);
            rule__HTTPResponse__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__6"


    // $ANTLR start "rule__HTTPResponse__Group__6__Impl"
    // InternalBot.g:5247:1: rule__HTTPResponse__Group__6__Impl : ( 'text:' ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5251:1: ( ( 'text:' ) )
            // InternalBot.g:5252:1: ( 'text:' )
            {
            // InternalBot.g:5252:1: ( 'text:' )
            // InternalBot.g:5253:2: 'text:'
            {
             before(grammarAccess.getHTTPResponseAccess().getTextKeyword_6()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getTextKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__6__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__7"
    // InternalBot.g:5262:1: rule__HTTPResponse__Group__7 : rule__HTTPResponse__Group__7__Impl rule__HTTPResponse__Group__8 ;
    public final void rule__HTTPResponse__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5266:1: ( rule__HTTPResponse__Group__7__Impl rule__HTTPResponse__Group__8 )
            // InternalBot.g:5267:2: rule__HTTPResponse__Group__7__Impl rule__HTTPResponse__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__HTTPResponse__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__7"


    // $ANTLR start "rule__HTTPResponse__Group__7__Impl"
    // InternalBot.g:5274:1: rule__HTTPResponse__Group__7__Impl : ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ;
    public final void rule__HTTPResponse__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5278:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) )
            // InternalBot.g:5279:1: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            {
            // InternalBot.g:5279:1: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            // InternalBot.g:5280:2: ( rule__HTTPResponse__InputsAssignment_7 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:5281:2: ( rule__HTTPResponse__InputsAssignment_7 )
            // InternalBot.g:5281:3: rule__HTTPResponse__InputsAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__InputsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__7__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__8"
    // InternalBot.g:5289:1: rule__HTTPResponse__Group__8 : rule__HTTPResponse__Group__8__Impl ;
    public final void rule__HTTPResponse__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5293:1: ( rule__HTTPResponse__Group__8__Impl )
            // InternalBot.g:5294:2: rule__HTTPResponse__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__8"


    // $ANTLR start "rule__HTTPResponse__Group__8__Impl"
    // InternalBot.g:5300:1: rule__HTTPResponse__Group__8__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5304:1: ( ( ';' ) )
            // InternalBot.g:5305:1: ( ';' )
            {
            // InternalBot.g:5305:1: ( ';' )
            // InternalBot.g:5306:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_8()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__8__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__0"
    // InternalBot.g:5316:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5320:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:5321:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
            {
            pushFollow(FOLLOW_55);
            rule__HTTPRequest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__0"


    // $ANTLR start "rule__HTTPRequest__Group__0__Impl"
    // InternalBot.g:5328:1: rule__HTTPRequest__Group__0__Impl : ( 'HTTP' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5332:1: ( ( 'HTTP' ) )
            // InternalBot.g:5333:1: ( 'HTTP' )
            {
            // InternalBot.g:5333:1: ( 'HTTP' )
            // InternalBot.g:5334:2: 'HTTP'
            {
             before(grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__1"
    // InternalBot.g:5343:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5347:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:5348:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
            {
            pushFollow(FOLLOW_56);
            rule__HTTPRequest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__1"


    // $ANTLR start "rule__HTTPRequest__Group__1__Impl"
    // InternalBot.g:5355:1: rule__HTTPRequest__Group__1__Impl : ( 'request' ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5359:1: ( ( 'request' ) )
            // InternalBot.g:5360:1: ( 'request' )
            {
            // InternalBot.g:5360:1: ( 'request' )
            // InternalBot.g:5361:2: 'request'
            {
             before(grammarAccess.getHTTPRequestAccess().getRequestKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getRequestKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__2"
    // InternalBot.g:5370:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5374:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:5375:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__2"


    // $ANTLR start "rule__HTTPRequest__Group__2__Impl"
    // InternalBot.g:5382:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__MethodAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5386:1: ( ( ( rule__HTTPRequest__MethodAssignment_2 ) ) )
            // InternalBot.g:5387:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            {
            // InternalBot.g:5387:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            // InternalBot.g:5388:2: ( rule__HTTPRequest__MethodAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_2()); 
            // InternalBot.g:5389:2: ( rule__HTTPRequest__MethodAssignment_2 )
            // InternalBot.g:5389:3: rule__HTTPRequest__MethodAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__MethodAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getMethodAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__3"
    // InternalBot.g:5397:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5401:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:5402:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__HTTPRequest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__3"


    // $ANTLR start "rule__HTTPRequest__Group__3__Impl"
    // InternalBot.g:5409:1: rule__HTTPRequest__Group__3__Impl : ( ( rule__HTTPRequest__NameAssignment_3 ) ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5413:1: ( ( ( rule__HTTPRequest__NameAssignment_3 ) ) )
            // InternalBot.g:5414:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            {
            // InternalBot.g:5414:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            // InternalBot.g:5415:2: ( rule__HTTPRequest__NameAssignment_3 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_3()); 
            // InternalBot.g:5416:2: ( rule__HTTPRequest__NameAssignment_3 )
            // InternalBot.g:5416:3: rule__HTTPRequest__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__4"
    // InternalBot.g:5424:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5428:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:5429:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
            {
            pushFollow(FOLLOW_57);
            rule__HTTPRequest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__4"


    // $ANTLR start "rule__HTTPRequest__Group__4__Impl"
    // InternalBot.g:5436:1: rule__HTTPRequest__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5440:1: ( ( ':' ) )
            // InternalBot.g:5441:1: ( ':' )
            {
            // InternalBot.g:5441:1: ( ':' )
            // InternalBot.g:5442:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_4()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__5"
    // InternalBot.g:5451:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5455:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:5456:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__HTTPRequest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__5"


    // $ANTLR start "rule__HTTPRequest__Group__5__Impl"
    // InternalBot.g:5463:1: rule__HTTPRequest__Group__5__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5467:1: ( ( 'URL' ) )
            // InternalBot.g:5468:1: ( 'URL' )
            {
            // InternalBot.g:5468:1: ( 'URL' )
            // InternalBot.g:5469:2: 'URL'
            {
             before(grammarAccess.getHTTPRequestAccess().getURLKeyword_5()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getURLKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__5__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__6"
    // InternalBot.g:5478:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5482:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:5483:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__6"


    // $ANTLR start "rule__HTTPRequest__Group__6__Impl"
    // InternalBot.g:5490:1: rule__HTTPRequest__Group__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5494:1: ( ( ':' ) )
            // InternalBot.g:5495:1: ( ':' )
            {
            // InternalBot.g:5495:1: ( ':' )
            // InternalBot.g:5496:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_6()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__7"
    // InternalBot.g:5505:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5509:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:5510:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__HTTPRequest__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__7"


    // $ANTLR start "rule__HTTPRequest__Group__7__Impl"
    // InternalBot.g:5517:1: rule__HTTPRequest__Group__7__Impl : ( ( rule__HTTPRequest__URLAssignment_7 ) ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5521:1: ( ( ( rule__HTTPRequest__URLAssignment_7 ) ) )
            // InternalBot.g:5522:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            {
            // InternalBot.g:5522:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            // InternalBot.g:5523:2: ( rule__HTTPRequest__URLAssignment_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_7()); 
            // InternalBot.g:5524:2: ( rule__HTTPRequest__URLAssignment_7 )
            // InternalBot.g:5524:3: rule__HTTPRequest__URLAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__URLAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getURLAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__7__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__8"
    // InternalBot.g:5532:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5536:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:5537:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
            {
            pushFollow(FOLLOW_58);
            rule__HTTPRequest__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__8"


    // $ANTLR start "rule__HTTPRequest__Group__8__Impl"
    // InternalBot.g:5544:1: rule__HTTPRequest__Group__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5548:1: ( ( ';' ) )
            // InternalBot.g:5549:1: ( ';' )
            {
            // InternalBot.g:5549:1: ( ';' )
            // InternalBot.g:5550:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__8__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__9"
    // InternalBot.g:5559:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5563:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:5564:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
            {
            pushFollow(FOLLOW_58);
            rule__HTTPRequest__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__9"


    // $ANTLR start "rule__HTTPRequest__Group__9__Impl"
    // InternalBot.g:5571:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5575:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:5576:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:5576:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:5577:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:5578:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==79) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBot.g:5578:3: rule__HTTPRequest__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__9__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__10"
    // InternalBot.g:5586:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5590:1: ( rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 )
            // InternalBot.g:5591:2: rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11
            {
            pushFollow(FOLLOW_58);
            rule__HTTPRequest__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__10"


    // $ANTLR start "rule__HTTPRequest__Group__10__Impl"
    // InternalBot.g:5598:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5602:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:5603:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:5603:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:5604:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:5605:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==80) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:5605:3: rule__HTTPRequest__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__10__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__11"
    // InternalBot.g:5613:1: rule__HTTPRequest__Group__11 : rule__HTTPRequest__Group__11__Impl ;
    public final void rule__HTTPRequest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5617:1: ( rule__HTTPRequest__Group__11__Impl )
            // InternalBot.g:5618:2: rule__HTTPRequest__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__11"


    // $ANTLR start "rule__HTTPRequest__Group__11__Impl"
    // InternalBot.g:5624:1: rule__HTTPRequest__Group__11__Impl : ( ( rule__HTTPRequest__Group_11__0 )? ) ;
    public final void rule__HTTPRequest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5628:1: ( ( ( rule__HTTPRequest__Group_11__0 )? ) )
            // InternalBot.g:5629:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            {
            // InternalBot.g:5629:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            // InternalBot.g:5630:2: ( rule__HTTPRequest__Group_11__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11()); 
            // InternalBot.g:5631:2: ( rule__HTTPRequest__Group_11__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==18) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBot.g:5631:3: rule__HTTPRequest__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__11__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__0"
    // InternalBot.g:5640:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5644:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:5645:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
            {
            pushFollow(FOLLOW_9);
            rule__HTTPRequest__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__0"


    // $ANTLR start "rule__HTTPRequest__Group_9__0__Impl"
    // InternalBot.g:5652:1: rule__HTTPRequest__Group_9__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5656:1: ( ( 'basicAuth' ) )
            // InternalBot.g:5657:1: ( 'basicAuth' )
            {
            // InternalBot.g:5657:1: ( 'basicAuth' )
            // InternalBot.g:5658:2: 'basicAuth'
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__1"
    // InternalBot.g:5667:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5671:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:5672:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__1"


    // $ANTLR start "rule__HTTPRequest__Group_9__1__Impl"
    // InternalBot.g:5679:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5683:1: ( ( ':' ) )
            // InternalBot.g:5684:1: ( ':' )
            {
            // InternalBot.g:5684:1: ( ':' )
            // InternalBot.g:5685:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__2"
    // InternalBot.g:5694:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5698:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:5699:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
            {
            pushFollow(FOLLOW_19);
            rule__HTTPRequest__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__2"


    // $ANTLR start "rule__HTTPRequest__Group_9__2__Impl"
    // InternalBot.g:5706:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5710:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) )
            // InternalBot.g:5711:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            {
            // InternalBot.g:5711:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            // InternalBot.g:5712:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_9_2()); 
            // InternalBot.g:5713:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            // InternalBot.g:5713:3: rule__HTTPRequest__BasicAuthAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__BasicAuthAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__3"
    // InternalBot.g:5721:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5725:1: ( rule__HTTPRequest__Group_9__3__Impl )
            // InternalBot.g:5726:2: rule__HTTPRequest__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__3"


    // $ANTLR start "rule__HTTPRequest__Group_9__3__Impl"
    // InternalBot.g:5732:1: rule__HTTPRequest__Group_9__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5736:1: ( ( ';' ) )
            // InternalBot.g:5737:1: ( ';' )
            {
            // InternalBot.g:5737:1: ( ';' )
            // InternalBot.g:5738:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__0"
    // InternalBot.g:5748:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5752:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:5753:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
            {
            pushFollow(FOLLOW_9);
            rule__HTTPRequest__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__0"


    // $ANTLR start "rule__HTTPRequest__Group_10__0__Impl"
    // InternalBot.g:5760:1: rule__HTTPRequest__Group_10__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5764:1: ( ( 'headers' ) )
            // InternalBot.g:5765:1: ( 'headers' )
            {
            // InternalBot.g:5765:1: ( 'headers' )
            // InternalBot.g:5766:2: 'headers'
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__1"
    // InternalBot.g:5775:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5779:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:5780:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__1"


    // $ANTLR start "rule__HTTPRequest__Group_10__1__Impl"
    // InternalBot.g:5787:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5791:1: ( ( ':' ) )
            // InternalBot.g:5792:1: ( ':' )
            {
            // InternalBot.g:5792:1: ( ':' )
            // InternalBot.g:5793:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__2"
    // InternalBot.g:5802:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5806:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:5807:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
            {
            pushFollow(FOLLOW_35);
            rule__HTTPRequest__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__2"


    // $ANTLR start "rule__HTTPRequest__Group_10__2__Impl"
    // InternalBot.g:5814:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5818:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) )
            // InternalBot.g:5819:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            {
            // InternalBot.g:5819:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            // InternalBot.g:5820:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_2()); 
            // InternalBot.g:5821:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            // InternalBot.g:5821:3: rule__HTTPRequest__HeadersAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__HeadersAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__3"
    // InternalBot.g:5829:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5833:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:5834:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
            {
            pushFollow(FOLLOW_35);
            rule__HTTPRequest__Group_10__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__3"


    // $ANTLR start "rule__HTTPRequest__Group_10__3__Impl"
    // InternalBot.g:5841:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5845:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:5846:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:5846:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:5847:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:5848:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==55) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBot.g:5848:3: rule__HTTPRequest__Group_10_3__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__HTTPRequest__Group_10_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__4"
    // InternalBot.g:5856:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5860:1: ( rule__HTTPRequest__Group_10__4__Impl )
            // InternalBot.g:5861:2: rule__HTTPRequest__Group_10__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__4"


    // $ANTLR start "rule__HTTPRequest__Group_10__4__Impl"
    // InternalBot.g:5867:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5871:1: ( ( ';' ) )
            // InternalBot.g:5872:1: ( ';' )
            {
            // InternalBot.g:5872:1: ( ';' )
            // InternalBot.g:5873:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__0"
    // InternalBot.g:5883:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5887:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:5888:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_10_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__0"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__0__Impl"
    // InternalBot.g:5895:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5899:1: ( ( ',' ) )
            // InternalBot.g:5900:1: ( ',' )
            {
            // InternalBot.g:5900:1: ( ',' )
            // InternalBot.g:5901:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__1"
    // InternalBot.g:5910:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5914:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:5915:2: rule__HTTPRequest__Group_10_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__1"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__1__Impl"
    // InternalBot.g:5921:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5925:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) )
            // InternalBot.g:5926:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            {
            // InternalBot.g:5926:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            // InternalBot.g:5927:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_3_1()); 
            // InternalBot.g:5928:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            // InternalBot.g:5928:3: rule__HTTPRequest__HeadersAssignment_10_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__HeadersAssignment_10_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__0"
    // InternalBot.g:5937:1: rule__HTTPRequest__Group_11__0 : rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 ;
    public final void rule__HTTPRequest__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5941:1: ( rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 )
            // InternalBot.g:5942:2: rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1
            {
            pushFollow(FOLLOW_9);
            rule__HTTPRequest__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__0"


    // $ANTLR start "rule__HTTPRequest__Group_11__0__Impl"
    // InternalBot.g:5949:1: rule__HTTPRequest__Group_11__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5953:1: ( ( 'data' ) )
            // InternalBot.g:5954:1: ( 'data' )
            {
            // InternalBot.g:5954:1: ( 'data' )
            // InternalBot.g:5955:2: 'data'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__1"
    // InternalBot.g:5964:1: rule__HTTPRequest__Group_11__1 : rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 ;
    public final void rule__HTTPRequest__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5968:1: ( rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 )
            // InternalBot.g:5969:2: rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__1"


    // $ANTLR start "rule__HTTPRequest__Group_11__1__Impl"
    // InternalBot.g:5976:1: rule__HTTPRequest__Group_11__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5980:1: ( ( ':' ) )
            // InternalBot.g:5981:1: ( ':' )
            {
            // InternalBot.g:5981:1: ( ':' )
            // InternalBot.g:5982:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__2"
    // InternalBot.g:5991:1: rule__HTTPRequest__Group_11__2 : rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 ;
    public final void rule__HTTPRequest__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5995:1: ( rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 )
            // InternalBot.g:5996:2: rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3
            {
            pushFollow(FOLLOW_35);
            rule__HTTPRequest__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__2"


    // $ANTLR start "rule__HTTPRequest__Group_11__2__Impl"
    // InternalBot.g:6003:1: rule__HTTPRequest__Group_11__2__Impl : ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) ;
    public final void rule__HTTPRequest__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6007:1: ( ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) )
            // InternalBot.g:6008:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            {
            // InternalBot.g:6008:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            // InternalBot.g:6009:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_2()); 
            // InternalBot.g:6010:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            // InternalBot.g:6010:3: rule__HTTPRequest__DataAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__3"
    // InternalBot.g:6018:1: rule__HTTPRequest__Group_11__3 : rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 ;
    public final void rule__HTTPRequest__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6022:1: ( rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 )
            // InternalBot.g:6023:2: rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4
            {
            pushFollow(FOLLOW_35);
            rule__HTTPRequest__Group_11__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__3"


    // $ANTLR start "rule__HTTPRequest__Group_11__3__Impl"
    // InternalBot.g:6030:1: rule__HTTPRequest__Group_11__3__Impl : ( ( rule__HTTPRequest__Group_11_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6034:1: ( ( ( rule__HTTPRequest__Group_11_3__0 )* ) )
            // InternalBot.g:6035:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            {
            // InternalBot.g:6035:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            // InternalBot.g:6036:2: ( rule__HTTPRequest__Group_11_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11_3()); 
            // InternalBot.g:6037:2: ( rule__HTTPRequest__Group_11_3__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==55) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:6037:3: rule__HTTPRequest__Group_11_3__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__HTTPRequest__Group_11_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getHTTPRequestAccess().getGroup_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__4"
    // InternalBot.g:6045:1: rule__HTTPRequest__Group_11__4 : rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 ;
    public final void rule__HTTPRequest__Group_11__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6049:1: ( rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 )
            // InternalBot.g:6050:2: rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5
            {
            pushFollow(FOLLOW_59);
            rule__HTTPRequest__Group_11__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__4"


    // $ANTLR start "rule__HTTPRequest__Group_11__4__Impl"
    // InternalBot.g:6057:1: rule__HTTPRequest__Group_11__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6061:1: ( ( ';' ) )
            // InternalBot.g:6062:1: ( ';' )
            {
            // InternalBot.g:6062:1: ( ';' )
            // InternalBot.g:6063:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__5"
    // InternalBot.g:6072:1: rule__HTTPRequest__Group_11__5 : rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 ;
    public final void rule__HTTPRequest__Group_11__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6076:1: ( rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 )
            // InternalBot.g:6077:2: rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6
            {
            pushFollow(FOLLOW_9);
            rule__HTTPRequest__Group_11__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__5"


    // $ANTLR start "rule__HTTPRequest__Group_11__5__Impl"
    // InternalBot.g:6084:1: rule__HTTPRequest__Group_11__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_11__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6088:1: ( ( 'dataType' ) )
            // InternalBot.g:6089:1: ( 'dataType' )
            {
            // InternalBot.g:6089:1: ( 'dataType' )
            // InternalBot.g:6090:2: 'dataType'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__5__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__6"
    // InternalBot.g:6099:1: rule__HTTPRequest__Group_11__6 : rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 ;
    public final void rule__HTTPRequest__Group_11__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6103:1: ( rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 )
            // InternalBot.g:6104:2: rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7
            {
            pushFollow(FOLLOW_60);
            rule__HTTPRequest__Group_11__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__6"


    // $ANTLR start "rule__HTTPRequest__Group_11__6__Impl"
    // InternalBot.g:6111:1: rule__HTTPRequest__Group_11__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6115:1: ( ( ':' ) )
            // InternalBot.g:6116:1: ( ':' )
            {
            // InternalBot.g:6116:1: ( ':' )
            // InternalBot.g:6117:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__7"
    // InternalBot.g:6126:1: rule__HTTPRequest__Group_11__7 : rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 ;
    public final void rule__HTTPRequest__Group_11__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6130:1: ( rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 )
            // InternalBot.g:6131:2: rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8
            {
            pushFollow(FOLLOW_19);
            rule__HTTPRequest__Group_11__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__7"


    // $ANTLR start "rule__HTTPRequest__Group_11__7__Impl"
    // InternalBot.g:6138:1: rule__HTTPRequest__Group_11__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) ;
    public final void rule__HTTPRequest__Group_11__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6142:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) )
            // InternalBot.g:6143:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            {
            // InternalBot.g:6143:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            // InternalBot.g:6144:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_11_7()); 
            // InternalBot.g:6145:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            // InternalBot.g:6145:3: rule__HTTPRequest__DataTypeAssignment_11_7
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataTypeAssignment_11_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_11_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__7__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__8"
    // InternalBot.g:6153:1: rule__HTTPRequest__Group_11__8 : rule__HTTPRequest__Group_11__8__Impl ;
    public final void rule__HTTPRequest__Group_11__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6157:1: ( rule__HTTPRequest__Group_11__8__Impl )
            // InternalBot.g:6158:2: rule__HTTPRequest__Group_11__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__8"


    // $ANTLR start "rule__HTTPRequest__Group_11__8__Impl"
    // InternalBot.g:6164:1: rule__HTTPRequest__Group_11__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6168:1: ( ( ';' ) )
            // InternalBot.g:6169:1: ( ';' )
            {
            // InternalBot.g:6169:1: ( ';' )
            // InternalBot.g:6170:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__8__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__0"
    // InternalBot.g:6180:1: rule__HTTPRequest__Group_11_3__0 : rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 ;
    public final void rule__HTTPRequest__Group_11_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6184:1: ( rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 )
            // InternalBot.g:6185:2: rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_11_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__0"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__0__Impl"
    // InternalBot.g:6192:1: rule__HTTPRequest__Group_11_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_11_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6196:1: ( ( ',' ) )
            // InternalBot.g:6197:1: ( ',' )
            {
            // InternalBot.g:6197:1: ( ',' )
            // InternalBot.g:6198:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__1"
    // InternalBot.g:6207:1: rule__HTTPRequest__Group_11_3__1 : rule__HTTPRequest__Group_11_3__1__Impl ;
    public final void rule__HTTPRequest__Group_11_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6211:1: ( rule__HTTPRequest__Group_11_3__1__Impl )
            // InternalBot.g:6212:2: rule__HTTPRequest__Group_11_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__1"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__1__Impl"
    // InternalBot.g:6218:1: rule__HTTPRequest__Group_11_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_11_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6222:1: ( ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) )
            // InternalBot.g:6223:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            {
            // InternalBot.g:6223:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            // InternalBot.g:6224:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_3_1()); 
            // InternalBot.g:6225:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            // InternalBot.g:6225:3: rule__HTTPRequest__DataAssignment_11_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataAssignment_11_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__1__Impl"


    // $ANTLR start "rule__Image__Group__0"
    // InternalBot.g:6234:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6238:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:6239:2: rule__Image__Group__0__Impl rule__Image__Group__1
            {
            pushFollow(FOLLOW_50);
            rule__Image__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__0"


    // $ANTLR start "rule__Image__Group__0__Impl"
    // InternalBot.g:6246:1: rule__Image__Group__0__Impl : ( 'image' ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6250:1: ( ( 'image' ) )
            // InternalBot.g:6251:1: ( 'image' )
            {
            // InternalBot.g:6251:1: ( 'image' )
            // InternalBot.g:6252:2: 'image'
            {
             before(grammarAccess.getImageAccess().getImageKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getImageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__0__Impl"


    // $ANTLR start "rule__Image__Group__1"
    // InternalBot.g:6261:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6265:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:6266:2: rule__Image__Group__1__Impl rule__Image__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Image__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__1"


    // $ANTLR start "rule__Image__Group__1__Impl"
    // InternalBot.g:6273:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6277:1: ( ( 'response' ) )
            // InternalBot.g:6278:1: ( 'response' )
            {
            // InternalBot.g:6278:1: ( 'response' )
            // InternalBot.g:6279:2: 'response'
            {
             before(grammarAccess.getImageAccess().getResponseKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getResponseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__1__Impl"


    // $ANTLR start "rule__Image__Group__2"
    // InternalBot.g:6288:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6292:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:6293:2: rule__Image__Group__2__Impl rule__Image__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Image__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__2"


    // $ANTLR start "rule__Image__Group__2__Impl"
    // InternalBot.g:6300:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6304:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:6305:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:6305:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:6306:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:6307:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:6307:3: rule__Image__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Image__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__2__Impl"


    // $ANTLR start "rule__Image__Group__3"
    // InternalBot.g:6315:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6319:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:6320:2: rule__Image__Group__3__Impl rule__Image__Group__4
            {
            pushFollow(FOLLOW_57);
            rule__Image__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__3"


    // $ANTLR start "rule__Image__Group__3__Impl"
    // InternalBot.g:6327:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6331:1: ( ( ':' ) )
            // InternalBot.g:6332:1: ( ':' )
            {
            // InternalBot.g:6332:1: ( ':' )
            // InternalBot.g:6333:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_3()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__3__Impl"


    // $ANTLR start "rule__Image__Group__4"
    // InternalBot.g:6342:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6346:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:6347:2: rule__Image__Group__4__Impl rule__Image__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Image__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__4"


    // $ANTLR start "rule__Image__Group__4__Impl"
    // InternalBot.g:6354:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6358:1: ( ( 'URL' ) )
            // InternalBot.g:6359:1: ( 'URL' )
            {
            // InternalBot.g:6359:1: ( 'URL' )
            // InternalBot.g:6360:2: 'URL'
            {
             before(grammarAccess.getImageAccess().getURLKeyword_4()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getURLKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__4__Impl"


    // $ANTLR start "rule__Image__Group__5"
    // InternalBot.g:6369:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6373:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:6374:2: rule__Image__Group__5__Impl rule__Image__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Image__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__5"


    // $ANTLR start "rule__Image__Group__5__Impl"
    // InternalBot.g:6381:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6385:1: ( ( ':' ) )
            // InternalBot.g:6386:1: ( ':' )
            {
            // InternalBot.g:6386:1: ( ':' )
            // InternalBot.g:6387:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_5()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__5__Impl"


    // $ANTLR start "rule__Image__Group__6"
    // InternalBot.g:6396:1: rule__Image__Group__6 : rule__Image__Group__6__Impl ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6400:1: ( rule__Image__Group__6__Impl )
            // InternalBot.g:6401:2: rule__Image__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Image__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__6"


    // $ANTLR start "rule__Image__Group__6__Impl"
    // InternalBot.g:6407:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6411:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:6412:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:6412:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:6413:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:6414:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:6414:3: rule__Image__URLAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Image__URLAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getURLAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__6__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // InternalBot.g:6423:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6427:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:6428:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0"


    // $ANTLR start "rule__KeyValue__Group__0__Impl"
    // InternalBot.g:6435:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6439:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:6440:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:6440:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:6441:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:6442:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:6442:3: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0__Impl"


    // $ANTLR start "rule__KeyValue__Group__1"
    // InternalBot.g:6450:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6454:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:6455:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1"


    // $ANTLR start "rule__KeyValue__Group__1__Impl"
    // InternalBot.g:6462:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6466:1: ( ( ':' ) )
            // InternalBot.g:6467:1: ( ':' )
            {
            // InternalBot.g:6467:1: ( ':' )
            // InternalBot.g:6468:2: ':'
            {
             before(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__2"
    // InternalBot.g:6477:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6481:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:6482:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2"


    // $ANTLR start "rule__KeyValue__Group__2__Impl"
    // InternalBot.g:6488:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6492:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:6493:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:6493:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:6494:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:6495:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:6495:3: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2__Impl"


    // $ANTLR start "rule__Data__Group__0"
    // InternalBot.g:6504:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6508:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:6509:2: rule__Data__Group__0__Impl rule__Data__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Data__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Data__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__0"


    // $ANTLR start "rule__Data__Group__0__Impl"
    // InternalBot.g:6516:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6520:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:6521:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:6521:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:6522:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:6523:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:6523:3: rule__Data__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Data__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__0__Impl"


    // $ANTLR start "rule__Data__Group__1"
    // InternalBot.g:6531:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6535:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:6536:2: rule__Data__Group__1__Impl rule__Data__Group__2
            {
            pushFollow(FOLLOW_61);
            rule__Data__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Data__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__1"


    // $ANTLR start "rule__Data__Group__1__Impl"
    // InternalBot.g:6543:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6547:1: ( ( ':' ) )
            // InternalBot.g:6548:1: ( ':' )
            {
            // InternalBot.g:6548:1: ( ':' )
            // InternalBot.g:6549:2: ':'
            {
             before(grammarAccess.getDataAccess().getColonKeyword_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getDataAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__1__Impl"


    // $ANTLR start "rule__Data__Group__2"
    // InternalBot.g:6558:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6562:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:6563:2: rule__Data__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Data__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__2"


    // $ANTLR start "rule__Data__Group__2__Impl"
    // InternalBot.g:6569:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6573:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:6574:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:6574:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:6575:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:6576:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:6576:3: rule__Data__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Data__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__2__Impl"


    // $ANTLR start "rule__Bot__NameAssignment_1"
    // InternalBot.g:6585:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6589:1: ( ( ruleEString ) )
            // InternalBot.g:6590:2: ( ruleEString )
            {
            // InternalBot.g:6590:2: ( ruleEString )
            // InternalBot.g:6591:3: ruleEString
            {
             before(grammarAccess.getBotAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getBotAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__NameAssignment_1"


    // $ANTLR start "rule__Bot__LanguageAssignment_3"
    // InternalBot.g:6600:1: rule__Bot__LanguageAssignment_3 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6604:1: ( ( ruleLanguage ) )
            // InternalBot.g:6605:2: ( ruleLanguage )
            {
            // InternalBot.g:6605:2: ( ruleLanguage )
            // InternalBot.g:6606:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguageLanguageEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguageLanguageEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguageAssignment_3"


    // $ANTLR start "rule__Bot__IntentsAssignment_6"
    // InternalBot.g:6615:1: rule__Bot__IntentsAssignment_6 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6619:1: ( ( ruleIntent ) )
            // InternalBot.g:6620:2: ( ruleIntent )
            {
            // InternalBot.g:6620:2: ( ruleIntent )
            // InternalBot.g:6621:3: ruleIntent
            {
             before(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__IntentsAssignment_6"


    // $ANTLR start "rule__Bot__IntentsAssignment_7"
    // InternalBot.g:6630:1: rule__Bot__IntentsAssignment_7 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6634:1: ( ( ruleIntent ) )
            // InternalBot.g:6635:2: ( ruleIntent )
            {
            // InternalBot.g:6635:2: ( ruleIntent )
            // InternalBot.g:6636:3: ruleIntent
            {
             before(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__IntentsAssignment_7"


    // $ANTLR start "rule__Bot__EntitiesAssignment_8_2"
    // InternalBot.g:6645:1: rule__Bot__EntitiesAssignment_8_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6649:1: ( ( ruleEntity ) )
            // InternalBot.g:6650:2: ( ruleEntity )
            {
            // InternalBot.g:6650:2: ( ruleEntity )
            // InternalBot.g:6651:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_8_2"


    // $ANTLR start "rule__Bot__EntitiesAssignment_8_3"
    // InternalBot.g:6660:1: rule__Bot__EntitiesAssignment_8_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6664:1: ( ( ruleEntity ) )
            // InternalBot.g:6665:2: ( ruleEntity )
            {
            // InternalBot.g:6665:2: ( ruleEntity )
            // InternalBot.g:6666:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_8_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_8_3"


    // $ANTLR start "rule__Bot__ActionsAssignment_9_2"
    // InternalBot.g:6675:1: rule__Bot__ActionsAssignment_9_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6679:1: ( ( ruleAction ) )
            // InternalBot.g:6680:2: ( ruleAction )
            {
            // InternalBot.g:6680:2: ( ruleAction )
            // InternalBot.g:6681:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_9_2"


    // $ANTLR start "rule__Bot__ActionsAssignment_9_3"
    // InternalBot.g:6690:1: rule__Bot__ActionsAssignment_9_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6694:1: ( ( ruleAction ) )
            // InternalBot.g:6695:2: ( ruleAction )
            {
            // InternalBot.g:6695:2: ( ruleAction )
            // InternalBot.g:6696:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_9_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_9_3"


    // $ANTLR start "rule__Bot__FlowsAssignment_12_1"
    // InternalBot.g:6705:1: rule__Bot__FlowsAssignment_12_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_12_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6709:1: ( ( ruleTransition ) )
            // InternalBot.g:6710:2: ( ruleTransition )
            {
            // InternalBot.g:6710:2: ( ruleTransition )
            // InternalBot.g:6711:3: ruleTransition
            {
             before(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_12_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_12_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__FlowsAssignment_12_1"


    // $ANTLR start "rule__Intent__NameAssignment_0"
    // InternalBot.g:6720:1: rule__Intent__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6724:1: ( ( ruleEString ) )
            // InternalBot.g:6725:2: ( ruleEString )
            {
            // InternalBot.g:6725:2: ( ruleEString )
            // InternalBot.g:6726:3: ruleEString
            {
             before(grammarAccess.getIntentAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__NameAssignment_0"


    // $ANTLR start "rule__Intent__FallbackIntentAssignment_1"
    // InternalBot.g:6735:1: rule__Intent__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6739:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:6740:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:6740:2: ( ( 'Fallback' ) )
            // InternalBot.g:6741:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:6742:3: ( 'Fallback' )
            // InternalBot.g:6743:4: 'Fallback'
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 

            }

             after(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__FallbackIntentAssignment_1"


    // $ANTLR start "rule__Intent__InputsAssignment_4"
    // InternalBot.g:6754:1: rule__Intent__InputsAssignment_4 : ( ruleTrainingPhrase ) ;
    public final void rule__Intent__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6758:1: ( ( ruleTrainingPhrase ) )
            // InternalBot.g:6759:2: ( ruleTrainingPhrase )
            {
            // InternalBot.g:6759:2: ( ruleTrainingPhrase )
            // InternalBot.g:6760:3: ruleTrainingPhrase
            {
             before(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__InputsAssignment_4"


    // $ANTLR start "rule__Intent__InputsAssignment_5_1"
    // InternalBot.g:6769:1: rule__Intent__InputsAssignment_5_1 : ( ruleTrainingPhrase ) ;
    public final void rule__Intent__InputsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6773:1: ( ( ruleTrainingPhrase ) )
            // InternalBot.g:6774:2: ( ruleTrainingPhrase )
            {
            // InternalBot.g:6774:2: ( ruleTrainingPhrase )
            // InternalBot.g:6775:3: ruleTrainingPhrase
            {
             before(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__InputsAssignment_5_1"


    // $ANTLR start "rule__Intent__ParametersAssignment_6_1"
    // InternalBot.g:6784:1: rule__Intent__ParametersAssignment_6_1 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6788:1: ( ( ruleParameter ) )
            // InternalBot.g:6789:2: ( ruleParameter )
            {
            // InternalBot.g:6789:2: ( ruleParameter )
            // InternalBot.g:6790:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_6_1"


    // $ANTLR start "rule__Intent__ParametersAssignment_6_2"
    // InternalBot.g:6799:1: rule__Intent__ParametersAssignment_6_2 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6803:1: ( ( ruleParameter ) )
            // InternalBot.g:6804:2: ( ruleParameter )
            {
            // InternalBot.g:6804:2: ( ruleParameter )
            // InternalBot.g:6805:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_6_2"


    // $ANTLR start "rule__Transition__IntentAssignment_1"
    // InternalBot.g:6814:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6818:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:6819:2: ( ( ruleEString ) )
            {
            // InternalBot.g:6819:2: ( ( ruleEString ) )
            // InternalBot.g:6820:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:6821:3: ( ruleEString )
            // InternalBot.g:6822:4: ruleEString
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getIntentIntentEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__IntentAssignment_1"


    // $ANTLR start "rule__Transition__TargetAssignment_2_1"
    // InternalBot.g:6833:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6837:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:6838:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:6838:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:6839:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:6840:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:6840:4: rule__Transition__TargetAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__TargetAlternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__TargetAssignment_2_1"


    // $ANTLR start "rule__State__ActionsAssignment_2"
    // InternalBot.g:6848:1: rule__State__ActionsAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6852:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:6853:2: ( ( ruleEString ) )
            {
            // InternalBot.g:6853:2: ( ( ruleEString ) )
            // InternalBot.g:6854:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0()); 
            // InternalBot.g:6855:3: ( ruleEString )
            // InternalBot.g:6856:4: ruleEString
            {
             before(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_2"


    // $ANTLR start "rule__State__ActionsAssignment_3_1"
    // InternalBot.g:6867:1: rule__State__ActionsAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6871:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:6872:2: ( ( ruleEString ) )
            {
            // InternalBot.g:6872:2: ( ( ruleEString ) )
            // InternalBot.g:6873:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0()); 
            // InternalBot.g:6874:3: ( ruleEString )
            // InternalBot.g:6875:4: ruleEString
            {
             before(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_3_1"


    // $ANTLR start "rule__State__OutcomingAssignment_5_1"
    // InternalBot.g:6886:1: rule__State__OutcomingAssignment_5_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6890:1: ( ( ruleTransition ) )
            // InternalBot.g:6891:2: ( ruleTransition )
            {
            // InternalBot.g:6891:2: ( ruleTransition )
            // InternalBot.g:6892:3: ruleTransition
            {
             before(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__OutcomingAssignment_5_1"


    // $ANTLR start "rule__State2__ActionsAssignment_2"
    // InternalBot.g:6901:1: rule__State2__ActionsAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6905:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:6906:2: ( ( ruleEString ) )
            {
            // InternalBot.g:6906:2: ( ( ruleEString ) )
            // InternalBot.g:6907:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_0()); 
            // InternalBot.g:6908:3: ( ruleEString )
            // InternalBot.g:6909:4: ruleEString
            {
             before(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getState2Access().getActionsActionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__ActionsAssignment_2"


    // $ANTLR start "rule__State2__ActionsAssignment_3_1"
    // InternalBot.g:6920:1: rule__State2__ActionsAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6924:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:6925:2: ( ( ruleEString ) )
            {
            // InternalBot.g:6925:2: ( ( ruleEString ) )
            // InternalBot.g:6926:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0()); 
            // InternalBot.g:6927:3: ( ruleEString )
            // InternalBot.g:6928:4: ruleEString
            {
             before(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__ActionsAssignment_3_1"


    // $ANTLR start "rule__State2__OutcomingAssignment_6_1"
    // InternalBot.g:6939:1: rule__State2__OutcomingAssignment_6_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6943:1: ( ( ruleTransition ) )
            // InternalBot.g:6944:2: ( ruleTransition )
            {
            // InternalBot.g:6944:2: ( ruleTransition )
            // InternalBot.g:6945:3: ruleTransition
            {
             before(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__OutcomingAssignment_6_1"


    // $ANTLR start "rule__TrainingPhrase__TokensAssignment_1"
    // InternalBot.g:6954:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6958:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:6959:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:6959:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:6960:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:6961:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:6961:4: rule__TrainingPhrase__TokensAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__TokensAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__TokensAssignment_1"


    // $ANTLR start "rule__Parameter__NameAssignment_0"
    // InternalBot.g:6969:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6973:1: ( ( ruleEString ) )
            // InternalBot.g:6974:2: ( ruleEString )
            {
            // InternalBot.g:6974:2: ( ruleEString )
            // InternalBot.g:6975:3: ruleEString
            {
             before(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment_0"


    // $ANTLR start "rule__Parameter__EntityAssignment_3_0"
    // InternalBot.g:6984:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6988:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:6989:2: ( ( ruleEString ) )
            {
            // InternalBot.g:6989:2: ( ( ruleEString ) )
            // InternalBot.g:6990:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:6991:3: ( ruleEString )
            // InternalBot.g:6992:4: ruleEString
            {
             before(grammarAccess.getParameterAccess().getEntityEntityEStringParserRuleCall_3_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getEntityEntityEStringParserRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__EntityAssignment_3_0"


    // $ANTLR start "rule__Parameter__DefaultEntityAssignment_3_1"
    // InternalBot.g:7003:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7007:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:7008:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:7008:2: ( ruleDefaultEntity )
            // InternalBot.g:7009:3: ruleDefaultEntity
            {
             before(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDefaultEntity();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__DefaultEntityAssignment_3_1"


    // $ANTLR start "rule__Parameter__RequiredAssignment_4_1"
    // InternalBot.g:7018:1: rule__Parameter__RequiredAssignment_4_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7022:1: ( ( ( 'required' ) ) )
            // InternalBot.g:7023:2: ( ( 'required' ) )
            {
            // InternalBot.g:7023:2: ( ( 'required' ) )
            // InternalBot.g:7024:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            // InternalBot.g:7025:3: ( 'required' )
            // InternalBot.g:7026:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 

            }

             after(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__RequiredAssignment_4_1"


    // $ANTLR start "rule__Parameter__PromptsAssignment_4_2_3"
    // InternalBot.g:7037:1: rule__Parameter__PromptsAssignment_4_2_3 : ( ruleEString ) ;
    public final void rule__Parameter__PromptsAssignment_4_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7041:1: ( ( ruleEString ) )
            // InternalBot.g:7042:2: ( ruleEString )
            {
            // InternalBot.g:7042:2: ( ruleEString )
            // InternalBot.g:7043:3: ruleEString
            {
             before(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_4_2_3"


    // $ANTLR start "rule__Parameter__PromptsAssignment_4_2_4_1"
    // InternalBot.g:7052:1: rule__Parameter__PromptsAssignment_4_2_4_1 : ( ruleEString ) ;
    public final void rule__Parameter__PromptsAssignment_4_2_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7056:1: ( ( ruleEString ) )
            // InternalBot.g:7057:2: ( ruleEString )
            {
            // InternalBot.g:7057:2: ( ruleEString )
            // InternalBot.g:7058:3: ruleEString
            {
             before(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_4_2_4_1"


    // $ANTLR start "rule__Parameter__IsListAssignment_5_1"
    // InternalBot.g:7067:1: rule__Parameter__IsListAssignment_5_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7071:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:7072:2: ( ( 'isList' ) )
            {
            // InternalBot.g:7072:2: ( ( 'isList' ) )
            // InternalBot.g:7073:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 
            // InternalBot.g:7074:3: ( 'isList' )
            // InternalBot.g:7075:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 

            }

             after(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__IsListAssignment_5_1"


    // $ANTLR start "rule__Literal__TextAssignment"
    // InternalBot.g:7086:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7090:1: ( ( ruleEString ) )
            // InternalBot.g:7091:2: ( ruleEString )
            {
            // InternalBot.g:7091:2: ( ruleEString )
            // InternalBot.g:7092:3: ruleEString
            {
             before(grammarAccess.getLiteralAccess().getTextEStringParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLiteralAccess().getTextEStringParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__TextAssignment"


    // $ANTLR start "rule__EntityToken__EntityAssignment_1"
    // InternalBot.g:7101:1: rule__EntityToken__EntityAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7105:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7106:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7106:2: ( ( ruleEString ) )
            // InternalBot.g:7107:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 
            // InternalBot.g:7108:3: ( ruleEString )
            // InternalBot.g:7109:4: ruleEString
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEntityTokenAccess().getEntityEntityEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__EntityAssignment_1"


    // $ANTLR start "rule__ParameterToken__ParameterAssignment_1"
    // InternalBot.g:7120:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7124:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7125:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7125:2: ( ( ruleEString ) )
            // InternalBot.g:7126:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:7127:3: ( ruleEString )
            // InternalBot.g:7128:4: ruleEString
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterTokenAccess().getParameterParameterEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__ParameterAssignment_1"


    // $ANTLR start "rule__ParameterRefenceToken__TextReferenceAssignment_1"
    // InternalBot.g:7139:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7143:1: ( ( ruleEString ) )
            // InternalBot.g:7144:2: ( ruleEString )
            {
            // InternalBot.g:7144:2: ( ruleEString )
            // InternalBot.g:7145:3: ruleEString
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__TextReferenceAssignment_1"


    // $ANTLR start "rule__ParameterRefenceToken__ParameterAssignment_4"
    // InternalBot.g:7154:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7158:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7159:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7159:2: ( ( ruleEString ) )
            // InternalBot.g:7160:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:7161:3: ( ruleEString )
            // InternalBot.g:7162:4: ruleEString
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__ParameterAssignment_4"


    // $ANTLR start "rule__HTTPRequestToken__TypeAssignment_1"
    // InternalBot.g:7173:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7177:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:7178:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:7178:2: ( ruleHTTPReturnType )
            // InternalBot.g:7179:3: ruleHTTPReturnType
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHTTPReturnType();

            state._fsp--;

             after(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__TypeAssignment_1"


    // $ANTLR start "rule__HTTPRequestToken__DataKeyAssignment_2_1"
    // InternalBot.g:7188:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7192:1: ( ( ruleEString ) )
            // InternalBot.g:7193:2: ( ruleEString )
            {
            // InternalBot.g:7193:2: ( ruleEString )
            // InternalBot.g:7194:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestTokenAccess().getDataKeyEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__DataKeyAssignment_2_1"


    // $ANTLR start "rule__Simple__NameAssignment_3"
    // InternalBot.g:7203:1: rule__Simple__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__Simple__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7207:1: ( ( ruleEString ) )
            // InternalBot.g:7208:2: ( ruleEString )
            {
            // InternalBot.g:7208:2: ( ruleEString )
            // InternalBot.g:7209:3: ruleEString
            {
             before(grammarAccess.getSimpleAccess().getNameEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getNameEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__NameAssignment_3"


    // $ANTLR start "rule__Simple__InputsAssignment_5_0"
    // InternalBot.g:7218:1: rule__Simple__InputsAssignment_5_0 : ( ruleSimpleInput ) ;
    public final void rule__Simple__InputsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7222:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:7223:2: ( ruleSimpleInput )
            {
            // InternalBot.g:7223:2: ( ruleSimpleInput )
            // InternalBot.g:7224:3: ruleSimpleInput
            {
             before(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__InputsAssignment_5_0"


    // $ANTLR start "rule__Simple__InputsAssignment_5_1"
    // InternalBot.g:7233:1: rule__Simple__InputsAssignment_5_1 : ( ruleSimpleInput ) ;
    public final void rule__Simple__InputsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7237:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:7238:2: ( ruleSimpleInput )
            {
            // InternalBot.g:7238:2: ( ruleSimpleInput )
            // InternalBot.g:7239:3: ruleSimpleInput
            {
             before(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__InputsAssignment_5_1"


    // $ANTLR start "rule__Composite__NameAssignment_3"
    // InternalBot.g:7248:1: rule__Composite__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__Composite__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7252:1: ( ( ruleEString ) )
            // InternalBot.g:7253:2: ( ruleEString )
            {
            // InternalBot.g:7253:2: ( ruleEString )
            // InternalBot.g:7254:3: ruleEString
            {
             before(grammarAccess.getCompositeAccess().getNameEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getNameEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__NameAssignment_3"


    // $ANTLR start "rule__Composite__InputsAssignment_5_0"
    // InternalBot.g:7263:1: rule__Composite__InputsAssignment_5_0 : ( ruleCompositeInput ) ;
    public final void rule__Composite__InputsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7267:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:7268:2: ( ruleCompositeInput )
            {
            // InternalBot.g:7268:2: ( ruleCompositeInput )
            // InternalBot.g:7269:3: ruleCompositeInput
            {
             before(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__InputsAssignment_5_0"


    // $ANTLR start "rule__Composite__InputsAssignment_5_1"
    // InternalBot.g:7278:1: rule__Composite__InputsAssignment_5_1 : ( ruleCompositeInput ) ;
    public final void rule__Composite__InputsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7282:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:7283:2: ( ruleCompositeInput )
            {
            // InternalBot.g:7283:2: ( ruleCompositeInput )
            // InternalBot.g:7284:3: ruleCompositeInput
            {
             before(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__InputsAssignment_5_1"


    // $ANTLR start "rule__SimpleInput__NameAssignment_1"
    // InternalBot.g:7293:1: rule__SimpleInput__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7297:1: ( ( ruleEString ) )
            // InternalBot.g:7298:2: ( ruleEString )
            {
            // InternalBot.g:7298:2: ( ruleEString )
            // InternalBot.g:7299:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__NameAssignment_1"


    // $ANTLR start "rule__SimpleInput__ValuesAssignment_2_1"
    // InternalBot.g:7308:1: rule__SimpleInput__ValuesAssignment_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7312:1: ( ( ruleEString ) )
            // InternalBot.g:7313:2: ( ruleEString )
            {
            // InternalBot.g:7313:2: ( ruleEString )
            // InternalBot.g:7314:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__ValuesAssignment_2_1"


    // $ANTLR start "rule__SimpleInput__ValuesAssignment_2_2_1"
    // InternalBot.g:7323:1: rule__SimpleInput__ValuesAssignment_2_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7327:1: ( ( ruleEString ) )
            // InternalBot.g:7328:2: ( ruleEString )
            {
            // InternalBot.g:7328:2: ( ruleEString )
            // InternalBot.g:7329:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__ValuesAssignment_2_2_1"


    // $ANTLR start "rule__CompositeInput__TokensAssignment_0"
    // InternalBot.g:7338:1: rule__CompositeInput__TokensAssignment_0 : ( ( rule__CompositeInput__TokensAlternatives_0_0 ) ) ;
    public final void rule__CompositeInput__TokensAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7342:1: ( ( ( rule__CompositeInput__TokensAlternatives_0_0 ) ) )
            // InternalBot.g:7343:2: ( ( rule__CompositeInput__TokensAlternatives_0_0 ) )
            {
            // InternalBot.g:7343:2: ( ( rule__CompositeInput__TokensAlternatives_0_0 ) )
            // InternalBot.g:7344:3: ( rule__CompositeInput__TokensAlternatives_0_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAlternatives_0_0()); 
            // InternalBot.g:7345:3: ( rule__CompositeInput__TokensAlternatives_0_0 )
            // InternalBot.g:7345:4: rule__CompositeInput__TokensAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__CompositeInput__TokensAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getTokensAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__TokensAssignment_0"


    // $ANTLR start "rule__Text__NameAssignment_2"
    // InternalBot.g:7353:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7357:1: ( ( ruleEString ) )
            // InternalBot.g:7358:2: ( ruleEString )
            {
            // InternalBot.g:7358:2: ( ruleEString )
            // InternalBot.g:7359:3: ruleEString
            {
             before(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__NameAssignment_2"


    // $ANTLR start "rule__Text__InputsAssignment_5"
    // InternalBot.g:7368:1: rule__Text__InputsAssignment_5 : ( ruleTextInputText ) ;
    public final void rule__Text__InputsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7372:1: ( ( ruleTextInputText ) )
            // InternalBot.g:7373:2: ( ruleTextInputText )
            {
            // InternalBot.g:7373:2: ( ruleTextInputText )
            // InternalBot.g:7374:3: ruleTextInputText
            {
             before(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__InputsAssignment_5"


    // $ANTLR start "rule__Text__InputsAssignment_6_1"
    // InternalBot.g:7383:1: rule__Text__InputsAssignment_6_1 : ( ruleTextInputText ) ;
    public final void rule__Text__InputsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7387:1: ( ( ruleTextInputText ) )
            // InternalBot.g:7388:2: ( ruleTextInputText )
            {
            // InternalBot.g:7388:2: ( ruleTextInputText )
            // InternalBot.g:7389:3: ruleTextInputText
            {
             before(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__InputsAssignment_6_1"


    // $ANTLR start "rule__HTTPResponse__NameAssignment_1"
    // InternalBot.g:7398:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7402:1: ( ( ruleEString ) )
            // InternalBot.g:7403:2: ( ruleEString )
            {
            // InternalBot.g:7403:2: ( ruleEString )
            // InternalBot.g:7404:3: ruleEString
            {
             before(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__NameAssignment_1"


    // $ANTLR start "rule__HTTPResponse__HTTPRequestAssignment_4"
    // InternalBot.g:7413:1: rule__HTTPResponse__HTTPRequestAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7417:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7418:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7418:2: ( ( ruleEString ) )
            // InternalBot.g:7419:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0()); 
            // InternalBot.g:7420:3: ( ruleEString )
            // InternalBot.g:7421:4: ruleEString
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__HTTPRequestAssignment_4"


    // $ANTLR start "rule__HTTPResponse__InputsAssignment_7"
    // InternalBot.g:7432:1: rule__HTTPResponse__InputsAssignment_7 : ( ruleTextInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7436:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:7437:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:7437:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:7438:3: ruleTextInputHttpResponse
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsTextInputHttpResponseParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getInputsTextInputHttpResponseParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__InputsAssignment_7"


    // $ANTLR start "rule__HTTPRequest__MethodAssignment_2"
    // InternalBot.g:7447:1: rule__HTTPRequest__MethodAssignment_2 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7451:1: ( ( ruleMethod ) )
            // InternalBot.g:7452:2: ( ruleMethod )
            {
            // InternalBot.g:7452:2: ( ruleMethod )
            // InternalBot.g:7453:3: ruleMethod
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMethod();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__MethodAssignment_2"


    // $ANTLR start "rule__HTTPRequest__NameAssignment_3"
    // InternalBot.g:7462:1: rule__HTTPRequest__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7466:1: ( ( ruleEString ) )
            // InternalBot.g:7467:2: ( ruleEString )
            {
            // InternalBot.g:7467:2: ( ruleEString )
            // InternalBot.g:7468:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__NameAssignment_3"


    // $ANTLR start "rule__HTTPRequest__URLAssignment_7"
    // InternalBot.g:7477:1: rule__HTTPRequest__URLAssignment_7 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7481:1: ( ( ruleEString ) )
            // InternalBot.g:7482:2: ( ruleEString )
            {
            // InternalBot.g:7482:2: ( ruleEString )
            // InternalBot.g:7483:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__URLAssignment_7"


    // $ANTLR start "rule__HTTPRequest__BasicAuthAssignment_9_2"
    // InternalBot.g:7492:1: rule__HTTPRequest__BasicAuthAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7496:1: ( ( ruleKeyValue ) )
            // InternalBot.g:7497:2: ( ruleKeyValue )
            {
            // InternalBot.g:7497:2: ( ruleKeyValue )
            // InternalBot.g:7498:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__BasicAuthAssignment_9_2"


    // $ANTLR start "rule__HTTPRequest__HeadersAssignment_10_2"
    // InternalBot.g:7507:1: rule__HTTPRequest__HeadersAssignment_10_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7511:1: ( ( ruleKeyValue ) )
            // InternalBot.g:7512:2: ( ruleKeyValue )
            {
            // InternalBot.g:7512:2: ( ruleKeyValue )
            // InternalBot.g:7513:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__HeadersAssignment_10_2"


    // $ANTLR start "rule__HTTPRequest__HeadersAssignment_10_3_1"
    // InternalBot.g:7522:1: rule__HTTPRequest__HeadersAssignment_10_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7526:1: ( ( ruleKeyValue ) )
            // InternalBot.g:7527:2: ( ruleKeyValue )
            {
            // InternalBot.g:7527:2: ( ruleKeyValue )
            // InternalBot.g:7528:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__HeadersAssignment_10_3_1"


    // $ANTLR start "rule__HTTPRequest__DataAssignment_11_2"
    // InternalBot.g:7537:1: rule__HTTPRequest__DataAssignment_11_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7541:1: ( ( ruleData ) )
            // InternalBot.g:7542:2: ( ruleData )
            {
            // InternalBot.g:7542:2: ( ruleData )
            // InternalBot.g:7543:3: ruleData
            {
             before(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataAssignment_11_2"


    // $ANTLR start "rule__HTTPRequest__DataAssignment_11_3_1"
    // InternalBot.g:7552:1: rule__HTTPRequest__DataAssignment_11_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7556:1: ( ( ruleData ) )
            // InternalBot.g:7557:2: ( ruleData )
            {
            // InternalBot.g:7557:2: ( ruleData )
            // InternalBot.g:7558:3: ruleData
            {
             before(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataAssignment_11_3_1"


    // $ANTLR start "rule__HTTPRequest__DataTypeAssignment_11_7"
    // InternalBot.g:7567:1: rule__HTTPRequest__DataTypeAssignment_11_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_11_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7571:1: ( ( ruleDataType ) )
            // InternalBot.g:7572:2: ( ruleDataType )
            {
            // InternalBot.g:7572:2: ( ruleDataType )
            // InternalBot.g:7573:3: ruleDataType
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_11_7_0()); 
            pushFollow(FOLLOW_2);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_11_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataTypeAssignment_11_7"


    // $ANTLR start "rule__Image__NameAssignment_2"
    // InternalBot.g:7582:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7586:1: ( ( ruleEString ) )
            // InternalBot.g:7587:2: ( ruleEString )
            {
            // InternalBot.g:7587:2: ( ruleEString )
            // InternalBot.g:7588:3: ruleEString
            {
             before(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__NameAssignment_2"


    // $ANTLR start "rule__Image__URLAssignment_6"
    // InternalBot.g:7597:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7601:1: ( ( ruleEString ) )
            // InternalBot.g:7602:2: ( ruleEString )
            {
            // InternalBot.g:7602:2: ( ruleEString )
            // InternalBot.g:7603:3: ruleEString
            {
             before(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__URLAssignment_6"


    // $ANTLR start "rule__TextInputHttpResponse__TokensAssignment"
    // InternalBot.g:7612:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7616:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:7617:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:7617:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:7618:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:7619:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:7619:4: rule__TextInputHttpResponse__TokensAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TextInputHttpResponse__TokensAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputHttpResponse__TokensAssignment"


    // $ANTLR start "rule__TextInputText__TokensAssignment"
    // InternalBot.g:7627:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7631:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:7632:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:7632:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:7633:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:7634:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:7634:4: rule__TextInputText__TokensAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TextInputText__TokensAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputText__TokensAssignment"


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // InternalBot.g:7642:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7646:1: ( ( ruleEString ) )
            // InternalBot.g:7647:2: ( ruleEString )
            {
            // InternalBot.g:7647:2: ( ruleEString )
            // InternalBot.g:7648:3: ruleEString
            {
             before(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__KeyAssignment_0"


    // $ANTLR start "rule__KeyValue__ValueAssignment_2"
    // InternalBot.g:7657:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7661:1: ( ( ruleLiteral ) )
            // InternalBot.g:7662:2: ( ruleLiteral )
            {
            // InternalBot.g:7662:2: ( ruleLiteral )
            // InternalBot.g:7663:3: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__ValueAssignment_2"


    // $ANTLR start "rule__Data__KeyAssignment_0"
    // InternalBot.g:7672:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7676:1: ( ( ruleEString ) )
            // InternalBot.g:7677:2: ( ruleEString )
            {
            // InternalBot.g:7677:2: ( ruleEString )
            // InternalBot.g:7678:3: ruleEString
            {
             before(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__KeyAssignment_0"


    // $ANTLR start "rule__Data__ValueAssignment_2"
    // InternalBot.g:7687:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7691:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:7692:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:7692:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:7693:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:7694:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:7694:4: rule__Data__ValueAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Data__ValueAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__ValueAssignment_2"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\6\uffff\1\12\4\uffff";
    static final String dfa_3s = "\1\73\1\74\1\4\2\67\1\4\1\63\2\67\2\uffff";
    static final String dfa_4s = "\1\73\1\74\1\5\2\75\1\5\1\72\2\75\2\uffff";
    static final String dfa_5s = "\11\uffff\1\2\1\1";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\5\5\uffff\1\6",
            "\1\5\5\uffff\1\6",
            "\1\7\1\10",
            "\1\12\1\11\5\uffff\1\12",
            "\1\5\5\uffff\1\6",
            "\1\5\5\uffff\1\6",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "896:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000009L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000001L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000007FFFF80000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0003800000000030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000020800L,0x0000000000001400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020802L,0x0000000000001400L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x01C0000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x2080000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x1000000000000032L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000000F830L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0088000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000070800L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000004L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000004L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000201L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000009L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000040000L,0x0000000000018000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000001L});

}