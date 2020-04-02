/**
 */
package generator.impl;

import generator.DefaultEntity;
import generator.Entity;
import generator.GeneratorPackage;
import generator.Parameter;
import generator.PromptLanguage;

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
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.ParameterImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link generator.impl.ParameterImpl#getDefaultEntity <em>Default Entity</em>}</li>
 *   <li>{@link generator.impl.ParameterImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link generator.impl.ParameterImpl#isIsList <em>Is List</em>}</li>
 *   <li>{@link generator.impl.ParameterImpl#getPrompts <em>Prompts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends ElementImpl implements Parameter {
	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected Entity entity;

	/**
	 * The default value of the '{@link #getDefaultEntity() <em>Default Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultEntity()
	 * @generated
	 * @ordered
	 */
	protected static final DefaultEntity DEFAULT_ENTITY_EDEFAULT = DefaultEntity.TEXT;

	/**
	 * The cached value of the '{@link #getDefaultEntity() <em>Default Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultEntity()
	 * @generated
	 * @ordered
	 */
	protected DefaultEntity defaultEntity = DEFAULT_ENTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsList() <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsList() <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsList()
	 * @generated
	 * @ordered
	 */
	protected boolean isList = IS_LIST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrompts() <em>Prompts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrompts()
	 * @generated
	 * @ordered
	 */
	protected EList<PromptLanguage> prompts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entity getEntity() {
		if (entity != null && entity.eIsProxy()) {
			InternalEObject oldEntity = (InternalEObject)entity;
			entity = (Entity)eResolveProxy(oldEntity);
			if (entity != oldEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.PARAMETER__ENTITY, oldEntity, entity));
			}
		}
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetEntity() {
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntity(Entity newEntity) {
		Entity oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.PARAMETER__ENTITY, oldEntity, entity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefaultEntity getDefaultEntity() {
		return defaultEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultEntity(DefaultEntity newDefaultEntity) {
		DefaultEntity oldDefaultEntity = defaultEntity;
		defaultEntity = newDefaultEntity == null ? DEFAULT_ENTITY_EDEFAULT : newDefaultEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.PARAMETER__DEFAULT_ENTITY, oldDefaultEntity, defaultEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.PARAMETER__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsList() {
		return isList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsList(boolean newIsList) {
		boolean oldIsList = isList;
		isList = newIsList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.PARAMETER__IS_LIST, oldIsList, isList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PromptLanguage> getPrompts() {
		if (prompts == null) {
			prompts = new EObjectContainmentEList<PromptLanguage>(PromptLanguage.class, this, GeneratorPackage.PARAMETER__PROMPTS);
		}
		return prompts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.PARAMETER__PROMPTS:
				return ((InternalEList<?>)getPrompts()).basicRemove(otherEnd, msgs);
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
			case GeneratorPackage.PARAMETER__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
			case GeneratorPackage.PARAMETER__DEFAULT_ENTITY:
				return getDefaultEntity();
			case GeneratorPackage.PARAMETER__REQUIRED:
				return isRequired();
			case GeneratorPackage.PARAMETER__IS_LIST:
				return isIsList();
			case GeneratorPackage.PARAMETER__PROMPTS:
				return getPrompts();
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
			case GeneratorPackage.PARAMETER__ENTITY:
				setEntity((Entity)newValue);
				return;
			case GeneratorPackage.PARAMETER__DEFAULT_ENTITY:
				setDefaultEntity((DefaultEntity)newValue);
				return;
			case GeneratorPackage.PARAMETER__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case GeneratorPackage.PARAMETER__IS_LIST:
				setIsList((Boolean)newValue);
				return;
			case GeneratorPackage.PARAMETER__PROMPTS:
				getPrompts().clear();
				getPrompts().addAll((Collection<? extends PromptLanguage>)newValue);
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
			case GeneratorPackage.PARAMETER__ENTITY:
				setEntity((Entity)null);
				return;
			case GeneratorPackage.PARAMETER__DEFAULT_ENTITY:
				setDefaultEntity(DEFAULT_ENTITY_EDEFAULT);
				return;
			case GeneratorPackage.PARAMETER__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case GeneratorPackage.PARAMETER__IS_LIST:
				setIsList(IS_LIST_EDEFAULT);
				return;
			case GeneratorPackage.PARAMETER__PROMPTS:
				getPrompts().clear();
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
			case GeneratorPackage.PARAMETER__ENTITY:
				return entity != null;
			case GeneratorPackage.PARAMETER__DEFAULT_ENTITY:
				return defaultEntity != DEFAULT_ENTITY_EDEFAULT;
			case GeneratorPackage.PARAMETER__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case GeneratorPackage.PARAMETER__IS_LIST:
				return isList != IS_LIST_EDEFAULT;
			case GeneratorPackage.PARAMETER__PROMPTS:
				return prompts != null && !prompts.isEmpty();
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
		result.append(" (defaultEntity: ");
		result.append(defaultEntity);
		result.append(", required: ");
		result.append(required);
		result.append(", isList: ");
		result.append(isList);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
