/**
 */
package droidRecommenderHistory.impl;

import droidRecommenderHistory.DroidRecommenderHistoryFactory;
import droidRecommenderHistory.DroidRecommenderHistoryPackage;
import droidRecommenderHistory.RecommendationEvent;
import droidRecommenderHistory.RecommendationMsg;
import droidRecommenderHistory.RecommendationResult;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import projectHistory.Action;
import projectHistory.UserInteraction;
import projectHistory.impl.InteractionWithActionsImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recommendation Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationEventImpl#getRecommendation <em>Recommendation</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationEventImpl#getSelected <em>Selected</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationEventImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecommendationEventImpl extends InteractionWithActionsImpl implements RecommendationEvent {
	/**
	 * The cached value of the '{@link #getRecommendation() <em>Recommendation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecommendation()
	 * @generated
	 * @ordered
	 */
	protected RecommendationMsg recommendation;

	/**
	 * The cached value of the '{@link #getSelected() <em>Selected</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelected()
	 * @generated
	 * @ordered
	 */
	protected RecommendationResult selected;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> commands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommendationEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DroidRecommenderHistoryPackage.Literals.RECOMMENDATION_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecommendationMsg getRecommendation() {
		if (recommendation != null && recommendation.eIsProxy()) {
			InternalEObject oldRecommendation = (InternalEObject)recommendation;
			recommendation = (RecommendationMsg)eResolveProxy(oldRecommendation);
			if (recommendation != oldRecommendation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__RECOMMENDATION, oldRecommendation, recommendation));
			}
		}
		return recommendation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationMsg basicGetRecommendation() {
		return recommendation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecommendation(RecommendationMsg newRecommendation) {
		RecommendationMsg oldRecommendation = recommendation;
		recommendation = newRecommendation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__RECOMMENDATION, oldRecommendation, recommendation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecommendationResult getSelected() {
		if (selected != null && selected.eIsProxy()) {
			InternalEObject oldSelected = (InternalEObject)selected;
			selected = (RecommendationResult)eResolveProxy(oldSelected);
			if (selected != oldSelected) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__SELECTED, oldSelected, selected));
			}
		}
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationResult basicGetSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelected(RecommendationResult newSelected) {
		RecommendationResult oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList<Action>(Action.class, this, DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__COMMANDS:
				return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__RECOMMENDATION:
				if (resolve) return getRecommendation();
				return basicGetRecommendation();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__SELECTED:
				if (resolve) return getSelected();
				return basicGetSelected();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__COMMANDS:
				return getCommands();
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__RECOMMENDATION:
				setRecommendation((RecommendationMsg)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__SELECTED:
				setSelected((RecommendationResult)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__COMMANDS:
				getCommands().clear();
				getCommands().addAll((Collection<? extends Action>)newValue);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__RECOMMENDATION:
				setRecommendation((RecommendationMsg)null);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__SELECTED:
				setSelected((RecommendationResult)null);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__COMMANDS:
				getCommands().clear();
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__RECOMMENDATION:
				return recommendation != null;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__SELECTED:
				return selected != null;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT__COMMANDS:
				return commands != null && !commands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<Action> getAllActions() {
		return this.getCommands();
	}

	@Override
	public boolean hasElement(String element) {
		for (Action am : this.getAllActions()) {
			if (am.getObject().getName().equalsIgnoreCase(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasAction(String action) {
		for (Action am : this.getAllActions()) {
			if (am.getActionName().equalsIgnoreCase(action)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public UserInteraction getACopy() {
		RecommendationEvent event = DroidRecommenderHistoryFactory.eINSTANCE.createRecommendationEvent();
		event.setDate(this.getDate());
		event.setRecommendation((RecommendationMsg) this.getRecommendation().getACopy());
		event.setSelected(event.getRecommendation().getSelected(this.getSelected()));
		event.setUndoable(this.isUndoable());
		event.setUser(this.getUser());
		event.getCommands().addAll(this.getCommands());
		return event;
	}

	@Override
	public String getElementName() {
		return this.getRecommendation().getElementName();
	}

	@Override
	public String getElementType() {
		
		return this.getRecommendation().getElementType();
	}

} //RecommendationEventImpl
