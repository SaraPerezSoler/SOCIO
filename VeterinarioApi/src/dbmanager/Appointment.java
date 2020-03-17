package dbmanager;

import java.util.Date;

public class Appointment {

	private Date date;
	private String pet;
	private String petName;
	
	public Appointment() {
	}
	
	public Appointment(Date date, String pet, String petName) {
		super();
		this.date = date;
		this.pet = pet;
		this.petName = petName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
}
