/**
 */
package projectHistory.impl;

import branchDecision.BranchDecisionPackage;
import branchDecision.impl.BranchDecisionPackageImpl;
import droidRecommenderHistory.DroidRecommenderHistoryPackage;
import droidRecommenderHistory.impl.DroidRecommenderHistoryPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import projectHistory.Action;
import projectHistory.Add;
import projectHistory.CreateMsg;
import projectHistory.Delete;
import projectHistory.History;
import projectHistory.InteractionWithActions;
import projectHistory.Msg;
import projectHistory.ProjectHistoryFactory;
import projectHistory.ProjectHistoryPackage;
import projectHistory.Sentence;
import projectHistory.Update;
import projectHistory.UserInteraction;
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
public class ProjectHistoryPackageImpl extends EPackageImpl implements ProjectHistoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createMsgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userInteractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionWithActionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass msgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sentenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateEClass = null;

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
	 * @see projectHistory.ProjectHistoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProjectHistoryPackageImpl() {
		super(eNS_URI, ProjectHistoryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProjectHistoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProjectHistoryPackage init() {
		if (isInited) return (ProjectHistoryPackage)EPackage.Registry.INSTANCE.getEPackage(ProjectHistoryPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProjectHistoryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProjectHistoryPackageImpl theProjectHistoryPackage = registeredProjectHistoryPackage instanceof ProjectHistoryPackageImpl ? (ProjectHistoryPackageImpl)registeredProjectHistoryPackage : new ProjectHistoryPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DroidRecommenderHistoryPackage.eNS_URI);
		DroidRecommenderHistoryPackageImpl theDroidRecommenderHistoryPackage = (DroidRecommenderHistoryPackageImpl)(registeredPackage instanceof DroidRecommenderHistoryPackageImpl ? registeredPackage : DroidRecommenderHistoryPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI);
		SocioProjectsPackageImpl theSocioProjectsPackage = (SocioProjectsPackageImpl)(registeredPackage instanceof SocioProjectsPackageImpl ? registeredPackage : SocioProjectsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI);
		RemoveLogPackageImpl theRemoveLogPackage = (RemoveLogPackageImpl)(registeredPackage instanceof RemoveLogPackageImpl ? registeredPackage : RemoveLogPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BranchDecisionPackage.eNS_URI);
		BranchDecisionPackageImpl theBranchDecisionPackage = (BranchDecisionPackageImpl)(registeredPackage instanceof BranchDecisionPackageImpl ? registeredPackage : BranchDecisionPackage.eINSTANCE);

		// Create package meta-data objects
		theProjectHistoryPackage.createPackageContents();
		theDroidRecommenderHistoryPackage.createPackageContents();
		theSocioProjectsPackage.createPackageContents();
		theRemoveLogPackage.createPackageContents();
		theBranchDecisionPackage.createPackageContents();

		// Initialize created meta-data
		theProjectHistoryPackage.initializePackageContents();
		theDroidRecommenderHistoryPackage.initializePackageContents();
		theSocioProjectsPackage.initializePackageContents();
		theRemoveLogPackage.initializePackageContents();
		theBranchDecisionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProjectHistoryPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProjectHistoryPackage.eNS_URI, theProjectHistoryPackage);
		return theProjectHistoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHistory() {
		return historyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHistory_Msg() {
		return (EReference)historyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHistory_CreateMsg() {
		return (EReference)historyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateMsg() {
		return createMsgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCreateMsg_User() {
		return (EReference)createMsgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCreateMsg_Date() {
		return (EAttribute)createMsgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUserInteraction() {
		return userInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserInteraction_User() {
		return (EReference)userInteractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUserInteraction_Date() {
		return (EAttribute)userInteractionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInteractionWithActions() {
		return interactionWithActionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInteractionWithActions_Undoable() {
		return (EAttribute)interactionWithActionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInteractionWithActions__GetAllActions() {
		return interactionWithActionsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMsg() {
		return msgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMsg_Msg() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMsg_Text() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMsg_Id() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMsg_Sentences() {
		return (EReference)msgEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMsg__GetChannel() {
		return msgEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSentence() {
		return sentenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSentence_Sentence() {
		return (EAttribute)sentenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSentence_Commands() {
		return (EReference)sentenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAction_Element() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__DoIt() {
		return actionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__UndoIt() {
		return actionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__RedoIt() {
		return actionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__IsUndo() {
		return actionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__IsExecute() {
		return actionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__GetActionName() {
		return actionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getAction__GetObject() {
		return actionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAdd() {
		return addEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDelete() {
		return deleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUpdate() {
		return updateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUpdate_Old() {
		return (EReference)updateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUpdate_New() {
		return (EReference)updateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProjectHistoryFactory getProjectHistoryFactory() {
		return (ProjectHistoryFactory)getEFactoryInstance();
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
		historyEClass = createEClass(HISTORY);
		createEReference(historyEClass, HISTORY__MSG);
		createEReference(historyEClass, HISTORY__CREATE_MSG);

		createMsgEClass = createEClass(CREATE_MSG);
		createEReference(createMsgEClass, CREATE_MSG__USER);
		createEAttribute(createMsgEClass, CREATE_MSG__DATE);

		userInteractionEClass = createEClass(USER_INTERACTION);
		createEReference(userInteractionEClass, USER_INTERACTION__USER);
		createEAttribute(userInteractionEClass, USER_INTERACTION__DATE);

		interactionWithActionsEClass = createEClass(INTERACTION_WITH_ACTIONS);
		createEAttribute(interactionWithActionsEClass, INTERACTION_WITH_ACTIONS__UNDOABLE);
		createEOperation(interactionWithActionsEClass, INTERACTION_WITH_ACTIONS___GET_ALL_ACTIONS);

		msgEClass = createEClass(MSG);
		createEAttribute(msgEClass, MSG__MSG);
		createEAttribute(msgEClass, MSG__TEXT);
		createEAttribute(msgEClass, MSG__ID);
		createEReference(msgEClass, MSG__SENTENCES);
		createEOperation(msgEClass, MSG___GET_CHANNEL);

		sentenceEClass = createEClass(SENTENCE);
		createEAttribute(sentenceEClass, SENTENCE__SENTENCE);
		createEReference(sentenceEClass, SENTENCE__COMMANDS);

		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__ELEMENT);
		createEOperation(actionEClass, ACTION___DO_IT);
		createEOperation(actionEClass, ACTION___UNDO_IT);
		createEOperation(actionEClass, ACTION___REDO_IT);
		createEOperation(actionEClass, ACTION___IS_UNDO);
		createEOperation(actionEClass, ACTION___IS_EXECUTE);
		createEOperation(actionEClass, ACTION___GET_ACTION_NAME);
		createEOperation(actionEClass, ACTION___GET_OBJECT);

		addEClass = createEClass(ADD);

		deleteEClass = createEClass(DELETE);

		updateEClass = createEClass(UPDATE);
		createEReference(updateEClass, UPDATE__OLD);
		createEReference(updateEClass, UPDATE__NEW);
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
		interactionWithActionsEClass.getESuperTypes().add(this.getUserInteraction());
		msgEClass.getESuperTypes().add(this.getInteractionWithActions());
		addEClass.getESuperTypes().add(this.getAction());
		deleteEClass.getESuperTypes().add(this.getAction());
		updateEClass.getESuperTypes().add(this.getAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(historyEClass, History.class, "History", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHistory_Msg(), this.getUserInteraction(), null, "msg", null, 0, -1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistory_CreateMsg(), this.getCreateMsg(), null, "createMsg", null, 1, 1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createMsgEClass, CreateMsg.class, "CreateMsg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateMsg_User(), theSocioProjectsPackage.getUser(), null, "user", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateMsg_Date(), ecorePackage.getEDate(), "date", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userInteractionEClass, UserInteraction.class, "UserInteraction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserInteraction_User(), theSocioProjectsPackage.getUser(), null, "user", null, 1, 1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserInteraction_Date(), ecorePackage.getEDate(), "date", null, 1, 1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionWithActionsEClass, InteractionWithActions.class, "InteractionWithActions", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteractionWithActions_Undoable(), ecorePackage.getEBoolean(), "undoable", null, 1, 1, InteractionWithActions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getInteractionWithActions__GetAllActions(), null, "getAllActions", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(msgEClass, Msg.class, "Msg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMsg_Msg(), ecorePackage.getEString(), "msg", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Text(), ecorePackage.getEString(), "text", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Id(), ecorePackage.getEString(), "id", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMsg_Sentences(), this.getSentence(), null, "sentences", null, 1, -1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMsg__GetChannel(), ecorePackage.getEString(), "getChannel", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sentenceEClass, Sentence.class, "Sentence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSentence_Sentence(), ecorePackage.getEString(), "sentence", null, 1, 1, Sentence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSentence_Commands(), this.getAction(), null, "commands", null, 0, -1, Sentence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_Element(), ecorePackage.getEObject(), null, "element", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAction__DoIt(), null, "doIt", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__UndoIt(), null, "undoIt", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__RedoIt(), null, "redoIt", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__IsUndo(), ecorePackage.getEBoolean(), "isUndo", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__IsExecute(), ecorePackage.getEBoolean(), "isExecute", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__GetActionName(), ecorePackage.getEString(), "getActionName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__GetObject(), ecorePackage.getEJavaObject(), "getObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addEClass, Add.class, "Add", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteEClass, Delete.class, "Delete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateEClass, Update.class, "Update", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdate_Old(), ecorePackage.getEObject(), null, "old", null, 1, 1, Update.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUpdate_New(), ecorePackage.getEObject(), null, "new", null, 1, 1, Update.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProjectHistoryPackageImpl
