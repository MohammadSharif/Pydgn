package util;

import java.util.List;
import java.util.ArrayList;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.DB;

public abstract class DatabaseClient {
	protected static DB db;
	static {
		db = getDb();
	}

	private static DB getDb() {
		// This feels like not the right way to do this, but it's almost 4 in the morning, so ask me how many shits I give.
		String userName = play.Configuration.root().getString("mongo.username");
		String password = play.Configuration.root().getString("mongo.password");
		String hostName = play.Configuration.root().getString("mongo.host");
		String database = play.Configuration.root().getString("mongo.database");
		Integer port = play.Configuration.root().getInt("mongo.port");
	
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(MongoCredential.createCredential(userName, database, password.toCharArray()));	
	   	MongoClient mongoClient = new MongoClient(new ServerAddress(hostName, port));
		return mongoClient.getDB(database);
  }
}
