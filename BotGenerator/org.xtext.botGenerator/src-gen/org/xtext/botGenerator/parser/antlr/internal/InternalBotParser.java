package org.xtext.botGenerator.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.botGenerator.services.BotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBotParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language:'", "'intents'", "':'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'{'", "'inputs:'", "','", "'parameters:'", "'}'", "'user'", "'=>'", "'chatbot'", "'('", "')'", "'entity'", "'required'", "'prompts'", "'['", "']'", "'isList'", "'@'", "'request.'", "'.'", "'Simple'", "'Composite'", "'synonyms'", "'text'", "'response'", "'text:'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'image'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'JSON'", "'FORM'", "'post'", "'get'"
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

        public InternalBotParser(TokenStream input, BotGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Bot";
       	}

       	@Override
       	protected BotGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleBot"
    // InternalBot.g:65:1: entryRuleBot returns [EObject current=null] : iv_ruleBot= ruleBot EOF ;
    public final EObject entryRuleBot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBot = null;


        try {
            // InternalBot.g:65:44: (iv_ruleBot= ruleBot EOF )
            // InternalBot.g:66:2: iv_ruleBot= ruleBot EOF
            {
             newCompositeNode(grammarAccess.getBotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBot=ruleBot();

            state._fsp--;

             current =iv_ruleBot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBot"


    // $ANTLR start "ruleBot"
    // InternalBot.g:72:1: ruleBot returns [EObject current=null] : (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_language_3_0= ruleLanguage ) ) otherlv_4= 'intents' otherlv_5= ':' ( (lv_intents_6_0= ruleIntent ) ) ( (lv_intents_7_0= ruleIntent ) )* (otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )* )? (otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )* )? otherlv_16= 'flows' otherlv_17= ':' (otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';' )+ ) ;
    public final EObject ruleBot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_language_3_0 = null;

        EObject lv_intents_6_0 = null;

        EObject lv_intents_7_0 = null;

        EObject lv_entities_10_0 = null;

        EObject lv_entities_11_0 = null;

        EObject lv_actions_14_0 = null;

        EObject lv_actions_15_0 = null;

        EObject lv_flows_19_0 = null;



        	enterRule();

        try {
            // InternalBot.g:78:2: ( (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_language_3_0= ruleLanguage ) ) otherlv_4= 'intents' otherlv_5= ':' ( (lv_intents_6_0= ruleIntent ) ) ( (lv_intents_7_0= ruleIntent ) )* (otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )* )? (otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )* )? otherlv_16= 'flows' otherlv_17= ':' (otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';' )+ ) )
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_language_3_0= ruleLanguage ) ) otherlv_4= 'intents' otherlv_5= ':' ( (lv_intents_6_0= ruleIntent ) ) ( (lv_intents_7_0= ruleIntent ) )* (otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )* )? (otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )* )? otherlv_16= 'flows' otherlv_17= ':' (otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';' )+ )
            {
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_language_3_0= ruleLanguage ) ) otherlv_4= 'intents' otherlv_5= ':' ( (lv_intents_6_0= ruleIntent ) ) ( (lv_intents_7_0= ruleIntent ) )* (otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )* )? (otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )* )? otherlv_16= 'flows' otherlv_17= ':' (otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';' )+ )
            // InternalBot.g:80:3: otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_language_3_0= ruleLanguage ) ) otherlv_4= 'intents' otherlv_5= ':' ( (lv_intents_6_0= ruleIntent ) ) ( (lv_intents_7_0= ruleIntent ) )* (otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )* )? (otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )* )? otherlv_16= 'flows' otherlv_17= ':' (otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';' )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBotAccess().getChatbotKeyword_0());
            		
            // InternalBot.g:84:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:85:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:85:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:86:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getBotAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getBotAccess().getLanguageKeyword_2());
            		
            // InternalBot.g:107:3: ( (lv_language_3_0= ruleLanguage ) )
            // InternalBot.g:108:4: (lv_language_3_0= ruleLanguage )
            {
            // InternalBot.g:108:4: (lv_language_3_0= ruleLanguage )
            // InternalBot.g:109:5: lv_language_3_0= ruleLanguage
            {

            					newCompositeNode(grammarAccess.getBotAccess().getLanguageLanguageEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_language_3_0=ruleLanguage();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					set(
            						current,
            						"language",
            						lv_language_3_0,
            						"org.xtext.botGenerator.Bot.Language");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getBotAccess().getIntentsKeyword_4());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getBotAccess().getColonKeyword_5());
            		
            // InternalBot.g:134:3: ( (lv_intents_6_0= ruleIntent ) )
            // InternalBot.g:135:4: (lv_intents_6_0= ruleIntent )
            {
            // InternalBot.g:135:4: (lv_intents_6_0= ruleIntent )
            // InternalBot.g:136:5: lv_intents_6_0= ruleIntent
            {

            					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
            lv_intents_6_0=ruleIntent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"intents",
            						lv_intents_6_0,
            						"org.xtext.botGenerator.Bot.Intent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:153:3: ( (lv_intents_7_0= ruleIntent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:154:4: (lv_intents_7_0= ruleIntent )
            	    {
            	    // InternalBot.g:154:4: (lv_intents_7_0= ruleIntent )
            	    // InternalBot.g:155:5: lv_intents_7_0= ruleIntent
            	    {

            	    					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_intents_7_0=ruleIntent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBotRule());
            	    					}
            	    					add(
            	    						current,
            	    						"intents",
            	    						lv_intents_7_0,
            	    						"org.xtext.botGenerator.Bot.Intent");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalBot.g:172:3: (otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBot.g:173:4: otherlv_8= 'entities' otherlv_9= ':' ( (lv_entities_10_0= ruleEntity ) ) ( (lv_entities_11_0= ruleEntity ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getBotAccess().getEntitiesKeyword_8_0());
                    			
                    otherlv_9=(Token)match(input,14,FOLLOW_9); 

                    				newLeafNode(otherlv_9, grammarAccess.getBotAccess().getColonKeyword_8_1());
                    			
                    // InternalBot.g:181:4: ( (lv_entities_10_0= ruleEntity ) )
                    // InternalBot.g:182:5: (lv_entities_10_0= ruleEntity )
                    {
                    // InternalBot.g:182:5: (lv_entities_10_0= ruleEntity )
                    // InternalBot.g:183:6: lv_entities_10_0= ruleEntity
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_entities_10_0=ruleEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"entities",
                    							lv_entities_10_0,
                    							"org.xtext.botGenerator.Bot.Entity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:200:4: ( (lv_entities_11_0= ruleEntity ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=40 && LA2_0<=41)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBot.g:201:5: (lv_entities_11_0= ruleEntity )
                    	    {
                    	    // InternalBot.g:201:5: (lv_entities_11_0= ruleEntity )
                    	    // InternalBot.g:202:6: lv_entities_11_0= ruleEntity
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_8_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_entities_11_0=ruleEntity();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBotRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entities",
                    	    							lv_entities_11_0,
                    	    							"org.xtext.botGenerator.Bot.Entity");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBot.g:220:3: (otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBot.g:221:4: otherlv_12= 'actions' otherlv_13= ':' ( (lv_actions_14_0= ruleAction ) ) ( (lv_actions_15_0= ruleAction ) )*
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getBotAccess().getActionsKeyword_9_0());
                    			
                    otherlv_13=(Token)match(input,14,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getBotAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:229:4: ( (lv_actions_14_0= ruleAction ) )
                    // InternalBot.g:230:5: (lv_actions_14_0= ruleAction )
                    {
                    // InternalBot.g:230:5: (lv_actions_14_0= ruleAction )
                    // InternalBot.g:231:6: lv_actions_14_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_actions_14_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_14_0,
                    							"org.xtext.botGenerator.Bot.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:248:4: ( (lv_actions_15_0= ruleAction ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==43||LA4_0==46||LA4_0==48||LA4_0==55) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBot.g:249:5: (lv_actions_15_0= ruleAction )
                    	    {
                    	    // InternalBot.g:249:5: (lv_actions_15_0= ruleAction )
                    	    // InternalBot.g:250:6: lv_actions_15_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_9_3_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
                    	    lv_actions_15_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBotRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_15_0,
                    	    							"org.xtext.botGenerator.Bot.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_16, grammarAccess.getBotAccess().getFlowsKeyword_10());
            		
            otherlv_17=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_17, grammarAccess.getBotAccess().getColonKeyword_11());
            		
            // InternalBot.g:276:3: (otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBot.g:277:4: otherlv_18= '-' ( (lv_flows_19_0= ruleTransition ) ) otherlv_20= ';'
            	    {
            	    otherlv_18=(Token)match(input,18,FOLLOW_14); 

            	    				newLeafNode(otherlv_18, grammarAccess.getBotAccess().getHyphenMinusKeyword_12_0());
            	    			
            	    // InternalBot.g:281:4: ( (lv_flows_19_0= ruleTransition ) )
            	    // InternalBot.g:282:5: (lv_flows_19_0= ruleTransition )
            	    {
            	    // InternalBot.g:282:5: (lv_flows_19_0= ruleTransition )
            	    // InternalBot.g:283:6: lv_flows_19_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_12_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_flows_19_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"flows",
            	    							lv_flows_19_0,
            	    							"org.xtext.botGenerator.Bot.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_20=(Token)match(input,19,FOLLOW_16); 

            	    				newLeafNode(otherlv_20, grammarAccess.getBotAccess().getSemicolonKeyword_12_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBot"


    // $ANTLR start "entryRuleEntity"
    // InternalBot.g:309:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:309:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:310:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalBot.g:316:1: ruleEntity returns [EObject current=null] : (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_Composite_1 = null;



        	enterRule();

        try {
            // InternalBot.g:322:2: ( (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite ) )
            // InternalBot.g:323:2: (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite )
            {
            // InternalBot.g:323:2: (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==40) ) {
                alt7=1;
            }
            else if ( (LA7_0==41) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBot.g:324:3: this_Simple_0= ruleSimple
                    {

                    			newCompositeNode(grammarAccess.getEntityAccess().getSimpleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Simple_0=ruleSimple();

                    state._fsp--;


                    			current = this_Simple_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:333:3: this_Composite_1= ruleComposite
                    {

                    			newCompositeNode(grammarAccess.getEntityAccess().getCompositeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Composite_1=ruleComposite();

                    state._fsp--;


                    			current = this_Composite_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleAction"
    // InternalBot.g:345:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalBot.g:345:47: (iv_ruleAction= ruleAction EOF )
            // InternalBot.g:346:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalBot.g:352:1: ruleAction returns [EObject current=null] : (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_Text_0 = null;

        EObject this_HTTPRequest_1 = null;

        EObject this_Image_2 = null;

        EObject this_HTTPResponse_3 = null;



        	enterRule();

        try {
            // InternalBot.g:358:2: ( (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) )
            // InternalBot.g:359:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            {
            // InternalBot.g:359:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt8=1;
                }
                break;
            case 48:
                {
                alt8=2;
                }
                break;
            case 55:
                {
                alt8=3;
                }
                break;
            case 46:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalBot.g:360:3: this_Text_0= ruleText
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getTextParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Text_0=ruleText();

                    state._fsp--;


                    			current = this_Text_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:369:3: this_HTTPRequest_1= ruleHTTPRequest
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getHTTPRequestParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_HTTPRequest_1=ruleHTTPRequest();

                    state._fsp--;


                    			current = this_HTTPRequest_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBot.g:378:3: this_Image_2= ruleImage
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getImageParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Image_2=ruleImage();

                    state._fsp--;


                    			current = this_Image_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalBot.g:387:3: this_HTTPResponse_3= ruleHTTPResponse
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_HTTPResponse_3=ruleHTTPResponse();

                    state._fsp--;


                    			current = this_HTTPResponse_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEString"
    // InternalBot.g:399:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalBot.g:399:47: (iv_ruleEString= ruleEString EOF )
            // InternalBot.g:400:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalBot.g:406:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalBot.g:412:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalBot.g:413:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalBot.g:413:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBot.g:414:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:422:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleIntent"
    // InternalBot.g:433:1: entryRuleIntent returns [EObject current=null] : iv_ruleIntent= ruleIntent EOF ;
    public final EObject entryRuleIntent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent = null;


        try {
            // InternalBot.g:433:47: (iv_ruleIntent= ruleIntent EOF )
            // InternalBot.g:434:2: iv_ruleIntent= ruleIntent EOF
            {
             newCompositeNode(grammarAccess.getIntentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntent=ruleIntent();

            state._fsp--;

             current =iv_ruleIntent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntent"


    // $ANTLR start "ruleIntent"
    // InternalBot.g:440:1: ruleIntent returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= '{' otherlv_3= 'inputs:' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* (otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )* )? otherlv_10= '}' ) ;
    public final EObject ruleIntent() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_9_0 = null;



        	enterRule();

        try {
            // InternalBot.g:446:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= '{' otherlv_3= 'inputs:' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* (otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )* )? otherlv_10= '}' ) )
            // InternalBot.g:447:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= '{' otherlv_3= 'inputs:' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* (otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )* )? otherlv_10= '}' )
            {
            // InternalBot.g:447:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= '{' otherlv_3= 'inputs:' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* (otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )* )? otherlv_10= '}' )
            // InternalBot.g:448:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= '{' otherlv_3= 'inputs:' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* (otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )* )? otherlv_10= '}'
            {
            // InternalBot.g:448:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:449:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:449:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:450:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIntentAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:467:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBot.g:468:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:468:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:469:5: lv_fallbackIntent_1_0= 'Fallback'
                    {
                    lv_fallbackIntent_1_0=(Token)match(input,20,FOLLOW_18); 

                    					newLeafNode(lv_fallbackIntent_1_0, grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntentRule());
                    					}
                    					setWithLastConsumed(current, "fallbackIntent", true, "Fallback");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getIntentAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentAccess().getInputsKeyword_3());
            		
            // InternalBot.g:489:3: ( (lv_inputs_4_0= ruleTrainingPhrase ) )
            // InternalBot.g:490:4: (lv_inputs_4_0= ruleTrainingPhrase )
            {
            // InternalBot.g:490:4: (lv_inputs_4_0= ruleTrainingPhrase )
            // InternalBot.g:491:5: lv_inputs_4_0= ruleTrainingPhrase
            {

            					newCompositeNode(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_inputs_4_0=ruleTrainingPhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TrainingPhrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:508:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBot.g:509:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_20); 

            	    				newLeafNode(otherlv_5, grammarAccess.getIntentAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalBot.g:513:4: ( (lv_inputs_6_0= ruleTrainingPhrase ) )
            	    // InternalBot.g:514:5: (lv_inputs_6_0= ruleTrainingPhrase )
            	    {
            	    // InternalBot.g:514:5: (lv_inputs_6_0= ruleTrainingPhrase )
            	    // InternalBot.g:515:6: lv_inputs_6_0= ruleTrainingPhrase
            	    {

            	    						newCompositeNode(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_inputs_6_0=ruleTrainingPhrase();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIntentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.TrainingPhrase");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalBot.g:533:3: (otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBot.g:534:4: otherlv_7= 'parameters:' ( (lv_parameters_8_0= ruleParameter ) ) ( (lv_parameters_9_0= ruleParameter ) )*
                    {
                    otherlv_7=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntentAccess().getParametersKeyword_6_0());
                    			
                    // InternalBot.g:538:4: ( (lv_parameters_8_0= ruleParameter ) )
                    // InternalBot.g:539:5: (lv_parameters_8_0= ruleParameter )
                    {
                    // InternalBot.g:539:5: (lv_parameters_8_0= ruleParameter )
                    // InternalBot.g:540:6: lv_parameters_8_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_parameters_8_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_8_0,
                    							"org.xtext.botGenerator.Bot.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:557:4: ( (lv_parameters_9_0= ruleParameter ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalBot.g:558:5: (lv_parameters_9_0= ruleParameter )
                    	    {
                    	    // InternalBot.g:558:5: (lv_parameters_9_0= ruleParameter )
                    	    // InternalBot.g:559:6: lv_parameters_9_0= ruleParameter
                    	    {

                    	    						newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_22);
                    	    lv_parameters_9_0=ruleParameter();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"parameters",
                    	    							lv_parameters_9_0,
                    	    							"org.xtext.botGenerator.Bot.Parameter");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIntentAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntent"


    // $ANTLR start "entryRuleTransition"
    // InternalBot.g:585:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalBot.g:585:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalBot.g:586:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalBot.g:592:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_target_3_1 = null;

        EObject lv_target_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:598:2: ( (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) )
            // InternalBot.g:599:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            {
            // InternalBot.g:599:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            // InternalBot.g:600:3: otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getUserKeyword_0());
            		
            // InternalBot.g:604:3: ( ( ruleEString ) )
            // InternalBot.g:605:4: ( ruleEString )
            {
            // InternalBot.g:605:4: ( ruleEString )
            // InternalBot.g:606:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:620:3: (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:621:4: otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_24); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                    			
                    // InternalBot.g:625:4: ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    // InternalBot.g:626:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    {
                    // InternalBot.g:626:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    // InternalBot.g:627:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    {
                    // InternalBot.g:627:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    int alt14=2;
                    alt14 = dfa14.predict(input);
                    switch (alt14) {
                        case 1 :
                            // InternalBot.g:628:7: lv_target_3_1= ruleState
                            {

                            							newCompositeNode(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_target_3_1=ruleState();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTransitionRule());
                            							}
                            							set(
                            								current,
                            								"target",
                            								lv_target_3_1,
                            								"org.xtext.botGenerator.Bot.State");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalBot.g:644:7: lv_target_3_2= ruleState2
                            {

                            							newCompositeNode(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_2_1_0_1());
                            						
                            pushFollow(FOLLOW_2);
                            lv_target_3_2=ruleState2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTransitionRule());
                            							}
                            							set(
                            								current,
                            								"target",
                            								lv_target_3_2,
                            								"org.xtext.botGenerator.Bot.State2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleState"
    // InternalBot.g:667:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBot.g:667:46: (iv_ruleState= ruleState EOF )
            // InternalBot.g:668:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalBot.g:674:1: ruleState returns [EObject current=null] : (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_outcoming_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:680:2: ( (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? ) )
            // InternalBot.g:681:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? )
            {
            // InternalBot.g:681:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? )
            // InternalBot.g:682:3: otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getChatbotKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalBot.g:690:3: ( ( ruleEString ) )
            // InternalBot.g:691:4: ( ruleEString )
            {
            // InternalBot.g:691:4: ( ruleEString )
            // InternalBot.g:692:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:706:3: (otherlv_3= ',' ( ( ruleEString ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBot.g:707:4: otherlv_3= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getStateAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:711:4: ( ( ruleEString ) )
            	    // InternalBot.g:712:5: ( ruleEString )
            	    {
            	    // InternalBot.g:712:5: ( ruleEString )
            	    // InternalBot.g:713:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_5=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightParenthesisKeyword_4());
            		
            // InternalBot.g:732:3: (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBot.g:733:4: otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_14); 

                    				newLeafNode(otherlv_6, grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_5_0());
                    			
                    // InternalBot.g:737:4: ( (lv_outcoming_7_0= ruleTransition ) )
                    // InternalBot.g:738:5: (lv_outcoming_7_0= ruleTransition )
                    {
                    // InternalBot.g:738:5: (lv_outcoming_7_0= ruleTransition )
                    // InternalBot.g:739:6: lv_outcoming_7_0= ruleTransition
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_outcoming_7_0=ruleTransition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStateRule());
                    						}
                    						add(
                    							current,
                    							"outcoming",
                    							lv_outcoming_7_0,
                    							"org.xtext.botGenerator.Bot.Transition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleState2"
    // InternalBot.g:761:1: entryRuleState2 returns [EObject current=null] : iv_ruleState2= ruleState2 EOF ;
    public final EObject entryRuleState2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState2 = null;


        try {
            // InternalBot.g:761:47: (iv_ruleState2= ruleState2 EOF )
            // InternalBot.g:762:2: iv_ruleState2= ruleState2 EOF
            {
             newCompositeNode(grammarAccess.getState2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState2=ruleState2();

            state._fsp--;

             current =iv_ruleState2; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState2"


    // $ANTLR start "ruleState2"
    // InternalBot.g:768:1: ruleState2 returns [EObject current=null] : (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' ) ;
    public final EObject ruleState2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_outcoming_8_0 = null;



        	enterRule();

        try {
            // InternalBot.g:774:2: ( (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' ) )
            // InternalBot.g:775:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' )
            {
            // InternalBot.g:775:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' )
            // InternalBot.g:776:3: otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getState2Access().getChatbotKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getState2Access().getLeftParenthesisKeyword_1());
            		
            // InternalBot.g:784:3: ( ( ruleEString ) )
            // InternalBot.g:785:4: ( ruleEString )
            {
            // InternalBot.g:785:4: ( ruleEString )
            // InternalBot.g:786:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getState2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:800:3: (otherlv_3= ',' ( ( ruleEString ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBot.g:801:4: otherlv_3= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getState2Access().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:805:4: ( ( ruleEString ) )
            	    // InternalBot.g:806:5: ( ruleEString )
            	    {
            	    // InternalBot.g:806:5: ( ruleEString )
            	    // InternalBot.g:807:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getState2Rule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_5=(Token)match(input,30,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getState2Access().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,21,FOLLOW_27); 

            			newLeafNode(otherlv_6, grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5());
            		
            // InternalBot.g:830:3: (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==27) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:831:4: otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';'
            	    {
            	    otherlv_7=(Token)match(input,27,FOLLOW_14); 

            	    				newLeafNode(otherlv_7, grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_6_0());
            	    			
            	    // InternalBot.g:835:4: ( (lv_outcoming_8_0= ruleTransition ) )
            	    // InternalBot.g:836:5: (lv_outcoming_8_0= ruleTransition )
            	    {
            	    // InternalBot.g:836:5: (lv_outcoming_8_0= ruleTransition )
            	    // InternalBot.g:837:6: lv_outcoming_8_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_outcoming_8_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getState2Rule());
            	    						}
            	    						add(
            	    							current,
            	    							"outcoming",
            	    							lv_outcoming_8_0,
            	    							"org.xtext.botGenerator.Bot.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_9=(Token)match(input,19,FOLLOW_28); 

            	    				newLeafNode(otherlv_9, grammarAccess.getState2Access().getSemicolonKeyword_6_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            otherlv_10=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getState2Access().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState2"


    // $ANTLR start "entryRuleTrainingPhrase"
    // InternalBot.g:867:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:867:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:868:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
            {
             newCompositeNode(grammarAccess.getTrainingPhraseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrainingPhrase=ruleTrainingPhrase();

            state._fsp--;

             current =iv_ruleTrainingPhrase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrainingPhrase"


    // $ANTLR start "ruleTrainingPhrase"
    // InternalBot.g:874:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:880:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:881:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:881:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:882:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:882:3: ()
            // InternalBot.g:883:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:889:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_ID)||LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:890:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:890:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:891:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:891:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_ID)) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==29) ) {
            	        alt20=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalBot.g:892:6: lv_tokens_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_29);
            	            lv_tokens_1_1=ruleLiteral();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getTrainingPhraseRule());
            	            						}
            	            						add(
            	            							current,
            	            							"tokens",
            	            							lv_tokens_1_1,
            	            							"org.xtext.botGenerator.Bot.Literal");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:908:6: lv_tokens_1_2= ruleParameterRefenceToken
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_29);
            	            lv_tokens_1_2=ruleParameterRefenceToken();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getTrainingPhraseRule());
            	            						}
            	            						add(
            	            							current,
            	            							"tokens",
            	            							lv_tokens_1_2,
            	            							"org.xtext.botGenerator.Bot.ParameterRefenceToken");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrainingPhrase"


    // $ANTLR start "entryRuleParameter"
    // InternalBot.g:930:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:930:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:931:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBot.g:937:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )? )? (otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) ) )? otherlv_16= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_required_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_isList_15_0=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_defaultEntity_4_0 = null;

        AntlrDatatypeRuleToken lv_prompts_10_0 = null;

        AntlrDatatypeRuleToken lv_prompts_12_0 = null;



        	enterRule();

        try {
            // InternalBot.g:943:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )? )? (otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) ) )? otherlv_16= ';' ) )
            // InternalBot.g:944:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )? )? (otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) ) )? otherlv_16= ';' )
            {
            // InternalBot.g:944:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )? )? (otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) ) )? otherlv_16= ';' )
            // InternalBot.g:945:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )? )? (otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) ) )? otherlv_16= ';'
            {
            // InternalBot.g:945:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:946:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:946:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:947:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_31); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEntityKeyword_2());
            		
            // InternalBot.g:972:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)) ) {
                alt22=1;
            }
            else if ( (LA22_0==43||(LA22_0>=56 && LA22_0<=59)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalBot.g:973:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:973:4: ( ( ruleEString ) )
                    // InternalBot.g:974:5: ( ruleEString )
                    {
                    // InternalBot.g:974:5: ( ruleEString )
                    // InternalBot.g:975:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_32);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:990:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:990:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:991:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:991:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:992:6: lv_defaultEntity_4_0= ruleDefaultEntity
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_defaultEntity_4_0=ruleDefaultEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"defaultEntity",
                    							lv_defaultEntity_4_0,
                    							"org.xtext.botGenerator.Bot.DefaultEntity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalBot.g:1010:3: (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==32) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:1011:4: otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )?
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_33); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1015:4: ( (lv_required_6_0= 'required' ) )
                    // InternalBot.g:1016:5: (lv_required_6_0= 'required' )
                    {
                    // InternalBot.g:1016:5: (lv_required_6_0= 'required' )
                    // InternalBot.g:1017:6: lv_required_6_0= 'required'
                    {
                    lv_required_6_0=(Token)match(input,32,FOLLOW_32); 

                    						newLeafNode(lv_required_6_0, grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "required", true, "required");
                    					

                    }


                    }

                    // InternalBot.g:1029:4: (otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==23) ) {
                        int LA24_1 = input.LA(2);

                        if ( (LA24_1==33) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalBot.g:1030:5: otherlv_7= ',' otherlv_8= 'prompts' otherlv_9= '[' ( (lv_prompts_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )* otherlv_13= ']'
                            {
                            otherlv_7=(Token)match(input,23,FOLLOW_34); 

                            					newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_4_2_0());
                            				
                            otherlv_8=(Token)match(input,33,FOLLOW_35); 

                            					newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getPromptsKeyword_4_2_1());
                            				
                            otherlv_9=(Token)match(input,34,FOLLOW_3); 

                            					newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_4_2_2());
                            				
                            // InternalBot.g:1042:5: ( (lv_prompts_10_0= ruleEString ) )
                            // InternalBot.g:1043:6: (lv_prompts_10_0= ruleEString )
                            {
                            // InternalBot.g:1043:6: (lv_prompts_10_0= ruleEString )
                            // InternalBot.g:1044:7: lv_prompts_10_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_3_0());
                            						
                            pushFollow(FOLLOW_36);
                            lv_prompts_10_0=ruleEString();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getParameterRule());
                            							}
                            							add(
                            								current,
                            								"prompts",
                            								lv_prompts_10_0,
                            								"org.xtext.botGenerator.Bot.EString");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalBot.g:1061:5: (otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) ) )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==23) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // InternalBot.g:1062:6: otherlv_11= ',' ( (lv_prompts_12_0= ruleEString ) )
                            	    {
                            	    otherlv_11=(Token)match(input,23,FOLLOW_3); 

                            	    						newLeafNode(otherlv_11, grammarAccess.getParameterAccess().getCommaKeyword_4_2_4_0());
                            	    					
                            	    // InternalBot.g:1066:6: ( (lv_prompts_12_0= ruleEString ) )
                            	    // InternalBot.g:1067:7: (lv_prompts_12_0= ruleEString )
                            	    {
                            	    // InternalBot.g:1067:7: (lv_prompts_12_0= ruleEString )
                            	    // InternalBot.g:1068:8: lv_prompts_12_0= ruleEString
                            	    {

                            	    								newCompositeNode(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_4_1_0());
                            	    							
                            	    pushFollow(FOLLOW_36);
                            	    lv_prompts_12_0=ruleEString();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getParameterRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"prompts",
                            	    									lv_prompts_12_0,
                            	    									"org.xtext.botGenerator.Bot.EString");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);

                            otherlv_13=(Token)match(input,35,FOLLOW_32); 

                            					newLeafNode(otherlv_13, grammarAccess.getParameterAccess().getRightSquareBracketKeyword_4_2_5());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalBot.g:1092:3: (otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==23) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBot.g:1093:4: otherlv_14= ',' ( (lv_isList_15_0= 'isList' ) )
                    {
                    otherlv_14=(Token)match(input,23,FOLLOW_37); 

                    				newLeafNode(otherlv_14, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1097:4: ( (lv_isList_15_0= 'isList' ) )
                    // InternalBot.g:1098:5: (lv_isList_15_0= 'isList' )
                    {
                    // InternalBot.g:1098:5: (lv_isList_15_0= 'isList' )
                    // InternalBot.g:1099:6: lv_isList_15_0= 'isList'
                    {
                    lv_isList_15_0=(Token)match(input,36,FOLLOW_15); 

                    						newLeafNode(lv_isList_15_0, grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "isList", true, "isList");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getParameterAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:1120:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1120:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1121:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBot.g:1127:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1133:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1134:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1134:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1135:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1135:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1136:4: lv_text_0_0= ruleEString
            {

            				newCompositeNode(grammarAccess.getLiteralAccess().getTextEStringParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_text_0_0=ruleEString();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getLiteralRule());
            				}
            				set(
            					current,
            					"text",
            					lv_text_0_0,
            					"org.xtext.botGenerator.Bot.EString");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEntityToken"
    // InternalBot.g:1156:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1156:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1157:2: iv_ruleEntityToken= ruleEntityToken EOF
            {
             newCompositeNode(grammarAccess.getEntityTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityToken=ruleEntityToken();

            state._fsp--;

             current =iv_ruleEntityToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityToken"


    // $ANTLR start "ruleEntityToken"
    // InternalBot.g:1163:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBot.g:1169:2: ( (otherlv_0= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1170:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1170:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1171:3: otherlv_0= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0());
            		
            // InternalBot.g:1175:3: ( ( ruleEString ) )
            // InternalBot.g:1176:4: ( ruleEString )
            {
            // InternalBot.g:1176:4: ( ruleEString )
            // InternalBot.g:1177:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityToken"


    // $ANTLR start "entryRuleParameterToken"
    // InternalBot.g:1195:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1195:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1196:2: iv_ruleParameterToken= ruleParameterToken EOF
            {
             newCompositeNode(grammarAccess.getParameterTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterToken=ruleParameterToken();

            state._fsp--;

             current =iv_ruleParameterToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterToken"


    // $ANTLR start "ruleParameterToken"
    // InternalBot.g:1202:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1208:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1209:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1209:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1210:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1214:3: ( ( ruleEString ) )
            // InternalBot.g:1215:4: ( ruleEString )
            {
            // InternalBot.g:1215:4: ( ruleEString )
            // InternalBot.g:1216:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0());
            				
            pushFollow(FOLLOW_38);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterToken"


    // $ANTLR start "entryRuleParameterRefenceToken"
    // InternalBot.g:1238:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1238:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1239:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
            {
             newCompositeNode(grammarAccess.getParameterRefenceTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterRefenceToken=ruleParameterRefenceToken();

            state._fsp--;

             current =iv_ruleParameterRefenceToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterRefenceToken"


    // $ANTLR start "ruleParameterRefenceToken"
    // InternalBot.g:1245:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1251:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1252:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1252:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1253:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1257:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1258:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1258:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1259:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_39);
            lv_textReference_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRefenceTokenRule());
            					}
            					set(
            						current,
            						"textReference",
            						lv_textReference_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1284:3: ( ( ruleEString ) )
            // InternalBot.g:1285:4: ( ruleEString )
            {
            // InternalBot.g:1285:4: ( ruleEString )
            // InternalBot.g:1286:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRefenceTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0());
            				
            pushFollow(FOLLOW_38);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterRefenceToken"


    // $ANTLR start "entryRuleHTTPRequestToken"
    // InternalBot.g:1308:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1308:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1309:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
            {
             newCompositeNode(grammarAccess.getHTTPRequestTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHTTPRequestToken=ruleHTTPRequestToken();

            state._fsp--;

             current =iv_ruleHTTPRequestToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTPRequestToken"


    // $ANTLR start "ruleHTTPRequestToken"
    // InternalBot.g:1315:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1321:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1322:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1322:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1323:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_40); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1327:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1328:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1328:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1329:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_41);
            lv_type_1_0=ruleHTTPReturnType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestTokenRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.botGenerator.Bot.HTTPReturnType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1346:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBot.g:1347:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1351:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1352:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1352:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1353:6: lv_dataKey_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getDataKeyEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_dataKey_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestTokenRule());
                    						}
                    						set(
                    							current,
                    							"dataKey",
                    							lv_dataKey_3_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPRequestToken"


    // $ANTLR start "entryRuleSimple"
    // InternalBot.g:1375:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // InternalBot.g:1375:47: (iv_ruleSimple= ruleSimple EOF )
            // InternalBot.g:1376:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // InternalBot.g:1382:1: ruleSimple returns [EObject current=null] : ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )* )? ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_inputs_5_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1388:2: ( ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )* )? ) )
            // InternalBot.g:1389:2: ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )* )? )
            {
            // InternalBot.g:1389:2: ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )* )? )
            // InternalBot.g:1390:3: () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )* )?
            {
            // InternalBot.g:1390:3: ()
            // InternalBot.g:1391:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleAccess().getSimpleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleAccess().getSimpleKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1405:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1406:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1406:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1407:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleAccess().getColonKeyword_4());
            		
            // InternalBot.g:1428:3: ( ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_ID)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:1429:4: ( (lv_inputs_5_0= ruleSimpleInput ) ) ( (lv_inputs_6_0= ruleSimpleInput ) )*
                    {
                    // InternalBot.g:1429:4: ( (lv_inputs_5_0= ruleSimpleInput ) )
                    // InternalBot.g:1430:5: (lv_inputs_5_0= ruleSimpleInput )
                    {
                    // InternalBot.g:1430:5: (lv_inputs_5_0= ruleSimpleInput )
                    // InternalBot.g:1431:6: lv_inputs_5_0= ruleSimpleInput
                    {

                    						newCompositeNode(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_inputs_5_0=ruleSimpleInput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleRule());
                    						}
                    						add(
                    							current,
                    							"inputs",
                    							lv_inputs_5_0,
                    							"org.xtext.botGenerator.Bot.SimpleInput");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:1448:4: ( (lv_inputs_6_0= ruleSimpleInput ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_ID)) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalBot.g:1449:5: (lv_inputs_6_0= ruleSimpleInput )
                    	    {
                    	    // InternalBot.g:1449:5: (lv_inputs_6_0= ruleSimpleInput )
                    	    // InternalBot.g:1450:6: lv_inputs_6_0= ruleSimpleInput
                    	    {

                    	    						newCompositeNode(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_42);
                    	    lv_inputs_6_0=ruleSimpleInput();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSimpleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"inputs",
                    	    							lv_inputs_6_0,
                    	    							"org.xtext.botGenerator.Bot.SimpleInput");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleComposite"
    // InternalBot.g:1472:1: entryRuleComposite returns [EObject current=null] : iv_ruleComposite= ruleComposite EOF ;
    public final EObject entryRuleComposite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposite = null;


        try {
            // InternalBot.g:1472:50: (iv_ruleComposite= ruleComposite EOF )
            // InternalBot.g:1473:2: iv_ruleComposite= ruleComposite EOF
            {
             newCompositeNode(grammarAccess.getCompositeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComposite=ruleComposite();

            state._fsp--;

             current =iv_ruleComposite; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComposite"


    // $ANTLR start "ruleComposite"
    // InternalBot.g:1479:1: ruleComposite returns [EObject current=null] : ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? ) ;
    public final EObject ruleComposite() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_inputs_5_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1485:2: ( ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? ) )
            // InternalBot.g:1486:2: ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? )
            {
            // InternalBot.g:1486:2: ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? )
            // InternalBot.g:1487:3: () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )?
            {
            // InternalBot.g:1487:3: ()
            // InternalBot.g:1488:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeAccess().getCompositeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeAccess().getCompositeKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1502:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1503:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1503:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1504:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompositeAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompositeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_43); 

            			newLeafNode(otherlv_4, grammarAccess.getCompositeAccess().getColonKeyword_4());
            		
            // InternalBot.g:1525:3: ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_ID)||LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:1526:4: ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )*
                    {
                    // InternalBot.g:1526:4: ( (lv_inputs_5_0= ruleCompositeInput ) )
                    // InternalBot.g:1527:5: (lv_inputs_5_0= ruleCompositeInput )
                    {
                    // InternalBot.g:1527:5: (lv_inputs_5_0= ruleCompositeInput )
                    // InternalBot.g:1528:6: lv_inputs_5_0= ruleCompositeInput
                    {

                    						newCompositeNode(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_inputs_5_0=ruleCompositeInput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompositeRule());
                    						}
                    						add(
                    							current,
                    							"inputs",
                    							lv_inputs_5_0,
                    							"org.xtext.botGenerator.Bot.CompositeInput");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:1545:4: ( (lv_inputs_6_0= ruleCompositeInput ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_ID)||LA30_0==37) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalBot.g:1546:5: (lv_inputs_6_0= ruleCompositeInput )
                    	    {
                    	    // InternalBot.g:1546:5: (lv_inputs_6_0= ruleCompositeInput )
                    	    // InternalBot.g:1547:6: lv_inputs_6_0= ruleCompositeInput
                    	    {

                    	    						newCompositeNode(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_43);
                    	    lv_inputs_6_0=ruleCompositeInput();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCompositeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"inputs",
                    	    							lv_inputs_6_0,
                    	    							"org.xtext.botGenerator.Bot.CompositeInput");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComposite"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:1569:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:1569:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:1570:2: iv_ruleSimpleInput= ruleSimpleInput EOF
            {
             newCompositeNode(grammarAccess.getSimpleInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleInput=ruleSimpleInput();

            state._fsp--;

             current =iv_ruleSimpleInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleInput"


    // $ANTLR start "ruleSimpleInput"
    // InternalBot.g:1576:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' ) ;
    public final EObject ruleSimpleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1582:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' ) )
            // InternalBot.g:1583:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' )
            {
            // InternalBot.g:1583:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' )
            // InternalBot.g:1584:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';'
            {
            // InternalBot.g:1584:3: ()
            // InternalBot.g:1585:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:1591:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1592:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1592:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1593:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_44);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleInputRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1610:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==42) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:1611:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:1615:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:1616:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:1616:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:1617:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_values_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleInputRule());
                    						}
                    						add(
                    							current,
                    							"values",
                    							lv_values_3_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:1634:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==23) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalBot.g:1635:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:1639:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:1640:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:1640:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:1641:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    lv_values_5_0=ruleEString();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSimpleInputRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_5_0,
                    	    								"org.xtext.botGenerator.Bot.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSimpleInputAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleInput"


    // $ANTLR start "entryRuleCompositeInput"
    // InternalBot.g:1668:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:1668:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:1669:2: iv_ruleCompositeInput= ruleCompositeInput EOF
            {
             newCompositeNode(grammarAccess.getCompositeInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompositeInput=ruleCompositeInput();

            state._fsp--;

             current =iv_ruleCompositeInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeInput"


    // $ANTLR start "ruleCompositeInput"
    // InternalBot.g:1675:1: ruleCompositeInput returns [EObject current=null] : ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1681:2: ( ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' ) )
            // InternalBot.g:1682:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' )
            {
            // InternalBot.g:1682:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' )
            // InternalBot.g:1683:3: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';'
            {
            // InternalBot.g:1683:3: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_ID)||LA35_0==37) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBot.g:1684:4: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:1684:4: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) )
            	    // InternalBot.g:1685:5: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:1685:5: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_ID)) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==37) ) {
            	        alt34=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // InternalBot.g:1686:6: lv_tokens_0_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getTokensLiteralParserRuleCall_0_0_0());
            	            					
            	            pushFollow(FOLLOW_45);
            	            lv_tokens_0_1=ruleLiteral();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getCompositeInputRule());
            	            						}
            	            						add(
            	            							current,
            	            							"tokens",
            	            							lv_tokens_0_1,
            	            							"org.xtext.botGenerator.Bot.Literal");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:1702:6: lv_tokens_0_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getTokensEntityTokenParserRuleCall_0_0_1());
            	            					
            	            pushFollow(FOLLOW_45);
            	            lv_tokens_0_2=ruleEntityToken();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getCompositeInputRule());
            	            						}
            	            						add(
            	            							current,
            	            							"tokens",
            	            							lv_tokens_0_2,
            	            							"org.xtext.botGenerator.Bot.EntityToken");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            otherlv_1=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeInputAccess().getSemicolonKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompositeInput"


    // $ANTLR start "entryRuleText"
    // InternalBot.g:1728:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:1728:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:1729:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalBot.g:1735:1: ruleText returns [EObject current=null] : (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' (otherlv_4= 'text:' )? ( (lv_inputs_5_0= ruleTextInputText ) ) (otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) ) )* ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_5_0 = null;

        EObject lv_inputs_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1741:2: ( (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' (otherlv_4= 'text:' )? ( (lv_inputs_5_0= ruleTextInputText ) ) (otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) ) )* ) )
            // InternalBot.g:1742:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' (otherlv_4= 'text:' )? ( (lv_inputs_5_0= ruleTextInputText ) ) (otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) ) )* )
            {
            // InternalBot.g:1742:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' (otherlv_4= 'text:' )? ( (lv_inputs_5_0= ruleTextInputText ) ) (otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) ) )* )
            // InternalBot.g:1743:3: otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' (otherlv_4= 'text:' )? ( (lv_inputs_5_0= ruleTextInputText ) ) (otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) ) )*
            {
            otherlv_0=(Token)match(input,43,FOLLOW_46); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0());
            		
            otherlv_1=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:1751:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1752:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1752:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1753:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:1774:3: (otherlv_4= 'text:' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBot.g:1775:4: otherlv_4= 'text:'
                    {
                    otherlv_4=(Token)match(input,45,FOLLOW_47); 

                    				newLeafNode(otherlv_4, grammarAccess.getTextAccess().getTextKeyword_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:1780:3: ( (lv_inputs_5_0= ruleTextInputText ) )
            // InternalBot.g:1781:4: (lv_inputs_5_0= ruleTextInputText )
            {
            // InternalBot.g:1781:4: (lv_inputs_5_0= ruleTextInputText )
            // InternalBot.g:1782:5: lv_inputs_5_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_48);
            lv_inputs_5_0=ruleTextInputText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_5_0,
            						"org.xtext.botGenerator.Bot.TextInputText");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1799:3: (otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==23) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBot.g:1800:4: otherlv_6= ',' ( (lv_inputs_7_0= ruleTextInputText ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_47); 

            	    				newLeafNode(otherlv_6, grammarAccess.getTextAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalBot.g:1804:4: ( (lv_inputs_7_0= ruleTextInputText ) )
            	    // InternalBot.g:1805:5: (lv_inputs_7_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:1805:5: (lv_inputs_7_0= ruleTextInputText )
            	    // InternalBot.g:1806:6: lv_inputs_7_0= ruleTextInputText
            	    {

            	    						newCompositeNode(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
            	    lv_inputs_7_0=ruleTextInputText();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_7_0,
            	    							"org.xtext.botGenerator.Bot.TextInputText");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:1828:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:1828:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:1829:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
            {
             newCompositeNode(grammarAccess.getHTTPResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHTTPResponse=ruleHTTPResponse();

            state._fsp--;

             current =iv_ruleHTTPResponse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTPResponse"


    // $ANTLR start "ruleHTTPResponse"
    // InternalBot.g:1835:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' ) ;
    public final EObject ruleHTTPResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1841:2: ( (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' ) )
            // InternalBot.g:1842:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' )
            {
            // InternalBot.g:1842:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' )
            // InternalBot.g:1843:3: otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0());
            		
            // InternalBot.g:1847:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1848:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1848:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1849:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3());
            		
            // InternalBot.g:1874:3: ( ( ruleEString ) )
            // InternalBot.g:1875:4: ( ruleEString )
            {
            // InternalBot.g:1875:4: ( ruleEString )
            // InternalBot.g:1876:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHTTPResponseRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0());
            				
            pushFollow(FOLLOW_15);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_50); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5());
            		
            otherlv_6=(Token)match(input,45,FOLLOW_51); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPResponseAccess().getTextKeyword_6());
            		
            // InternalBot.g:1898:3: ( (lv_inputs_7_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:1899:4: (lv_inputs_7_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:1899:4: (lv_inputs_7_0= ruleTextInputHttpResponse )
            // InternalBot.g:1900:5: lv_inputs_7_0= ruleTextInputHttpResponse
            {

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsTextInputHttpResponseParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_15);
            lv_inputs_7_0=ruleTextInputHttpResponse();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            					}
            					set(
            						current,
            						"inputs",
            						lv_inputs_7_0,
            						"org.xtext.botGenerator.Bot.TextInputHttpResponse");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPResponse"


    // $ANTLR start "entryRuleHTTPRequest"
    // InternalBot.g:1925:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:1925:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:1926:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
            {
             newCompositeNode(grammarAccess.getHTTPRequestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHTTPRequest=ruleHTTPRequest();

            state._fsp--;

             current =iv_ruleHTTPRequest; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTPRequest"


    // $ANTLR start "ruleHTTPRequest"
    // InternalBot.g:1932:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) ;
    public final EObject ruleHTTPRequest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Enumerator lv_method_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_URL_7_0 = null;

        EObject lv_basicAuth_11_0 = null;

        EObject lv_headers_15_0 = null;

        EObject lv_headers_17_0 = null;

        EObject lv_data_21_0 = null;

        EObject lv_data_23_0 = null;

        Enumerator lv_dataType_27_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1938:2: ( (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) )
            // InternalBot.g:1939:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            {
            // InternalBot.g:1939:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            // InternalBot.g:1940:3: otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_52); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0());
            		
            otherlv_1=(Token)match(input,49,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getHTTPRequestAccess().getRequestKeyword_1());
            		
            // InternalBot.g:1948:3: ( (lv_method_2_0= ruleMethod ) )
            // InternalBot.g:1949:4: (lv_method_2_0= ruleMethod )
            {
            // InternalBot.g:1949:4: (lv_method_2_0= ruleMethod )
            // InternalBot.g:1950:5: lv_method_2_0= ruleMethod
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_method_2_0=ruleMethod();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"method",
            						lv_method_2_0,
            						"org.xtext.botGenerator.Bot.Method");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1967:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1968:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1968:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1969:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_54); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getURLKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPRequestAccess().getColonKeyword_6());
            		
            // InternalBot.g:1998:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:1999:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:1999:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:2000:5: lv_URL_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_15);
            lv_URL_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_7_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_55); 

            			newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8());
            		
            // InternalBot.g:2021:3: (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==51) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:2022:4: otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,51,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0());
                    			
                    otherlv_10=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:2030:4: ( (lv_basicAuth_11_0= ruleKeyValue ) )
                    // InternalBot.g:2031:5: (lv_basicAuth_11_0= ruleKeyValue )
                    {
                    // InternalBot.g:2031:5: (lv_basicAuth_11_0= ruleKeyValue )
                    // InternalBot.g:2032:6: lv_basicAuth_11_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_basicAuth_11_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						set(
                    							current,
                    							"basicAuth",
                    							lv_basicAuth_11_0,
                    							"org.xtext.botGenerator.Bot.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,19,FOLLOW_56); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:2054:3: (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==52) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBot.g:2055:4: otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';'
                    {
                    otherlv_13=(Token)match(input,52,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0());
                    			
                    otherlv_14=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:2063:4: ( (lv_headers_15_0= ruleKeyValue ) )
                    // InternalBot.g:2064:5: (lv_headers_15_0= ruleKeyValue )
                    {
                    // InternalBot.g:2064:5: (lv_headers_15_0= ruleKeyValue )
                    // InternalBot.g:2065:6: lv_headers_15_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_headers_15_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						add(
                    							current,
                    							"headers",
                    							lv_headers_15_0,
                    							"org.xtext.botGenerator.Bot.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2082:4: (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==23) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalBot.g:2083:5: otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:2087:5: ( (lv_headers_17_0= ruleKeyValue ) )
                    	    // InternalBot.g:2088:6: (lv_headers_17_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:2088:6: (lv_headers_17_0= ruleKeyValue )
                    	    // InternalBot.g:2089:7: lv_headers_17_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    lv_headers_17_0=ruleKeyValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"headers",
                    	    								lv_headers_17_0,
                    	    								"org.xtext.botGenerator.Bot.KeyValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,19,FOLLOW_57); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:2112:3: (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==53) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:2113:4: otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';'
                    {
                    otherlv_19=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1());
                    			
                    // InternalBot.g:2121:4: ( (lv_data_21_0= ruleData ) )
                    // InternalBot.g:2122:5: (lv_data_21_0= ruleData )
                    {
                    // InternalBot.g:2122:5: (lv_data_21_0= ruleData )
                    // InternalBot.g:2123:6: lv_data_21_0= ruleData
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_data_21_0=ruleData();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						add(
                    							current,
                    							"data",
                    							lv_data_21_0,
                    							"org.xtext.botGenerator.Bot.Data");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2140:4: (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==23) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalBot.g:2141:5: otherlv_22= ',' ( (lv_data_23_0= ruleData ) )
                    	    {
                    	    otherlv_22=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalBot.g:2145:5: ( (lv_data_23_0= ruleData ) )
                    	    // InternalBot.g:2146:6: (lv_data_23_0= ruleData )
                    	    {
                    	    // InternalBot.g:2146:6: (lv_data_23_0= ruleData )
                    	    // InternalBot.g:2147:7: lv_data_23_0= ruleData
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    lv_data_23_0=ruleData();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"data",
                    	    								lv_data_23_0,
                    	    								"org.xtext.botGenerator.Bot.Data");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,19,FOLLOW_58); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4());
                    			
                    otherlv_25=(Token)match(input,54,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5());
                    			
                    otherlv_26=(Token)match(input,14,FOLLOW_59); 

                    				newLeafNode(otherlv_26, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6());
                    			
                    // InternalBot.g:2177:4: ( (lv_dataType_27_0= ruleDataType ) )
                    // InternalBot.g:2178:5: (lv_dataType_27_0= ruleDataType )
                    {
                    // InternalBot.g:2178:5: (lv_dataType_27_0= ruleDataType )
                    // InternalBot.g:2179:6: lv_dataType_27_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_11_7_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_dataType_27_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_27_0,
                    							"org.xtext.botGenerator.Bot.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_28=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_28, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPRequest"


    // $ANTLR start "entryRuleImage"
    // InternalBot.g:2205:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:2205:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:2206:2: iv_ruleImage= ruleImage EOF
            {
             newCompositeNode(grammarAccess.getImageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImage=ruleImage();

            state._fsp--;

             current =iv_ruleImage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImage"


    // $ANTLR start "ruleImage"
    // InternalBot.g:2212:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) ;
    public final EObject ruleImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_URL_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2218:2: ( (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) )
            // InternalBot.g:2219:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            {
            // InternalBot.g:2219:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            // InternalBot.g:2220:3: otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_46); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            otherlv_1=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2228:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2229:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2229:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2230:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImageRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_54); 

            			newLeafNode(otherlv_3, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:2259:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2260:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2260:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2261:5: lv_URL_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_URL_6_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImageRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_6_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImage"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:2282:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:2282:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:2283:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
            {
             newCompositeNode(grammarAccess.getTextInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextInputHttpResponse=ruleTextInputHttpResponse();

            state._fsp--;

             current =iv_ruleTextInputHttpResponse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextInputHttpResponse"


    // $ANTLR start "ruleTextInputHttpResponse"
    // InternalBot.g:2289:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:2295:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:2296:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:2296:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||LA44_0==34||LA44_0==38) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:2297:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:2297:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:2298:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:2298:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt43=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt43=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt43=2;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt43=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 43, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt43) {
            	        case 1 :
            	            // InternalBot.g:2299:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_60);
            	            lv_tokens_0_1=ruleLiteral();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputHttpResponseRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_1,
            	            						"org.xtext.botGenerator.Bot.Literal");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:2315:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_60);
            	            lv_tokens_0_2=ruleParameterToken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputHttpResponseRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_2,
            	            						"org.xtext.botGenerator.Bot.ParameterToken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 3 :
            	            // InternalBot.g:2331:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_60);
            	            lv_tokens_0_3=ruleHTTPRequestToken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputHttpResponseRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_3,
            	            						"org.xtext.botGenerator.Bot.HTTPRequestToken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextInputHttpResponse"


    // $ANTLR start "entryRuleTextInputText"
    // InternalBot.g:2352:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:2352:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:2353:2: iv_ruleTextInputText= ruleTextInputText EOF
            {
             newCompositeNode(grammarAccess.getTextInputTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextInputText=ruleTextInputText();

            state._fsp--;

             current =iv_ruleTextInputText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextInputText"


    // $ANTLR start "ruleTextInputText"
    // InternalBot.g:2359:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2365:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:2366:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:2366:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)||LA46_0==34) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:2367:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:2367:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:2368:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:2368:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_ID)) ) {
            	        alt45=1;
            	    }
            	    else if ( (LA45_0==34) ) {
            	        alt45=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 45, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // InternalBot.g:2369:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_61);
            	            lv_tokens_0_1=ruleLiteral();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputTextRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_1,
            	            						"org.xtext.botGenerator.Bot.Literal");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:2385:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_61);
            	            lv_tokens_0_2=ruleParameterToken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputTextRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_2,
            	            						"org.xtext.botGenerator.Bot.ParameterToken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt46 >= 1 ) break loop46;
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextInputText"


    // $ANTLR start "entryRuleKeyValue"
    // InternalBot.g:2406:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:2406:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:2407:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // InternalBot.g:2413:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2419:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:2420:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:2420:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:2421:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:2421:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2422:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2422:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2423:5: lv_key_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_key_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getKeyValueRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getColonKeyword_1());
            		
            // InternalBot.g:2444:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:2445:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:2445:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:2446:5: lv_value_2_0= ruleLiteral
            {

            					newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getKeyValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.botGenerator.Bot.Literal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleData"
    // InternalBot.g:2467:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:2467:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:2468:2: iv_ruleData= ruleData EOF
            {
             newCompositeNode(grammarAccess.getDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleData=ruleData();

            state._fsp--;

             current =iv_ruleData; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalBot.g:2474:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2480:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:2481:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:2481:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:2482:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:2482:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2483:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2483:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2484:5: lv_key_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_key_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:2505:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:2506:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:2506:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:2507:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:2507:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)) ) {
                alt47=1;
            }
            else if ( (LA47_0==34) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:2508:6: lv_value_2_1= ruleLiteral
                    {

                    						newCompositeNode(grammarAccess.getDataAccess().getValueLiteralParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_1=ruleLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_1,
                    							"org.xtext.botGenerator.Bot.Literal");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalBot.g:2524:6: lv_value_2_2= ruleParameterToken
                    {

                    						newCompositeNode(grammarAccess.getDataAccess().getValueParameterTokenParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_2=ruleParameterToken();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_2,
                    							"org.xtext.botGenerator.Bot.ParameterToken");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleData"


    // $ANTLR start "ruleDefaultEntity"
    // InternalBot.g:2546:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:2552:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:2553:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:2553:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt48=1;
                }
                break;
            case 56:
                {
                alt48=2;
                }
                break;
            case 57:
                {
                alt48=3;
                }
                break;
            case 58:
                {
                alt48=4;
                }
                break;
            case 59:
                {
                alt48=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalBot.g:2554:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:2554:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:2555:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2562:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:2562:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:2563:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:2570:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:2570:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:2571:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:2578:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:2578:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:2579:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:2586:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:2586:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:2587:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultEntity"


    // $ANTLR start "ruleHTTPReturnType"
    // InternalBot.g:2597:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:2603:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:2604:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:2604:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt49=1;
                }
                break;
            case 60:
                {
                alt49=2;
                }
                break;
            case 55:
                {
                alt49=3;
                }
                break;
            case 53:
                {
                alt49=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalBot.g:2605:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:2605:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:2606:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2613:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:2613:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:2614:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:2621:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:2621:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:2622:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:2629:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:2629:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:2630:4: enumLiteral_3= 'data'
                    {
                    enumLiteral_3=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPReturnType"


    // $ANTLR start "ruleLanguage"
    // InternalBot.g:2640:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) ) ;
    public final Enumerator ruleLanguage() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;


        	enterRule();

        try {
            // InternalBot.g:2646:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) ) )
            // InternalBot.g:2647:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) )
            {
            // InternalBot.g:2647:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) )
            int alt50=20;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt50=1;
                }
                break;
            case 62:
                {
                alt50=2;
                }
                break;
            case 63:
                {
                alt50=3;
                }
                break;
            case 64:
                {
                alt50=4;
                }
                break;
            case 65:
                {
                alt50=5;
                }
                break;
            case 66:
                {
                alt50=6;
                }
                break;
            case 67:
                {
                alt50=7;
                }
                break;
            case 68:
                {
                alt50=8;
                }
                break;
            case 69:
                {
                alt50=9;
                }
                break;
            case 70:
                {
                alt50=10;
                }
                break;
            case 71:
                {
                alt50=11;
                }
                break;
            case 72:
                {
                alt50=12;
                }
                break;
            case 73:
                {
                alt50=13;
                }
                break;
            case 74:
                {
                alt50=14;
                }
                break;
            case 75:
                {
                alt50=15;
                }
                break;
            case 76:
                {
                alt50=16;
                }
                break;
            case 77:
                {
                alt50=17;
                }
                break;
            case 78:
                {
                alt50=18;
                }
                break;
            case 79:
                {
                alt50=19;
                }
                break;
            case 80:
                {
                alt50=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalBot.g:2648:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:2648:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:2649:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2656:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:2656:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:2657:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:2664:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:2664:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:2665:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:2672:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:2672:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:2673:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:2680:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:2680:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:2681:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:2688:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:2688:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:2689:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:2696:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:2696:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:2697:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:2704:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:2704:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:2705:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:2712:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:2712:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:2713:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:2720:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:2720:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:2721:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:2728:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:2728:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:2729:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:2736:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:2736:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:2737:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:2744:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:2744:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:2745:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:2752:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:2752:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:2753:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:2760:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:2760:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:2761:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:2768:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:2768:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:2769:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:2776:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:2776:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:2777:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:2784:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:2784:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:2785:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:2792:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:2792:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:2793:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:2800:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:2800:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:2801:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLanguage"


    // $ANTLR start "ruleDataType"
    // InternalBot.g:2811:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:2817:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:2818:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:2818:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==81) ) {
                alt51=1;
            }
            else if ( (LA51_0==82) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:2819:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:2819:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:2820:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2827:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:2827:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:2828:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleMethod"
    // InternalBot.g:2838:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:2844:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:2845:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:2845:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==83) ) {
                alt52=1;
            }
            else if ( (LA52_0==84) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalBot.g:2846:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:2846:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:2847:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2854:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:2854:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:2855:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\6\uffff\1\12\4\uffff";
    static final String dfa_3s = "\1\34\1\35\1\4\2\27\1\4\1\23\2\27\2\uffff";
    static final String dfa_4s = "\1\34\1\35\1\5\2\36\1\5\1\33\2\36\2\uffff";
    static final String dfa_5s = "\11\uffff\1\2\1\1";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\5\6\uffff\1\6",
            "\1\5\6\uffff\1\6",
            "\1\7\1\10",
            "\1\12\1\uffff\1\11\5\uffff\1\12",
            "\1\5\6\uffff\1\6",
            "\1\5\6\uffff\1\6",
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

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "627:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xE000000000000000L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000038030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000030000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0081480000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0081480000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000032L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0F00080000000030L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000800800000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x10A0080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000002000000032L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000002000080030L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000200400000030L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000204400000030L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000180000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000204400000032L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000200400000032L});

}