/**
 */
package recommenderQuestionnaire.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import generator.Bot;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.evaluations.Evaluator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EvaluationImpl extends QuestionImpl implements Evaluation {
	private Evaluator evaluator;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.EVALUATION;
	}

	@Override
	public void setEvaluator(Evaluator ev) {
		this.evaluator = ev;
		
	}

	@Override
	public List<Option> evaluate(Bot bot) {
		List<String> answerStrings = this.evaluator.evaluate(bot);
		List<Option> answers = new ArrayList<Option>();
		for (String answerString: answerStrings) {
			for (Option answer : getOptions()) {
				if (answer.getText().equalsIgnoreCase(answerString)) {
					answers.add(answer);
					break;
				}
			}
		}
		return answers;
	}


} //EvaluationImpl
