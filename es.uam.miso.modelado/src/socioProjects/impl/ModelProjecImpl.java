/**
 */
package socioProjects.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.Add;
import es.uam.app.actions.Delete;
import es.uam.app.actions.Update;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.projects.ecore.Controlador;
import projectHistory.Action;
import socioProjects.ModelProjec;
import socioProjects.SocioProjectsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Projec</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelProjecImpl extends ProjectImpl implements ModelProjec {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelProjecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.MODEL_PROJEC;
	}

	@Override
	public List<Action> parseSentence(String sentence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String createUML(List<Action> actions, List<Action> actual, boolean sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Controlador> getAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "model";
	}

	@Override
	protected void removeFiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize2() throws FatalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Add<ModelProjec> createAddAction(EObject element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delete<ModelProjec> createDeleteAction(EObject element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Update<ModelProjec> createUpdateAction(EObject element, EObject new_, EObject old) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}


} //ModelProjecImpl
