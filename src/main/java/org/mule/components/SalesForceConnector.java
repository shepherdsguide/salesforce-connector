/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.components;

import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.tools.cloudconnect.annotations.Connector;
import org.mule.tools.cloudconnect.annotations.Operation;
import org.mule.tools.cloudconnect.annotations.Property;
import org.mule.util.StringUtils;

import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.EmptyRecycleBinResult;
import com.sforce.soap.partner.GetDeletedResult;
import com.sforce.soap.partner.GetUpdatedResult;
import com.sforce.soap.partner.InvalidateSessionsResult;
import com.sforce.soap.partner.LeadConvert;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.ProcessRequest;
import com.sforce.soap.partner.ProcessResult;
import com.sforce.soap.partner.ProcessSubmitRequest;
import com.sforce.soap.partner.ProcessWorkitemRequest;
import com.sforce.soap.partner.QueryOptions;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SforceService;
import com.sforce.soap.partner.Soap;
import com.sforce.soap.partner.UpsertResult;
import com.sforce.soap.partner.sobject.SObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.w3c.dom.Document;

@Connector(namespacePrefix = "sfdc")
public class SalesForceConnector implements Initialisable
{

    @Property
    private String username;
    @Property
    private String password;
    @Property
    private String proxyHost;
    @Property(defaultValue = "80")
    private int proxyPort = -1;
    @Property
    private String securityToken;

    private JAXBDataBinding jSessionDataBinding;
    private JAXBDataBinding jQueryOptionsDataBinding = null;
    private Document docBuilder;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSecurityToken()
    {
        return securityToken;
    }

    public void setSecurityToken(String securityToken)
    {
        this.securityToken = securityToken;
    }

    public String getProxyHost()
    {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost)
    {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort()
    {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort)
    {
        this.proxyPort = proxyPort;
    }

    protected Soap login() throws RuntimeException
    {
        Soap client = null;
        SforceService sforceService = null;

        sforceService = new SforceService(getClass().getResource("/partner.wsdl"));
        client = sforceService.getPort(Soap.class);

        initializeHttpProxy(client);

        LoginResult loginResult = null;
        try
        {
            loginResult = client.login(username, password + securityToken);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        BindingProvider bindingProvider = ((BindingProvider) client);
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, loginResult.getServerUrl());

        //Enable GZip compression
        Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
        Map<String, Object> reqContext = bindingProvider.getRequestContext();
        reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);

        SessionHeader sh = new SessionHeader();
        sh.setSessionId(loginResult.getSessionId());

        List<Header> headers = new ArrayList<Header>();

        headers.add(new Header(new QName("urn:partner.soap.sforce.com", "SessionHeader"), sh, jSessionDataBinding));
        bindingProvider.getRequestContext().put(Header.HEADER_LIST, headers);

        return client;
    }

    private void initializeHttpProxy(Soap soap)
    {
        if (StringUtils.isNotBlank(proxyHost) && (proxyPort != -1))
        {
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setProxyServer(proxyHost);
            httpClientPolicy.setProxyServerPort(proxyPort);

            Client client = ClientProxy.getClient(soap);
            HTTPConduit http = (HTTPConduit) client.getConduit();
            http.setClient(httpClientPolicy);
        }
    }

