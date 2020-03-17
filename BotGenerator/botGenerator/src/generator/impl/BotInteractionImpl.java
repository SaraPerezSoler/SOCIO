/**
 */
package generator.impl;

import generator.Action;
import generator.BotInteraction;
import generator.GeneratorPackage;
import generator.UserInteraction;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bot Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.BotInteractionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link generator.impl.BotInteractionImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link generator.impl.BotInteractionImpl#getOutcoming <em>Outcoming</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BotInteractionImpl extends InteractionImpl implements BotInteraction {
	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getOutcoming() <em>Outcoming</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutcoming()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInteraction> outcoming;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BotInteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.BOT_INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, GeneratorPackage.BOT_INTERACTION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserInteraction getIncoming() {
		if (eContainerFeatureID() != GeneratorPackage.BOT_INTERACTION__INCOMING) return null;
		return (UserInteraction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncoming(UserInteraction newIncoming, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIncoming, GeneratorPackage.BOT_INTERACTION__INCOMING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncoming(UserInteraction newIncoming) {
		if (newIncoming != eInternalContainer() || (eContainerFeatureID() != GeneratorPackage.BOT_INTERACTION__INCOMING && newIncoming != null)) {
			if (EcoreUtil.isAncestor(this, newIncoming))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIncoming != null)
				msgs = ((InternalEObject)newIncoming).eInverseAdd(this, GeneratorPackage.USER_INTERACTION__TARGET, UserInteraction.class, msgs);
			msgs = basicSetIncoming(newIncoming, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.BOT_INTERACTION__INCOMING, newIncoming, newIncoming));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserInteraction> getOutcoming() {
		if (outcoming == null) {
			outcoming = new EObjectContainmentWithInverseEList<UserInteraction>(UserInteraction.class, this, GeneratorPackage.BOT_INTERACTION__OUTCOMING, GeneratorPackage.USER_INTERACTION__SRC);
		}
		return outcoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIncoming((UserInteraction)otherEnd, msgs);
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutcoming()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return basicSetIncoming(null, msgs);
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return ((InternalEList<?>)getOutcoming()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return eInternalContainer().eInverseRemove(this, GeneratorPackage.USER_INTERACTION__TARGET, UserInteraction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				return getActions();
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return getIncoming();
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return getOutcoming();
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
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				setIncoming((UserInteraction)newValue);
				return;
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				getOutcoming().clear();
				getOutcoming().addAll((Collection<? extends UserInteraction>)newValue);
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
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				getActions().clear();
				return;
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				setIncoming((UserInteraction)null);
				return;
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				getOutcoming().clear();
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
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				return actions != null && !actions.isEmpty();
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return getIncoming() != null;
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return outcoming != null && !outcoming.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BotInteractionImpl
