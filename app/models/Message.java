package models;

public class Message {
	public String message;
	public String senderSession;

	public void setSenderSession(String senderSession) {
		this.senderSession = senderSession;
	}

	public String getSenderSession() {
		return this.senderSession;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String toString() {
		return "Message: " + message;
	}
}
