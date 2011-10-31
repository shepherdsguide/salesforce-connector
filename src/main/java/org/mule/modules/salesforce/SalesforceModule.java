package org.mule.modules.salesforce;

import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.*;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.transport.SoapConnection;
import org.apache.log4j.Logger;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.*;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.callback.SourceCallback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * The Salesforce Connector will allow to connect to the Salesforce application. Almost every operation that can be
 * done via the Salesforce's API can be done thru this connector. This connector will also work if your Salesforce
 * objects are customized with additional fields or even you are working with custom objects.
 * <p/>
 * Integrating with Salesforce consists of web service calls utilizing XML request/response setup
 * over an HTTPS connection. The technical details of this connection such as request headers,
 * error handling, HTTPS connection, etc. are all abstracted from the user to make implementation
 * quick and easy.
 *
 * @author MuleSoft, Inc.
 */
@org.mule.api.annotations.Connector(name = "sfdc", schemaVersion = "4.0")
public class SalesforceModule {
    private static final Logger LOGGER = Logger.getLogger(SalesforceModule.class);

    /**
     * Proxy host
     */
    @Configurable
    @Optional
    private String proxyHost;

    /**
     * Proxy port
     */
    @Configurable
    @Optional
    @Default("80")
    private int proxyPort = -1;

    /**                 V
     * Proxy username
     */
    @Configurable
    @Optional
    private String proxyUsername;

    /**
     * Proxy password
     */
    @Configurable
    @Optional
    private String proxyPassword;

    /**
     * SalesForce SOAP endpoint
     */
    @Configurable
    @Optional
    @Default("https://login.salesforce.com/services/Soap/u/23.0")
    private URL url;

    /**
     * Bayeux client
     */
    private SalesforceBayeuxClient bc;

    /**
     * Partner connection
     */
    private PartnerConnection connection;

    /**
     * Login result
     */
    private LoginResult loginResult;

    /**
     * Adds one or more new records to your organization's data.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:create}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:create}
     *
     * @param objects An array of one or more sObjects objects.
     * @param type    Type of object to create
     * @return An array of {@link SaveResult}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public List<SaveResult> create(String type, List<Map<String, String>> objects) throws Exception {

        List<SaveResult> saveResults = null;
        saveResults = Arrays.asList(this.connection.create(toSObjectList(type, objects)));

        return saveResults;
    }

    @ValidateConnection
    public boolean isConnected() {
        if (this.connection != null) {
            if (this.loginResult != null) {
                if (this.loginResult.getSessionId() != null) {
                    return true;
                }
            }
        }

        return false;
    }

    @ConnectionIdentifier
    public String getSessionId() {
        if (this.connection != null) {
            if (this.loginResult != null) {
                return this.loginResult.getSessionId();
            }
        }

        return null;
    }


    /**
     * End the current session
     *
     * @throws Exception
     */
    @Disconnect
    public synchronized void destroySession() {
        if (this.bc != null) {
            if (this.bc.isConnected()) {
                this.bc.disconnect();
            }
        }

        if (this.connection != null) {
            try {
                this.connection.logout();
                this.loginResult = null;
                this.connection = null;
            } catch (ConnectionException ce) {
                LOGGER.error(ce);
            }
        }
    }

    /**
     * Updates one or more existing records in your organization's data.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:update}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:update}
     *
     * @param objects An array of one or more sObjects objects.
     * @param type    Type of object to update
     * @return An array of {@link SaveResult}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public List<SaveResult> update(String type, List<Map<String, String>> objects) throws Exception {

        List<SaveResult> saveResults = null;
        saveResults = Arrays.asList(this.connection.update(toSObjectList(type, objects)));

        return saveResults;
    }

    /**
     * <a href="http://www.salesforce.com/us/developer/docs/api/Content/sforce_api_calls_upsert.htm">Upserts</a>
     * an homogeneous list of objects: creates new records and updates existing records, using a custom field to determine the presence of existing records.
     * In most cases, prefer {@link #upsert(String, String, List)} over {@link #create(String, List)},
     * to avoid creating unwanted duplicate records.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:upsert}
     *
     * @param externalIdFieldName Contains the name of the field on this object with the external ID field attribute
     *                            for custom objects or the idLookup field property for standard objects.
     * @param type                the type of the given objects. The list of objects to upsert must be homogeneous
     * @param objects             the objects to upsert
     * @return a list of {@link UpsertResult}, one for each passed object
     * @throws Exception if a connection error occurs
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public List<UpsertResult> upsert(String externalIdFieldName, String type, List<Map<String, String>> objects) throws Exception {
        try {
            return Arrays.asList(this.connection.upsert(externalIdFieldName, toSObjectList(type, objects)));
        } catch (Exception e) {
            throw new Exception("Unexpected error encountered in upsert: " +
                    e.getMessage(), e);
        }
    }

    /**
     * Retrieves a list of available objects for your organization's data.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:describe-global}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:describe-global}
     *
     * @return A {@link DescribeGlobalResult}
     * @throws Exception
     */
    @Processor
    public DescribeGlobalResult describeGlobal() throws Exception {
        return this.connection.describeGlobal();
    }

