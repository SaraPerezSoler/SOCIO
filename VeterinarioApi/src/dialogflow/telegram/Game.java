package dialogflow.telegram;

import java.util.List;

public class Game {
	

    private String title; 
    private String description; 
    private List<PhotoSize> photo; 
    private String text;
    private List<MessageEntity> entities;
    private Animation animation; 

    public Game() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PhotoSize> getPhoto() {
		return photo;
	}

	public void setPhoto(List<PhotoSize> photo) {
		this.photo = photo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MessageEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<MessageEntity> entities) {
		this.entities = entities;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

    
}
