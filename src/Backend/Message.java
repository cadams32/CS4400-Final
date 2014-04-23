package Backend;

public class Message {
	
	private String message;
	private String sender;
	private String receiver;
	private String time;
	private String status;
	
	public Message(String message, String sender, String receiver, String time, String status) {
		this.setMessage(message);
		this.setSender(sender);
		this.setReceiver(receiver);
		this.setTime(time);
		this.setStatus(status);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
