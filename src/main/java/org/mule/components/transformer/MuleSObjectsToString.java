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

import org.mule.api.transformer.TransformerException;
import org.mule.components.model.MuleSObject;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import java.util.List;
import java.util.Map;

public class MuleSObjectsToString extends AbstractTransformer
{
    public MuleSObjectsToString()
    {
        registerSourceType(DataTypeFactory.create(List.class));
        setReturnDataType(DataTypeFactory.TEXT_STRING);
    }

    @Override
    protected Object doTransform(Object src, String enc) throws TransformerException
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            List<MuleSObject> sObjects = (List<MuleSObject>) src;

            for (MuleSObject sObject : sObjects)
            {
                builder.append("SObject Type: ");
                builder.append(sObject.getType());
                for (Map.Entry<String, String> field : sObject.entrySet())
                {
                    builder.append("; Fields: \n");
                    builder.append(field.getKey());
                    builder.append(", ");
                    builder.append(field.getValue());
                }
            }


        } catch (Exception e)
        {
            throw new TransformerException(this, e);
        }

        return builder.toString();
    }
}
