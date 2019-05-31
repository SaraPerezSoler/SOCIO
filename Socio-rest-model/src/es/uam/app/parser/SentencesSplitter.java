package es.uam.app.parser;

import java.io.Reader;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.Tree;

/**
 *
 * @author Sara Pérez Soler
 *
 */
public class SentencesSplitter {
	public static List<String> sentencesSplitter(String paragraph) throws ParseException {
		List<String> sentenceList = new ArrayList<String>();
		if (paragraph != null) {

			Reader reader = new StringReader(paragraph);
			DocumentPreprocessor dp = new DocumentPreprocessor(reader);

			for (List<HasWord> sentence : dp) {

				String sentenceString = SentenceUtils.listToString(sentence);
				ParserControl parser = ParserControl.getParser();
				Tree tree = parser.parser(sentenceString);
				sentenceList.addAll(findSub(tree, sentenceString));
			}
		}
		return sentenceList;
	}

	private static List<String> findSub(Tree tree, String sentence) {

		if (tree.isLeaf()) {
			List<String> ret = new ArrayList<>();
			ret.add(sentence);
			return ret;
		}
		if (tree.value().equalsIgnoreCase("NP")) {
			Tree NPprev = null;
			String remove = "";
			String sub = null;
			String NPprevString = null;
			String which = null;
			List<Tree> children = tree.getChildrenAsList();
			for (Tree child : children) {
				if (child.value().equalsIgnoreCase("NP")) {
					NPprev = child;
				} else {
					if (children.indexOf(child) + 1 == children.size()) {
						remove += treeToString(child);
					} else {
						remove += treeToString(child) + " ";
					}
				}
				if (child.value().equalsIgnoreCase("SBAR") && NPprev != null) {
					sub = treeToString(child);
					NPprevString = treeToString(NPprev);
					List<Tree> childrenChild = child.getChildrenAsList();
					for (Tree chch : childrenChild) {
						if (chch.value().equalsIgnoreCase("WHNP")) {
							which = treeToString(chch);
						}
					}

				}

			}
			if (which != null && sub != null && NPprevString != null) {
				sub = sub.replace(which, NPprevString);
				sentence = sentence.replace(remove, "");
				List<String> ret = new ArrayList<>();
				ret.add(sentence);
				ret.add(sub);
				return ret;
			}

		}
		List<String> ret = new ArrayList<>();
		ret.add(sentence);
		List<Tree> children = tree.getChildrenAsList();
		String sentAux = sentence;
		for (Tree child : children) {
			List<String> retAux = findSub(child, sentAux);
			sentAux = retAux.get(0);
			retAux.remove(0);
			ret.addAll(retAux);
			ret.set(0, sentAux);
		}

		return ret;

	}

	private static String treeToString(Tree t) {
		String ret = "";
		List<Tree> leaves = t.getLeaves();
		for (int i = 0; i < leaves.size(); i++) {
			Tree leaf = leaves.get(i);
			if (i + 1 == leaves.size()) {
				ret += leaf.value();
			} else {
				ret += leaf.value() + " ";
			}
		}
		return ret;
	}

}
