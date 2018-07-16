package es.uam.app.words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WordTransformer {

	public static void getSynonyms(String word) {

		URL url;
			try {
				url = new URL("https://store.apicultur.com/api/sinonimosporpalabra/1.0.0/" + word.toLowerCase());
			
			URLConnection con = url.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String linea;
			do{
			 linea= in.readLine();
			 System.out.println(linea);
			} while (linea != null);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String removeLastS(String word) {
		char[] wordArray = word.toCharArray();
		if (wordArray.length < 2) {
			return word;
		}

		if (wordArray[wordArray.length - 1] == 's') {
			char [] ret;
			if (wordArray.length > 4) {
				if (wordArray[wordArray.length - 2] == 'e') {
					if (wordArray[wordArray.length - 3] == 's' || wordArray[wordArray.length - 3] == 'x'
							|| wordArray[wordArray.length - 3] == 'z' || wordArray[wordArray.length - 3] == 'o') {
						//devolver sin es
						ret= new char[wordArray.length - 2];
						for (int i=0; i<wordArray.length - 2; i++){
							ret[i]=wordArray[i];
						}
						return new String(ret);
					} else if (wordArray[wordArray.length - 3] == 'h'
							&& (wordArray[wordArray.length - 4] == 'c' || wordArray[wordArray.length - 4] == 's')) {
						//devolver sin es
						ret= new char[wordArray.length - 2];
						for (int i=0; i<wordArray.length - 2; i++){
							ret[i]=wordArray[i];
						}
						return new String(ret);
					}
				}
			}
			ret= new char[wordArray.length - 1];
			for (int i=0; i<wordArray.length - 1; i++){
				ret[i]=wordArray[i];
			}
			return new String(ret);
			//devolver sin s
		} 
		return word;

	}
}
