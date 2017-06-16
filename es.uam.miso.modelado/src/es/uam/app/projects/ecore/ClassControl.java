package es.uam.app.projects.ecore;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import es.uam.app.parser.rules.IsClass;

public class ClassControl implements MetamodelControl, IsClass, ControlCopier {

	private EClass eClass;
	public static final String ANNOTATION_SUPERTYPE = "@SuperType";
	public static final String ANNOTATION_SEP = "VAR";

	public ClassControl() {
		eClass = factory.createEClass();
	}

	public ClassControl(EClass clss) {
		eClass = clss;
	}

	public ClassControl(String name) {
		eClass = factory.createEClass();
		eClass.setName(name);
	}

	public EClass getEClass() {
		return this.eClass;
	}

	public boolean getAbstract() {
		return this.eClass.isAbstract();
	}

	public List<ClassControl> getSuperTypes() {
		List<ClassControl> ret = new ArrayList<ClassControl>();
		for (EClass est : eClass.getESuperTypes()) {
			ret.add(new ClassControl(est));
		}
		return ret;
	}

	public List<String> getSuperTypesNames() {
		List<String> ret = new ArrayList<String>();
		if (eClass.getESuperTypes().isEmpty()) {
			List<EAnnotation> anno = this.getAnnotations();
			for (EAnnotation a : anno) {
				if (a.getSource().startsWith(ANNOTATION_SUPERTYPE)) {
					String[] split = a.getSource().split(ANNOTATION_SEP);
					for (int i = 1; i < split.length; i++) {
						ret.add(split[i]);
					}
				}
			}
		} else {
			for (EClass est : eClass.getESuperTypes()) {
				ret.add(est.getName());
			}
		}
		return ret;
	}

	public ClassControl copyObject() {

		Copier copier = new Copier();
		EClass eObj = (EClass) copier.copy(this.getEClass());
		ClassControl ret = new ClassControl(eObj);
		copier.clear();

		List<String> superTypes = this.getSuperTypesNames();
		String cad = ANNOTATION_SUPERTYPE + ANNOTATION_SEP;
		for (String st : superTypes) {
			cad += st + ANNOTATION_SEP;
		}

		ret.setAnnotation(cad);
		return ret;
	}

	public boolean getInterface() {
		return eClass.isInterface();
	}

	public String getName() {
		return eClass.getName();
	}

	public void setAbstract(boolean value) {
		this.eClass.setAbstract(value);
	}

	public void setESuperTypes(EClass superType) {
		eClass.getESuperTypes().add(superType);
	}

	public void setESuperTypes(ClassControl superType) {
		eClass.getESuperTypes().add(superType.getEClass());
	}

	public void setInstanceTypeName(String name) {
		eClass.setInstanceClassName(name);
	}

	public void setInterface(boolean value) {
		eClass.setInterface(value);
	}

	public void setName(String name) {
		eClass.setName(name);
	}

	public void addAttrRef(EStructuralFeature attr) {
		eClass.getEStructuralFeatures().add(attr);
	}

	public void removeAttrRef(EStructuralFeature attr) {
		eClass.getEStructuralFeatures().remove(attr);
	}

	public EStructuralFeature getAttrRef(String attr) {

		return eClass.getEStructuralFeature(attr);
	}

	public AttributeControl getAttr(String attr) {

		List<EStructuralFeature> esf= eClass.getEAllStructuralFeatures();
		for (EStructuralFeature e: esf){
			if (e.getName().equalsIgnoreCase(attr)){
				if (e instanceof EAttribute) {
					return new AttributeControl((EAttribute) e);
				}
			}
			
		}
		
		return null;
	}

	public ReferenceControl getRef(String attr) {

		List<EStructuralFeature> esf= eClass.getEAllStructuralFeatures();
		for (EStructuralFeature e: esf){
			if (e.getName().equalsIgnoreCase(attr)){
				if (e instanceof EReference) {
					return new ReferenceControl((EReference) e);
				}
			}
		}
		
		return null;
	}

	public void removeAttrRef(String attr) {
		eClass.getEStructuralFeatures().remove(getAttrRef(attr));
	}

	public void addOperation(EOperation op) {
		eClass.getEAllOperations().add(op);
	}

	public List<ReferenceControl> getRefForType(String attr_ref) {
		List<ReferenceControl> ret = new ArrayList<>();

		for (ReferenceControl e : this.getReferences()) {
			String type = e.getTypeName();
			if (type != null) {
				if (type.equals(attr_ref)) {
					ret.add(e);
				}
			}
		}
		return ret;
	}

	public List<AttributeControl> getAttrForType(String attr_ref) {
		List<AttributeControl> ret = new ArrayList<>();

		for (AttributeControl e : this.getAttributes()) {
			EClassifier type = e.getType();
			if (attr_ref.equals("null")) {
				if (type == null) {
					ret.add(e);
				}
			} else {
				if (type != null) {
					if (type.equals(attr_ref)) {
						ret.add(e);
					}
				}
			}
		}
		return ret;
	}

	public List<AttributeControl> getAttributes() {
		List<AttributeControl> ret = new ArrayList<AttributeControl>();
		for (EStructuralFeature esf : this.eClass.getEStructuralFeatures()) {
			if (esf instanceof EAttribute) {
				ret.add(new AttributeControl((EAttribute) esf));
			}
		}
		return ret;
	}

	public List<ReferenceControl> getReferences() {
		List<ReferenceControl> ret = new ArrayList<>();
		for (EStructuralFeature esf : eClass.getEStructuralFeatures()) {
			if (esf instanceof EReference) {
				ret.add(new ReferenceControl((EReference) esf));
			}
		}
		return ret;
	}

	@Override
	public EObject getObject() {

		return eClass;
	}

	public boolean equals(Object o) {
		if (o instanceof ClassControl) {
			return this.eClass.equals(((ClassControl) o).eClass);

		}
		return false;
	}

	/*
	 * @Override public boolean containEElement(Object o) { if (o instanceof
	 * EClass){ return (o); } return false; }
	 */

	public String toString() {
		List<String> superTypes = getSuperTypesNames();
		String start = "class ";
		if (getAbstract()) {
			start = "abstract class ";
		}
		if (superTypes.isEmpty()) {
			return start + getName();
		} else {
			return start + getName() + ", superTypes: " + superTypes;
		}

	}

	@Override
	public ClassControl getClassControl() {
		return this;
	}

	public void addAllSuperType(List<ClassControl> superTypes) {
		eClass.getESuperTypes().clear();
		for (ClassControl c: superTypes){
			this.setESuperTypes(c);
		}
	}

	public boolean isSubTypeOf(ClassControl c) {
		List<ClassControl> superTypes= this.getSuperTypes();
		if (superTypes.contains(c)){
			return true;
		}
		return false;
	}

	@Override
	public String elementType() {
		return "class";
	}
}
