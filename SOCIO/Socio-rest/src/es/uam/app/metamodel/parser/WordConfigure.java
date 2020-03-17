package es.uam.app.metamodel.parser;


public interface WordConfigure {

	
	
	public static String startUpperCase(String cad) {
		if (cad == null) {
			return null;
		}
		char[] cadChar = cad.toCharArray();
		cadChar[0] = Character.toUpperCase(cadChar[0]);
		return new String(cadChar);
	}
	
	public static String startLowerCase(String cad) {
		if (cad == null) {
			return null;
		}
		char[] cadChar = cad.toCharArray();
		cadChar[0] = Character.toLowerCase(cadChar[0]);
		return new String(cadChar);
	}
}
