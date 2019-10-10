package es.uam.app.projects.emf.metamodel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.plantUML.CreateMetamodelUML;
import es.uam.app.plantUML.CreateSortMetamodelUML;
import es.uam.app.projects.FileProject;
import es.uam.app.projects.emf.Controlador;
import projectHistory.Action;

/**
 * 
 * @author Sara Pérez Soler
 * @version 0.1
 *
 */
public class MetamodelControl implements Controlador, FileProject {

	private Resource resource;
	

	/**
	 * Constructor para cargar un fichero ecore.
	 * 
	 * @param uri
	 *            path del fichero.
	 * @throws ModellingException
	 */
	public MetamodelControl(String uri) throws FatalException {
		/*
		 * Cargamos el fichero con la URI. Si no existe lo creamos con el
		 * paquete por defecto.
		 */
		try {
			File f=new File(uri);
			if (!f.exists()){
				throw new FatalException("In class "+this.getClass().getName()+": the file "+ uri+" can be opened");
			}
			URI uri1 = URI.createURI(uri);
			resource = SocioData.getResourceSet().getResource(URI.createURI(uri), true);
		} catch (Exception e) {
			throw new FatalException("In class "+this.getClass().getName()+": the file "+ uri+" can be opened");
		}

	}

	/**
	 * Constructor para crear un nuevo fichero ecore, y el paquete.
	 * 
	 * @param uri
	 *            path del fichero.
	 * @param packageName
	 *            nombre que va a llevar el paquete.
	 */
	public MetamodelControl(String uri, String packageName) {
		crearEcore(uri, packageName, packageName, packageName);
	}

	/**
	 * Constructor para crear un nuevo fichero ecore, y el paquete.
	 * Especificamos los campos nsPrefix y nsURI del paquete.
	 * 
	 * @param uri
	 *            path del fichero
	 * @param packageName
	 *            nombre que va a llevar el paquete
	 * @param nsPrefix
	 *            nsPrefix del paquete.
	 * @param nsURI
	 *            nsURI del paquete.
	 */
	public MetamodelControl(String uri, String packageName, String nsPrefix, String nsURI) {
		crearEcore(uri, packageName, nsPrefix, nsURI);
	}

	public MetamodelControl(Resource eResource) {
		this.resource=eResource;
	}

	/**
	 * Crea el fichero ecore a partir del path y el nombre del paquete, el campo
	 * nsPrefix y el campo nsURI.
	 * 
	 * @param uri
	 *            path del fichero
	 * @param packageName
	 *            nombre que va a llevar el paquete
	 * @param nsPrefix
	 *            nsPrefix del paquete.
	 * @param nsURI
	 *            nsURI del paquete.
	 */
	private void crearEcore(String uri, String name, String nsPrefix, String nsURI) {
		URI uri1 = URI.createURI(uri);
		// Creamos el fichero ecore
		this.resource = SocioData.getResourceSet().createResource(URI.createURI(uri));
		// Creamos y añadimos el paquete con el nombre y el nsPrefix y nsURI
		this.resource.getContents().add(new PackageControl(name, nsPrefix, nsURI).getEPackage());
		save();

	}
	
	public EFactory getEFactoryInstance(){
		return this.getPackage().getEPackage().getEFactoryInstance();
	}



	public PackageControl getPackage() {
		return new PackageControl((EPackage) resource.getContents().get(0));
	}

	/**
	 * Guarda los cambios en el fichero ecore.
	 */
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

	

	public String getnameEcore() {
		return resource.getURI().lastSegment();
	}
	
	public EList<EObject>getContents(){
		return resource.getContents();
	}
	
	public String getName(){
		return resource.getURI().lastSegment().replace(".ecore", "");
	}

	public String getPath(){
		return resource.getURI().toFileString();
	}
	@Override
	public EObject getObject() {
		return resource.getContents().get(0);
	}

	public Resource getResource() {
		return resource;
	}
	
