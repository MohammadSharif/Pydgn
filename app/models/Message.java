package models;

public class Message {
	public String message;

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
