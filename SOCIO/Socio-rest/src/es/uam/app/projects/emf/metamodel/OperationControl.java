package es.uam.app.projects.emf.metamodel;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

public class OperationControl implements MetamodelControlInterface {

	private EOperation eOp;

	public OperationControl() {
		eOp=factory.createEOperation();
	}
	public OperationControl(EOperation op) {
		eOp=op;
	}
	public OperationControl(String name) {
		eOp=factory.createEOperation();
		eOp.setName(name);
	}

	public OperationControl(String name, EClassifier type) {
		eOp=factory.createEOperation();
		eOp.setName(name);
		eOp.setEType(type);
	}
	
	public void setEExceptio(EClassifier e){
		eOp.getEExceptions().add(e);
	}
	public void setEType (String type){
		eOp.setEType(MetamodelControlInterface.getType(type));
	}
	public void setEType (EClassifier type){
		eOp.setEType(type);
	}
	public void setLowerBound(int lowerBound){
		eOp.setLowerBound(lowerBound);
	}
	public void setName(String name){
		eOp.setName(name);
	}
	public void setOrdered(boolean value){
		eOp.setOrdered(value);
	}
	public void setUnique(boolean value){
		eOp.setUnique(value);
	}
	public void setUpperBound(int upperBound){
		eOp.setUpperBound(upperBound);
	}
	
	public void addParameter (EParameter param){
		eOp.getEParameters().add(param);
	}
	@Override
	public EObject getObject() {
		// TODO Auto-generated method stub
		return eOp;
	}
	@Override
	public String getName() {
		return eOp.getName();
	}
	@Override
	public String elementType() {
		return "operation";
	}
}
