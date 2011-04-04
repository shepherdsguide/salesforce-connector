/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.components.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MuleSObject extends HashMap<String, String>
{
    protected String type;
    protected List<MuleSObject> childern;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setFields(Map<String, String> fields)
    {
        this.putAll(fields);
    }

    public List<MuleSObject> getChildern()
    {
        if (childern == null)
        {
            childern = new ArrayList();
        }

        return childern;
    }

    public void setChildern(List<MuleSObject> childern)
    {
        this.childern = childern;
    }
}