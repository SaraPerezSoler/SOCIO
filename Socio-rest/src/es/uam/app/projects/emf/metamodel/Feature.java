package es.uam.app.projects.emf.metamodel;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public interface Feature extends MetamodelControlInterface, ControlCopier {

	public static final String ANNOTATION_INI="@CointainerVAR";
	public ClassControl getParent();

	default ClassControl getParent(PackageControl pck){
		EObject parent= getObject().eContainer();
		if (parent==null){
			List<EAnnotation> annotations=this.getAnnotations();
			for (EAnnotation a: annotations){
				if (a.getSource().startsWith(ANNOTATION_INI)){
					String name=a.getSource().replace(ANNOTATION_INI, "");
					return pck.getClass(name);
				}
			}
		}
		if (parent instanceof EClass){
			return new ClassControl((EClass)getObject().eContainer());
		}
		return null;
	}
	
	default String getParentName(){
		EObject parent= getObject().eContainer();
		if (parent==null || !(parent instanceof EClass)){
			List<EAnnotation> annotations=this.getAnnotations();
			for (EAnnotation a: annotations){
				if (a.getSource().startsWith(ANNOTATION_INI)){
					String name=a.getSource().replace(ANNOTATION_INI, "");
					return name;
				}
			}
		}else{
			return new ClassControl((EClass)getObject().eContainer()).getName();
		}
		return "";
	}
	
	public void copyValuesIn(Feature other);
	public void removeValues();
	public int getLowerBound();
	public int getUpperBound();
	public String getTypeString();

	public Object getType();
}
