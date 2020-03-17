package es.uam.app.actions.metamodels;

import java.util.List;

import socioProjects.MetamodelProject;
import es.uam.app.actions.metamodels.UpdateClassSuperType;
import es.uam.app.projects.IsClass;
import es.uam.app.projects.ecore.ClassControl;

public class UpdateClassRemoveSuperType extends UpdateClassSuperType {


	public UpdateClassRemoveSuperType(MetamodelProject proj, IsClass class_, ClassControl superType) {
		super(proj, class_, superType);
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

		setOld(classClassCont.copyObject());

		List<ClassControl> superTypes=classClassCont.getSuperTypes();
		superTypes.remove(superTypeClassC);
		classClassCont.addAllSuperType(superTypes);
		setObject(classClassCont);
		setNew(classClassCont.copyObject());

		setExecute(true);

	}

}
