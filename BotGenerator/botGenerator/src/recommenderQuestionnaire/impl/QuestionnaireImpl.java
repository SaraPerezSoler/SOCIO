/**
 */
package recommenderQuestionnaire.impl;

import generator.Bot;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Questionnaire;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Questionnaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.QuestionnaireImpl#getBot <em>Bot</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.QuestionnaireImpl#getTools <em>Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.QuestionnaireImpl#getQuestions <em>Questions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuestionnaireImpl extends MinimalEObjectImpl.Container implements Questionnaire {
	/**
	 * The cached value of the '{@link #getBot() <em>Bot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBot()
	 * @generated
	 * @ordered
	 */
	protected Bot bot;

	/**
	 * The cached value of the '{@link #getTools() <em>Tools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTools()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> tools;

	/**
	 * The cached value of the '{@link #getQuestions() <em>Questions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuestions()
	 * @generated
	 * @ordered
	 */
	protected EList<Question> questions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuestionnaireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.QUESTIONNAIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bot getBot() {
		if (bot != null && bot.eIsProxy()) {
			InternalEObject oldBot = (InternalEObject)bot;
			bot = (Bot)eResolveProxy(oldBot);
			if (bot != oldBot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommenderQuestionnairePackage.QUESTIONNAIRE__BOT, oldBot, bot));
			}
		}
		return bot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bot basicGetBot() {
		return bot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBot(Bot newBot) {
		Bot oldBot = bot;
		bot = newBot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommenderQuestionnairePackage.QUESTIONNAIRE__BOT, oldBot, bot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getTools() {
		if (tools == null) {
			tools = new EObjectContainmentEList<Tool>(Tool.class, this, RecommenderQuestionnairePackage.QUESTIONNAIRE__TOOLS);
		}
		return tools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Question> getQuestions() {
		if (questions == null) {
			questions = new EObjectContainmentEList<Question>(Question.class, this, RecommenderQuestionnairePackage.QUESTIONNAIRE__QUESTIONS);
		}
		return questions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__TOOLS:
				return ((InternalEList<?>)getTools()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__QUESTIONS:
				return ((InternalEList<?>)getQuestions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__BOT:
				if (resolve) return getBot();
				return basicGetBot();
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__TOOLS:
				return getTools();
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__QUESTIONS:
				return getQuestions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__BOT:
				setBot((Bot)newValue);
				return;
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__TOOLS:
				getTools().clear();
				getTools().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__QUESTIONS:
				getQuestions().clear();
				getQuestions().addAll((Collection<? extends Question>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__BOT:
				setBot((Bot)null);
				return;
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__TOOLS:
				getTools().clear();
				return;
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__QUESTIONS:
				getQuestions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__BOT:
				return bot != null;
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__TOOLS:
				return tools != null && !tools.isEmpty();
			case RecommenderQuestionnairePackage.QUESTIONNAIRE__QUESTIONS:
				return questions != null && !questions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Evaluation getEvaluation(String name) {
		for (Question q: getQuestions()) {
			if (q instanceof Evaluation) {
				if (((Evaluation)q).getName().equals(name)) {
					return (Evaluation)q;
				}
			}
		}
	
		return null;
	}

} //QuestionnaireImpl
