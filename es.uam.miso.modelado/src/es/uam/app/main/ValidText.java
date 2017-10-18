package es.uam.app.main;

import java.util.ArrayList;
import java.util.List;

public interface ValidText {

	
	
public static String validText(String text, char [] validChars, int maxLenth) {
		if (text==null || maxLenth==0){
			return null;
		}
		char[] textChar = text.toCharArray();
		List<Character> ret=new ArrayList<Character>();
		int lenth=0;
		for (char c: textChar) {
			if (isValidChar(c, validChars)) {
				ret.add(c);
				lenth++;
			}
			if (lenth>=maxLenth){
				break;
			}
			
		}
		char[] retChar= new char[ret.size()];
		for (int i=0; i<ret.size(); i++){
			retChar[i]= ret.get(i);
		}
		
		
		return new String(retChar);
	}
	
	public static boolean isValidChar(char c, char [] validChars){
		if (Character.isLetter(c) || Character.isDigit(c)){
			return true;
		}else{
			for (char v: validChars){
				if (v==c){
					return true;
				}
			}
		}
		return false;
	}
	
}
