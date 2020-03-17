/**
 */
package generator;

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
 * @see generator.GeneratorFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface GeneratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://generator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorPackage eINSTANCE = generator.impl.GeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link generator.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ElementImpl
	 * @see generator.impl.GeneratorPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.BotImpl <em>Bot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.BotImpl
	 * @see generator.impl.GeneratorPackageImpl#getBot()
	 * @generated
	 */
	int BOT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Intents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__INTENTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__ENTITIES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__ACTIONS = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__FLOWS = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__LANGUAGE = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.InteractionImpl
	 * @see generator.impl.GeneratorPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 1;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.BotInteractionImpl <em>Bot Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.BotInteractionImpl
	 * @see generator.impl.GeneratorPackageImpl#getBotInteraction()
	 * @generated
	 */
	int BOT_INTERACTION = 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__ACTIONS = INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__INCOMING = INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outcoming</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__OUTCOMING = INTERACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bot Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION_FEATURE_COUNT = INTERACTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Bot Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION_OPERATION_COUNT = INTERACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.UserInteractionImpl <em>User Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.UserInteractionImpl
	 * @see generator.impl.GeneratorPackageImpl#getUserInteraction()
	 * @generated
	 */
	int USER_INTERACTION = 3;

	/**
	 * The feature id for the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__INTENT = INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__SRC = INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__TARGET = INTERACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_FEATURE_COUNT = INTERACTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_OPERATION_COUNT = INTERACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.EntityImpl
	 * @see generator.impl.GeneratorPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.SimpleImpl <em>Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.SimpleImpl
	 * @see generator.impl.GeneratorPackageImpl#getSimple()
	 * @generated
	 */
	int SIMPLE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__INPUTS = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.CompositeImpl <em>Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.CompositeImpl
	 * @see generator.impl.GeneratorPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__INPUTS = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.SimpleInputImpl <em>Simple Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.SimpleInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getSimpleInput()
	 * @generated
	 */
	int SIMPLE_INPUT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT__VALUES = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Simple Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.CompositeInputImpl <em>Composite Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.CompositeInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getCompositeInput()
	 * @generated
	 */
	int COMPOSITE_INPUT = 9;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INPUT__TOKENS = 0;

	/**
	 * The number of structural features of the '<em>Composite Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INPUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Composite Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 10;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LiteralImpl
	 * @see generator.impl.GeneratorPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__TEXT = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.EntityTokenImpl <em>Entity Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.EntityTokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getEntityToken()
	 * @generated
	 */
	int ENTITY_TOKEN = 12;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TOKEN__ENTITY = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TOKEN_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entity Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TOKEN_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ParameterTokenImpl <em>Parameter Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ParameterTokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getParameterToken()
	 * @generated
	 */
	int PARAMETER_TOKEN = 13;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN__PARAMETER = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ParameterReferenceTokenImpl <em>Parameter Reference Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ParameterReferenceTokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getParameterReferenceToken()
	 * @generated
	 */
	int PARAMETER_REFERENCE_TOKEN = 14;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN__PARAMETER = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Reference Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Parameter Reference Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.HTTPRequestTokeImpl <em>HTTP Request Toke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.HTTPRequestTokeImpl
	 * @see generator.impl.GeneratorPackageImpl#getHTTPRequestToke()
	 * @generated
	 */
	int HTTP_REQUEST_TOKE = 15;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE__TYPE = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE__DATA_KEY = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HTTP Request Toke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>HTTP Request Toke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.IntentImpl <em>Intent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.IntentImpl
	 * @see generator.impl.GeneratorPackageImpl#getIntent()
	 * @generated
	 */
	int INTENT = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__INPUTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__PARAMETERS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fallback Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__FALLBACK_INTENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.TrainingPhraseImpl <em>Training Phrase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TrainingPhraseImpl
	 * @see generator.impl.GeneratorPackageImpl#getTrainingPhrase()
	 * @generated
	 */
	int TRAINING_PHRASE = 17;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAINING_PHRASE__TOKENS = 0;

	/**
	 * The number of structural features of the '<em>Training Phrase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAINING_PHRASE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Training Phrase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAINING_PHRASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ParameterImpl
	 * @see generator.impl.GeneratorPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ENTITY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DEFAULT_ENTITY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__REQUIRED = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prompts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PROMPTS = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_LIST = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ActionImpl
	 * @see generator.impl.GeneratorPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ImageImpl
	 * @see generator.impl.GeneratorPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__URL = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__CAPTION = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TextImpl
	 * @see generator.impl.GeneratorPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__INPUTS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.TextInputImpl <em>Text Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TextInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getTextInput()
	 * @generated
	 */
	int TEXT_INPUT = 22;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_INPUT__TOKENS = 0;

	/**
	 * The number of structural features of the '<em>Text Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_INPUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Text Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.HTTPRequestImpl <em>HTTP Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.HTTPRequestImpl
	 * @see generator.impl.GeneratorPackageImpl#getHTTPRequest()
	 * @generated
	 */
	int HTTP_REQUEST = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__URL = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Basic Auth</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__BASIC_AUTH = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__HEADERS = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__DATA = ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__DATA_TYPE = ACTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__METHOD = ACTION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>HTTP Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_FEATURE_COUNT = ACTION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>HTTP Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.HTTPResponseImpl <em>HTTP Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.HTTPResponseImpl
	 * @see generator.impl.GeneratorPackageImpl#getHTTPResponse()
	 * @generated
	 */
	int HTTP_RESPONSE = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE__INPUTS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>HTTP Request</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE__HTTP_REQUEST = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HTTP Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>HTTP Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.KeyValueImpl <em>Key Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.KeyValueImpl
	 * @see generator.impl.GeneratorPackageImpl#getKeyValue()
	 * @generated
	 */
	int KEY_VALUE = 25;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.DataType
	 * @see generator.impl.GeneratorPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 26;

	/**
	 * The meta object id for the '{@link generator.Method <em>Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.Method
	 * @see generator.impl.GeneratorPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 27;

	/**
	 * The meta object id for the '{@link generator.Language <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.Language
	 * @see generator.impl.GeneratorPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 28;

	/**
	 * The meta object id for the '{@link generator.HTTPReturnType <em>HTTP Return Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.HTTPReturnType
	 * @see generator.impl.GeneratorPackageImpl#getHTTPReturnType()
	 * @generated
	 */
	int HTTP_RETURN_TYPE = 29;

	/**
	 * The meta object id for the '{@link generator.DefaultEntity <em>Default Entity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.DefaultEntity
	 * @see generator.impl.GeneratorPackageImpl#getDefaultEntity()
	 * @generated
	 */
	int DEFAULT_ENTITY = 30;


	/**
	 * Returns the meta object for class '{@link generator.Bot <em>Bot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bot</em>'.
	 * @see generator.Bot
	 * @generated
	 */
	EClass getBot();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getIntents <em>Intents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intents</em>'.
	 * @see generator.Bot#getIntents()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Intents();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see generator.Bot#getEntities()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see generator.Bot#getActions()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getFlows <em>Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flows</em>'.
	 * @see generator.Bot#getFlows()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Flows();

	/**
	 * Returns the meta object for the attribute '{@link generator.Bot#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see generator.Bot#getLanguage()
	 * @see #getBot()
	 * @generated
	 */
	EAttribute getBot_Language();

	/**
	 * Returns the meta object for class '{@link generator.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see generator.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for class '{@link generator.BotInteraction <em>Bot Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bot Interaction</em>'.
	 * @see generator.BotInteraction
	 * @generated
	 */
	EClass getBotInteraction();

	/**
	 * Returns the meta object for the reference list '{@link generator.BotInteraction#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see generator.BotInteraction#getActions()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_Actions();

	/**
	 * Returns the meta object for the container reference '{@link generator.BotInteraction#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Incoming</em>'.
	 * @see generator.BotInteraction#getIncoming()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_Incoming();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.BotInteraction#getOutcoming <em>Outcoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outcoming</em>'.
	 * @see generator.BotInteraction#getOutcoming()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_Outcoming();

	/**
	 * Returns the meta object for class '{@link generator.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interaction</em>'.
	 * @see generator.UserInteraction
	 * @generated
	 */
	EClass getUserInteraction();

	/**
	 * Returns the meta object for the reference '{@link generator.UserInteraction#getIntent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent</em>'.
	 * @see generator.UserInteraction#getIntent()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Intent();

	/**
	 * Returns the meta object for the container reference '{@link generator.UserInteraction#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see generator.UserInteraction#getSrc()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Src();

	/**
	 * Returns the meta object for the containment reference '{@link generator.UserInteraction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see generator.UserInteraction#getTarget()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Target();

	/**
	 * Returns the meta object for class '{@link generator.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see generator.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link generator.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see generator.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for class '{@link generator.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see generator.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link generator.Simple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple</em>'.
	 * @see generator.Simple
	 * @generated
	 */
	EClass getSimple();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Simple#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Simple#getInputs()
	 * @see #getSimple()
	 * @generated
	 */
	EReference getSimple_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see generator.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Composite#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Composite#getInputs()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.SimpleInput <em>Simple Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Input</em>'.
	 * @see generator.SimpleInput
	 * @generated
	 */
	EClass getSimpleInput();

	/**
	 * Returns the meta object for the attribute list '{@link generator.SimpleInput#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see generator.SimpleInput#getValues()
	 * @see #getSimpleInput()
	 * @generated
	 */
	EAttribute getSimpleInput_Values();

	/**
	 * Returns the meta object for class '{@link generator.CompositeInput <em>Composite Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Input</em>'.
	 * @see generator.CompositeInput
	 * @generated
	 */
	EClass getCompositeInput();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.CompositeInput#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see generator.CompositeInput#getTokens()
	 * @see #getCompositeInput()
	 * @generated
	 */
	EReference getCompositeInput_Tokens();

	/**
	 * Returns the meta object for class '{@link generator.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see generator.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for class '{@link generator.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see generator.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the attribute '{@link generator.Literal#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see generator.Literal#getText()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Text();

	/**
	 * Returns the meta object for class '{@link generator.EntityToken <em>Entity Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Token</em>'.
	 * @see generator.EntityToken
	 * @generated
	 */
	EClass getEntityToken();

	/**
	 * Returns the meta object for the reference '{@link generator.EntityToken#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see generator.EntityToken#getEntity()
	 * @see #getEntityToken()
	 * @generated
	 */
	EReference getEntityToken_Entity();

	/**
	 * Returns the meta object for class '{@link generator.ParameterToken <em>Parameter Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Token</em>'.
	 * @see generator.ParameterToken
	 * @generated
	 */
	EClass getParameterToken();

	/**
	 * Returns the meta object for the reference '{@link generator.ParameterToken#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see generator.ParameterToken#getParameter()
	 * @see #getParameterToken()
	 * @generated
	 */
	EReference getParameterToken_Parameter();

	/**
	 * Returns the meta object for class '{@link generator.ParameterReferenceToken <em>Parameter Reference Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Reference Token</em>'.
	 * @see generator.ParameterReferenceToken
	 * @generated
	 */
	EClass getParameterReferenceToken();

	/**
	 * Returns the meta object for the reference '{@link generator.ParameterReferenceToken#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see generator.ParameterReferenceToken#getParameter()
	 * @see #getParameterReferenceToken()
	 * @generated
	 */
	EReference getParameterReferenceToken_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link generator.ParameterReferenceToken#getTextReference <em>Text Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Reference</em>'.
	 * @see generator.ParameterReferenceToken#getTextReference()
	 * @see #getParameterReferenceToken()
	 * @generated
	 */
	EAttribute getParameterReferenceToken_TextReference();

	/**
	 * Returns the meta object for class '{@link generator.HTTPRequestToke <em>HTTP Request Toke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HTTP Request Toke</em>'.
	 * @see generator.HTTPRequestToke
	 * @generated
	 */
	EClass getHTTPRequestToke();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequestToke#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see generator.HTTPRequestToke#getType()
	 * @see #getHTTPRequestToke()
	 * @generated
	 */
	EAttribute getHTTPRequestToke_Type();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequestToke#getDataKey <em>Data Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Key</em>'.
	 * @see generator.HTTPRequestToke#getDataKey()
	 * @see #getHTTPRequestToke()
	 * @generated
	 */
	EAttribute getHTTPRequestToke_DataKey();

	/**
	 * Returns the meta object for class '{@link generator.Intent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intent</em>'.
	 * @see generator.Intent
	 * @generated
	 */
	EClass getIntent();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Intent#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Intent#getInputs()
	 * @see #getIntent()
	 * @generated
	 */
	EReference getIntent_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Intent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see generator.Intent#getParameters()
	 * @see #getIntent()
	 * @generated
	 */
	EReference getIntent_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link generator.Intent#isFallbackIntent <em>Fallback Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fallback Intent</em>'.
	 * @see generator.Intent#isFallbackIntent()
	 * @see #getIntent()
	 * @generated
	 */
	EAttribute getIntent_FallbackIntent();

	/**
	 * Returns the meta object for class '{@link generator.TrainingPhrase <em>Training Phrase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Training Phrase</em>'.
	 * @see generator.TrainingPhrase
	 * @generated
	 */
	EClass getTrainingPhrase();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.TrainingPhrase#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see generator.TrainingPhrase#getTokens()
	 * @see #getTrainingPhrase()
	 * @generated
	 */
	EReference getTrainingPhrase_Tokens();

	/**
	 * Returns the meta object for class '{@link generator.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see generator.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link generator.Parameter#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see generator.Parameter#getEntity()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Entity();

	/**
	 * Returns the meta object for the attribute '{@link generator.Parameter#getDefaultEntity <em>Default Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Entity</em>'.
	 * @see generator.Parameter#getDefaultEntity()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_DefaultEntity();

	/**
	 * Returns the meta object for the attribute '{@link generator.Parameter#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see generator.Parameter#isRequired()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Required();

	/**
	 * Returns the meta object for the attribute list '{@link generator.Parameter#getPrompts <em>Prompts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Prompts</em>'.
	 * @see generator.Parameter#getPrompts()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Prompts();

	/**
	 * Returns the meta object for the attribute '{@link generator.Parameter#isIsList <em>Is List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is List</em>'.
	 * @see generator.Parameter#isIsList()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_IsList();

	/**
	 * Returns the meta object for class '{@link generator.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see generator.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link generator.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see generator.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link generator.Image#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see generator.Image#getURL()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_URL();

	/**
	 * Returns the meta object for the attribute '{@link generator.Image#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see generator.Image#getCaption()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Caption();

	/**
	 * Returns the meta object for class '{@link generator.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see generator.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Text#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Text#getInputs()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.TextInput <em>Text Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Input</em>'.
	 * @see generator.TextInput
	 * @generated
	 */
	EClass getTextInput();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.TextInput#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see generator.TextInput#getTokens()
	 * @see #getTextInput()
	 * @generated
	 */
	EReference getTextInput_Tokens();

	/**
	 * Returns the meta object for class '{@link generator.HTTPRequest <em>HTTP Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HTTP Request</em>'.
	 * @see generator.HTTPRequest
	 * @generated
	 */
	EClass getHTTPRequest();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequest#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see generator.HTTPRequest#getURL()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EAttribute getHTTPRequest_URL();

	/**
	 * Returns the meta object for the containment reference '{@link generator.HTTPRequest#getBasicAuth <em>Basic Auth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic Auth</em>'.
	 * @see generator.HTTPRequest#getBasicAuth()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EReference getHTTPRequest_BasicAuth();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.HTTPRequest#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Headers</em>'.
	 * @see generator.HTTPRequest#getHeaders()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EReference getHTTPRequest_Headers();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.HTTPRequest#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see generator.HTTPRequest#getData()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EReference getHTTPRequest_Data();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequest#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see generator.HTTPRequest#getDataType()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EAttribute getHTTPRequest_DataType();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequest#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see generator.HTTPRequest#getMethod()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EAttribute getHTTPRequest_Method();

	/**
	 * Returns the meta object for class '{@link generator.HTTPResponse <em>HTTP Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HTTP Response</em>'.
	 * @see generator.HTTPResponse
	 * @generated
	 */
	EClass getHTTPResponse();

	/**
	 * Returns the meta object for the containment reference '{@link generator.HTTPResponse#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inputs</em>'.
	 * @see generator.HTTPResponse#getInputs()
	 * @see #getHTTPResponse()
	 * @generated
	 */
	EReference getHTTPResponse_Inputs();

	/**
	 * Returns the meta object for the reference '{@link generator.HTTPResponse#getHTTPRequest <em>HTTP Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>HTTP Request</em>'.
	 * @see generator.HTTPResponse#getHTTPRequest()
	 * @see #getHTTPResponse()
	 * @generated
	 */
	EReference getHTTPResponse_HTTPRequest();

	/**
	 * Returns the meta object for class '{@link generator.KeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value</em>'.
	 * @see generator.KeyValue
	 * @generated
	 */
	EClass getKeyValue();

	/**
	 * Returns the meta object for the attribute '{@link generator.KeyValue#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see generator.KeyValue#getKey()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Key();

	/**
	 * Returns the meta object for the containment reference '{@link generator.KeyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see generator.KeyValue#getValue()
	 * @see #getKeyValue()
	 * @generated
	 */
	EReference getKeyValue_Value();

	/**
	 * Returns the meta object for enum '{@link generator.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see generator.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link generator.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Method</em>'.
	 * @see generator.Method
	 * @generated
	 */
	EEnum getMethod();

	/**
	 * Returns the meta object for enum '{@link generator.Language <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Language</em>'.
	 * @see generator.Language
	 * @generated
	 */
	EEnum getLanguage();

	/**
	 * Returns the meta object for enum '{@link generator.HTTPReturnType <em>HTTP Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HTTP Return Type</em>'.
	 * @see generator.HTTPReturnType
	 * @generated
	 */
	EEnum getHTTPReturnType();

	/**
	 * Returns the meta object for enum '{@link generator.DefaultEntity <em>Default Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Default Entity</em>'.
	 * @see generator.DefaultEntity
	 * @generated
	 */
	EEnum getDefaultEntity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratorFactory getGeneratorFactory();

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
		 * The meta object literal for the '{@link generator.impl.BotImpl <em>Bot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.BotImpl
		 * @see generator.impl.GeneratorPackageImpl#getBot()
		 * @generated
		 */
		EClass BOT = eINSTANCE.getBot();

		/**
		 * The meta object literal for the '<em><b>Intents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__INTENTS = eINSTANCE.getBot_Intents();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__ENTITIES = eINSTANCE.getBot_Entities();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__ACTIONS = eINSTANCE.getBot_Actions();

		/**
		 * The meta object literal for the '<em><b>Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__FLOWS = eINSTANCE.getBot_Flows();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT__LANGUAGE = eINSTANCE.getBot_Language();

		/**
		 * The meta object literal for the '{@link generator.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.InteractionImpl
		 * @see generator.impl.GeneratorPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '{@link generator.impl.BotInteractionImpl <em>Bot Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.BotInteractionImpl
		 * @see generator.impl.GeneratorPackageImpl#getBotInteraction()
		 * @generated
		 */
		EClass BOT_INTERACTION = eINSTANCE.getBotInteraction();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__ACTIONS = eINSTANCE.getBotInteraction_Actions();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__INCOMING = eINSTANCE.getBotInteraction_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outcoming</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__OUTCOMING = eINSTANCE.getBotInteraction_Outcoming();

		/**
		 * The meta object literal for the '{@link generator.impl.UserInteractionImpl <em>User Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.UserInteractionImpl
		 * @see generator.impl.GeneratorPackageImpl#getUserInteraction()
		 * @generated
		 */
		EClass USER_INTERACTION = eINSTANCE.getUserInteraction();

		/**
		 * The meta object literal for the '<em><b>Intent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__INTENT = eINSTANCE.getUserInteraction_Intent();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__SRC = eINSTANCE.getUserInteraction_Src();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__TARGET = eINSTANCE.getUserInteraction_Target();

		/**
		 * The meta object literal for the '{@link generator.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ElementImpl
		 * @see generator.impl.GeneratorPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '{@link generator.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.EntityImpl
		 * @see generator.impl.GeneratorPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link generator.impl.SimpleImpl <em>Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.SimpleImpl
		 * @see generator.impl.GeneratorPackageImpl#getSimple()
		 * @generated
		 */
		EClass SIMPLE = eINSTANCE.getSimple();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE__INPUTS = eINSTANCE.getSimple_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.CompositeImpl
		 * @see generator.impl.GeneratorPackageImpl#getComposite()
		 * @generated
		 */
		EClass COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__INPUTS = eINSTANCE.getComposite_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.SimpleInputImpl <em>Simple Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.SimpleInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getSimpleInput()
		 * @generated
		 */
		EClass SIMPLE_INPUT = eINSTANCE.getSimpleInput();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_INPUT__VALUES = eINSTANCE.getSimpleInput_Values();

		/**
		 * The meta object literal for the '{@link generator.impl.CompositeInputImpl <em>Composite Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.CompositeInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getCompositeInput()
		 * @generated
		 */
		EClass COMPOSITE_INPUT = eINSTANCE.getCompositeInput();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_INPUT__TOKENS = eINSTANCE.getCompositeInput_Tokens();

		/**
		 * The meta object literal for the '{@link generator.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '{@link generator.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LiteralImpl
		 * @see generator.impl.GeneratorPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__TEXT = eINSTANCE.getLiteral_Text();

		/**
		 * The meta object literal for the '{@link generator.impl.EntityTokenImpl <em>Entity Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.EntityTokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getEntityToken()
		 * @generated
		 */
		EClass ENTITY_TOKEN = eINSTANCE.getEntityToken();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_TOKEN__ENTITY = eINSTANCE.getEntityToken_Entity();

		/**
		 * The meta object literal for the '{@link generator.impl.ParameterTokenImpl <em>Parameter Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ParameterTokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getParameterToken()
		 * @generated
		 */
		EClass PARAMETER_TOKEN = eINSTANCE.getParameterToken();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_TOKEN__PARAMETER = eINSTANCE.getParameterToken_Parameter();

		/**
		 * The meta object literal for the '{@link generator.impl.ParameterReferenceTokenImpl <em>Parameter Reference Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ParameterReferenceTokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getParameterReferenceToken()
		 * @generated
		 */
		EClass PARAMETER_REFERENCE_TOKEN = eINSTANCE.getParameterReferenceToken();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_REFERENCE_TOKEN__PARAMETER = eINSTANCE.getParameterReferenceToken_Parameter();

		/**
		 * The meta object literal for the '<em><b>Text Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE = eINSTANCE.getParameterReferenceToken_TextReference();

		/**
		 * The meta object literal for the '{@link generator.impl.HTTPRequestTokeImpl <em>HTTP Request Toke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.HTTPRequestTokeImpl
		 * @see generator.impl.GeneratorPackageImpl#getHTTPRequestToke()
		 * @generated
		 */
		EClass HTTP_REQUEST_TOKE = eINSTANCE.getHTTPRequestToke();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST_TOKE__TYPE = eINSTANCE.getHTTPRequestToke_Type();

		/**
		 * The meta object literal for the '<em><b>Data Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST_TOKE__DATA_KEY = eINSTANCE.getHTTPRequestToke_DataKey();

		/**
		 * The meta object literal for the '{@link generator.impl.IntentImpl <em>Intent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.IntentImpl
		 * @see generator.impl.GeneratorPackageImpl#getIntent()
		 * @generated
		 */
		EClass INTENT = eINSTANCE.getIntent();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT__INPUTS = eINSTANCE.getIntent_Inputs();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT__PARAMETERS = eINSTANCE.getIntent_Parameters();

		/**
		 * The meta object literal for the '<em><b>Fallback Intent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT__FALLBACK_INTENT = eINSTANCE.getIntent_FallbackIntent();

		/**
		 * The meta object literal for the '{@link generator.impl.TrainingPhraseImpl <em>Training Phrase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TrainingPhraseImpl
		 * @see generator.impl.GeneratorPackageImpl#getTrainingPhrase()
		 * @generated
		 */
		EClass TRAINING_PHRASE = eINSTANCE.getTrainingPhrase();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAINING_PHRASE__TOKENS = eINSTANCE.getTrainingPhrase_Tokens();

		/**
		 * The meta object literal for the '{@link generator.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ParameterImpl
		 * @see generator.impl.GeneratorPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__ENTITY = eINSTANCE.getParameter_Entity();

		/**
		 * The meta object literal for the '<em><b>Default Entity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DEFAULT_ENTITY = eINSTANCE.getParameter_DefaultEntity();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__REQUIRED = eINSTANCE.getParameter_Required();

		/**
		 * The meta object literal for the '<em><b>Prompts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__PROMPTS = eINSTANCE.getParameter_Prompts();

		/**
		 * The meta object literal for the '<em><b>Is List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IS_LIST = eINSTANCE.getParameter_IsList();

		/**
		 * The meta object literal for the '{@link generator.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ActionImpl
		 * @see generator.impl.GeneratorPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link generator.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ImageImpl
		 * @see generator.impl.GeneratorPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__URL = eINSTANCE.getImage_URL();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__CAPTION = eINSTANCE.getImage_Caption();

		/**
		 * The meta object literal for the '{@link generator.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TextImpl
		 * @see generator.impl.GeneratorPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__INPUTS = eINSTANCE.getText_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.TextInputImpl <em>Text Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TextInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getTextInput()
		 * @generated
		 */
		EClass TEXT_INPUT = eINSTANCE.getTextInput();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_INPUT__TOKENS = eINSTANCE.getTextInput_Tokens();

		/**
		 * The meta object literal for the '{@link generator.impl.HTTPRequestImpl <em>HTTP Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.HTTPRequestImpl
		 * @see generator.impl.GeneratorPackageImpl#getHTTPRequest()
		 * @generated
		 */
		EClass HTTP_REQUEST = eINSTANCE.getHTTPRequest();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST__URL = eINSTANCE.getHTTPRequest_URL();

		/**
		 * The meta object literal for the '<em><b>Basic Auth</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_REQUEST__BASIC_AUTH = eINSTANCE.getHTTPRequest_BasicAuth();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_REQUEST__HEADERS = eINSTANCE.getHTTPRequest_Headers();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_REQUEST__DATA = eINSTANCE.getHTTPRequest_Data();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST__DATA_TYPE = eINSTANCE.getHTTPRequest_DataType();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST__METHOD = eINSTANCE.getHTTPRequest_Method();

		/**
		 * The meta object literal for the '{@link generator.impl.HTTPResponseImpl <em>HTTP Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.HTTPResponseImpl
		 * @see generator.impl.GeneratorPackageImpl#getHTTPResponse()
		 * @generated
		 */
		EClass HTTP_RESPONSE = eINSTANCE.getHTTPResponse();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_RESPONSE__INPUTS = eINSTANCE.getHTTPResponse_Inputs();

		/**
		 * The meta object literal for the '<em><b>HTTP Request</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_RESPONSE__HTTP_REQUEST = eINSTANCE.getHTTPResponse_HTTPRequest();

		/**
		 * The meta object literal for the '{@link generator.impl.KeyValueImpl <em>Key Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.KeyValueImpl
		 * @see generator.impl.GeneratorPackageImpl#getKeyValue()
		 * @generated
		 */
		EClass KEY_VALUE = eINSTANCE.getKeyValue();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

		/**
		 * The meta object literal for the '{@link generator.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.DataType
		 * @see generator.impl.GeneratorPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link generator.Method <em>Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.Method
		 * @see generator.impl.GeneratorPackageImpl#getMethod()
		 * @generated
		 */
		EEnum METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '{@link generator.Language <em>Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.Language
		 * @see generator.impl.GeneratorPackageImpl#getLanguage()
		 * @generated
		 */
		EEnum LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '{@link generator.HTTPReturnType <em>HTTP Return Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.HTTPReturnType
		 * @see generator.impl.GeneratorPackageImpl#getHTTPReturnType()
		 * @generated
		 */
		EEnum HTTP_RETURN_TYPE = eINSTANCE.getHTTPReturnType();

		/**
		 * The meta object literal for the '{@link generator.DefaultEntity <em>Default Entity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.DefaultEntity
		 * @see generator.impl.GeneratorPackageImpl#getDefaultEntity()
		 * @generated
		 */
		EEnum DEFAULT_ENTITY = eINSTANCE.getDefaultEntity();

	}

} //GeneratorPackage
