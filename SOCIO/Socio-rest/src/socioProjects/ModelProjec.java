/**
 */
package socioProjects;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link socioProjects.ModelProjec#getMetamodelName <em>Metamodel Name</em>}</li>
 * </ul>
 *
 * @see socioProjects.SocioProjectsPackage#getModelProjec()
 * @model
 * @generated
 */
public interface ModelProjec extends Project {
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
	 * @see socioProjects.SocioProjectsPackage#getModelProjec_MetamodelName()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodelName();

	/**
	 * Sets the value of the '{@link socioProjects.ModelProjec#getMetamodelName <em>Metamodel Name</em>}' attribute.
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
	 * @generated
	 */
	EList<Action> parseSentence(String sentence);

} // ModelProjec
