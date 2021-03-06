/**
 */
package socioProjects.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.impl.BranchDecisionPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import projectHistory.ProjectHistoryPackage;
import projectHistory.impl.ProjectHistoryPackageImpl;
import removeLog.RemoveLogPackage;

import removeLog.impl.RemoveLogPackageImpl;

import socioProjects.Access;
import socioProjects.BranchGroup;
import socioProjects.Contribution;
import socioProjects.GroupStatus;
import socioProjects.MetamodelProject;
import socioProjects.ModelProject;
import socioProjects.Project;
import socioProjects.SocioApp;
import socioProjects.SocioProjectsFactory;
import socioProjects.SocioProjectsPackage;
import socioProjects.User;
import socioProjects.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SocioProjectsPackageImpl extends EPackageImpl implements SocioProjectsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass socioAppEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum groupStatusEEnum = null;

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
	 * @see socioProjects.SocioProjectsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SocioProjectsPackageImpl() {
		super(eNS_URI, SocioProjectsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SocioProjectsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SocioProjectsPackage init() {
		if (isInited) return (SocioProjectsPackage)EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI);

		// Obtain or create and register package
		SocioProjectsPackageImpl theSocioProjectsPackage = (SocioProjectsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SocioProjectsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SocioProjectsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ProjectHistoryPackageImpl theProjectHistoryPackage = (ProjectHistoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProjectHistoryPackage.eNS_URI) instanceof ProjectHistoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProjectHistoryPackage.eNS_URI) : ProjectHistoryPackage.eINSTANCE);
		RemoveLogPackageImpl theRemoveLogPackage = (RemoveLogPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI) instanceof RemoveLogPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI) : RemoveLogPackage.eINSTANCE);
		BranchDecisionPackageImpl theBranchDecisionPackage = (BranchDecisionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BranchDecisionPackage.eNS_URI) instanceof BranchDecisionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BranchDecisionPackage.eNS_URI) : BranchDecisionPackage.eINSTANCE);

		// Create package meta-data objects
		theSocioProjectsPackage.createPackageContents();
		theProjectHistoryPackage.createPackageContents();
		theRemoveLogPackage.createPackageContents();
		theBranchDecisionPackage.createPackageContents();

		// Initialize created meta-data
		theSocioProjectsPackage.initializePackageContents();
		theProjectHistoryPackage.initializePackageContents();
		theRemoveLogPackage.initializePackageContents();
		theBranchDecisionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSocioProjectsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SocioProjectsPackage.eNS_URI, theSocioProjectsPackage);
		return theSocioProjectsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSocioApp() {
		return socioAppEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSocioApp_Users() {
		return (EReference)socioAppEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSocioApp_Projects() {
		return (EReference)socioAppEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Id() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Open() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_History() {
		return (EReference)projectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Remove() {
		return (EReference)projectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Model() {
		return (EReference)projectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Visibility() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Admin() {
		return (EReference)projectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_BranchIsLocking() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_BranchGroup() {
		return (EReference)projectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Branch() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Branchs() {
		return (EReference)projectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetPath() {
		return projectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__ParseSentence__String() {
		return projectEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__Execute__Msg() {
		return projectEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__Undo() {
		return projectEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__Redo() {
		return projectEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetHistoryMsg() {
		return projectEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetHistoryMsg__Date_int() {
		return projectEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetHistoryMsg__Date_Date_int() {
		return projectEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetHistoryForUser__User() {
		return projectEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetHistoryForElement__String() {
		return projectEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetHistoryForAction__String() {
		return projectEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsUserMsg() {
		return projectEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsUserMsg__User() {
		return projectEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsUserAction() {
		return projectEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsUserAction__User() {
		return projectEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsUserMsgAbs() {
		return projectEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsUserActionAbs() {
		return projectEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__GetStatisticsActions() {
		return projectEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__PercentOfAuthorship() {
		return projectEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProject__Validate() {
		return projectEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelProject() {
		return modelProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelProject_MetamodelName() {
		return (EAttribute)modelProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelProject__ParseSentence__String() {
		return modelProjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodelProject() {
		return metamodelProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetamodelProject__ParseSentence__String() {
		return metamodelProjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Name() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Nick() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Id() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Channel() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_OwnProjects() {
		return (EReference)userEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Contributions() {
		return (EReference)userEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__CanEdit__Project() {
		return userEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__CanRead__Project() {
		return userEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__IsAdmin__Project() {
		return userEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__RemoveContribution__Project() {
		return userEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__AddContribution__Project_Access() {
		return userEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__AddProject__Project() {
		return userEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__GetContribution__Project() {
		return userEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUser__IsRoot() {
		return userEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContribution() {
		return contributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Access() {
		return (EAttribute)contributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_Project() {
		return (EReference)contributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchGroup() {
		return branchGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranchGroup_Name() {
		return (EAttribute)branchGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranchGroup_CreateAt() {
		return (EAttribute)branchGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranchGroup_Status() {
		return (EAttribute)branchGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchGroup_Father() {
		return (EReference)branchGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchGroup_Decision() {
		return (EReference)branchGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchGroup_Branchs() {
		return (EReference)branchGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccess() {
		return accessEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGroupStatus() {
		return groupStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocioProjectsFactory getSocioProjectsFactory() {
		return (SocioProjectsFactory)getEFactoryInstance();
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
		socioAppEClass = createEClass(SOCIO_APP);
		createEReference(socioAppEClass, SOCIO_APP__USERS);
		createEReference(socioAppEClass, SOCIO_APP__PROJECTS);

		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEAttribute(projectEClass, PROJECT__ID);
		createEAttribute(projectEClass, PROJECT__OPEN);
		createEReference(projectEClass, PROJECT__HISTORY);
		createEReference(projectEClass, PROJECT__REMOVE);
		createEReference(projectEClass, PROJECT__MODEL);
		createEAttribute(projectEClass, PROJECT__VISIBILITY);
		createEReference(projectEClass, PROJECT__ADMIN);
		createEAttribute(projectEClass, PROJECT__BRANCH_IS_LOCKING);
		createEAttribute(projectEClass, PROJECT__BRANCH);
		createEReference(projectEClass, PROJECT__BRANCHS);
		createEReference(projectEClass, PROJECT__BRANCH_GROUP);
		createEOperation(projectEClass, PROJECT___GET_PATH);
		createEOperation(projectEClass, PROJECT___PARSE_SENTENCE__STRING);
		createEOperation(projectEClass, PROJECT___EXECUTE__MSG);
		createEOperation(projectEClass, PROJECT___UNDO);
		createEOperation(projectEClass, PROJECT___REDO);
		createEOperation(projectEClass, PROJECT___GET_HISTORY_MSG);
		createEOperation(projectEClass, PROJECT___GET_HISTORY_MSG__DATE_INT);
		createEOperation(projectEClass, PROJECT___GET_HISTORY_MSG__DATE_DATE_INT);
		createEOperation(projectEClass, PROJECT___GET_HISTORY_FOR_USER__USER);
		createEOperation(projectEClass, PROJECT___GET_HISTORY_FOR_ELEMENT__STRING);
		createEOperation(projectEClass, PROJECT___GET_HISTORY_FOR_ACTION__STRING);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_USER_MSG);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_USER_MSG__USER);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_USER_ACTION);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_USER_ACTION__USER);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_USER_MSG_ABS);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_USER_ACTION_ABS);
		createEOperation(projectEClass, PROJECT___GET_STATISTICS_ACTIONS);
		createEOperation(projectEClass, PROJECT___PERCENT_OF_AUTHORSHIP);
		createEOperation(projectEClass, PROJECT___VALIDATE);

		modelProjectEClass = createEClass(MODEL_PROJECT);
		createEAttribute(modelProjectEClass, MODEL_PROJECT__METAMODEL_NAME);
		createEOperation(modelProjectEClass, MODEL_PROJECT___PARSE_SENTENCE__STRING);

		metamodelProjectEClass = createEClass(METAMODEL_PROJECT);
		createEOperation(metamodelProjectEClass, METAMODEL_PROJECT___PARSE_SENTENCE__STRING);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__NAME);
		createEAttribute(userEClass, USER__NICK);
		createEAttribute(userEClass, USER__ID);
		createEAttribute(userEClass, USER__CHANNEL);
		createEReference(userEClass, USER__OWN_PROJECTS);
		createEReference(userEClass, USER__CONTRIBUTIONS);
		createEOperation(userEClass, USER___CAN_EDIT__PROJECT);
		createEOperation(userEClass, USER___CAN_READ__PROJECT);
		createEOperation(userEClass, USER___IS_ADMIN__PROJECT);
		createEOperation(userEClass, USER___REMOVE_CONTRIBUTION__PROJECT);
		createEOperation(userEClass, USER___ADD_CONTRIBUTION__PROJECT_ACCESS);
		createEOperation(userEClass, USER___ADD_PROJECT__PROJECT);
		createEOperation(userEClass, USER___GET_CONTRIBUTION__PROJECT);
		createEOperation(userEClass, USER___IS_ROOT);

		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__ACCESS);
		createEReference(contributionEClass, CONTRIBUTION__PROJECT);

		branchGroupEClass = createEClass(BRANCH_GROUP);
		createEAttribute(branchGroupEClass, BRANCH_GROUP__NAME);
		createEAttribute(branchGroupEClass, BRANCH_GROUP__CREATE_AT);
		createEAttribute(branchGroupEClass, BRANCH_GROUP__STATUS);
		createEReference(branchGroupEClass, BRANCH_GROUP__FATHER);
		createEReference(branchGroupEClass, BRANCH_GROUP__DECISION);
		createEReference(branchGroupEClass, BRANCH_GROUP__BRANCHS);

		// Create enums
		accessEEnum = createEEnum(ACCESS);
		visibilityEEnum = createEEnum(VISIBILITY);
		groupStatusEEnum = createEEnum(GROUP_STATUS);
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
		RemoveLogPackage theRemoveLogPackage = (RemoveLogPackage)EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI);
		BranchDecisionPackage theBranchDecisionPackage = (BranchDecisionPackage)EPackage.Registry.INSTANCE.getEPackage(BranchDecisionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelProjectEClass.getESuperTypes().add(this.getProject());
		metamodelProjectEClass.getESuperTypes().add(this.getProject());

		// Initialize classes, features, and operations; add parameters
		initEClass(socioAppEClass, SocioApp.class, "SocioApp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSocioApp_Users(), this.getUser(), null, "users", null, 0, -1, SocioApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSocioApp_Projects(), this.getProject(), null, "projects", null, 0, -1, SocioApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectEClass, Project.class, "Project", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Id(), ecorePackage.getELong(), "id", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Open(), ecorePackage.getEBoolean(), "open", "true", 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_History(), theProjectHistoryPackage.getHistory(), null, "history", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Remove(), theRemoveLogPackage.getRoot(), null, "remove", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Model(), ecorePackage.getEObject(), null, "model", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Visibility(), this.getVisibility(), "visibility", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Admin(), this.getUser(), this.getUser_OwnProjects(), "admin", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_BranchIsLocking(), ecorePackage.getEBoolean(), "branchIsLocking", "true", 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Branch(), ecorePackage.getEBoolean(), "branch", "false", 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Branchs(), this.getBranchGroup(), this.getBranchGroup_Father(), "branchs", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_BranchGroup(), this.getBranchGroup(), this.getBranchGroup_Branchs(), "branchGroup", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getProject__GetPath(), ecorePackage.getEString(), "getPath", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getProject__ParseSentence__String(), theProjectHistoryPackage.getAction(), "parseSentence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sentence", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__Execute__Msg(), null, "execute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theProjectHistoryPackage.getMsg(), "msg", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__Undo(), null, "undo", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__Redo(), null, "redo", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__GetHistoryMsg(), theProjectHistoryPackage.getMsg(), "getHistoryMsg", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetHistoryMsg__Date_int(), theProjectHistoryPackage.getMsg(), "getHistoryMsg", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "date", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "order", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetHistoryMsg__Date_Date_int(), theProjectHistoryPackage.getMsg(), "getHistoryMsg", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "start", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "end", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "order", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetHistoryForUser__User(), theProjectHistoryPackage.getMsg(), "getHistoryForUser", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetHistoryForElement__String(), theProjectHistoryPackage.getMsg(), "getHistoryForElement", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "element", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetHistoryForAction__String(), theProjectHistoryPackage.getMsg(), "getHistoryForAction", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__GetStatisticsUserMsg(), null, "getStatisticsUserMsg", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetStatisticsUserMsg__User(), null, "getStatisticsUserMsg", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__GetStatisticsUserAction(), null, "getStatisticsUserAction", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProject__GetStatisticsUserAction__User(), null, "getStatisticsUserAction", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__GetStatisticsUserMsgAbs(), null, "getStatisticsUserMsgAbs", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__GetStatisticsUserActionAbs(), null, "getStatisticsUserActionAbs", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__GetStatisticsActions(), null, "getStatisticsActions", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__PercentOfAuthorship(), null, "percentOfAuthorship", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProject__Validate(), ecorePackage.getEString(), "validate", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelProjectEClass, ModelProject.class, "ModelProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelProject_MetamodelName(), ecorePackage.getEString(), "metamodelName", null, 1, 1, ModelProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getModelProject__ParseSentence__String(), theProjectHistoryPackage.getAction(), "parseSentence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sentence", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(metamodelProjectEClass, MetamodelProject.class, "MetamodelProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getMetamodelProject__ParseSentence__String(), theProjectHistoryPackage.getAction(), "parseSentence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sentence", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_Name(), ecorePackage.getEString(), "name", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Nick(), ecorePackage.getEString(), "nick", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Id(), ecorePackage.getELong(), "id", "-1", 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Channel(), ecorePackage.getEString(), "channel", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_OwnProjects(), this.getProject(), this.getProject_Admin(), "ownProjects", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Contributions(), this.getContribution(), null, "contributions", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getUser__CanEdit__Project(), ecorePackage.getEBoolean(), "canEdit", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUser__CanRead__Project(), ecorePackage.getEBoolean(), "canRead", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUser__IsAdmin__Project(), ecorePackage.getEBoolean(), "isAdmin", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUser__RemoveContribution__Project(), null, "removeContribution", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUser__AddContribution__Project_Access(), null, "addContribution", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAccess(), "access", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUser__AddProject__Project(), null, "addProject", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUser__GetContribution__Project(), this.getContribution(), "getContribution", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProject(), "project", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getUser__IsRoot(), ecorePackage.getEBoolean(), "isRoot", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Access(), this.getAccess(), "access", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_Project(), this.getProject(), null, "project", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(branchGroupEClass, BranchGroup.class, "BranchGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBranchGroup_Name(), ecorePackage.getEString(), "name", null, 1, 1, BranchGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBranchGroup_CreateAt(), ecorePackage.getEDate(), "createAt", null, 1, 1, BranchGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBranchGroup_Status(), this.getGroupStatus(), "status", "OPEN", 1, 1, BranchGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchGroup_Father(), this.getProject(), this.getProject_Branchs(), "father", null, 1, 1, BranchGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchGroup_Decision(), theBranchDecisionPackage.getDecision(), null, "decision", null, 0, 1, BranchGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchGroup_Branchs(), this.getProject(), this.getProject_BranchGroup(), "branchs", null, 0, -1, BranchGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accessEEnum, Access.class, "Access");
		addEEnumLiteral(accessEEnum, Access.EDIT);
		addEEnumLiteral(accessEEnum, Access.READ);

		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);
		addEEnumLiteral(visibilityEEnum, Visibility.PROTECTED);
		addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);

		initEEnum(groupStatusEEnum, GroupStatus.class, "GroupStatus");
		addEEnumLiteral(groupStatusEEnum, GroupStatus.OPEN);
		addEEnumLiteral(groupStatusEEnum, GroupStatus.CLOSE);
		addEEnumLiteral(groupStatusEEnum, GroupStatus.MERGED);

		// Create resource
		createResource(eNS_URI);
	}

} //SocioProjectsPackageImpl
