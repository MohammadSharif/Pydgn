package models;

/**
 * Created by Momo on 9/23/17
 */

import java.util.*;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import exceptions.UserAlreadyExistsException;
import util.DatabaseClient;

public class User {
  private String userName, serviceType, conversationID;
  
  public User() {}

  public User(String userName, String serviceType, String conversationID) {
    this.userName = userName;
    this.serviceType = serviceType;
	this.conversationID = conversationID;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
	this.userName = userName;
  }

  public String getServiceType() {
    return this.serviceType;
  }

  public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
  }

  public String getConversationID() {
	return this.conversationID;
  }

  public void setConversationID(String conversationID) {
	this.conversationID = conversationID;
  }

  public static class UserClient extends DatabaseClient {
	private static final String COLLECTION_NAME = "users";

	public User getUserByUsername(String username) {
		DBCollection collection = db.getCollection(COLLECTION_NAME);
		BasicDBObject query = new BasicDBObject();
		query.put("userName", username);
		DBCursor cursor = collection.find(query);
		if (!cursor.hasNext()) {
			return null;
		}
		DBObject object = cursor.next();
		return new User(object.get("userName").toString(), object.get("serviceType").toString(), object.get("conversationID").toString());
	}	

	public void saveUser(User user) throws UserAlreadyExistsException {
		if (getUserByUsername(user.userName) != null) {
			UserAlreadyExistsException down = new UserAlreadyExistsException();
			throw down; 
		}
		DBCollection collection = db.getCollection(COLLECTION_NAME);
		BasicDBObject document = new BasicDBObject();
		document.put("userName", user.userName);
		document.put("serviceType", user.serviceType);
		document.put("conversationID", user.conversationID);
		collection.insert(document);
	}	
  }
}
