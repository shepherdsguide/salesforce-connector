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

import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.SessionHeader;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class SalesForceSoapHeaderHandler implements SOAPHandler<SOAPMessageContext>
{
    private String sessionId;

    public SalesForceSoapHeaderHandler(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public Set<QName> getHeaders()
    {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext soapMessageContext)
    {
        Boolean outboundProperty = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty)
        {
            SOAPMessage message = soapMessageContext.getMessage();
            QName sessionHeader = new QName("urn:partner.soap.sforce.com", "SessionHeader");
            QName sessionId = new QName("urn:enterprise.soap.sforce.com", "sessionId");

            try
            {
                SOAPEnvelope envelope = soapMessageContext.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();

                if (header == null)
                {
                    header = envelope.addHeader();
                }

                SOAPHeaderElement sessionHeaderElement = header.addHeaderElement(sessionHeader);
                SOAPElement sessionIdElement = sessionHeaderElement.addChildElement(sessionId);
                sessionIdElement.addTextNode(this.sessionId);

            } catch (SOAPException e)
            {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public boolean handleFault(SOAPMessageContext soapMessageContext)
    {
        return false;
    }

    public void close(MessageContext messageContext)
    {

    }
}
