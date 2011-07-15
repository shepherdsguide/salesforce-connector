package org.mule.modules.salesforce;

import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.EmptyRecycleBinResult;
import com.sforce.soap.partner.GetDeletedResult;
import com.sforce.soap.partner.LeadConvert;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.apache.log4j.Logger;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.HttpClientTransport;
import org.cometd.client.transport.LongPollingTransport;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.Source;
import org.mule.api.annotations.SourceCallback;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Salesforce Connector will allow to connect to the Salesforce application. Almost every operation that can be
 * done via the Salesforce's API can be done thru this connector. This connector will also work if your Salesforce
 * objects are customized with additional fields or even you are working with custom objects.
 * <p/>
 * Integrating with Salesforce consists of web service calls utilizing XML request/response setup
 * over an HTTPS connection. The technical details of this connection such as request headers,
 * error handling, HTTPS connection, etc. are all abstracted from the user to make implementation
 * quick and easy.
 */
@Module(name = "sfdc")
public class SalesforceModule {
    private static final Logger LOGGER = Logger.getLogger(SalesforceModule.class);
    private static final int HANDSHAKE_TIMEOUT = 30 * 1000;

    /**
     * Username for authenticating the connection
     */
    @Configurable
    private String username;

    /**
     * Password
     */
    @Configurable
    private String password;

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

    /**
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
     * Poll timeout
     */
    @Configurable
    @Optional
    @Default("120000")
    private int pollTimeout;

    /**
     * SalesForce SOAP endpoint
     */
    @Configurable
    @Optional
    @Default("https://login.salesforce.com/services/Soap/u/21.0")
    private URL url;

    /**
     * Partner connection
     */
    private PartnerConnection connection;

    /**
     * Login result
     */
    private LoginResult loginResult;

    /**
     * Bayeux client
     */
    private BayeuxClient bc;

    /**
     * Callbacks
     */
    private HashMap<String, SourceCallback> callbacks;

    /**
     * Adds one or more new records to your organization's data.
     *
     * @param objects An array of one or more sObjects objects.
     * @return An array of {@link SaveResult}
     */
    @Processor
    public List<SaveResult> create(List<Map<String, String>> objects) {

        SObject[] sobjects = new SObject[objects.size()];

        for (Map<String, String> map : objects) {
            SObject sObject = new SObject();
            for (String key : map.keySet()) {
                sObject.setField(key, map.get(key));
            }
        }

        List<SaveResult> saveResults = null;
        try {
            saveResults = Arrays.asList(this.connection.create(sobjects));
        } catch (Exception e) {
            throw new SalesforceException(e);
        }

        return saveResults;
    }

    /**
     * Updates one or more existing records in your organization's data.
     *
     * @param objects An array of one or more sObjects objects.
     * @return An array of {@link SaveResult}
     */
    @Processor
    public List<SaveResult> update(List<Map<String, String>> objects) {

        SObject[] sobjects = new SObject[objects.size()];

        for (Map<String, String> map : objects) {
            SObject sObject = new SObject();
            for (String key : map.keySet()) {
                sObject.setField(key, map.get(key));
            }
        }

        List<SaveResult> saveResults = null;
        try {
            saveResults = Arrays.asList(this.connection.update(sobjects));
        } catch (Exception e) {
            throw new SalesforceException(e);
        }

        return saveResults;
    }

    /**
     * Retrieves a list of available objects for your organization's data.
     *
     * @return A {@link DescribeGlobalResult}
     */
    @Processor
    public DescribeGlobalResult describeGlobal() {
        try {
            return this.connection.describeGlobal();
        } catch (ConnectionException e) {
            throw new SalesforceException(e);
        }
    }

    /**
     * Executes a query against the specified object and returns data that matches the specified criteria.
     *
     * @param query Query string that specifies the object to query, the fields to return, and any conditions for
     *              including a specific object in the query. For more information, see Salesforce Object Query
     *              Language (SOQL).
     * @return An array of {@link SObject}s
     */
    @Processor
    public List<Map<String, Object>> query(String query) {
        try {
            SObject[] objects = this.connection.query(query).getRecords();
            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
            for (SObject object : objects) {
                result.add(object.toMap());
            }

            return result;
        } catch (Exception e) {
            throw new SalesforceException(e);
        }
    }

    /**
     * Executes a query against the specified object and returns the first record that matches the specified criteria.
     *
     * @param query Query string that specifies the object to query, the fields to return, and any conditions for
     *              including a specific object in the query. For more information, see Salesforce Object Query
     *              Language (SOQL).
     * @return A single {@link SObject}
     */
    @Processor
    public Map<String, Object> querySingle(String query) {
        try {
            SObject[] result = this.connection.query(query).getRecords();
            if (result.length > 0) {
                return result[0].toMap();
            }
        } catch (Exception e) {
            throw new SalesforceException(e);
        }

        return null;
    }

