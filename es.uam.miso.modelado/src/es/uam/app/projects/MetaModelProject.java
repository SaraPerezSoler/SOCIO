package es.uam.app.projects;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

import es.uam.app.actions.ActionModel;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.ReceivedMessage;
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
import es.uam.app.projects.log.HistoryControl;
import es.uam.app.projects.log.RemoveLogControl;
import es.uam.app.words.WordNet;
import net.didion.jwnl.JWNLException;

public class MetaModelProject extends Project{


	private EcoreControl ec;
	
	private static Map<Class<? extends ExtractionRule<MetaModelProject>>, Constructor<? extends ExtractionRule<MetaModelProject>>> extractionRules = new HashMap<>();

	public static void registerRule(Class<? extends ExtractionRule<MetaModelProject>> er)
			throws NoSuchMethodException, SecurityException {
		Constructor<? extends ExtractionRule<MetaModelProject>> ruleConstructor = er
				.getConstructor(new Class[] { Sentence.class, Verb.class });
		if (ruleConstructor != null) {
			extractionRules.put(er, ruleConstructor);
		}
	}
	
	public static Map<Class<? extends ExtractionRule<MetaModelProject>>, Constructor<? extends ExtractionRule<MetaModelProject>>> getExtractionRules() {
		return extractionRules;
	}
	
	

	public static EcoreControl createFileProject(String name, ReceivedMessage msg) {
		return new EcoreControl(URI + "/" + name + "/" + name + ".ecore", name, name, name);
	}
	
	public static EcoreControl cargaFileProject(String name) throws FatalException {

		return new EcoreControl(URI + "/" + name + "/" + name + ".ecore");

	}

	
	
	MetaModelProject(EcoreControl ec, RemoveLogControl rlc, HistoryControl log, String name) {
		super(rlc, log, name);
		this.ec = ec;
	} 
	 
	@Override
	public String FilePath() {
		return this.ec.getPath();
	}
	
	@Override
	public FileProject getFileProject() {
		
		return ec;
	}

	@Override
	public void setFileProject(FileProject fileProj) {
		if (fileProj instanceof EcoreControl){
			ec=(EcoreControl)fileProj;
		}
		
	}

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

