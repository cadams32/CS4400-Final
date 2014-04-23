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
		this.time = time;
		this.status = status;
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

}
