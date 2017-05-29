package es.uam.app.projects.log;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import RemoveLog.RemoveLogFactory;
import RemoveLog.Root;
import es.uam.app.main.Main;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.ecore.EcoreControl;
import es.uam.app.projects.ecore.Feature;

public class RemoveLogControl {

	private Resource model;
	private String name;
	private Root root;

	public RemoveLogControl(String name, boolean create) {

		ResourceSet resourceSet = EcoreControl.getResourceSet();
		if (!create) {
			model = resourceSet.getResource(URI.createURI(name), true);
		} else {
			model = resourceSet.createResource(URI.createURI(name));
		}
		if (model.getContents().isEmpty()) {
			root = RemoveLogFactory.eINSTANCE.createRoot();
			model.getContents().add(root);
			this.save();
		} else {
			root = (Root) model.getContents().get(0);
		}
		String[] seg = name.split("/");
		this.name = seg[seg.length - 1];
	}

	public void addRemove(Controlador c) {
		if (c instanceof Feature) {
			Feature f = (Feature) c;
			f.copyValuesIn(f);
		}
		root.getElementsDeletes().add(c.getObject());

	}
	
	public void deleteRemove(Controlador c) {
		root.getElementsDeletes().remove(c.getObject());

	}
	public void deleteRemove(Feature c) {
		c.removeValues();
		root.getElementsDeletes().remove(c.getObject());
	}

	public void save() {
		try {
			/*
			 * Save the resource
			 */
			model.save(null);
		} catch (IOException e) {
			Main.log.fatal(e.getMessage());
		}
	}

	public List<EObject> getRemoves() {
		return root.getElementsDeletes();
	}

	public String getName() {
		return name;
	}
}
