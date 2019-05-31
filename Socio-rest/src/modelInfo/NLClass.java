/**
 */
package modelInfo;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

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
 *   <li>{@link modelInfo.NLClass#isRoot <em>Root</em>}</li>
 *   <li>{@link modelInfo.NLClass#isInstantiable <em>Instantiable</em>}</li>
 *   <li>{@link modelInfo.NLClass#getContainer <em>Container</em>}</li>
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
	 * Returns the value of the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' attribute.
	 * @see #setRoot(boolean)
	 * @see modelInfo.ModelInfoPackage#getNLClass_Root()
	 * @model required="true"
	 * @generated
	 */
	boolean isRoot();

	/**
	 * Sets the value of the '{@link modelInfo.NLClass#isRoot <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' attribute.
	 * @see #isRoot()
	 * @generated
	 */
	void setRoot(boolean value);

	/**
	 * Returns the value of the '<em><b>Instantiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(Boolean)
	 * @see modelInfo.ModelInfoPackage#getNLClass_Container()
	 * @model default="null" required="true"
	 * @generated
	 */
	Boolean getContainer();

	/**
	 * Sets the value of the '{@link modelInfo.NLClass#getContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Boolean value);

	/**
	 * Returns the value of the '<em><b>Create</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create</em>' attribute.
	 * @see #setCreate(Boolean)
	 * @see modelInfo.ModelInfoPackage#getNLClass_Create()
	 * @model default="null" required="true"
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
	 * The list contents are of type {@link modelInfo.NLAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference list.
	 * @see modelInfo.ModelInfoPackage#getNLClass_Id()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<NLAttribute> getId();

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
	
	NLFeature getNLFeature(EStructuralFeature feature);
	NLFeature getNLFeature(String featureName);

	NLAttribute getNLAttribute(String attributeName);
	NLAttribute getNLAttribute(EAttribute attribute);

	NLReference getNLReference(String referenceName);
	NLReference getNLReference(EReference reference);

	String getName();



	

	

	

} // NLClass
