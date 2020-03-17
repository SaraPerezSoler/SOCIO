package dialogflow.telegram;

public class Document extends File implements Thumb, Mime {
	
	
	private PhotoSize thumb;
	private String mime_type;
	
	public Document() {
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}


}