    /**
     * Executes a query against the specified object and returns data that matches the specified criteria.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:query}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:query}
     *
     * @param query Query string that specifies the object to query, the fields to return, and any conditions for
     *              including a specific object in the query. For more information, see Salesforce Object Query
     *              Language (SOQL).
     * @return An array of {@link SObject}s
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public List<Map<String, Object>> query(String query) throws Exception {
        try {
            SObject[] objects = this.connection.query(query).getRecords();
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
            for (SObject object : objects) {
                result.add(object.toMap());
            }

            return result;
        } catch (Exception e) {
            throw new Exception("Unexpected error encountered in query: " +
                    e.getMessage(), e);
        }
    }

    /**
     * Executes a query against the specified object and returns the first record that matches the specified criteria.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:query-single}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:query-single}
     *
     * @param query Query string that specifies the object to query, the fields to return, and any conditions for
     *              including a specific object in the query. For more information, see Salesforce Object Query
     *              Language (SOQL).
     * @return A single {@link SObject}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public Map<String, Object> querySingle(String query) throws Exception {
        SObject[] result = this.connection.query(query).getRecords();
        if (result.length > 0) {
            return result[0].toMap();
        }

        return null;
    }

    /**
     * Converts a Lead into an Account, Contact, or (optionally) an Opportunity.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:convert-lead}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:convert-lead}
     *
     * @param leadId                 ID of the Lead to convert. Required. For information on IDs, see ID Field Type.
     * @param contactId              ID of the Contact into which the lead will be merged (this contact must be
     *                               associated with the specified accountId, and an accountId must be specified).
     *                               Required only when updating an existing contact.IMPORTANT if you are converting
     *                               a lead into a person account, do not specify the contactId or an error will result.
     *                               Specify only the accountId of the person account. If no contactID is specified,
     *                               then the API creates a new contact that is implicitly associated with the Account.
     *                               To create a new contact, the client application must be logged in with sufficient
     *                               access rights. To merge a lead into an existing contact, the client application
     *                               must be logged in with read/write access to the specified contact. The contact
     *                               name and other existing data are not overwritten (unless overwriteLeadSource is
     *                               set to true, in which case only the LeadSource field is overwritten).
     *                               For information on IDs, see ID Field Type.
     * @param accountId              ID of the Account into which the lead will be merged. Required
     *                               only when updating an existing account, including person accounts.
     *                               If no accountID is specified, then the API creates a new account. To
     *                               create a new account, the client application must be logged in with
     *                               sufficient access rights. To merge a lead into an existing account,
     *                               the client application must be logged in with read/write access to the
     *                               specified account. The account name and other existing data are not overwritten.
     *                               For information on IDs, see ID Field Type.
     * @param overWriteLeadSource    Specifies whether to overwrite the LeadSource field on the target Contact object
     *                               with the contents of the LeadSource field in the source Lead object (true), or
     *                               not (false, the default). To set this field to true, the client application
     *                               must specify a contactId for the target contact.
     * @param doNotCreateOpportunity Specifies whether to create an Opportunity during lead conversion (false, the
     *                               default) or not (true). Set this flag to true only if you do not want to create
     *                               an opportunity from the lead. An opportunity is created by default.
     * @param opportunityName        Name of the opportunity to create. If no name is specified, then this value
     *                               defaults to the company name of the lead. The maximum length of this field is
     *                               80 characters. If doNotCreateOpportunity argument is true, then no Opportunity
     *                               is created and this field must be left blank; otherwise, an error is returned.
     * @param convertedStatus        Valid LeadStatus value for a converted lead. Required.
     *                               To obtain the list of possible values, the client application queries the
     *                               LeadStatus object, as in:
     *                               Select Id, MasterLabel from LeadStatus where IsConverted=true
     * @param sendEmailToOwner       Specifies whether to send a notification email to the owner specified in the
     *                               ownerId (true) or not (false, the default).
     * @return A list of {@link LeadConvertResult}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public LeadConvertResult convertLead(String leadId, String contactId,
                                         @Optional String accountId,
                                         @Optional @Default("false") Boolean overWriteLeadSource,
                                         @Optional @Default("false") Boolean doNotCreateOpportunity,
                                         @Optional String opportunityName,
                                         String convertedStatus,
                                         @Optional @Default("false") Boolean sendEmailToOwner)
            throws Exception {

        LeadConvert leadConvert = new LeadConvert();
        leadConvert.setLeadId(leadId);
        leadConvert.setContactId(contactId);
        leadConvert.setAccountId(accountId);
        leadConvert.setOverwriteLeadSource(overWriteLeadSource);
        leadConvert.setDoNotCreateOpportunity(doNotCreateOpportunity);
        if (opportunityName != null) {
            leadConvert.setOpportunityName(opportunityName);
        }
        leadConvert.setConvertedStatus(convertedStatus);
        leadConvert.setSendNotificationEmail(sendEmailToOwner);
        LeadConvert[] list = new LeadConvert[1];
        list[0] = leadConvert;

        LeadConvertResult[] lcr = null;

        lcr = this.connection.convertLead(list);

        return lcr[0];
    }

    /**
     * The recycle bin lets you view and restore recently deleted records for 30 days before they are
     * permanently deleted. Your organization can have up to 5000 records per license in the Recycle Bin at any
     * one time. For example, if your organization has five user licenses, 25,000 records can be stored in the
     * Recycle Bin. If your organization reaches its Recycle Bin limit, Salesforce.com automatically removes
     * the oldest records, as long as they have been in the recycle bin for at least two hours.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:empty-recycle-bin}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:empty-recycle-bin}
     *
     * @param ids Array of one or more IDs associated with the records to delete from the recycle bin.
     *            Maximum number of records is 200.
     * @return A list of {@link EmptyRecycleBinResult}
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public List<EmptyRecycleBinResult> emptyRecycleBin(List<String> ids) throws Exception {
        EmptyRecycleBinResult[] emptyRecycleBinResults = null;

        emptyRecycleBinResults = this.connection.emptyRecycleBin(ids.toArray(new String[]{}));

        return Arrays.asList(emptyRecycleBinResults);
    }


    /**
     * Deletes one or more records from your organization's data.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:delete}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:delete}
     *
     * @param ids Array of one or more IDs associated with the objects to delete.
     * @return An array of {@link DeleteResult}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public List<DeleteResult> delete(List<String> ids) throws Exception {
        List<DeleteResult> deleteResults = null;
        try {
            deleteResults = Arrays.asList(this.connection.delete((String[]) ids.toArray()));
        } catch (Exception e) {
            throw new Exception("Unexpected error encountered in delete: " +
                    e.getMessage(), e);
        }

        return deleteResults;
    }

    /**
     * Retrieves the list of individual records that have been deleted within the given timespan for the specified object.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:get-deleted-range}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:get-deleted-range}
     *
     * @param type      Object type. The specified value must be a valid object for your organization.
     * @param startTime Starting date/time (Coordinated Universal Time (UTC)not local timezone) of the timespan for
     *                  which to retrieve the data. The API ignores the seconds portion of the specified dateTime value '
     *                  (for example, 12:30:15 is interpreted as 12:30:00 UTC).
     * @param endTime   Ending date/time (Coordinated Universal Time (UTC)not local timezone) of the timespan for
     *                  which to retrieve the data. The API ignores the seconds portion of the specified dateTime value
     *                  (for example, 12:35:15 is interpreted as 12:35:00 UTC).
     * @return {@link GetDeletedResult}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public GetDeletedResult getDeletedRange(String type, Calendar startTime, Calendar endTime) throws Exception {

        GetDeletedResult gdr = null;

        gdr = this.connection.getDeleted(type, startTime, endTime);

        return gdr;
    }

    /**
     * Describes metadata (field list and object properties) for the specified object.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:describe-sobject}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:describe-sobject}
     *
     * @param type Object. The specified value must be a valid object for your organization. For a complete list
     *             of objects, see Standard Objects
     * @return {@link DescribeSObjectResult}
     * @throws Exception
     */
    @Processor(name = "describe-sobject")
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public DescribeSObjectResult describeSObject(String type) throws Exception {

        DescribeSObjectResult dsobj = null;

        try {
            dsobj = this.connection.describeSObject(type);
        } catch (Exception e) {
            throw new Exception("Unexpected error encountered in describeSObject: " +
                    e.getMessage(), e);
        }

        return dsobj;
    }

