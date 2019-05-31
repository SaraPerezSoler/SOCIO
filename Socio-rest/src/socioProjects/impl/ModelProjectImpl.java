/**
 */
package socioProjects.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import es.uam.app.actions.Add;
import es.uam.app.actions.AddModel;
import es.uam.app.actions.Delete;
import es.uam.app.actions.DeleteModel;
import es.uam.app.actions.Update;
import es.uam.app.actions.UpdateModel;
import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.model.EObjectControl;
import es.uam.app.projects.emf.model.ModelControl;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLFeature;
import modelInfo.NLModel;
import projectHistory.Action;
import socioProjects.ModelProject;
import socioProjects.SocioProjectsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model
 * Projec</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelProjectImpl extends ProjectImpl implements ModelProject {

	private ModelControl mc;
	private NLModel nlmodel;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.MODEL_PROJEC;
	}

	@Override
	public List<Action> parseSentence(String sentence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String createUML(List<Action> actions, List<Action> actual, boolean sort) {
		return mc.createUML(actions, actual);
	}

	@Override
	protected List<Controlador> getAllObjects() {
		List<Controlador> ret = new ArrayList<>();
		ret.addAll(mc.getAllObjects());
		return ret;
	}

	/*
	 * 1. Comprobar si solo hay un objecto suelto...sino error, el resto de
	 * elementos deben ser asignados.*************************************** 2.
	 * Evaluar todas las clases sueltas
	 */
	@Override
	public String validate() {

		String validateRet = "";
		List<EObjectControl> objects = mc.getAllObjects();
		for (EObjectControl obj : objects) {
			validateRet += "Validating " + obj.getName() + ":\n";
			Diagnostic diagnostic = mc.validate(obj);
			List<Diagnostic> diagnosticChild = diagnostic.getChildren();
			if (diagnosticChild.isEmpty()) {
				validateRet += getStringDiagnostic(diagnostic);
			} else {
				for (Diagnostic d : diagnosticChild) {
					String diadnostic = getStringDiagnostic(d);
					if (diadnostic != null && diadnostic != "" && diadnostic != " ") {
						validateRet += diadnostic + "\n";
					}
				}
			}
		}
		return validateRet;
	}

	public String getStringDiagnostic(Diagnostic d) {

		if (d.getSeverity() == Diagnostic.ERROR) {
			if (d.getCode() == 1) {
				EObjectControl object = mc.getControl((EObject) d.getData().get(0));
				NLFeature feature = mc.getNLFeature((EStructuralFeature) d.getData().get(1));

				return "\t- ERROR: " + getCode1Text(object, feature);
			}
			return "ERROR: " + d.getMessage();
		} else if (d.getSeverity() == Diagnostic.WARNING) {
			return "WARNING: " + d.getMessage();
		} else {
			return "Validation completed successfully";
		}
	}

	private String getCode1Text(EObjectControl object, NLFeature feature) {

		String ret = "The feature " + feature.getName() + " of " + object.getName();
		Object value = object.getNLFeatureValue(feature);
		int min = feature.getFeature().getLowerBound();
		int max = feature.getFeature().getUpperBound();

		if (value instanceof List<?>) {
			List<?> list = (List<?>) value;
			if (list.size() < min) {
				return ret + " with " + list.size() + " values, must have at least " + min + " values";
			}
			if (list.size() > max) {
				return ret + " with " + list.size() + " values, may have at most " + max + " values";
			}
		} else if (value == null) {
			if (min == 1) {
				return ret + " must have some value";
			}
		}
		return ret + " must have at least " + min + " and may have at most " + max + " values";

	}

	@Override
	public String getFileExtension() {
		return "xmi";
	}

	@Override
	public String getType() {
		return "model";
	}

	@Override
	public void removeFiles() {
		File f = new File(getFilePath());
		f.delete();

	}

	@Override
	public void initialize2() throws FatalException {

		String nlmodelUri = getPath() + "/" + getName() + ".xmi";
		if (nlmodel == null) {
			File f = new File(nlmodelUri);
			if (!f.exists()) {
				throw new FatalException(
						"In class " + this.getClass().getName() + ": the file " + nlmodelUri + " can be opened");
			}
			Resource resource = SocioData.getResourceSet().getResource(URI.createURI(nlmodelUri), true);
			nlmodel = (NLModel) resource.getContents().get(0);
		}
		mc = new ModelControl(getFilePath(), nlmodel);
		if (model == null) {
			this.model = mc.getObject();
		}

	}

	@Override
	public Add<ModelProject> createAddAction(EObject element) {
		return AddModel.createAction(element, this);
	}

	@Override
	public Delete<ModelProject> createDeleteAction(EObject element) {
		return DeleteModel.createAction(this, element);
	}

	@Override
	public Update<ModelProject> createUpdateAction(EObject element, EObject new_, EObject old) {
		return UpdateModel.createAction(element, old, new_, this);

	}

	@Override
	public void save() {
		mc.save();
	}

	@Override
	public EObjectControl createEObject(String name) throws InternalException {
		return mc.createEObject(name);
	}

	public NLClass getNLClass(String className) throws InternalException {
		return mc.getNLClass(className);
	}

	public NLClass getNLClass(EClass eclass) {
		return mc.getNLClass(eclass);
	}

	@Override
	public EObjectControl getObject(String className, Map<String, Object> id) throws InternalException {
		
		List<Object> idList = id.values().stream().collect(Collectors.toList()); 
		NLClass nlclass = getNLClass(className);
		List<EObjectControl> objects = mc.getAllObjects();
		for (EObjectControl object : objects) {
			if (object.getNLClass().equals(nlclass) && object.is(idList)) {
				return object;
			}
		}
		return null;
	}

	@Override
	public void removeObject(EObjectControl object) {
		//TODO guardar objeto en removeLog
		mc.removeObject(object);

	}

	@Override
	public void addObject(EObjectControl object) {
		mc.addObjectToResource(object);

	}

	@Override
	public void setId(EObjectControl object, Map<String, Object> id) throws InternalException {
		List<NLAttribute> NLids = object.getNLClass().getId();
		for (NLAttribute NLid : NLids) {
			mc.addAttribute (object, NLid, id.get(NLid.getName()));
		}

	}

	@Override
	public void setEAttribute(EObjectControl object, String attName, Object value) throws InternalException {
		mc.addAttribute(object, attName, value);

	}

	@Override
	public void restoreFeature(EObjectControl object, NLFeature feature, Object nlFeatureValue) {
		mc.restoreFeature(object, feature, nlFeatureValue);

	}

	@Override
	public void setEReference(EObjectControl object, EObjectControl value, String refName) throws InternalException {
		mc.addReference(object, refName, value);

	}

	@Override
	public void unsetEReference(EObjectControl object, String refName, EObjectControl value) {
		mc.unsetReference(object, refName, value);

	}
	@Override
	public void unsetEReference(EObjectControl object, String refName) {
		mc.unsetReference(object, refName);

	}
	@Override
	public void unsetEAttribute(EObjectControl object, String attName, Object value) throws InternalException {
		mc.unsetAttribute(object, attName, value);

	}

	@Override
	public void unRemoveObject(EObjectControl object) {
		// TODO Auto-generated method stub

	}

	@Override
	public EObjectControl getControl(EObject obj) {
		return mc.getControl(obj);
	}

} // ModelProjecImpl
