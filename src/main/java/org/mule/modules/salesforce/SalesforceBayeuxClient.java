package org.mule.modules.salesforce;

import com.sforce.ws.ConnectionException;
import org.apache.log4j.Logger;
import org.cometd.bayeux.Channel;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;

import java.net.ProtocolException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>{@link SalesforceBayeuxClient} is an extension of a {@link BayeuxClient} that can deal with Salesforce session
 * management.
 */
public class SalesforceBayeuxClient extends BayeuxClient {
    private static final int HANDSHAKE_TIMEOUT = 30 * 1000;
    private static final Logger LOGGER = Logger.getLogger(SalesforceBayeuxClient.class);
    private Map<String, org.cometd.bayeux.client.ClientSessionChannel.MessageListener> subscriptions;
    private SalesforceSessionManager sessionManager;

    /**
     * Create a new instance of this Bayeux client.
     *
     * @param sessionManager Session information
     * @param url            Url to connect to
     * @param transport      the default (mandatory) transport to use
     * @param transports     additional optional transports to use in case the default transport cannot be used
     * @see #BayeuxClient(String, java.util.concurrent.ScheduledExecutorService, ClientTransport, ClientTransport...)
     */
    public SalesforceBayeuxClient(SalesforceSessionManager sessionManager, String url, ClientTransport transport, ClientTransport... transports) {
        super(url, transport, transports);

        this.sessionManager = sessionManager;
        this.subscriptions = Collections.synchronizedMap(new HashMap<String, ClientSessionChannel.MessageListener>());
        setCookies();

        getChannel(Channel.META_HANDSHAKE).addListener(new ClientSessionChannel.MessageListener() {
            public void onMessage(ClientSessionChannel channel, Message message) {
                if (message.isSuccessful()) {
                    for( String subscriptionChannel : subscriptions.keySet() ) {
                        LOGGER.info("Subscribing to channel: " + subscriptionChannel);
                        getChannel(subscriptionChannel).subscribe(subscriptions.get(subscriptionChannel));
                    }
                }
            }
        });
    }

    private void setCookies() {
        setCookie("com.salesforce.LocaleInfo", "us");
        setCookie("login", this.sessionManager.getUsername());
        setCookie("sid", this.sessionManager.getSessionId());
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
            LOGGER.info("Session seem to have expired...");
            LOGGER.debug(x);
            try {
                disconnect();
                this.sessionManager.login();
                setCookies();
                handshake(HANDSHAKE_TIMEOUT);
            } catch (ConnectionException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            LOGGER.error(x.getMessage());
        }
    }

    @Override
    public void handshake() {
        super.handshake(HANDSHAKE_TIMEOUT);
    }

    public void subscribe(String channel, ClientSessionChannel.MessageListener messageListener) {
        this.subscriptions.put(channel, messageListener);

        if (isHandshook()) {
            getChannel(channel).subscribe(messageListener);
        }
    }
}
