/**
 */
package projectHistory.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import projectHistory.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProjectHistoryFactoryImpl extends EFactoryImpl implements ProjectHistoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProjectHistoryFactory init() {
		try {
			ProjectHistoryFactory theProjectHistoryFactory = (ProjectHistoryFactory)EPackage.Registry.INSTANCE.getEFactory(ProjectHistoryPackage.eNS_URI);
			if (theProjectHistoryFactory != null) {
				return theProjectHistoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProjectHistoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectHistoryFactoryImpl() {
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
			case ProjectHistoryPackage.HISTORY: return createHistory();
			case ProjectHistoryPackage.CREATE_MSG: return createCreateMsg();
			case ProjectHistoryPackage.MSG: return createMsg();
			case ProjectHistoryPackage.SENTENCE: return createSentence();
			case ProjectHistoryPackage.ADD: return createAdd();
			case ProjectHistoryPackage.DELETE: return createDelete();
			case ProjectHistoryPackage.UPDATE: return createUpdate();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public History createHistory() {
		HistoryImpl history = new HistoryImpl();
		return history;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateMsg createCreateMsg() {
		CreateMsgImpl createMsg = new CreateMsgImpl();
		return createMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Msg createMsg() {
		MsgImpl msg = new MsgImpl();
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sentence createSentence() {
		SentenceImpl sentence = new SentenceImpl();
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Add createAdd() {
		AddImpl add = new AddImpl();
		return add;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete createDelete() {
		DeleteImpl delete = new DeleteImpl();
		return delete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Update createUpdate() {
		UpdateImpl update = new UpdateImpl();
		return update;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectHistoryPackage getProjectHistoryPackage() {
		return (ProjectHistoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProjectHistoryPackage getPackage() {
		return ProjectHistoryPackage.eINSTANCE;
	}

} //ProjectHistoryFactoryImpl
