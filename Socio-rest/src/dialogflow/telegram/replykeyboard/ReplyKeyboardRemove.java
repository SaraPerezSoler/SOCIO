package dialogflow.telegram.replykeyboard;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ReplyKeyboardRemove implements ReplyKeyboard {
    private static final String REMOVEKEYBOARD_FIELD = "remove_keyboard";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(REMOVEKEYBOARD_FIELD)
    private Boolean removeKeyboard; 
    
    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective = false;

    public ReplyKeyboardRemove() {
        super();
        this.removeKeyboard = true;
    }

    public Boolean getRemoveKeyboard() {
        return removeKeyboard;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ReplyKeyboardRemove setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((removeKeyboard == null) ? 0 : removeKeyboard.hashCode());
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
		ReplyKeyboardRemove other = (ReplyKeyboardRemove) obj;
		if (removeKeyboard == null) {
			if (other.removeKeyboard != null)
				return false;
		} else if (!removeKeyboard.equals(other.removeKeyboard))
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
		return "ReplyKeyboardRemove [removeKeyboard=" + removeKeyboard + ", selective=" + selective + "]";
	}

   
}
