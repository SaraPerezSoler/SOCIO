/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see recommenderQuestionnaire.RecommenderQuestionnaireFactory
 * @model kind="package"
 * @generated
 */
public interface RecommenderQuestionnairePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "recommenderQuestionnaire";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "recommenderQuestionnaire";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "recommenderQuestionnaire";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RecommenderQuestionnairePackage eINSTANCE = recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl.init();

	/**
	 * The meta object id for the '{@link recommenderQuestionnaire.impl.QuestionnaireImpl <em>Questionnaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see recommenderQuestionnaire.impl.QuestionnaireImpl
	 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getQuestionnaire()
	 * @generated
	 */
	int QUESTIONNAIRE = 0;

	/**
	 * The feature id for the '<em><b>Bot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE__BOT = 0;

	/**
	 * The feature id for the '<em><b>Tools</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE__TOOLS = 1;

	/**
	 * The feature id for the '<em><b>Questions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE__QUESTIONS = 2;

	/**
	 * The number of structural features of the '<em>Questionnaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Questionnaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link recommenderQuestionnaire.impl.WithNameImpl <em>With Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see recommenderQuestionnaire.impl.WithNameImpl
	 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getWithName()
	 * @generated
	 */
	int WITH_NAME = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_NAME__NAME = 0;

	/**
	 * The number of structural features of the '<em>With Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_NAME_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>With Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_NAME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link recommenderQuestionnaire.impl.ToolImpl <em>Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see recommenderQuestionnaire.impl.ToolImpl
	 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getTool()
	 * @generated
	 */
	int TOOL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__NAME = WITH_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL__OPTIONS = WITH_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_FEATURE_COUNT = WITH_NAME_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_OPERATION_COUNT = WITH_NAME_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link recommenderQuestionnaire.impl.QuestionImpl <em>Question</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see recommenderQuestionnaire.impl.QuestionImpl
	 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getQuestion()
	 * @generated
	 */
	int QUESTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__NAME = WITH_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__TEXT = WITH_NAME_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiresponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__MULTIRESPONSE = WITH_NAME_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Answers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__ANSWERS = WITH_NAME_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Question</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION_FEATURE_COUNT = WITH_NAME_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Question</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION_OPERATION_COUNT = WITH_NAME_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link recommenderQuestionnaire.impl.EvaluationImpl <em>Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see recommenderQuestionnaire.impl.EvaluationImpl
	 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getEvaluation()
	 * @generated
	 */
	int EVALUATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__NAME = QUESTION__NAME;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__TEXT = QUESTION__TEXT;

	/**
	 * The feature id for the '<em><b>Multiresponse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__MULTIRESPONSE = QUESTION__MULTIRESPONSE;

	/**
	 * The feature id for the '<em><b>Answers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION__ANSWERS = QUESTION__ANSWERS;

	/**
	 * The number of structural features of the '<em>Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_COUNT = QUESTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_OPERATION_COUNT = QUESTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link recommenderQuestionnaire.impl.AnswerImpl <em>Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see recommenderQuestionnaire.impl.AnswerImpl
	 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getAnswer()
	 * @generated
	 */
	int ANSWER = 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Tools</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__TOOLS = 1;

	/**
	 * The feature id for the '<em><b>Not Knowing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__NOT_KNOWING = 2;

	/**
	 * The number of structural features of the '<em>Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link recommenderQuestionnaire.Questionnaire <em>Questionnaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Questionnaire</em>'.
	 * @see recommenderQuestionnaire.Questionnaire
	 * @generated
	 */
	EClass getQuestionnaire();

	/**
	 * Returns the meta object for the reference '{@link recommenderQuestionnaire.Questionnaire#getBot <em>Bot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bot</em>'.
	 * @see recommenderQuestionnaire.Questionnaire#getBot()
	 * @see #getQuestionnaire()
	 * @generated
	 */
	EReference getQuestionnaire_Bot();

	/**
	 * Returns the meta object for the containment reference list '{@link recommenderQuestionnaire.Questionnaire#getTools <em>Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tools</em>'.
	 * @see recommenderQuestionnaire.Questionnaire#getTools()
	 * @see #getQuestionnaire()
	 * @generated
	 */
	EReference getQuestionnaire_Tools();

	/**
	 * Returns the meta object for the containment reference list '{@link recommenderQuestionnaire.Questionnaire#getQuestions <em>Questions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Questions</em>'.
	 * @see recommenderQuestionnaire.Questionnaire#getQuestions()
	 * @see #getQuestionnaire()
	 * @generated
	 */
	EReference getQuestionnaire_Questions();

	/**
	 * Returns the meta object for class '{@link recommenderQuestionnaire.Tool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool</em>'.
	 * @see recommenderQuestionnaire.Tool
	 * @generated
	 */
	EClass getTool();

	/**
	 * Returns the meta object for the reference list '{@link recommenderQuestionnaire.Tool#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Options</em>'.
	 * @see recommenderQuestionnaire.Tool#getOptions()
	 * @see #getTool()
	 * @generated
	 */
	EReference getTool_Options();

	/**
	 * Returns the meta object for class '{@link recommenderQuestionnaire.Question <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Question</em>'.
	 * @see recommenderQuestionnaire.Question
	 * @generated
	 */
	EClass getQuestion();

	/**
	 * Returns the meta object for the attribute '{@link recommenderQuestionnaire.Question#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see recommenderQuestionnaire.Question#getText()
	 * @see #getQuestion()
	 * @generated
	 */
	EAttribute getQuestion_Text();

	/**
	 * Returns the meta object for the attribute '{@link recommenderQuestionnaire.Question#isMultiresponse <em>Multiresponse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiresponse</em>'.
	 * @see recommenderQuestionnaire.Question#isMultiresponse()
	 * @see #getQuestion()
	 * @generated
	 */
	EAttribute getQuestion_Multiresponse();

	/**
	 * Returns the meta object for the containment reference list '{@link recommenderQuestionnaire.Question#getAnswers <em>Answers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Answers</em>'.
	 * @see recommenderQuestionnaire.Question#getAnswers()
	 * @see #getQuestion()
	 * @generated
	 */
	EReference getQuestion_Answers();

	/**
	 * Returns the meta object for class '{@link recommenderQuestionnaire.Evaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation</em>'.
	 * @see recommenderQuestionnaire.Evaluation
	 * @generated
	 */
	EClass getEvaluation();

	/**
	 * Returns the meta object for class '{@link recommenderQuestionnaire.Answer <em>Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Answer</em>'.
	 * @see recommenderQuestionnaire.Answer
	 * @generated
	 */
	EClass getAnswer();

	/**
	 * Returns the meta object for the attribute '{@link recommenderQuestionnaire.Answer#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see recommenderQuestionnaire.Answer#getText()
	 * @see #getAnswer()
	 * @generated
	 */
	EAttribute getAnswer_Text();

	/**
	 * Returns the meta object for the reference list '{@link recommenderQuestionnaire.Answer#getTools <em>Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tools</em>'.
	 * @see recommenderQuestionnaire.Answer#getTools()
	 * @see #getAnswer()
	 * @generated
	 */
	EReference getAnswer_Tools();

	/**
	 * Returns the meta object for the reference list '{@link recommenderQuestionnaire.Answer#getNotKnowing <em>Not Knowing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Not Knowing</em>'.
	 * @see recommenderQuestionnaire.Answer#getNotKnowing()
	 * @see #getAnswer()
	 * @generated
	 */
	EReference getAnswer_NotKnowing();

	/**
	 * Returns the meta object for class '{@link recommenderQuestionnaire.WithName <em>With Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Name</em>'.
	 * @see recommenderQuestionnaire.WithName
	 * @generated
	 */
	EClass getWithName();

	/**
	 * Returns the meta object for the attribute '{@link recommenderQuestionnaire.WithName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see recommenderQuestionnaire.WithName#getName()
	 * @see #getWithName()
	 * @generated
	 */
	EAttribute getWithName_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RecommenderQuestionnaireFactory getRecommenderQuestionnaireFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link recommenderQuestionnaire.impl.QuestionnaireImpl <em>Questionnaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see recommenderQuestionnaire.impl.QuestionnaireImpl
		 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getQuestionnaire()
		 * @generated
		 */
		EClass QUESTIONNAIRE = eINSTANCE.getQuestionnaire();

		/**
		 * The meta object literal for the '<em><b>Bot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTIONNAIRE__BOT = eINSTANCE.getQuestionnaire_Bot();

		/**
		 * The meta object literal for the '<em><b>Tools</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTIONNAIRE__TOOLS = eINSTANCE.getQuestionnaire_Tools();

		/**
		 * The meta object literal for the '<em><b>Questions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTIONNAIRE__QUESTIONS = eINSTANCE.getQuestionnaire_Questions();

		/**
		 * The meta object literal for the '{@link recommenderQuestionnaire.impl.ToolImpl <em>Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see recommenderQuestionnaire.impl.ToolImpl
		 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getTool()
		 * @generated
		 */
		EClass TOOL = eINSTANCE.getTool();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL__OPTIONS = eINSTANCE.getTool_Options();

		/**
		 * The meta object literal for the '{@link recommenderQuestionnaire.impl.QuestionImpl <em>Question</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see recommenderQuestionnaire.impl.QuestionImpl
		 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getQuestion()
		 * @generated
		 */
		EClass QUESTION = eINSTANCE.getQuestion();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUESTION__TEXT = eINSTANCE.getQuestion_Text();

		/**
		 * The meta object literal for the '<em><b>Multiresponse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUESTION__MULTIRESPONSE = eINSTANCE.getQuestion_Multiresponse();

		/**
		 * The meta object literal for the '<em><b>Answers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTION__ANSWERS = eINSTANCE.getQuestion_Answers();

		/**
		 * The meta object literal for the '{@link recommenderQuestionnaire.impl.EvaluationImpl <em>Evaluation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see recommenderQuestionnaire.impl.EvaluationImpl
		 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getEvaluation()
		 * @generated
		 */
		EClass EVALUATION = eINSTANCE.getEvaluation();

		/**
		 * The meta object literal for the '{@link recommenderQuestionnaire.impl.AnswerImpl <em>Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see recommenderQuestionnaire.impl.AnswerImpl
		 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getAnswer()
		 * @generated
		 */
		EClass ANSWER = eINSTANCE.getAnswer();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANSWER__TEXT = eINSTANCE.getAnswer_Text();

		/**
		 * The meta object literal for the '<em><b>Tools</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANSWER__TOOLS = eINSTANCE.getAnswer_Tools();

		/**
		 * The meta object literal for the '<em><b>Not Knowing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANSWER__NOT_KNOWING = eINSTANCE.getAnswer_NotKnowing();

		/**
		 * The meta object literal for the '{@link recommenderQuestionnaire.impl.WithNameImpl <em>With Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see recommenderQuestionnaire.impl.WithNameImpl
		 * @see recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl#getWithName()
		 * @generated
		 */
		EClass WITH_NAME = eINSTANCE.getWithName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH_NAME__NAME = eINSTANCE.getWithName_Name();

	}

} //RecommenderQuestionnairePackage
