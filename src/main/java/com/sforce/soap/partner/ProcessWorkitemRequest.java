package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class ProcessWorkitemRequest extends ProcessRequest {

  /**
   * Constructor
   */
  public ProcessWorkitemRequest() {
  }
    
  
  /**
   * element  : action of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo action__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","action","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean action__is_set = false;

  private String action;

  public String getAction() {
    return action;
  }

  

  public void setAction(String action) {
    this.action = action;
    action__is_set = true;
  }
  
  /**
   * element  : workitemId of type {urn:partner.soap.sforce.com}ID
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo workitemId__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","workitemId","urn:partner.soap.sforce.com","ID",1,1,true);

  private boolean workitemId__is_set = false;

  private String workitemId;

  public String getWorkitemId() {
    return workitemId;
  }

  

  public void setWorkitemId(String workitemId) {
    this.workitemId = workitemId;
    workitemId__is_set = true;
  }
  

  /**
   */
  public void write(javax.xml.namespace.QName __element,
      com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
      throws java.io.IOException {
    __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
    __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "ProcessWorkitemRequest");
    writeFields(__out, __typeMapper);
    __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
  }

  protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
      com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException {
   super.writeFields(__out, __typeMapper);
    __typeMapper.writeString(__out, action__typeInfo, action, action__is_set);
    __typeMapper.writeString(__out, workitemId__typeInfo, workitemId, workitemId__is_set);
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
    if (__typeMapper.verifyElement(__in, action__typeInfo)) {
      setAction((String)__typeMapper.readString(__in, action__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, workitemId__typeInfo)) {
      setWorkitemId((String)__typeMapper.readString(__in, workitemId__typeInfo, String.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ProcessWorkitemRequest ");
    sb.append(super.toString());
    sb.append(" action=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(action)+"'\n");
    sb.append(" workitemId=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(workitemId)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}