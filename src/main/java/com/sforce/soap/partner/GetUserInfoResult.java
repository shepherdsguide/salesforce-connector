package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class GetUserInfoResult implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public GetUserInfoResult() {
  }
    
  
  /**
   * element  : accessibilityMode of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo accessibilityMode__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","accessibilityMode","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean accessibilityMode__is_set = false;

  private boolean accessibilityMode;

  public boolean getAccessibilityMode() {
    return accessibilityMode;
  }

  

  public boolean isAccessibilityMode() {
    return accessibilityMode;
  }

  

  public void setAccessibilityMode(boolean accessibilityMode) {
    this.accessibilityMode = accessibilityMode;
    accessibilityMode__is_set = true;
  }
  
  /**
   * element  : currencySymbol of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo currencySymbol__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","currencySymbol","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean currencySymbol__is_set = false;

  private String currencySymbol;

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  

  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
    currencySymbol__is_set = true;
  }
  
  /**
   * element  : orgAttachmentFileSizeLimit of type {http://www.w3.org/2001/XMLSchema}int
   * java type: int
   */
  private static final com.sforce.ws.bind.TypeInfo orgAttachmentFileSizeLimit__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","orgAttachmentFileSizeLimit","http://www.w3.org/2001/XMLSchema","int",1,1,true);

  private boolean orgAttachmentFileSizeLimit__is_set = false;

  private int orgAttachmentFileSizeLimit;

  public int getOrgAttachmentFileSizeLimit() {
    return orgAttachmentFileSizeLimit;
  }

  

  public void setOrgAttachmentFileSizeLimit(int orgAttachmentFileSizeLimit) {
    this.orgAttachmentFileSizeLimit = orgAttachmentFileSizeLimit;
    orgAttachmentFileSizeLimit__is_set = true;
  }
  
  /**
   * element  : orgDefaultCurrencyIsoCode of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo orgDefaultCurrencyIsoCode__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","orgDefaultCurrencyIsoCode","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean orgDefaultCurrencyIsoCode__is_set = false;

  private String orgDefaultCurrencyIsoCode;

  public String getOrgDefaultCurrencyIsoCode() {
    return orgDefaultCurrencyIsoCode;
  }

  

  public void setOrgDefaultCurrencyIsoCode(String orgDefaultCurrencyIsoCode) {
    this.orgDefaultCurrencyIsoCode = orgDefaultCurrencyIsoCode;
    orgDefaultCurrencyIsoCode__is_set = true;
  }
  
  /**
   * element  : orgDisallowHtmlAttachments of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo orgDisallowHtmlAttachments__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","orgDisallowHtmlAttachments","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean orgDisallowHtmlAttachments__is_set = false;

  private boolean orgDisallowHtmlAttachments;

  public boolean getOrgDisallowHtmlAttachments() {
    return orgDisallowHtmlAttachments;
  }

  

  public boolean isOrgDisallowHtmlAttachments() {
    return orgDisallowHtmlAttachments;
  }

  

  public void setOrgDisallowHtmlAttachments(boolean orgDisallowHtmlAttachments) {
    this.orgDisallowHtmlAttachments = orgDisallowHtmlAttachments;
    orgDisallowHtmlAttachments__is_set = true;
  }
  
  /**
   * element  : orgHasPersonAccounts of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo orgHasPersonAccounts__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","orgHasPersonAccounts","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean orgHasPersonAccounts__is_set = false;

  private boolean orgHasPersonAccounts;

  public boolean getOrgHasPersonAccounts() {
    return orgHasPersonAccounts;
  }

  

  public boolean isOrgHasPersonAccounts() {
    return orgHasPersonAccounts;
  }

  

  public void setOrgHasPersonAccounts(boolean orgHasPersonAccounts) {
    this.orgHasPersonAccounts = orgHasPersonAccounts;
    orgHasPersonAccounts__is_set = true;
  }
  
  /**
   * element  : organizationId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo organizationId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","organizationId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean organizationId__is_set = false;

  private String organizationId;

  public String getOrganizationId() {
    return organizationId;
  }

  

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
    organizationId__is_set = true;
  }
  
  /**
   * element  : organizationMultiCurrency of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo organizationMultiCurrency__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","organizationMultiCurrency","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean organizationMultiCurrency__is_set = false;

  private boolean organizationMultiCurrency;

  public boolean getOrganizationMultiCurrency() {
    return organizationMultiCurrency;
  }

  

  public boolean isOrganizationMultiCurrency() {
    return organizationMultiCurrency;
  }

  

  public void setOrganizationMultiCurrency(boolean organizationMultiCurrency) {
    this.organizationMultiCurrency = organizationMultiCurrency;
    organizationMultiCurrency__is_set = true;
  }
  
  /**
   * element  : organizationName of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo organizationName__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","organizationName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean organizationName__is_set = false;

  private String organizationName;

  public String getOrganizationName() {
    return organizationName;
  }

  

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    organizationName__is_set = true;
  }
  
  /**
   * element  : profileId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo profileId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","profileId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean profileId__is_set = false;

  private String profileId;

  public String getProfileId() {
    return profileId;
  }

  

  public void setProfileId(String profileId) {
    this.profileId = profileId;
    profileId__is_set = true;
  }
  
  /**
   * element  : roleId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo roleId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","roleId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean roleId__is_set = false;

  private String roleId;

  public String getRoleId() {
    return roleId;
  }

  

  public void setRoleId(String roleId) {
    this.roleId = roleId;
    roleId__is_set = true;
  }
  
  /**
   * element  : sessionSecondsValid of type {http://www.w3.org/2001/XMLSchema}int
   * java type: int
   */
  private static final com.sforce.ws.bind.TypeInfo sessionSecondsValid__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","sessionSecondsValid","http://www.w3.org/2001/XMLSchema","int",1,1,true);

  private boolean sessionSecondsValid__is_set = false;

  private int sessionSecondsValid;

  public int getSessionSecondsValid() {
    return sessionSecondsValid;
  }

  

  public void setSessionSecondsValid(int sessionSecondsValid) {
    this.sessionSecondsValid = sessionSecondsValid;
    sessionSecondsValid__is_set = true;
  }
  
  /**
   * element  : userDefaultCurrencyIsoCode of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userDefaultCurrencyIsoCode__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userDefaultCurrencyIsoCode","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userDefaultCurrencyIsoCode__is_set = false;

  private String userDefaultCurrencyIsoCode;

  public String getUserDefaultCurrencyIsoCode() {
    return userDefaultCurrencyIsoCode;
  }

  

  public void setUserDefaultCurrencyIsoCode(String userDefaultCurrencyIsoCode) {
    this.userDefaultCurrencyIsoCode = userDefaultCurrencyIsoCode;
    userDefaultCurrencyIsoCode__is_set = true;
  }
  
  /**
   * element  : userEmail of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userEmail__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userEmail","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userEmail__is_set = false;

  private String userEmail;

  public String getUserEmail() {
    return userEmail;
  }

  

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
    userEmail__is_set = true;
  }
  
  /**
   * element  : userFullName of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userFullName__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userFullName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userFullName__is_set = false;

  private String userFullName;

  public String getUserFullName() {
    return userFullName;
  }

  

  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
    userFullName__is_set = true;
  }
  
  /**
   * element  : userId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean userId__is_set = false;

  private String userId;

  public String getUserId() {
    return userId;
  }

  

  public void setUserId(String userId) {
    this.userId = userId;
    userId__is_set = true;
  }
  
  /**
   * element  : userLanguage of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userLanguage__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userLanguage","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userLanguage__is_set = false;

  private String userLanguage;

  public String getUserLanguage() {
    return userLanguage;
  }

  

  public void setUserLanguage(String userLanguage) {
    this.userLanguage = userLanguage;
    userLanguage__is_set = true;
  }
  
  /**
   * element  : userLocale of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userLocale__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userLocale","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userLocale__is_set = false;

  private String userLocale;

  public String getUserLocale() {
    return userLocale;
  }

  

  public void setUserLocale(String userLocale) {
    this.userLocale = userLocale;
    userLocale__is_set = true;
  }
  
  /**
   * element  : userName of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userName__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userName__is_set = false;

  private String userName;

  public String getUserName() {
    return userName;
  }

  

  public void setUserName(String userName) {
    this.userName = userName;
    userName__is_set = true;
  }
  
  /**
   * element  : userTimeZone of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userTimeZone__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userTimeZone","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userTimeZone__is_set = false;

  private String userTimeZone;

  public String getUserTimeZone() {
    return userTimeZone;
  }

  

  public void setUserTimeZone(String userTimeZone) {
    this.userTimeZone = userTimeZone;
    userTimeZone__is_set = true;
  }
  
  /**
   * element  : userType of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userType__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userType__is_set = false;

  private String userType;

  public String getUserType() {
    return userType;
  }

  

  public void setUserType(String userType) {
    this.userType = userType;
    userType__is_set = true;
  }
  
  /**
   * element  : userUiSkin of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo userUiSkin__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","userUiSkin","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean userUiSkin__is_set = false;

  private String userUiSkin;

  public String getUserUiSkin() {
    return userUiSkin;
  }

  

  public void setUserUiSkin(String userUiSkin) {
    this.userUiSkin = userUiSkin;
    userUiSkin__is_set = true;
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
   
    __typeMapper.writeBoolean(__out, accessibilityMode__typeInfo, accessibilityMode, accessibilityMode__is_set);
    __typeMapper.writeString(__out, currencySymbol__typeInfo, currencySymbol, currencySymbol__is_set);
    __typeMapper.writeInt(__out, orgAttachmentFileSizeLimit__typeInfo, orgAttachmentFileSizeLimit, orgAttachmentFileSizeLimit__is_set);
    __typeMapper.writeString(__out, orgDefaultCurrencyIsoCode__typeInfo, orgDefaultCurrencyIsoCode, orgDefaultCurrencyIsoCode__is_set);
    __typeMapper.writeBoolean(__out, orgDisallowHtmlAttachments__typeInfo, orgDisallowHtmlAttachments, orgDisallowHtmlAttachments__is_set);
    __typeMapper.writeBoolean(__out, orgHasPersonAccounts__typeInfo, orgHasPersonAccounts, orgHasPersonAccounts__is_set);
    __typeMapper.writeString(__out, organizationId__typeInfo, organizationId, organizationId__is_set);
    __typeMapper.writeBoolean(__out, organizationMultiCurrency__typeInfo, organizationMultiCurrency, organizationMultiCurrency__is_set);
    __typeMapper.writeString(__out, organizationName__typeInfo, organizationName, organizationName__is_set);
    __typeMapper.writeString(__out, profileId__typeInfo, profileId, profileId__is_set);
    __typeMapper.writeString(__out, roleId__typeInfo, roleId, roleId__is_set);
    __typeMapper.writeInt(__out, sessionSecondsValid__typeInfo, sessionSecondsValid, sessionSecondsValid__is_set);
    __typeMapper.writeString(__out, userDefaultCurrencyIsoCode__typeInfo, userDefaultCurrencyIsoCode, userDefaultCurrencyIsoCode__is_set);
    __typeMapper.writeString(__out, userEmail__typeInfo, userEmail, userEmail__is_set);
    __typeMapper.writeString(__out, userFullName__typeInfo, userFullName, userFullName__is_set);
    __typeMapper.writeString(__out, userId__typeInfo, userId, userId__is_set);
    __typeMapper.writeString(__out, userLanguage__typeInfo, userLanguage, userLanguage__is_set);
    __typeMapper.writeString(__out, userLocale__typeInfo, userLocale, userLocale__is_set);
    __typeMapper.writeString(__out, userName__typeInfo, userName, userName__is_set);
    __typeMapper.writeString(__out, userTimeZone__typeInfo, userTimeZone, userTimeZone__is_set);
    __typeMapper.writeString(__out, userType__typeInfo, userType, userType__is_set);
    __typeMapper.writeString(__out, userUiSkin__typeInfo, userUiSkin, userUiSkin__is_set);
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
    if (__typeMapper.verifyElement(__in, accessibilityMode__typeInfo)) {
      setAccessibilityMode((boolean)__typeMapper.readBoolean(__in, accessibilityMode__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, currencySymbol__typeInfo)) {
      setCurrencySymbol((String)__typeMapper.readString(__in, currencySymbol__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, orgAttachmentFileSizeLimit__typeInfo)) {
      setOrgAttachmentFileSizeLimit((int)__typeMapper.readInt(__in, orgAttachmentFileSizeLimit__typeInfo, int.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, orgDefaultCurrencyIsoCode__typeInfo)) {
      setOrgDefaultCurrencyIsoCode((String)__typeMapper.readString(__in, orgDefaultCurrencyIsoCode__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, orgDisallowHtmlAttachments__typeInfo)) {
      setOrgDisallowHtmlAttachments((boolean)__typeMapper.readBoolean(__in, orgDisallowHtmlAttachments__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, orgHasPersonAccounts__typeInfo)) {
      setOrgHasPersonAccounts((boolean)__typeMapper.readBoolean(__in, orgHasPersonAccounts__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, organizationId__typeInfo)) {
      setOrganizationId((String)__typeMapper.readString(__in, organizationId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, organizationMultiCurrency__typeInfo)) {
      setOrganizationMultiCurrency((boolean)__typeMapper.readBoolean(__in, organizationMultiCurrency__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, organizationName__typeInfo)) {
      setOrganizationName((String)__typeMapper.readString(__in, organizationName__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, profileId__typeInfo)) {
      setProfileId((String)__typeMapper.readString(__in, profileId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, roleId__typeInfo)) {
      setRoleId((String)__typeMapper.readString(__in, roleId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, sessionSecondsValid__typeInfo)) {
      setSessionSecondsValid((int)__typeMapper.readInt(__in, sessionSecondsValid__typeInfo, int.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userDefaultCurrencyIsoCode__typeInfo)) {
      setUserDefaultCurrencyIsoCode((String)__typeMapper.readString(__in, userDefaultCurrencyIsoCode__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userEmail__typeInfo)) {
      setUserEmail((String)__typeMapper.readString(__in, userEmail__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userFullName__typeInfo)) {
      setUserFullName((String)__typeMapper.readString(__in, userFullName__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userId__typeInfo)) {
      setUserId((String)__typeMapper.readString(__in, userId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userLanguage__typeInfo)) {
      setUserLanguage((String)__typeMapper.readString(__in, userLanguage__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userLocale__typeInfo)) {
      setUserLocale((String)__typeMapper.readString(__in, userLocale__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userName__typeInfo)) {
      setUserName((String)__typeMapper.readString(__in, userName__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userTimeZone__typeInfo)) {
      setUserTimeZone((String)__typeMapper.readString(__in, userTimeZone__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userType__typeInfo)) {
      setUserType((String)__typeMapper.readString(__in, userType__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, userUiSkin__typeInfo)) {
      setUserUiSkin((String)__typeMapper.readString(__in, userUiSkin__typeInfo, String.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[GetUserInfoResult ");
    
    sb.append(" accessibilityMode=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(accessibilityMode)+"'\n");
    sb.append(" currencySymbol=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(currencySymbol)+"'\n");
    sb.append(" orgAttachmentFileSizeLimit=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(orgAttachmentFileSizeLimit)+"'\n");
    sb.append(" orgDefaultCurrencyIsoCode=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(orgDefaultCurrencyIsoCode)+"'\n");
    sb.append(" orgDisallowHtmlAttachments=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(orgDisallowHtmlAttachments)+"'\n");
    sb.append(" orgHasPersonAccounts=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(orgHasPersonAccounts)+"'\n");
    sb.append(" organizationId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(organizationId)+"'\n");
    sb.append(" organizationMultiCurrency=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(organizationMultiCurrency)+"'\n");
    sb.append(" organizationName=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(organizationName)+"'\n");
    sb.append(" profileId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(profileId)+"'\n");
    sb.append(" roleId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(roleId)+"'\n");
    sb.append(" sessionSecondsValid=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(sessionSecondsValid)+"'\n");
    sb.append(" userDefaultCurrencyIsoCode=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userDefaultCurrencyIsoCode)+"'\n");
    sb.append(" userEmail=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userEmail)+"'\n");
    sb.append(" userFullName=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userFullName)+"'\n");
    sb.append(" userId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userId)+"'\n");
    sb.append(" userLanguage=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userLanguage)+"'\n");
    sb.append(" userLocale=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userLocale)+"'\n");
    sb.append(" userName=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userName)+"'\n");
    sb.append(" userTimeZone=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userTimeZone)+"'\n");
    sb.append(" userType=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userType)+"'\n");
    sb.append(" userUiSkin=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(userUiSkin)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}