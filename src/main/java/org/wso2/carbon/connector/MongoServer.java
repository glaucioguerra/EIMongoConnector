package org.wso2.carbon.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoServer {
	public MongoClient connect(MessageContext messageContext) {
		Log log = LogFactory.getLog(this.getClass());
		final String host = messageContext.getProperty(MongoDBConstants.HOSTNAME).toString();
	    final String username = messageContext.getProperty(MongoDBConstants.USERNAME).toString();
	    final String password = messageContext.getProperty(MongoDBConstants.PASSWORD).toString();
	    final String port = messageContext.getProperty(MongoDBConstants.PORT).toString();
	    final String database = messageContext.getProperty(MongoDBConstants.DATABASE).toString();
		final String connectionStringDB = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + database; 
	    try {
	        log.info("MongoDB started.");
	        MongoClientURI connectionString = new MongoClientURI(connectionStringDB);
	        MongoClient mongoClient = new MongoClient(connectionString);
	    	MongoDatabase mongoDB = mongoClient.getDatabase(database);
	    	log.info(mongoDB.getName());
	    	return mongoClient;
	        
	    } catch (Exception e) {
	    	log.error(e);
	    	return null;
	    }
	}
	
	
}
