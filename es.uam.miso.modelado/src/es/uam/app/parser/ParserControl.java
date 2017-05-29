package es.uam.app.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;

public class ParserControl {
	public static final String PARSER_MODEL = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
	private static ParserControl parser=null;
	private LexicalizedParser lp;
	private TreebankLanguagePack tlp;
	private GrammaticalStructureFactory gsf;
	private final TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
			"invertible=true");

	private ParserControl() {
		String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
		lp = LexicalizedParser.loadModel(PARSER_MODEL, options);
		tlp = lp.treebankLanguagePack();
		gsf = tlp.grammaticalStructureFactory();

	}
	public static ParserControl getParser() {
		if (parser==null){
			parser= new ParserControl();
		}
		return parser;
	}

	private List<CoreLabel> tokenize(String str) {
		Tokenizer<CoreLabel> tokenizer = tokenizerFactory.getTokenizer(new StringReader(str));
		return tokenizer.tokenize();
	}

	public Tree parser(String sentence) {
		List<CoreLabel> rawWords = tokenize(sentence);
		Tree parse = lp.apply(rawWords);
		return parse;
	}
	
	
	public Tree parser(List<TaggedWord> sentenceTW) {
		List<CoreLabel> rawWords = Sentence.toCoreLabelList(sentenceTW);
		Tree parse = lp.apply(rawWords);
		return parse;
	}

	public static TypedDependency getRoot(List<TypedDependency> list){
		for (TypedDependency t: list){
			if (t.reln().getShortName().equals("root")){
				return t;
			}
		}
		return null;
	}
	
	public static List<TypedDependency> getNext(IndexedWord word, List<TypedDependency> list){
		List<TypedDependency> ret= new ArrayList<>();
		for(TypedDependency t: list){
			if (t.gov().compareTo(word)==0){
				ret.add(t);
			}
		}
		return ret;
	}

	public List<TypedDependency> getDependecies(String sentence) {
		Tree parse = parser(sentence);
		GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
		return gs.typedDependenciesCCprocessed();
	}
	
	public List<TypedDependency> getDependecies(Tree parse) {
		GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
		return gs.typedDependenciesCCprocessed();
	}

	public List<TypedDependency> getDependecies(List<TaggedWord> sentence) {
		List<CoreLabel> rawWords = Sentence.toCoreLabelList(sentence);
		Tree parse = lp.apply(rawWords);
		GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
		return gs.typedDependenciesCCprocessed();
	}
	
}
