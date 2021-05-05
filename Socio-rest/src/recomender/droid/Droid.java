package recomender.droid;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.socio.client.command.CreateRequest;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public class Droid extends CreateRequest {

	public Droid(String URL) {
		super(URL);
	}

	public JSONObject getRecommendation(JSONObject context) throws ResponseError, ForbiddenResponse {
	
		System.out.println(context.toString());
		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("itemType", "attributes");
		JSONObject obj1 = responseJSON("recommend", queryParam, context);

		queryParam.put("itemType", "superClasses");
		JSONObject obj2 = responseJSON("recommend",queryParam, context);

		JSONObject ret = new JSONObject();
		ret.put("attributes", obj1);
		ret.put("superTypes", obj2);
		return ret;
	}
}
