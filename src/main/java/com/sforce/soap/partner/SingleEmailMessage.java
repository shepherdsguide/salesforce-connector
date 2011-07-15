package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class SingleEmailMessage extends Email {

  /**
   * Constructor
   */
  public SingleEmailMessage() {
  }
    
  
  /**
   * element  : bccAddresses of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo bccAddresses__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","bccAddresses","http://www.w3.org/2001/XMLSchema","string",0,25,true);

  private boolean bccAddresses__is_set = false;

  private String[] bccAddresses = new String[0];

  public String[] getBccAddresses() {
    return bccAddresses;
  }

  

  public void setBccAddresses(String[] bccAddresses) {
    this.bccAddresses = bccAddresses;
    bccAddresses__is_set = true;
  }
  
  /**
   * element  : ccAddresses of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo ccAddresses__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","ccAddresses","http://www.w3.org/2001/XMLSchema","string",0,25,true);

  private boolean ccAddresses__is_set = false;

  private String[] ccAddresses = new String[0];

  public String[] getCcAddresses() {
    return ccAddresses;
  }

  

  public void setCcAddresses(String[] ccAddresses) {
    this.ccAddresses = ccAddresses;
    ccAddresses__is_set = true;
  }
  
  /**
   * element  : charset of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo charset__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","charset","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean charset__is_set = false;

  private String charset;

  public String getCharset() {
    return charset;
  }

  

  public void setCharset(String charset) {
    this.charset = charset;
    charset__is_set = true;
  }
  
  /**
   * element  : documentAttachments of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo documentAttachments__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","documentAttachments","urn:partner.soap.sforce.com","ID",0,-1,true);

  private boolean documentAttachments__is_set = false;

  private String[] documentAttachments = new String[0];

  public String[] getDocumentAttachments() {
    return documentAttachments;
  }

  

  public void setDocumentAttachments(String[] documentAttachments) {
    this.documentAttachments = documentAttachments;
    documentAttachments__is_set = true;
  }
  
  /**
   * element  : htmlBody of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo htmlBody__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","htmlBody","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean htmlBody__is_set = false;

  private String htmlBody;

  public String getHtmlBody() {
    return htmlBody;
  }

  

  public void setHtmlBody(String htmlBody) {
    this.htmlBody = htmlBody;
    htmlBody__is_set = true;
  }
  
  /**
   * element  : inReplyTo of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo inReplyTo__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","inReplyTo","http://www.w3.org/2001/XMLSchema","string",0,1,true);

  private boolean inReplyTo__is_set = false;

  private String inReplyTo;

  public String getInReplyTo() {
    return inReplyTo;
  }

  

  public void setInReplyTo(String inReplyTo) {
    this.inReplyTo = inReplyTo;
    inReplyTo__is_set = true;
  }
  
  /**
   * element  : fileAttachments of type {urn:partner.soap.sforce.com}EmailFileAttachment
   * java type: com.sforce.soap.partner.EmailFileAttachment[]
   */
  private static final com.sforce.ws.bind.TypeInfo fileAttachments__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","fileAttachments","urn:partner.soap.sforce.com","EmailFileAttachment",0,-1,true);

  private boolean fileAttachments__is_set = false;

  private EmailFileAttachment[] fileAttachments = new EmailFileAttachment[0];

  public EmailFileAttachment[] getFileAttachments() {
    return fileAttachments;
  }

  

  public void setFileAttachments(EmailFileAttachment[] fileAttachments) {
    this.fileAttachments = fileAttachments;
    fileAttachments__is_set = true;
  }
  
  /**
   * element  : orgWideEmailAddressId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo orgWideEmailAddressId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","orgWideEmailAddressId","urn:partner.soap.sforce.com","ID",0,1,true);

  private boolean orgWideEmailAddressId__is_set = false;

  private String orgWideEmailAddressId;

  public String getOrgWideEmailAddressId() {
    return orgWideEmailAddressId;
  }

  

  public void setOrgWideEmailAddressId(String orgWideEmailAddressId) {
    this.orgWideEmailAddressId = orgWideEmailAddressId;
    orgWideEmailAddressId__is_set = true;
  }
  
  /**
   * element  : plainTextBody of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo plainTextBody__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","plainTextBody","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean plainTextBody__is_set = false;

  private String plainTextBody;

  public String getPlainTextBody() {
    return plainTextBody;
  }

  

  public void setPlainTextBody(String plainTextBody) {
    this.plainTextBody = plainTextBody;
    plainTextBody__is_set = true;
  }
  
  /**
   * element  : references of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo references__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","references","http://www.w3.org/2001/XMLSchema","string",0,1,true);

  private boolean references__is_set = false;

  private String references;

  public String getReferences() {
    return references;
  }

  

  public void setReferences(String references) {
    this.references = references;
    references__is_set = true;
  }
  
  /**
   * element  : targetObjectId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo targetObjectId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","targetObjectId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean targetObjectId__is_set = false;

  private String targetObjectId;

  public String getTargetObjectId() {
    return targetObjectId;
  }

  

  public void setTargetObjectId(String targetObjectId) {
    this.targetObjectId = targetObjectId;
    targetObjectId__is_set = true;
  }
  
  /**
   * element  : templateId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo templateId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","templateId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean templateId__is_set = false;

  private String templateId;

  public String getTemplateId() {
    return templateId;
  }

  

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
    templateId__is_set = true;
  }
  
  /**
   * element  : toAddresses of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo toAddresses__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","toAddresses","http://www.w3.org/2001/XMLSchema","string",0,100,true);

  private boolean toAddresses__is_set = false;

  private String[] toAddresses = new String[0];

  public String[] getToAddresses() {
    return toAddresses;
  }

  

  public void setToAddresses(String[] toAddresses) {
    this.toAddresses = toAddresses;
    toAddresses__is_set = true;
  }
  
  /**
   * element  : whatId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo whatId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","whatId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean whatId__is_set = false;

  private String whatId;

  public String getWhatId() {
    return whatId;
  }

  

  public void setWhatId(String whatId) {
    this.whatId = whatId;
    whatId__is_set = true;
  }
  

  /**
   */
  public void write(javax.xml.namespace.QName __element,
      com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
      throws java.io.IOException {
    __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
    __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "SingleEmailMessage");
    writeFields(__out, __typeMapper);
    __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
  }

  protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException {
   super.writeFields(__out, __typeMapper);
    __typeMapper.writeObject(__out, bccAddresses__typeInfo, bccAddresses, bccAddresses__is_set);
    __typeMapper.writeObject(__out, ccAddresses__typeInfo, ccAddresses, ccAddresses__is_set);
    __typeMapper.writeString(__out, charset__typeInfo, charset, charset__is_set);
    __typeMapper.writeObject(__out, documentAttachments__typeInfo, documentAttachments, documentAttachments__is_set);
    __typeMapper.writeString(__out, htmlBody__typeInfo, htmlBody, htmlBody__is_set);
    __typeMapper.writeString(__out, inReplyTo__typeInfo, inReplyTo, inReplyTo__is_set);
    __typeMapper.writeObject(__out, fileAttachments__typeInfo, fileAttachments, fileAttachments__is_set);
    __typeMapper.writeString(__out, orgWideEmailAddressId__typeInfo, orgWideEmailAddressId, orgWideEmailAddressId__is_set);
    __typeMapper.writeString(__out, plainTextBody__typeInfo, plainTextBody, plainTextBody__is_set);
    __typeMapper.writeString(__out, references__typeInfo, references, references__is_set);
    __typeMapper.writeString(__out, targetObjectId__typeInfo, targetObjectId, targetObjectId__is_set);
    __typeMapper.writeString(__out, templateId__typeInfo, templateId, templateId__is_set);
    __typeMapper.writeObject(__out, toAddresses__typeInfo, toAddresses, toAddresses__is_set);
    __typeMapper.writeString(__out, whatId__typeInfo, whatId, whatId__is_set);
  }


  public void load(com.sforce.ws.parser.XmlInputStream __in,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
    __typeMapper.consumeStartTag(__in);
    loadFields(__in, __typeMapper);
    __typeMapper.consumeEndTag(__in);
  }

  protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
   super.loadFields(__in, __typeMapper);
    __in.peekTag();
    if (__typeMapper.isElement(__in, bccAddresses__typeInfo)) {
      setBccAddresses((String[])__typeMapper.readObject(__in, bccAddresses__typeInfo, String[].class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, ccAddresses__typeInfo)) {
      setCcAddresses((String[])__typeMapper.readObject(__in, ccAddresses__typeInfo, String[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, charset__typeInfo)) {
      setCharset((String)__typeMapper.readString(__in, charset__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, documentAttachments__typeInfo)) {
      setDocumentAttachments((String[])__typeMapper.readObject(__in, documentAttachments__typeInfo, String[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, htmlBody__typeInfo)) {
      setHtmlBody((String)__typeMapper.readString(__in, htmlBody__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, inReplyTo__typeInfo)) {
      setInReplyTo((String)__typeMapper.readString(__in, inReplyTo__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, fileAttachments__typeInfo)) {
      setFileAttachments((EmailFileAttachment[])__typeMapper.readObject(__in, fileAttachments__typeInfo, EmailFileAttachment[].class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, orgWideEmailAddressId__typeInfo)) {
      setOrgWideEmailAddressId((String)__typeMapper.readString(__in, orgWideEmailAddressId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, plainTextBody__typeInfo)) {
      setPlainTextBody((String)__typeMapper.readString(__in, plainTextBody__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, references__typeInfo)) {
      setReferences((String)__typeMapper.readString(__in, references__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, targetObjectId__typeInfo)) {
      setTargetObjectId((String)__typeMapper.readString(__in, targetObjectId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, templateId__typeInfo)) {
      setTemplateId((String)__typeMapper.readString(__in, templateId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, toAddresses__typeInfo)) {
      setToAddresses((String[])__typeMapper.readObject(__in, toAddresses__typeInfo, String[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, whatId__typeInfo)) {
      setWhatId((String)__typeMapper.readString(__in, whatId__typeInfo, String.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[SingleEmailMessage ");
    sb.append(super.toString());
    sb.append(" bccAddresses=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(bccAddresses)+"'\n");
    sb.append(" ccAddresses=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(ccAddresses)+"'\n");
    sb.append(" charset=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(charset)+"'\n");
    sb.append(" documentAttachments=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(documentAttachments)+"'\n");
    sb.append(" htmlBody=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(htmlBody)+"'\n");
    sb.append(" inReplyTo=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(inReplyTo)+"'\n");
    sb.append(" fileAttachments=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(fileAttachments)+"'\n");
    sb.append(" orgWideEmailAddressId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(orgWideEmailAddressId)+"'\n");
    sb.append(" plainTextBody=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(plainTextBody)+"'\n");
    sb.append(" references=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(references)+"'\n");
    sb.append(" targetObjectId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(targetObjectId)+"'\n");
    sb.append(" templateId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(templateId)+"'\n");
    sb.append(" toAddresses=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(toAddresses)+"'\n");
    sb.append(" whatId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(whatId)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}