package org.mule.modules.salesforce;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

public class SalesforceLongPollingTransportTest {
    @Test
    public void testCreate() throws Exception {
        SalesforceModule salesforceModule = Mockito.mock(SalesforceModule.class);
        Map options = Mockito.mock(Map.class);

        SalesforceLongPollingTransport transport = SalesforceLongPollingTransport.create(salesforceModule, options);
    }
    
    
}
