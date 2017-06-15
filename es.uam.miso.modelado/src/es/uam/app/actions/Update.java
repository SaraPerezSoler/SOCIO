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
import es.uam.app.projects.Project;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.ReferenceControl;

public abstract class Update extends ActionModel {

	public static Update createAction(EObject obj, EObject old, EObject new_) {
		if (obj instanceof EClass) {
			if (old instanceof EClass && new_ instanceof EClass) {
				ClassControl oldC=new ClassControl((EClass) old);
				ClassControl newC=new ClassControl((EClass)new_);
				if (oldC.getAbstract()!=newC.getAbstract()){
					return new UpdateClassAbstract(new ClassControl((EClass) obj), oldC, newC);
				}else{
					return new UpdateClassSuperType(new ClassControl((EClass) obj), oldC, newC);
				}
			} else {
				return null;
			}
		} else if (obj instanceof EAttribute && new_ instanceof EAttribute) {
			if (old instanceof EAttribute ) {
				return new UpdateAttrType(new AttributeControl((EAttribute)obj), new AttributeControl((EAttribute)old), new AttributeControl((EAttribute)new_));
			}
			if (old instanceof EReference) {
				return new ChangeRefForAttr(new AttributeControl((EAttribute)obj), new ReferenceControl((EReference)old),  new AttributeControl((EAttribute)new_));
			} else {
				return null;
			}
		} else if (obj instanceof EReference && new_ instanceof EReference) {
			if (old instanceof EAttribute) {
				return new ChangeAttrForRef(new ReferenceControl((EReference)obj), new AttributeControl((EAttribute)old), new ReferenceControl((EReference)new_));
			}
			if (old instanceof EReference) {
				return new UpdateRefType(new ReferenceControl((EReference)obj), new ReferenceControl((EReference)old),  new ReferenceControl((EReference)new_));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Update(Project proj) {
		super(proj);
	}

	public abstract Controlador getOld();
	public abstract Controlador getNew();
	
	@Override
	public String toString() {
		return "Update-> Old: "+getOld()+" / New: "+getNew();
	}
	
	public String getActionName(){
		return ActionModel.ACTION.UPDATE.name();
	}

}
