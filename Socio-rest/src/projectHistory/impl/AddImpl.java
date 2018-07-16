/**
 */
package projectHistory.impl;

import org.eclipse.emf.ecore.EClass;

import es.uam.app.actions.ProjectAction;
import projectHistory.Add;
import projectHistory.ProjectHistoryPackage;
import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AddImpl extends ActionImpl implements Add {
	
	private es.uam.app.actions.Add<? extends Project> action;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProjectHistoryPackage.Literals.ADD;
	}

	@Override
	protected es.uam.app.actions.Add<? extends Project> createAction() {
			Project p=getProject();
			return p.createAddAction(getElement());
		
	}

	@Override
	public ProjectAction<? extends Project> getAction() {
		if(action==null){
			action=createAction();
		}
		return action;
	}

	public void setAction(es.uam.app.actions.Add<? extends Project> action) {
		this.action = action;
	}


	
	

} //AddImpl
