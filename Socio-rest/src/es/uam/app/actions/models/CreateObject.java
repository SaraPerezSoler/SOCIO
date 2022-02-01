package es.uam.app.actions.models;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import es.uam.app.actions.AddModel;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import modelInfo.NLAttribute;
import modelInfo.NLFeature;
import socioProjects.ModelProject;

public class CreateObject extends AddModel implements IsEObject{

	private String name;
	private Map<String, Object> id;

	public CreateObject(ModelProject p, String name, Map<String, Object> id) {
		super(p);
		this.name = name;
		this.id = id;
	}
	
	public CreateObject(ModelProject p, EObjectControl object) {
		super(p);
		super.setObject(object);
		this.name=object.getName();
		id = new HashMap<>();
		List<NLAttribute> ids = object.getNLClass().getId();
		for (NLAttribute i: ids) {
			id.put(i.getName(), object.getNLFeatureValue(i));
		}
		setExecute(true);
		setUndo(false);
	}
	
	public EObjectControl getObject() {
		return (EObjectControl)super.getObject();
	}

	
	@Override
	public void doIt() throws Exception {
		if (isExecute()){
			return;
		}
		if (getProject().getObject(name, id)==null){
			EObjectControl object = getProject().createEObject(name);
			getProject().setId(object, id);
			
			for (NLFeature feature : object.getNLClass().getFeatures()) {
				if (feature instanceof NLAttribute) {
					if (((NLAttribute)feature).getAttribute().getEType().getInstanceClass().equals(Boolean.class)) {
						getProject().setEAttribute(object, feature.getName(),true);
					}
				}
			}
			
			setObject(object);
		}else{
			throw new Exception("Problem ocurred in CreateObject: the object with classname "+ name +" and id "+ id+"  already exists");
		}
		setExecute(true);

	}
	
	@Override
	public void undoIt() throws Exception {
		if (!isExecute() || isUndo()){
			return;
		}
		
		getProject().unCreateEObject(getObject());
		setUndo(true);

	}
	
	@Override
	public void redoIt() throws Exception {
		if (!isExecute() || !isUndo()){
			return;
		}
		getProject().reCreateEObject(getObject());
		setUndo(false);

	}

	@Override
	public EObjectControl getEObjectControl() throws Exception {
		doIt();
		return getObject();
		
	}





}
