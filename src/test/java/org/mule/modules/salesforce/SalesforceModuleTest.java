package org.mule.modules.salesforce;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.construct.SimpleFlowConstruct;
import org.mule.tck.FunctionalTestCase;

public class SalesforceModuleTest extends FunctionalTestCase {
    @Override
    protected String getConfigResources() {
        return "test-config.xml";
    }


    @Test
    public void testPublishTopicFlow() throws Exception {
        String payload = "";
        SimpleFlowConstruct flow = lookupFlowConstruct("publishTopicFlow");
        MuleEvent event = getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);
        //assertEquals("", responseEvent.getMessage().getPayloadAsString());
    }


    /*
    @Test
    public void testQuery() throws Exception {
        String payload = "";
        SimpleFlowConstruct flow = lookupFlowConstruct("subscribeTopicFlow");
        MuleEvent event = getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);

        Thread.sleep(90000);

        //assertEquals("", responseEvent.getMessage().getPayloadAsString());
    }
    */

    private SimpleFlowConstruct lookupFlowConstruct(String name) {
        return (SimpleFlowConstruct) muleContext.getRegistry().lookupFlowConstruct(name);
    }
}
