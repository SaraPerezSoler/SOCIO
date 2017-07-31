package es.uam.app.actions.metamodels;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.projects.ecore.IsClass;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;

public class UpdateClassSuperType extends UpdateMetamodel{

	protected IsClass class_ = null;
	protected IsClass superType = null;
	

	protected ClassControl old = null;
	protected ClassControl new_ = null;
	protected ClassControl object=null;
	
	private MetaModelProject project;
	private boolean isUndo=false;
	private boolean isExecute=false;
	

	public UpdateClassSuperType(MetaModelProject proj, IsClass class_, IsClass superType) {
		setProject(proj);

		this.class_ =  class_;

		this.superType = superType;

	}

	/*public UpdateClassSuperType(ClassControl object, ClassControl old, ClassControl new_) {
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
		
		List<String> supertypes=old.getSuperTypesNames();
		List<ClassControl> superTypeClass= new ArrayList<ClassControl>();
		for (String s: supertypes){
			ClassControl c=project.getClass(s);
			if (c!=null){
				superTypeClass.add(c);
			}
		}
		object.addAllSuperType(superTypeClass);
		setUndo(true);
	}

	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		List<String> supertypes=new_.getSuperTypesNames();
		List<ClassControl> superTypeClass= new ArrayList<ClassControl>();
		for (String s: supertypes){
			ClassControl c=project.getClass(s);
			if (c!=null){
				superTypeClass.add(c);
			}
		}
		this.object.addAllSuperType(superTypeClass);
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
