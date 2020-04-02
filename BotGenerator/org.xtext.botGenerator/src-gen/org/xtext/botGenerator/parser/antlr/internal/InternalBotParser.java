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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language:'", "','", "'intents'", "':'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'parameters:'", "'inputs'", "'in'", "'{'", "'}'", "'user'", "'=>'", "'chatbot'", "'('", "')'", "'entity'", "'required'", "'isList'", "'prompts'", "'['", "']'", "'@'", "'request.'", "'.'", "'Simple'", "'Composite'", "'synonyms'", "'text'", "'response'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'image'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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
    // InternalBot.g:72:1: ruleBot returns [EObject current=null] : (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ ) ;
    public final EObject ruleBot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_languages_3_0 = null;

        Enumerator lv_languages_5_0 = null;

        EObject lv_intents_8_0 = null;

        EObject lv_intents_9_0 = null;

        EObject lv_entities_12_0 = null;

        EObject lv_entities_13_0 = null;

        EObject lv_actions_16_0 = null;

        EObject lv_actions_17_0 = null;

        EObject lv_flows_21_0 = null;



        	enterRule();

        try {
            // InternalBot.g:78:2: ( (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ ) )
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ )
            {
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ )
            // InternalBot.g:80:3: otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+
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
            		
            // InternalBot.g:107:3: ( (lv_languages_3_0= ruleLanguage ) )
            // InternalBot.g:108:4: (lv_languages_3_0= ruleLanguage )
            {
            // InternalBot.g:108:4: (lv_languages_3_0= ruleLanguage )
            // InternalBot.g:109:5: lv_languages_3_0= ruleLanguage
            {

            					newCompositeNode(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_languages_3_0=ruleLanguage();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"languages",
            						lv_languages_3_0,
            						"org.xtext.botGenerator.Bot.Language");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:126:3: (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:127:4: otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_4, grammarAccess.getBotAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:131:4: ( (lv_languages_5_0= ruleLanguage ) )
            	    // InternalBot.g:132:5: (lv_languages_5_0= ruleLanguage )
            	    {
            	    // InternalBot.g:132:5: (lv_languages_5_0= ruleLanguage )
            	    // InternalBot.g:133:6: lv_languages_5_0= ruleLanguage
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_languages_5_0=ruleLanguage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"languages",
            	    							lv_languages_5_0,
            	    							"org.xtext.botGenerator.Bot.Language");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getBotAccess().getIntentsKeyword_5());
            		
            otherlv_7=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getBotAccess().getColonKeyword_6());
            		
            // InternalBot.g:159:3: ( (lv_intents_8_0= ruleIntent ) )
            // InternalBot.g:160:4: (lv_intents_8_0= ruleIntent )
            {
            // InternalBot.g:160:4: (lv_intents_8_0= ruleIntent )
            // InternalBot.g:161:5: lv_intents_8_0= ruleIntent
            {

            					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_8);
            lv_intents_8_0=ruleIntent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"intents",
            						lv_intents_8_0,
            						"org.xtext.botGenerator.Bot.Intent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:178:3: ( (lv_intents_9_0= ruleIntent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:179:4: (lv_intents_9_0= ruleIntent )
            	    {
            	    // InternalBot.g:179:4: (lv_intents_9_0= ruleIntent )
            	    // InternalBot.g:180:5: lv_intents_9_0= ruleIntent
            	    {

            	    					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_intents_9_0=ruleIntent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBotRule());
            	    					}
            	    					add(
            	    						current,
            	    						"intents",
            	    						lv_intents_9_0,
            	    						"org.xtext.botGenerator.Bot.Intent");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalBot.g:197:3: (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBot.g:198:4: otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )*
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getBotAccess().getEntitiesKeyword_9_0());
                    			
                    otherlv_11=(Token)match(input,15,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getBotAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:206:4: ( (lv_entities_12_0= ruleEntity ) )
                    // InternalBot.g:207:5: (lv_entities_12_0= ruleEntity )
                    {
                    // InternalBot.g:207:5: (lv_entities_12_0= ruleEntity )
                    // InternalBot.g:208:6: lv_entities_12_0= ruleEntity
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_entities_12_0=ruleEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"entities",
                    							lv_entities_12_0,
                    							"org.xtext.botGenerator.Bot.Entity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:225:4: ( (lv_entities_13_0= ruleEntity ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=41 && LA3_0<=42)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBot.g:226:5: (lv_entities_13_0= ruleEntity )
                    	    {
                    	    // InternalBot.g:226:5: (lv_entities_13_0= ruleEntity )
                    	    // InternalBot.g:227:6: lv_entities_13_0= ruleEntity
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_entities_13_0=ruleEntity();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBotRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entities",
                    	    							lv_entities_13_0,
                    	    							"org.xtext.botGenerator.Bot.Entity");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBot.g:245:3: (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBot.g:246:4: otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )*
                    {
                    otherlv_14=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getBotAccess().getActionsKeyword_10_0());
                    			
                    otherlv_15=(Token)match(input,15,FOLLOW_11); 

                    				newLeafNode(otherlv_15, grammarAccess.getBotAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:254:4: ( (lv_actions_16_0= ruleAction ) )
                    // InternalBot.g:255:5: (lv_actions_16_0= ruleAction )
                    {
                    // InternalBot.g:255:5: (lv_actions_16_0= ruleAction )
                    // InternalBot.g:256:6: lv_actions_16_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_actions_16_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_16_0,
                    							"org.xtext.botGenerator.Bot.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:273:4: ( (lv_actions_17_0= ruleAction ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==44||LA5_0==46||LA5_0==48||LA5_0==55) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBot.g:274:5: (lv_actions_17_0= ruleAction )
                    	    {
                    	    // InternalBot.g:274:5: (lv_actions_17_0= ruleAction )
                    	    // InternalBot.g:275:6: lv_actions_17_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_3_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
                    	    lv_actions_17_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBotRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_17_0,
                    	    							"org.xtext.botGenerator.Bot.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_18=(Token)match(input,18,FOLLOW_7); 

            			newLeafNode(otherlv_18, grammarAccess.getBotAccess().getFlowsKeyword_11());
            		
            otherlv_19=(Token)match(input,15,FOLLOW_13); 

            			newLeafNode(otherlv_19, grammarAccess.getBotAccess().getColonKeyword_12());
            		
            // InternalBot.g:301:3: (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBot.g:302:4: otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';'
            	    {
            	    otherlv_20=(Token)match(input,19,FOLLOW_14); 

            	    				newLeafNode(otherlv_20, grammarAccess.getBotAccess().getHyphenMinusKeyword_13_0());
            	    			
            	    // InternalBot.g:306:4: ( (lv_flows_21_0= ruleTransition ) )
            	    // InternalBot.g:307:5: (lv_flows_21_0= ruleTransition )
            	    {
            	    // InternalBot.g:307:5: (lv_flows_21_0= ruleTransition )
            	    // InternalBot.g:308:6: lv_flows_21_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_flows_21_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"flows",
            	    							lv_flows_21_0,
            	    							"org.xtext.botGenerator.Bot.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_22=(Token)match(input,20,FOLLOW_16); 

            	    				newLeafNode(otherlv_22, grammarAccess.getBotAccess().getSemicolonKeyword_13_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
    // InternalBot.g:334:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:334:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:335:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalBot.g:341:1: ruleEntity returns [EObject current=null] : (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_Composite_1 = null;



        	enterRule();

        try {
            // InternalBot.g:347:2: ( (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite ) )
            // InternalBot.g:348:2: (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite )
            {
            // InternalBot.g:348:2: (this_Simple_0= ruleSimple | this_Composite_1= ruleComposite )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==41) ) {
                alt8=1;
            }
            else if ( (LA8_0==42) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBot.g:349:3: this_Simple_0= ruleSimple
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
                    // InternalBot.g:358:3: this_Composite_1= ruleComposite
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
    // InternalBot.g:370:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalBot.g:370:47: (iv_ruleAction= ruleAction EOF )
            // InternalBot.g:371:2: iv_ruleAction= ruleAction EOF
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
    // InternalBot.g:377:1: ruleAction returns [EObject current=null] : (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_Text_0 = null;

        EObject this_HTTPRequest_1 = null;

        EObject this_Image_2 = null;

        EObject this_HTTPResponse_3 = null;



        	enterRule();

        try {
            // InternalBot.g:383:2: ( (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) )
            // InternalBot.g:384:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            {
            // InternalBot.g:384:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt9=1;
                }
                break;
            case 48:
                {
                alt9=2;
                }
                break;
            case 55:
                {
                alt9=3;
                }
                break;
            case 46:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBot.g:385:3: this_Text_0= ruleText
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
                    // InternalBot.g:394:3: this_HTTPRequest_1= ruleHTTPRequest
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
                    // InternalBot.g:403:3: this_Image_2= ruleImage
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
                    // InternalBot.g:412:3: this_HTTPResponse_3= ruleHTTPResponse
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
    // InternalBot.g:424:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalBot.g:424:47: (iv_ruleEString= ruleEString EOF )
            // InternalBot.g:425:2: iv_ruleEString= ruleEString EOF
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
    // InternalBot.g:431:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalBot.g:437:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalBot.g:438:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalBot.g:438:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalBot.g:439:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:447:3: this_ID_1= RULE_ID
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
    // InternalBot.g:458:1: entryRuleIntent returns [EObject current=null] : iv_ruleIntent= ruleIntent EOF ;
    public final EObject entryRuleIntent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent = null;


        try {
            // InternalBot.g:458:47: (iv_ruleIntent= ruleIntent EOF )
            // InternalBot.g:459:2: iv_ruleIntent= ruleIntent EOF
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
    // InternalBot.g:465:1: ruleIntent returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )+ (otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )* )? ) ;
    public final EObject ruleIntent() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_inputs_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:471:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )+ (otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )* )? ) )
            // InternalBot.g:472:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )+ (otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )* )? )
            {
            // InternalBot.g:472:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )+ (otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )* )? )
            // InternalBot.g:473:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )+ (otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )* )?
            {
            // InternalBot.g:473:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:474:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:474:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:475:5: lv_name_0_0= ruleEString
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

            // InternalBot.g:492:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:493:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:493:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:494:5: lv_fallbackIntent_1_0= 'Fallback'
                    {
                    lv_fallbackIntent_1_0=(Token)match(input,21,FOLLOW_7); 

                    					newLeafNode(lv_fallbackIntent_1_0, grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntentRule());
                    					}
                    					setWithLastConsumed(current, "fallbackIntent", true, "Fallback");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getIntentAccess().getColonKeyword_2());
            		
            // InternalBot.g:510:3: ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBot.g:511:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    {
            	    // InternalBot.g:511:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    // InternalBot.g:512:5: lv_inputs_3_0= ruleIntentLanguageInputs
            	    {

            	    					newCompositeNode(grammarAccess.getIntentAccess().getInputsIntentLanguageInputsParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_inputs_3_0=ruleIntentLanguageInputs();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_3_0,
            	    						"org.xtext.botGenerator.Bot.IntentLanguageInputs");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            // InternalBot.g:529:3: (otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBot.g:530:4: otherlv_4= 'parameters:' ( (lv_parameters_5_0= ruleParameter ) ) ( (lv_parameters_6_0= ruleParameter ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntentAccess().getParametersKeyword_4_0());
                    			
                    // InternalBot.g:534:4: ( (lv_parameters_5_0= ruleParameter ) )
                    // InternalBot.g:535:5: (lv_parameters_5_0= ruleParameter )
                    {
                    // InternalBot.g:535:5: (lv_parameters_5_0= ruleParameter )
                    // InternalBot.g:536:6: lv_parameters_5_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_parameters_5_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_5_0,
                    							"org.xtext.botGenerator.Bot.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:553:4: ( (lv_parameters_6_0= ruleParameter ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_STRING) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==15) ) {
                                int LA13_4 = input.LA(3);

                                if ( (LA13_4==32) ) {
                                    alt13=1;
                                }


                            }


                        }
                        else if ( (LA13_0==RULE_ID) ) {
                            int LA13_2 = input.LA(2);

                            if ( (LA13_2==15) ) {
                                int LA13_4 = input.LA(3);

                                if ( (LA13_4==32) ) {
                                    alt13=1;
                                }


                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalBot.g:554:5: (lv_parameters_6_0= ruleParameter )
                    	    {
                    	    // InternalBot.g:554:5: (lv_parameters_6_0= ruleParameter )
                    	    // InternalBot.g:555:6: lv_parameters_6_0= ruleParameter
                    	    {

                    	    						newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_20);
                    	    lv_parameters_6_0=ruleParameter();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"parameters",
                    	    							lv_parameters_6_0,
                    	    							"org.xtext.botGenerator.Bot.Parameter");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
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
    // $ANTLR end "ruleIntent"


    // $ANTLR start "entryRuleIntentLanguageInputs"
    // InternalBot.g:577:1: entryRuleIntentLanguageInputs returns [EObject current=null] : iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF ;
    public final EObject entryRuleIntentLanguageInputs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentLanguageInputs = null;


        try {
            // InternalBot.g:577:61: (iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF )
            // InternalBot.g:578:2: iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF
            {
             newCompositeNode(grammarAccess.getIntentLanguageInputsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntentLanguageInputs=ruleIntentLanguageInputs();

            state._fsp--;

             current =iv_ruleIntentLanguageInputs; 
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
    // $ANTLR end "entryRuleIntentLanguageInputs"


    // $ANTLR start "ruleIntentLanguageInputs"
    // InternalBot.g:584:1: ruleIntentLanguageInputs returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleIntentLanguageInputs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:590:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:591:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:591:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' )
            // InternalBot.g:592:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0());
            		
            // InternalBot.g:596:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:597:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:601:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:602:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:602:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:603:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntentLanguageInputsRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:625:3: ( (lv_inputs_4_0= ruleTrainingPhrase ) )
            // InternalBot.g:626:4: (lv_inputs_4_0= ruleTrainingPhrase )
            {
            // InternalBot.g:626:4: (lv_inputs_4_0= ruleTrainingPhrase )
            // InternalBot.g:627:5: lv_inputs_4_0= ruleTrainingPhrase
            {

            					newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsTrainingPhraseParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTrainingPhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentLanguageInputsRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TrainingPhrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:644:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==13) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBot.g:645:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_23); 

            	    				newLeafNode(otherlv_5, grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:649:4: ( (lv_inputs_6_0= ruleTrainingPhrase ) )
            	    // InternalBot.g:650:5: (lv_inputs_6_0= ruleTrainingPhrase )
            	    {
            	    // InternalBot.g:650:5: (lv_inputs_6_0= ruleTrainingPhrase )
            	    // InternalBot.g:651:6: lv_inputs_6_0= ruleTrainingPhrase
            	    {

            	    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsTrainingPhraseParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTrainingPhrase();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIntentLanguageInputsRule());
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
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleIntentLanguageInputs"


    // $ANTLR start "entryRuleTransition"
    // InternalBot.g:677:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalBot.g:677:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalBot.g:678:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalBot.g:684:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_target_3_1 = null;

        EObject lv_target_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:690:2: ( (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) )
            // InternalBot.g:691:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            {
            // InternalBot.g:691:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            // InternalBot.g:692:3: otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getUserKeyword_0());
            		
            // InternalBot.g:696:3: ( ( ruleEString ) )
            // InternalBot.g:697:4: ( ruleEString )
            {
            // InternalBot.g:697:4: ( ruleEString )
            // InternalBot.g:698:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:712:3: (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBot.g:713:4: otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_26); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                    			
                    // InternalBot.g:717:4: ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    // InternalBot.g:718:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    {
                    // InternalBot.g:718:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    // InternalBot.g:719:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    {
                    // InternalBot.g:719:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    int alt17=2;
                    alt17 = dfa17.predict(input);
                    switch (alt17) {
                        case 1 :
                            // InternalBot.g:720:7: lv_target_3_1= ruleState
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
                            // InternalBot.g:736:7: lv_target_3_2= ruleState2
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
    // InternalBot.g:759:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBot.g:759:46: (iv_ruleState= ruleState EOF )
            // InternalBot.g:760:2: iv_ruleState= ruleState EOF
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
    // InternalBot.g:766:1: ruleState returns [EObject current=null] : (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? ) ;
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
            // InternalBot.g:772:2: ( (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? ) )
            // InternalBot.g:773:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? )
            {
            // InternalBot.g:773:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? )
            // InternalBot.g:774:3: otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getChatbotKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalBot.g:782:3: ( ( ruleEString ) )
            // InternalBot.g:783:4: ( ruleEString )
            {
            // InternalBot.g:783:4: ( ruleEString )
            // InternalBot.g:784:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_28);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:798:3: (otherlv_3= ',' ( ( ruleEString ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==13) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:799:4: otherlv_3= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getStateAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:803:4: ( ( ruleEString ) )
            	    // InternalBot.g:804:5: ( ruleEString )
            	    {
            	    // InternalBot.g:804:5: ( ruleEString )
            	    // InternalBot.g:805:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_28);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_5=(Token)match(input,31,FOLLOW_25); 

            			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightParenthesisKeyword_4());
            		
            // InternalBot.g:824:3: (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:825:4: otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_14); 

                    				newLeafNode(otherlv_6, grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_5_0());
                    			
                    // InternalBot.g:829:4: ( (lv_outcoming_7_0= ruleTransition ) )
                    // InternalBot.g:830:5: (lv_outcoming_7_0= ruleTransition )
                    {
                    // InternalBot.g:830:5: (lv_outcoming_7_0= ruleTransition )
                    // InternalBot.g:831:6: lv_outcoming_7_0= ruleTransition
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
    // InternalBot.g:853:1: entryRuleState2 returns [EObject current=null] : iv_ruleState2= ruleState2 EOF ;
    public final EObject entryRuleState2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState2 = null;


        try {
            // InternalBot.g:853:47: (iv_ruleState2= ruleState2 EOF )
            // InternalBot.g:854:2: iv_ruleState2= ruleState2 EOF
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
    // InternalBot.g:860:1: ruleState2 returns [EObject current=null] : (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' ) ;
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
            // InternalBot.g:866:2: ( (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' ) )
            // InternalBot.g:867:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' )
            {
            // InternalBot.g:867:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' )
            // InternalBot.g:868:3: otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getState2Access().getChatbotKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getState2Access().getLeftParenthesisKeyword_1());
            		
            // InternalBot.g:876:3: ( ( ruleEString ) )
            // InternalBot.g:877:4: ( ruleEString )
            {
            // InternalBot.g:877:4: ( ruleEString )
            // InternalBot.g:878:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getState2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_28);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:892:3: (otherlv_3= ',' ( ( ruleEString ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==13) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:893:4: otherlv_3= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getState2Access().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:897:4: ( ( ruleEString ) )
            	    // InternalBot.g:898:5: ( ruleEString )
            	    {
            	    // InternalBot.g:898:5: ( ruleEString )
            	    // InternalBot.g:899:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getState2Rule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_28);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_5=(Token)match(input,31,FOLLOW_22); 

            			newLeafNode(otherlv_5, grammarAccess.getState2Access().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,25,FOLLOW_29); 

            			newLeafNode(otherlv_6, grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5());
            		
            // InternalBot.g:922:3: (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBot.g:923:4: otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';'
            	    {
            	    otherlv_7=(Token)match(input,28,FOLLOW_14); 

            	    				newLeafNode(otherlv_7, grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_6_0());
            	    			
            	    // InternalBot.g:927:4: ( (lv_outcoming_8_0= ruleTransition ) )
            	    // InternalBot.g:928:5: (lv_outcoming_8_0= ruleTransition )
            	    {
            	    // InternalBot.g:928:5: (lv_outcoming_8_0= ruleTransition )
            	    // InternalBot.g:929:6: lv_outcoming_8_0= ruleTransition
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

            	    otherlv_9=(Token)match(input,20,FOLLOW_30); 

            	    				newLeafNode(otherlv_9, grammarAccess.getState2Access().getSemicolonKeyword_6_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            otherlv_10=(Token)match(input,26,FOLLOW_2); 

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
    // InternalBot.g:959:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:959:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:960:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
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
    // InternalBot.g:966:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:972:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:973:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:973:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:974:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:974:3: ()
            // InternalBot.g:975:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:981:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_ID)||LA24_0==30) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:982:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:982:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:983:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:983:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==30) ) {
            	        alt23=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // InternalBot.g:984:6: lv_tokens_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_31);
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
            	            // InternalBot.g:1000:6: lv_tokens_1_2= ruleParameterRefenceToken
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_31);
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
    // InternalBot.g:1022:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:1022:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:1023:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalBot.g:1029:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_required_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_isList_10_0=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_defaultEntity_4_0 = null;

        EObject lv_prompts_8_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1035:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' ) )
            // InternalBot.g:1036:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' )
            {
            // InternalBot.g:1036:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' )
            // InternalBot.g:1037:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';'
            {
            // InternalBot.g:1037:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1038:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1038:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1039:5: lv_name_0_0= ruleEString
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

            otherlv_1=(Token)match(input,15,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1064:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_ID)) ) {
                alt25=1;
            }
            else if ( (LA25_0==44||(LA25_0>=56 && LA25_0<=59)) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:1065:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:1065:4: ( ( ruleEString ) )
                    // InternalBot.g:1066:5: ( ruleEString )
                    {
                    // InternalBot.g:1066:5: ( ruleEString )
                    // InternalBot.g:1067:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_34);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1082:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:1082:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:1083:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:1083:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:1084:6: lv_defaultEntity_4_0= ruleDefaultEntity
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_34);
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

            // InternalBot.g:1102:3: (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==13) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==33) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // InternalBot.g:1103:4: otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )?
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_35); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1107:4: ( (lv_required_6_0= 'required' ) )
                    // InternalBot.g:1108:5: (lv_required_6_0= 'required' )
                    {
                    // InternalBot.g:1108:5: (lv_required_6_0= 'required' )
                    // InternalBot.g:1109:6: lv_required_6_0= 'required'
                    {
                    lv_required_6_0=(Token)match(input,33,FOLLOW_34); 

                    						newLeafNode(lv_required_6_0, grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "required", true, "required");
                    					

                    }


                    }

                    // InternalBot.g:1121:4: (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==13) ) {
                        int LA27_1 = input.LA(2);

                        if ( (LA27_1==35) ) {
                            alt27=1;
                        }
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalBot.g:1122:5: otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+
                            {
                            otherlv_7=(Token)match(input,13,FOLLOW_36); 

                            					newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_4_2_0());
                            				
                            // InternalBot.g:1126:5: ( (lv_prompts_8_0= rulePromptLanguage ) )+
                            int cnt26=0;
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==35) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // InternalBot.g:1127:6: (lv_prompts_8_0= rulePromptLanguage )
                            	    {
                            	    // InternalBot.g:1127:6: (lv_prompts_8_0= rulePromptLanguage )
                            	    // InternalBot.g:1128:7: lv_prompts_8_0= rulePromptLanguage
                            	    {

                            	    							newCompositeNode(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_4_2_1_0());
                            	    						
                            	    pushFollow(FOLLOW_37);
                            	    lv_prompts_8_0=rulePromptLanguage();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getParameterRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"prompts",
                            	    								lv_prompts_8_0,
                            	    								"org.xtext.botGenerator.Bot.PromptLanguage");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt26 >= 1 ) break loop26;
                                        EarlyExitException eee =
                                            new EarlyExitException(26, input);
                                        throw eee;
                                }
                                cnt26++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalBot.g:1147:3: (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==13) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:1148:4: otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) )
                    {
                    otherlv_9=(Token)match(input,13,FOLLOW_38); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1152:4: ( (lv_isList_10_0= 'isList' ) )
                    // InternalBot.g:1153:5: (lv_isList_10_0= 'isList' )
                    {
                    // InternalBot.g:1153:5: (lv_isList_10_0= 'isList' )
                    // InternalBot.g:1154:6: lv_isList_10_0= 'isList'
                    {
                    lv_isList_10_0=(Token)match(input,34,FOLLOW_15); 

                    						newLeafNode(lv_isList_10_0, grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "isList", true, "isList");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getParameterAccess().getSemicolonKeyword_6());
            		

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


    // $ANTLR start "entryRulePromptLanguage"
    // InternalBot.g:1175:1: entryRulePromptLanguage returns [EObject current=null] : iv_rulePromptLanguage= rulePromptLanguage EOF ;
    public final EObject entryRulePromptLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePromptLanguage = null;


        try {
            // InternalBot.g:1175:55: (iv_rulePromptLanguage= rulePromptLanguage EOF )
            // InternalBot.g:1176:2: iv_rulePromptLanguage= rulePromptLanguage EOF
            {
             newCompositeNode(grammarAccess.getPromptLanguageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePromptLanguage=rulePromptLanguage();

            state._fsp--;

             current =iv_rulePromptLanguage; 
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
    // $ANTLR end "entryRulePromptLanguage"


    // $ANTLR start "rulePromptLanguage"
    // InternalBot.g:1182:1: rulePromptLanguage returns [EObject current=null] : (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) ;
    public final EObject rulePromptLanguage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        AntlrDatatypeRuleToken lv_prompts_4_0 = null;

        AntlrDatatypeRuleToken lv_prompts_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1188:2: ( (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) )
            // InternalBot.g:1189:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            {
            // InternalBot.g:1189:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            // InternalBot.g:1190:3: otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_39); 

            			newLeafNode(otherlv_0, grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0());
            		
            // InternalBot.g:1194:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==24) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:1195:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getPromptLanguageAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:1199:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1200:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1200:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1201:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPromptLanguageRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalBot.g:1223:3: ( (lv_prompts_4_0= ruleEString ) )
            // InternalBot.g:1224:4: (lv_prompts_4_0= ruleEString )
            {
            // InternalBot.g:1224:4: (lv_prompts_4_0= ruleEString )
            // InternalBot.g:1225:5: lv_prompts_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_41);
            lv_prompts_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPromptLanguageRule());
            					}
            					add(
            						current,
            						"prompts",
            						lv_prompts_4_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1242:3: (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==13) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBot.g:1243:4: otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:1247:4: ( (lv_prompts_6_0= ruleEString ) )
            	    // InternalBot.g:1248:5: (lv_prompts_6_0= ruleEString )
            	    {
            	    // InternalBot.g:1248:5: (lv_prompts_6_0= ruleEString )
            	    // InternalBot.g:1249:6: lv_prompts_6_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_prompts_6_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPromptLanguageRule());
            	    						}
            	    						add(
            	    							current,
            	    							"prompts",
            	    							lv_prompts_6_0,
            	    							"org.xtext.botGenerator.Bot.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_7=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5());
            		

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
    // $ANTLR end "rulePromptLanguage"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:1275:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1275:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1276:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalBot.g:1282:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1288:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1289:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1289:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1290:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1290:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1291:4: lv_text_0_0= ruleEString
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
    // InternalBot.g:1311:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1311:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1312:2: iv_ruleEntityToken= ruleEntityToken EOF
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
    // InternalBot.g:1318:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBot.g:1324:2: ( (otherlv_0= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1325:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1325:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1326:3: otherlv_0= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0());
            		
            // InternalBot.g:1330:3: ( ( ruleEString ) )
            // InternalBot.g:1331:4: ( ruleEString )
            {
            // InternalBot.g:1331:4: ( ruleEString )
            // InternalBot.g:1332:5: ruleEString
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
    // InternalBot.g:1350:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1350:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1351:2: iv_ruleParameterToken= ruleParameterToken EOF
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
    // InternalBot.g:1357:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1363:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1364:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1364:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1365:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1369:3: ( ( ruleEString ) )
            // InternalBot.g:1370:4: ( ruleEString )
            {
            // InternalBot.g:1370:4: ( ruleEString )
            // InternalBot.g:1371:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0());
            				
            pushFollow(FOLLOW_42);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_2); 

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
    // InternalBot.g:1393:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1393:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1394:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
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
    // InternalBot.g:1400:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1406:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1407:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1407:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1408:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1412:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1413:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1413:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1414:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_43);
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

            otherlv_2=(Token)match(input,31,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1439:3: ( ( ruleEString ) )
            // InternalBot.g:1440:4: ( ruleEString )
            {
            // InternalBot.g:1440:4: ( ruleEString )
            // InternalBot.g:1441:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRefenceTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0());
            				
            pushFollow(FOLLOW_42);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

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
    // InternalBot.g:1463:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1463:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1464:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
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
    // InternalBot.g:1470:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1476:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1477:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1477:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1478:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1482:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1483:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1483:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1484:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_45);
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

            // InternalBot.g:1501:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBot.g:1502:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1506:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1507:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1507:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1508:6: lv_dataKey_3_0= ruleEString
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
    // InternalBot.g:1530:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // InternalBot.g:1530:47: (iv_ruleSimple= ruleSimple EOF )
            // InternalBot.g:1531:2: iv_ruleSimple= ruleSimple EOF
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
    // InternalBot.g:1537:1: ruleSimple returns [EObject current=null] : ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleSimpleLanguageInput ) )+ ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1543:2: ( ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleSimpleLanguageInput ) )+ ) )
            // InternalBot.g:1544:2: ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleSimpleLanguageInput ) )+ )
            {
            // InternalBot.g:1544:2: ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleSimpleLanguageInput ) )+ )
            // InternalBot.g:1545:3: () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleSimpleLanguageInput ) )+
            {
            // InternalBot.g:1545:3: ()
            // InternalBot.g:1546:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleAccess().getSimpleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleAccess().getSimpleKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1560:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1561:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1561:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1562:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,15,FOLLOW_46); 

            			newLeafNode(otherlv_4, grammarAccess.getSimpleAccess().getColonKeyword_4());
            		
            // InternalBot.g:1583:3: ( (lv_inputs_5_0= ruleSimpleLanguageInput ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==23||LA33_0==25) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBot.g:1584:4: (lv_inputs_5_0= ruleSimpleLanguageInput )
            	    {
            	    // InternalBot.g:1584:4: (lv_inputs_5_0= ruleSimpleLanguageInput )
            	    // InternalBot.g:1585:5: lv_inputs_5_0= ruleSimpleLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleAccess().getInputsSimpleLanguageInputParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_inputs_5_0=ruleSimpleLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSimpleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_5_0,
            	    						"org.xtext.botGenerator.Bot.SimpleLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleSimpleLanguageInput"
    // InternalBot.g:1606:1: entryRuleSimpleLanguageInput returns [EObject current=null] : iv_ruleSimpleLanguageInput= ruleSimpleLanguageInput EOF ;
    public final EObject entryRuleSimpleLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleLanguageInput = null;


        try {
            // InternalBot.g:1606:60: (iv_ruleSimpleLanguageInput= ruleSimpleLanguageInput EOF )
            // InternalBot.g:1607:2: iv_ruleSimpleLanguageInput= ruleSimpleLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getSimpleLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleLanguageInput=ruleSimpleLanguageInput();

            state._fsp--;

             current =iv_ruleSimpleLanguageInput; 
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
    // $ANTLR end "entryRuleSimpleLanguageInput"


    // $ANTLR start "ruleSimpleLanguageInput"
    // InternalBot.g:1613:1: ruleSimpleLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleSimpleLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1619:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:1620:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:1620:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:1621:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:1621:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBot.g:1622:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_48); 

                    				newLeafNode(otherlv_0, grammarAccess.getSimpleLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:1630:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1631:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1631:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1632:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getSimpleLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleLanguageInputRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSimpleLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:1654:3: ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* )
            // InternalBot.g:1655:4: ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )*
            {
            // InternalBot.g:1655:4: ( (lv_inputs_4_0= ruleSimpleInput ) )
            // InternalBot.g:1656:5: (lv_inputs_4_0= ruleSimpleInput )
            {
            // InternalBot.g:1656:5: (lv_inputs_4_0= ruleSimpleInput )
            // InternalBot.g:1657:6: lv_inputs_4_0= ruleSimpleInput
            {

            						newCompositeNode(grammarAccess.getSimpleLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_49);
            lv_inputs_4_0=ruleSimpleInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getSimpleLanguageInputRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.SimpleInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:1674:4: ( (lv_inputs_5_0= ruleSimpleInput ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_ID)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBot.g:1675:5: (lv_inputs_5_0= ruleSimpleInput )
            	    {
            	    // InternalBot.g:1675:5: (lv_inputs_5_0= ruleSimpleInput )
            	    // InternalBot.g:1676:6: lv_inputs_5_0= ruleSimpleInput
            	    {

            	    						newCompositeNode(grammarAccess.getSimpleLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_49);
            	    lv_inputs_5_0=ruleSimpleInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSimpleLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_5_0,
            	    							"org.xtext.botGenerator.Bot.SimpleInput");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSimpleLanguageInputAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleSimpleLanguageInput"


    // $ANTLR start "entryRuleComposite"
    // InternalBot.g:1702:1: entryRuleComposite returns [EObject current=null] : iv_ruleComposite= ruleComposite EOF ;
    public final EObject entryRuleComposite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposite = null;


        try {
            // InternalBot.g:1702:50: (iv_ruleComposite= ruleComposite EOF )
            // InternalBot.g:1703:2: iv_ruleComposite= ruleComposite EOF
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
    // InternalBot.g:1709:1: ruleComposite returns [EObject current=null] : ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleCompositeLanguageInput ) )+ ) ;
    public final EObject ruleComposite() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1715:2: ( ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleCompositeLanguageInput ) )+ ) )
            // InternalBot.g:1716:2: ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleCompositeLanguageInput ) )+ )
            {
            // InternalBot.g:1716:2: ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleCompositeLanguageInput ) )+ )
            // InternalBot.g:1717:3: () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleCompositeLanguageInput ) )+
            {
            // InternalBot.g:1717:3: ()
            // InternalBot.g:1718:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeAccess().getCompositeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,42,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeAccess().getCompositeKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1732:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1733:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1733:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1734:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,15,FOLLOW_46); 

            			newLeafNode(otherlv_4, grammarAccess.getCompositeAccess().getColonKeyword_4());
            		
            // InternalBot.g:1755:3: ( (lv_inputs_5_0= ruleCompositeLanguageInput ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==23||LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:1756:4: (lv_inputs_5_0= ruleCompositeLanguageInput )
            	    {
            	    // InternalBot.g:1756:4: (lv_inputs_5_0= ruleCompositeLanguageInput )
            	    // InternalBot.g:1757:5: lv_inputs_5_0= ruleCompositeLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getCompositeAccess().getInputsCompositeLanguageInputParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_inputs_5_0=ruleCompositeLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCompositeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_5_0,
            	    						"org.xtext.botGenerator.Bot.CompositeLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
    // $ANTLR end "ruleComposite"


    // $ANTLR start "entryRuleCompositeLanguageInput"
    // InternalBot.g:1778:1: entryRuleCompositeLanguageInput returns [EObject current=null] : iv_ruleCompositeLanguageInput= ruleCompositeLanguageInput EOF ;
    public final EObject entryRuleCompositeLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeLanguageInput = null;


        try {
            // InternalBot.g:1778:63: (iv_ruleCompositeLanguageInput= ruleCompositeLanguageInput EOF )
            // InternalBot.g:1779:2: iv_ruleCompositeLanguageInput= ruleCompositeLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getCompositeLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompositeLanguageInput=ruleCompositeLanguageInput();

            state._fsp--;

             current =iv_ruleCompositeLanguageInput; 
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
    // $ANTLR end "entryRuleCompositeLanguageInput"


    // $ANTLR start "ruleCompositeLanguageInput"
    // InternalBot.g:1785:1: ruleCompositeLanguageInput returns [EObject current=null] : ( () (otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) ) )? otherlv_4= '{' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? otherlv_7= '}' ) ;
    public final EObject ruleCompositeLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Enumerator lv_language_3_0 = null;

        EObject lv_inputs_5_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1791:2: ( ( () (otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) ) )? otherlv_4= '{' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? otherlv_7= '}' ) )
            // InternalBot.g:1792:2: ( () (otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) ) )? otherlv_4= '{' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? otherlv_7= '}' )
            {
            // InternalBot.g:1792:2: ( () (otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) ) )? otherlv_4= '{' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? otherlv_7= '}' )
            // InternalBot.g:1793:3: () (otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) ) )? otherlv_4= '{' ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )? otherlv_7= '}'
            {
            // InternalBot.g:1793:3: ()
            // InternalBot.g:1794:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeLanguageInputAccess().getCompositeLanguageInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:1800:3: (otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==23) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:1801:4: otherlv_1= 'inputs' otherlv_2= 'in' ( (lv_language_3_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getCompositeLanguageInputAccess().getInputsKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getCompositeLanguageInputAccess().getInKeyword_1_1());
                    			
                    // InternalBot.g:1809:4: ( (lv_language_3_0= ruleLanguage ) )
                    // InternalBot.g:1810:5: (lv_language_3_0= ruleLanguage )
                    {
                    // InternalBot.g:1810:5: (lv_language_3_0= ruleLanguage )
                    // InternalBot.g:1811:6: lv_language_3_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getCompositeLanguageInputAccess().getLanguageLanguageEnumRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_3_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompositeLanguageInputRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_3_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FOLLOW_50); 

            			newLeafNode(otherlv_4, grammarAccess.getCompositeLanguageInputAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:1833:3: ( ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)||LA39_0==38) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:1834:4: ( (lv_inputs_5_0= ruleCompositeInput ) ) ( (lv_inputs_6_0= ruleCompositeInput ) )*
                    {
                    // InternalBot.g:1834:4: ( (lv_inputs_5_0= ruleCompositeInput ) )
                    // InternalBot.g:1835:5: (lv_inputs_5_0= ruleCompositeInput )
                    {
                    // InternalBot.g:1835:5: (lv_inputs_5_0= ruleCompositeInput )
                    // InternalBot.g:1836:6: lv_inputs_5_0= ruleCompositeInput
                    {

                    						newCompositeNode(grammarAccess.getCompositeLanguageInputAccess().getInputsCompositeInputParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_inputs_5_0=ruleCompositeInput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompositeLanguageInputRule());
                    						}
                    						add(
                    							current,
                    							"inputs",
                    							lv_inputs_5_0,
                    							"org.xtext.botGenerator.Bot.CompositeInput");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:1853:4: ( (lv_inputs_6_0= ruleCompositeInput ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)||LA38_0==38) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalBot.g:1854:5: (lv_inputs_6_0= ruleCompositeInput )
                    	    {
                    	    // InternalBot.g:1854:5: (lv_inputs_6_0= ruleCompositeInput )
                    	    // InternalBot.g:1855:6: lv_inputs_6_0= ruleCompositeInput
                    	    {

                    	    						newCompositeNode(grammarAccess.getCompositeLanguageInputAccess().getInputsCompositeInputParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_50);
                    	    lv_inputs_6_0=ruleCompositeInput();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCompositeLanguageInputRule());
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
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getCompositeLanguageInputAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleCompositeLanguageInput"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:1881:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:1881:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:1882:2: iv_ruleSimpleInput= ruleSimpleInput EOF
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
    // InternalBot.g:1888:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' ) ;
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
            // InternalBot.g:1894:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' ) )
            // InternalBot.g:1895:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' )
            {
            // InternalBot.g:1895:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' )
            // InternalBot.g:1896:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';'
            {
            // InternalBot.g:1896:3: ()
            // InternalBot.g:1897:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:1903:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1904:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1904:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1905:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_51);
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

            // InternalBot.g:1922:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==43) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:1923:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,43,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:1927:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:1928:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:1928:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:1929:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    // InternalBot.g:1946:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==13) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalBot.g:1947:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:1951:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:1952:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:1952:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:1953:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

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
    // InternalBot.g:1980:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:1980:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:1981:2: iv_ruleCompositeInput= ruleCompositeInput EOF
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
    // InternalBot.g:1987:1: ruleCompositeInput returns [EObject current=null] : ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1993:2: ( ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' ) )
            // InternalBot.g:1994:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' )
            {
            // InternalBot.g:1994:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' )
            // InternalBot.g:1995:3: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';'
            {
            // InternalBot.g:1995:3: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_ID)||LA43_0==38) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalBot.g:1996:4: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:1996:4: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) )
            	    // InternalBot.g:1997:5: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:1997:5: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==38) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // InternalBot.g:1998:6: lv_tokens_0_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getTokensLiteralParserRuleCall_0_0_0());
            	            					
            	            pushFollow(FOLLOW_52);
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
            	            // InternalBot.g:2014:6: lv_tokens_0_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getTokensEntityTokenParserRuleCall_0_0_1());
            	            					
            	            pushFollow(FOLLOW_52);
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
            	    if ( cnt43 >= 1 ) break loop43;
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);

            otherlv_1=(Token)match(input,20,FOLLOW_2); 

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
    // InternalBot.g:2040:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:2040:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:2041:2: iv_ruleText= ruleText EOF
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
    // InternalBot.g:2047:1: ruleText returns [EObject current=null] : (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2053:2: ( (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) )
            // InternalBot.g:2054:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            {
            // InternalBot.g:2054:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            // InternalBot.g:2055:3: otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,44,FOLLOW_53); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0());
            		
            otherlv_1=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2063:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2064:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2064:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2065:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,15,FOLLOW_54); 

            			newLeafNode(otherlv_3, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:2086:3: ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==44) ) {
                    int LA44_1 = input.LA(2);

                    if ( ((LA44_1>=24 && LA44_1<=25)) ) {
                        alt44=1;
                    }


                }
                else if ( (LA44_0==25) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:2087:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    {
            	    // InternalBot.g:2087:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    // InternalBot.g:2088:5: lv_inputs_4_0= ruleTextLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_55);
            	    lv_inputs_4_0=ruleTextLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.TextLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

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


    // $ANTLR start "entryRuleTextLanguageInput"
    // InternalBot.g:2109:1: entryRuleTextLanguageInput returns [EObject current=null] : iv_ruleTextLanguageInput= ruleTextLanguageInput EOF ;
    public final EObject entryRuleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInput = null;


        try {
            // InternalBot.g:2109:58: (iv_ruleTextLanguageInput= ruleTextLanguageInput EOF )
            // InternalBot.g:2110:2: iv_ruleTextLanguageInput= ruleTextLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getTextLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextLanguageInput=ruleTextLanguageInput();

            state._fsp--;

             current =iv_ruleTextLanguageInput; 
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
    // $ANTLR end "entryRuleTextLanguageInput"


    // $ANTLR start "ruleTextLanguageInput"
    // InternalBot.g:2116:1: ruleTextLanguageInput returns [EObject current=null] : ( (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2122:2: ( ( (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2123:2: ( (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2123:2: ( (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            // InternalBot.g:2124:3: (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:2124:3: (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==44) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBot.g:2125:4: otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,44,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputAccess().getTextKeyword_0_0());
                    			
                    // InternalBot.g:2129:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==24) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalBot.g:2130:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_5); 

                            					newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:2134:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:2135:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:2135:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:2136:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_language_2_0=ruleLanguage();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTextLanguageInputRule());
                            							}
                            							set(
                            								current,
                            								"language",
                            								lv_language_2_0,
                            								"org.xtext.botGenerator.Bot.Language");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_56); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2159:3: ( (lv_inputs_4_0= ruleTextInputText ) )
            // InternalBot.g:2160:4: (lv_inputs_4_0= ruleTextInputText )
            {
            // InternalBot.g:2160:4: (lv_inputs_4_0= ruleTextInputText )
            // InternalBot.g:2161:5: lv_inputs_4_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTextInputText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextLanguageInputRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TextInputText");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2178:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==13) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBot.g:2179:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_56); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:2183:4: ( (lv_inputs_6_0= ruleTextInputText ) )
            	    // InternalBot.g:2184:5: (lv_inputs_6_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:2184:5: (lv_inputs_6_0= ruleTextInputText )
            	    // InternalBot.g:2185:6: lv_inputs_6_0= ruleTextInputText
            	    {

            	    						newCompositeNode(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTextInputText();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTextLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.TextInputText");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleTextLanguageInput"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:2211:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:2211:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:2212:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
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
    // InternalBot.g:2218:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ ) ;
    public final EObject ruleHTTPResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2224:2: ( (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ ) )
            // InternalBot.g:2225:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ )
            {
            // InternalBot.g:2225:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ )
            // InternalBot.g:2226:3: otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0());
            		
            // InternalBot.g:2230:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2231:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2231:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2232:5: lv_name_1_0= ruleEString
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

            otherlv_2=(Token)match(input,15,FOLLOW_57); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3());
            		
            // InternalBot.g:2257:3: ( ( ruleEString ) )
            // InternalBot.g:2258:4: ( ruleEString )
            {
            // InternalBot.g:2258:4: ( ruleEString )
            // InternalBot.g:2259:5: ruleEString
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

            otherlv_5=(Token)match(input,20,FOLLOW_58); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5());
            		
            // InternalBot.g:2277:3: ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==44) ) {
                    int LA48_1 = input.LA(2);

                    if ( ((LA48_1>=24 && LA48_1<=25)) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalBot.g:2278:4: (lv_inputs_6_0= ruleTextLanguageInputHttpResponse )
            	    {
            	    // InternalBot.g:2278:4: (lv_inputs_6_0= ruleTextLanguageInputHttpResponse )
            	    // InternalBot.g:2279:5: lv_inputs_6_0= ruleTextLanguageInputHttpResponse
            	    {

            	    					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_59);
            	    lv_inputs_6_0=ruleTextLanguageInputHttpResponse();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_6_0,
            	    						"org.xtext.botGenerator.Bot.TextLanguageInputHttpResponse");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
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
    // $ANTLR end "ruleHTTPResponse"


    // $ANTLR start "entryRuleHTTPRequest"
    // InternalBot.g:2300:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2300:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2301:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
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
    // InternalBot.g:2307:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) ;
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
            // InternalBot.g:2313:2: ( (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) )
            // InternalBot.g:2314:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            {
            // InternalBot.g:2314:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            // InternalBot.g:2315:3: otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_60); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0());
            		
            otherlv_1=(Token)match(input,49,FOLLOW_61); 

            			newLeafNode(otherlv_1, grammarAccess.getHTTPRequestAccess().getRequestKeyword_1());
            		
            // InternalBot.g:2323:3: ( (lv_method_2_0= ruleMethod ) )
            // InternalBot.g:2324:4: (lv_method_2_0= ruleMethod )
            {
            // InternalBot.g:2324:4: (lv_method_2_0= ruleMethod )
            // InternalBot.g:2325:5: lv_method_2_0= ruleMethod
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

            // InternalBot.g:2342:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:2343:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:2343:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:2344:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,15,FOLLOW_62); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getURLKeyword_5());
            		
            otherlv_6=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPRequestAccess().getColonKeyword_6());
            		
            // InternalBot.g:2373:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:2374:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:2374:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:2375:5: lv_URL_7_0= ruleEString
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

            otherlv_8=(Token)match(input,20,FOLLOW_63); 

            			newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8());
            		
            // InternalBot.g:2396:3: (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==51) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:2397:4: otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,51,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0());
                    			
                    otherlv_10=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:2405:4: ( (lv_basicAuth_11_0= ruleKeyValue ) )
                    // InternalBot.g:2406:5: (lv_basicAuth_11_0= ruleKeyValue )
                    {
                    // InternalBot.g:2406:5: (lv_basicAuth_11_0= ruleKeyValue )
                    // InternalBot.g:2407:6: lv_basicAuth_11_0= ruleKeyValue
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

                    otherlv_12=(Token)match(input,20,FOLLOW_64); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:2429:3: (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:2430:4: otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';'
                    {
                    otherlv_13=(Token)match(input,52,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0());
                    			
                    otherlv_14=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:2438:4: ( (lv_headers_15_0= ruleKeyValue ) )
                    // InternalBot.g:2439:5: (lv_headers_15_0= ruleKeyValue )
                    {
                    // InternalBot.g:2439:5: (lv_headers_15_0= ruleKeyValue )
                    // InternalBot.g:2440:6: lv_headers_15_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    // InternalBot.g:2457:4: (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==13) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalBot.g:2458:5: otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_16=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:2462:5: ( (lv_headers_17_0= ruleKeyValue ) )
                    	    // InternalBot.g:2463:6: (lv_headers_17_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:2463:6: (lv_headers_17_0= ruleKeyValue )
                    	    // InternalBot.g:2464:7: lv_headers_17_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,20,FOLLOW_65); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:2487:3: (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==53) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:2488:4: otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';'
                    {
                    otherlv_19=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1());
                    			
                    // InternalBot.g:2496:4: ( (lv_data_21_0= ruleData ) )
                    // InternalBot.g:2497:5: (lv_data_21_0= ruleData )
                    {
                    // InternalBot.g:2497:5: (lv_data_21_0= ruleData )
                    // InternalBot.g:2498:6: lv_data_21_0= ruleData
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_34);
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

                    // InternalBot.g:2515:4: (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==13) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalBot.g:2516:5: otherlv_22= ',' ( (lv_data_23_0= ruleData ) )
                    	    {
                    	    otherlv_22=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalBot.g:2520:5: ( (lv_data_23_0= ruleData ) )
                    	    // InternalBot.g:2521:6: (lv_data_23_0= ruleData )
                    	    {
                    	    // InternalBot.g:2521:6: (lv_data_23_0= ruleData )
                    	    // InternalBot.g:2522:7: lv_data_23_0= ruleData
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
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
                    	    break loop52;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,20,FOLLOW_66); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4());
                    			
                    otherlv_25=(Token)match(input,54,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5());
                    			
                    otherlv_26=(Token)match(input,15,FOLLOW_67); 

                    				newLeafNode(otherlv_26, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6());
                    			
                    // InternalBot.g:2552:4: ( (lv_dataType_27_0= ruleDataType ) )
                    // InternalBot.g:2553:5: (lv_dataType_27_0= ruleDataType )
                    {
                    // InternalBot.g:2553:5: (lv_dataType_27_0= ruleDataType )
                    // InternalBot.g:2554:6: lv_dataType_27_0= ruleDataType
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

                    otherlv_28=(Token)match(input,20,FOLLOW_2); 

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
    // InternalBot.g:2580:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:2580:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:2581:2: iv_ruleImage= ruleImage EOF
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
    // InternalBot.g:2587:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) ;
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
            // InternalBot.g:2593:2: ( (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) )
            // InternalBot.g:2594:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            {
            // InternalBot.g:2594:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            // InternalBot.g:2595:3: otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_53); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            otherlv_1=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2603:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2604:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2604:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2605:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,15,FOLLOW_62); 

            			newLeafNode(otherlv_3, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,50,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:2634:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2635:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2635:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2636:5: lv_URL_6_0= ruleEString
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


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:2657:1: entryRuleTextLanguageInputHttpResponse returns [EObject current=null] : iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF ;
    public final EObject entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInputHttpResponse = null;


        try {
            // InternalBot.g:2657:70: (iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:2658:2: iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF
            {
             newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextLanguageInputHttpResponse=ruleTextLanguageInputHttpResponse();

            state._fsp--;

             current =iv_ruleTextLanguageInputHttpResponse; 
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
    // $ANTLR end "entryRuleTextLanguageInputHttpResponse"


    // $ANTLR start "ruleTextLanguageInputHttpResponse"
    // InternalBot.g:2664:1: ruleTextLanguageInputHttpResponse returns [EObject current=null] : (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2670:2: ( (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2671:2: (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2671:2: (otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            // InternalBot.g:2672:3: otherlv_0= 'text' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputHttpResponseAccess().getTextKeyword_0());
            		
            // InternalBot.g:2676:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==24) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalBot.g:2677:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:2681:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2682:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2682:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2683:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTextLanguageInputHttpResponseRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_68); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:2705:3: ( (lv_inputs_4_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:2706:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:2706:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            // InternalBot.g:2707:5: lv_inputs_4_0= ruleTextInputHttpResponse
            {

            					newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTextInputHttpResponse();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextLanguageInputHttpResponseRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TextInputHttpResponse");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2724:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==13) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalBot.g:2725:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_68); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:2729:4: ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    // InternalBot.g:2730:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    {
            	    // InternalBot.g:2730:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    // InternalBot.g:2731:6: lv_inputs_6_0= ruleTextInputHttpResponse
            	    {

            	    						newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTextInputHttpResponse();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTextLanguageInputHttpResponseRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.TextInputHttpResponse");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleTextLanguageInputHttpResponse"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:2757:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:2757:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:2758:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
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
    // InternalBot.g:2764:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:2770:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:2771:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:2771:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_STRING && LA57_0<=RULE_ID)||LA57_0==36||LA57_0==39) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBot.g:2772:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:2772:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:2773:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:2773:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt56=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt56=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt56=2;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt56=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt56) {
            	        case 1 :
            	            // InternalBot.g:2774:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_69);
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
            	            // InternalBot.g:2790:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_69);
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
            	            // InternalBot.g:2806:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_69);
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
            	    if ( cnt57 >= 1 ) break loop57;
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
    // InternalBot.g:2827:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:2827:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:2828:2: iv_ruleTextInputText= ruleTextInputText EOF
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
    // InternalBot.g:2834:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2840:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:2841:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:2841:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_ID)||LA59_0==36) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBot.g:2842:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:2842:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:2843:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:2843:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt58=2;
            	    int LA58_0 = input.LA(1);

            	    if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_ID)) ) {
            	        alt58=1;
            	    }
            	    else if ( (LA58_0==36) ) {
            	        alt58=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 58, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt58) {
            	        case 1 :
            	            // InternalBot.g:2844:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_70);
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
            	            // InternalBot.g:2860:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_70);
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
            	    if ( cnt59 >= 1 ) break loop59;
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
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
    // InternalBot.g:2881:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:2881:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:2882:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalBot.g:2888:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2894:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:2895:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:2895:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:2896:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:2896:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2897:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2897:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2898:5: lv_key_0_0= ruleEString
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

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getColonKeyword_1());
            		
            // InternalBot.g:2919:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:2920:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:2920:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:2921:5: lv_value_2_0= ruleLiteral
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
    // InternalBot.g:2942:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:2942:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:2943:2: iv_ruleData= ruleData EOF
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
    // InternalBot.g:2949:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2955:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:2956:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:2956:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:2957:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:2957:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2958:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2958:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2959:5: lv_key_0_0= ruleEString
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

            otherlv_1=(Token)match(input,15,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:2980:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:2981:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:2981:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:2982:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:2982:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_ID)) ) {
                alt60=1;
            }
            else if ( (LA60_0==36) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalBot.g:2983:6: lv_value_2_1= ruleLiteral
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
                    // InternalBot.g:2999:6: lv_value_2_2= ruleParameterToken
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
    // InternalBot.g:3021:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:3027:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:3028:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:3028:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt61=5;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt61=1;
                }
                break;
            case 56:
                {
                alt61=2;
                }
                break;
            case 57:
                {
                alt61=3;
                }
                break;
            case 58:
                {
                alt61=4;
                }
                break;
            case 59:
                {
                alt61=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalBot.g:3029:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3029:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3030:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3037:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:3037:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:3038:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3045:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:3045:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:3046:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3053:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:3053:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:3054:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3061:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:3061:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:3062:4: enumLiteral_4= 'time'
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
    // InternalBot.g:3072:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:3078:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:3079:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:3079:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt62=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt62=1;
                }
                break;
            case 60:
                {
                alt62=2;
                }
                break;
            case 55:
                {
                alt62=3;
                }
                break;
            case 53:
                {
                alt62=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalBot.g:3080:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3080:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3081:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3088:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:3088:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:3089:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3096:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:3096:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:3097:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3104:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:3104:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:3105:4: enumLiteral_3= 'data'
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
    // InternalBot.g:3115:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
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
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;


        	enterRule();

        try {
            // InternalBot.g:3121:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:3122:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:3122:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt63=26;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt63=1;
                }
                break;
            case 62:
                {
                alt63=2;
                }
                break;
            case 63:
                {
                alt63=3;
                }
                break;
            case 64:
                {
                alt63=4;
                }
                break;
            case 65:
                {
                alt63=5;
                }
                break;
            case 66:
                {
                alt63=6;
                }
                break;
            case 67:
                {
                alt63=7;
                }
                break;
            case 68:
                {
                alt63=8;
                }
                break;
            case 69:
                {
                alt63=9;
                }
                break;
            case 70:
                {
                alt63=10;
                }
                break;
            case 71:
                {
                alt63=11;
                }
                break;
            case 72:
                {
                alt63=12;
                }
                break;
            case 73:
                {
                alt63=13;
                }
                break;
            case 74:
                {
                alt63=14;
                }
                break;
            case 75:
                {
                alt63=15;
                }
                break;
            case 76:
                {
                alt63=16;
                }
                break;
            case 77:
                {
                alt63=17;
                }
                break;
            case 78:
                {
                alt63=18;
                }
                break;
            case 79:
                {
                alt63=19;
                }
                break;
            case 80:
                {
                alt63=20;
                }
                break;
            case 81:
                {
                alt63=21;
                }
                break;
            case 82:
                {
                alt63=22;
                }
                break;
            case 83:
                {
                alt63=23;
                }
                break;
            case 84:
                {
                alt63=24;
                }
                break;
            case 85:
                {
                alt63=25;
                }
                break;
            case 86:
                {
                alt63=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalBot.g:3123:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:3123:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:3124:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3131:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:3131:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:3132:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3139:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:3139:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:3140:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3147:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:3147:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:3148:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3155:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:3155:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:3156:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:3163:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:3163:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:3164:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:3171:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:3171:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:3172:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:3179:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:3179:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:3180:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:3187:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:3187:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:3188:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:3195:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:3195:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:3196:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:3203:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:3203:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:3204:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:3211:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:3211:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:3212:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:3219:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:3219:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:3220:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:3227:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:3227:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:3228:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:3235:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:3235:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:3236:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:3243:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:3243:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:3244:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:3251:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:3251:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:3252:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:3259:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:3259:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:3260:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:3267:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:3267:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:3268:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:3275:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:3275:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:3276:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:3283:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:3283:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:3284:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:3291:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:3291:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:3292:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:3299:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:3299:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:3300:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:3307:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:3307:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:3308:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:3315:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:3315:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:3316:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:3323:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:3323:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:3324:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25());
                    			

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
    // InternalBot.g:3334:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3340:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:3341:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:3341:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==87) ) {
                alt64=1;
            }
            else if ( (LA64_0==88) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalBot.g:3342:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:3342:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:3343:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3350:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:3350:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:3351:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); 

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
    // InternalBot.g:3361:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3367:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:3368:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:3368:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==89) ) {
                alt65=1;
            }
            else if ( (LA65_0==90) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalBot.g:3369:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:3369:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:3370:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3377:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:3377:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:3378:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

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


    protected DFA17 dfa17 = new DFA17(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\6\uffff\1\12\4\uffff";
    static final String dfa_3s = "\1\35\1\36\1\4\2\15\1\4\1\24\2\15\2\uffff";
    static final String dfa_4s = "\1\35\1\36\1\5\2\37\1\5\1\34\2\37\2\uffff";
    static final String dfa_5s = "\11\uffff\1\2\1\1";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\5\21\uffff\1\6",
            "\1\5\21\uffff\1\6",
            "\1\7\1\10",
            "\1\12\4\uffff\1\11\2\uffff\1\12",
            "\1\5\21\uffff\1\6",
            "\1\5\21\uffff\1\6",
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

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "719:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xE000000000000000L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000060000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0081500000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0081500000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000080002000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000032L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0F00100000000030L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000800102000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000002000002000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x10A0100000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000004004000030L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000080000100000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000004000100030L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000100002000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000100002000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000006000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000001800000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000009000000030L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000009000000032L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000001000000032L});

}