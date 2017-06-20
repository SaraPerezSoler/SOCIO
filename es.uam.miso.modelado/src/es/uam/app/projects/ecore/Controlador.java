package es.uam.app.projects.ecore;

import org.eclipse.emf.ecore.EObject;

import es.uam.app.main.ValidText;

public interface Controlador {
	
	static final char [] validCharacter={'_'};

	public EObject getObject();

	public String getName();
	
	public String elementType();
	
	default String validElementName (String text){
		return ValidText.validText(text, validCharacter);
	}
	

}
