/**
 */
package recommenderQuestionnaire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import recommenderQuestionnaire.Answer;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Question</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.QuestionImpl#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.QuestionImpl#isMultiresponse <em>Multiresponse</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.QuestionImpl#getAnswers <em>Answers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuestionImpl extends WithNameImpl implements Question {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isMultiresponse() <em>Multiresponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiresponse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIRESPONSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiresponse() <em>Multiresponse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiresponse()
	 * @generated
	 * @ordered
	 */
	protected boolean multiresponse = MULTIRESPONSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnswers() <em>Answers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected EList<Answer> answers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuestionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.QUESTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommenderQuestionnairePackage.QUESTION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMultiresponse() {
		return multiresponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMultiresponse(boolean newMultiresponse) {
		boolean oldMultiresponse = multiresponse;
		multiresponse = newMultiresponse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommenderQuestionnairePackage.QUESTION__MULTIRESPONSE, oldMultiresponse, multiresponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Answer> getAnswers() {
		if (answers == null) {
			answers = new EObjectContainmentEList<Answer>(Answer.class, this, RecommenderQuestionnairePackage.QUESTION__ANSWERS);
		}
		return answers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTION__ANSWERS:
				return ((InternalEList<?>)getAnswers()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.QUESTION__TEXT:
				return getText();
			case RecommenderQuestionnairePackage.QUESTION__MULTIRESPONSE:
				return isMultiresponse();
			case RecommenderQuestionnairePackage.QUESTION__ANSWERS:
				return getAnswers();
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
			case RecommenderQuestionnairePackage.QUESTION__TEXT:
				setText((String)newValue);
				return;
			case RecommenderQuestionnairePackage.QUESTION__MULTIRESPONSE:
				setMultiresponse((Boolean)newValue);
				return;
			case RecommenderQuestionnairePackage.QUESTION__ANSWERS:
				getAnswers().clear();
				getAnswers().addAll((Collection<? extends Answer>)newValue);
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
			case RecommenderQuestionnairePackage.QUESTION__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case RecommenderQuestionnairePackage.QUESTION__MULTIRESPONSE:
				setMultiresponse(MULTIRESPONSE_EDEFAULT);
				return;
			case RecommenderQuestionnairePackage.QUESTION__ANSWERS:
				getAnswers().clear();
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
			case RecommenderQuestionnairePackage.QUESTION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case RecommenderQuestionnairePackage.QUESTION__MULTIRESPONSE:
				return multiresponse != MULTIRESPONSE_EDEFAULT;
			case RecommenderQuestionnairePackage.QUESTION__ANSWERS:
				return answers != null && !answers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(", multiresponse: ");
		result.append(multiresponse);
		result.append(')');
		return result.toString();
	}

} //QuestionImpl
