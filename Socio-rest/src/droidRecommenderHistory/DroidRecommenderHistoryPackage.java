/**
 */
package droidRecommenderHistory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import projectHistory.ProjectHistoryPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see droidRecommenderHistory.DroidRecommenderHistoryFactory
 * @model kind="package"
 * @generated
 */
public interface DroidRecommenderHistoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "droidRecommenderHistory";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "droidRecommenderHistory";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "droidRecommenderHistory";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DroidRecommenderHistoryPackage eINSTANCE = droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link droidRecommenderHistory.impl.RecommendationMsgImpl <em>Recommendation Msg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see droidRecommenderHistory.impl.RecommendationMsgImpl
	 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getRecommendationMsg()
	 * @generated
	 */
	int RECOMMENDATION_MSG = 0;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__USER = ProjectHistoryPackage.USER_INTERACTION__USER;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__DATE = ProjectHistoryPackage.USER_INTERACTION__DATE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__ID = ProjectHistoryPackage.USER_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__ELEMENT = ProjectHistoryPackage.USER_INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__ELEMENT_STATUS = ProjectHistoryPackage.USER_INTERACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__RESULTS = ProjectHistoryPackage.USER_INTERACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Recomendation Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG__RECOMENDATION_INTERFACE = ProjectHistoryPackage.USER_INTERACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Recommendation Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG_FEATURE_COUNT = ProjectHistoryPackage.USER_INTERACTION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Recommendation Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_MSG_OPERATION_COUNT = ProjectHistoryPackage.USER_INTERACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link droidRecommenderHistory.impl.RecommendationResultImpl <em>Recommendation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see droidRecommenderHistory.impl.RecommendationResultImpl
	 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getRecommendationResult()
	 * @generated
	 */
	int RECOMMENDATION_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_RESULT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_RESULT__VALUES = 1;

	/**
	 * The feature id for the '<em><b>Raitin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_RESULT__RAITIN = 2;

	/**
	 * The number of structural features of the '<em>Recommendation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_RESULT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Recommendation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link droidRecommenderHistory.impl.StringToObjectImpl <em>String To Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see droidRecommenderHistory.impl.StringToObjectImpl
	 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getStringToObject()
	 * @generated
	 */
	int STRING_TO_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link droidRecommenderHistory.impl.RecommendationEventImpl <em>Recommendation Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see droidRecommenderHistory.impl.RecommendationEventImpl
	 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getRecommendationEvent()
	 * @generated
	 */
	int RECOMMENDATION_EVENT = 3;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT__USER = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__USER;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT__DATE = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__DATE;

	/**
	 * The feature id for the '<em><b>Undoable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT__UNDOABLE = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS__UNDOABLE;

	/**
	 * The feature id for the '<em><b>Recommendation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT__RECOMMENDATION = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT__SELECTED = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT__COMMANDS = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Recommendation Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT_FEATURE_COUNT = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get All Actions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT___GET_ALL_ACTIONS = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS___GET_ALL_ACTIONS;

	/**
	 * The number of operations of the '<em>Recommendation Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDATION_EVENT_OPERATION_COUNT = ProjectHistoryPackage.INTERACTION_WITH_ACTIONS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link droidRecommenderHistory.RecommendationMsg <em>Recommendation Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recommendation Msg</em>'.
	 * @see droidRecommenderHistory.RecommendationMsg
	 * @generated
	 */
	EClass getRecommendationMsg();

	/**
	 * Returns the meta object for the attribute '{@link droidRecommenderHistory.RecommendationMsg#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see droidRecommenderHistory.RecommendationMsg#getId()
	 * @see #getRecommendationMsg()
	 * @generated
	 */
	EAttribute getRecommendationMsg_Id();

	/**
	 * Returns the meta object for the reference '{@link droidRecommenderHistory.RecommendationMsg#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see droidRecommenderHistory.RecommendationMsg#getElement()
	 * @see #getRecommendationMsg()
	 * @generated
	 */
	EReference getRecommendationMsg_Element();

	/**
	 * Returns the meta object for the containment reference '{@link droidRecommenderHistory.RecommendationMsg#getElementStatus <em>Element Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Status</em>'.
	 * @see droidRecommenderHistory.RecommendationMsg#getElementStatus()
	 * @see #getRecommendationMsg()
	 * @generated
	 */
	EReference getRecommendationMsg_ElementStatus();

	/**
	 * Returns the meta object for the containment reference list '{@link droidRecommenderHistory.RecommendationMsg#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see droidRecommenderHistory.RecommendationMsg#getResults()
	 * @see #getRecommendationMsg()
	 * @generated
	 */
	EReference getRecommendationMsg_Results();

	/**
	 * Returns the meta object for the attribute '{@link droidRecommenderHistory.RecommendationMsg#getRecomendationInterface <em>Recomendation Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recomendation Interface</em>'.
	 * @see droidRecommenderHistory.RecommendationMsg#getRecomendationInterface()
	 * @see #getRecommendationMsg()
	 * @generated
	 */
	EAttribute getRecommendationMsg_RecomendationInterface();

	/**
	 * Returns the meta object for class '{@link droidRecommenderHistory.RecommendationResult <em>Recommendation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recommendation Result</em>'.
	 * @see droidRecommenderHistory.RecommendationResult
	 * @generated
	 */
	EClass getRecommendationResult();

	/**
	 * Returns the meta object for the attribute '{@link droidRecommenderHistory.RecommendationResult#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see droidRecommenderHistory.RecommendationResult#getType()
	 * @see #getRecommendationResult()
	 * @generated
	 */
	EAttribute getRecommendationResult_Type();

	/**
	 * Returns the meta object for the map '{@link droidRecommenderHistory.RecommendationResult#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Values</em>'.
	 * @see droidRecommenderHistory.RecommendationResult#getValues()
	 * @see #getRecommendationResult()
	 * @generated
	 */
	EReference getRecommendationResult_Values();

	/**
	 * Returns the meta object for the attribute '{@link droidRecommenderHistory.RecommendationResult#getRaitin <em>Raitin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raitin</em>'.
	 * @see droidRecommenderHistory.RecommendationResult#getRaitin()
	 * @see #getRecommendationResult()
	 * @generated
	 */
	EAttribute getRecommendationResult_Raitin();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Object</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EJavaObject" valueRequired="true"
	 * @generated
	 */
	EClass getStringToObject();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToObject()
	 * @generated
	 */
	EAttribute getStringToObject_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToObject()
	 * @generated
	 */
	EAttribute getStringToObject_Value();

	/**
	 * Returns the meta object for class '{@link droidRecommenderHistory.RecommendationEvent <em>Recommendation Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recommendation Event</em>'.
	 * @see droidRecommenderHistory.RecommendationEvent
	 * @generated
	 */
	EClass getRecommendationEvent();

	/**
	 * Returns the meta object for the reference '{@link droidRecommenderHistory.RecommendationEvent#getRecommendation <em>Recommendation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recommendation</em>'.
	 * @see droidRecommenderHistory.RecommendationEvent#getRecommendation()
	 * @see #getRecommendationEvent()
	 * @generated
	 */
	EReference getRecommendationEvent_Recommendation();

	/**
	 * Returns the meta object for the reference '{@link droidRecommenderHistory.RecommendationEvent#getSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selected</em>'.
	 * @see droidRecommenderHistory.RecommendationEvent#getSelected()
	 * @see #getRecommendationEvent()
	 * @generated
	 */
	EReference getRecommendationEvent_Selected();

	/**
	 * Returns the meta object for the containment reference list '{@link droidRecommenderHistory.RecommendationEvent#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see droidRecommenderHistory.RecommendationEvent#getCommands()
	 * @see #getRecommendationEvent()
	 * @generated
	 */
	EReference getRecommendationEvent_Commands();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DroidRecommenderHistoryFactory getDroidRecommenderHistoryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link droidRecommenderHistory.impl.RecommendationMsgImpl <em>Recommendation Msg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see droidRecommenderHistory.impl.RecommendationMsgImpl
		 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getRecommendationMsg()
		 * @generated
		 */
		EClass RECOMMENDATION_MSG = eINSTANCE.getRecommendationMsg();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOMMENDATION_MSG__ID = eINSTANCE.getRecommendationMsg_Id();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_MSG__ELEMENT = eINSTANCE.getRecommendationMsg_Element();

		/**
		 * The meta object literal for the '<em><b>Element Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_MSG__ELEMENT_STATUS = eINSTANCE.getRecommendationMsg_ElementStatus();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_MSG__RESULTS = eINSTANCE.getRecommendationMsg_Results();

		/**
		 * The meta object literal for the '<em><b>Recomendation Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOMMENDATION_MSG__RECOMENDATION_INTERFACE = eINSTANCE.getRecommendationMsg_RecomendationInterface();

		/**
		 * The meta object literal for the '{@link droidRecommenderHistory.impl.RecommendationResultImpl <em>Recommendation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see droidRecommenderHistory.impl.RecommendationResultImpl
		 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getRecommendationResult()
		 * @generated
		 */
		EClass RECOMMENDATION_RESULT = eINSTANCE.getRecommendationResult();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOMMENDATION_RESULT__TYPE = eINSTANCE.getRecommendationResult_Type();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_RESULT__VALUES = eINSTANCE.getRecommendationResult_Values();

		/**
		 * The meta object literal for the '<em><b>Raitin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECOMMENDATION_RESULT__RAITIN = eINSTANCE.getRecommendationResult_Raitin();

		/**
		 * The meta object literal for the '{@link droidRecommenderHistory.impl.StringToObjectImpl <em>String To Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see droidRecommenderHistory.impl.StringToObjectImpl
		 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getStringToObject()
		 * @generated
		 */
		EClass STRING_TO_OBJECT = eINSTANCE.getStringToObject();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_OBJECT__KEY = eINSTANCE.getStringToObject_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_OBJECT__VALUE = eINSTANCE.getStringToObject_Value();

		/**
		 * The meta object literal for the '{@link droidRecommenderHistory.impl.RecommendationEventImpl <em>Recommendation Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see droidRecommenderHistory.impl.RecommendationEventImpl
		 * @see droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl#getRecommendationEvent()
		 * @generated
		 */
		EClass RECOMMENDATION_EVENT = eINSTANCE.getRecommendationEvent();

		/**
		 * The meta object literal for the '<em><b>Recommendation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_EVENT__RECOMMENDATION = eINSTANCE.getRecommendationEvent_Recommendation();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_EVENT__SELECTED = eINSTANCE.getRecommendationEvent_Selected();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDATION_EVENT__COMMANDS = eINSTANCE.getRecommendationEvent_Commands();

	}

} //DroidRecommenderHistoryPackage
