package dialogflow.telegram;

import java.util.List;

public class PassportData {
    private List<EncryptedPassportElement> data;
    private EncryptedCredentials credentials;
    
    public PassportData() {
	}

	public List<EncryptedPassportElement> getData() {
		return data;
	}

	public void setData(List<EncryptedPassportElement> data) {
		this.data = data;
	}

	public EncryptedCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(EncryptedCredentials credentials) {
		this.credentials = credentials;
	}
    
    
}
