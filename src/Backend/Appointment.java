package Backend;

public class Appointment {
	
	private String docUsername;
	private String patUsername;
	private String date;
	private String time;

	public Appointment(String docUsername, String patUsername, String date, String time) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
