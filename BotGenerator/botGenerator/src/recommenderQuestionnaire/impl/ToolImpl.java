/**
 */
package recommenderQuestionnaire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import recommenderQuestionnaire.Answer;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getAceptedOptions <em>Acepted Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getRefusedOptions <em>Refused Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ToolImpl extends WithNameImpl implements Tool {
	/**
	 * The cached value of the '{@link #getAceptedOptions() <em>Acepted Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAceptedOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Answer> aceptedOptions;
	/**
	 * The cached value of the '{@link #getUnknown() <em>Unknown</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknown()
	 * @generated
	 * @ordered
	 */
	protected EList<Answer> unknown;
	/**
	 * The cached value of the '{@link #getRefusedOptions() <em>Refused Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefusedOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Answer> refusedOptions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.TOOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Answer> getAceptedOptions() {
		if (aceptedOptions == null) {
			aceptedOptions = new EObjectWithInverseResolvingEList.ManyInverse<Answer>(Answer.class, this, RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS, RecommenderQuestionnairePackage.ANSWER__ACEPTED_TOOLS);
		}
		return aceptedOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Answer> getUnknown() {
		if (unknown == null) {
			unknown = new EObjectWithInverseResolvingEList.ManyInverse<Answer>(Answer.class, this, RecommenderQuestionnairePackage.TOOL__UNKNOWN, RecommenderQuestionnairePackage.ANSWER__UNKNOWN);
		}
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Answer> getRefusedOptions() {
		if (refusedOptions == null) {
			refusedOptions = new EObjectWithInverseResolvingEList.ManyInverse<Answer>(Answer.class, this, RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS, RecommenderQuestionnairePackage.ANSWER__REFUSED_TOOLS);
		}
		return refusedOptions;
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
			case RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAceptedOptions()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnknown()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefusedOptions()).basicAdd(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS:
				return ((InternalEList<?>)getAceptedOptions()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				return ((InternalEList<?>)getUnknown()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				return ((InternalEList<?>)getRefusedOptions()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS:
				return getAceptedOptions();
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				return getUnknown();
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				return getRefusedOptions();
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
			case RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS:
				getAceptedOptions().clear();
				getAceptedOptions().addAll((Collection<? extends Answer>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				getUnknown().clear();
				getUnknown().addAll((Collection<? extends Answer>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				getRefusedOptions().clear();
				getRefusedOptions().addAll((Collection<? extends Answer>)newValue);
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
			case RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS:
				getAceptedOptions().clear();
				return;
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				getUnknown().clear();
				return;
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				getRefusedOptions().clear();
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
			case RecommenderQuestionnairePackage.TOOL__ACEPTED_OPTIONS:
				return aceptedOptions != null && !aceptedOptions.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				return unknown != null && !unknown.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				return refusedOptions != null && !refusedOptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ToolImpl
