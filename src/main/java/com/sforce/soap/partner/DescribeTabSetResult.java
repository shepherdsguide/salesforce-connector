package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class DescribeTabSetResult implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public DescribeTabSetResult() {
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
   * element  : logoUrl of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo logoUrl__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","logoUrl","http://www.w3.org/2001/XMLSchema","string",1,1,true);

  private boolean logoUrl__is_set = false;

  private String logoUrl;

  public String getLogoUrl() {
    return logoUrl;
  }

  

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
    logoUrl__is_set = true;
  }
  
  /**
   * element  : namespace of type {http://www.w3.org/2001/XMLSchema}string
   * java type: java.lang.String
   */
  private static final com.sforce.ws.bind.TypeInfo namespace__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","namespace","http://www.w3.org/2001/XMLSchema","string",0,1,true);

  private boolean namespace__is_set = false;

  private String namespace;

  public String getNamespace() {
    return namespace;
  }

  

  public void setNamespace(String namespace) {
    this.namespace = namespace;
    namespace__is_set = true;
  }
  
  /**
   * element  : selected of type {http://www.w3.org/2001/XMLSchema}boolean
   * java type: boolean
   */
  private static final com.sforce.ws.bind.TypeInfo selected__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","selected","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

  private boolean selected__is_set = false;

  private boolean selected;

  public boolean getSelected() {
    return selected;
  }

  

  public boolean isSelected() {
    return selected;
  }

  

  public void setSelected(boolean selected) {
    this.selected = selected;
    selected__is_set = true;
  }
  
  /**
   * element  : tabs of type {urn:partner.soap.sforce.com}DescribeTab
   * java type: com.sforce.soap.partner.DescribeTab[]
   */
  private static final com.sforce.ws.bind.TypeInfo tabs__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","tabs","urn:partner.soap.sforce.com","DescribeTab",0,-1,true);

  private boolean tabs__is_set = false;

  private DescribeTab[] tabs = new DescribeTab[0];

  public DescribeTab[] getTabs() {
    return tabs;
  }

  

  public void setTabs(DescribeTab[] tabs) {
    this.tabs = tabs;
    tabs__is_set = true;
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
   
    __typeMapper.writeString(__out, label__typeInfo, label, label__is_set);
    __typeMapper.writeString(__out, logoUrl__typeInfo, logoUrl, logoUrl__is_set);
    __typeMapper.writeString(__out, namespace__typeInfo, namespace, namespace__is_set);
    __typeMapper.writeBoolean(__out, selected__typeInfo, selected, selected__is_set);
    __typeMapper.writeObject(__out, tabs__typeInfo, tabs, tabs__is_set);
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
    if (__typeMapper.verifyElement(__in, label__typeInfo)) {
      setLabel((String)__typeMapper.readString(__in, label__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, logoUrl__typeInfo)) {
      setLogoUrl((String)__typeMapper.readString(__in, logoUrl__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, namespace__typeInfo)) {
      setNamespace((String)__typeMapper.readString(__in, namespace__typeInfo, String.class));
    }
    __in.peekTag();
    if (__typeMapper.verifyElement(__in, selected__typeInfo)) {
      setSelected((boolean)__typeMapper.readBoolean(__in, selected__typeInfo, boolean.class));
    }
    __in.peekTag();
    if (__typeMapper.isElement(__in, tabs__typeInfo)) {
      setTabs((DescribeTab[])__typeMapper.readObject(__in, tabs__typeInfo, DescribeTab[].class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[DescribeTabSetResult ");
    
    sb.append(" label=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(label)+"'\n");
    sb.append(" logoUrl=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(logoUrl)+"'\n");
    sb.append(" namespace=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(namespace)+"'\n");
    sb.append(" selected=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(selected)+"'\n");
    sb.append(" tabs=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(tabs)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}