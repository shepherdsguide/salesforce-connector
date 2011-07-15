package com.sforce.soap.partner;

import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.bind.XMLizable;
import com.sforce.ws.bind.TypeMapper;

import java.util.HashMap;

import javax.xml.namespace.QName;

/**
 * Generated class, please do not edit.
 */
public class PartnerConnection {

  private TypeMapper __typeMapper = new TypeMapper();
  private ConnectorConfig __config;
  private HashMap<QName, XMLizable> __extraHeaders = new HashMap<QName, XMLizable>();

  public ConnectorConfig getConfig() {
    return __config;
  }

  
  private com.sforce.soap.partner.StreamingEnabledHeader_element __StreamingEnabledHeader;

  public void setStreamingEnabledHeader(boolean streamingEnabled) {
    __StreamingEnabledHeader = new com.sforce.soap.partner.StreamingEnabledHeader_element();
     
       __StreamingEnabledHeader.setStreamingEnabled(streamingEnabled);
  }

  public void clearStreamingEnabledHeader() {
    __StreamingEnabledHeader = null;
  }

  public com.sforce.soap.partner.StreamingEnabledHeader_element getStreamingEnabledHeader() {
    return  __StreamingEnabledHeader;
  }

  public void __setStreamingEnabledHeader(com.sforce.soap.partner.StreamingEnabledHeader_element __header) {
    __StreamingEnabledHeader = __header ;
  }

  
  private MruHeader_element __MruHeader;

  public void setMruHeader(boolean updateMru) {
    __MruHeader = new MruHeader_element();
     
       __MruHeader.setUpdateMru(updateMru);
  }

  public void clearMruHeader() {
    __MruHeader = null;
  }

  public MruHeader_element getMruHeader() {
    return  __MruHeader;
  }

  public void __setMruHeader(MruHeader_element __header) {
    __MruHeader = __header ;
  }

  
  private CallOptions_element __CallOptions;

  public void setCallOptions(String client,String defaultNamespace) {
    __CallOptions = new CallOptions_element();
     
       __CallOptions.setClient(client);
       __CallOptions.setDefaultNamespace(defaultNamespace);
  }

  public void clearCallOptions() {
    __CallOptions = null;
  }

  public CallOptions_element getCallOptions() {
    return  __CallOptions;
  }

  public void __setCallOptions(CallOptions_element __header) {
    __CallOptions = __header ;
  }

  
  private PackageVersionHeader_element __PackageVersionHeader;

  public void setPackageVersionHeader(PackageVersion[] packageVersions) {
    __PackageVersionHeader = new PackageVersionHeader_element();
     
       __PackageVersionHeader.setPackageVersions(packageVersions);
  }

  public void clearPackageVersionHeader() {
    __PackageVersionHeader = null;
  }

  public PackageVersionHeader_element getPackageVersionHeader() {
    return  __PackageVersionHeader;
  }

  public void __setPackageVersionHeader(PackageVersionHeader_element __header) {
    __PackageVersionHeader = __header ;
  }

  
  private LocaleOptions_element __LocaleOptions;

  public void setLocaleOptions(String language) {
    __LocaleOptions = new LocaleOptions_element();
     
       __LocaleOptions.setLanguage(language);
  }

  public void clearLocaleOptions() {
    __LocaleOptions = null;
  }

  public LocaleOptions_element getLocaleOptions() {
    return  __LocaleOptions;
  }

  public void __setLocaleOptions(LocaleOptions_element __header) {
    __LocaleOptions = __header ;
  }

  
  private EmailHeader_element __EmailHeader;

  public void setEmailHeader(boolean triggerAutoResponseEmail,boolean triggerOtherEmail,boolean triggerUserEmail) {
    __EmailHeader = new EmailHeader_element();
     
       __EmailHeader.setTriggerAutoResponseEmail(triggerAutoResponseEmail);
       __EmailHeader.setTriggerOtherEmail(triggerOtherEmail);
       __EmailHeader.setTriggerUserEmail(triggerUserEmail);
  }

  public void clearEmailHeader() {
    __EmailHeader = null;
  }

  public EmailHeader_element getEmailHeader() {
    return  __EmailHeader;
  }

  public void __setEmailHeader(EmailHeader_element __header) {
    __EmailHeader = __header ;
  }

  
  private DebuggingInfo_element __DebuggingInfo;

  public void setDebuggingInfo(String debugLog) {
    __DebuggingInfo = new DebuggingInfo_element();
     
       __DebuggingInfo.setDebugLog(debugLog);
  }

  public void clearDebuggingInfo() {
    __DebuggingInfo = null;
  }

  public DebuggingInfo_element getDebuggingInfo() {
    return  __DebuggingInfo;
  }

  public void __setDebuggingInfo(DebuggingInfo_element __header) {
    __DebuggingInfo = __header ;
  }

  
  private com.sforce.soap.partner.SessionHeader_element __SessionHeader;

  public void setSessionHeader(String sessionId) {
    __SessionHeader = new com.sforce.soap.partner.SessionHeader_element();
     
       __SessionHeader.setSessionId(sessionId);
  }

  public void clearSessionHeader() {
    __SessionHeader = null;
  }

  public com.sforce.soap.partner.SessionHeader_element getSessionHeader() {
    return  __SessionHeader;
  }

  public void __setSessionHeader(com.sforce.soap.partner.SessionHeader_element __header) {
    __SessionHeader = __header ;
  }

  
  private DebuggingHeader_element __DebuggingHeader;

