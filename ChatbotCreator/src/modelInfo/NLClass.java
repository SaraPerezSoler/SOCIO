/**
 */
package modelInfo;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NL Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelInfo.NLClass#getClass_ <em>Class</em>}</li>
 *   <li>{@link modelInfo.NLClass#isWithContainer <em>With Container</em>}</li>
 *   <li>{@link modelInfo.NLClass#isInstantiable <em>Instantiable</em>}</li>
 *   <li>{@link modelInfo.NLClass#getCreate <em>Create</em>}</li>
 *   <li>{@link modelInfo.NLClass#getId <em>Id</em>}</li>
 *   <li>{@link modelInfo.NLClass#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see modelInfo.ModelInfoPackage#getNLClass()
 * @model
 * @generated
 */
public interface NLClass extends NLElement {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(EClass)
	 * @see modelInfo.ModelInfoPackage#getNLClass_Class()
	 * @model required="true"
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Sets the value of the '{@link modelInfo.NLClass#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(EClass value);

	/**
	 * Returns the value of the '<em><b>With Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Container</em>' attribute.
	 * @see #setWithContainer(boolean)
	 * @see modelInfo.ModelInfoPackage#getNLClass_WithContainer()
	 * @model required="true"
	 * @generated
	 */
	boolean isWithContainer();

	/**
	 * Sets the value of the '{@link modelInfo.NLClass#isWithContainer <em>With Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Container</em>' attribute.
	 * @see #isWithContainer()
	 * @generated
	 */
	void setWithContainer(boolean value);

	/**
	 * Returns the value of the '<em><b>Instantiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If false, the objects of this class can be directly in the model
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instantiable</em>' attribute.
	 * @see #setInstantiable(boolean)
	 * @see modelInfo.ModelInfoPackage#getNLClass_Instantiable()
	 * @model required="true"
	 * @generated
	 */
	boolean isInstantiable();

	/**
	 * Sets the value of the '{@link modelInfo.NLClass#isInstantiable <em>Instantiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiable</em>' attribute.
	 * @see #isInstantiable()
	 * @generated
	 */
	void setInstantiable(boolean value);

	/**
	 * Returns the value of the '<em><b>Create</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true and the class is abtract the bot use a fleximodelling, if is false and the class is concrete, tue user cannot create elements of this class
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Create</em>' attribute.
	 * @see #setCreate(Boolean)
	 * @see modelInfo.ModelInfoPackage#getNLClass_Create()
	 * @model default="false" required="true"
	 * @generated
	 */
	Boolean getCreate();

	/**
	 * Sets the value of the '{@link modelInfo.NLClass#getCreate <em>Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create</em>' attribute.
	 * @see #getCreate()
	 * @generated
	 */
	void setCreate(Boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference list.
	 * The list contents are of type {@link modelInfo.NLIdentifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * if true, objects of this class are created when they are mentioned and do not exist
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' containment reference list.
	 * @see modelInfo.ModelInfoPackage#getNLClass_Id()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<NLIdentifier> getId();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link modelInfo.NLFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see modelInfo.ModelInfoPackage#getNLClass_Features()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<NLFeature> getFeatures();

	List<NLClass> getSuper();

	List<NLAttribute> getAllAttribtues();
	List<NLReference> getAllReferences();
	List<NLFeature> getAllFeatures();
} // NLClass
