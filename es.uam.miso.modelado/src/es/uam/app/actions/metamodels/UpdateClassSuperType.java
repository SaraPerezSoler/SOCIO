package es.uam.app.actions.metamodels;

import java.util.ArrayList;
import java.util.List;

import es.uam.app.actions.Update;
import es.uam.app.parser.rules.IsClass;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;

public class UpdateClassSuperType extends Update {

	protected IsClass class_ = null;
	protected IsClass superType = null;
	

	protected ClassControl old = null;
	protected ClassControl new_ = null;
	protected ClassControl object=null;
	

	public UpdateClassSuperType(Project proj, IsClass class_, IsClass superType) {
		super(proj);

		this.class_ =  class_;

		this.superType = superType;

	}

	public UpdateClassSuperType(ClassControl object, ClassControl old, ClassControl new_) {
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

		ClassControl superTypeClassC= superType.getClassControl();
		if (superTypeClassC == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the class of the super type is not found");
		}
		ClassControl classClassCont= class_.getClassControl();
		if (classClassCont == null) {
			throw new Exception("Problem ocurred in"+this.getClass().getName()+": the class is not found");
		}

		old = classClassCont.copyObject();

		classClassCont.setESuperTypes(superTypeClassC);

		new_ = classClassCont.copyObject();
		this.object=classClassCont;
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
		
		List<String> supertypes=old.getSuperTypesNames();
		List<ClassControl> superTypeClass= new ArrayList<ClassControl>();
		for (String s: supertypes){
			ClassControl c=proj.getClass(s);
			if (c!=null){
				superTypeClass.add(c);
			}
		}
		object.addAllSuperType(superTypeClass);
		super.undoIt();
	}

	@Override
	public void redoIt(Project proj) throws Exception {
		if (!isExecute() || !isUndo() || isRedo()){
			return;
		}
		List<String> supertypes=new_.getSuperTypesNames();
		List<ClassControl> superTypeClass= new ArrayList<ClassControl>();
		for (String s: supertypes){
			ClassControl c=proj.getClass(s);
			if (c!=null){
				superTypeClass.add(c);
			}
		}
		this.object.addAllSuperType(superTypeClass);
		super.redoIt();
	}

}