  public void setDebuggingHeader(DebugLevel debugLevel) {
    __DebuggingHeader = new DebuggingHeader_element();
     
       __DebuggingHeader.setDebugLevel(debugLevel);
  }

  public void clearDebuggingHeader() {
    __DebuggingHeader = null;
  }

  public DebuggingHeader_element getDebuggingHeader() {
    return  __DebuggingHeader;
  }

  public void __setDebuggingHeader(DebuggingHeader_element __header) {
    __DebuggingHeader = __header ;
  }

  
  private LoginScopeHeader_element __LoginScopeHeader;

  public void setLoginScopeHeader(String organizationId,String portalId) {
    __LoginScopeHeader = new LoginScopeHeader_element();
     
       __LoginScopeHeader.setOrganizationId(organizationId);
       __LoginScopeHeader.setPortalId(portalId);
  }

  public void clearLoginScopeHeader() {
    __LoginScopeHeader = null;
  }

  public LoginScopeHeader_element getLoginScopeHeader() {
    return  __LoginScopeHeader;
  }

  public void __setLoginScopeHeader(LoginScopeHeader_element __header) {
    __LoginScopeHeader = __header ;
  }

  
  private DisableFeedTrackingHeader_element __DisableFeedTrackingHeader;

  public void setDisableFeedTrackingHeader(boolean disableFeedTracking) {
    __DisableFeedTrackingHeader = new DisableFeedTrackingHeader_element();
     
       __DisableFeedTrackingHeader.setDisableFeedTracking(disableFeedTracking);
  }

  public void clearDisableFeedTrackingHeader() {
    __DisableFeedTrackingHeader = null;
  }

  public DisableFeedTrackingHeader_element getDisableFeedTrackingHeader() {
    return  __DisableFeedTrackingHeader;
  }

  public void __setDisableFeedTrackingHeader(DisableFeedTrackingHeader_element __header) {
    __DisableFeedTrackingHeader = __header ;
  }

  
  private com.sforce.soap.partner.UserTerritoryDeleteHeader_element __UserTerritoryDeleteHeader;

  public void setUserTerritoryDeleteHeader(String transferToUserId) {
    __UserTerritoryDeleteHeader = new com.sforce.soap.partner.UserTerritoryDeleteHeader_element();
     
       __UserTerritoryDeleteHeader.setTransferToUserId(transferToUserId);
  }

  public void clearUserTerritoryDeleteHeader() {
    __UserTerritoryDeleteHeader = null;
  }

  public com.sforce.soap.partner.UserTerritoryDeleteHeader_element getUserTerritoryDeleteHeader() {
    return  __UserTerritoryDeleteHeader;
  }

  public void __setUserTerritoryDeleteHeader(com.sforce.soap.partner.UserTerritoryDeleteHeader_element __header) {
    __UserTerritoryDeleteHeader = __header ;
  }

  
  private AllowFieldTruncationHeader_element __AllowFieldTruncationHeader;

  public void setAllowFieldTruncationHeader(boolean allowFieldTruncation) {
    __AllowFieldTruncationHeader = new AllowFieldTruncationHeader_element();
     
       __AllowFieldTruncationHeader.setAllowFieldTruncation(allowFieldTruncation);
  }

  public void clearAllowFieldTruncationHeader() {
    __AllowFieldTruncationHeader = null;
  }

  public AllowFieldTruncationHeader_element getAllowFieldTruncationHeader() {
    return  __AllowFieldTruncationHeader;
  }

  public void __setAllowFieldTruncationHeader(AllowFieldTruncationHeader_element __header) {
    __AllowFieldTruncationHeader = __header ;
  }

  
  private com.sforce.soap.partner.QueryOptions_element __QueryOptions;

  public void setQueryOptions(int batchSize) {
    __QueryOptions = new com.sforce.soap.partner.QueryOptions_element();
     
       __QueryOptions.setBatchSize(batchSize);
  }

  public void clearQueryOptions() {
    __QueryOptions = null;
  }

  public com.sforce.soap.partner.QueryOptions_element getQueryOptions() {
    return  __QueryOptions;
  }

  public void __setQueryOptions(com.sforce.soap.partner.QueryOptions_element __header) {
    __QueryOptions = __header ;
  }

  
  private AssignmentRuleHeader_element __AssignmentRuleHeader;

  public void setAssignmentRuleHeader(String assignmentRuleId,Boolean useDefaultRule) {
    __AssignmentRuleHeader = new AssignmentRuleHeader_element();
     
       __AssignmentRuleHeader.setAssignmentRuleId(assignmentRuleId);
       __AssignmentRuleHeader.setUseDefaultRule(useDefaultRule);
  }

  public void clearAssignmentRuleHeader() {
    __AssignmentRuleHeader = null;
  }

  public AssignmentRuleHeader_element getAssignmentRuleHeader() {
    return  __AssignmentRuleHeader;
  }

  public void __setAssignmentRuleHeader(AssignmentRuleHeader_element __header) {
    __AssignmentRuleHeader = __header ;
  }

  
  private AllOrNoneHeader_element __AllOrNoneHeader;

  public void setAllOrNoneHeader(boolean allOrNone) {
    __AllOrNoneHeader = new AllOrNoneHeader_element();
     
       __AllOrNoneHeader.setAllOrNone(allOrNone);
  }

  public void clearAllOrNoneHeader() {
    __AllOrNoneHeader = null;
  }

