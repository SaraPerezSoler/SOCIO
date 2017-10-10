/**
 */
package projectHistory.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import es.uam.app.actions.ProjectAction;
import es.uam.app.projects.ecore.Controlador;
import projectHistory.Action;
import projectHistory.projectHistoryPackage;
import socioProjects.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projectHistory.impl.ActionImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ActionImpl extends MinimalEObjectImpl.Container implements Action {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;	

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return projectHistoryPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, projectHistoryPackage.ACTION__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, projectHistoryPackage.ACTION__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOt
	 */
	public void doIt() throws Exception {
		getAction().doIt();
		setElement(getAction().getEObject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void undoIt() throws Exception{
		getAction().undoIt();
		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void redoIt() throws Exception{
		getAction().redoIt();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getActionName(){
		return getAction().getActionName();
	}
	
	@Override
	public boolean isUndo() throws Exception {
		return getAction().isUndo();
	}

	@Override
	public boolean isExecute() {
		return getAction().isExecute();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case projectHistoryPackage.ACTION__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case projectHistoryPackage.ACTION__ELEMENT:
				setElement((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case projectHistoryPackage.ACTION__ELEMENT:
				setElement((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case projectHistoryPackage.ACTION__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case projectHistoryPackage.ACTION___DO_IT:
			try {
				doIt();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case projectHistoryPackage.ACTION___UNDO_IT:
			try {
				undoIt();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case projectHistoryPackage.ACTION___REDO_IT:
			try {
				redoIt();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
				return null;
			case projectHistoryPackage.ACTION___IS_UNDO:
			try {
				return isUndo();
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
			case projectHistoryPackage.ACTION___IS_EXECUTE:
				return isExecute();
			case projectHistoryPackage.ACTION___GET_ACTION_NAME:
				return getActionName();
		}
		return super.eInvoke(operationID, arguments);
	}
	
	public Project getProject(){
		
		//project->history->msg->sentence->action
		
		if (this.eContainer()!=null){//el contenedor de action es sentence
			if (this.eContainer().eContainer()!=null){//contenedor de sentence es msg
				if (this.eContainer().eContainer().eContainer()!=null){//contenedor de msg es history
					if (this.eContainer().eContainer().eContainer().eContainer()!=null){//contenedor de history es project
						EObject obj=this.eContainer().eContainer().eContainer().eContainer();
						if (obj instanceof Project){
							return ((Project)obj);
						}
					}
				}
			}
		}
		return null;
	}

	public abstract ProjectAction<? extends Project> getAction();
	
	protected abstract ProjectAction<? extends Project> createAction();
	
	public void setObject(Controlador object) {
		setElement(object.getObject());
	}
	@Override
	public Controlador getObject() {
		return getAction().eobjectToControlador(getElement());
	}	
	
	public String toString(){
		return getAction().toString();
	}

} //ActionImpl
