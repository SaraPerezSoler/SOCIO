/**
 */
package modelInfo.impl;

import java.util.Collection;

import modelInfo.ModelInfoPackage;
import modelInfo.NLClass;
import modelInfo.NLModel;
import modelInfo.UpdateInterface;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NL Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.impl.NLModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link modelInfo.impl.NLModelImpl#getModel <em>Model</em>}</li>
 *   <li>{@link modelInfo.impl.NLModelImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link modelInfo.impl.NLModelImpl#getModelUpdate <em>Model Update</em>}</li>
 *   <li>{@link modelInfo.impl.NLModelImpl#isCreate <em>Create</em>}</li>
 *   <li>{@link modelInfo.impl.NLModelImpl#isContainer <em>Container</em>}</li>
 *   <li>{@link modelInfo.impl.NLModelImpl#isAsk <em>Ask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NLModelImpl extends MinimalEObjectImpl.Container implements NLModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EPackage model;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<NLClass> classes;

	/**
	 * The cached value of the '{@link #getModelUpdate() <em>Model Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUpdate()
	 * @generated
	 * @ordered
	 */
	protected UpdateInterface modelUpdate;

	/**
	 * The default value of the '{@link #isCreate() <em>Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCreate() <em>Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCreate()
	 * @generated
	 * @ordered
	 */
	protected boolean create = CREATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainer()
	 * @generated
	 * @ordered
	 */
	protected boolean container = CONTAINER_EDEFAULT;

	/**
	 * The default value of the '{@link #isAsk() <em>Ask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsk()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASK_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAsk() <em>Ask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsk()
	 * @generated
	 * @ordered
	 */
	protected boolean ask = ASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NLModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (EPackage)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelInfoPackage.NL_MODEL__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(EPackage newModel) {
		EPackage oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NLClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<NLClass>(NLClass.class, this, ModelInfoPackage.NL_MODEL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateInterface getModelUpdate() {
		return modelUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelUpdate(UpdateInterface newModelUpdate, NotificationChain msgs) {
		UpdateInterface oldModelUpdate = modelUpdate;
		modelUpdate = newModelUpdate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__MODEL_UPDATE, oldModelUpdate, newModelUpdate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelUpdate(UpdateInterface newModelUpdate) {
		if (newModelUpdate != modelUpdate) {
			NotificationChain msgs = null;
			if (modelUpdate != null)
				msgs = ((InternalEObject)modelUpdate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelInfoPackage.NL_MODEL__MODEL_UPDATE, null, msgs);
			if (newModelUpdate != null)
				msgs = ((InternalEObject)newModelUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelInfoPackage.NL_MODEL__MODEL_UPDATE, null, msgs);
			msgs = basicSetModelUpdate(newModelUpdate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__MODEL_UPDATE, newModelUpdate, newModelUpdate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreate() {
		return create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreate(boolean newCreate) {
		boolean oldCreate = create;
		create = newCreate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__CREATE, oldCreate, create));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(boolean newContainer) {
		boolean oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsk() {
		return ask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsk(boolean newAsk) {
		boolean oldAsk = ask;
		ask = newAsk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__ASK, oldAsk, ask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelInfoPackage.NL_MODEL__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
				return basicSetModelUpdate(null, msgs);
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
			case ModelInfoPackage.NL_MODEL__NAME:
				return getName();
			case ModelInfoPackage.NL_MODEL__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case ModelInfoPackage.NL_MODEL__CLASSES:
				return getClasses();
			case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
				return getModelUpdate();
			case ModelInfoPackage.NL_MODEL__CREATE:
				return isCreate();
			case ModelInfoPackage.NL_MODEL__CONTAINER:
				return isContainer();
			case ModelInfoPackage.NL_MODEL__ASK:
				return isAsk();
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
			case ModelInfoPackage.NL_MODEL__NAME:
				setName((String)newValue);
				return;
			case ModelInfoPackage.NL_MODEL__MODEL:
				setModel((EPackage)newValue);
				return;
			case ModelInfoPackage.NL_MODEL__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends NLClass>)newValue);
				return;
			case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
				setModelUpdate((UpdateInterface)newValue);
				return;
			case ModelInfoPackage.NL_MODEL__CREATE:
				setCreate((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_MODEL__CONTAINER:
				setContainer((Boolean)newValue);
				return;
			case ModelInfoPackage.NL_MODEL__ASK:
				setAsk((Boolean)newValue);
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
			case ModelInfoPackage.NL_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelInfoPackage.NL_MODEL__MODEL:
				setModel((EPackage)null);
				return;
			case ModelInfoPackage.NL_MODEL__CLASSES:
				getClasses().clear();
				return;
			case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
				setModelUpdate((UpdateInterface)null);
				return;
			case ModelInfoPackage.NL_MODEL__CREATE:
				setCreate(CREATE_EDEFAULT);
				return;
			case ModelInfoPackage.NL_MODEL__CONTAINER:
				setContainer(CONTAINER_EDEFAULT);
				return;
			case ModelInfoPackage.NL_MODEL__ASK:
				setAsk(ASK_EDEFAULT);
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
			case ModelInfoPackage.NL_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelInfoPackage.NL_MODEL__MODEL:
				return model != null;
			case ModelInfoPackage.NL_MODEL__CLASSES:
				return classes != null && !classes.isEmpty();
			case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
				return modelUpdate != null;
			case ModelInfoPackage.NL_MODEL__CREATE:
				return create != CREATE_EDEFAULT;
			case ModelInfoPackage.NL_MODEL__CONTAINER:
				return container != CONTAINER_EDEFAULT;
			case ModelInfoPackage.NL_MODEL__ASK:
				return ask != ASK_EDEFAULT;
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
		result.append(", create: ");
		result.append(create);
		result.append(", container: ");
		result.append(container);
		result.append(", ask: ");
		result.append(ask);
		result.append(')');
		return result.toString();
	}

	@Override
	public NLClass getRoot() {
		for (NLClass clas : getClasses()) {
			if (clas.isRoot()) {
				return clas;
			}
		}
		return null;
	}

	@Override
	public NLClass getClass(String className) {
		for (NLClass clas : getClasses()) {
			if (clas.getName().equalsIgnoreCase(className)) {
				return clas;
			}
		}
		return null;
	}

	@Override
	public NLClass getClass(EClass class_) {
		for (NLClass clas : getClasses()) {
			if (clas.getClass_().equals(class_)){
				return clas;
			}
		}
		return null;
	}

} //NLModelImpl
