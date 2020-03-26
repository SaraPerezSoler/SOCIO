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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'text'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language:'", "'intents'", "':'", "'flows'", "','", "'entities'", "'actions'", "'-'", "';'", "'{'", "'inputs:'", "'}'", "'language'", "'parameters:'", "'user'", "'=>'", "'chatbot'", "'('", "')'", "'entity'", "'prompts'", "'['", "']'", "'in'", "'@'", "'request.'", "'.'", "'Simple'", "'Composite'", "'synonyms'", "'response'", "'text:'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'Fallback'", "'required'", "'isList'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
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

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==71||LA1_0==75) ) {
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

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==71) ) {
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

            if ( (LA3_0==77) ) {
                alt3=1;
            }
            else if ( (LA3_0==78) ) {
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
            case 84:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 82:
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
            else if ( (LA9_0==74) ) {
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
            case 71:
                {
                alt10=2;
                }
                break;
            case 75:
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
    // InternalBot.g:1121:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1125:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) )
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
                case 21 :
                    // InternalBot.g:1246:2: ( ( 'ar' ) )
                    {
                    // InternalBot.g:1246:2: ( ( 'ar' ) )
                    // InternalBot.g:1247:3: ( 'ar' )
                    {
                     before(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 
                    // InternalBot.g:1248:3: ( 'ar' )
                    // InternalBot.g:1248:4: 'ar'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:1252:2: ( ( 'cz' ) )
                    {
                    // InternalBot.g:1252:2: ( ( 'cz' ) )
                    // InternalBot.g:1253:3: ( 'cz' )
                    {
                     before(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 
                    // InternalBot.g:1254:3: ( 'cz' )
                    // InternalBot.g:1254:4: 'cz'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:1258:2: ( ( 'bu' ) )
                    {
                    // InternalBot.g:1258:2: ( ( 'bu' ) )
                    // InternalBot.g:1259:3: ( 'bu' )
                    {
                     before(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 
                    // InternalBot.g:1260:3: ( 'bu' )
                    // InternalBot.g:1260:4: 'bu'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:1264:2: ( ( 'fi' ) )
                    {
                    // InternalBot.g:1264:2: ( ( 'fi' ) )
                    // InternalBot.g:1265:3: ( 'fi' )
                    {
                     before(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 
                    // InternalBot.g:1266:3: ( 'fi' )
                    // InternalBot.g:1266:4: 'fi'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:1270:2: ( ( 'gr' ) )
                    {
                    // InternalBot.g:1270:2: ( ( 'gr' ) )
                    // InternalBot.g:1271:3: ( 'gr' )
                    {
                     before(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 
                    // InternalBot.g:1272:3: ( 'gr' )
                    // InternalBot.g:1272:4: 'gr'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:1276:2: ( ( 'ba' ) )
                    {
                    // InternalBot.g:1276:2: ( ( 'ba' ) )
                    // InternalBot.g:1277:3: ( 'ba' )
                    {
                     before(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 
                    // InternalBot.g:1278:3: ( 'ba' )
                    // InternalBot.g:1278:4: 'ba'
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
    // InternalBot.g:1286:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1290:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
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
                    // InternalBot.g:1291:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1291:2: ( ( 'JSON' ) )
                    // InternalBot.g:1292:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1293:3: ( 'JSON' )
                    // InternalBot.g:1293:4: 'JSON'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1297:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1297:2: ( ( 'FORM' ) )
                    // InternalBot.g:1298:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1299:3: ( 'FORM' )
                    // InternalBot.g:1299:4: 'FORM'
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
    // InternalBot.g:1307:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1311:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
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
                    // InternalBot.g:1312:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1312:2: ( ( 'post' ) )
                    // InternalBot.g:1313:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1314:3: ( 'post' )
                    // InternalBot.g:1314:4: 'post'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1318:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1318:2: ( ( 'get' ) )
                    // InternalBot.g:1319:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1320:3: ( 'get' )
                    // InternalBot.g:1320:4: 'get'
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
    // InternalBot.g:1328:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1332:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1333:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
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
    // InternalBot.g:1340:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1344:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1345:1: ( 'Chatbot' )
            {
            // InternalBot.g:1345:1: ( 'Chatbot' )
            // InternalBot.g:1346:2: 'Chatbot'
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
    // InternalBot.g:1355:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1359:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1360:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
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
    // InternalBot.g:1367:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1371:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1372:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1372:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1373:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1374:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1374:3: rule__Bot__NameAssignment_1
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
    // InternalBot.g:1382:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1386:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1387:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
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
    // InternalBot.g:1394:1: rule__Bot__Group__2__Impl : ( 'language:' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1398:1: ( ( 'language:' ) )
            // InternalBot.g:1399:1: ( 'language:' )
            {
            // InternalBot.g:1399:1: ( 'language:' )
            // InternalBot.g:1400:2: 'language:'
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
    // InternalBot.g:1409:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1413:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1414:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
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
    // InternalBot.g:1421:1: rule__Bot__Group__3__Impl : ( ( rule__Bot__LanguagesAssignment_3 ) ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1425:1: ( ( ( rule__Bot__LanguagesAssignment_3 ) ) )
            // InternalBot.g:1426:1: ( ( rule__Bot__LanguagesAssignment_3 ) )
            {
            // InternalBot.g:1426:1: ( ( rule__Bot__LanguagesAssignment_3 ) )
            // InternalBot.g:1427:2: ( rule__Bot__LanguagesAssignment_3 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_3()); 
            // InternalBot.g:1428:2: ( rule__Bot__LanguagesAssignment_3 )
            // InternalBot.g:1428:3: rule__Bot__LanguagesAssignment_3
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
    // InternalBot.g:1436:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1440:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1441:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
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
    // InternalBot.g:1448:1: rule__Bot__Group__4__Impl : ( ( rule__Bot__Group_4__0 )* ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1452:1: ( ( ( rule__Bot__Group_4__0 )* ) )
            // InternalBot.g:1453:1: ( ( rule__Bot__Group_4__0 )* )
            {
            // InternalBot.g:1453:1: ( ( rule__Bot__Group_4__0 )* )
            // InternalBot.g:1454:2: ( rule__Bot__Group_4__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_4()); 
            // InternalBot.g:1455:2: ( rule__Bot__Group_4__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==54) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBot.g:1455:3: rule__Bot__Group_4__0
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
    // InternalBot.g:1463:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1467:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1468:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
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
    // InternalBot.g:1475:1: rule__Bot__Group__5__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1479:1: ( ( 'intents' ) )
            // InternalBot.g:1480:1: ( 'intents' )
            {
            // InternalBot.g:1480:1: ( 'intents' )
            // InternalBot.g:1481:2: 'intents'
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
    // InternalBot.g:1490:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1494:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:1495:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
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
    // InternalBot.g:1502:1: rule__Bot__Group__6__Impl : ( ':' ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1506:1: ( ( ':' ) )
            // InternalBot.g:1507:1: ( ':' )
            {
            // InternalBot.g:1507:1: ( ':' )
            // InternalBot.g:1508:2: ':'
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
    // InternalBot.g:1517:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1521:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:1522:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
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
    // InternalBot.g:1529:1: rule__Bot__Group__7__Impl : ( ( rule__Bot__IntentsAssignment_7 ) ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1533:1: ( ( ( rule__Bot__IntentsAssignment_7 ) ) )
            // InternalBot.g:1534:1: ( ( rule__Bot__IntentsAssignment_7 ) )
            {
            // InternalBot.g:1534:1: ( ( rule__Bot__IntentsAssignment_7 ) )
            // InternalBot.g:1535:2: ( rule__Bot__IntentsAssignment_7 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_7()); 
            // InternalBot.g:1536:2: ( rule__Bot__IntentsAssignment_7 )
            // InternalBot.g:1536:3: rule__Bot__IntentsAssignment_7
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
    // InternalBot.g:1544:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1548:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:1549:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
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
    // InternalBot.g:1556:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__IntentsAssignment_8 )* ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1560:1: ( ( ( rule__Bot__IntentsAssignment_8 )* ) )
            // InternalBot.g:1561:1: ( ( rule__Bot__IntentsAssignment_8 )* )
            {
            // InternalBot.g:1561:1: ( ( rule__Bot__IntentsAssignment_8 )* )
            // InternalBot.g:1562:2: ( rule__Bot__IntentsAssignment_8 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_8()); 
            // InternalBot.g:1563:2: ( rule__Bot__IntentsAssignment_8 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:1563:3: rule__Bot__IntentsAssignment_8
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
    // InternalBot.g:1571:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1575:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:1576:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
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
    // InternalBot.g:1583:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__Group_9__0 )? ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1587:1: ( ( ( rule__Bot__Group_9__0 )? ) )
            // InternalBot.g:1588:1: ( ( rule__Bot__Group_9__0 )? )
            {
            // InternalBot.g:1588:1: ( ( rule__Bot__Group_9__0 )? )
            // InternalBot.g:1589:2: ( rule__Bot__Group_9__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_9()); 
            // InternalBot.g:1590:2: ( rule__Bot__Group_9__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==55) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:1590:3: rule__Bot__Group_9__0
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
    // InternalBot.g:1598:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1602:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:1603:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
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
    // InternalBot.g:1610:1: rule__Bot__Group__10__Impl : ( ( rule__Bot__Group_10__0 )? ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1614:1: ( ( ( rule__Bot__Group_10__0 )? ) )
            // InternalBot.g:1615:1: ( ( rule__Bot__Group_10__0 )? )
            {
            // InternalBot.g:1615:1: ( ( rule__Bot__Group_10__0 )? )
            // InternalBot.g:1616:2: ( rule__Bot__Group_10__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_10()); 
            // InternalBot.g:1617:2: ( rule__Bot__Group_10__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==56) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBot.g:1617:3: rule__Bot__Group_10__0
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
    // InternalBot.g:1625:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1629:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:1630:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
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
    // InternalBot.g:1637:1: rule__Bot__Group__11__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1641:1: ( ( 'flows' ) )
            // InternalBot.g:1642:1: ( 'flows' )
            {
            // InternalBot.g:1642:1: ( 'flows' )
            // InternalBot.g:1643:2: 'flows'
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
    // InternalBot.g:1652:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl rule__Bot__Group__13 ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1656:1: ( rule__Bot__Group__12__Impl rule__Bot__Group__13 )
            // InternalBot.g:1657:2: rule__Bot__Group__12__Impl rule__Bot__Group__13
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
    // InternalBot.g:1664:1: rule__Bot__Group__12__Impl : ( ':' ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1668:1: ( ( ':' ) )
            // InternalBot.g:1669:1: ( ':' )
            {
            // InternalBot.g:1669:1: ( ':' )
            // InternalBot.g:1670:2: ':'
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
    // InternalBot.g:1679:1: rule__Bot__Group__13 : rule__Bot__Group__13__Impl ;
    public final void rule__Bot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1683:1: ( rule__Bot__Group__13__Impl )
            // InternalBot.g:1684:2: rule__Bot__Group__13__Impl
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
    // InternalBot.g:1690:1: rule__Bot__Group__13__Impl : ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) ) ;
    public final void rule__Bot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1694:1: ( ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) ) )
            // InternalBot.g:1695:1: ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) )
            {
            // InternalBot.g:1695:1: ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) )
            // InternalBot.g:1696:2: ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* )
            {
            // InternalBot.g:1696:2: ( ( rule__Bot__Group_13__0 ) )
            // InternalBot.g:1697:3: ( rule__Bot__Group_13__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_13()); 
            // InternalBot.g:1698:3: ( rule__Bot__Group_13__0 )
            // InternalBot.g:1698:4: rule__Bot__Group_13__0
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_13__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_13()); 

            }

            // InternalBot.g:1701:2: ( ( rule__Bot__Group_13__0 )* )
            // InternalBot.g:1702:3: ( rule__Bot__Group_13__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_13()); 
            // InternalBot.g:1703:3: ( rule__Bot__Group_13__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==57) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBot.g:1703:4: rule__Bot__Group_13__0
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
    // InternalBot.g:1713:1: rule__Bot__Group_4__0 : rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1 ;
    public final void rule__Bot__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1717:1: ( rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1 )
            // InternalBot.g:1718:2: rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1
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
    // InternalBot.g:1725:1: rule__Bot__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Bot__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1729:1: ( ( ',' ) )
            // InternalBot.g:1730:1: ( ',' )
            {
            // InternalBot.g:1730:1: ( ',' )
            // InternalBot.g:1731:2: ','
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
    // InternalBot.g:1740:1: rule__Bot__Group_4__1 : rule__Bot__Group_4__1__Impl ;
    public final void rule__Bot__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1744:1: ( rule__Bot__Group_4__1__Impl )
            // InternalBot.g:1745:2: rule__Bot__Group_4__1__Impl
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
    // InternalBot.g:1751:1: rule__Bot__Group_4__1__Impl : ( ( rule__Bot__LanguagesAssignment_4_1 ) ) ;
    public final void rule__Bot__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1755:1: ( ( ( rule__Bot__LanguagesAssignment_4_1 ) ) )
            // InternalBot.g:1756:1: ( ( rule__Bot__LanguagesAssignment_4_1 ) )
            {
            // InternalBot.g:1756:1: ( ( rule__Bot__LanguagesAssignment_4_1 ) )
            // InternalBot.g:1757:2: ( rule__Bot__LanguagesAssignment_4_1 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_4_1()); 
            // InternalBot.g:1758:2: ( rule__Bot__LanguagesAssignment_4_1 )
            // InternalBot.g:1758:3: rule__Bot__LanguagesAssignment_4_1
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
    // InternalBot.g:1767:1: rule__Bot__Group_9__0 : rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 ;
    public final void rule__Bot__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1771:1: ( rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 )
            // InternalBot.g:1772:2: rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1
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
    // InternalBot.g:1779:1: rule__Bot__Group_9__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1783:1: ( ( 'entities' ) )
            // InternalBot.g:1784:1: ( 'entities' )
            {
            // InternalBot.g:1784:1: ( 'entities' )
            // InternalBot.g:1785:2: 'entities'
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
    // InternalBot.g:1794:1: rule__Bot__Group_9__1 : rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 ;
    public final void rule__Bot__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1798:1: ( rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 )
            // InternalBot.g:1799:2: rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2
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
    // InternalBot.g:1806:1: rule__Bot__Group_9__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1810:1: ( ( ':' ) )
            // InternalBot.g:1811:1: ( ':' )
            {
            // InternalBot.g:1811:1: ( ':' )
            // InternalBot.g:1812:2: ':'
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
    // InternalBot.g:1821:1: rule__Bot__Group_9__2 : rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 ;
    public final void rule__Bot__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1825:1: ( rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 )
            // InternalBot.g:1826:2: rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3
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
    // InternalBot.g:1833:1: rule__Bot__Group_9__2__Impl : ( ( rule__Bot__EntitiesAssignment_9_2 ) ) ;
    public final void rule__Bot__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1837:1: ( ( ( rule__Bot__EntitiesAssignment_9_2 ) ) )
            // InternalBot.g:1838:1: ( ( rule__Bot__EntitiesAssignment_9_2 ) )
            {
            // InternalBot.g:1838:1: ( ( rule__Bot__EntitiesAssignment_9_2 ) )
            // InternalBot.g:1839:2: ( rule__Bot__EntitiesAssignment_9_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_9_2()); 
            // InternalBot.g:1840:2: ( rule__Bot__EntitiesAssignment_9_2 )
            // InternalBot.g:1840:3: rule__Bot__EntitiesAssignment_9_2
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
    // InternalBot.g:1848:1: rule__Bot__Group_9__3 : rule__Bot__Group_9__3__Impl ;
    public final void rule__Bot__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1852:1: ( rule__Bot__Group_9__3__Impl )
            // InternalBot.g:1853:2: rule__Bot__Group_9__3__Impl
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
    // InternalBot.g:1859:1: rule__Bot__Group_9__3__Impl : ( ( rule__Bot__EntitiesAssignment_9_3 )* ) ;
    public final void rule__Bot__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1863:1: ( ( ( rule__Bot__EntitiesAssignment_9_3 )* ) )
            // InternalBot.g:1864:1: ( ( rule__Bot__EntitiesAssignment_9_3 )* )
            {
            // InternalBot.g:1864:1: ( ( rule__Bot__EntitiesAssignment_9_3 )* )
            // InternalBot.g:1865:2: ( rule__Bot__EntitiesAssignment_9_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_9_3()); 
            // InternalBot.g:1866:2: ( rule__Bot__EntitiesAssignment_9_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=77 && LA23_0<=78)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:1866:3: rule__Bot__EntitiesAssignment_9_3
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
    // InternalBot.g:1875:1: rule__Bot__Group_10__0 : rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 ;
    public final void rule__Bot__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1879:1: ( rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 )
            // InternalBot.g:1880:2: rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1
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
    // InternalBot.g:1887:1: rule__Bot__Group_10__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1891:1: ( ( 'actions' ) )
            // InternalBot.g:1892:1: ( 'actions' )
            {
            // InternalBot.g:1892:1: ( 'actions' )
            // InternalBot.g:1893:2: 'actions'
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
    // InternalBot.g:1902:1: rule__Bot__Group_10__1 : rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 ;
    public final void rule__Bot__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1906:1: ( rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 )
            // InternalBot.g:1907:2: rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2
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
    // InternalBot.g:1914:1: rule__Bot__Group_10__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1918:1: ( ( ':' ) )
            // InternalBot.g:1919:1: ( ':' )
            {
            // InternalBot.g:1919:1: ( ':' )
            // InternalBot.g:1920:2: ':'
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
    // InternalBot.g:1929:1: rule__Bot__Group_10__2 : rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 ;
    public final void rule__Bot__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1933:1: ( rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 )
            // InternalBot.g:1934:2: rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3
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
    // InternalBot.g:1941:1: rule__Bot__Group_10__2__Impl : ( ( rule__Bot__ActionsAssignment_10_2 ) ) ;
    public final void rule__Bot__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1945:1: ( ( ( rule__Bot__ActionsAssignment_10_2 ) ) )
            // InternalBot.g:1946:1: ( ( rule__Bot__ActionsAssignment_10_2 ) )
            {
            // InternalBot.g:1946:1: ( ( rule__Bot__ActionsAssignment_10_2 ) )
            // InternalBot.g:1947:2: ( rule__Bot__ActionsAssignment_10_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_10_2()); 
            // InternalBot.g:1948:2: ( rule__Bot__ActionsAssignment_10_2 )
            // InternalBot.g:1948:3: rule__Bot__ActionsAssignment_10_2
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
    // InternalBot.g:1956:1: rule__Bot__Group_10__3 : rule__Bot__Group_10__3__Impl ;
    public final void rule__Bot__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1960:1: ( rule__Bot__Group_10__3__Impl )
            // InternalBot.g:1961:2: rule__Bot__Group_10__3__Impl
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
    // InternalBot.g:1967:1: rule__Bot__Group_10__3__Impl : ( ( rule__Bot__ActionsAssignment_10_3 )* ) ;
    public final void rule__Bot__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1971:1: ( ( ( rule__Bot__ActionsAssignment_10_3 )* ) )
            // InternalBot.g:1972:1: ( ( rule__Bot__ActionsAssignment_10_3 )* )
            {
            // InternalBot.g:1972:1: ( ( rule__Bot__ActionsAssignment_10_3 )* )
            // InternalBot.g:1973:2: ( rule__Bot__ActionsAssignment_10_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_10_3()); 
            // InternalBot.g:1974:2: ( rule__Bot__ActionsAssignment_10_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==11||LA24_0==17||LA24_0==82||LA24_0==84) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:1974:3: rule__Bot__ActionsAssignment_10_3
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
    // InternalBot.g:1983:1: rule__Bot__Group_13__0 : rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1 ;
    public final void rule__Bot__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1987:1: ( rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1 )
            // InternalBot.g:1988:2: rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1
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
    // InternalBot.g:1995:1: rule__Bot__Group_13__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1999:1: ( ( '-' ) )
            // InternalBot.g:2000:1: ( '-' )
            {
            // InternalBot.g:2000:1: ( '-' )
            // InternalBot.g:2001:2: '-'
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
    // InternalBot.g:2010:1: rule__Bot__Group_13__1 : rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2 ;
    public final void rule__Bot__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2014:1: ( rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2 )
            // InternalBot.g:2015:2: rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2
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
    // InternalBot.g:2022:1: rule__Bot__Group_13__1__Impl : ( ( rule__Bot__FlowsAssignment_13_1 ) ) ;
    public final void rule__Bot__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2026:1: ( ( ( rule__Bot__FlowsAssignment_13_1 ) ) )
            // InternalBot.g:2027:1: ( ( rule__Bot__FlowsAssignment_13_1 ) )
            {
            // InternalBot.g:2027:1: ( ( rule__Bot__FlowsAssignment_13_1 ) )
            // InternalBot.g:2028:2: ( rule__Bot__FlowsAssignment_13_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_13_1()); 
            // InternalBot.g:2029:2: ( rule__Bot__FlowsAssignment_13_1 )
            // InternalBot.g:2029:3: rule__Bot__FlowsAssignment_13_1
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
    // InternalBot.g:2037:1: rule__Bot__Group_13__2 : rule__Bot__Group_13__2__Impl ;
    public final void rule__Bot__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2041:1: ( rule__Bot__Group_13__2__Impl )
            // InternalBot.g:2042:2: rule__Bot__Group_13__2__Impl
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
    // InternalBot.g:2048:1: rule__Bot__Group_13__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2052:1: ( ( ';' ) )
            // InternalBot.g:2053:1: ( ';' )
            {
            // InternalBot.g:2053:1: ( ';' )
            // InternalBot.g:2054:2: ';'
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
    // InternalBot.g:2064:1: rule__Intent__Group__0 : rule__Intent__Group__0__Impl rule__Intent__Group__1 ;
    public final void rule__Intent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2068:1: ( rule__Intent__Group__0__Impl rule__Intent__Group__1 )
            // InternalBot.g:2069:2: rule__Intent__Group__0__Impl rule__Intent__Group__1
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
    // InternalBot.g:2076:1: rule__Intent__Group__0__Impl : ( ( rule__Intent__NameAssignment_0 ) ) ;
    public final void rule__Intent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2080:1: ( ( ( rule__Intent__NameAssignment_0 ) ) )
            // InternalBot.g:2081:1: ( ( rule__Intent__NameAssignment_0 ) )
            {
            // InternalBot.g:2081:1: ( ( rule__Intent__NameAssignment_0 ) )
            // InternalBot.g:2082:2: ( rule__Intent__NameAssignment_0 )
            {
             before(grammarAccess.getIntentAccess().getNameAssignment_0()); 
            // InternalBot.g:2083:2: ( rule__Intent__NameAssignment_0 )
            // InternalBot.g:2083:3: rule__Intent__NameAssignment_0
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
    // InternalBot.g:2091:1: rule__Intent__Group__1 : rule__Intent__Group__1__Impl rule__Intent__Group__2 ;
    public final void rule__Intent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2095:1: ( rule__Intent__Group__1__Impl rule__Intent__Group__2 )
            // InternalBot.g:2096:2: rule__Intent__Group__1__Impl rule__Intent__Group__2
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
    // InternalBot.g:2103:1: rule__Intent__Group__1__Impl : ( ( rule__Intent__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2107:1: ( ( ( rule__Intent__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2108:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2108:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2109:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2110:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==90) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:2110:3: rule__Intent__FallbackIntentAssignment_1
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
    // InternalBot.g:2118:1: rule__Intent__Group__2 : rule__Intent__Group__2__Impl rule__Intent__Group__3 ;
    public final void rule__Intent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2122:1: ( rule__Intent__Group__2__Impl rule__Intent__Group__3 )
            // InternalBot.g:2123:2: rule__Intent__Group__2__Impl rule__Intent__Group__3
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
    // InternalBot.g:2130:1: rule__Intent__Group__2__Impl : ( ( rule__Intent__Group_2__0 )? ) ;
    public final void rule__Intent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2134:1: ( ( ( rule__Intent__Group_2__0 )? ) )
            // InternalBot.g:2135:1: ( ( rule__Intent__Group_2__0 )? )
            {
            // InternalBot.g:2135:1: ( ( rule__Intent__Group_2__0 )? )
            // InternalBot.g:2136:2: ( rule__Intent__Group_2__0 )?
            {
             before(grammarAccess.getIntentAccess().getGroup_2()); 
            // InternalBot.g:2137:2: ( rule__Intent__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==62) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBot.g:2137:3: rule__Intent__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getGroup_2()); 

            }


            }

        }
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
    // InternalBot.g:2145:1: rule__Intent__Group__3 : rule__Intent__Group__3__Impl rule__Intent__Group__4 ;
    public final void rule__Intent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2149:1: ( rule__Intent__Group__3__Impl rule__Intent__Group__4 )
            // InternalBot.g:2150:2: rule__Intent__Group__3__Impl rule__Intent__Group__4
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
    // InternalBot.g:2157:1: rule__Intent__Group__3__Impl : ( '{' ) ;
    public final void rule__Intent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2161:1: ( ( '{' ) )
            // InternalBot.g:2162:1: ( '{' )
            {
            // InternalBot.g:2162:1: ( '{' )
            // InternalBot.g:2163:2: '{'
            {
             before(grammarAccess.getIntentAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
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
    // InternalBot.g:2172:1: rule__Intent__Group__4 : rule__Intent__Group__4__Impl rule__Intent__Group__5 ;
    public final void rule__Intent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2176:1: ( rule__Intent__Group__4__Impl rule__Intent__Group__5 )
            // InternalBot.g:2177:2: rule__Intent__Group__4__Impl rule__Intent__Group__5
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
    // InternalBot.g:2184:1: rule__Intent__Group__4__Impl : ( 'inputs:' ) ;
    public final void rule__Intent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2188:1: ( ( 'inputs:' ) )
            // InternalBot.g:2189:1: ( 'inputs:' )
            {
            // InternalBot.g:2189:1: ( 'inputs:' )
            // InternalBot.g:2190:2: 'inputs:'
            {
             before(grammarAccess.getIntentAccess().getInputsKeyword_4()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getInputsKeyword_4()); 

            }


            }

        }
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
    // InternalBot.g:2199:1: rule__Intent__Group__5 : rule__Intent__Group__5__Impl rule__Intent__Group__6 ;
    public final void rule__Intent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2203:1: ( rule__Intent__Group__5__Impl rule__Intent__Group__6 )
            // InternalBot.g:2204:2: rule__Intent__Group__5__Impl rule__Intent__Group__6
            {
            pushFollow(FOLLOW_24);
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
    // InternalBot.g:2211:1: rule__Intent__Group__5__Impl : ( ( rule__Intent__InputsAssignment_5 ) ) ;
    public final void rule__Intent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2215:1: ( ( ( rule__Intent__InputsAssignment_5 ) ) )
            // InternalBot.g:2216:1: ( ( rule__Intent__InputsAssignment_5 ) )
            {
            // InternalBot.g:2216:1: ( ( rule__Intent__InputsAssignment_5 ) )
            // InternalBot.g:2217:2: ( rule__Intent__InputsAssignment_5 )
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_5()); 
            // InternalBot.g:2218:2: ( rule__Intent__InputsAssignment_5 )
            // InternalBot.g:2218:3: rule__Intent__InputsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Intent__InputsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getInputsAssignment_5()); 

            }


            }

        }
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
    // InternalBot.g:2226:1: rule__Intent__Group__6 : rule__Intent__Group__6__Impl rule__Intent__Group__7 ;
    public final void rule__Intent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2230:1: ( rule__Intent__Group__6__Impl rule__Intent__Group__7 )
            // InternalBot.g:2231:2: rule__Intent__Group__6__Impl rule__Intent__Group__7
            {
            pushFollow(FOLLOW_24);
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
    // InternalBot.g:2238:1: rule__Intent__Group__6__Impl : ( ( rule__Intent__Group_6__0 )* ) ;
    public final void rule__Intent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2242:1: ( ( ( rule__Intent__Group_6__0 )* ) )
            // InternalBot.g:2243:1: ( ( rule__Intent__Group_6__0 )* )
            {
            // InternalBot.g:2243:1: ( ( rule__Intent__Group_6__0 )* )
            // InternalBot.g:2244:2: ( rule__Intent__Group_6__0 )*
            {
             before(grammarAccess.getIntentAccess().getGroup_6()); 
            // InternalBot.g:2245:2: ( rule__Intent__Group_6__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==54) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBot.g:2245:3: rule__Intent__Group_6__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Intent__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

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
    // InternalBot.g:2253:1: rule__Intent__Group__7 : rule__Intent__Group__7__Impl rule__Intent__Group__8 ;
    public final void rule__Intent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2257:1: ( rule__Intent__Group__7__Impl rule__Intent__Group__8 )
            // InternalBot.g:2258:2: rule__Intent__Group__7__Impl rule__Intent__Group__8
            {
            pushFollow(FOLLOW_24);
            rule__Intent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__8();

            state._fsp--;


            }

        }
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
    // InternalBot.g:2265:1: rule__Intent__Group__7__Impl : ( ( rule__Intent__Group_7__0 )? ) ;
    public final void rule__Intent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2269:1: ( ( ( rule__Intent__Group_7__0 )? ) )
            // InternalBot.g:2270:1: ( ( rule__Intent__Group_7__0 )? )
            {
            // InternalBot.g:2270:1: ( ( rule__Intent__Group_7__0 )? )
            // InternalBot.g:2271:2: ( rule__Intent__Group_7__0 )?
            {
             before(grammarAccess.getIntentAccess().getGroup_7()); 
            // InternalBot.g:2272:2: ( rule__Intent__Group_7__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==63) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBot.g:2272:3: rule__Intent__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getGroup_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__Intent__Group__8"
    // InternalBot.g:2280:1: rule__Intent__Group__8 : rule__Intent__Group__8__Impl ;
    public final void rule__Intent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2284:1: ( rule__Intent__Group__8__Impl )
            // InternalBot.g:2285:2: rule__Intent__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__8"


    // $ANTLR start "rule__Intent__Group__8__Impl"
    // InternalBot.g:2291:1: rule__Intent__Group__8__Impl : ( '}' ) ;
    public final void rule__Intent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2295:1: ( ( '}' ) )
            // InternalBot.g:2296:1: ( '}' )
            {
            // InternalBot.g:2296:1: ( '}' )
            // InternalBot.g:2297:2: '}'
            {
             before(grammarAccess.getIntentAccess().getRightCurlyBracketKeyword_8()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__8__Impl"


    // $ANTLR start "rule__Intent__Group_2__0"
    // InternalBot.g:2307:1: rule__Intent__Group_2__0 : rule__Intent__Group_2__0__Impl rule__Intent__Group_2__1 ;
    public final void rule__Intent__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2311:1: ( rule__Intent__Group_2__0__Impl rule__Intent__Group_2__1 )
            // InternalBot.g:2312:2: rule__Intent__Group_2__0__Impl rule__Intent__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__Intent__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_2__0"


    // $ANTLR start "rule__Intent__Group_2__0__Impl"
    // InternalBot.g:2319:1: rule__Intent__Group_2__0__Impl : ( 'language' ) ;
    public final void rule__Intent__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2323:1: ( ( 'language' ) )
            // InternalBot.g:2324:1: ( 'language' )
            {
            // InternalBot.g:2324:1: ( 'language' )
            // InternalBot.g:2325:2: 'language'
            {
             before(grammarAccess.getIntentAccess().getLanguageKeyword_2_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getLanguageKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_2__0__Impl"


    // $ANTLR start "rule__Intent__Group_2__1"
    // InternalBot.g:2334:1: rule__Intent__Group_2__1 : rule__Intent__Group_2__1__Impl rule__Intent__Group_2__2 ;
    public final void rule__Intent__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2338:1: ( rule__Intent__Group_2__1__Impl rule__Intent__Group_2__2 )
            // InternalBot.g:2339:2: rule__Intent__Group_2__1__Impl rule__Intent__Group_2__2
            {
            pushFollow(FOLLOW_7);
            rule__Intent__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_2__1"


    // $ANTLR start "rule__Intent__Group_2__1__Impl"
    // InternalBot.g:2346:1: rule__Intent__Group_2__1__Impl : ( ':' ) ;
    public final void rule__Intent__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2350:1: ( ( ':' ) )
            // InternalBot.g:2351:1: ( ':' )
            {
            // InternalBot.g:2351:1: ( ':' )
            // InternalBot.g:2352:2: ':'
            {
             before(grammarAccess.getIntentAccess().getColonKeyword_2_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getColonKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_2__1__Impl"


    // $ANTLR start "rule__Intent__Group_2__2"
    // InternalBot.g:2361:1: rule__Intent__Group_2__2 : rule__Intent__Group_2__2__Impl ;
    public final void rule__Intent__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2365:1: ( rule__Intent__Group_2__2__Impl )
            // InternalBot.g:2366:2: rule__Intent__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_2__2"


    // $ANTLR start "rule__Intent__Group_2__2__Impl"
    // InternalBot.g:2372:1: rule__Intent__Group_2__2__Impl : ( ( rule__Intent__LanguageAssignment_2_2 ) ) ;
    public final void rule__Intent__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2376:1: ( ( ( rule__Intent__LanguageAssignment_2_2 ) ) )
            // InternalBot.g:2377:1: ( ( rule__Intent__LanguageAssignment_2_2 ) )
            {
            // InternalBot.g:2377:1: ( ( rule__Intent__LanguageAssignment_2_2 ) )
            // InternalBot.g:2378:2: ( rule__Intent__LanguageAssignment_2_2 )
            {
             before(grammarAccess.getIntentAccess().getLanguageAssignment_2_2()); 
            // InternalBot.g:2379:2: ( rule__Intent__LanguageAssignment_2_2 )
            // InternalBot.g:2379:3: rule__Intent__LanguageAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Intent__LanguageAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getLanguageAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_2__2__Impl"


    // $ANTLR start "rule__Intent__Group_6__0"
    // InternalBot.g:2388:1: rule__Intent__Group_6__0 : rule__Intent__Group_6__0__Impl rule__Intent__Group_6__1 ;
    public final void rule__Intent__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2392:1: ( rule__Intent__Group_6__0__Impl rule__Intent__Group_6__1 )
            // InternalBot.g:2393:2: rule__Intent__Group_6__0__Impl rule__Intent__Group_6__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalBot.g:2400:1: rule__Intent__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Intent__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2404:1: ( ( ',' ) )
            // InternalBot.g:2405:1: ( ',' )
            {
            // InternalBot.g:2405:1: ( ',' )
            // InternalBot.g:2406:2: ','
            {
             before(grammarAccess.getIntentAccess().getCommaKeyword_6_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getCommaKeyword_6_0()); 

            }


            }

        }
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
    // InternalBot.g:2415:1: rule__Intent__Group_6__1 : rule__Intent__Group_6__1__Impl ;
    public final void rule__Intent__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2419:1: ( rule__Intent__Group_6__1__Impl )
            // InternalBot.g:2420:2: rule__Intent__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_6__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalBot.g:2426:1: rule__Intent__Group_6__1__Impl : ( ( rule__Intent__InputsAssignment_6_1 ) ) ;
    public final void rule__Intent__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2430:1: ( ( ( rule__Intent__InputsAssignment_6_1 ) ) )
            // InternalBot.g:2431:1: ( ( rule__Intent__InputsAssignment_6_1 ) )
            {
            // InternalBot.g:2431:1: ( ( rule__Intent__InputsAssignment_6_1 ) )
            // InternalBot.g:2432:2: ( rule__Intent__InputsAssignment_6_1 )
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_6_1()); 
            // InternalBot.g:2433:2: ( rule__Intent__InputsAssignment_6_1 )
            // InternalBot.g:2433:3: rule__Intent__InputsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent__InputsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getInputsAssignment_6_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Intent__Group_7__0"
    // InternalBot.g:2442:1: rule__Intent__Group_7__0 : rule__Intent__Group_7__0__Impl rule__Intent__Group_7__1 ;
    public final void rule__Intent__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2446:1: ( rule__Intent__Group_7__0__Impl rule__Intent__Group_7__1 )
            // InternalBot.g:2447:2: rule__Intent__Group_7__0__Impl rule__Intent__Group_7__1
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_7__0"


    // $ANTLR start "rule__Intent__Group_7__0__Impl"
    // InternalBot.g:2454:1: rule__Intent__Group_7__0__Impl : ( 'parameters:' ) ;
    public final void rule__Intent__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2458:1: ( ( 'parameters:' ) )
            // InternalBot.g:2459:1: ( 'parameters:' )
            {
            // InternalBot.g:2459:1: ( 'parameters:' )
            // InternalBot.g:2460:2: 'parameters:'
            {
             before(grammarAccess.getIntentAccess().getParametersKeyword_7_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getParametersKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_7__0__Impl"


    // $ANTLR start "rule__Intent__Group_7__1"
    // InternalBot.g:2469:1: rule__Intent__Group_7__1 : rule__Intent__Group_7__1__Impl rule__Intent__Group_7__2 ;
    public final void rule__Intent__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2473:1: ( rule__Intent__Group_7__1__Impl rule__Intent__Group_7__2 )
            // InternalBot.g:2474:2: rule__Intent__Group_7__1__Impl rule__Intent__Group_7__2
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_7__1"


    // $ANTLR start "rule__Intent__Group_7__1__Impl"
    // InternalBot.g:2481:1: rule__Intent__Group_7__1__Impl : ( ( rule__Intent__ParametersAssignment_7_1 ) ) ;
    public final void rule__Intent__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2485:1: ( ( ( rule__Intent__ParametersAssignment_7_1 ) ) )
            // InternalBot.g:2486:1: ( ( rule__Intent__ParametersAssignment_7_1 ) )
            {
            // InternalBot.g:2486:1: ( ( rule__Intent__ParametersAssignment_7_1 ) )
            // InternalBot.g:2487:2: ( rule__Intent__ParametersAssignment_7_1 )
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_7_1()); 
            // InternalBot.g:2488:2: ( rule__Intent__ParametersAssignment_7_1 )
            // InternalBot.g:2488:3: rule__Intent__ParametersAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent__ParametersAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getParametersAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_7__1__Impl"


    // $ANTLR start "rule__Intent__Group_7__2"
    // InternalBot.g:2496:1: rule__Intent__Group_7__2 : rule__Intent__Group_7__2__Impl ;
    public final void rule__Intent__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2500:1: ( rule__Intent__Group_7__2__Impl )
            // InternalBot.g:2501:2: rule__Intent__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_7__2"


    // $ANTLR start "rule__Intent__Group_7__2__Impl"
    // InternalBot.g:2507:1: rule__Intent__Group_7__2__Impl : ( ( rule__Intent__ParametersAssignment_7_2 )* ) ;
    public final void rule__Intent__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2511:1: ( ( ( rule__Intent__ParametersAssignment_7_2 )* ) )
            // InternalBot.g:2512:1: ( ( rule__Intent__ParametersAssignment_7_2 )* )
            {
            // InternalBot.g:2512:1: ( ( rule__Intent__ParametersAssignment_7_2 )* )
            // InternalBot.g:2513:2: ( rule__Intent__ParametersAssignment_7_2 )*
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_7_2()); 
            // InternalBot.g:2514:2: ( rule__Intent__ParametersAssignment_7_2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_ID)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalBot.g:2514:3: rule__Intent__ParametersAssignment_7_2
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent__ParametersAssignment_7_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getParametersAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_7__2__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalBot.g:2523:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2527:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:2528:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
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
    // InternalBot.g:2535:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2539:1: ( ( 'user' ) )
            // InternalBot.g:2540:1: ( 'user' )
            {
            // InternalBot.g:2540:1: ( 'user' )
            // InternalBot.g:2541:2: 'user'
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
    // InternalBot.g:2550:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2554:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:2555:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
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
    // InternalBot.g:2562:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2566:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:2567:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:2567:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:2568:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:2569:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:2569:3: rule__Transition__IntentAssignment_1
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
    // InternalBot.g:2577:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2581:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:2582:2: rule__Transition__Group__2__Impl
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
    // InternalBot.g:2588:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2592:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:2593:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:2593:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:2594:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:2595:2: ( rule__Transition__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==65) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:2595:3: rule__Transition__Group_2__0
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
    // InternalBot.g:2604:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2608:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:2609:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
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
    // InternalBot.g:2616:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2620:1: ( ( '=>' ) )
            // InternalBot.g:2621:1: ( '=>' )
            {
            // InternalBot.g:2621:1: ( '=>' )
            // InternalBot.g:2622:2: '=>'
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
    // InternalBot.g:2631:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2635:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:2636:2: rule__Transition__Group_2__1__Impl
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
    // InternalBot.g:2642:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2646:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:2647:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:2647:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:2648:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:2649:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:2649:3: rule__Transition__TargetAssignment_2_1
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
    // InternalBot.g:2658:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2662:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:2663:2: rule__State__Group__0__Impl rule__State__Group__1
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
    // InternalBot.g:2670:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2674:1: ( ( 'chatbot' ) )
            // InternalBot.g:2675:1: ( 'chatbot' )
            {
            // InternalBot.g:2675:1: ( 'chatbot' )
            // InternalBot.g:2676:2: 'chatbot'
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
    // InternalBot.g:2685:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2689:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:2690:2: rule__State__Group__1__Impl rule__State__Group__2
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
    // InternalBot.g:2697:1: rule__State__Group__1__Impl : ( '(' ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2701:1: ( ( '(' ) )
            // InternalBot.g:2702:1: ( '(' )
            {
            // InternalBot.g:2702:1: ( '(' )
            // InternalBot.g:2703:2: '('
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
    // InternalBot.g:2712:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2716:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:2717:2: rule__State__Group__2__Impl rule__State__Group__3
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
    // InternalBot.g:2724:1: rule__State__Group__2__Impl : ( ( rule__State__ActionsAssignment_2 ) ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2728:1: ( ( ( rule__State__ActionsAssignment_2 ) ) )
            // InternalBot.g:2729:1: ( ( rule__State__ActionsAssignment_2 ) )
            {
            // InternalBot.g:2729:1: ( ( rule__State__ActionsAssignment_2 ) )
            // InternalBot.g:2730:2: ( rule__State__ActionsAssignment_2 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2()); 
            // InternalBot.g:2731:2: ( rule__State__ActionsAssignment_2 )
            // InternalBot.g:2731:3: rule__State__ActionsAssignment_2
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
    // InternalBot.g:2739:1: rule__State__Group__3 : rule__State__Group__3__Impl rule__State__Group__4 ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2743:1: ( rule__State__Group__3__Impl rule__State__Group__4 )
            // InternalBot.g:2744:2: rule__State__Group__3__Impl rule__State__Group__4
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
    // InternalBot.g:2751:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )* ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2755:1: ( ( ( rule__State__Group_3__0 )* ) )
            // InternalBot.g:2756:1: ( ( rule__State__Group_3__0 )* )
            {
            // InternalBot.g:2756:1: ( ( rule__State__Group_3__0 )* )
            // InternalBot.g:2757:2: ( rule__State__Group_3__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:2758:2: ( rule__State__Group_3__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==54) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBot.g:2758:3: rule__State__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__State__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalBot.g:2766:1: rule__State__Group__4 : rule__State__Group__4__Impl rule__State__Group__5 ;
    public final void rule__State__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2770:1: ( rule__State__Group__4__Impl rule__State__Group__5 )
            // InternalBot.g:2771:2: rule__State__Group__4__Impl rule__State__Group__5
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
    // InternalBot.g:2778:1: rule__State__Group__4__Impl : ( ')' ) ;
    public final void rule__State__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2782:1: ( ( ')' ) )
            // InternalBot.g:2783:1: ( ')' )
            {
            // InternalBot.g:2783:1: ( ')' )
            // InternalBot.g:2784:2: ')'
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
    // InternalBot.g:2793:1: rule__State__Group__5 : rule__State__Group__5__Impl ;
    public final void rule__State__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2797:1: ( rule__State__Group__5__Impl )
            // InternalBot.g:2798:2: rule__State__Group__5__Impl
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
    // InternalBot.g:2804:1: rule__State__Group__5__Impl : ( ( rule__State__Group_5__0 )? ) ;
    public final void rule__State__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2808:1: ( ( ( rule__State__Group_5__0 )? ) )
            // InternalBot.g:2809:1: ( ( rule__State__Group_5__0 )? )
            {
            // InternalBot.g:2809:1: ( ( rule__State__Group_5__0 )? )
            // InternalBot.g:2810:2: ( rule__State__Group_5__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_5()); 
            // InternalBot.g:2811:2: ( rule__State__Group_5__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==65) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBot.g:2811:3: rule__State__Group_5__0
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
    // InternalBot.g:2820:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2824:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:2825:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
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
    // InternalBot.g:2832:1: rule__State__Group_3__0__Impl : ( ',' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2836:1: ( ( ',' ) )
            // InternalBot.g:2837:1: ( ',' )
            {
            // InternalBot.g:2837:1: ( ',' )
            // InternalBot.g:2838:2: ','
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
    // InternalBot.g:2847:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2851:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:2852:2: rule__State__Group_3__1__Impl
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
    // InternalBot.g:2858:1: rule__State__Group_3__1__Impl : ( ( rule__State__ActionsAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2862:1: ( ( ( rule__State__ActionsAssignment_3_1 ) ) )
            // InternalBot.g:2863:1: ( ( rule__State__ActionsAssignment_3_1 ) )
            {
            // InternalBot.g:2863:1: ( ( rule__State__ActionsAssignment_3_1 ) )
            // InternalBot.g:2864:2: ( rule__State__ActionsAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_3_1()); 
            // InternalBot.g:2865:2: ( rule__State__ActionsAssignment_3_1 )
            // InternalBot.g:2865:3: rule__State__ActionsAssignment_3_1
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
    // InternalBot.g:2874:1: rule__State__Group_5__0 : rule__State__Group_5__0__Impl rule__State__Group_5__1 ;
    public final void rule__State__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2878:1: ( rule__State__Group_5__0__Impl rule__State__Group_5__1 )
            // InternalBot.g:2879:2: rule__State__Group_5__0__Impl rule__State__Group_5__1
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
    // InternalBot.g:2886:1: rule__State__Group_5__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2890:1: ( ( '=>' ) )
            // InternalBot.g:2891:1: ( '=>' )
            {
            // InternalBot.g:2891:1: ( '=>' )
            // InternalBot.g:2892:2: '=>'
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
    // InternalBot.g:2901:1: rule__State__Group_5__1 : rule__State__Group_5__1__Impl ;
    public final void rule__State__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2905:1: ( rule__State__Group_5__1__Impl )
            // InternalBot.g:2906:2: rule__State__Group_5__1__Impl
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
    // InternalBot.g:2912:1: rule__State__Group_5__1__Impl : ( ( rule__State__OutcomingAssignment_5_1 ) ) ;
    public final void rule__State__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2916:1: ( ( ( rule__State__OutcomingAssignment_5_1 ) ) )
            // InternalBot.g:2917:1: ( ( rule__State__OutcomingAssignment_5_1 ) )
            {
            // InternalBot.g:2917:1: ( ( rule__State__OutcomingAssignment_5_1 ) )
            // InternalBot.g:2918:2: ( rule__State__OutcomingAssignment_5_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_5_1()); 
            // InternalBot.g:2919:2: ( rule__State__OutcomingAssignment_5_1 )
            // InternalBot.g:2919:3: rule__State__OutcomingAssignment_5_1
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
    // InternalBot.g:2928:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2932:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:2933:2: rule__State2__Group__0__Impl rule__State2__Group__1
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
    // InternalBot.g:2940:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2944:1: ( ( 'chatbot' ) )
            // InternalBot.g:2945:1: ( 'chatbot' )
            {
            // InternalBot.g:2945:1: ( 'chatbot' )
            // InternalBot.g:2946:2: 'chatbot'
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
    // InternalBot.g:2955:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2959:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:2960:2: rule__State2__Group__1__Impl rule__State2__Group__2
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
    // InternalBot.g:2967:1: rule__State2__Group__1__Impl : ( '(' ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2971:1: ( ( '(' ) )
            // InternalBot.g:2972:1: ( '(' )
            {
            // InternalBot.g:2972:1: ( '(' )
            // InternalBot.g:2973:2: '('
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
    // InternalBot.g:2982:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2986:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:2987:2: rule__State2__Group__2__Impl rule__State2__Group__3
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
    // InternalBot.g:2994:1: rule__State2__Group__2__Impl : ( ( rule__State2__ActionsAssignment_2 ) ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2998:1: ( ( ( rule__State2__ActionsAssignment_2 ) ) )
            // InternalBot.g:2999:1: ( ( rule__State2__ActionsAssignment_2 ) )
            {
            // InternalBot.g:2999:1: ( ( rule__State2__ActionsAssignment_2 ) )
            // InternalBot.g:3000:2: ( rule__State2__ActionsAssignment_2 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2()); 
            // InternalBot.g:3001:2: ( rule__State2__ActionsAssignment_2 )
            // InternalBot.g:3001:3: rule__State2__ActionsAssignment_2
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
    // InternalBot.g:3009:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3013:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:3014:2: rule__State2__Group__3__Impl rule__State2__Group__4
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
    // InternalBot.g:3021:1: rule__State2__Group__3__Impl : ( ( rule__State2__Group_3__0 )* ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3025:1: ( ( ( rule__State2__Group_3__0 )* ) )
            // InternalBot.g:3026:1: ( ( rule__State2__Group_3__0 )* )
            {
            // InternalBot.g:3026:1: ( ( rule__State2__Group_3__0 )* )
            // InternalBot.g:3027:2: ( rule__State2__Group_3__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_3()); 
            // InternalBot.g:3028:2: ( rule__State2__Group_3__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==54) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBot.g:3028:3: rule__State2__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__State2__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalBot.g:3036:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3040:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:3041:2: rule__State2__Group__4__Impl rule__State2__Group__5
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
    // InternalBot.g:3048:1: rule__State2__Group__4__Impl : ( ')' ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3052:1: ( ( ')' ) )
            // InternalBot.g:3053:1: ( ')' )
            {
            // InternalBot.g:3053:1: ( ')' )
            // InternalBot.g:3054:2: ')'
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
    // InternalBot.g:3063:1: rule__State2__Group__5 : rule__State2__Group__5__Impl rule__State2__Group__6 ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3067:1: ( rule__State2__Group__5__Impl rule__State2__Group__6 )
            // InternalBot.g:3068:2: rule__State2__Group__5__Impl rule__State2__Group__6
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
    // InternalBot.g:3075:1: rule__State2__Group__5__Impl : ( '{' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3079:1: ( ( '{' ) )
            // InternalBot.g:3080:1: ( '{' )
            {
            // InternalBot.g:3080:1: ( '{' )
            // InternalBot.g:3081:2: '{'
            {
             before(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5()); 
            match(input,59,FOLLOW_2); 
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
    // InternalBot.g:3090:1: rule__State2__Group__6 : rule__State2__Group__6__Impl rule__State2__Group__7 ;
    public final void rule__State2__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3094:1: ( rule__State2__Group__6__Impl rule__State2__Group__7 )
            // InternalBot.g:3095:2: rule__State2__Group__6__Impl rule__State2__Group__7
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
    // InternalBot.g:3102:1: rule__State2__Group__6__Impl : ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) ) ;
    public final void rule__State2__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3106:1: ( ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) ) )
            // InternalBot.g:3107:1: ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) )
            {
            // InternalBot.g:3107:1: ( ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* ) )
            // InternalBot.g:3108:2: ( ( rule__State2__Group_6__0 ) ) ( ( rule__State2__Group_6__0 )* )
            {
            // InternalBot.g:3108:2: ( ( rule__State2__Group_6__0 ) )
            // InternalBot.g:3109:3: ( rule__State2__Group_6__0 )
            {
             before(grammarAccess.getState2Access().getGroup_6()); 
            // InternalBot.g:3110:3: ( rule__State2__Group_6__0 )
            // InternalBot.g:3110:4: rule__State2__Group_6__0
            {
            pushFollow(FOLLOW_31);
            rule__State2__Group_6__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_6()); 

            }

            // InternalBot.g:3113:2: ( ( rule__State2__Group_6__0 )* )
            // InternalBot.g:3114:3: ( rule__State2__Group_6__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_6()); 
            // InternalBot.g:3115:3: ( rule__State2__Group_6__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==65) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:3115:4: rule__State2__Group_6__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__State2__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalBot.g:3124:1: rule__State2__Group__7 : rule__State2__Group__7__Impl ;
    public final void rule__State2__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3128:1: ( rule__State2__Group__7__Impl )
            // InternalBot.g:3129:2: rule__State2__Group__7__Impl
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
    // InternalBot.g:3135:1: rule__State2__Group__7__Impl : ( '}' ) ;
    public final void rule__State2__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3139:1: ( ( '}' ) )
            // InternalBot.g:3140:1: ( '}' )
            {
            // InternalBot.g:3140:1: ( '}' )
            // InternalBot.g:3141:2: '}'
            {
             before(grammarAccess.getState2Access().getRightCurlyBracketKeyword_7()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:3151:1: rule__State2__Group_3__0 : rule__State2__Group_3__0__Impl rule__State2__Group_3__1 ;
    public final void rule__State2__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3155:1: ( rule__State2__Group_3__0__Impl rule__State2__Group_3__1 )
            // InternalBot.g:3156:2: rule__State2__Group_3__0__Impl rule__State2__Group_3__1
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
    // InternalBot.g:3163:1: rule__State2__Group_3__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3167:1: ( ( ',' ) )
            // InternalBot.g:3168:1: ( ',' )
            {
            // InternalBot.g:3168:1: ( ',' )
            // InternalBot.g:3169:2: ','
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
    // InternalBot.g:3178:1: rule__State2__Group_3__1 : rule__State2__Group_3__1__Impl ;
    public final void rule__State2__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3182:1: ( rule__State2__Group_3__1__Impl )
            // InternalBot.g:3183:2: rule__State2__Group_3__1__Impl
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
    // InternalBot.g:3189:1: rule__State2__Group_3__1__Impl : ( ( rule__State2__ActionsAssignment_3_1 ) ) ;
    public final void rule__State2__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3193:1: ( ( ( rule__State2__ActionsAssignment_3_1 ) ) )
            // InternalBot.g:3194:1: ( ( rule__State2__ActionsAssignment_3_1 ) )
            {
            // InternalBot.g:3194:1: ( ( rule__State2__ActionsAssignment_3_1 ) )
            // InternalBot.g:3195:2: ( rule__State2__ActionsAssignment_3_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_3_1()); 
            // InternalBot.g:3196:2: ( rule__State2__ActionsAssignment_3_1 )
            // InternalBot.g:3196:3: rule__State2__ActionsAssignment_3_1
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
    // InternalBot.g:3205:1: rule__State2__Group_6__0 : rule__State2__Group_6__0__Impl rule__State2__Group_6__1 ;
    public final void rule__State2__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3209:1: ( rule__State2__Group_6__0__Impl rule__State2__Group_6__1 )
            // InternalBot.g:3210:2: rule__State2__Group_6__0__Impl rule__State2__Group_6__1
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
    // InternalBot.g:3217:1: rule__State2__Group_6__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3221:1: ( ( '=>' ) )
            // InternalBot.g:3222:1: ( '=>' )
            {
            // InternalBot.g:3222:1: ( '=>' )
            // InternalBot.g:3223:2: '=>'
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
    // InternalBot.g:3232:1: rule__State2__Group_6__1 : rule__State2__Group_6__1__Impl rule__State2__Group_6__2 ;
    public final void rule__State2__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3236:1: ( rule__State2__Group_6__1__Impl rule__State2__Group_6__2 )
            // InternalBot.g:3237:2: rule__State2__Group_6__1__Impl rule__State2__Group_6__2
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
    // InternalBot.g:3244:1: rule__State2__Group_6__1__Impl : ( ( rule__State2__OutcomingAssignment_6_1 ) ) ;
    public final void rule__State2__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3248:1: ( ( ( rule__State2__OutcomingAssignment_6_1 ) ) )
            // InternalBot.g:3249:1: ( ( rule__State2__OutcomingAssignment_6_1 ) )
            {
            // InternalBot.g:3249:1: ( ( rule__State2__OutcomingAssignment_6_1 ) )
            // InternalBot.g:3250:2: ( rule__State2__OutcomingAssignment_6_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_6_1()); 
            // InternalBot.g:3251:2: ( rule__State2__OutcomingAssignment_6_1 )
            // InternalBot.g:3251:3: rule__State2__OutcomingAssignment_6_1
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
    // InternalBot.g:3259:1: rule__State2__Group_6__2 : rule__State2__Group_6__2__Impl ;
    public final void rule__State2__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3263:1: ( rule__State2__Group_6__2__Impl )
            // InternalBot.g:3264:2: rule__State2__Group_6__2__Impl
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
    // InternalBot.g:3270:1: rule__State2__Group_6__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3274:1: ( ( ';' ) )
            // InternalBot.g:3275:1: ( ';' )
            {
            // InternalBot.g:3275:1: ( ';' )
            // InternalBot.g:3276:2: ';'
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
    // InternalBot.g:3286:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3290:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3291:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalBot.g:3298:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3302:1: ( ( () ) )
            // InternalBot.g:3303:1: ( () )
            {
            // InternalBot.g:3303:1: ( () )
            // InternalBot.g:3304:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3305:2: ()
            // InternalBot.g:3305:3: 
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
    // InternalBot.g:3313:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3317:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3318:2: rule__TrainingPhrase__Group__1__Impl
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
    // InternalBot.g:3324:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3328:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3329:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3329:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3330:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3330:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3331:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3332:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3332:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_32);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3335:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3336:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3337:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_ID)||LA35_0==67) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBot.g:3337:4: rule__TrainingPhrase__TokensAssignment_1
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__TrainingPhrase__TokensAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalBot.g:3347:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3351:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3352:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
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
    // InternalBot.g:3359:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3363:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3364:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3364:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3365:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3366:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3366:3: rule__Parameter__NameAssignment_0
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
    // InternalBot.g:3374:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3378:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3379:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
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
    // InternalBot.g:3386:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3390:1: ( ( ':' ) )
            // InternalBot.g:3391:1: ( ':' )
            {
            // InternalBot.g:3391:1: ( ':' )
            // InternalBot.g:3392:2: ':'
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
    // InternalBot.g:3401:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3405:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3406:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
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
    // InternalBot.g:3413:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3417:1: ( ( 'entity' ) )
            // InternalBot.g:3418:1: ( 'entity' )
            {
            // InternalBot.g:3418:1: ( 'entity' )
            // InternalBot.g:3419:2: 'entity'
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
    // InternalBot.g:3428:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3432:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:3433:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
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
    // InternalBot.g:3440:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3444:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:3445:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:3445:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:3446:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:3447:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:3447:3: rule__Parameter__Alternatives_3
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
    // InternalBot.g:3455:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3459:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:3460:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
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
    // InternalBot.g:3467:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3471:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:3472:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:3472:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:3473:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:3474:2: ( rule__Parameter__Group_4__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==54) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==91) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // InternalBot.g:3474:3: rule__Parameter__Group_4__0
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
    // InternalBot.g:3482:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3486:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:3487:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
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
    // InternalBot.g:3494:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3498:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:3499:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:3499:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:3500:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:3501:2: ( rule__Parameter__Group_5__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==54) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:3501:3: rule__Parameter__Group_5__0
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
    // InternalBot.g:3509:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3513:1: ( rule__Parameter__Group__6__Impl )
            // InternalBot.g:3514:2: rule__Parameter__Group__6__Impl
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
    // InternalBot.g:3520:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3524:1: ( ( ';' ) )
            // InternalBot.g:3525:1: ( ';' )
            {
            // InternalBot.g:3525:1: ( ';' )
            // InternalBot.g:3526:2: ';'
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
    // InternalBot.g:3536:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3540:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:3541:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
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
    // InternalBot.g:3548:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3552:1: ( ( ',' ) )
            // InternalBot.g:3553:1: ( ',' )
            {
            // InternalBot.g:3553:1: ( ',' )
            // InternalBot.g:3554:2: ','
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
    // InternalBot.g:3563:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3567:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // InternalBot.g:3568:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
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
    // InternalBot.g:3575:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__RequiredAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3579:1: ( ( ( rule__Parameter__RequiredAssignment_4_1 ) ) )
            // InternalBot.g:3580:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            {
            // InternalBot.g:3580:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            // InternalBot.g:3581:2: ( rule__Parameter__RequiredAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_4_1()); 
            // InternalBot.g:3582:2: ( rule__Parameter__RequiredAssignment_4_1 )
            // InternalBot.g:3582:3: rule__Parameter__RequiredAssignment_4_1
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
    // InternalBot.g:3590:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3594:1: ( rule__Parameter__Group_4__2__Impl )
            // InternalBot.g:3595:2: rule__Parameter__Group_4__2__Impl
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
    // InternalBot.g:3601:1: rule__Parameter__Group_4__2__Impl : ( ( rule__Parameter__Group_4_2__0 )? ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3605:1: ( ( ( rule__Parameter__Group_4_2__0 )? ) )
            // InternalBot.g:3606:1: ( ( rule__Parameter__Group_4_2__0 )? )
            {
            // InternalBot.g:3606:1: ( ( rule__Parameter__Group_4_2__0 )? )
            // InternalBot.g:3607:2: ( rule__Parameter__Group_4_2__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4_2()); 
            // InternalBot.g:3608:2: ( rule__Parameter__Group_4_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==54) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==70) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:3608:3: rule__Parameter__Group_4_2__0
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
    // InternalBot.g:3617:1: rule__Parameter__Group_4_2__0 : rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1 ;
    public final void rule__Parameter__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3621:1: ( rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1 )
            // InternalBot.g:3622:2: rule__Parameter__Group_4_2__0__Impl rule__Parameter__Group_4_2__1
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
    // InternalBot.g:3629:1: rule__Parameter__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3633:1: ( ( ',' ) )
            // InternalBot.g:3634:1: ( ',' )
            {
            // InternalBot.g:3634:1: ( ',' )
            // InternalBot.g:3635:2: ','
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
    // InternalBot.g:3644:1: rule__Parameter__Group_4_2__1 : rule__Parameter__Group_4_2__1__Impl rule__Parameter__Group_4_2__2 ;
    public final void rule__Parameter__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3648:1: ( rule__Parameter__Group_4_2__1__Impl rule__Parameter__Group_4_2__2 )
            // InternalBot.g:3649:2: rule__Parameter__Group_4_2__1__Impl rule__Parameter__Group_4_2__2
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
    // InternalBot.g:3656:1: rule__Parameter__Group_4_2__1__Impl : ( 'prompts' ) ;
    public final void rule__Parameter__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3660:1: ( ( 'prompts' ) )
            // InternalBot.g:3661:1: ( 'prompts' )
            {
            // InternalBot.g:3661:1: ( 'prompts' )
            // InternalBot.g:3662:2: 'prompts'
            {
             before(grammarAccess.getParameterAccess().getPromptsKeyword_4_2_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalBot.g:3671:1: rule__Parameter__Group_4_2__2 : rule__Parameter__Group_4_2__2__Impl rule__Parameter__Group_4_2__3 ;
    public final void rule__Parameter__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3675:1: ( rule__Parameter__Group_4_2__2__Impl rule__Parameter__Group_4_2__3 )
            // InternalBot.g:3676:2: rule__Parameter__Group_4_2__2__Impl rule__Parameter__Group_4_2__3
            {
            pushFollow(FOLLOW_39);
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
    // InternalBot.g:3683:1: rule__Parameter__Group_4_2__2__Impl : ( ( rule__Parameter__Group_4_2_2__0 )? ) ;
    public final void rule__Parameter__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3687:1: ( ( ( rule__Parameter__Group_4_2_2__0 )? ) )
            // InternalBot.g:3688:1: ( ( rule__Parameter__Group_4_2_2__0 )? )
            {
            // InternalBot.g:3688:1: ( ( rule__Parameter__Group_4_2_2__0 )? )
            // InternalBot.g:3689:2: ( rule__Parameter__Group_4_2_2__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4_2_2()); 
            // InternalBot.g:3690:2: ( rule__Parameter__Group_4_2_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==73) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:3690:3: rule__Parameter__Group_4_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_4_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_4_2_2()); 

            }


            }

        }
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
    // InternalBot.g:3698:1: rule__Parameter__Group_4_2__3 : rule__Parameter__Group_4_2__3__Impl rule__Parameter__Group_4_2__4 ;
    public final void rule__Parameter__Group_4_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3702:1: ( rule__Parameter__Group_4_2__3__Impl rule__Parameter__Group_4_2__4 )
            // InternalBot.g:3703:2: rule__Parameter__Group_4_2__3__Impl rule__Parameter__Group_4_2__4
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:3710:1: rule__Parameter__Group_4_2__3__Impl : ( '[' ) ;
    public final void rule__Parameter__Group_4_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3714:1: ( ( '[' ) )
            // InternalBot.g:3715:1: ( '[' )
            {
            // InternalBot.g:3715:1: ( '[' )
            // InternalBot.g:3716:2: '['
            {
             before(grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_4_2_3()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_4_2_3()); 

            }


            }

        }
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
    // InternalBot.g:3725:1: rule__Parameter__Group_4_2__4 : rule__Parameter__Group_4_2__4__Impl rule__Parameter__Group_4_2__5 ;
    public final void rule__Parameter__Group_4_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3729:1: ( rule__Parameter__Group_4_2__4__Impl rule__Parameter__Group_4_2__5 )
            // InternalBot.g:3730:2: rule__Parameter__Group_4_2__4__Impl rule__Parameter__Group_4_2__5
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
    // InternalBot.g:3737:1: rule__Parameter__Group_4_2__4__Impl : ( ( rule__Parameter__PromptsAssignment_4_2_4 ) ) ;
    public final void rule__Parameter__Group_4_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3741:1: ( ( ( rule__Parameter__PromptsAssignment_4_2_4 ) ) )
            // InternalBot.g:3742:1: ( ( rule__Parameter__PromptsAssignment_4_2_4 ) )
            {
            // InternalBot.g:3742:1: ( ( rule__Parameter__PromptsAssignment_4_2_4 ) )
            // InternalBot.g:3743:2: ( rule__Parameter__PromptsAssignment_4_2_4 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_4()); 
            // InternalBot.g:3744:2: ( rule__Parameter__PromptsAssignment_4_2_4 )
            // InternalBot.g:3744:3: rule__Parameter__PromptsAssignment_4_2_4
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__PromptsAssignment_4_2_4();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_4()); 

            }


            }

        }
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
    // InternalBot.g:3752:1: rule__Parameter__Group_4_2__5 : rule__Parameter__Group_4_2__5__Impl rule__Parameter__Group_4_2__6 ;
    public final void rule__Parameter__Group_4_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3756:1: ( rule__Parameter__Group_4_2__5__Impl rule__Parameter__Group_4_2__6 )
            // InternalBot.g:3757:2: rule__Parameter__Group_4_2__5__Impl rule__Parameter__Group_4_2__6
            {
            pushFollow(FOLLOW_40);
            rule__Parameter__Group_4_2__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__6();

            state._fsp--;


            }

        }
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
    // InternalBot.g:3764:1: rule__Parameter__Group_4_2__5__Impl : ( ( rule__Parameter__Group_4_2_5__0 )* ) ;
    public final void rule__Parameter__Group_4_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3768:1: ( ( ( rule__Parameter__Group_4_2_5__0 )* ) )
            // InternalBot.g:3769:1: ( ( rule__Parameter__Group_4_2_5__0 )* )
            {
            // InternalBot.g:3769:1: ( ( rule__Parameter__Group_4_2_5__0 )* )
            // InternalBot.g:3770:2: ( rule__Parameter__Group_4_2_5__0 )*
            {
             before(grammarAccess.getParameterAccess().getGroup_4_2_5()); 
            // InternalBot.g:3771:2: ( rule__Parameter__Group_4_2_5__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==54) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:3771:3: rule__Parameter__Group_4_2_5__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Parameter__Group_4_2_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getParameterAccess().getGroup_4_2_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__Parameter__Group_4_2__6"
    // InternalBot.g:3779:1: rule__Parameter__Group_4_2__6 : rule__Parameter__Group_4_2__6__Impl ;
    public final void rule__Parameter__Group_4_2__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3783:1: ( rule__Parameter__Group_4_2__6__Impl )
            // InternalBot.g:3784:2: rule__Parameter__Group_4_2__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__6"


    // $ANTLR start "rule__Parameter__Group_4_2__6__Impl"
    // InternalBot.g:3790:1: rule__Parameter__Group_4_2__6__Impl : ( ']' ) ;
    public final void rule__Parameter__Group_4_2__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3794:1: ( ( ']' ) )
            // InternalBot.g:3795:1: ( ']' )
            {
            // InternalBot.g:3795:1: ( ']' )
            // InternalBot.g:3796:2: ']'
            {
             before(grammarAccess.getParameterAccess().getRightSquareBracketKeyword_4_2_6()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getRightSquareBracketKeyword_4_2_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2__6__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2_2__0"
    // InternalBot.g:3806:1: rule__Parameter__Group_4_2_2__0 : rule__Parameter__Group_4_2_2__0__Impl rule__Parameter__Group_4_2_2__1 ;
    public final void rule__Parameter__Group_4_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3810:1: ( rule__Parameter__Group_4_2_2__0__Impl rule__Parameter__Group_4_2_2__1 )
            // InternalBot.g:3811:2: rule__Parameter__Group_4_2_2__0__Impl rule__Parameter__Group_4_2_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Parameter__Group_4_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_2__0"


    // $ANTLR start "rule__Parameter__Group_4_2_2__0__Impl"
    // InternalBot.g:3818:1: rule__Parameter__Group_4_2_2__0__Impl : ( 'in' ) ;
    public final void rule__Parameter__Group_4_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3822:1: ( ( 'in' ) )
            // InternalBot.g:3823:1: ( 'in' )
            {
            // InternalBot.g:3823:1: ( 'in' )
            // InternalBot.g:3824:2: 'in'
            {
             before(grammarAccess.getParameterAccess().getInKeyword_4_2_2_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getInKeyword_4_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_2__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2_2__1"
    // InternalBot.g:3833:1: rule__Parameter__Group_4_2_2__1 : rule__Parameter__Group_4_2_2__1__Impl ;
    public final void rule__Parameter__Group_4_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3837:1: ( rule__Parameter__Group_4_2_2__1__Impl )
            // InternalBot.g:3838:2: rule__Parameter__Group_4_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_2__1"


    // $ANTLR start "rule__Parameter__Group_4_2_2__1__Impl"
    // InternalBot.g:3844:1: rule__Parameter__Group_4_2_2__1__Impl : ( ( rule__Parameter__PrompLanguageAssignment_4_2_2_1 ) ) ;
    public final void rule__Parameter__Group_4_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3848:1: ( ( ( rule__Parameter__PrompLanguageAssignment_4_2_2_1 ) ) )
            // InternalBot.g:3849:1: ( ( rule__Parameter__PrompLanguageAssignment_4_2_2_1 ) )
            {
            // InternalBot.g:3849:1: ( ( rule__Parameter__PrompLanguageAssignment_4_2_2_1 ) )
            // InternalBot.g:3850:2: ( rule__Parameter__PrompLanguageAssignment_4_2_2_1 )
            {
             before(grammarAccess.getParameterAccess().getPrompLanguageAssignment_4_2_2_1()); 
            // InternalBot.g:3851:2: ( rule__Parameter__PrompLanguageAssignment_4_2_2_1 )
            // InternalBot.g:3851:3: rule__Parameter__PrompLanguageAssignment_4_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__PrompLanguageAssignment_4_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPrompLanguageAssignment_4_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_2__1__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2_5__0"
    // InternalBot.g:3860:1: rule__Parameter__Group_4_2_5__0 : rule__Parameter__Group_4_2_5__0__Impl rule__Parameter__Group_4_2_5__1 ;
    public final void rule__Parameter__Group_4_2_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3864:1: ( rule__Parameter__Group_4_2_5__0__Impl rule__Parameter__Group_4_2_5__1 )
            // InternalBot.g:3865:2: rule__Parameter__Group_4_2_5__0__Impl rule__Parameter__Group_4_2_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Parameter__Group_4_2_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_5__0"


    // $ANTLR start "rule__Parameter__Group_4_2_5__0__Impl"
    // InternalBot.g:3872:1: rule__Parameter__Group_4_2_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4_2_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3876:1: ( ( ',' ) )
            // InternalBot.g:3877:1: ( ',' )
            {
            // InternalBot.g:3877:1: ( ',' )
            // InternalBot.g:3878:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_2_5_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_4_2_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_5__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4_2_5__1"
    // InternalBot.g:3887:1: rule__Parameter__Group_4_2_5__1 : rule__Parameter__Group_4_2_5__1__Impl ;
    public final void rule__Parameter__Group_4_2_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3891:1: ( rule__Parameter__Group_4_2_5__1__Impl )
            // InternalBot.g:3892:2: rule__Parameter__Group_4_2_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4_2_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_5__1"


    // $ANTLR start "rule__Parameter__Group_4_2_5__1__Impl"
    // InternalBot.g:3898:1: rule__Parameter__Group_4_2_5__1__Impl : ( ( rule__Parameter__PromptsAssignment_4_2_5_1 ) ) ;
    public final void rule__Parameter__Group_4_2_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3902:1: ( ( ( rule__Parameter__PromptsAssignment_4_2_5_1 ) ) )
            // InternalBot.g:3903:1: ( ( rule__Parameter__PromptsAssignment_4_2_5_1 ) )
            {
            // InternalBot.g:3903:1: ( ( rule__Parameter__PromptsAssignment_4_2_5_1 ) )
            // InternalBot.g:3904:2: ( rule__Parameter__PromptsAssignment_4_2_5_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_5_1()); 
            // InternalBot.g:3905:2: ( rule__Parameter__PromptsAssignment_4_2_5_1 )
            // InternalBot.g:3905:3: rule__Parameter__PromptsAssignment_4_2_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__PromptsAssignment_4_2_5_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_4_2_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4_2_5__1__Impl"


    // $ANTLR start "rule__Parameter__Group_5__0"
    // InternalBot.g:3914:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3918:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:3919:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
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
    // InternalBot.g:3926:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3930:1: ( ( ',' ) )
            // InternalBot.g:3931:1: ( ',' )
            {
            // InternalBot.g:3931:1: ( ',' )
            // InternalBot.g:3932:2: ','
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
    // InternalBot.g:3941:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3945:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:3946:2: rule__Parameter__Group_5__1__Impl
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
    // InternalBot.g:3952:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__IsListAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3956:1: ( ( ( rule__Parameter__IsListAssignment_5_1 ) ) )
            // InternalBot.g:3957:1: ( ( rule__Parameter__IsListAssignment_5_1 ) )
            {
            // InternalBot.g:3957:1: ( ( rule__Parameter__IsListAssignment_5_1 ) )
            // InternalBot.g:3958:2: ( rule__Parameter__IsListAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_5_1()); 
            // InternalBot.g:3959:2: ( rule__Parameter__IsListAssignment_5_1 )
            // InternalBot.g:3959:3: rule__Parameter__IsListAssignment_5_1
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
    // InternalBot.g:3968:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3972:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:3973:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
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
    // InternalBot.g:3980:1: rule__EntityToken__Group__0__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3984:1: ( ( '@' ) )
            // InternalBot.g:3985:1: ( '@' )
            {
            // InternalBot.g:3985:1: ( '@' )
            // InternalBot.g:3986:2: '@'
            {
             before(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalBot.g:3995:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3999:1: ( rule__EntityToken__Group__1__Impl )
            // InternalBot.g:4000:2: rule__EntityToken__Group__1__Impl
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
    // InternalBot.g:4006:1: rule__EntityToken__Group__1__Impl : ( ( rule__EntityToken__EntityAssignment_1 ) ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4010:1: ( ( ( rule__EntityToken__EntityAssignment_1 ) ) )
            // InternalBot.g:4011:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            {
            // InternalBot.g:4011:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            // InternalBot.g:4012:2: ( rule__EntityToken__EntityAssignment_1 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 
            // InternalBot.g:4013:2: ( rule__EntityToken__EntityAssignment_1 )
            // InternalBot.g:4013:3: rule__EntityToken__EntityAssignment_1
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
    // InternalBot.g:4022:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4026:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:4027:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
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
    // InternalBot.g:4034:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4038:1: ( ( '[' ) )
            // InternalBot.g:4039:1: ( '[' )
            {
            // InternalBot.g:4039:1: ( '[' )
            // InternalBot.g:4040:2: '['
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
    // InternalBot.g:4049:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4053:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:4054:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
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
    // InternalBot.g:4061:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4065:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:4066:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:4066:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:4067:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:4068:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:4068:3: rule__ParameterToken__ParameterAssignment_1
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
    // InternalBot.g:4076:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4080:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:4081:2: rule__ParameterToken__Group__2__Impl
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
    // InternalBot.g:4087:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4091:1: ( ( ']' ) )
            // InternalBot.g:4092:1: ( ']' )
            {
            // InternalBot.g:4092:1: ( ']' )
            // InternalBot.g:4093:2: ']'
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
    // InternalBot.g:4103:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4107:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:4108:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
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
    // InternalBot.g:4115:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4119:1: ( ( '(' ) )
            // InternalBot.g:4120:1: ( '(' )
            {
            // InternalBot.g:4120:1: ( '(' )
            // InternalBot.g:4121:2: '('
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
    // InternalBot.g:4130:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4134:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:4135:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
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
    // InternalBot.g:4142:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4146:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:4147:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:4147:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:4148:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:4149:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:4149:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
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
    // InternalBot.g:4157:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4161:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:4162:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
            {
            pushFollow(FOLLOW_44);
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
    // InternalBot.g:4169:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4173:1: ( ( ')' ) )
            // InternalBot.g:4174:1: ( ')' )
            {
            // InternalBot.g:4174:1: ( ')' )
            // InternalBot.g:4175:2: ')'
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
    // InternalBot.g:4184:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4188:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:4189:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
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
    // InternalBot.g:4196:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4200:1: ( ( '[' ) )
            // InternalBot.g:4201:1: ( '[' )
            {
            // InternalBot.g:4201:1: ( '[' )
            // InternalBot.g:4202:2: '['
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
    // InternalBot.g:4211:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4215:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:4216:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
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
    // InternalBot.g:4223:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4227:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:4228:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:4228:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:4229:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:4230:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:4230:3: rule__ParameterRefenceToken__ParameterAssignment_4
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
    // InternalBot.g:4238:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4242:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:4243:2: rule__ParameterRefenceToken__Group__5__Impl
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
    // InternalBot.g:4249:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4253:1: ( ( ']' ) )
            // InternalBot.g:4254:1: ( ']' )
            {
            // InternalBot.g:4254:1: ( ']' )
            // InternalBot.g:4255:2: ']'
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
    // InternalBot.g:4265:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4269:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:4270:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalBot.g:4277:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4281:1: ( ( 'request.' ) )
            // InternalBot.g:4282:1: ( 'request.' )
            {
            // InternalBot.g:4282:1: ( 'request.' )
            // InternalBot.g:4283:2: 'request.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalBot.g:4292:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4296:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:4297:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
            {
            pushFollow(FOLLOW_46);
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
    // InternalBot.g:4304:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4308:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4309:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4309:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4310:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4311:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4311:3: rule__HTTPRequestToken__TypeAssignment_1
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
    // InternalBot.g:4319:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4323:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:4324:2: rule__HTTPRequestToken__Group__2__Impl
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
    // InternalBot.g:4330:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4334:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:4335:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:4335:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:4336:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:4337:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==76) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:4337:3: rule__HTTPRequestToken__Group_2__0
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
    // InternalBot.g:4346:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4350:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:4351:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
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
    // InternalBot.g:4358:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4362:1: ( ( '.' ) )
            // InternalBot.g:4363:1: ( '.' )
            {
            // InternalBot.g:4363:1: ( '.' )
            // InternalBot.g:4364:2: '.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 
            match(input,76,FOLLOW_2); 
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
    // InternalBot.g:4373:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4377:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:4378:2: rule__HTTPRequestToken__Group_2__1__Impl
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
    // InternalBot.g:4384:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4388:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:4389:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:4389:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:4390:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:4391:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:4391:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
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
    // InternalBot.g:4400:1: rule__Simple__Group__0 : rule__Simple__Group__0__Impl rule__Simple__Group__1 ;
    public final void rule__Simple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4404:1: ( rule__Simple__Group__0__Impl rule__Simple__Group__1 )
            // InternalBot.g:4405:2: rule__Simple__Group__0__Impl rule__Simple__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalBot.g:4412:1: rule__Simple__Group__0__Impl : ( () ) ;
    public final void rule__Simple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4416:1: ( ( () ) )
            // InternalBot.g:4417:1: ( () )
            {
            // InternalBot.g:4417:1: ( () )
            // InternalBot.g:4418:2: ()
            {
             before(grammarAccess.getSimpleAccess().getSimpleAction_0()); 
            // InternalBot.g:4419:2: ()
            // InternalBot.g:4419:3: 
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
    // InternalBot.g:4427:1: rule__Simple__Group__1 : rule__Simple__Group__1__Impl rule__Simple__Group__2 ;
    public final void rule__Simple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4431:1: ( rule__Simple__Group__1__Impl rule__Simple__Group__2 )
            // InternalBot.g:4432:2: rule__Simple__Group__1__Impl rule__Simple__Group__2
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
    // InternalBot.g:4439:1: rule__Simple__Group__1__Impl : ( 'Simple' ) ;
    public final void rule__Simple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4443:1: ( ( 'Simple' ) )
            // InternalBot.g:4444:1: ( 'Simple' )
            {
            // InternalBot.g:4444:1: ( 'Simple' )
            // InternalBot.g:4445:2: 'Simple'
            {
             before(grammarAccess.getSimpleAccess().getSimpleKeyword_1()); 
            match(input,77,FOLLOW_2); 
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
    // InternalBot.g:4454:1: rule__Simple__Group__2 : rule__Simple__Group__2__Impl rule__Simple__Group__3 ;
    public final void rule__Simple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4458:1: ( rule__Simple__Group__2__Impl rule__Simple__Group__3 )
            // InternalBot.g:4459:2: rule__Simple__Group__2__Impl rule__Simple__Group__3
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
    // InternalBot.g:4466:1: rule__Simple__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Simple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4470:1: ( ( 'entity' ) )
            // InternalBot.g:4471:1: ( 'entity' )
            {
            // InternalBot.g:4471:1: ( 'entity' )
            // InternalBot.g:4472:2: 'entity'
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
    // InternalBot.g:4481:1: rule__Simple__Group__3 : rule__Simple__Group__3__Impl rule__Simple__Group__4 ;
    public final void rule__Simple__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4485:1: ( rule__Simple__Group__3__Impl rule__Simple__Group__4 )
            // InternalBot.g:4486:2: rule__Simple__Group__3__Impl rule__Simple__Group__4
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:4493:1: rule__Simple__Group__3__Impl : ( ( rule__Simple__NameAssignment_3 ) ) ;
    public final void rule__Simple__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4497:1: ( ( ( rule__Simple__NameAssignment_3 ) ) )
            // InternalBot.g:4498:1: ( ( rule__Simple__NameAssignment_3 ) )
            {
            // InternalBot.g:4498:1: ( ( rule__Simple__NameAssignment_3 ) )
            // InternalBot.g:4499:2: ( rule__Simple__NameAssignment_3 )
            {
             before(grammarAccess.getSimpleAccess().getNameAssignment_3()); 
            // InternalBot.g:4500:2: ( rule__Simple__NameAssignment_3 )
            // InternalBot.g:4500:3: rule__Simple__NameAssignment_3
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
    // InternalBot.g:4508:1: rule__Simple__Group__4 : rule__Simple__Group__4__Impl rule__Simple__Group__5 ;
    public final void rule__Simple__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4512:1: ( rule__Simple__Group__4__Impl rule__Simple__Group__5 )
            // InternalBot.g:4513:2: rule__Simple__Group__4__Impl rule__Simple__Group__5
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:4520:1: rule__Simple__Group__4__Impl : ( ( rule__Simple__Group_4__0 )? ) ;
    public final void rule__Simple__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4524:1: ( ( ( rule__Simple__Group_4__0 )? ) )
            // InternalBot.g:4525:1: ( ( rule__Simple__Group_4__0 )? )
            {
            // InternalBot.g:4525:1: ( ( rule__Simple__Group_4__0 )? )
            // InternalBot.g:4526:2: ( rule__Simple__Group_4__0 )?
            {
             before(grammarAccess.getSimpleAccess().getGroup_4()); 
            // InternalBot.g:4527:2: ( rule__Simple__Group_4__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==73) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:4527:3: rule__Simple__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Simple__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleAccess().getGroup_4()); 

            }


            }

        }
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
    // InternalBot.g:4535:1: rule__Simple__Group__5 : rule__Simple__Group__5__Impl rule__Simple__Group__6 ;
    public final void rule__Simple__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4539:1: ( rule__Simple__Group__5__Impl rule__Simple__Group__6 )
            // InternalBot.g:4540:2: rule__Simple__Group__5__Impl rule__Simple__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Simple__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group__6();

            state._fsp--;


            }

        }
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
    // InternalBot.g:4547:1: rule__Simple__Group__5__Impl : ( ':' ) ;
    public final void rule__Simple__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4551:1: ( ( ':' ) )
            // InternalBot.g:4552:1: ( ':' )
            {
            // InternalBot.g:4552:1: ( ':' )
            // InternalBot.g:4553:2: ':'
            {
             before(grammarAccess.getSimpleAccess().getColonKeyword_5()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getSimpleAccess().getColonKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__Simple__Group__6"
    // InternalBot.g:4562:1: rule__Simple__Group__6 : rule__Simple__Group__6__Impl ;
    public final void rule__Simple__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4566:1: ( rule__Simple__Group__6__Impl )
            // InternalBot.g:4567:2: rule__Simple__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Simple__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__6"


    // $ANTLR start "rule__Simple__Group__6__Impl"
    // InternalBot.g:4573:1: rule__Simple__Group__6__Impl : ( ( rule__Simple__Group_6__0 )? ) ;
    public final void rule__Simple__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4577:1: ( ( ( rule__Simple__Group_6__0 )? ) )
            // InternalBot.g:4578:1: ( ( rule__Simple__Group_6__0 )? )
            {
            // InternalBot.g:4578:1: ( ( rule__Simple__Group_6__0 )? )
            // InternalBot.g:4579:2: ( rule__Simple__Group_6__0 )?
            {
             before(grammarAccess.getSimpleAccess().getGroup_6()); 
            // InternalBot.g:4580:2: ( rule__Simple__Group_6__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_ID)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:4580:3: rule__Simple__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Simple__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group__6__Impl"


    // $ANTLR start "rule__Simple__Group_4__0"
    // InternalBot.g:4589:1: rule__Simple__Group_4__0 : rule__Simple__Group_4__0__Impl rule__Simple__Group_4__1 ;
    public final void rule__Simple__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4593:1: ( rule__Simple__Group_4__0__Impl rule__Simple__Group_4__1 )
            // InternalBot.g:4594:2: rule__Simple__Group_4__0__Impl rule__Simple__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Simple__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_4__0"


    // $ANTLR start "rule__Simple__Group_4__0__Impl"
    // InternalBot.g:4601:1: rule__Simple__Group_4__0__Impl : ( 'in' ) ;
    public final void rule__Simple__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4605:1: ( ( 'in' ) )
            // InternalBot.g:4606:1: ( 'in' )
            {
            // InternalBot.g:4606:1: ( 'in' )
            // InternalBot.g:4607:2: 'in'
            {
             before(grammarAccess.getSimpleAccess().getInKeyword_4_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getSimpleAccess().getInKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_4__0__Impl"


    // $ANTLR start "rule__Simple__Group_4__1"
    // InternalBot.g:4616:1: rule__Simple__Group_4__1 : rule__Simple__Group_4__1__Impl ;
    public final void rule__Simple__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4620:1: ( rule__Simple__Group_4__1__Impl )
            // InternalBot.g:4621:2: rule__Simple__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Simple__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_4__1"


    // $ANTLR start "rule__Simple__Group_4__1__Impl"
    // InternalBot.g:4627:1: rule__Simple__Group_4__1__Impl : ( ( rule__Simple__LanguageAssignment_4_1 ) ) ;
    public final void rule__Simple__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4631:1: ( ( ( rule__Simple__LanguageAssignment_4_1 ) ) )
            // InternalBot.g:4632:1: ( ( rule__Simple__LanguageAssignment_4_1 ) )
            {
            // InternalBot.g:4632:1: ( ( rule__Simple__LanguageAssignment_4_1 ) )
            // InternalBot.g:4633:2: ( rule__Simple__LanguageAssignment_4_1 )
            {
             before(grammarAccess.getSimpleAccess().getLanguageAssignment_4_1()); 
            // InternalBot.g:4634:2: ( rule__Simple__LanguageAssignment_4_1 )
            // InternalBot.g:4634:3: rule__Simple__LanguageAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Simple__LanguageAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAccess().getLanguageAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_4__1__Impl"


    // $ANTLR start "rule__Simple__Group_6__0"
    // InternalBot.g:4643:1: rule__Simple__Group_6__0 : rule__Simple__Group_6__0__Impl rule__Simple__Group_6__1 ;
    public final void rule__Simple__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4647:1: ( rule__Simple__Group_6__0__Impl rule__Simple__Group_6__1 )
            // InternalBot.g:4648:2: rule__Simple__Group_6__0__Impl rule__Simple__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Simple__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Simple__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_6__0"


    // $ANTLR start "rule__Simple__Group_6__0__Impl"
    // InternalBot.g:4655:1: rule__Simple__Group_6__0__Impl : ( ( rule__Simple__InputsAssignment_6_0 ) ) ;
    public final void rule__Simple__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4659:1: ( ( ( rule__Simple__InputsAssignment_6_0 ) ) )
            // InternalBot.g:4660:1: ( ( rule__Simple__InputsAssignment_6_0 ) )
            {
            // InternalBot.g:4660:1: ( ( rule__Simple__InputsAssignment_6_0 ) )
            // InternalBot.g:4661:2: ( rule__Simple__InputsAssignment_6_0 )
            {
             before(grammarAccess.getSimpleAccess().getInputsAssignment_6_0()); 
            // InternalBot.g:4662:2: ( rule__Simple__InputsAssignment_6_0 )
            // InternalBot.g:4662:3: rule__Simple__InputsAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__Simple__InputsAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAccess().getInputsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_6__0__Impl"


    // $ANTLR start "rule__Simple__Group_6__1"
    // InternalBot.g:4670:1: rule__Simple__Group_6__1 : rule__Simple__Group_6__1__Impl ;
    public final void rule__Simple__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4674:1: ( rule__Simple__Group_6__1__Impl )
            // InternalBot.g:4675:2: rule__Simple__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Simple__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_6__1"


    // $ANTLR start "rule__Simple__Group_6__1__Impl"
    // InternalBot.g:4681:1: rule__Simple__Group_6__1__Impl : ( ( rule__Simple__InputsAssignment_6_1 )* ) ;
    public final void rule__Simple__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4685:1: ( ( ( rule__Simple__InputsAssignment_6_1 )* ) )
            // InternalBot.g:4686:1: ( ( rule__Simple__InputsAssignment_6_1 )* )
            {
            // InternalBot.g:4686:1: ( ( rule__Simple__InputsAssignment_6_1 )* )
            // InternalBot.g:4687:2: ( rule__Simple__InputsAssignment_6_1 )*
            {
             before(grammarAccess.getSimpleAccess().getInputsAssignment_6_1()); 
            // InternalBot.g:4688:2: ( rule__Simple__InputsAssignment_6_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:4688:3: rule__Simple__InputsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Simple__InputsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getSimpleAccess().getInputsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__Group_6__1__Impl"


    // $ANTLR start "rule__Composite__Group__0"
    // InternalBot.g:4697:1: rule__Composite__Group__0 : rule__Composite__Group__0__Impl rule__Composite__Group__1 ;
    public final void rule__Composite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4701:1: ( rule__Composite__Group__0__Impl rule__Composite__Group__1 )
            // InternalBot.g:4702:2: rule__Composite__Group__0__Impl rule__Composite__Group__1
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
    // InternalBot.g:4709:1: rule__Composite__Group__0__Impl : ( () ) ;
    public final void rule__Composite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4713:1: ( ( () ) )
            // InternalBot.g:4714:1: ( () )
            {
            // InternalBot.g:4714:1: ( () )
            // InternalBot.g:4715:2: ()
            {
             before(grammarAccess.getCompositeAccess().getCompositeAction_0()); 
            // InternalBot.g:4716:2: ()
            // InternalBot.g:4716:3: 
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
    // InternalBot.g:4724:1: rule__Composite__Group__1 : rule__Composite__Group__1__Impl rule__Composite__Group__2 ;
    public final void rule__Composite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4728:1: ( rule__Composite__Group__1__Impl rule__Composite__Group__2 )
            // InternalBot.g:4729:2: rule__Composite__Group__1__Impl rule__Composite__Group__2
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
    // InternalBot.g:4736:1: rule__Composite__Group__1__Impl : ( 'Composite' ) ;
    public final void rule__Composite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4740:1: ( ( 'Composite' ) )
            // InternalBot.g:4741:1: ( 'Composite' )
            {
            // InternalBot.g:4741:1: ( 'Composite' )
            // InternalBot.g:4742:2: 'Composite'
            {
             before(grammarAccess.getCompositeAccess().getCompositeKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalBot.g:4751:1: rule__Composite__Group__2 : rule__Composite__Group__2__Impl rule__Composite__Group__3 ;
    public final void rule__Composite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4755:1: ( rule__Composite__Group__2__Impl rule__Composite__Group__3 )
            // InternalBot.g:4756:2: rule__Composite__Group__2__Impl rule__Composite__Group__3
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
    // InternalBot.g:4763:1: rule__Composite__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Composite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4767:1: ( ( 'entity' ) )
            // InternalBot.g:4768:1: ( 'entity' )
            {
            // InternalBot.g:4768:1: ( 'entity' )
            // InternalBot.g:4769:2: 'entity'
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
    // InternalBot.g:4778:1: rule__Composite__Group__3 : rule__Composite__Group__3__Impl rule__Composite__Group__4 ;
    public final void rule__Composite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4782:1: ( rule__Composite__Group__3__Impl rule__Composite__Group__4 )
            // InternalBot.g:4783:2: rule__Composite__Group__3__Impl rule__Composite__Group__4
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:4790:1: rule__Composite__Group__3__Impl : ( ( rule__Composite__NameAssignment_3 ) ) ;
    public final void rule__Composite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4794:1: ( ( ( rule__Composite__NameAssignment_3 ) ) )
            // InternalBot.g:4795:1: ( ( rule__Composite__NameAssignment_3 ) )
            {
            // InternalBot.g:4795:1: ( ( rule__Composite__NameAssignment_3 ) )
            // InternalBot.g:4796:2: ( rule__Composite__NameAssignment_3 )
            {
             before(grammarAccess.getCompositeAccess().getNameAssignment_3()); 
            // InternalBot.g:4797:2: ( rule__Composite__NameAssignment_3 )
            // InternalBot.g:4797:3: rule__Composite__NameAssignment_3
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
    // InternalBot.g:4805:1: rule__Composite__Group__4 : rule__Composite__Group__4__Impl rule__Composite__Group__5 ;
    public final void rule__Composite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4809:1: ( rule__Composite__Group__4__Impl rule__Composite__Group__5 )
            // InternalBot.g:4810:2: rule__Composite__Group__4__Impl rule__Composite__Group__5
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:4817:1: rule__Composite__Group__4__Impl : ( ( rule__Composite__Group_4__0 )? ) ;
    public final void rule__Composite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4821:1: ( ( ( rule__Composite__Group_4__0 )? ) )
            // InternalBot.g:4822:1: ( ( rule__Composite__Group_4__0 )? )
            {
            // InternalBot.g:4822:1: ( ( rule__Composite__Group_4__0 )? )
            // InternalBot.g:4823:2: ( rule__Composite__Group_4__0 )?
            {
             before(grammarAccess.getCompositeAccess().getGroup_4()); 
            // InternalBot.g:4824:2: ( rule__Composite__Group_4__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==73) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBot.g:4824:3: rule__Composite__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Composite__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompositeAccess().getGroup_4()); 

            }


            }

        }
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
    // InternalBot.g:4832:1: rule__Composite__Group__5 : rule__Composite__Group__5__Impl rule__Composite__Group__6 ;
    public final void rule__Composite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4836:1: ( rule__Composite__Group__5__Impl rule__Composite__Group__6 )
            // InternalBot.g:4837:2: rule__Composite__Group__5__Impl rule__Composite__Group__6
            {
            pushFollow(FOLLOW_49);
            rule__Composite__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group__6();

            state._fsp--;


            }

        }
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
    // InternalBot.g:4844:1: rule__Composite__Group__5__Impl : ( ':' ) ;
    public final void rule__Composite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4848:1: ( ( ':' ) )
            // InternalBot.g:4849:1: ( ':' )
            {
            // InternalBot.g:4849:1: ( ':' )
            // InternalBot.g:4850:2: ':'
            {
             before(grammarAccess.getCompositeAccess().getColonKeyword_5()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getCompositeAccess().getColonKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__Composite__Group__6"
    // InternalBot.g:4859:1: rule__Composite__Group__6 : rule__Composite__Group__6__Impl ;
    public final void rule__Composite__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4863:1: ( rule__Composite__Group__6__Impl )
            // InternalBot.g:4864:2: rule__Composite__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composite__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__6"


    // $ANTLR start "rule__Composite__Group__6__Impl"
    // InternalBot.g:4870:1: rule__Composite__Group__6__Impl : ( ( rule__Composite__Group_6__0 )? ) ;
    public final void rule__Composite__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4874:1: ( ( ( rule__Composite__Group_6__0 )? ) )
            // InternalBot.g:4875:1: ( ( rule__Composite__Group_6__0 )? )
            {
            // InternalBot.g:4875:1: ( ( rule__Composite__Group_6__0 )? )
            // InternalBot.g:4876:2: ( rule__Composite__Group_6__0 )?
            {
             before(grammarAccess.getCompositeAccess().getGroup_6()); 
            // InternalBot.g:4877:2: ( rule__Composite__Group_6__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||LA46_0==74) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBot.g:4877:3: rule__Composite__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Composite__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompositeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group__6__Impl"


    // $ANTLR start "rule__Composite__Group_4__0"
    // InternalBot.g:4886:1: rule__Composite__Group_4__0 : rule__Composite__Group_4__0__Impl rule__Composite__Group_4__1 ;
    public final void rule__Composite__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4890:1: ( rule__Composite__Group_4__0__Impl rule__Composite__Group_4__1 )
            // InternalBot.g:4891:2: rule__Composite__Group_4__0__Impl rule__Composite__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Composite__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_4__0"


    // $ANTLR start "rule__Composite__Group_4__0__Impl"
    // InternalBot.g:4898:1: rule__Composite__Group_4__0__Impl : ( 'in' ) ;
    public final void rule__Composite__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4902:1: ( ( 'in' ) )
            // InternalBot.g:4903:1: ( 'in' )
            {
            // InternalBot.g:4903:1: ( 'in' )
            // InternalBot.g:4904:2: 'in'
            {
             before(grammarAccess.getCompositeAccess().getInKeyword_4_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getCompositeAccess().getInKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_4__0__Impl"


    // $ANTLR start "rule__Composite__Group_4__1"
    // InternalBot.g:4913:1: rule__Composite__Group_4__1 : rule__Composite__Group_4__1__Impl ;
    public final void rule__Composite__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4917:1: ( rule__Composite__Group_4__1__Impl )
            // InternalBot.g:4918:2: rule__Composite__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composite__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_4__1"


    // $ANTLR start "rule__Composite__Group_4__1__Impl"
    // InternalBot.g:4924:1: rule__Composite__Group_4__1__Impl : ( ( rule__Composite__LanguageAssignment_4_1 ) ) ;
    public final void rule__Composite__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4928:1: ( ( ( rule__Composite__LanguageAssignment_4_1 ) ) )
            // InternalBot.g:4929:1: ( ( rule__Composite__LanguageAssignment_4_1 ) )
            {
            // InternalBot.g:4929:1: ( ( rule__Composite__LanguageAssignment_4_1 ) )
            // InternalBot.g:4930:2: ( rule__Composite__LanguageAssignment_4_1 )
            {
             before(grammarAccess.getCompositeAccess().getLanguageAssignment_4_1()); 
            // InternalBot.g:4931:2: ( rule__Composite__LanguageAssignment_4_1 )
            // InternalBot.g:4931:3: rule__Composite__LanguageAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Composite__LanguageAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getCompositeAccess().getLanguageAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_4__1__Impl"


    // $ANTLR start "rule__Composite__Group_6__0"
    // InternalBot.g:4940:1: rule__Composite__Group_6__0 : rule__Composite__Group_6__0__Impl rule__Composite__Group_6__1 ;
    public final void rule__Composite__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4944:1: ( rule__Composite__Group_6__0__Impl rule__Composite__Group_6__1 )
            // InternalBot.g:4945:2: rule__Composite__Group_6__0__Impl rule__Composite__Group_6__1
            {
            pushFollow(FOLLOW_49);
            rule__Composite__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Composite__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_6__0"


    // $ANTLR start "rule__Composite__Group_6__0__Impl"
    // InternalBot.g:4952:1: rule__Composite__Group_6__0__Impl : ( ( rule__Composite__InputsAssignment_6_0 ) ) ;
    public final void rule__Composite__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4956:1: ( ( ( rule__Composite__InputsAssignment_6_0 ) ) )
            // InternalBot.g:4957:1: ( ( rule__Composite__InputsAssignment_6_0 ) )
            {
            // InternalBot.g:4957:1: ( ( rule__Composite__InputsAssignment_6_0 ) )
            // InternalBot.g:4958:2: ( rule__Composite__InputsAssignment_6_0 )
            {
             before(grammarAccess.getCompositeAccess().getInputsAssignment_6_0()); 
            // InternalBot.g:4959:2: ( rule__Composite__InputsAssignment_6_0 )
            // InternalBot.g:4959:3: rule__Composite__InputsAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__Composite__InputsAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeAccess().getInputsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_6__0__Impl"


    // $ANTLR start "rule__Composite__Group_6__1"
    // InternalBot.g:4967:1: rule__Composite__Group_6__1 : rule__Composite__Group_6__1__Impl ;
    public final void rule__Composite__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4971:1: ( rule__Composite__Group_6__1__Impl )
            // InternalBot.g:4972:2: rule__Composite__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composite__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_6__1"


    // $ANTLR start "rule__Composite__Group_6__1__Impl"
    // InternalBot.g:4978:1: rule__Composite__Group_6__1__Impl : ( ( rule__Composite__InputsAssignment_6_1 )* ) ;
    public final void rule__Composite__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4982:1: ( ( ( rule__Composite__InputsAssignment_6_1 )* ) )
            // InternalBot.g:4983:1: ( ( rule__Composite__InputsAssignment_6_1 )* )
            {
            // InternalBot.g:4983:1: ( ( rule__Composite__InputsAssignment_6_1 )* )
            // InternalBot.g:4984:2: ( rule__Composite__InputsAssignment_6_1 )*
            {
             before(grammarAccess.getCompositeAccess().getInputsAssignment_6_1()); 
            // InternalBot.g:4985:2: ( rule__Composite__InputsAssignment_6_1 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||LA47_0==74) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBot.g:4985:3: rule__Composite__InputsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_50);
            	    rule__Composite__InputsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getCompositeAccess().getInputsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__Group_6__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group__0"
    // InternalBot.g:4994:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4998:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:4999:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
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
    // InternalBot.g:5006:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5010:1: ( ( () ) )
            // InternalBot.g:5011:1: ( () )
            {
            // InternalBot.g:5011:1: ( () )
            // InternalBot.g:5012:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:5013:2: ()
            // InternalBot.g:5013:3: 
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
    // InternalBot.g:5021:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5025:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:5026:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
            {
            pushFollow(FOLLOW_51);
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
    // InternalBot.g:5033:1: rule__SimpleInput__Group__1__Impl : ( ( rule__SimpleInput__NameAssignment_1 ) ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5037:1: ( ( ( rule__SimpleInput__NameAssignment_1 ) ) )
            // InternalBot.g:5038:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            {
            // InternalBot.g:5038:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            // InternalBot.g:5039:2: ( rule__SimpleInput__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 
            // InternalBot.g:5040:2: ( rule__SimpleInput__NameAssignment_1 )
            // InternalBot.g:5040:3: rule__SimpleInput__NameAssignment_1
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
    // InternalBot.g:5048:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5052:1: ( rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 )
            // InternalBot.g:5053:2: rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3
            {
            pushFollow(FOLLOW_51);
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
    // InternalBot.g:5060:1: rule__SimpleInput__Group__2__Impl : ( ( rule__SimpleInput__Group_2__0 )? ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5064:1: ( ( ( rule__SimpleInput__Group_2__0 )? ) )
            // InternalBot.g:5065:1: ( ( rule__SimpleInput__Group_2__0 )? )
            {
            // InternalBot.g:5065:1: ( ( rule__SimpleInput__Group_2__0 )? )
            // InternalBot.g:5066:2: ( rule__SimpleInput__Group_2__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2()); 
            // InternalBot.g:5067:2: ( rule__SimpleInput__Group_2__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==79) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBot.g:5067:3: rule__SimpleInput__Group_2__0
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
    // InternalBot.g:5075:1: rule__SimpleInput__Group__3 : rule__SimpleInput__Group__3__Impl ;
    public final void rule__SimpleInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5079:1: ( rule__SimpleInput__Group__3__Impl )
            // InternalBot.g:5080:2: rule__SimpleInput__Group__3__Impl
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
    // InternalBot.g:5086:1: rule__SimpleInput__Group__3__Impl : ( ';' ) ;
    public final void rule__SimpleInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5090:1: ( ( ';' ) )
            // InternalBot.g:5091:1: ( ';' )
            {
            // InternalBot.g:5091:1: ( ';' )
            // InternalBot.g:5092:2: ';'
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
    // InternalBot.g:5102:1: rule__SimpleInput__Group_2__0 : rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 ;
    public final void rule__SimpleInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5106:1: ( rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 )
            // InternalBot.g:5107:2: rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1
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
    // InternalBot.g:5114:1: rule__SimpleInput__Group_2__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5118:1: ( ( 'synonyms' ) )
            // InternalBot.g:5119:1: ( 'synonyms' )
            {
            // InternalBot.g:5119:1: ( 'synonyms' )
            // InternalBot.g:5120:2: 'synonyms'
            {
             before(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalBot.g:5129:1: rule__SimpleInput__Group_2__1 : rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 ;
    public final void rule__SimpleInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5133:1: ( rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 )
            // InternalBot.g:5134:2: rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2
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
    // InternalBot.g:5141:1: rule__SimpleInput__Group_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5145:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) )
            // InternalBot.g:5146:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            {
            // InternalBot.g:5146:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            // InternalBot.g:5147:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 
            // InternalBot.g:5148:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            // InternalBot.g:5148:3: rule__SimpleInput__ValuesAssignment_2_1
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
    // InternalBot.g:5156:1: rule__SimpleInput__Group_2__2 : rule__SimpleInput__Group_2__2__Impl ;
    public final void rule__SimpleInput__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5160:1: ( rule__SimpleInput__Group_2__2__Impl )
            // InternalBot.g:5161:2: rule__SimpleInput__Group_2__2__Impl
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
    // InternalBot.g:5167:1: rule__SimpleInput__Group_2__2__Impl : ( ( rule__SimpleInput__Group_2_2__0 )* ) ;
    public final void rule__SimpleInput__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5171:1: ( ( ( rule__SimpleInput__Group_2_2__0 )* ) )
            // InternalBot.g:5172:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            {
            // InternalBot.g:5172:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            // InternalBot.g:5173:2: ( rule__SimpleInput__Group_2_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 
            // InternalBot.g:5174:2: ( rule__SimpleInput__Group_2_2__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==54) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBot.g:5174:3: rule__SimpleInput__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__SimpleInput__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // InternalBot.g:5183:1: rule__SimpleInput__Group_2_2__0 : rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 ;
    public final void rule__SimpleInput__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5187:1: ( rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 )
            // InternalBot.g:5188:2: rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1
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
    // InternalBot.g:5195:1: rule__SimpleInput__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5199:1: ( ( ',' ) )
            // InternalBot.g:5200:1: ( ',' )
            {
            // InternalBot.g:5200:1: ( ',' )
            // InternalBot.g:5201:2: ','
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
    // InternalBot.g:5210:1: rule__SimpleInput__Group_2_2__1 : rule__SimpleInput__Group_2_2__1__Impl ;
    public final void rule__SimpleInput__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5214:1: ( rule__SimpleInput__Group_2_2__1__Impl )
            // InternalBot.g:5215:2: rule__SimpleInput__Group_2_2__1__Impl
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
    // InternalBot.g:5221:1: rule__SimpleInput__Group_2_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5225:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) )
            // InternalBot.g:5226:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            {
            // InternalBot.g:5226:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            // InternalBot.g:5227:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 
            // InternalBot.g:5228:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            // InternalBot.g:5228:3: rule__SimpleInput__ValuesAssignment_2_2_1
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
    // InternalBot.g:5237:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5241:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:5242:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
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
    // InternalBot.g:5249:1: rule__CompositeInput__Group__0__Impl : ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5253:1: ( ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) ) )
            // InternalBot.g:5254:1: ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) )
            {
            // InternalBot.g:5254:1: ( ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* ) )
            // InternalBot.g:5255:2: ( ( rule__CompositeInput__TokensAssignment_0 ) ) ( ( rule__CompositeInput__TokensAssignment_0 )* )
            {
            // InternalBot.g:5255:2: ( ( rule__CompositeInput__TokensAssignment_0 ) )
            // InternalBot.g:5256:3: ( rule__CompositeInput__TokensAssignment_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 
            // InternalBot.g:5257:3: ( rule__CompositeInput__TokensAssignment_0 )
            // InternalBot.g:5257:4: rule__CompositeInput__TokensAssignment_0
            {
            pushFollow(FOLLOW_50);
            rule__CompositeInput__TokensAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 

            }

            // InternalBot.g:5260:2: ( ( rule__CompositeInput__TokensAssignment_0 )* )
            // InternalBot.g:5261:3: ( rule__CompositeInput__TokensAssignment_0 )*
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAssignment_0()); 
            // InternalBot.g:5262:3: ( rule__CompositeInput__TokensAssignment_0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||LA50_0==74) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:5262:4: rule__CompositeInput__TokensAssignment_0
            	    {
            	    pushFollow(FOLLOW_50);
            	    rule__CompositeInput__TokensAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalBot.g:5271:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5275:1: ( rule__CompositeInput__Group__1__Impl )
            // InternalBot.g:5276:2: rule__CompositeInput__Group__1__Impl
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
    // InternalBot.g:5282:1: rule__CompositeInput__Group__1__Impl : ( ';' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5286:1: ( ( ';' ) )
            // InternalBot.g:5287:1: ( ';' )
            {
            // InternalBot.g:5287:1: ( ';' )
            // InternalBot.g:5288:2: ';'
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
    // InternalBot.g:5298:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5302:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:5303:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalBot.g:5310:1: rule__Text__Group__0__Impl : ( 'text' ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5314:1: ( ( 'text' ) )
            // InternalBot.g:5315:1: ( 'text' )
            {
            // InternalBot.g:5315:1: ( 'text' )
            // InternalBot.g:5316:2: 'text'
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
    // InternalBot.g:5325:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5329:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:5330:2: rule__Text__Group__1__Impl rule__Text__Group__2
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
    // InternalBot.g:5337:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5341:1: ( ( 'response' ) )
            // InternalBot.g:5342:1: ( 'response' )
            {
            // InternalBot.g:5342:1: ( 'response' )
            // InternalBot.g:5343:2: 'response'
            {
             before(grammarAccess.getTextAccess().getResponseKeyword_1()); 
            match(input,80,FOLLOW_2); 
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
    // InternalBot.g:5352:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5356:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:5357:2: rule__Text__Group__2__Impl rule__Text__Group__3
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:5364:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5368:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:5369:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:5369:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:5370:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:5371:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:5371:3: rule__Text__NameAssignment_2
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
    // InternalBot.g:5379:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5383:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:5384:2: rule__Text__Group__3__Impl rule__Text__Group__4
            {
            pushFollow(FOLLOW_48);
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
    // InternalBot.g:5391:1: rule__Text__Group__3__Impl : ( ( rule__Text__Group_3__0 )? ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5395:1: ( ( ( rule__Text__Group_3__0 )? ) )
            // InternalBot.g:5396:1: ( ( rule__Text__Group_3__0 )? )
            {
            // InternalBot.g:5396:1: ( ( rule__Text__Group_3__0 )? )
            // InternalBot.g:5397:2: ( rule__Text__Group_3__0 )?
            {
             before(grammarAccess.getTextAccess().getGroup_3()); 
            // InternalBot.g:5398:2: ( rule__Text__Group_3__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==73) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:5398:3: rule__Text__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Text__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextAccess().getGroup_3()); 

            }


            }

        }
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
    // InternalBot.g:5406:1: rule__Text__Group__4 : rule__Text__Group__4__Impl rule__Text__Group__5 ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5410:1: ( rule__Text__Group__4__Impl rule__Text__Group__5 )
            // InternalBot.g:5411:2: rule__Text__Group__4__Impl rule__Text__Group__5
            {
            pushFollow(FOLLOW_53);
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
    // InternalBot.g:5418:1: rule__Text__Group__4__Impl : ( ':' ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5422:1: ( ( ':' ) )
            // InternalBot.g:5423:1: ( ':' )
            {
            // InternalBot.g:5423:1: ( ':' )
            // InternalBot.g:5424:2: ':'
            {
             before(grammarAccess.getTextAccess().getColonKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getColonKeyword_4()); 

            }


            }

        }
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
    // InternalBot.g:5433:1: rule__Text__Group__5 : rule__Text__Group__5__Impl rule__Text__Group__6 ;
    public final void rule__Text__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5437:1: ( rule__Text__Group__5__Impl rule__Text__Group__6 )
            // InternalBot.g:5438:2: rule__Text__Group__5__Impl rule__Text__Group__6
            {
            pushFollow(FOLLOW_53);
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
    // InternalBot.g:5445:1: rule__Text__Group__5__Impl : ( ( 'text:' )? ) ;
    public final void rule__Text__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5449:1: ( ( ( 'text:' )? ) )
            // InternalBot.g:5450:1: ( ( 'text:' )? )
            {
            // InternalBot.g:5450:1: ( ( 'text:' )? )
            // InternalBot.g:5451:2: ( 'text:' )?
            {
             before(grammarAccess.getTextAccess().getTextKeyword_5()); 
            // InternalBot.g:5452:2: ( 'text:' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==81) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBot.g:5452:3: 'text:'
                    {
                    match(input,81,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getTextAccess().getTextKeyword_5()); 

            }


            }

        }
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
    // InternalBot.g:5460:1: rule__Text__Group__6 : rule__Text__Group__6__Impl rule__Text__Group__7 ;
    public final void rule__Text__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5464:1: ( rule__Text__Group__6__Impl rule__Text__Group__7 )
            // InternalBot.g:5465:2: rule__Text__Group__6__Impl rule__Text__Group__7
            {
            pushFollow(FOLLOW_37);
            rule__Text__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__7();

            state._fsp--;


            }

        }
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
    // InternalBot.g:5472:1: rule__Text__Group__6__Impl : ( ( rule__Text__InputsAssignment_6 ) ) ;
    public final void rule__Text__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5476:1: ( ( ( rule__Text__InputsAssignment_6 ) ) )
            // InternalBot.g:5477:1: ( ( rule__Text__InputsAssignment_6 ) )
            {
            // InternalBot.g:5477:1: ( ( rule__Text__InputsAssignment_6 ) )
            // InternalBot.g:5478:2: ( rule__Text__InputsAssignment_6 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_6()); 
            // InternalBot.g:5479:2: ( rule__Text__InputsAssignment_6 )
            // InternalBot.g:5479:3: rule__Text__InputsAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Text__InputsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__Text__Group__7"
    // InternalBot.g:5487:1: rule__Text__Group__7 : rule__Text__Group__7__Impl ;
    public final void rule__Text__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5491:1: ( rule__Text__Group__7__Impl )
            // InternalBot.g:5492:2: rule__Text__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__7"


    // $ANTLR start "rule__Text__Group__7__Impl"
    // InternalBot.g:5498:1: rule__Text__Group__7__Impl : ( ( rule__Text__Group_7__0 )* ) ;
    public final void rule__Text__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5502:1: ( ( ( rule__Text__Group_7__0 )* ) )
            // InternalBot.g:5503:1: ( ( rule__Text__Group_7__0 )* )
            {
            // InternalBot.g:5503:1: ( ( rule__Text__Group_7__0 )* )
            // InternalBot.g:5504:2: ( rule__Text__Group_7__0 )*
            {
             before(grammarAccess.getTextAccess().getGroup_7()); 
            // InternalBot.g:5505:2: ( rule__Text__Group_7__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==54) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBot.g:5505:3: rule__Text__Group_7__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Text__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getTextAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__7__Impl"


    // $ANTLR start "rule__Text__Group_3__0"
    // InternalBot.g:5514:1: rule__Text__Group_3__0 : rule__Text__Group_3__0__Impl rule__Text__Group_3__1 ;
    public final void rule__Text__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5518:1: ( rule__Text__Group_3__0__Impl rule__Text__Group_3__1 )
            // InternalBot.g:5519:2: rule__Text__Group_3__0__Impl rule__Text__Group_3__1
            {
            pushFollow(FOLLOW_7);
            rule__Text__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_3__0"


    // $ANTLR start "rule__Text__Group_3__0__Impl"
    // InternalBot.g:5526:1: rule__Text__Group_3__0__Impl : ( 'in' ) ;
    public final void rule__Text__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5530:1: ( ( 'in' ) )
            // InternalBot.g:5531:1: ( 'in' )
            {
            // InternalBot.g:5531:1: ( 'in' )
            // InternalBot.g:5532:2: 'in'
            {
             before(grammarAccess.getTextAccess().getInKeyword_3_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getInKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_3__0__Impl"


    // $ANTLR start "rule__Text__Group_3__1"
    // InternalBot.g:5541:1: rule__Text__Group_3__1 : rule__Text__Group_3__1__Impl ;
    public final void rule__Text__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5545:1: ( rule__Text__Group_3__1__Impl )
            // InternalBot.g:5546:2: rule__Text__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_3__1"


    // $ANTLR start "rule__Text__Group_3__1__Impl"
    // InternalBot.g:5552:1: rule__Text__Group_3__1__Impl : ( ( rule__Text__LanguageAssignment_3_1 ) ) ;
    public final void rule__Text__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5556:1: ( ( ( rule__Text__LanguageAssignment_3_1 ) ) )
            // InternalBot.g:5557:1: ( ( rule__Text__LanguageAssignment_3_1 ) )
            {
            // InternalBot.g:5557:1: ( ( rule__Text__LanguageAssignment_3_1 ) )
            // InternalBot.g:5558:2: ( rule__Text__LanguageAssignment_3_1 )
            {
             before(grammarAccess.getTextAccess().getLanguageAssignment_3_1()); 
            // InternalBot.g:5559:2: ( rule__Text__LanguageAssignment_3_1 )
            // InternalBot.g:5559:3: rule__Text__LanguageAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Text__LanguageAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getLanguageAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_3__1__Impl"


    // $ANTLR start "rule__Text__Group_7__0"
    // InternalBot.g:5568:1: rule__Text__Group_7__0 : rule__Text__Group_7__0__Impl rule__Text__Group_7__1 ;
    public final void rule__Text__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5572:1: ( rule__Text__Group_7__0__Impl rule__Text__Group_7__1 )
            // InternalBot.g:5573:2: rule__Text__Group_7__0__Impl rule__Text__Group_7__1
            {
            pushFollow(FOLLOW_53);
            rule__Text__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_7__0"


    // $ANTLR start "rule__Text__Group_7__0__Impl"
    // InternalBot.g:5580:1: rule__Text__Group_7__0__Impl : ( ',' ) ;
    public final void rule__Text__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5584:1: ( ( ',' ) )
            // InternalBot.g:5585:1: ( ',' )
            {
            // InternalBot.g:5585:1: ( ',' )
            // InternalBot.g:5586:2: ','
            {
             before(grammarAccess.getTextAccess().getCommaKeyword_7_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getCommaKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_7__0__Impl"


    // $ANTLR start "rule__Text__Group_7__1"
    // InternalBot.g:5595:1: rule__Text__Group_7__1 : rule__Text__Group_7__1__Impl ;
    public final void rule__Text__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5599:1: ( rule__Text__Group_7__1__Impl )
            // InternalBot.g:5600:2: rule__Text__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_7__1"


    // $ANTLR start "rule__Text__Group_7__1__Impl"
    // InternalBot.g:5606:1: rule__Text__Group_7__1__Impl : ( ( rule__Text__InputsAssignment_7_1 ) ) ;
    public final void rule__Text__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5610:1: ( ( ( rule__Text__InputsAssignment_7_1 ) ) )
            // InternalBot.g:5611:1: ( ( rule__Text__InputsAssignment_7_1 ) )
            {
            // InternalBot.g:5611:1: ( ( rule__Text__InputsAssignment_7_1 ) )
            // InternalBot.g:5612:2: ( rule__Text__InputsAssignment_7_1 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_7_1()); 
            // InternalBot.g:5613:2: ( rule__Text__InputsAssignment_7_1 )
            // InternalBot.g:5613:3: rule__Text__InputsAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Text__InputsAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group_7__1__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__0"
    // InternalBot.g:5622:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5626:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:5627:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
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
    // InternalBot.g:5634:1: rule__HTTPResponse__Group__0__Impl : ( 'HttpResponse' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5638:1: ( ( 'HttpResponse' ) )
            // InternalBot.g:5639:1: ( 'HttpResponse' )
            {
            // InternalBot.g:5639:1: ( 'HttpResponse' )
            // InternalBot.g:5640:2: 'HttpResponse'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0()); 
            match(input,82,FOLLOW_2); 
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
    // InternalBot.g:5649:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5653:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:5654:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
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
    // InternalBot.g:5661:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5665:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:5666:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:5666:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:5667:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:5668:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:5668:3: rule__HTTPResponse__NameAssignment_1
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
    // InternalBot.g:5676:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5680:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:5681:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
            {
            pushFollow(FOLLOW_54);
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
    // InternalBot.g:5688:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5692:1: ( ( ':' ) )
            // InternalBot.g:5693:1: ( ':' )
            {
            // InternalBot.g:5693:1: ( ':' )
            // InternalBot.g:5694:2: ':'
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
    // InternalBot.g:5703:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5707:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:5708:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
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
    // InternalBot.g:5715:1: rule__HTTPResponse__Group__3__Impl : ( 'HttpRequest:' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5719:1: ( ( 'HttpRequest:' ) )
            // InternalBot.g:5720:1: ( 'HttpRequest:' )
            {
            // InternalBot.g:5720:1: ( 'HttpRequest:' )
            // InternalBot.g:5721:2: 'HttpRequest:'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3()); 
            match(input,83,FOLLOW_2); 
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
    // InternalBot.g:5730:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5734:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:5735:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
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
    // InternalBot.g:5742:1: rule__HTTPResponse__Group__4__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5746:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) )
            // InternalBot.g:5747:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            {
            // InternalBot.g:5747:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            // InternalBot.g:5748:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_4()); 
            // InternalBot.g:5749:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            // InternalBot.g:5749:3: rule__HTTPResponse__HTTPRequestAssignment_4
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
    // InternalBot.g:5757:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5761:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:5762:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
            {
            pushFollow(FOLLOW_55);
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
    // InternalBot.g:5769:1: rule__HTTPResponse__Group__5__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5773:1: ( ( ';' ) )
            // InternalBot.g:5774:1: ( ';' )
            {
            // InternalBot.g:5774:1: ( ';' )
            // InternalBot.g:5775:2: ';'
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
    // InternalBot.g:5784:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5788:1: ( rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 )
            // InternalBot.g:5789:2: rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7
            {
            pushFollow(FOLLOW_56);
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
    // InternalBot.g:5796:1: rule__HTTPResponse__Group__6__Impl : ( 'text:' ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5800:1: ( ( 'text:' ) )
            // InternalBot.g:5801:1: ( 'text:' )
            {
            // InternalBot.g:5801:1: ( 'text:' )
            // InternalBot.g:5802:2: 'text:'
            {
             before(grammarAccess.getHTTPResponseAccess().getTextKeyword_6()); 
            match(input,81,FOLLOW_2); 
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
    // InternalBot.g:5811:1: rule__HTTPResponse__Group__7 : rule__HTTPResponse__Group__7__Impl rule__HTTPResponse__Group__8 ;
    public final void rule__HTTPResponse__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5815:1: ( rule__HTTPResponse__Group__7__Impl rule__HTTPResponse__Group__8 )
            // InternalBot.g:5816:2: rule__HTTPResponse__Group__7__Impl rule__HTTPResponse__Group__8
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:5823:1: rule__HTTPResponse__Group__7__Impl : ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ;
    public final void rule__HTTPResponse__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5827:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) )
            // InternalBot.g:5828:1: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            {
            // InternalBot.g:5828:1: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            // InternalBot.g:5829:2: ( rule__HTTPResponse__InputsAssignment_7 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:5830:2: ( rule__HTTPResponse__InputsAssignment_7 )
            // InternalBot.g:5830:3: rule__HTTPResponse__InputsAssignment_7
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
    // InternalBot.g:5838:1: rule__HTTPResponse__Group__8 : rule__HTTPResponse__Group__8__Impl ;
    public final void rule__HTTPResponse__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5842:1: ( rule__HTTPResponse__Group__8__Impl )
            // InternalBot.g:5843:2: rule__HTTPResponse__Group__8__Impl
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
    // InternalBot.g:5849:1: rule__HTTPResponse__Group__8__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5853:1: ( ( ';' ) )
            // InternalBot.g:5854:1: ( ';' )
            {
            // InternalBot.g:5854:1: ( ';' )
            // InternalBot.g:5855:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_8()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:5865:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5869:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:5870:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalBot.g:5877:1: rule__HTTPRequest__Group__0__Impl : ( 'HTTP' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5881:1: ( ( 'HTTP' ) )
            // InternalBot.g:5882:1: ( 'HTTP' )
            {
            // InternalBot.g:5882:1: ( 'HTTP' )
            // InternalBot.g:5883:2: 'HTTP'
            {
             before(grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0()); 
            match(input,84,FOLLOW_2); 
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
    // InternalBot.g:5892:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5896:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:5897:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
            {
            pushFollow(FOLLOW_58);
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
    // InternalBot.g:5904:1: rule__HTTPRequest__Group__1__Impl : ( 'request' ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5908:1: ( ( 'request' ) )
            // InternalBot.g:5909:1: ( 'request' )
            {
            // InternalBot.g:5909:1: ( 'request' )
            // InternalBot.g:5910:2: 'request'
            {
             before(grammarAccess.getHTTPRequestAccess().getRequestKeyword_1()); 
            match(input,85,FOLLOW_2); 
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
    // InternalBot.g:5919:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5923:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:5924:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
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
    // InternalBot.g:5931:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__MethodAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5935:1: ( ( ( rule__HTTPRequest__MethodAssignment_2 ) ) )
            // InternalBot.g:5936:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            {
            // InternalBot.g:5936:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            // InternalBot.g:5937:2: ( rule__HTTPRequest__MethodAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_2()); 
            // InternalBot.g:5938:2: ( rule__HTTPRequest__MethodAssignment_2 )
            // InternalBot.g:5938:3: rule__HTTPRequest__MethodAssignment_2
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
    // InternalBot.g:5946:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5950:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:5951:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
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
    // InternalBot.g:5958:1: rule__HTTPRequest__Group__3__Impl : ( ( rule__HTTPRequest__NameAssignment_3 ) ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5962:1: ( ( ( rule__HTTPRequest__NameAssignment_3 ) ) )
            // InternalBot.g:5963:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            {
            // InternalBot.g:5963:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            // InternalBot.g:5964:2: ( rule__HTTPRequest__NameAssignment_3 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_3()); 
            // InternalBot.g:5965:2: ( rule__HTTPRequest__NameAssignment_3 )
            // InternalBot.g:5965:3: rule__HTTPRequest__NameAssignment_3
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
    // InternalBot.g:5973:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5977:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:5978:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
            {
            pushFollow(FOLLOW_59);
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
    // InternalBot.g:5985:1: rule__HTTPRequest__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5989:1: ( ( ':' ) )
            // InternalBot.g:5990:1: ( ':' )
            {
            // InternalBot.g:5990:1: ( ':' )
            // InternalBot.g:5991:2: ':'
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
    // InternalBot.g:6000:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6004:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:6005:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
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
    // InternalBot.g:6012:1: rule__HTTPRequest__Group__5__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6016:1: ( ( 'URL' ) )
            // InternalBot.g:6017:1: ( 'URL' )
            {
            // InternalBot.g:6017:1: ( 'URL' )
            // InternalBot.g:6018:2: 'URL'
            {
             before(grammarAccess.getHTTPRequestAccess().getURLKeyword_5()); 
            match(input,86,FOLLOW_2); 
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
    // InternalBot.g:6027:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6031:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:6032:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
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
    // InternalBot.g:6039:1: rule__HTTPRequest__Group__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6043:1: ( ( ':' ) )
            // InternalBot.g:6044:1: ( ':' )
            {
            // InternalBot.g:6044:1: ( ':' )
            // InternalBot.g:6045:2: ':'
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
    // InternalBot.g:6054:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6058:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:6059:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
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
    // InternalBot.g:6066:1: rule__HTTPRequest__Group__7__Impl : ( ( rule__HTTPRequest__URLAssignment_7 ) ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6070:1: ( ( ( rule__HTTPRequest__URLAssignment_7 ) ) )
            // InternalBot.g:6071:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            {
            // InternalBot.g:6071:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            // InternalBot.g:6072:2: ( rule__HTTPRequest__URLAssignment_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_7()); 
            // InternalBot.g:6073:2: ( rule__HTTPRequest__URLAssignment_7 )
            // InternalBot.g:6073:3: rule__HTTPRequest__URLAssignment_7
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
    // InternalBot.g:6081:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6085:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:6086:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
            {
            pushFollow(FOLLOW_60);
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
    // InternalBot.g:6093:1: rule__HTTPRequest__Group__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6097:1: ( ( ';' ) )
            // InternalBot.g:6098:1: ( ';' )
            {
            // InternalBot.g:6098:1: ( ';' )
            // InternalBot.g:6099:2: ';'
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
    // InternalBot.g:6108:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6112:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:6113:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
            {
            pushFollow(FOLLOW_60);
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
    // InternalBot.g:6120:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6124:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:6125:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:6125:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:6126:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:6127:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==87) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalBot.g:6127:3: rule__HTTPRequest__Group_9__0
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
    // InternalBot.g:6135:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6139:1: ( rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 )
            // InternalBot.g:6140:2: rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11
            {
            pushFollow(FOLLOW_60);
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
    // InternalBot.g:6147:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6151:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:6152:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:6152:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:6153:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:6154:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==88) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:6154:3: rule__HTTPRequest__Group_10__0
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
    // InternalBot.g:6162:1: rule__HTTPRequest__Group__11 : rule__HTTPRequest__Group__11__Impl ;
    public final void rule__HTTPRequest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6166:1: ( rule__HTTPRequest__Group__11__Impl )
            // InternalBot.g:6167:2: rule__HTTPRequest__Group__11__Impl
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
    // InternalBot.g:6173:1: rule__HTTPRequest__Group__11__Impl : ( ( rule__HTTPRequest__Group_11__0 )? ) ;
    public final void rule__HTTPRequest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6177:1: ( ( ( rule__HTTPRequest__Group_11__0 )? ) )
            // InternalBot.g:6178:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            {
            // InternalBot.g:6178:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            // InternalBot.g:6179:2: ( rule__HTTPRequest__Group_11__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11()); 
            // InternalBot.g:6180:2: ( rule__HTTPRequest__Group_11__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==18) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalBot.g:6180:3: rule__HTTPRequest__Group_11__0
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
    // InternalBot.g:6189:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6193:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:6194:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
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
    // InternalBot.g:6201:1: rule__HTTPRequest__Group_9__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6205:1: ( ( 'basicAuth' ) )
            // InternalBot.g:6206:1: ( 'basicAuth' )
            {
            // InternalBot.g:6206:1: ( 'basicAuth' )
            // InternalBot.g:6207:2: 'basicAuth'
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0()); 
            match(input,87,FOLLOW_2); 
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
    // InternalBot.g:6216:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6220:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:6221:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
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
    // InternalBot.g:6228:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6232:1: ( ( ':' ) )
            // InternalBot.g:6233:1: ( ':' )
            {
            // InternalBot.g:6233:1: ( ':' )
            // InternalBot.g:6234:2: ':'
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
    // InternalBot.g:6243:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6247:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:6248:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
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
    // InternalBot.g:6255:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6259:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) )
            // InternalBot.g:6260:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            {
            // InternalBot.g:6260:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            // InternalBot.g:6261:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_9_2()); 
            // InternalBot.g:6262:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            // InternalBot.g:6262:3: rule__HTTPRequest__BasicAuthAssignment_9_2
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
    // InternalBot.g:6270:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6274:1: ( rule__HTTPRequest__Group_9__3__Impl )
            // InternalBot.g:6275:2: rule__HTTPRequest__Group_9__3__Impl
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
    // InternalBot.g:6281:1: rule__HTTPRequest__Group_9__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6285:1: ( ( ';' ) )
            // InternalBot.g:6286:1: ( ';' )
            {
            // InternalBot.g:6286:1: ( ';' )
            // InternalBot.g:6287:2: ';'
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
    // InternalBot.g:6297:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6301:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:6302:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
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
    // InternalBot.g:6309:1: rule__HTTPRequest__Group_10__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6313:1: ( ( 'headers' ) )
            // InternalBot.g:6314:1: ( 'headers' )
            {
            // InternalBot.g:6314:1: ( 'headers' )
            // InternalBot.g:6315:2: 'headers'
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0()); 
            match(input,88,FOLLOW_2); 
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
    // InternalBot.g:6324:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6328:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:6329:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
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
    // InternalBot.g:6336:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6340:1: ( ( ':' ) )
            // InternalBot.g:6341:1: ( ':' )
            {
            // InternalBot.g:6341:1: ( ':' )
            // InternalBot.g:6342:2: ':'
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
    // InternalBot.g:6351:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6355:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:6356:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
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
    // InternalBot.g:6363:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6367:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) )
            // InternalBot.g:6368:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            {
            // InternalBot.g:6368:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            // InternalBot.g:6369:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_2()); 
            // InternalBot.g:6370:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            // InternalBot.g:6370:3: rule__HTTPRequest__HeadersAssignment_10_2
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
    // InternalBot.g:6378:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6382:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:6383:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
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
    // InternalBot.g:6390:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6394:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:6395:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:6395:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:6396:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:6397:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==54) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBot.g:6397:3: rule__HTTPRequest__Group_10_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HTTPRequest__Group_10_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
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
    // InternalBot.g:6405:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6409:1: ( rule__HTTPRequest__Group_10__4__Impl )
            // InternalBot.g:6410:2: rule__HTTPRequest__Group_10__4__Impl
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
    // InternalBot.g:6416:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6420:1: ( ( ';' ) )
            // InternalBot.g:6421:1: ( ';' )
            {
            // InternalBot.g:6421:1: ( ';' )
            // InternalBot.g:6422:2: ';'
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
    // InternalBot.g:6432:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6436:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:6437:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
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
    // InternalBot.g:6444:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6448:1: ( ( ',' ) )
            // InternalBot.g:6449:1: ( ',' )
            {
            // InternalBot.g:6449:1: ( ',' )
            // InternalBot.g:6450:2: ','
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
    // InternalBot.g:6459:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6463:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:6464:2: rule__HTTPRequest__Group_10_3__1__Impl
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
    // InternalBot.g:6470:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6474:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) )
            // InternalBot.g:6475:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            {
            // InternalBot.g:6475:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            // InternalBot.g:6476:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_3_1()); 
            // InternalBot.g:6477:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            // InternalBot.g:6477:3: rule__HTTPRequest__HeadersAssignment_10_3_1
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
    // InternalBot.g:6486:1: rule__HTTPRequest__Group_11__0 : rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 ;
    public final void rule__HTTPRequest__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6490:1: ( rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 )
            // InternalBot.g:6491:2: rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1
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
    // InternalBot.g:6498:1: rule__HTTPRequest__Group_11__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6502:1: ( ( 'data' ) )
            // InternalBot.g:6503:1: ( 'data' )
            {
            // InternalBot.g:6503:1: ( 'data' )
            // InternalBot.g:6504:2: 'data'
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
    // InternalBot.g:6513:1: rule__HTTPRequest__Group_11__1 : rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 ;
    public final void rule__HTTPRequest__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6517:1: ( rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 )
            // InternalBot.g:6518:2: rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2
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
    // InternalBot.g:6525:1: rule__HTTPRequest__Group_11__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6529:1: ( ( ':' ) )
            // InternalBot.g:6530:1: ( ':' )
            {
            // InternalBot.g:6530:1: ( ':' )
            // InternalBot.g:6531:2: ':'
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
    // InternalBot.g:6540:1: rule__HTTPRequest__Group_11__2 : rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 ;
    public final void rule__HTTPRequest__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6544:1: ( rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 )
            // InternalBot.g:6545:2: rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3
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
    // InternalBot.g:6552:1: rule__HTTPRequest__Group_11__2__Impl : ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) ;
    public final void rule__HTTPRequest__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6556:1: ( ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) )
            // InternalBot.g:6557:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            {
            // InternalBot.g:6557:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            // InternalBot.g:6558:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_2()); 
            // InternalBot.g:6559:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            // InternalBot.g:6559:3: rule__HTTPRequest__DataAssignment_11_2
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
    // InternalBot.g:6567:1: rule__HTTPRequest__Group_11__3 : rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 ;
    public final void rule__HTTPRequest__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6571:1: ( rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 )
            // InternalBot.g:6572:2: rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4
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
    // InternalBot.g:6579:1: rule__HTTPRequest__Group_11__3__Impl : ( ( rule__HTTPRequest__Group_11_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6583:1: ( ( ( rule__HTTPRequest__Group_11_3__0 )* ) )
            // InternalBot.g:6584:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            {
            // InternalBot.g:6584:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            // InternalBot.g:6585:2: ( rule__HTTPRequest__Group_11_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11_3()); 
            // InternalBot.g:6586:2: ( rule__HTTPRequest__Group_11_3__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==54) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalBot.g:6586:3: rule__HTTPRequest__Group_11_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HTTPRequest__Group_11_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // InternalBot.g:6594:1: rule__HTTPRequest__Group_11__4 : rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 ;
    public final void rule__HTTPRequest__Group_11__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6598:1: ( rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 )
            // InternalBot.g:6599:2: rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5
            {
            pushFollow(FOLLOW_61);
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
    // InternalBot.g:6606:1: rule__HTTPRequest__Group_11__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6610:1: ( ( ';' ) )
            // InternalBot.g:6611:1: ( ';' )
            {
            // InternalBot.g:6611:1: ( ';' )
            // InternalBot.g:6612:2: ';'
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
    // InternalBot.g:6621:1: rule__HTTPRequest__Group_11__5 : rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 ;
    public final void rule__HTTPRequest__Group_11__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6625:1: ( rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 )
            // InternalBot.g:6626:2: rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6
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
    // InternalBot.g:6633:1: rule__HTTPRequest__Group_11__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_11__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6637:1: ( ( 'dataType' ) )
            // InternalBot.g:6638:1: ( 'dataType' )
            {
            // InternalBot.g:6638:1: ( 'dataType' )
            // InternalBot.g:6639:2: 'dataType'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5()); 
            match(input,89,FOLLOW_2); 
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
    // InternalBot.g:6648:1: rule__HTTPRequest__Group_11__6 : rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 ;
    public final void rule__HTTPRequest__Group_11__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6652:1: ( rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 )
            // InternalBot.g:6653:2: rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7
            {
            pushFollow(FOLLOW_62);
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
    // InternalBot.g:6660:1: rule__HTTPRequest__Group_11__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6664:1: ( ( ':' ) )
            // InternalBot.g:6665:1: ( ':' )
            {
            // InternalBot.g:6665:1: ( ':' )
            // InternalBot.g:6666:2: ':'
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
    // InternalBot.g:6675:1: rule__HTTPRequest__Group_11__7 : rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 ;
    public final void rule__HTTPRequest__Group_11__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6679:1: ( rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 )
            // InternalBot.g:6680:2: rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8
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
    // InternalBot.g:6687:1: rule__HTTPRequest__Group_11__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) ;
    public final void rule__HTTPRequest__Group_11__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6691:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) )
            // InternalBot.g:6692:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            {
            // InternalBot.g:6692:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            // InternalBot.g:6693:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_11_7()); 
            // InternalBot.g:6694:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            // InternalBot.g:6694:3: rule__HTTPRequest__DataTypeAssignment_11_7
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
    // InternalBot.g:6702:1: rule__HTTPRequest__Group_11__8 : rule__HTTPRequest__Group_11__8__Impl ;
    public final void rule__HTTPRequest__Group_11__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6706:1: ( rule__HTTPRequest__Group_11__8__Impl )
            // InternalBot.g:6707:2: rule__HTTPRequest__Group_11__8__Impl
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
    // InternalBot.g:6713:1: rule__HTTPRequest__Group_11__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6717:1: ( ( ';' ) )
            // InternalBot.g:6718:1: ( ';' )
            {
            // InternalBot.g:6718:1: ( ';' )
            // InternalBot.g:6719:2: ';'
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
    // InternalBot.g:6729:1: rule__HTTPRequest__Group_11_3__0 : rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 ;
    public final void rule__HTTPRequest__Group_11_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6733:1: ( rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 )
            // InternalBot.g:6734:2: rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1
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
    // InternalBot.g:6741:1: rule__HTTPRequest__Group_11_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_11_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6745:1: ( ( ',' ) )
            // InternalBot.g:6746:1: ( ',' )
            {
            // InternalBot.g:6746:1: ( ',' )
            // InternalBot.g:6747:2: ','
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
    // InternalBot.g:6756:1: rule__HTTPRequest__Group_11_3__1 : rule__HTTPRequest__Group_11_3__1__Impl ;
    public final void rule__HTTPRequest__Group_11_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6760:1: ( rule__HTTPRequest__Group_11_3__1__Impl )
            // InternalBot.g:6761:2: rule__HTTPRequest__Group_11_3__1__Impl
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
    // InternalBot.g:6767:1: rule__HTTPRequest__Group_11_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_11_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6771:1: ( ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) )
            // InternalBot.g:6772:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            {
            // InternalBot.g:6772:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            // InternalBot.g:6773:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_3_1()); 
            // InternalBot.g:6774:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            // InternalBot.g:6774:3: rule__HTTPRequest__DataAssignment_11_3_1
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
    // InternalBot.g:6783:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6787:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:6788:2: rule__Image__Group__0__Impl rule__Image__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalBot.g:6795:1: rule__Image__Group__0__Impl : ( 'image' ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6799:1: ( ( 'image' ) )
            // InternalBot.g:6800:1: ( 'image' )
            {
            // InternalBot.g:6800:1: ( 'image' )
            // InternalBot.g:6801:2: 'image'
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
    // InternalBot.g:6810:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6814:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:6815:2: rule__Image__Group__1__Impl rule__Image__Group__2
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
    // InternalBot.g:6822:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6826:1: ( ( 'response' ) )
            // InternalBot.g:6827:1: ( 'response' )
            {
            // InternalBot.g:6827:1: ( 'response' )
            // InternalBot.g:6828:2: 'response'
            {
             before(grammarAccess.getImageAccess().getResponseKeyword_1()); 
            match(input,80,FOLLOW_2); 
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
    // InternalBot.g:6837:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6841:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:6842:2: rule__Image__Group__2__Impl rule__Image__Group__3
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
    // InternalBot.g:6849:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6853:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:6854:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:6854:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:6855:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:6856:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:6856:3: rule__Image__NameAssignment_2
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
    // InternalBot.g:6864:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6868:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:6869:2: rule__Image__Group__3__Impl rule__Image__Group__4
            {
            pushFollow(FOLLOW_59);
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
    // InternalBot.g:6876:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6880:1: ( ( ':' ) )
            // InternalBot.g:6881:1: ( ':' )
            {
            // InternalBot.g:6881:1: ( ':' )
            // InternalBot.g:6882:2: ':'
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
    // InternalBot.g:6891:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6895:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:6896:2: rule__Image__Group__4__Impl rule__Image__Group__5
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
    // InternalBot.g:6903:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6907:1: ( ( 'URL' ) )
            // InternalBot.g:6908:1: ( 'URL' )
            {
            // InternalBot.g:6908:1: ( 'URL' )
            // InternalBot.g:6909:2: 'URL'
            {
             before(grammarAccess.getImageAccess().getURLKeyword_4()); 
            match(input,86,FOLLOW_2); 
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
    // InternalBot.g:6918:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6922:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:6923:2: rule__Image__Group__5__Impl rule__Image__Group__6
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
    // InternalBot.g:6930:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6934:1: ( ( ':' ) )
            // InternalBot.g:6935:1: ( ':' )
            {
            // InternalBot.g:6935:1: ( ':' )
            // InternalBot.g:6936:2: ':'
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
    // InternalBot.g:6945:1: rule__Image__Group__6 : rule__Image__Group__6__Impl ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6949:1: ( rule__Image__Group__6__Impl )
            // InternalBot.g:6950:2: rule__Image__Group__6__Impl
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
    // InternalBot.g:6956:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6960:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:6961:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:6961:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:6962:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:6963:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:6963:3: rule__Image__URLAssignment_6
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
    // InternalBot.g:6972:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6976:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:6977:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
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
    // InternalBot.g:6984:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6988:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:6989:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:6989:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:6990:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:6991:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:6991:3: rule__KeyValue__KeyAssignment_0
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
    // InternalBot.g:6999:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7003:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:7004:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalBot.g:7011:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7015:1: ( ( ':' ) )
            // InternalBot.g:7016:1: ( ':' )
            {
            // InternalBot.g:7016:1: ( ':' )
            // InternalBot.g:7017:2: ':'
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
    // InternalBot.g:7026:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7030:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:7031:2: rule__KeyValue__Group__2__Impl
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
    // InternalBot.g:7037:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7041:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:7042:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:7042:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:7043:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:7044:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:7044:3: rule__KeyValue__ValueAssignment_2
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
    // InternalBot.g:7053:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7057:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:7058:2: rule__Data__Group__0__Impl rule__Data__Group__1
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
    // InternalBot.g:7065:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7069:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:7070:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:7070:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:7071:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:7072:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:7072:3: rule__Data__KeyAssignment_0
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
    // InternalBot.g:7080:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7084:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:7085:2: rule__Data__Group__1__Impl rule__Data__Group__2
            {
            pushFollow(FOLLOW_63);
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
    // InternalBot.g:7092:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7096:1: ( ( ':' ) )
            // InternalBot.g:7097:1: ( ':' )
            {
            // InternalBot.g:7097:1: ( ':' )
            // InternalBot.g:7098:2: ':'
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
    // InternalBot.g:7107:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7111:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:7112:2: rule__Data__Group__2__Impl
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
    // InternalBot.g:7118:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7122:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:7123:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:7123:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:7124:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:7125:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:7125:3: rule__Data__ValueAssignment_2
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
    // InternalBot.g:7134:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7138:1: ( ( ruleEString ) )
            // InternalBot.g:7139:2: ( ruleEString )
            {
            // InternalBot.g:7139:2: ( ruleEString )
            // InternalBot.g:7140:3: ruleEString
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
    // InternalBot.g:7149:1: rule__Bot__LanguagesAssignment_3 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7153:1: ( ( ruleLanguage ) )
            // InternalBot.g:7154:2: ( ruleLanguage )
            {
            // InternalBot.g:7154:2: ( ruleLanguage )
            // InternalBot.g:7155:3: ruleLanguage
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
    // InternalBot.g:7164:1: rule__Bot__LanguagesAssignment_4_1 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7168:1: ( ( ruleLanguage ) )
            // InternalBot.g:7169:2: ( ruleLanguage )
            {
            // InternalBot.g:7169:2: ( ruleLanguage )
            // InternalBot.g:7170:3: ruleLanguage
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
    // InternalBot.g:7179:1: rule__Bot__IntentsAssignment_7 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7183:1: ( ( ruleIntent ) )
            // InternalBot.g:7184:2: ( ruleIntent )
            {
            // InternalBot.g:7184:2: ( ruleIntent )
            // InternalBot.g:7185:3: ruleIntent
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
    // InternalBot.g:7194:1: rule__Bot__IntentsAssignment_8 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7198:1: ( ( ruleIntent ) )
            // InternalBot.g:7199:2: ( ruleIntent )
            {
            // InternalBot.g:7199:2: ( ruleIntent )
            // InternalBot.g:7200:3: ruleIntent
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
    // InternalBot.g:7209:1: rule__Bot__EntitiesAssignment_9_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7213:1: ( ( ruleEntity ) )
            // InternalBot.g:7214:2: ( ruleEntity )
            {
            // InternalBot.g:7214:2: ( ruleEntity )
            // InternalBot.g:7215:3: ruleEntity
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
    // InternalBot.g:7224:1: rule__Bot__EntitiesAssignment_9_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7228:1: ( ( ruleEntity ) )
            // InternalBot.g:7229:2: ( ruleEntity )
            {
            // InternalBot.g:7229:2: ( ruleEntity )
            // InternalBot.g:7230:3: ruleEntity
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
    // InternalBot.g:7239:1: rule__Bot__ActionsAssignment_10_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7243:1: ( ( ruleAction ) )
            // InternalBot.g:7244:2: ( ruleAction )
            {
            // InternalBot.g:7244:2: ( ruleAction )
            // InternalBot.g:7245:3: ruleAction
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
    // InternalBot.g:7254:1: rule__Bot__ActionsAssignment_10_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7258:1: ( ( ruleAction ) )
            // InternalBot.g:7259:2: ( ruleAction )
            {
            // InternalBot.g:7259:2: ( ruleAction )
            // InternalBot.g:7260:3: ruleAction
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
    // InternalBot.g:7269:1: rule__Bot__FlowsAssignment_13_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7273:1: ( ( ruleTransition ) )
            // InternalBot.g:7274:2: ( ruleTransition )
            {
            // InternalBot.g:7274:2: ( ruleTransition )
            // InternalBot.g:7275:3: ruleTransition
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
    // InternalBot.g:7284:1: rule__Intent__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7288:1: ( ( ruleEString ) )
            // InternalBot.g:7289:2: ( ruleEString )
            {
            // InternalBot.g:7289:2: ( ruleEString )
            // InternalBot.g:7290:3: ruleEString
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
    // InternalBot.g:7299:1: rule__Intent__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7303:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:7304:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:7304:2: ( ( 'Fallback' ) )
            // InternalBot.g:7305:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:7306:3: ( 'Fallback' )
            // InternalBot.g:7307:4: 'Fallback'
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,90,FOLLOW_2); 
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


    // $ANTLR start "rule__Intent__LanguageAssignment_2_2"
    // InternalBot.g:7318:1: rule__Intent__LanguageAssignment_2_2 : ( ruleLanguage ) ;
    public final void rule__Intent__LanguageAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7322:1: ( ( ruleLanguage ) )
            // InternalBot.g:7323:2: ( ruleLanguage )
            {
            // InternalBot.g:7323:2: ( ruleLanguage )
            // InternalBot.g:7324:3: ruleLanguage
            {
             before(grammarAccess.getIntentAccess().getLanguageLanguageEnumRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getLanguageLanguageEnumRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__LanguageAssignment_2_2"


    // $ANTLR start "rule__Intent__InputsAssignment_5"
    // InternalBot.g:7333:1: rule__Intent__InputsAssignment_5 : ( ruleTrainingPhrase ) ;
    public final void rule__Intent__InputsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7337:1: ( ( ruleTrainingPhrase ) )
            // InternalBot.g:7338:2: ( ruleTrainingPhrase )
            {
            // InternalBot.g:7338:2: ( ruleTrainingPhrase )
            // InternalBot.g:7339:3: ruleTrainingPhrase
            {
             before(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__InputsAssignment_5"


    // $ANTLR start "rule__Intent__InputsAssignment_6_1"
    // InternalBot.g:7348:1: rule__Intent__InputsAssignment_6_1 : ( ruleTrainingPhrase ) ;
    public final void rule__Intent__InputsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7352:1: ( ( ruleTrainingPhrase ) )
            // InternalBot.g:7353:2: ( ruleTrainingPhrase )
            {
            // InternalBot.g:7353:2: ( ruleTrainingPhrase )
            // InternalBot.g:7354:3: ruleTrainingPhrase
            {
             before(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__InputsAssignment_6_1"


    // $ANTLR start "rule__Intent__ParametersAssignment_7_1"
    // InternalBot.g:7363:1: rule__Intent__ParametersAssignment_7_1 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7367:1: ( ( ruleParameter ) )
            // InternalBot.g:7368:2: ( ruleParameter )
            {
            // InternalBot.g:7368:2: ( ruleParameter )
            // InternalBot.g:7369:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_7_1"


    // $ANTLR start "rule__Intent__ParametersAssignment_7_2"
    // InternalBot.g:7378:1: rule__Intent__ParametersAssignment_7_2 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7382:1: ( ( ruleParameter ) )
            // InternalBot.g:7383:2: ( ruleParameter )
            {
            // InternalBot.g:7383:2: ( ruleParameter )
            // InternalBot.g:7384:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_7_2"


    // $ANTLR start "rule__Transition__IntentAssignment_1"
    // InternalBot.g:7393:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7397:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7398:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7398:2: ( ( ruleEString ) )
            // InternalBot.g:7399:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:7400:3: ( ruleEString )
            // InternalBot.g:7401:4: ruleEString
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
    // InternalBot.g:7412:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7416:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:7417:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:7417:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:7418:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:7419:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:7419:4: rule__Transition__TargetAlternatives_2_1_0
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
    // InternalBot.g:7427:1: rule__State__ActionsAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7431:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7432:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7432:2: ( ( ruleEString ) )
            // InternalBot.g:7433:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0()); 
            // InternalBot.g:7434:3: ( ruleEString )
            // InternalBot.g:7435:4: ruleEString
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
    // InternalBot.g:7446:1: rule__State__ActionsAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7450:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7451:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7451:2: ( ( ruleEString ) )
            // InternalBot.g:7452:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0()); 
            // InternalBot.g:7453:3: ( ruleEString )
            // InternalBot.g:7454:4: ruleEString
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
    // InternalBot.g:7465:1: rule__State__OutcomingAssignment_5_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7469:1: ( ( ruleTransition ) )
            // InternalBot.g:7470:2: ( ruleTransition )
            {
            // InternalBot.g:7470:2: ( ruleTransition )
            // InternalBot.g:7471:3: ruleTransition
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
    // InternalBot.g:7480:1: rule__State2__ActionsAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7484:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7485:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7485:2: ( ( ruleEString ) )
            // InternalBot.g:7486:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_0()); 
            // InternalBot.g:7487:3: ( ruleEString )
            // InternalBot.g:7488:4: ruleEString
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
    // InternalBot.g:7499:1: rule__State2__ActionsAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7503:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7504:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7504:2: ( ( ruleEString ) )
            // InternalBot.g:7505:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0()); 
            // InternalBot.g:7506:3: ( ruleEString )
            // InternalBot.g:7507:4: ruleEString
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
    // InternalBot.g:7518:1: rule__State2__OutcomingAssignment_6_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7522:1: ( ( ruleTransition ) )
            // InternalBot.g:7523:2: ( ruleTransition )
            {
            // InternalBot.g:7523:2: ( ruleTransition )
            // InternalBot.g:7524:3: ruleTransition
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
    // InternalBot.g:7533:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7537:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:7538:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:7538:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:7539:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:7540:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:7540:4: rule__TrainingPhrase__TokensAlternatives_1_0
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
    // InternalBot.g:7548:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7552:1: ( ( ruleEString ) )
            // InternalBot.g:7553:2: ( ruleEString )
            {
            // InternalBot.g:7553:2: ( ruleEString )
            // InternalBot.g:7554:3: ruleEString
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
    // InternalBot.g:7563:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7567:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7568:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7568:2: ( ( ruleEString ) )
            // InternalBot.g:7569:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:7570:3: ( ruleEString )
            // InternalBot.g:7571:4: ruleEString
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
    // InternalBot.g:7582:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7586:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:7587:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:7587:2: ( ruleDefaultEntity )
            // InternalBot.g:7588:3: ruleDefaultEntity
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
    // InternalBot.g:7597:1: rule__Parameter__RequiredAssignment_4_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7601:1: ( ( ( 'required' ) ) )
            // InternalBot.g:7602:2: ( ( 'required' ) )
            {
            // InternalBot.g:7602:2: ( ( 'required' ) )
            // InternalBot.g:7603:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            // InternalBot.g:7604:3: ( 'required' )
            // InternalBot.g:7605:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            match(input,91,FOLLOW_2); 
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


    // $ANTLR start "rule__Parameter__PrompLanguageAssignment_4_2_2_1"
    // InternalBot.g:7616:1: rule__Parameter__PrompLanguageAssignment_4_2_2_1 : ( ruleLanguage ) ;
    public final void rule__Parameter__PrompLanguageAssignment_4_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7620:1: ( ( ruleLanguage ) )
            // InternalBot.g:7621:2: ( ruleLanguage )
            {
            // InternalBot.g:7621:2: ( ruleLanguage )
            // InternalBot.g:7622:3: ruleLanguage
            {
             before(grammarAccess.getParameterAccess().getPrompLanguageLanguageEnumRuleCall_4_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPrompLanguageLanguageEnumRuleCall_4_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PrompLanguageAssignment_4_2_2_1"


    // $ANTLR start "rule__Parameter__PromptsAssignment_4_2_4"
    // InternalBot.g:7631:1: rule__Parameter__PromptsAssignment_4_2_4 : ( ruleEString ) ;
    public final void rule__Parameter__PromptsAssignment_4_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7635:1: ( ( ruleEString ) )
            // InternalBot.g:7636:2: ( ruleEString )
            {
            // InternalBot.g:7636:2: ( ruleEString )
            // InternalBot.g:7637:3: ruleEString
            {
             before(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_4_2_4"


    // $ANTLR start "rule__Parameter__PromptsAssignment_4_2_5_1"
    // InternalBot.g:7646:1: rule__Parameter__PromptsAssignment_4_2_5_1 : ( ruleEString ) ;
    public final void rule__Parameter__PromptsAssignment_4_2_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7650:1: ( ( ruleEString ) )
            // InternalBot.g:7651:2: ( ruleEString )
            {
            // InternalBot.g:7651:2: ( ruleEString )
            // InternalBot.g:7652:3: ruleEString
            {
             before(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_4_2_5_1"


    // $ANTLR start "rule__Parameter__IsListAssignment_5_1"
    // InternalBot.g:7661:1: rule__Parameter__IsListAssignment_5_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7665:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:7666:2: ( ( 'isList' ) )
            {
            // InternalBot.g:7666:2: ( ( 'isList' ) )
            // InternalBot.g:7667:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 
            // InternalBot.g:7668:3: ( 'isList' )
            // InternalBot.g:7669:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0()); 
            match(input,92,FOLLOW_2); 
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
    // InternalBot.g:7680:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7684:1: ( ( ruleEString ) )
            // InternalBot.g:7685:2: ( ruleEString )
            {
            // InternalBot.g:7685:2: ( ruleEString )
            // InternalBot.g:7686:3: ruleEString
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
    // InternalBot.g:7695:1: rule__EntityToken__EntityAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7699:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7700:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7700:2: ( ( ruleEString ) )
            // InternalBot.g:7701:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 
            // InternalBot.g:7702:3: ( ruleEString )
            // InternalBot.g:7703:4: ruleEString
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
    // InternalBot.g:7714:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7718:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7719:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7719:2: ( ( ruleEString ) )
            // InternalBot.g:7720:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:7721:3: ( ruleEString )
            // InternalBot.g:7722:4: ruleEString
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
    // InternalBot.g:7733:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7737:1: ( ( ruleEString ) )
            // InternalBot.g:7738:2: ( ruleEString )
            {
            // InternalBot.g:7738:2: ( ruleEString )
            // InternalBot.g:7739:3: ruleEString
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
    // InternalBot.g:7748:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7752:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7753:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7753:2: ( ( ruleEString ) )
            // InternalBot.g:7754:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:7755:3: ( ruleEString )
            // InternalBot.g:7756:4: ruleEString
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
    // InternalBot.g:7767:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7771:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:7772:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:7772:2: ( ruleHTTPReturnType )
            // InternalBot.g:7773:3: ruleHTTPReturnType
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
    // InternalBot.g:7782:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7786:1: ( ( ruleEString ) )
            // InternalBot.g:7787:2: ( ruleEString )
            {
            // InternalBot.g:7787:2: ( ruleEString )
            // InternalBot.g:7788:3: ruleEString
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
    // InternalBot.g:7797:1: rule__Simple__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__Simple__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7801:1: ( ( ruleEString ) )
            // InternalBot.g:7802:2: ( ruleEString )
            {
            // InternalBot.g:7802:2: ( ruleEString )
            // InternalBot.g:7803:3: ruleEString
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


    // $ANTLR start "rule__Simple__LanguageAssignment_4_1"
    // InternalBot.g:7812:1: rule__Simple__LanguageAssignment_4_1 : ( ruleLanguage ) ;
    public final void rule__Simple__LanguageAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7816:1: ( ( ruleLanguage ) )
            // InternalBot.g:7817:2: ( ruleLanguage )
            {
            // InternalBot.g:7817:2: ( ruleLanguage )
            // InternalBot.g:7818:3: ruleLanguage
            {
             before(grammarAccess.getSimpleAccess().getLanguageLanguageEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getLanguageLanguageEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__LanguageAssignment_4_1"


    // $ANTLR start "rule__Simple__InputsAssignment_6_0"
    // InternalBot.g:7827:1: rule__Simple__InputsAssignment_6_0 : ( ruleSimpleInput ) ;
    public final void rule__Simple__InputsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7831:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:7832:2: ( ruleSimpleInput )
            {
            // InternalBot.g:7832:2: ( ruleSimpleInput )
            // InternalBot.g:7833:3: ruleSimpleInput
            {
             before(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__InputsAssignment_6_0"


    // $ANTLR start "rule__Simple__InputsAssignment_6_1"
    // InternalBot.g:7842:1: rule__Simple__InputsAssignment_6_1 : ( ruleSimpleInput ) ;
    public final void rule__Simple__InputsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7846:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:7847:2: ( ruleSimpleInput )
            {
            // InternalBot.g:7847:2: ( ruleSimpleInput )
            // InternalBot.g:7848:3: ruleSimpleInput
            {
             before(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Simple__InputsAssignment_6_1"


    // $ANTLR start "rule__Composite__NameAssignment_3"
    // InternalBot.g:7857:1: rule__Composite__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__Composite__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7861:1: ( ( ruleEString ) )
            // InternalBot.g:7862:2: ( ruleEString )
            {
            // InternalBot.g:7862:2: ( ruleEString )
            // InternalBot.g:7863:3: ruleEString
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


    // $ANTLR start "rule__Composite__LanguageAssignment_4_1"
    // InternalBot.g:7872:1: rule__Composite__LanguageAssignment_4_1 : ( ruleLanguage ) ;
    public final void rule__Composite__LanguageAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7876:1: ( ( ruleLanguage ) )
            // InternalBot.g:7877:2: ( ruleLanguage )
            {
            // InternalBot.g:7877:2: ( ruleLanguage )
            // InternalBot.g:7878:3: ruleLanguage
            {
             before(grammarAccess.getCompositeAccess().getLanguageLanguageEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getLanguageLanguageEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__LanguageAssignment_4_1"


    // $ANTLR start "rule__Composite__InputsAssignment_6_0"
    // InternalBot.g:7887:1: rule__Composite__InputsAssignment_6_0 : ( ruleCompositeInput ) ;
    public final void rule__Composite__InputsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7891:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:7892:2: ( ruleCompositeInput )
            {
            // InternalBot.g:7892:2: ( ruleCompositeInput )
            // InternalBot.g:7893:3: ruleCompositeInput
            {
             before(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__InputsAssignment_6_0"


    // $ANTLR start "rule__Composite__InputsAssignment_6_1"
    // InternalBot.g:7902:1: rule__Composite__InputsAssignment_6_1 : ( ruleCompositeInput ) ;
    public final void rule__Composite__InputsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7906:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:7907:2: ( ruleCompositeInput )
            {
            // InternalBot.g:7907:2: ( ruleCompositeInput )
            // InternalBot.g:7908:3: ruleCompositeInput
            {
             before(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Composite__InputsAssignment_6_1"


    // $ANTLR start "rule__SimpleInput__NameAssignment_1"
    // InternalBot.g:7917:1: rule__SimpleInput__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7921:1: ( ( ruleEString ) )
            // InternalBot.g:7922:2: ( ruleEString )
            {
            // InternalBot.g:7922:2: ( ruleEString )
            // InternalBot.g:7923:3: ruleEString
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
    // InternalBot.g:7932:1: rule__SimpleInput__ValuesAssignment_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7936:1: ( ( ruleEString ) )
            // InternalBot.g:7937:2: ( ruleEString )
            {
            // InternalBot.g:7937:2: ( ruleEString )
            // InternalBot.g:7938:3: ruleEString
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
    // InternalBot.g:7947:1: rule__SimpleInput__ValuesAssignment_2_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7951:1: ( ( ruleEString ) )
            // InternalBot.g:7952:2: ( ruleEString )
            {
            // InternalBot.g:7952:2: ( ruleEString )
            // InternalBot.g:7953:3: ruleEString
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
    // InternalBot.g:7962:1: rule__CompositeInput__TokensAssignment_0 : ( ( rule__CompositeInput__TokensAlternatives_0_0 ) ) ;
    public final void rule__CompositeInput__TokensAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7966:1: ( ( ( rule__CompositeInput__TokensAlternatives_0_0 ) ) )
            // InternalBot.g:7967:2: ( ( rule__CompositeInput__TokensAlternatives_0_0 ) )
            {
            // InternalBot.g:7967:2: ( ( rule__CompositeInput__TokensAlternatives_0_0 ) )
            // InternalBot.g:7968:3: ( rule__CompositeInput__TokensAlternatives_0_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getTokensAlternatives_0_0()); 
            // InternalBot.g:7969:3: ( rule__CompositeInput__TokensAlternatives_0_0 )
            // InternalBot.g:7969:4: rule__CompositeInput__TokensAlternatives_0_0
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
    // InternalBot.g:7977:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7981:1: ( ( ruleEString ) )
            // InternalBot.g:7982:2: ( ruleEString )
            {
            // InternalBot.g:7982:2: ( ruleEString )
            // InternalBot.g:7983:3: ruleEString
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


    // $ANTLR start "rule__Text__LanguageAssignment_3_1"
    // InternalBot.g:7992:1: rule__Text__LanguageAssignment_3_1 : ( ruleLanguage ) ;
    public final void rule__Text__LanguageAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7996:1: ( ( ruleLanguage ) )
            // InternalBot.g:7997:2: ( ruleLanguage )
            {
            // InternalBot.g:7997:2: ( ruleLanguage )
            // InternalBot.g:7998:3: ruleLanguage
            {
             before(grammarAccess.getTextAccess().getLanguageLanguageEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getTextAccess().getLanguageLanguageEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__LanguageAssignment_3_1"


    // $ANTLR start "rule__Text__InputsAssignment_6"
    // InternalBot.g:8007:1: rule__Text__InputsAssignment_6 : ( ruleTextInputText ) ;
    public final void rule__Text__InputsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8011:1: ( ( ruleTextInputText ) )
            // InternalBot.g:8012:2: ( ruleTextInputText )
            {
            // InternalBot.g:8012:2: ( ruleTextInputText )
            // InternalBot.g:8013:3: ruleTextInputText
            {
             before(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__InputsAssignment_6"


    // $ANTLR start "rule__Text__InputsAssignment_7_1"
    // InternalBot.g:8022:1: rule__Text__InputsAssignment_7_1 : ( ruleTextInputText ) ;
    public final void rule__Text__InputsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8026:1: ( ( ruleTextInputText ) )
            // InternalBot.g:8027:2: ( ruleTextInputText )
            {
            // InternalBot.g:8027:2: ( ruleTextInputText )
            // InternalBot.g:8028:3: ruleTextInputText
            {
             before(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__InputsAssignment_7_1"


    // $ANTLR start "rule__HTTPResponse__NameAssignment_1"
    // InternalBot.g:8037:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8041:1: ( ( ruleEString ) )
            // InternalBot.g:8042:2: ( ruleEString )
            {
            // InternalBot.g:8042:2: ( ruleEString )
            // InternalBot.g:8043:3: ruleEString
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
    // InternalBot.g:8052:1: rule__HTTPResponse__HTTPRequestAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8056:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8057:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8057:2: ( ( ruleEString ) )
            // InternalBot.g:8058:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0()); 
            // InternalBot.g:8059:3: ( ruleEString )
            // InternalBot.g:8060:4: ruleEString
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
    // InternalBot.g:8071:1: rule__HTTPResponse__InputsAssignment_7 : ( ruleTextInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8075:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:8076:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:8076:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:8077:3: ruleTextInputHttpResponse
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
    // InternalBot.g:8086:1: rule__HTTPRequest__MethodAssignment_2 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8090:1: ( ( ruleMethod ) )
            // InternalBot.g:8091:2: ( ruleMethod )
            {
            // InternalBot.g:8091:2: ( ruleMethod )
            // InternalBot.g:8092:3: ruleMethod
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
    // InternalBot.g:8101:1: rule__HTTPRequest__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8105:1: ( ( ruleEString ) )
            // InternalBot.g:8106:2: ( ruleEString )
            {
            // InternalBot.g:8106:2: ( ruleEString )
            // InternalBot.g:8107:3: ruleEString
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
    // InternalBot.g:8116:1: rule__HTTPRequest__URLAssignment_7 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8120:1: ( ( ruleEString ) )
            // InternalBot.g:8121:2: ( ruleEString )
            {
            // InternalBot.g:8121:2: ( ruleEString )
            // InternalBot.g:8122:3: ruleEString
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
    // InternalBot.g:8131:1: rule__HTTPRequest__BasicAuthAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8135:1: ( ( ruleKeyValue ) )
            // InternalBot.g:8136:2: ( ruleKeyValue )
            {
            // InternalBot.g:8136:2: ( ruleKeyValue )
            // InternalBot.g:8137:3: ruleKeyValue
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
    // InternalBot.g:8146:1: rule__HTTPRequest__HeadersAssignment_10_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8150:1: ( ( ruleKeyValue ) )
            // InternalBot.g:8151:2: ( ruleKeyValue )
            {
            // InternalBot.g:8151:2: ( ruleKeyValue )
            // InternalBot.g:8152:3: ruleKeyValue
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
    // InternalBot.g:8161:1: rule__HTTPRequest__HeadersAssignment_10_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8165:1: ( ( ruleKeyValue ) )
            // InternalBot.g:8166:2: ( ruleKeyValue )
            {
            // InternalBot.g:8166:2: ( ruleKeyValue )
            // InternalBot.g:8167:3: ruleKeyValue
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
    // InternalBot.g:8176:1: rule__HTTPRequest__DataAssignment_11_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8180:1: ( ( ruleData ) )
            // InternalBot.g:8181:2: ( ruleData )
            {
            // InternalBot.g:8181:2: ( ruleData )
            // InternalBot.g:8182:3: ruleData
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
    // InternalBot.g:8191:1: rule__HTTPRequest__DataAssignment_11_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8195:1: ( ( ruleData ) )
            // InternalBot.g:8196:2: ( ruleData )
            {
            // InternalBot.g:8196:2: ( ruleData )
            // InternalBot.g:8197:3: ruleData
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
    // InternalBot.g:8206:1: rule__HTTPRequest__DataTypeAssignment_11_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_11_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8210:1: ( ( ruleDataType ) )
            // InternalBot.g:8211:2: ( ruleDataType )
            {
            // InternalBot.g:8211:2: ( ruleDataType )
            // InternalBot.g:8212:3: ruleDataType
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
    // InternalBot.g:8221:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8225:1: ( ( ruleEString ) )
            // InternalBot.g:8226:2: ( ruleEString )
            {
            // InternalBot.g:8226:2: ( ruleEString )
            // InternalBot.g:8227:3: ruleEString
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
    // InternalBot.g:8236:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8240:1: ( ( ruleEString ) )
            // InternalBot.g:8241:2: ( ruleEString )
            {
            // InternalBot.g:8241:2: ( ruleEString )
            // InternalBot.g:8242:3: ruleEString
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
    // InternalBot.g:8251:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8255:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:8256:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:8256:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:8257:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:8258:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:8258:4: rule__TextInputHttpResponse__TokensAlternatives_0
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
    // InternalBot.g:8266:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8270:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:8271:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:8271:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:8272:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:8273:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:8273:4: rule__TextInputText__TokensAlternatives_0
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
    // InternalBot.g:8281:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8285:1: ( ( ruleEString ) )
            // InternalBot.g:8286:2: ( ruleEString )
            {
            // InternalBot.g:8286:2: ( ruleEString )
            // InternalBot.g:8287:3: ruleEString
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
    // InternalBot.g:8296:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8300:1: ( ( ruleLiteral ) )
            // InternalBot.g:8301:2: ( ruleLiteral )
            {
            // InternalBot.g:8301:2: ( ruleLiteral )
            // InternalBot.g:8302:3: ruleLiteral
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
    // InternalBot.g:8311:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8315:1: ( ( ruleEString ) )
            // InternalBot.g:8316:2: ( ruleEString )
            {
            // InternalBot.g:8316:2: ( ruleEString )
            // InternalBot.g:8317:3: ruleEString
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
    // InternalBot.g:8326:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8330:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:8331:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:8331:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:8332:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:8333:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:8333:4: rule__Data__ValueAlternatives_2_0
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
            "\1\12\1\11\5\uffff\1\12",
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
            return "896:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000880L});
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
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020800L,0x0000000000140000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020802L,0x0000000000140000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x4800000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000008L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xA040000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000008L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000000F830L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000280L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000070800L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000400L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000400L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0400000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000030L,0x0000000000020080L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000880L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000040000L,0x0000000001800000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000080L});

}