  public AllOrNoneHeader_element getAllOrNoneHeader() {
    return  __AllOrNoneHeader;
  }

  public void __setAllOrNoneHeader(AllOrNoneHeader_element __header) {
    __AllOrNoneHeader = __header ;
  }

  

  public PartnerConnection(ConnectorConfig config) throws ConnectionException {
    this.__config = config;
    this.__typeMapper.setPackagePrefix(null);
    this.__typeMapper.setConfig(config);

    
    config.verifyPartnerEndpoint();
    if (!config.isManualLogin()) {
      if (config.getSessionId()==null) {
        config.setServiceEndpoint(config.getAuthEndpoint());
        LoginResult result = login(config.getUsername(), config.getPassword());
        config.setSessionId(result.getSessionId());
        config.setServiceEndpoint(result.getServerUrl());
      } else {
        if (config.getServiceEndpoint() == null) {
          throw new ConnectionException("Please set ServiceEndpoint");
        }
      }
    }
    

    
      __SessionHeader = new SessionHeader_element();
      __SessionHeader.setSessionId(config.getSessionId());
    
  }

  private com.sforce.ws.transport.SoapConnection newConnection() {
      com.sforce.ws.transport.SoapConnection __c   = new com.sforce.ws.transport.SoapConnection(
           __config.getServiceEndpoint(), "urn:sobject.partner.soap.sforce.com", __typeMapper, __config);

      __c.setConnection(this);
      __c.setKnownHeaders(knownHeaders);
      return __c;
   }

  
  public LeadConvertResult[] convertLead(LeadConvert[] leadConverts)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    ConvertLead_element __request = new ConvertLead_element();
    ConvertLeadResponse_element __response = new ConvertLeadResponse_element();

  
    __request.setLeadConverts(leadConverts);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (ConvertLeadResponse_element) __connection.send("",
       convertLead_qname, __request, convertLeadResponse_qname,
       ConvertLeadResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeDataCategoryGroupStructureResult[] describeDataCategoryGroupStructures(DataCategoryGroupSobjectTypePair[] pairs,boolean topCategoriesOnly)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeDataCategoryGroupStructures_element __request = new DescribeDataCategoryGroupStructures_element();
    DescribeDataCategoryGroupStructuresResponse_element __response = new DescribeDataCategoryGroupStructuresResponse_element();

  
    __request.setPairs(pairs);
    __request.setTopCategoriesOnly(topCategoriesOnly);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (DescribeDataCategoryGroupStructuresResponse_element) __connection.send("",
       describeDataCategoryGroupStructures_qname, __request, describeDataCategoryGroupStructuresResponse_qname,
       DescribeDataCategoryGroupStructuresResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.SendEmailResult[] sendEmail(Email[] messages)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.SendEmail_element __request = new com.sforce.soap.partner.SendEmail_element();
    com.sforce.soap.partner.SendEmailResponse_element __response = new com.sforce.soap.partner.SendEmailResponse_element();

  
    __request.setMessages(messages);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.SendEmailResponse_element) __connection.send("",
       sendEmail_qname, __request, sendEmailResponse_qname,
       com.sforce.soap.partner.SendEmailResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeGlobalResult describeGlobal()
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeGlobal_element __request = new DescribeGlobal_element();
    DescribeGlobalResponse_element __response = new DescribeGlobalResponse_element();

  

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (DescribeGlobalResponse_element) __connection.send("",
       describeGlobal_qname, __request, describeGlobalResponse_qname,
       DescribeGlobalResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.sobject.SObject[] retrieve(String fieldList,String sObjectType,String[] ids)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Retrieve_element __request = new com.sforce.soap.partner.Retrieve_element();
    com.sforce.soap.partner.RetrieveResponse_element __response = new com.sforce.soap.partner.RetrieveResponse_element();

  
    __request.setFieldList(fieldList);
    __request.setSObjectType(sObjectType);
    __request.setIds(ids);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__QueryOptions != null) __connection.addHeader(QueryOptions_qname, __QueryOptions);
    
    if (__MruHeader != null) __connection.addHeader(MruHeader_qname, __MruHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.RetrieveResponse_element) __connection.send("",
       retrieve_qname, __request, retrieveResponse_qname,
       com.sforce.soap.partner.RetrieveResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeLayoutResult describeLayout(String sObjectType,String[] recordTypeIds)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeLayout_element __request = new DescribeLayout_element();
    DescribeLayoutResponse_element __response = new DescribeLayoutResponse_element();

  
    __request.setSObjectType(sObjectType);
    __request.setRecordTypeIds(recordTypeIds);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (DescribeLayoutResponse_element) __connection.send("",
       describeLayout_qname, __request, describeLayoutResponse_qname,
       DescribeLayoutResponse_element.class);

    return __response.getResult();
  }
  
  public EmptyRecycleBinResult[] emptyRecycleBin(String[] ids)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    EmptyRecycleBin_element __request = new EmptyRecycleBin_element();
    EmptyRecycleBinResponse_element __response = new EmptyRecycleBinResponse_element();

  
    __request.setIds(ids);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (EmptyRecycleBinResponse_element) __connection.send("",
       emptyRecycleBin_qname, __request, emptyRecycleBinResponse_qname,
       EmptyRecycleBinResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.ProcessResult[] process(com.sforce.soap.partner.ProcessRequest[] actions)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Process_element __request = new com.sforce.soap.partner.Process_element();
    com.sforce.soap.partner.ProcessResponse_element __response = new com.sforce.soap.partner.ProcessResponse_element();

  
    __request.setActions(actions);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.ProcessResponse_element) __connection.send("",
       process_qname, __request, processResponse_qname,
       com.sforce.soap.partner.ProcessResponse_element.class);

    return __response.getResult();
  }
  
  public void logout()
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    Logout_element __request = new Logout_element();
    LogoutResponse_element __response = new LogoutResponse_element();

  

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (LogoutResponse_element) __connection.send("",
       logout_qname, __request, logoutResponse_qname,
       LogoutResponse_element.class);

    
  }
  
