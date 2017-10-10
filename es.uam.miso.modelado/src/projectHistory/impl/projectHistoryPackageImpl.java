/**
 */
package projectHistory.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import projectHistory.Action;
import projectHistory.Add;
import projectHistory.CreateMsg;
import projectHistory.Delete;
import projectHistory.History;
import projectHistory.Msg;
import projectHistory.Sentence;
import projectHistory.Update;
import projectHistory.projectHistoryFactory;
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
public class projectHistoryPackageImpl extends EPackageImpl implements projectHistoryPackage {
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
	 * @see projectHistory.projectHistoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private projectHistoryPackageImpl() {
		super(eNS_URI, projectHistoryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link projectHistoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static projectHistoryPackage init() {
		if (isInited) return (projectHistoryPackage)EPackage.Registry.INSTANCE.getEPackage(projectHistoryPackage.eNS_URI);

		// Obtain or create and register package
		projectHistoryPackageImpl theprojectHistoryPackage = (projectHistoryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof projectHistoryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new projectHistoryPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SocioProjectsPackageImpl theSocioProjectsPackage = (SocioProjectsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI) instanceof SocioProjectsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI) : SocioProjectsPackage.eINSTANCE);
		RemoveLogPackageImpl theRemoveLogPackage = (RemoveLogPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI) instanceof RemoveLogPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI) : RemoveLogPackage.eINSTANCE);

		// Create package meta-data objects
		theprojectHistoryPackage.createPackageContents();
		theSocioProjectsPackage.createPackageContents();
		theRemoveLogPackage.createPackageContents();

		// Initialize created meta-data
		theprojectHistoryPackage.initializePackageContents();
		theSocioProjectsPackage.initializePackageContents();
		theRemoveLogPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theprojectHistoryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(projectHistoryPackage.eNS_URI, theprojectHistoryPackage);
		return theprojectHistoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistory() {
		return historyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistory_Msg() {
		return (EReference)historyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistory_CreateMsg() {
		return (EReference)historyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateMsg() {
		return createMsgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateMsg_User() {
		return (EReference)createMsgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateMsg_Text() {
		return (EAttribute)createMsgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateMsg_Sentence() {
		return (EAttribute)createMsgEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateMsg_Date() {
		return (EAttribute)createMsgEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateMsg_Id() {
		return (EAttribute)createMsgEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMsg() {
		return msgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMsg_User() {
		return (EReference)msgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMsg_Msg() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMsg_Command() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMsg_Text() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMsg_Date() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMsg_Id() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMsg_Sentences() {
		return (EReference)msgEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMsg_Undoable() {
		return (EAttribute)msgEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMsg__GetChannel() {
		return msgEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSentence() {
		return sentenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSentence_Sentence() {
		return (EAttribute)sentenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSentence_Commands() {
		return (EReference)sentenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Element() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__DoIt() {
		return actionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__UndoIt() {
		return actionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__RedoIt() {
		return actionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__IsUndo() {
		return actionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__IsExecute() {
		return actionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__GetActionName() {
		return actionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__GetObject() {
		return actionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdd() {
		return addEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelete() {
		return deleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdate() {
		return updateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdate_Old() {
		return (EReference)updateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdate_New() {
		return (EReference)updateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public projectHistoryFactory getprojectHistoryFactory() {
		return (projectHistoryFactory)getEFactoryInstance();
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
		createEAttribute(createMsgEClass, CREATE_MSG__TEXT);
		createEAttribute(createMsgEClass, CREATE_MSG__SENTENCE);
		createEAttribute(createMsgEClass, CREATE_MSG__DATE);
		createEAttribute(createMsgEClass, CREATE_MSG__ID);

		msgEClass = createEClass(MSG);
		createEReference(msgEClass, MSG__USER);
		createEAttribute(msgEClass, MSG__MSG);
		createEAttribute(msgEClass, MSG__COMMAND);
		createEAttribute(msgEClass, MSG__TEXT);
		createEAttribute(msgEClass, MSG__DATE);
		createEAttribute(msgEClass, MSG__ID);
		createEReference(msgEClass, MSG__SENTENCES);
		createEAttribute(msgEClass, MSG__UNDOABLE);
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
		addEClass.getESuperTypes().add(this.getAction());
		deleteEClass.getESuperTypes().add(this.getAction());
		updateEClass.getESuperTypes().add(this.getAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(historyEClass, History.class, "History", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHistory_Msg(), this.getMsg(), null, "msg", null, 0, -1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistory_CreateMsg(), this.getCreateMsg(), null, "createMsg", null, 1, 1, History.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createMsgEClass, CreateMsg.class, "CreateMsg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateMsg_User(), theSocioProjectsPackage.getUser(), null, "user", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateMsg_Text(), ecorePackage.getEString(), "text", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateMsg_Sentence(), ecorePackage.getEString(), "sentence", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateMsg_Date(), ecorePackage.getEDate(), "date", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateMsg_Id(), ecorePackage.getEString(), "id", null, 1, 1, CreateMsg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(msgEClass, Msg.class, "Msg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMsg_User(), theSocioProjectsPackage.getUser(), null, "user", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Msg(), ecorePackage.getEString(), "msg", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Command(), ecorePackage.getEString(), "command", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Text(), ecorePackage.getEString(), "text", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Date(), ecorePackage.getEDate(), "date", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Id(), ecorePackage.getEString(), "id", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMsg_Sentences(), this.getSentence(), null, "sentences", null, 1, -1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMsg_Undoable(), ecorePackage.getEBoolean(), "undoable", null, 1, 1, Msg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

} //projectHistoryPackageImpl
