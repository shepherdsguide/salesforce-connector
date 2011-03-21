package org.mule.components;

import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.NullPayload;

public class SalesForceProxyTestCase extends FunctionalTestCase
{

    public void testQueryConfig() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage result = client.send("vm://proxy", null, null);

        assertNotNull(result);
        assertTrue(result.getPayload() == NullPayload.getInstance());
    }

    @Override
    protected String getConfigResources()
    {
        return "sfdc-proxy-test.xml";
    }
}
