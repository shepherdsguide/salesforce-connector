package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class MassEmailMessage extends Email {

  /**
   * Constructor
   */
  public MassEmailMessage() {
  }
    
  
  /**
   * element  : description of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo description__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","description","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean description__is_set = false;

  private String description;

  public String getDescription() {
    return description;
  }

  

  public void setDescription(String description) {
    this.description = description;
    description__is_set = true;
  }
  
  /**
   * element  : targetObjectIds of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo targetObjectIds__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","targetObjectIds","urn:partner.soap.sforce.com","ID",0,250,true);

  private boolean targetObjectIds__is_set = false;

  private String[] targetObjectIds = new String[0];

  public String[] getTargetObjectIds() {
    return targetObjectIds;
  }

  

  public void setTargetObjectIds(String[] targetObjectIds) {
    this.targetObjectIds = targetObjectIds;
    targetObjectIds__is_set = true;
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
   * element  : whatIds of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo whatIds__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","whatIds","urn:partner.soap.sforce.com","ID",0,250,true);

  private boolean whatIds__is_set = false;

  private String[] whatIds = new String[0];

  public String[] getWhatIds() {
    return whatIds;
  }

  

  public void setWhatIds(String[] whatIds) {
    this.whatIds = whatIds;
    whatIds__is_set = true;
  }
  

  /**
   */
  public void write(javax.xml.namespace.QName __element,
      com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
      throws java.io.IOException {
    __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
    __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "MassEmailMessage");
    writeFields(__out, __typeMapper);
    __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
  }

  protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException {
   super.writeFields(__out, __typeMapper);
    __typeMapper.writeString(__out, description__typeInfo, description, description__is_set);
    __typeMapper.writeObject(__out, targetObjectIds__typeInfo, targetObjectIds, targetObjectIds__is_set);
    __typeMapper.writeString(__out, templateId__typeInfo, templateId, templateId__is_set);
    __typeMapper.writeObject(__out, whatIds__typeInfo, whatIds, whatIds__is_set);
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
    if (__typeMapper.verifyElement(__in, description__typeInfo)) {
      setDescription((String)__typeMapper.readString(__in, description__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, targetObjectIds__typeInfo)) {
      setTargetObjectIds((String[])__typeMapper.readObject(__in, targetObjectIds__typeInfo, String[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, templateId__typeInfo)) {
      setTemplateId((String)__typeMapper.readString(__in, templateId__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, whatIds__typeInfo)) {
      setWhatIds((String[])__typeMapper.readObject(__in, whatIds__typeInfo, String[].class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[MassEmailMessage ");
    sb.append(super.toString());
    sb.append(" description=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(description)+"'\n");
    sb.append(" targetObjectIds=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(targetObjectIds)+"'\n");
    sb.append(" templateId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(templateId)+"'\n");
    sb.append(" whatIds=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(whatIds)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}