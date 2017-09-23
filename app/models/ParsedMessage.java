package models;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import util.DatabaseClient;

public class ParsedMessage {
	String toUser, parsedMessage;

	public ParsedMessage(String toUser, String parsedMessage) {
		this.toUser = toUser;
		this.parsedMessage = parsedMessage;
	}

	public static class ParsedMessageClient extends DatabaseClient {
		private static final String COLLECTION_NAME = "parsedMessages";
		public static void saveMessage(ParsedMessage parsedMessage) {
			DBCollection collection = db.getCollection(COLLECTION_NAME);
			BasicDBObject document = new BasicDBObject();
			document.put("parsedMessage", parsedMessage.parsedMessage);
			document.put("toUser", parsedMessage.toUser);
			collection.insert(document);
		}	
	}
}	
