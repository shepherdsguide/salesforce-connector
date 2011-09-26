package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class DescribeSoftphoneLayoutResult implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public DescribeSoftphoneLayoutResult() {
  }
    
  
  /**
   * element  : callTypes of type {urn:partner.soap.sforce.com}DescribeSoftphoneLayoutCallType
   * java type: com.sforce.soap.partner.DescribeSoftphoneLayoutCallType[]
   */
  private static final com.sforce.ws.bind.TypeInfo callTypes__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","callTypes","urn:partner.soap.sforce.com","DescribeSoftphoneLayoutCallType",1,-1,true);

  private boolean callTypes__is_set = false;

  private DescribeSoftphoneLayoutCallType[] callTypes = new DescribeSoftphoneLayoutCallType[0];

  public DescribeSoftphoneLayoutCallType[] getCallTypes() {
    return callTypes;
  }

  

  public void setCallTypes(DescribeSoftphoneLayoutCallType[] callTypes) {
    this.callTypes = callTypes;
    callTypes__is_set = true;
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
   * element  : name of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo name__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","name","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean name__is_set = false;

  private String name;

  public String getName() {
    return name;
  }

  

  public void setName(String name) {
    this.name = name;
    name__is_set = true;
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
   
    __typeMapper.writeObject(__out, callTypes__typeInfo, callTypes, callTypes__is_set);
    __typeMapper.writeString(__out, id__typeInfo, id, id__is_set);
    __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
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
    if (__typeMapper.verifyElement(__in, callTypes__typeInfo)) {
      setCallTypes((DescribeSoftphoneLayoutCallType[])__typeMapper.readObject(__in, callTypes__typeInfo, DescribeSoftphoneLayoutCallType[].class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, id__typeInfo)) {
      setId((String)__typeMapper.readString(__in, id__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, name__typeInfo)) {
      setName((String)__typeMapper.readString(__in, name__typeInfo, String.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[DescribeSoftphoneLayoutResult ");
    
    sb.append(" callTypes=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(callTypes)+"'\n");
    sb.append(" id=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(id)+"'\n");
    sb.append(" name=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(name)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}