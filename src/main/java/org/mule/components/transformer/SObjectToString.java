/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.components.transformer;

import com.sforce.soap.partner.sobject.SObject;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.w3c.dom.Element;

public class SObjectToString extends AbstractTransformer implements DiscoverableTransformer
{

    private int priorityWeighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public SObjectToString()
    {
        registerSourceType(DataTypeFactory.create(SObject.class));
        setReturnDataType(DataTypeFactory.TEXT_STRING);
    }

    @Override
    protected Object doTransform(Object src, String enc) throws TransformerException
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            SObject sObject = (SObject) src;

            builder.append("SObject Type: ");
            builder.append(sObject.getType());
            for (Object field : sObject.getAny())
            {
                Element el = (Element) field;
                builder.append("; Fields: \n");
                builder.append(el.getLocalName());
                builder.append(", ");
                builder.append(el.getFirstChild().getTextContent());
            }

        } catch (Exception e)
        {
            throw new TransformerException(this, e);
        }

        return builder.toString();
    }

    public int getPriorityWeighting()
    {
        return priorityWeighting;
    }

    public void setPriorityWeighting(int weighting)
    {
        priorityWeighting = weighting;
    }
}
