package es.uam.app.actions;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.projects.ecore.Controlador;
import projectHistory.Action;
import projectHistory.impl.projectHistoryFactoryImpl;
import socioProjects.Project;

public abstract class Update <T extends Project> extends ProjectAction<T> {

	private Controlador old;
	private Controlador new_;
	
	public Update(T project) {
		super(project);
	}

	
	public void setOld(Controlador old){
		this.old=old;
	}
	
	public void setNew(Controlador new_){
		this.new_=new_;
	}
	
	public Controlador getOldC(){
		return old;
	}
	
	public Controlador getNewC(){
		return new_;
	}
	
	public EObject getOld(){
		return old.getObject();
	}
	
	public EObject getNew(){
		return new_.getObject();
	}
	
	@Override
	public String getActionName() {
		return "Update";
	}
	
	@Override
	public Action getAction() {
		projectHistory.Update ret=projectHistoryFactoryImpl.eINSTANCE.createUpdate();
		ret.setAction(this);
		return ret;
	}
}
