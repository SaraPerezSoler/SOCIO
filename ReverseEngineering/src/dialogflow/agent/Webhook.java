package dialogflow.agent;
import java.util.Map;

public class Webhook {
	
	private String url;
	private String username;
	private Map<String, String> headers;
	
	public Webhook() {
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	@Override
	public String toString() {
		return "Webhook [url=" + url + ", username=" + username + ", headers=" + headers + "]";
	}
	

}
