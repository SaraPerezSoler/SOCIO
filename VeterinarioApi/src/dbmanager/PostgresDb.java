package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostgresDb {

	private final String insert = "insert into appointments (date_time, pet, petName) values (?, ?, ?)";
	private final String select = "SELECT * FROM appointments WHERE date_time = ?";

	public enum SSLMODE {
		DISABLE("disable"), ALLOW("allow"), PREFER("prefer"), REQUIRE("require"), VERIFYCA("verify-ca"),
		VERIFYFULL("verify-full");

		private String name;

		private SSLMODE(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	Connection con = null;

	// private static final String
	// URL="jdbc:postgresql://ec2-54-75-224-168.eu-west-1.compute.amazonaws.com:5432/df23pf5it1jmjr?sslmode=require";
	// private static final String USER = "muepxgxuelrkbj";
	// private static final String PASSWORD =
	// "63dcef7904f83226cc2620768146e8a07ce9bf745ff4ea8bd55c3f770abb69cb";
	public PostgresDb(String host, int port, String database, String user, String password, SSLMODE sslmode)
			throws InstantiationException, IllegalAccessException {
		try {
			String url = "jdbc:postgresql://" + host + ":" + port + "/" + database + "?sslmode=" + sslmode
					+ "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			System.out.println(url);
			Class.forName("org.postgresql.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean insertAppointment(Appointment appointment) throws SQLException {
		PreparedStatement pstm = con.prepareStatement(insert);
		Timestamp date1= new Timestamp(appointment.getDate().getTime());
		pstm.setTimestamp(1, date1);
		pstm.setString(2, appointment.getPet());
		pstm.setString(3, appointment.getPetName());

		if (!pstm.execute() && pstm.getUpdateCount() == 1) {
			return true;
		}
		return false;

	}

	public boolean insertCita(String date, int availability, String pet) throws SQLException, ParseException {
		PreparedStatement pstm = con.prepareStatement(insert);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp date1= new Timestamp(format.parse(date).getTime());
		pstm.setTimestamp(1, date1);
		pstm.setInt(2, availability);
		pstm.setString(3, pet);

		if (!pstm.execute() && pstm.getUpdateCount() == 1) {
			return true;
		}
		return false;

	}

	public List<Appointment> getAppointment(Date date) throws SQLException {
		PreparedStatement pstm = con.prepareStatement(select);
		Timestamp date1= new Timestamp(date.getTime());
		pstm.setTimestamp(1, date1);
		ResultSet rs = pstm.executeQuery();
		List<Appointment> appointments = new ArrayList<Appointment>();
		while(rs.next()) {
			Appointment ap = new Appointment();
			ap.setDate(rs.getTimestamp("date_time"));
			ap.setPet(rs.getString("pet"));
			ap.setPetName(rs.getString("petname"));
			appointments.add(ap);
		}
		return appointments;
	}

}