    /**
     * Retrieves the list of individual records that have been deleted between the range of now to the duration before now.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:get-deleted}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:get-deleted}
     *
     * @param type     Object type. The specified value must be a valid object for your organization.
     * @param duration The amount of time in minutes before now for which to return records from.
     * @return {@link GetDeletedResult}
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public GetDeletedResult getDeleted(String type, int duration) throws Exception {
        GetDeletedResult gdr = null;
        Calendar serverTime = null;

        serverTime = this.connection.getServerTimestamp().getTimestamp();
        Calendar startTime = (Calendar) serverTime.clone();
        Calendar endTime = (Calendar) serverTime.clone();

        endTime.add(Calendar.MINUTE, duration);
        gdr = getDeletedRange(type, startTime, endTime);

        return gdr;
    }

    /**
     * Creates a topic which represents a query that is the basis for notifying
     * listeners of changes to records in an organization.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:publish-topic}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:publish-topic}
     *
     * @param name        Descriptive name of the push topic, such as MyNewCases or TeamUpdatedContacts. The
     *                    maximum length is 25 characters. This value identifies the channel.
     * @param description Description of what kinds of records are returned by the query. Limit: 400 characters
     * @param query       The SOQL query statement that determines which records' changes trigger events to be sent to
     *                    the channel. Maximum length: 1200 characters
     * @throws Exception
     */
    @Processor
    @InvalidateConnectionOn(exception = SoapConnection.SessionTimedOutException.class)
    public void publishTopic(String name, String query, @Optional String description) throws Exception {
        QueryResult result = this.connection.query("SELECT Id FROM PushTopic WHERE Name = '" + name + "'");
        if (result.getSize() == 0) {
            SObject pushTopic = new SObject();
            pushTopic.setType("PushTopic");
            pushTopic.setField("ApiVersion", "22.0");
            if (description != null) {
                pushTopic.setField("Description", description);
            }

            pushTopic.setField("Name", name);
            pushTopic.setField("Query", query);

            SaveResult[] saveResults = this.connection.create(new SObject[]{pushTopic});
            if (!saveResults[0].isSuccess()) {
                throw new SalesforceException(saveResults[0].getErrors()[0].getStatusCode(), saveResults[0].getErrors()[0].getMessage());
            }
        } else {
            SObject pushTopic = result.getRecords()[0];
            if (description != null) {
                pushTopic.setField("Description", description);
            }

            pushTopic.setField("Query", query);

            SaveResult[] saveResults = this.connection.update(new SObject[]{pushTopic});
            if (!saveResults[0].isSuccess()) {
                throw new SalesforceException(saveResults[0].getErrors()[0].getStatusCode(), saveResults[0].getErrors()[0].getMessage());
            }
        }
    }

