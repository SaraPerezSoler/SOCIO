/**
 */
package modelInfo.util;

import modelInfo.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see modelInfo.ModelInfoPackage
 * @generated
 */
public class ModelInfoAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelInfoPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelInfoAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelInfoPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelInfoSwitch<Adapter> modelSwitch =
		new ModelInfoSwitch<Adapter>() {
			@Override
			public Adapter caseNLModel(NLModel object) {
				return createNLModelAdapter();
			}
			@Override
			public Adapter caseNLElement(NLElement object) {
				return createNLElementAdapter();
			}
			@Override
			public Adapter caseNLClass(NLClass object) {
				return createNLClassAdapter();
			}
			@Override
			public Adapter caseNLFeature(NLFeature object) {
				return createNLFeatureAdapter();
			}
			@Override
			public Adapter caseNLAttribute(NLAttribute object) {
				return createNLAttributeAdapter();
			}
			@Override
			public Adapter caseNLReference(NLReference object) {
				return createNLReferenceAdapter();
			}
			@Override
			public Adapter caseUpdateInterface(UpdateInterface object) {
				return createUpdateInterfaceAdapter();
			}
			@Override
			public Adapter caseWebService(WebService object) {
				return createWebServiceAdapter();
			}
			@Override
			public Adapter caseMoment(Moment object) {
				return createMomentAdapter();
			}
			@Override
			public Adapter caseStart(Start object) {
				return createStartAdapter();
			}
			@Override
			public Adapter caseFrequency(Frequency object) {
				return createFrequencyAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.NLModel <em>NL Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.NLModel
	 * @generated
	 */
	public Adapter createNLModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.NLElement <em>NL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.NLElement
	 * @generated
	 */
	public Adapter createNLElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.NLClass <em>NL Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.NLClass
	 * @generated
	 */
	public Adapter createNLClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.NLFeature <em>NL Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.NLFeature
	 * @generated
	 */
	public Adapter createNLFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.NLAttribute <em>NL Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.NLAttribute
	 * @generated
	 */
	public Adapter createNLAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.NLReference <em>NL Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.NLReference
	 * @generated
	 */
	public Adapter createNLReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.UpdateInterface <em>Update Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.UpdateInterface
	 * @generated
	 */
	public Adapter createUpdateInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.WebService <em>Web Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.WebService
	 * @generated
	 */
	public Adapter createWebServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.Moment <em>Moment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.Moment
	 * @generated
	 */
	public Adapter createMomentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.Start
	 * @generated
	 */
	public Adapter createStartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modelInfo.Frequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modelInfo.Frequency
	 * @generated
	 */
	public Adapter createFrequencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelInfoAdapterFactory
