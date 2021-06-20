/**
 */
package projectHistory.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import projectHistory.CreateMsg;
import projectHistory.History;
import projectHistory.ProjectHistoryPackage;
import projectHistory.UserInteraction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.impl.HistoryImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link projectHistory.impl.HistoryImpl#getCreateMsg <em>Create Msg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HistoryImpl extends MinimalEObjectImpl.Container implements History {
	/**
	 * The cached value of the '{@link #getMsg() <em>Msg</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInteraction> msg;

	/**
	 * The cached value of the '{@link #getCreateMsg() <em>Create Msg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateMsg()
	 * @generated
	 * @ordered
	 */
	protected CreateMsg createMsg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProjectHistoryPackage.Literals.HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserInteraction> getMsg() {
		if (msg == null) {
			msg = new EObjectContainmentEList<UserInteraction>(UserInteraction.class, this, ProjectHistoryPackage.HISTORY__MSG);
		}
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateMsg getCreateMsg() {
		return createMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreateMsg(CreateMsg newCreateMsg, NotificationChain msgs) {
		CreateMsg oldCreateMsg = createMsg;
		createMsg = newCreateMsg;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.HISTORY__CREATE_MSG, oldCreateMsg, newCreateMsg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreateMsg(CreateMsg newCreateMsg) {
		if (newCreateMsg != createMsg) {
			NotificationChain msgs = null;
			if (createMsg != null)
				msgs = ((InternalEObject)createMsg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProjectHistoryPackage.HISTORY__CREATE_MSG, null, msgs);
			if (newCreateMsg != null)
				msgs = ((InternalEObject)newCreateMsg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProjectHistoryPackage.HISTORY__CREATE_MSG, null, msgs);
			msgs = basicSetCreateMsg(newCreateMsg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProjectHistoryPackage.HISTORY__CREATE_MSG, newCreateMsg, newCreateMsg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProjectHistoryPackage.HISTORY__MSG:
				return ((InternalEList<?>)getMsg()).basicRemove(otherEnd, msgs);
			case ProjectHistoryPackage.HISTORY__CREATE_MSG:
				return basicSetCreateMsg(null, msgs);
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
			case ProjectHistoryPackage.HISTORY__MSG:
				return getMsg();
			case ProjectHistoryPackage.HISTORY__CREATE_MSG:
				return getCreateMsg();
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
			case ProjectHistoryPackage.HISTORY__MSG:
				getMsg().clear();
				getMsg().addAll((Collection<? extends UserInteraction>)newValue);
				return;
			case ProjectHistoryPackage.HISTORY__CREATE_MSG:
				setCreateMsg((CreateMsg)newValue);
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
			case ProjectHistoryPackage.HISTORY__MSG:
				getMsg().clear();
				return;
			case ProjectHistoryPackage.HISTORY__CREATE_MSG:
				setCreateMsg((CreateMsg)null);
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
			case ProjectHistoryPackage.HISTORY__MSG:
				return msg != null && !msg.isEmpty();
			case ProjectHistoryPackage.HISTORY__CREATE_MSG:
				return createMsg != null;
		}
		return super.eIsSet(featureID);
	}

} //HistoryImpl
