/**
 */
package modelInfo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see modelInfo.ModelInfoFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ModelInfoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modelInfo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "modelInfo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modelInfo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelInfoPackage eINSTANCE = modelInfo.impl.ModelInfoPackageImpl.init();

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLModelImpl <em>NL Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLModelImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLModel()
	 * @generated
	 */
	int NL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_MODEL__MODEL = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_MODEL__CLASSES = 2;

	/**
	 * The feature id for the '<em><b>Model Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_MODEL__MODEL_UPDATE = 3;

	/**
	 * The number of structural features of the '<em>NL Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>NL Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLElementImpl <em>NL Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLElementImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLElement()
	 * @generated
	 */
	int NL_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Synonyms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT__SYNONYMS = 2;

	/**
	 * The feature id for the '<em><b>Create Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT__CREATE_TEMPLATES = 3;

	/**
	 * The feature id for the '<em><b>Delete Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT__DELETE_TEMPLATES = 4;

	/**
	 * The number of structural features of the '<em>NL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>NL Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLClassImpl <em>NL Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLClassImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLClass()
	 * @generated
	 */
	int NL_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__NAME = NL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__DESCRIPTION = NL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Synonyms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__SYNONYMS = NL_ELEMENT__SYNONYMS;

	/**
	 * The feature id for the '<em><b>Create Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__CREATE_TEMPLATES = NL_ELEMENT__CREATE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Delete Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__DELETE_TEMPLATES = NL_ELEMENT__DELETE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__CLASS = NL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>With Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__WITH_CONTAINER = NL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instantiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__INSTANTIABLE = NL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__CREATE = NL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__ID = NL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS__FEATURES = NL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>NL Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS_FEATURE_COUNT = NL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>NL Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_CLASS_OPERATION_COUNT = NL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLFeatureImpl <em>NL Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLFeatureImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLFeature()
	 * @generated
	 */
	int NL_FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE__NAME = NL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE__DESCRIPTION = NL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Synonyms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE__SYNONYMS = NL_ELEMENT__SYNONYMS;

	/**
	 * The feature id for the '<em><b>Create Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE__CREATE_TEMPLATES = NL_ELEMENT__CREATE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Delete Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE__DELETE_TEMPLATES = NL_ELEMENT__DELETE_TEMPLATES;

	/**
	 * The number of structural features of the '<em>NL Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE_FEATURE_COUNT = NL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>NL Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_FEATURE_OPERATION_COUNT = NL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLIdentifierImpl <em>NL Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLIdentifierImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLIdentifier()
	 * @generated
	 */
	int NL_IDENTIFIER = 4;

	/**
	 * The number of structural features of the '<em>NL Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_IDENTIFIER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>NL Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_IDENTIFIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.DefaultIdImpl <em>Default Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.DefaultIdImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getDefaultId()
	 * @generated
	 */
	int DEFAULT_ID = 5;

	/**
	 * The number of structural features of the '<em>Default Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ID_FEATURE_COUNT = NL_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Default Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ID_OPERATION_COUNT = NL_IDENTIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLAttributeImpl <em>NL Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLAttributeImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLAttribute()
	 * @generated
	 */
	int NL_ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE__NAME = NL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE__DESCRIPTION = NL_FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Synonyms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE__SYNONYMS = NL_FEATURE__SYNONYMS;

	/**
	 * The feature id for the '<em><b>Create Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE__CREATE_TEMPLATES = NL_FEATURE__CREATE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Delete Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE__DELETE_TEMPLATES = NL_FEATURE__DELETE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE__ATTRIBUTE = NL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>NL Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE_FEATURE_COUNT = NL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>NL Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_ATTRIBUTE_OPERATION_COUNT = NL_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.NLReferenceImpl <em>NL Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.NLReferenceImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getNLReference()
	 * @generated
	 */
	int NL_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__NAME = NL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__DESCRIPTION = NL_FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Synonyms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__SYNONYMS = NL_FEATURE__SYNONYMS;

	/**
	 * The feature id for the '<em><b>Create Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__CREATE_TEMPLATES = NL_FEATURE__CREATE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Delete Templates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__DELETE_TEMPLATES = NL_FEATURE__DELETE_TEMPLATES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__REFERENCE = NL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Synonyms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE__SRC_SYNONYMS = NL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>NL Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE_FEATURE_COUNT = NL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>NL Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NL_REFERENCE_OPERATION_COUNT = NL_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.UpdateInterfaceImpl <em>Update Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.UpdateInterfaceImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getUpdateInterface()
	 * @generated
	 */
	int UPDATE_INTERFACE = 8;

	/**
	 * The feature id for the '<em><b>Moments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INTERFACE__MOMENTS = 0;

	/**
	 * The number of structural features of the '<em>Update Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INTERFACE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Update Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INTERFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.WebServiceImpl <em>Web Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.WebServiceImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getWebService()
	 * @generated
	 */
	int WEB_SERVICE = 9;

	/**
	 * The feature id for the '<em><b>Moments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__MOMENTS = UPDATE_INTERFACE__MOMENTS;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__PROTOCOL = UPDATE_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__METHOD = UPDATE_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__DOMAIN = UPDATE_INTERFACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__PORT = UPDATE_INTERFACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__PATH = UPDATE_INTERFACE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Web Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE_FEATURE_COUNT = UPDATE_INTERFACE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Web Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE_OPERATION_COUNT = UPDATE_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.MomentImpl <em>Moment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.MomentImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getMoment()
	 * @generated
	 */
	int MOMENT = 10;

	/**
	 * The number of structural features of the '<em>Moment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Moment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.StartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.StartImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getStart()
	 * @generated
	 */
	int START = 11;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_FEATURE_COUNT = MOMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_OPERATION_COUNT = MOMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.impl.FrequencyImpl <em>Frequency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.impl.FrequencyImpl
	 * @see modelInfo.impl.ModelInfoPackageImpl#getFrequency()
	 * @generated
	 */
	int FREQUENCY = 12;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__TIME = MOMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__ACTION = MOMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY__ELEMENTS = MOMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Frequency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_FEATURE_COUNT = MOMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Frequency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREQUENCY_OPERATION_COUNT = MOMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modelInfo.Time <em>Time</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.Time
	 * @see modelInfo.impl.ModelInfoPackageImpl#getTime()
	 * @generated
	 */
	int TIME = 13;

	/**
	 * The meta object id for the '{@link modelInfo.Action <em>Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelInfo.Action
	 * @see modelInfo.impl.ModelInfoPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 14;


	/**
	 * Returns the meta object for class '{@link modelInfo.NLModel <em>NL Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Model</em>'.
	 * @see modelInfo.NLModel
	 * @generated
	 */
	EClass getNLModel();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.NLModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see modelInfo.NLModel#getName()
	 * @see #getNLModel()
	 * @generated
	 */
	EAttribute getNLModel_Name();

	/**
	 * Returns the meta object for the reference '{@link modelInfo.NLModel#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see modelInfo.NLModel#getModel()
	 * @see #getNLModel()
	 * @generated
	 */
	EReference getNLModel_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link modelInfo.NLModel#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see modelInfo.NLModel#getClasses()
	 * @see #getNLModel()
	 * @generated
	 */
	EReference getNLModel_Classes();

	/**
	 * Returns the meta object for the containment reference '{@link modelInfo.NLModel#getModelUpdate <em>Model Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Update</em>'.
	 * @see modelInfo.NLModel#getModelUpdate()
	 * @see #getNLModel()
	 * @generated
	 */
	EReference getNLModel_ModelUpdate();

	/**
	 * Returns the meta object for class '{@link modelInfo.NLElement <em>NL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Element</em>'.
	 * @see modelInfo.NLElement
	 * @generated
	 */
	EClass getNLElement();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.NLElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see modelInfo.NLElement#getName()
	 * @see #getNLElement()
	 * @generated
	 */
	EAttribute getNLElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.NLElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see modelInfo.NLElement#getDescription()
	 * @see #getNLElement()
	 * @generated
	 */
	EAttribute getNLElement_Description();

	/**
	 * Returns the meta object for the attribute list '{@link modelInfo.NLElement#getSynonyms <em>Synonyms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Synonyms</em>'.
	 * @see modelInfo.NLElement#getSynonyms()
	 * @see #getNLElement()
	 * @generated
	 */
	EAttribute getNLElement_Synonyms();

	/**
	 * Returns the meta object for the attribute list '{@link modelInfo.NLElement#getCreateTemplates <em>Create Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Create Templates</em>'.
	 * @see modelInfo.NLElement#getCreateTemplates()
	 * @see #getNLElement()
	 * @generated
	 */
	EAttribute getNLElement_CreateTemplates();

	/**
	 * Returns the meta object for the attribute list '{@link modelInfo.NLElement#getDeleteTemplates <em>Delete Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Delete Templates</em>'.
	 * @see modelInfo.NLElement#getDeleteTemplates()
	 * @see #getNLElement()
	 * @generated
	 */
	EAttribute getNLElement_DeleteTemplates();

	/**
	 * Returns the meta object for class '{@link modelInfo.NLClass <em>NL Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Class</em>'.
	 * @see modelInfo.NLClass
	 * @generated
	 */
	EClass getNLClass();

	/**
	 * Returns the meta object for the reference '{@link modelInfo.NLClass#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see modelInfo.NLClass#getClass_()
	 * @see #getNLClass()
	 * @generated
	 */
	EReference getNLClass_Class();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.NLClass#isWithContainer <em>With Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Container</em>'.
	 * @see modelInfo.NLClass#isWithContainer()
	 * @see #getNLClass()
	 * @generated
	 */
	EAttribute getNLClass_WithContainer();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.NLClass#isInstantiable <em>Instantiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instantiable</em>'.
	 * @see modelInfo.NLClass#isInstantiable()
	 * @see #getNLClass()
	 * @generated
	 */
	EAttribute getNLClass_Instantiable();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.NLClass#getCreate <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create</em>'.
	 * @see modelInfo.NLClass#getCreate()
	 * @see #getNLClass()
	 * @generated
	 */
	EAttribute getNLClass_Create();

	/**
	 * Returns the meta object for the containment reference list '{@link modelInfo.NLClass#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Id</em>'.
	 * @see modelInfo.NLClass#getId()
	 * @see #getNLClass()
	 * @generated
	 */
	EReference getNLClass_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link modelInfo.NLClass#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see modelInfo.NLClass#getFeatures()
	 * @see #getNLClass()
	 * @generated
	 */
	EReference getNLClass_Features();

	/**
	 * Returns the meta object for class '{@link modelInfo.NLFeature <em>NL Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Feature</em>'.
	 * @see modelInfo.NLFeature
	 * @generated
	 */
	EClass getNLFeature();

	/**
	 * Returns the meta object for class '{@link modelInfo.NLIdentifier <em>NL Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Identifier</em>'.
	 * @see modelInfo.NLIdentifier
	 * @generated
	 */
	EClass getNLIdentifier();

	/**
	 * Returns the meta object for class '{@link modelInfo.DefaultId <em>Default Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Id</em>'.
	 * @see modelInfo.DefaultId
	 * @generated
	 */
	EClass getDefaultId();

	/**
	 * Returns the meta object for class '{@link modelInfo.NLAttribute <em>NL Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Attribute</em>'.
	 * @see modelInfo.NLAttribute
	 * @generated
	 */
	EClass getNLAttribute();

	/**
	 * Returns the meta object for the reference '{@link modelInfo.NLAttribute#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see modelInfo.NLAttribute#getAttribute()
	 * @see #getNLAttribute()
	 * @generated
	 */
	EReference getNLAttribute_Attribute();

	/**
	 * Returns the meta object for class '{@link modelInfo.NLReference <em>NL Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NL Reference</em>'.
	 * @see modelInfo.NLReference
	 * @generated
	 */
	EClass getNLReference();

	/**
	 * Returns the meta object for the reference '{@link modelInfo.NLReference#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see modelInfo.NLReference#getReference()
	 * @see #getNLReference()
	 * @generated
	 */
	EReference getNLReference_Reference();

	/**
	 * Returns the meta object for the attribute list '{@link modelInfo.NLReference#getSrcSynonyms <em>Src Synonyms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Synonyms</em>'.
	 * @see modelInfo.NLReference#getSrcSynonyms()
	 * @see #getNLReference()
	 * @generated
	 */
	EAttribute getNLReference_SrcSynonyms();

	/**
	 * Returns the meta object for class '{@link modelInfo.UpdateInterface <em>Update Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Interface</em>'.
	 * @see modelInfo.UpdateInterface
	 * @generated
	 */
	EClass getUpdateInterface();

	/**
	 * Returns the meta object for the reference list '{@link modelInfo.UpdateInterface#getMoments <em>Moments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Moments</em>'.
	 * @see modelInfo.UpdateInterface#getMoments()
	 * @see #getUpdateInterface()
	 * @generated
	 */
	EReference getUpdateInterface_Moments();

	/**
	 * Returns the meta object for class '{@link modelInfo.WebService <em>Web Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Service</em>'.
	 * @see modelInfo.WebService
	 * @generated
	 */
	EClass getWebService();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.WebService#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol</em>'.
	 * @see modelInfo.WebService#getProtocol()
	 * @see #getWebService()
	 * @generated
	 */
	EAttribute getWebService_Protocol();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.WebService#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see modelInfo.WebService#getMethod()
	 * @see #getWebService()
	 * @generated
	 */
	EAttribute getWebService_Method();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.WebService#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see modelInfo.WebService#getDomain()
	 * @see #getWebService()
	 * @generated
	 */
	EAttribute getWebService_Domain();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.WebService#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see modelInfo.WebService#getPort()
	 * @see #getWebService()
	 * @generated
	 */
	EAttribute getWebService_Port();

	/**
	 * Returns the meta object for the attribute list '{@link modelInfo.WebService#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see modelInfo.WebService#getPath()
	 * @see #getWebService()
	 * @generated
	 */
	EAttribute getWebService_Path();

	/**
	 * Returns the meta object for class '{@link modelInfo.Moment <em>Moment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moment</em>'.
	 * @see modelInfo.Moment
	 * @generated
	 */
	EClass getMoment();

	/**
	 * Returns the meta object for class '{@link modelInfo.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see modelInfo.Start
	 * @generated
	 */
	EClass getStart();

	/**
	 * Returns the meta object for class '{@link modelInfo.Frequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Frequency</em>'.
	 * @see modelInfo.Frequency
	 * @generated
	 */
	EClass getFrequency();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.Frequency#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see modelInfo.Frequency#getTime()
	 * @see #getFrequency()
	 * @generated
	 */
	EAttribute getFrequency_Time();

	/**
	 * Returns the meta object for the attribute '{@link modelInfo.Frequency#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see modelInfo.Frequency#getAction()
	 * @see #getFrequency()
	 * @generated
	 */
	EAttribute getFrequency_Action();

	/**
	 * Returns the meta object for the reference list '{@link modelInfo.Frequency#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see modelInfo.Frequency#getElements()
	 * @see #getFrequency()
	 * @generated
	 */
	EReference getFrequency_Elements();

	/**
	 * Returns the meta object for enum '{@link modelInfo.Time <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time</em>'.
	 * @see modelInfo.Time
	 * @generated
	 */
	EEnum getTime();

	/**
	 * Returns the meta object for enum '{@link modelInfo.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action</em>'.
	 * @see modelInfo.Action
	 * @generated
	 */
	EEnum getAction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelInfoFactory getModelInfoFactory();

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
		 * The meta object literal for the '{@link modelInfo.impl.NLModelImpl <em>NL Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLModelImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLModel()
		 * @generated
		 */
		EClass NL_MODEL = eINSTANCE.getNLModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_MODEL__NAME = eINSTANCE.getNLModel_Name();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_MODEL__MODEL = eINSTANCE.getNLModel_Model();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_MODEL__CLASSES = eINSTANCE.getNLModel_Classes();

		/**
		 * The meta object literal for the '<em><b>Model Update</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_MODEL__MODEL_UPDATE = eINSTANCE.getNLModel_ModelUpdate();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.NLElementImpl <em>NL Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLElementImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLElement()
		 * @generated
		 */
		EClass NL_ELEMENT = eINSTANCE.getNLElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_ELEMENT__NAME = eINSTANCE.getNLElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_ELEMENT__DESCRIPTION = eINSTANCE.getNLElement_Description();

		/**
		 * The meta object literal for the '<em><b>Synonyms</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_ELEMENT__SYNONYMS = eINSTANCE.getNLElement_Synonyms();

		/**
		 * The meta object literal for the '<em><b>Create Templates</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_ELEMENT__CREATE_TEMPLATES = eINSTANCE.getNLElement_CreateTemplates();

		/**
		 * The meta object literal for the '<em><b>Delete Templates</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_ELEMENT__DELETE_TEMPLATES = eINSTANCE.getNLElement_DeleteTemplates();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.NLClassImpl <em>NL Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLClassImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLClass()
		 * @generated
		 */
		EClass NL_CLASS = eINSTANCE.getNLClass();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_CLASS__CLASS = eINSTANCE.getNLClass_Class();

		/**
		 * The meta object literal for the '<em><b>With Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_CLASS__WITH_CONTAINER = eINSTANCE.getNLClass_WithContainer();

		/**
		 * The meta object literal for the '<em><b>Instantiable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_CLASS__INSTANTIABLE = eINSTANCE.getNLClass_Instantiable();

		/**
		 * The meta object literal for the '<em><b>Create</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_CLASS__CREATE = eINSTANCE.getNLClass_Create();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_CLASS__ID = eINSTANCE.getNLClass_Id();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_CLASS__FEATURES = eINSTANCE.getNLClass_Features();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.NLFeatureImpl <em>NL Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLFeatureImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLFeature()
		 * @generated
		 */
		EClass NL_FEATURE = eINSTANCE.getNLFeature();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.NLIdentifierImpl <em>NL Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLIdentifierImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLIdentifier()
		 * @generated
		 */
		EClass NL_IDENTIFIER = eINSTANCE.getNLIdentifier();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.DefaultIdImpl <em>Default Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.DefaultIdImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getDefaultId()
		 * @generated
		 */
		EClass DEFAULT_ID = eINSTANCE.getDefaultId();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.NLAttributeImpl <em>NL Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLAttributeImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLAttribute()
		 * @generated
		 */
		EClass NL_ATTRIBUTE = eINSTANCE.getNLAttribute();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getNLAttribute_Attribute();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.NLReferenceImpl <em>NL Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.NLReferenceImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getNLReference()
		 * @generated
		 */
		EClass NL_REFERENCE = eINSTANCE.getNLReference();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NL_REFERENCE__REFERENCE = eINSTANCE.getNLReference_Reference();

		/**
		 * The meta object literal for the '<em><b>Src Synonyms</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NL_REFERENCE__SRC_SYNONYMS = eINSTANCE.getNLReference_SrcSynonyms();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.UpdateInterfaceImpl <em>Update Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.UpdateInterfaceImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getUpdateInterface()
		 * @generated
		 */
		EClass UPDATE_INTERFACE = eINSTANCE.getUpdateInterface();

		/**
		 * The meta object literal for the '<em><b>Moments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_INTERFACE__MOMENTS = eINSTANCE.getUpdateInterface_Moments();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.WebServiceImpl <em>Web Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.WebServiceImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getWebService()
		 * @generated
		 */
		EClass WEB_SERVICE = eINSTANCE.getWebService();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SERVICE__PROTOCOL = eINSTANCE.getWebService_Protocol();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SERVICE__METHOD = eINSTANCE.getWebService_Method();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SERVICE__DOMAIN = eINSTANCE.getWebService_Domain();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SERVICE__PORT = eINSTANCE.getWebService_Port();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SERVICE__PATH = eINSTANCE.getWebService_Path();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.MomentImpl <em>Moment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.MomentImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getMoment()
		 * @generated
		 */
		EClass MOMENT = eINSTANCE.getMoment();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.StartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.StartImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getStart()
		 * @generated
		 */
		EClass START = eINSTANCE.getStart();

		/**
		 * The meta object literal for the '{@link modelInfo.impl.FrequencyImpl <em>Frequency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.impl.FrequencyImpl
		 * @see modelInfo.impl.ModelInfoPackageImpl#getFrequency()
		 * @generated
		 */
		EClass FREQUENCY = eINSTANCE.getFrequency();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY__TIME = eINSTANCE.getFrequency_Time();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREQUENCY__ACTION = eINSTANCE.getFrequency_Action();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREQUENCY__ELEMENTS = eINSTANCE.getFrequency_Elements();

		/**
		 * The meta object literal for the '{@link modelInfo.Time <em>Time</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.Time
		 * @see modelInfo.impl.ModelInfoPackageImpl#getTime()
		 * @generated
		 */
		EEnum TIME = eINSTANCE.getTime();

		/**
		 * The meta object literal for the '{@link modelInfo.Action <em>Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelInfo.Action
		 * @see modelInfo.impl.ModelInfoPackageImpl#getAction()
		 * @generated
		 */
		EEnum ACTION = eINSTANCE.getAction();

	}

} //ModelInfoPackage
