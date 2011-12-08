/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce;

import com.sforce.async.AsyncApiException;
import com.sforce.async.AsyncExceptionCode;
import com.sforce.async.BatchInfo;
import com.sforce.async.BatchRequest;
import com.sforce.async.JobInfo;
import com.sforce.async.RestConnection;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeGlobalResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.EmptyRecycleBinResult;
import com.sforce.soap.partner.GetServerTimestampResult;
import com.sforce.soap.partner.GetUserInfoResult;
import com.sforce.soap.partner.LeadConvert;
import com.sforce.soap.partner.LeadConvertResult;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.transport.SoapConnection;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesforceModuleTest {

    public static final String LEAD_ID = "001";
    public static final String MOCKED_ID = LEAD_ID;
    public static final String MOCK_OBJET_TYPE = "Account";
    public static final String MOCK_QUERY = "SELECT Id FROM Account";
    public static final String ACCOUNT_ID = "003";
    public static final String CONTACT_ID = "002";
    public static final String OPPORTUNITY_NAME = "NAME";
    public static final String CONVERTED_STATUS = "STATUS";
    public static final String FIRST_NAME_FIELD = "FirstName";
    public static final String LAST_NAME_FIELD = "LastName";
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";

    @Test
    public void testCreate() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        List<SaveResult> saveResults = module.create(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(saveResults.get(0), saveResult);
    }

    @Test
    public void testCreateSingle() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);

        SaveResult returnedSaveResult = module.createSingle(MOCK_OBJET_TYPE, sObject);

        assertEquals(returnedSaveResult, saveResult);
    }

    @Test
    public void testCreateSingleWithNoSaveResults() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{});
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);

        SaveResult returnedSaveResult = module.createSingle(MOCK_OBJET_TYPE, sObject);

        assertNull(returnedSaveResult);
    }

    @Test
    public void testIsNotConnectedWhenConnectionIsNull() throws Exception {
        SalesforceModule module = new SalesforceModule();

        assertFalse(module.isConnected());
    }

    @Test
    public void testIsNotConnectedWhenLoginResultIsNull() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);

        assertFalse(module.isConnected());
    }

    @Test
    public void testIsConnected() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        LoginResult loginResult = Mockito.mock(LoginResult.class);
        module.setConnection(partnerConnection);
        module.setLoginResult(loginResult);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        when(loginResult.getSessionId()).thenReturn(MOCKED_ID);

        assertTrue(module.isConnected());
    }

    @Test
    public void testGetSessionId() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        LoginResult loginResult = Mockito.mock(LoginResult.class);
        module.setConnection(partnerConnection);
        module.setLoginResult(loginResult);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        when(loginResult.getSessionId()).thenReturn(MOCKED_ID);

        assertEquals(module.getSessionId(), MOCKED_ID);
    }

    @Test
    public void testDestroySession() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.update(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        List<SaveResult> saveResults = module.update(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(saveResults.get(0), saveResult);
    }

    @Test
    public void testDescribeGlobal() throws Exception {
        SalesforceModule module = new SalesforceModule();
        DescribeGlobalResult describeGlobalResult = Mockito.mock(DescribeGlobalResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);

        when(partnerConnection.describeGlobal()).thenReturn(describeGlobalResult);

        module.describeGlobal();

        verify(partnerConnection).describeGlobal();
    }

    @Test
    public void testQuery() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SObject sObject1 = Mockito.mock(SObject.class);
        SObject sObject2 = Mockito.mock(SObject.class);
        QueryResult queryResult1 = Mockito.mock(QueryResult.class);
        when(queryResult1.getRecords()).thenReturn(new SObject[]{sObject1});
        when(queryResult1.isDone()).thenReturn(false);
        when(queryResult1.getQueryLocator()).thenReturn("001");
        QueryResult queryResult2 = Mockito.mock(QueryResult.class);
        when(queryResult2.getRecords()).thenReturn(new SObject[]{sObject2});
        when(queryResult2.isDone()).thenReturn(true);
        when(queryResult2.getQueryLocator()).thenReturn("001");
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);

        when(partnerConnection.query(eq(MOCK_QUERY))).thenReturn(queryResult1);
        when(partnerConnection.queryMore(eq("001"))).thenReturn(queryResult2);

        List<Map<String, Object>> result = module.query(MOCK_QUERY);

        assertEquals(2, result.size());
    }

    @Test
    public void testQuerySingle() throws Exception {
        SalesforceModule module = new SalesforceModule();
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        when(queryResult.getRecords()).thenReturn(new SObject[]{});
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);

        when(partnerConnection.query(eq(MOCK_QUERY))).thenReturn(queryResult);

        module.querySingle(MOCK_QUERY);
    }

    @Test
    public void testQuerySingleNoResults() throws Exception {
        SalesforceModule module = new SalesforceModule();
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        SObject sObject = Mockito.mock(SObject.class);
        when(queryResult.getRecords()).thenReturn(new SObject[]{sObject});
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);

        when(partnerConnection.query(eq(MOCK_QUERY))).thenReturn(queryResult);

        module.querySingle(MOCK_QUERY);

        verify(sObject, atLeastOnce()).toMap();
    }

    @Test
    public void testEmptyRecycleBin() throws Exception {
        SalesforceModule module = new SalesforceModule();
        EmptyRecycleBinResult emptyRecycleBinResult = Mockito.mock(EmptyRecycleBinResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);


        when(partnerConnection.emptyRecycleBin(argThat(new StringArrayMatcher()))).thenReturn(new EmptyRecycleBinResult[]{emptyRecycleBinResult});

        List<String> ids = new ArrayList<String>();
        ids.add(MOCKED_ID);

        module.emptyRecycleBin(ids);
    }

    @Test
    public void testDelete() throws Exception {
        SalesforceModule module = new SalesforceModule();
        DeleteResult deleteResult = Mockito.mock(DeleteResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);


        when(partnerConnection.delete(argThat(new StringArrayMatcher()))).thenReturn(new DeleteResult[]{deleteResult});

        List<String> ids = new ArrayList<String>();
        ids.add(MOCKED_ID);

        module.delete(ids);
    }

    @Test
    public void testDescribeSObject() throws Exception {
        SalesforceModule module = new SalesforceModule();
        DescribeSObjectResult describeSObjectResult = Mockito.mock(DescribeSObjectResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);


        when(partnerConnection.describeSObject(eq(MOCK_OBJET_TYPE))).thenReturn(describeSObjectResult);

        module.describeSObject(MOCK_OBJET_TYPE);
    }

    /*
    @Test
    public void testBatchSplitter() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        SourceCallback sourceCallback = Mockito.mock(SourceCallback.class);

        List<Map<String, Object>> objects = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> object = new HashMap<String, Object>();
            objects.add(object);
        }

        module.batchSplitter(200, objects, sourceCallback);

        verify(sourceCallback, times(5)).process(any());
    }
    */

    @Test
    public void testCreateBulk() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        JobInfo jobInfo = Mockito.mock(JobInfo.class);
        BatchRequest batchRequest = Mockito.mock(BatchRequest.class);
        BatchInfo batchInfo = Mockito.mock(BatchInfo.class);
        doReturn(jobInfo).when(restConnection).createJob(any(JobInfo.class));
        doReturn(batchRequest).when(restConnection).createBatch(any(JobInfo.class));
        doReturn(batchInfo).when(batchRequest).completeRequest();

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        BatchInfo returnedBatchInfo = module.createBulk(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(batchInfo, returnedBatchInfo);
    }

    @Test
    public void testUpdateBulk() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        JobInfo jobInfo = Mockito.mock(JobInfo.class);
        BatchRequest batchRequest = Mockito.mock(BatchRequest.class);
        BatchInfo batchInfo = Mockito.mock(BatchInfo.class);
        doReturn(jobInfo).when(restConnection).createJob(any(JobInfo.class));
        doReturn(batchRequest).when(restConnection).createBatch(any(JobInfo.class));
        doReturn(batchInfo).when(batchRequest).completeRequest();

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        BatchInfo returnedBatchInfo = module.updateBulk(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(batchInfo, returnedBatchInfo);
    }

    @Test
    public void testUpsertBulk() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        JobInfo jobInfo = Mockito.mock(JobInfo.class);
        BatchRequest batchRequest = Mockito.mock(BatchRequest.class);
        BatchInfo batchInfo = Mockito.mock(BatchInfo.class);
        doReturn(jobInfo).when(restConnection).createJob(any(JobInfo.class));
        doReturn(batchRequest).when(restConnection).createBatch(any(JobInfo.class));
        doReturn(batchInfo).when(batchRequest).completeRequest();

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        BatchInfo returnedBatchInfo = module.upsertBulk(MOCK_OBJET_TYPE, "X_c", sObjectList);

        assertEquals(batchInfo, returnedBatchInfo);
    }

    @Test
    public void testPublishTopic() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        when(saveResult.isSuccess()).thenReturn(true);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        when(partnerConnection.query(eq("SELECT Id FROM PushTopic WHERE Name = 'TopicName'"))).thenReturn(queryResult);
        when(queryResult.getSize()).thenReturn(0);

        module.publishTopic("TopicName", "SELECT * FROM Account", "Description");

        verify(partnerConnection, atLeastOnce()).create(Mockito.argThat(new SObjectArrayMatcher()));
    }

    @Test
    public void testPublishTopicAlreadyExists() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        when(saveResult.isSuccess()).thenReturn(true);
        when(partnerConnection.update(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        when(partnerConnection.query(eq("SELECT Id FROM PushTopic WHERE Name = 'TopicName'"))).thenReturn(queryResult);
        when(queryResult.getSize()).thenReturn(1);
        SObject sObject = Mockito.mock(SObject.class);
        when(queryResult.getRecords()).thenReturn(new SObject[]{sObject});

        module.publishTopic("TopicName", "SELECT * FROM Account", "Description");

        verify(partnerConnection, atLeastOnce()).update(Mockito.argThat(new SObjectArrayMatcher()));
    }

    @Test
    public void testGetUserInfo() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        GetUserInfoResult getUserInfoResult = Mockito.mock(GetUserInfoResult.class);
        when(partnerConnection.getUserInfo()).thenReturn(getUserInfoResult);

        assertEquals(getUserInfoResult, module.getUserInfo());
    }

    @Test
    public void testGetDeletedRange() throws Exception {
        SalesforceModule module = spy(new SalesforceModule());
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        GetServerTimestampResult getServerTimestampResult = Mockito.mock(GetServerTimestampResult.class);
        when(partnerConnection.getServerTimestamp()).thenReturn(getServerTimestampResult);

        module.getDeletedRange("Account", Calendar.getInstance(), Calendar.getInstance());

        verify(partnerConnection, atLeastOnce()).getDeleted(eq("Account"), any(Calendar.class), any(Calendar.class));
    }

    @Test
    public void testGetDeleted() throws Exception {
        SalesforceModule module = spy(new SalesforceModule());
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        GetServerTimestampResult getServerTimestampResult = Mockito.mock(GetServerTimestampResult.class);
        when(partnerConnection.getServerTimestamp()).thenReturn(getServerTimestampResult);
        when(getServerTimestampResult.getTimestamp()).thenReturn(Calendar.getInstance());

        module.getDeleted("Account", 30);

        verify(partnerConnection, atLeastOnce()).getDeleted(eq("Account"), any(Calendar.class), any(Calendar.class));
    }

    @Test(expected = SoapConnection.SessionTimedOutException.class)
    public void testCreateBulkWithTimeOutException() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        module.setConnection(partnerConnection);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        JobInfo jobInfo = Mockito.mock(JobInfo.class);
        BatchRequest batchRequest = Mockito.mock(BatchRequest.class);
        AsyncApiException exception = Mockito.mock(AsyncApiException.class);
        doReturn(AsyncExceptionCode.InvalidSessionId).when(exception).getExceptionCode();
        doReturn(jobInfo).when(restConnection).createJob(any(JobInfo.class));
        doReturn(batchRequest).when(restConnection).createBatch(any(JobInfo.class));
        doThrow(exception).when(batchRequest).completeRequest();

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put(FIRST_NAME_FIELD, FIRST_NAME);
        sObject.put(LAST_NAME_FIELD, LAST_NAME);
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        BatchInfo returnedBatchInfo = module.createBulk(MOCK_OBJET_TYPE, sObjectList);
    }

    @Test
    public void testDestroySessionWithNull() throws Exception {
        SalesforceModule module = new SalesforceModule();
        module.destroySession();
    }

    @Test
    public void testDestroySessionWithNullBayeuxClient() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        LoginResult loginResult = Mockito.mock(LoginResult.class);
        module.setLoginResult(loginResult);

        module.destroySession();

        verify(partnerConnection, atLeastOnce()).logout();

        assertNull(module.getConnection());
        assertNull(module.getLoginResult());
    }

    @Test
    public void testDestroySessionWithBayeuxClient() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SalesforceBayeuxClient salesforceBayeuxClient = Mockito.mock(SalesforceBayeuxClient.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setBayeuxClient(salesforceBayeuxClient);
        module.setConnection(partnerConnection);
        LoginResult loginResult = Mockito.mock(LoginResult.class);
        module.setLoginResult(loginResult);
        when(salesforceBayeuxClient.isConnected()).thenReturn(true);

        module.destroySession();

        verify(salesforceBayeuxClient, atLeastOnce()).disconnect();

        assertNull(module.getConnection());
        assertNull(module.getLoginResult());
    }

    @Test
    public void testConvertLead() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);
        LeadConvertResult result = Mockito.mock(LeadConvertResult.class);

        when(partnerConnection.convertLead(argThat(new Matcher<LeadConvert[]>() {
            @Override
            public boolean matches(Object o) {
                if (!o.getClass().isArray()) {
                    return false;
                }

                Object[] oArray = (Object[]) o;
                if (oArray.length != 1) {
                    return false;
                }

                if (!(oArray[0] instanceof LeadConvert)) {
                    return false;
                }

                LeadConvert leadConvert = (LeadConvert) oArray[0];

                if (!leadConvert.getAccountId().equals(ACCOUNT_ID)) {
                    return false;
                }

                if (!leadConvert.getContactId().equals(CONTACT_ID)) {
                    return false;
                }

                if (!leadConvert.getLeadId().equals(LEAD_ID)) {
                    return false;
                }

                if (!leadConvert.getOpportunityName().equals(OPPORTUNITY_NAME)) {
                    return false;
                }

                if (!leadConvert.getOverwriteLeadSource()) {
                    return false;
                }

                if (!leadConvert.getDoNotCreateOpportunity()) {
                    return false;
                }

                if (!leadConvert.getSendNotificationEmail()) {
                    return false;
                }

                return true;
            }

            @Override
            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
            }

            @Override
            public void describeTo(Description description) {
            }
        }))).thenReturn(new LeadConvertResult[]{result});

        module.convertLead(LEAD_ID, CONTACT_ID, ACCOUNT_ID, true, true, OPPORTUNITY_NAME, CONVERTED_STATUS, true);
    }

    @Test
    public void testCreateConnectorConfig() throws Exception {
        SalesforceModule module = new SalesforceModule();

        ConnectorConfig config = module.createConnectorConfig(new URL("http://www.salesforce.com"), "username", "password", "", 0, "", "");

        assertEquals(config.getUsername(), "username");
        assertEquals(config.getPassword(), "password");
        assertEquals(config.getAuthEndpoint(), "http://www.salesforce.com");
        assertEquals(config.getServiceEndpoint(), "http://www.salesforce.com");
        assertTrue(config.isManualLogin());
        assertFalse(config.isCompression());
    }

    @Test
    public void testCreateConnectorConfigWithProxy() throws Exception {
        SalesforceModule module = new SalesforceModule();

        ConnectorConfig config = module.createConnectorConfig(new URL("http://www.salesforce.com"), "username", "password", "proxyhost", 80, "aa", "bb");

        assertEquals(config.getUsername(), "username");
        assertEquals(config.getPassword(), "password");
        assertEquals(config.getAuthEndpoint(), "http://www.salesforce.com");
        assertEquals(config.getServiceEndpoint(), "http://www.salesforce.com");
        assertTrue(config.isManualLogin());
        assertFalse(config.isCompression());

        assertEquals(config.getProxyUsername(), "aa");
        assertEquals(config.getProxyPassword(), "bb");
    }

}
