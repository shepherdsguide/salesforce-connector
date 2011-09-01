package org.mule.modules.salesforce;

import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.apache.log4j.Logger;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.HttpClientTransport;
import org.cometd.client.transport.LongPollingTransport;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SalesforceSession {
    private static final Logger LOGGER = Logger.getLogger(SalesforceSession.class);
    private static final int pollTimeout = 120000;


    /**
     * Partner connection
     */
    private PartnerConnection connection;

    /**
     * Login result
     */
    private LoginResult loginResult;

    /**
     * Bayeux client
     */
    private SalesforceBayeuxClient bc;

    public SalesforceSession(URL endpoint, String username, String password, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) throws ConnectionException {
        this.connection = Connector.newConnection(createConnectorConfig(endpoint, username, password, proxyHost, proxyPort, proxyUsername, proxyPassword));

    }

    public void initialize() throws ConnectionException {
        LOGGER.debug("Creating a Salesforce session using " + this.connection.getConfig().getUsername());
        this.loginResult = this.connection.login(this.connection.getConfig().getUsername(), this.connection.getConfig().getPassword());

        if( this.loginResult.isPasswordExpired() )
            throw new ConnectionException("The password for the user " + this.connection.getConfig().getUsername() + " has expired");

        LOGGER.debug("Session established sucessfully with ID " + this.loginResult.getSessionId() + " at instance " + this.loginResult.getServerUrl());
        this.connection.getSessionHeader().setSessionId(this.loginResult.getSessionId());
        this.connection.getConfig().setServiceEndpoint(this.loginResult.getServerUrl());

        try {
            if (this.bc == null) {
                Map<String, Object> options = new HashMap<String, Object>();
                options.put(ClientTransport.TIMEOUT_OPTION, pollTimeout);

                HttpClientTransport clientTransport = LongPollingTransport.create(options);

                URL serviceEndpoint = new URL(this.connection.getConfig().getServiceEndpoint());
                this.bc = new SalesforceBayeuxClient(this, "https://" + serviceEndpoint.getHost() + "/cometd", clientTransport);

                if (!this.bc.isHandshook()) {
                    this.bc.handshake();
                }
            }
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }

    }

    public void destroy() {
        if (this.bc != null) {
            if (this.bc.isConnected()) {
                this.bc.disconnect();
            }
        }

        if (this.connection != null) {
            try {
                this.connection.logout();
                this.loginResult = null;
            } catch (ConnectionException ce) {
                LOGGER.error(ce);
            }
        }

    }

    private ConnectorConfig createConnectorConfig(URL endpoint, String username, String password, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(username);
        config.setPassword(password);

        config.setAuthEndpoint(endpoint.toString());
        config.setServiceEndpoint(endpoint.toString());

        config.setManualLogin(true);

        if (proxyHost != null) {
            config.setProxy(proxyHost, proxyPort);
            if (proxyUsername != null) {
                config.setProxyUsername(proxyUsername);
            }
            if (proxyPassword != null) {
                config.setProxyPassword(proxyPassword);
            }
        }

        return config;
    }

    public PartnerConnection getConnection() {
        return connection;
    }

    public LoginResult getLoginResult() {
        return loginResult;
    }

    public SalesforceBayeuxClient getBayeuxClient() {
        return bc;
    }
}
