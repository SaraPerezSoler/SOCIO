package es.uam.app.projects.ecore;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class PackageControl implements Controlador{
	private EPackage ePack;

	public PackageControl() {
		ePack=factory.createEPackage();
	}
	public PackageControl(EPackage pack) {
		ePack=pack;
	}
	public PackageControl(String name) {
		ePack=factory.createEPackage();
		ePack.setName(name);
	}
	public PackageControl(String name, String nsPrefix, String nsURI) {
		ePack=factory.createEPackage();
		ePack.setName(name);
		ePack.setNsPrefix(nsPrefix);
		ePack.setNsURI(nsURI);
	}
	
	public EPackage getEPackage(){
		return ePack;
	}
	
	public void setNsPrefix(String nsPrefix){
		ePack.setNsPrefix(nsPrefix);
	}
	public void setNsURI(String nsURI){
		ePack.setNsURI(nsURI);
	}
	public void setName(String name){
		ePack.setName(name);
	}
	public void add(EClassifier c){
		ePack.getEClassifiers().add(c);
	}
	public void add(EPackage p){
		ePack.getESubpackages().add(p);
	}
	
	public void remove(EClassifier c){
		ePack.getEClassifiers().remove(c);
	}
	
	public EClassifier find (String name){
		return ePack.getEClassifier(name);
	}
	
	public List<ClassControl> getClasses(){
		List<ClassControl> ret= new ArrayList<ClassControl>();
		for(EClassifier ecl: ePack.getEClassifiers()){
			if (ecl instanceof EClass){
				ret.add(new ClassControl((EClass)ecl));
			}
		}
		return ret;
	}
	public List<AttributeControl> getAttributes(){
		List<ClassControl> clas= this.getClasses();
		List<AttributeControl> ret= new ArrayList<AttributeControl>();
		for(ClassControl c: clas){
			ret.addAll(c.getAttributes());
		}
		return ret;
	}
	
	public List<ReferenceControl> getReferences(){
		List<ClassControl> clas= this.getClasses();
		List<ReferenceControl> ret= new ArrayList<ReferenceControl>();
		for(ClassControl c: clas){
			ret.addAll(c.getReferences());
		}
		return ret;
	}
	
	@Override
	public EObject getObject() {
		return ePack;
	}
	public boolean contain(EClassifier c) {
		return ePack.getEClassifiers().contains(c);
	}
	public PackageControl getPackage(String pk) {
		List<EPackage>list=ePack.getESubpackages();
		for (EPackage p: list){
			if (p.getName().equalsIgnoreCase(pk)){
				return new PackageControl(p);
			}
		}
		return null;
	}
	@Override
	public String getName() {
		return ePack.getName();
	}
	
	public ClassControl getClass(String name){
		EClass c=(EClass)this.find(name);
		if (c!=null){
			return new ClassControl(c);
	
		}
		return null;
	}
	@Override
	public String elementType() {
		return "package";
	}
}
