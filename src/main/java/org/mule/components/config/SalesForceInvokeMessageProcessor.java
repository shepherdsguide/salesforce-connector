/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.components.config;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.components.model.MuleSObject;
import org.mule.processor.InvokerMessageProcessor;

import java.util.Map;

public class SalesForceInvokeMessageProcessor extends InvokerMessageProcessor
{

    @Override
    protected Object evaluateExpressionCandidate(Object expressionCandidate, MuleMessage message) throws TransformerException
    {
        if (expressionCandidate instanceof MuleSObject)
        {
            MuleSObject muleSObject = (MuleSObject) expressionCandidate;
            MuleSObject newMuleSObject = new MuleSObject();
            for (Map.Entry<String, String> entry : muleSObject.entrySet())
            {
                newMuleSObject.put(entry.getKey(), evaluateExpressionCandidate(entry.getValue(), message).toString());
            }
            return newMuleSObject;

        } else {
            return super.evaluateExpressionCandidate(expressionCandidate, message);
        }
    }
}
