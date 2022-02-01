/**
 */
package modelInfo.impl;

import java.util.Collection;

import modelInfo.ModelInfoPackage;
import modelInfo.NLClass;
import modelInfo.NLReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NL Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.impl.NLReferenceImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link modelInfo.impl.NLReferenceImpl#getSrcSynonyms <em>Src Synonyms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NLReferenceImpl extends NLFeatureImpl implements NLReference {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * The cached value of the '{@link #getSrcSynonyms() <em>Src Synonyms</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcSynonyms()
	 * @generated
	 * @ordered
	 */
	protected EList<String> srcSynonyms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NLReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelInfoPackage.NL_REFERENCE__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_REFERENCE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSrcSynonyms() {
		if (srcSynonyms == null) {
			srcSynonyms = new EDataTypeUniqueEList<String>(String.class, this, ModelInfoPackage.NL_REFERENCE__SRC_SYNONYMS);
		}
		return srcSynonyms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelInfoPackage.NL_REFERENCE__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case ModelInfoPackage.NL_REFERENCE__SRC_SYNONYMS:
				return getSrcSynonyms();
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
			case ModelInfoPackage.NL_REFERENCE__REFERENCE:
				setReference((EReference)newValue);
				return;
			case ModelInfoPackage.NL_REFERENCE__SRC_SYNONYMS:
				getSrcSynonyms().clear();
				getSrcSynonyms().addAll((Collection<? extends String>)newValue);
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
			case ModelInfoPackage.NL_REFERENCE__REFERENCE:
				setReference((EReference)null);
				return;
			case ModelInfoPackage.NL_REFERENCE__SRC_SYNONYMS:
				getSrcSynonyms().clear();
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
			case ModelInfoPackage.NL_REFERENCE__REFERENCE:
				return reference != null;
			case ModelInfoPackage.NL_REFERENCE__SRC_SYNONYMS:
				return srcSynonyms != null && !srcSynonyms.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (srcSynonyms: ");
		result.append(srcSynonyms);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isType(EClass eClass) {
		if (getReference().getEReferenceType().equals(eClass)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isType(NLClass eClass) {
		return isType(eClass.getClass_());
	}

	@Override
	public String getName() {
		return getReference().getName();
	}

	@Override
	public EStructuralFeature getFeature() {
		return getReference();
	}

} //NLReferenceImpl
