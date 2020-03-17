/**
 */
package socioProjects.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import es.uam.app.actions.Add;
import es.uam.app.actions.AddMetamodel;
import es.uam.app.actions.Delete;
import es.uam.app.actions.DeleteMetamodel;
import es.uam.app.actions.Update;
import es.uam.app.actions.UpdateMetamodel;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.parser.NP;
import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.parser.WordConfigure;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.EcoreControl;
import es.uam.app.projects.ecore.Feature;
import es.uam.app.projects.ecore.ReferenceControl;
import es.uam.app.words.WordNet;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;
import socioProjects.MetamodelProject;
import socioProjects.SocioProjectsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Metamodel Project</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class MetamodelProjectImpl extends ProjectImpl implements MetamodelProject {

	private EcoreControl ec;

	private static Map<Class<? extends ExtractionRule<MetamodelProject>>, Constructor<? extends ExtractionRule<MetamodelProject>>> extractionRules = new HashMap<>();

	public static void registerRule(Class<? extends ExtractionRule<MetamodelProject>> er)
			throws NoSuchMethodException, SecurityException {
		Constructor<? extends ExtractionRule<MetamodelProject>> ruleConstructor = er
				.getConstructor(new Class[] { Sentence.class, Verb.class });
		if (ruleConstructor != null) {
			extractionRules.put(er, ruleConstructor);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected MetamodelProjectImpl() {
		super();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.METAMODEL_PROJECT;
	}

	public List<Action> parseSentence(String sentence) throws Exception {
		Sentence<MetamodelProject> sentenceParse = new Sentence<MetamodelProject>(sentence);
		List<List<ExtractionRule<MetamodelProject>>> allRules = sentenceParse
				.parser(MetamodelProjectImpl.extractionRules);
		List<ExtractionRule<MetamodelProject>> rules = decide(allRules);

		List<Action> act = new ArrayList<Action>();

		for (ExtractionRule<MetamodelProject> rule : rules) {
			for (int i = 0; i < rule.numEvaluete(); i++) {
				List<Action> actual = rule.evaluete(this, i);
				for (Action a : actual) {
					a.doIt();
				}

				act.addAll(actual);
			}

		}
		return act;
	}

	@Override
	protected String createUML(List<Action> actions, List<Action> actual, boolean sort) {
		if (sort){
			return ec.createSortUML(actions, actual);
		}
		return ec.createUML(actions, actual);
	}

	@Override
	protected List<Controlador> getAllObjects() {
		return ec.getAllObjects();
	}

	@Override
	public String validate() {

		Diagnostic diagnostic = null;

		diagnostic = ec.validate();

		String validateRet;
		List<Diagnostic> diagnosticChild = diagnostic.getChildren();
		if (diagnosticChild.isEmpty()) {
			validateRet = getStringDiagnostic(diagnostic);
		} else {
			validateRet = "";
			for (Diagnostic d : diagnosticChild) {
				String diadnostic = getStringDiagnostic(d);
				if (diadnostic != null && diadnostic != "" && diadnostic != " ") {
					validateRet += diadnostic + "\n";
				}
			}
		}
		return validateRet;

	}

	public String getStringDiagnostic(Diagnostic d) {
		if (d.getSeverity() == Diagnostic.ERROR) {
			if (d.getCode() == 1) {
				return "";
			} else if (d.getCode() == 40) {
				if (d.getData().size() >= 1) {
					Object o = d.getData().get(0);
					if (o instanceof EStructuralFeature) {
						return "ERROR: The type of " + ((EStructuralFeature) o).getName() + " in "
								+ ((EStructuralFeature) o).getEContainingClass().getName() + " must be set.";
					}
				}

			} else if (d.getCode() == 26) {
				if (d.getData().size() >= 1) {
					Object o = d.getData().get(0);
					if (o instanceof EClass) {
						return "ERROR: The class " + ((EClass) o).getName() + " cannot be a super type of itself.";
					}
				}
			} else if (d.getCode() == 32) {
				if (d.getData().size() >= 2) {
					Object o = d.getData().get(0);
					Object feature = d.getData().get(1);
					if (o instanceof EClass && feature instanceof EStructuralFeature) {
						return "ERROR: There cannot be two features named " + ((EStructuralFeature) feature).getName()
								+ " in the class " + ((EClass) o).getName() + ".";
					}
				}
			}
			return "ERROR: " + d.getMessage();
		} else if (d.getSeverity() == Diagnostic.WARNING) {
			return "WARNING: " + d.getMessage();
		} else {
			return "Validation completed successfully";
		}
	}

	/* add unAdd elements */
	@Override
	public void addAttribute(AttributeControl attr, ClassControl of) {
		of.addAttrRef(attr.getEAtribute());
	}

	@Override
	public void unAddAttribute(AttributeControl attr, ClassControl of) {
		of.removeAttrRef(attr.getEAtribute());

	}

	@Override
	public void addReference(ReferenceControl ref, ClassControl of) {
		of.addAttrRef(ref.getEReference());

	}

	@Override
	public void unAddReference(ReferenceControl ref, ClassControl of) {
		of.removeAttrRef(ref.getEReference());
	}

	@Override
	public void addClass(ClassControl clase) {
		ec.addClass(clase);
	}

	@Override
	public void unAddClass(ClassControl clase) {
		ec.remove(clase);
	}

	/* remove unRemove elements */
	@Override
	public void removeAttribute(AttributeControl atr, ClassControl parent) {
		atr.copyValuesIn(atr);
		this.remove.getElementsDeletes().add(atr.getObject());
		parent.removeAttrRef(atr.getEAtribute());
	}

	@Override
	public void unRemoveAttribute(AttributeControl atr) {
		ClassControl parent = ec.getClass(atr.getParentName());
		this.remove.getElementsDeletes().remove(atr.getObject());
		parent.addAttrRef(atr.getEAtribute());

	}

	@Override
	public void removeReference(ReferenceControl ref, ClassControl parent) {
		ref.copyValuesIn(ref);
		this.remove.getElementsDeletes().add(ref.getObject());
		parent.removeAttrRef(ref.getEReference());

	}

	@Override
	public void unRemoveReference(ReferenceControl ref) {
		ClassControl type = ec.getClass(ref.getTypeName());
		ClassControl parent = ec.getClass(ref.getParentName());
		if (type != null) {
			ref.setType(type);
		}
		remove.getElementsDeletes().remove(ref.getObject());
		parent.addAttrRef(ref.getEReference());

	}

	@Override
	public void removeClass(ClassControl class_) {
		this.remove.getElementsDeletes().add(class_.getObject());
		ec.remove(class_);

	}

	@Override
	public void unRemoveClass(ClassControl class_) {
		this.remove.getElementsDeletes().remove(class_.getObject());
		ec.addClass(class_);

	}

	/* get elements */
	@Override
	public ClassControl getClass(String clas) throws FileNotFoundException, JWNLException {
		ClassControl ret = ec.getClass(clas);

		if (ret == null) {
			List<String> synonyms;
			synonyms = WordNet.getWordNet().getSynonyms(clas);

			for (String s : synonyms) {
				ret = ec.getClass(s);
				if (ret != null) {
					return ret;
				}
			}
		}

		return ret;
	}

	@Override
	public ClassControl getClass(NP element) throws FileNotFoundException, JWNLException {

		ClassControl ret = this.getClass(element.lemmaUpperCammelCase());
		if (ret == null) {
			List<String> nouns;
			if (element.getNoun() != null) {
				nouns = WordNet.getWordNet().getSynonyms(element.getNoun().getLemma());
			} else {
				nouns = new ArrayList<>();
			}
			List<String> adjs;
			if (!element.getAdj().isEmpty()) {
				adjs = WordNet.getWordNet().getSynonyms(element.getAdjCammelCase());
			} else {
				adjs = new ArrayList<>();
			}
			for (String n : nouns) {
				for (String a : adjs) {
					ret = ec.getClass(WordConfigure.startUpperCase(a) + WordConfigure.startUpperCase(n));
					if (ret != null) {
						return ret;
					}
				}
			}

			for (String n : nouns) {
				ret = ec.getClass(WordConfigure.startUpperCase(n));
				if (ret != null) {
					return ret;
				}
			}

		}
		return ret;

	}

	@Override
	public ClassControl getExactlyClass(String clas) throws FileNotFoundException, JWNLException {
		ClassControl ret = ec.getExactlyClass(clas);
		return ret;
	}

	@Override
	public ClassControl getExactlyClass(NP element) throws FileNotFoundException, JWNLException {

		ClassControl ret = this.getExactlyClass(element.lemmaUpperCammelCase());
		return ret;

	}

	@Override
	public Feature getFeature(String verb) throws FileNotFoundException, JWNLException {
		String feature = WordConfigure.startLowerCase(verb);
		List<ClassControl> classes = ec.getClasses();
		Feature ret = null;
		for (ClassControl cc : classes) {
			ret = cc.getAttr(feature);
			if (ret == null) {
				ret = cc.getRef(feature);
			}
			if (ret != null) {
				return ret;
			}
		}

		List<String> synonyms;
		synonyms = WordNet.getWordNet().getSynonyms(feature);

		for (String s : synonyms) {
			for (ClassControl cc : classes) {
				ret = cc.getAttr(WordConfigure.startLowerCase(s));
				if (ret == null) {
					ret = cc.getRef(WordConfigure.startLowerCase(s));
				}
				if (ret != null) {
					return ret;
				}
			}
		}

		return null;
	}

	@Override
	public Feature getFeature(String verb, ClassControl cc) throws FileNotFoundException, JWNLException {

		String feature = WordConfigure.startLowerCase(verb);

		if (cc == null) {
			return getFeature(feature);
		}
		Feature ret = cc.getAttr(feature);
		if (ret == null) {
			ret = cc.getRef(feature);
		}

		if (ret == null) {
			List<String> synonyms;

			synonyms = WordNet.getWordNet().getSynonyms(feature);

			for (String s : synonyms) {
				ret = cc.getAttr(WordConfigure.startLowerCase(s));
				if (ret == null) {
					ret = cc.getRef(WordConfigure.startLowerCase(s));
				}
				if (ret != null) {
					return ret;
				}
			}
		}
		return ret;
	}

	@Override
	public Feature getExactlyFeature(String verb, ClassControl cc) throws FileNotFoundException, JWNLException {

		String feature = WordConfigure.startLowerCase(verb);

		if (cc == null) {
			return null;
		}
		Feature ret = cc.getAttr(feature);
		if (ret == null) {
			ret = cc.getRef(feature);
		}
		return ret;
	}

	@Override
	public List<ReferenceControl> getRefereceTo(ClassControl cc) {
		return ec.getReferencesTo(cc);
	}

	@Override
	public List<ClassControl> getSubTypesOf(ClassControl c) {
		return ec.getSubTypesOf(c);
	}

	@Override
	public String getFileExtension() {
		return "ecore";
	}

	@Override
	String getType() {
		return "metamodel";
	}

	@Override
	protected void removeFiles() {
		File f = new File(getFilePath());
		f.delete();
	}

	@Override
	protected void initialize2() throws FatalException {
		if (model != null) {
			ec = new EcoreControl(getFilePath());
		} else {
			ec = new EcoreControl(getFilePath(), name);
			this.model = ec.getObject();
		}
	}

	@Override
	public Add<MetamodelProject> createAddAction(EObject element) {
		return AddMetamodel.createAction(element, this);
	}

	@Override
	public Delete<MetamodelProject> createDeleteAction(EObject element) {

		return DeleteMetamodel.createAction(this, element);
	}

	@Override
	public Update<MetamodelProject> createUpdateAction(EObject element, EObject new_, EObject old) {
		return UpdateMetamodel.createAction(element, old, new_, this);
	}

	@Override
	public void save() {
		ec.save();

	}

	public void setModel(EObject model) {
		if (ec != null) {
			List<EObject> contents = ec.getContents();
			contents.clear();
			contents.add(model);
		}
		super.setModel(model);
	}



} // MetamodelProjectImpl
