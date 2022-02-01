/**
 */
package droidRecommenderHistory.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.InternalEList;
import org.json.JSONObject;

import droidRecommenderHistory.DroidRecommenderHistoryFactory;
import droidRecommenderHistory.DroidRecommenderHistoryPackage;
import droidRecommenderHistory.RecommendationMsg;
import droidRecommenderHistory.RecommendationResult;
import es.uam.app.projects.emf.metamodel.MetamodelControl;
import projectHistory.UserInteraction;
import projectHistory.impl.UserInteractionImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Recommendation Msg</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationMsgImpl#getId <em>Id</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationMsgImpl#getElement <em>Element</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationMsgImpl#getElementStatus <em>Element Status</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationMsgImpl#getResults <em>Results</em>}</li>
 *   <li>{@link droidRecommenderHistory.impl.RecommendationMsgImpl#getRecomendationInterface <em>Recomendation Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecommendationMsgImpl extends UserInteractionImpl implements RecommendationMsg {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

	/**
	 * The cached value of the '{@link #getElementStatus() <em>Element Status</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElementStatus()
	 * @generated
	 * @ordered
	 */
	protected EObject elementStatus;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<RecommendationResult> results;

	/**
	 * The default value of the '{@link #getRecomendationInterface() <em>Recomendation Interface</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRecomendationInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String RECOMENDATION_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecomendationInterface() <em>Recomendation Interface</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRecomendationInterface()
	 * @generated
	 * @ordered
	 */
	protected String recomendationInterface = RECOMENDATION_INTERFACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommendationMsgImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DroidRecommenderHistoryPackage.Literals.RECOMMENDATION_MSG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getElementStatus() {
		return elementStatus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementStatus(EObject newElementStatus, NotificationChain msgs) {
		EObject oldElementStatus = elementStatus;
		elementStatus = newElementStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS, oldElementStatus, newElementStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElementStatus(EObject newElementStatus) {
		if (newElementStatus != elementStatus) {
			NotificationChain msgs = null;
			if (elementStatus != null)
				msgs = ((InternalEObject)elementStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS, null, msgs);
			if (newElementStatus != null)
				msgs = ((InternalEObject)newElementStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS, null, msgs);
			msgs = basicSetElementStatus(newElementStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS, newElementStatus, newElementStatus));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RecommendationResult> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<RecommendationResult>(RecommendationResult.class, this, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRecomendationInterface() {
		return recomendationInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecomendationInterface(String newRecomendationInterface) {
		String oldRecomendationInterface = recomendationInterface;
		recomendationInterface = newRecomendationInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RECOMENDATION_INTERFACE, oldRecomendationInterface, recomendationInterface));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS:
				return basicSetElementStatus(null, msgs);
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ID:
				return getId();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS:
				return getElementStatus();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RESULTS:
				return getResults();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RECOMENDATION_INTERFACE:
				return getRecomendationInterface();
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ID:
				setId((Long)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT:
				setElement((EObject)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS:
				setElementStatus((EObject)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends RecommendationResult>)newValue);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RECOMENDATION_INTERFACE:
				setRecomendationInterface((String)newValue);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ID:
				setId(ID_EDEFAULT);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT:
				setElement((EObject)null);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS:
				setElementStatus((EObject)null);
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RESULTS:
				getResults().clear();
				return;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RECOMENDATION_INTERFACE:
				setRecomendationInterface(RECOMENDATION_INTERFACE_EDEFAULT);
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
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ID:
				return id != ID_EDEFAULT;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT:
				return element != null;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__ELEMENT_STATUS:
				return elementStatus != null;
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RESULTS:
				return results != null && !results.isEmpty();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG__RECOMENDATION_INTERFACE:
				return RECOMENDATION_INTERFACE_EDEFAULT == null ? recomendationInterface != null : !RECOMENDATION_INTERFACE_EDEFAULT.equals(recomendationInterface);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", recomendationInterface: ");
		result.append(recomendationInterface);
		result.append(')');
		return result.toString();
	}

	@Override
	public UserInteraction getACopy() {
		RecommendationMsg msg = DroidRecommenderHistoryFactory.eINSTANCE.createRecommendationMsg();
		msg.setDate(this.getDate());
		msg.setElement(this.element);

		Copier copier = new Copier();
		EObject copy = copier.copy(this.elementStatus);
		copier.clear();

		msg.setElementStatus(copy);
		msg.setId(this.getId());
		msg.setUser(this.getUser());
		for (RecommendationResult result : this.getResults()) {
			msg.getResults().add(result.getACopy());
		}

		return msg;
	}

	@Override
	public JSONObject getJSON() {
		if (this.getElementStatus() instanceof EClass) {
			JSONObject object = new JSONObject();
			JSONObject features = new JSONObject();
			JSONObject superClasses = new JSONObject();
			for (RecommendationResult result : getResults()) {

				String name = (String) result.getValues().get(MetamodelControl.NAME);
				JSONObject obj = new JSONObject();
				for (String key : result.getValues().keySet()) {
					obj.put(key, result.getValues().get(key));
				}
				obj.put("value", result.getRaitin());

				if (result.getType().equals(MetamodelControl.FEATURES)) {
					features.put(name, obj);
				} else if (result.getType().equals(MetamodelControl.SUPERCLASSES)) {
					superClasses.put(name, obj);
				}
			}
			object.put(MetamodelControl.FEATURES, features);
			object.put(MetamodelControl.SUPERCLASSES, superClasses);

			JSONObject ret = new JSONObject();
			ret.put(((EClass) this.elementStatus).getName(), object);
			ret.put("RecommenderId", getId());
			return ret;
		}
		return new JSONObject();
	}

	@Override
	public RecommendationResult getSelected(RecommendationResult selected) {
		for (RecommendationResult element : this.getResults()) {
			if (element.equals(selected)) {
				return element;
			}
		}
		return null;
	}

	@Override
	public String getElementName() {
		if (this.getElement() instanceof ENamedElement) {
			return ((ENamedElement)this.getElement()).getName();
		}
		return "";
	}

	@Override
	public String getElementType() {
		if (this.getElement() instanceof EClass) {
			return "EClass";
		}
		return null;
	}

} // RecommendationMsgImpl
