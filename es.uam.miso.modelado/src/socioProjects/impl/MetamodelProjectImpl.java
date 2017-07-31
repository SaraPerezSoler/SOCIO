/**
 */
package socioProjects.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import es.uam.app.parser.Sentence;
import es.uam.app.parser.Verb;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.EcoreControl;
import projectHistory.Action;
import socioProjects.MetamodelProject;
import socioProjects.SocioProjectsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metamodel Project</b></em>'.
 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MetamodelProjectImpl() {
		super();	
		if (model!=null){
			ec=new EcoreControl(model.eResource());
		}else{
			ec=new EcoreControl(getPath()+"/"+name+".ecore", name);
			this.model=ec.getObject();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocioProjectsPackage.Literals.METAMODEL_PROJECT;
	}
	
	public List<Action> parseSentence(String sentence) throws Exception{
		Sentence<MetamodelProject> sentenceParse = new Sentence<MetamodelProject>(sentence);
		List<List<ExtractionRule<MetamodelProject>>> allRules = sentenceParse.parser(MetamodelProjectImpl.extractionRules);
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
	protected String createUML(List<Action> actions) {
		return ec.createUML(actions);
	}
	@Override
	protected List<Controlador> getAllObjects() {
		return ec.getAllObjects();
	}
	@Override
	public String validate()  {

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

} //MetamodelProjectImpl
