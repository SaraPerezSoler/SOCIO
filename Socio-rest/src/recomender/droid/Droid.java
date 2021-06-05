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
		JSONArray superArray = superClasses.getJSONArray("obj");

		JSONObject classJObject = new JSONObject();

		JSONObject object = new JSONObject();
		JSONObject features = new JSONObject();
		for (int i = 0; i < attrArray.length(); i++) {
			JSONObject feature = new JSONObject();

			JSONObject element = attrArray.getJSONObject(i);
			element = element.getJSONObject("pk");
			String attrName = element.getString("attrName");
			String attrType = element.getString("attrType");
			String simpleType = MetamodelControlInterface.getType(attrType).getInstanceClass().getSimpleName();
			feature.put("type", simpleType);
			features.put(attrName, feature);
		}
		object.put("features", features);
		JSONArray superTypes = new JSONArray();
		for (int i = 0; i < superArray.length(); i++) {

			JSONObject element = superArray.getJSONObject(i);
			element = element.getJSONObject("pk");
			String name = element.getString("name");

			superTypes.put(name);
		}
		object.put("superClasses", superTypes);
		classJObject.put(className, object);
		return classJObject;

	}

}
