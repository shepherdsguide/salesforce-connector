package org.mule.modules.salesforce;

import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.common.HashMapMessage;
import org.junit.Test;
import org.mockito.Mockito;
import org.mule.api.callback.SourceCallback;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesforceBayeuxMessageListenerTest {
    @Test
    public void testOnMessage() throws Exception {
        SourceCallback callback = Mockito.mock(SourceCallback.class);
        ClientSessionChannel clientSessionChannel = Mockito.mock(ClientSessionChannel.class);
        Message message = Mockito.mock(Message.class);
        when(message.getData()).thenReturn("DATA");
        
        SalesforceBayeuxMessageListener messageListener = new SalesforceBayeuxMessageListener(callback);
        messageListener.onMessage(clientSessionChannel, message);
        
        verify(callback, atLeastOnce()).process(any(String.class));
    }

    @Test
    public void testOnHashMapMessage() throws Exception {
        SourceCallback callback = Mockito.mock(SourceCallback.class);
        ClientSessionChannel clientSessionChannel = Mockito.mock(ClientSessionChannel.class);
        HashMapMessage message = Mockito.mock(HashMapMessage.class);
        HashMap data = Mockito.mock(HashMap.class);
        Map sObject = Mockito.mock(Map.class);
        Map event = Mockito.mock(Map.class);
        doReturn(true).when(message).containsKey("channel");
        doReturn("channel").when(message).get("channel");
        doReturn(true).when(message).containsKey("data");
        doReturn(data).when(message).get("data");
        doReturn(sObject).when(data).get("sobject");
        doReturn(event).when(data).get("event");

        SalesforceBayeuxMessageListener messageListener = new SalesforceBayeuxMessageListener(callback);
        messageListener.onMessage(clientSessionChannel, message);
        
        verify(callback, atLeastOnce()).process(any(Map.class), any(Map.class));
    }
}
