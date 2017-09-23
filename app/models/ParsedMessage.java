package models;

public class ParsedMessage {
	String parsedMessage;
	User toUser;

	public ParsedMessage(User toUser, String parsedMessage) {
		this.toUser = toUser;
		this.parsedMessage = parsedMessage;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User user) {
		this.toUser = user;
	}

	public String getParsedMessage() {
		return parsedMessage;
	}

	public void setParsedMessage(String parsedMessage) {
		this.parsedMessage = parsedMessage;
	}
}	
