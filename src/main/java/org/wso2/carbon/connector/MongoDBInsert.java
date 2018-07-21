package org.wso2.carbon.connector;

import org.apache.synapse.MessageContext;
import org.bson.Document;
import org.json.JSONObject;
import org.json.XML;
import org.wso2.carbon.connector.core.AbstractConnector;
import org.wso2.carbon.connector.core.ConnectException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBInsert extends AbstractConnector{
	
	@Override
	public void connect(MessageContext messageContext) throws ConnectException {
		MongoServer server = new MongoServer();
		MongoClient client = server.connect(messageContext);
		try{
			 server = new MongoServer();
			 client = server.connect(messageContext);
			if (client!=null){
				log.debug("Mongodb connected - MongoInsert");
				log.debug("collection: " + messageContext.getProperty(MongoDBConstants.COLLECTION).toString());
				log.debug("database: " + messageContext.getProperty(MongoDBConstants.DATABASE).toString());
				log.debug("document" + messageContext.getProperty(MongoDBConstants.DOCUMENT).toString());
				JSONObject xmlJSONObj = XML.toJSONObject( messageContext.getProperty(MongoDBConstants.DOCUMENT).toString());
				log.debug("Document in json: " + xmlJSONObj.toString());
				String collection = messageContext.getProperty(MongoDBConstants.COLLECTION).toString();
				MongoDatabase db = client.getDatabase(messageContext.getProperty(MongoDBConstants.DATABASE).toString());
				MongoCollection<Document> dbCollection =  db.getCollection(collection);
				log.debug("Document: " + messageContext.getProperty(MongoDBConstants.DOCUMENT).toString());
				Document dbObject = Document.parse(xmlJSONObj.toString());
				dbCollection.insertOne(dbObject);
				messageContext.setProperty(MongoDBConstants.RESULT, "OK");
				client.close();
			}
		}catch (Exception e){
			log.error(e);
			client.close();
			messageContext.setProperty(MongoDBConstants.RESULT, "ERROR");
		}
		
	}

}
