/**
 */
package branchDecision.impl;

import branchDecision.*;

import org.eclipse.emf.ecore.EClass;
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
public class BranchDecisionFactoryImpl extends EFactoryImpl implements BranchDecisionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BranchDecisionFactory init() {
		try {
			BranchDecisionFactory theBranchDecisionFactory = (BranchDecisionFactory)EPackage.Registry.INSTANCE.getEFactory(BranchDecisionPackage.eNS_URI);
			if (theBranchDecisionFactory != null) {
				return theBranchDecisionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BranchDecisionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchDecisionFactoryImpl() {
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
			case BranchDecisionPackage.CONSENSUS: return createConsensus();
			case BranchDecisionPackage.ROUND: return createRound();
			case BranchDecisionPackage.PREFERENCE_ORDERING: return createPreferenceOrdering();
			case BranchDecisionPackage.ORDER: return createOrder();
			case BranchDecisionPackage.ADMIN_CHOICE: return createAdminChoice();
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
	public Consensus createConsensus() {
		ConsensusImpl consensus = new ConsensusImpl();
		return consensus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Round createRound() {
		RoundImpl round = new RoundImpl();
		return round;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreferenceOrdering createPreferenceOrdering() {
		PreferenceOrderingImpl preferenceOrdering = new PreferenceOrderingImpl();
		return preferenceOrdering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Order createOrder() {
		OrderImpl order = new OrderImpl();
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AdminChoice createAdminChoice() {
		AdminChoiceImpl adminChoice = new AdminChoiceImpl();
		return adminChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BranchDecisionPackage getBranchDecisionPackage() {
		return (BranchDecisionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BranchDecisionPackage getPackage() {
		return BranchDecisionPackage.eINSTANCE;
	}

} //BranchDecisionFactoryImpl
