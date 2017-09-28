/**
 */
package projectHistory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see projectHistory.projectHistoryFactory
 * @model kind="package"
 * @generated
 */
public interface projectHistoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "projectHistory";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "projectHistory";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "projectHistory";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	projectHistoryPackage eINSTANCE = projectHistory.impl.projectHistoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link projectHistory.impl.HistoryImpl <em>History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.HistoryImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getHistory()
	 * @generated
	 */
	int HISTORY = 0;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__MSG = 0;

	/**
	 * The feature id for the '<em><b>Create Msg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__CREATE_MSG = 1;

	/**
	 * The number of structural features of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link projectHistory.impl.CreateMsgImpl <em>Create Msg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.CreateMsgImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getCreateMsg()
	 * @generated
	 */
	int CREATE_MSG = 1;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG__USER = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG__TEXT = 1;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG__SENTENCE = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG__DATE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG__ID = 4;

	/**
	 * The number of structural features of the '<em>Create Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Create Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_MSG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link projectHistory.impl.MsgImpl <em>Msg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.MsgImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getMsg()
	 * @generated
	 */
	int MSG = 2;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__USER = 0;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__MSG = 1;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__COMMAND = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__TEXT = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__DATE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__ID = 5;

	/**
	 * The feature id for the '<em><b>Sentences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__SENTENCES = 6;

	/**
	 * The feature id for the '<em><b>Undoable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG__UNDOABLE = 7;

	/**
	 * The number of structural features of the '<em>Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG___GET_CHANNEL = 0;

	/**
	 * The number of operations of the '<em>Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSG_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link projectHistory.impl.SentenceImpl <em>Sentence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.SentenceImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getSentence()
	 * @generated
	 */
	int SENTENCE = 3;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__SENTENCE = 0;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__COMMANDS = 1;

	/**
	 * The number of structural features of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link projectHistory.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.ActionImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 4;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Do It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___DO_IT = 0;

	/**
	 * The operation id for the '<em>Undo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___UNDO_IT = 1;

	/**
	 * The operation id for the '<em>Redo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___REDO_IT = 2;

	/**
	 * The operation id for the '<em>Is Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___IS_UNDO = 3;

	/**
	 * The operation id for the '<em>Is Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___IS_EXECUTE = 4;

	/**
	 * The operation id for the '<em>Get Action Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___GET_ACTION_NAME = 5;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___GET_OBJECT = 6;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 7;

	/**
	 * The meta object id for the '{@link projectHistory.impl.AddImpl <em>Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.AddImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getAdd()
	 * @generated
	 */
	int ADD = 5;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__ELEMENT = ACTION__ELEMENT;

	/**
	 * The number of structural features of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Do It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___DO_IT = ACTION___DO_IT;

	/**
	 * The operation id for the '<em>Undo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___UNDO_IT = ACTION___UNDO_IT;

	/**
	 * The operation id for the '<em>Redo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___REDO_IT = ACTION___REDO_IT;

	/**
	 * The operation id for the '<em>Is Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___IS_UNDO = ACTION___IS_UNDO;

	/**
	 * The operation id for the '<em>Is Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___IS_EXECUTE = ACTION___IS_EXECUTE;

	/**
	 * The operation id for the '<em>Get Action Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___GET_ACTION_NAME = ACTION___GET_ACTION_NAME;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD___GET_OBJECT = ACTION___GET_OBJECT;

	/**
	 * The number of operations of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link projectHistory.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.DeleteImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 6;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__ELEMENT = ACTION__ELEMENT;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Do It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___DO_IT = ACTION___DO_IT;

	/**
	 * The operation id for the '<em>Undo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___UNDO_IT = ACTION___UNDO_IT;

	/**
	 * The operation id for the '<em>Redo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___REDO_IT = ACTION___REDO_IT;

	/**
	 * The operation id for the '<em>Is Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___IS_UNDO = ACTION___IS_UNDO;

	/**
	 * The operation id for the '<em>Is Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___IS_EXECUTE = ACTION___IS_EXECUTE;

	/**
	 * The operation id for the '<em>Get Action Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___GET_ACTION_NAME = ACTION___GET_ACTION_NAME;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE___GET_OBJECT = ACTION___GET_OBJECT;

	/**
	 * The number of operations of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link projectHistory.impl.UpdateImpl <em>Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see projectHistory.impl.UpdateImpl
	 * @see projectHistory.impl.projectHistoryPackageImpl#getUpdate()
	 * @generated
	 */
	int UPDATE = 7;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE__ELEMENT = ACTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>Old</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE__OLD = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE__NEW = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Do It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___DO_IT = ACTION___DO_IT;

	/**
	 * The operation id for the '<em>Undo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___UNDO_IT = ACTION___UNDO_IT;

	/**
	 * The operation id for the '<em>Redo It</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___REDO_IT = ACTION___REDO_IT;

	/**
	 * The operation id for the '<em>Is Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___IS_UNDO = ACTION___IS_UNDO;

	/**
	 * The operation id for the '<em>Is Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___IS_EXECUTE = ACTION___IS_EXECUTE;

	/**
	 * The operation id for the '<em>Get Action Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___GET_ACTION_NAME = ACTION___GET_ACTION_NAME;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE___GET_OBJECT = ACTION___GET_OBJECT;

	/**
	 * The number of operations of the '<em>Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link projectHistory.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History</em>'.
	 * @see projectHistory.History
	 * @generated
	 */
	EClass getHistory();

	/**
	 * Returns the meta object for the containment reference list '{@link projectHistory.History#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Msg</em>'.
	 * @see projectHistory.History#getMsg()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_Msg();

	/**
	 * Returns the meta object for the reference '{@link projectHistory.History#getCreateMsg <em>Create Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Create Msg</em>'.
	 * @see projectHistory.History#getCreateMsg()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_CreateMsg();

	/**
	 * Returns the meta object for class '{@link projectHistory.CreateMsg <em>Create Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Msg</em>'.
	 * @see projectHistory.CreateMsg
	 * @generated
	 */
	EClass getCreateMsg();

	/**
	 * Returns the meta object for the reference '{@link projectHistory.CreateMsg#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see projectHistory.CreateMsg#getUser()
	 * @see #getCreateMsg()
	 * @generated
	 */
	EReference getCreateMsg_User();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.CreateMsg#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see projectHistory.CreateMsg#getText()
	 * @see #getCreateMsg()
	 * @generated
	 */
	EAttribute getCreateMsg_Text();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.CreateMsg#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sentence</em>'.
	 * @see projectHistory.CreateMsg#getSentence()
	 * @see #getCreateMsg()
	 * @generated
	 */
	EAttribute getCreateMsg_Sentence();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.CreateMsg#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see projectHistory.CreateMsg#getDate()
	 * @see #getCreateMsg()
	 * @generated
	 */
	EAttribute getCreateMsg_Date();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.CreateMsg#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see projectHistory.CreateMsg#getId()
	 * @see #getCreateMsg()
	 * @generated
	 */
	EAttribute getCreateMsg_Id();

	/**
	 * Returns the meta object for class '{@link projectHistory.Msg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Msg</em>'.
	 * @see projectHistory.Msg
	 * @generated
	 */
	EClass getMsg();

	/**
	 * Returns the meta object for the reference '{@link projectHistory.Msg#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see projectHistory.Msg#getUser()
	 * @see #getMsg()
	 * @generated
	 */
	EReference getMsg_User();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Msg#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msg</em>'.
	 * @see projectHistory.Msg#getMsg()
	 * @see #getMsg()
	 * @generated
	 */
	EAttribute getMsg_Msg();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Msg#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see projectHistory.Msg#getCommand()
	 * @see #getMsg()
	 * @generated
	 */
	EAttribute getMsg_Command();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Msg#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see projectHistory.Msg#getText()
	 * @see #getMsg()
	 * @generated
	 */
	EAttribute getMsg_Text();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Msg#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see projectHistory.Msg#getDate()
	 * @see #getMsg()
	 * @generated
	 */
	EAttribute getMsg_Date();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Msg#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see projectHistory.Msg#getId()
	 * @see #getMsg()
	 * @generated
	 */
	EAttribute getMsg_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link projectHistory.Msg#getSentences <em>Sentences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sentences</em>'.
	 * @see projectHistory.Msg#getSentences()
	 * @see #getMsg()
	 * @generated
	 */
	EReference getMsg_Sentences();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Msg#isUndoable <em>Undoable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Undoable</em>'.
	 * @see projectHistory.Msg#isUndoable()
	 * @see #getMsg()
	 * @generated
	 */
	EAttribute getMsg_Undoable();

	/**
	 * Returns the meta object for the '{@link projectHistory.Msg#getChannel() <em>Get Channel</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Channel</em>' operation.
	 * @see projectHistory.Msg#getChannel()
	 * @generated
	 */
	EOperation getMsg__GetChannel();

	/**
	 * Returns the meta object for class '{@link projectHistory.Sentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence</em>'.
	 * @see projectHistory.Sentence
	 * @generated
	 */
	EClass getSentence();

	/**
	 * Returns the meta object for the attribute '{@link projectHistory.Sentence#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sentence</em>'.
	 * @see projectHistory.Sentence#getSentence()
	 * @see #getSentence()
	 * @generated
	 */
	EAttribute getSentence_Sentence();

	/**
	 * Returns the meta object for the containment reference list '{@link projectHistory.Sentence#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see projectHistory.Sentence#getCommands()
	 * @see #getSentence()
	 * @generated
	 */
	EReference getSentence_Commands();

	/**
	 * Returns the meta object for class '{@link projectHistory.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see projectHistory.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the reference '{@link projectHistory.Action#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see projectHistory.Action#getElement()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Element();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#doIt() <em>Do It</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Do It</em>' operation.
	 * @see projectHistory.Action#doIt()
	 * @generated
	 */
	EOperation getAction__DoIt();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#undoIt() <em>Undo It</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo It</em>' operation.
	 * @see projectHistory.Action#undoIt()
	 * @generated
	 */
	EOperation getAction__UndoIt();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#redoIt() <em>Redo It</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Redo It</em>' operation.
	 * @see projectHistory.Action#redoIt()
	 * @generated
	 */
	EOperation getAction__RedoIt();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#isUndo() <em>Is Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Undo</em>' operation.
	 * @see projectHistory.Action#isUndo()
	 * @generated
	 */
	EOperation getAction__IsUndo();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#isExecute() <em>Is Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Execute</em>' operation.
	 * @see projectHistory.Action#isExecute()
	 * @generated
	 */
	EOperation getAction__IsExecute();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#getActionName() <em>Get Action Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Action Name</em>' operation.
	 * @see projectHistory.Action#getActionName()
	 * @generated
	 */
	EOperation getAction__GetActionName();

	/**
	 * Returns the meta object for the '{@link projectHistory.Action#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see projectHistory.Action#getObject()
	 * @generated
	 */
	EOperation getAction__GetObject();

	/**
	 * Returns the meta object for class '{@link projectHistory.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add</em>'.
	 * @see projectHistory.Add
	 * @generated
	 */
	EClass getAdd();

	/**
	 * Returns the meta object for class '{@link projectHistory.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see projectHistory.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for class '{@link projectHistory.Update <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update</em>'.
	 * @see projectHistory.Update
	 * @generated
	 */
	EClass getUpdate();

	/**
	 * Returns the meta object for the containment reference '{@link projectHistory.Update#getOld <em>Old</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Old</em>'.
	 * @see projectHistory.Update#getOld()
	 * @see #getUpdate()
	 * @generated
	 */
	EReference getUpdate_Old();

	/**
	 * Returns the meta object for the containment reference '{@link projectHistory.Update#getNew <em>New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New</em>'.
	 * @see projectHistory.Update#getNew()
	 * @see #getUpdate()
	 * @generated
	 */
	EReference getUpdate_New();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	projectHistoryFactory getprojectHistoryFactory();

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
		 * The meta object literal for the '{@link projectHistory.impl.HistoryImpl <em>History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.HistoryImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getHistory()
		 * @generated
		 */
		EClass HISTORY = eINSTANCE.getHistory();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__MSG = eINSTANCE.getHistory_Msg();

		/**
		 * The meta object literal for the '<em><b>Create Msg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__CREATE_MSG = eINSTANCE.getHistory_CreateMsg();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.CreateMsgImpl <em>Create Msg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.CreateMsgImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getCreateMsg()
		 * @generated
		 */
		EClass CREATE_MSG = eINSTANCE.getCreateMsg();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_MSG__USER = eINSTANCE.getCreateMsg_User();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_MSG__TEXT = eINSTANCE.getCreateMsg_Text();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_MSG__SENTENCE = eINSTANCE.getCreateMsg_Sentence();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_MSG__DATE = eINSTANCE.getCreateMsg_Date();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_MSG__ID = eINSTANCE.getCreateMsg_Id();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.MsgImpl <em>Msg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.MsgImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getMsg()
		 * @generated
		 */
		EClass MSG = eINSTANCE.getMsg();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSG__USER = eINSTANCE.getMsg_User();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSG__MSG = eINSTANCE.getMsg_Msg();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSG__COMMAND = eINSTANCE.getMsg_Command();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSG__TEXT = eINSTANCE.getMsg_Text();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSG__DATE = eINSTANCE.getMsg_Date();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSG__ID = eINSTANCE.getMsg_Id();

		/**
		 * The meta object literal for the '<em><b>Sentences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSG__SENTENCES = eINSTANCE.getMsg_Sentences();

		/**
		 * The meta object literal for the '<em><b>Undoable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MSG__UNDOABLE = eINSTANCE.getMsg_Undoable();

		/**
		 * The meta object literal for the '<em><b>Get Channel</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MSG___GET_CHANNEL = eINSTANCE.getMsg__GetChannel();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.SentenceImpl <em>Sentence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.SentenceImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getSentence()
		 * @generated
		 */
		EClass SENTENCE = eINSTANCE.getSentence();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENTENCE__SENTENCE = eINSTANCE.getSentence_Sentence();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENTENCE__COMMANDS = eINSTANCE.getSentence_Commands();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.ActionImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__ELEMENT = eINSTANCE.getAction_Element();

		/**
		 * The meta object literal for the '<em><b>Do It</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___DO_IT = eINSTANCE.getAction__DoIt();

		/**
		 * The meta object literal for the '<em><b>Undo It</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___UNDO_IT = eINSTANCE.getAction__UndoIt();

		/**
		 * The meta object literal for the '<em><b>Redo It</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___REDO_IT = eINSTANCE.getAction__RedoIt();

		/**
		 * The meta object literal for the '<em><b>Is Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___IS_UNDO = eINSTANCE.getAction__IsUndo();

		/**
		 * The meta object literal for the '<em><b>Is Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___IS_EXECUTE = eINSTANCE.getAction__IsExecute();

		/**
		 * The meta object literal for the '<em><b>Get Action Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___GET_ACTION_NAME = eINSTANCE.getAction__GetActionName();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___GET_OBJECT = eINSTANCE.getAction__GetObject();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.AddImpl <em>Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.AddImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getAdd()
		 * @generated
		 */
		EClass ADD = eINSTANCE.getAdd();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.DeleteImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '{@link projectHistory.impl.UpdateImpl <em>Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see projectHistory.impl.UpdateImpl
		 * @see projectHistory.impl.projectHistoryPackageImpl#getUpdate()
		 * @generated
		 */
		EClass UPDATE = eINSTANCE.getUpdate();

		/**
		 * The meta object literal for the '<em><b>Old</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE__OLD = eINSTANCE.getUpdate_Old();

		/**
		 * The meta object literal for the '<em><b>New</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE__NEW = eINSTANCE.getUpdate_New();

	}

} //projectHistoryPackage
