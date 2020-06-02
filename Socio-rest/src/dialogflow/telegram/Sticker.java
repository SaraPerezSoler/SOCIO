package dialogflow.telegram;

public class Sticker extends File implements Dimension, Thumb {
	
    private int width; 
    private int height; 
    private PhotoSize thumb; 
    private String emoji; 
    private String set_name; 
    private MaskPosition mask_position; 
    
    public Sticker() {
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public void setThumb(PhotoSize thumb) {
		this.thumb = thumb;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public String getSet_name() {
		return set_name;
	}

	public void setSet_name(String set_name) {
		this.set_name = set_name;
	}

	public MaskPosition getMask_position() {
		return mask_position;
	}

	public void setMask_position(MaskPosition mask_position) {
		this.mask_position = mask_position;
	}
    
    
}
