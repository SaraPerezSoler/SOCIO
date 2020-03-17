package dialogflow.telegram;

public class PassportFile {

    private String file_id; 
    private Integer file_size;
    private Integer file_date;
    
    public PassportFile() {
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public Integer getFile_size() {
		return file_size;
	}

	public void setFile_size(Integer file_size) {
		this.file_size = file_size;
	}

	public Integer getFile_date() {
		return file_date;
	}

	public void setFile_date(Integer file_date) {
		this.file_date = file_date;
	}
    
    
}
