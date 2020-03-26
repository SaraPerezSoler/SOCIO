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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import recommenderQuestionnaire.Answer;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Answer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.AnswerImpl#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.AnswerImpl#getTools <em>Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.AnswerImpl#getNotKnowing <em>Not Knowing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnswerImpl extends MinimalEObjectImpl.Container implements Answer {
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
	 * The cached value of the '{@link #getTools() <em>Tools</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTools()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> tools;

	/**
	 * The cached value of the '{@link #getNotKnowing() <em>Not Knowing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotKnowing()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> notKnowing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnswerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.ANSWER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RecommenderQuestionnairePackage.ANSWER__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getTools() {
		if (tools == null) {
			tools = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.ANSWER__TOOLS, RecommenderQuestionnairePackage.TOOL__OPTIONS);
		}
		return tools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getNotKnowing() {
		if (notKnowing == null) {
			notKnowing = new EObjectResolvingEList<Tool>(Tool.class, this, RecommenderQuestionnairePackage.ANSWER__NOT_KNOWING);
		}
		return notKnowing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.ANSWER__TOOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTools()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.ANSWER__TOOLS:
				return ((InternalEList<?>)getTools()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.ANSWER__TEXT:
				return getText();
			case RecommenderQuestionnairePackage.ANSWER__TOOLS:
				return getTools();
			case RecommenderQuestionnairePackage.ANSWER__NOT_KNOWING:
				return getNotKnowing();
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
			case RecommenderQuestionnairePackage.ANSWER__TEXT:
				setText((String)newValue);
				return;
			case RecommenderQuestionnairePackage.ANSWER__TOOLS:
				getTools().clear();
				getTools().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.ANSWER__NOT_KNOWING:
				getNotKnowing().clear();
				getNotKnowing().addAll((Collection<? extends Tool>)newValue);
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
			case RecommenderQuestionnairePackage.ANSWER__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case RecommenderQuestionnairePackage.ANSWER__TOOLS:
				getTools().clear();
				return;
			case RecommenderQuestionnairePackage.ANSWER__NOT_KNOWING:
				getNotKnowing().clear();
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
			case RecommenderQuestionnairePackage.ANSWER__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case RecommenderQuestionnairePackage.ANSWER__TOOLS:
				return tools != null && !tools.isEmpty();
			case RecommenderQuestionnairePackage.ANSWER__NOT_KNOWING:
				return notKnowing != null && !notKnowing.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //AnswerImpl
