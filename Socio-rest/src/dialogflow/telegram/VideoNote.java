package dialogflow.telegram;

public class VideoNote extends File implements Duration, Thumb {

    private int length; 
    private int duration;
    private PhotoSize thumb;
    
    public VideoNote() {
	}

	public int getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}
    
    
}
