/**
 */
package socioProjects;

import java.util.List;
import projectHistory.Action;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel Project</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see socioProjects.SocioProjectsPackage#getMetamodelProject()
 * @model
 * @generated
 */
public interface MetamodelProject extends Project {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @model sentenceRequired="true"
	 * @generated NOT
	 */
	List<Action> parseSentence(String sentence) throws Exception;

} 
