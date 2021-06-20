/**
 */
package droidRecommenderHistory.impl;

import droidRecommenderHistory.*;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DroidRecommenderHistoryFactoryImpl extends EFactoryImpl implements DroidRecommenderHistoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DroidRecommenderHistoryFactory init() {
		try {
			DroidRecommenderHistoryFactory theDroidRecommenderHistoryFactory = (DroidRecommenderHistoryFactory)EPackage.Registry.INSTANCE.getEFactory(DroidRecommenderHistoryPackage.eNS_URI);
			if (theDroidRecommenderHistoryFactory != null) {
				return theDroidRecommenderHistoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DroidRecommenderHistoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DroidRecommenderHistoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DroidRecommenderHistoryPackage.RECOMMENDATION_MSG: return createRecommendationMsg();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_RESULT: return createRecommendationResult();
			case DroidRecommenderHistoryPackage.STRING_TO_OBJECT: return (EObject)createStringToObject();
			case DroidRecommenderHistoryPackage.RECOMMENDATION_EVENT: return createRecommendationEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecommendationMsg createRecommendationMsg() {
		RecommendationMsgImpl recommendationMsg = new RecommendationMsgImpl();
		return recommendationMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecommendationResult createRecommendationResult() {
		RecommendationResultImpl recommendationResult = new RecommendationResultImpl();
		return recommendationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createStringToObject() {
		StringToObjectImpl stringToObject = new StringToObjectImpl();
		return stringToObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecommendationEvent createRecommendationEvent() {
		RecommendationEventImpl recommendationEvent = new RecommendationEventImpl();
		return recommendationEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DroidRecommenderHistoryPackage getDroidRecommenderHistoryPackage() {
		return (DroidRecommenderHistoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DroidRecommenderHistoryPackage getPackage() {
		return DroidRecommenderHistoryPackage.eINSTANCE;
	}

} //DroidRecommenderHistoryFactoryImpl
