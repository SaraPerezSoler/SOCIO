package es.uam.app.projects.emf.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.plantUML.CreateModelUML;
import es.uam.app.projects.emf.Controlador;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;
import modelInfo.NLModel;
import modelInfo.NLReference;
import projectHistory.Action;

public class ModelControl implements Controlador {
	private Resource resource;
	private NLModel model;
	private EObjectControl root;

	public ModelControl(String mdUri, NLModel model) throws FatalException {
		try {
			this.model = model;
			createResource(mdUri);
			if (resource.getContents().isEmpty()) {

				root = createEObject(model.getRoot());

				resource.getContents().add(root.getObject());
			} else {
				root = new EObjectControl(resource.getContents().get(0), model.getRoot());
			}
		} catch (InternalException e) {
			throw new FatalException(e.getMessage());
		}
	}

	public ModelControl(Resource eResource, NLModel model) throws FatalException {
		try {
			this.model = model;
			this.resource = eResource;
			if (resource.getContents().isEmpty()) {

				root = createEObject(model.getRoot());

				resource.getContents().add(root.getObject());
			} else {
				root = new EObjectControl(resource.getContents().get(0), model.getRoot());
			}
		} catch (InternalException e) {
			throw new FatalException(e.getMessage());
		}

	}

	private void createResource(String mdUri) throws FatalException {
		EPackage pck = model.getModel();
		SocioData.getResourceSet().getPackageRegistry().put(pck.getName(), pck);

		try {
			File f = new File(mdUri);
			if (!f.exists()) {
				resource = SocioData.getResourceSet().createResource(URI.createURI(mdUri));
			} else {
				resource = SocioData.getResourceSet().getResource(URI.createURI(mdUri), true);
			}

		} catch (Exception e) {
			throw new FatalException(
					"In class " + this.getClass().getName() + ": the file " + mdUri + " can be opened");
		}
	}

	public void addObjectToResource(EObjectControl object) {
		addObjectToResource(object.getObject());
	}

	public void addObjectToResource(EObject object) {
		if (!resource.getContents().contains(object)) {
			resource.getContents().add(object);
		}
	}

	public EObjectControl createEObject(NLClass eclass) throws InternalException {
		EObject object = model.getModel().getEFactoryInstance().create(eclass.getClass_());
		resource.getContents().add(object);
		return new EObjectControl(object, eclass);
	}

	public EObjectControl createEObject(String className) throws InternalException {
		NLClass class_ = getNLClass(className);
		if (!class_.isInstantiable()) {
			throw new InternalException("The class " + className + " is not instantiable");
		}
		return createEObject(class_);
	}

	public void addAttribute(EObjectControl object, NLAttribute attribute, Object value) throws InternalException {
		// Object currValue = object.getNLFeatureValue(attribute);??
		object.setEAttribute(attribute, value);
		// if (currValue.) ??

	}

	public void addAttribute(EObjectControl object, String attName, Object value) throws InternalException {
		NLAttribute attribute = object.getNLClass().getNLAttribute(attName);
		addAttribute(object, attribute, value);
	}

	public void addReference(EObjectControl object, String refName, EObjectControl value) throws InternalException {
		NLReference reference = getNLReference(object.getNLClass(), refName);
		addReference(object, reference, value);

	}
	
	public void addReference(EObjectControl object, NLReference reference, EObjectControl value) throws InternalException {
		if (reference.getReference().isContainment()) {
			if (resource.getContents().contains(value.getObject())) {
				resource.getContents().remove(value.getObject());
			}
		}
		object.setEReference(value, reference);

	}

	public EObjectControl addReference(String srcClassName, List<Object> srcId, String trgClassName, List<Object> trgId,
			String referenceName) throws InternalException {
		/*
		 * NLClass srcClass = getNLClass(srcClassName); NLClass trgClass =
		 * getNLClass(trgClassName); NLReference ref = getNLReference(srcClass,
		 * referenceName); if (!ref.isType(trgClass)) { throw new
		 * InternalException("The type class of the reference " + ref.getName() +
		 * " does not equal that the class " + trgClass.getName()); } EObjectControl
		 * srcObject = getObject(srcClass, srcId); EObjectControl trgObject =
		 * getObject(trgClass, trgId);
		 * 
		 * if (srcObject == null) { throw new InternalException(
		 * "The object with the class " + srcClass.getName() + " and the id " + srcId +
		 * " does not exist"); }
		 * 
		 * if (trgObject == null) { throw new InternalException(
		 * "The object with the class " + trgClass.getName() + " and the id " + trgId +
		 * " does not exist"); } if (ref.getReference().isContainment()) { if
		 * (resource.getContents().contains(trgObject.getObject())) {
		 * resource.getContents().remove(trgObject.getObject()); } }
		 * srcObject.setEReference(trgObject, ref); return srcObject;
		 */
		// TODO
		return null;
	}

	public void restoreFeature(EObjectControl object, NLFeature feature, Object nlFeatureValue) {
		object.restoreFeature(feature, nlFeatureValue);

	}

	public void unsetAttribute(EObjectControl object, String attName, Object value) throws InternalException {
		NLAttribute attribute = getNLAttribute(object.getNLClass(), attName);
		unsetAttribute(object, attribute, value);

	}

	public void unsetAttribute(EObjectControl object, NLAttribute attribute, Object value) {
		object.unset(attribute, value);
	}

	public void unsetAttribute(EObjectControl object, String attName) throws InternalException {
		NLAttribute attribute = getNLAttribute(object.getNLClass(), attName);
		unsetAttribute(object, attribute);

	}

