package dialogflow.request;



public class Request {
	private String responseId;
	private String session;
	private QueryResult queryResult;
	private Payload originalDetectIntentRequest;

	public Request() {
		super();
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public QueryResult getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(QueryResult queryResult) {
		this.queryResult = queryResult;
	}

	public Payload getOriginalDetectIntentRequest() {
		return originalDetectIntentRequest;
	}

	public void setOriginalDetectIntentRequest(Payload originalDetectIntentRequest) {
		this.originalDetectIntentRequest = originalDetectIntentRequest;
	}

	@Override
	public String toString() {
		return "Request [responseId=" + responseId + ", session=" + session + ", queryResult=" + queryResult
				+ ", originalDetectIntentRequest=" + originalDetectIntentRequest + "]";
	}

	

}
