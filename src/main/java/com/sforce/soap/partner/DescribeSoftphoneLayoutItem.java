package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class DescribeSoftphoneLayoutItem implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public DescribeSoftphoneLayoutItem() {
  }
    
  
  /**
   * element  : itemApiName of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo itemApiName__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","itemApiName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean itemApiName__is_set = false;

  private String itemApiName;

  public String getItemApiName() {
    return itemApiName;
  }

  

  public void setItemApiName(String itemApiName) {
    this.itemApiName = itemApiName;
    itemApiName__is_set = true;
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
   
    __typeMapper.writeString(__out, itemApiName__typeInfo, itemApiName, itemApiName__is_set);
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
    if (__typeMapper.verifyElement(__in, itemApiName__typeInfo)) {
      setItemApiName((String)__typeMapper.readString(__in, itemApiName__typeInfo, String.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[DescribeSoftphoneLayoutItem ");
    
    sb.append(" itemApiName=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(itemApiName)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}