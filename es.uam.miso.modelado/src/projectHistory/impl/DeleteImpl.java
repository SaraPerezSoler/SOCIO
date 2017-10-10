/**
 */
package projectHistory.impl;

import org.eclipse.emf.ecore.EClass;

import es.uam.app.actions.ProjectAction;
import projectHistory.Delete;
import projectHistory.projectHistoryPackage;
import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DeleteImpl extends ActionImpl implements Delete {
	
	private es.uam.app.actions.Delete<? extends Project> action;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return projectHistoryPackage.Literals.DELETE;
	}

	@Override
	protected es.uam.app.actions.Delete<? extends Project> createAction() {
		Project p=getProject();
		return p.createDeleteAction(getElement());
	}

	@Override
	public ProjectAction<? extends Project> getAction() {
		if (action==null){
			action=createAction();
		}
		return action;
	}

	@Override
	public void setAction(es.uam.app.actions.Delete<? extends Project> action) {
		this.action=action;
	}

} //DeleteImpl
