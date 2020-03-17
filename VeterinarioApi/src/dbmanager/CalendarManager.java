package dbmanager;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import dbmanager.PostgresDb.SSLMODE;

public class CalendarManager {

	private PostgresDb db = null;
	private static CalendarManager calendar;
	
	public static CalendarManager getCalendarManager () throws InstantiationException, IllegalAccessException {
		if (calendar==null) {
			calendar = new CalendarManager();
		}
		return calendar;
	}
	public CalendarManager() throws InstantiationException, IllegalAccessException {
		db = new PostgresDb("ec2-54-75-224-168.eu-west-1.compute.amazonaws.com", 5432, "df23pf5it1jmjr", "muepxgxuelrkbj", 
				"63dcef7904f83226cc2620768146e8a07ce9bf745ff4ea8bd55c3f770abb69cb", SSLMODE.REQUIRE);
	}
	
	public boolean newAppointmen (DateTime dateTime, String pet, String petName) throws NotAvailable, SQLException, OutOfOpenRange, PastDate {
		DateTime today = new DateTime();
		if (dateTime.compareTo(today)<0) {
			throw new PastDate();
		}
		System.out.println(dateTime.getHourOfDay());
		if (dateTime.getHourOfDay()<9 || dateTime.getHourOfDay()>=18) {
			throw new OutOfOpenRange();
		}
		
		Date date = dateTime.toDate();
		Appointment appointment = new Appointment(date, pet, petName);
			
		List<Appointment> appointmenst = db.getAppointment(date);
		if (appointmenst.isEmpty()) {
			return db.insertAppointment(appointment);
		}else {
			throw new NotAvailable();
		}
	}
	
	
}
