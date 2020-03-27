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
 *   <li>{@link recommenderQuestionnaire.impl.AnswerImpl#getAceptedTools <em>Acepted Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.AnswerImpl#getRefusedTools <em>Refused Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.AnswerImpl#getUnknown <em>Unknown</em>}</li>
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
	 * The cached value of the '{@link #getAceptedTools() <em>Acepted Tools</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAceptedTools()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> aceptedTools;

	/**
	 * The cached value of the '{@link #getRefusedTools() <em>Refused Tools</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefusedTools()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> refusedTools;

	/**
	 * The cached value of the '{@link #getUnknown() <em>Unknown</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknown()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> unknown;

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
	public EList<Tool> getAceptedTools() {
		if (aceptedTools == null) {
			aceptedTools = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS, RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS);
		}
		return aceptedTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getRefusedTools() {
		if (refusedTools == null) {
			refusedTools = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS, RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS);
		}
		return refusedTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getUnknown() {
		if (unknown == null) {
			unknown = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.ANSWER__UNKNOWN, RecommenderQuestionnairePackage.TOOL__UNKNOWN);
		}
		return unknown;
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
			case RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAceptedTools()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefusedTools()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.ANSWER__UNKNOWN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnknown()).basicAdd(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS:
				return ((InternalEList<?>)getAceptedTools()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS:
				return ((InternalEList<?>)getRefusedTools()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.ANSWER__UNKNOWN:
				return ((InternalEList<?>)getUnknown()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS:
				return getAceptedTools();
			case RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS:
				return getRefusedTools();
			case RecommenderQuestionnairePackage.ANSWER__UNKNOWN:
				return getUnknown();
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
			case RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS:
				getAceptedTools().clear();
				getAceptedTools().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS:
				getRefusedTools().clear();
				getRefusedTools().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.ANSWER__UNKNOWN:
				getUnknown().clear();
				getUnknown().addAll((Collection<? extends Tool>)newValue);
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
			case RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS:
				getAceptedTools().clear();
				return;
			case RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS:
				getRefusedTools().clear();
				return;
			case RecommenderQuestionnairePackage.ANSWER__UNKNOWN:
				getUnknown().clear();
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
			case RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS:
				return aceptedTools != null && !aceptedTools.isEmpty();
			case RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS:
				return refusedTools != null && !refusedTools.isEmpty();
			case RecommenderQuestionnairePackage.ANSWER__UNKNOWN:
				return unknown != null && !unknown.isEmpty();
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
