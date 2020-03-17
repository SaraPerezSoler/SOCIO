package dialogflow.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dialogflow.restAccess.RestAccess;

@JsonIgnoreProperties("")
public class QueryResult {
	private String queryText;
	private Map<String, Object> parameters;
	private boolean allRequiredParamsPresent;
	private String fulfillmentText;
	private double intentDetectionConfidence;
	private String languageCode;
	private String action;
	private Intent intent;
	private List<OutputContext> outputContexts;
	private List<RichMessege> fulfillmentMessages = new ArrayList <> ();
	//private List<Object> fulfillmentMessages = new ArrayList<>();
	
	
	public QueryResult() {
		super();
	}
	public String getQueryText() {
		return queryText;
	}
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	public boolean isAllRequiredParamsPresent() {
		return allRequiredParamsPresent;
	}
	public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
		this.allRequiredParamsPresent = allRequiredParamsPresent;
	}
	public String getFulfillmentText() {
		return fulfillmentText;
	}
	public void setFulfillmentText(String fulfillmentText) {
		this.fulfillmentText = fulfillmentText;
	}
	public double getIntentDetectionConfidence() {
		return intentDetectionConfidence;
	}
	public void setIntentDetectionConfidence(double intentDetectionConfidence) {
		this.intentDetectionConfidence = intentDetectionConfidence;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public Intent getIntent() {
		return intent;
	}
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	public List<OutputContext> getOutputContexts() {
		return outputContexts;
	}
	public void setOutputContexts(List<OutputContext> outputContexts) {
		this.outputContexts = outputContexts;
	}
	
	
	@Override
	public String toString() {
		return "QueryResult [queryText=" + queryText + ", parameters=" + parameters + ", allRequiredParamsPresent="
				+ allRequiredParamsPresent + ", fulfillmentText=" + fulfillmentText + ", intentDetectionConfidence="
				+ intentDetectionConfidence + ", languageCode=" + languageCode + ", intent=" + intent
				+ ", outputContexts=" + outputContexts + ", fulfillmentMessages=" + fulfillmentMessages + "]";
	}
	public List<RichMessege> getFulfillmentMessages() {
		return fulfillmentMessages;
	}
	public void setFulfillmentMessages(List<Map<String, Object>> fulfillmentMessages) {
		for (Map<String, Object> map: fulfillmentMessages) {
			for (String key: map.keySet()) {
				if (key.equalsIgnoreCase("text")){
					try {
						this.fulfillmentMessages.add(RestAccess.mapper.readValue(RestAccess.mapper.writeValueAsString(map.get(key)), Text.class));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	
}