  public com.sforce.soap.partner.SaveResult[] create(com.sforce.soap.partner.sobject.SObject[] sObjects)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    Create_element __request = new Create_element();
    CreateResponse_element __response = new CreateResponse_element();

  
    __request.setSObjects(sObjects);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AssignmentRuleHeader != null) __connection.addHeader(AssignmentRuleHeader_qname, __AssignmentRuleHeader);
    
    if (__MruHeader != null) __connection.addHeader(MruHeader_qname, __MruHeader);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__AllOrNoneHeader != null) __connection.addHeader(AllOrNoneHeader_qname, __AllOrNoneHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__EmailHeader != null) __connection.addHeader(EmailHeader_qname, __EmailHeader);
    

    addHeaders(__connection);

    __response = (CreateResponse_element) __connection.send("",
       create_qname, __request, createResponse_qname,
       CreateResponse_element.class);

    return __response.getResult();
  }
  
  public InvalidateSessionsResult[] invalidateSessions(String[] sessionIds)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    InvalidateSessions_element __request = new InvalidateSessions_element();
    InvalidateSessionsResponse_element __response = new InvalidateSessionsResponse_element();

  
    __request.setSessionIds(sessionIds);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (InvalidateSessionsResponse_element) __connection.send("",
       invalidateSessions_qname, __request, invalidateSessionsResponse_qname,
       InvalidateSessionsResponse_element.class);

    return __response.getResult();
  }
  
  public GetUserInfoResult getUserInfo()
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    GetUserInfo_element __request = new GetUserInfo_element();
    GetUserInfoResponse_element __response = new GetUserInfoResponse_element();

  

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (GetUserInfoResponse_element) __connection.send("",
       getUserInfo_qname, __request, getUserInfoResponse_qname,
       GetUserInfoResponse_element.class);

    return __response.getResult();
  }
  
  public GetServerTimestampResult getServerTimestamp()
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    GetServerTimestamp_element __request = new GetServerTimestamp_element();
    GetServerTimestampResponse_element __response = new GetServerTimestampResponse_element();

  

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (GetServerTimestampResponse_element) __connection.send("",
       getServerTimestamp_qname, __request, getServerTimestampResponse_qname,
       GetServerTimestampResponse_element.class);

    return __response.getResult();
  }
  
  public GetDeletedResult getDeleted(String sObjectType,java.util.Calendar startDate,java.util.Calendar endDate)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    GetDeleted_element __request = new GetDeleted_element();
    GetDeletedResponse_element __response = new GetDeletedResponse_element();

  
    __request.setSObjectType(sObjectType);
    __request.setStartDate(startDate);
    __request.setEndDate(endDate);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (GetDeletedResponse_element) __connection.send("",
       getDeleted_qname, __request, getDeletedResponse_qname,
       GetDeletedResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.SetPasswordResult setPassword(String userId,String password)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.SetPassword_element __request = new com.sforce.soap.partner.SetPassword_element();
    com.sforce.soap.partner.SetPasswordResponse_element __response = new com.sforce.soap.partner.SetPasswordResponse_element();

  
    __request.setUserId(userId);
    __request.setPassword(password);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.SetPasswordResponse_element) __connection.send("",
       setPassword_qname, __request, setPasswordResponse_qname,
       com.sforce.soap.partner.SetPasswordResponse_element.class);

    return __response.getResult();
  }
  
  public DeleteResult[] delete(String[] ids)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    Delete_element __request = new Delete_element();
    DeleteResponse_element __response = new DeleteResponse_element();

  
    __request.setIds(ids);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__UserTerritoryDeleteHeader != null) __connection.addHeader(UserTerritoryDeleteHeader_qname, __UserTerritoryDeleteHeader);
    
    if (__EmailHeader != null) __connection.addHeader(EmailHeader_qname, __EmailHeader);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__AllOrNoneHeader != null) __connection.addHeader(AllOrNoneHeader_qname, __AllOrNoneHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    

    addHeaders(__connection);

    __response = (DeleteResponse_element) __connection.send("",
       delete_qname, __request, deleteResponse_qname,
       DeleteResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeTabSetResult[] describeTabs()
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeTabs_element __request = new DescribeTabs_element();
    DescribeTabsResponse_element __response = new DescribeTabsResponse_element();

  

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (DescribeTabsResponse_element) __connection.send("",
       describeTabs_qname, __request, describeTabsResponse_qname,
       DescribeTabsResponse_element.class);

    return __response.getResult();
  }
  
  public LoginResult login(String username,String password)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    Login_element __request = new Login_element();
    LoginResponse_element __response = new LoginResponse_element();

  
    __request.setUsername(username);
    __request.setPassword(password);

    
    if (__LoginScopeHeader != null) __connection.addHeader(LoginScopeHeader_qname, __LoginScopeHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (LoginResponse_element) __connection.send("",
       login_qname, __request, loginResponse_qname,
       LoginResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.SearchResult search(String searchString)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Search_element __request = new com.sforce.soap.partner.Search_element();
    com.sforce.soap.partner.SearchResponse_element __response = new com.sforce.soap.partner.SearchResponse_element();

  
    __request.setSearchString(searchString);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.SearchResponse_element) __connection.send("",
       search_qname, __request, searchResponse_qname,
       com.sforce.soap.partner.SearchResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.QueryResult queryMore(String queryLocator)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.QueryMore_element __request = new com.sforce.soap.partner.QueryMore_element();
    com.sforce.soap.partner.QueryMoreResponse_element __response = new com.sforce.soap.partner.QueryMoreResponse_element();

  
    __request.setQueryLocator(queryLocator);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__QueryOptions != null) __connection.addHeader(QueryOptions_qname, __QueryOptions);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.QueryMoreResponse_element) __connection.send("",
       queryMore_qname, __request, queryMoreResponse_qname,
       com.sforce.soap.partner.QueryMoreResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeDataCategoryGroupResult[] describeDataCategoryGroups(String[] sObjectType)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeDataCategoryGroups_element __request = new DescribeDataCategoryGroups_element();
    DescribeDataCategoryGroupsResponse_element __response = new DescribeDataCategoryGroupsResponse_element();

  
    __request.setSObjectType(sObjectType);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (DescribeDataCategoryGroupsResponse_element) __connection.send("",
       describeDataCategoryGroups_qname, __request, describeDataCategoryGroupsResponse_qname,
       DescribeDataCategoryGroupsResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeSoftphoneLayoutResult describeSoftphoneLayout()
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeSoftphoneLayout_element __request = new DescribeSoftphoneLayout_element();
    DescribeSoftphoneLayoutResponse_element __response = new DescribeSoftphoneLayoutResponse_element();

  

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (DescribeSoftphoneLayoutResponse_element) __connection.send("",
       describeSoftphoneLayout_qname, __request, describeSoftphoneLayoutResponse_qname,
       DescribeSoftphoneLayoutResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeSObjectResult describeSObject(String sObjectType)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeSObject_element __request = new DescribeSObject_element();
    DescribeSObjectResponse_element __response = new DescribeSObjectResponse_element();

  
    __request.setSObjectType(sObjectType);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__LocaleOptions != null) __connection.addHeader(LocaleOptions_qname, __LocaleOptions);
    

    addHeaders(__connection);

    __response = (DescribeSObjectResponse_element) __connection.send("",
       describeSObject_qname, __request, describeSObjectResponse_qname,
       DescribeSObjectResponse_element.class);

    return __response.getResult();
  }
  
  public DescribeSObjectResult[] describeSObjects(String[] sObjectType)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    DescribeSObjects_element __request = new DescribeSObjects_element();
    DescribeSObjectsResponse_element __response = new DescribeSObjectsResponse_element();

  
    __request.setSObjectType(sObjectType);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__LocaleOptions != null) __connection.addHeader(LocaleOptions_qname, __LocaleOptions);
    

    addHeaders(__connection);

    __response = (DescribeSObjectsResponse_element) __connection.send("",
       describeSObjects_qname, __request, describeSObjectsResponse_qname,
       DescribeSObjectsResponse_element.class);

    return __response.getResult();
  }
  
  public GetUpdatedResult getUpdated(String sObjectType,java.util.Calendar startDate,java.util.Calendar endDate)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    GetUpdated_element __request = new GetUpdated_element();
    GetUpdatedResponse_element __response = new GetUpdatedResponse_element();

  
    __request.setSObjectType(sObjectType);
    __request.setStartDate(startDate);
    __request.setEndDate(endDate);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    

    addHeaders(__connection);

    __response = (GetUpdatedResponse_element) __connection.send("",
       getUpdated_qname, __request, getUpdatedResponse_qname,
       GetUpdatedResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.UpsertResult[] upsert(String externalIDFieldName,com.sforce.soap.partner.sobject.SObject[] sObjects)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Upsert_element __request = new com.sforce.soap.partner.Upsert_element();
    com.sforce.soap.partner.UpsertResponse_element __response = new com.sforce.soap.partner.UpsertResponse_element();

  
    __request.setExternalIDFieldName(externalIDFieldName);
    __request.setSObjects(sObjects);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AssignmentRuleHeader != null) __connection.addHeader(AssignmentRuleHeader_qname, __AssignmentRuleHeader);
    
    if (__MruHeader != null) __connection.addHeader(MruHeader_qname, __MruHeader);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__AllOrNoneHeader != null) __connection.addHeader(AllOrNoneHeader_qname, __AllOrNoneHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__EmailHeader != null) __connection.addHeader(EmailHeader_qname, __EmailHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.UpsertResponse_element) __connection.send("",
       upsert_qname, __request, upsertResponse_qname,
       com.sforce.soap.partner.UpsertResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.QueryResult queryAll(String queryString)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.QueryAll_element __request = new com.sforce.soap.partner.QueryAll_element();
    com.sforce.soap.partner.QueryAllResponse_element __response = new com.sforce.soap.partner.QueryAllResponse_element();

  
    __request.setQueryString(queryString);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__QueryOptions != null) __connection.addHeader(QueryOptions_qname, __QueryOptions);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.QueryAllResponse_element) __connection.send("",
       queryAll_qname, __request, queryAllResponse_qname,
       com.sforce.soap.partner.QueryAllResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.ResetPasswordResult resetPassword(String userId)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.ResetPassword_element __request = new com.sforce.soap.partner.ResetPassword_element();
    com.sforce.soap.partner.ResetPasswordResponse_element __response = new com.sforce.soap.partner.ResetPasswordResponse_element();

  
    __request.setUserId(userId);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__EmailHeader != null) __connection.addHeader(EmailHeader_qname, __EmailHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.ResetPasswordResponse_element) __connection.send("",
       resetPassword_qname, __request, resetPasswordResponse_qname,
       com.sforce.soap.partner.ResetPasswordResponse_element.class);

    return __response.getResult();
  }
  
  public MergeResult[] merge(MergeRequest[] request)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    Merge_element __request = new Merge_element();
    MergeResponse_element __response = new MergeResponse_element();

  
    __request.setRequest(request);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AssignmentRuleHeader != null) __connection.addHeader(AssignmentRuleHeader_qname, __AssignmentRuleHeader);
    
    if (__MruHeader != null) __connection.addHeader(MruHeader_qname, __MruHeader);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__EmailHeader != null) __connection.addHeader(EmailHeader_qname, __EmailHeader);
    

    addHeaders(__connection);

    __response = (MergeResponse_element) __connection.send("",
       merge_qname, __request, mergeResponse_qname,
       MergeResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.QueryResult query(String queryString)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Query_element __request = new com.sforce.soap.partner.Query_element();
    com.sforce.soap.partner.QueryResponse_element __response = new com.sforce.soap.partner.QueryResponse_element();

  
    __request.setQueryString(queryString);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__QueryOptions != null) __connection.addHeader(QueryOptions_qname, __QueryOptions);
    
    if (__MruHeader != null) __connection.addHeader(MruHeader_qname, __MruHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.QueryResponse_element) __connection.send("",
       query_qname, __request, queryResponse_qname,
       com.sforce.soap.partner.QueryResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.SaveResult[] update(com.sforce.soap.partner.sobject.SObject[] sObjects)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Update_element __request = new com.sforce.soap.partner.Update_element();
    com.sforce.soap.partner.UpdateResponse_element __response = new com.sforce.soap.partner.UpdateResponse_element();

  
    __request.setSObjects(sObjects);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AssignmentRuleHeader != null) __connection.addHeader(AssignmentRuleHeader_qname, __AssignmentRuleHeader);
    
    if (__MruHeader != null) __connection.addHeader(MruHeader_qname, __MruHeader);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__AllOrNoneHeader != null) __connection.addHeader(AllOrNoneHeader_qname, __AllOrNoneHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    
    if (__EmailHeader != null) __connection.addHeader(EmailHeader_qname, __EmailHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.UpdateResponse_element) __connection.send("",
       update_qname, __request, updateResponse_qname,
       com.sforce.soap.partner.UpdateResponse_element.class);

    return __response.getResult();
  }
  
  public com.sforce.soap.partner.UndeleteResult[] undelete(String[] ids)
       throws ConnectionException {
    com.sforce.ws.transport.SoapConnection __connection = newConnection();
    com.sforce.soap.partner.Undelete_element __request = new com.sforce.soap.partner.Undelete_element();
    com.sforce.soap.partner.UndeleteResponse_element __response = new com.sforce.soap.partner.UndeleteResponse_element();

  
    __request.setIds(ids);

    
    if (__SessionHeader != null) __connection.addHeader(SessionHeader_qname, __SessionHeader);
    
    if (__CallOptions != null) __connection.addHeader(CallOptions_qname, __CallOptions);
    
    if (__AllowFieldTruncationHeader != null) __connection.addHeader(AllowFieldTruncationHeader_qname, __AllowFieldTruncationHeader);
    
    if (__DisableFeedTrackingHeader != null) __connection.addHeader(DisableFeedTrackingHeader_qname, __DisableFeedTrackingHeader);
    
    if (__StreamingEnabledHeader != null) __connection.addHeader(StreamingEnabledHeader_qname, __StreamingEnabledHeader);
    
    if (__AllOrNoneHeader != null) __connection.addHeader(AllOrNoneHeader_qname, __AllOrNoneHeader);
    
    if (__DebuggingHeader != null) __connection.addHeader(DebuggingHeader_qname, __DebuggingHeader);
    
    if (__PackageVersionHeader != null) __connection.addHeader(PackageVersionHeader_qname, __PackageVersionHeader);
    

    addHeaders(__connection);

    __response = (com.sforce.soap.partner.UndeleteResponse_element) __connection.send("",
       undelete_qname, __request, undeleteResponse_qname,
       com.sforce.soap.partner.UndeleteResponse_element.class);

    return __response.getResult();
  }
  


  private void addHeaders(com.sforce.ws.transport.SoapConnection __connection) {
    for(java.util.Map.Entry<QName, XMLizable> entry : __extraHeaders.entrySet()) {
      __connection.addHeader(entry.getKey(), entry.getValue());
    }
  }

  public void addExtraHeader(QName __headerName, XMLizable __value) {
    __extraHeaders.put(__headerName, __value);
  }

	public void removeExtraHeader(QName __headerName) {
		__extraHeaders.remove(__headerName);
	}

	public XMLizable getExtraHeader(QName __headerName) {
		return __extraHeaders.get(__headerName);
	}
	
	public void clearExtraHeaders() {
		__extraHeaders = new HashMap<QName, XMLizable>();
	}    private static final QName convertLead_qname = new QName("urn:partner.soap.sforce.com", "convertLead");
    private static final QName convertLeadResponse_qname = new QName("urn:partner.soap.sforce.com", "convertLeadResponse");
    private static final QName describeDataCategoryGroupStructures_qname = new QName("urn:partner.soap.sforce.com", "describeDataCategoryGroupStructures");
    private static final QName describeDataCategoryGroupStructuresResponse_qname = new QName("urn:partner.soap.sforce.com", "describeDataCategoryGroupStructuresResponse");
    private static final QName sendEmail_qname = new QName("urn:partner.soap.sforce.com", "sendEmail");
    private static final QName sendEmailResponse_qname = new QName("urn:partner.soap.sforce.com", "sendEmailResponse");
    private static final QName describeGlobal_qname = new QName("urn:partner.soap.sforce.com", "describeGlobal");
    private static final QName describeGlobalResponse_qname = new QName("urn:partner.soap.sforce.com", "describeGlobalResponse");
    private static final QName retrieve_qname = new QName("urn:partner.soap.sforce.com", "retrieve");
    private static final QName retrieveResponse_qname = new QName("urn:partner.soap.sforce.com", "retrieveResponse");
    private static final QName describeLayout_qname = new QName("urn:partner.soap.sforce.com", "describeLayout");
    private static final QName describeLayoutResponse_qname = new QName("urn:partner.soap.sforce.com", "describeLayoutResponse");
    private static final QName emptyRecycleBin_qname = new QName("urn:partner.soap.sforce.com", "emptyRecycleBin");
    private static final QName emptyRecycleBinResponse_qname = new QName("urn:partner.soap.sforce.com", "emptyRecycleBinResponse");
    private static final QName process_qname = new QName("urn:partner.soap.sforce.com", "process");
    private static final QName processResponse_qname = new QName("urn:partner.soap.sforce.com", "processResponse");
    private static final QName logout_qname = new QName("urn:partner.soap.sforce.com", "logout");
    private static final QName logoutResponse_qname = new QName("urn:partner.soap.sforce.com", "logoutResponse");
    private static final QName create_qname = new QName("urn:partner.soap.sforce.com", "create");
    private static final QName createResponse_qname = new QName("urn:partner.soap.sforce.com", "createResponse");
    private static final QName invalidateSessions_qname = new QName("urn:partner.soap.sforce.com", "invalidateSessions");
    private static final QName invalidateSessionsResponse_qname = new QName("urn:partner.soap.sforce.com", "invalidateSessionsResponse");
    private static final QName getUserInfo_qname = new QName("urn:partner.soap.sforce.com", "getUserInfo");
    private static final QName getUserInfoResponse_qname = new QName("urn:partner.soap.sforce.com", "getUserInfoResponse");
    private static final QName getServerTimestamp_qname = new QName("urn:partner.soap.sforce.com", "getServerTimestamp");
    private static final QName getServerTimestampResponse_qname = new QName("urn:partner.soap.sforce.com", "getServerTimestampResponse");
    private static final QName getDeleted_qname = new QName("urn:partner.soap.sforce.com", "getDeleted");
    private static final QName getDeletedResponse_qname = new QName("urn:partner.soap.sforce.com", "getDeletedResponse");
    private static final QName setPassword_qname = new QName("urn:partner.soap.sforce.com", "setPassword");
    private static final QName setPasswordResponse_qname = new QName("urn:partner.soap.sforce.com", "setPasswordResponse");
    private static final QName delete_qname = new QName("urn:partner.soap.sforce.com", "delete");
    private static final QName deleteResponse_qname = new QName("urn:partner.soap.sforce.com", "deleteResponse");
    private static final QName describeTabs_qname = new QName("urn:partner.soap.sforce.com", "describeTabs");
    private static final QName describeTabsResponse_qname = new QName("urn:partner.soap.sforce.com", "describeTabsResponse");
    private static final QName login_qname = new QName("urn:partner.soap.sforce.com", "login");
    private static final QName loginResponse_qname = new QName("urn:partner.soap.sforce.com", "loginResponse");
    private static final QName search_qname = new QName("urn:partner.soap.sforce.com", "search");
    private static final QName searchResponse_qname = new QName("urn:partner.soap.sforce.com", "searchResponse");
    private static final QName queryMore_qname = new QName("urn:partner.soap.sforce.com", "queryMore");
    private static final QName queryMoreResponse_qname = new QName("urn:partner.soap.sforce.com", "queryMoreResponse");
    private static final QName describeDataCategoryGroups_qname = new QName("urn:partner.soap.sforce.com", "describeDataCategoryGroups");
    private static final QName describeDataCategoryGroupsResponse_qname = new QName("urn:partner.soap.sforce.com", "describeDataCategoryGroupsResponse");
    private static final QName describeSoftphoneLayout_qname = new QName("urn:partner.soap.sforce.com", "describeSoftphoneLayout");
    private static final QName describeSoftphoneLayoutResponse_qname = new QName("urn:partner.soap.sforce.com", "describeSoftphoneLayoutResponse");
    private static final QName describeSObject_qname = new QName("urn:partner.soap.sforce.com", "describeSObject");
    private static final QName describeSObjectResponse_qname = new QName("urn:partner.soap.sforce.com", "describeSObjectResponse");
    private static final QName describeSObjects_qname = new QName("urn:partner.soap.sforce.com", "describeSObjects");
    private static final QName describeSObjectsResponse_qname = new QName("urn:partner.soap.sforce.com", "describeSObjectsResponse");
    private static final QName getUpdated_qname = new QName("urn:partner.soap.sforce.com", "getUpdated");
    private static final QName getUpdatedResponse_qname = new QName("urn:partner.soap.sforce.com", "getUpdatedResponse");
    private static final QName upsert_qname = new QName("urn:partner.soap.sforce.com", "upsert");
    private static final QName upsertResponse_qname = new QName("urn:partner.soap.sforce.com", "upsertResponse");
    private static final QName queryAll_qname = new QName("urn:partner.soap.sforce.com", "queryAll");
    private static final QName queryAllResponse_qname = new QName("urn:partner.soap.sforce.com", "queryAllResponse");
    private static final QName resetPassword_qname = new QName("urn:partner.soap.sforce.com", "resetPassword");
    private static final QName resetPasswordResponse_qname = new QName("urn:partner.soap.sforce.com", "resetPasswordResponse");
    private static final QName merge_qname = new QName("urn:partner.soap.sforce.com", "merge");
    private static final QName mergeResponse_qname = new QName("urn:partner.soap.sforce.com", "mergeResponse");
    private static final QName query_qname = new QName("urn:partner.soap.sforce.com", "query");
    private static final QName queryResponse_qname = new QName("urn:partner.soap.sforce.com", "queryResponse");
    private static final QName update_qname = new QName("urn:partner.soap.sforce.com", "update");
    private static final QName updateResponse_qname = new QName("urn:partner.soap.sforce.com", "updateResponse");
    private static final QName undelete_qname = new QName("urn:partner.soap.sforce.com", "undelete");
    private static final QName undeleteResponse_qname = new QName("urn:partner.soap.sforce.com", "undeleteResponse");
    private static final QName StreamingEnabledHeader_qname = new QName("urn:partner.soap.sforce.com", "StreamingEnabledHeader");
    private static final QName MruHeader_qname = new QName("urn:partner.soap.sforce.com", "MruHeader");
    private static final QName CallOptions_qname = new QName("urn:partner.soap.sforce.com", "CallOptions");
    private static final QName PackageVersionHeader_qname = new QName("urn:partner.soap.sforce.com", "PackageVersionHeader");
    private static final QName LocaleOptions_qname = new QName("urn:partner.soap.sforce.com", "LocaleOptions");
    private static final QName EmailHeader_qname = new QName("urn:partner.soap.sforce.com", "EmailHeader");
    private static final QName DebuggingInfo_qname = new QName("urn:partner.soap.sforce.com", "DebuggingInfo");
    private static final QName SessionHeader_qname = new QName("urn:partner.soap.sforce.com", "SessionHeader");
    private static final QName DebuggingHeader_qname = new QName("urn:partner.soap.sforce.com", "DebuggingHeader");
    private static final QName LoginScopeHeader_qname = new QName("urn:partner.soap.sforce.com", "LoginScopeHeader");
    private static final QName DisableFeedTrackingHeader_qname = new QName("urn:partner.soap.sforce.com", "DisableFeedTrackingHeader");
    private static final QName UserTerritoryDeleteHeader_qname = new QName("urn:partner.soap.sforce.com", "UserTerritoryDeleteHeader");
    private static final QName AllowFieldTruncationHeader_qname = new QName("urn:partner.soap.sforce.com", "AllowFieldTruncationHeader");
    private static final QName QueryOptions_qname = new QName("urn:partner.soap.sforce.com", "QueryOptions");
    private static final QName AssignmentRuleHeader_qname = new QName("urn:partner.soap.sforce.com", "AssignmentRuleHeader");
    private static final QName AllOrNoneHeader_qname = new QName("urn:partner.soap.sforce.com", "AllOrNoneHeader");


  private static HashMap<QName, Class> knownHeaders = new HashMap<QName, Class>();

  static {  knownHeaders.put(StreamingEnabledHeader_qname,com.sforce.soap.partner.StreamingEnabledHeader_element.class);
  knownHeaders.put(MruHeader_qname,MruHeader_element.class);
  knownHeaders.put(CallOptions_qname,CallOptions_element.class);
  knownHeaders.put(PackageVersionHeader_qname,PackageVersionHeader_element.class);
  knownHeaders.put(LocaleOptions_qname,LocaleOptions_element.class);
  knownHeaders.put(EmailHeader_qname,EmailHeader_element.class);
  knownHeaders.put(DebuggingInfo_qname,DebuggingInfo_element.class);
  knownHeaders.put(SessionHeader_qname,com.sforce.soap.partner.SessionHeader_element.class);
  knownHeaders.put(DebuggingHeader_qname,DebuggingHeader_element.class);
  knownHeaders.put(LoginScopeHeader_qname,LoginScopeHeader_element.class);
  knownHeaders.put(DisableFeedTrackingHeader_qname,DisableFeedTrackingHeader_element.class);
  knownHeaders.put(UserTerritoryDeleteHeader_qname,com.sforce.soap.partner.UserTerritoryDeleteHeader_element.class);
  knownHeaders.put(AllowFieldTruncationHeader_qname,AllowFieldTruncationHeader_element.class);
  knownHeaders.put(QueryOptions_qname,com.sforce.soap.partner.QueryOptions_element.class);
  knownHeaders.put(AssignmentRuleHeader_qname,AssignmentRuleHeader_element.class);
  knownHeaders.put(AllOrNoneHeader_qname,AllOrNoneHeader_element.class);

  }
}