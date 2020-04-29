package recommenderQuestionnaire.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import answers.UserResponse;
import answers.QuestionAnswer.RelevanceLevel;
import generator.Bot;
import generator.GeneratorPackage;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Questionnaire;
import recommenderQuestionnaire.RecommenderQuestionnaireFactory;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.evaluations.Evaluator;
import org.xtext.botGenerator.generator.BotPlatformStandAlone;

public class RecommenderControl {

	private static RecommenderControl recommenderControl = null;
	private static ResourceSet resourceSet;
	private Questionnaire questionnaire = null;
	private Resource resource;

	private Map<Long, UserResponse> questionnaireAnswers = new HashMap<>();

	public static RecommenderControl getRecommenderControl(String recomenderModelPath, String jsonPath) {
		if (recommenderControl == null) {
			recommenderControl = new RecommenderControl(recomenderModelPath, jsonPath);
		}
		return recommenderControl;
	}

	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			// Especificamos la extension del fichero (para todos los ficheros),
			// y indicamos que
			// es un XMI.
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(RecommenderQuestionnairePackage.eNS_URI,
					RecommenderQuestionnairePackage.eINSTANCE);
			resourceSet.getPackageRegistry().put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
		}
		return resourceSet;
	}

	public static Bot getBot(String path) {
		return BotPlatformStandAlone.getBotPlatformStandAlone().getResourceBot(path);
	}

	private RecommenderControl(String recomenderModelPath, String jsonPath) {
		File f = new File(recomenderModelPath);
		if (f.exists()) {
			resource = getResourceSet().getResource(URI.createURI(recomenderModelPath), true);
			this.questionnaire = (Questionnaire) resource.getContents().get(0);
		} else {
			resource = getResourceSet().createResource(URI.createURI(recomenderModelPath));
			this.questionnaire = RecommenderQuestionnaireFactory.eINSTANCE.createQuestionnaire();
			resource.getContents().add(questionnaire);
			save();
		}

		try {
			Evaluator.loadEvaluators(questionnaire, jsonPath);
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Long newUser(Bot bot, Map<String, String> questionsLevels) {
		Set<Long> keySet = questionnaireAnswers.keySet();
		long max = -1;
		for (long key : keySet) {
			if (key > max) {
				max = key;
			}
		}
		max++;

		UserResponse response = new UserResponse(max, questionnaire.getTools());

		for (Evaluation ev : questionnaire.getEvaluations()) {
			List<Option> ans = ev.evaluate(bot);
			String levelString = questionsLevels.get(ev.getText());
			RelevanceLevel level = null;
			if (levelString != null) {
				level = RelevanceLevel.getRelevanceLevelByText(levelString);
			}
			if (level == null) {
				level = RelevanceLevel.RELEVANT;
			}
			response.addQuestionAnswer(ev, ans, level);
		}

		questionnaireAnswers.put(max, response);
		return max;
	}

	public Map<String, List<String>> getQuestions() {
		Map<String, List<String>> ret = new HashMap<>();
		for (Question question : questionnaire.getOnlyQuestions()) {
			List<String> options = new ArrayList<String>();
			for (Option answer : question.getOptions()) {
				options.add(answer.getText());
			}
			ret.put(question.getText(), options);
		}
		return ret;
	}

	public Map<String, Boolean> getEvaluations() {
		Map<String, Boolean> ret = new HashMap<>();
		for (Evaluation question : questionnaire.getEvaluations()) {
			ret.put(question.getText(), question.isMultiresponse());
		}
		return ret;
	}

	public boolean addAnswer(Long id, String questionText, List<String> answersText, RelevanceLevel level) {
		Question actualQuestion = null;
		for (Question question : questionnaire.getOnlyQuestions()) {
			if (question.getText().equalsIgnoreCase(questionText)) {
				actualQuestion = question;
				break;
			}
		}
		if (actualQuestion == null) {
			return false;
		}
		List<Option> actualAnswer = new ArrayList<Option>();
		for (String answerText : answersText) {
			for (Option ans : actualQuestion.getOptions()) {
				if (ans.getText().equalsIgnoreCase(answerText)) {
					actualAnswer.add(ans);
				}
				break;
			}
		}
		if (actualAnswer.isEmpty()) {
			return false;
		}
		UserResponse answers = questionnaireAnswers.get(id);
		if (answers == null) {
			return false;
		}
		answers.addQuestionAnswer(actualQuestion, actualAnswer, level);
		return true;
	}

	public boolean addAnswer(Long id, String questionText, String answerText, RelevanceLevel level) {
		Question actualQuestion = null;
		for (Question question : questionnaire.getOnlyQuestions()) {
			if (question.getText().equalsIgnoreCase(questionText)) {
				actualQuestion = question;
				break;
			}
		}
		if (actualQuestion == null) {
			return false;
		}
		List<Option> actualAnswer = new ArrayList<Option>();
		for (Option ans : actualQuestion.getOptions()) {
			if (ans.getText().equalsIgnoreCase(answerText)) {
				actualAnswer.add(ans);
			}
			break;
		}
		if (actualAnswer.isEmpty()) {
			return false;
		}
		UserResponse answers = questionnaireAnswers.get(id);
		if (answers == null) {
			return false;
		}
		answers.addQuestionAnswer(actualQuestion, actualAnswer, level);
		return true;
	}

	private void save() {
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isMulti(String questionText) {
		Question actualQuestion = getQuestion(questionText);
		if (actualQuestion == null) {
			return false;
		}
		return actualQuestion.isMultiresponse();
	}

	public String[] getRelevantLevel(String questionText) {
		return RelevanceLevel.getLevelsString(isMulti(questionText));
	}

	public String getQuestionName(String questionText) {
		Question actualQuestion = getQuestion(questionText);
		if (actualQuestion == null) {
			return "";
		}
		return actualQuestion.getName();
	}

	private Question getQuestion(String questionText) {
		Question actualQuestion = null;
		for (Question question : questionnaire.getQuestions()) {
			if (question.getText().equalsIgnoreCase(questionText)) {
				actualQuestion = question;
				break;
			}
		}
		if (actualQuestion == null) {
			return null;
		}
		return actualQuestion;
	}

	public void setRelevantLevel(long id, String questionText, String value) {
		Question q = getQuestion(questionText);
		if (q == null) {
			return;
		}
		UserResponse user = questionnaireAnswers.get(id);
		user.changeRelevance(q, value);

	}

}
