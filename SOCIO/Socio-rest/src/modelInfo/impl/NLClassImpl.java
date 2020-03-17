/**
 */
package modelInfo.impl;

import java.util.Collection;

import modelInfo.ModelInfoPackage;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;
import modelInfo.NLReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>NL
 * Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.impl.NLClassImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#isRoot <em>Root</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#isInstantiable <em>Instantiable</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#getCreate <em>Create</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#getId <em>Id</em>}</li>
 *   <li>{@link modelInfo.impl.NLClassImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NLClassImpl extends NLElementImpl implements NLClass {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected EClass class_;

	/**
	 * The default value of the '{@link #isRoot() <em>Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isRoot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ROOT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRoot() <em>Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isRoot()
	 * @generated
	 * @ordered
	 */
	protected boolean root = ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #isInstantiable() <em>Instantiable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isInstantiable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANTIABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstantiable() <em>Instantiable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isInstantiable()
	 * @generated
	 * @ordered
	 */
	protected boolean instantiable = INSTANTIABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getContainer() <em>Container</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContainer()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Boolean CONTAINER_EDEFAULT = null; 

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected Boolean container = CONTAINER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreate() <em>Create</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreate()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Boolean CREATE_EDEFAULT = null; 

	/**
	 * The cached value of the '{@link #getCreate() <em>Create</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreate()
	 * @generated
	 * @ordered
	 */
	protected Boolean create = CREATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected EList<NLAttribute> id;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<NLFeature> features;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NLClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (EClass)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelInfoPackage.NL_CLASS__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(EClass newClass) {
		EClass oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(boolean newRoot) {
		boolean oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstantiable() {
		return instantiable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiable(boolean newInstantiable) {
		boolean oldInstantiable = instantiable;
		instantiable = newInstantiable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__INSTANTIABLE, oldInstantiable, instantiable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Boolean newContainer) {
		Boolean oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCreate() {
		return create;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreate(Boolean newCreate) {
		Boolean oldCreate = create;
		create = newCreate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__CREATE, oldCreate, create));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NLAttribute> getId() {
		if (id == null) {
			id = new EObjectContainmentEList<NLAttribute>(NLAttribute.class, this, ModelInfoPackage.NL_CLASS__ID);
		}
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NLFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<NLFeature>(NLFeature.class, this, ModelInfoPackage.NL_CLASS__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelInfoPackage.NL_CLASS__ID:
				return ((InternalEList<?>)getId()).basicRemove(otherEnd, msgs);
			case ModelInfoPackage.NL_CLASS__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelInfoPackage.NL_CLASS__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case ModelInfoPackage.NL_CLASS__ROOT:
				return isRoot();
			case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
				return isInstantiable();
			case ModelInfoPackage.NL_CLASS__ABSTRACT:
				return isAbstract();
			case ModelInfoPackage.NL_CLASS__CONTAINER:
				return getContainer();
			case ModelInfoPackage.NL_CLASS__CREATE:
				return getCreate();
			case ModelInfoPackage.NL_CLASS__ID:
				return getId();
			case ModelInfoPackage.NL_CLASS__FEATURES:
				return getFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelInfoPackage.NL_CLASS__CLASS:
				setClass((EClass)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__ROOT:
				setRoot((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
				setInstantiable((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__CONTAINER:
				setContainer((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__CREATE:
				setCreate((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__ID:
				getId().clear();
				getId().addAll((Collection<? extends NLAttribute>)newValue);
				return;
			case ModelInfoPackage.NL_CLASS__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends NLFeature>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelInfoPackage.NL_CLASS__CLASS:
				setClass((EClass)null);
				return;
			case ModelInfoPackage.NL_CLASS__ROOT:
				setRoot(ROOT_EDEFAULT);
				return;
			case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
				setInstantiable(INSTANTIABLE_EDEFAULT);
				return;
			case ModelInfoPackage.NL_CLASS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case ModelInfoPackage.NL_CLASS__CONTAINER:
				setContainer(CONTAINER_EDEFAULT);
				return;
			case ModelInfoPackage.NL_CLASS__CREATE:
				setCreate(CREATE_EDEFAULT);
				return;
			case ModelInfoPackage.NL_CLASS__ID:
				getId().clear();
				return;
			case ModelInfoPackage.NL_CLASS__FEATURES:
				getFeatures().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelInfoPackage.NL_CLASS__CLASS:
				return class_ != null;
			case ModelInfoPackage.NL_CLASS__ROOT:
				return root != ROOT_EDEFAULT;
			case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
				return instantiable != INSTANTIABLE_EDEFAULT;
			case ModelInfoPackage.NL_CLASS__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case ModelInfoPackage.NL_CLASS__CONTAINER:
				return CONTAINER_EDEFAULT == null ? container != null : !CONTAINER_EDEFAULT.equals(container);
			case ModelInfoPackage.NL_CLASS__CREATE:
				return CREATE_EDEFAULT == null ? create != null : !CREATE_EDEFAULT.equals(create);
			case ModelInfoPackage.NL_CLASS__ID:
				return id != null && !id.isEmpty();
			case ModelInfoPackage.NL_CLASS__FEATURES:
				return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (root: ");
		result.append(root);
		result.append(", instantiable: ");
		result.append(instantiable);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(", container: ");
		result.append(container);
		result.append(", create: ");
		result.append(create);
		result.append(')');
		return result.toString();
	}

	@Override
	public NLAttribute getNLAttribute(String attributeName) {
		for (NLAttribute ids : getId()) {
			if (ids.getAttribute().getName().equalsIgnoreCase(attributeName)) {
				return ids;
			}
		}

		for (NLFeature feature : getFeatures()) {
			if (feature instanceof NLAttribute) {
				if (((NLAttribute) feature).getAttribute().getName().equalsIgnoreCase(attributeName)) {
					return ((NLAttribute) feature);
				}
			}
		}
		return null;
	}

	@Override
	public NLReference getNLReference(String referenceName) {
		for (NLFeature feature : getFeatures()) {
			if (feature instanceof NLReference) {
				if (((NLReference) feature).getReference().getName().equalsIgnoreCase(referenceName)) {
					return ((NLReference) feature);
				}
			}
		}
		return null;
	}

	@Override
	public String getName() {
		return getClass_().getName();
	}

	@Override
	public NLFeature getNLFeature(EStructuralFeature feature) {
		for (NLFeature f : getFeatures()) {
			if (f.getFeature().equals(feature)) {
				return f;
			}
		}
		return null;

	}

	@Override
	public NLFeature getNLFeature(String featureName) {
		for (NLFeature f : getFeatures()) {
			if (f.getFeature().getName().equalsIgnoreCase(featureName)) {
				return f;
			}
		}
		return null;

	}

	@Override
	public NLAttribute getNLAttribute(EAttribute attribute) {
		for (NLAttribute ids : getId()) {
			if (ids.getAttribute().equals(attribute)) {
				return ids;
			}
		}
		for (NLFeature feature : getFeatures()) {
			if (feature instanceof NLAttribute) {
				if (((NLAttribute) feature).getAttribute().equals(attribute)) {
					return ((NLAttribute) feature);
				}
			}
		}
		return null;
	}

	@Override
	public NLReference getNLReference(EReference reference) {
		for (NLFeature feature : getFeatures()) {
			if (feature instanceof NLReference) {
				if (((NLReference) feature).getReference().equals(reference)) {
					return ((NLReference) feature);
				}
			}
		}
		return null;
	}

} // NLClassImpl
