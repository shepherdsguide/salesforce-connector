package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class DataCategoryGroupSobjectTypePair implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public DataCategoryGroupSobjectTypePair() {
  }
    
  
  /**
   * element  : dataCategoryGroupName of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo dataCategoryGroupName__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","dataCategoryGroupName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean dataCategoryGroupName__is_set = false;

  private String dataCategoryGroupName;

  public String getDataCategoryGroupName() {
    return dataCategoryGroupName;
  }

  

  public void setDataCategoryGroupName(String dataCategoryGroupName) {
    this.dataCategoryGroupName = dataCategoryGroupName;
    dataCategoryGroupName__is_set = true;
  }
  
  /**
   * element  : sobject of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo sobject__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","sobject","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean sobject__is_set = false;

  private String sobject;

  public String getSobject() {
    return sobject;
  }

  

  public void setSobject(String sobject) {
    this.sobject = sobject;
    sobject__is_set = true;
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
   
    __typeMapper.writeString(__out, dataCategoryGroupName__typeInfo, dataCategoryGroupName, dataCategoryGroupName__is_set);
    __typeMapper.writeString(__out, sobject__typeInfo, sobject, sobject__is_set);
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
    if (__typeMapper.verifyElement(__in, dataCategoryGroupName__typeInfo)) {
      setDataCategoryGroupName((String)__typeMapper.readString(__in, dataCategoryGroupName__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, sobject__typeInfo)) {
      setSobject((String)__typeMapper.readString(__in, sobject__typeInfo, String.class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[DataCategoryGroupSobjectTypePair ");
    
    sb.append(" dataCategoryGroupName=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(dataCategoryGroupName)+"'\n");
    sb.append(" sobject=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(sobject)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}