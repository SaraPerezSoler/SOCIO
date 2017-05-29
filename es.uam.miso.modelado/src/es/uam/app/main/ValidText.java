package es.uam.app.main;

public interface ValidText {

	
	
	public static String validText(String text, char [] validChars) {
		if (text==null){
			return null;
		}
		char[] textChar = text.toCharArray();
		String ret=text;
		for (char c : textChar) {
			if (!isValidChar(c, validChars)) {
				ret = ret.replace(c, ' ');
			}
		}
		
		return ret;
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
