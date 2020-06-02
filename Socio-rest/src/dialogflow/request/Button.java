package dialogflow.request;


public class Button {
	private String text;
	private String postback;
	
	public Button() {
		super();
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPostback() {
		return postback;
	}
	public void setPostback(String postback) {
		this.postback = postback;
	}

}
