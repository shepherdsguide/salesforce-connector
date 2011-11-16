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
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.transport.SoapConnection;
import org.cometd.client.BayeuxClient;
import org.junit.Test;
import org.mockito.Mockito;
import org.mule.api.callback.SourceCallback;

import java.util.ArrayList;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesforceModuleTest {

    public static final String MOCKED_ID = "001";
    public static final String MOCK_OBJET_TYPE = "Account";
    public static final String MOCK_QUERY = "SELECT Id FROM Account";

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
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");
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
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");

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
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");

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
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");
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
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        when(queryResult.getRecords()).thenReturn(new SObject[]{});
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        RestConnection restConnection = Mockito.mock(RestConnection.class);
        module.setRestConnection(restConnection);
        module.setConnection(partnerConnection);

        when(partnerConnection.query(eq(MOCK_QUERY))).thenReturn(queryResult);

        module.query(MOCK_QUERY);
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
    public void testConvertLead() throws Exception {

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
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        BatchInfo returnedBatchInfo = module.createBulk(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(batchInfo, returnedBatchInfo);
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
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");
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
        when(salesforceBayeuxClient.isConnected()).thenReturn(true);

        module.destroySession();

        verify(salesforceBayeuxClient, atLeastOnce()).disconnect();

        assertNull(module.getConnection());
        assertNull(module.getLoginResult());
    }

}
