/**
 */
package projectHistory.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import projectHistory.ProjectHistoryPackage;
import es.uam.app.actions.metamodels.UpdateClassSuperType;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.metamodel.ClassControl;
import projectHistory.Update;
import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.impl.UpdateImpl#getOld <em>Old</em>}</li>
 *   <li>{@link projectHistory.impl.UpdateImpl#getNew <em>New</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateImpl extends ActionImpl implements Update {
	/**
	 * The cached value of the '{@link #getOld() <em>Old</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOld()
	 * @generated
	 * @ordered
	 */
	protected EObject old;

	/**
	 * The cached value of the '{@link #getNew() <em>New</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNew()
	 * @generated
	 * @ordered
	 */
	protected EObject new_;
	
	private es.uam.app.actions.Update<? extends Project> action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProjectHistoryPackage.Literals.UPDATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOld() {
		return old;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOt
	 */
	public void doIt() throws Exception {
		super.doIt();
		setOld(getAction().getOld());
		setNew(getAction().getNew());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOld(EObject newOld, NotificationChain msgs) {
		EObject oldOld = old;
		old = newOld;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.UPDATE__OLD, oldOld, newOld);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOld(EObject newOld) {
		if (newOld != old) {
			NotificationChain msgs = null;
			if (old != null)
				msgs = ((InternalEObject)old).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProjectHistoryPackage.UPDATE__OLD, null, msgs);
			if (newOld != null)
				msgs = ((InternalEObject)newOld).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProjectHistoryPackage.UPDATE__OLD, null, msgs);
			msgs = basicSetOld(newOld, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.UPDATE__OLD, newOld, newOld));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getNew() {
		return new_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNew(EObject newNew, NotificationChain msgs) {
		EObject oldNew = new_;
		new_ = newNew;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.UPDATE__NEW, oldNew, newNew);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNew(EObject newNew) {
		if (newNew != new_) {
			NotificationChain msgs = null;
			if (new_ != null)
				msgs = ((InternalEObject)new_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProjectHistoryPackage.UPDATE__NEW, null, msgs);
			if (newNew != null)
				msgs = ((InternalEObject)newNew).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProjectHistoryPackage.UPDATE__NEW, null, msgs);
			msgs = basicSetNew(newNew, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.UPDATE__NEW, newNew, newNew));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProjectHistoryPackage.UPDATE__OLD:
				return basicSetOld(null, msgs);
			case ProjectHistoryPackage.UPDATE__NEW:
				return basicSetNew(null, msgs);
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
			case ProjectHistoryPackage.UPDATE__OLD:
				return getOld();
			case ProjectHistoryPackage.UPDATE__NEW:
				return getNew();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProjectHistoryPackage.UPDATE__OLD:
				setOld((EObject)newValue);
				return;
			case ProjectHistoryPackage.UPDATE__NEW:
				setNew((EObject)newValue);
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
			case ProjectHistoryPackage.UPDATE__OLD:
				setOld((EObject)null);
				return;
			case ProjectHistoryPackage.UPDATE__NEW:
				setNew((EObject)null);
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
			case ProjectHistoryPackage.UPDATE__OLD:
				return old != null;
			case ProjectHistoryPackage.UPDATE__NEW:
				return new_ != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	protected es.uam.app.actions.Update<? extends Project> createAction() {
		Project p=getProject();
		return p.createUpdateAction(this.getElement(), this.new_, this.old);
	}

	@Override
	public void setAction(es.uam.app.actions.Update<? extends Project> action) {
		this.action=action;
		
	}

	@Override
	public es.uam.app.actions.Update<? extends Project> getAction() {
		if (action==null){
			action=createAction();
		}
		return action;
	}

	@Override
	public boolean isUpdateAbstract() {
		if (getNew() instanceof EClass && getOld() instanceof EClass){
			return ((EClass)getNew()).isAbstract()!=((EClass)getOld()).isAbstract();
		}
		return false;
	}

	@Override
	public boolean isUpdateSuperType(ClassControl superType) {
		if (action instanceof UpdateClassSuperType){
			ClassControl oldC=(ClassControl)action.getOldC();
			ClassControl newC=(ClassControl)action.getNewC();
			if (!oldC.isSubTypeOf(superType) && newC.isSubTypeOf(superType)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Controlador getOldC() {
		return action.getOldC();
	}

	@Override
	public Controlador getNewC() {
		return action.getNewC();
	}

} //UpdateImpl
