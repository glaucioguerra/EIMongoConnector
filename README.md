# MongoDB Enterprise Integrator Connector

The MongoDB connector allows you to connect, create and insert documents in MongoDB database.

##Supported versions

MongoDB was developed in EI 6.1.1 tested in MongoDB version 3.4.15.

|        | Version | 
| ------------- |:-------------:|
| MongoDBConnector      | 1.0.0
| Mongo DB      | 3.4.15      
| Java Mongo Driver | 3.8.0
| WSO2 EI | 6.1.1

##Java MongoDB Driver

Copy [Java MongoDB Driver](https://oss.sonatype.org/content/repositories/releases/org/mongodb/mongodb-driver/3.8.0) and paste in <EI_HOME>/lib folder. Restart EI after that.


##Build 

mvn clean install

## Use MongoDB Connector

* After build this connector, add it to [EI instance](https://docs.wso2.com/display/EI611/Working+with+Connectors+via+the+Management+Console#WorkingwithConnectorsviatheManagementConsole-addAddingaconnector)
* Enable the [connector](https://docs.wso2.com/display/EI611/Working+with+Connectors+via+the+Management+Console#WorkingwithConnectorsviatheManagementConsole-enableEnablingaconnector)
* Importing the connector into EI-Tooling [described here](https://docs.wso2.com/display/EI600/Using+the+Gmail+Connector). This connector is not official, it's necessary to build and import the zip file, not choose from wso2 Connector store options.