	public void unsetReference(EObjectControl object, String refName, EObjectControl value) {
		NLReference reference = object.getNLClass().getNLReference(refName);
		unsetReference(object, reference, value);

	}

	public void unsetReference(EObjectControl object, NLReference feature, EObjectControl value) {

		if (feature.getReference().isContainment()) {
			this.addObjectToResource(value);
		}
		object.unset(feature, value);
	}

	public void unsetReference(EObjectControl object, String refName) {
		NLReference reference = object.getNLClass().getNLReference(refName);
		unsetReference(object, reference);

	}

	public void unsetReference(EObjectControl object, NLReference feature) {
		Object currValue = object.getNLFeatureValue(feature);
		if (currValue instanceof List<?>) {
			List<?> currList = (List<?>) currValue;
			if (feature.getReference().isContainment()) {
				this.addAllObjectsToResource(currList);
			}
		} else {
			if (feature.getReference().isContainment()) {
				this.addObjectToResource((EObject) currValue);
			}
		}
		object.unset(feature);

	}

	private void addAllObjectsToResource(List<?> currList) {
		for (Object obj : currList) {
			if (obj instanceof EObject) {
				addObjectToResource((EObject) obj);
			}
		}

	}

	public void unsetAttribute(EObjectControl object, NLAttribute feature) {
		object.unset(feature);
	}

	public NLClass getNLClass(String className) throws InternalException {
		NLClass eclass = model.getClass(className);
		if (eclass == null) {
			throw new InternalException(
					"The class with name " + className + " does not exist in the meta-model " + model.getName());
		}
		return eclass;
	}

	public NLClass getNLClass(EClass clas) {
		NLClass eclass = model.getClass(clas);
		return eclass;
	}

	public NLFeature getNLFeature(EStructuralFeature feature) {
		NLClass eclass = getNLClass(feature.getEContainingClass());

		return eclass.getNLFeature(feature);
	}

	public NLAttribute getNLAttribute(EAttribute attribute) {
		NLClass eclass = getNLClass(attribute.getEContainingClass());

		return eclass.getNLAttribute(attribute);

	}

	public NLAttribute getNLAttribute(String className, String attributeName) throws InternalException {
		NLClass eclass = getNLClass(className);
		return getNLAttribute(eclass, attributeName);

	}

	private NLAttribute getNLAttribute(NLClass eclass, String attributeName) throws InternalException {
		NLAttribute efeature = eclass.getNLAttribute(attributeName);
		if (efeature == null) {
			throw new InternalException(
					"The featute with name " + attributeName + " does not exist in the class " + eclass.getName());
		} else if (!(efeature instanceof EAttribute)) {

			throw new InternalException(
					"The attribute with name " + attributeName + " does not exist in the class " + eclass.getName());
		}
		return efeature;

	}

	public NLReference getNLReference(EReference reference) throws InternalException {
		NLClass eclass = getNLClass(reference.getEContainingClass());

		return eclass.getNLReference(reference);
	}

	public NLReference getNLReference(String className, String referenceName) throws InternalException {
		NLClass eclass = getNLClass(className);
		return getNLReference(eclass, referenceName);
	}

	private NLReference getNLReference(NLClass eclass, String referenceName) throws InternalException {
		NLReference efeature = eclass.getNLReference(referenceName);
		if (efeature == null) {
			throw new InternalException(
					"The featute with name " + referenceName + " does not exist in the class " + eclass.getName());
		} else if (!(efeature instanceof EAttribute)) {
			throw new InternalException(
					"The reference with name " + referenceName + " does not exist in the class " + eclass.getName());
		}
		return efeature;

	}

	public EObjectControl getObject(String className, List<Object> value) throws InternalException {
		NLClass eclass = getNLClass(className);

		return getObject(eclass, value);
	}

	public EObjectControl getObject(NLClass eclass, List<Object> value) throws InternalException {

		TreeIterator<EObject> iterator = resource.getAllContents();

		while (iterator.hasNext()) {
			EObject object = iterator.next();
			if (object.eClass().equals(eclass.getClass_())) {
				EObjectControl objControl = new EObjectControl(object, eclass);

				if (objControl.is(value)) {
					return objControl;
				}
			}

		}
		return null;
	}

	public EObject getObject() {
		return root.getObject();
	}

	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public String elementType() {
		return "xmi";
	}

	public List<EObjectControl> getAllObjects() {
		List<EObjectControl> ret = new ArrayList<>();

		TreeIterator<EObject> iterator = resource.getAllContents();

		while (iterator.hasNext()) {
			EObject object = iterator.next();
			NLClass clas = getNLClass(object.eClass());
			ret.add(new EObjectControl(object, clas));
		}
		return ret;
	}

	public void save() {
		try {
			/*
			 * Save the resource
			 */
			resource.save(null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Diagnostic validate(EObjectControl object) {
		// TODO Auto-generated method stub
		return null;
	}

	public EObjectControl getControl(EObject object) {
		NLClass nlclass = getNLClass(object.eClass());
		return new EObjectControl(object, nlclass);
	}

	public void removeObject(EObjectControl object) {
		
		if (object.getObject().eContainer() != null) {
			EObjectControl container = getControl(object.getObject().eContainer());
			NLReference reference = container.getNLFeature(object);
			unsetReference(container, reference, object);
		}
		resource.getContents().remove(object.getObject());

	}

	public String createUML(List<Action> actions, List<Action> pastActions) {
		return new CreateModelUML(this).createUML(actions, pastActions);
	}

}
