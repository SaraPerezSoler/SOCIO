package dialogflow.telegram;

public class Animation extends File implements Dimension, Duration, Mime, Thumb {

	private PhotoSize thumb;
	private String mime_type;
	private int duration;
	private int width;
	private int height;
	
	public Animation() {
	}

	@Override
	public PhotoSize getThumb() {
		return thumb;
	}

	@Override
	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	@Override
	public String getMime_type() {
		return mime_type;
	}

	@Override
	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

}
