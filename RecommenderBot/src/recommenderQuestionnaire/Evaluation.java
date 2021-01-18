/**
 */
package recommenderQuestionnaire;

import java.util.List;

import generator.Bot;
import recommenderQuestionnaire.evaluations.Evaluator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getEvaluation()
 * @model
 * @generated
 */
public interface Evaluation extends Question {
	void setEvaluator(Evaluator ev);

	List<Option> evaluate(Bot bot);

	

	


} // Evaluation
