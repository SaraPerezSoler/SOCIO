/**
 */
package recommenderQuestionnaire.impl;

import org.eclipse.emf.ecore.EClass;
import recommenderQuestionnaire.Evaluation;
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

} //EvaluationImpl
