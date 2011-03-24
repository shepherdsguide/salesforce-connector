/*
 * $Id:$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.components;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

public class SalesForceHeaderHandlerResolver implements HandlerResolver
{
    private String sessionId = null;


    public SalesForceHeaderHandlerResolver(String sessionId)
    {
        this.sessionId = sessionId;
    }


    public List<Handler> getHandlerChain(PortInfo portInfo)
    {
        List<Handler> handlerChain = new ArrayList<Handler>();
        SalesForceSoapHeaderHandler hh = new SalesForceSoapHeaderHandler(sessionId);
        handlerChain.add(hh);
        return handlerChain;
    }
}
