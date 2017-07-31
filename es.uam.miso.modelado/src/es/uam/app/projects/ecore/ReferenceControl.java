package es.uam.app.projects.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;


public class ReferenceControl implements Feature, IsReference {

	private EReference eRef;
	public static final String ANNOTATION_TYPE = "@TypeVAR";

	public ReferenceControl() {
		eRef = factory.createEReference();
	}

	public ReferenceControl(String name) {
		eRef = factory.createEReference();
		eRef.setName(validElementName(name));
	}

	public ReferenceControl(String name, EClass type) {
		eRef = factory.createEReference();
		eRef.setName(validElementName(name));
		eRef.setEType(type);
	}

	public ReferenceControl(EReference esf) {
		eRef = esf;
	}

	public EReference getEReference() {
		return eRef;
	}

	public void setChangeable(boolean value) {
		eRef.setChangeable(value);
	}

	public void setContainment(boolean value) {
		eRef.setContainment(value);
	}

	public boolean isContainment() {
		return eRef.isContainment();
	}

	public void setDefaultValue(String literal) {
		eRef.setDefaultValueLiteral(literal);
	}

	public void setDerived(boolean value) {
		eRef.setDerived(value);
	}

	public void setEOpposite(EReference value) {
		eRef.setEOpposite(value);
	}

	public void setType(EClass type) {
		eRef.setEType(type);
	}

	public void setType(ClassControl type) {
		if (type == null) {
			eRef.setEType(null);
		} else {
			eRef.setEType(type.getEClass());
		}
	}

	public ClassControl getType() {
		EClassifier type= eRef.getEType();
		if (type instanceof EClass) {
			return new ClassControl((EClass)type);
		}
		return null;
	}

	public String getTypeName() {

		if (eRef.getEType() instanceof EClass) {
			return eRef.getEType().getName();
		} else {
			List<EAnnotation> anno = this.getAnnotations();
			for (EAnnotation a : anno) {
				if (a.getSource().startsWith(ANNOTATION_TYPE)) {
					return a.getSource().replace(ANNOTATION_TYPE, "");
				}
			}
		}
		return "null";
	}

	public void setLowerBound(int lowerBound) {
		eRef.setLowerBound(lowerBound);
	}

	public int getLowerBound() {
		return eRef.getLowerBound();
	}

	public void setName(String name) {
		eRef.setName(validElementName(name));
	}

	public String getName() {
		return eRef.getName();
	}

	public void setOrdered(boolean value) {
		eRef.setOrdered(value);
	}

	public void setResolveProxie(boolean value) {
		eRef.setResolveProxies(value);
	}

	public void setTransient(boolean value) {
		eRef.setTransient(value);
	}

	public void setUnique(boolean value) {
		eRef.setUnique(value);
	}

	public void setUnsettable(boolean value) {
		eRef.setUnsettable(value);
	}

	public void setUpperBound(int upperBound) {
		eRef.setUpperBound(upperBound);
	}

	public int getUpperBound() {
		return eRef.getUpperBound();
	}

	public void setVolatile(boolean value) {
		eRef.setVolatile(value);
	}

	@Override
	public EObject getObject() {
		return eRef;
	}

	public ClassControl getParent() {
		if (eRef.eContainer() instanceof EClass) {
			return new ClassControl((EClass) eRef.eContainer());
		}
		return null;

	}

	public boolean equals(Object o) {
		if (o instanceof ReferenceControl) {
			return this.eRef.equals(((ReferenceControl) o).eRef);
		}
		return false;
	}

	public String toString() {

		if (getParentName() == "") {
			return "reference " + getName() + " [" + getLowerBound() + ".." + getUpperBound() + "], type: "
					+ getTypeName();
		} else {
			return "reference " + getName() + " [" + getLowerBound() + ".." + getUpperBound() + "], type: "
					+ getTypeName() + ", from " + getParentName();
		}

	}

	@Override
	public ReferenceControl copyObject() {
		Copier copier = new Copier();
		EReference eObj = (EReference) copier.copy(this.getObject());
		ReferenceControl ret = new ReferenceControl(eObj);
		copyValuesIn(ret);
		copier.clear();
		return ret;
	}

	@Override
	public void copyValuesIn(Feature other) {
		other.setAnnotation(Feature.ANNOTATION_INI + this.getParentName());
		other.setAnnotation(ANNOTATION_TYPE + this.getTypeName());

	}

	@Override
	public ReferenceControl getReferenceControl() {
		return this;
	}

	@Override
	public void removeValues() {
		this.removeAnnotation(ANNOTATION_INI);
		this.removeAnnotation(ANNOTATION_TYPE);
		
	}

	@Override
	public String elementType() {
		return "reference";
	}
}
