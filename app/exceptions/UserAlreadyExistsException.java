package exceptions;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException() {
		super("User with that name already exists");
	}
}
