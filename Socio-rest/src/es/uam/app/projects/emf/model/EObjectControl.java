package es.uam.app.projects.emf.model;

import java.util.ArrayList;
import java.util.HashMap;
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
	private Map<NLReference, List<EObjectControl>> refernces = new HashMap<>();

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

		Class c = nlattribute.getAttribute().getEType().getInstanceClass();
		if (!c.isInstance(value)) {
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

	@SuppressWarnings("unchecked")
	void setEReference(EObjectControl trg, NLReference nlreference) throws InternalException {

		if (!nlreference.getReference().getEReferenceType().isInstance(trg.getObject())) {
			throw new InternalException("The class of the reference " + nlreference.getReference().getName()
					+ " don't match with the class of the trg " + trg.getName());
		}
		Object oldValue = this.object.eGet(nlreference.getReference());
		if (oldValue instanceof List<?>) {
			((List<Object>) oldValue).add(trg.getObject());
		} else {
			object.eSet(nlreference.getReference(), trg.getObject());

		}

		List<EObjectControl> ref = refernces.get(nlreference);
		if (ref == null) {
			ref = new ArrayList<>();
			refernces.put(nlreference, ref);
		}
		ref.add(trg);

	}

	@Override
	public String getName() {
		String id = "";
		for (NLAttribute att : class_.getId()) {
			id += object.eGet(att.getAttribute()).toString() + " ";
		}
		return id + ":" + object.eClass().getName();
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
				if (feature instanceof NLReference) {
					if (!isSameReference((NLReference) feature, other)) {
						return feature;
					}
				} else {
					if (isNLFeatureDifferent(other, feature)) {
						return feature;
					}
				}

			}
		}
		return null;
	}

	private boolean isSameReference(NLReference reference, EObjectControl other) {
		List<EObjectControl> objects1 = this.refernces.get(reference);
		List<EObjectControl> objects2 = other.refernces.get(reference);
		if (objects1 == null) {
			if (objects2 != null) {
				return false;
			} else {
				return true;
			}
		} else {
			if (objects2 == null) {
				return false;
			} else {
				if (objects1.size() != objects2.size()) {
					return false;
				}
				for (EObjectControl obj : objects1) {
					if (!objects2.contains(obj)) {
						return false;
					}
				}
				return true;
			}
		}
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

		for (NLReference key : refernces.keySet()) {
			List<EObjectControl> ref = new ArrayList<>();
			for (EObjectControl object : this.refernces.get(key)) {
				ref.add(object);
			}
			eObj.refernces.put(key, ref);
		}
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
				NLReference reference = (NLReference) feature;
				Object value = object.eGet(reference.getReference());
				if (value instanceof List<?>) {
					if (((List<?>) value).contains(object2)) {
						return reference;
					}
				} else {
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
			id += object.eGet(att.getAttribute()).toString().replaceAll(" ", "").replaceAll("\n", "");
		}
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_ == null) ? 0 : class_.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
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
		EObjectControl other = (EObjectControl) obj;
		if (class_ == null) {
			if (other.class_ != null)
				return false;
		} else if (!class_.equals(other.class_))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String values = "";
		List<NLFeature> features = class_.getFeatures();
		for (NLFeature feature : features) {
			if (feature instanceof NLAttribute) {
				values += getNLFeatureValue(feature);
			} else {
				List<EObjectControl> refs = refernces.get(feature);
				values += "[";
				if (refs != null) {
					for (EObjectControl ref : refs) {
						values += ref.getName();
						if (refs.indexOf(ref) != refs.size() - 1) {
							values += ",";
						}
					}
				}
				values += "]";
			}
			if (features.indexOf(feature) != features.size() - 1) {
				values += ",";
			}
		}
		return getName() + "{" + values + "}";
	}
	
	public void validate() {
		 if (class_.isAbstract()) {
			 //TODO no puede haber clases abstractas
		 }
		 
		 
		 
	}

}
