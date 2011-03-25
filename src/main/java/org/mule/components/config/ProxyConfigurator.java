/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.components.config;

import com.sforce.soap.partner.Soap;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

/**
 * CXF specific configuration of the HTTP proxy
 */
public class ProxyConfigurator
{
    private Soap soap;

    public ProxyConfigurator(Soap soap)
    {
        super();
        this.soap = soap;
    }

    public void configure(String proxyHost, int proxyPort)
    {
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setProxyServer(proxyHost);
        httpClientPolicy.setProxyServerPort(proxyPort);

        Client client = ClientProxy.getClient(soap);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        http.setClient(httpClientPolicy);
    }
}


