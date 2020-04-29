/**
 */
package recommenderQuestionnaire.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import recommenderQuestionnaire.Option;
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
 *   <li>{@link recommenderQuestionnaire.impl.QuestionImpl#getOptions <em>Options</em>}</li>
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
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> options;

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
	public EList<Option> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<Option>(Option.class, this, RecommenderQuestionnairePackage.QUESTION__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.QUESTION__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.QUESTION__OPTIONS:
				return getOptions();
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
			case RecommenderQuestionnairePackage.QUESTION__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends Option>)newValue);
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
			case RecommenderQuestionnairePackage.QUESTION__OPTIONS:
				getOptions().clear();
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
			case RecommenderQuestionnairePackage.QUESTION__OPTIONS:
				return options != null && !options.isEmpty();
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

	@Override
	public List<String> getOptionsString() {
		List<String> ret = new ArrayList<String>();
		for (Option opt: getOptions()) {
			ret.add(opt.getText());
		}
		return ret;
	}

} //QuestionImpl
