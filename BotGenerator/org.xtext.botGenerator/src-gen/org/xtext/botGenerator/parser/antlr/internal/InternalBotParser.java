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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language:'", "','", "'intents'", "':'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'language'", "'{'", "'inputs:'", "'parameters:'", "'}'", "'user'", "'=>'", "'chatbot'", "'('", "')'", "'entity'", "'required'", "'prompts'", "'in'", "'['", "']'", "'isList'", "'@'", "'request.'", "'.'", "'Simple'", "'Composite'", "'synonyms'", "'text'", "'response'", "'text:'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'image'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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

                        if ( ((LA3_0>=42 && LA3_0<=43)) ) {
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

                        if ( (LA5_0==45||LA5_0==48||LA5_0==50||LA5_0==57) ) {
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

            if ( (LA8_0==42) ) {
                alt8=1;
            }
            else if ( (LA8_0==43) ) {
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
            case 45:
                {
                alt9=1;
                }
                break;
            case 50:
                {
                alt9=2;
                }
                break;
            case 57:
                {
                alt9=3;
                }
                break;
            case 48:
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
    // InternalBot.g:465:1: ruleIntent returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? (otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= '{' otherlv_6= 'inputs:' ( (lv_inputs_7_0= ruleTrainingPhrase ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) ) )* (otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleIntent() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_language_4_0 = null;

        EObject lv_inputs_7_0 = null;

        EObject lv_inputs_9_0 = null;

        EObject lv_parameters_11_0 = null;

        EObject lv_parameters_12_0 = null;



        	enterRule();

        try {
            // InternalBot.g:471:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? (otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= '{' otherlv_6= 'inputs:' ( (lv_inputs_7_0= ruleTrainingPhrase ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) ) )* (otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )* )? otherlv_13= '}' ) )
            // InternalBot.g:472:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? (otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= '{' otherlv_6= 'inputs:' ( (lv_inputs_7_0= ruleTrainingPhrase ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) ) )* (otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )* )? otherlv_13= '}' )
            {
            // InternalBot.g:472:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? (otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= '{' otherlv_6= 'inputs:' ( (lv_inputs_7_0= ruleTrainingPhrase ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) ) )* (otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )* )? otherlv_13= '}' )
            // InternalBot.g:473:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? (otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= '{' otherlv_6= 'inputs:' ( (lv_inputs_7_0= ruleTrainingPhrase ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) ) )* (otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )* )? otherlv_13= '}'
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
                    lv_fallbackIntent_1_0=(Token)match(input,21,FOLLOW_18); 

                    					newLeafNode(lv_fallbackIntent_1_0, grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntentRule());
                    					}
                    					setWithLastConsumed(current, "fallbackIntent", true, "Fallback");
                    				

                    }


                    }
                    break;

            }

            // InternalBot.g:506:3: (otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBot.g:507:4: otherlv_2= 'language' otherlv_3= ':' ( (lv_language_4_0= ruleLanguage ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getIntentAccess().getLanguageKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getIntentAccess().getColonKeyword_2_1());
                    			
                    // InternalBot.g:515:4: ( (lv_language_4_0= ruleLanguage ) )
                    // InternalBot.g:516:5: (lv_language_4_0= ruleLanguage )
                    {
                    // InternalBot.g:516:5: (lv_language_4_0= ruleLanguage )
                    // InternalBot.g:517:6: lv_language_4_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getIntentAccess().getLanguageLanguageEnumRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_language_4_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_4_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_20); 

            			newLeafNode(otherlv_5, grammarAccess.getIntentAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_6=(Token)match(input,24,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getIntentAccess().getInputsKeyword_4());
            		
            // InternalBot.g:543:3: ( (lv_inputs_7_0= ruleTrainingPhrase ) )
            // InternalBot.g:544:4: (lv_inputs_7_0= ruleTrainingPhrase )
            {
            // InternalBot.g:544:4: (lv_inputs_7_0= ruleTrainingPhrase )
            // InternalBot.g:545:5: lv_inputs_7_0= ruleTrainingPhrase
            {

            					newCompositeNode(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_22);
            lv_inputs_7_0=ruleTrainingPhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_7_0,
            						"org.xtext.botGenerator.Bot.TrainingPhrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:562:3: (otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==13) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBot.g:563:4: otherlv_8= ',' ( (lv_inputs_9_0= ruleTrainingPhrase ) )
            	    {
            	    otherlv_8=(Token)match(input,13,FOLLOW_21); 

            	    				newLeafNode(otherlv_8, grammarAccess.getIntentAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalBot.g:567:4: ( (lv_inputs_9_0= ruleTrainingPhrase ) )
            	    // InternalBot.g:568:5: (lv_inputs_9_0= ruleTrainingPhrase )
            	    {
            	    // InternalBot.g:568:5: (lv_inputs_9_0= ruleTrainingPhrase )
            	    // InternalBot.g:569:6: lv_inputs_9_0= ruleTrainingPhrase
            	    {

            	    						newCompositeNode(grammarAccess.getIntentAccess().getInputsTrainingPhraseParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_inputs_9_0=ruleTrainingPhrase();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIntentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_9_0,
            	    							"org.xtext.botGenerator.Bot.TrainingPhrase");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalBot.g:587:3: (otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:588:4: otherlv_10= 'parameters:' ( (lv_parameters_11_0= ruleParameter ) ) ( (lv_parameters_12_0= ruleParameter ) )*
                    {
                    otherlv_10=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getIntentAccess().getParametersKeyword_7_0());
                    			
                    // InternalBot.g:592:4: ( (lv_parameters_11_0= ruleParameter ) )
                    // InternalBot.g:593:5: (lv_parameters_11_0= ruleParameter )
                    {
                    // InternalBot.g:593:5: (lv_parameters_11_0= ruleParameter )
                    // InternalBot.g:594:6: lv_parameters_11_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_parameters_11_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_11_0,
                    							"org.xtext.botGenerator.Bot.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:611:4: ( (lv_parameters_12_0= ruleParameter ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_ID)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBot.g:612:5: (lv_parameters_12_0= ruleParameter )
                    	    {
                    	    // InternalBot.g:612:5: (lv_parameters_12_0= ruleParameter )
                    	    // InternalBot.g:613:6: lv_parameters_12_0= ruleParameter
                    	    {

                    	    						newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_7_2_0());
                    	    					
                    	    pushFollow(FOLLOW_23);
                    	    lv_parameters_12_0=ruleParameter();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getIntentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"parameters",
                    	    							lv_parameters_12_0,
                    	    							"org.xtext.botGenerator.Bot.Parameter");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getIntentAccess().getRightCurlyBracketKeyword_8());
            		

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
    // InternalBot.g:639:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalBot.g:639:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalBot.g:640:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalBot.g:646:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_target_3_1 = null;

        EObject lv_target_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:652:2: ( (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) )
            // InternalBot.g:653:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            {
            // InternalBot.g:653:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            // InternalBot.g:654:3: otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getUserKeyword_0());
            		
            // InternalBot.g:658:3: ( ( ruleEString ) )
            // InternalBot.g:659:4: ( ruleEString )
            {
            // InternalBot.g:659:4: ( ruleEString )
            // InternalBot.g:660:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:674:3: (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBot.g:675:4: otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                    			
                    // InternalBot.g:679:4: ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    // InternalBot.g:680:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    {
                    // InternalBot.g:680:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    // InternalBot.g:681:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    {
                    // InternalBot.g:681:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    int alt16=2;
                    alt16 = dfa16.predict(input);
                    switch (alt16) {
                        case 1 :
                            // InternalBot.g:682:7: lv_target_3_1= ruleState
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
                            // InternalBot.g:698:7: lv_target_3_2= ruleState2
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
    // InternalBot.g:721:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBot.g:721:46: (iv_ruleState= ruleState EOF )
            // InternalBot.g:722:2: iv_ruleState= ruleState EOF
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
    // InternalBot.g:728:1: ruleState returns [EObject current=null] : (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? ) ;
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
            // InternalBot.g:734:2: ( (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? ) )
            // InternalBot.g:735:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? )
            {
            // InternalBot.g:735:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )? )
            // InternalBot.g:736:3: otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getChatbotKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalBot.g:744:3: ( ( ruleEString ) )
            // InternalBot.g:745:4: ( ruleEString )
            {
            // InternalBot.g:745:4: ( ruleEString )
            // InternalBot.g:746:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_27);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:760:3: (otherlv_3= ',' ( ( ruleEString ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==13) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBot.g:761:4: otherlv_3= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getStateAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:765:4: ( ( ruleEString ) )
            	    // InternalBot.g:766:5: ( ruleEString )
            	    {
            	    // InternalBot.g:766:5: ( ruleEString )
            	    // InternalBot.g:767:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_27);
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

            otherlv_5=(Token)match(input,31,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightParenthesisKeyword_4());
            		
            // InternalBot.g:786:3: (otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalBot.g:787:4: otherlv_6= '=>' ( (lv_outcoming_7_0= ruleTransition ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_14); 

                    				newLeafNode(otherlv_6, grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_5_0());
                    			
                    // InternalBot.g:791:4: ( (lv_outcoming_7_0= ruleTransition ) )
                    // InternalBot.g:792:5: (lv_outcoming_7_0= ruleTransition )
                    {
                    // InternalBot.g:792:5: (lv_outcoming_7_0= ruleTransition )
                    // InternalBot.g:793:6: lv_outcoming_7_0= ruleTransition
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
    // InternalBot.g:815:1: entryRuleState2 returns [EObject current=null] : iv_ruleState2= ruleState2 EOF ;
    public final EObject entryRuleState2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState2 = null;


        try {
            // InternalBot.g:815:47: (iv_ruleState2= ruleState2 EOF )
            // InternalBot.g:816:2: iv_ruleState2= ruleState2 EOF
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
    // InternalBot.g:822:1: ruleState2 returns [EObject current=null] : (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' ) ;
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
            // InternalBot.g:828:2: ( (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' ) )
            // InternalBot.g:829:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' )
            {
            // InternalBot.g:829:2: (otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}' )
            // InternalBot.g:830:3: otherlv_0= 'chatbot' otherlv_1= '(' ( ( ruleEString ) ) (otherlv_3= ',' ( ( ruleEString ) ) )* otherlv_5= ')' otherlv_6= '{' (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getState2Access().getChatbotKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getState2Access().getLeftParenthesisKeyword_1());
            		
            // InternalBot.g:838:3: ( ( ruleEString ) )
            // InternalBot.g:839:4: ( ruleEString )
            {
            // InternalBot.g:839:4: ( ruleEString )
            // InternalBot.g:840:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getState2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_27);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:854:3: (otherlv_3= ',' ( ( ruleEString ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==13) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBot.g:855:4: otherlv_3= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getState2Access().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:859:4: ( ( ruleEString ) )
            	    // InternalBot.g:860:5: ( ruleEString )
            	    {
            	    // InternalBot.g:860:5: ( ruleEString )
            	    // InternalBot.g:861:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getState2Rule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_5=(Token)match(input,31,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getState2Access().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,23,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getState2Access().getLeftCurlyBracketKeyword_5());
            		
            // InternalBot.g:884:3: (otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:885:4: otherlv_7= '=>' ( (lv_outcoming_8_0= ruleTransition ) ) otherlv_9= ';'
            	    {
            	    otherlv_7=(Token)match(input,28,FOLLOW_14); 

            	    				newLeafNode(otherlv_7, grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_6_0());
            	    			
            	    // InternalBot.g:889:4: ( (lv_outcoming_8_0= ruleTransition ) )
            	    // InternalBot.g:890:5: (lv_outcoming_8_0= ruleTransition )
            	    {
            	    // InternalBot.g:890:5: (lv_outcoming_8_0= ruleTransition )
            	    // InternalBot.g:891:6: lv_outcoming_8_0= ruleTransition
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

            	    otherlv_9=(Token)match(input,20,FOLLOW_29); 

            	    				newLeafNode(otherlv_9, grammarAccess.getState2Access().getSemicolonKeyword_6_2());
            	    			

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
    // InternalBot.g:921:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:921:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:922:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
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
    // InternalBot.g:928:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:934:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:935:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:935:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:936:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:936:3: ()
            // InternalBot.g:937:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:943:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)||LA23_0==30) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:944:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:944:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:945:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:945:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==30) ) {
            	        alt22=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalBot.g:946:6: lv_tokens_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_30);
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
            	            // InternalBot.g:962:6: lv_tokens_1_2= ruleParameterRefenceToken
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_30);
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
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
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
    // InternalBot.g:984:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:984:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:985:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalBot.g:991:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )? )? (otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) ) )? otherlv_18= ';' ) ;
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
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_isList_17_0=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_defaultEntity_4_0 = null;

        Enumerator lv_prompLanguage_10_0 = null;

        AntlrDatatypeRuleToken lv_prompts_12_0 = null;

        AntlrDatatypeRuleToken lv_prompts_14_0 = null;



        	enterRule();

        try {
            // InternalBot.g:997:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )? )? (otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) ) )? otherlv_18= ';' ) )
            // InternalBot.g:998:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )? )? (otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) ) )? otherlv_18= ';' )
            {
            // InternalBot.g:998:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )? )? (otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) ) )? otherlv_18= ';' )
            // InternalBot.g:999:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )? )? (otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) ) )? otherlv_18= ';'
            {
            // InternalBot.g:999:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1000:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1000:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1001:5: lv_name_0_0= ruleEString
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

            otherlv_1=(Token)match(input,15,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1026:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_ID)) ) {
                alt24=1;
            }
            else if ( (LA24_0==45||(LA24_0>=58 && LA24_0<=61)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalBot.g:1027:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:1027:4: ( ( ruleEString ) )
                    // InternalBot.g:1028:5: ( ruleEString )
                    {
                    // InternalBot.g:1028:5: ( ruleEString )
                    // InternalBot.g:1029:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_33);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1044:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:1044:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:1045:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:1045:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:1046:6: lv_defaultEntity_4_0= ruleDefaultEntity
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_33);
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

            // InternalBot.g:1064:3: (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )? )?
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
                    // InternalBot.g:1065:4: otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )?
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_34); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1069:4: ( (lv_required_6_0= 'required' ) )
                    // InternalBot.g:1070:5: (lv_required_6_0= 'required' )
                    {
                    // InternalBot.g:1070:5: (lv_required_6_0= 'required' )
                    // InternalBot.g:1071:6: lv_required_6_0= 'required'
                    {
                    lv_required_6_0=(Token)match(input,33,FOLLOW_33); 

                    						newLeafNode(lv_required_6_0, grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "required", true, "required");
                    					

                    }


                    }

                    // InternalBot.g:1083:4: (otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==13) ) {
                        int LA27_1 = input.LA(2);

                        if ( (LA27_1==34) ) {
                            alt27=1;
                        }
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalBot.g:1084:5: otherlv_7= ',' otherlv_8= 'prompts' (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )? otherlv_11= '[' ( (lv_prompts_12_0= ruleEString ) ) (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )* otherlv_15= ']'
                            {
                            otherlv_7=(Token)match(input,13,FOLLOW_35); 

                            					newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_4_2_0());
                            				
                            otherlv_8=(Token)match(input,34,FOLLOW_36); 

                            					newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getPromptsKeyword_4_2_1());
                            				
                            // InternalBot.g:1092:5: (otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) ) )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==35) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // InternalBot.g:1093:6: otherlv_9= 'in' ( (lv_prompLanguage_10_0= ruleLanguage ) )
                                    {
                                    otherlv_9=(Token)match(input,35,FOLLOW_5); 

                                    						newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getInKeyword_4_2_2_0());
                                    					
                                    // InternalBot.g:1097:6: ( (lv_prompLanguage_10_0= ruleLanguage ) )
                                    // InternalBot.g:1098:7: (lv_prompLanguage_10_0= ruleLanguage )
                                    {
                                    // InternalBot.g:1098:7: (lv_prompLanguage_10_0= ruleLanguage )
                                    // InternalBot.g:1099:8: lv_prompLanguage_10_0= ruleLanguage
                                    {

                                    								newCompositeNode(grammarAccess.getParameterAccess().getPrompLanguageLanguageEnumRuleCall_4_2_2_1_0());
                                    							
                                    pushFollow(FOLLOW_37);
                                    lv_prompLanguage_10_0=ruleLanguage();

                                    state._fsp--;


                                    								if (current==null) {
                                    									current = createModelElementForParent(grammarAccess.getParameterRule());
                                    								}
                                    								set(
                                    									current,
                                    									"prompLanguage",
                                    									lv_prompLanguage_10_0,
                                    									"org.xtext.botGenerator.Bot.Language");
                                    								afterParserOrEnumRuleCall();
                                    							

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_11=(Token)match(input,36,FOLLOW_3); 

                            					newLeafNode(otherlv_11, grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_4_2_3());
                            				
                            // InternalBot.g:1121:5: ( (lv_prompts_12_0= ruleEString ) )
                            // InternalBot.g:1122:6: (lv_prompts_12_0= ruleEString )
                            {
                            // InternalBot.g:1122:6: (lv_prompts_12_0= ruleEString )
                            // InternalBot.g:1123:7: lv_prompts_12_0= ruleEString
                            {

                            							newCompositeNode(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_4_0());
                            						
                            pushFollow(FOLLOW_38);
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

                            // InternalBot.g:1140:5: (otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==13) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // InternalBot.g:1141:6: otherlv_13= ',' ( (lv_prompts_14_0= ruleEString ) )
                            	    {
                            	    otherlv_13=(Token)match(input,13,FOLLOW_3); 

                            	    						newLeafNode(otherlv_13, grammarAccess.getParameterAccess().getCommaKeyword_4_2_5_0());
                            	    					
                            	    // InternalBot.g:1145:6: ( (lv_prompts_14_0= ruleEString ) )
                            	    // InternalBot.g:1146:7: (lv_prompts_14_0= ruleEString )
                            	    {
                            	    // InternalBot.g:1146:7: (lv_prompts_14_0= ruleEString )
                            	    // InternalBot.g:1147:8: lv_prompts_14_0= ruleEString
                            	    {

                            	    								newCompositeNode(grammarAccess.getParameterAccess().getPromptsEStringParserRuleCall_4_2_5_1_0());
                            	    							
                            	    pushFollow(FOLLOW_38);
                            	    lv_prompts_14_0=ruleEString();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getParameterRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"prompts",
                            	    									lv_prompts_14_0,
                            	    									"org.xtext.botGenerator.Bot.EString");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);

                            otherlv_15=(Token)match(input,37,FOLLOW_33); 

                            					newLeafNode(otherlv_15, grammarAccess.getParameterAccess().getRightSquareBracketKeyword_4_2_6());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalBot.g:1171:3: (otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==13) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:1172:4: otherlv_16= ',' ( (lv_isList_17_0= 'isList' ) )
                    {
                    otherlv_16=(Token)match(input,13,FOLLOW_39); 

                    				newLeafNode(otherlv_16, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1176:4: ( (lv_isList_17_0= 'isList' ) )
                    // InternalBot.g:1177:5: (lv_isList_17_0= 'isList' )
                    {
                    // InternalBot.g:1177:5: (lv_isList_17_0= 'isList' )
                    // InternalBot.g:1178:6: lv_isList_17_0= 'isList'
                    {
                    lv_isList_17_0=(Token)match(input,38,FOLLOW_15); 

                    						newLeafNode(lv_isList_17_0, grammarAccess.getParameterAccess().getIsListIsListKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "isList", true, "isList");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_18=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getParameterAccess().getSemicolonKeyword_6());
            		

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
    // InternalBot.g:1199:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1199:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1200:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalBot.g:1206:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1212:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1213:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1213:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1214:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1214:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1215:4: lv_text_0_0= ruleEString
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
    // InternalBot.g:1235:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1235:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1236:2: iv_ruleEntityToken= ruleEntityToken EOF
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
    // InternalBot.g:1242:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBot.g:1248:2: ( (otherlv_0= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1249:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1249:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1250:3: otherlv_0= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0());
            		
            // InternalBot.g:1254:3: ( ( ruleEString ) )
            // InternalBot.g:1255:4: ( ruleEString )
            {
            // InternalBot.g:1255:4: ( ruleEString )
            // InternalBot.g:1256:5: ruleEString
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
    // InternalBot.g:1274:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1274:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1275:2: iv_ruleParameterToken= ruleParameterToken EOF
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
    // InternalBot.g:1281:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1287:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1288:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1288:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1289:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1293:3: ( ( ruleEString ) )
            // InternalBot.g:1294:4: ( ruleEString )
            {
            // InternalBot.g:1294:4: ( ruleEString )
            // InternalBot.g:1295:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0());
            				
            pushFollow(FOLLOW_40);
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
    // InternalBot.g:1317:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1317:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1318:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
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
    // InternalBot.g:1324:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1330:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1331:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1331:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1332:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1336:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1337:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1337:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1338:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_41);
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

            otherlv_2=(Token)match(input,31,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1363:3: ( ( ruleEString ) )
            // InternalBot.g:1364:4: ( ruleEString )
            {
            // InternalBot.g:1364:4: ( ruleEString )
            // InternalBot.g:1365:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRefenceTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0());
            				
            pushFollow(FOLLOW_40);
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
    // InternalBot.g:1387:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1387:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1388:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
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
    // InternalBot.g:1394:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1400:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1401:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1401:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1402:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_42); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1406:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1407:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1407:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1408:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_43);
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

            // InternalBot.g:1425:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==41) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:1426:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1430:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1431:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1431:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1432:6: lv_dataKey_3_0= ruleEString
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
    // InternalBot.g:1454:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // InternalBot.g:1454:47: (iv_ruleSimple= ruleSimple EOF )
            // InternalBot.g:1455:2: iv_ruleSimple= ruleSimple EOF
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
    // InternalBot.g:1461:1: ruleSimple returns [EObject current=null] : ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )* )? ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        Enumerator lv_language_5_0 = null;

        EObject lv_inputs_7_0 = null;

        EObject lv_inputs_8_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1467:2: ( ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )* )? ) )
            // InternalBot.g:1468:2: ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )* )? )
            {
            // InternalBot.g:1468:2: ( () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )* )? )
            // InternalBot.g:1469:3: () otherlv_1= 'Simple' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )* )?
            {
            // InternalBot.g:1469:3: ()
            // InternalBot.g:1470:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleAccess().getSimpleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,42,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleAccess().getSimpleKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1484:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1485:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1485:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1486:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_44);
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

            // InternalBot.g:1503:3: (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:1504:4: otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) )
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getSimpleAccess().getInKeyword_4_0());
                    			
                    // InternalBot.g:1508:4: ( (lv_language_5_0= ruleLanguage ) )
                    // InternalBot.g:1509:5: (lv_language_5_0= ruleLanguage )
                    {
                    // InternalBot.g:1509:5: (lv_language_5_0= ruleLanguage )
                    // InternalBot.g:1510:6: lv_language_5_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getSimpleAccess().getLanguageLanguageEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_language_5_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_5_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_45); 

            			newLeafNode(otherlv_6, grammarAccess.getSimpleAccess().getColonKeyword_5());
            		
            // InternalBot.g:1532:3: ( ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_ID)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:1533:4: ( (lv_inputs_7_0= ruleSimpleInput ) ) ( (lv_inputs_8_0= ruleSimpleInput ) )*
                    {
                    // InternalBot.g:1533:4: ( (lv_inputs_7_0= ruleSimpleInput ) )
                    // InternalBot.g:1534:5: (lv_inputs_7_0= ruleSimpleInput )
                    {
                    // InternalBot.g:1534:5: (lv_inputs_7_0= ruleSimpleInput )
                    // InternalBot.g:1535:6: lv_inputs_7_0= ruleSimpleInput
                    {

                    						newCompositeNode(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_inputs_7_0=ruleSimpleInput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleRule());
                    						}
                    						add(
                    							current,
                    							"inputs",
                    							lv_inputs_7_0,
                    							"org.xtext.botGenerator.Bot.SimpleInput");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:1552:4: ( (lv_inputs_8_0= ruleSimpleInput ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalBot.g:1553:5: (lv_inputs_8_0= ruleSimpleInput )
                    	    {
                    	    // InternalBot.g:1553:5: (lv_inputs_8_0= ruleSimpleInput )
                    	    // InternalBot.g:1554:6: lv_inputs_8_0= ruleSimpleInput
                    	    {

                    	    						newCompositeNode(grammarAccess.getSimpleAccess().getInputsSimpleInputParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_45);
                    	    lv_inputs_8_0=ruleSimpleInput();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSimpleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"inputs",
                    	    							lv_inputs_8_0,
                    	    							"org.xtext.botGenerator.Bot.SimpleInput");
                    	    						afterParserOrEnumRuleCall();
                    	    					

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
    // InternalBot.g:1576:1: entryRuleComposite returns [EObject current=null] : iv_ruleComposite= ruleComposite EOF ;
    public final EObject entryRuleComposite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposite = null;


        try {
            // InternalBot.g:1576:50: (iv_ruleComposite= ruleComposite EOF )
            // InternalBot.g:1577:2: iv_ruleComposite= ruleComposite EOF
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
    // InternalBot.g:1583:1: ruleComposite returns [EObject current=null] : ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )* )? ) ;
    public final EObject ruleComposite() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        Enumerator lv_language_5_0 = null;

        EObject lv_inputs_7_0 = null;

        EObject lv_inputs_8_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1589:2: ( ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )* )? ) )
            // InternalBot.g:1590:2: ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )* )? )
            {
            // InternalBot.g:1590:2: ( () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )* )? )
            // InternalBot.g:1591:3: () otherlv_1= 'Composite' otherlv_2= 'entity' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )? otherlv_6= ':' ( ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )* )?
            {
            // InternalBot.g:1591:3: ()
            // InternalBot.g:1592:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeAccess().getCompositeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeAccess().getCompositeKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1606:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1607:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1607:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1608:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompositeAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_44);
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

            // InternalBot.g:1625:3: (otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==35) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBot.g:1626:4: otherlv_4= 'in' ( (lv_language_5_0= ruleLanguage ) )
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getCompositeAccess().getInKeyword_4_0());
                    			
                    // InternalBot.g:1630:4: ( (lv_language_5_0= ruleLanguage ) )
                    // InternalBot.g:1631:5: (lv_language_5_0= ruleLanguage )
                    {
                    // InternalBot.g:1631:5: (lv_language_5_0= ruleLanguage )
                    // InternalBot.g:1632:6: lv_language_5_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getCompositeAccess().getLanguageLanguageEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_language_5_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompositeRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_5_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_46); 

            			newLeafNode(otherlv_6, grammarAccess.getCompositeAccess().getColonKeyword_5());
            		
            // InternalBot.g:1654:3: ( ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)||LA36_0==39) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBot.g:1655:4: ( (lv_inputs_7_0= ruleCompositeInput ) ) ( (lv_inputs_8_0= ruleCompositeInput ) )*
                    {
                    // InternalBot.g:1655:4: ( (lv_inputs_7_0= ruleCompositeInput ) )
                    // InternalBot.g:1656:5: (lv_inputs_7_0= ruleCompositeInput )
                    {
                    // InternalBot.g:1656:5: (lv_inputs_7_0= ruleCompositeInput )
                    // InternalBot.g:1657:6: lv_inputs_7_0= ruleCompositeInput
                    {

                    						newCompositeNode(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_inputs_7_0=ruleCompositeInput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompositeRule());
                    						}
                    						add(
                    							current,
                    							"inputs",
                    							lv_inputs_7_0,
                    							"org.xtext.botGenerator.Bot.CompositeInput");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:1674:4: ( (lv_inputs_8_0= ruleCompositeInput ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_ID)||LA35_0==39) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalBot.g:1675:5: (lv_inputs_8_0= ruleCompositeInput )
                    	    {
                    	    // InternalBot.g:1675:5: (lv_inputs_8_0= ruleCompositeInput )
                    	    // InternalBot.g:1676:6: lv_inputs_8_0= ruleCompositeInput
                    	    {

                    	    						newCompositeNode(grammarAccess.getCompositeAccess().getInputsCompositeInputParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_46);
                    	    lv_inputs_8_0=ruleCompositeInput();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCompositeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"inputs",
                    	    							lv_inputs_8_0,
                    	    							"org.xtext.botGenerator.Bot.CompositeInput");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
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
    // InternalBot.g:1698:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:1698:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:1699:2: iv_ruleSimpleInput= ruleSimpleInput EOF
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
    // InternalBot.g:1705:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' ) ;
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
            // InternalBot.g:1711:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' ) )
            // InternalBot.g:1712:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' )
            {
            // InternalBot.g:1712:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';' )
            // InternalBot.g:1713:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? otherlv_6= ';'
            {
            // InternalBot.g:1713:3: ()
            // InternalBot.g:1714:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:1720:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1721:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1721:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1722:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_47);
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

            // InternalBot.g:1739:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==44) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:1740:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:1744:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:1745:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:1745:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:1746:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_33);
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

                    // InternalBot.g:1763:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==13) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalBot.g:1764:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:1768:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:1769:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:1769:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:1770:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_33);
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
                    	    break loop37;
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
    // InternalBot.g:1797:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:1797:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:1798:2: iv_ruleCompositeInput= ruleCompositeInput EOF
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
    // InternalBot.g:1804:1: ruleCompositeInput returns [EObject current=null] : ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1810:2: ( ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' ) )
            // InternalBot.g:1811:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' )
            {
            // InternalBot.g:1811:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';' )
            // InternalBot.g:1812:3: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+ otherlv_1= ';'
            {
            // InternalBot.g:1812:3: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==39) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:1813:4: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:1813:4: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken ) )
            	    // InternalBot.g:1814:5: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:1814:5: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleEntityToken )
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)) ) {
            	        alt39=1;
            	    }
            	    else if ( (LA39_0==39) ) {
            	        alt39=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // InternalBot.g:1815:6: lv_tokens_0_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getTokensLiteralParserRuleCall_0_0_0());
            	            					
            	            pushFollow(FOLLOW_48);
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
            	            // InternalBot.g:1831:6: lv_tokens_0_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getTokensEntityTokenParserRuleCall_0_0_1());
            	            					
            	            pushFollow(FOLLOW_48);
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
            	    if ( cnt40 >= 1 ) break loop40;
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
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
    // InternalBot.g:1857:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:1857:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:1858:2: iv_ruleText= ruleText EOF
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
    // InternalBot.g:1864:1: ruleText returns [EObject current=null] : (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= ':' (otherlv_6= 'text:' )? ( (lv_inputs_7_0= ruleTextInputText ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) ) )* ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_language_4_0 = null;

        EObject lv_inputs_7_0 = null;

        EObject lv_inputs_9_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1870:2: ( (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= ':' (otherlv_6= 'text:' )? ( (lv_inputs_7_0= ruleTextInputText ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) ) )* ) )
            // InternalBot.g:1871:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= ':' (otherlv_6= 'text:' )? ( (lv_inputs_7_0= ruleTextInputText ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )
            {
            // InternalBot.g:1871:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= ':' (otherlv_6= 'text:' )? ( (lv_inputs_7_0= ruleTextInputText ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )
            // InternalBot.g:1872:3: otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) ) )? otherlv_5= ':' (otherlv_6= 'text:' )? ( (lv_inputs_7_0= ruleTextInputText ) ) (otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) ) )*
            {
            otherlv_0=(Token)match(input,45,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:1880:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1881:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1881:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1882:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_44);
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

            // InternalBot.g:1899:3: (otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==35) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:1900:4: otherlv_3= 'in' ( (lv_language_4_0= ruleLanguage ) )
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getTextAccess().getInKeyword_3_0());
                    			
                    // InternalBot.g:1904:4: ( (lv_language_4_0= ruleLanguage ) )
                    // InternalBot.g:1905:5: (lv_language_4_0= ruleLanguage )
                    {
                    // InternalBot.g:1905:5: (lv_language_4_0= ruleLanguage )
                    // InternalBot.g:1906:6: lv_language_4_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getTextAccess().getLanguageLanguageEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_language_4_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTextRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_4_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_50); 

            			newLeafNode(otherlv_5, grammarAccess.getTextAccess().getColonKeyword_4());
            		
            // InternalBot.g:1928:3: (otherlv_6= 'text:' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==47) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:1929:4: otherlv_6= 'text:'
                    {
                    otherlv_6=(Token)match(input,47,FOLLOW_50); 

                    				newLeafNode(otherlv_6, grammarAccess.getTextAccess().getTextKeyword_5());
                    			

                    }
                    break;

            }

            // InternalBot.g:1934:3: ( (lv_inputs_7_0= ruleTextInputText ) )
            // InternalBot.g:1935:4: (lv_inputs_7_0= ruleTextInputText )
            {
            // InternalBot.g:1935:4: (lv_inputs_7_0= ruleTextInputText )
            // InternalBot.g:1936:5: lv_inputs_7_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_51);
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

            // InternalBot.g:1953:3: (otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==13) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalBot.g:1954:4: otherlv_8= ',' ( (lv_inputs_9_0= ruleTextInputText ) )
            	    {
            	    otherlv_8=(Token)match(input,13,FOLLOW_50); 

            	    				newLeafNode(otherlv_8, grammarAccess.getTextAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalBot.g:1958:4: ( (lv_inputs_9_0= ruleTextInputText ) )
            	    // InternalBot.g:1959:5: (lv_inputs_9_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:1959:5: (lv_inputs_9_0= ruleTextInputText )
            	    // InternalBot.g:1960:6: lv_inputs_9_0= ruleTextInputText
            	    {

            	    						newCompositeNode(grammarAccess.getTextAccess().getInputsTextInputTextParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_inputs_9_0=ruleTextInputText();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_9_0,
            	    							"org.xtext.botGenerator.Bot.TextInputText");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // InternalBot.g:1982:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:1982:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:1983:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
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
    // InternalBot.g:1989:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' ) ;
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
            // InternalBot.g:1995:2: ( (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' ) )
            // InternalBot.g:1996:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' )
            {
            // InternalBot.g:1996:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';' )
            // InternalBot.g:1997:3: otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' otherlv_6= 'text:' ( (lv_inputs_7_0= ruleTextInputHttpResponse ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0());
            		
            // InternalBot.g:2001:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2002:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2002:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2003:5: lv_name_1_0= ruleEString
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

            otherlv_2=(Token)match(input,15,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3());
            		
            // InternalBot.g:2028:3: ( ( ruleEString ) )
            // InternalBot.g:2029:4: ( ruleEString )
            {
            // InternalBot.g:2029:4: ( ruleEString )
            // InternalBot.g:2030:5: ruleEString
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

            otherlv_5=(Token)match(input,20,FOLLOW_53); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5());
            		
            otherlv_6=(Token)match(input,47,FOLLOW_54); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPResponseAccess().getTextKeyword_6());
            		
            // InternalBot.g:2052:3: ( (lv_inputs_7_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:2053:4: (lv_inputs_7_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:2053:4: (lv_inputs_7_0= ruleTextInputHttpResponse )
            // InternalBot.g:2054:5: lv_inputs_7_0= ruleTextInputHttpResponse
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

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

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
    // InternalBot.g:2079:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2079:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2080:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
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
    // InternalBot.g:2086:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) ;
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
            // InternalBot.g:2092:2: ( (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) )
            // InternalBot.g:2093:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            {
            // InternalBot.g:2093:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            // InternalBot.g:2094:3: otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_55); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0());
            		
            otherlv_1=(Token)match(input,51,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getHTTPRequestAccess().getRequestKeyword_1());
            		
            // InternalBot.g:2102:3: ( (lv_method_2_0= ruleMethod ) )
            // InternalBot.g:2103:4: (lv_method_2_0= ruleMethod )
            {
            // InternalBot.g:2103:4: (lv_method_2_0= ruleMethod )
            // InternalBot.g:2104:5: lv_method_2_0= ruleMethod
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

            // InternalBot.g:2121:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:2122:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:2122:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:2123:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,15,FOLLOW_57); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,52,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getURLKeyword_5());
            		
            otherlv_6=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPRequestAccess().getColonKeyword_6());
            		
            // InternalBot.g:2152:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:2153:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:2153:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:2154:5: lv_URL_7_0= ruleEString
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

            otherlv_8=(Token)match(input,20,FOLLOW_58); 

            			newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8());
            		
            // InternalBot.g:2175:3: (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==53) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBot.g:2176:4: otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0());
                    			
                    otherlv_10=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:2184:4: ( (lv_basicAuth_11_0= ruleKeyValue ) )
                    // InternalBot.g:2185:5: (lv_basicAuth_11_0= ruleKeyValue )
                    {
                    // InternalBot.g:2185:5: (lv_basicAuth_11_0= ruleKeyValue )
                    // InternalBot.g:2186:6: lv_basicAuth_11_0= ruleKeyValue
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

                    otherlv_12=(Token)match(input,20,FOLLOW_59); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:2208:3: (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==54) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBot.g:2209:4: otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';'
                    {
                    otherlv_13=(Token)match(input,54,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0());
                    			
                    otherlv_14=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:2217:4: ( (lv_headers_15_0= ruleKeyValue ) )
                    // InternalBot.g:2218:5: (lv_headers_15_0= ruleKeyValue )
                    {
                    // InternalBot.g:2218:5: (lv_headers_15_0= ruleKeyValue )
                    // InternalBot.g:2219:6: lv_headers_15_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_33);
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

                    // InternalBot.g:2236:4: (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==13) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalBot.g:2237:5: otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_16=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:2241:5: ( (lv_headers_17_0= ruleKeyValue ) )
                    	    // InternalBot.g:2242:6: (lv_headers_17_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:2242:6: (lv_headers_17_0= ruleKeyValue )
                    	    // InternalBot.g:2243:7: lv_headers_17_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_33);
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
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,20,FOLLOW_60); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:2266:3: (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBot.g:2267:4: otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';'
                    {
                    otherlv_19=(Token)match(input,55,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1());
                    			
                    // InternalBot.g:2275:4: ( (lv_data_21_0= ruleData ) )
                    // InternalBot.g:2276:5: (lv_data_21_0= ruleData )
                    {
                    // InternalBot.g:2276:5: (lv_data_21_0= ruleData )
                    // InternalBot.g:2277:6: lv_data_21_0= ruleData
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_33);
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

                    // InternalBot.g:2294:4: (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==13) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalBot.g:2295:5: otherlv_22= ',' ( (lv_data_23_0= ruleData ) )
                    	    {
                    	    otherlv_22=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalBot.g:2299:5: ( (lv_data_23_0= ruleData ) )
                    	    // InternalBot.g:2300:6: (lv_data_23_0= ruleData )
                    	    {
                    	    // InternalBot.g:2300:6: (lv_data_23_0= ruleData )
                    	    // InternalBot.g:2301:7: lv_data_23_0= ruleData
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_33);
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
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,20,FOLLOW_61); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4());
                    			
                    otherlv_25=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5());
                    			
                    otherlv_26=(Token)match(input,15,FOLLOW_62); 

                    				newLeafNode(otherlv_26, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6());
                    			
                    // InternalBot.g:2331:4: ( (lv_dataType_27_0= ruleDataType ) )
                    // InternalBot.g:2332:5: (lv_dataType_27_0= ruleDataType )
                    {
                    // InternalBot.g:2332:5: (lv_dataType_27_0= ruleDataType )
                    // InternalBot.g:2333:6: lv_dataType_27_0= ruleDataType
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
    // InternalBot.g:2359:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:2359:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:2360:2: iv_ruleImage= ruleImage EOF
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
    // InternalBot.g:2366:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) ;
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
            // InternalBot.g:2372:2: ( (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) )
            // InternalBot.g:2373:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            {
            // InternalBot.g:2373:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            // InternalBot.g:2374:3: otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2382:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2383:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2383:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2384:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,15,FOLLOW_57); 

            			newLeafNode(otherlv_3, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,52,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:2413:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2414:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2414:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2415:5: lv_URL_6_0= ruleEString
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
    // InternalBot.g:2436:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:2436:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:2437:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
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
    // InternalBot.g:2443:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:2449:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:2450:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:2450:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||LA50_0==36||LA50_0==40) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:2451:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:2451:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:2452:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:2452:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt49=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt49=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt49=2;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt49=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt49) {
            	        case 1 :
            	            // InternalBot.g:2453:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_63);
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
            	            // InternalBot.g:2469:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_63);
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
            	            // InternalBot.g:2485:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_63);
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
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
    // InternalBot.g:2506:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:2506:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:2507:2: iv_ruleTextInputText= ruleTextInputText EOF
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
    // InternalBot.g:2513:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2519:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:2520:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:2520:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=RULE_STRING && LA52_0<=RULE_ID)||LA52_0==36) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:2521:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:2521:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:2522:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:2522:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_ID)) ) {
            	        alt51=1;
            	    }
            	    else if ( (LA51_0==36) ) {
            	        alt51=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 51, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // InternalBot.g:2523:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_64);
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
            	            // InternalBot.g:2539:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_64);
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
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
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
    // InternalBot.g:2560:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:2560:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:2561:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalBot.g:2567:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2573:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:2574:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:2574:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:2575:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:2575:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2576:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2576:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2577:5: lv_key_0_0= ruleEString
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
            		
            // InternalBot.g:2598:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:2599:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:2599:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:2600:5: lv_value_2_0= ruleLiteral
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
    // InternalBot.g:2621:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:2621:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:2622:2: iv_ruleData= ruleData EOF
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
    // InternalBot.g:2628:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2634:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:2635:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:2635:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:2636:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:2636:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2637:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2637:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2638:5: lv_key_0_0= ruleEString
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

            otherlv_1=(Token)match(input,15,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:2659:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:2660:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:2660:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:2661:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:2661:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_STRING && LA53_0<=RULE_ID)) ) {
                alt53=1;
            }
            else if ( (LA53_0==36) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:2662:6: lv_value_2_1= ruleLiteral
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
                    // InternalBot.g:2678:6: lv_value_2_2= ruleParameterToken
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
    // InternalBot.g:2700:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:2706:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:2707:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:2707:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt54=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt54=1;
                }
                break;
            case 58:
                {
                alt54=2;
                }
                break;
            case 59:
                {
                alt54=3;
                }
                break;
            case 60:
                {
                alt54=4;
                }
                break;
            case 61:
                {
                alt54=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalBot.g:2708:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:2708:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:2709:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2716:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:2716:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:2717:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:2724:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:2724:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:2725:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:2732:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:2732:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:2733:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:2740:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:2740:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:2741:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,61,FOLLOW_2); 

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
    // InternalBot.g:2751:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:2757:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:2758:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:2758:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt55=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt55=1;
                }
                break;
            case 62:
                {
                alt55=2;
                }
                break;
            case 57:
                {
                alt55=3;
                }
                break;
            case 55:
                {
                alt55=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalBot.g:2759:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:2759:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:2760:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2767:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:2767:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:2768:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:2775:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:2775:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:2776:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:2783:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:2783:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:2784:4: enumLiteral_3= 'data'
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_2); 

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
    // InternalBot.g:2794:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
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
            // InternalBot.g:2800:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:2801:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:2801:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt56=26;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt56=1;
                }
                break;
            case 64:
                {
                alt56=2;
                }
                break;
            case 65:
                {
                alt56=3;
                }
                break;
            case 66:
                {
                alt56=4;
                }
                break;
            case 67:
                {
                alt56=5;
                }
                break;
            case 68:
                {
                alt56=6;
                }
                break;
            case 69:
                {
                alt56=7;
                }
                break;
            case 70:
                {
                alt56=8;
                }
                break;
            case 71:
                {
                alt56=9;
                }
                break;
            case 72:
                {
                alt56=10;
                }
                break;
            case 73:
                {
                alt56=11;
                }
                break;
            case 74:
                {
                alt56=12;
                }
                break;
            case 75:
                {
                alt56=13;
                }
                break;
            case 76:
                {
                alt56=14;
                }
                break;
            case 77:
                {
                alt56=15;
                }
                break;
            case 78:
                {
                alt56=16;
                }
                break;
            case 79:
                {
                alt56=17;
                }
                break;
            case 80:
                {
                alt56=18;
                }
                break;
            case 81:
                {
                alt56=19;
                }
                break;
            case 82:
                {
                alt56=20;
                }
                break;
            case 83:
                {
                alt56=21;
                }
                break;
            case 84:
                {
                alt56=22;
                }
                break;
            case 85:
                {
                alt56=23;
                }
                break;
            case 86:
                {
                alt56=24;
                }
                break;
            case 87:
                {
                alt56=25;
                }
                break;
            case 88:
                {
                alt56=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalBot.g:2802:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:2802:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:2803:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2810:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:2810:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:2811:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:2818:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:2818:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:2819:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:2826:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:2826:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:2827:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:2834:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:2834:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:2835:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:2842:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:2842:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:2843:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:2850:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:2850:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:2851:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:2858:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:2858:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:2859:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:2866:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:2866:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:2867:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:2874:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:2874:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:2875:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:2882:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:2882:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:2883:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:2890:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:2890:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:2891:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:2898:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:2898:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:2899:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:2906:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:2906:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:2907:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:2914:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:2914:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:2915:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:2922:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:2922:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:2923:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:2930:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:2930:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:2931:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:2938:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:2938:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:2939:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:2946:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:2946:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:2947:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:2954:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:2954:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:2955:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:2962:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:2962:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:2963:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:2970:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:2970:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:2971:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:2978:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:2978:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:2979:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:2986:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:2986:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:2987:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:2994:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:2994:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:2995:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:3002:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:3002:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:3003:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,88,FOLLOW_2); 

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
    // InternalBot.g:3013:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3019:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:3020:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:3020:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==89) ) {
                alt57=1;
            }
            else if ( (LA57_0==90) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalBot.g:3021:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:3021:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:3022:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3029:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:3029:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:3030:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

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
    // InternalBot.g:3040:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3046:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:3047:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:3047:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==91) ) {
                alt58=1;
            }
            else if ( (LA58_0==92) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:3048:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:3048:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:3049:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3056:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:3056:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:3057:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

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


    protected DFA16 dfa16 = new DFA16(this);
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
            "\1\12\2\uffff\1\11\4\uffff\1\12",
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

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "681:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x8000000000000000L,0x0000000001FFFFFFL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000C0000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0205200000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0205200000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000006002000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000032L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x3C00200000000030L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x4280200000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000008000000032L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000100000100000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000008000100030L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000801000000030L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000811000000030L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000006000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000811000000032L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000801000000032L});

}