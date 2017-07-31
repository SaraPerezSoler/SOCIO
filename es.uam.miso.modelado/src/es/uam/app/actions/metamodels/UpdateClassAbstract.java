package es.uam.app.actions.metamodels;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.IsClass;

public class UpdateClassAbstract extends UpdateMetamodel {

	private IsClass class_ = null;
	private boolean abstract_=false;
	

	private ClassControl old=null;
	private ClassControl new_=null;
	private ClassControl object=null;
	
	private MetaModelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	
	public UpdateClassAbstract(MetaModelProject proj, IsClass class_, boolean abstract_) {
		setProject(proj);
		this.class_ =  class_;
		
		this.abstract_=abstract_;
		
	}

	/*public UpdateClassAbstract(ClassControl object, ClassControl old, ClassControl new_) {
		super(null);
		this.object=object;
		this.old=old;
		this.new_=new_;
	}*/

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}
		
		ClassControl classClassControl=class_.getClassControl();
		if (classClassControl == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the class is not found");
		}
		
		old=classClassControl.copyObject();
		classClassControl.setAbstract(abstract_);
		new_=classClassControl.copyObject();
		object= classClassControl;
		
		setExecute(true);

	}


	@Override
	public Controlador getObject() {
		return object;
	}

	@Override
	public EObject getOld() {
		return old.getObject();
	}

	@Override
	public EObject getNew() {
		return new_.getObject();
	}
	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		object.setAbstract(old.getAbstract());
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		this.object.setAbstract(new_.getAbstract());
		setUndo(false);
	}

	public MetaModelProject getProject() {
		return project;
	}

	public void setProject(MetaModelProject project) {
		this.project = project;
	}

	public boolean isUndo() {
		return isUndo;
	}

	public void setUndo(boolean isUndo) {
		this.isUndo = isUndo;
	}

	public boolean isExecute() {
		return isExecute;
	}

	public void setExecute(boolean isExecute) {
		this.isExecute = isExecute;
	}

}
