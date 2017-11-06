/**
 */
package branchDecision.impl;

import branchDecision.AdminChoice;
import branchDecision.BranchDecisionFactory;
import branchDecision.BranchDecisionPackage;
import branchDecision.Consensus;
import branchDecision.Decision;
import branchDecision.Order;
import branchDecision.Preference;
import branchDecision.PreferenceOrdering;
import branchDecision.Round;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import projectHistory.impl.projectHistoryPackageImpl;

import projectHistory.projectHistoryPackage;

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
public class BranchDecisionPackageImpl extends EPackageImpl implements BranchDecisionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consensusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferenceOrderingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adminChoiceEClass = null;

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
	 * @see branchDecision.BranchDecisionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BranchDecisionPackageImpl() {
		super(eNS_URI, BranchDecisionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BranchDecisionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BranchDecisionPackage init() {
		if (isInited) return (BranchDecisionPackage)EPackage.Registry.INSTANCE.getEPackage(BranchDecisionPackage.eNS_URI);

		// Obtain or create and register package
		BranchDecisionPackageImpl theBranchDecisionPackage = (BranchDecisionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BranchDecisionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BranchDecisionPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SocioProjectsPackageImpl theSocioProjectsPackage = (SocioProjectsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI) instanceof SocioProjectsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI) : SocioProjectsPackage.eINSTANCE);
		projectHistoryPackageImpl theprojectHistoryPackage = (projectHistoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(projectHistoryPackage.eNS_URI) instanceof projectHistoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(projectHistoryPackage.eNS_URI) : projectHistoryPackage.eINSTANCE);
		RemoveLogPackageImpl theRemoveLogPackage = (RemoveLogPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI) instanceof RemoveLogPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI) : RemoveLogPackage.eINSTANCE);

		// Create package meta-data objects
		theBranchDecisionPackage.createPackageContents();
		theSocioProjectsPackage.createPackageContents();
		theprojectHistoryPackage.createPackageContents();
		theRemoveLogPackage.createPackageContents();

		// Initialize created meta-data
		theBranchDecisionPackage.initializePackageContents();
		theSocioProjectsPackage.initializePackageContents();
		theprojectHistoryPackage.initializePackageContents();
		theRemoveLogPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBranchDecisionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BranchDecisionPackage.eNS_URI, theBranchDecisionPackage);
		return theBranchDecisionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecision() {
		return decisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecision_Name() {
		return (EAttribute)decisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecision_Branchs() {
		return (EReference)decisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecision_ChosenBranch() {
		return (EReference)decisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConsensus() {
		return consensusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsensus_ConsensusRequired() {
		return (EAttribute)consensusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsensus_PreferencesRound() {
		return (EReference)consensusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsensus_Users() {
		return (EReference)consensusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRound() {
		return roundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRound_RoundId() {
		return (EAttribute)roundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRound_ConsensusMeasure() {
		return (EAttribute)roundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRound_UserPreferences() {
		return (EReference)roundEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRound_ConsensusOrder() {
		return (EReference)roundEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreference() {
		return preferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreference_User() {
		return (EReference)preferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreferenceOrdering() {
		return preferenceOrderingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrder() {
		return orderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_ProjectName() {
		return (EAttribute)orderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_Pos() {
		return (EAttribute)orderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdminChoice() {
		return adminChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchDecisionFactory getBranchDecisionFactory() {
		return (BranchDecisionFactory)getEFactoryInstance();
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
		decisionEClass = createEClass(DECISION);
		createEAttribute(decisionEClass, DECISION__NAME);
		createEReference(decisionEClass, DECISION__BRANCHS);
		createEReference(decisionEClass, DECISION__CHOSEN_BRANCH);

		consensusEClass = createEClass(CONSENSUS);
		createEAttribute(consensusEClass, CONSENSUS__CONSENSUS_REQUIRED);
		createEReference(consensusEClass, CONSENSUS__PREFERENCES_ROUND);
		createEReference(consensusEClass, CONSENSUS__USERS);

		roundEClass = createEClass(ROUND);
		createEAttribute(roundEClass, ROUND__ROUND_ID);
		createEAttribute(roundEClass, ROUND__CONSENSUS_MEASURE);
		createEReference(roundEClass, ROUND__USER_PREFERENCES);
		createEReference(roundEClass, ROUND__CONSENSUS_ORDER);

		preferenceEClass = createEClass(PREFERENCE);
		createEReference(preferenceEClass, PREFERENCE__USER);

		preferenceOrderingEClass = createEClass(PREFERENCE_ORDERING);

		orderEClass = createEClass(ORDER);
		createEAttribute(orderEClass, ORDER__PROJECT_NAME);
		createEAttribute(orderEClass, ORDER__POS);

		adminChoiceEClass = createEClass(ADMIN_CHOICE);
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
		SocioProjectsPackage theSocioProjectsPackage = (SocioProjectsPackage)EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		consensusEClass.getESuperTypes().add(this.getDecision());
		preferenceOrderingEClass.getESuperTypes().add(this.getPreference());
		adminChoiceEClass.getESuperTypes().add(this.getDecision());

		// Initialize classes, features, and operations; add parameters
		initEClass(decisionEClass, Decision.class, "Decision", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecision_Name(), ecorePackage.getEString(), "name", null, 1, 1, Decision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDecision_Branchs(), theSocioProjectsPackage.getProject(), null, "branchs", null, 1, -1, Decision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDecision_ChosenBranch(), theSocioProjectsPackage.getProject(), null, "chosenBranch", null, 0, 1, Decision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consensusEClass, Consensus.class, "Consensus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConsensus_ConsensusRequired(), ecorePackage.getEDouble(), "consensusRequired", "0.75", 1, 1, Consensus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsensus_PreferencesRound(), this.getRound(), null, "preferencesRound", null, 1, -1, Consensus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsensus_Users(), theSocioProjectsPackage.getUser(), null, "users", null, 2, -1, Consensus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roundEClass, Round.class, "Round", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRound_RoundId(), ecorePackage.getEInt(), "roundId", null, 1, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRound_ConsensusMeasure(), ecorePackage.getEDouble(), "consensusMeasure", null, 0, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRound_UserPreferences(), this.getPreference(), null, "userPreferences", null, 0, -1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRound_ConsensusOrder(), this.getOrder(), null, "consensusOrder", null, 1, -1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferenceEClass, Preference.class, "Preference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreference_User(), theSocioProjectsPackage.getUser(), null, "user", null, 1, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferenceOrderingEClass, PreferenceOrdering.class, "PreferenceOrdering", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orderEClass, Order.class, "Order", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrder_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrder_Pos(), ecorePackage.getEInt(), "pos", null, 1, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adminChoiceEClass, AdminChoice.class, "AdminChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BranchDecisionPackageImpl
