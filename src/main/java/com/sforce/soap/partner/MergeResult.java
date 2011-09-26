package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class MergeResult implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public MergeResult() {
  }
    
  
  /**
   * element  : errors of type {urn:partner.soap.sforce.com}Error
   * java type: com.sforce.soap.partner.Error[]
   */
  private static final com.sforce.ws.bind.TypeInfo errors__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","errors","urn:partner.soap.sforce.com","Error",0,-1,true);

  private boolean errors__is_set = false;

  private Error[] errors = new Error[0];

  public Error[] getErrors() {
    return errors;
  }

  

  public void setErrors(Error[] errors) {
    this.errors = errors;
    errors__is_set = true;
  }
  
  /**
   * element  : id of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo id__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","id","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean id__is_set = false;

  private String id;

  public String getId() {
    return id;
  }

  

  public void setId(String id) {
    this.id = id;
    id__is_set = true;
  }
  
  /**
   * element  : mergedRecordIds of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo mergedRecordIds__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","mergedRecordIds","urn:partner.soap.sforce.com","ID",0,-1,true);

  private boolean mergedRecordIds__is_set = false;

  private String[] mergedRecordIds = new String[0];

  public String[] getMergedRecordIds() {
    return mergedRecordIds;
  }

  

  public void setMergedRecordIds(String[] mergedRecordIds) {
    this.mergedRecordIds = mergedRecordIds;
    mergedRecordIds__is_set = true;
  }
  
  /**
   * element  : success of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo success__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","success","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean success__is_set = false;

  private boolean success;

  public boolean getSuccess() {
    return success;
  }

  

  public boolean isSuccess() {
    return success;
  }

  

  public void setSuccess(boolean success) {
    this.success = success;
    success__is_set = true;
  }
  
  /**
   * element  : updatedRelatedIds of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo updatedRelatedIds__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","updatedRelatedIds","urn:partner.soap.sforce.com","ID",0,-1,true);

  private boolean updatedRelatedIds__is_set = false;

  private String[] updatedRelatedIds = new String[0];

  public String[] getUpdatedRelatedIds() {
    return updatedRelatedIds;
  }

  

  public void setUpdatedRelatedIds(String[] updatedRelatedIds) {
    this.updatedRelatedIds = updatedRelatedIds;
    updatedRelatedIds__is_set = true;
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
   
    __typeMapper.writeObject(__out, errors__typeInfo, errors, errors__is_set);
    __typeMapper.writeString(__out, id__typeInfo, id, id__is_set);
    __typeMapper.writeObject(__out, mergedRecordIds__typeInfo, mergedRecordIds, mergedRecordIds__is_set);
    __typeMapper.writeBoolean(__out, success__typeInfo, success, success__is_set);
    __typeMapper.writeObject(__out, updatedRelatedIds__typeInfo, updatedRelatedIds, updatedRelatedIds__is_set);
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
    if (__typeMapper.isElement(__in, errors__typeInfo)) {
      setErrors((Error[])__typeMapper.readObject(__in, errors__typeInfo, Error[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, id__typeInfo)) {
      setId((String)__typeMapper.readString(__in, id__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, mergedRecordIds__typeInfo)) {
      setMergedRecordIds((String[])__typeMapper.readObject(__in, mergedRecordIds__typeInfo, String[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, success__typeInfo)) {
      setSuccess((boolean)__typeMapper.readBoolean(__in, success__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, updatedRelatedIds__typeInfo)) {
      setUpdatedRelatedIds((String[])__typeMapper.readObject(__in, updatedRelatedIds__typeInfo, String[].class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[MergeResult ");
    
    sb.append(" errors=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(errors)+"'\n");
    sb.append(" id=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(id)+"'\n");
    sb.append(" mergedRecordIds=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(mergedRecordIds)+"'\n");
    sb.append(" success=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(success)+"'\n");
    sb.append(" updatedRelatedIds=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(updatedRelatedIds)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}