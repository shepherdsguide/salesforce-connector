package org.mule.components;

import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.components.model.MuleSObject;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.NullPayload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
