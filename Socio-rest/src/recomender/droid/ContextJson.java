package recomender.droid;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import es.uam.app.projects.emf.metamodel.AttributeControl;
import es.uam.app.projects.emf.metamodel.ClassControl;

public class ContextJson {

	
	public static JSONObject getJSONContext (ClassControl class_) {
		JSONObject object = new JSONObject();
		object.put("name", class_.getName());
		List<AttributeControl> attrs = class_.getAttributes();
		if (!attrs.isEmpty()) {
			JSONArray attributesArray = new JSONArray();
			for (AttributeControl attr: attrs) {
				JSONObject attrObject = new JSONObject();
				attrObject.put("attrName", attr.getName());
				if (attr.getType() != null) {
					attrObject.put("attrType", attr.getType().getName());
				}else {
					attrObject.put("attrType", "");
				}
				attributesArray.put(attrObject);
			}
			object.put("attributes", attributesArray);
		}
		
		List<ClassControl>superTypes = class_.getSuperTypes();
		if (!superTypes.isEmpty()) {
			JSONArray superTypesArray = new JSONArray();
			for (ClassControl superType : superTypes) {
				superTypesArray.put(getJSONContext(superType));
			}
			object.put("superClasses", superTypesArray);
		}
		return object;
		
	}
}
