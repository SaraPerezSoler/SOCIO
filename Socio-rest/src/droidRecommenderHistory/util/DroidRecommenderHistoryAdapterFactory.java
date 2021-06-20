/**
 */
package droidRecommenderHistory.util;

import droidRecommenderHistory.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import projectHistory.InteractionWithActions;
import projectHistory.UserInteraction;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage
 * @generated
 */
public class DroidRecommenderHistoryAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DroidRecommenderHistoryPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DroidRecommenderHistoryAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DroidRecommenderHistoryPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DroidRecommenderHistorySwitch<Adapter> modelSwitch =
		new DroidRecommenderHistorySwitch<Adapter>() {
			@Override
			public Adapter caseRecommendationMsg(RecommendationMsg object) {
				return createRecommendationMsgAdapter();
			}
			@Override
			public Adapter caseRecommendationResult(RecommendationResult object) {
				return createRecommendationResultAdapter();
			}
			@Override
			public Adapter caseStringToObject(Map.Entry<String, Object> object) {
				return createStringToObjectAdapter();
			}
			@Override
			public Adapter caseRecommendationEvent(RecommendationEvent object) {
				return createRecommendationEventAdapter();
			}
			@Override
			public Adapter caseUserInteraction(UserInteraction object) {
				return createUserInteractionAdapter();
			}
			@Override
			public Adapter caseInteractionWithActions(InteractionWithActions object) {
				return createInteractionWithActionsAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link droidRecommenderHistory.RecommendationMsg <em>Recommendation Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see droidRecommenderHistory.RecommendationMsg
	 * @generated
	 */
	public Adapter createRecommendationMsgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link droidRecommenderHistory.RecommendationResult <em>Recommendation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see droidRecommenderHistory.RecommendationResult
	 * @generated
	 */
	public Adapter createRecommendationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link droidRecommenderHistory.RecommendationEvent <em>Recommendation Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see droidRecommenderHistory.RecommendationEvent
	 * @generated
	 */
	public Adapter createRecommendationEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link projectHistory.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see projectHistory.UserInteraction
	 * @generated
	 */
	public Adapter createUserInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link projectHistory.InteractionWithActions <em>Interaction With Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see projectHistory.InteractionWithActions
	 * @generated
	 */
	public Adapter createInteractionWithActionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DroidRecommenderHistoryAdapterFactory
