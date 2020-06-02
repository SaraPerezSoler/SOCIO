package es.uam.app.projects.ecore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import es.uam.app.projects.IsAttribute;


public class AttributeControl implements Feature, IsAttribute {

	private EAttribute eAttr;

	public AttributeControl() {
		eAttr = factory.createEAttribute();
	}

	public AttributeControl(EAttribute attr) {
		eAttr = attr;
	}

	public AttributeControl(String name) {
		eAttr = factory.createEAttribute();
		eAttr.setName(validElementName(name));
	}

	public AttributeControl(String name, EClassifier type) {
		eAttr = factory.createEAttribute();
		eAttr.setName(validElementName(name));
		eAttr.setEType(type);
	}

	public EAttribute getEAtribute() {
		return eAttr;
	}

	public void setChangeable(boolean value) {
		eAttr.setChangeable(value);
	}

	public void setDefaultValue(String literal) {
		eAttr.setDefaultValueLiteral(literal);
	}

	public void setType(String type) {
		eAttr.setEType(MetamodelControl.getType(type));
	}

	public EClassifier getType() {
		return eAttr.getEType();
	}

	public void setType(EClassifier type) {
		eAttr.setEType(type);
	}

	/*
	 * public void setId(boolean value){ eAttr.setID(value); }
	 */
	public void setLowerBound(int lowerBound) {
		eAttr.setLowerBound(lowerBound);
	}

	public int getLowerBound() {
		return eAttr.getLowerBound();
	}

	public void setName(String name) {
		eAttr.setName(validElementName(name));
	}

	public String getName() {
		return eAttr.getName();
	}

	public ClassControl getParent() {
		EObject parent = eAttr.eContainer();
		if (parent instanceof EClass) {
			return new ClassControl((EClass) eAttr.eContainer());
		}
		return null;
	}

	public void setOrdered(boolean value) {
		eAttr.setOrdered(value);
	}

	public void setTransient(boolean value) {
		eAttr.setTransient(value);
	}

	public void setUnique(boolean value) {
		eAttr.setUnique(value);
	}

	public void setUnsettable(boolean value) {
		eAttr.setUnsettable(value);
	}

	public void setUpperBound(int upperBound) {
		eAttr.setUpperBound(upperBound);
	}

	public int getUpperBound() {
		return eAttr.getUpperBound();
	}

	public void setVolatile(boolean value) {
		eAttr.setVolatile(value);
	}

	@Override
	public EObject getObject() {
		return eAttr;
	}


	public String toString() {

		String type = "null";
		if (getType() != null) {
			type = getType().getName();
		}

		if (getParentName() == "") {
			return "attribute " + getName() + " [" + getLowerBound() + ".." + getUpperBound() + "], type: " + type;

		} else {
			return "attribute " + getName() + " [" + getLowerBound() + ".." + getUpperBound() + "], type: " + type
					+ ", from " + getParentName();
		}
	}

	@Override
	public AttributeControl copyObject() {
		Copier copier = new Copier();
		EAttribute eObj = (EAttribute) copier.copy(this.getObject());
		AttributeControl ret = new AttributeControl(eObj);
		copyValuesIn(ret);
		copier.clear();
		return ret;
	}

	@Override
	public void copyValuesIn(Feature other) {
		if (other instanceof AttributeControl) {
			other.setAnnotation(Feature.ANNOTATION_INI + this.getParentName());
			((AttributeControl) other).setType(this.getType());
		}

	}

	@Override
	public AttributeControl getAttributeControl() {

		return this;
	}

	@Override
	public void removeValues() {
		this.removeAnnotation(Feature.ANNOTATION_INI);
	}

	@Override
	public String elementType() {
		return "attribute";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eAttr == null) ? 0 : eAttr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributeControl other = (AttributeControl) obj;
		if (eAttr == null) {
			if (other.eAttr != null)
				return false;
		} else if (!eAttr.equals(other.eAttr))
			return false;
		return true;
	}

	@Override
	public int getMin() {
		return this.getLowerBound();
	}

	@Override
	public int getMax() {

		return this.getUpperBound();
	}
}
