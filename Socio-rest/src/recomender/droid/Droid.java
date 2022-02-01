package recomender.droid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.socio.client.command.CreateRequest;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

import droidRecommenderHistory.DroidRecommenderHistoryFactory;
import droidRecommenderHistory.RecommendationMsg;
import droidRecommenderHistory.RecommendationResult;
import es.uam.app.projects.emf.metamodel.ClassControl;
import es.uam.app.projects.emf.metamodel.MetamodelControl;
import es.uam.app.projects.emf.metamodel.MetamodelControlInterface;
import socioProjects.Project;
import socioProjects.User;

public class Droid extends CreateRequest {

	public Droid(String URL) {
		super(URL);
	}

	public RecommendationMsg getRecommendation(ClassControl class_, User user, Project project) throws ResponseError, ForbiddenResponse {
		
		
		
		RecommendationMsg recommendationMsg = DroidRecommenderHistoryFactory.eINSTANCE.createRecommendationMsg();
		recommendationMsg.setDate(new Date());
		recommendationMsg.setUser(user);
		recommendationMsg.setElement(class_.getObject());
		recommendationMsg.setElementStatus(class_.copyObject().getObject());
		recommendationMsg.setId(getLastId(project)+1);
		
		
		JSONObject context = ContextJson.getJSONContext(class_);
		System.out.println(context.toString());
		Map<String, Object> queryParam = new HashMap<>();
		queryParam.put("itemType", "attributes");
		queryParam.put("newMaxRec", 10);
		JSONObject obj1 = responseJSON("simpleopp/recommend", queryParam, context);

		queryParam.put("itemType", "superClasses");
		JSONObject obj2 = responseJSON("simpleopp/recommend", queryParam, context);
		
		recommendationMsg.getResults().addAll(getJSONRecommendation(class_.getName(), obj1, obj2));
		return recommendationMsg;
	}

	private List<RecommendationResult> getJSONRecommendation(String className, JSONObject attributes, JSONObject superClasses) {
		List<RecommendationResult> ret = new ArrayList<>();
		
		JSONArray attrArray = attributes.getJSONArray("obj");
		System.out.println(attributes.toString());
		System.out.println(superClasses.toString());
		JSONArray superArray = superClasses.getJSONArray("obj");

		for (int i = 0; i < attrArray.length(); i++) {
			RecommendationResult result = DroidRecommenderHistoryFactory.eINSTANCE.createRecommendationResult();
			
			JSONObject element = attrArray.getJSONObject(i);
			JSONObject pks = element.getJSONObject("pk");
			String attrName = pks.getString("attrName");
			String attrType = pks.getString("attrType");
			double value= element.getDouble("value");
			String simpleType = MetamodelControlInterface.getType(attrType).getInstanceClass().getSimpleName();
			
			result.setRaitin(value);
			result.setType(MetamodelControl.FEATURES);
			
			result.getValues().put(MetamodelControl.TYPE, simpleType);
			result.getValues().put(MetamodelControl.NAME, attrName);
			ret.add(result);
		}

		for (int i = 0; i < superArray.length(); i++) {
			RecommendationResult result = DroidRecommenderHistoryFactory.eINSTANCE.createRecommendationResult();
			
			JSONObject element = superArray.getJSONObject(i);
			JSONObject pks = element.getJSONObject("pk");
			String name = pks.getString("name");
			double value = element.getDouble("value");
			
			result.setRaitin(value);
			result.setType(MetamodelControl.SUPERCLASSES);
			result.getValues().put(MetamodelControl.NAME, name);
			ret.add(result);
		}
		return ret;

	}

	private long getLastId(Project project) {
		List<RecommendationMsg> list =  project.getRecommendationMsg();
		if (list.isEmpty()) {
			return -1;
		}
		Collections.sort(list, new Comparator<RecommendationMsg>() {

			@Override
			public int compare(RecommendationMsg o1, RecommendationMsg o2) {
				return Long.compare(o2.getId(), o1.getId());
			}
		});
		return list.get(0).getId();
	}
}