    /**
     * Adds one or more new records to your organization�s data. This specific call
     * is different from create() in that it takes true sObjects versus mule specific
     * MuleSObjects
     *
     * @param sObjects Salesforce specific sObjects.
     * @return
     */
    @Operation
    public List<SaveResult> createSObjects(List<SObject> sObjects)
    {
        Soap client = login();

        List<SaveResult> sr = null;

        try
        {
            sr = client.create(sObjects);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return sr;

    }

    /**
     * Adds one or more new records to your organization�s data. This call differs
     * from the original create object by allowing for the setting of the type as part
     * of the method call along with the passing of a MuleSObject which is just an object
     * which extends a hashmap.
     *
     * @param sObjects
     * @return
     */
    @Operation
    public List<SaveResult> create(List<SObject> sObjects)
    {
        Soap client = login();

        List<SaveResult> sr = null;

        try
        {
            sr = client.create(sObjects);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return sr;
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
    @Operation
    public List<LeadConvertResult> convertLead(String leadId, String contactId,
                                               String accountId, Boolean overWriteLeadSource, Boolean doNotCreateOpportunity,
                                               String opportunityName, String convertedStatus, Boolean sendEmailToOwner)
    {

        LeadConvert leadConvert = new LeadConvert();
        leadConvert.setLeadId(leadId);
        leadConvert.setContactId(contactId);
        leadConvert.setAccountId(accountId);
        leadConvert.setOverwriteLeadSource(overWriteLeadSource);
        leadConvert.setDoNotCreateOpportunity(doNotCreateOpportunity);
        leadConvert.setOpportunityName(opportunityName);
        leadConvert.setConvertedStatus(convertedStatus);
        leadConvert.setSendNotificationEmail(sendEmailToOwner);
        List<LeadConvert> list = new ArrayList<LeadConvert>();
        list.add(leadConvert);

        List<LeadConvertResult> lcr = null;

        Soap client = login();

        try
        {
            lcr = client.convertLead(list);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return lcr;
    }

    /**
     * Use delete() to delete one or more existing records, such as individual accounts or contacts, in your
     * organization�s data. The delete() call is analogous to the DELETE statement in SQL.
     *
     * @param ids Array of one or more IDs associated with the objects to delete. In version 7.0 and later,
     *            you can pass a maximum of 200 object IDs to the delete() call. In version 6.0 and earlier,
     *            the limit is 2,000.
     * @return
     */
    @Operation
    public List<DeleteResult> delete(List<String> ids)
    {

        List<DeleteResult> deleteResults = null;

        Soap client = login();

        try
        {
            deleteResults = client.delete(ids);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return deleteResults;
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
     * @return
     */
    @Operation
    public List<EmptyRecycleBinResult> emptyrecyclebin(List<String> ids)
    {

        List<EmptyRecycleBinResult> emptyRecycleBinResults = null;

        Soap client = login();

        try
        {
            emptyRecycleBinResults = client.emptyRecycleBin(ids);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return emptyRecycleBinResults;
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
     * @return
     */
    public GetDeletedResult getDeletedRange(String type, XMLGregorianCalendar startTime, XMLGregorianCalendar endTime)
    {

        GetDeletedResult gdr = null;

        Soap client = login();

        try
        {
            gdr = client.getDeleted(type, startTime, endTime);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return gdr;
    }

    /**
     * Retrieves the list of individual records that have been deleted between the range of now to the duration before now.
     *
     * @param type     Object type. The specified value must be a valid object for your organization.
     * @param duration The amount of time in minutes before now for which to return records from.
     * @return
     */
    @Operation
    public GetDeletedResult getDeleted(String type, int duration)
    {
        GetDeletedResult gdr = null;
        XMLGregorianCalendar serverTime = null;
        Soap client = login();

        try
        {
            serverTime = client.getServerTimestamp().getTimestamp();
        }
        catch (Exception e)
        {
            System.out.println("Unexpected error encountered in getTimestamp:\n\n" +
                               e.getMessage());
        }
        XMLGregorianCalendar startTime = (XMLGregorianCalendar) serverTime.clone();
        XMLGregorianCalendar endTime = serverTime;

        DatatypeFactory df = null;

        try
        {
            df = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException e)
        {
            throw new RuntimeException(e);
        }

        Duration dur = df.newDuration(false, 0, 0, 0, 0, duration, 0);

        startTime.add(dur);
        gdr = getDeletedRange(type, startTime, endTime);

        return gdr;
    }

    /**
     * Retrieves the list of individual objects that have been updated (added or changed) within the given timespan for
     * the specified object.
     *
     * @param type      Object type. The specified value must be a valid object for your organization.
     * @param startTime Starting date/time (Coordinated Universal Time (UTC) time zone�not local� timezone) of the
     *                  timespan for which to retrieve the data. The API ignores the seconds portion of the specified
     *                  dateTime value (for example, 12:30:15 is interpreted as 12:30:00 UTC).
     * @param endTime   Ending date/time (Coordinated Universal Time (UTC) time zone�not local� timezone) of the
     *                  timespan for which to retrieve the data. The API ignores the seconds portion of the specified
     *                  dateTime value (for example, 12:35:15 is interpreted as 12:35:00 UTC).
     * @return
     */
    public GetUpdatedResult getUpdatedRange(String type, XMLGregorianCalendar startTime, XMLGregorianCalendar endTime)
    {

        GetUpdatedResult gur = null;

        Soap client = login();

        try
        {
            gur = client.getUpdated(type, startTime, endTime);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return gur;
    }

    /**
     * Retrieves the list of individual objects that have been updated (added or changed) within the given from now to
     * the number of minutes previous
     *
     * @param type     Object type. The specified value must be a valid object for your organization.
     * @param duration
     * @return
     */
    @Operation
    public GetUpdatedResult getUpdated(String type, int duration)
    {

        GetUpdatedResult gur = null;
        XMLGregorianCalendar serverTime = null;
        Soap client = login();

        try
        {
            serverTime = client.getServerTimestamp().getTimestamp();
        }
        catch (Exception e)
        {
            System.out.println("Unexpected error encountered in getTimestamp:\n\n" +
                               e.getMessage());
        }
        XMLGregorianCalendar startTime = (XMLGregorianCalendar) serverTime.clone();
        XMLGregorianCalendar endTime = serverTime;

        DatatypeFactory df = null;

        try
        {
            df = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException e)
        {
            throw new RuntimeException(e);
        }

        Duration dur = df.newDuration(false, 0, 0, 0, 0, duration, 0);

        startTime.add(dur);
        gur = getUpdatedRange(type, startTime, endTime);

        return gur;
    }

    @Operation
    public List<InvalidateSessionsResult> invalidateSessions(List<String> sessionIds)
    {
        Soap client = login();

        List<InvalidateSessionsResult> results = null;
        try
        {
            results = client.invalidateSessions(sessionIds);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return results;
    }

    @Operation
    public List<ProcessResult> submitRequest(String comments, String id, List<String> approverIds)
    {

        Soap client = login();

        List<ProcessResult> processResults = null;
        ProcessSubmitRequest request = new ProcessSubmitRequest();

        request.setComments(comments);
        request.getNextApproverIds().addAll(approverIds);
        request.setObjectId(id);
        List<ProcessRequest> requests = new ArrayList<ProcessRequest>();
        requests.add(request);

        try
        {
            processResults = client.process(requests);
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }

        return processResults;
    }

    @Operation
    public List<ProcessResult> process(String action, String id, String comments, List<String> approverIds)
    {
        Soap client = login();

        List<ProcessResult> processResults = null;
        ProcessWorkitemRequest request = new ProcessWorkitemRequest();

        List<ProcessRequest> list = new ArrayList<ProcessRequest>();
        request.setComments(comments);
        request.getNextApproverIds().addAll(approverIds);
        request.setWorkitemId(id);
        request.setAction(action);
        list.add(request);

        try
        {
            processResults = client.process(list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return processResults;

    }

    /**
     * Executes a query against the specified object and returns data that matches the specified criteria.
     *
     * @param query     Query string that specifies the object to query, the fields to return, and any conditions for
     *                  including a specific object in the query.
     * @param batchsize The amount of records to return
     * @return
     */
    @Operation
    public List<SObject> query(String query, int batchsize)
    {
        Soap client = login();

        QueryResult qr = null;
        QueryOptions qo = new QueryOptions();
        qo.setBatchSize(batchsize);

        // We have already added the sessionId to the Header.HEADER_LIST so we must retrieve it first to use it.
        List<Header> headers = (List<Header>) ((BindingProvider) client).getRequestContext().get(Header.HEADER_LIST);
        if (headers == null)
        {
            throw new RuntimeException("The header list was not initialized.");
        }

        if (jQueryOptionsDataBinding == null)
        {
            try
            {
                jQueryOptionsDataBinding = new JAXBDataBinding(QueryOptions.class);
            }
            catch (JAXBException e)
            {
                throw new RuntimeException(e);
            }

        }

        headers.add(new Header(new QName("urn:partner.soap.sforce.com", "QueryOptions"), qo, jQueryOptionsDataBinding));
        ((BindingProvider) client).getRequestContext().put(Header.HEADER_LIST, headers);

        try
        {
            qr = client.query(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return qr.getRecords();
    }

    /**
     * Executes a query against the specified object and returns data that matches the specified criteria.
     *
     * @param query     Query string that specifies the object to query, the fields to return, and any conditions for
     *                  including a specific object in the query.
     * @param batchsize The amount of records to return
     * @return
     */
    public QueryResult querySObject(String query, int batchsize)
    {
        Soap client = login();

        QueryResult qr = null;
        QueryOptions qo = new QueryOptions();
        qo.setBatchSize(batchsize);

        // We have already added the sessionId to the Header.HEADER_LIST so we must retrieve it first to use it.
        List<Header> headers = (List<Header>) ((BindingProvider) client).getRequestContext().get(Header.HEADER_LIST);
        if (headers == null)
        {
            throw new RuntimeException("The header list was not initialized.");
        }

        if (jQueryOptionsDataBinding == null)
        {
            try
            {
                jQueryOptionsDataBinding = new JAXBDataBinding(QueryOptions.class);
            }
            catch (JAXBException e)
            {
                throw new RuntimeException(e);
            }

        }

        headers.add(new Header(new QName("urn:partner.soap.sforce.com", "QueryOptions"), qo, jQueryOptionsDataBinding));
        ((BindingProvider) client).getRequestContext().put(Header.HEADER_LIST, headers);

        try
        {
            qr = client.query(query);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return qr;
    }

    /**
     * Retrieves one or more records based on the specified IDs.
     *
     * @param fields List of one or more fields in the specified object, separated by commas. You must specify valid
     *               field names and must have read-level permissions to each specified field. The fieldList defines
     *               the ordering of fields in the result.
     * @param type   Object from which to retrieve data.
     * @param ids    Array of one or more IDs of the objects to retrieve. You can pass a maximum of 2000 object IDs to
     *               the retrieve() call.
     * @return
     */
    @Operation
    public List<SObject> retrieveSObjects(String fields, String type, List<String> ids)
    {
        Soap client = login();

        List<SObject> sObjects = null;

        try
        {
            sObjects = client.retrieve(fields, type, ids);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return sObjects;
    }

    /**
     * Retrieves one or more records based on the specified IDs.
     *
     * @param fields List of one or more fields in the specified object, separated by commas. You must specify valid
     *               field names and must have read-level permissions to each specified field. The fieldList defines
     *               the ordering of fields in the result.
     * @param type   Object from which to retrieve data.
     * @param ids    Array of one or more IDs of the objects to retrieve. You can pass a maximum of 2000 object IDs to
     *               the retrieve() call.
     * @return
     */
    @Operation
    public List<SObject> retrieve(String fields, String type, List<String> ids)
    {
        Soap client = login();

        List<SObject> sObjects = null;

        try
        {
            sObjects = client.retrieve(fields, type, ids);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return sObjects;
    }

    /**
     * Use this call to update one or more existing records, such as accounts or contacts, in your organization�s data.
     * The update() call is analogous to the UPDATE statement in SQL.
     *
     * @param sObjects
     * @return
     */
    @Operation
    public List<SaveResult> updateSObjects(List<SObject> sObjects)
    {

        Soap client = login();

        List<SaveResult> sr;

        try
        {
            sr = client.update(sObjects);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return sr;
    }

    /**
     * Use this call to update one or more existing records, such as accounts or contacts, in your organization�s data.
     * The update() call is analogous to the UPDATE statement in SQL.
     *
     * @param sObjects Mule specific SObject which is extends a hashmap.
     * @return
     */
    @Operation
    public List<SaveResult> update(List<SObject> sObjects)
    {

        Soap client = login();

        List<SaveResult> sr;

        try
        {
            sr = client.update(sObjects);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return sr;
    }

    /**
     * Creates new records and updates existing records; uses a custom field to determine the presence of existing
     * records. In most cases, we recommend that you use upsert() instead of create() to avoid creating unwanted
     * duplicate records (idempotent). Available in the API version 7.0 and later. You can process records for one
     * more than object type in an create() or update() call, but all records must have the same object type in an
     * upsert() call.
     *
     * @param externalIdFieldName Contains the name of the field on this object with the external ID field attribute
     *                            for custom objects or the idLookup field property for standard objects. The idLookup
     *                            field property is usually on a field that is the object's ID field or name field, but
     *                            there are exceptions, so check for the presence of the property in the object you wish
     *                            to upsert().
     * @param sObjects
     * @return
     */
    @Operation
    public List<UpsertResult> upsert(String externalIdFieldName, List<SObject> sObjects)
    {

        List<UpsertResult> ur;

        try
        {
            ur = upsertSObject(externalIdFieldName, sObjects);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return ur;
    }

    /**
     * Creates new records and updates existing records; uses a custom field to determine the presence of existing
     * records. In most cases, we recommend that you use upsert() instead of create() to avoid creating unwanted
     * duplicate records (idempotent). Available in the API version 7.0 and later. You can process records for one
     * more than object type in an create() or update() call, but all records must have the same object type in an
     * upsert() call.
     *
     * @param externalIdFieldName Contains the name of the field on this object with the external ID field attribute
     *                            for custom objects or the idLookup field property for standard objects. The idLookup
     *                            field property is usually on a field that is the object's ID field or name field, but
     *                            there are exceptions, so check for the presence of the property in the object you wish
     *                            to upsert().
     * @param sObjects
     * @return
     */
    @Operation
    public List<UpsertResult> upsertSObject(String externalIdFieldName, List<SObject> sObjects)
    {

        Soap client = login();

        List<UpsertResult> ur;

        try
        {
            ur = client.upsert(externalIdFieldName, sObjects);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return ur;
    }

    public void initialise() throws InitialisationException
    {
        try
        {
            jSessionDataBinding = new JAXBDataBinding(SessionHeader.class);
        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        }


        try
        {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        }
        catch (ParserConfigurationException e)
        {
            throw new RuntimeException(e);
        }
    }


}