    /**
     * Converts a Lead into an Account, Contact, or (optionally) an Opportunity.
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
     * @return
     */
    @Processor
    public LeadConvertResult convertLead(String leadId, String contactId,
                                         String accountId, Boolean overWriteLeadSource, Boolean doNotCreateOpportunity,
                                         String opportunityName, String convertedStatus, Boolean sendEmailToOwner) {

        LeadConvert leadConvert = new LeadConvert();
        leadConvert.setLeadId(leadId);
        leadConvert.setContactId(contactId);
        leadConvert.setAccountId(accountId);
        leadConvert.setOverwriteLeadSource(overWriteLeadSource);
        leadConvert.setDoNotCreateOpportunity(doNotCreateOpportunity);
        leadConvert.setOpportunityName(opportunityName);
        leadConvert.setConvertedStatus(convertedStatus);
        leadConvert.setSendNotificationEmail(sendEmailToOwner);
        LeadConvert[] list = new LeadConvert[1];
        list[0] = leadConvert;

        LeadConvertResult[] lcr = null;

        try {
            lcr = this.connection.convertLead(list);
        } catch (Exception e) {
            throw new SalesforceException(e);
        }

        return lcr[0];
    }

    /**
     * The recycle bin lets you view and restore recently deleted records for 30 days before they are
     * permanently deleted. Your organization can have up to 5000 records per license in the Recycle Bin at any
     * one time. For example, if your organization has five user licenses, 25,000 records can be stored in the
     * Recycle Bin. If your organization reaches its Recycle Bin limit, Salesforce.com automatically removes
     * the oldest records, as long as they have been in the recycle bin for at least two hours.
     *
     * @param ids Array of one or more IDs associated with the records to delete from the recycle bin.
     *            Maximum number of records is 200.
     * @return A list of {@link EmptyRecycleBinResult}
     */
    @Processor
    public List<EmptyRecycleBinResult> emptyRecycleBin(List<String> ids) {
        EmptyRecycleBinResult[] emptyRecycleBinResults = null;

        try {
            emptyRecycleBinResults = this.connection.emptyRecycleBin(ids.toArray(new String[]{}));
        } catch (Exception e) {
            throw new SalesforceException(e);
        }

        return Arrays.asList(emptyRecycleBinResults);
    }


    /**
     * Deletes one or more records from your organization’s data.
     *
     * @param ids Array of one or more IDs associated with the objects to delete.
     * @return An array of {@link DeleteResult}
     */
    @Processor
    public List<DeleteResult> delete(List<String> ids) {
        List<DeleteResult> deleteResults = null;
        try {
            deleteResults = Arrays.asList(this.connection.delete((String[]) ids.toArray()));
        } catch (ConnectionException e) {
            throw new SalesforceException(e);
        }

        return deleteResults;
    }

