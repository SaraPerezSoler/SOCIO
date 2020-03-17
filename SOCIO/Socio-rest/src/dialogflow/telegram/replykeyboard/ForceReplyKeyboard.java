package dialogflow.telegram.replykeyboard;

import com.fasterxml.jackson.annotation.JsonProperty;



public class ForceReplyKeyboard implements ReplyKeyboard {
    private static final String FORCEREPLY_FIELD = "force_reply";
    private static final String SELECTIVE_FIELD = "selective";

    @JsonProperty(FORCEREPLY_FIELD)
    private Boolean forceReply;
 
    @JsonProperty(SELECTIVE_FIELD)
    private Boolean selective;

    public ForceReplyKeyboard() {
        super();
        this.forceReply = true;
    }

    public Boolean getForceReply() {
        return forceReply;
    }

    public Boolean getSelective() {
        return selective;
    }

    public ForceReplyKeyboard setSelective(Boolean selective) {
        this.selective = selective;
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forceReply == null) ? 0 : forceReply.hashCode());
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
		ForceReplyKeyboard other = (ForceReplyKeyboard) obj;
		if (forceReply == null) {
			if (other.forceReply != null)
				return false;
		} else if (!forceReply.equals(other.forceReply))
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
		return "ForceReplyKeyboard [forceReply=" + forceReply + ", selective=" + selective + "]";
	}

  
	
}
