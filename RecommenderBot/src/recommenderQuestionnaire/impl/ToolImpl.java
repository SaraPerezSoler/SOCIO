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
import recommenderQuestionnaire.Option;
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
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getAcceptedOptions <em>Accepted Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getRefusedOptions <em>Refused Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ToolImpl extends WithNameImpl implements Tool {
	/**
	 * The cached value of the '{@link #getAcceptedOptions() <em>Accepted Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptedOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> acceptedOptions;
	/**
	 * The cached value of the '{@link #getUnknown() <em>Unknown</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknown()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> unknown;
	/**
	 * The cached value of the '{@link #getRefusedOptions() <em>Refused Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefusedOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> refusedOptions;
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
	public EList<Option> getAcceptedOptions() {
		if (acceptedOptions == null) {
			acceptedOptions = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS, RecommenderQuestionnairePackage.OPTION__ACCEPTED_TOOLS);
		}
		return acceptedOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Option> getUnknown() {
		if (unknown == null) {
			unknown = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__UNKNOWN, RecommenderQuestionnairePackage.OPTION__UNKNOWN);
		}
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Option> getRefusedOptions() {
		if (refusedOptions == null) {
			refusedOptions = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS, RecommenderQuestionnairePackage.OPTION__REFUSED_TOOLS);
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
			case RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAcceptedOptions()).basicAdd(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS:
				return ((InternalEList<?>)getAcceptedOptions()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS:
				return getAcceptedOptions();
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
			case RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS:
				getAcceptedOptions().clear();
				getAcceptedOptions().addAll((Collection<? extends Option>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				getUnknown().clear();
				getUnknown().addAll((Collection<? extends Option>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				getRefusedOptions().clear();
				getRefusedOptions().addAll((Collection<? extends Option>)newValue);
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
			case RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS:
				getAcceptedOptions().clear();
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
			case RecommenderQuestionnairePackage.TOOL__ACCEPTED_OPTIONS:
				return acceptedOptions != null && !acceptedOptions.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN:
				return unknown != null && !unknown.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__REFUSED_OPTIONS:
				return refusedOptions != null && !refusedOptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ToolImpl
