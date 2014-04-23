package Backend;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	
	private String docUsername;
	private String patUsername;
	private Date date;
	private Time time;

	public Appointment(String docUsername, String patUsername, Date date, Time time) {
		this.docUsername = docUsername;
		this.patUsername = patUsername;
		this.date = date;
		this.time = time;
	}

	public String getDocUsername() {
		return docUsername;
	}

	public void setDocUsername(String docUsername) {
		this.docUsername = docUsername;
	}

	public String getPatUsername() {
		return patUsername;
	}

	public void setPatUsername(String patUsername) {
		this.patUsername = patUsername;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
