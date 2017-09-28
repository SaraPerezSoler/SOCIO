package es.uam.app.actions.metamodels;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.ecore.IsClass;
import es.uam.app.projects.ecore.IsReference;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public class UpdateRefType extends UpdateMetamodel {

	private IsReference ref = null;

	private IsClass type = null;

	private ReferenceControl old = null;
	private ReferenceControl new_ = null;
	private ReferenceControl object= null;
	
	private MetamodelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;

	public UpdateRefType(MetamodelProject proj, IsReference ref, IsClass type) {
		setProject(proj);
		
		this.ref = ref;
		this.type= type;

	}

	/*public UpdateRefType(ReferenceControl object, ReferenceControl old, ReferenceControl new_) {
		super(null);
		this.object = object;
		this.old = old;
		this.new_ = new_;
	}*/

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}

		ReferenceControl refControl=ref.getReferenceControl();
		
		if (refControl == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the reference is not found");
		}
		old = refControl.copyObject();

		ClassControl typeCC= null;
		if (type!=null){
			typeCC=type.getClassControl();
		}

		refControl.setType(typeCC);
		new_ = refControl.copyObject();
		object= refControl;
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
		
		ClassControl type=project.getClass(old.getTypeName());
		object.setType(type);
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		ClassControl type=project.getClass(new_.getTypeName());
		this.object.setType(type);
		setUndo(false);
	}

	public MetamodelProject getProject() {
		return project;
	}

	public void setProject(MetamodelProject project) {
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