	public ClassControl getClass(NP element) throws FileNotFoundException, JWNLException {
		if (element.getAdj() != null && element.getAdj().lemmaEquals("abstract")) {
			return this.getClass(WordConfigure.startUpperCase(element.getNoun().getLemma()));

		} else {

			ClassControl ret = this.getClass(element.upperCammelCase());
			if (ret == null) {
				List<String> nouns;
				if (element.getNoun() != null) {
					nouns = WordNet.getWordNet().getSynonyms(element.getNoun().getLemma());
				} else {
					nouns = new ArrayList<>();
				}
				List<String> adjs;
				if (element.getAdj() != null) {
					adjs = WordNet.getWordNet().getSynonyms(element.getAdj().getLemma());
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
	}

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

	public ClassControl getExactlyClass(String clas) throws FileNotFoundException, JWNLException {
		ClassControl ret = ec.getExactlyClass(clas);
		return ret;
	}

	public ClassControl getExactlyClass(NP element) throws FileNotFoundException, JWNLException {
		if (element.getAdj() != null && element.getAdj().lemmaEquals("abstract")) {
			return this.getExactlyClass(WordConfigure.startUpperCase(element.getNoun().getLemma()));

		} else {
			ClassControl ret = this.getExactlyClass(element.upperCammelCase());
			return ret;
		}
	}

	public void addAttribute(AttributeControl attr, ClassControl of) {
		of.addAttrRef(attr.getEAtribute());

	}

	public void addClass(ClassControl clase) {
		ec.addClass(clase);
	}

	public void addReference(ReferenceControl ref, ClassControl of) {
		of.addAttrRef(ref.getEReference());

	}

	public void removeAttribute(AttributeControl atr, ClassControl parent) {

		rlc.addRemove(atr);
		parent.removeAttrRef(atr.getEAtribute());

	}

	public void removeClass(ClassControl class_) {
		rlc.addRemove(class_);
		ec.remove(class_);

	}

	public void removeReference(ReferenceControl ref, ClassControl parent) {
		rlc.addRemove(ref);
		parent.removeAttrRef(ref.getEReference());

	}

	public void unAddAttribute(AttributeControl attr, ClassControl of) {
		of.removeAttrRef(attr.getEAtribute());

	}

	public void unAddClass(ClassControl clase) {
		ec.remove(clase);
	}

	public void unAddReference(ReferenceControl ref, ClassControl of) {
		of.removeAttrRef(ref.getEReference());
	}

	public void unRemoveAttribute(AttributeControl atr) {
		ClassControl parent = ec.getClass(atr.getParentName());
		rlc.deleteRemove(atr);
		parent.addAttrRef(atr.getEAtribute());

	}

	public void unRemoveClass(ClassControl class_) {
		rlc.deleteRemove(class_);
		ec.addClass(class_);

	}

	public void unRemoveReference(ReferenceControl ref) {

		ClassControl type = ec.getClass(ref.getTypeName());
		ClassControl parent = ec.getClass(ref.getParentName());
		if (type != null) {
			ref.setType(type);
		}
		rlc.deleteRemove(ref);
		parent.addAttrRef(ref.getEReference());

	}

	public List<ReferenceControl> getRefTo(ClassControl cc) {
		return ec.getReferencesTo(cc);

	}

	public List<ClassControl> getSubTypesOf(ClassControl c) {
		return ec.getSubTypesOf(c);
	}

	String validateRet;

	public String validate() {

		Diagnostic diagnostic = null;

		diagnostic = ec.validate();

		List<Diagnostic> diagnosticChild = diagnostic.getChildren();
		if (diagnosticChild.isEmpty()) {
			validateRet = getStringDiagnostic(diagnostic);
		} else {
			validateRet = "";
			for (Diagnostic d : diagnosticChild) {
				String diadnostic=getStringDiagnostic(d);
				if (diadnostic!=null && diadnostic!="" && diadnostic!=" "){
					validateRet += diadnostic + "\n";
				}
			}
		}
		return validateRet;

	}

	public String getValidateString() {
		return validateRet;
	}

	public String getStringDiagnostic(Diagnostic d) {
		if (d.getSeverity() == Diagnostic.ERROR) {
			if (d.getCode()==1){
				return "";
			}else if (d.getCode()==40){
				Object o=d.getData().get(0);
				if (o instanceof EReference){
					return "ERROR: The type of "+((EReference)o).getName()+" in "+((EReference)o).getEContainingClass().getName()+" must be set."; 
				}else if (o instanceof EAttribute){
					return "ERROR: The type of "+((EAttribute)o).getName()+" in "+((EAttribute)o).getEContainingClass().getName()+" must be set."; 
				}
				
			}
				return "ERROR: " + d.getMessage();
		} else if (d.getSeverity() == Diagnostic.WARNING) {
			return "WARNING: " + d.getMessage();
		} else {
			return "Validation completed successfully";
		}
	}

	@Override
	public List<ActionModel> parseSentence(String sentece) throws Exception {
		Sentence<MetaModelProject> sentenceParse = new Sentence<MetaModelProject>(sentece);
		List<List<ExtractionRule<MetaModelProject>>> allRules = sentenceParse.parser(MetaModelProject.extractionRules);
		List<ExtractionRule<MetaModelProject>> rules = decide(allRules);

		List<ActionModel> act = new ArrayList<ActionModel>();

		for (ExtractionRule<MetaModelProject> rule : rules) {
			for (int i = 0; i < rule.numEvaluete(); i++) {
				List<ActionModel> actual = rule.evaluete(this, i);
				for (ActionModel a : actual) {
					a.doIt();
				}

				act.addAll(actual);
			}

		}
		return act;
	}

	@Override
	public List<Controlador> getAllObjects() {
		return ec.getAllObjects();
	}





}
