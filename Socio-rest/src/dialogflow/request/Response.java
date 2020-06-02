package dialogflow.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
	
	private String fulfillmentText;
	private List<OutputContext> outputContexts;	
	private List<Map<String, RichMessege>> fulfillmentMessages = new ArrayList<>();
	private Map<String, Map<String, ?>> payload = new HashMap<>();
	
	public Response() {
		super();
	}
	public String getFulfillmentText() {
		return fulfillmentText;
	}
	public void setFulfillmentText(String fulfillmentText) {
		this.fulfillmentText = fulfillmentText;
	}
	public List<OutputContext> getOutputContexts() {
		return outputContexts;
	}
	public void setOutputContexts(List<OutputContext> outputContexts) {
		this.outputContexts = outputContexts;
	}
	public List<Map<String, RichMessege>> getFulfillmentMessages() {
		return fulfillmentMessages;
	}
	public void addFulfillmentMessages(Map<String, RichMessege> fulfillmentMessages) {
		this.fulfillmentMessages.add(fulfillmentMessages);
	}
	@Override
	public String toString() {
		return "Response [fulfillmentText=" + fulfillmentText + ", outputContexts=" + outputContexts
				+ ", fulfillmentMessages=" + fulfillmentMessages + "]";
	}
	public Map<String, Map<String, ?>> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Map<String, ?>> payload) {
		this.payload = payload;
	}
	
	public void addPayload(String sn, Map<String, ?> payload2) {
		this.payload.put(sn, payload2);
	}
	
	
	

}
