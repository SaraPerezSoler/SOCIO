package es.uam.app.words;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.uam.app.metamodel.parser.WordConfigure;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.IndexWordSet;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

/*
Example code from Wicked Cool Java (No Starch Press)
Copyright (C) 2005 Brian D. Eubanks

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

Note: The LGPL licence can be found online at http://www.gnu.org

*/
/**
 * This class looks up word senses in JWordnet, and finds holonyms.
 */
public class WordNet {

	private static WordNet wordNet = null;

	public static void ini(ServletContext context) throws Exception {
		wordNet = new WordNet(context);
	}

	public static WordNet getWordNet() throws FileNotFoundException, JWNLException {
		return wordNet;
	}

	private WordNet(ServletContext context) throws Exception {
		configureJWordNet(context);
	}

	public List<String> getSynonyms(String arg) throws JWNLException {

		List<String> ret = new ArrayList<String>();

		if (arg == null) {
			return ret;
		}
		Dictionary dictionary = Dictionary.getInstance();
		IndexWordSet words = dictionary.lookupAllIndexWords(arg);
		if (words.size() > 0) {
			IndexWord[] arrayWords = words.getIndexWordArray();
			for (IndexWord word : arrayWords) {
				Synset[] senses = word.getSenses();

				for (int i = 0; i < senses.length; i++) {
					Synset sense = senses[i];
					Word[] sinonimos = sense.getWords();
					for (Word w : sinonimos) {
						String word1 = "";
						String[] split = w.getLemma().split("_");
						for (String s : split) {
							word1 += WordConfigure.startUpperCase(s.toLowerCase());
						}
						if (!ret.contains(word1)) {
							ret.add(word1);
						}

					}

				}
			}
		}
		return ret;

	}

	public void configureJWordNet(ServletContext context) throws Exception {
		// WARNING: This still does not work in Java 5!!!
		String PATH = context.getInitParameter("wordNet.file");
		String dictPath = context.getInitParameter("wordNet.dict");
		changeDict(PATH, dictPath);
		JWNL.initialize(new FileInputStream(PATH));
	}

	private void changeDict(String path, String dictPath) throws Exception {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(path);
		NodeList params = doc.getElementsByTagName("param");
		for (int i = 0; i < params.getLength(); i++) {
			Node param = params.item(i);
			NamedNodeMap attrs = param.getAttributes();
			Node namedItem = attrs.getNamedItem("name");
			if (namedItem != null) {
				if ("dictionary_path".equals(namedItem.getNodeValue())) {
					attrs.getNamedItem("value").setTextContent(dictPath);
					break;
				}
			}
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(path));
		transformer.transform(source, result);

	}
}
