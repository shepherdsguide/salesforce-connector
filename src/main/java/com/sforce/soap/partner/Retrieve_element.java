package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class Retrieve_element implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public Retrieve_element() {
  }
    
  
  /**
   * element  : fieldList of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo fieldList__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","fieldList","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean fieldList__is_set = false;

  private String fieldList;

  public String getFieldList() {
    return fieldList;
  }

  

  public void setFieldList(String fieldList) {
    this.fieldList = fieldList;
    fieldList__is_set = true;
  }
  
  /**
   * element  : sObjectType of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo sObjectType__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","sObjectType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean sObjectType__is_set = false;

  private String sObjectType;

  public String getSObjectType() {
    return sObjectType;
  }

  

  public void setSObjectType(String sObjectType) {
    this.sObjectType = sObjectType;
    sObjectType__is_set = true;
  }
  
  /**
   * element  : ids of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String[]
   */
  private static final com.sforce.ws.bind.TypeInfo ids__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","ids","urn:partner.soap.sforce.com","ID",0,-1,true);

  private boolean ids__is_set = false;

  private String[] ids = new String[0];

  public String[] getIds() {
    return ids;
  }

  

  public void setIds(String[] ids) {
    this.ids = ids;
    ids__is_set = true;
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
   
    __typeMapper.writeString(__out, fieldList__typeInfo, fieldList, fieldList__is_set);
    __typeMapper.writeString(__out, sObjectType__typeInfo, sObjectType, sObjectType__is_set);
    __typeMapper.writeObject(__out, ids__typeInfo, ids, ids__is_set);
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
    if (__typeMapper.verifyElement(__in, fieldList__typeInfo)) {
      setFieldList((String)__typeMapper.readString(__in, fieldList__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, sObjectType__typeInfo)) {
      setSObjectType((String)__typeMapper.readString(__in, sObjectType__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, ids__typeInfo)) {
      setIds((String[])__typeMapper.readObject(__in, ids__typeInfo, String[].class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[Retrieve_element ");
    
    sb.append(" fieldList=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(fieldList)+"'\n");
    sb.append(" sObjectType=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(sObjectType)+"'\n");
    sb.append(" ids=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(ids)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}