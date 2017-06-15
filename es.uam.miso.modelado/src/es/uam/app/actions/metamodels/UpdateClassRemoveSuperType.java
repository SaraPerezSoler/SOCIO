package es.uam.app.actions.metamodels;

import java.util.List;

import es.uam.app.parser.rules.IsClass;
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.ClassControl;

public class UpdateClassRemoveSuperType extends UpdateClassSuperType {


	public UpdateClassRemoveSuperType(Project proj, IsClass class_, ClassControl superType) {
		super(proj, class_, superType);
	}

	public UpdateClassRemoveSuperType(ClassControl object, ClassControl old, ClassControl new_) {
		super(object,old, new_);
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

		this.old = classClassCont.copyObject();

		List<ClassControl> superTypes=classClassCont.getSuperTypes();
		superTypes.remove(superTypeClassC);
		classClassCont.addAllSuperType(superTypes);

		new_ = classClassCont.copyObject();

		super.execute();

	}

}
