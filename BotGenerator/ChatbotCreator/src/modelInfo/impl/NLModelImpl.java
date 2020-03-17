/**
 */
package modelInfo.impl;

import java.util.Collection;

import modelInfo.ModelInfoPackage;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLModel;
import modelInfo.NLReference;
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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>NL
 * Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link modelInfo.impl.NLModelImpl#getName <em>Name</em>}</li>
 * <li>{@link modelInfo.impl.NLModelImpl#getModel <em>Model</em>}</li>
 * <li>{@link modelInfo.impl.NLModelImpl#getClasses <em>Classes</em>}</li>
 * <li>{@link modelInfo.impl.NLModelImpl#getModelUpdate <em>Model
 * Update</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NLModelImpl extends MinimalEObjectImpl.Container implements NLModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EPackage model;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<NLClass> classes;

	/**
	 * The cached value of the '{@link #getModelUpdate() <em>Model Update</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelUpdate()
	 * @generated
	 * @ordered
	 */
	protected UpdateInterface modelUpdate;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NLModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelInfoPackage.Literals.NL_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPackage getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject) model;
			model = (EPackage) eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelInfoPackage.NL_MODEL__MODEL,
							oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPackage basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModel(EPackage newModel) {
		EPackage oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NLClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<NLClass>(NLClass.class, this, ModelInfoPackage.NL_MODEL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UpdateInterface getModelUpdate() {
		return modelUpdate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetModelUpdate(UpdateInterface newModelUpdate, NotificationChain msgs) {
		UpdateInterface oldModelUpdate = modelUpdate;
		modelUpdate = newModelUpdate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ModelInfoPackage.NL_MODEL__MODEL_UPDATE, oldModelUpdate, newModelUpdate);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelUpdate(UpdateInterface newModelUpdate) {
		if (newModelUpdate != modelUpdate) {
			NotificationChain msgs = null;
			if (modelUpdate != null)
				msgs = ((InternalEObject) modelUpdate).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ModelInfoPackage.NL_MODEL__MODEL_UPDATE, null, msgs);
			if (newModelUpdate != null)
				msgs = ((InternalEObject) newModelUpdate).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ModelInfoPackage.NL_MODEL__MODEL_UPDATE, null, msgs);
			msgs = basicSetModelUpdate(newModelUpdate, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelInfoPackage.NL_MODEL__MODEL_UPDATE,
					newModelUpdate, newModelUpdate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelInfoPackage.NL_MODEL__CLASSES:
			return ((InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
		case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
			return basicSetModelUpdate(null, msgs);
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
		case ModelInfoPackage.NL_MODEL__NAME:
			return getName();
		case ModelInfoPackage.NL_MODEL__MODEL:
			if (resolve)
				return getModel();
			return basicGetModel();
		case ModelInfoPackage.NL_MODEL__CLASSES:
			return getClasses();
		case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
			return getModelUpdate();
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
		case ModelInfoPackage.NL_MODEL__NAME:
			setName((String) newValue);
			return;
		case ModelInfoPackage.NL_MODEL__MODEL:
			setModel((EPackage) newValue);
			return;
		case ModelInfoPackage.NL_MODEL__CLASSES:
			getClasses().clear();
			getClasses().addAll((Collection<? extends NLClass>) newValue);
			return;
		case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
			setModelUpdate((UpdateInterface) newValue);
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
		case ModelInfoPackage.NL_MODEL__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ModelInfoPackage.NL_MODEL__MODEL:
			setModel((EPackage) null);
			return;
		case ModelInfoPackage.NL_MODEL__CLASSES:
			getClasses().clear();
			return;
		case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
			setModelUpdate((UpdateInterface) null);
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
		case ModelInfoPackage.NL_MODEL__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ModelInfoPackage.NL_MODEL__MODEL:
			return model != null;
		case ModelInfoPackage.NL_MODEL__CLASSES:
			return classes != null && !classes.isEmpty();
		case ModelInfoPackage.NL_MODEL__MODEL_UPDATE:
			return modelUpdate != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	public NLClass getClass(String name) {
		for (NLClass nlClass : getClasses()) {
			if (nlClass.getName().equalsIgnoreCase(name)) {
				return nlClass;
			}
		}
		return null;
	}

	public NLAttribute getAttribute(String name) {
		String [] splitName = name.split("_");
		if (splitName.length!= 2) {
			return null;
		}
		String nlClassName = splitName[0];
		String nlAttributeName = splitName[1];
		NLClass nlClass = getClass(nlClassName);
		if (nlClass == null) {
			return null;
		}
		for (NLAttribute attribute : nlClass.getAllAttribtues()) {
			if (attribute.getName().equalsIgnoreCase(nlAttributeName)) {
				return attribute;
			}
		}
		return null;
	}

	public NLReference getReference(String name) {
		String [] splitName = name.split("_");
		if (splitName.length!= 2) {
			return null;
		}
		String nlClassName = splitName[0];
		String nlReferenceName = splitName[1];
		NLClass nlClass = getClass(nlClassName);
		if (nlClass == null) {
			return null;
		}
		for (NLReference reference : nlClass.getAllReferences()) {
			if (reference.getName().equalsIgnoreCase(nlReferenceName)) {
				return reference;
			}
		}
		return null;
	}

} // NLModelImpl
