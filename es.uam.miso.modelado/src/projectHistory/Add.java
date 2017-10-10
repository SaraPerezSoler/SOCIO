/**
 */
package projectHistory;

import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see projectHistory.projectHistoryPackage#getAdd()
 * @model
 * @generated
 */
public interface Add extends Action {
	
	default String getActionName(){
		return "Add";
	}
	
	void setAction(es.uam.app.actions.Add<? extends Project> action);
} // Add
