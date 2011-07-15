package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class LeadConvert implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public LeadConvert() {
  }
    
  
  /**
   * element  : accountId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo accountId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","accountId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean accountId__is_set = false;

  private String accountId;

  public String getAccountId() {
    return accountId;
  }

  

  public void setAccountId(String accountId) {
    this.accountId = accountId;
    accountId__is_set = true;
  }
  
  /**
   * element  : contactId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo contactId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","contactId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean contactId__is_set = false;

  private String contactId;

  public String getContactId() {
    return contactId;
  }

  

  public void setContactId(String contactId) {
    this.contactId = contactId;
    contactId__is_set = true;
  }
  
  /**
   * element  : convertedStatus of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo convertedStatus__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","convertedStatus","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean convertedStatus__is_set = false;

  private String convertedStatus;

  public String getConvertedStatus() {
    return convertedStatus;
  }

  

  public void setConvertedStatus(String convertedStatus) {
    this.convertedStatus = convertedStatus;
    convertedStatus__is_set = true;
  }
  
  /**
   * element  : doNotCreateOpportunity of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo doNotCreateOpportunity__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","doNotCreateOpportunity","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean doNotCreateOpportunity__is_set = false;

  private boolean doNotCreateOpportunity;

  public boolean getDoNotCreateOpportunity() {
    return doNotCreateOpportunity;
  }

  

  public boolean isDoNotCreateOpportunity() {
    return doNotCreateOpportunity;
  }

  

  public void setDoNotCreateOpportunity(boolean doNotCreateOpportunity) {
    this.doNotCreateOpportunity = doNotCreateOpportunity;
    doNotCreateOpportunity__is_set = true;
  }
  
  /**
   * element  : leadId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo leadId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","leadId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean leadId__is_set = false;

  private String leadId;

  public String getLeadId() {
    return leadId;
  }

  

  public void setLeadId(String leadId) {
    this.leadId = leadId;
    leadId__is_set = true;
  }
  
  /**
   * element  : opportunityName of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo opportunityName__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","opportunityName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean opportunityName__is_set = false;

  private String opportunityName;

  public String getOpportunityName() {
    return opportunityName;
  }

  

  public void setOpportunityName(String opportunityName) {
    this.opportunityName = opportunityName;
    opportunityName__is_set = true;
  }
  
  /**
   * element  : overwriteLeadSource of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo overwriteLeadSource__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","overwriteLeadSource","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean overwriteLeadSource__is_set = false;

  private boolean overwriteLeadSource;

  public boolean getOverwriteLeadSource() {
    return overwriteLeadSource;
  }

  

  public boolean isOverwriteLeadSource() {
    return overwriteLeadSource;
  }

  

  public void setOverwriteLeadSource(boolean overwriteLeadSource) {
    this.overwriteLeadSource = overwriteLeadSource;
    overwriteLeadSource__is_set = true;
  }
  
  /**
   * element  : ownerId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo ownerId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","ownerId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean ownerId__is_set = false;

  private String ownerId;

  public String getOwnerId() {
    return ownerId;
  }

  

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
    ownerId__is_set = true;
  }
  
  /**
   * element  : sendNotificationEmail of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo sendNotificationEmail__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","sendNotificationEmail","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean sendNotificationEmail__is_set = false;

  private boolean sendNotificationEmail;

  public boolean getSendNotificationEmail() {
    return sendNotificationEmail;
  }

  

  public boolean isSendNotificationEmail() {
    return sendNotificationEmail;
  }

  

  public void setSendNotificationEmail(boolean sendNotificationEmail) {
    this.sendNotificationEmail = sendNotificationEmail;
    sendNotificationEmail__is_set = true;
  }
  

  /**
   */
  public void write(javax.xml.namespace.QName __element,
      com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
      throws java.io.IOException {
    __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
    
    writeFields(__out, __typeMapper);
    __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
  }

  protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException {
   
    __typeMapper.writeString(__out, accountId__typeInfo, accountId, accountId__is_set);
    __typeMapper.writeString(__out, contactId__typeInfo, contactId, contactId__is_set);
    __typeMapper.writeString(__out, convertedStatus__typeInfo, convertedStatus, convertedStatus__is_set);
    __typeMapper.writeBoolean(__out, doNotCreateOpportunity__typeInfo, doNotCreateOpportunity, doNotCreateOpportunity__is_set);
    __typeMapper.writeString(__out, leadId__typeInfo, leadId, leadId__is_set);
    __typeMapper.writeString(__out, opportunityName__typeInfo, opportunityName, opportunityName__is_set);
    __typeMapper.writeBoolean(__out, overwriteLeadSource__typeInfo, overwriteLeadSource, overwriteLeadSource__is_set);
    __typeMapper.writeString(__out, ownerId__typeInfo, ownerId, ownerId__is_set);
    __typeMapper.writeBoolean(__out, sendNotificationEmail__typeInfo, sendNotificationEmail, sendNotificationEmail__is_set);
  }


  public void load(com.sforce.ws.parser.XmlInputStream __in,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
    __typeMapper.consumeStartTag(__in);
    loadFields(__in, __typeMapper);
    __typeMapper.consumeEndTag(__in);
  }

  protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
   
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, accountId__typeInfo)) {
      setAccountId((String)__typeMapper.readString(__in, accountId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, contactId__typeInfo)) {
      setContactId((String)__typeMapper.readString(__in, contactId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, convertedStatus__typeInfo)) {
      setConvertedStatus((String)__typeMapper.readString(__in, convertedStatus__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, doNotCreateOpportunity__typeInfo)) {
      setDoNotCreateOpportunity((boolean)__typeMapper.readBoolean(__in, doNotCreateOpportunity__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, leadId__typeInfo)) {
      setLeadId((String)__typeMapper.readString(__in, leadId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, opportunityName__typeInfo)) {
      setOpportunityName((String)__typeMapper.readString(__in, opportunityName__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, overwriteLeadSource__typeInfo)) {
      setOverwriteLeadSource((boolean)__typeMapper.readBoolean(__in, overwriteLeadSource__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, ownerId__typeInfo)) {
      setOwnerId((String)__typeMapper.readString(__in, ownerId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, sendNotificationEmail__typeInfo)) {
      setSendNotificationEmail((boolean)__typeMapper.readBoolean(__in, sendNotificationEmail__typeInfo, boolean.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[LeadConvert ");
    
    sb.append(" accountId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(accountId)+"'\n");
    sb.append(" contactId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(contactId)+"'\n");
    sb.append(" convertedStatus=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(convertedStatus)+"'\n");
    sb.append(" doNotCreateOpportunity=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(doNotCreateOpportunity)+"'\n");
    sb.append(" leadId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(leadId)+"'\n");
    sb.append(" opportunityName=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(opportunityName)+"'\n");
    sb.append(" overwriteLeadSource=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(overwriteLeadSource)+"'\n");
    sb.append(" ownerId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(ownerId)+"'\n");
    sb.append(" sendNotificationEmail=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(sendNotificationEmail)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}