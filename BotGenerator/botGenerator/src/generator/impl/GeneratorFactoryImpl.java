/**
 */
package generator.impl;

import generator.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorFactoryImpl extends EFactoryImpl implements GeneratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorFactory init() {
		try {
			GeneratorFactory theGeneratorFactory = (GeneratorFactory)EPackage.Registry.INSTANCE.getEFactory(GeneratorPackage.eNS_URI);
			if (theGeneratorFactory != null) {
				return theGeneratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GeneratorPackage.BOT: return createBot();
			case GeneratorPackage.BOT_INTERACTION: return createBotInteraction();
			case GeneratorPackage.USER_INTERACTION: return createUserInteraction();
			case GeneratorPackage.SIMPLE: return createSimple();
			case GeneratorPackage.COMPOSITE: return createComposite();
			case GeneratorPackage.SIMPLE_INPUT: return createSimpleInput();
			case GeneratorPackage.COMPOSITE_INPUT: return createCompositeInput();
			case GeneratorPackage.LITERAL: return createLiteral();
			case GeneratorPackage.ENTITY_TOKEN: return createEntityToken();
			case GeneratorPackage.PARAMETER_TOKEN: return createParameterToken();
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN: return createParameterReferenceToken();
			case GeneratorPackage.HTTP_REQUEST_TOKE: return createHTTPRequestToke();
			case GeneratorPackage.INTENT: return createIntent();
			case GeneratorPackage.TRAINING_PHRASE: return createTrainingPhrase();
			case GeneratorPackage.PARAMETER: return createParameter();
			case GeneratorPackage.IMAGE: return createImage();
			case GeneratorPackage.TEXT: return createText();
			case GeneratorPackage.TEXT_INPUT: return createTextInput();
			case GeneratorPackage.HTTP_REQUEST: return createHTTPRequest();
			case GeneratorPackage.HTTP_RESPONSE: return createHTTPResponse();
			case GeneratorPackage.KEY_VALUE: return createKeyValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GeneratorPackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
			case GeneratorPackage.METHOD:
				return createMethodFromString(eDataType, initialValue);
			case GeneratorPackage.LANGUAGE:
				return createLanguageFromString(eDataType, initialValue);
			case GeneratorPackage.HTTP_RETURN_TYPE:
				return createHTTPReturnTypeFromString(eDataType, initialValue);
			case GeneratorPackage.DEFAULT_ENTITY:
				return createDefaultEntityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GeneratorPackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			case GeneratorPackage.METHOD:
				return convertMethodToString(eDataType, instanceValue);
			case GeneratorPackage.LANGUAGE:
				return convertLanguageToString(eDataType, instanceValue);
			case GeneratorPackage.HTTP_RETURN_TYPE:
				return convertHTTPReturnTypeToString(eDataType, instanceValue);
			case GeneratorPackage.DEFAULT_ENTITY:
				return convertDefaultEntityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bot createBot() {
		BotImpl bot = new BotImpl();
		return bot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BotInteraction createBotInteraction() {
		BotInteractionImpl botInteraction = new BotInteractionImpl();
		return botInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserInteraction createUserInteraction() {
		UserInteractionImpl userInteraction = new UserInteractionImpl();
		return userInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Simple createSimple() {
		SimpleImpl simple = new SimpleImpl();
		return simple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Composite createComposite() {
		CompositeImpl composite = new CompositeImpl();
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleInput createSimpleInput() {
		SimpleInputImpl simpleInput = new SimpleInputImpl();
		return simpleInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeInput createCompositeInput() {
		CompositeInputImpl compositeInput = new CompositeInputImpl();
		return compositeInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityToken createEntityToken() {
		EntityTokenImpl entityToken = new EntityTokenImpl();
		return entityToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterToken createParameterToken() {
		ParameterTokenImpl parameterToken = new ParameterTokenImpl();
		return parameterToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterReferenceToken createParameterReferenceToken() {
		ParameterReferenceTokenImpl parameterReferenceToken = new ParameterReferenceTokenImpl();
		return parameterReferenceToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HTTPRequestToke createHTTPRequestToke() {
		HTTPRequestTokeImpl httpRequestToke = new HTTPRequestTokeImpl();
		return httpRequestToke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Intent createIntent() {
		IntentImpl intent = new IntentImpl();
		return intent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TrainingPhrase createTrainingPhrase() {
		TrainingPhraseImpl trainingPhrase = new TrainingPhraseImpl();
		return trainingPhrase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TextInput createTextInput() {
		TextInputImpl textInput = new TextInputImpl();
		return textInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HTTPRequest createHTTPRequest() {
		HTTPRequestImpl httpRequest = new HTTPRequestImpl();
		return httpRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HTTPResponse createHTTPResponse() {
		HTTPResponseImpl httpResponse = new HTTPResponseImpl();
		return httpResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyValue createKeyValue() {
		KeyValueImpl keyValue = new KeyValueImpl();
		return keyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
		DataType result = DataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethodFromString(EDataType eDataType, String initialValue) {
		Method result = Method.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language createLanguageFromString(EDataType eDataType, String initialValue) {
		Language result = Language.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPReturnType createHTTPReturnTypeFromString(EDataType eDataType, String initialValue) {
		HTTPReturnType result = HTTPReturnType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHTTPReturnTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultEntity createDefaultEntityFromString(EDataType eDataType, String initialValue) {
		DefaultEntity result = DefaultEntity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultEntityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GeneratorPackage getGeneratorPackage() {
		return (GeneratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneratorPackage getPackage() {
		return GeneratorPackage.eINSTANCE;
	}

} //GeneratorFactoryImpl
