/**
 */
package generator.impl;

import generator.GeneratorPackage;
import generator.Intent;
import generator.IntentLanguageInputs;
import generator.Parameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.IntentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link generator.impl.IntentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link generator.impl.IntentImpl#isFallbackIntent <em>Fallback Intent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntentImpl extends ElementImpl implements Intent {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentLanguageInputs> inputs;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The default value of the '{@link #isFallbackIntent() <em>Fallback Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFallbackIntent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FALLBACK_INTENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFallbackIntent() <em>Fallback Intent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFallbackIntent()
	 * @generated
	 * @ordered
	 */
	protected boolean fallbackIntent = FALLBACK_INTENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.INTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntentLanguageInputs> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<IntentLanguageInputs>(IntentLanguageInputs.class, this, GeneratorPackage.INTENT__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, GeneratorPackage.INTENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFallbackIntent() {
		return fallbackIntent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFallbackIntent(boolean newFallbackIntent) {
		boolean oldFallbackIntent = fallbackIntent;
		fallbackIntent = newFallbackIntent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.INTENT__FALLBACK_INTENT, oldFallbackIntent, fallbackIntent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.INTENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.INTENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case GeneratorPackage.INTENT__INPUTS:
				return getInputs();
			case GeneratorPackage.INTENT__PARAMETERS:
				return getParameters();
			case GeneratorPackage.INTENT__FALLBACK_INTENT:
				return isFallbackIntent();
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
			case GeneratorPackage.INTENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends IntentLanguageInputs>)newValue);
				return;
			case GeneratorPackage.INTENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case GeneratorPackage.INTENT__FALLBACK_INTENT:
				setFallbackIntent((Boolean)newValue);
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
			case GeneratorPackage.INTENT__INPUTS:
				getInputs().clear();
				return;
			case GeneratorPackage.INTENT__PARAMETERS:
				getParameters().clear();
				return;
			case GeneratorPackage.INTENT__FALLBACK_INTENT:
				setFallbackIntent(FALLBACK_INTENT_EDEFAULT);
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
			case GeneratorPackage.INTENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case GeneratorPackage.INTENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case GeneratorPackage.INTENT__FALLBACK_INTENT:
				return fallbackIntent != FALLBACK_INTENT_EDEFAULT;
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
		result.append(" (fallbackIntent: ");
		result.append(fallbackIntent);
		result.append(')');
		return result.toString();
	}

} //IntentImpl
