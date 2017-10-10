/**
 */
package socioProjects;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see socioProjects.SocioProjectsFactory
 * @model kind="package"
 * @generated
 */
public interface SocioProjectsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "socioProjects";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "socioProjects";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "socioProjects";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SocioProjectsPackage eINSTANCE = socioProjects.impl.SocioProjectsPackageImpl.init();

	/**
	 * The meta object id for the '{@link socioProjects.impl.SocioAppImpl <em>Socio App</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.impl.SocioAppImpl
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getSocioApp()
	 * @generated
	 */
	int SOCIO_APP = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIO_APP__PROJECTS = 0;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIO_APP__USERS = 1;

	/**
	 * The number of structural features of the '<em>Socio App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIO_APP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Socio App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIO_APP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link socioProjects.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.impl.ProjectImpl
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__HISTORY = 1;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__REMOVE = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL = 3;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__VISIBILITY = 4;

	/**
	 * The feature id for the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ADMIN = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ID = 6;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Get Path</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_PATH = 0;

	/**
	 * The operation id for the '<em>Parse Sentence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___PARSE_SENTENCE__STRING = 1;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___EXECUTE__MSG = 2;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___UNDO = 3;

	/**
	 * The operation id for the '<em>Redo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___REDO = 4;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_HISTORY_MSG = 5;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_HISTORY_MSG__DATE_INT = 6;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_HISTORY_MSG__DATE_DATE_INT = 7;

	/**
	 * The operation id for the '<em>Get History For User</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_HISTORY_FOR_USER__USER = 8;

	/**
	 * The operation id for the '<em>Get History For Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_HISTORY_FOR_ELEMENT__STRING = 9;

	/**
	 * The operation id for the '<em>Get History For Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_HISTORY_FOR_ACTION__STRING = 10;

	/**
	 * The operation id for the '<em>Get Statistics User Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_USER_MSG = 11;

	/**
	 * The operation id for the '<em>Get Statistics User Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_USER_MSG__USER = 12;

	/**
	 * The operation id for the '<em>Get Statistics User Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_USER_ACTION = 13;

	/**
	 * The operation id for the '<em>Get Statistics User Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_USER_ACTION__USER = 14;

	/**
	 * The operation id for the '<em>Get Statistics User Msg Abs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_USER_MSG_ABS = 15;

	/**
	 * The operation id for the '<em>Get Statistics User Action Abs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_USER_ACTION_ABS = 16;

	/**
	 * The operation id for the '<em>Get Statistics Actions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___GET_STATISTICS_ACTIONS = 17;

	/**
	 * The operation id for the '<em>Percent Of Authorship</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___PERCENT_OF_AUTHORSHIP = 18;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT___VALIDATE = 19;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = 20;

	/**
	 * The meta object id for the '{@link socioProjects.impl.ModelProjecImpl <em>Model Projec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.impl.ModelProjecImpl
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getModelProjec()
	 * @generated
	 */
	int MODEL_PROJEC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__NAME = PROJECT__NAME;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__HISTORY = PROJECT__HISTORY;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__REMOVE = PROJECT__REMOVE;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__MODEL = PROJECT__MODEL;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__VISIBILITY = PROJECT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__ADMIN = PROJECT__ADMIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC__ID = PROJECT__ID;

	/**
	 * The number of structural features of the '<em>Model Projec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC_FEATURE_COUNT = PROJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Path</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_PATH = PROJECT___GET_PATH;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___EXECUTE__MSG = PROJECT___EXECUTE__MSG;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___UNDO = PROJECT___UNDO;

	/**
	 * The operation id for the '<em>Redo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___REDO = PROJECT___REDO;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_HISTORY_MSG = PROJECT___GET_HISTORY_MSG;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_HISTORY_MSG__DATE_INT = PROJECT___GET_HISTORY_MSG__DATE_INT;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_HISTORY_MSG__DATE_DATE_INT = PROJECT___GET_HISTORY_MSG__DATE_DATE_INT;

	/**
	 * The operation id for the '<em>Get History For User</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_HISTORY_FOR_USER__USER = PROJECT___GET_HISTORY_FOR_USER__USER;

	/**
	 * The operation id for the '<em>Get History For Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_HISTORY_FOR_ELEMENT__STRING = PROJECT___GET_HISTORY_FOR_ELEMENT__STRING;

	/**
	 * The operation id for the '<em>Get History For Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_HISTORY_FOR_ACTION__STRING = PROJECT___GET_HISTORY_FOR_ACTION__STRING;

	/**
	 * The operation id for the '<em>Get Statistics User Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_USER_MSG = PROJECT___GET_STATISTICS_USER_MSG;

	/**
	 * The operation id for the '<em>Get Statistics User Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_USER_MSG__USER = PROJECT___GET_STATISTICS_USER_MSG__USER;

	/**
	 * The operation id for the '<em>Get Statistics User Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_USER_ACTION = PROJECT___GET_STATISTICS_USER_ACTION;

	/**
	 * The operation id for the '<em>Get Statistics User Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_USER_ACTION__USER = PROJECT___GET_STATISTICS_USER_ACTION__USER;

	/**
	 * The operation id for the '<em>Get Statistics User Msg Abs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_USER_MSG_ABS = PROJECT___GET_STATISTICS_USER_MSG_ABS;

	/**
	 * The operation id for the '<em>Get Statistics User Action Abs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_USER_ACTION_ABS = PROJECT___GET_STATISTICS_USER_ACTION_ABS;

	/**
	 * The operation id for the '<em>Get Statistics Actions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___GET_STATISTICS_ACTIONS = PROJECT___GET_STATISTICS_ACTIONS;

	/**
	 * The operation id for the '<em>Percent Of Authorship</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___PERCENT_OF_AUTHORSHIP = PROJECT___PERCENT_OF_AUTHORSHIP;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___VALIDATE = PROJECT___VALIDATE;

	/**
	 * The operation id for the '<em>Parse Sentence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC___PARSE_SENTENCE__STRING = PROJECT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Projec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PROJEC_OPERATION_COUNT = PROJECT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link socioProjects.impl.MetamodelProjectImpl <em>Metamodel Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.impl.MetamodelProjectImpl
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getMetamodelProject()
	 * @generated
	 */
	int METAMODEL_PROJECT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__NAME = PROJECT__NAME;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__HISTORY = PROJECT__HISTORY;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__REMOVE = PROJECT__REMOVE;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__MODEL = PROJECT__MODEL;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__VISIBILITY = PROJECT__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__ADMIN = PROJECT__ADMIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT__ID = PROJECT__ID;

	/**
	 * The number of structural features of the '<em>Metamodel Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT_FEATURE_COUNT = PROJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Path</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_PATH = PROJECT___GET_PATH;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___EXECUTE__MSG = PROJECT___EXECUTE__MSG;

	/**
	 * The operation id for the '<em>Undo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___UNDO = PROJECT___UNDO;

	/**
	 * The operation id for the '<em>Redo</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___REDO = PROJECT___REDO;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_HISTORY_MSG = PROJECT___GET_HISTORY_MSG;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_HISTORY_MSG__DATE_INT = PROJECT___GET_HISTORY_MSG__DATE_INT;

	/**
	 * The operation id for the '<em>Get History Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_HISTORY_MSG__DATE_DATE_INT = PROJECT___GET_HISTORY_MSG__DATE_DATE_INT;

	/**
	 * The operation id for the '<em>Get History For User</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_HISTORY_FOR_USER__USER = PROJECT___GET_HISTORY_FOR_USER__USER;

	/**
	 * The operation id for the '<em>Get History For Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_HISTORY_FOR_ELEMENT__STRING = PROJECT___GET_HISTORY_FOR_ELEMENT__STRING;

	/**
	 * The operation id for the '<em>Get History For Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_HISTORY_FOR_ACTION__STRING = PROJECT___GET_HISTORY_FOR_ACTION__STRING;

	/**
	 * The operation id for the '<em>Get Statistics User Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_USER_MSG = PROJECT___GET_STATISTICS_USER_MSG;

	/**
	 * The operation id for the '<em>Get Statistics User Msg</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_USER_MSG__USER = PROJECT___GET_STATISTICS_USER_MSG__USER;

	/**
	 * The operation id for the '<em>Get Statistics User Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_USER_ACTION = PROJECT___GET_STATISTICS_USER_ACTION;

	/**
	 * The operation id for the '<em>Get Statistics User Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_USER_ACTION__USER = PROJECT___GET_STATISTICS_USER_ACTION__USER;

	/**
	 * The operation id for the '<em>Get Statistics User Msg Abs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_USER_MSG_ABS = PROJECT___GET_STATISTICS_USER_MSG_ABS;

	/**
	 * The operation id for the '<em>Get Statistics User Action Abs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_USER_ACTION_ABS = PROJECT___GET_STATISTICS_USER_ACTION_ABS;

	/**
	 * The operation id for the '<em>Get Statistics Actions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___GET_STATISTICS_ACTIONS = PROJECT___GET_STATISTICS_ACTIONS;

	/**
	 * The operation id for the '<em>Percent Of Authorship</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___PERCENT_OF_AUTHORSHIP = PROJECT___PERCENT_OF_AUTHORSHIP;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___VALIDATE = PROJECT___VALIDATE;

	/**
	 * The operation id for the '<em>Parse Sentence</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT___PARSE_SENTENCE__STRING = PROJECT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Metamodel Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_PROJECT_OPERATION_COUNT = PROJECT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link socioProjects.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.impl.UserImpl
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getUser()
	 * @generated
	 */
	int USER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Nick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NICK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ID = 2;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__CHANNEL = 3;

	/**
	 * The feature id for the '<em><b>Own Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__OWN_PROJECTS = 4;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__CONTRIBUTIONS = 5;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Can Edit</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___CAN_EDIT__PROJECT = 0;

	/**
	 * The operation id for the '<em>Can Read</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___CAN_READ__PROJECT = 1;

	/**
	 * The operation id for the '<em>Is Admin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___IS_ADMIN__PROJECT = 2;

	/**
	 * The operation id for the '<em>Remove Contribution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___REMOVE_CONTRIBUTION__PROJECT = 3;

	/**
	 * The operation id for the '<em>Add Contribution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___ADD_CONTRIBUTION__PROJECT_ACCESS = 4;

	/**
	 * The operation id for the '<em>Add Project</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___ADD_PROJECT__PROJECT = 5;

	/**
	 * The operation id for the '<em>Get Contribution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___GET_CONTRIBUTION__PROJECT = 6;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___IS_ROOT = 7;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = 8;

	/**
	 * The meta object id for the '{@link socioProjects.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.impl.ContributionImpl
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 5;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__ACCESS = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__PROJECT = 1;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link socioProjects.Access <em>Access</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.Access
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getAccess()
	 * @generated
	 */
	int ACCESS = 6;

	/**
	 * The meta object id for the '{@link socioProjects.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see socioProjects.Visibility
	 * @see socioProjects.impl.SocioProjectsPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 7;


	/**
	 * Returns the meta object for class '{@link socioProjects.SocioApp <em>Socio App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Socio App</em>'.
	 * @see socioProjects.SocioApp
	 * @generated
	 */
	EClass getSocioApp();

	/**
	 * Returns the meta object for the containment reference list '{@link socioProjects.SocioApp#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see socioProjects.SocioApp#getProjects()
	 * @see #getSocioApp()
	 * @generated
	 */
	EReference getSocioApp_Projects();

	/**
	 * Returns the meta object for the containment reference list '{@link socioProjects.SocioApp#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see socioProjects.SocioApp#getUsers()
	 * @see #getSocioApp()
	 * @generated
	 */
	EReference getSocioApp_Users();

	/**
	 * Returns the meta object for class '{@link socioProjects.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see socioProjects.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see socioProjects.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the containment reference '{@link socioProjects.Project#getHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>History</em>'.
	 * @see socioProjects.Project#getHistory()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_History();

	/**
	 * Returns the meta object for the containment reference '{@link socioProjects.Project#getRemove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Remove</em>'.
	 * @see socioProjects.Project#getRemove()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Remove();

	/**
	 * Returns the meta object for the reference '{@link socioProjects.Project#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see socioProjects.Project#getModel()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Model();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.Project#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see socioProjects.Project#getVisibility()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Visibility();

	/**
	 * Returns the meta object for the reference '{@link socioProjects.Project#getAdmin <em>Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Admin</em>'.
	 * @see socioProjects.Project#getAdmin()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Admin();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.Project#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see socioProjects.Project#getId()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Id();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getPath() <em>Get Path</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Path</em>' operation.
	 * @see socioProjects.Project#getPath()
	 * @generated
	 */
	EOperation getProject__GetPath();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#parseSentence(java.lang.String) <em>Parse Sentence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parse Sentence</em>' operation.
	 * @see socioProjects.Project#parseSentence(java.lang.String)
	 * @generated
	 */
	EOperation getProject__ParseSentence__String();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#execute(projectHistory.Msg) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see socioProjects.Project#execute(projectHistory.Msg)
	 * @generated
	 */
	EOperation getProject__Execute__Msg();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#undo() <em>Undo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Undo</em>' operation.
	 * @see socioProjects.Project#undo()
	 * @generated
	 */
	EOperation getProject__Undo();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#redo() <em>Redo</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Redo</em>' operation.
	 * @see socioProjects.Project#redo()
	 * @generated
	 */
	EOperation getProject__Redo();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getHistoryMsg() <em>Get History Msg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get History Msg</em>' operation.
	 * @see socioProjects.Project#getHistoryMsg()
	 * @generated
	 */
	EOperation getProject__GetHistoryMsg();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getHistoryMsg(java.util.Date, int) <em>Get History Msg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get History Msg</em>' operation.
	 * @see socioProjects.Project#getHistoryMsg(java.util.Date, int)
	 * @generated
	 */
	EOperation getProject__GetHistoryMsg__Date_int();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getHistoryMsg(java.util.Date, java.util.Date, int) <em>Get History Msg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get History Msg</em>' operation.
	 * @see socioProjects.Project#getHistoryMsg(java.util.Date, java.util.Date, int)
	 * @generated
	 */
	EOperation getProject__GetHistoryMsg__Date_Date_int();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getHistoryForUser(socioProjects.User) <em>Get History For User</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get History For User</em>' operation.
	 * @see socioProjects.Project#getHistoryForUser(socioProjects.User)
	 * @generated
	 */
	EOperation getProject__GetHistoryForUser__User();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getHistoryForElement(java.lang.String) <em>Get History For Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get History For Element</em>' operation.
	 * @see socioProjects.Project#getHistoryForElement(java.lang.String)
	 * @generated
	 */
	EOperation getProject__GetHistoryForElement__String();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getHistoryForAction(java.lang.String) <em>Get History For Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get History For Action</em>' operation.
	 * @see socioProjects.Project#getHistoryForAction(java.lang.String)
	 * @generated
	 */
	EOperation getProject__GetHistoryForAction__String();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsUserMsg() <em>Get Statistics User Msg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics User Msg</em>' operation.
	 * @see socioProjects.Project#getStatisticsUserMsg()
	 * @generated
	 */
	EOperation getProject__GetStatisticsUserMsg();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsUserMsg(socioProjects.User) <em>Get Statistics User Msg</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics User Msg</em>' operation.
	 * @see socioProjects.Project#getStatisticsUserMsg(socioProjects.User)
	 * @generated
	 */
	EOperation getProject__GetStatisticsUserMsg__User();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsUserAction() <em>Get Statistics User Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics User Action</em>' operation.
	 * @see socioProjects.Project#getStatisticsUserAction()
	 * @generated
	 */
	EOperation getProject__GetStatisticsUserAction();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsUserAction(socioProjects.User) <em>Get Statistics User Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics User Action</em>' operation.
	 * @see socioProjects.Project#getStatisticsUserAction(socioProjects.User)
	 * @generated
	 */
	EOperation getProject__GetStatisticsUserAction__User();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsUserMsgAbs() <em>Get Statistics User Msg Abs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics User Msg Abs</em>' operation.
	 * @see socioProjects.Project#getStatisticsUserMsgAbs()
	 * @generated
	 */
	EOperation getProject__GetStatisticsUserMsgAbs();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsUserActionAbs() <em>Get Statistics User Action Abs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics User Action Abs</em>' operation.
	 * @see socioProjects.Project#getStatisticsUserActionAbs()
	 * @generated
	 */
	EOperation getProject__GetStatisticsUserActionAbs();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#getStatisticsActions() <em>Get Statistics Actions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Statistics Actions</em>' operation.
	 * @see socioProjects.Project#getStatisticsActions()
	 * @generated
	 */
	EOperation getProject__GetStatisticsActions();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#percentOfAuthorship() <em>Percent Of Authorship</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Percent Of Authorship</em>' operation.
	 * @see socioProjects.Project#percentOfAuthorship()
	 * @generated
	 */
	EOperation getProject__PercentOfAuthorship();

	/**
	 * Returns the meta object for the '{@link socioProjects.Project#validate() <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate</em>' operation.
	 * @see socioProjects.Project#validate()
	 * @generated
	 */
	EOperation getProject__Validate();

	/**
	 * Returns the meta object for class '{@link socioProjects.ModelProjec <em>Model Projec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Projec</em>'.
	 * @see socioProjects.ModelProjec
	 * @generated
	 */
	EClass getModelProjec();

	/**
	 * Returns the meta object for the '{@link socioProjects.ModelProjec#parseSentence(java.lang.String) <em>Parse Sentence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parse Sentence</em>' operation.
	 * @see socioProjects.ModelProjec#parseSentence(java.lang.String)
	 * @generated
	 */
	EOperation getModelProjec__ParseSentence__String();

	/**
	 * Returns the meta object for class '{@link socioProjects.MetamodelProject <em>Metamodel Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel Project</em>'.
	 * @see socioProjects.MetamodelProject
	 * @generated
	 */
	EClass getMetamodelProject();

	/**
	 * Returns the meta object for the '{@link socioProjects.MetamodelProject#parseSentence(java.lang.String) <em>Parse Sentence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parse Sentence</em>' operation.
	 * @see socioProjects.MetamodelProject#parseSentence(java.lang.String)
	 * @generated
	 */
	EOperation getMetamodelProject__ParseSentence__String();

	/**
	 * Returns the meta object for class '{@link socioProjects.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see socioProjects.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see socioProjects.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.User#getNick <em>Nick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nick</em>'.
	 * @see socioProjects.User#getNick()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Nick();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.User#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see socioProjects.User#getId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Id();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.User#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see socioProjects.User#getChannel()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Channel();

	/**
	 * Returns the meta object for the reference list '{@link socioProjects.User#getOwnProjects <em>Own Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Own Projects</em>'.
	 * @see socioProjects.User#getOwnProjects()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_OwnProjects();

	/**
	 * Returns the meta object for the containment reference list '{@link socioProjects.User#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributions</em>'.
	 * @see socioProjects.User#getContributions()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Contributions();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#canEdit(socioProjects.Project) <em>Can Edit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Can Edit</em>' operation.
	 * @see socioProjects.User#canEdit(socioProjects.Project)
	 * @generated
	 */
	EOperation getUser__CanEdit__Project();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#canRead(socioProjects.Project) <em>Can Read</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Can Read</em>' operation.
	 * @see socioProjects.User#canRead(socioProjects.Project)
	 * @generated
	 */
	EOperation getUser__CanRead__Project();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#isAdmin(socioProjects.Project) <em>Is Admin</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Admin</em>' operation.
	 * @see socioProjects.User#isAdmin(socioProjects.Project)
	 * @generated
	 */
	EOperation getUser__IsAdmin__Project();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#removeContribution(socioProjects.Project) <em>Remove Contribution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Remove Contribution</em>' operation.
	 * @see socioProjects.User#removeContribution(socioProjects.Project)
	 * @generated
	 */
	EOperation getUser__RemoveContribution__Project();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#addContribution(socioProjects.Project, socioProjects.Access) <em>Add Contribution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Contribution</em>' operation.
	 * @see socioProjects.User#addContribution(socioProjects.Project, socioProjects.Access)
	 * @generated
	 */
	EOperation getUser__AddContribution__Project_Access();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#addProject(socioProjects.Project) <em>Add Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Project</em>' operation.
	 * @see socioProjects.User#addProject(socioProjects.Project)
	 * @generated
	 */
	EOperation getUser__AddProject__Project();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#getContribution(socioProjects.Project) <em>Get Contribution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contribution</em>' operation.
	 * @see socioProjects.User#getContribution(socioProjects.Project)
	 * @generated
	 */
	EOperation getUser__GetContribution__Project();

	/**
	 * Returns the meta object for the '{@link socioProjects.User#isRoot() <em>Is Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Root</em>' operation.
	 * @see socioProjects.User#isRoot()
	 * @generated
	 */
	EOperation getUser__IsRoot();

	/**
	 * Returns the meta object for class '{@link socioProjects.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see socioProjects.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the attribute '{@link socioProjects.Contribution#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see socioProjects.Contribution#getAccess()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Access();

	/**
	 * Returns the meta object for the reference '{@link socioProjects.Contribution#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see socioProjects.Contribution#getProject()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Project();

	/**
	 * Returns the meta object for enum '{@link socioProjects.Access <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access</em>'.
	 * @see socioProjects.Access
	 * @generated
	 */
	EEnum getAccess();

	/**
	 * Returns the meta object for enum '{@link socioProjects.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see socioProjects.Visibility
	 * @generated
	 */
	EEnum getVisibility();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SocioProjectsFactory getSocioProjectsFactory();

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
		 * The meta object literal for the '{@link socioProjects.impl.SocioAppImpl <em>Socio App</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.impl.SocioAppImpl
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getSocioApp()
		 * @generated
		 */
		EClass SOCIO_APP = eINSTANCE.getSocioApp();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCIO_APP__PROJECTS = eINSTANCE.getSocioApp_Projects();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCIO_APP__USERS = eINSTANCE.getSocioApp_Users();

		/**
		 * The meta object literal for the '{@link socioProjects.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.impl.ProjectImpl
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__HISTORY = eINSTANCE.getProject_History();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__REMOVE = eINSTANCE.getProject_Remove();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__MODEL = eINSTANCE.getProject_Model();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__VISIBILITY = eINSTANCE.getProject_Visibility();

		/**
		 * The meta object literal for the '<em><b>Admin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__ADMIN = eINSTANCE.getProject_Admin();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__ID = eINSTANCE.getProject_Id();

		/**
		 * The meta object literal for the '<em><b>Get Path</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_PATH = eINSTANCE.getProject__GetPath();

		/**
		 * The meta object literal for the '<em><b>Parse Sentence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___PARSE_SENTENCE__STRING = eINSTANCE.getProject__ParseSentence__String();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___EXECUTE__MSG = eINSTANCE.getProject__Execute__Msg();

		/**
		 * The meta object literal for the '<em><b>Undo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___UNDO = eINSTANCE.getProject__Undo();

		/**
		 * The meta object literal for the '<em><b>Redo</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___REDO = eINSTANCE.getProject__Redo();

		/**
		 * The meta object literal for the '<em><b>Get History Msg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_HISTORY_MSG = eINSTANCE.getProject__GetHistoryMsg();

		/**
		 * The meta object literal for the '<em><b>Get History Msg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_HISTORY_MSG__DATE_INT = eINSTANCE.getProject__GetHistoryMsg__Date_int();

		/**
		 * The meta object literal for the '<em><b>Get History Msg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_HISTORY_MSG__DATE_DATE_INT = eINSTANCE.getProject__GetHistoryMsg__Date_Date_int();

		/**
		 * The meta object literal for the '<em><b>Get History For User</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_HISTORY_FOR_USER__USER = eINSTANCE.getProject__GetHistoryForUser__User();

		/**
		 * The meta object literal for the '<em><b>Get History For Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_HISTORY_FOR_ELEMENT__STRING = eINSTANCE.getProject__GetHistoryForElement__String();

		/**
		 * The meta object literal for the '<em><b>Get History For Action</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_HISTORY_FOR_ACTION__STRING = eINSTANCE.getProject__GetHistoryForAction__String();

		/**
		 * The meta object literal for the '<em><b>Get Statistics User Msg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_USER_MSG = eINSTANCE.getProject__GetStatisticsUserMsg();

		/**
		 * The meta object literal for the '<em><b>Get Statistics User Msg</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_USER_MSG__USER = eINSTANCE.getProject__GetStatisticsUserMsg__User();

		/**
		 * The meta object literal for the '<em><b>Get Statistics User Action</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_USER_ACTION = eINSTANCE.getProject__GetStatisticsUserAction();

		/**
		 * The meta object literal for the '<em><b>Get Statistics User Action</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_USER_ACTION__USER = eINSTANCE.getProject__GetStatisticsUserAction__User();

		/**
		 * The meta object literal for the '<em><b>Get Statistics User Msg Abs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_USER_MSG_ABS = eINSTANCE.getProject__GetStatisticsUserMsgAbs();

		/**
		 * The meta object literal for the '<em><b>Get Statistics User Action Abs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_USER_ACTION_ABS = eINSTANCE.getProject__GetStatisticsUserActionAbs();

		/**
		 * The meta object literal for the '<em><b>Get Statistics Actions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___GET_STATISTICS_ACTIONS = eINSTANCE.getProject__GetStatisticsActions();

		/**
		 * The meta object literal for the '<em><b>Percent Of Authorship</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___PERCENT_OF_AUTHORSHIP = eINSTANCE.getProject__PercentOfAuthorship();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROJECT___VALIDATE = eINSTANCE.getProject__Validate();

		/**
		 * The meta object literal for the '{@link socioProjects.impl.ModelProjecImpl <em>Model Projec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.impl.ModelProjecImpl
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getModelProjec()
		 * @generated
		 */
		EClass MODEL_PROJEC = eINSTANCE.getModelProjec();

		/**
		 * The meta object literal for the '<em><b>Parse Sentence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_PROJEC___PARSE_SENTENCE__STRING = eINSTANCE.getModelProjec__ParseSentence__String();

		/**
		 * The meta object literal for the '{@link socioProjects.impl.MetamodelProjectImpl <em>Metamodel Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.impl.MetamodelProjectImpl
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getMetamodelProject()
		 * @generated
		 */
		EClass METAMODEL_PROJECT = eINSTANCE.getMetamodelProject();

		/**
		 * The meta object literal for the '<em><b>Parse Sentence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation METAMODEL_PROJECT___PARSE_SENTENCE__STRING = eINSTANCE.getMetamodelProject__ParseSentence__String();

		/**
		 * The meta object literal for the '{@link socioProjects.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.impl.UserImpl
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Nick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NICK = eINSTANCE.getUser_Nick();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__ID = eINSTANCE.getUser_Id();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__CHANNEL = eINSTANCE.getUser_Channel();

		/**
		 * The meta object literal for the '<em><b>Own Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__OWN_PROJECTS = eINSTANCE.getUser_OwnProjects();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__CONTRIBUTIONS = eINSTANCE.getUser_Contributions();

		/**
		 * The meta object literal for the '<em><b>Can Edit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___CAN_EDIT__PROJECT = eINSTANCE.getUser__CanEdit__Project();

		/**
		 * The meta object literal for the '<em><b>Can Read</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___CAN_READ__PROJECT = eINSTANCE.getUser__CanRead__Project();

		/**
		 * The meta object literal for the '<em><b>Is Admin</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___IS_ADMIN__PROJECT = eINSTANCE.getUser__IsAdmin__Project();

		/**
		 * The meta object literal for the '<em><b>Remove Contribution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___REMOVE_CONTRIBUTION__PROJECT = eINSTANCE.getUser__RemoveContribution__Project();

		/**
		 * The meta object literal for the '<em><b>Add Contribution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___ADD_CONTRIBUTION__PROJECT_ACCESS = eINSTANCE.getUser__AddContribution__Project_Access();

		/**
		 * The meta object literal for the '<em><b>Add Project</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___ADD_PROJECT__PROJECT = eINSTANCE.getUser__AddProject__Project();

		/**
		 * The meta object literal for the '<em><b>Get Contribution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___GET_CONTRIBUTION__PROJECT = eINSTANCE.getUser__GetContribution__Project();

		/**
		 * The meta object literal for the '<em><b>Is Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USER___IS_ROOT = eINSTANCE.getUser__IsRoot();

		/**
		 * The meta object literal for the '{@link socioProjects.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.impl.ContributionImpl
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__ACCESS = eINSTANCE.getContribution_Access();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__PROJECT = eINSTANCE.getContribution_Project();

		/**
		 * The meta object literal for the '{@link socioProjects.Access <em>Access</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.Access
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getAccess()
		 * @generated
		 */
		EEnum ACCESS = eINSTANCE.getAccess();

		/**
		 * The meta object literal for the '{@link socioProjects.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see socioProjects.Visibility
		 * @see socioProjects.impl.SocioProjectsPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //SocioProjectsPackage
