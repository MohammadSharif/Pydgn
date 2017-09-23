/**
 * Created by Momo on 9/23/17
 */

import java.util.*;

public class backend {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    MessageParser mP = new MessageParser();
    boolean isDone = false;
    String message;
    String extractedMessage = "";
    String userName = null;
    while(!isDone){
      message = in.nextLine();
      if(userName == null)
        userName = mP.extractUserName(message);
      extractedMessage = extractedMessage + mP.extractMessage(message);
      isDone = mP.messageEnded(message);
    }
    in.close();
    System.out.println("Recipient: " + userName);
    System.out.println("Message: " + extractedMessage);
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