    /**
     * Retrieves the list of individual records that have been deleted within the given timespan for the specified object.
     *
     * @param type      Object type. The specified value must be a valid object for your organization.
     * @param startTime Starting date/time (Coordinated Universal Time (UTC)�not local� timezone) of the timespan for
     *                  which to retrieve the data. The API ignores the seconds portion of the specified dateTime value '
     *                  (for example, 12:30:15 is interpreted as 12:30:00 UTC).
     * @param endTime   Ending date/time (Coordinated Universal Time (UTC)�not local� timezone) of the timespan for
     *                  which to retrieve the data. The API ignores the seconds portion of the specified dateTime value
     *                  (for example, 12:35:15 is interpreted as 12:35:00 UTC).
     * @return {@link GetDeletedResult}
     */
    @Processor
    public GetDeletedResult getDeletedRange(String type, Calendar startTime, Calendar endTime) {

        GetDeletedResult gdr = null;

        try {
            gdr = this.connection.getDeleted(type, startTime, endTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return gdr;
    }

    /**
     * Describes metadata (field list and object properties) for the specified object.
     *
     * @param type Object. The specified value must be a valid object for your organization. For a complete list
     * of objects, see Standard Objects
     *
     * @return {@link DescribeSObjectResult}
     */
    @Processor
    public DescribeSObjectResult describeSObject(String type) {

        DescribeSObjectResult dsobj = null;

        try {
            dsobj = this.connection.describeSObject(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dsobj;
    }

    /**
     * Retrieves the list of individual records that have been deleted between the range of now to the duration before now.
     *
     * @param type     Object type. The specified value must be a valid object for your organization.
     * @param duration The amount of time in minutes before now for which to return records from.
     * @return {@link GetDeletedResult}
     */
    public GetDeletedResult getDeleted(String type, int duration) {
        GetDeletedResult gdr = null;
        Calendar serverTime = null;

        try {
            serverTime = this.connection.getServerTimestamp().getTimestamp();
        } catch (Exception e) {
            throw new SalesforceException("Unexpected error encountered in getTimestamp: " +
                    e.getMessage(), e);
        }
        Calendar startTime = (Calendar) serverTime.clone();
        Calendar endTime = (Calendar) serverTime.clone();

        endTime.add(Calendar.MINUTE, duration);
        gdr = getDeletedRange(type, startTime, endTime);

        return gdr;
    }


    /**
     * Creates a topic which represents a query that is the basis for notifying
     * listeners of changes to records in an organization.
     *
     * @param name        Descriptive name of the push topic, such as MyNewCases or TeamUpdatedContacts. The
     *                    maximum length is 25 characters. This value identifies the channel.
     * @param description Description of what kinds of records are returned by the query. Limit: 400 characters
     * @param query       The SOQL query statement that determines which records' changes trigger events to be sent to
     *                    the channel. Maximum length: 1200 characters
     */
    @Processor
    public void publishTopic(String name, String query, @Optional String description) throws SalesforceException {
        try {
            QueryResult result = this.connection.query("SELECT Id FROM PushTopic WHERE Name = '" + name + "'");
            if (result.getSize() == 0) {
                SObject pushTopic = new SObject();
                pushTopic.setType("PushTopic");
                pushTopic.setField("ApiVersion", "22.0");
                if (description != null)
                    pushTopic.setField("Description", description);

                pushTopic.setField("Name", name);
                pushTopic.setField("Query", query);

                SaveResult[] saveResults = this.connection.create(new SObject[]{pushTopic});
                if (!saveResults[0].isSuccess()) {
                    throw new SalesforceException(saveResults[0].getErrors()[0].getStatusCode(), saveResults[0].getErrors()[0].getMessage());
                }
            } else {
                SObject pushTopic = result.getRecords()[0];
                if (description != null)
                    pushTopic.setField("Description", description);

                pushTopic.setField("Query", query);

                SaveResult[] saveResults = this.connection.update(new SObject[]{pushTopic});
                if (!saveResults[0].isSuccess()) {
                    throw new SalesforceException(saveResults[0].getErrors()[0].getStatusCode(), saveResults[0].getErrors()[0].getMessage());
                }
            }
        } catch (ConnectionException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void initializeBayeuxClient() {
        try {
            if (this.bc == null) {
                Map<String, Object> options = new HashMap<String, Object>();
                options.put(ClientTransport.TIMEOUT_OPTION, pollTimeout);

                HttpClientTransport clientTransport = LongPollingTransport.create(options);

                URL serviceEndpoint = new URL(this.connection.getConfig().getServiceEndpoint());
                this.bc = new SalesforceBayeuxClient(this, "https://" + serviceEndpoint.getHost() + "/cometd", clientTransport);

                if (!this.bc.isHandshook()) {
                    this.bc.handshake(HANDSHAKE_TIMEOUT);
                }
            }
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * Subscribe to a topic.
     *
     * @param topic    The name of the topic to subscribe to
     * @param callback The callback to be called when a message is received
     */
    @Source
    public void subscribeTopic(String topic, final SourceCallback callback) {
        initializeBayeuxClient();

        bc.getChannel(topic).subscribe(new ClientSessionChannel.MessageListener() {
            @Override
            public void onMessage(ClientSessionChannel channel, Message message) {
                callback.process(message.getData());
            }
        });
    }

    @PostConstruct
    protected void connect() throws ConnectionException {
        this.connection = Connector.newConnection(createConnectorConfig());
        login();
    }

    protected synchronized void login() throws ConnectionException {
        this.loginResult = this.connection.login(this.username, this.password);

        this.connection.getSessionHeader().setSessionId(this.loginResult.getSessionId());
        this.connection.getConfig().setServiceEndpoint(this.loginResult.getServerUrl());
    }

    @PreDestroy
    protected void disconnect() {
        if (this.bc != null) {
            if (this.bc.isConnected()) {
                this.bc.disconnect();
            }
        }

        if (this.connection != null) {
            try {
                this.connection.logout();
            } catch (ConnectionException ce) {
            }
        }
    }

    private ConnectorConfig createConnectorConfig() {
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(this.username);
        config.setPassword(this.password);

        config.setAuthEndpoint(url.toString());
        config.setServiceEndpoint(url.toString());

        config.setManualLogin(true);

        if (this.proxyHost != null) {
            config.setProxy(this.proxyHost, this.proxyPort);
            if (this.proxyUsername != null) {
                config.setProxyUsername(this.proxyUsername);
            }
            if (this.proxyPassword != null) {
                config.setProxyPassword(this.proxyPassword);
            }
        }

        return config;
    }

    /**
     * Retrieve username
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     *
     * @param username Username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieve password
     *
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     *
     * @param password Password to set
     */
    public void setPassword(String password) {
        this.password = password;
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

    public int getPollTimeout() {
        return pollTimeout;
    }

    public void setPollTimeout(int pollTimeout) {
        this.pollTimeout = pollTimeout;
    }

    public URL getUrl() {
        return url;
    }

    protected String getSessionId() {
        return this.loginResult.getSessionId();
    }

    /**
     * Set Salesforce endpoint.
     * <p/>
     * Example:
     * https://prerelna1.pre.salesforce.com/services/Soap/u/21.0
     *
     * @param url Web service endpoint
     */
    public void setUrl(URL url) {
        this.url = url;
    }
}
