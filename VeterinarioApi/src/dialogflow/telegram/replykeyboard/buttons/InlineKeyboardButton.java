package dialogflow.telegram.replykeyboard.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineKeyboardButton {

    private static final String TEXT_FIELD = "text";
    private static final String URL_FIELD = "url";
    private static final String CALLBACK_DATA_FIELD = "callback_data";
    private static final String CALLBACK_GAME_FIELD = "callback_game";
    private static final String SWITCH_INLINE_QUERY_FIELD = "switch_inline_query";
    private static final String SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD = "switch_inline_query_current_chat";
    private static final String PAY_FIELD = "pay";

    @JsonProperty(TEXT_FIELD)
    private String text; 
    @JsonProperty(URL_FIELD)
    private String url;
    @JsonProperty(CALLBACK_DATA_FIELD)
    private String callbackData; 
  
    @JsonProperty(CALLBACK_GAME_FIELD)
    private CallbackGame callbackGame;
   
    @JsonProperty(SWITCH_INLINE_QUERY_FIELD)
    private String switchInlineQuery;
   
    @JsonProperty(SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD)
    private String switchInlineQueryCurrentChat;

   
    @JsonProperty(PAY_FIELD)
    private Boolean pay;

    public InlineKeyboardButton() {
        super();
    }

    public InlineKeyboardButton(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public InlineKeyboardButton setText(String text) {
        this.text = text;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public InlineKeyboardButton setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public InlineKeyboardButton setCallbackData(String callbackData) {
        this.callbackData = callbackData;
        return this;
    }

    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    public InlineKeyboardButton setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
        return this;
    }

    public CallbackGame getCallbackGame() {
        return callbackGame;
    }

    public InlineKeyboardButton setCallbackGame(CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
        return this;
    }

    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    public InlineKeyboardButton setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        return this;
    }

    public Boolean getPay() {
        return pay;
    }

    public InlineKeyboardButton setPay(Boolean pay) {
        this.pay = pay;
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callbackData == null) ? 0 : callbackData.hashCode());
		result = prime * result + ((callbackGame == null) ? 0 : callbackGame.hashCode());
		result = prime * result + ((pay == null) ? 0 : pay.hashCode());
		result = prime * result + ((switchInlineQuery == null) ? 0 : switchInlineQuery.hashCode());
		result = prime * result
				+ ((switchInlineQueryCurrentChat == null) ? 0 : switchInlineQueryCurrentChat.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		InlineKeyboardButton other = (InlineKeyboardButton) obj;
		if (callbackData == null) {
			if (other.callbackData != null)
				return false;
		} else if (!callbackData.equals(other.callbackData))
			return false;
		if (callbackGame == null) {
			if (other.callbackGame != null)
				return false;
		} else if (!callbackGame.equals(other.callbackGame))
			return false;
		if (pay == null) {
			if (other.pay != null)
				return false;
		} else if (!pay.equals(other.pay))
			return false;
		if (switchInlineQuery == null) {
			if (other.switchInlineQuery != null)
				return false;
		} else if (!switchInlineQuery.equals(other.switchInlineQuery))
			return false;
		if (switchInlineQueryCurrentChat == null) {
			if (other.switchInlineQueryCurrentChat != null)
				return false;
		} else if (!switchInlineQueryCurrentChat.equals(other.switchInlineQueryCurrentChat))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InlineKeyboardButton [text=" + text + ", url=" + url + ", callbackData=" + callbackData
				+ ", callbackGame=" + callbackGame + ", switchInlineQuery=" + switchInlineQuery
				+ ", switchInlineQueryCurrentChat=" + switchInlineQueryCurrentChat + ", pay=" + pay + "]";
	}

    
}
