/**
 */
package generator.util;

import generator.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see generator.GeneratorPackage
 * @generated
 */
public class GeneratorValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GeneratorValidator INSTANCE = new GeneratorValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "generator";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GeneratorPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case GeneratorPackage.BOT:
				return validateBot((Bot)value, diagnostics, context);
			case GeneratorPackage.INTERACTION:
				return validateInteraction((Interaction)value, diagnostics, context);
			case GeneratorPackage.BOT_INTERACTION:
				return validateBotInteraction((BotInteraction)value, diagnostics, context);
			case GeneratorPackage.USER_INTERACTION:
				return validateUserInteraction((UserInteraction)value, diagnostics, context);
			case GeneratorPackage.ELEMENT:
				return validateElement((Element)value, diagnostics, context);
			case GeneratorPackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case GeneratorPackage.SIMPLE:
				return validateSimple((Simple)value, diagnostics, context);
			case GeneratorPackage.COMPOSITE:
				return validateComposite((Composite)value, diagnostics, context);
			case GeneratorPackage.SIMPLE_INPUT:
				return validateSimpleInput((SimpleInput)value, diagnostics, context);
			case GeneratorPackage.COMPOSITE_INPUT:
				return validateCompositeInput((CompositeInput)value, diagnostics, context);
			case GeneratorPackage.TOKEN:
				return validateToken((Token)value, diagnostics, context);
			case GeneratorPackage.LITERAL:
				return validateLiteral((Literal)value, diagnostics, context);
			case GeneratorPackage.ENTITY_TOKEN:
				return validateEntityToken((EntityToken)value, diagnostics, context);
			case GeneratorPackage.PARAMETER_TOKEN:
				return validateParameterToken((ParameterToken)value, diagnostics, context);
			case GeneratorPackage.PARAMETER_REFERENCE_TOKEN:
				return validateParameterReferenceToken((ParameterReferenceToken)value, diagnostics, context);
			case GeneratorPackage.HTTP_REQUEST_TOKE:
				return validateHTTPRequestToke((HTTPRequestToke)value, diagnostics, context);
			case GeneratorPackage.INTENT:
				return validateIntent((Intent)value, diagnostics, context);
			case GeneratorPackage.TRAINING_PHRASE:
				return validateTrainingPhrase((TrainingPhrase)value, diagnostics, context);
			case GeneratorPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case GeneratorPackage.ACTION:
				return validateAction((Action)value, diagnostics, context);
			case GeneratorPackage.IMAGE:
				return validateImage((Image)value, diagnostics, context);
			case GeneratorPackage.TEXT:
				return validateText((Text)value, diagnostics, context);
			case GeneratorPackage.TEXT_INPUT:
				return validateTextInput((TextInput)value, diagnostics, context);
			case GeneratorPackage.HTTP_REQUEST:
				return validateHTTPRequest((HTTPRequest)value, diagnostics, context);
			case GeneratorPackage.HTTP_RESPONSE:
				return validateHTTPResponse((HTTPResponse)value, diagnostics, context);
			case GeneratorPackage.KEY_VALUE:
				return validateKeyValue((KeyValue)value, diagnostics, context);
			case GeneratorPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case GeneratorPackage.METHOD:
				return validateMethod((Method)value, diagnostics, context);
			case GeneratorPackage.LANGUAGE:
				return validateLanguage((Language)value, diagnostics, context);
			case GeneratorPackage.HTTP_RETURN_TYPE:
				return validateHTTPReturnType((HTTPReturnType)value, diagnostics, context);
			case GeneratorPackage.DEFAULT_ENTITY:
				return validateDefaultEntity((DefaultEntity)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBot(Bot bot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteraction(Interaction interaction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interaction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBotInteraction(BotInteraction botInteraction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(botInteraction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUserInteraction(UserInteraction userInteraction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(userInteraction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(element, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimple(Simple simple, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(simple, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComposite(Composite composite, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(composite, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleInput(SimpleInput simpleInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(simpleInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeInput(CompositeInput compositeInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(compositeInput, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compositeInput, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompositeInput_tokenComplexEntity(compositeInput, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the tokenComplexEntity constraint of '<em>Composite Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String COMPOSITE_INPUT__TOKEN_COMPLEX_ENTITY__EEXPRESSION = "\n" +
		"\t\t\tself.tokens->forAll(t| t.oclIsTypeOf(Literal) or t.oclIsTypeOf(EntityToken))";

	/**
	 * Validates the tokenComplexEntity constraint of '<em>Composite Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeInput_tokenComplexEntity(CompositeInput compositeInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(GeneratorPackage.Literals.COMPOSITE_INPUT,
				 compositeInput,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "tokenComplexEntity",
				 COMPOSITE_INPUT__TOKEN_COMPLEX_ENTITY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateToken(Token token, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(token, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteral(Literal literal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(literal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntityToken(EntityToken entityToken, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entityToken, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterToken(ParameterToken parameterToken, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterToken, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterReferenceToken(ParameterReferenceToken parameterReferenceToken, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterReferenceToken, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHTTPRequestToke(HTTPRequestToke httpRequestToke, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(httpRequestToke, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntent(Intent intent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrainingPhrase(TrainingPhrase trainingPhrase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(trainingPhrase, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction(Action action, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(action, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImage(Image image, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(image, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateText(Text text, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(text, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTextInput(TextInput textInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(textInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHTTPRequest(HTTPRequest httpRequest, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(httpRequest, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHTTPResponse(HTTPResponse httpResponse, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(httpResponse, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKeyValue(KeyValue keyValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(keyValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethod(Method method, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLanguage(Language language, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHTTPReturnType(HTTPReturnType httpReturnType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDefaultEntity(DefaultEntity defaultEntity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //GeneratorValidator
