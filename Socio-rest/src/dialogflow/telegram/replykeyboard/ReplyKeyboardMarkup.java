package dialogflow.telegram.replykeyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import dialogflow.telegram.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


public class ReplyKeyboardMarkup implements ReplyKeyboard {

    private static final String KEYBOARD_FIELD = "keyboard";
    private static final String RESIZEKEYBOARD_FIELD = "resize_keyboard";
    private static final String ONETIMEKEYBOARD_FIELD = "one_time_keyboard";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(KEYBOARD_FIELD)
    private List<KeyboardRow> keyboard; 
    @JsonProperty(RESIZEKEYBOARD_FIELD)
    private Boolean resizeKeyboard = false; 
    @JsonProperty(ONETIMEKEYBOARD_FIELD)
    private Boolean oneTimeKeyboard= false; 
    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective= false;

    public ReplyKeyboardMarkup() {
        super();
        keyboard = new ArrayList<>();
    }

    public List<KeyboardRow> getKeyboard() {
        return keyboard;
    }

    public ReplyKeyboardMarkup setKeyboard(List<KeyboardRow> keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    public ReplyKeyboardMarkup setResizeKeyboard(Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
        return this;
    }

    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    public ReplyKeyboardMarkup setOneTimeKeyboard(Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
        return this;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ReplyKeyboardMarkup setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyboard == null) ? 0 : keyboard.hashCode());
		result = prime * result + ((oneTimeKeyboard == null) ? 0 : oneTimeKeyboard.hashCode());
		result = prime * result + ((resizeKeyboard == null) ? 0 : resizeKeyboard.hashCode());
		result = prime * result + ((selective == null) ? 0 : selective.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyKeyboardMarkup other = (ReplyKeyboardMarkup) obj;
		if (keyboard == null) {
			if (other.keyboard != null)
				return false;
		} else if (!keyboard.equals(other.keyboard))
			return false;
		if (oneTimeKeyboard == null) {
			if (other.oneTimeKeyboard != null)
				return false;
		} else if (!oneTimeKeyboard.equals(other.oneTimeKeyboard))
			return false;
		if (resizeKeyboard == null) {
			if (other.resizeKeyboard != null)
				return false;
		} else if (!resizeKeyboard.equals(other.resizeKeyboard))
			return false;
		if (selective == null) {
			if (other.selective != null)
				return false;
		} else if (!selective.equals(other.selective))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReplyKeyboardMarkup [keyboard=" + keyboard + ", resizeKeyboard=" + resizeKeyboard + ", oneTimeKeyboard="
				+ oneTimeKeyboard + ", selective=" + selective + "]";
	}



   
}
