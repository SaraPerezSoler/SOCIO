/**
 */
package modelInfo.impl;

import java.util.Collection;

import modelInfo.ModelInfoPackage;
import modelInfo.NLElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NL Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.impl.NLElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link modelInfo.impl.NLElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link modelInfo.impl.NLElementImpl#getSynonyms <em>Synonyms</em>}</li>
 *   <li>{@link modelInfo.impl.NLElementImpl#getCreateTemplates <em>Create Templates</em>}</li>
 *   <li>{@link modelInfo.impl.NLElementImpl#getDeleteTemplates <em>Delete Templates</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NLElementImpl extends MinimalEObjectImpl.Container implements NLElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSynonyms() <em>Synonyms</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynonyms()
	 * @generated
	 * @ordered
	 */
	protected EList<String> synonyms;

	/**
	 * The cached value of the '{@link #getCreateTemplates() <em>Create Templates</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTemplates()
	 * @generated
	 * @ordered
	 */
	protected EList<String> createTemplates;

	/**
	 * The cached value of the '{@link #getDeleteTemplates() <em>Delete Templates</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeleteTemplates()
	 * @generated
	 * @ordered
	 */
	protected EList<String> deleteTemplates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NLElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_ELEMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSynonyms() {
		if (synonyms == null) {
			synonyms = new EDataTypeUniqueEList<String>(String.class, this, ModelInfoPackage.NL_ELEMENT__SYNONYMS);
		}
		return synonyms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCreateTemplates() {
		if (createTemplates == null) {
			createTemplates = new EDataTypeUniqueEList<String>(String.class, this, ModelInfoPackage.NL_ELEMENT__CREATE_TEMPLATES);
		}
		return createTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDeleteTemplates() {
		if (deleteTemplates == null) {
			deleteTemplates = new EDataTypeUniqueEList<String>(String.class, this, ModelInfoPackage.NL_ELEMENT__DELETE_TEMPLATES);
		}
		return deleteTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelInfoPackage.NL_ELEMENT__NAME:
				return getName();
			case ModelInfoPackage.NL_ELEMENT__DESCRIPTION:
				return getDescription();
			case ModelInfoPackage.NL_ELEMENT__SYNONYMS:
				return getSynonyms();
			case ModelInfoPackage.NL_ELEMENT__CREATE_TEMPLATES:
				return getCreateTemplates();
			case ModelInfoPackage.NL_ELEMENT__DELETE_TEMPLATES:
				return getDeleteTemplates();
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
			case ModelInfoPackage.NL_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case ModelInfoPackage.NL_ELEMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelInfoPackage.NL_ELEMENT__SYNONYMS:
				getSynonyms().clear();
				getSynonyms().addAll((Collection<? extends String>)newValue);
				return;
			case ModelInfoPackage.NL_ELEMENT__CREATE_TEMPLATES:
				getCreateTemplates().clear();
				getCreateTemplates().addAll((Collection<? extends String>)newValue);
				return;
			case ModelInfoPackage.NL_ELEMENT__DELETE_TEMPLATES:
				getDeleteTemplates().clear();
				getDeleteTemplates().addAll((Collection<? extends String>)newValue);
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
			case ModelInfoPackage.NL_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelInfoPackage.NL_ELEMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelInfoPackage.NL_ELEMENT__SYNONYMS:
				getSynonyms().clear();
				return;
			case ModelInfoPackage.NL_ELEMENT__CREATE_TEMPLATES:
				getCreateTemplates().clear();
				return;
			case ModelInfoPackage.NL_ELEMENT__DELETE_TEMPLATES:
				getDeleteTemplates().clear();
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
			case ModelInfoPackage.NL_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelInfoPackage.NL_ELEMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelInfoPackage.NL_ELEMENT__SYNONYMS:
				return synonyms != null && !synonyms.isEmpty();
			case ModelInfoPackage.NL_ELEMENT__CREATE_TEMPLATES:
				return createTemplates != null && !createTemplates.isEmpty();
			case ModelInfoPackage.NL_ELEMENT__DELETE_TEMPLATES:
				return deleteTemplates != null && !deleteTemplates.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", synonyms: ");
		result.append(synonyms);
		result.append(", createTemplates: ");
		result.append(createTemplates);
		result.append(", deleteTemplates: ");
		result.append(deleteTemplates);
		result.append(')');
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NLElementImpl other = (NLElementImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

} //NLElementImpl
