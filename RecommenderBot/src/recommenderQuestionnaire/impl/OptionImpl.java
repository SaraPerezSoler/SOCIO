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

import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getAcceptedTools <em>Accepted Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getRefusedTools <em>Refused Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getUnknown <em>Unknown</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionImpl extends MinimalEObjectImpl.Container implements Option {
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
	 * The cached value of the '{@link #getAcceptedTools() <em>Accepted Tools</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptedTools()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> acceptedTools;

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
	protected OptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.OPTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RecommenderQuestionnairePackage.OPTION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getAcceptedTools() {
		if (acceptedTools == null) {
			acceptedTools = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS, RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS);
		}
		return acceptedTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Tool> getRefusedTools() {
		if (refusedTools == null) {
			refusedTools = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS, RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS);
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
			unknown = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__UNKNOWN, RecommenderQuestionnairePackage.TOOL__UNKNOWN);
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
			case RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAcceptedTools()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefusedTools()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
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
			case RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS:
				return ((InternalEList<?>)getAcceptedTools()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS:
				return ((InternalEList<?>)getRefusedTools()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				return getText();
			case RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS:
				return getAcceptedTools();
			case RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS:
				return getRefusedTools();
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				setText((String)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS:
				getAcceptedTools().clear();
				getAcceptedTools().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS:
				getRefusedTools().clear();
				getRefusedTools().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS:
				getAcceptedTools().clear();
				return;
			case RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS:
				getRefusedTools().clear();
				return;
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS:
				return acceptedTools != null && !acceptedTools.isEmpty();
			case RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS:
				return refusedTools != null && !refusedTools.isEmpty();
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
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

} //OptionImpl
