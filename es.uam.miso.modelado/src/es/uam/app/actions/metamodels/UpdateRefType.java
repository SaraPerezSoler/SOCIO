package es.uam.app.actions.metamodels;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.IsReference;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.ReferenceControl;
import socioProjects.MetamodelProject;

public class UpdateRefType extends UpdateMetamodel {

	private IsReference ref = null;
	private IsClass type = null;

	public UpdateRefType(MetamodelProject proj, IsReference ref, IsClass type) {
		super(proj);
		
		this.ref = ref;
		this.type= type;

	}


	public UpdateRefType(MetamodelProject p, ReferenceControl referenceControl, ReferenceControl oldC,
			ReferenceControl newC) {
		super(p);
		setObject(referenceControl);
		setOld(oldC);
		setNew(newC);
		this.setExecute(true);
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
		setOld(refControl.copyObject());

		ClassControl typeCC= null;
		if (type!=null){
			typeCC=type.getClassControl();
		}

		refControl.setType(typeCC);
		setNew(refControl.copyObject());
		setObject(refControl);
		setExecute(true);
	}

	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		ClassControl type=getProject().getClass(((ReferenceControl)getOldC()).getTypeName());
		(getObject()).setType(type);
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		ClassControl type=getProject().getClass(((ReferenceControl)getNewC()).getTypeName());
		(getObject()).setType(type);
		setUndo(false);
	}
	
	@Override
	public ReferenceControl getObject() {
		return (ReferenceControl)super.getObject();
	}

}
