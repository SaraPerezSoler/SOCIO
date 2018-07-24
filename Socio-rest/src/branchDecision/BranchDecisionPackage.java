/**
 */
package branchDecision;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see branchDecision.BranchDecisionFactory
 * @model kind="package"
 * @generated
 */
public interface BranchDecisionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "branchDecision";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "branchDecision";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "branchDecision";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BranchDecisionPackage eINSTANCE = branchDecision.impl.BranchDecisionPackageImpl.init();

	/**
	 * The meta object id for the '{@link branchDecision.impl.DecisionImpl <em>Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.DecisionImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getDecision()
	 * @generated
	 */
	int DECISION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Chosen Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__CHOSEN_BRANCH = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__START = 2;

	/**
	 * The feature id for the '<em><b>Merged Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__MERGED_DATE = 3;

	/**
	 * The number of structural features of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link branchDecision.impl.ConsensusImpl <em>Consensus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.ConsensusImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getConsensus()
	 * @generated
	 */
	int CONSENSUS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__NAME = DECISION__NAME;

	/**
	 * The feature id for the '<em><b>Chosen Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__CHOSEN_BRANCH = DECISION__CHOSEN_BRANCH;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__START = DECISION__START;

	/**
	 * The feature id for the '<em><b>Merged Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__MERGED_DATE = DECISION__MERGED_DATE;

	/**
	 * The feature id for the '<em><b>Consensus Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__CONSENSUS_REQUIRED = DECISION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__ROUNDS = DECISION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Users</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS__USERS = DECISION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Consensus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS_FEATURE_COUNT = DECISION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Consensus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENSUS_OPERATION_COUNT = DECISION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link branchDecision.impl.RoundImpl <em>Round</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.RoundImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getRound()
	 * @generated
	 */
	int ROUND = 2;

	/**
	 * The feature id for the '<em><b>Round Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__ROUND_ID = 0;

	/**
	 * The feature id for the '<em><b>Consensus Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__CONSENSUS_MEASURE = 1;

	/**
	 * The feature id for the '<em><b>User Preferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__USER_PREFERENCES = 2;

	/**
	 * The feature id for the '<em><b>Consensus Order</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__CONSENSUS_ORDER = 3;

	/**
	 * The feature id for the '<em><b>Round Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__ROUND_DATE = 4;

	/**
	 * The number of structural features of the '<em>Round</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Round</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link branchDecision.impl.PreferenceImpl <em>Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.PreferenceImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getPreference()
	 * @generated
	 */
	int PREFERENCE = 3;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__USER = 0;

	/**
	 * The number of structural features of the '<em>Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link branchDecision.impl.PreferenceOrderingImpl <em>Preference Ordering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.PreferenceOrderingImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getPreferenceOrdering()
	 * @generated
	 */
	int PREFERENCE_ORDERING = 4;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_ORDERING__USER = PREFERENCE__USER;

	/**
	 * The feature id for the '<em><b>Order</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_ORDERING__ORDER = PREFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Preference Ordering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_ORDERING_FEATURE_COUNT = PREFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Preference Ordering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_ORDERING_OPERATION_COUNT = PREFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link branchDecision.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.OrderImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 5;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__PROJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__POS = 1;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link branchDecision.impl.AdminChoiceImpl <em>Admin Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see branchDecision.impl.AdminChoiceImpl
	 * @see branchDecision.impl.BranchDecisionPackageImpl#getAdminChoice()
	 * @generated
	 */
	int ADMIN_CHOICE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMIN_CHOICE__NAME = DECISION__NAME;

	/**
	 * The feature id for the '<em><b>Chosen Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMIN_CHOICE__CHOSEN_BRANCH = DECISION__CHOSEN_BRANCH;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMIN_CHOICE__START = DECISION__START;

	/**
	 * The feature id for the '<em><b>Merged Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMIN_CHOICE__MERGED_DATE = DECISION__MERGED_DATE;

	/**
	 * The number of structural features of the '<em>Admin Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMIN_CHOICE_FEATURE_COUNT = DECISION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Admin Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMIN_CHOICE_OPERATION_COUNT = DECISION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link branchDecision.Decision <em>Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision</em>'.
	 * @see branchDecision.Decision
	 * @generated
	 */
	EClass getDecision();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Decision#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see branchDecision.Decision#getName()
	 * @see #getDecision()
	 * @generated
	 */
	EAttribute getDecision_Name();

	/**
	 * Returns the meta object for the reference '{@link branchDecision.Decision#getChosenBranch <em>Chosen Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Chosen Branch</em>'.
	 * @see branchDecision.Decision#getChosenBranch()
	 * @see #getDecision()
	 * @generated
	 */
	EReference getDecision_ChosenBranch();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Decision#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see branchDecision.Decision#getStart()
	 * @see #getDecision()
	 * @generated
	 */
	EAttribute getDecision_Start();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Decision#getMergedDate <em>Merged Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Merged Date</em>'.
	 * @see branchDecision.Decision#getMergedDate()
	 * @see #getDecision()
	 * @generated
	 */
	EAttribute getDecision_MergedDate();

	/**
	 * Returns the meta object for class '{@link branchDecision.Consensus <em>Consensus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consensus</em>'.
	 * @see branchDecision.Consensus
	 * @generated
	 */
	EClass getConsensus();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Consensus#getConsensusRequired <em>Consensus Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consensus Required</em>'.
	 * @see branchDecision.Consensus#getConsensusRequired()
	 * @see #getConsensus()
	 * @generated
	 */
	EAttribute getConsensus_ConsensusRequired();

	/**
	 * Returns the meta object for the containment reference list '{@link branchDecision.Consensus#getRounds <em>Rounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rounds</em>'.
	 * @see branchDecision.Consensus#getRounds()
	 * @see #getConsensus()
	 * @generated
	 */
	EReference getConsensus_Rounds();

	/**
	 * Returns the meta object for the reference list '{@link branchDecision.Consensus#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Users</em>'.
	 * @see branchDecision.Consensus#getUsers()
	 * @see #getConsensus()
	 * @generated
	 */
	EReference getConsensus_Users();

	/**
	 * Returns the meta object for class '{@link branchDecision.Round <em>Round</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round</em>'.
	 * @see branchDecision.Round
	 * @generated
	 */
	EClass getRound();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Round#getRoundId <em>Round Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Round Id</em>'.
	 * @see branchDecision.Round#getRoundId()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_RoundId();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Round#getConsensusMeasure <em>Consensus Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consensus Measure</em>'.
	 * @see branchDecision.Round#getConsensusMeasure()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_ConsensusMeasure();

	/**
	 * Returns the meta object for the containment reference list '{@link branchDecision.Round#getUserPreferences <em>User Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>User Preferences</em>'.
	 * @see branchDecision.Round#getUserPreferences()
	 * @see #getRound()
	 * @generated
	 */
	EReference getRound_UserPreferences();

	/**
	 * Returns the meta object for the containment reference list '{@link branchDecision.Round#getConsensusOrder <em>Consensus Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consensus Order</em>'.
	 * @see branchDecision.Round#getConsensusOrder()
	 * @see #getRound()
	 * @generated
	 */
	EReference getRound_ConsensusOrder();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Round#getRoundDate <em>Round Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Round Date</em>'.
	 * @see branchDecision.Round#getRoundDate()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_RoundDate();

	/**
	 * Returns the meta object for class '{@link branchDecision.Preference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preference</em>'.
	 * @see branchDecision.Preference
	 * @generated
	 */
	EClass getPreference();

	/**
	 * Returns the meta object for the reference '{@link branchDecision.Preference#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see branchDecision.Preference#getUser()
	 * @see #getPreference()
	 * @generated
	 */
	EReference getPreference_User();

	/**
	 * Returns the meta object for class '{@link branchDecision.PreferenceOrdering <em>Preference Ordering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preference Ordering</em>'.
	 * @see branchDecision.PreferenceOrdering
	 * @generated
	 */
	EClass getPreferenceOrdering();

	/**
	 * Returns the meta object for the containment reference list '{@link branchDecision.PreferenceOrdering#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Order</em>'.
	 * @see branchDecision.PreferenceOrdering#getOrder()
	 * @see #getPreferenceOrdering()
	 * @generated
	 */
	EReference getPreferenceOrdering_Order();

	/**
	 * Returns the meta object for class '{@link branchDecision.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see branchDecision.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Order#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see branchDecision.Order#getProjectName()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link branchDecision.Order#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos</em>'.
	 * @see branchDecision.Order#getPos()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Pos();

	/**
	 * Returns the meta object for class '{@link branchDecision.AdminChoice <em>Admin Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Admin Choice</em>'.
	 * @see branchDecision.AdminChoice
	 * @generated
	 */
	EClass getAdminChoice();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BranchDecisionFactory getBranchDecisionFactory();

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
		 * The meta object literal for the '{@link branchDecision.impl.DecisionImpl <em>Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.DecisionImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getDecision()
		 * @generated
		 */
		EClass DECISION = eINSTANCE.getDecision();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION__NAME = eINSTANCE.getDecision_Name();

		/**
		 * The meta object literal for the '<em><b>Chosen Branch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION__CHOSEN_BRANCH = eINSTANCE.getDecision_ChosenBranch();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION__START = eINSTANCE.getDecision_Start();

		/**
		 * The meta object literal for the '<em><b>Merged Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION__MERGED_DATE = eINSTANCE.getDecision_MergedDate();

		/**
		 * The meta object literal for the '{@link branchDecision.impl.ConsensusImpl <em>Consensus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.ConsensusImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getConsensus()
		 * @generated
		 */
		EClass CONSENSUS = eINSTANCE.getConsensus();

		/**
		 * The meta object literal for the '<em><b>Consensus Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSENSUS__CONSENSUS_REQUIRED = eINSTANCE.getConsensus_ConsensusRequired();

		/**
		 * The meta object literal for the '<em><b>Rounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENSUS__ROUNDS = eINSTANCE.getConsensus_Rounds();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENSUS__USERS = eINSTANCE.getConsensus_Users();

		/**
		 * The meta object literal for the '{@link branchDecision.impl.RoundImpl <em>Round</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.RoundImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getRound()
		 * @generated
		 */
		EClass ROUND = eINSTANCE.getRound();

		/**
		 * The meta object literal for the '<em><b>Round Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__ROUND_ID = eINSTANCE.getRound_RoundId();

		/**
		 * The meta object literal for the '<em><b>Consensus Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__CONSENSUS_MEASURE = eINSTANCE.getRound_ConsensusMeasure();

		/**
		 * The meta object literal for the '<em><b>User Preferences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND__USER_PREFERENCES = eINSTANCE.getRound_UserPreferences();

		/**
		 * The meta object literal for the '<em><b>Consensus Order</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND__CONSENSUS_ORDER = eINSTANCE.getRound_ConsensusOrder();

		/**
		 * The meta object literal for the '<em><b>Round Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__ROUND_DATE = eINSTANCE.getRound_RoundDate();

		/**
		 * The meta object literal for the '{@link branchDecision.impl.PreferenceImpl <em>Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.PreferenceImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getPreference()
		 * @generated
		 */
		EClass PREFERENCE = eINSTANCE.getPreference();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCE__USER = eINSTANCE.getPreference_User();

		/**
		 * The meta object literal for the '{@link branchDecision.impl.PreferenceOrderingImpl <em>Preference Ordering</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.PreferenceOrderingImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getPreferenceOrdering()
		 * @generated
		 */
		EClass PREFERENCE_ORDERING = eINSTANCE.getPreferenceOrdering();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCE_ORDERING__ORDER = eINSTANCE.getPreferenceOrdering_Order();

		/**
		 * The meta object literal for the '{@link branchDecision.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.OrderImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__PROJECT_NAME = eINSTANCE.getOrder_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__POS = eINSTANCE.getOrder_Pos();

		/**
		 * The meta object literal for the '{@link branchDecision.impl.AdminChoiceImpl <em>Admin Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see branchDecision.impl.AdminChoiceImpl
		 * @see branchDecision.impl.BranchDecisionPackageImpl#getAdminChoice()
		 * @generated
		 */
		EClass ADMIN_CHOICE = eINSTANCE.getAdminChoice();

	}

} //BranchDecisionPackage
