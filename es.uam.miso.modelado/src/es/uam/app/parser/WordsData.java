package es.uam.app.parser;

public abstract class WordsData {

	private static final String [] CONTAIN ={"contain","include"}; //is made up of
	private static final String [] TO_BE ={"be", "is"}; //"type of", "kind of"
	private static final String [] TO_HAVE ={"Have"};
	private static final String [] ADD ={"add","create", "new"}; //is made up of
	private static final String [] REMOVE ={"remove","delete", "del"}; //is made up of
	
	public static String [] getContain(){
		return CONTAIN;
		
	}

	public static String[] getToBe() {
		return TO_BE;
	}

	public static String[] getToHave() {
		return TO_HAVE;
	}
	
	public static String [] getAdd(){
		return ADD;
		
	}
	
	public static String [] getRemove(){
		return REMOVE;
		
	}
}
