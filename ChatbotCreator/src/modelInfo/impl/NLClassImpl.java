/**
 */
package modelInfo.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import modelInfo.ModelInfoPackage;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;

import modelInfo.NLIdentifier;
import modelInfo.NLModel;
import modelInfo.NLReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
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
 * <li>{@link modelInfo.impl.NLClassImpl#getClass_ <em>Class</em>}</li>
 * <li>{@link modelInfo.impl.NLClassImpl#isWithContainer <em>With
 * Container</em>}</li>
 * <li>{@link modelInfo.impl.NLClassImpl#isInstantiable
 * <em>Instantiable</em>}</li>
 * <li>{@link modelInfo.impl.NLClassImpl#getCreate <em>Create</em>}</li>
 * <li>{@link modelInfo.impl.NLClassImpl#getId <em>Id</em>}</li>
 * <li>{@link modelInfo.impl.NLClassImpl#getFeatures <em>Features</em>}</li>
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
	 * The default value of the '{@link #isWithContainer() <em>With Container</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isWithContainer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_CONTAINER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithContainer() <em>With Container</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isWithContainer()
	 * @generated
	 * @ordered
	 */
	protected boolean withContainer = WITH_CONTAINER_EDEFAULT;

	/**
	 * The default value of the '{@link #isInstantiable() <em>Instantiable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isInstantiable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANTIABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstantiable() <em>Instantiable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isInstantiable()
	 * @generated
	 * @ordered
	 */
	protected boolean instantiable = INSTANTIABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreate() <em>Create</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreate()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean CREATE_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getCreate() <em>Create</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreate()
	 * @generated
	 * @ordered
	 */
	protected Boolean create = CREATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected EList<NLIdentifier> id;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<NLFeature> features;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NLClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject) class_;
			class_ = (EClass) eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelInfoPackage.NL_CLASS__CLASS,
							oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	public boolean isWithContainer() {
		return withContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWithContainer(boolean newWithContainer) {
		boolean oldWithContainer = withContainer;
		withContainer = newWithContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__WITH_CONTAINER,
					oldWithContainer, withContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isInstantiable() {
		return instantiable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInstantiable(boolean newInstantiable) {
		boolean oldInstantiable = instantiable;
		instantiable = newInstantiable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__INSTANTIABLE,
					oldInstantiable, instantiable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Boolean getCreate() {
		return create;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreate(Boolean newCreate) {
		Boolean oldCreate = create;
		create = newCreate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_CLASS__CREATE, oldCreate,
					create));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NLIdentifier> getId() {
		if (id == null) {
			id = new EObjectContainmentEList<NLIdentifier>(NLIdentifier.class, this, ModelInfoPackage.NL_CLASS__ID);
		}
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NLFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<NLFeature>(NLFeature.class, this,
					ModelInfoPackage.NL_CLASS__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelInfoPackage.NL_CLASS__ID:
			return ((InternalEList<?>) getId()).basicRemove(otherEnd, msgs);
		case ModelInfoPackage.NL_CLASS__FEATURES:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelInfoPackage.NL_CLASS__CLASS:
			if (resolve)
				return getClass_();
			return basicGetClass();
		case ModelInfoPackage.NL_CLASS__WITH_CONTAINER:
			return isWithContainer();
		case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
			return isInstantiable();
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
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelInfoPackage.NL_CLASS__CLASS:
			setClass((EClass) newValue);
			return;
		case ModelInfoPackage.NL_CLASS__WITH_CONTAINER:
			setWithContainer((Boolean) newValue);
			return;
		case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
			setInstantiable((Boolean) newValue);
			return;
		case ModelInfoPackage.NL_CLASS__CREATE:
			setCreate((Boolean) newValue);
			return;
		case ModelInfoPackage.NL_CLASS__ID:
			getId().clear();
			getId().addAll((Collection<? extends NLIdentifier>) newValue);
			return;
		case ModelInfoPackage.NL_CLASS__FEATURES:
			getFeatures().clear();
			getFeatures().addAll((Collection<? extends NLFeature>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelInfoPackage.NL_CLASS__CLASS:
			setClass((EClass) null);
			return;
		case ModelInfoPackage.NL_CLASS__WITH_CONTAINER:
			setWithContainer(WITH_CONTAINER_EDEFAULT);
			return;
		case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
			setInstantiable(INSTANTIABLE_EDEFAULT);
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
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelInfoPackage.NL_CLASS__CLASS:
			return class_ != null;
		case ModelInfoPackage.NL_CLASS__WITH_CONTAINER:
			return withContainer != WITH_CONTAINER_EDEFAULT;
		case ModelInfoPackage.NL_CLASS__INSTANTIABLE:
			return instantiable != INSTANTIABLE_EDEFAULT;
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
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (withContainer: ");
		result.append(withContainer);
		result.append(", instantiable: ");
		result.append(instantiable);
		result.append(", create: ");
		result.append(create);
		result.append(')');
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_ == null) ? 0 : class_.hashCode());
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
		NLClassImpl other = (NLClassImpl) obj;
		if (class_ == null) {
			if (other.class_ != null)
				return false;
		} else if (!class_.equals(other.class_))
			return false;
		return true;
	}

	@Override
	public List<NLClass> getSuper() {
		NLModel model = (NLModel) this.eContainer;
		List<NLClass> superNLClasses = new ArrayList<NLClass>();
		for (NLClass modelNLClasses : model.getClasses()) {
			if (getClass_().getEAllSuperTypes().contains(modelNLClasses.getClass_())) {
				superNLClasses.add(modelNLClasses);
			}
		}
		return superNLClasses;
	}

	@Override
	public List<NLAttribute> getAllAttribtues() {
		List<NLAttribute> list = new ArrayList<>();
		for (NLIdentifier id: getId()) {
			if (id instanceof NLAttribute) {
				list.add((NLAttribute)id);
			}
		}
		
		for (NLFeature feature: getFeatures()) {
			if (feature instanceof NLAttribute) {
				list.add((NLAttribute)feature);
			}
		}
		return list;
	}
	
	public List<NLReference> getAllReferences() {
		List<NLReference> list = new ArrayList<>();
		for (NLFeature feature: getFeatures()) {
			if (feature instanceof NLReference) {
				list.add((NLReference)feature);
			}
		}
		return list;
	}
	
	@Override
	public List<NLFeature> getAllFeatures() {
		List<NLFeature> list = new ArrayList<>();
		for (NLIdentifier id: getId()) {
			if (id instanceof NLFeature) {
				list.add((NLAttribute)id);
			}
		}
		list.addAll(getFeatures());
			
		return list;
	}

	@Override
	public String getAttributesList() {
		String text = "[";
		for (int i=0; i < getAllAttribtues().size(); i++) {
			text+= getAllAttribtues().get(i).getName();
			if (i != getAllAttribtues().size()-1) {
				text += ", ";
			}
		}
		return text + "]";
	}

} // NLClassImpl
