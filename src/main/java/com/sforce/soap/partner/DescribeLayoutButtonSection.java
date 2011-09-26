package com.sforce.soap.partner;

/**
 * Generated class, please do not edit.
 */
public class DescribeLayoutButtonSection implements com.sforce.ws.bind.XMLizable {

  /**
   * Constructor
   */
  public DescribeLayoutButtonSection() {
  }
    
  
  /**
   * element  : detailButtons of type {urn:partner.soap.sforce.com}DescribeLayoutButton
   * java type: com.sforce.soap.partner.DescribeLayoutButton[]
   */
  private static final com.sforce.ws.bind.TypeInfo detailButtons__typeInfo =
    new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","detailButtons","urn:partner.soap.sforce.com","DescribeLayoutButton",1,-1,true);

  private boolean detailButtons__is_set = false;

  private DescribeLayoutButton[] detailButtons = new DescribeLayoutButton[0];

  public DescribeLayoutButton[] getDetailButtons() {
    return detailButtons;
  }

  

  public void setDetailButtons(DescribeLayoutButton[] detailButtons) {
    this.detailButtons = detailButtons;
    detailButtons__is_set = true;
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
   
    __typeMapper.writeObject(__out, detailButtons__typeInfo, detailButtons, detailButtons__is_set);
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
    if (__typeMapper.verifyElement(__in, detailButtons__typeInfo)) {
      setDetailButtons((DescribeLayoutButton[])__typeMapper.readObject(__in, detailButtons__typeInfo, DescribeLayoutButton[].class));
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[DescribeLayoutButtonSection ");
    
    sb.append(" detailButtons=");
    sb.append("'"+com.sforce.ws.util.Verbose.toString(detailButtons)+"'\n");
    sb.append("]\n");
    return sb.toString();
  }
}