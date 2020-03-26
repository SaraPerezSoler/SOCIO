package recommenderQuestionnaire.evaluations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import generator.Bot;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import recommenderQuestionnaire.Answer;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Questionnaire;
import recommenderQuestionnaire.impl.RecommenderQuestionnaireFactoryImpl;



public abstract class Evaluator {
	
	public static void loadEvaluators(Questionnaire questionnaire) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//Buscar todas las clases que van a evaluarse sobre el modelo
		List<Class<? extends Evaluator>> evaluators = new ArrayList<>();
		new FastClasspathScanner(Evaluator.class.getPackage().getName())
				.matchSubclassesOf(Evaluator.class, evaluators::add).scan();
		//Crear una instancia de cada clase
		for (Class<? extends Evaluator> evaluator : evaluators) {
			Constructor<? extends Evaluator> evaluatorConstructor = evaluator
					.getConstructor(new Class[] { });
			if (evaluatorConstructor != null) {
				Evaluator ev = evaluatorConstructor.newInstance();
				Evaluation qEvaluation =questionnaire.getEvaluation(evaluator.getName());
				if (qEvaluation == null) {
					qEvaluation = RecommenderQuestionnaireFactoryImpl.eINSTANCE.createEvaluation();
					qEvaluation.setName(evaluator.getName());
					qEvaluation.setMultiresponse(ev.getMultiresponse());
					qEvaluation.getAnswers().addAll(ev.getAnswers(questionnaire));
					qEvaluation.setText("");
					qEvaluation.setEvaluator(ev);
					questionnaire.getQuestions().add(qEvaluation);
				}else {
					qEvaluation.setEvaluator(ev);
				}
				
			}
		}
	}

	protected abstract List<Answer> getAnswers(Questionnaire questionnaire);

	protected abstract boolean getMultiresponse();

	public abstract List<Answer> evaluate(Bot bot);
}
