package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class DescribeDataCategoryGroupStructureResult implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public DescribeDataCategoryGroupStructureResult() {
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
   * element  : label of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo label__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","label","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean label__is_set = false;

  private String label;

  public String getLabel() {
    return label;
  }

  

  public void setLabel(String label) {
    this.label = label;
    label__is_set = true;
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
   * element  : topCategories of type {urn:partner.soap.sforce.com}DataCategory
   * java type: com.sforce.soap.partner.DataCategory[]
   */
  private static final com.sforce.ws.bind.TypeInfo topCategories__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","topCategories","urn:partner.soap.sforce.com","DataCategory",0,-1,true);

  private boolean topCategories__is_set = false;

  private DataCategory[] topCategories = new DataCategory[0];

  public DataCategory[] getTopCategories() {
    return topCategories;
  }

  

  public void setTopCategories(DataCategory[] topCategories) {
    this.topCategories = topCategories;
    topCategories__is_set = true;
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
   
    __typeMapper.writeString(__out, description__typeInfo, description, description__is_set);
    __typeMapper.writeString(__out, label__typeInfo, label, label__is_set);
    __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
    __typeMapper.writeString(__out, sobject__typeInfo, sobject, sobject__is_set);
    __typeMapper.writeObject(__out, topCategories__typeInfo, topCategories, topCategories__is_set);
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
    if (__typeMapper.verifyElement(__in, description__typeInfo)) {
      setDescription((String)__typeMapper.readString(__in, description__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, label__typeInfo)) {
      setLabel((String)__typeMapper.readString(__in, label__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, name__typeInfo)) {
      setName((String)__typeMapper.readString(__in, name__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, sobject__typeInfo)) {
      setSobject((String)__typeMapper.readString(__in, sobject__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, topCategories__typeInfo)) {
      setTopCategories((DataCategory[])__typeMapper.readObject(__in, topCategories__typeInfo, DataCategory[].class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[DescribeDataCategoryGroupStructureResult ");
    
    sb.append(" description=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(description)+"'\n");
    sb.append(" label=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(label)+"'\n");
    sb.append(" name=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(name)+"'\n");
    sb.append(" sobject=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(sobject)+"'\n");
    sb.append(" topCategories=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(topCategories)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}