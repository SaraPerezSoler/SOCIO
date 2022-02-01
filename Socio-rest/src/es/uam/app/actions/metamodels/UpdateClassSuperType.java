package es.uam.app.actions.metamodels;

import java.util.ArrayList;
import java.util.List;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.emf.metamodel.ClassControl;
import socioProjects.MetamodelProject;

public class UpdateClassSuperType extends UpdateMetamodel{

	protected IsClass class_ = null;
	protected IsClass superType = null;
	

	public UpdateClassSuperType(MetamodelProject proj, IsClass class_, IsClass superType) {
		super(proj);
		this.class_ =  class_;
		this.superType = superType;

	}

	public UpdateClassSuperType(MetamodelProject p, ClassControl classControl, ClassControl oldC, ClassControl newC) {
		super(p);
		setObject(classControl);
		this.class_=classControl;
		setOld(oldC);
		setNew(newC);
		this.setExecute(true);
	}

	@Override
	public void doIt() throws Exception {
		if (isExecute()) {
			return;
		}

		ClassControl superTypeClassC= superType.getClassControl();
		if (superTypeClassC == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the class of the super type is not found");
		}
		ClassControl classClassCont= class_.getClassControl();
		if (classClassCont == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the class is not found");
		}

		this.setOld(classClassCont.copyObject());

		classClassCont.setESuperTypes(superTypeClassC);

		setNew(classClassCont.copyObject());
		setObject(classClassCont);
		setExecute(true);

	}

	@Override
	public ClassControl getObject() {
		return (ClassControl)super.getObject();
	}

	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		List<String> supertypes=((ClassControl)getOldC()).getSuperTypesNames();
		List<ClassControl> superTypeClass= new ArrayList<ClassControl>();
		for (String s: supertypes){
			ClassControl c=getProject().getClass(s);
			if (c!=null){
				superTypeClass.add(c);
			}
		}
		getObject().addAllSuperType(superTypeClass);
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		List<String> supertypes=((ClassControl)getNewC()).getSuperTypesNames();
		List<ClassControl> superTypeClass= new ArrayList<ClassControl>();
		for (String s: supertypes){
			ClassControl c=getProject().getClass(s);
			if (c!=null){
				superTypeClass.add(c);
			}
		}
		this.getObject().addAllSuperType(superTypeClass);
		setUndo(false);
	}

}
