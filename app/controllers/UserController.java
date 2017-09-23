package controllers;

import javax.inject.*;
import play.mvc.*;
import play.data.Form;
import play.data.FormFactory;
import models.User;
import exceptions.UserAlreadyExistsException;

public class UserController extends Controller {
	@Inject FormFactory formFactory;

	public Result createUser() {
		Form<User> form = formFactory.form(User.class).bindFromRequest();

		if (form.data().size() == 0) {
			return badRequest("No data");
		}

		User newUser = form.get();
		User.UserClient client = new User.UserClient();
		try {
			client.saveUser(newUser);	
		} catch(UserAlreadyExistsException e) {
			return badRequest(e.getMessage());
		}
		return created();	
	}
}
