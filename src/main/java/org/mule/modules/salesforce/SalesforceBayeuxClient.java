package org.mule.modules.salesforce;

import com.sforce.ws.ConnectionException;
import org.apache.log4j.Logger;
import org.cometd.bayeux.Message;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;

import java.net.ProtocolException;

/**
 * <p>{@link SalesforceBayeuxClient} is an extension of a {@link BayeuxClient} that can deal with Salesforce session
 * management.
 */
public class SalesforceBayeuxClient extends BayeuxClient {
    private static final Logger LOGGER = Logger.getLogger(SalesforceModule.class);
    private SalesforceModule module;

    /**
     * Create a new instance of this Bayeux client.
     *
     * @param module Parent {@link SalesforceModule}
     * @param url Url to connect to
     * @param transport  the default (mandatory) transport to use
     * @param transports additional optional transports to use in case the default transport cannot be used
     * @see #BayeuxClient(String, java.util.concurrent.ScheduledExecutorService, ClientTransport, ClientTransport...)
     */
    public SalesforceBayeuxClient(SalesforceModule module, String url, ClientTransport transport, ClientTransport... transports) {
        super(url, transport, transports);

        this.module = module;
        setCookies();
    }

    private void setCookies() {
        setCookie("com.salesforce.LocaleInfo", "us");
        setCookie("login", this.module.getUsername());
        setCookie("sid", this.module.getSessionId());
        setCookie("language", "en_US");
    }

    /**
     * <p>Callback method invoked when the given messages have failed to be sent.</p>
     * <p>The default implementation logs the failure at INFO level.</p>
     *
     * @param x        the exception that caused the failure
     * @param messages the messages being sent
     */
    public void onFailure(Throwable x, Message[] messages) {
        if (x instanceof ProtocolException) {
            LOGGER.info("Session seem to have expired. Attempting relogin...");
            LOGGER.warn(x.getMessage());
            try {
                this.module.login();
                setCookies();
            } catch (ConnectionException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            LOGGER.error(x.getMessage());
        }
    }
}
