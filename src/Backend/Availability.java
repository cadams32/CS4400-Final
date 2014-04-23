package Backend;

public class Availability {
	
	private Object day;
	private Object from;
	private Object to;
	
	public Availability(String day, String from, String to) {
		this.day = day;
		this.from = from;
		this.to = to;
	}

	public Availability(Object day, Object from, Object to) {
		this.day = day;
		this.from = from;
		this.to = to;
	}

	public Object getDay() {
		return day;
	}

	public void setDay(Object day) {
		this.day = day;
	}

	public Object getFrom() {
		return from;
	}

	public void setFrom(Object from) {
		this.from = from;
	}

	public Object getTo() {
		return to;
	}

	public void setTo(Object to) {
		this.to = to;
	}

}
