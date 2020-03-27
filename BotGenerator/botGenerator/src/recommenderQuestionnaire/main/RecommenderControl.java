package recommenderQuestionnaire.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import recommenderQuestionnaire.Questionnaire;
import recommenderQuestionnaire.RecommenderQuestionnaireFactory;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.evaluations.Evaluator;


public class RecommenderControl {
	
	private static RecommenderControl recommenderControl = null;
	private static ResourceSet resourceSet;
	private static final String RECOMENDER_MODEL_PATH = "recomenderModel.xmi"; 
	private Questionnaire questionnaire = null;
	private Resource resource;
	
	public static RecommenderControl getRecommenderControl() {
		if (recommenderControl == null) {
			recommenderControl = new RecommenderControl();
		}
		return recommenderControl;
	}
	
	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			// Especificamos la extension del fichero (para todos los ficheros),
			// y indicamos que
			// es un XMI.
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(RecommenderQuestionnairePackage.eNS_URI, RecommenderQuestionnairePackage.eINSTANCE);
		}
		return resourceSet;
	}

	 
	private RecommenderControl() {
		File f = new File(RECOMENDER_MODEL_PATH);
		if (f.exists()) {
			resource = getResourceSet().getResource(URI.createURI(RECOMENDER_MODEL_PATH), true);
			this.questionnaire = (Questionnaire) resource.getContents().get(0);
		}else {
			resource = getResourceSet().createResource(URI.createURI(RECOMENDER_MODEL_PATH));
			this.questionnaire = RecommenderQuestionnaireFactory.eINSTANCE.createQuestionnaire();
			resource.getContents().add(questionnaire);
			save();
		}
		
		try {
			Evaluator.loadEvaluators(questionnaire);
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void save() {
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
