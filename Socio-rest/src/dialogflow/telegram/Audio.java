package dialogflow.telegram;

public class Audio extends File implements Thumb, Duration, Mime {
	
	private String performer;
	private String title;
	private PhotoSize thumb;
	private int duration;
	private String mime_type;
	
	
	public Audio() {
	}
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public PhotoSize getThumb() {
		return thumb;
	}
	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
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
