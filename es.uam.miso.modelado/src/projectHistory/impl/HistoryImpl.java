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
import projectHistory.Msg;
import projectHistory.projectHistoryPackage;

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
	protected EList<Msg> msg;

	/**
	 * The cached value of the '{@link #getCreateMsg() <em>Create Msg</em>}' reference.
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
		return projectHistoryPackage.Literals.HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Msg> getMsg() {
		if (msg == null) {
			msg = new EObjectContainmentEList<Msg>(Msg.class, this, projectHistoryPackage.HISTORY__MSG);
		}
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateMsg getCreateMsg() {
		if (createMsg != null && createMsg.eIsProxy()) {
			InternalEObject oldCreateMsg = (InternalEObject)createMsg;
			createMsg = (CreateMsg)eResolveProxy(oldCreateMsg);
			if (createMsg != oldCreateMsg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, projectHistoryPackage.HISTORY__CREATE_MSG, oldCreateMsg, createMsg));
			}
		}
		return createMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateMsg basicGetCreateMsg() {
		return createMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateMsg(CreateMsg newCreateMsg) {
		CreateMsg oldCreateMsg = createMsg;
		createMsg = newCreateMsg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, projectHistoryPackage.HISTORY__CREATE_MSG, oldCreateMsg, createMsg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case projectHistoryPackage.HISTORY__MSG:
				return ((InternalEList<?>)getMsg()).basicRemove(otherEnd, msgs);
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
			case projectHistoryPackage.HISTORY__MSG:
				return getMsg();
			case projectHistoryPackage.HISTORY__CREATE_MSG:
				if (resolve) return getCreateMsg();
				return basicGetCreateMsg();
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
			case projectHistoryPackage.HISTORY__MSG:
				getMsg().clear();
				getMsg().addAll((Collection<? extends Msg>)newValue);
				return;
			case projectHistoryPackage.HISTORY__CREATE_MSG:
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
			case projectHistoryPackage.HISTORY__MSG:
				getMsg().clear();
				return;
			case projectHistoryPackage.HISTORY__CREATE_MSG:
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
			case projectHistoryPackage.HISTORY__MSG:
				return msg != null && !msg.isEmpty();
			case projectHistoryPackage.HISTORY__CREATE_MSG:
				return createMsg != null;
		}
		return super.eIsSet(featureID);
	}

} //HistoryImpl
