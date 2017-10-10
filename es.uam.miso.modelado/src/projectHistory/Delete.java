/**
 */
package projectHistory;

import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see projectHistory.projectHistoryPackage#getDelete()
 * @model
 * @generated
 */
public interface Delete extends Action {
	default String getActionName(){
		return "Delete";
	}
	
	void setAction(es.uam.app.actions.Delete<? extends Project> action);
} // Delete