	public ClassControl getClass(String name){
		if (name==null){
			return null;
		}
		ClassControl c=this.getExactlyClass(name);
		
		if (c==null){
			for (ClassControl cc: getClasses()){
				String nameCC= cc.getName().toLowerCase();
				if (nameCC.contains(name.toLowerCase())){
					return cc;
				}
			}
		}
		return c;
	}
	public ClassControl getExactlyClass(String name){
		if (name==null){
			return null;
		}
		
		EClass c=(EClass)this.getPackage().find(name);
		if (c!=null){
			return new ClassControl(c);
	
		}else{
			List<ClassControl> classes= getClasses();
			for (ClassControl cc: classes){
				String nameCC= cc.getName().toLowerCase();
				if (nameCC.equals(name.toLowerCase())){
					return cc;
				}
			}
		}
		return null;
	}
	
	public PackageControl getPackage(String packRemove) {
		return this.getPackage().getPackage(packRemove);
	}

	public void  addClass(String name) {
		this.getPackage().add(new ClassControl(name).getEClass());
	}
	public void  addClass(ClassControl c) {
		this.getPackage().add(c.getEClass());
	}
	public void addClass(String name, String pk ){
		PackageControl pkControl=this.getPackage().getPackage(pk);
		pkControl.add(new ClassControl(name).getEClass());
	}
	public void addClass(ClassControl c, String pk ){
		PackageControl pkControl=this.getPackage().getPackage(pk);
		pkControl.add(c.getEClass());
	}
	
	public void  addPackage(String name) {
		this.getPackage().add(new PackageControl(name).getEPackage());
	}
	public void  addPackage(PackageControl p) {
		this.getPackage().add(p.getEPackage());
	}
	public void addPackage(String name, String pk ){
		PackageControl pkControl=this.getPackage().getPackage(pk);
		pkControl.add(new PackageControl(name).getEPackage());
	}
	public void addPackage(PackageControl p, String pk ){
		PackageControl pkControl=this.getPackage().getPackage(pk);
		pkControl.add(p.getEPackage());
	}
	
	public void remove(ClassControl c){
	
		this.getPackage().remove(c.getEClass());
	}
	
	public List<ReferenceControl> getReferencesTo(ClassControl c){
		List<ReferenceControl>references= new ArrayList<ReferenceControl>();
		List<ClassControl>classes=this.getPackage().getClasses();
		for (ClassControl c1: classes){
			references.addAll(c1.getRefForType(c.getName()));
		}
		return references;
		
	}
	public void removeClass(ClassControl c, String pk ){
		PackageControl pkControl=this.getPackage().getPackage(pk);
		pkControl.remove(c.getEClass());
	}

	public List<ClassControl> getClasses() {
		return this.getPackage().getClasses();
	}

	public List<ClassControl> getSubTypesOf(ClassControl c) {
		List<ClassControl> ret= new ArrayList<>();
		for (ClassControl c1: getClasses()){
			if (c1.isSubTypeOf(c)){
				ret.add(c1);
			}
		}
		return ret;
	}

	@Override
	public String elementType() {
		return "ecore";
	}
	

	public Diagnostic validate() {
	return Diagnostician.INSTANCE.validate(getObject());
		
		
		 
	}

	@Override
	public String createUML(List<Action> actions, List<Action> actual) {
		return new CreateMetamodelUML(getPackage()).createUML(actions, actual);
	}
	@Override
	public String createSortUML(List<Action> actions, List<Action> actual) {
		return new CreateSortMetamodelUML(getPackage()).createUML(actions, actual);
	}

	public List<Controlador> getAllObjects() {
		List<Controlador> ret= new ArrayList<>();
		List<ClassControl> clases=getClasses();
		ret.addAll(clases);
		for (ClassControl c: clases){
			ret.addAll(c.getAttributes());
			ret.addAll(c.getReferences());
		}
		return ret;
	}

	
}
