/**
 */
package socioProjects;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLClass;
import modelInfo.NLFeature;
import modelInfo.NLModel;
import projectHistory.Action;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Projec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link socioProjects.ModelProject#getMetamodelName <em>Metamodel Name</em>}</li>
 * </ul>
 *
 * @see socioProjects.SocioProjectsPackage#getModelProject()
 * @model
 * @generated
 */
public interface ModelProject extends Project {

	/**
	 * Returns the value of the '<em><b>Metamodel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Name</em>' attribute.
	 * @see #setMetamodelName(String)
	 * @see socioProjects.SocioProjectsPackage#getModelProject_MetamodelName()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodelName();

	/**
	 * Sets the value of the '{@link socioProjects.ModelProject#getMetamodelName <em>Metamodel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Name</em>' attribute.
	 * @see #getMetamodelName()
	 * @generated
	 */
	void setMetamodelName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sentenceRequired="true"
	 * @generated NOT
	 */
	List<Action> parseSentence(String sentence) throws Exception;
	
	EObjectControl createEObject(String name) throws InternalException;
	void unCreateEObject(EObjectControl object) throws InternalException;
	void reCreateEObject(EObjectControl object) throws InternalException;
	
	NLClass getNLClass(String className) throws InternalException;
	NLClass getNLClass(EClass className);

	EObjectControl getObject(String ClassName, Map<String, Object> id) throws InternalException;

	void removeObject(EObjectControl object);

	void addObject(EObjectControl object);

	void setId(EObjectControl object, Map<String, Object> id) throws InternalException;

	void setEAttribute(EObjectControl object, String attName, Object value) throws InternalException;

	void restoreFeature(EObjectControl object, NLFeature feature, Object nlFeatureValue);

	void setEReference(EObjectControl object, EObjectControl value, String refName) throws InternalException;

	void unsetEReference(EObjectControl object, String refName, EObjectControl value);

	void unsetEAttribute(EObjectControl object, String attName, Object value) throws InternalException;

	void unRemoveObject(EObjectControl object);

	EObjectControl getControl(EObject obj);

	void unsetEReference(EObjectControl object, String refName);

	NLModel getNLModel();

	void setNLModel(NLModel nlModel);

} // ModelProjec
