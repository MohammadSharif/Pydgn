package models;

public class ParsedMessage {
	String parsedMessage;
	User fromUser, toUser;

	public ParsedMessage(User fromUser, User toUser, String parsedMessage) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.parsedMessage = parsedMessage;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
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
