/**
 */
package removeLog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import projectHistory.impl.projectHistoryPackageImpl;
import projectHistory.projectHistoryPackage;
import removeLog.RemoveLogFactory;
import removeLog.RemoveLogPackage;
import removeLog.Root;

import socioProjects.SocioProjectsPackage;

import socioProjects.impl.SocioProjectsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RemoveLogPackageImpl extends EPackageImpl implements RemoveLogPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

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
	 * @see removeLog.RemoveLogPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RemoveLogPackageImpl() {
		super(eNS_URI, RemoveLogFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RemoveLogPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RemoveLogPackage init() {
		if (isInited) return (RemoveLogPackage)EPackage.Registry.INSTANCE.getEPackage(RemoveLogPackage.eNS_URI);

		// Obtain or create and register package
		RemoveLogPackageImpl theRemoveLogPackage = (RemoveLogPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RemoveLogPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RemoveLogPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SocioProjectsPackageImpl theSocioProjectsPackage = (SocioProjectsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI) instanceof SocioProjectsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SocioProjectsPackage.eNS_URI) : SocioProjectsPackage.eINSTANCE);
		projectHistoryPackageImpl theprojectHistoryPackage = (projectHistoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(projectHistoryPackage.eNS_URI) instanceof projectHistoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(projectHistoryPackage.eNS_URI) : projectHistoryPackage.eINSTANCE);

		// Create package meta-data objects
		theRemoveLogPackage.createPackageContents();
		theSocioProjectsPackage.createPackageContents();
		theprojectHistoryPackage.createPackageContents();

		// Initialize created meta-data
		theRemoveLogPackage.initializePackageContents();
		theSocioProjectsPackage.initializePackageContents();
		theprojectHistoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRemoveLogPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RemoveLogPackage.eNS_URI, theRemoveLogPackage);
		return theRemoveLogPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_ElementsDeletes() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveLogFactory getRemoveLogFactory() {
		return (RemoveLogFactory)getEFactoryInstance();
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
		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__ELEMENTS_DELETES);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_ElementsDeletes(), ecorePackage.getEObject(), null, "ElementsDeletes", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RemoveLogPackageImpl
