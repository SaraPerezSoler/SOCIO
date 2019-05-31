/**
 */
package socioProjects;

import java.io.FileNotFoundException;
import java.util.List;

import es.uam.app.parser.NP;
import es.uam.app.projects.ecore.AttributeControl;
import es.uam.app.projects.ecore.ClassControl;
import es.uam.app.projects.ecore.Feature;
import es.uam.app.projects.ecore.ReferenceControl;
import net.didion.jwnl.JWNLException;
import projectHistory.Action;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel Project</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see socioProjects.SocioProjectsPackage#getMetamodelProject()
 * @model
 * @generated
 */
public interface MetamodelProject extends Project {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @model sentenceRequired="true"
	 * @generated NOT
	 */
	List<Action> parseSentence(String sentence) throws Exception;

	
	
	
	/*Add and unAdd elements*/
	void addAttribute(AttributeControl attr, ClassControl ofClass);

	void unAddAttribute(AttributeControl object, ClassControl parent);
	
	void addReference(ReferenceControl object, ClassControl classControl);
	
	void unAddReference(ReferenceControl object, ClassControl parent);
	
	void addClass(ClassControl clase);

	void unAddClass(ClassControl object);
	
	/*Remove and unRemove elements*/
	void removeAttribute(AttributeControl atr, ClassControl parent);

	void unRemoveAttribute(AttributeControl atr);
	
	void removeReference(ReferenceControl ref, ClassControl parent);

	void unRemoveReference(ReferenceControl ref);

	void removeClass(ClassControl class_);

	void unRemoveClass(ClassControl class_);

	/*get elements*/
	
	ClassControl getClass(String name) throws FileNotFoundException, JWNLException;

	ClassControl getClass(NP clas) throws FileNotFoundException, JWNLException;

	ClassControl getExactlyClass(String name) throws FileNotFoundException, JWNLException;

	ClassControl getExactlyClass(NP clas) throws FileNotFoundException, JWNLException;

	Feature getFeature(String lowerCammelCase) throws FileNotFoundException, JWNLException;

	Feature getFeature(String lowerCammelCase, ClassControl toClass) throws FileNotFoundException, JWNLException;
	
	Feature getExactlyFeature(String att2, ClassControl of) throws FileNotFoundException, JWNLException;

	List<ReferenceControl> getRefereceTo(ClassControl c);

	List<ClassControl> getSubTypesOf(ClassControl c);

	

	

} 