    /**
     * Subscribe to a topic.
     * <p/>
     * {@sample.xml ../../../doc/mule-module-sfdc.xml.sample sfdc:subscribe-topic}
     * {@sample.java ../../../doc/mule-module-sfdc.java.sample sfdc:subscribe-topic}
     *
     * @param topic    The name of the topic to subscribe to
     * @param callback The callback to be called when a message is received
     */
    @Source
    public void subscribeTopic(String topic, final SourceCallback callback) {
        this.getBayeuxClient().subscribe(topic, new ClientSessionChannel.MessageListener() {
            @Override
            public void onMessage(ClientSessionChannel channel, Message message) {
                try {
                    callback.process(message.getData());
                } catch (Exception e) {
                    LOGGER.error(e);
                }
            }
        });
    }

    /**
     * Creates a new Salesforce session
     *
     * @param username      Username used to initialize the session
     * @param password      Password used to authenticate the user
     * @param securityToken User's security token
     * @throws ConnectionException if a problem occurred while trying to create the session
     */
    @Connect
    public synchronized void connect(@ConnectionKey String username, String password, String securityToken)
            throws org.mule.api.ConnectionException {
        try {
            this.connection = Connector.newConnection(createConnectorConfig(this.url, username, password + securityToken, this.proxyHost, this.proxyPort, this.proxyUsername, this.proxyPassword));
        } catch (ConnectionException e) {
            throw new org.mule.api.ConnectionException(ConnectionExceptionCode.UNKNOWN, null, e.getMessage(), e);
        }

        reconnect();
    }

