package dialogflow.telegram;

public class Voice extends File implements Duration, Mime {

	private int duration;
    private String mime_type; 
    
    public Voice() {
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}
    
    

    
    
}
