/**
 */
package generator.impl;

import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.Composite;
import generator.CompositeInput;
import generator.DataType;
import generator.DefaultEntity;
import generator.Element;
import generator.Entity;
import generator.EntityToken;
import generator.GeneratorFactory;
import generator.GeneratorPackage;
import generator.HTTPRequest;
import generator.HTTPRequestToke;
import generator.HTTPResponse;
import generator.HTTPReturnType;
import generator.Image;
import generator.Intent;
import generator.Interaction;
import generator.KeyValue;
import generator.Language;
import generator.Literal;
import generator.Method;
import generator.Parameter;
import generator.ParameterReferenceToken;
import generator.ParameterToken;
import generator.Simple;
import generator.SimpleInput;
import generator.Text;
import generator.TextInput;
import generator.Token;
import generator.TrainingPhrase;
import generator.UserInteraction;

import generator.util.GeneratorValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorPackageImpl extends EPackageImpl implements GeneratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass botEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass botInteractionEClass = null;

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
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterReferenceTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpRequestTokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trainingPhraseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

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
	private EClass imageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass httpResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum methodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum languageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum httpReturnTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum defaultEntityEEnum = null;

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
	 * @see generator.GeneratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeneratorPackageImpl() {
		super(eNS_URI, GeneratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GeneratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeneratorPackage init() {
		if (isInited) return (GeneratorPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratorPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGeneratorPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GeneratorPackageImpl theGeneratorPackage = registeredGeneratorPackage instanceof GeneratorPackageImpl ? (GeneratorPackageImpl)registeredGeneratorPackage : new GeneratorPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theGeneratorPackage.createPackageContents();

		// Initialize created meta-data
		theGeneratorPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theGeneratorPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return GeneratorValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theGeneratorPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, theGeneratorPackage);
		return theGeneratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBot() {
		return botEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBot_Intents() {
		return (EReference)botEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBot_Entities() {
		return (EReference)botEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBot_Actions() {
		return (EReference)botEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBot_Flows() {
		return (EReference)botEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBot_Languages() {
		return (EAttribute)botEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInteraction() {
		return interactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBotInteraction() {
		return botInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBotInteraction_Actions() {
		return (EReference)botInteractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBotInteraction_Incoming() {
		return (EReference)botInteractionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBotInteraction_Outcoming() {
		return (EReference)botInteractionEClass.getEStructuralFeatures().get(2);
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
	public EReference getUserInteraction_Intent() {
		return (EReference)userInteractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserInteraction_Src() {
		return (EReference)userInteractionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserInteraction_Target() {
		return (EReference)userInteractionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElement_Name() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntity_Language() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimple() {
		return simpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimple_Inputs() {
		return (EReference)simpleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComposite() {
		return compositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComposite_Inputs() {
		return (EReference)compositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleInput() {
		return simpleInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleInput_Values() {
		return (EAttribute)simpleInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeInput() {
		return compositeInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeInput_Tokens() {
		return (EReference)compositeInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getToken() {
		return tokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteral_Text() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityToken() {
		return entityTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntityToken_Entity() {
		return (EReference)entityTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterToken() {
		return parameterTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameterToken_Parameter() {
		return (EReference)parameterTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterReferenceToken() {
		return parameterReferenceTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameterReferenceToken_Parameter() {
		return (EReference)parameterReferenceTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameterReferenceToken_TextReference() {
		return (EAttribute)parameterReferenceTokenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHTTPRequestToke() {
		return httpRequestTokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHTTPRequestToke_Type() {
		return (EAttribute)httpRequestTokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHTTPRequestToke_DataKey() {
		return (EAttribute)httpRequestTokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntent() {
		return intentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntent_Inputs() {
		return (EReference)intentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntent_Parameters() {
		return (EReference)intentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntent_FallbackIntent() {
		return (EAttribute)intentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntent_Language() {
		return (EAttribute)intentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTrainingPhrase() {
		return trainingPhraseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTrainingPhrase_Tokens() {
		return (EReference)trainingPhraseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Entity() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_DefaultEntity() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_Required() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_Prompts() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_IsList() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_PrompLanguage() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(5);
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
	public EClass getImage() {
		return imageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_URL() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Caption() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getText() {
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getText_Inputs() {
		return (EReference)textEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getText_Language() {
		return (EAttribute)textEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTextInput() {
		return textInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTextInput_Tokens() {
		return (EReference)textInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHTTPRequest() {
		return httpRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHTTPRequest_URL() {
		return (EAttribute)httpRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHTTPRequest_BasicAuth() {
		return (EReference)httpRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHTTPRequest_Headers() {
		return (EReference)httpRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHTTPRequest_Data() {
		return (EReference)httpRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHTTPRequest_DataType() {
		return (EAttribute)httpRequestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHTTPRequest_Method() {
		return (EAttribute)httpRequestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHTTPResponse() {
		return httpResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHTTPResponse_Inputs() {
		return (EReference)httpResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHTTPResponse_HTTPRequest() {
		return (EReference)httpResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyValue() {
		return keyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getKeyValue_Key() {
		return (EAttribute)keyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyValue_Value() {
		return (EReference)keyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDataType() {
		return dataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMethod() {
		return methodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getLanguage() {
		return languageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getHTTPReturnType() {
		return httpReturnTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDefaultEntity() {
		return defaultEntityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GeneratorFactory getGeneratorFactory() {
		return (GeneratorFactory)getEFactoryInstance();
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
		botEClass = createEClass(BOT);
		createEReference(botEClass, BOT__INTENTS);
		createEReference(botEClass, BOT__ENTITIES);
		createEReference(botEClass, BOT__ACTIONS);
		createEReference(botEClass, BOT__FLOWS);
		createEAttribute(botEClass, BOT__LANGUAGES);

		interactionEClass = createEClass(INTERACTION);

		botInteractionEClass = createEClass(BOT_INTERACTION);
		createEReference(botInteractionEClass, BOT_INTERACTION__ACTIONS);
		createEReference(botInteractionEClass, BOT_INTERACTION__INCOMING);
		createEReference(botInteractionEClass, BOT_INTERACTION__OUTCOMING);

		userInteractionEClass = createEClass(USER_INTERACTION);
		createEReference(userInteractionEClass, USER_INTERACTION__INTENT);
		createEReference(userInteractionEClass, USER_INTERACTION__SRC);
		createEReference(userInteractionEClass, USER_INTERACTION__TARGET);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__NAME);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__LANGUAGE);

		simpleEClass = createEClass(SIMPLE);
		createEReference(simpleEClass, SIMPLE__INPUTS);

		compositeEClass = createEClass(COMPOSITE);
		createEReference(compositeEClass, COMPOSITE__INPUTS);

		simpleInputEClass = createEClass(SIMPLE_INPUT);
		createEAttribute(simpleInputEClass, SIMPLE_INPUT__VALUES);

		compositeInputEClass = createEClass(COMPOSITE_INPUT);
		createEReference(compositeInputEClass, COMPOSITE_INPUT__TOKENS);

		tokenEClass = createEClass(TOKEN);

		literalEClass = createEClass(LITERAL);
		createEAttribute(literalEClass, LITERAL__TEXT);

		entityTokenEClass = createEClass(ENTITY_TOKEN);
		createEReference(entityTokenEClass, ENTITY_TOKEN__ENTITY);

		parameterTokenEClass = createEClass(PARAMETER_TOKEN);
		createEReference(parameterTokenEClass, PARAMETER_TOKEN__PARAMETER);

		parameterReferenceTokenEClass = createEClass(PARAMETER_REFERENCE_TOKEN);
		createEReference(parameterReferenceTokenEClass, PARAMETER_REFERENCE_TOKEN__PARAMETER);
		createEAttribute(parameterReferenceTokenEClass, PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE);

		httpRequestTokeEClass = createEClass(HTTP_REQUEST_TOKE);
		createEAttribute(httpRequestTokeEClass, HTTP_REQUEST_TOKE__TYPE);
		createEAttribute(httpRequestTokeEClass, HTTP_REQUEST_TOKE__DATA_KEY);

		intentEClass = createEClass(INTENT);
		createEReference(intentEClass, INTENT__INPUTS);
		createEReference(intentEClass, INTENT__PARAMETERS);
		createEAttribute(intentEClass, INTENT__FALLBACK_INTENT);
		createEAttribute(intentEClass, INTENT__LANGUAGE);

		trainingPhraseEClass = createEClass(TRAINING_PHRASE);
		createEReference(trainingPhraseEClass, TRAINING_PHRASE__TOKENS);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__ENTITY);
		createEAttribute(parameterEClass, PARAMETER__DEFAULT_ENTITY);
		createEAttribute(parameterEClass, PARAMETER__REQUIRED);
		createEAttribute(parameterEClass, PARAMETER__PROMPTS);
		createEAttribute(parameterEClass, PARAMETER__IS_LIST);
		createEAttribute(parameterEClass, PARAMETER__PROMP_LANGUAGE);

		actionEClass = createEClass(ACTION);

		imageEClass = createEClass(IMAGE);
		createEAttribute(imageEClass, IMAGE__URL);
		createEAttribute(imageEClass, IMAGE__CAPTION);

		textEClass = createEClass(TEXT);
		createEReference(textEClass, TEXT__INPUTS);
		createEAttribute(textEClass, TEXT__LANGUAGE);

		textInputEClass = createEClass(TEXT_INPUT);
		createEReference(textInputEClass, TEXT_INPUT__TOKENS);

		httpRequestEClass = createEClass(HTTP_REQUEST);
		createEAttribute(httpRequestEClass, HTTP_REQUEST__URL);
		createEReference(httpRequestEClass, HTTP_REQUEST__BASIC_AUTH);
		createEReference(httpRequestEClass, HTTP_REQUEST__HEADERS);
		createEReference(httpRequestEClass, HTTP_REQUEST__DATA);
		createEAttribute(httpRequestEClass, HTTP_REQUEST__DATA_TYPE);
		createEAttribute(httpRequestEClass, HTTP_REQUEST__METHOD);

		httpResponseEClass = createEClass(HTTP_RESPONSE);
		createEReference(httpResponseEClass, HTTP_RESPONSE__INPUTS);
		createEReference(httpResponseEClass, HTTP_RESPONSE__HTTP_REQUEST);

		keyValueEClass = createEClass(KEY_VALUE);
		createEAttribute(keyValueEClass, KEY_VALUE__KEY);
		createEReference(keyValueEClass, KEY_VALUE__VALUE);

		// Create enums
		dataTypeEEnum = createEEnum(DATA_TYPE);
		methodEEnum = createEEnum(METHOD);
		languageEEnum = createEEnum(LANGUAGE);
		httpReturnTypeEEnum = createEEnum(HTTP_RETURN_TYPE);
		defaultEntityEEnum = createEEnum(DEFAULT_ENTITY);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		botEClass.getESuperTypes().add(this.getElement());
		botInteractionEClass.getESuperTypes().add(this.getInteraction());
		userInteractionEClass.getESuperTypes().add(this.getInteraction());
		entityEClass.getESuperTypes().add(this.getElement());
		simpleEClass.getESuperTypes().add(this.getEntity());
		compositeEClass.getESuperTypes().add(this.getEntity());
		simpleInputEClass.getESuperTypes().add(this.getElement());
		literalEClass.getESuperTypes().add(this.getToken());
		entityTokenEClass.getESuperTypes().add(this.getToken());
		parameterTokenEClass.getESuperTypes().add(this.getToken());
		parameterReferenceTokenEClass.getESuperTypes().add(this.getToken());
		httpRequestTokeEClass.getESuperTypes().add(this.getToken());
		intentEClass.getESuperTypes().add(this.getElement());
		parameterEClass.getESuperTypes().add(this.getElement());
		actionEClass.getESuperTypes().add(this.getElement());
		imageEClass.getESuperTypes().add(this.getAction());
		textEClass.getESuperTypes().add(this.getAction());
		httpRequestEClass.getESuperTypes().add(this.getAction());
		httpResponseEClass.getESuperTypes().add(this.getAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(botEClass, Bot.class, "Bot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBot_Intents(), this.getIntent(), null, "intents", null, 1, -1, Bot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBot_Entities(), this.getEntity(), null, "entities", null, 0, -1, Bot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBot_Actions(), this.getAction(), null, "actions", null, 0, -1, Bot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBot_Flows(), this.getUserInteraction(), null, "flows", null, 1, -1, Bot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBot_Languages(), this.getLanguage(), "languages", null, 1, -1, Bot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionEClass, Interaction.class, "Interaction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(botInteractionEClass, BotInteraction.class, "BotInteraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBotInteraction_Actions(), this.getAction(), null, "actions", null, 0, -1, BotInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBotInteraction_Incoming(), this.getUserInteraction(), this.getUserInteraction_Target(), "incoming", null, 1, 1, BotInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBotInteraction_Outcoming(), this.getUserInteraction(), this.getUserInteraction_Src(), "outcoming", null, 0, -1, BotInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userInteractionEClass, UserInteraction.class, "UserInteraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserInteraction_Intent(), this.getIntent(), null, "intent", null, 1, 1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserInteraction_Src(), this.getBotInteraction(), this.getBotInteraction_Outcoming(), "src", null, 0, 1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserInteraction_Target(), this.getBotInteraction(), this.getBotInteraction_Incoming(), "target", null, 0, 1, UserInteraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Language(), this.getLanguage(), "language", "EMPTY", 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleEClass, Simple.class, "Simple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimple_Inputs(), this.getSimpleInput(), null, "inputs", null, 0, -1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeEClass, Composite.class, "Composite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposite_Inputs(), this.getCompositeInput(), null, "inputs", null, 0, -1, Composite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleInputEClass, SimpleInput.class, "SimpleInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleInput_Values(), ecorePackage.getEString(), "values", null, 0, -1, SimpleInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeInputEClass, CompositeInput.class, "CompositeInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeInput_Tokens(), this.getToken(), null, "tokens", null, 1, -1, CompositeInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tokenEClass, Token.class, "Token", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteral_Text(), ecorePackage.getEString(), "text", null, 1, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityTokenEClass, EntityToken.class, "EntityToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityToken_Entity(), this.getEntity(), null, "entity", null, 1, 1, EntityToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterTokenEClass, ParameterToken.class, "ParameterToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterToken_Parameter(), this.getParameter(), null, "parameter", null, 1, 1, ParameterToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterReferenceTokenEClass, ParameterReferenceToken.class, "ParameterReferenceToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterReferenceToken_Parameter(), this.getParameter(), null, "parameter", null, 1, 1, ParameterReferenceToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterReferenceToken_TextReference(), ecorePackage.getEString(), "textReference", null, 1, 1, ParameterReferenceToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(httpRequestTokeEClass, HTTPRequestToke.class, "HTTPRequestToke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHTTPRequestToke_Type(), this.getHTTPReturnType(), "type", null, 1, 1, HTTPRequestToke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHTTPRequestToke_DataKey(), ecorePackage.getEString(), "dataKey", null, 0, 1, HTTPRequestToke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentEClass, Intent.class, "Intent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntent_Inputs(), this.getTrainingPhrase(), null, "inputs", null, 1, -1, Intent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntent_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Intent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntent_FallbackIntent(), ecorePackage.getEBoolean(), "fallbackIntent", null, 1, 1, Intent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntent_Language(), this.getLanguage(), "language", "EMPTY", 0, 1, Intent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trainingPhraseEClass, TrainingPhrase.class, "TrainingPhrase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrainingPhrase_Tokens(), this.getToken(), null, "tokens", null, 0, -1, TrainingPhrase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Entity(), this.getEntity(), null, "entity", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_DefaultEntity(), this.getDefaultEntity(), "defaultEntity", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Required(), ecorePackage.getEBoolean(), "required", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Prompts(), ecorePackage.getEString(), "prompts", null, 0, -1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_IsList(), ecorePackage.getEBoolean(), "isList", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_PrompLanguage(), this.getLanguage(), "prompLanguage", "EMPTY", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImage_URL(), ecorePackage.getEString(), "URL", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Caption(), ecorePackage.getEString(), "caption", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getText_Inputs(), this.getTextInput(), null, "inputs", null, 1, -1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getText_Language(), this.getLanguage(), "language", "EMPTY", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textInputEClass, TextInput.class, "TextInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextInput_Tokens(), this.getToken(), null, "tokens", null, 1, -1, TextInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(httpRequestEClass, HTTPRequest.class, "HTTPRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHTTPRequest_URL(), ecorePackage.getEString(), "URL", null, 1, 1, HTTPRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHTTPRequest_BasicAuth(), this.getKeyValue(), null, "basicAuth", null, 0, 1, HTTPRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHTTPRequest_Headers(), this.getKeyValue(), null, "headers", null, 0, -1, HTTPRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHTTPRequest_Data(), this.getKeyValue(), null, "data", null, 0, -1, HTTPRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHTTPRequest_DataType(), this.getDataType(), "dataType", null, 1, 1, HTTPRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHTTPRequest_Method(), this.getMethod(), "method", null, 1, 1, HTTPRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(httpResponseEClass, HTTPResponse.class, "HTTPResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHTTPResponse_Inputs(), this.getTextInput(), null, "inputs", null, 1, 1, HTTPResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHTTPResponse_HTTPRequest(), this.getHTTPRequest(), null, "HTTPRequest", null, 1, 1, HTTPResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyValueEClass, KeyValue.class, "KeyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeyValue_Key(), ecorePackage.getEString(), "key", null, 1, 1, KeyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyValue_Value(), this.getToken(), null, "value", null, 1, 1, KeyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.JSON);
		addEEnumLiteral(dataTypeEEnum, DataType.FORM);

		initEEnum(methodEEnum, Method.class, "Method");
		addEEnumLiteral(methodEEnum, Method.GET);
		addEEnumLiteral(methodEEnum, Method.POST);

		initEEnum(languageEEnum, Language.class, "Language");
		addEEnumLiteral(languageEEnum, Language.ENGLISH);
		addEEnumLiteral(languageEEnum, Language.SPANISH);
		addEEnumLiteral(languageEEnum, Language.DANISH);
		addEEnumLiteral(languageEEnum, Language.GERMAN);
		addEEnumLiteral(languageEEnum, Language.FRENCH);
		addEEnumLiteral(languageEEnum, Language.HINDI);
		addEEnumLiteral(languageEEnum, Language.INDONESIAN);
		addEEnumLiteral(languageEEnum, Language.ITALIAN);
		addEEnumLiteral(languageEEnum, Language.JAPANESE);
		addEEnumLiteral(languageEEnum, Language.KOREAN);
		addEEnumLiteral(languageEEnum, Language.DUTCH);
		addEEnumLiteral(languageEEnum, Language.NORWEGIAN);
		addEEnumLiteral(languageEEnum, Language.POLISH);
		addEEnumLiteral(languageEEnum, Language.PORTUGUESE);
		addEEnumLiteral(languageEEnum, Language.RUSIAN);
		addEEnumLiteral(languageEEnum, Language.SWEDISH);
		addEEnumLiteral(languageEEnum, Language.THAI);
		addEEnumLiteral(languageEEnum, Language.TURKISH);
		addEEnumLiteral(languageEEnum, Language.UKRANIAN);
		addEEnumLiteral(languageEEnum, Language.CHINESE);
		addEEnumLiteral(languageEEnum, Language.ARABIC);
		addEEnumLiteral(languageEEnum, Language.CZECH);
		addEEnumLiteral(languageEEnum, Language.BULGARIAN);
		addEEnumLiteral(languageEEnum, Language.FINISH);
		addEEnumLiteral(languageEEnum, Language.GREEK);
		addEEnumLiteral(languageEEnum, Language.BANGLA);
		addEEnumLiteral(languageEEnum, Language.EMPTY);

		initEEnum(httpReturnTypeEEnum, HTTPReturnType.class, "HTTPReturnType");
		addEEnumLiteral(httpReturnTypeEEnum, HTTPReturnType.TEXT);
		addEEnumLiteral(httpReturnTypeEEnum, HTTPReturnType.STATUS_CODE);
		addEEnumLiteral(httpReturnTypeEEnum, HTTPReturnType.IMAGE);
		addEEnumLiteral(httpReturnTypeEEnum, HTTPReturnType.DATA);

		initEEnum(defaultEntityEEnum, DefaultEntity.class, "DefaultEntity");
		addEEnumLiteral(defaultEntityEEnum, DefaultEntity.TEXT);
		addEEnumLiteral(defaultEntityEEnum, DefaultEntity.NUMBER);
		addEEnumLiteral(defaultEntityEEnum, DefaultEntity.DATE);
		addEEnumLiteral(defaultEntityEEnum, DefaultEntity.FLOAT);
		addEEnumLiteral(defaultEntityEEnum, DefaultEntity.TIME);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
		addAnnotation
		  (compositeInputEClass,
		   source,
		   new String[] {
			   "constraints", "tokenComplexEntity"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (compositeInputEClass,
		   source,
		   new String[] {
			   "tokenComplexEntity", "\n\t\t\tself.tokens->forAll(t| t.oclIsTypeOf(Literal) or t.oclIsTypeOf(EntityToken))"
		   });
	}

} //GeneratorPackageImpl
