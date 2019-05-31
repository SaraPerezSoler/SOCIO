package es.uam.app.projects.emf.model;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.Controlador;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;
import modelInfo.NLReference;

public class EObjectControl implements Controlador, IsEObject {

	private EObject object;
	private NLClass class_;

	public EObjectControl(EObject object, NLClass class_) {
		this.object = object;
		this.class_ = class_;
	}

	void setEAttribute(String attributeName, Object value) throws InternalException {
		NLAttribute nlattribute = class_.getNLAttribute(attributeName);
		if (nlattribute != null) {
			setEAttribute(nlattribute, value);
		}
	}

	@SuppressWarnings("unchecked")
	void setEAttribute(NLAttribute nlattribute, Object value) throws InternalException {

		if (!nlattribute.isType(value.getClass())) {
			throw new InternalException("The type of the attribute " + nlattribute.getAttribute().getName()
					+ " don't match with the type if the value " + value.getClass().getName());
		}
		Object oldValue = this.object.eGet(nlattribute.getAttribute());
		if (oldValue instanceof List<?>) {
			((List<Object>) oldValue).add(value);
		} else {
			object.eSet(nlattribute.getAttribute(), value);
		}

	}

	void restoreFeature(NLFeature feature, Object nlFeatureValue) {
		object.eSet(feature.getFeature(), nlFeatureValue);
	}

	void setEReference(EObjectControl trg, String referenceName) throws InternalException {
		NLReference nlreference = class_.getNLReference(referenceName);
		setEReference(trg, nlreference);
	}

	void setEReference(EObjectControl trg, NLReference nlreference) throws InternalException {

		if (!nlreference.isType(trg.getNLClass())) {
			throw new InternalException("The class of the reference " + nlreference.getReference().getName()
					+ " don't match with the class of the trg " + trg.getName());
		}
		object.eSet(nlreference.getReference(), trg.getObject());

	}

	@Override
	public String getName() {
		String id = " : ";
		for (NLAttribute att : class_.getId()) {
			id += object.eGet(att.getAttribute()).toString() + " ";
		}
		return object.eClass().getName() + id;
	}

	@Override
	public String elementType() {
		return "object";
	}

	public boolean is(List<Object> idObjects) {
		boolean ret;
		for (NLAttribute id : this.class_.getId()) {
			ret = false;
			for (Object idO : idObjects) {
				if (object.eGet(id.getAttribute()).equals(idO)) {
					ret = true;
					break;
				}
			}
			if (ret == false) {
				return false;
			}
		}
		return true;
	}

	void setId(Map<String, Object> idObject) throws InternalException {
		for (NLAttribute id : class_.getId()) {
			setEAttribute(id, idObject.get(id.getAttribute().getName()));
		}

	}

	@Override
	public EObjectControl getEObjectControl() throws Exception {
		return this;
	}

	public NLFeature getFeatureDiff(EObjectControl other) {

		if (this.getNLClass().equals(other.getNLClass())) {
			for (NLFeature feature : this.getNLClass().getFeatures()) {
				NLAttribute attr = (NLAttribute) feature;
				if (isNLFeatureDifferent(other, attr)) {
					return attr;
				}

			}
		}
		return null;
	}

	private boolean isNLFeatureDifferent(EObjectControl other, NLFeature feature) {
		Object value1 = this.getNLFeatureValue(feature);
		Object value2 = other.getNLFeatureValue(feature);
		if (!value1.equals(value2)) {
			return true;
		}
		return false;
	}

	public Object getNLFeatureValue(NLFeature feature) {
		return this.object.eGet(feature.getFeature());
	}

	public EObjectControl copyObject() {
		Copier copier = new Copier();
		EObjectControl eObj = new EObjectControl(copier.copy(this.getObject()), class_);
		copier.clear();
		return eObj;
	}

	public Object unset(NLAttribute feature, Object value) {
		
		EObject currValue = (EObject) this.getNLFeatureValue(feature);
		if (currValue instanceof List<?>) {
			List<?> currList = (List<?>) currValue;
			if (currList.contains(value)) {
				currList.remove(value);
				return value;
			}
		} else {
			if (currValue.equals(value)) {
				object.eUnset(feature.getFeature());
				return value;
			}
		}
		
		return null;

	}
	public EObjectControl unset(NLReference feature, EObjectControl value) {
		
		EObject currValue = (EObject) this.getNLFeatureValue(feature);
		if (currValue instanceof List<?>) {
			List<?> currList = (List<?>) currValue;
			if (currList.contains(value.getObject())) {
				currList.remove(value.getObject());
				return value;
			}
		} else {
			if (currValue.equals(value.getObject())) {
				object.eUnset(feature.getFeature());
				return value;
			}
		}
		return null;
		

	}


	public Object unset(NLFeature feature) {
		
		Object currValue = getNLFeatureValue(feature);		
		this.object.eUnset(feature.getFeature());
		return currValue;

	}
	public NLClass getNLClass() {
		return class_;
	}

	@Override
	public EObject getObject() {
		return object;
	}

	public NLReference getNLFeature(EObjectControl object2) {
		for (NLFeature feature : getNLClass().getFeatures()) {
			if (feature instanceof NLReference) {
				NLReference reference = (NLReference)feature;
				Object value = object.eGet(reference.getReference());
				if (value instanceof List<?>) {
					if (((List<?>)value).contains(object2)) {
						return reference;
					}
				}else {
					if (value.equals(object2)) {
						return reference;
					}
				}
			}
		}
		return null;
	}

	public String getIdString() {
		String id = "";
		for (NLAttribute att : class_.getId()) {
			id += object.eGet(att.getAttribute()).toString().replaceAll(" \n\t", "");
		}
		return id;
	}

}
