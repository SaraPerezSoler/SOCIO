package dialogflow.telegram.replykeyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import dialogflow.telegram.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardMarkup implements ReplyKeyboard {

    private static final String KEYBOARD_FIELD = "inline_keyboard";

    @JsonProperty(KEYBOARD_FIELD)
    private List<List<dialogflow.telegram.replykeyboard.buttons.InlineKeyboardButton>> keyboard; ///< Array of button rows, each represented by an Array of Strings

    public InlineKeyboardMarkup() {
        super();
        keyboard = new ArrayList<>();
    }

    public List<List<InlineKeyboardButton>> getKeyboard() {
        return keyboard;
    }

    public InlineKeyboardMarkup setKeyboard(List<List<InlineKeyboardButton>> keyboard) {
        this.keyboard = keyboard;
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyboard == null) ? 0 : keyboard.hashCode());
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
		InlineKeyboardMarkup other = (InlineKeyboardMarkup) obj;
		if (keyboard == null) {
			if (other.keyboard != null)
				return false;
		} else if (!keyboard.equals(other.keyboard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InlineKeyboardMarkup [keyboard=" + keyboard + "]";
	}

   
	
}
