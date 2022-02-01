/**
 */
package droidRecommenderHistory.impl;

import branchDecision.BranchDecisionPackage;

import branchDecision.impl.BranchDecisionPackageImpl;

import droidRecommenderHistory.DroidRecommenderHistoryFactory;
import droidRecommenderHistory.DroidRecommenderHistoryPackage;
import droidRecommenderHistory.RecommendationEvent;
import droidRecommenderHistory.RecommendationMsg;
import droidRecommenderHistory.RecommendationResult;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import projectHistory.ProjectHistoryPackage;

import projectHistory.impl.ProjectHistoryPackageImpl;

import removeLog.RemoveLogPackage;

import removeLog.impl.RemoveLogPackageImpl;

import socioProjects.SocioProjectsPackage;

import socioProjects.impl.SocioProjectsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DroidRecommenderHistoryPackageImpl extends EPackageImpl implements DroidRecommenderHistoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendationMsgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendationEventEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see droidRecommenderHistory.DroidRecommenderHistoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DroidRecommenderHistoryPackageImpl() {
		super(eNS_URI, DroidRecommenderHistoryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DroidRecommenderHistoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DroidRecommenderHistoryPackage init() {
		if (isInited) return (DroidRecommenderHistoryPackage)EPackage.Registry.INSTANCE.getEPackage(DroidRecommenderHistoryPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDroidRecommenderHistoryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DroidRecommenderHistoryPackageImpl theDroidRecommenderHistoryPackage = registeredDroidRecommenderHistoryPackage instanceof DroidRecommenderHistoryPackageImpl ? (DroidRecommenderHistoryPackageImpl)registeredDroidRecommenderHistoryPackage : new DroidRecommenderHistoryPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProjectHistoryPackage.eNS_URI);
		ProjectHistoryPackageImpl theProjectHistoryPackage = (ProjectHistoryPackageImpl)(registeredPackage instanceof ProjectHistoryPackageImpl ? registeredPackage : ProjectHistoryPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI);
		SocioProjectsPackageImpl theSocioProjectsPackage = (SocioProjectsPackageImpl)(registeredPackage instanceof SocioProjectsPackageImpl ? registeredPackage : SocioProjectsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI);
		RemoveLogPackageImpl theRemoveLogPackage = (RemoveLogPackageImpl)(registeredPackage instanceof RemoveLogPackageImpl ? registeredPackage : RemoveLogPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BranchDecisionPackage.eNS_URI);
		BranchDecisionPackageImpl theBranchDecisionPackage = (BranchDecisionPackageImpl)(registeredPackage instanceof BranchDecisionPackageImpl ? registeredPackage : BranchDecisionPackage.eINSTANCE);

		// Create package meta-data objects
		theDroidRecommenderHistoryPackage.createPackageContents();
		theProjectHistoryPackage.createPackageContents();
		theSocioProjectsPackage.createPackageContents();
		theRemoveLogPackage.createPackageContents();
		theBranchDecisionPackage.createPackageContents();

		// Initialize created meta-data
		theDroidRecommenderHistoryPackage.initializePackageContents();
		theProjectHistoryPackage.initializePackageContents();
		theSocioProjectsPackage.initializePackageContents();
		theRemoveLogPackage.initializePackageContents();
		theBranchDecisionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDroidRecommenderHistoryPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DroidRecommenderHistoryPackage.eNS_URI, theDroidRecommenderHistoryPackage);
		return theDroidRecommenderHistoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecommendationMsg() {
		return recommendationMsgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecommendationMsg_Id() {
		return (EAttribute)recommendationMsgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationMsg_Element() {
		return (EReference)recommendationMsgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationMsg_ElementStatus() {
		return (EReference)recommendationMsgEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationMsg_Results() {
		return (EReference)recommendationMsgEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecommendationMsg_RecomendationInterface() {
		return (EAttribute)recommendationMsgEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecommendationResult() {
		return recommendationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecommendationResult_Type() {
		return (EAttribute)recommendationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationResult_Values() {
		return (EReference)recommendationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecommendationResult_Raitin() {
		return (EAttribute)recommendationResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringToObject() {
		return stringToObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringToObject_Key() {
		return (EAttribute)stringToObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringToObject_Value() {
		return (EAttribute)stringToObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecommendationEvent() {
		return recommendationEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationEvent_Recommendation() {
		return (EReference)recommendationEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationEvent_Selected() {
		return (EReference)recommendationEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecommendationEvent_Commands() {
		return (EReference)recommendationEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DroidRecommenderHistoryFactory getDroidRecommenderHistoryFactory() {
		return (DroidRecommenderHistoryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		recommendationMsgEClass = createEClass(RECOMMENDATION_MSG);
		createEAttribute(recommendationMsgEClass, RECOMMENDATION_MSG__ID);
		createEReference(recommendationMsgEClass, RECOMMENDATION_MSG__ELEMENT);
		createEReference(recommendationMsgEClass, RECOMMENDATION_MSG__ELEMENT_STATUS);
		createEReference(recommendationMsgEClass, RECOMMENDATION_MSG__RESULTS);
		createEAttribute(recommendationMsgEClass, RECOMMENDATION_MSG__RECOMENDATION_INTERFACE);

		recommendationResultEClass = createEClass(RECOMMENDATION_RESULT);
		createEAttribute(recommendationResultEClass, RECOMMENDATION_RESULT__TYPE);
		createEReference(recommendationResultEClass, RECOMMENDATION_RESULT__VALUES);
		createEAttribute(recommendationResultEClass, RECOMMENDATION_RESULT__RAITIN);

		stringToObjectEClass = createEClass(STRING_TO_OBJECT);
		createEAttribute(stringToObjectEClass, STRING_TO_OBJECT__KEY);
		createEAttribute(stringToObjectEClass, STRING_TO_OBJECT__VALUE);

		recommendationEventEClass = createEClass(RECOMMENDATION_EVENT);
		createEReference(recommendationEventEClass, RECOMMENDATION_EVENT__RECOMMENDATION);
		createEReference(recommendationEventEClass, RECOMMENDATION_EVENT__SELECTED);
		createEReference(recommendationEventEClass, RECOMMENDATION_EVENT__COMMANDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ProjectHistoryPackage theProjectHistoryPackage = (ProjectHistoryPackage)EPackage.Registry.INSTANCE.getEPackage(ProjectHistoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		recommendationMsgEClass.getESuperTypes().add(theProjectHistoryPackage.getUserInteraction());
		recommendationEventEClass.getESuperTypes().add(theProjectHistoryPackage.getInteractionWithActions());

		// Initialize classes, features, and operations; add parameters
		initEClass(recommendationMsgEClass, RecommendationMsg.class, "RecommendationMsg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecommendationMsg_Id(), ecorePackage.getELong(), "id", null, 1, 1, RecommendationMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationMsg_Element(), ecorePackage.getEObject(), null, "element", null, 1, 1, RecommendationMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationMsg_ElementStatus(), ecorePackage.getEObject(), null, "elementStatus", null, 1, 1, RecommendationMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationMsg_Results(), this.getRecommendationResult(), null, "results", null, 0, -1, RecommendationMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecommendationMsg_RecomendationInterface(), ecorePackage.getEString(), "recomendationInterface", null, 1, 1, RecommendationMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recommendationResultEClass, RecommendationResult.class, "RecommendationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecommendationResult_Type(), ecorePackage.getEString(), "type", null, 1, 1, RecommendationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationResult_Values(), this.getStringToObject(), null, "values", null, 0, -1, RecommendationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecommendationResult_Raitin(), ecorePackage.getEDouble(), "raitin", null, 1, 1, RecommendationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToObjectEClass, Map.Entry.class, "StringToObject", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToObject_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringToObject_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recommendationEventEClass, RecommendationEvent.class, "RecommendationEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecommendationEvent_Recommendation(), this.getRecommendationMsg(), null, "recommendation", null, 1, 1, RecommendationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationEvent_Selected(), this.getRecommendationResult(), null, "selected", null, 1, 1, RecommendationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecommendationEvent_Commands(), theProjectHistoryPackage.getAction(), null, "commands", null, 0, -1, RecommendationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DroidRecommenderHistoryPackageImpl
