package recomender.droid;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.socio.client.command.CreateRequest;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.MetamodelControlInterface;

public class Droid extends CreateRequest {

	public Droid(String URL) {
		super(URL);
	}

	public JSONObject getRecommendation(ClassControl class_) throws ResponseError, ForbiddenResponse {
		JSONObject context = ContextJson.getJSONContext(class_);
		System.out.println(context.toString());
		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("itemType", "attributes");
		queryParam.put("newMaxRec", 10);
		JSONObject obj1 = responseJSON("simpleopp/recommend", queryParam, context);

		queryParam.put("itemType", "superClasses");
		JSONObject obj2 = responseJSON("simpleopp/recommend", queryParam, context);
		return getJSONRecommendation(class_.getName(), obj1, obj2);
	}

	private JSONObject getJSONRecommendation(String className, JSONObject attributes, JSONObject superClasses) {

		JSONArray attrArray = attributes.getJSONArray("obj");
		System.out.println(attributes.toString());
		System.out.println(superClasses.toString());
		JSONArray superArray = superClasses.getJSONArray("obj");

		JSONObject classJObject = new JSONObject();

		JSONObject object = new JSONObject();
		JSONObject features = new JSONObject();
		for (int i = 0; i < attrArray.length(); i++) {
			JSONObject feature = new JSONObject();

			JSONObject element = attrArray.getJSONObject(i);
			JSONObject pks = element.getJSONObject("pk");
			String attrName = pks.getString("attrName");
			String attrType = pks.getString("attrType");
			double value= element.getDouble("value");
			String simpleType = MetamodelControlInterface.getType(attrType).getInstanceClass().getSimpleName();
			feature.put("type", simpleType);
			feature.put("value", value);
			features.put(attrName, feature);
			
		}
		object.put("features", features);
		JSONObject superTypes = new JSONObject();
		for (int i = 0; i < superArray.length(); i++) {

			JSONObject element = superArray.getJSONObject(i);
			JSONObject pks = element.getJSONObject("pk");
			String name = pks.getString("name");
			double value = element.getDouble("value");
			JSONObject superType = new JSONObject();
			superType.put("value", value);
			
			superTypes.put(name, superType);
		}
		object.put("superClasses", superTypes);
		classJObject.put(className, object);
		return classJObject;

	}

}
