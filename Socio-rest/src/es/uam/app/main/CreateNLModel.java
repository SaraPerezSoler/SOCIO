package es.uam.app.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import modelInfo.ModelInfoFactory;
import modelInfo.NLAttribute;
import modelInfo.NLClass;
import modelInfo.NLModel;
import modelInfo.NLReference;

public class CreateNLModel {

	public CreateNLModel() {
	}

	public static void main(String[] args) {
		Resource planingMetamodel = SocioData.getResourceSet()
				.getResource(URI.createURI("Metamodel\\ProjectPlaning.ecore"), true);
		Resource planingNLmodel = SocioData.getResourceSet()
				.createResource(URI.createURI("Metamodel\\ProjectPlaning.xmi"));
		EPackage pack = (EPackage)planingMetamodel.getContents().get(0);
		NLModel nlModel = ModelInfoFactory.eINSTANCE.createNLModel();
		
		nlModel.setName(pack.getName());
		nlModel.setModel(pack);
		nlModel.setAsk(false);
		nlModel.setContainer(false);
		
		List<EObject> content = pack.eContents();
		for (EObject con: content) {
			if (con instanceof EClass) {
				EClass clas = (EClass) con;
				NLClass nlClass = ModelInfoFactory.eINSTANCE.createNLClass();
				nlClass.setClass(clas);
				nlClass.setRoot(false);
				nlClass.setCreate(true);
				if (clas.isAbstract()) {
					nlClass.setAbstract(true);
					nlClass.setInstantiable(false);
					clas.setAbstract(false);
				}else {
					nlClass.setAbstract(false);
					nlClass.setInstantiable(true);
				}
				List<EStructuralFeature> features = new ArrayList<>();
				features.addAll(clas.getEStructuralFeatures());
				for (EClass superT: clas.getESuperTypes()) {
					features.addAll(superT.getEStructuralFeatures());
				}
				
				for (EStructuralFeature feature : features) {
					if (feature instanceof EReference) {
						NLReference nlReference = ModelInfoFactory.eINSTANCE.createNLReference();
						nlReference.setReference((EReference)feature);
						nlReference.setLowerBound(feature.getLowerBound());
						nlReference.setUpperBound(feature.getUpperBound());
						feature.setLowerBound(0);
						feature.setUpperBound(-1);
						nlReference.setAsk(false);
						nlClass.getFeatures().add(nlReference);
					}else if (feature instanceof EAttribute) {
						NLAttribute nlAttribute = ModelInfoFactory.eINSTANCE.createNLAttribute();
						nlAttribute.setAttribute((EAttribute)feature);
						if (isId(clas, (EAttribute)feature)){
							nlAttribute.setAsk(true);
							nlAttribute.setLowerBound(1);
							nlAttribute.setUpperBound(1);
							feature.setLowerBound(1);
							feature.setUpperBound(1);
							nlClass.getId().add(nlAttribute);
						}else {
							nlAttribute.setAsk(false);
							nlAttribute.setLowerBound(feature.getLowerBound());
							nlAttribute.setUpperBound(feature.getUpperBound());
							feature.setLowerBound(0);
							feature.setUpperBound(-1);
							nlClass.getFeatures().add(nlAttribute);
						}
					}
				}
				nlModel.getClasses().add(nlClass);
			}
			
		}
		planingNLmodel.getContents().add(nlModel);
		try {
			/*
			 * Save the resource
			 */
			planingNLmodel.save(null);
			planingMetamodel.save(null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static NLModel getNlModel(File f) {
		Resource planingMetamodel = SocioData.getResourceSet()
				.getResource(URI.createURI(f.getPath()), true);
		EPackage pack = (EPackage)planingMetamodel.getContents().get(0);
		NLModel nlModel = ModelInfoFactory.eINSTANCE.createNLModel();
		
		nlModel.setName(pack.getName());
		nlModel.setModel(pack);
		nlModel.setAsk(false);
		nlModel.setContainer(false);
		
		List<EObject> content = pack.eContents();
		for (EObject con: content) {
			if (con instanceof EClass) {
				EClass clas = (EClass) con;
				NLClass nlClass = ModelInfoFactory.eINSTANCE.createNLClass();
				nlClass.setClass(clas);
				nlClass.setRoot(false);
				nlClass.setCreate(true);
				if (clas.isAbstract()) {
					nlClass.setAbstract(true);
					nlClass.setInstantiable(false);
					clas.setAbstract(false);
				}else {
					nlClass.setAbstract(false);
					nlClass.setInstantiable(true);
				}
				List<EStructuralFeature> features = new ArrayList<>();
				features.addAll(clas.getEStructuralFeatures());
				for (EClass superT: clas.getESuperTypes()) {
					features.addAll(superT.getEStructuralFeatures());
				}
				
				for (EStructuralFeature feature : features) {
					if (feature instanceof EReference) {
						NLReference nlReference = ModelInfoFactory.eINSTANCE.createNLReference();
						nlReference.setReference((EReference)feature);
						nlReference.setLowerBound(feature.getLowerBound());
						nlReference.setUpperBound(feature.getUpperBound());
						feature.setLowerBound(0);
						feature.setUpperBound(-1);
						nlReference.setAsk(false);
						nlClass.getFeatures().add(nlReference);
					}else if (feature instanceof EAttribute) {
						NLAttribute nlAttribute = ModelInfoFactory.eINSTANCE.createNLAttribute();
						nlAttribute.setAttribute((EAttribute)feature);
						if (isId(clas, (EAttribute)feature)){
							nlAttribute.setAsk(true);
							nlAttribute.setLowerBound(1);
							nlAttribute.setUpperBound(1);
							feature.setLowerBound(1);
							feature.setUpperBound(1);
							nlClass.getId().add(nlAttribute);
						}else {
							nlAttribute.setAsk(false);
							nlAttribute.setLowerBound(feature.getLowerBound());
							nlAttribute.setUpperBound(feature.getUpperBound());
							feature.setLowerBound(0);
							feature.setUpperBound(-1);
							nlClass.getFeatures().add(nlAttribute);
						}
					}
				}
				nlModel.getClasses().add(nlClass);
			}
			
		}
		return nlModel;

	}
	
//	public static void main(String[] args) {
//		Resource planingMetamodel = SocioData.getResourceSet()
//				.getResource(URI.createURI("Metamodel\\ProjectPlaning.ecore"), true);
//		Resource planingNLmodel = SocioData.getResourceSet()
//				.getResource(URI.createURI("Metamodel\\ProjectPlaning.xmi"), true);
//		NLModel model = (NLModel) planingNLmodel.getContents().get(0);
//		String name = model.getName();
//		System.out.println(name);
//		System.out.println(model);
//		System.out.println(model.getModel().eContents());
//	}
	
	private static boolean isId(EClass clas, EAttribute attr) {
		if (clas.getName().equals("Project") && attr.getName().equals("name")) {
			return true;
		}
		
		if (clas.getName().equals("TaskUnit") && attr.getName().equals("id")) {
			return true;
		}
		if (clas.getName().equals("Task") && attr.getName().equals("id")) {
			return true;
		}
		if (clas.getName().equals("Milestone") && attr.getName().equals("id")) {
			return true;
		}
		if (clas.getName().equals("CompositeTask") && attr.getName().equals("id")) {
			return true;
		}
		if (clas.getName().equals("Human") && (attr.getName().equals("name")|| attr.getName().equals("surname"))) {
			return true;
		}
		if (clas.getName().equals("Technical") && attr.getName().equals("id")) {
			return true;
		}
		return false;
	}

}
