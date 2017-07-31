package es.uam.app.words;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import es.uam.app.parser.WordConfigure;
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

	public static WordNet getWordNet() throws FileNotFoundException, JWNLException {
		if (wordNet == null) {
			wordNet = new WordNet();
		}
		return wordNet;
	}

	private WordNet() throws FileNotFoundException, JWNLException {
		configureJWordNet();
	}

	public List<String> getSynonyms(String arg) throws JWNLException {

		List<String> ret = new ArrayList<String>();

		if (arg==null){
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

	public void configureJWordNet() throws FileNotFoundException, JWNLException {
		// WARNING: This still does not work in Java 5!!!
		JWNL.initialize(new FileInputStream("./file_properties.xml"));
	}
}
