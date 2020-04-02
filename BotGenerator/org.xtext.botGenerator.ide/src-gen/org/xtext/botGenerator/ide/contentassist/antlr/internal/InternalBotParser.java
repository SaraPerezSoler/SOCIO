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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'text'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language:'", "'intents'", "':'", "'flows'", "','", "'entities'", "'actions'", "'-'", "';'", "'parameters:'", "'inputs'", "'{'", "'}'", "'in'", "'user'", "'=>'", "'chatbot'", "'('", "')'", "'entity'", "'prompts'", "'['", "']'", "'@'", "'request.'", "'.'", "'Simple'", "'Composite'", "'synonyms'", "'response'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'Fallback'", "'required'", "'isList'"
    };
    public static final int T__50=50;
    public static final int T__90=90;
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
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__89=89;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

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


    // $ANTLR start "entryRuleIntentLanguageInputs"
    // InternalBot.g:178:1: entryRuleIntentLanguageInputs : ruleIntentLanguageInputs EOF ;
    public final void entryRuleIntentLanguageInputs() throws RecognitionException {
        try {
            // InternalBot.g:179:1: ( ruleIntentLanguageInputs EOF )
            // InternalBot.g:180:1: ruleIntentLanguageInputs EOF
            {
             before(grammarAccess.getIntentLanguageInputsRule()); 
            pushFollow(FOLLOW_1);
            ruleIntentLanguageInputs();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsRule()); 
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
    // $ANTLR end "entryRuleIntentLanguageInputs"


    // $ANTLR start "ruleIntentLanguageInputs"
    // InternalBot.g:187:1: ruleIntentLanguageInputs : ( ( rule__IntentLanguageInputs__Group__0 ) ) ;
    public final void ruleIntentLanguageInputs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:191:2: ( ( ( rule__IntentLanguageInputs__Group__0 ) ) )
            // InternalBot.g:192:2: ( ( rule__IntentLanguageInputs__Group__0 ) )
            {
            // InternalBot.g:192:2: ( ( rule__IntentLanguageInputs__Group__0 ) )
            // InternalBot.g:193:3: ( rule__IntentLanguageInputs__Group__0 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup()); 
            // InternalBot.g:194:3: ( rule__IntentLanguageInputs__Group__0 )
            // InternalBot.g:194:4: rule__IntentLanguageInputs__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntentLanguageInputs"


    // $ANTLR start "entryRuleTransition"
    // InternalBot.g:203:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalBot.g:204:1: ( ruleTransition EOF )
            // InternalBot.g:205:1: ruleTransition EOF
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
    // InternalBot.g:212:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:216:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalBot.g:217:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalBot.g:217:2: ( ( rule__Transition__Group__0 ) )
            // InternalBot.g:218:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalBot.g:219:3: ( rule__Transition__Group__0 )
            // InternalBot.g:219:4: rule__Transition__Group__0
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
    // InternalBot.g:228:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalBot.g:229:1: ( ruleState EOF )
            // InternalBot.g:230:1: ruleState EOF
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
    // InternalBot.g:237:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:241:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalBot.g:242:2: ( ( rule__State__Group__0 ) )
            {
            // InternalBot.g:242:2: ( ( rule__State__Group__0 ) )
            // InternalBot.g:243:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalBot.g:244:3: ( rule__State__Group__0 )
            // InternalBot.g:244:4: rule__State__Group__0
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
    // InternalBot.g:253:1: entryRuleState2 : ruleState2 EOF ;
    public final void entryRuleState2() throws RecognitionException {
        try {
            // InternalBot.g:254:1: ( ruleState2 EOF )
            // InternalBot.g:255:1: ruleState2 EOF
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
    // InternalBot.g:262:1: ruleState2 : ( ( rule__State2__Group__0 ) ) ;
    public final void ruleState2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:266:2: ( ( ( rule__State2__Group__0 ) ) )
            // InternalBot.g:267:2: ( ( rule__State2__Group__0 ) )
            {
            // InternalBot.g:267:2: ( ( rule__State2__Group__0 ) )
            // InternalBot.g:268:3: ( rule__State2__Group__0 )
            {
             before(grammarAccess.getState2Access().getGroup()); 
            // InternalBot.g:269:3: ( rule__State2__Group__0 )
            // InternalBot.g:269:4: rule__State2__Group__0
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
    // InternalBot.g:278:1: entryRuleTrainingPhrase : ruleTrainingPhrase EOF ;
    public final void entryRuleTrainingPhrase() throws RecognitionException {
        try {
            // InternalBot.g:279:1: ( ruleTrainingPhrase EOF )
            // InternalBot.g:280:1: ruleTrainingPhrase EOF
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
    // InternalBot.g:287:1: ruleTrainingPhrase : ( ( rule__TrainingPhrase__Group__0 ) ) ;
    public final void ruleTrainingPhrase() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:291:2: ( ( ( rule__TrainingPhrase__Group__0 ) ) )
            // InternalBot.g:292:2: ( ( rule__TrainingPhrase__Group__0 ) )
            {
            // InternalBot.g:292:2: ( ( rule__TrainingPhrase__Group__0 ) )
            // InternalBot.g:293:3: ( rule__TrainingPhrase__Group__0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getGroup()); 
            // InternalBot.g:294:3: ( rule__TrainingPhrase__Group__0 )
            // InternalBot.g:294:4: rule__TrainingPhrase__Group__0
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
    // InternalBot.g:303:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalBot.g:304:1: ( ruleParameter EOF )
            // InternalBot.g:305:1: ruleParameter EOF
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
    // InternalBot.g:312:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:316:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalBot.g:317:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalBot.g:317:2: ( ( rule__Parameter__Group__0 ) )
            // InternalBot.g:318:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalBot.g:319:3: ( rule__Parameter__Group__0 )
            // InternalBot.g:319:4: rule__Parameter__Group__0
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


    // $ANTLR start "entryRulePromptLanguage"
    // InternalBot.g:328:1: entryRulePromptLanguage : rulePromptLanguage EOF ;
    public final void entryRulePromptLanguage() throws RecognitionException {
        try {
            // InternalBot.g:329:1: ( rulePromptLanguage EOF )
            // InternalBot.g:330:1: rulePromptLanguage EOF
            {
             before(grammarAccess.getPromptLanguageRule()); 
            pushFollow(FOLLOW_1);
            rulePromptLanguage();

            state._fsp--;

             after(grammarAccess.getPromptLanguageRule()); 
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
    // $ANTLR end "entryRulePromptLanguage"


    // $ANTLR start "rulePromptLanguage"
    // InternalBot.g:337:1: rulePromptLanguage : ( ( rule__PromptLanguage__Group__0 ) ) ;
    public final void rulePromptLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:341:2: ( ( ( rule__PromptLanguage__Group__0 ) ) )
            // InternalBot.g:342:2: ( ( rule__PromptLanguage__Group__0 ) )
            {
            // InternalBot.g:342:2: ( ( rule__PromptLanguage__Group__0 ) )
            // InternalBot.g:343:3: ( rule__PromptLanguage__Group__0 )
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup()); 
            // InternalBot.g:344:3: ( rule__PromptLanguage__Group__0 )
            // InternalBot.g:344:4: rule__PromptLanguage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePromptLanguage"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:353:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBot.g:354:1: ( ruleLiteral EOF )
            // InternalBot.g:355:1: ruleLiteral EOF
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
    // InternalBot.g:362:1: ruleLiteral : ( ( rule__Literal__TextAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:366:2: ( ( ( rule__Literal__TextAssignment ) ) )
            // InternalBot.g:367:2: ( ( rule__Literal__TextAssignment ) )
            {
            // InternalBot.g:367:2: ( ( rule__Literal__TextAssignment ) )
            // InternalBot.g:368:3: ( rule__Literal__TextAssignment )
            {
             before(grammarAccess.getLiteralAccess().getTextAssignment()); 
            // InternalBot.g:369:3: ( rule__Literal__TextAssignment )
            // InternalBot.g:369:4: rule__Literal__TextAssignment
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
    // InternalBot.g:378:1: entryRuleEntityToken : ruleEntityToken EOF ;
    public final void entryRuleEntityToken() throws RecognitionException {
        try {
            // InternalBot.g:379:1: ( ruleEntityToken EOF )
            // InternalBot.g:380:1: ruleEntityToken EOF
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
    // InternalBot.g:387:1: ruleEntityToken : ( ( rule__EntityToken__Group__0 ) ) ;
    public final void ruleEntityToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:391:2: ( ( ( rule__EntityToken__Group__0 ) ) )
            // InternalBot.g:392:2: ( ( rule__EntityToken__Group__0 ) )
            {
            // InternalBot.g:392:2: ( ( rule__EntityToken__Group__0 ) )
            // InternalBot.g:393:3: ( rule__EntityToken__Group__0 )
            {
             before(grammarAccess.getEntityTokenAccess().getGroup()); 
            // InternalBot.g:394:3: ( rule__EntityToken__Group__0 )
            // InternalBot.g:394:4: rule__EntityToken__Group__0
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
    // InternalBot.g:403:1: entryRuleParameterToken : ruleParameterToken EOF ;
    public final void entryRuleParameterToken() throws RecognitionException {
        try {
            // InternalBot.g:404:1: ( ruleParameterToken EOF )
            // InternalBot.g:405:1: ruleParameterToken EOF
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
    // InternalBot.g:412:1: ruleParameterToken : ( ( rule__ParameterToken__Group__0 ) ) ;
    public final void ruleParameterToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:416:2: ( ( ( rule__ParameterToken__Group__0 ) ) )
            // InternalBot.g:417:2: ( ( rule__ParameterToken__Group__0 ) )
            {
            // InternalBot.g:417:2: ( ( rule__ParameterToken__Group__0 ) )
            // InternalBot.g:418:3: ( rule__ParameterToken__Group__0 )
            {
             before(grammarAccess.getParameterTokenAccess().getGroup()); 
            // InternalBot.g:419:3: ( rule__ParameterToken__Group__0 )
            // InternalBot.g:419:4: rule__ParameterToken__Group__0
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
    // InternalBot.g:428:1: entryRuleParameterRefenceToken : ruleParameterRefenceToken EOF ;
    public final void entryRuleParameterRefenceToken() throws RecognitionException {
        try {
            // InternalBot.g:429:1: ( ruleParameterRefenceToken EOF )
            // InternalBot.g:430:1: ruleParameterRefenceToken EOF
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
    // InternalBot.g:437:1: ruleParameterRefenceToken : ( ( rule__ParameterRefenceToken__Group__0 ) ) ;
    public final void ruleParameterRefenceToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:441:2: ( ( ( rule__ParameterRefenceToken__Group__0 ) ) )
            // InternalBot.g:442:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            {
            // InternalBot.g:442:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            // InternalBot.g:443:3: ( rule__ParameterRefenceToken__Group__0 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getGroup()); 
            // InternalBot.g:444:3: ( rule__ParameterRefenceToken__Group__0 )
            // InternalBot.g:444:4: rule__ParameterRefenceToken__Group__0
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
    // InternalBot.g:453:1: entryRuleHTTPRequestToken : ruleHTTPRequestToken EOF ;
    public final void entryRuleHTTPRequestToken() throws RecognitionException {
        try {
            // InternalBot.g:454:1: ( ruleHTTPRequestToken EOF )
            // InternalBot.g:455:1: ruleHTTPRequestToken EOF
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
    // InternalBot.g:462:1: ruleHTTPRequestToken : ( ( rule__HTTPRequestToken__Group__0 ) ) ;
    public final void ruleHTTPRequestToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:466:2: ( ( ( rule__HTTPRequestToken__Group__0 ) ) )
            // InternalBot.g:467:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            {
            // InternalBot.g:467:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            // InternalBot.g:468:3: ( rule__HTTPRequestToken__Group__0 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup()); 
            // InternalBot.g:469:3: ( rule__HTTPRequestToken__Group__0 )
            // InternalBot.g:469:4: rule__HTTPRequestToken__Group__0
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
    // InternalBot.g:478:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // InternalBot.g:479:1: ( ruleSimple EOF )
            // InternalBot.g:480:1: ruleSimple EOF
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
    // InternalBot.g:487:1: ruleSimple : ( ( rule__Simple__Group__0 ) ) ;
    public final void ruleSimple() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:491:2: ( ( ( rule__Simple__Group__0 ) ) )
            // InternalBot.g:492:2: ( ( rule__Simple__Group__0 ) )
            {
            // InternalBot.g:492:2: ( ( rule__Simple__Group__0 ) )
            // InternalBot.g:493:3: ( rule__Simple__Group__0 )
            {
             before(grammarAccess.getSimpleAccess().getGroup()); 
            // InternalBot.g:494:3: ( rule__Simple__Group__0 )
            // InternalBot.g:494:4: rule__Simple__Group__0
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


    // $ANTLR start "entryRuleSimpleLanguageInput"
    // InternalBot.g:503:1: entryRuleSimpleLanguageInput : ruleSimpleLanguageInput EOF ;
    public final void entryRuleSimpleLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:504:1: ( ruleSimpleLanguageInput EOF )
            // InternalBot.g:505:1: ruleSimpleLanguageInput EOF
            {
             before(grammarAccess.getSimpleLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleLanguageInput();

            state._fsp--;

             after(grammarAccess.getSimpleLanguageInputRule()); 
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
    // $ANTLR end "entryRuleSimpleLanguageInput"


    // $ANTLR start "ruleSimpleLanguageInput"
    // InternalBot.g:512:1: ruleSimpleLanguageInput : ( ( rule__SimpleLanguageInput__Group__0 ) ) ;
    public final void ruleSimpleLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:516:2: ( ( ( rule__SimpleLanguageInput__Group__0 ) ) )
            // InternalBot.g:517:2: ( ( rule__SimpleLanguageInput__Group__0 ) )
            {
            // InternalBot.g:517:2: ( ( rule__SimpleLanguageInput__Group__0 ) )
            // InternalBot.g:518:3: ( rule__SimpleLanguageInput__Group__0 )
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getGroup()); 
            // InternalBot.g:519:3: ( rule__SimpleLanguageInput__Group__0 )
            // InternalBot.g:519:4: rule__SimpleLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleLanguageInput"


    // $ANTLR start "entryRuleComposite"
    // InternalBot.g:528:1: entryRuleComposite : ruleComposite EOF ;
    public final void entryRuleComposite() throws RecognitionException {
        try {
            // InternalBot.g:529:1: ( ruleComposite EOF )
            // InternalBot.g:530:1: ruleComposite EOF
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
    // InternalBot.g:537:1: ruleComposite : ( ( rule__Composite__Group__0 ) ) ;
    public final void ruleComposite() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:541:2: ( ( ( rule__Composite__Group__0 ) ) )
            // InternalBot.g:542:2: ( ( rule__Composite__Group__0 ) )
            {
            // InternalBot.g:542:2: ( ( rule__Composite__Group__0 ) )
            // InternalBot.g:543:3: ( rule__Composite__Group__0 )
            {
             before(grammarAccess.getCompositeAccess().getGroup()); 
            // InternalBot.g:544:3: ( rule__Composite__Group__0 )
            // InternalBot.g:544:4: rule__Composite__Group__0
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


    // $ANTLR start "entryRuleCompositeLanguageInput"
    // InternalBot.g:553:1: entryRuleCompositeLanguageInput : ruleCompositeLanguageInput EOF ;
    public final void entryRuleCompositeLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:554:1: ( ruleCompositeLanguageInput EOF )
            // InternalBot.g:555:1: ruleCompositeLanguageInput EOF
            {
             before(grammarAccess.getCompositeLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleCompositeLanguageInput();

            state._fsp--;

             after(grammarAccess.getCompositeLanguageInputRule()); 
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
    // $ANTLR end "entryRuleCompositeLanguageInput"


    // $ANTLR start "ruleCompositeLanguageInput"
    // InternalBot.g:562:1: ruleCompositeLanguageInput : ( ( rule__CompositeLanguageInput__Group__0 ) ) ;
    public final void ruleCompositeLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:566:2: ( ( ( rule__CompositeLanguageInput__Group__0 ) ) )
            // InternalBot.g:567:2: ( ( rule__CompositeLanguageInput__Group__0 ) )
            {
            // InternalBot.g:567:2: ( ( rule__CompositeLanguageInput__Group__0 ) )
            // InternalBot.g:568:3: ( rule__CompositeLanguageInput__Group__0 )
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getGroup()); 
            // InternalBot.g:569:3: ( rule__CompositeLanguageInput__Group__0 )
            // InternalBot.g:569:4: rule__CompositeLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompositeLanguageInput"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:578:1: entryRuleSimpleInput : ruleSimpleInput EOF ;
    public final void entryRuleSimpleInput() throws RecognitionException {
        try {
            // InternalBot.g:579:1: ( ruleSimpleInput EOF )
            // InternalBot.g:580:1: ruleSimpleInput EOF
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
    // InternalBot.g:587:1: ruleSimpleInput : ( ( rule__SimpleInput__Group__0 ) ) ;
    public final void ruleSimpleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:591:2: ( ( ( rule__SimpleInput__Group__0 ) ) )
            // InternalBot.g:592:2: ( ( rule__SimpleInput__Group__0 ) )
            {
            // InternalBot.g:592:2: ( ( rule__SimpleInput__Group__0 ) )
            // InternalBot.g:593:3: ( rule__SimpleInput__Group__0 )
            {
             before(grammarAccess.getSimpleInputAccess().getGroup()); 
            // InternalBot.g:594:3: ( rule__SimpleInput__Group__0 )
            // InternalBot.g:594:4: rule__SimpleInput__Group__0
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
    // InternalBot.g:603:1: entryRuleCompositeInput : ruleCompositeInput EOF ;
    public final void entryRuleCompositeInput() throws RecognitionException {
        try {
            // InternalBot.g:604:1: ( ruleCompositeInput EOF )
            // InternalBot.g:605:1: ruleCompositeInput EOF
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
    // InternalBot.g:612:1: ruleCompositeInput : ( ( rule__CompositeInput__Group__0 ) ) ;
    public final void ruleCompositeInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:616:2: ( ( ( rule__CompositeInput__Group__0 ) ) )
            // InternalBot.g:617:2: ( ( rule__CompositeInput__Group__0 ) )
            {
            // InternalBot.g:617:2: ( ( rule__CompositeInput__Group__0 ) )
            // InternalBot.g:618:3: ( rule__CompositeInput__Group__0 )
            {
             before(grammarAccess.getCompositeInputAccess().getGroup()); 
            // InternalBot.g:619:3: ( rule__CompositeInput__Group__0 )
            // InternalBot.g:619:4: rule__CompositeInput__Group__0
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
    // InternalBot.g:628:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // InternalBot.g:629:1: ( ruleText EOF )
            // InternalBot.g:630:1: ruleText EOF
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
    // InternalBot.g:637:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:641:2: ( ( ( rule__Text__Group__0 ) ) )
            // InternalBot.g:642:2: ( ( rule__Text__Group__0 ) )
            {
            // InternalBot.g:642:2: ( ( rule__Text__Group__0 ) )
            // InternalBot.g:643:3: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // InternalBot.g:644:3: ( rule__Text__Group__0 )
            // InternalBot.g:644:4: rule__Text__Group__0
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


    // $ANTLR start "entryRuleTextLanguageInput"
    // InternalBot.g:653:1: entryRuleTextLanguageInput : ruleTextLanguageInput EOF ;
    public final void entryRuleTextLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:654:1: ( ruleTextLanguageInput EOF )
            // InternalBot.g:655:1: ruleTextLanguageInput EOF
            {
             before(grammarAccess.getTextLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleTextLanguageInput();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputRule()); 
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
    // $ANTLR end "entryRuleTextLanguageInput"


    // $ANTLR start "ruleTextLanguageInput"
    // InternalBot.g:662:1: ruleTextLanguageInput : ( ( rule__TextLanguageInput__Group__0 ) ) ;
    public final void ruleTextLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:666:2: ( ( ( rule__TextLanguageInput__Group__0 ) ) )
            // InternalBot.g:667:2: ( ( rule__TextLanguageInput__Group__0 ) )
            {
            // InternalBot.g:667:2: ( ( rule__TextLanguageInput__Group__0 ) )
            // InternalBot.g:668:3: ( rule__TextLanguageInput__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup()); 
            // InternalBot.g:669:3: ( rule__TextLanguageInput__Group__0 )
            // InternalBot.g:669:4: rule__TextLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextLanguageInput"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:678:1: entryRuleHTTPResponse : ruleHTTPResponse EOF ;
    public final void entryRuleHTTPResponse() throws RecognitionException {
        try {
            // InternalBot.g:679:1: ( ruleHTTPResponse EOF )
            // InternalBot.g:680:1: ruleHTTPResponse EOF
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
    // InternalBot.g:687:1: ruleHTTPResponse : ( ( rule__HTTPResponse__Group__0 ) ) ;
    public final void ruleHTTPResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:691:2: ( ( ( rule__HTTPResponse__Group__0 ) ) )
            // InternalBot.g:692:2: ( ( rule__HTTPResponse__Group__0 ) )
            {
            // InternalBot.g:692:2: ( ( rule__HTTPResponse__Group__0 ) )
            // InternalBot.g:693:3: ( rule__HTTPResponse__Group__0 )
            {
             before(grammarAccess.getHTTPResponseAccess().getGroup()); 
            // InternalBot.g:694:3: ( rule__HTTPResponse__Group__0 )
            // InternalBot.g:694:4: rule__HTTPResponse__Group__0
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
    // InternalBot.g:703:1: entryRuleHTTPRequest : ruleHTTPRequest EOF ;
    public final void entryRuleHTTPRequest() throws RecognitionException {
        try {
            // InternalBot.g:704:1: ( ruleHTTPRequest EOF )
            // InternalBot.g:705:1: ruleHTTPRequest EOF
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
    // InternalBot.g:712:1: ruleHTTPRequest : ( ( rule__HTTPRequest__Group__0 ) ) ;
    public final void ruleHTTPRequest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:716:2: ( ( ( rule__HTTPRequest__Group__0 ) ) )
            // InternalBot.g:717:2: ( ( rule__HTTPRequest__Group__0 ) )
            {
            // InternalBot.g:717:2: ( ( rule__HTTPRequest__Group__0 ) )
            // InternalBot.g:718:3: ( rule__HTTPRequest__Group__0 )
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup()); 
            // InternalBot.g:719:3: ( rule__HTTPRequest__Group__0 )
            // InternalBot.g:719:4: rule__HTTPRequest__Group__0
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
    // InternalBot.g:728:1: entryRuleImage : ruleImage EOF ;
    public final void entryRuleImage() throws RecognitionException {
        try {
            // InternalBot.g:729:1: ( ruleImage EOF )
            // InternalBot.g:730:1: ruleImage EOF
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
    // InternalBot.g:737:1: ruleImage : ( ( rule__Image__Group__0 ) ) ;
    public final void ruleImage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:741:2: ( ( ( rule__Image__Group__0 ) ) )
            // InternalBot.g:742:2: ( ( rule__Image__Group__0 ) )
            {
            // InternalBot.g:742:2: ( ( rule__Image__Group__0 ) )
            // InternalBot.g:743:3: ( rule__Image__Group__0 )
            {
             before(grammarAccess.getImageAccess().getGroup()); 
            // InternalBot.g:744:3: ( rule__Image__Group__0 )
            // InternalBot.g:744:4: rule__Image__Group__0
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


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:753:1: entryRuleTextLanguageInputHttpResponse : ruleTextLanguageInputHttpResponse EOF ;
    public final void entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:754:1: ( ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:755:1: ruleTextLanguageInputHttpResponse EOF
            {
             before(grammarAccess.getTextLanguageInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleTextLanguageInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseRule()); 
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
    // $ANTLR end "entryRuleTextLanguageInputHttpResponse"


    // $ANTLR start "ruleTextLanguageInputHttpResponse"
    // InternalBot.g:762:1: ruleTextLanguageInputHttpResponse : ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) ;
    public final void ruleTextLanguageInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:766:2: ( ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) )
            // InternalBot.g:767:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            {
            // InternalBot.g:767:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            // InternalBot.g:768:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 
            // InternalBot.g:769:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            // InternalBot.g:769:4: rule__TextLanguageInputHttpResponse__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextLanguageInputHttpResponse"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:778:1: entryRuleTextInputHttpResponse : ruleTextInputHttpResponse EOF ;
    public final void entryRuleTextInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:779:1: ( ruleTextInputHttpResponse EOF )
            // InternalBot.g:780:1: ruleTextInputHttpResponse EOF
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
    // InternalBot.g:787:1: ruleTextInputHttpResponse : ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) ;
    public final void ruleTextInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:791:2: ( ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) )
            // InternalBot.g:792:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            {
            // InternalBot.g:792:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            // InternalBot.g:793:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            {
            // InternalBot.g:793:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) )
            // InternalBot.g:794:4: ( rule__TextInputHttpResponse__TokensAssignment )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:795:4: ( rule__TextInputHttpResponse__TokensAssignment )
            // InternalBot.g:795:5: rule__TextInputHttpResponse__TokensAssignment
            {
            pushFollow(FOLLOW_3);
            rule__TextInputHttpResponse__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }

            // InternalBot.g:798:3: ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            // InternalBot.g:799:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:800:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==71||LA1_0==74) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:800:5: rule__TextInputHttpResponse__TokensAssignment
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
    // InternalBot.g:810:1: entryRuleTextInputText : ruleTextInputText EOF ;
    public final void entryRuleTextInputText() throws RecognitionException {
        try {
            // InternalBot.g:811:1: ( ruleTextInputText EOF )
            // InternalBot.g:812:1: ruleTextInputText EOF
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
    // InternalBot.g:819:1: ruleTextInputText : ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) ;
    public final void ruleTextInputText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:823:2: ( ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) )
            // InternalBot.g:824:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            {
            // InternalBot.g:824:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            // InternalBot.g:825:3: ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* )
            {
            // InternalBot.g:825:3: ( ( rule__TextInputText__TokensAssignment ) )
            // InternalBot.g:826:4: ( rule__TextInputText__TokensAssignment )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:827:4: ( rule__TextInputText__TokensAssignment )
            // InternalBot.g:827:5: rule__TextInputText__TokensAssignment
            {
            pushFollow(FOLLOW_4);
            rule__TextInputText__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }

            // InternalBot.g:830:3: ( ( rule__TextInputText__TokensAssignment )* )
            // InternalBot.g:831:4: ( rule__TextInputText__TokensAssignment )*
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:832:4: ( rule__TextInputText__TokensAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==71) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:832:5: rule__TextInputText__TokensAssignment
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
    // InternalBot.g:842:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBot.g:843:1: ( ruleKeyValue EOF )
            // InternalBot.g:844:1: ruleKeyValue EOF
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
    // InternalBot.g:851:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:855:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBot.g:856:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBot.g:856:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBot.g:857:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBot.g:858:3: ( rule__KeyValue__Group__0 )
            // InternalBot.g:858:4: rule__KeyValue__Group__0
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
    // InternalBot.g:867:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalBot.g:868:1: ( ruleData EOF )
            // InternalBot.g:869:1: ruleData EOF
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
    // InternalBot.g:876:1: ruleData : ( ( rule__Data__Group__0 ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:880:2: ( ( ( rule__Data__Group__0 ) ) )
            // InternalBot.g:881:2: ( ( rule__Data__Group__0 ) )
            {
            // InternalBot.g:881:2: ( ( rule__Data__Group__0 ) )
            // InternalBot.g:882:3: ( rule__Data__Group__0 )
            {
             before(grammarAccess.getDataAccess().getGroup()); 
            // InternalBot.g:883:3: ( rule__Data__Group__0 )
            // InternalBot.g:883:4: rule__Data__Group__0
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
    // InternalBot.g:892:1: ruleDefaultEntity : ( ( rule__DefaultEntity__Alternatives ) ) ;
    public final void ruleDefaultEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:896:1: ( ( ( rule__DefaultEntity__Alternatives ) ) )
            // InternalBot.g:897:2: ( ( rule__DefaultEntity__Alternatives ) )
            {
            // InternalBot.g:897:2: ( ( rule__DefaultEntity__Alternatives ) )
            // InternalBot.g:898:3: ( rule__DefaultEntity__Alternatives )
            {
             before(grammarAccess.getDefaultEntityAccess().getAlternatives()); 
            // InternalBot.g:899:3: ( rule__DefaultEntity__Alternatives )
            // InternalBot.g:899:4: rule__DefaultEntity__Alternatives
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
    // InternalBot.g:908:1: ruleHTTPReturnType : ( ( rule__HTTPReturnType__Alternatives ) ) ;
    public final void ruleHTTPReturnType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:912:1: ( ( ( rule__HTTPReturnType__Alternatives ) ) )
            // InternalBot.g:913:2: ( ( rule__HTTPReturnType__Alternatives ) )
            {
            // InternalBot.g:913:2: ( ( rule__HTTPReturnType__Alternatives ) )
            // InternalBot.g:914:3: ( rule__HTTPReturnType__Alternatives )
            {
             before(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 
            // InternalBot.g:915:3: ( rule__HTTPReturnType__Alternatives )
            // InternalBot.g:915:4: rule__HTTPReturnType__Alternatives
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
    // InternalBot.g:924:1: ruleLanguage : ( ( rule__Language__Alternatives ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:928:1: ( ( ( rule__Language__Alternatives ) ) )
            // InternalBot.g:929:2: ( ( rule__Language__Alternatives ) )
            {
            // InternalBot.g:929:2: ( ( rule__Language__Alternatives ) )
            // InternalBot.g:930:3: ( rule__Language__Alternatives )
            {
             before(grammarAccess.getLanguageAccess().getAlternatives()); 
            // InternalBot.g:931:3: ( rule__Language__Alternatives )
            // InternalBot.g:931:4: rule__Language__Alternatives
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
    // InternalBot.g:940:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:944:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalBot.g:945:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalBot.g:945:2: ( ( rule__DataType__Alternatives ) )
            // InternalBot.g:946:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalBot.g:947:3: ( rule__DataType__Alternatives )
            // InternalBot.g:947:4: rule__DataType__Alternatives
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
    // InternalBot.g:956:1: ruleMethod : ( ( rule__Method__Alternatives ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:960:1: ( ( ( rule__Method__Alternatives ) ) )
            // InternalBot.g:961:2: ( ( rule__Method__Alternatives ) )
            {
            // InternalBot.g:961:2: ( ( rule__Method__Alternatives ) )
            // InternalBot.g:962:3: ( rule__Method__Alternatives )
            {
             before(grammarAccess.getMethodAccess().getAlternatives()); 
            // InternalBot.g:963:3: ( rule__Method__Alternatives )
            // InternalBot.g:963:4: rule__Method__Alternatives
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
    // InternalBot.g:971:1: rule__Entity__Alternatives : ( ( ruleSimple ) | ( ruleComposite ) );
    public final void rule__Entity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:975:1: ( ( ruleSimple ) | ( ruleComposite ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==76) ) {
                alt3=1;
            }
            else if ( (LA3_0==77) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBot.g:976:2: ( ruleSimple )
                    {
                    // InternalBot.g:976:2: ( ruleSimple )
                    // InternalBot.g:977:3: ruleSimple
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
                    // InternalBot.g:982:2: ( ruleComposite )
                    {
                    // InternalBot.g:982:2: ( ruleComposite )
                    // InternalBot.g:983:3: ruleComposite
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
    // InternalBot.g:992:1: rule__Action__Alternatives : ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:996:1: ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 82:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 80:
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
                    // InternalBot.g:997:2: ( ruleText )
                    {
                    // InternalBot.g:997:2: ( ruleText )
                    // InternalBot.g:998:3: ruleText
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
                    // InternalBot.g:1003:2: ( ruleHTTPRequest )
                    {
                    // InternalBot.g:1003:2: ( ruleHTTPRequest )
                    // InternalBot.g:1004:3: ruleHTTPRequest
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
                    // InternalBot.g:1009:2: ( ruleImage )
                    {
                    // InternalBot.g:1009:2: ( ruleImage )
                    // InternalBot.g:1010:3: ruleImage
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
                    // InternalBot.g:1015:2: ( ruleHTTPResponse )
                    {
                    // InternalBot.g:1015:2: ( ruleHTTPResponse )
                    // InternalBot.g:1016:3: ruleHTTPResponse
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
    // InternalBot.g:1025:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1029:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalBot.g:1030:2: ( RULE_STRING )
                    {
                    // InternalBot.g:1030:2: ( RULE_STRING )
                    // InternalBot.g:1031:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1036:2: ( RULE_ID )
                    {
                    // InternalBot.g:1036:2: ( RULE_ID )
                    // InternalBot.g:1037:3: RULE_ID
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
    // InternalBot.g:1046:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );
    public final void rule__Transition__TargetAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1050:1: ( ( ruleState ) | ( ruleState2 ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBot.g:1051:2: ( ruleState )
                    {
                    // InternalBot.g:1051:2: ( ruleState )
                    // InternalBot.g:1052:3: ruleState
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
                    // InternalBot.g:1057:2: ( ruleState2 )
                    {
                    // InternalBot.g:1057:2: ( ruleState2 )
                    // InternalBot.g:1058:3: ruleState2
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
    // InternalBot.g:1067:1: rule__TrainingPhrase__TokensAlternatives_1_0 : ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) );
    public final void rule__TrainingPhrase__TokensAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1071:1: ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            else if ( (LA7_0==67) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBot.g:1072:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1072:2: ( ruleLiteral )
                    // InternalBot.g:1073:3: ruleLiteral
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
                    // InternalBot.g:1078:2: ( ruleParameterRefenceToken )
                    {
                    // InternalBot.g:1078:2: ( ruleParameterRefenceToken )
                    // InternalBot.g:1079:3: ruleParameterRefenceToken
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
    // InternalBot.g:1088:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1092:1: ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) )
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
                    // InternalBot.g:1093:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    {
                    // InternalBot.g:1093:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    // InternalBot.g:1094:3: ( rule__Parameter__EntityAssignment_3_0 )
                    {
                     before(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 
                    // InternalBot.g:1095:3: ( rule__Parameter__EntityAssignment_3_0 )
                    // InternalBot.g:1095:4: rule__Parameter__EntityAssignment_3_0
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
                    // InternalBot.g:1099:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    {
                    // InternalBot.g:1099:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    // InternalBot.g:1100:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    {
                     before(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 
                    // InternalBot.g:1101:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    // InternalBot.g:1101:4: rule__Parameter__DefaultEntityAssignment_3_1
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
    // InternalBot.g:1109:1: rule__CompositeInput__TokensAlternatives_0_0 : ( ( ruleLiteral ) | ( ruleEntityToken ) );
    public final void rule__CompositeInput__TokensAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1113:1: ( ( ruleLiteral ) | ( ruleEntityToken ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                alt9=1;
            }
            else if ( (LA9_0==73) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBot.g:1114:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1114:2: ( ruleLiteral )
                    // InternalBot.g:1115:3: ruleLiteral
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
                    // InternalBot.g:1120:2: ( ruleEntityToken )
                    {
                    // InternalBot.g:1120:2: ( ruleEntityToken )
                    // InternalBot.g:1121:3: ruleEntityToken
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
    // InternalBot.g:1130:1: rule__TextInputHttpResponse__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) );
    public final void rule__TextInputHttpResponse__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1134:1: ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt10=1;
                }
                break;
            case 71:
                {
                alt10=2;
                }
                break;
            case 74:
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
                    // InternalBot.g:1135:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1135:2: ( ruleLiteral )
                    // InternalBot.g:1136:3: ruleLiteral
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
                    // InternalBot.g:1141:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1141:2: ( ruleParameterToken )
                    // InternalBot.g:1142:3: ruleParameterToken
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
                    // InternalBot.g:1147:2: ( ruleHTTPRequestToken )
                    {
                    // InternalBot.g:1147:2: ( ruleHTTPRequestToken )
                    // InternalBot.g:1148:3: ruleHTTPRequestToken
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
    // InternalBot.g:1157:1: rule__TextInputText__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__TextInputText__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1161:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                alt11=1;
            }
            else if ( (LA11_0==71) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:1162:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1162:2: ( ruleLiteral )
                    // InternalBot.g:1163:3: ruleLiteral
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
                    // InternalBot.g:1168:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1168:2: ( ruleParameterToken )
                    // InternalBot.g:1169:3: ruleParameterToken
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
    // InternalBot.g:1178:1: rule__Data__ValueAlternatives_2_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__Data__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1182:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                alt12=1;
            }
            else if ( (LA12_0==71) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBot.g:1183:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1183:2: ( ruleLiteral )
                    // InternalBot.g:1184:3: ruleLiteral
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
                    // InternalBot.g:1189:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1189:2: ( ruleParameterToken )
                    // InternalBot.g:1190:3: ruleParameterToken
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
    // InternalBot.g:1199:1: rule__DefaultEntity__Alternatives : ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) );
    public final void rule__DefaultEntity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1203:1: ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) )
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
                    // InternalBot.g:1204:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1204:2: ( ( 'text' ) )
                    // InternalBot.g:1205:3: ( 'text' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1206:3: ( 'text' )
                    // InternalBot.g:1206:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1210:2: ( ( 'number' ) )
                    {
                    // InternalBot.g:1210:2: ( ( 'number' ) )
                    // InternalBot.g:1211:3: ( 'number' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalBot.g:1212:3: ( 'number' )
                    // InternalBot.g:1212:4: 'number'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1216:2: ( ( 'date' ) )
                    {
                    // InternalBot.g:1216:2: ( ( 'date' ) )
                    // InternalBot.g:1217:3: ( 'date' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1218:3: ( 'date' )
                    // InternalBot.g:1218:4: 'date'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1222:2: ( ( 'float' ) )
                    {
                    // InternalBot.g:1222:2: ( ( 'float' ) )
                    // InternalBot.g:1223:3: ( 'float' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1224:3: ( 'float' )
                    // InternalBot.g:1224:4: 'float'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1228:2: ( ( 'time' ) )
                    {
                    // InternalBot.g:1228:2: ( ( 'time' ) )
                    // InternalBot.g:1229:3: ( 'time' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1230:3: ( 'time' )
                    // InternalBot.g:1230:4: 'time'
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
    // InternalBot.g:1238:1: rule__HTTPReturnType__Alternatives : ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) );
    public final void rule__HTTPReturnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1242:1: ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) )
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
                    // InternalBot.g:1243:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1243:2: ( ( 'text' ) )
                    // InternalBot.g:1244:3: ( 'text' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1245:3: ( 'text' )
                    // InternalBot.g:1245:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1249:2: ( ( 'status_code' ) )
                    {
                    // InternalBot.g:1249:2: ( ( 'status_code' ) )
                    // InternalBot.g:1250:3: ( 'status_code' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1251:3: ( 'status_code' )
                    // InternalBot.g:1251:4: 'status_code'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1255:2: ( ( 'image' ) )
                    {
                    // InternalBot.g:1255:2: ( ( 'image' ) )
                    // InternalBot.g:1256:3: ( 'image' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1257:3: ( 'image' )
                    // InternalBot.g:1257:4: 'image'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1261:2: ( ( 'data' ) )
                    {
                    // InternalBot.g:1261:2: ( ( 'data' ) )
                    // InternalBot.g:1262:3: ( 'data' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1263:3: ( 'data' )
                    // InternalBot.g:1263:4: 'data'
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
    // InternalBot.g:1271:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1275:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) )
            int alt15=26;
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
            case 39:
                {
                alt15=21;
                }
                break;
            case 40:
                {
                alt15=22;
                }
                break;
            case 41:
                {
                alt15=23;
                }
                break;
            case 42:
                {
                alt15=24;
                }
                break;
            case 43:
                {
                alt15=25;
                }
                break;
            case 44:
                {
                alt15=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalBot.g:1276:2: ( ( 'en' ) )
                    {
                    // InternalBot.g:1276:2: ( ( 'en' ) )
                    // InternalBot.g:1277:3: ( 'en' )
                    {
                     before(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1278:3: ( 'en' )
                    // InternalBot.g:1278:4: 'en'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1282:2: ( ( 'es' ) )
                    {
                    // InternalBot.g:1282:2: ( ( 'es' ) )
                    // InternalBot.g:1283:3: ( 'es' )
                    {
                     before(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1284:3: ( 'es' )
                    // InternalBot.g:1284:4: 'es'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1288:2: ( ( 'da' ) )
                    {
                    // InternalBot.g:1288:2: ( ( 'da' ) )
                    // InternalBot.g:1289:3: ( 'da' )
                    {
                     before(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1290:3: ( 'da' )
                    // InternalBot.g:1290:4: 'da'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1294:2: ( ( 'de' ) )
                    {
                    // InternalBot.g:1294:2: ( ( 'de' ) )
                    // InternalBot.g:1295:3: ( 'de' )
                    {
                     before(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1296:3: ( 'de' )
                    // InternalBot.g:1296:4: 'de'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1300:2: ( ( 'fr' ) )
                    {
                    // InternalBot.g:1300:2: ( ( 'fr' ) )
                    // InternalBot.g:1301:3: ( 'fr' )
                    {
                     before(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1302:3: ( 'fr' )
                    // InternalBot.g:1302:4: 'fr'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1306:2: ( ( 'hi' ) )
                    {
                    // InternalBot.g:1306:2: ( ( 'hi' ) )
                    // InternalBot.g:1307:3: ( 'hi' )
                    {
                     before(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 
                    // InternalBot.g:1308:3: ( 'hi' )
                    // InternalBot.g:1308:4: 'hi'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:1312:2: ( ( 'id' ) )
                    {
                    // InternalBot.g:1312:2: ( ( 'id' ) )
                    // InternalBot.g:1313:3: ( 'id' )
                    {
                     before(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 
                    // InternalBot.g:1314:3: ( 'id' )
                    // InternalBot.g:1314:4: 'id'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:1318:2: ( ( 'it' ) )
                    {
                    // InternalBot.g:1318:2: ( ( 'it' ) )
                    // InternalBot.g:1319:3: ( 'it' )
                    {
                     before(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 
                    // InternalBot.g:1320:3: ( 'it' )
                    // InternalBot.g:1320:4: 'it'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:1324:2: ( ( 'ja' ) )
                    {
                    // InternalBot.g:1324:2: ( ( 'ja' ) )
                    // InternalBot.g:1325:3: ( 'ja' )
                    {
                     before(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 
                    // InternalBot.g:1326:3: ( 'ja' )
                    // InternalBot.g:1326:4: 'ja'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:1330:2: ( ( 'ko' ) )
                    {
                    // InternalBot.g:1330:2: ( ( 'ko' ) )
                    // InternalBot.g:1331:3: ( 'ko' )
                    {
                     before(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 
                    // InternalBot.g:1332:3: ( 'ko' )
                    // InternalBot.g:1332:4: 'ko'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:1336:2: ( ( 'nl' ) )
                    {
                    // InternalBot.g:1336:2: ( ( 'nl' ) )
                    // InternalBot.g:1337:3: ( 'nl' )
                    {
                     before(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 
                    // InternalBot.g:1338:3: ( 'nl' )
                    // InternalBot.g:1338:4: 'nl'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:1342:2: ( ( 'no' ) )
                    {
                    // InternalBot.g:1342:2: ( ( 'no' ) )
                    // InternalBot.g:1343:3: ( 'no' )
                    {
                     before(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 
                    // InternalBot.g:1344:3: ( 'no' )
                    // InternalBot.g:1344:4: 'no'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:1348:2: ( ( 'pl' ) )
                    {
                    // InternalBot.g:1348:2: ( ( 'pl' ) )
                    // InternalBot.g:1349:3: ( 'pl' )
                    {
                     before(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 
                    // InternalBot.g:1350:3: ( 'pl' )
                    // InternalBot.g:1350:4: 'pl'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:1354:2: ( ( 'pt' ) )
                    {
                    // InternalBot.g:1354:2: ( ( 'pt' ) )
                    // InternalBot.g:1355:3: ( 'pt' )
                    {
                     before(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 
                    // InternalBot.g:1356:3: ( 'pt' )
                    // InternalBot.g:1356:4: 'pt'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:1360:2: ( ( 'ru' ) )
                    {
                    // InternalBot.g:1360:2: ( ( 'ru' ) )
                    // InternalBot.g:1361:3: ( 'ru' )
                    {
                     before(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 
                    // InternalBot.g:1362:3: ( 'ru' )
                    // InternalBot.g:1362:4: 'ru'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:1366:2: ( ( 'sv' ) )
                    {
                    // InternalBot.g:1366:2: ( ( 'sv' ) )
                    // InternalBot.g:1367:3: ( 'sv' )
                    {
                     before(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 
                    // InternalBot.g:1368:3: ( 'sv' )
                    // InternalBot.g:1368:4: 'sv'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:1372:2: ( ( 'th' ) )
                    {
                    // InternalBot.g:1372:2: ( ( 'th' ) )
                    // InternalBot.g:1373:3: ( 'th' )
                    {
                     before(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 
                    // InternalBot.g:1374:3: ( 'th' )
                    // InternalBot.g:1374:4: 'th'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:1378:2: ( ( 'tr' ) )
                    {
                    // InternalBot.g:1378:2: ( ( 'tr' ) )
                    // InternalBot.g:1379:3: ( 'tr' )
                    {
                     before(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 
                    // InternalBot.g:1380:3: ( 'tr' )
                    // InternalBot.g:1380:4: 'tr'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:1384:2: ( ( 'uk' ) )
                    {
                    // InternalBot.g:1384:2: ( ( 'uk' ) )
                    // InternalBot.g:1385:3: ( 'uk' )
                    {
                     before(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 
                    // InternalBot.g:1386:3: ( 'uk' )
                    // InternalBot.g:1386:4: 'uk'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:1390:2: ( ( 'zh' ) )
                    {
                    // InternalBot.g:1390:2: ( ( 'zh' ) )
                    // InternalBot.g:1391:3: ( 'zh' )
                    {
                     before(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 
                    // InternalBot.g:1392:3: ( 'zh' )
                    // InternalBot.g:1392:4: 'zh'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:1396:2: ( ( 'ar' ) )
                    {
                    // InternalBot.g:1396:2: ( ( 'ar' ) )
                    // InternalBot.g:1397:3: ( 'ar' )
                    {
                     before(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 
                    // InternalBot.g:1398:3: ( 'ar' )
                    // InternalBot.g:1398:4: 'ar'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:1402:2: ( ( 'cz' ) )
                    {
                    // InternalBot.g:1402:2: ( ( 'cz' ) )
                    // InternalBot.g:1403:3: ( 'cz' )
                    {
                     before(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 
                    // InternalBot.g:1404:3: ( 'cz' )
                    // InternalBot.g:1404:4: 'cz'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:1408:2: ( ( 'bu' ) )
                    {
                    // InternalBot.g:1408:2: ( ( 'bu' ) )
                    // InternalBot.g:1409:3: ( 'bu' )
                    {
                     before(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 
                    // InternalBot.g:1410:3: ( 'bu' )
                    // InternalBot.g:1410:4: 'bu'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:1414:2: ( ( 'fi' ) )
                    {
                    // InternalBot.g:1414:2: ( ( 'fi' ) )
                    // InternalBot.g:1415:3: ( 'fi' )
                    {
                     before(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 
                    // InternalBot.g:1416:3: ( 'fi' )
                    // InternalBot.g:1416:4: 'fi'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:1420:2: ( ( 'gr' ) )
                    {
                    // InternalBot.g:1420:2: ( ( 'gr' ) )
                    // InternalBot.g:1421:3: ( 'gr' )
                    {
                     before(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 
                    // InternalBot.g:1422:3: ( 'gr' )
                    // InternalBot.g:1422:4: 'gr'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:1426:2: ( ( 'ba' ) )
                    {
                    // InternalBot.g:1426:2: ( ( 'ba' ) )
                    // InternalBot.g:1427:3: ( 'ba' )
                    {
                     before(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 
                    // InternalBot.g:1428:3: ( 'ba' )
                    // InternalBot.g:1428:4: 'ba'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 

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
    // InternalBot.g:1436:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1440:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==45) ) {
                alt16=1;
            }
            else if ( (LA16_0==46) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalBot.g:1441:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1441:2: ( ( 'JSON' ) )
                    // InternalBot.g:1442:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1443:3: ( 'JSON' )
                    // InternalBot.g:1443:4: 'JSON'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1447:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1447:2: ( ( 'FORM' ) )
                    // InternalBot.g:1448:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1449:3: ( 'FORM' )
                    // InternalBot.g:1449:4: 'FORM'
                    {
                    match(input,46,FOLLOW_2); 

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
    // InternalBot.g:1457:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1461:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==47) ) {
                alt17=1;
            }
            else if ( (LA17_0==48) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalBot.g:1462:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1462:2: ( ( 'post' ) )
                    // InternalBot.g:1463:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1464:3: ( 'post' )
                    // InternalBot.g:1464:4: 'post'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1468:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1468:2: ( ( 'get' ) )
                    // InternalBot.g:1469:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1470:3: ( 'get' )
                    // InternalBot.g:1470:4: 'get'
                    {
                    match(input,48,FOLLOW_2); 

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
    // InternalBot.g:1478:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1482:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1483:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
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
    // InternalBot.g:1490:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1494:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1495:1: ( 'Chatbot' )
            {
            // InternalBot.g:1495:1: ( 'Chatbot' )
            // InternalBot.g:1496:2: 'Chatbot'
            {
             before(grammarAccess.getBotAccess().getChatbotKeyword_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalBot.g:1505:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1509:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1510:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
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
    // InternalBot.g:1517:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1521:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1522:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1522:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1523:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1524:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1524:3: rule__Bot__NameAssignment_1
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
    // InternalBot.g:1532:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1536:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1537:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
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
    // InternalBot.g:1544:1: rule__Bot__Group__2__Impl : ( 'language:' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1548:1: ( ( 'language:' ) )
            // InternalBot.g:1549:1: ( 'language:' )
            {
            // InternalBot.g:1549:1: ( 'language:' )
            // InternalBot.g:1550:2: 'language:'
            {
             before(grammarAccess.getBotAccess().getLanguageKeyword_2()); 
            match(input,50,FOLLOW_2); 
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
    // InternalBot.g:1559:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1563:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1564:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
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
    // InternalBot.g:1571:1: rule__Bot__Group__3__Impl : ( ( rule__Bot__LanguagesAssignment_3 ) ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1575:1: ( ( ( rule__Bot__LanguagesAssignment_3 ) ) )
            // InternalBot.g:1576:1: ( ( rule__Bot__LanguagesAssignment_3 ) )
            {
            // InternalBot.g:1576:1: ( ( rule__Bot__LanguagesAssignment_3 ) )
            // InternalBot.g:1577:2: ( rule__Bot__LanguagesAssignment_3 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_3()); 
            // InternalBot.g:1578:2: ( rule__Bot__LanguagesAssignment_3 )
            // InternalBot.g:1578:3: rule__Bot__LanguagesAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguagesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguagesAssignment_3()); 

            }


            }

        }
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
    // InternalBot.g:1586:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1590:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1591:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
            {
            pushFollow(FOLLOW_8);
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
    // InternalBot.g:1598:1: rule__Bot__Group__4__Impl : ( ( rule__Bot__Group_4__0 )* ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1602:1: ( ( ( rule__Bot__Group_4__0 )* ) )
            // InternalBot.g:1603:1: ( ( rule__Bot__Group_4__0 )* )
            {
            // InternalBot.g:1603:1: ( ( rule__Bot__Group_4__0 )* )
            // InternalBot.g:1604:2: ( rule__Bot__Group_4__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_4()); 
            // InternalBot.g:1605:2: ( rule__Bot__Group_4__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==54) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBot.g:1605:3: rule__Bot__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Bot__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_4()); 

            }


            }

        }
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
    // InternalBot.g:1613:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1617:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1618:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:1625:1: rule__Bot__Group__5__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1629:1: ( ( 'intents' ) )
            // InternalBot.g:1630:1: ( 'intents' )
            {
            // InternalBot.g:1630:1: ( 'intents' )
            // InternalBot.g:1631:2: 'intents'
            {
             before(grammarAccess.getBotAccess().getIntentsKeyword_5()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getIntentsKeyword_5()); 

            }


            }

        }
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
    // InternalBot.g:1640:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1644:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:1645:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:1652:1: rule__Bot__Group__6__Impl : ( ':' ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1656:1: ( ( ':' ) )
            // InternalBot.g:1657:1: ( ':' )
            {
            // InternalBot.g:1657:1: ( ':' )
            // InternalBot.g:1658:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_6()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_6()); 

            }


            }

        }
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
    // InternalBot.g:1667:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1671:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:1672:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
            {
            pushFollow(FOLLOW_11);
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
    // InternalBot.g:1679:1: rule__Bot__Group__7__Impl : ( ( rule__Bot__IntentsAssignment_7 ) ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1683:1: ( ( ( rule__Bot__IntentsAssignment_7 ) ) )
            // InternalBot.g:1684:1: ( ( rule__Bot__IntentsAssignment_7 ) )
            {
            // InternalBot.g:1684:1: ( ( rule__Bot__IntentsAssignment_7 ) )
            // InternalBot.g:1685:2: ( rule__Bot__IntentsAssignment_7 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_7()); 
            // InternalBot.g:1686:2: ( rule__Bot__IntentsAssignment_7 )
            // InternalBot.g:1686:3: rule__Bot__IntentsAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Bot__IntentsAssignment_7();

            state._fsp--;


            }

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
    // InternalBot.g:1694:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1698:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:1699:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
            {
            pushFollow(FOLLOW_11);
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
    // InternalBot.g:1706:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__IntentsAssignment_8 )* ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1710:1: ( ( ( rule__Bot__IntentsAssignment_8 )* ) )
            // InternalBot.g:1711:1: ( ( rule__Bot__IntentsAssignment_8 )* )
            {
            // InternalBot.g:1711:1: ( ( rule__Bot__IntentsAssignment_8 )* )
            // InternalBot.g:1712:2: ( rule__Bot__IntentsAssignment_8 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_8()); 
            // InternalBot.g:1713:2: ( rule__Bot__IntentsAssignment_8 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:1713:3: rule__Bot__IntentsAssignment_8
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Bot__IntentsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getIntentsAssignment_8()); 

            }


            }

        }
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
    // InternalBot.g:1721:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1725:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:1726:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
            {
            pushFollow(FOLLOW_11);
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
    // InternalBot.g:1733:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__Group_9__0 )? ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1737:1: ( ( ( rule__Bot__Group_9__0 )? ) )
            // InternalBot.g:1738:1: ( ( rule__Bot__Group_9__0 )? )
            {
            // InternalBot.g:1738:1: ( ( rule__Bot__Group_9__0 )? )
            // InternalBot.g:1739:2: ( rule__Bot__Group_9__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_9()); 
            // InternalBot.g:1740:2: ( rule__Bot__Group_9__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==55) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:1740:3: rule__Bot__Group_9__0
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
    // InternalBot.g:1748:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1752:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:1753:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
            {
            pushFollow(FOLLOW_11);
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
    // InternalBot.g:1760:1: rule__Bot__Group__10__Impl : ( ( rule__Bot__Group_10__0 )? ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1764:1: ( ( ( rule__Bot__Group_10__0 )? ) )
            // InternalBot.g:1765:1: ( ( rule__Bot__Group_10__0 )? )
            {
            // InternalBot.g:1765:1: ( ( rule__Bot__Group_10__0 )? )
            // InternalBot.g:1766:2: ( rule__Bot__Group_10__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_10()); 
            // InternalBot.g:1767:2: ( rule__Bot__Group_10__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==56) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBot.g:1767:3: rule__Bot__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Bot__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBotAccess().getGroup_10()); 

            }


            }

        }
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
    // InternalBot.g:1775:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1779:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:1780:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:1787:1: rule__Bot__Group__11__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1791:1: ( ( 'flows' ) )
            // InternalBot.g:1792:1: ( 'flows' )
            {
            // InternalBot.g:1792:1: ( 'flows' )
            // InternalBot.g:1793:2: 'flows'
            {
             before(grammarAccess.getBotAccess().getFlowsKeyword_11()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getFlowsKeyword_11()); 

            }


            }

        }
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
    // InternalBot.g:1802:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl rule__Bot__Group__13 ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1806:1: ( rule__Bot__Group__12__Impl rule__Bot__Group__13 )
            // InternalBot.g:1807:2: rule__Bot__Group__12__Impl rule__Bot__Group__13
            {
            pushFollow(FOLLOW_13);
            rule__Bot__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__13();

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
    // InternalBot.g:1814:1: rule__Bot__Group__12__Impl : ( ':' ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1818:1: ( ( ':' ) )
            // InternalBot.g:1819:1: ( ':' )
            {
            // InternalBot.g:1819:1: ( ':' )
            // InternalBot.g:1820:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_12()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_12()); 

            }


            }

        }
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


    // $ANTLR start "rule__Bot__Group__13"
    // InternalBot.g:1829:1: rule__Bot__Group__13 : rule__Bot__Group__13__Impl ;
    public final void rule__Bot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1833:1: ( rule__Bot__Group__13__Impl )
            // InternalBot.g:1834:2: rule__Bot__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group__13__Impl();

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
    // $ANTLR end "rule__Bot__Group__13"


    // $ANTLR start "rule__Bot__Group__13__Impl"
    // InternalBot.g:1840:1: rule__Bot__Group__13__Impl : ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) ) ;
    public final void rule__Bot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1844:1: ( ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) ) )
            // InternalBot.g:1845:1: ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) )
            {
            // InternalBot.g:1845:1: ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) )
            // InternalBot.g:1846:2: ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* )
            {
            // InternalBot.g:1846:2: ( ( rule__Bot__Group_13__0 ) )
            // InternalBot.g:1847:3: ( rule__Bot__Group_13__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_13()); 
            // InternalBot.g:1848:3: ( rule__Bot__Group_13__0 )
            // InternalBot.g:1848:4: rule__Bot__Group_13__0
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_13__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_13()); 

            }

            // InternalBot.g:1851:2: ( ( rule__Bot__Group_13__0 )* )
            // InternalBot.g:1852:3: ( rule__Bot__Group_13__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_13()); 
            // InternalBot.g:1853:3: ( rule__Bot__Group_13__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==57) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBot.g:1853:4: rule__Bot__Group_13__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Bot__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_13()); 

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
    // $ANTLR end "rule__Bot__Group__13__Impl"


    // $ANTLR start "rule__Bot__Group_4__0"
    // InternalBot.g:1863:1: rule__Bot__Group_4__0 : rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1 ;
    public final void rule__Bot__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1867:1: ( rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1 )
            // InternalBot.g:1868:2: rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Bot__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_4__1();

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
    // $ANTLR end "rule__Bot__Group_4__0"


    // $ANTLR start "rule__Bot__Group_4__0__Impl"
    // InternalBot.g:1875:1: rule__Bot__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Bot__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1879:1: ( ( ',' ) )
            // InternalBot.g:1880:1: ( ',' )
            {
            // InternalBot.g:1880:1: ( ',' )
            // InternalBot.g:1881:2: ','
            {
             before(grammarAccess.getBotAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_4__0__Impl"


    // $ANTLR start "rule__Bot__Group_4__1"
    // InternalBot.g:1890:1: rule__Bot__Group_4__1 : rule__Bot__Group_4__1__Impl ;
    public final void rule__Bot__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1894:1: ( rule__Bot__Group_4__1__Impl )
            // InternalBot.g:1895:2: rule__Bot__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_4__1__Impl();

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
    // $ANTLR end "rule__Bot__Group_4__1"


    // $ANTLR start "rule__Bot__Group_4__1__Impl"
    // InternalBot.g:1901:1: rule__Bot__Group_4__1__Impl : ( ( rule__Bot__LanguagesAssignment_4_1 ) ) ;
    public final void rule__Bot__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1905:1: ( ( ( rule__Bot__LanguagesAssignment_4_1 ) ) )
            // InternalBot.g:1906:1: ( ( rule__Bot__LanguagesAssignment_4_1 ) )
            {
            // InternalBot.g:1906:1: ( ( rule__Bot__LanguagesAssignment_4_1 ) )
            // InternalBot.g:1907:2: ( rule__Bot__LanguagesAssignment_4_1 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_4_1()); 
            // InternalBot.g:1908:2: ( rule__Bot__LanguagesAssignment_4_1 )
            // InternalBot.g:1908:3: rule__Bot__LanguagesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguagesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguagesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_4__1__Impl"


    // $ANTLR start "rule__Bot__Group_9__0"
    // InternalBot.g:1917:1: rule__Bot__Group_9__0 : rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 ;
    public final void rule__Bot__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1921:1: ( rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 )
            // InternalBot.g:1922:2: rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:1929:1: rule__Bot__Group_9__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1933:1: ( ( 'entities' ) )
            // InternalBot.g:1934:1: ( 'entities' )
            {
            // InternalBot.g:1934:1: ( 'entities' )
            // InternalBot.g:1935:2: 'entities'
            {
             before(grammarAccess.getBotAccess().getEntitiesKeyword_9_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getEntitiesKeyword_9_0()); 

            }


            }

        }
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
    // InternalBot.g:1944:1: rule__Bot__Group_9__1 : rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 ;
    public final void rule__Bot__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1948:1: ( rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 )
            // InternalBot.g:1949:2: rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2
            {
            pushFollow(FOLLOW_15);
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
    // InternalBot.g:1956:1: rule__Bot__Group_9__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1960:1: ( ( ':' ) )
            // InternalBot.g:1961:1: ( ':' )
            {
            // InternalBot.g:1961:1: ( ':' )
            // InternalBot.g:1962:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_9_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:1971:1: rule__Bot__Group_9__2 : rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 ;
    public final void rule__Bot__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1975:1: ( rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 )
            // InternalBot.g:1976:2: rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3
            {
            pushFollow(FOLLOW_15);
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
    // InternalBot.g:1983:1: rule__Bot__Group_9__2__Impl : ( ( rule__Bot__EntitiesAssignment_9_2 ) ) ;
    public final void rule__Bot__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1987:1: ( ( ( rule__Bot__EntitiesAssignment_9_2 ) ) )
            // InternalBot.g:1988:1: ( ( rule__Bot__EntitiesAssignment_9_2 ) )
            {
            // InternalBot.g:1988:1: ( ( rule__Bot__EntitiesAssignment_9_2 ) )
            // InternalBot.g:1989:2: ( rule__Bot__EntitiesAssignment_9_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_9_2()); 
            // InternalBot.g:1990:2: ( rule__Bot__EntitiesAssignment_9_2 )
            // InternalBot.g:1990:3: rule__Bot__EntitiesAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__EntitiesAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getEntitiesAssignment_9_2()); 

            }


            }

        }
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
    // InternalBot.g:1998:1: rule__Bot__Group_9__3 : rule__Bot__Group_9__3__Impl ;
    public final void rule__Bot__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2002:1: ( rule__Bot__Group_9__3__Impl )
            // InternalBot.g:2003:2: rule__Bot__Group_9__3__Impl
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
    // InternalBot.g:2009:1: rule__Bot__Group_9__3__Impl : ( ( rule__Bot__EntitiesAssignment_9_3 )* ) ;
    public final void rule__Bot__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2013:1: ( ( ( rule__Bot__EntitiesAssignment_9_3 )* ) )
            // InternalBot.g:2014:1: ( ( rule__Bot__EntitiesAssignment_9_3 )* )
            {
            // InternalBot.g:2014:1: ( ( rule__Bot__EntitiesAssignment_9_3 )* )
            // InternalBot.g:2015:2: ( rule__Bot__EntitiesAssignment_9_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_9_3()); 
            // InternalBot.g:2016:2: ( rule__Bot__EntitiesAssignment_9_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=76 && LA23_0<=77)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:2016:3: rule__Bot__EntitiesAssignment_9_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Bot__EntitiesAssignment_9_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getEntitiesAssignment_9_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Bot__Group_10__0"
    // InternalBot.g:2025:1: rule__Bot__Group_10__0 : rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 ;
    public final void rule__Bot__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2029:1: ( rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 )
            // InternalBot.g:2030:2: rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__1();

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
    // $ANTLR end "rule__Bot__Group_10__0"


    // $ANTLR start "rule__Bot__Group_10__0__Impl"
    // InternalBot.g:2037:1: rule__Bot__Group_10__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2041:1: ( ( 'actions' ) )
            // InternalBot.g:2042:1: ( 'actions' )
            {
            // InternalBot.g:2042:1: ( 'actions' )
            // InternalBot.g:2043:2: 'actions'
            {
             before(grammarAccess.getBotAccess().getActionsKeyword_10_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getActionsKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__0__Impl"


    // $ANTLR start "rule__Bot__Group_10__1"
    // InternalBot.g:2052:1: rule__Bot__Group_10__1 : rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 ;
    public final void rule__Bot__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2056:1: ( rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 )
            // InternalBot.g:2057:2: rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2
            {
            pushFollow(FOLLOW_17);
            rule__Bot__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__2();

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
    // $ANTLR end "rule__Bot__Group_10__1"


    // $ANTLR start "rule__Bot__Group_10__1__Impl"
    // InternalBot.g:2064:1: rule__Bot__Group_10__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2068:1: ( ( ':' ) )
            // InternalBot.g:2069:1: ( ':' )
            {
            // InternalBot.g:2069:1: ( ':' )
            // InternalBot.g:2070:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_10_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__1__Impl"


    // $ANTLR start "rule__Bot__Group_10__2"
    // InternalBot.g:2079:1: rule__Bot__Group_10__2 : rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 ;
    public final void rule__Bot__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2083:1: ( rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 )
            // InternalBot.g:2084:2: rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3
            {
            pushFollow(FOLLOW_17);
            rule__Bot__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__3();

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
    // $ANTLR end "rule__Bot__Group_10__2"


    // $ANTLR start "rule__Bot__Group_10__2__Impl"
    // InternalBot.g:2091:1: rule__Bot__Group_10__2__Impl : ( ( rule__Bot__ActionsAssignment_10_2 ) ) ;
    public final void rule__Bot__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2095:1: ( ( ( rule__Bot__ActionsAssignment_10_2 ) ) )
            // InternalBot.g:2096:1: ( ( rule__Bot__ActionsAssignment_10_2 ) )
            {
            // InternalBot.g:2096:1: ( ( rule__Bot__ActionsAssignment_10_2 ) )
            // InternalBot.g:2097:2: ( rule__Bot__ActionsAssignment_10_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_10_2()); 
            // InternalBot.g:2098:2: ( rule__Bot__ActionsAssignment_10_2 )
            // InternalBot.g:2098:3: rule__Bot__ActionsAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__ActionsAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getActionsAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__2__Impl"


    // $ANTLR start "rule__Bot__Group_10__3"
    // InternalBot.g:2106:1: rule__Bot__Group_10__3 : rule__Bot__Group_10__3__Impl ;
    public final void rule__Bot__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2110:1: ( rule__Bot__Group_10__3__Impl )
            // InternalBot.g:2111:2: rule__Bot__Group_10__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__3__Impl();

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
    // $ANTLR end "rule__Bot__Group_10__3"


    // $ANTLR start "rule__Bot__Group_10__3__Impl"
    // InternalBot.g:2117:1: rule__Bot__Group_10__3__Impl : ( ( rule__Bot__ActionsAssignment_10_3 )* ) ;
    public final void rule__Bot__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2121:1: ( ( ( rule__Bot__ActionsAssignment_10_3 )* ) )
            // InternalBot.g:2122:1: ( ( rule__Bot__ActionsAssignment_10_3 )* )
            {
            // InternalBot.g:2122:1: ( ( rule__Bot__ActionsAssignment_10_3 )* )
            // InternalBot.g:2123:2: ( rule__Bot__ActionsAssignment_10_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_10_3()); 
            // InternalBot.g:2124:2: ( rule__Bot__ActionsAssignment_10_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==11||LA24_0==17||LA24_0==80||LA24_0==82) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:2124:3: rule__Bot__ActionsAssignment_10_3
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Bot__ActionsAssignment_10_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getActionsAssignment_10_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__3__Impl"


    // $ANTLR start "rule__Bot__Group_13__0"
    // InternalBot.g:2133:1: rule__Bot__Group_13__0 : rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1 ;
    public final void rule__Bot__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2137:1: ( rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1 )
            // InternalBot.g:2138:2: rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1
            {
            pushFollow(FOLLOW_19);
            rule__Bot__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_13__1();

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
    // $ANTLR end "rule__Bot__Group_13__0"


    // $ANTLR start "rule__Bot__Group_13__0__Impl"
    // InternalBot.g:2145:1: rule__Bot__Group_13__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2149:1: ( ( '-' ) )
            // InternalBot.g:2150:1: ( '-' )
            {
            // InternalBot.g:2150:1: ( '-' )
            // InternalBot.g:2151:2: '-'
            {
             before(grammarAccess.getBotAccess().getHyphenMinusKeyword_13_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getHyphenMinusKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__0__Impl"


    // $ANTLR start "rule__Bot__Group_13__1"
    // InternalBot.g:2160:1: rule__Bot__Group_13__1 : rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2 ;
    public final void rule__Bot__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2164:1: ( rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2 )
            // InternalBot.g:2165:2: rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2
            {
            pushFollow(FOLLOW_20);
            rule__Bot__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_13__2();

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
    // $ANTLR end "rule__Bot__Group_13__1"


    // $ANTLR start "rule__Bot__Group_13__1__Impl"
    // InternalBot.g:2172:1: rule__Bot__Group_13__1__Impl : ( ( rule__Bot__FlowsAssignment_13_1 ) ) ;
    public final void rule__Bot__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2176:1: ( ( ( rule__Bot__FlowsAssignment_13_1 ) ) )
            // InternalBot.g:2177:1: ( ( rule__Bot__FlowsAssignment_13_1 ) )
            {
            // InternalBot.g:2177:1: ( ( rule__Bot__FlowsAssignment_13_1 ) )
            // InternalBot.g:2178:2: ( rule__Bot__FlowsAssignment_13_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_13_1()); 
            // InternalBot.g:2179:2: ( rule__Bot__FlowsAssignment_13_1 )
            // InternalBot.g:2179:3: rule__Bot__FlowsAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__FlowsAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getFlowsAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__1__Impl"


    // $ANTLR start "rule__Bot__Group_13__2"
    // InternalBot.g:2187:1: rule__Bot__Group_13__2 : rule__Bot__Group_13__2__Impl ;
    public final void rule__Bot__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2191:1: ( rule__Bot__Group_13__2__Impl )
            // InternalBot.g:2192:2: rule__Bot__Group_13__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_13__2__Impl();

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
    // $ANTLR end "rule__Bot__Group_13__2"


    // $ANTLR start "rule__Bot__Group_13__2__Impl"
    // InternalBot.g:2198:1: rule__Bot__Group_13__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2202:1: ( ( ';' ) )
            // InternalBot.g:2203:1: ( ';' )
            {
            // InternalBot.g:2203:1: ( ';' )
            // InternalBot.g:2204:2: ';'
            {
             before(grammarAccess.getBotAccess().getSemicolonKeyword_13_2()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getSemicolonKeyword_13_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__2__Impl"


    // $ANTLR start "rule__Intent__Group__0"
    // InternalBot.g:2214:1: rule__Intent__Group__0 : rule__Intent__Group__0__Impl rule__Intent__Group__1 ;
    public final void rule__Intent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2218:1: ( rule__Intent__Group__0__Impl rule__Intent__Group__1 )
            // InternalBot.g:2219:2: rule__Intent__Group__0__Impl rule__Intent__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalBot.g:2226:1: rule__Intent__Group__0__Impl : ( ( rule__Intent__NameAssignment_0 ) ) ;
    public final void rule__Intent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2230:1: ( ( ( rule__Intent__NameAssignment_0 ) ) )
            // InternalBot.g:2231:1: ( ( rule__Intent__NameAssignment_0 ) )
            {
            // InternalBot.g:2231:1: ( ( rule__Intent__NameAssignment_0 ) )
            // InternalBot.g:2232:2: ( rule__Intent__NameAssignment_0 )
            {
             before(grammarAccess.getIntentAccess().getNameAssignment_0()); 
            // InternalBot.g:2233:2: ( rule__Intent__NameAssignment_0 )
            // InternalBot.g:2233:3: rule__Intent__NameAssignment_0
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
    // InternalBot.g:2241:1: rule__Intent__Group__1 : rule__Intent__Group__1__Impl rule__Intent__Group__2 ;
    public final void rule__Intent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2245:1: ( rule__Intent__Group__1__Impl rule__Intent__Group__2 )
            // InternalBot.g:2246:2: rule__Intent__Group__1__Impl rule__Intent__Group__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalBot.g:2253:1: rule__Intent__Group__1__Impl : ( ( rule__Intent__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2257:1: ( ( ( rule__Intent__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2258:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2258:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2259:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2260:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==88) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:2260:3: rule__Intent__FallbackIntentAssignment_1
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
    // InternalBot.g:2268:1: rule__Intent__Group__2 : rule__Intent__Group__2__Impl rule__Intent__Group__3 ;
    public final void rule__Intent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2272:1: ( rule__Intent__Group__2__Impl rule__Intent__Group__3 )
            // InternalBot.g:2273:2: rule__Intent__Group__2__Impl rule__Intent__Group__3
            {
            pushFollow(FOLLOW_22);
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
    // InternalBot.g:2280:1: rule__Intent__Group__2__Impl : ( ':' ) ;
    public final void rule__Intent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2284:1: ( ( ':' ) )
            // InternalBot.g:2285:1: ( ':' )
            {
            // InternalBot.g:2285:1: ( ':' )
            // InternalBot.g:2286:2: ':'
            {
             before(grammarAccess.getIntentAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getColonKeyword_2()); 

            }


            }

        }
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
    // InternalBot.g:2295:1: rule__Intent__Group__3 : rule__Intent__Group__3__Impl rule__Intent__Group__4 ;
    public final void rule__Intent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2299:1: ( rule__Intent__Group__3__Impl rule__Intent__Group__4 )
            // InternalBot.g:2300:2: rule__Intent__Group__3__Impl rule__Intent__Group__4
            {
            pushFollow(FOLLOW_23);
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
    // InternalBot.g:2307:1: rule__Intent__Group__3__Impl : ( ( ( rule__Intent__InputsAssignment_3 ) ) ( ( rule__Intent__InputsAssignment_3 )* ) ) ;
    public final void rule__Intent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2311:1: ( ( ( ( rule__Intent__InputsAssignment_3 ) ) ( ( rule__Intent__InputsAssignment_3 )* ) ) )
            // InternalBot.g:2312:1: ( ( ( rule__Intent__InputsAssignment_3 ) ) ( ( rule__Intent__InputsAssignment_3 )* ) )
            {
            // InternalBot.g:2312:1: ( ( ( rule__Intent__InputsAssignment_3 ) ) ( ( rule__Intent__InputsAssignment_3 )* ) )
            // InternalBot.g:2313:2: ( ( rule__Intent__InputsAssignment_3 ) ) ( ( rule__Intent__InputsAssignment_3 )* )
            {
            // InternalBot.g:2313:2: ( ( rule__Intent__InputsAssignment_3 ) )
            // InternalBot.g:2314:3: ( rule__Intent__InputsAssignment_3 )
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_3()); 
            // InternalBot.g:2315:3: ( rule__Intent__InputsAssignment_3 )
            // InternalBot.g:2315:4: rule__Intent__InputsAssignment_3
            {
            pushFollow(FOLLOW_24);
            rule__Intent__InputsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getInputsAssignment_3()); 

            }

            // InternalBot.g:2318:2: ( ( rule__Intent__InputsAssignment_3 )* )
            // InternalBot.g:2319:3: ( rule__Intent__InputsAssignment_3 )*
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_3()); 
            // InternalBot.g:2320:3: ( rule__Intent__InputsAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==60) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBot.g:2320:4: rule__Intent__InputsAssignment_3
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Intent__InputsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getInputsAssignment_3()); 

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
    // $ANTLR end "rule__Intent__Group__3__Impl"


    // $ANTLR start "rule__Intent__Group__4"
    // InternalBot.g:2329:1: rule__Intent__Group__4 : rule__Intent__Group__4__Impl ;
    public final void rule__Intent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2333:1: ( rule__Intent__Group__4__Impl )
            // InternalBot.g:2334:2: rule__Intent__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group__4__Impl();

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
    // InternalBot.g:2340:1: rule__Intent__Group__4__Impl : ( ( rule__Intent__Group_4__0 )? ) ;
    public final void rule__Intent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2344:1: ( ( ( rule__Intent__Group_4__0 )? ) )
            // InternalBot.g:2345:1: ( ( rule__Intent__Group_4__0 )? )
            {
            // InternalBot.g:2345:1: ( ( rule__Intent__Group_4__0 )? )
            // InternalBot.g:2346:2: ( rule__Intent__Group_4__0 )?
            {
             before(grammarAccess.getIntentAccess().getGroup_4()); 
            // InternalBot.g:2347:2: ( rule__Intent__Group_4__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==59) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBot.g:2347:3: rule__Intent__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getGroup_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__Intent__Group_4__0"
    // InternalBot.g:2356:1: rule__Intent__Group_4__0 : rule__Intent__Group_4__0__Impl rule__Intent__Group_4__1 ;
    public final void rule__Intent__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2360:1: ( rule__Intent__Group_4__0__Impl rule__Intent__Group_4__1 )
            // InternalBot.g:2361:2: rule__Intent__Group_4__0__Impl rule__Intent__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_4__1();

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
    // $ANTLR end "rule__Intent__Group_4__0"


    // $ANTLR start "rule__Intent__Group_4__0__Impl"
    // InternalBot.g:2368:1: rule__Intent__Group_4__0__Impl : ( 'parameters:' ) ;
    public final void rule__Intent__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2372:1: ( ( 'parameters:' ) )
            // InternalBot.g:2373:1: ( 'parameters:' )
            {
            // InternalBot.g:2373:1: ( 'parameters:' )
            // InternalBot.g:2374:2: 'parameters:'
            {
             before(grammarAccess.getIntentAccess().getParametersKeyword_4_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getParametersKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__0__Impl"


    // $ANTLR start "rule__Intent__Group_4__1"
    // InternalBot.g:2383:1: rule__Intent__Group_4__1 : rule__Intent__Group_4__1__Impl rule__Intent__Group_4__2 ;
    public final void rule__Intent__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2387:1: ( rule__Intent__Group_4__1__Impl rule__Intent__Group_4__2 )
            // InternalBot.g:2388:2: rule__Intent__Group_4__1__Impl rule__Intent__Group_4__2
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_4__2();

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
    // $ANTLR end "rule__Intent__Group_4__1"


    // $ANTLR start "rule__Intent__Group_4__1__Impl"
    // InternalBot.g:2395:1: rule__Intent__Group_4__1__Impl : ( ( rule__Intent__ParametersAssignment_4_1 ) ) ;
    public final void rule__Intent__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2399:1: ( ( ( rule__Intent__ParametersAssignment_4_1 ) ) )
            // InternalBot.g:2400:1: ( ( rule__Intent__ParametersAssignment_4_1 ) )
            {
            // InternalBot.g:2400:1: ( ( rule__Intent__ParametersAssignment_4_1 ) )
            // InternalBot.g:2401:2: ( rule__Intent__ParametersAssignment_4_1 )
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_4_1()); 
            // InternalBot.g:2402:2: ( rule__Intent__ParametersAssignment_4_1 )
            // InternalBot.g:2402:3: rule__Intent__ParametersAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent__ParametersAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getParametersAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__1__Impl"


    // $ANTLR start "rule__Intent__Group_4__2"
    // InternalBot.g:2410:1: rule__Intent__Group_4__2 : rule__Intent__Group_4__2__Impl ;
    public final void rule__Intent__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2414:1: ( rule__Intent__Group_4__2__Impl )
            // InternalBot.g:2415:2: rule__Intent__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_4__2__Impl();

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
    // $ANTLR end "rule__Intent__Group_4__2"


    // $ANTLR start "rule__Intent__Group_4__2__Impl"
    // InternalBot.g:2421:1: rule__Intent__Group_4__2__Impl : ( ( rule__Intent__ParametersAssignment_4_2 )* ) ;
    public final void rule__Intent__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2425:1: ( ( ( rule__Intent__ParametersAssignment_4_2 )* ) )
            // InternalBot.g:2426:1: ( ( rule__Intent__ParametersAssignment_4_2 )* )
            {
            // InternalBot.g:2426:1: ( ( rule__Intent__ParametersAssignment_4_2 )* )
            // InternalBot.g:2427:2: ( rule__Intent__ParametersAssignment_4_2 )*
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_4_2()); 
            // InternalBot.g:2428:2: ( rule__Intent__ParametersAssignment_4_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_STRING) ) {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==52) ) {
                        int LA28_4 = input.LA(3);

                        if ( (LA28_4==69) ) {
                            alt28=1;
                        }


                    }


                }
                else if ( (LA28_0==RULE_ID) ) {
                    int LA28_3 = input.LA(2);

                    if ( (LA28_3==52) ) {
                        int LA28_4 = input.LA(3);

                        if ( (LA28_4==69) ) {
                            alt28=1;
                        }


                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalBot.g:2428:3: rule__Intent__ParametersAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent__ParametersAssignment_4_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getParametersAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__2__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__0"
    // InternalBot.g:2437:1: rule__IntentLanguageInputs__Group__0 : rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 ;
    public final void rule__IntentLanguageInputs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2441:1: ( rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 )
            // InternalBot.g:2442:2: rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__IntentLanguageInputs__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__1();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group__0"


    // $ANTLR start "rule__IntentLanguageInputs__Group__0__Impl"
    // InternalBot.g:2449:1: rule__IntentLanguageInputs__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__IntentLanguageInputs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2453:1: ( ( 'inputs' ) )
            // InternalBot.g:2454:1: ( 'inputs' )
            {
            // InternalBot.g:2454:1: ( 'inputs' )
            // InternalBot.g:2455:2: 'inputs'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__0__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__1"
    // InternalBot.g:2464:1: rule__IntentLanguageInputs__Group__1 : rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 ;
    public final void rule__IntentLanguageInputs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2468:1: ( rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 )
            // InternalBot.g:2469:2: rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IntentLanguageInputs__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__2();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group__1"


    // $ANTLR start "rule__IntentLanguageInputs__Group__1__Impl"
    // InternalBot.g:2476:1: rule__IntentLanguageInputs__Group__1__Impl : ( ( rule__IntentLanguageInputs__Group_1__0 )? ) ;
    public final void rule__IntentLanguageInputs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2480:1: ( ( ( rule__IntentLanguageInputs__Group_1__0 )? ) )
            // InternalBot.g:2481:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            {
            // InternalBot.g:2481:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            // InternalBot.g:2482:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 
            // InternalBot.g:2483:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==63) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:2483:3: rule__IntentLanguageInputs__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntentLanguageInputs__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__1__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__2"
    // InternalBot.g:2491:1: rule__IntentLanguageInputs__Group__2 : rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 ;
    public final void rule__IntentLanguageInputs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2495:1: ( rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 )
            // InternalBot.g:2496:2: rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__IntentLanguageInputs__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__3();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group__2"


    // $ANTLR start "rule__IntentLanguageInputs__Group__2__Impl"
    // InternalBot.g:2503:1: rule__IntentLanguageInputs__Group__2__Impl : ( '{' ) ;
    public final void rule__IntentLanguageInputs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2507:1: ( ( '{' ) )
            // InternalBot.g:2508:1: ( '{' )
            {
            // InternalBot.g:2508:1: ( '{' )
            // InternalBot.g:2509:2: '{'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__2__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__3"
    // InternalBot.g:2518:1: rule__IntentLanguageInputs__Group__3 : rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 ;
    public final void rule__IntentLanguageInputs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2522:1: ( rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 )
            // InternalBot.g:2523:2: rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__IntentLanguageInputs__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__4();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group__3"


    // $ANTLR start "rule__IntentLanguageInputs__Group__3__Impl"
    // InternalBot.g:2530:1: rule__IntentLanguageInputs__Group__3__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) ;
    public final void rule__IntentLanguageInputs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2534:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) )
            // InternalBot.g:2535:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            {
            // InternalBot.g:2535:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            // InternalBot.g:2536:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 
            // InternalBot.g:2537:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            // InternalBot.g:2537:3: rule__IntentLanguageInputs__InputsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__InputsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__3__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__4"
    // InternalBot.g:2545:1: rule__IntentLanguageInputs__Group__4 : rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 ;
    public final void rule__IntentLanguageInputs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2549:1: ( rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 )
            // InternalBot.g:2550:2: rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__IntentLanguageInputs__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__5();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group__4"


    // $ANTLR start "rule__IntentLanguageInputs__Group__4__Impl"
    // InternalBot.g:2557:1: rule__IntentLanguageInputs__Group__4__Impl : ( ( rule__IntentLanguageInputs__Group_4__0 )* ) ;
    public final void rule__IntentLanguageInputs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2561:1: ( ( ( rule__IntentLanguageInputs__Group_4__0 )* ) )
            // InternalBot.g:2562:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            {
            // InternalBot.g:2562:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            // InternalBot.g:2563:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 
            // InternalBot.g:2564:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==54) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBot.g:2564:3: rule__IntentLanguageInputs__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__IntentLanguageInputs__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__4__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__5"
    // InternalBot.g:2572:1: rule__IntentLanguageInputs__Group__5 : rule__IntentLanguageInputs__Group__5__Impl ;
    public final void rule__IntentLanguageInputs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2576:1: ( rule__IntentLanguageInputs__Group__5__Impl )
            // InternalBot.g:2577:2: rule__IntentLanguageInputs__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__5__Impl();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group__5"


    // $ANTLR start "rule__IntentLanguageInputs__Group__5__Impl"
    // InternalBot.g:2583:1: rule__IntentLanguageInputs__Group__5__Impl : ( '}' ) ;
    public final void rule__IntentLanguageInputs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2587:1: ( ( '}' ) )
            // InternalBot.g:2588:1: ( '}' )
            {
            // InternalBot.g:2588:1: ( '}' )
            // InternalBot.g:2589:2: '}'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__5__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__0"
    // InternalBot.g:2599:1: rule__IntentLanguageInputs__Group_1__0 : rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 ;
    public final void rule__IntentLanguageInputs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2603:1: ( rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 )
            // InternalBot.g:2604:2: rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__IntentLanguageInputs__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_1__1();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__0"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__0__Impl"
    // InternalBot.g:2611:1: rule__IntentLanguageInputs__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__IntentLanguageInputs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2615:1: ( ( 'in' ) )
            // InternalBot.g:2616:1: ( 'in' )
            {
            // InternalBot.g:2616:1: ( 'in' )
            // InternalBot.g:2617:2: 'in'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__0__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__1"
    // InternalBot.g:2626:1: rule__IntentLanguageInputs__Group_1__1 : rule__IntentLanguageInputs__Group_1__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2630:1: ( rule__IntentLanguageInputs__Group_1__1__Impl )
            // InternalBot.g:2631:2: rule__IntentLanguageInputs__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_1__1__Impl();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__1"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__1__Impl"
    // InternalBot.g:2637:1: rule__IntentLanguageInputs__Group_1__1__Impl : ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2641:1: ( ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:2642:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:2642:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            // InternalBot.g:2643:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:2644:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            // InternalBot.g:2644:3: rule__IntentLanguageInputs__LanguageAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__LanguageAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__1__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__0"
    // InternalBot.g:2653:1: rule__IntentLanguageInputs__Group_4__0 : rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 ;
    public final void rule__IntentLanguageInputs__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2657:1: ( rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 )
            // InternalBot.g:2658:2: rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1
            {
            pushFollow(FOLLOW_26);
            rule__IntentLanguageInputs__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_4__1();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__0"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__0__Impl"
    // InternalBot.g:2665:1: rule__IntentLanguageInputs__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IntentLanguageInputs__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2669:1: ( ( ',' ) )
            // InternalBot.g:2670:1: ( ',' )
            {
            // InternalBot.g:2670:1: ( ',' )
            // InternalBot.g:2671:2: ','
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__0__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__1"
    // InternalBot.g:2680:1: rule__IntentLanguageInputs__Group_4__1 : rule__IntentLanguageInputs__Group_4__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2684:1: ( rule__IntentLanguageInputs__Group_4__1__Impl )
            // InternalBot.g:2685:2: rule__IntentLanguageInputs__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_4__1__Impl();

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
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__1"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__1__Impl"
    // InternalBot.g:2691:1: rule__IntentLanguageInputs__Group_4__1__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2695:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) )
            // InternalBot.g:2696:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:2696:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            // InternalBot.g:2697:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:2698:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            // InternalBot.g:2698:3: rule__IntentLanguageInputs__InputsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__InputsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__1__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalBot.g:2707:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2711:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:2712:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
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
    // InternalBot.g:2719:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2723:1: ( ( 'user' ) )
            // InternalBot.g:2724:1: ( 'user' )
            {
            // InternalBot.g:2724:1: ( 'user' )
            // InternalBot.g:2725:2: 'user'
            {
             before(grammarAccess.getTransitionAccess().getUserKeyword_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:2734:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2738:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:2739:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalBot.g:2746:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2750:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:2751:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:2751:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:2752:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:2753:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:2753:3: rule__Transition__IntentAssignment_1
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
    // InternalBot.g:2761:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2765:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:2766:2: rule__Transition__Group__2__Impl
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
    // InternalBot.g:2772:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2776:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:2777:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:2777:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:2778:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:2779:2: ( rule__Transition__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==65) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:2779:3: rule__Transition__Group_2__0
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
    // InternalBot.g:2788:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2792:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:2793:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalBot.g:2800:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2804:1: ( ( '=>' ) )
            // InternalBot.g:2805:1: ( '=>' )
            {
            // InternalBot.g:2805:1: ( '=>' )
            // InternalBot.g:2806:2: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:2815:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2819:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:2820:2: rule__Transition__Group_2__1__Impl
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
    // InternalBot.g:2826:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2830:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:2831:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:2831:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:2832:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:2833:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:2833:3: rule__Transition__TargetAssignment_2_1
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
    // InternalBot.g:2842:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2846:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:2847:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalBot.g:2854:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2858:1: ( ( 'chatbot' ) )
            // InternalBot.g:2859:1: ( 'chatbot' )
            {
            // InternalBot.g:2859:1: ( 'chatbot' )
            // InternalBot.g:2860:2: 'chatbot'
            {
             before(grammarAccess.getStateAccess().getChatbotKeyword_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:2869:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2873:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:2874:2: rule__State__Group__1__Impl rule__State__Group__2
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
    // InternalBot.g:2881:1: rule__State__Group__1__Impl : ( '(' ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2885:1: ( ( '(' ) )
            // InternalBot.g:2886:1: ( '(' )
            {
            // InternalBot.g:2886:1: ( '(' )
            // InternalBot.g:2887:2: '('
            {
             before(grammarAccess.getStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,67,FOLLOW_2); 
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
    // InternalBot.g:2896:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2900:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:2901:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalBot.g:2908:1: rule__State__Group__2__Impl : ( ( rule__State__ActionsAssignment_2 ) ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2912:1: ( ( ( rule__State__ActionsAssignment_2 ) ) )
            // InternalBot.g:2913:1: ( ( rule__State__ActionsAssignment_2 ) )
            {
            // InternalBot.g:2913:1: ( ( rule__State__ActionsAssignment_2 ) )
            // InternalBot.g:2914:2: ( rule__State__ActionsAssignment_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2()); 
            // InternalBot.g:2915:2: ( rule__State__ActionsAssignment_2 )
            // InternalBot.g:2915:3: rule__State__ActionsAssignment_2
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
    // InternalBot.g:2923:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2927:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // InternalBot.g:2928:2: rule__State__Group__3__Impl rule__State__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalBot.g:2935:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2939:1: ( ( ( rule__State__Group_3__0 )* ) )
            // InternalBot.g:2940:1: ( ( rule__State__Group_3__0 )* )
            {
            // InternalBot.g:2940:1: ( ( rule__State__Group_3__0 )* )
            // InternalBot.g:2941:2: ( rule__State__Group_3__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:2942:2: ( rule__State__Group_3__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==54) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBot.g:2942:3: rule__State__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__State__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalBot.g:2950:1: rule__State__Group__4 : rule__State__Group__4__Impl rule__State__Group__5 ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2954:1: ( rule__State__Group__4__Impl rule__State__Group__5 )
            // InternalBot.g:2955:2: rule__State__Group__4__Impl rule__State__Group__5
            {
            pushFollow(FOLLOW_28);
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
    // InternalBot.g:2962:1: rule__State__Group__4__Impl : ( ')' ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2966:1: ( ( ')' ) )
            // InternalBot.g:2967:1: ( ')' )
            {
            // InternalBot.g:2967:1: ( ')' )
            // InternalBot.g:2968:2: ')'
            {
             before(grammarAccess.getStateAccess().getRightParenthesisKeyword_4()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBot.g:2977:1: rule__State__Group__5 : rule__State__Group__5__Impl ;
    public final void rule__State__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2981:1: ( rule__State__Group__5__Impl )
            // InternalBot.g:2982:2: rule__State__Group__5__Impl
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
    // InternalBot.g:2988:1: rule__State__Group__5__Impl : ( ( rule__State__Group_5__0 )? ) ;
    public final void rule__State__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2992:1: ( ( ( rule__State__Group_5__0 )? ) )
            // InternalBot.g:2993:1: ( ( rule__State__Group_5__0 )? )
            {
            // InternalBot.g:2993:1: ( ( rule__State__Group_5__0 )? )
            // InternalBot.g:2994:2: ( rule__State__Group_5__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_5()); 
            // InternalBot.g:2995:2: ( rule__State__Group_5__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==65) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:2995:3: rule__State__Group_5__0
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
    // InternalBot.g:3004:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3008:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:3009:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
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
    // InternalBot.g:3016:1: rule__State__Group_3__0__Impl : ( ',' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3020:1: ( ( ',' ) )
            // InternalBot.g:3021:1: ( ',' )
            {
            // InternalBot.g:3021:1: ( ',' )
            // InternalBot.g:3022:2: ','
            {
             before(grammarAccess.getStateAccess().getCommaKeyword_3_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:3031:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3035:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:3036:2: rule__State__Group_3__1__Impl
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
    // InternalBot.g:3042:1: rule__State__Group_3__1__Impl : ( ( rule__State__ActionsAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3046:1: ( ( ( rule__State__ActionsAssignment_3_1 ) ) )
            // InternalBot.g:3047:1: ( ( rule__State__ActionsAssignment_3_1 ) )
            {
            // InternalBot.g:3047:1: ( ( rule__State__ActionsAssignment_3_1 ) )
            // InternalBot.g:3048:2: ( rule__State__ActionsAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_3_1()); 
            // InternalBot.g:3049:2: ( rule__State__ActionsAssignment_3_1 )
            // InternalBot.g:3049:3: rule__State__ActionsAssignment_3_1
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
    // InternalBot.g:3058:1: rule__State__Group_5__0 : rule__State__Group_5__0__Impl rule__State__Group_5__1 ;
    public final void rule__State__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3062:1: ( rule__State__Group_5__0__Impl rule__State__Group_5__1 )
            // InternalBot.g:3063:2: rule__State__Group_5__0__Impl rule__State__Group_5__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalBot.g:3070:1: rule__State__Group_5__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3074:1: ( ( '=>' ) )
            // InternalBot.g:3075:1: ( '=>' )
            {
            // InternalBot.g:3075:1: ( '=>' )
            // InternalBot.g:3076:2: '=>'
            {
             before(grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_5_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:3085:1: rule__State__Group_5__1 : rule__State__Group_5__1__Impl ;
    public final void rule__State__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3089:1: ( rule__State__Group_5__1__Impl )
            // InternalBot.g:3090:2: rule__State__Group_5__1__Impl
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
    // InternalBot.g:3096:1: rule__State__Group_5__1__Impl : ( ( rule__State__OutcomingAssignment_5_1 ) ) ;
    public final void rule__State__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3100:1: ( ( ( rule__State__OutcomingAssignment_5_1 ) ) )
            // InternalBot.g:3101:1: ( ( rule__State__OutcomingAssignment_5_1 ) )
            {
            // InternalBot.g:3101:1: ( ( rule__State__OutcomingAssignment_5_1 ) )
            // InternalBot.g:3102:2: ( rule__State__OutcomingAssignment_5_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_5_1()); 
            // InternalBot.g:3103:2: ( rule__State__OutcomingAssignment_5_1 )
            // InternalBot.g:3103:3: rule__State__OutcomingAssignment_5_1
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
    // InternalBot.g:3112:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3116:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:3117:2: rule__State2__Group__0__Impl rule__State2__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalBot.g:3124:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3128:1: ( ( 'chatbot' ) )
            // InternalBot.g:3129:1: ( 'chatbot' )
            {
            // InternalBot.g:3129:1: ( 'chatbot' )
            // InternalBot.g:3130:2: 'chatbot'
            {
             before(grammarAccess.getState2Access().getChatbotKeyword_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:3139:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3143:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:3144:2: rule__State2__Group__1__Impl rule__State2__Group__2
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
    // InternalBot.g:3151:1: rule__State2__Group__1__Impl : ( '(' ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3155:1: ( ( '(' ) )
            // InternalBot.g:3156:1: ( '(' )
            {
            // InternalBot.g:3156:1: ( '(' )
            // InternalBot.g:3157:2: '('
            {
             before(grammarAccess.getState2Access().getLeftParenthesisKeyword_1()); 
            match(input,67,FOLLOW_2); 
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
    // InternalBot.g:3166:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3170:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:3171:2: rule__State2__Group__2__Impl rule__State2__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalBot.g:3178:1: rule__State2__Group__2__Impl : ( ( rule__State2__ActionsAssignment_2 ) ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3182:1: ( ( ( rule__State2__ActionsAssignment_2 ) ) )
            // InternalBot.g:3183:1: ( ( rule__State2__ActionsAssignment_2 ) )
            {
            // InternalBot.g:3183:1: ( ( rule__State2__ActionsAssignment_2 ) )
            // InternalBot.g:3184:2: ( rule__State2__ActionsAssignment_2 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2()); 
            // InternalBot.g:3185:2: ( rule__State2__ActionsAssignment_2 )
            // InternalBot.g:3185:3: rule__State2__ActionsAssignment_2
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
    // InternalBot.g:3193:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3197:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:3198:2: rule__State2__Group__3__Impl rule__State2__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalBot.g:3205:1: rule__State2__Group__3__Impl : ( ( rule__State2__Group_3__0 )* ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3209:1: ( ( ( rule__State2__Group_3__0 )* ) )
            // InternalBot.g:3210:1: ( ( rule__State2__Group_3__0 )* )
            {
            // InternalBot.g:3210:1: ( ( rule__State2__Group_3__0 )* )
            // InternalBot.g:3211:2: ( rule__State2__Group_3__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_3()); 
            // InternalBot.g:3212:2: ( rule__State2__Group_3__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==54) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:3212:3: rule__State2__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__State2__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalBot.g:3220:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3224:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:3225:2: rule__State2__Group__4__Impl rule__State2__Group__5
            {
            pushFollow(FOLLOW_32);
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
    // InternalBot.g:3232:1: rule__State2__Group__4__Impl : ( ')' ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3236:1: ( ( ')' ) )
            // InternalBot.g:3237:1: ( ')' )
            {
            // InternalBot.g:3237:1: ( ')' )
            // InternalBot.g:3238:2: ')'
            {
             before(grammarAccess.getState2Access().getRightParenthesisKeyword_4()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBot.g:3247:1: rule__State2__Group__5 : rule__State2__Group__5__Impl rule__State2__Group__6 ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3251:1: ( rule__State2__Group__5__Impl rule__State2__Group__6 )
            // InternalBot.g:3252:2: rule__State2__Group__5__Impl rule__State2__Group__6
            {
            pushFollow(FOLLOW_28);
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
    // InternalBot.g:3259:1: rule__State2__Group__5__Impl : ( '{' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3263:1: ( ( '{' ) )
            // InternalBot.g:3264:1: ( '{' )
            {
            // InternalBot.g:3264:1: ( '{' )
            // InternalBot.g:3265:2: '{'
            {
             before(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:3274:1: rule__State2__Group__6 : rule__State2__Group__6__Impl rule__State2__Group__7 ;
    public final void rule__State2__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3278:1: ( rule__State2__Group__6__Impl rule__State2__Group__7 )
            // InternalBot.g:3279:2: rule__State2__Group__6__Impl rule__State2__Group__7
            {
            pushFollow(FOLLOW_33);
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
    // InternalBot.g:3286:1: rule__State2__Group__6__Impl : ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) ) ;
    public final void rule__State2__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3290:1: ( ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) ) )
            // InternalBot.g:3291:1: ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) )
            {
            // InternalBot.g:3291:1: ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) )
            // InternalBot.g:3292:2: ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* )
            {
            // InternalBot.g:3292:2: ( ( rule__State2__Group_6__0 ) )
            // InternalBot.g:3293:3: ( rule__State2__Group_6__0 )
            {
             before(grammarAccess.getState2Access().getGroup_6()); 
            // InternalBot.g:3294:3: ( rule__State2__Group_6__0 )
            // InternalBot.g:3294:4: rule__State2__Group_6__0
            {
            pushFollow(FOLLOW_34);
            rule__State2__Group_6__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_6()); 

            }

            // InternalBot.g:3297:2: ( ( rule__State2__Group_6__0 )* )
            // InternalBot.g:3298:3: ( rule__State2__Group_6__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_6()); 
            // InternalBot.g:3299:3: ( rule__State2__Group_6__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==65) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBot.g:3299:4: rule__State2__Group_6__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__State2__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalBot.g:3308:1: rule__State2__Group__7 : rule__State2__Group__7__Impl ;
    public final void rule__State2__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3312:1: ( rule__State2__Group__7__Impl )
            // InternalBot.g:3313:2: rule__State2__Group__7__Impl
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
    // InternalBot.g:3319:1: rule__State2__Group__7__Impl : ( '}' ) ;
    public final void rule__State2__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3323:1: ( ( '}' ) )
            // InternalBot.g:3324:1: ( '}' )
            {
            // InternalBot.g:3324:1: ( '}' )
            // InternalBot.g:3325:2: '}'
            {
             before(grammarAccess.getState2Access().getRightCurlyBracketKeyword_7()); 
            match(input,62,FOLLOW_2); 
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
    // InternalBot.g:3335:1: rule__State2__Group_3__0 : rule__State2__Group_3__0__Impl rule__State2__Group_3__1 ;
    public final void rule__State2__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3339:1: ( rule__State2__Group_3__0__Impl rule__State2__Group_3__1 )
            // InternalBot.g:3340:2: rule__State2__Group_3__0__Impl rule__State2__Group_3__1
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
    // InternalBot.g:3347:1: rule__State2__Group_3__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3351:1: ( ( ',' ) )
            // InternalBot.g:3352:1: ( ',' )
            {
            // InternalBot.g:3352:1: ( ',' )
            // InternalBot.g:3353:2: ','
            {
             before(grammarAccess.getState2Access().getCommaKeyword_3_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:3362:1: rule__State2__Group_3__1 : rule__State2__Group_3__1__Impl ;
    public final void rule__State2__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3366:1: ( rule__State2__Group_3__1__Impl )
            // InternalBot.g:3367:2: rule__State2__Group_3__1__Impl
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
    // InternalBot.g:3373:1: rule__State2__Group_3__1__Impl : ( ( rule__State2__ActionsAssignment_3_1 ) ) ;
    public final void rule__State2__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3377:1: ( ( ( rule__State2__ActionsAssignment_3_1 ) ) )
            // InternalBot.g:3378:1: ( ( rule__State2__ActionsAssignment_3_1 ) )
            {
            // InternalBot.g:3378:1: ( ( rule__State2__ActionsAssignment_3_1 ) )
            // InternalBot.g:3379:2: ( rule__State2__ActionsAssignment_3_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_3_1()); 
            // InternalBot.g:3380:2: ( rule__State2__ActionsAssignment_3_1 )
            // InternalBot.g:3380:3: rule__State2__ActionsAssignment_3_1
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
    // InternalBot.g:3389:1: rule__State2__Group_6__0 : rule__State2__Group_6__0__Impl rule__State2__Group_6__1 ;
    public final void rule__State2__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3393:1: ( rule__State2__Group_6__0__Impl rule__State2__Group_6__1 )
            // InternalBot.g:3394:2: rule__State2__Group_6__0__Impl rule__State2__Group_6__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalBot.g:3401:1: rule__State2__Group_6__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3405:1: ( ( '=>' ) )
            // InternalBot.g:3406:1: ( '=>' )
            {
            // InternalBot.g:3406:1: ( '=>' )
            // InternalBot.g:3407:2: '=>'
            {
             before(grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_6_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:3416:1: rule__State2__Group_6__1 : rule__State2__Group_6__1__Impl rule__State2__Group_6__2 ;
    public final void rule__State2__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3420:1: ( rule__State2__Group_6__1__Impl rule__State2__Group_6__2 )
            // InternalBot.g:3421:2: rule__State2__Group_6__1__Impl rule__State2__Group_6__2
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:3428:1: rule__State2__Group_6__1__Impl : ( ( rule__State2__OutcomingAssignment_6_1 ) ) ;
    public final void rule__State2__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3432:1: ( ( ( rule__State2__OutcomingAssignment_6_1 ) ) )
            // InternalBot.g:3433:1: ( ( rule__State2__OutcomingAssignment_6_1 ) )
            {
            // InternalBot.g:3433:1: ( ( rule__State2__OutcomingAssignment_6_1 ) )
            // InternalBot.g:3434:2: ( rule__State2__OutcomingAssignment_6_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_6_1()); 
            // InternalBot.g:3435:2: ( rule__State2__OutcomingAssignment_6_1 )
            // InternalBot.g:3435:3: rule__State2__OutcomingAssignment_6_1
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
    // InternalBot.g:3443:1: rule__State2__Group_6__2 : rule__State2__Group_6__2__Impl ;
    public final void rule__State2__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3447:1: ( rule__State2__Group_6__2__Impl )
            // InternalBot.g:3448:2: rule__State2__Group_6__2__Impl
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
    // InternalBot.g:3454:1: rule__State2__Group_6__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3458:1: ( ( ';' ) )
            // InternalBot.g:3459:1: ( ';' )
            {
            // InternalBot.g:3459:1: ( ';' )
            // InternalBot.g:3460:2: ';'
            {
             before(grammarAccess.getState2Access().getSemicolonKeyword_6_2()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:3470:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3474:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3475:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalBot.g:3482:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3486:1: ( ( () ) )
            // InternalBot.g:3487:1: ( () )
            {
            // InternalBot.g:3487:1: ( () )
            // InternalBot.g:3488:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3489:2: ()
            // InternalBot.g:3489:3: 
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
    // InternalBot.g:3497:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3501:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3502:2: rule__TrainingPhrase__Group__1__Impl
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
    // InternalBot.g:3508:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3512:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3513:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3513:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3514:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3514:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3515:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3516:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3516:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_35);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3519:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3520:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3521:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)||LA36_0==67) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:3521:4: rule__TrainingPhrase__TokensAssignment_1
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__TrainingPhrase__TokensAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalBot.g:3531:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3535:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3536:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:3543:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3547:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3548:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3548:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3549:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3550:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3550:3: rule__Parameter__NameAssignment_0
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
    // InternalBot.g:3558:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3562:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3563:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalBot.g:3570:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3574:1: ( ( ':' ) )
            // InternalBot.g:3575:1: ( ':' )
            {
            // InternalBot.g:3575:1: ( ':' )
            // InternalBot.g:3576:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:3585:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3589:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3590:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FOLLOW_37);
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
    // InternalBot.g:3597:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3601:1: ( ( 'entity' ) )
            // InternalBot.g:3602:1: ( 'entity' )
            {
            // InternalBot.g:3602:1: ( 'entity' )
            // InternalBot.g:3603:2: 'entity'
            {
             before(grammarAccess.getParameterAccess().getEntityKeyword_2()); 
            match(input,69,FOLLOW_2); 
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
    // InternalBot.g:3612:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3616:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:3617:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3624:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3628:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:3629:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:3629:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:3630:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:3631:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:3631:3: rule__Parameter__Alternatives_3
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
    // InternalBot.g:3639:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3643:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:3644:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3651:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3655:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:3656:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:3656:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:3657:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:3658:2: ( rule__Parameter__Group_4__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==54) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==89) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:3658:3: rule__Parameter__Group_4__0
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
    // InternalBot.g:3666:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3670:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:3671:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3678:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3682:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:3683:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:3683:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:3684:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:3685:2: ( rule__Parameter__Group_5__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==54) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:3685:3: rule__Parameter__Group_5__0
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
    // InternalBot.g:3693:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3697:1: ( rule__Parameter__Group__6__Impl )
            // InternalBot.g:3698:2: rule__Parameter__Group__6__Impl
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
    // InternalBot.g:3704:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3708:1: ( ( ';' ) )
            // InternalBot.g:3709:1: ( ';' )
            {
            // InternalBot.g:3709:1: ( ';' )
            // InternalBot.g:3710:2: ';'
            {
             before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:3720:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3724:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:3725:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalBot.g:3732:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3736:1: ( ( ',' ) )
            // InternalBot.g:3737:1: ( ',' )
            {
            // InternalBot.g:3737:1: ( ',' )
            // InternalBot.g:3738:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:3747:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3751:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // InternalBot.g:3752:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalBot.g:3759:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__RequiredAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3763:1: ( ( ( rule__Parameter__RequiredAssignment_4_1 ) ) )
            // InternalBot.g:3764:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            {
            // InternalBot.g:3764:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            // InternalBot.g:3765:2: ( rule__Parameter__RequiredAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_4_1()); 
            // InternalBot.g:3766:2: ( rule__Parameter__RequiredAssignment_4_1 )
            // InternalBot.g:3766:3: rule__Parameter__RequiredAssignment_4_1
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
    // InternalBot.g:3774:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3778:1: ( rule__Parameter__Group_4__2__Impl )
            // InternalBot.g:3779:2: rule__Parameter__Group_4__2__Impl
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
    // InternalBot.g:3785:1: rule__Parameter__Group_4__2__Impl : ( ( rule__Parameter__Group_4_2__0 )? ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3789:1: ( ( ( rule__Parameter__Group_4_2__0 )? ) )
            // InternalBot.g:3790:1: ( ( rule__Parameter__Group_4_2__0 )? )
            {
            // InternalBot.g:3790:1: ( ( rule__Parameter__Group_4_2__0 )? )
            // InternalBot.g:3791:2: ( rule__Parameter__Group_4_2__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4_2()); 
            // InternalBot.g:3792:2: ( rule__Parameter__Group_4_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==54) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==70) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:3792:3: rule__Parameter__Group_4_2__0
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
    // InternalBot.g:3801:1: rule__Parameter__Group_4_2__0 : rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1 ;
    public final void rule__Parameter__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3805:1: ( rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1 )
            // InternalBot.g:3806:2: rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalBot.g:3813:1: rule__Parameter__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3817:1: ( ( ',' ) )
            // InternalBot.g:3818:1: ( ',' )
            {
            // InternalBot.g:3818:1: ( ',' )
            // InternalBot.g:3819:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_2_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:3828:1: rule__Parameter__Group_4_2__1 : rule__Parameter__Group_4_2__1__Impl ;
    public final void rule__Parameter__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3832:1: ( rule__Parameter__Group_4_2__1__Impl )
            // InternalBot.g:3833:2: rule__Parameter__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__1__Impl();

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
    // InternalBot.g:3839:1: rule__Parameter__Group_4_2__1__Impl : ( ( ( rule__Parameter__PromptsAssignment_4_2_1 ) ) ( ( rule__Parameter__PromptsAssignment_4_2_1 )* ) ) ;
    public final void rule__Parameter__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3843:1: ( ( ( ( rule__Parameter__PromptsAssignment_4_2_1 ) ) ( ( rule__Parameter__PromptsAssignment_4_2_1 )* ) ) )
            // InternalBot.g:3844:1: ( ( ( rule__Parameter__PromptsAssignment_4_2_1 ) ) ( ( rule__Parameter__PromptsAssignment_4_2_1 )* ) )
            {
            // InternalBot.g:3844:1: ( ( ( rule__Parameter__PromptsAssignment_4_2_1 ) ) ( ( rule__Parameter__PromptsAssignment_4_2_1 )* ) )
            // InternalBot.g:3845:2: ( ( rule__Parameter__PromptsAssignment_4_2_1 ) ) ( ( rule__Parameter__PromptsAssignment_4_2_1 )* )
            {
            // InternalBot.g:3845:2: ( ( rule__Parameter__PromptsAssignment_4_2_1 ) )
            // InternalBot.g:3846:3: ( rule__Parameter__PromptsAssignment_4_2_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_1()); 
            // InternalBot.g:3847:3: ( rule__Parameter__PromptsAssignment_4_2_1 )
            // InternalBot.g:3847:4: rule__Parameter__PromptsAssignment_4_2_1
            {
            pushFollow(FOLLOW_42);
            rule__Parameter__PromptsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_1()); 

            }

            // InternalBot.g:3850:2: ( ( rule__Parameter__PromptsAssignment_4_2_1 )* )
            // InternalBot.g:3851:3: ( rule__Parameter__PromptsAssignment_4_2_1 )*
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_1()); 
            // InternalBot.g:3852:3: ( rule__Parameter__PromptsAssignment_4_2_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==70) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:3852:4: rule__Parameter__PromptsAssignment_4_2_1
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__Parameter__PromptsAssignment_4_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_1()); 

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
    // $ANTLR end "rule__Parameter__Group_4_2__1__Impl"


    // $ANTLR start "rule__Parameter__Group_5__0"
    // InternalBot.g:3862:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3866:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:3867:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalBot.g:3874:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3878:1: ( ( ',' ) )
            // InternalBot.g:3879:1: ( ',' )
            {
            // InternalBot.g:3879:1: ( ',' )
            // InternalBot.g:3880:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_5_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:3889:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3893:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:3894:2: rule__Parameter__Group_5__1__Impl
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
    // InternalBot.g:3900:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__IsListAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3904:1: ( ( ( rule__Parameter__IsListAssignment_5_1 ) ) )
            // InternalBot.g:3905:1: ( ( rule__Parameter__IsListAssignment_5_1 ) )
            {
            // InternalBot.g:3905:1: ( ( rule__Parameter__IsListAssignment_5_1 ) )
            // InternalBot.g:3906:2: ( rule__Parameter__IsListAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_5_1()); 
            // InternalBot.g:3907:2: ( rule__Parameter__IsListAssignment_5_1 )
            // InternalBot.g:3907:3: rule__Parameter__IsListAssignment_5_1
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


    // $ANTLR start "rule__PromptLanguage__Group__0"
    // InternalBot.g:3916:1: rule__PromptLanguage__Group__0 : rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 ;
    public final void rule__PromptLanguage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3920:1: ( rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 )
            // InternalBot.g:3921:2: rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__PromptLanguage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__1();

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
    // $ANTLR end "rule__PromptLanguage__Group__0"


    // $ANTLR start "rule__PromptLanguage__Group__0__Impl"
    // InternalBot.g:3928:1: rule__PromptLanguage__Group__0__Impl : ( 'prompts' ) ;
    public final void rule__PromptLanguage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3932:1: ( ( 'prompts' ) )
            // InternalBot.g:3933:1: ( 'prompts' )
            {
            // InternalBot.g:3933:1: ( 'prompts' )
            // InternalBot.g:3934:2: 'prompts'
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__0__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__1"
    // InternalBot.g:3943:1: rule__PromptLanguage__Group__1 : rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 ;
    public final void rule__PromptLanguage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3947:1: ( rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 )
            // InternalBot.g:3948:2: rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2
            {
            pushFollow(FOLLOW_44);
            rule__PromptLanguage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__2();

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
    // $ANTLR end "rule__PromptLanguage__Group__1"


    // $ANTLR start "rule__PromptLanguage__Group__1__Impl"
    // InternalBot.g:3955:1: rule__PromptLanguage__Group__1__Impl : ( ( rule__PromptLanguage__Group_1__0 )? ) ;
    public final void rule__PromptLanguage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3959:1: ( ( ( rule__PromptLanguage__Group_1__0 )? ) )
            // InternalBot.g:3960:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            {
            // InternalBot.g:3960:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            // InternalBot.g:3961:2: ( rule__PromptLanguage__Group_1__0 )?
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_1()); 
            // InternalBot.g:3962:2: ( rule__PromptLanguage__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==63) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:3962:3: rule__PromptLanguage__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PromptLanguage__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPromptLanguageAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__1__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__2"
    // InternalBot.g:3970:1: rule__PromptLanguage__Group__2 : rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 ;
    public final void rule__PromptLanguage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3974:1: ( rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 )
            // InternalBot.g:3975:2: rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__PromptLanguage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__3();

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
    // $ANTLR end "rule__PromptLanguage__Group__2"


    // $ANTLR start "rule__PromptLanguage__Group__2__Impl"
    // InternalBot.g:3982:1: rule__PromptLanguage__Group__2__Impl : ( '[' ) ;
    public final void rule__PromptLanguage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3986:1: ( ( '[' ) )
            // InternalBot.g:3987:1: ( '[' )
            {
            // InternalBot.g:3987:1: ( '[' )
            // InternalBot.g:3988:2: '['
            {
             before(grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__2__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__3"
    // InternalBot.g:3997:1: rule__PromptLanguage__Group__3 : rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 ;
    public final void rule__PromptLanguage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4001:1: ( rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 )
            // InternalBot.g:4002:2: rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4
            {
            pushFollow(FOLLOW_45);
            rule__PromptLanguage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__4();

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
    // $ANTLR end "rule__PromptLanguage__Group__3"


    // $ANTLR start "rule__PromptLanguage__Group__3__Impl"
    // InternalBot.g:4009:1: rule__PromptLanguage__Group__3__Impl : ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) ;
    public final void rule__PromptLanguage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4013:1: ( ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) )
            // InternalBot.g:4014:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            {
            // InternalBot.g:4014:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            // InternalBot.g:4015:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 
            // InternalBot.g:4016:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            // InternalBot.g:4016:3: rule__PromptLanguage__PromptsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__PromptsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__3__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__4"
    // InternalBot.g:4024:1: rule__PromptLanguage__Group__4 : rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 ;
    public final void rule__PromptLanguage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4028:1: ( rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 )
            // InternalBot.g:4029:2: rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5
            {
            pushFollow(FOLLOW_45);
            rule__PromptLanguage__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__5();

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
    // $ANTLR end "rule__PromptLanguage__Group__4"


    // $ANTLR start "rule__PromptLanguage__Group__4__Impl"
    // InternalBot.g:4036:1: rule__PromptLanguage__Group__4__Impl : ( ( rule__PromptLanguage__Group_4__0 )* ) ;
    public final void rule__PromptLanguage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4040:1: ( ( ( rule__PromptLanguage__Group_4__0 )* ) )
            // InternalBot.g:4041:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            {
            // InternalBot.g:4041:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            // InternalBot.g:4042:2: ( rule__PromptLanguage__Group_4__0 )*
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_4()); 
            // InternalBot.g:4043:2: ( rule__PromptLanguage__Group_4__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==54) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBot.g:4043:3: rule__PromptLanguage__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__PromptLanguage__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getPromptLanguageAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__4__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__5"
    // InternalBot.g:4051:1: rule__PromptLanguage__Group__5 : rule__PromptLanguage__Group__5__Impl ;
    public final void rule__PromptLanguage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4055:1: ( rule__PromptLanguage__Group__5__Impl )
            // InternalBot.g:4056:2: rule__PromptLanguage__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__5__Impl();

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
    // $ANTLR end "rule__PromptLanguage__Group__5"


    // $ANTLR start "rule__PromptLanguage__Group__5__Impl"
    // InternalBot.g:4062:1: rule__PromptLanguage__Group__5__Impl : ( ']' ) ;
    public final void rule__PromptLanguage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4066:1: ( ( ']' ) )
            // InternalBot.g:4067:1: ( ']' )
            {
            // InternalBot.g:4067:1: ( ']' )
            // InternalBot.g:4068:2: ']'
            {
             before(grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__5__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_1__0"
    // InternalBot.g:4078:1: rule__PromptLanguage__Group_1__0 : rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 ;
    public final void rule__PromptLanguage__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4082:1: ( rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 )
            // InternalBot.g:4083:2: rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__PromptLanguage__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_1__1();

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
    // $ANTLR end "rule__PromptLanguage__Group_1__0"


    // $ANTLR start "rule__PromptLanguage__Group_1__0__Impl"
    // InternalBot.g:4090:1: rule__PromptLanguage__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__PromptLanguage__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4094:1: ( ( 'in' ) )
            // InternalBot.g:4095:1: ( 'in' )
            {
            // InternalBot.g:4095:1: ( 'in' )
            // InternalBot.g:4096:2: 'in'
            {
             before(grammarAccess.getPromptLanguageAccess().getInKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getInKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_1__0__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_1__1"
    // InternalBot.g:4105:1: rule__PromptLanguage__Group_1__1 : rule__PromptLanguage__Group_1__1__Impl ;
    public final void rule__PromptLanguage__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4109:1: ( rule__PromptLanguage__Group_1__1__Impl )
            // InternalBot.g:4110:2: rule__PromptLanguage__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_1__1__Impl();

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
    // $ANTLR end "rule__PromptLanguage__Group_1__1"


    // $ANTLR start "rule__PromptLanguage__Group_1__1__Impl"
    // InternalBot.g:4116:1: rule__PromptLanguage__Group_1__1__Impl : ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) ;
    public final void rule__PromptLanguage__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4120:1: ( ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:4121:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:4121:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            // InternalBot.g:4122:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:4123:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            // InternalBot.g:4123:3: rule__PromptLanguage__LanguageAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__LanguageAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_1__1__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_4__0"
    // InternalBot.g:4132:1: rule__PromptLanguage__Group_4__0 : rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 ;
    public final void rule__PromptLanguage__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4136:1: ( rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 )
            // InternalBot.g:4137:2: rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__PromptLanguage__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_4__1();

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
    // $ANTLR end "rule__PromptLanguage__Group_4__0"


    // $ANTLR start "rule__PromptLanguage__Group_4__0__Impl"
    // InternalBot.g:4144:1: rule__PromptLanguage__Group_4__0__Impl : ( ',' ) ;
    public final void rule__PromptLanguage__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4148:1: ( ( ',' ) )
            // InternalBot.g:4149:1: ( ',' )
            {
            // InternalBot.g:4149:1: ( ',' )
            // InternalBot.g:4150:2: ','
            {
             before(grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_4__0__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_4__1"
    // InternalBot.g:4159:1: rule__PromptLanguage__Group_4__1 : rule__PromptLanguage__Group_4__1__Impl ;
    public final void rule__PromptLanguage__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4163:1: ( rule__PromptLanguage__Group_4__1__Impl )
            // InternalBot.g:4164:2: rule__PromptLanguage__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_4__1__Impl();

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
    // $ANTLR end "rule__PromptLanguage__Group_4__1"


    // $ANTLR start "rule__PromptLanguage__Group_4__1__Impl"
    // InternalBot.g:4170:1: rule__PromptLanguage__Group_4__1__Impl : ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) ;
    public final void rule__PromptLanguage__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4174:1: ( ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) )
            // InternalBot.g:4175:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            {
            // InternalBot.g:4175:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            // InternalBot.g:4176:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 
            // InternalBot.g:4177:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            // InternalBot.g:4177:3: rule__PromptLanguage__PromptsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__PromptsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_4__1__Impl"


    // $ANTLR start "rule__EntityToken__Group__0"
    // InternalBot.g:4186:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4190:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:4191:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
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
    // InternalBot.g:4198:1: rule__EntityToken__Group__0__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4202:1: ( ( '@' ) )
            // InternalBot.g:4203:1: ( '@' )
            {
            // InternalBot.g:4203:1: ( '@' )
            // InternalBot.g:4204:2: '@'
            {
             before(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 
            match(input,73,FOLLOW_2); 
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
    // InternalBot.g:4213:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4217:1: ( rule__EntityToken__Group__1__Impl )
            // InternalBot.g:4218:2: rule__EntityToken__Group__1__Impl
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
    // InternalBot.g:4224:1: rule__EntityToken__Group__1__Impl : ( ( rule__EntityToken__EntityAssignment_1 ) ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4228:1: ( ( ( rule__EntityToken__EntityAssignment_1 ) ) )
            // InternalBot.g:4229:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            {
            // InternalBot.g:4229:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            // InternalBot.g:4230:2: ( rule__EntityToken__EntityAssignment_1 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 
            // InternalBot.g:4231:2: ( rule__EntityToken__EntityAssignment_1 )
            // InternalBot.g:4231:3: rule__EntityToken__EntityAssignment_1
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
    // InternalBot.g:4240:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4244:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:4245:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
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
    // InternalBot.g:4252:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4256:1: ( ( '[' ) )
            // InternalBot.g:4257:1: ( '[' )
            {
            // InternalBot.g:4257:1: ( '[' )
            // InternalBot.g:4258:2: '['
            {
             before(grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalBot.g:4267:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4271:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:4272:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
            {
            pushFollow(FOLLOW_46);
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
    // InternalBot.g:4279:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4283:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:4284:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:4284:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:4285:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:4286:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:4286:3: rule__ParameterToken__ParameterAssignment_1
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
    // InternalBot.g:4294:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4298:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:4299:2: rule__ParameterToken__Group__2__Impl
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
    // InternalBot.g:4305:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4309:1: ( ( ']' ) )
            // InternalBot.g:4310:1: ( ']' )
            {
            // InternalBot.g:4310:1: ( ']' )
            // InternalBot.g:4311:2: ']'
            {
             before(grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2()); 
            match(input,72,FOLLOW_2); 
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
    // InternalBot.g:4321:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4325:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:4326:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
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
    // InternalBot.g:4333:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4337:1: ( ( '(' ) )
            // InternalBot.g:4338:1: ( '(' )
            {
            // InternalBot.g:4338:1: ( '(' )
            // InternalBot.g:4339:2: '('
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalBot.g:4348:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4352:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:4353:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
            {
            pushFollow(FOLLOW_47);
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
    // InternalBot.g:4360:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4364:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:4365:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:4365:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:4366:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:4367:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:4367:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
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
    // InternalBot.g:4375:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4379:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:4380:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:4387:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4391:1: ( ( ')' ) )
            // InternalBot.g:4392:1: ( ')' )
            {
            // InternalBot.g:4392:1: ( ')' )
            // InternalBot.g:4393:2: ')'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBot.g:4402:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4406:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:4407:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
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
    // InternalBot.g:4414:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4418:1: ( ( '[' ) )
            // InternalBot.g:4419:1: ( '[' )
            {
            // InternalBot.g:4419:1: ( '[' )
            // InternalBot.g:4420:2: '['
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3()); 
            match(input,71,FOLLOW_2); 
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
    // InternalBot.g:4429:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4433:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:4434:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
            {
            pushFollow(FOLLOW_46);
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
    // InternalBot.g:4441:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4445:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:4446:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:4446:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:4447:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:4448:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:4448:3: rule__ParameterRefenceToken__ParameterAssignment_4
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
    // InternalBot.g:4456:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4460:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:4461:2: rule__ParameterRefenceToken__Group__5__Impl
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
    // InternalBot.g:4467:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4471:1: ( ( ']' ) )
            // InternalBot.g:4472:1: ( ']' )
            {
            // InternalBot.g:4472:1: ( ']' )
            // InternalBot.g:4473:2: ']'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5()); 
            match(input,72,FOLLOW_2); 
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
    // InternalBot.g:4483:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4487:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:4488:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalBot.g:4495:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4499:1: ( ( 'request.' ) )
            // InternalBot.g:4500:1: ( 'request.' )
            {
            // InternalBot.g:4500:1: ( 'request.' )
            // InternalBot.g:4501:2: 'request.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalBot.g:4510:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4514:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:4515:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
            {
            pushFollow(FOLLOW_50);
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
    // InternalBot.g:4522:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4526:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4527:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4527:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4528:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4529:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4529:3: rule__HTTPRequestToken__TypeAssignment_1
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
    // InternalBot.g:4537:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4541:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:4542:2: rule__HTTPRequestToken__Group__2__Impl
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
    // InternalBot.g:4548:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4552:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:4553:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:4553:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:4554:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:4555:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==75) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:4555:3: rule__HTTPRequestToken__Group_2__0
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
    // InternalBot.g:4564:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4568:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:4569:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
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
    // InternalBot.g:4576:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4580:1: ( ( '.' ) )
            // InternalBot.g:4581:1: ( '.' )
            {
            // InternalBot.g:4581:1: ( '.' )
            // InternalBot.g:4582:2: '.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalBot.g:4591:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4595:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:4596:2: rule__HTTPRequestToken__Group_2__1__Impl
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
    // InternalBot.g:4602:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4606:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:4607:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:4607:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:4608:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:4609:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:4609:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
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
    // InternalBot.g:4618:1: rule__Simple__Group__0 : rule__Simple__Group__0__Impl rule__Simple__Group__1 ;
    public final void rule__Simple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4622:1: ( rule__Simple__Group__0__Impl rule__Simple__Group__1 )
            // InternalBot.g:4623:2: rule__Simple__Group__0__Impl rule__Simple__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalBot.g:4630:1: rule__Simple__Group__0__Impl : ( () ) ;
    public final void rule__Simple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4634:1: ( ( () ) )
            // InternalBot.g:4635:1: ( () )
            {
            // InternalBot.g:4635:1: ( () )
            // InternalBot.g:4636:2: ()
            {
             before(grammarAccess.getSimpleAccess().getSimpleAction_0()); 
            // InternalBot.g:4637:2: ()
            // InternalBot.g:4637:3: 
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
    // InternalBot.g:4645:1: rule__Simple__Group__1 : rule__Simple__Group__1__Impl rule__Simple__Group__2 ;
    public final void rule__Simple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4649:1: ( rule__Simple__Group__1__Impl rule__Simple__Group__2 )
            // InternalBot.g:4650:2: rule__Simple__Group__1__Impl rule__Simple__Group__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalBot.g:4657:1: rule__Simple__Group__1__Impl : ( 'Simple' ) ;
    public final void rule__Simple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4661:1: ( ( 'Simple' ) )
            // InternalBot.g:4662:1: ( 'Simple' )
            {
            // InternalBot.g:4662:1: ( 'Simple' )
            // InternalBot.g:4663:2: 'Simple'
            {
             before(grammarAccess.getSimpleAccess().getSimpleKeyword_1()); 
            match(input,76,FOLLOW_2); 
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
    // InternalBot.g:4672:1: rule__Simple__Group__2 : rule__Simple__Group__2__Impl rule__Simple__Group__3 ;
    public final void rule__Simple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4676:1: ( rule__Simple__Group__2__Impl rule__Simple__Group__3 )
            // InternalBot.g:4677:2: rule__Simple__Group__2__Impl rule__Simple__Group__3
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
    // InternalBot.g:4684:1: rule__Simple__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Simple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4688:1: ( ( 'entity' ) )
            // InternalBot.g:4689:1: ( 'entity' )
            {
            // InternalBot.g:4689:1: ( 'entity' )
            // InternalBot.g:4690:2: 'entity'
            {
             before(grammarAccess.getSimpleAccess().getEntityKeyword_2()); 
            match(input,69,FOLLOW_2); 
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
    // InternalBot.g:4699:1: rule__Simple__Group__3 : rule__Simple__Group__3__Impl rule__Simple__Group__4 ;
    public final void rule__Simple__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4703:1: ( rule__Simple__Group__3__Impl rule__Simple__Group__4 )
            // InternalBot.g:4704:2: rule__Simple__Group__3__Impl rule__Simple__Group__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:4711:1: rule__Simple__Group__3__Impl : ( ( rule__Simple__NameAssignment_3 ) ) ;
    public final void rule__Simple__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4715:1: ( ( ( rule__Simple__NameAssignment_3 ) ) )
            // InternalBot.g:4716:1: ( ( rule__Simple__NameAssignment_3 ) )
            {
            // InternalBot.g:4716:1: ( ( rule__Simple__NameAssignment_3 ) )
            // InternalBot.g:4717:2: ( rule__Simple__NameAssignment_3 )
            {
             before(grammarAccess.getSimpleAccess().getNameAssignment_3()); 
            // InternalBot.g:4718:2: ( rule__Simple__NameAssignment_3 )
            // InternalBot.g:4718:3: rule__Simple__NameAssignment_3
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
    // InternalBot.g:4726:1: rule__Simple__Group__4 : rule__Simple__Group__4__Impl rule__Simple__Group__5 ;
    public final void rule__Simple__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4730:1: ( rule__Simple__Group__4__Impl rule__Simple__Group__5 )
            // InternalBot.g:4731:2: rule__Simple__Group__4__Impl rule__Simple__Group__5
            {
            pushFollow(FOLLOW_52);
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
    // InternalBot.g:4738:1: rule__Simple__Group__4__Impl : ( ':' ) ;
    public final void rule__Simple__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4742:1: ( ( ':' ) )
            // InternalBot.g:4743:1: ( ':' )
            {
            // InternalBot.g:4743:1: ( ':' )
            // InternalBot.g:4744:2: ':'
            {
             before(grammarAccess.getSimpleAccess().getColonKeyword_4()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:4753:1: rule__Simple__Group__5 : rule__Simple__Group__5__Impl ;
    public final void rule__Simple__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4757:1: ( rule__Simple__Group__5__Impl )
            // InternalBot.g:4758:2: rule__Simple__Group__5__Impl
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
    // InternalBot.g:4764:1: rule__Simple__Group__5__Impl : ( ( ( rule__Simple__InputsAssignment_5 ) ) ( ( rule__Simple__InputsAssignment_5 )* ) ) ;
    public final void rule__Simple__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4768:1: ( ( ( ( rule__Simple__InputsAssignment_5 ) ) ( ( rule__Simple__InputsAssignment_5 )* ) ) )
            // InternalBot.g:4769:1: ( ( ( rule__Simple__InputsAssignment_5 ) ) ( ( rule__Simple__InputsAssignment_5 )* ) )
            {
            // InternalBot.g:4769:1: ( ( ( rule__Simple__InputsAssignment_5 ) ) ( ( rule__Simple__InputsAssignment_5 )* ) )
            // InternalBot.g:4770:2: ( ( rule__Simple__InputsAssignment_5 ) ) ( ( rule__Simple__InputsAssignment_5 )* )
            {
            // InternalBot.g:4770:2: ( ( rule__Simple__InputsAssignment_5 ) )
            // InternalBot.g:4771:3: ( rule__Simple__InputsAssignment_5 )
            {
             before(grammarAccess.getSimpleAccess().getInputsAssignment_5()); 
            // InternalBot.g:4772:3: ( rule__Simple__InputsAssignment_5 )
            // InternalBot.g:4772:4: rule__Simple__InputsAssignment_5
            {
            pushFollow(FOLLOW_53);
            rule__Simple__InputsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAccess().getInputsAssignment_5()); 

            }

            // InternalBot.g:4775:2: ( ( rule__Simple__InputsAssignment_5 )* )
            // InternalBot.g:4776:3: ( rule__Simple__InputsAssignment_5 )*
            {
             before(grammarAccess.getSimpleAccess().getInputsAssignment_5()); 
            // InternalBot.g:4777:3: ( rule__Simple__InputsAssignment_5 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=60 && LA44_0<=61)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:4777:4: rule__Simple__InputsAssignment_5
            	    {
            	    pushFollow(FOLLOW_53);
            	    rule__Simple__InputsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getSimpleAccess().getInputsAssignment_5()); 

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
    // $ANTLR end "rule__Simple__Group__5__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group__0"
    // InternalBot.g:4787:1: rule__SimpleLanguageInput__Group__0 : rule__SimpleLanguageInput__Group__0__Impl rule__SimpleLanguageInput__Group__1 ;
    public final void rule__SimpleLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4791:1: ( rule__SimpleLanguageInput__Group__0__Impl rule__SimpleLanguageInput__Group__1 )
            // InternalBot.g:4792:2: rule__SimpleLanguageInput__Group__0__Impl rule__SimpleLanguageInput__Group__1
            {
            pushFollow(FOLLOW_52);
            rule__SimpleLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group__1();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group__0"


    // $ANTLR start "rule__SimpleLanguageInput__Group__0__Impl"
    // InternalBot.g:4799:1: rule__SimpleLanguageInput__Group__0__Impl : ( ( rule__SimpleLanguageInput__Group_0__0 )? ) ;
    public final void rule__SimpleLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4803:1: ( ( ( rule__SimpleLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:4804:1: ( ( rule__SimpleLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:4804:1: ( ( rule__SimpleLanguageInput__Group_0__0 )? )
            // InternalBot.g:4805:2: ( rule__SimpleLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:4806:2: ( rule__SimpleLanguageInput__Group_0__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==60) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBot.g:4806:3: rule__SimpleLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group__1"
    // InternalBot.g:4814:1: rule__SimpleLanguageInput__Group__1 : rule__SimpleLanguageInput__Group__1__Impl rule__SimpleLanguageInput__Group__2 ;
    public final void rule__SimpleLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4818:1: ( rule__SimpleLanguageInput__Group__1__Impl rule__SimpleLanguageInput__Group__2 )
            // InternalBot.g:4819:2: rule__SimpleLanguageInput__Group__1__Impl rule__SimpleLanguageInput__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__SimpleLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group__2();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group__1"


    // $ANTLR start "rule__SimpleLanguageInput__Group__1__Impl"
    // InternalBot.g:4826:1: rule__SimpleLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__SimpleLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4830:1: ( ( '{' ) )
            // InternalBot.g:4831:1: ( '{' )
            {
            // InternalBot.g:4831:1: ( '{' )
            // InternalBot.g:4832:2: '{'
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getSimpleLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group__2"
    // InternalBot.g:4841:1: rule__SimpleLanguageInput__Group__2 : rule__SimpleLanguageInput__Group__2__Impl rule__SimpleLanguageInput__Group__3 ;
    public final void rule__SimpleLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4845:1: ( rule__SimpleLanguageInput__Group__2__Impl rule__SimpleLanguageInput__Group__3 )
            // InternalBot.g:4846:2: rule__SimpleLanguageInput__Group__2__Impl rule__SimpleLanguageInput__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__SimpleLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group__3();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group__2"


    // $ANTLR start "rule__SimpleLanguageInput__Group__2__Impl"
    // InternalBot.g:4853:1: rule__SimpleLanguageInput__Group__2__Impl : ( ( rule__SimpleLanguageInput__Group_2__0 ) ) ;
    public final void rule__SimpleLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4857:1: ( ( ( rule__SimpleLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:4858:1: ( ( rule__SimpleLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:4858:1: ( ( rule__SimpleLanguageInput__Group_2__0 ) )
            // InternalBot.g:4859:2: ( rule__SimpleLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:4860:2: ( rule__SimpleLanguageInput__Group_2__0 )
            // InternalBot.g:4860:3: rule__SimpleLanguageInput__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleLanguageInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group__3"
    // InternalBot.g:4868:1: rule__SimpleLanguageInput__Group__3 : rule__SimpleLanguageInput__Group__3__Impl ;
    public final void rule__SimpleLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4872:1: ( rule__SimpleLanguageInput__Group__3__Impl )
            // InternalBot.g:4873:2: rule__SimpleLanguageInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group__3__Impl();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group__3"


    // $ANTLR start "rule__SimpleLanguageInput__Group__3__Impl"
    // InternalBot.g:4879:1: rule__SimpleLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__SimpleLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4883:1: ( ( '}' ) )
            // InternalBot.g:4884:1: ( '}' )
            {
            // InternalBot.g:4884:1: ( '}' )
            // InternalBot.g:4885:2: '}'
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getSimpleLanguageInputAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group_0__0"
    // InternalBot.g:4895:1: rule__SimpleLanguageInput__Group_0__0 : rule__SimpleLanguageInput__Group_0__0__Impl rule__SimpleLanguageInput__Group_0__1 ;
    public final void rule__SimpleLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4899:1: ( rule__SimpleLanguageInput__Group_0__0__Impl rule__SimpleLanguageInput__Group_0__1 )
            // InternalBot.g:4900:2: rule__SimpleLanguageInput__Group_0__0__Impl rule__SimpleLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_54);
            rule__SimpleLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group_0__1();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group_0__0"


    // $ANTLR start "rule__SimpleLanguageInput__Group_0__0__Impl"
    // InternalBot.g:4907:1: rule__SimpleLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__SimpleLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4911:1: ( ( 'inputs' ) )
            // InternalBot.g:4912:1: ( 'inputs' )
            {
            // InternalBot.g:4912:1: ( 'inputs' )
            // InternalBot.g:4913:2: 'inputs'
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getSimpleLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group_0__1"
    // InternalBot.g:4922:1: rule__SimpleLanguageInput__Group_0__1 : rule__SimpleLanguageInput__Group_0__1__Impl rule__SimpleLanguageInput__Group_0__2 ;
    public final void rule__SimpleLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4926:1: ( rule__SimpleLanguageInput__Group_0__1__Impl rule__SimpleLanguageInput__Group_0__2 )
            // InternalBot.g:4927:2: rule__SimpleLanguageInput__Group_0__1__Impl rule__SimpleLanguageInput__Group_0__2
            {
            pushFollow(FOLLOW_7);
            rule__SimpleLanguageInput__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group_0__2();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group_0__1"


    // $ANTLR start "rule__SimpleLanguageInput__Group_0__1__Impl"
    // InternalBot.g:4934:1: rule__SimpleLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__SimpleLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4938:1: ( ( 'in' ) )
            // InternalBot.g:4939:1: ( 'in' )
            {
            // InternalBot.g:4939:1: ( 'in' )
            // InternalBot.g:4940:2: 'in'
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getInKeyword_0_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getSimpleLanguageInputAccess().getInKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group_0__2"
    // InternalBot.g:4949:1: rule__SimpleLanguageInput__Group_0__2 : rule__SimpleLanguageInput__Group_0__2__Impl ;
    public final void rule__SimpleLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4953:1: ( rule__SimpleLanguageInput__Group_0__2__Impl )
            // InternalBot.g:4954:2: rule__SimpleLanguageInput__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group_0__2__Impl();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group_0__2"


    // $ANTLR start "rule__SimpleLanguageInput__Group_0__2__Impl"
    // InternalBot.g:4960:1: rule__SimpleLanguageInput__Group_0__2__Impl : ( ( rule__SimpleLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__SimpleLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4964:1: ( ( ( rule__SimpleLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:4965:1: ( ( rule__SimpleLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:4965:1: ( ( rule__SimpleLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:4966:2: ( rule__SimpleLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:4967:2: ( rule__SimpleLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:4967:3: rule__SimpleLanguageInput__LanguageAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__LanguageAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleLanguageInputAccess().getLanguageAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group_0__2__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group_2__0"
    // InternalBot.g:4976:1: rule__SimpleLanguageInput__Group_2__0 : rule__SimpleLanguageInput__Group_2__0__Impl rule__SimpleLanguageInput__Group_2__1 ;
    public final void rule__SimpleLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4980:1: ( rule__SimpleLanguageInput__Group_2__0__Impl rule__SimpleLanguageInput__Group_2__1 )
            // InternalBot.g:4981:2: rule__SimpleLanguageInput__Group_2__0__Impl rule__SimpleLanguageInput__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleLanguageInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group_2__1();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group_2__0"


    // $ANTLR start "rule__SimpleLanguageInput__Group_2__0__Impl"
    // InternalBot.g:4988:1: rule__SimpleLanguageInput__Group_2__0__Impl : ( ( rule__SimpleLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__SimpleLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4992:1: ( ( ( rule__SimpleLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:4993:1: ( ( rule__SimpleLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:4993:1: ( ( rule__SimpleLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:4994:2: ( rule__SimpleLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:4995:2: ( rule__SimpleLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:4995:3: rule__SimpleLanguageInput__InputsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__InputsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleLanguageInputAccess().getInputsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group_2__0__Impl"


    // $ANTLR start "rule__SimpleLanguageInput__Group_2__1"
    // InternalBot.g:5003:1: rule__SimpleLanguageInput__Group_2__1 : rule__SimpleLanguageInput__Group_2__1__Impl ;
    public final void rule__SimpleLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5007:1: ( rule__SimpleLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5008:2: rule__SimpleLanguageInput__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleLanguageInput__Group_2__1__Impl();

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
    // $ANTLR end "rule__SimpleLanguageInput__Group_2__1"


    // $ANTLR start "rule__SimpleLanguageInput__Group_2__1__Impl"
    // InternalBot.g:5014:1: rule__SimpleLanguageInput__Group_2__1__Impl : ( ( rule__SimpleLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__SimpleLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5018:1: ( ( ( rule__SimpleLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5019:1: ( ( rule__SimpleLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5019:1: ( ( rule__SimpleLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5020:2: ( rule__SimpleLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5021:2: ( rule__SimpleLanguageInput__InputsAssignment_2_1 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:5021:3: rule__SimpleLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__SimpleLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getSimpleLanguageInputAccess().getInputsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__Group_2__1__Impl"


    // $ANTLR start "rule__Composite__Group__0"
    // InternalBot.g:5030:1: rule__Composite__Group__0 : rule__Composite__Group__0__Impl rule__Composite__Group__1 ;
    public final void rule__Composite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5034:1: ( rule__Composite__Group__0__Impl rule__Composite__Group__1 )
            // InternalBot.g:5035:2: rule__Composite__Group__0__Impl rule__Composite__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalBot.g:5042:1: rule__Composite__Group__0__Impl : ( () ) ;
    public final void rule__Composite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5046:1: ( ( () ) )
            // InternalBot.g:5047:1: ( () )
            {
            // InternalBot.g:5047:1: ( () )
            // InternalBot.g:5048:2: ()
            {
             before(grammarAccess.getCompositeAccess().getCompositeAction_0()); 
            // InternalBot.g:5049:2: ()
            // InternalBot.g:5049:3: 
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
    // InternalBot.g:5057:1: rule__Composite__Group__1 : rule__Composite__Group__1__Impl rule__Composite__Group__2 ;
    public final void rule__Composite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5061:1: ( rule__Composite__Group__1__Impl rule__Composite__Group__2 )
            // InternalBot.g:5062:2: rule__Composite__Group__1__Impl rule__Composite__Group__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalBot.g:5069:1: rule__Composite__Group__1__Impl : ( 'Composite' ) ;
    public final void rule__Composite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5073:1: ( ( 'Composite' ) )
            // InternalBot.g:5074:1: ( 'Composite' )
            {
            // InternalBot.g:5074:1: ( 'Composite' )
            // InternalBot.g:5075:2: 'Composite'
            {
             before(grammarAccess.getCompositeAccess().getCompositeKeyword_1()); 
            match(input,77,FOLLOW_2); 
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
    // InternalBot.g:5084:1: rule__Composite__Group__2 : rule__Composite__Group__2__Impl rule__Composite__Group__3 ;
    public final void rule__Composite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5088:1: ( rule__Composite__Group__2__Impl rule__Composite__Group__3 )
            // InternalBot.g:5089:2: rule__Composite__Group__2__Impl rule__Composite__Group__3
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
    // InternalBot.g:5096:1: rule__Composite__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Composite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5100:1: ( ( 'entity' ) )
            // InternalBot.g:5101:1: ( 'entity' )
            {
            // InternalBot.g:5101:1: ( 'entity' )
            // InternalBot.g:5102:2: 'entity'
            {
             before(grammarAccess.getCompositeAccess().getEntityKeyword_2()); 
            match(input,69,FOLLOW_2); 
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
    // InternalBot.g:5111:1: rule__Composite__Group__3 : rule__Composite__Group__3__Impl rule__Composite__Group__4 ;
    public final void rule__Composite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5115:1: ( rule__Composite__Group__3__Impl rule__Composite__Group__4 )
            // InternalBot.g:5116:2: rule__Composite__Group__3__Impl rule__Composite__Group__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:5123:1: rule__Composite__Group__3__Impl : ( ( rule__Composite__NameAssignment_3 ) ) ;
    public final void rule__Composite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5127:1: ( ( ( rule__Composite__NameAssignment_3 ) ) )
            // InternalBot.g:5128:1: ( ( rule__Composite__NameAssignment_3 ) )
            {
            // InternalBot.g:5128:1: ( ( rule__Composite__NameAssignment_3 ) )
            // InternalBot.g:5129:2: ( rule__Composite__NameAssignment_3 )
            {
             before(grammarAccess.getCompositeAccess().getNameAssignment_3()); 
            // InternalBot.g:5130:2: ( rule__Composite__NameAssignment_3 )
            // InternalBot.g:5130:3: rule__Composite__NameAssignment_3
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
    // InternalBot.g:5138:1: rule__Composite__Group__4 : rule__Composite__Group__4__Impl rule__Composite__Group__5 ;
    public final void rule__Composite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5142:1: ( rule__Composite__Group__4__Impl rule__Composite__Group__5 )
            // InternalBot.g:5143:2: rule__Composite__Group__4__Impl rule__Composite__Group__5
            {
            pushFollow(FOLLOW_52);
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
    // InternalBot.g:5150:1: rule__Composite__Group__4__Impl : ( ':' ) ;
    public final void rule__Composite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5154:1: ( ( ':' ) )
            // InternalBot.g:5155:1: ( ':' )
            {
            // InternalBot.g:5155:1: ( ':' )
            // InternalBot.g:5156:2: ':'
            {
             before(grammarAccess.getCompositeAccess().getColonKeyword_4()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:5165:1: rule__Composite__Group__5 : rule__Composite__Group__5__Impl ;
    public final void rule__Composite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5169:1: ( rule__Composite__Group__5__Impl )
            // InternalBot.g:5170:2: rule__Composite__Group__5__Impl
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
    // InternalBot.g:5176:1: rule__Composite__Group__5__Impl : ( ( ( rule__Composite__InputsAssignment_5 ) ) ( ( rule__Composite__InputsAssignment_5 )* ) ) ;
    public final void rule__Composite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5180:1: ( ( ( ( rule__Composite__InputsAssignment_5 ) ) ( ( rule__Composite__InputsAssignment_5 )* ) ) )
            // InternalBot.g:5181:1: ( ( ( rule__Composite__InputsAssignment_5 ) ) ( ( rule__Composite__InputsAssignment_5 )* ) )
            {
            // InternalBot.g:5181:1: ( ( ( rule__Composite__InputsAssignment_5 ) ) ( ( rule__Composite__InputsAssignment_5 )* ) )
            // InternalBot.g:5182:2: ( ( rule__Composite__InputsAssignment_5 ) ) ( ( rule__Composite__InputsAssignment_5 )* )
            {
            // InternalBot.g:5182:2: ( ( rule__Composite__InputsAssignment_5 ) )
            // InternalBot.g:5183:3: ( rule__Composite__InputsAssignment_5 )
            {
             before(grammarAccess.getCompositeAccess().getInputsAssignment_5()); 
            // InternalBot.g:5184:3: ( rule__Composite__InputsAssignment_5 )
            // InternalBot.g:5184:4: rule__Composite__InputsAssignment_5
            {
            pushFollow(FOLLOW_53);
            rule__Composite__InputsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCompositeAccess().getInputsAssignment_5()); 

            }

            // InternalBot.g:5187:2: ( ( rule__Composite__InputsAssignment_5 )* )
            // InternalBot.g:5188:3: ( rule__Composite__InputsAssignment_5 )*
            {
             before(grammarAccess.getCompositeAccess().getInputsAssignment_5()); 
            // InternalBot.g:5189:3: ( rule__Composite__InputsAssignment_5 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=60 && LA47_0<=61)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBot.g:5189:4: rule__Composite__InputsAssignment_5
            	    {
            	    pushFollow(FOLLOW_53);
            	    rule__Composite__InputsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getCompositeAccess().getInputsAssignment_5()); 

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
    // $ANTLR end "rule__Composite__Group__5__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group__0"
    // InternalBot.g:5199:1: rule__CompositeLanguageInput__Group__0 : rule__CompositeLanguageInput__Group__0__Impl rule__CompositeLanguageInput__Group__1 ;
    public final void rule__CompositeLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5203:1: ( rule__CompositeLanguageInput__Group__0__Impl rule__CompositeLanguageInput__Group__1 )
            // InternalBot.g:5204:2: rule__CompositeLanguageInput__Group__0__Impl rule__CompositeLanguageInput__Group__1
            {
            pushFollow(FOLLOW_52);
            rule__CompositeLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group__1();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group__0"


    // $ANTLR start "rule__CompositeLanguageInput__Group__0__Impl"
    // InternalBot.g:5211:1: rule__CompositeLanguageInput__Group__0__Impl : ( () ) ;
    public final void rule__CompositeLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5215:1: ( ( () ) )
            // InternalBot.g:5216:1: ( () )
            {
            // InternalBot.g:5216:1: ( () )
            // InternalBot.g:5217:2: ()
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getCompositeLanguageInputAction_0()); 
            // InternalBot.g:5218:2: ()
            // InternalBot.g:5218:3: 
            {
            }

             after(grammarAccess.getCompositeLanguageInputAccess().getCompositeLanguageInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group__1"
    // InternalBot.g:5226:1: rule__CompositeLanguageInput__Group__1 : rule__CompositeLanguageInput__Group__1__Impl rule__CompositeLanguageInput__Group__2 ;
    public final void rule__CompositeLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5230:1: ( rule__CompositeLanguageInput__Group__1__Impl rule__CompositeLanguageInput__Group__2 )
            // InternalBot.g:5231:2: rule__CompositeLanguageInput__Group__1__Impl rule__CompositeLanguageInput__Group__2
            {
            pushFollow(FOLLOW_52);
            rule__CompositeLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group__2();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group__1"


    // $ANTLR start "rule__CompositeLanguageInput__Group__1__Impl"
    // InternalBot.g:5238:1: rule__CompositeLanguageInput__Group__1__Impl : ( ( rule__CompositeLanguageInput__Group_1__0 )? ) ;
    public final void rule__CompositeLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5242:1: ( ( ( rule__CompositeLanguageInput__Group_1__0 )? ) )
            // InternalBot.g:5243:1: ( ( rule__CompositeLanguageInput__Group_1__0 )? )
            {
            // InternalBot.g:5243:1: ( ( rule__CompositeLanguageInput__Group_1__0 )? )
            // InternalBot.g:5244:2: ( rule__CompositeLanguageInput__Group_1__0 )?
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getGroup_1()); 
            // InternalBot.g:5245:2: ( rule__CompositeLanguageInput__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==60) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBot.g:5245:3: rule__CompositeLanguageInput__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CompositeLanguageInput__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompositeLanguageInputAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group__2"
    // InternalBot.g:5253:1: rule__CompositeLanguageInput__Group__2 : rule__CompositeLanguageInput__Group__2__Impl rule__CompositeLanguageInput__Group__3 ;
    public final void rule__CompositeLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5257:1: ( rule__CompositeLanguageInput__Group__2__Impl rule__CompositeLanguageInput__Group__3 )
            // InternalBot.g:5258:2: rule__CompositeLanguageInput__Group__2__Impl rule__CompositeLanguageInput__Group__3
            {
            pushFollow(FOLLOW_55);
            rule__CompositeLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group__3();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group__2"


    // $ANTLR start "rule__CompositeLanguageInput__Group__2__Impl"
    // InternalBot.g:5265:1: rule__CompositeLanguageInput__Group__2__Impl : ( '{' ) ;
    public final void rule__CompositeLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5269:1: ( ( '{' ) )
            // InternalBot.g:5270:1: ( '{' )
            {
            // InternalBot.g:5270:1: ( '{' )
            // InternalBot.g:5271:2: '{'
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getCompositeLanguageInputAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group__3"
    // InternalBot.g:5280:1: rule__CompositeLanguageInput__Group__3 : rule__CompositeLanguageInput__Group__3__Impl rule__CompositeLanguageInput__Group__4 ;
    public final void rule__CompositeLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5284:1: ( rule__CompositeLanguageInput__Group__3__Impl rule__CompositeLanguageInput__Group__4 )
            // InternalBot.g:5285:2: rule__CompositeLanguageInput__Group__3__Impl rule__CompositeLanguageInput__Group__4
            {
            pushFollow(FOLLOW_55);
            rule__CompositeLanguageInput__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group__4();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group__3"


    // $ANTLR start "rule__CompositeLanguageInput__Group__3__Impl"
    // InternalBot.g:5292:1: rule__CompositeLanguageInput__Group__3__Impl : ( ( rule__CompositeLanguageInput__Group_3__0 )? ) ;
    public final void rule__CompositeLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5296:1: ( ( ( rule__CompositeLanguageInput__Group_3__0 )? ) )
            // InternalBot.g:5297:1: ( ( rule__CompositeLanguageInput__Group_3__0 )? )
            {
            // InternalBot.g:5297:1: ( ( rule__CompositeLanguageInput__Group_3__0 )? )
            // InternalBot.g:5298:2: ( rule__CompositeLanguageInput__Group_3__0 )?
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getGroup_3()); 
            // InternalBot.g:5299:2: ( rule__CompositeLanguageInput__Group_3__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||LA49_0==73) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:5299:3: rule__CompositeLanguageInput__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CompositeLanguageInput__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompositeLanguageInputAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group__4"
    // InternalBot.g:5307:1: rule__CompositeLanguageInput__Group__4 : rule__CompositeLanguageInput__Group__4__Impl ;
    public final void rule__CompositeLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5311:1: ( rule__CompositeLanguageInput__Group__4__Impl )
            // InternalBot.g:5312:2: rule__CompositeLanguageInput__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group__4__Impl();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group__4"


    // $ANTLR start "rule__CompositeLanguageInput__Group__4__Impl"
    // InternalBot.g:5318:1: rule__CompositeLanguageInput__Group__4__Impl : ( '}' ) ;
    public final void rule__CompositeLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5322:1: ( ( '}' ) )
            // InternalBot.g:5323:1: ( '}' )
            {
            // InternalBot.g:5323:1: ( '}' )
            // InternalBot.g:5324:2: '}'
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getRightCurlyBracketKeyword_4()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getCompositeLanguageInputAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group__4__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group_1__0"
    // InternalBot.g:5334:1: rule__CompositeLanguageInput__Group_1__0 : rule__CompositeLanguageInput__Group_1__0__Impl rule__CompositeLanguageInput__Group_1__1 ;
    public final void rule__CompositeLanguageInput__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5338:1: ( rule__CompositeLanguageInput__Group_1__0__Impl rule__CompositeLanguageInput__Group_1__1 )
            // InternalBot.g:5339:2: rule__CompositeLanguageInput__Group_1__0__Impl rule__CompositeLanguageInput__Group_1__1
            {
            pushFollow(FOLLOW_54);
            rule__CompositeLanguageInput__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group_1__1();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group_1__0"


    // $ANTLR start "rule__CompositeLanguageInput__Group_1__0__Impl"
    // InternalBot.g:5346:1: rule__CompositeLanguageInput__Group_1__0__Impl : ( 'inputs' ) ;
    public final void rule__CompositeLanguageInput__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5350:1: ( ( 'inputs' ) )
            // InternalBot.g:5351:1: ( 'inputs' )
            {
            // InternalBot.g:5351:1: ( 'inputs' )
            // InternalBot.g:5352:2: 'inputs'
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getInputsKeyword_1_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getCompositeLanguageInputAccess().getInputsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group_1__0__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group_1__1"
    // InternalBot.g:5361:1: rule__CompositeLanguageInput__Group_1__1 : rule__CompositeLanguageInput__Group_1__1__Impl rule__CompositeLanguageInput__Group_1__2 ;
    public final void rule__CompositeLanguageInput__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5365:1: ( rule__CompositeLanguageInput__Group_1__1__Impl rule__CompositeLanguageInput__Group_1__2 )
            // InternalBot.g:5366:2: rule__CompositeLanguageInput__Group_1__1__Impl rule__CompositeLanguageInput__Group_1__2
            {
            pushFollow(FOLLOW_7);
            rule__CompositeLanguageInput__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group_1__2();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group_1__1"


    // $ANTLR start "rule__CompositeLanguageInput__Group_1__1__Impl"
    // InternalBot.g:5373:1: rule__CompositeLanguageInput__Group_1__1__Impl : ( 'in' ) ;
    public final void rule__CompositeLanguageInput__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5377:1: ( ( 'in' ) )
            // InternalBot.g:5378:1: ( 'in' )
            {
            // InternalBot.g:5378:1: ( 'in' )
            // InternalBot.g:5379:2: 'in'
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getInKeyword_1_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getCompositeLanguageInputAccess().getInKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group_1__1__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group_1__2"
    // InternalBot.g:5388:1: rule__CompositeLanguageInput__Group_1__2 : rule__CompositeLanguageInput__Group_1__2__Impl ;
    public final void rule__CompositeLanguageInput__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5392:1: ( rule__CompositeLanguageInput__Group_1__2__Impl )
            // InternalBot.g:5393:2: rule__CompositeLanguageInput__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group_1__2__Impl();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group_1__2"


    // $ANTLR start "rule__CompositeLanguageInput__Group_1__2__Impl"
    // InternalBot.g:5399:1: rule__CompositeLanguageInput__Group_1__2__Impl : ( ( rule__CompositeLanguageInput__LanguageAssignment_1_2 ) ) ;
    public final void rule__CompositeLanguageInput__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5403:1: ( ( ( rule__CompositeLanguageInput__LanguageAssignment_1_2 ) ) )
            // InternalBot.g:5404:1: ( ( rule__CompositeLanguageInput__LanguageAssignment_1_2 ) )
            {
            // InternalBot.g:5404:1: ( ( rule__CompositeLanguageInput__LanguageAssignment_1_2 ) )
            // InternalBot.g:5405:2: ( rule__CompositeLanguageInput__LanguageAssignment_1_2 )
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getLanguageAssignment_1_2()); 
            // InternalBot.g:5406:2: ( rule__CompositeLanguageInput__LanguageAssignment_1_2 )
            // InternalBot.g:5406:3: rule__CompositeLanguageInput__LanguageAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__LanguageAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getCompositeLanguageInputAccess().getLanguageAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group_1__2__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group_3__0"
    // InternalBot.g:5415:1: rule__CompositeLanguageInput__Group_3__0 : rule__CompositeLanguageInput__Group_3__0__Impl rule__CompositeLanguageInput__Group_3__1 ;
    public final void rule__CompositeLanguageInput__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5419:1: ( rule__CompositeLanguageInput__Group_3__0__Impl rule__CompositeLanguageInput__Group_3__1 )
            // InternalBot.g:5420:2: rule__CompositeLanguageInput__Group_3__0__Impl rule__CompositeLanguageInput__Group_3__1
            {
            pushFollow(FOLLOW_56);
            rule__CompositeLanguageInput__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group_3__1();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group_3__0"


    // $ANTLR start "rule__CompositeLanguageInput__Group_3__0__Impl"
    // InternalBot.g:5427:1: rule__CompositeLanguageInput__Group_3__0__Impl : ( ( rule__CompositeLanguageInput__InputsAssignment_3_0 ) ) ;
    public final void rule__CompositeLanguageInput__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5431:1: ( ( ( rule__CompositeLanguageInput__InputsAssignment_3_0 ) ) )
            // InternalBot.g:5432:1: ( ( rule__CompositeLanguageInput__InputsAssignment_3_0 ) )
            {
            // InternalBot.g:5432:1: ( ( rule__CompositeLanguageInput__InputsAssignment_3_0 ) )
            // InternalBot.g:5433:2: ( rule__CompositeLanguageInput__InputsAssignment_3_0 )
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getInputsAssignment_3_0()); 
            // InternalBot.g:5434:2: ( rule__CompositeLanguageInput__InputsAssignment_3_0 )
            // InternalBot.g:5434:3: rule__CompositeLanguageInput__InputsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__InputsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeLanguageInputAccess().getInputsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group_3__0__Impl"


    // $ANTLR start "rule__CompositeLanguageInput__Group_3__1"
    // InternalBot.g:5442:1: rule__CompositeLanguageInput__Group_3__1 : rule__CompositeLanguageInput__Group_3__1__Impl ;
    public final void rule__CompositeLanguageInput__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5446:1: ( rule__CompositeLanguageInput__Group_3__1__Impl )
            // InternalBot.g:5447:2: rule__CompositeLanguageInput__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompositeLanguageInput__Group_3__1__Impl();

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
    // $ANTLR end "rule__CompositeLanguageInput__Group_3__1"


    // $ANTLR start "rule__CompositeLanguageInput__Group_3__1__Impl"
    // InternalBot.g:5453:1: rule__CompositeLanguageInput__Group_3__1__Impl : ( ( rule__CompositeLanguageInput__InputsAssignment_3_1 )* ) ;
    public final void rule__CompositeLanguageInput__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5457:1: ( ( ( rule__CompositeLanguageInput__InputsAssignment_3_1 )* ) )
            // InternalBot.g:5458:1: ( ( rule__CompositeLanguageInput__InputsAssignment_3_1 )* )
            {
            // InternalBot.g:5458:1: ( ( rule__CompositeLanguageInput__InputsAssignment_3_1 )* )
            // InternalBot.g:5459:2: ( rule__CompositeLanguageInput__InputsAssignment_3_1 )*
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getInputsAssignment_3_1()); 
            // InternalBot.g:5460:2: ( rule__CompositeLanguageInput__InputsAssignment_3_1 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||LA50_0==73) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:5460:3: rule__CompositeLanguageInput__InputsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_57);
            	    rule__CompositeLanguageInput__InputsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getCompositeLanguageInputAccess().getInputsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__Group_3__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group__0"
    // InternalBot.g:5469:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5473:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:5474:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
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
    // InternalBot.g:5481:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5485:1: ( ( () ) )
            // InternalBot.g:5486:1: ( () )
            {
            // InternalBot.g:5486:1: ( () )
            // InternalBot.g:5487:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:5488:2: ()
            // InternalBot.g:5488:3: 
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
    // InternalBot.g:5496:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5500:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:5501:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
            {
            pushFollow(FOLLOW_58);
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
    // InternalBot.g:5508:1: rule__SimpleInput__Group__1__Impl : ( ( rule__SimpleInput__NameAssignment_1 ) ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5512:1: ( ( ( rule__SimpleInput__NameAssignment_1 ) ) )
            // InternalBot.g:5513:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            {
            // InternalBot.g:5513:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            // InternalBot.g:5514:2: ( rule__SimpleInput__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 
            // InternalBot.g:5515:2: ( rule__SimpleInput__NameAssignment_1 )
            // InternalBot.g:5515:3: rule__SimpleInput__NameAssignment_1
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
    // InternalBot.g:5523:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5527:1: ( rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 )
            // InternalBot.g:5528:2: rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3
            {
            pushFollow(FOLLOW_58);
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
    // InternalBot.g:5535:1: rule__SimpleInput__Group__2__Impl : ( ( rule__SimpleInput__Group_2__0 )? ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5539:1: ( ( ( rule__SimpleInput__Group_2__0 )? ) )
            // InternalBot.g:5540:1: ( ( rule__SimpleInput__Group_2__0 )? )
            {
            // InternalBot.g:5540:1: ( ( rule__SimpleInput__Group_2__0 )? )
            // InternalBot.g:5541:2: ( rule__SimpleInput__Group_2__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2()); 
            // InternalBot.g:5542:2: ( rule__SimpleInput__Group_2__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==78) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:5542:3: rule__SimpleInput__Group_2__0
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
    // InternalBot.g:5550:1: rule__SimpleInput__Group__3 : rule__SimpleInput__Group__3__Impl ;
    public final void rule__SimpleInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5554:1: ( rule__SimpleInput__Group__3__Impl )
            // InternalBot.g:5555:2: rule__SimpleInput__Group__3__Impl
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
    // InternalBot.g:5561:1: rule__SimpleInput__Group__3__Impl : ( ';' ) ;
    public final void rule__SimpleInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5565:1: ( ( ';' ) )
            // InternalBot.g:5566:1: ( ';' )
            {
            // InternalBot.g:5566:1: ( ';' )
            // InternalBot.g:5567:2: ';'
            {
             before(grammarAccess.getSimpleInputAccess().getSemicolonKeyword_3()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:5577:1: rule__SimpleInput__Group_2__0 : rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 ;
    public final void rule__SimpleInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5581:1: ( rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 )
            // InternalBot.g:5582:2: rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1
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
    // InternalBot.g:5589:1: rule__SimpleInput__Group_2__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5593:1: ( ( 'synonyms' ) )
            // InternalBot.g:5594:1: ( 'synonyms' )
            {
            // InternalBot.g:5594:1: ( 'synonyms' )
            // InternalBot.g:5595:2: 'synonyms'
            {
             before(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 
            match(input,78,FOLLOW_2); 
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
    // InternalBot.g:5604:1: rule__SimpleInput__Group_2__1 : rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 ;
    public final void rule__SimpleInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5608:1: ( rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 )
            // InternalBot.g:5609:2: rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalBot.g:5616:1: rule__SimpleInput__Group_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5620:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) )
            // InternalBot.g:5621:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            {
            // InternalBot.g:5621:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            // InternalBot.g:5622:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 
            // InternalBot.g:5623:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            // InternalBot.g:5623:3: rule__SimpleInput__ValuesAssignment_2_1
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
    // InternalBot.g:5631:1: rule__SimpleInput__Group_2__2 : rule__SimpleInput__Group_2__2__Impl ;
    public final void rule__SimpleInput__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5635:1: ( rule__SimpleInput__Group_2__2__Impl )
            // InternalBot.g:5636:2: rule__SimpleInput__Group_2__2__Impl
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
    // InternalBot.g:5642:1: rule__SimpleInput__Group_2__2__Impl : ( ( rule__SimpleInput__Group_2_2__0 )* ) ;
    public final void rule__SimpleInput__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5646:1: ( ( ( rule__SimpleInput__Group_2_2__0 )* ) )
            // InternalBot.g:5647:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            {
            // InternalBot.g:5647:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            // InternalBot.g:5648:2: ( rule__SimpleInput__Group_2_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 
            // InternalBot.g:5649:2: ( rule__SimpleInput__Group_2_2__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==54) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:5649:3: rule__SimpleInput__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__SimpleInput__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalBot.g:5658:1: rule__SimpleInput__Group_2_2__0 : rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 ;
    public final void rule__SimpleInput__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5662:1: ( rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 )
            // InternalBot.g:5663:2: rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1
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
    // InternalBot.g:5670:1: rule__SimpleInput__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5674:1: ( ( ',' ) )
            // InternalBot.g:5675:1: ( ',' )
            {
            // InternalBot.g:5675:1: ( ',' )
            // InternalBot.g:5676:2: ','
            {
             before(grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:5685:1: rule__SimpleInput__Group_2_2__1 : rule__SimpleInput__Group_2_2__1__Impl ;
    public final void rule__SimpleInput__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5689:1: ( rule__SimpleInput__Group_2_2__1__Impl )
            // InternalBot.g:5690:2: rule__SimpleInput__Group_2_2__1__Impl
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
    // InternalBot.g:5696:1: rule__SimpleInput__Group_2_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5700:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) )
            // InternalBot.g:5701:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            {
            // InternalBot.g:5701:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            // InternalBot.g:5702:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 
            // InternalBot.g:5703:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            // InternalBot.g:5703:3: rule__SimpleInput__ValuesAssignment_2_2_1
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
    // InternalBot.g:5712:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5716:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:5717:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:5724:1: rule__CompositeInput__Group__0__Impl : ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5728:1: ( ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) ) )
            // InternalBot.g:5729:1: ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) )
            {
            // InternalBot.g:5729:1: ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) )
            // InternalBot.g:5730:2: ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* )
            {
            // InternalBot.g:5730:2: ( ( rule__CompositeInput__TokensAssignment_0 ) )
            // InternalBot.g:5731:3: ( rule__CompositeInput__TokensAssignment_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 
            // InternalBot.g:5732:3: ( rule__CompositeInput__TokensAssignment_0 )
            // InternalBot.g:5732:4: rule__CompositeInput__TokensAssignment_0
            {
            pushFollow(FOLLOW_57);
            rule__CompositeInput__TokensAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 

            }

            // InternalBot.g:5735:2: ( ( rule__CompositeInput__TokensAssignment_0 )* )
            // InternalBot.g:5736:3: ( rule__CompositeInput__TokensAssignment_0 )*
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 
            // InternalBot.g:5737:3: ( rule__CompositeInput__TokensAssignment_0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=RULE_STRING && LA53_0<=RULE_ID)||LA53_0==73) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBot.g:5737:4: rule__CompositeInput__TokensAssignment_0
            	    {
            	    pushFollow(FOLLOW_57);
            	    rule__CompositeInput__TokensAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
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
    // InternalBot.g:5746:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5750:1: ( rule__CompositeInput__Group__1__Impl )
            // InternalBot.g:5751:2: rule__CompositeInput__Group__1__Impl
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
    // InternalBot.g:5757:1: rule__CompositeInput__Group__1__Impl : ( ';' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5761:1: ( ( ';' ) )
            // InternalBot.g:5762:1: ( ';' )
            {
            // InternalBot.g:5762:1: ( ';' )
            // InternalBot.g:5763:2: ';'
            {
             before(grammarAccess.getCompositeInputAccess().getSemicolonKeyword_1()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:5773:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5777:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:5778:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FOLLOW_59);
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
    // InternalBot.g:5785:1: rule__Text__Group__0__Impl : ( 'text' ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5789:1: ( ( 'text' ) )
            // InternalBot.g:5790:1: ( 'text' )
            {
            // InternalBot.g:5790:1: ( 'text' )
            // InternalBot.g:5791:2: 'text'
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
    // InternalBot.g:5800:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5804:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:5805:2: rule__Text__Group__1__Impl rule__Text__Group__2
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
    // InternalBot.g:5812:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5816:1: ( ( 'response' ) )
            // InternalBot.g:5817:1: ( 'response' )
            {
            // InternalBot.g:5817:1: ( 'response' )
            // InternalBot.g:5818:2: 'response'
            {
             before(grammarAccess.getTextAccess().getResponseKeyword_1()); 
            match(input,79,FOLLOW_2); 
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
    // InternalBot.g:5827:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5831:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:5832:2: rule__Text__Group__2__Impl rule__Text__Group__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:5839:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5843:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:5844:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:5844:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:5845:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:5846:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:5846:3: rule__Text__NameAssignment_2
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
    // InternalBot.g:5854:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5858:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:5859:2: rule__Text__Group__3__Impl rule__Text__Group__4
            {
            pushFollow(FOLLOW_60);
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
    // InternalBot.g:5866:1: rule__Text__Group__3__Impl : ( ':' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5870:1: ( ( ':' ) )
            // InternalBot.g:5871:1: ( ':' )
            {
            // InternalBot.g:5871:1: ( ':' )
            // InternalBot.g:5872:2: ':'
            {
             before(grammarAccess.getTextAccess().getColonKeyword_3()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:5881:1: rule__Text__Group__4 : rule__Text__Group__4__Impl ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5885:1: ( rule__Text__Group__4__Impl )
            // InternalBot.g:5886:2: rule__Text__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__4__Impl();

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
    // InternalBot.g:5892:1: rule__Text__Group__4__Impl : ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5896:1: ( ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5897:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5897:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            // InternalBot.g:5898:2: ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* )
            {
            // InternalBot.g:5898:2: ( ( rule__Text__InputsAssignment_4 ) )
            // InternalBot.g:5899:3: ( rule__Text__InputsAssignment_4 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:5900:3: ( rule__Text__InputsAssignment_4 )
            // InternalBot.g:5900:4: rule__Text__InputsAssignment_4
            {
            pushFollow(FOLLOW_61);
            rule__Text__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5903:2: ( ( rule__Text__InputsAssignment_4 )* )
            // InternalBot.g:5904:3: ( rule__Text__InputsAssignment_4 )*
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:5905:3: ( rule__Text__InputsAssignment_4 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==11) ) {
                    int LA54_2 = input.LA(2);

                    if ( (LA54_2==61||LA54_2==63) ) {
                        alt54=1;
                    }


                }
                else if ( (LA54_0==61) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:5905:4: rule__Text__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_61);
            	    rule__Text__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

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
    // $ANTLR end "rule__Text__Group__4__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__0"
    // InternalBot.g:5915:1: rule__TextLanguageInput__Group__0 : rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 ;
    public final void rule__TextLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5919:1: ( rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 )
            // InternalBot.g:5920:2: rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__TextLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__1();

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
    // $ANTLR end "rule__TextLanguageInput__Group__0"


    // $ANTLR start "rule__TextLanguageInput__Group__0__Impl"
    // InternalBot.g:5927:1: rule__TextLanguageInput__Group__0__Impl : ( ( rule__TextLanguageInput__Group_0__0 )? ) ;
    public final void rule__TextLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5931:1: ( ( ( rule__TextLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5932:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5932:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            // InternalBot.g:5933:2: ( rule__TextLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5934:2: ( rule__TextLanguageInput__Group_0__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==11) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:5934:3: rule__TextLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__1"
    // InternalBot.g:5942:1: rule__TextLanguageInput__Group__1 : rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 ;
    public final void rule__TextLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5946:1: ( rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 )
            // InternalBot.g:5947:2: rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2
            {
            pushFollow(FOLLOW_62);
            rule__TextLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__2();

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
    // $ANTLR end "rule__TextLanguageInput__Group__1"


    // $ANTLR start "rule__TextLanguageInput__Group__1__Impl"
    // InternalBot.g:5954:1: rule__TextLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__TextLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5958:1: ( ( '{' ) )
            // InternalBot.g:5959:1: ( '{' )
            {
            // InternalBot.g:5959:1: ( '{' )
            // InternalBot.g:5960:2: '{'
            {
             before(grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__2"
    // InternalBot.g:5969:1: rule__TextLanguageInput__Group__2 : rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 ;
    public final void rule__TextLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5973:1: ( rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 )
            // InternalBot.g:5974:2: rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__TextLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__3();

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
    // $ANTLR end "rule__TextLanguageInput__Group__2"


    // $ANTLR start "rule__TextLanguageInput__Group__2__Impl"
    // InternalBot.g:5981:1: rule__TextLanguageInput__Group__2__Impl : ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) ;
    public final void rule__TextLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5985:1: ( ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) )
            // InternalBot.g:5986:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            {
            // InternalBot.g:5986:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            // InternalBot.g:5987:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 
            // InternalBot.g:5988:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            // InternalBot.g:5988:3: rule__TextLanguageInput__InputsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__InputsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__3"
    // InternalBot.g:5996:1: rule__TextLanguageInput__Group__3 : rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 ;
    public final void rule__TextLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6000:1: ( rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 )
            // InternalBot.g:6001:2: rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__TextLanguageInput__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__4();

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
    // $ANTLR end "rule__TextLanguageInput__Group__3"


    // $ANTLR start "rule__TextLanguageInput__Group__3__Impl"
    // InternalBot.g:6008:1: rule__TextLanguageInput__Group__3__Impl : ( ( rule__TextLanguageInput__Group_3__0 )* ) ;
    public final void rule__TextLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6012:1: ( ( ( rule__TextLanguageInput__Group_3__0 )* ) )
            // InternalBot.g:6013:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            {
            // InternalBot.g:6013:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            // InternalBot.g:6014:2: ( rule__TextLanguageInput__Group_3__0 )*
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 
            // InternalBot.g:6015:2: ( rule__TextLanguageInput__Group_3__0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==54) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBot.g:6015:3: rule__TextLanguageInput__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TextLanguageInput__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__4"
    // InternalBot.g:6023:1: rule__TextLanguageInput__Group__4 : rule__TextLanguageInput__Group__4__Impl ;
    public final void rule__TextLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6027:1: ( rule__TextLanguageInput__Group__4__Impl )
            // InternalBot.g:6028:2: rule__TextLanguageInput__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__4__Impl();

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
    // $ANTLR end "rule__TextLanguageInput__Group__4"


    // $ANTLR start "rule__TextLanguageInput__Group__4__Impl"
    // InternalBot.g:6034:1: rule__TextLanguageInput__Group__4__Impl : ( '}' ) ;
    public final void rule__TextLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6038:1: ( ( '}' ) )
            // InternalBot.g:6039:1: ( '}' )
            {
            // InternalBot.g:6039:1: ( '}' )
            // InternalBot.g:6040:2: '}'
            {
             before(grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__4__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0__0"
    // InternalBot.g:6050:1: rule__TextLanguageInput__Group_0__0 : rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 ;
    public final void rule__TextLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6054:1: ( rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 )
            // InternalBot.g:6055:2: rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_54);
            rule__TextLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0__1();

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
    // $ANTLR end "rule__TextLanguageInput__Group_0__0"


    // $ANTLR start "rule__TextLanguageInput__Group_0__0__Impl"
    // InternalBot.g:6062:1: rule__TextLanguageInput__Group_0__0__Impl : ( 'text' ) ;
    public final void rule__TextLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6066:1: ( ( 'text' ) )
            // InternalBot.g:6067:1: ( 'text' )
            {
            // InternalBot.g:6067:1: ( 'text' )
            // InternalBot.g:6068:2: 'text'
            {
             before(grammarAccess.getTextLanguageInputAccess().getTextKeyword_0_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getTextKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0__1"
    // InternalBot.g:6077:1: rule__TextLanguageInput__Group_0__1 : rule__TextLanguageInput__Group_0__1__Impl ;
    public final void rule__TextLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6081:1: ( rule__TextLanguageInput__Group_0__1__Impl )
            // InternalBot.g:6082:2: rule__TextLanguageInput__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0__1__Impl();

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
    // $ANTLR end "rule__TextLanguageInput__Group_0__1"


    // $ANTLR start "rule__TextLanguageInput__Group_0__1__Impl"
    // InternalBot.g:6088:1: rule__TextLanguageInput__Group_0__1__Impl : ( ( rule__TextLanguageInput__Group_0_1__0 )? ) ;
    public final void rule__TextLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6092:1: ( ( ( rule__TextLanguageInput__Group_0_1__0 )? ) )
            // InternalBot.g:6093:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            {
            // InternalBot.g:6093:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            // InternalBot.g:6094:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 
            // InternalBot.g:6095:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==63) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalBot.g:6095:3: rule__TextLanguageInput__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextLanguageInput__Group_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__0"
    // InternalBot.g:6104:1: rule__TextLanguageInput__Group_0_1__0 : rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 ;
    public final void rule__TextLanguageInput__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6108:1: ( rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 )
            // InternalBot.g:6109:2: rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TextLanguageInput__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0_1__1();

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
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__0"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__0__Impl"
    // InternalBot.g:6116:1: rule__TextLanguageInput__Group_0_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInput__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6120:1: ( ( 'in' ) )
            // InternalBot.g:6121:1: ( 'in' )
            {
            // InternalBot.g:6121:1: ( 'in' )
            // InternalBot.g:6122:2: 'in'
            {
             before(grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__1"
    // InternalBot.g:6131:1: rule__TextLanguageInput__Group_0_1__1 : rule__TextLanguageInput__Group_0_1__1__Impl ;
    public final void rule__TextLanguageInput__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6135:1: ( rule__TextLanguageInput__Group_0_1__1__Impl )
            // InternalBot.g:6136:2: rule__TextLanguageInput__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0_1__1__Impl();

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
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__1"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__1__Impl"
    // InternalBot.g:6142:1: rule__TextLanguageInput__Group_0_1__1__Impl : ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) ;
    public final void rule__TextLanguageInput__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6146:1: ( ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) )
            // InternalBot.g:6147:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            {
            // InternalBot.g:6147:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            // InternalBot.g:6148:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 
            // InternalBot.g:6149:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            // InternalBot.g:6149:3: rule__TextLanguageInput__LanguageAssignment_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__LanguageAssignment_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__1__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_3__0"
    // InternalBot.g:6158:1: rule__TextLanguageInput__Group_3__0 : rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 ;
    public final void rule__TextLanguageInput__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6162:1: ( rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 )
            // InternalBot.g:6163:2: rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1
            {
            pushFollow(FOLLOW_62);
            rule__TextLanguageInput__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_3__1();

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
    // $ANTLR end "rule__TextLanguageInput__Group_3__0"


    // $ANTLR start "rule__TextLanguageInput__Group_3__0__Impl"
    // InternalBot.g:6170:1: rule__TextLanguageInput__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInput__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6174:1: ( ( ',' ) )
            // InternalBot.g:6175:1: ( ',' )
            {
            // InternalBot.g:6175:1: ( ',' )
            // InternalBot.g:6176:2: ','
            {
             before(grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_3__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_3__1"
    // InternalBot.g:6185:1: rule__TextLanguageInput__Group_3__1 : rule__TextLanguageInput__Group_3__1__Impl ;
    public final void rule__TextLanguageInput__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6189:1: ( rule__TextLanguageInput__Group_3__1__Impl )
            // InternalBot.g:6190:2: rule__TextLanguageInput__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_3__1__Impl();

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
    // $ANTLR end "rule__TextLanguageInput__Group_3__1"


    // $ANTLR start "rule__TextLanguageInput__Group_3__1__Impl"
    // InternalBot.g:6196:1: rule__TextLanguageInput__Group_3__1__Impl : ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) ;
    public final void rule__TextLanguageInput__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6200:1: ( ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) )
            // InternalBot.g:6201:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            {
            // InternalBot.g:6201:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            // InternalBot.g:6202:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 
            // InternalBot.g:6203:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            // InternalBot.g:6203:3: rule__TextLanguageInput__InputsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__InputsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_3__1__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__0"
    // InternalBot.g:6212:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6216:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:6217:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
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
    // InternalBot.g:6224:1: rule__HTTPResponse__Group__0__Impl : ( 'HttpResponse' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6228:1: ( ( 'HttpResponse' ) )
            // InternalBot.g:6229:1: ( 'HttpResponse' )
            {
            // InternalBot.g:6229:1: ( 'HttpResponse' )
            // InternalBot.g:6230:2: 'HttpResponse'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0()); 
            match(input,80,FOLLOW_2); 
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
    // InternalBot.g:6239:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6243:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:6244:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:6251:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6255:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:6256:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:6256:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:6257:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:6258:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:6258:3: rule__HTTPResponse__NameAssignment_1
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
    // InternalBot.g:6266:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6270:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:6271:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
            {
            pushFollow(FOLLOW_63);
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
    // InternalBot.g:6278:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6282:1: ( ( ':' ) )
            // InternalBot.g:6283:1: ( ':' )
            {
            // InternalBot.g:6283:1: ( ':' )
            // InternalBot.g:6284:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:6293:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6297:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:6298:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
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
    // InternalBot.g:6305:1: rule__HTTPResponse__Group__3__Impl : ( 'HttpRequest:' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6309:1: ( ( 'HttpRequest:' ) )
            // InternalBot.g:6310:1: ( 'HttpRequest:' )
            {
            // InternalBot.g:6310:1: ( 'HttpRequest:' )
            // InternalBot.g:6311:2: 'HttpRequest:'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3()); 
            match(input,81,FOLLOW_2); 
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
    // InternalBot.g:6320:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6324:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:6325:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:6332:1: rule__HTTPResponse__Group__4__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6336:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) )
            // InternalBot.g:6337:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            {
            // InternalBot.g:6337:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            // InternalBot.g:6338:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_4()); 
            // InternalBot.g:6339:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            // InternalBot.g:6339:3: rule__HTTPResponse__HTTPRequestAssignment_4
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
    // InternalBot.g:6347:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6351:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:6352:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
            {
            pushFollow(FOLLOW_64);
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
    // InternalBot.g:6359:1: rule__HTTPResponse__Group__5__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6363:1: ( ( ';' ) )
            // InternalBot.g:6364:1: ( ';' )
            {
            // InternalBot.g:6364:1: ( ';' )
            // InternalBot.g:6365:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:6374:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6378:1: ( rule__HTTPResponse__Group__6__Impl )
            // InternalBot.g:6379:2: rule__HTTPResponse__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__6__Impl();

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
    // InternalBot.g:6385:1: rule__HTTPResponse__Group__6__Impl : ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6389:1: ( ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) ) )
            // InternalBot.g:6390:1: ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) )
            {
            // InternalBot.g:6390:1: ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) )
            // InternalBot.g:6391:2: ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* )
            {
            // InternalBot.g:6391:2: ( ( rule__HTTPResponse__InputsAssignment_6 ) )
            // InternalBot.g:6392:3: ( rule__HTTPResponse__InputsAssignment_6 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 
            // InternalBot.g:6393:3: ( rule__HTTPResponse__InputsAssignment_6 )
            // InternalBot.g:6393:4: rule__HTTPResponse__InputsAssignment_6
            {
            pushFollow(FOLLOW_65);
            rule__HTTPResponse__InputsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 

            }

            // InternalBot.g:6396:2: ( ( rule__HTTPResponse__InputsAssignment_6 )* )
            // InternalBot.g:6397:3: ( rule__HTTPResponse__InputsAssignment_6 )*
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 
            // InternalBot.g:6398:3: ( rule__HTTPResponse__InputsAssignment_6 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==11) ) {
                    int LA58_2 = input.LA(2);

                    if ( (LA58_2==61||LA58_2==63) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // InternalBot.g:6398:4: rule__HTTPResponse__InputsAssignment_6
            	    {
            	    pushFollow(FOLLOW_65);
            	    rule__HTTPResponse__InputsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 

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
    // $ANTLR end "rule__HTTPResponse__Group__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__0"
    // InternalBot.g:6408:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6412:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:6413:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
            {
            pushFollow(FOLLOW_66);
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
    // InternalBot.g:6420:1: rule__HTTPRequest__Group__0__Impl : ( 'HTTP' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6424:1: ( ( 'HTTP' ) )
            // InternalBot.g:6425:1: ( 'HTTP' )
            {
            // InternalBot.g:6425:1: ( 'HTTP' )
            // InternalBot.g:6426:2: 'HTTP'
            {
             before(grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0()); 
            match(input,82,FOLLOW_2); 
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
    // InternalBot.g:6435:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6439:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:6440:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
            {
            pushFollow(FOLLOW_67);
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
    // InternalBot.g:6447:1: rule__HTTPRequest__Group__1__Impl : ( 'request' ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6451:1: ( ( 'request' ) )
            // InternalBot.g:6452:1: ( 'request' )
            {
            // InternalBot.g:6452:1: ( 'request' )
            // InternalBot.g:6453:2: 'request'
            {
             before(grammarAccess.getHTTPRequestAccess().getRequestKeyword_1()); 
            match(input,83,FOLLOW_2); 
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
    // InternalBot.g:6462:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6466:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:6467:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
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
    // InternalBot.g:6474:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__MethodAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6478:1: ( ( ( rule__HTTPRequest__MethodAssignment_2 ) ) )
            // InternalBot.g:6479:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            {
            // InternalBot.g:6479:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            // InternalBot.g:6480:2: ( rule__HTTPRequest__MethodAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_2()); 
            // InternalBot.g:6481:2: ( rule__HTTPRequest__MethodAssignment_2 )
            // InternalBot.g:6481:3: rule__HTTPRequest__MethodAssignment_2
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
    // InternalBot.g:6489:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6493:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:6494:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:6501:1: rule__HTTPRequest__Group__3__Impl : ( ( rule__HTTPRequest__NameAssignment_3 ) ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6505:1: ( ( ( rule__HTTPRequest__NameAssignment_3 ) ) )
            // InternalBot.g:6506:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            {
            // InternalBot.g:6506:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            // InternalBot.g:6507:2: ( rule__HTTPRequest__NameAssignment_3 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_3()); 
            // InternalBot.g:6508:2: ( rule__HTTPRequest__NameAssignment_3 )
            // InternalBot.g:6508:3: rule__HTTPRequest__NameAssignment_3
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
    // InternalBot.g:6516:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6520:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:6521:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
            {
            pushFollow(FOLLOW_68);
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
    // InternalBot.g:6528:1: rule__HTTPRequest__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6532:1: ( ( ':' ) )
            // InternalBot.g:6533:1: ( ':' )
            {
            // InternalBot.g:6533:1: ( ':' )
            // InternalBot.g:6534:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_4()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:6543:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6547:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:6548:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:6555:1: rule__HTTPRequest__Group__5__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6559:1: ( ( 'URL' ) )
            // InternalBot.g:6560:1: ( 'URL' )
            {
            // InternalBot.g:6560:1: ( 'URL' )
            // InternalBot.g:6561:2: 'URL'
            {
             before(grammarAccess.getHTTPRequestAccess().getURLKeyword_5()); 
            match(input,84,FOLLOW_2); 
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
    // InternalBot.g:6570:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6574:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:6575:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
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
    // InternalBot.g:6582:1: rule__HTTPRequest__Group__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6586:1: ( ( ':' ) )
            // InternalBot.g:6587:1: ( ':' )
            {
            // InternalBot.g:6587:1: ( ':' )
            // InternalBot.g:6588:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_6()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:6597:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6601:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:6602:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:6609:1: rule__HTTPRequest__Group__7__Impl : ( ( rule__HTTPRequest__URLAssignment_7 ) ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6613:1: ( ( ( rule__HTTPRequest__URLAssignment_7 ) ) )
            // InternalBot.g:6614:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            {
            // InternalBot.g:6614:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            // InternalBot.g:6615:2: ( rule__HTTPRequest__URLAssignment_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_7()); 
            // InternalBot.g:6616:2: ( rule__HTTPRequest__URLAssignment_7 )
            // InternalBot.g:6616:3: rule__HTTPRequest__URLAssignment_7
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
    // InternalBot.g:6624:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6628:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:6629:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
            {
            pushFollow(FOLLOW_69);
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
    // InternalBot.g:6636:1: rule__HTTPRequest__Group__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6640:1: ( ( ';' ) )
            // InternalBot.g:6641:1: ( ';' )
            {
            // InternalBot.g:6641:1: ( ';' )
            // InternalBot.g:6642:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:6651:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6655:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:6656:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
            {
            pushFollow(FOLLOW_69);
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
    // InternalBot.g:6663:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6667:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:6668:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:6668:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:6669:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:6670:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==85) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalBot.g:6670:3: rule__HTTPRequest__Group_9__0
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
    // InternalBot.g:6678:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6682:1: ( rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 )
            // InternalBot.g:6683:2: rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11
            {
            pushFollow(FOLLOW_69);
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
    // InternalBot.g:6690:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6694:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:6695:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:6695:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:6696:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:6697:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==86) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalBot.g:6697:3: rule__HTTPRequest__Group_10__0
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
    // InternalBot.g:6705:1: rule__HTTPRequest__Group__11 : rule__HTTPRequest__Group__11__Impl ;
    public final void rule__HTTPRequest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6709:1: ( rule__HTTPRequest__Group__11__Impl )
            // InternalBot.g:6710:2: rule__HTTPRequest__Group__11__Impl
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
    // InternalBot.g:6716:1: rule__HTTPRequest__Group__11__Impl : ( ( rule__HTTPRequest__Group_11__0 )? ) ;
    public final void rule__HTTPRequest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6720:1: ( ( ( rule__HTTPRequest__Group_11__0 )? ) )
            // InternalBot.g:6721:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            {
            // InternalBot.g:6721:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            // InternalBot.g:6722:2: ( rule__HTTPRequest__Group_11__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11()); 
            // InternalBot.g:6723:2: ( rule__HTTPRequest__Group_11__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==18) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalBot.g:6723:3: rule__HTTPRequest__Group_11__0
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
    // InternalBot.g:6732:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6736:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:6737:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:6744:1: rule__HTTPRequest__Group_9__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6748:1: ( ( 'basicAuth' ) )
            // InternalBot.g:6749:1: ( 'basicAuth' )
            {
            // InternalBot.g:6749:1: ( 'basicAuth' )
            // InternalBot.g:6750:2: 'basicAuth'
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0()); 
            match(input,85,FOLLOW_2); 
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
    // InternalBot.g:6759:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6763:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:6764:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
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
    // InternalBot.g:6771:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6775:1: ( ( ':' ) )
            // InternalBot.g:6776:1: ( ':' )
            {
            // InternalBot.g:6776:1: ( ':' )
            // InternalBot.g:6777:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:6786:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6790:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:6791:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:6798:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6802:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) )
            // InternalBot.g:6803:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            {
            // InternalBot.g:6803:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            // InternalBot.g:6804:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_9_2()); 
            // InternalBot.g:6805:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            // InternalBot.g:6805:3: rule__HTTPRequest__BasicAuthAssignment_9_2
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
    // InternalBot.g:6813:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6817:1: ( rule__HTTPRequest__Group_9__3__Impl )
            // InternalBot.g:6818:2: rule__HTTPRequest__Group_9__3__Impl
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
    // InternalBot.g:6824:1: rule__HTTPRequest__Group_9__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6828:1: ( ( ';' ) )
            // InternalBot.g:6829:1: ( ';' )
            {
            // InternalBot.g:6829:1: ( ';' )
            // InternalBot.g:6830:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:6840:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6844:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:6845:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:6852:1: rule__HTTPRequest__Group_10__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6856:1: ( ( 'headers' ) )
            // InternalBot.g:6857:1: ( 'headers' )
            {
            // InternalBot.g:6857:1: ( 'headers' )
            // InternalBot.g:6858:2: 'headers'
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0()); 
            match(input,86,FOLLOW_2); 
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
    // InternalBot.g:6867:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6871:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:6872:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
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
    // InternalBot.g:6879:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6883:1: ( ( ':' ) )
            // InternalBot.g:6884:1: ( ':' )
            {
            // InternalBot.g:6884:1: ( ':' )
            // InternalBot.g:6885:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:6894:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6898:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:6899:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:6906:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6910:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) )
            // InternalBot.g:6911:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            {
            // InternalBot.g:6911:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            // InternalBot.g:6912:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_2()); 
            // InternalBot.g:6913:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            // InternalBot.g:6913:3: rule__HTTPRequest__HeadersAssignment_10_2
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
    // InternalBot.g:6921:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6925:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:6926:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:6933:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6937:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:6938:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:6938:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:6939:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:6940:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==54) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBot.g:6940:3: rule__HTTPRequest__Group_10_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HTTPRequest__Group_10_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // InternalBot.g:6948:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6952:1: ( rule__HTTPRequest__Group_10__4__Impl )
            // InternalBot.g:6953:2: rule__HTTPRequest__Group_10__4__Impl
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
    // InternalBot.g:6959:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6963:1: ( ( ';' ) )
            // InternalBot.g:6964:1: ( ';' )
            {
            // InternalBot.g:6964:1: ( ';' )
            // InternalBot.g:6965:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:6975:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6979:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:6980:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
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
    // InternalBot.g:6987:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6991:1: ( ( ',' ) )
            // InternalBot.g:6992:1: ( ',' )
            {
            // InternalBot.g:6992:1: ( ',' )
            // InternalBot.g:6993:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7002:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7006:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:7007:2: rule__HTTPRequest__Group_10_3__1__Impl
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
    // InternalBot.g:7013:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7017:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) )
            // InternalBot.g:7018:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            {
            // InternalBot.g:7018:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            // InternalBot.g:7019:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_3_1()); 
            // InternalBot.g:7020:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            // InternalBot.g:7020:3: rule__HTTPRequest__HeadersAssignment_10_3_1
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
    // InternalBot.g:7029:1: rule__HTTPRequest__Group_11__0 : rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 ;
    public final void rule__HTTPRequest__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7033:1: ( rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 )
            // InternalBot.g:7034:2: rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:7041:1: rule__HTTPRequest__Group_11__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7045:1: ( ( 'data' ) )
            // InternalBot.g:7046:1: ( 'data' )
            {
            // InternalBot.g:7046:1: ( 'data' )
            // InternalBot.g:7047:2: 'data'
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
    // InternalBot.g:7056:1: rule__HTTPRequest__Group_11__1 : rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 ;
    public final void rule__HTTPRequest__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7060:1: ( rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 )
            // InternalBot.g:7061:2: rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2
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
    // InternalBot.g:7068:1: rule__HTTPRequest__Group_11__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7072:1: ( ( ':' ) )
            // InternalBot.g:7073:1: ( ':' )
            {
            // InternalBot.g:7073:1: ( ':' )
            // InternalBot.g:7074:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:7083:1: rule__HTTPRequest__Group_11__2 : rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 ;
    public final void rule__HTTPRequest__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7087:1: ( rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 )
            // InternalBot.g:7088:2: rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:7095:1: rule__HTTPRequest__Group_11__2__Impl : ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) ;
    public final void rule__HTTPRequest__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7099:1: ( ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) )
            // InternalBot.g:7100:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            {
            // InternalBot.g:7100:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            // InternalBot.g:7101:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_2()); 
            // InternalBot.g:7102:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            // InternalBot.g:7102:3: rule__HTTPRequest__DataAssignment_11_2
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
    // InternalBot.g:7110:1: rule__HTTPRequest__Group_11__3 : rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 ;
    public final void rule__HTTPRequest__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7114:1: ( rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 )
            // InternalBot.g:7115:2: rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:7122:1: rule__HTTPRequest__Group_11__3__Impl : ( ( rule__HTTPRequest__Group_11_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7126:1: ( ( ( rule__HTTPRequest__Group_11_3__0 )* ) )
            // InternalBot.g:7127:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            {
            // InternalBot.g:7127:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            // InternalBot.g:7128:2: ( rule__HTTPRequest__Group_11_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11_3()); 
            // InternalBot.g:7129:2: ( rule__HTTPRequest__Group_11_3__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==54) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBot.g:7129:3: rule__HTTPRequest__Group_11_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HTTPRequest__Group_11_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalBot.g:7137:1: rule__HTTPRequest__Group_11__4 : rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 ;
    public final void rule__HTTPRequest__Group_11__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7141:1: ( rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 )
            // InternalBot.g:7142:2: rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5
            {
            pushFollow(FOLLOW_70);
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
    // InternalBot.g:7149:1: rule__HTTPRequest__Group_11__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7153:1: ( ( ';' ) )
            // InternalBot.g:7154:1: ( ';' )
            {
            // InternalBot.g:7154:1: ( ';' )
            // InternalBot.g:7155:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:7164:1: rule__HTTPRequest__Group_11__5 : rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 ;
    public final void rule__HTTPRequest__Group_11__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7168:1: ( rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 )
            // InternalBot.g:7169:2: rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:7176:1: rule__HTTPRequest__Group_11__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_11__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7180:1: ( ( 'dataType' ) )
            // InternalBot.g:7181:1: ( 'dataType' )
            {
            // InternalBot.g:7181:1: ( 'dataType' )
            // InternalBot.g:7182:2: 'dataType'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5()); 
            match(input,87,FOLLOW_2); 
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
    // InternalBot.g:7191:1: rule__HTTPRequest__Group_11__6 : rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 ;
    public final void rule__HTTPRequest__Group_11__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7195:1: ( rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 )
            // InternalBot.g:7196:2: rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7
            {
            pushFollow(FOLLOW_71);
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
    // InternalBot.g:7203:1: rule__HTTPRequest__Group_11__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7207:1: ( ( ':' ) )
            // InternalBot.g:7208:1: ( ':' )
            {
            // InternalBot.g:7208:1: ( ':' )
            // InternalBot.g:7209:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:7218:1: rule__HTTPRequest__Group_11__7 : rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 ;
    public final void rule__HTTPRequest__Group_11__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7222:1: ( rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 )
            // InternalBot.g:7223:2: rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:7230:1: rule__HTTPRequest__Group_11__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) ;
    public final void rule__HTTPRequest__Group_11__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7234:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) )
            // InternalBot.g:7235:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            {
            // InternalBot.g:7235:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            // InternalBot.g:7236:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_11_7()); 
            // InternalBot.g:7237:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            // InternalBot.g:7237:3: rule__HTTPRequest__DataTypeAssignment_11_7
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
    // InternalBot.g:7245:1: rule__HTTPRequest__Group_11__8 : rule__HTTPRequest__Group_11__8__Impl ;
    public final void rule__HTTPRequest__Group_11__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7249:1: ( rule__HTTPRequest__Group_11__8__Impl )
            // InternalBot.g:7250:2: rule__HTTPRequest__Group_11__8__Impl
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
    // InternalBot.g:7256:1: rule__HTTPRequest__Group_11__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7260:1: ( ( ';' ) )
            // InternalBot.g:7261:1: ( ';' )
            {
            // InternalBot.g:7261:1: ( ';' )
            // InternalBot.g:7262:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:7272:1: rule__HTTPRequest__Group_11_3__0 : rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 ;
    public final void rule__HTTPRequest__Group_11_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7276:1: ( rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 )
            // InternalBot.g:7277:2: rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1
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
    // InternalBot.g:7284:1: rule__HTTPRequest__Group_11_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_11_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7288:1: ( ( ',' ) )
            // InternalBot.g:7289:1: ( ',' )
            {
            // InternalBot.g:7289:1: ( ',' )
            // InternalBot.g:7290:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7299:1: rule__HTTPRequest__Group_11_3__1 : rule__HTTPRequest__Group_11_3__1__Impl ;
    public final void rule__HTTPRequest__Group_11_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7303:1: ( rule__HTTPRequest__Group_11_3__1__Impl )
            // InternalBot.g:7304:2: rule__HTTPRequest__Group_11_3__1__Impl
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
    // InternalBot.g:7310:1: rule__HTTPRequest__Group_11_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_11_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7314:1: ( ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) )
            // InternalBot.g:7315:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            {
            // InternalBot.g:7315:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            // InternalBot.g:7316:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_3_1()); 
            // InternalBot.g:7317:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            // InternalBot.g:7317:3: rule__HTTPRequest__DataAssignment_11_3_1
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
    // InternalBot.g:7326:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7330:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:7331:2: rule__Image__Group__0__Impl rule__Image__Group__1
            {
            pushFollow(FOLLOW_59);
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
    // InternalBot.g:7338:1: rule__Image__Group__0__Impl : ( 'image' ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7342:1: ( ( 'image' ) )
            // InternalBot.g:7343:1: ( 'image' )
            {
            // InternalBot.g:7343:1: ( 'image' )
            // InternalBot.g:7344:2: 'image'
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
    // InternalBot.g:7353:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7357:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:7358:2: rule__Image__Group__1__Impl rule__Image__Group__2
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
    // InternalBot.g:7365:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7369:1: ( ( 'response' ) )
            // InternalBot.g:7370:1: ( 'response' )
            {
            // InternalBot.g:7370:1: ( 'response' )
            // InternalBot.g:7371:2: 'response'
            {
             before(grammarAccess.getImageAccess().getResponseKeyword_1()); 
            match(input,79,FOLLOW_2); 
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
    // InternalBot.g:7380:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7384:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:7385:2: rule__Image__Group__2__Impl rule__Image__Group__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:7392:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7396:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:7397:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:7397:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:7398:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:7399:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:7399:3: rule__Image__NameAssignment_2
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
    // InternalBot.g:7407:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7411:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:7412:2: rule__Image__Group__3__Impl rule__Image__Group__4
            {
            pushFollow(FOLLOW_68);
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
    // InternalBot.g:7419:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7423:1: ( ( ':' ) )
            // InternalBot.g:7424:1: ( ':' )
            {
            // InternalBot.g:7424:1: ( ':' )
            // InternalBot.g:7425:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_3()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:7434:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7438:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:7439:2: rule__Image__Group__4__Impl rule__Image__Group__5
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:7446:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7450:1: ( ( 'URL' ) )
            // InternalBot.g:7451:1: ( 'URL' )
            {
            // InternalBot.g:7451:1: ( 'URL' )
            // InternalBot.g:7452:2: 'URL'
            {
             before(grammarAccess.getImageAccess().getURLKeyword_4()); 
            match(input,84,FOLLOW_2); 
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
    // InternalBot.g:7461:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7465:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:7466:2: rule__Image__Group__5__Impl rule__Image__Group__6
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
    // InternalBot.g:7473:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7477:1: ( ( ':' ) )
            // InternalBot.g:7478:1: ( ':' )
            {
            // InternalBot.g:7478:1: ( ':' )
            // InternalBot.g:7479:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_5()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:7488:1: rule__Image__Group__6 : rule__Image__Group__6__Impl ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7492:1: ( rule__Image__Group__6__Impl )
            // InternalBot.g:7493:2: rule__Image__Group__6__Impl
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
    // InternalBot.g:7499:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7503:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:7504:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:7504:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:7505:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:7506:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:7506:3: rule__Image__URLAssignment_6
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


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0"
    // InternalBot.g:7515:1: rule__TextLanguageInputHttpResponse__Group__0 : rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7519:1: ( rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 )
            // InternalBot.g:7520:2: rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__TextLanguageInputHttpResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__1();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__0"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0__Impl"
    // InternalBot.g:7527:1: rule__TextLanguageInputHttpResponse__Group__0__Impl : ( 'text' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7531:1: ( ( 'text' ) )
            // InternalBot.g:7532:1: ( 'text' )
            {
            // InternalBot.g:7532:1: ( 'text' )
            // InternalBot.g:7533:2: 'text'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getTextKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getTextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__0__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__1"
    // InternalBot.g:7542:1: rule__TextLanguageInputHttpResponse__Group__1 : rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 ;
    public final void rule__TextLanguageInputHttpResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7546:1: ( rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 )
            // InternalBot.g:7547:2: rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__TextLanguageInputHttpResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__2();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__1__Impl"
    // InternalBot.g:7554:1: rule__TextLanguageInputHttpResponse__Group__1__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7558:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) )
            // InternalBot.g:7559:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            {
            // InternalBot.g:7559:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            // InternalBot.g:7560:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 
            // InternalBot.g:7561:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==63) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalBot.g:7561:3: rule__TextLanguageInputHttpResponse__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextLanguageInputHttpResponse__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__1__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__2"
    // InternalBot.g:7569:1: rule__TextLanguageInputHttpResponse__Group__2 : rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 ;
    public final void rule__TextLanguageInputHttpResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7573:1: ( rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 )
            // InternalBot.g:7574:2: rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3
            {
            pushFollow(FOLLOW_72);
            rule__TextLanguageInputHttpResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__3();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__2"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__2__Impl"
    // InternalBot.g:7581:1: rule__TextLanguageInputHttpResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7585:1: ( ( '{' ) )
            // InternalBot.g:7586:1: ( '{' )
            {
            // InternalBot.g:7586:1: ( '{' )
            // InternalBot.g:7587:2: '{'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__2__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__3"
    // InternalBot.g:7596:1: rule__TextLanguageInputHttpResponse__Group__3 : rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 ;
    public final void rule__TextLanguageInputHttpResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7600:1: ( rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 )
            // InternalBot.g:7601:2: rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__TextLanguageInputHttpResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__4();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__3"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__3__Impl"
    // InternalBot.g:7608:1: rule__TextLanguageInputHttpResponse__Group__3__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7612:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) )
            // InternalBot.g:7613:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            {
            // InternalBot.g:7613:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            // InternalBot.g:7614:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 
            // InternalBot.g:7615:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            // InternalBot.g:7615:3: rule__TextLanguageInputHttpResponse__InputsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__InputsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__3__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__4"
    // InternalBot.g:7623:1: rule__TextLanguageInputHttpResponse__Group__4 : rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 ;
    public final void rule__TextLanguageInputHttpResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7627:1: ( rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 )
            // InternalBot.g:7628:2: rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__TextLanguageInputHttpResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__5();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__4"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__4__Impl"
    // InternalBot.g:7635:1: rule__TextLanguageInputHttpResponse__Group__4__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7639:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) )
            // InternalBot.g:7640:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            {
            // InternalBot.g:7640:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            // InternalBot.g:7641:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 
            // InternalBot.g:7642:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==54) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalBot.g:7642:3: rule__TextLanguageInputHttpResponse__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TextLanguageInputHttpResponse__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__4__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__5"
    // InternalBot.g:7650:1: rule__TextLanguageInputHttpResponse__Group__5 : rule__TextLanguageInputHttpResponse__Group__5__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7654:1: ( rule__TextLanguageInputHttpResponse__Group__5__Impl )
            // InternalBot.g:7655:2: rule__TextLanguageInputHttpResponse__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__5__Impl();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__5"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__5__Impl"
    // InternalBot.g:7661:1: rule__TextLanguageInputHttpResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7665:1: ( ( '}' ) )
            // InternalBot.g:7666:1: ( '}' )
            {
            // InternalBot.g:7666:1: ( '}' )
            // InternalBot.g:7667:2: '}'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__5__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__0"
    // InternalBot.g:7677:1: rule__TextLanguageInputHttpResponse__Group_1__0 : rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7681:1: ( rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 )
            // InternalBot.g:7682:2: rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TextLanguageInputHttpResponse__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_1__1();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__0"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__0__Impl"
    // InternalBot.g:7689:1: rule__TextLanguageInputHttpResponse__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7693:1: ( ( 'in' ) )
            // InternalBot.g:7694:1: ( 'in' )
            {
            // InternalBot.g:7694:1: ( 'in' )
            // InternalBot.g:7695:2: 'in'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__0__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__1"
    // InternalBot.g:7704:1: rule__TextLanguageInputHttpResponse__Group_1__1 : rule__TextLanguageInputHttpResponse__Group_1__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7708:1: ( rule__TextLanguageInputHttpResponse__Group_1__1__Impl )
            // InternalBot.g:7709:2: rule__TextLanguageInputHttpResponse__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_1__1__Impl();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__1__Impl"
    // InternalBot.g:7715:1: rule__TextLanguageInputHttpResponse__Group_1__1__Impl : ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7719:1: ( ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:7720:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:7720:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            // InternalBot.g:7721:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:7722:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            // InternalBot.g:7722:3: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__1__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__0"
    // InternalBot.g:7731:1: rule__TextLanguageInputHttpResponse__Group_4__0 : rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7735:1: ( rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 )
            // InternalBot.g:7736:2: rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1
            {
            pushFollow(FOLLOW_72);
            rule__TextLanguageInputHttpResponse__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_4__1();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__0"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__0__Impl"
    // InternalBot.g:7743:1: rule__TextLanguageInputHttpResponse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7747:1: ( ( ',' ) )
            // InternalBot.g:7748:1: ( ',' )
            {
            // InternalBot.g:7748:1: ( ',' )
            // InternalBot.g:7749:2: ','
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__0__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__1"
    // InternalBot.g:7758:1: rule__TextLanguageInputHttpResponse__Group_4__1 : rule__TextLanguageInputHttpResponse__Group_4__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7762:1: ( rule__TextLanguageInputHttpResponse__Group_4__1__Impl )
            // InternalBot.g:7763:2: rule__TextLanguageInputHttpResponse__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_4__1__Impl();

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
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__1__Impl"
    // InternalBot.g:7769:1: rule__TextLanguageInputHttpResponse__Group_4__1__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7773:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) )
            // InternalBot.g:7774:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:7774:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            // InternalBot.g:7775:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:7776:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            // InternalBot.g:7776:3: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__InputsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // InternalBot.g:7785:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7789:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:7790:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:7797:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7801:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:7802:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:7802:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:7803:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:7804:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:7804:3: rule__KeyValue__KeyAssignment_0
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
    // InternalBot.g:7812:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7816:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:7817:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalBot.g:7824:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7828:1: ( ( ':' ) )
            // InternalBot.g:7829:1: ( ':' )
            {
            // InternalBot.g:7829:1: ( ':' )
            // InternalBot.g:7830:2: ':'
            {
             before(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:7839:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7843:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:7844:2: rule__KeyValue__Group__2__Impl
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
    // InternalBot.g:7850:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7854:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:7855:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:7855:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:7856:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:7857:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:7857:3: rule__KeyValue__ValueAssignment_2
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
    // InternalBot.g:7866:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7870:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:7871:2: rule__Data__Group__0__Impl rule__Data__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalBot.g:7878:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7882:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:7883:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:7883:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:7884:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:7885:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:7885:3: rule__Data__KeyAssignment_0
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
    // InternalBot.g:7893:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7897:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:7898:2: rule__Data__Group__1__Impl rule__Data__Group__2
            {
            pushFollow(FOLLOW_62);
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
    // InternalBot.g:7905:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7909:1: ( ( ':' ) )
            // InternalBot.g:7910:1: ( ':' )
            {
            // InternalBot.g:7910:1: ( ':' )
            // InternalBot.g:7911:2: ':'
            {
             before(grammarAccess.getDataAccess().getColonKeyword_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:7920:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7924:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:7925:2: rule__Data__Group__2__Impl
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
    // InternalBot.g:7931:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7935:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:7936:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:7936:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:7937:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:7938:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:7938:3: rule__Data__ValueAssignment_2
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
    // InternalBot.g:7947:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7951:1: ( ( ruleEString ) )
            // InternalBot.g:7952:2: ( ruleEString )
            {
            // InternalBot.g:7952:2: ( ruleEString )
            // InternalBot.g:7953:3: ruleEString
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


    // $ANTLR start "rule__Bot__LanguagesAssignment_3"
    // InternalBot.g:7962:1: rule__Bot__LanguagesAssignment_3 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7966:1: ( ( ruleLanguage ) )
            // InternalBot.g:7967:2: ( ruleLanguage )
            {
            // InternalBot.g:7967:2: ( ruleLanguage )
            // InternalBot.g:7968:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguagesAssignment_3"


    // $ANTLR start "rule__Bot__LanguagesAssignment_4_1"
    // InternalBot.g:7977:1: rule__Bot__LanguagesAssignment_4_1 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7981:1: ( ( ruleLanguage ) )
            // InternalBot.g:7982:2: ( ruleLanguage )
            {
            // InternalBot.g:7982:2: ( ruleLanguage )
            // InternalBot.g:7983:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguagesAssignment_4_1"


    // $ANTLR start "rule__Bot__IntentsAssignment_7"
    // InternalBot.g:7992:1: rule__Bot__IntentsAssignment_7 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7996:1: ( ( ruleIntent ) )
            // InternalBot.g:7997:2: ( ruleIntent )
            {
            // InternalBot.g:7997:2: ( ruleIntent )
            // InternalBot.g:7998:3: ruleIntent
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


    // $ANTLR start "rule__Bot__IntentsAssignment_8"
    // InternalBot.g:8007:1: rule__Bot__IntentsAssignment_8 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8011:1: ( ( ruleIntent ) )
            // InternalBot.g:8012:2: ( ruleIntent )
            {
            // InternalBot.g:8012:2: ( ruleIntent )
            // InternalBot.g:8013:3: ruleIntent
            {
             before(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__IntentsAssignment_8"


    // $ANTLR start "rule__Bot__EntitiesAssignment_9_2"
    // InternalBot.g:8022:1: rule__Bot__EntitiesAssignment_9_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8026:1: ( ( ruleEntity ) )
            // InternalBot.g:8027:2: ( ruleEntity )
            {
            // InternalBot.g:8027:2: ( ruleEntity )
            // InternalBot.g:8028:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_9_2"


    // $ANTLR start "rule__Bot__EntitiesAssignment_9_3"
    // InternalBot.g:8037:1: rule__Bot__EntitiesAssignment_9_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8041:1: ( ( ruleEntity ) )
            // InternalBot.g:8042:2: ( ruleEntity )
            {
            // InternalBot.g:8042:2: ( ruleEntity )
            // InternalBot.g:8043:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_9_3"


    // $ANTLR start "rule__Bot__ActionsAssignment_10_2"
    // InternalBot.g:8052:1: rule__Bot__ActionsAssignment_10_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8056:1: ( ( ruleAction ) )
            // InternalBot.g:8057:2: ( ruleAction )
            {
            // InternalBot.g:8057:2: ( ruleAction )
            // InternalBot.g:8058:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_10_2"


    // $ANTLR start "rule__Bot__ActionsAssignment_10_3"
    // InternalBot.g:8067:1: rule__Bot__ActionsAssignment_10_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8071:1: ( ( ruleAction ) )
            // InternalBot.g:8072:2: ( ruleAction )
            {
            // InternalBot.g:8072:2: ( ruleAction )
            // InternalBot.g:8073:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_10_3"


    // $ANTLR start "rule__Bot__FlowsAssignment_13_1"
    // InternalBot.g:8082:1: rule__Bot__FlowsAssignment_13_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8086:1: ( ( ruleTransition ) )
            // InternalBot.g:8087:2: ( ruleTransition )
            {
            // InternalBot.g:8087:2: ( ruleTransition )
            // InternalBot.g:8088:3: ruleTransition
            {
             before(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__FlowsAssignment_13_1"


    // $ANTLR start "rule__Intent__NameAssignment_0"
    // InternalBot.g:8097:1: rule__Intent__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8101:1: ( ( ruleEString ) )
            // InternalBot.g:8102:2: ( ruleEString )
            {
            // InternalBot.g:8102:2: ( ruleEString )
            // InternalBot.g:8103:3: ruleEString
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
    // InternalBot.g:8112:1: rule__Intent__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8116:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:8117:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:8117:2: ( ( 'Fallback' ) )
            // InternalBot.g:8118:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:8119:3: ( 'Fallback' )
            // InternalBot.g:8120:4: 'Fallback'
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,88,FOLLOW_2); 
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


    // $ANTLR start "rule__Intent__InputsAssignment_3"
    // InternalBot.g:8131:1: rule__Intent__InputsAssignment_3 : ( ruleIntentLanguageInputs ) ;
    public final void rule__Intent__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8135:1: ( ( ruleIntentLanguageInputs ) )
            // InternalBot.g:8136:2: ( ruleIntentLanguageInputs )
            {
            // InternalBot.g:8136:2: ( ruleIntentLanguageInputs )
            // InternalBot.g:8137:3: ruleIntentLanguageInputs
            {
             before(grammarAccess.getIntentAccess().getInputsIntentLanguageInputsParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIntentLanguageInputs();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getInputsIntentLanguageInputsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__InputsAssignment_3"


    // $ANTLR start "rule__Intent__ParametersAssignment_4_1"
    // InternalBot.g:8146:1: rule__Intent__ParametersAssignment_4_1 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8150:1: ( ( ruleParameter ) )
            // InternalBot.g:8151:2: ( ruleParameter )
            {
            // InternalBot.g:8151:2: ( ruleParameter )
            // InternalBot.g:8152:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_4_1"


    // $ANTLR start "rule__Intent__ParametersAssignment_4_2"
    // InternalBot.g:8161:1: rule__Intent__ParametersAssignment_4_2 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8165:1: ( ( ruleParameter ) )
            // InternalBot.g:8166:2: ( ruleParameter )
            {
            // InternalBot.g:8166:2: ( ruleParameter )
            // InternalBot.g:8167:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_4_2"


    // $ANTLR start "rule__IntentLanguageInputs__LanguageAssignment_1_1"
    // InternalBot.g:8176:1: rule__IntentLanguageInputs__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__IntentLanguageInputs__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8180:1: ( ( ruleLanguage ) )
            // InternalBot.g:8181:2: ( ruleLanguage )
            {
            // InternalBot.g:8181:2: ( ruleLanguage )
            // InternalBot.g:8182:3: ruleLanguage
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__LanguageAssignment_1_1"


    // $ANTLR start "rule__IntentLanguageInputs__InputsAssignment_3"
    // InternalBot.g:8191:1: rule__IntentLanguageInputs__InputsAssignment_3 : ( ruleTrainingPhrase ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8195:1: ( ( ruleTrainingPhrase ) )
            // InternalBot.g:8196:2: ( ruleTrainingPhrase )
            {
            // InternalBot.g:8196:2: ( ruleTrainingPhrase )
            // InternalBot.g:8197:3: ruleTrainingPhrase
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsTrainingPhraseParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsTrainingPhraseParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__InputsAssignment_3"


    // $ANTLR start "rule__IntentLanguageInputs__InputsAssignment_4_1"
    // InternalBot.g:8206:1: rule__IntentLanguageInputs__InputsAssignment_4_1 : ( ruleTrainingPhrase ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8210:1: ( ( ruleTrainingPhrase ) )
            // InternalBot.g:8211:2: ( ruleTrainingPhrase )
            {
            // InternalBot.g:8211:2: ( ruleTrainingPhrase )
            // InternalBot.g:8212:3: ruleTrainingPhrase
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsTrainingPhraseParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsTrainingPhraseParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__InputsAssignment_4_1"


    // $ANTLR start "rule__Transition__IntentAssignment_1"
    // InternalBot.g:8221:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8225:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8226:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8226:2: ( ( ruleEString ) )
            // InternalBot.g:8227:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:8228:3: ( ruleEString )
            // InternalBot.g:8229:4: ruleEString
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
    // InternalBot.g:8240:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8244:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:8245:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:8245:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:8246:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:8247:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:8247:4: rule__Transition__TargetAlternatives_2_1_0
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
    // InternalBot.g:8255:1: rule__State__ActionsAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8259:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8260:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8260:2: ( ( ruleEString ) )
            // InternalBot.g:8261:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0()); 
            // InternalBot.g:8262:3: ( ruleEString )
            // InternalBot.g:8263:4: ruleEString
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
    // InternalBot.g:8274:1: rule__State__ActionsAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8278:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8279:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8279:2: ( ( ruleEString ) )
            // InternalBot.g:8280:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0()); 
            // InternalBot.g:8281:3: ( ruleEString )
            // InternalBot.g:8282:4: ruleEString
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
    // InternalBot.g:8293:1: rule__State__OutcomingAssignment_5_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8297:1: ( ( ruleTransition ) )
            // InternalBot.g:8298:2: ( ruleTransition )
            {
            // InternalBot.g:8298:2: ( ruleTransition )
            // InternalBot.g:8299:3: ruleTransition
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
    // InternalBot.g:8308:1: rule__State2__ActionsAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8312:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8313:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8313:2: ( ( ruleEString ) )
            // InternalBot.g:8314:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_0()); 
            // InternalBot.g:8315:3: ( ruleEString )
            // InternalBot.g:8316:4: ruleEString
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
    // InternalBot.g:8327:1: rule__State2__ActionsAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8331:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8332:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8332:2: ( ( ruleEString ) )
            // InternalBot.g:8333:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0()); 
            // InternalBot.g:8334:3: ( ruleEString )
            // InternalBot.g:8335:4: ruleEString
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
    // InternalBot.g:8346:1: rule__State2__OutcomingAssignment_6_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8350:1: ( ( ruleTransition ) )
            // InternalBot.g:8351:2: ( ruleTransition )
            {
            // InternalBot.g:8351:2: ( ruleTransition )
            // InternalBot.g:8352:3: ruleTransition
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
    // InternalBot.g:8361:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8365:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:8366:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:8366:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:8367:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:8368:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:8368:4: rule__TrainingPhrase__TokensAlternatives_1_0
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
    // InternalBot.g:8376:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8380:1: ( ( ruleEString ) )
            // InternalBot.g:8381:2: ( ruleEString )
            {
            // InternalBot.g:8381:2: ( ruleEString )
            // InternalBot.g:8382:3: ruleEString
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
    // InternalBot.g:8391:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8395:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8396:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8396:2: ( ( ruleEString ) )
            // InternalBot.g:8397:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:8398:3: ( ruleEString )
            // InternalBot.g:8399:4: ruleEString
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
    // InternalBot.g:8410:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8414:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:8415:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:8415:2: ( ruleDefaultEntity )
            // InternalBot.g:8416:3: ruleDefaultEntity
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
    // InternalBot.g:8425:1: rule__Parameter__RequiredAssignment_4_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8429:1: ( ( ( 'required' ) ) )
            // InternalBot.g:8430:2: ( ( 'required' ) )
            {
            // InternalBot.g:8430:2: ( ( 'required' ) )
            // InternalBot.g:8431:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            // InternalBot.g:8432:3: ( 'required' )
            // InternalBot.g:8433:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            match(input,89,FOLLOW_2); 
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


    // $ANTLR start "rule__Parameter__PromptsAssignment_4_2_1"
    // InternalBot.g:8444:1: rule__Parameter__PromptsAssignment_4_2_1 : ( rulePromptLanguage ) ;
    public final void rule__Parameter__PromptsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8448:1: ( ( rulePromptLanguage ) )
            // InternalBot.g:8449:2: ( rulePromptLanguage )
            {
            // InternalBot.g:8449:2: ( rulePromptLanguage )
            // InternalBot.g:8450:3: rulePromptLanguage
            {
             before(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            rulePromptLanguage();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_4_2_1"


    // $ANTLR start "rule__Parameter__IsListAssignment_5_1"
    // InternalBot.g:8459:1: rule__Parameter__IsListAssignment_5_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8463:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:8464:2: ( ( 'isList' ) )
            {
            // InternalBot.g:8464:2: ( ( 'isList' ) )
            // InternalBot.g:8465:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 
            // InternalBot.g:8466:3: ( 'isList' )
            // InternalBot.g:8467:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 
            match(input,90,FOLLOW_2); 
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


    // $ANTLR start "rule__PromptLanguage__LanguageAssignment_1_1"
    // InternalBot.g:8478:1: rule__PromptLanguage__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__PromptLanguage__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8482:1: ( ( ruleLanguage ) )
            // InternalBot.g:8483:2: ( ruleLanguage )
            {
            // InternalBot.g:8483:2: ( ruleLanguage )
            // InternalBot.g:8484:3: ruleLanguage
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__LanguageAssignment_1_1"


    // $ANTLR start "rule__PromptLanguage__PromptsAssignment_3"
    // InternalBot.g:8493:1: rule__PromptLanguage__PromptsAssignment_3 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8497:1: ( ( ruleEString ) )
            // InternalBot.g:8498:2: ( ruleEString )
            {
            // InternalBot.g:8498:2: ( ruleEString )
            // InternalBot.g:8499:3: ruleEString
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__PromptsAssignment_3"


    // $ANTLR start "rule__PromptLanguage__PromptsAssignment_4_1"
    // InternalBot.g:8508:1: rule__PromptLanguage__PromptsAssignment_4_1 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8512:1: ( ( ruleEString ) )
            // InternalBot.g:8513:2: ( ruleEString )
            {
            // InternalBot.g:8513:2: ( ruleEString )
            // InternalBot.g:8514:3: ruleEString
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__PromptsAssignment_4_1"


    // $ANTLR start "rule__Literal__TextAssignment"
    // InternalBot.g:8523:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8527:1: ( ( ruleEString ) )
            // InternalBot.g:8528:2: ( ruleEString )
            {
            // InternalBot.g:8528:2: ( ruleEString )
            // InternalBot.g:8529:3: ruleEString
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
    // InternalBot.g:8538:1: rule__EntityToken__EntityAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8542:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8543:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8543:2: ( ( ruleEString ) )
            // InternalBot.g:8544:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 
            // InternalBot.g:8545:3: ( ruleEString )
            // InternalBot.g:8546:4: ruleEString
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
    // InternalBot.g:8557:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8561:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8562:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8562:2: ( ( ruleEString ) )
            // InternalBot.g:8563:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:8564:3: ( ruleEString )
            // InternalBot.g:8565:4: ruleEString
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
    // InternalBot.g:8576:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8580:1: ( ( ruleEString ) )
            // InternalBot.g:8581:2: ( ruleEString )
            {
            // InternalBot.g:8581:2: ( ruleEString )
            // InternalBot.g:8582:3: ruleEString
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
    // InternalBot.g:8591:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8595:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8596:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8596:2: ( ( ruleEString ) )
            // InternalBot.g:8597:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:8598:3: ( ruleEString )
            // InternalBot.g:8599:4: ruleEString
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
    // InternalBot.g:8610:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8614:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:8615:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:8615:2: ( ruleHTTPReturnType )
            // InternalBot.g:8616:3: ruleHTTPReturnType
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
    // InternalBot.g:8625:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8629:1: ( ( ruleEString ) )
            // InternalBot.g:8630:2: ( ruleEString )
            {
            // InternalBot.g:8630:2: ( ruleEString )
            // InternalBot.g:8631:3: ruleEString
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
    // InternalBot.g:8640:1: rule__Simple__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__Simple__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8644:1: ( ( ruleEString ) )
            // InternalBot.g:8645:2: ( ruleEString )
            {
            // InternalBot.g:8645:2: ( ruleEString )
            // InternalBot.g:8646:3: ruleEString
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


    // $ANTLR start "rule__Simple__InputsAssignment_5"
    // InternalBot.g:8655:1: rule__Simple__InputsAssignment_5 : ( ruleSimpleLanguageInput ) ;
    public final void rule__Simple__InputsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8659:1: ( ( ruleSimpleLanguageInput ) )
            // InternalBot.g:8660:2: ( ruleSimpleLanguageInput )
            {
            // InternalBot.g:8660:2: ( ruleSimpleLanguageInput )
            // InternalBot.g:8661:3: ruleSimpleLanguageInput
            {
             before(grammarAccess.getSimpleAccess().getInputsSimpleLanguageInputParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleLanguageInput();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getInputsSimpleLanguageInputParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__InputsAssignment_5"


    // $ANTLR start "rule__SimpleLanguageInput__LanguageAssignment_0_2"
    // InternalBot.g:8670:1: rule__SimpleLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__SimpleLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8674:1: ( ( ruleLanguage ) )
            // InternalBot.g:8675:2: ( ruleLanguage )
            {
            // InternalBot.g:8675:2: ( ruleLanguage )
            // InternalBot.g:8676:3: ruleLanguage
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getSimpleLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__LanguageAssignment_0_2"


    // $ANTLR start "rule__SimpleLanguageInput__InputsAssignment_2_0"
    // InternalBot.g:8685:1: rule__SimpleLanguageInput__InputsAssignment_2_0 : ( ruleSimpleInput ) ;
    public final void rule__SimpleLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8689:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:8690:2: ( ruleSimpleInput )
            {
            // InternalBot.g:8690:2: ( ruleSimpleInput )
            // InternalBot.g:8691:3: ruleSimpleInput
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__InputsAssignment_2_0"


    // $ANTLR start "rule__SimpleLanguageInput__InputsAssignment_2_1"
    // InternalBot.g:8700:1: rule__SimpleLanguageInput__InputsAssignment_2_1 : ( ruleSimpleInput ) ;
    public final void rule__SimpleLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8704:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:8705:2: ( ruleSimpleInput )
            {
            // InternalBot.g:8705:2: ( ruleSimpleInput )
            // InternalBot.g:8706:3: ruleSimpleInput
            {
             before(grammarAccess.getSimpleLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleLanguageInput__InputsAssignment_2_1"


    // $ANTLR start "rule__Composite__NameAssignment_3"
    // InternalBot.g:8715:1: rule__Composite__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__Composite__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8719:1: ( ( ruleEString ) )
            // InternalBot.g:8720:2: ( ruleEString )
            {
            // InternalBot.g:8720:2: ( ruleEString )
            // InternalBot.g:8721:3: ruleEString
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


    // $ANTLR start "rule__Composite__InputsAssignment_5"
    // InternalBot.g:8730:1: rule__Composite__InputsAssignment_5 : ( ruleCompositeLanguageInput ) ;
    public final void rule__Composite__InputsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8734:1: ( ( ruleCompositeLanguageInput ) )
            // InternalBot.g:8735:2: ( ruleCompositeLanguageInput )
            {
            // InternalBot.g:8735:2: ( ruleCompositeLanguageInput )
            // InternalBot.g:8736:3: ruleCompositeLanguageInput
            {
             before(grammarAccess.getCompositeAccess().getInputsCompositeLanguageInputParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeLanguageInput();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getInputsCompositeLanguageInputParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__InputsAssignment_5"


    // $ANTLR start "rule__CompositeLanguageInput__LanguageAssignment_1_2"
    // InternalBot.g:8745:1: rule__CompositeLanguageInput__LanguageAssignment_1_2 : ( ruleLanguage ) ;
    public final void rule__CompositeLanguageInput__LanguageAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8749:1: ( ( ruleLanguage ) )
            // InternalBot.g:8750:2: ( ruleLanguage )
            {
            // InternalBot.g:8750:2: ( ruleLanguage )
            // InternalBot.g:8751:3: ruleLanguage
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getLanguageLanguageEnumRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getCompositeLanguageInputAccess().getLanguageLanguageEnumRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__LanguageAssignment_1_2"


    // $ANTLR start "rule__CompositeLanguageInput__InputsAssignment_3_0"
    // InternalBot.g:8760:1: rule__CompositeLanguageInput__InputsAssignment_3_0 : ( ruleCompositeInput ) ;
    public final void rule__CompositeLanguageInput__InputsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8764:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:8765:2: ( ruleCompositeInput )
            {
            // InternalBot.g:8765:2: ( ruleCompositeInput )
            // InternalBot.g:8766:3: ruleCompositeInput
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getInputsCompositeInputParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeLanguageInputAccess().getInputsCompositeInputParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__InputsAssignment_3_0"


    // $ANTLR start "rule__CompositeLanguageInput__InputsAssignment_3_1"
    // InternalBot.g:8775:1: rule__CompositeLanguageInput__InputsAssignment_3_1 : ( ruleCompositeInput ) ;
    public final void rule__CompositeLanguageInput__InputsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8779:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:8780:2: ( ruleCompositeInput )
            {
            // InternalBot.g:8780:2: ( ruleCompositeInput )
            // InternalBot.g:8781:3: ruleCompositeInput
            {
             before(grammarAccess.getCompositeLanguageInputAccess().getInputsCompositeInputParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeLanguageInputAccess().getInputsCompositeInputParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeLanguageInput__InputsAssignment_3_1"


    // $ANTLR start "rule__SimpleInput__NameAssignment_1"
    // InternalBot.g:8790:1: rule__SimpleInput__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8794:1: ( ( ruleEString ) )
            // InternalBot.g:8795:2: ( ruleEString )
            {
            // InternalBot.g:8795:2: ( ruleEString )
            // InternalBot.g:8796:3: ruleEString
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
    // InternalBot.g:8805:1: rule__SimpleInput__ValuesAssignment_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8809:1: ( ( ruleEString ) )
            // InternalBot.g:8810:2: ( ruleEString )
            {
            // InternalBot.g:8810:2: ( ruleEString )
            // InternalBot.g:8811:3: ruleEString
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
    // InternalBot.g:8820:1: rule__SimpleInput__ValuesAssignment_2_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8824:1: ( ( ruleEString ) )
            // InternalBot.g:8825:2: ( ruleEString )
            {
            // InternalBot.g:8825:2: ( ruleEString )
            // InternalBot.g:8826:3: ruleEString
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
    // InternalBot.g:8835:1: rule__CompositeInput__TokensAssignment_0 : ( ( rule__CompositeInput__TokensAlternatives_0_0 ) ) ;
    public final void rule__CompositeInput__TokensAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8839:1: ( ( ( rule__CompositeInput__TokensAlternatives_0_0 ) ) )
            // InternalBot.g:8840:2: ( ( rule__CompositeInput__TokensAlternatives_0_0 ) )
            {
            // InternalBot.g:8840:2: ( ( rule__CompositeInput__TokensAlternatives_0_0 ) )
            // InternalBot.g:8841:3: ( rule__CompositeInput__TokensAlternatives_0_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAlternatives_0_0()); 
            // InternalBot.g:8842:3: ( rule__CompositeInput__TokensAlternatives_0_0 )
            // InternalBot.g:8842:4: rule__CompositeInput__TokensAlternatives_0_0
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
    // InternalBot.g:8850:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8854:1: ( ( ruleEString ) )
            // InternalBot.g:8855:2: ( ruleEString )
            {
            // InternalBot.g:8855:2: ( ruleEString )
            // InternalBot.g:8856:3: ruleEString
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


    // $ANTLR start "rule__Text__InputsAssignment_4"
    // InternalBot.g:8865:1: rule__Text__InputsAssignment_4 : ( ruleTextLanguageInput ) ;
    public final void rule__Text__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8869:1: ( ( ruleTextLanguageInput ) )
            // InternalBot.g:8870:2: ( ruleTextLanguageInput )
            {
            // InternalBot.g:8870:2: ( ruleTextLanguageInput )
            // InternalBot.g:8871:3: ruleTextLanguageInput
            {
             before(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTextLanguageInput();

            state._fsp--;

             after(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__InputsAssignment_4"


    // $ANTLR start "rule__TextLanguageInput__LanguageAssignment_0_1_1"
    // InternalBot.g:8880:1: rule__TextLanguageInput__LanguageAssignment_0_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInput__LanguageAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8884:1: ( ( ruleLanguage ) )
            // InternalBot.g:8885:2: ( ruleLanguage )
            {
            // InternalBot.g:8885:2: ( ruleLanguage )
            // InternalBot.g:8886:3: ruleLanguage
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__LanguageAssignment_0_1_1"


    // $ANTLR start "rule__TextLanguageInput__InputsAssignment_2"
    // InternalBot.g:8895:1: rule__TextLanguageInput__InputsAssignment_2 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8899:1: ( ( ruleTextInputText ) )
            // InternalBot.g:8900:2: ( ruleTextInputText )
            {
            // InternalBot.g:8900:2: ( ruleTextInputText )
            // InternalBot.g:8901:3: ruleTextInputText
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__InputsAssignment_2"


    // $ANTLR start "rule__TextLanguageInput__InputsAssignment_3_1"
    // InternalBot.g:8910:1: rule__TextLanguageInput__InputsAssignment_3_1 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8914:1: ( ( ruleTextInputText ) )
            // InternalBot.g:8915:2: ( ruleTextInputText )
            {
            // InternalBot.g:8915:2: ( ruleTextInputText )
            // InternalBot.g:8916:3: ruleTextInputText
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__InputsAssignment_3_1"


    // $ANTLR start "rule__HTTPResponse__NameAssignment_1"
    // InternalBot.g:8925:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8929:1: ( ( ruleEString ) )
            // InternalBot.g:8930:2: ( ruleEString )
            {
            // InternalBot.g:8930:2: ( ruleEString )
            // InternalBot.g:8931:3: ruleEString
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
    // InternalBot.g:8940:1: rule__HTTPResponse__HTTPRequestAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8944:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8945:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8945:2: ( ( ruleEString ) )
            // InternalBot.g:8946:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0()); 
            // InternalBot.g:8947:3: ( ruleEString )
            // InternalBot.g:8948:4: ruleEString
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


    // $ANTLR start "rule__HTTPResponse__InputsAssignment_6"
    // InternalBot.g:8959:1: rule__HTTPResponse__InputsAssignment_6 : ( ruleTextLanguageInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8963:1: ( ( ruleTextLanguageInputHttpResponse ) )
            // InternalBot.g:8964:2: ( ruleTextLanguageInputHttpResponse )
            {
            // InternalBot.g:8964:2: ( ruleTextLanguageInputHttpResponse )
            // InternalBot.g:8965:3: ruleTextLanguageInputHttpResponse
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTextLanguageInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__InputsAssignment_6"


    // $ANTLR start "rule__HTTPRequest__MethodAssignment_2"
    // InternalBot.g:8974:1: rule__HTTPRequest__MethodAssignment_2 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8978:1: ( ( ruleMethod ) )
            // InternalBot.g:8979:2: ( ruleMethod )
            {
            // InternalBot.g:8979:2: ( ruleMethod )
            // InternalBot.g:8980:3: ruleMethod
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
    // InternalBot.g:8989:1: rule__HTTPRequest__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8993:1: ( ( ruleEString ) )
            // InternalBot.g:8994:2: ( ruleEString )
            {
            // InternalBot.g:8994:2: ( ruleEString )
            // InternalBot.g:8995:3: ruleEString
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
    // InternalBot.g:9004:1: rule__HTTPRequest__URLAssignment_7 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9008:1: ( ( ruleEString ) )
            // InternalBot.g:9009:2: ( ruleEString )
            {
            // InternalBot.g:9009:2: ( ruleEString )
            // InternalBot.g:9010:3: ruleEString
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
    // InternalBot.g:9019:1: rule__HTTPRequest__BasicAuthAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9023:1: ( ( ruleKeyValue ) )
            // InternalBot.g:9024:2: ( ruleKeyValue )
            {
            // InternalBot.g:9024:2: ( ruleKeyValue )
            // InternalBot.g:9025:3: ruleKeyValue
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
    // InternalBot.g:9034:1: rule__HTTPRequest__HeadersAssignment_10_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9038:1: ( ( ruleKeyValue ) )
            // InternalBot.g:9039:2: ( ruleKeyValue )
            {
            // InternalBot.g:9039:2: ( ruleKeyValue )
            // InternalBot.g:9040:3: ruleKeyValue
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
    // InternalBot.g:9049:1: rule__HTTPRequest__HeadersAssignment_10_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9053:1: ( ( ruleKeyValue ) )
            // InternalBot.g:9054:2: ( ruleKeyValue )
            {
            // InternalBot.g:9054:2: ( ruleKeyValue )
            // InternalBot.g:9055:3: ruleKeyValue
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
    // InternalBot.g:9064:1: rule__HTTPRequest__DataAssignment_11_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9068:1: ( ( ruleData ) )
            // InternalBot.g:9069:2: ( ruleData )
            {
            // InternalBot.g:9069:2: ( ruleData )
            // InternalBot.g:9070:3: ruleData
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
    // InternalBot.g:9079:1: rule__HTTPRequest__DataAssignment_11_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9083:1: ( ( ruleData ) )
            // InternalBot.g:9084:2: ( ruleData )
            {
            // InternalBot.g:9084:2: ( ruleData )
            // InternalBot.g:9085:3: ruleData
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
    // InternalBot.g:9094:1: rule__HTTPRequest__DataTypeAssignment_11_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_11_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9098:1: ( ( ruleDataType ) )
            // InternalBot.g:9099:2: ( ruleDataType )
            {
            // InternalBot.g:9099:2: ( ruleDataType )
            // InternalBot.g:9100:3: ruleDataType
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
    // InternalBot.g:9109:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9113:1: ( ( ruleEString ) )
            // InternalBot.g:9114:2: ( ruleEString )
            {
            // InternalBot.g:9114:2: ( ruleEString )
            // InternalBot.g:9115:3: ruleEString
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
    // InternalBot.g:9124:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9128:1: ( ( ruleEString ) )
            // InternalBot.g:9129:2: ( ruleEString )
            {
            // InternalBot.g:9129:2: ( ruleEString )
            // InternalBot.g:9130:3: ruleEString
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


    // $ANTLR start "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"
    // InternalBot.g:9139:1: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9143:1: ( ( ruleLanguage ) )
            // InternalBot.g:9144:2: ( ruleLanguage )
            {
            // InternalBot.g:9144:2: ( ruleLanguage )
            // InternalBot.g:9145:3: ruleLanguage
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__InputsAssignment_3"
    // InternalBot.g:9154:1: rule__TextLanguageInputHttpResponse__InputsAssignment_3 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9158:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:9159:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:9159:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:9160:3: ruleTextInputHttpResponse
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__InputsAssignment_3"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__InputsAssignment_4_1"
    // InternalBot.g:9169:1: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9173:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:9174:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:9174:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:9175:3: ruleTextInputHttpResponse
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__InputsAssignment_4_1"


    // $ANTLR start "rule__TextInputHttpResponse__TokensAssignment"
    // InternalBot.g:9184:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9188:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:9189:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:9189:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:9190:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:9191:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:9191:4: rule__TextInputHttpResponse__TokensAlternatives_0
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
    // InternalBot.g:9199:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9203:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:9204:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:9204:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:9205:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:9206:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:9206:4: rule__TextInputText__TokensAlternatives_0
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
    // InternalBot.g:9214:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9218:1: ( ( ruleEString ) )
            // InternalBot.g:9219:2: ( ruleEString )
            {
            // InternalBot.g:9219:2: ( ruleEString )
            // InternalBot.g:9220:3: ruleEString
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
    // InternalBot.g:9229:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9233:1: ( ( ruleLiteral ) )
            // InternalBot.g:9234:2: ( ruleLiteral )
            {
            // InternalBot.g:9234:2: ( ruleLiteral )
            // InternalBot.g:9235:3: ruleLiteral
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
    // InternalBot.g:9244:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9248:1: ( ( ruleEString ) )
            // InternalBot.g:9249:2: ( ruleEString )
            {
            // InternalBot.g:9249:2: ( ruleEString )
            // InternalBot.g:9250:3: ruleEString
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
    // InternalBot.g:9259:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9263:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:9264:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:9264:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:9265:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:9266:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:9266:4: rule__Data__ValueAlternatives_2_0
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
    static final String dfa_3s = "\1\102\1\103\1\4\2\66\1\4\1\72\2\66\2\uffff";
    static final String dfa_4s = "\1\102\1\103\1\5\2\104\1\5\1\101\2\104\2\uffff";
    static final String dfa_5s = "\11\uffff\1\2\1\1";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\5\15\uffff\1\6",
            "\1\5\15\uffff\1\6",
            "\1\7\1\10",
            "\1\12\2\uffff\1\11\3\uffff\1\12",
            "\1\5\15\uffff\1\6",
            "\1\5\15\uffff\1\6",
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
            return "1046:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000480L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000080L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00001FFFFFF80000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0048000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x01A0000000000030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020800L,0x0000000000050000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020802L,0x0000000000050000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0010000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xA000000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000008L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000008L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000000000000F830L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000070800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x4000000000000030L,0x0000000000000200L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000200L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000200L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0400000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000000000000800L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x2000000000000802L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000080L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000040000L,0x0000000000600000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000480L});

}