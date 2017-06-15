package es.uam.app.actions.metamodels;

import es.uam.app.actions.Update;
import es.uam.app.parser.rules.IsClass;
import es.uam.app.parser.rules.IsReference;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public class UpdateRefType extends Update {

	private IsReference ref = null;

	private IsClass type = null;

	private ReferenceControl old = null;
	private ReferenceControl new_ = null;
	private ReferenceControl object= null;

	public UpdateRefType(Project proj, IsReference ref, IsClass type) {
		super(proj);
		
		this.ref = ref;
		this.type= type;

	}

	public UpdateRefType(ReferenceControl object, ReferenceControl old, ReferenceControl new_) {
		super(null);
		this.object = object;
		this.old = old;
		this.new_ = new_;
	}

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
		super.execute();
	}


	@Override
	public Controlador getObject() {
		return object;
	}

	@Override
	public Controlador getOld() {
		return old;
	}

	@Override
	public Controlador getNew() {
		return new_;
	}
	
	@Override
	public void undoIt(Project proj) throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		ClassControl type=proj.getClass(old.getTypeName());
		object.setType(type);
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		ClassControl type=proj.getClass(new_.getTypeName());
		this.object.setType(type);
		super.redoIt();
	}

}
