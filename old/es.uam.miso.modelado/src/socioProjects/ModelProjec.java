/**
 */
package socioProjects;

import java.util.List;
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
public interface ModelProjec extends Project {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sentenceRequired="true"
	 * @generated NOT
	 */
	List<Action> parseSentence(String sentence);

} // ModelProjec
