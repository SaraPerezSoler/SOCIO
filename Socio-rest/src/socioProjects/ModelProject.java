/**
 */
package socioProjects;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;
import projectHistory.Action;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Projec</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see socioProjects.SocioProjectsPackage#getModelProjec()
 * @model
 * @generated
 */
public interface ModelProject extends Project {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sentenceRequired="true"
	 * @generated NOT
	 */
	List<Action> parseSentence(String sentence);
	
	EObjectControl createEObject(String name) throws InternalException;
	
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

} // ModelProjec
