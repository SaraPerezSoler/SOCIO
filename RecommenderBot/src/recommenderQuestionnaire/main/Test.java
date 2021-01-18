package recommenderQuestionnaire.main;


public class Test {
	private static final String RECOMENDER_MODEL_PATH = "recomenderModel.xmi";
	public static String json = "language.json";

	                                                                                                                                                        
	public static void main(String[] args) {
		RecommenderControl.getRecommenderControl(RECOMENDER_MODEL_PATH, json);
	}

}
