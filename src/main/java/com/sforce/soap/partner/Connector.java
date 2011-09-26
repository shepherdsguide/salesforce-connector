package com.sforce.soap.partner;

import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

/**
 * Generated class, please do not edit.
 */
public class Connector {

  public static final String END_POINT = "https://prerellogin.pre.salesforce.com/services/Soap/u/22.0";

  public static PartnerConnection newConnection(String username, String password) throws ConnectionException {
    ConnectorConfig config = new ConnectorConfig();
    config.setUsername(username);
    config.setPassword(password);
    return newConnection(config);
  }

  public static PartnerConnection newConnection(ConnectorConfig config) throws ConnectionException {
    if (config.getAuthEndpoint() == null) {
      config.setAuthEndpoint(END_POINT);
    }
    if (config.getServiceEndpoint() == null) {
      config.setServiceEndpoint(END_POINT);
    }
    return new PartnerConnection(config);
  }
}