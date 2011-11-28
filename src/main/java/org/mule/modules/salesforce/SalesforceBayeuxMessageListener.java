/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce;

import org.apache.log4j.Logger;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.common.HashMapMessage;
import org.mule.api.callback.SourceCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SalesforceBayeuxMessageListener implements ClientSessionChannel.MessageListener {
    private static final Logger LOGGER = Logger.getLogger(SalesforceBayeuxMessageListener.class);
    private final SourceCallback callback;

    public SalesforceBayeuxMessageListener(final SourceCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onMessage(ClientSessionChannel channel, Message message) {
        try {
            if (message instanceof HashMapMessage) {
                HashMapMessage hashMapMessage = (HashMapMessage) message;
                Map<String, Object> inboundProperties = new HashMap<String, Object>();
                if (!hashMapMessage.containsKey("channel")) {
                    LOGGER.error("The event does not contain the channel");
                } else {
                    inboundProperties.put("channel", hashMapMessage.get("channel"));
                }
                Map data;
                if (!hashMapMessage.containsKey("data")) {
                    LOGGER.error("The event does not contain any data?");
                } else {
                    data = (HashMap) hashMapMessage.get("data");
                    Map sObject = (Map) data.get("sobject");
                    Map event = (Map) data.get("event");
                    if (sObject == null) {
                        LOGGER.error("The data of the event does not contain an SObject");
                    } else {
                        if (event == null) {
                            LOGGER.error("The data of the event does not contain event information");
                        } else {
                            for (Map.Entry entry : (Set<Map.Entry>) event.entrySet()) {
                                inboundProperties.put((String) entry.getKey(), entry.getValue());
                            }
                            callback.process(sObject, inboundProperties);
                        }
                    }
                }
            } else {
                callback.process(message.getData());
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
