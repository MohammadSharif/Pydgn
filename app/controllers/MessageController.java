package controllers;

import javax.inject.*;
import java.net.URLDecoder;
import play.mvc.*;
import play.data.Form;
import play.data.FormFactory;
import models.Message;
import models.ParsedMessage;

import java.io.UnsupportedEncodingException;

public class MessageController extends Controller {
	@Inject FormFactory formFactory;

	public Result parseMessage() throws UnsupportedEncodingException {
		// Get the POST data
		Form<Message> form = formFactory.form(Message.class).bindFromRequest();

		if (form.data().size() == 0) {
			return badRequest("No data");
		}

		MessageParser mP = new MessageParser();
		String message = URLDecoder.decode(form.get().getMessage(), "UTF-8");
		String userName = mP.extractUserName(message);
		String extractedMessage = mP.extractMessage(message);
		if (extractedMessage == null) {
			return badRequest("No message");
		}
		ParsedMessage.ParsedMessageClient client = new ParsedMessage.ParsedMessageClient();
		ParsedMessage parsedMessage = new ParsedMessage(userName, extractedMessage);
		client.saveMessage(parsedMessage);
		return ok(extractedMessage);
	}

	private static class MessageParser {

		/**
		 * All messages must begin with @username so to extract the username we
		 * get the substring from 1 - the first occurence of a space.
		 * @param String message [message being sent over the Pydgn service]
		 * @return the username the message is directed to
		 */
		public String extractUserName(String message){
		  String userName = message.substring(1, message.indexOf(" "));
		  return userName;
		}

		/**
		 * Extracts the actual message text from the data sent through the chatbot.
		 * @param  String message       [message being sent over Pydgn service]
		 * @return the true message meant to be sent to the recipient
		 */
		public String extractMessage(String message){
		  int startMessageIndex = message.substring(0, 1).equals("@") ? message.indexOf(" ") : 0;
		  int endMessageIndex = message.contains("/end") ? message.indexOf("/end") : message.length();
		  String extractedMessage = message.substring(startMessageIndex, endMessageIndex);
		  return extractedMessage;
		}

		public boolean messageEnded(String message){
		  return message.contains("/end");
		}
	}
}
