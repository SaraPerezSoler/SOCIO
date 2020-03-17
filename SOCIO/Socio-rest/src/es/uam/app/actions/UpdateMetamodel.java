package es.uam.app.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.actions.metamodels.ChangeAttrForRef;
import es.uam.app.actions.metamodels.ChangeRefForAttr;
import es.uam.app.actions.metamodels.UpdateAttrType;
import es.uam.app.actions.metamodels.UpdateClassAbstract;
import es.uam.app.actions.metamodels.UpdateClassSuperType;
import es.uam.app.actions.metamodels.UpdateRefType;
import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.metamodel.ReferenceControl;
import socioProjects.MetamodelProject;

public abstract class UpdateMetamodel extends  Update<MetamodelProject>{

	public UpdateMetamodel(MetamodelProject p) {
		super(p);

	}
	public static UpdateMetamodel createAction(EObject obj, EObject old, EObject new_, MetamodelProject p) {
		if (obj instanceof EClass) {
			if (old instanceof EClass && new_ instanceof EClass) {
				ClassControl oldC=new ClassControl((EClass) old);
				ClassControl newC=new ClassControl((EClass)new_);
				if (oldC.getAbstract()!=newC.getAbstract()){
					return new UpdateClassAbstract(p,new ClassControl((EClass) obj), oldC, newC);
				}else{
					return new UpdateClassSuperType(p,new ClassControl((EClass) obj), oldC, newC);
				}
			} else {
				return null;
			}
		} else if (obj instanceof EAttribute && new_ instanceof EAttribute) {
			if (old instanceof EAttribute ) {
				return new UpdateAttrType(p,new AttributeControl((EAttribute)obj), new AttributeControl((EAttribute)old), new AttributeControl((EAttribute)new_));
			}
			if (old instanceof EReference) {
				return new ChangeRefForAttr(p,new AttributeControl((EAttribute)obj), new ReferenceControl((EReference)old),  new AttributeControl((EAttribute)new_));
			} else {
				return null;
			}
		} else if (obj instanceof EReference && new_ instanceof EReference) {
			if (old instanceof EAttribute) {
				return new ChangeAttrForRef(p,new ReferenceControl((EReference)obj), new AttributeControl((EAttribute)old), new ReferenceControl((EReference)new_));
			}
			if (old instanceof EReference) {
				return new UpdateRefType(p,new ReferenceControl((EReference)obj), new ReferenceControl((EReference)old),  new ReferenceControl((EReference)new_));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Controlador eobjectToControlador(EObject object) {
		return MetamodelAction.eobjectToControlador(object);
	}
}