    public void reconnect() throws org.mule.api.ConnectionException {
        try {
            LOGGER.debug("Creating a Salesforce session using " + this.connection.getConfig().getUsername());
            this.loginResult = this.connection.login(this.connection.getConfig().getUsername(), this.connection.getConfig().getPassword());

            if (this.loginResult.isPasswordExpired()) {
                try {
                    this.connection.logout();
                } catch (ConnectionException e) {
                    LOGGER.error(e.getMessage(), e);
                }
                this.connection = null;
                throw new org.mule.api.ConnectionException(ConnectionExceptionCode.CREDENTIALS_EXPIRED, null, "The password for the user " + this.connection.getConfig().getUsername() + " has expired");
            }

            LOGGER.debug("Session established successfully with ID " + this.loginResult.getSessionId() + " at instance " + this.loginResult.getServerUrl());
            this.connection.getSessionHeader().setSessionId(this.loginResult.getSessionId());
            this.connection.getConfig().setServiceEndpoint(this.loginResult.getServerUrl());
        } catch (ConnectionException e) {
            throw new org.mule.api.ConnectionException(ConnectionExceptionCode.UNKNOWN, null, e.getMessage(), e);
        }
    }

    protected SObject[] toSObjectList(String type, List<Map<String, String>> objects) {
        SObject[] sobjects = new SObject[objects.size()];
        int s = 0;
        for (Map<String, String> map : objects) {
            SObject sObject = new SObject();
            for (String key : map.keySet()) {
                sObject.setType(type);
                sObject.setField(key, map.get(key));
            }
            sobjects[s] = sObject;
            s++;
        }
        return sobjects;
    }


    /**
     * Retrieve host of proxy
     *
     * @return The host of the configured proxy
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * Set proxy host
     *
     * @param proxyHost Proxy host to set
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    /**
     * Retrieve proxy port
     *
     * @return Configured proxy port
     */
    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * Set proxy port
     *
     * @param proxyPort Proxy port to set
     */
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    /**
     * Retrieve proxy username
     *
     * @return Configured proxy username
     */
    public String getProxyUsername() {
        return proxyUsername;
    }

    /**
     * Set proxy username
     *
     * @param proxyUsername Proxy username to set
     */
    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    /**
     * Retrieve proxy password
     *
     * @return Proxy password
     */
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * Set proxy password
     *
     * @param proxyPassword Proxy password to set
     */
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public URL getUrl() {
        return url;
    }

    /**
     * Set Salesforce endpoint.
     *
     * @param url Web service endpoint
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * Create connector config
     *
     * @param endpoint      Salesforce endpoint
     * @param username      Username to use for authentication
     * @param password      Password to use for authentication
     * @param proxyHost
     * @param proxyPort
     * @param proxyUsername
     * @param proxyPassword
     * @return
     */
    private ConnectorConfig createConnectorConfig(URL endpoint, String username, String password, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(username);
        config.setPassword(password);

        config.setAuthEndpoint(endpoint.toString());
        config.setServiceEndpoint(endpoint.toString());

        config.setManualLogin(true);

        if (proxyHost != null) {
            config.setProxy(proxyHost, proxyPort);
            if (proxyUsername != null) {
                config.setProxyUsername(proxyUsername);
            }
            if (proxyPassword != null) {
                config.setProxyPassword(proxyPassword);
            }
        }

        return config;
    }

    public PartnerConnection getConnection() {
        return connection;
    }

    public LoginResult getLoginResult() {
        return loginResult;
    }

    public SalesforceBayeuxClient getBayeuxClient() {
        try {
            if (this.bc == null) {
                this.bc = new SalesforceBayeuxClient(this);

                if (!this.bc.isHandshook()) {
                    this.bc.handshake();
                }
            }
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }

        return bc;
    }
}
