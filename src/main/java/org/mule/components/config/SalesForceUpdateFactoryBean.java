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

import org.mule.components.SalesForce;
import org.mule.components.model.MuleSObject;
import org.mule.processor.InvokerMessageProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

public class SalesForceUpdateFactoryBean
        implements FactoryBean<SalesForceInvokeMessageProcessor>, ApplicationContextAware
{

    protected List<MuleSObject> muleSObjects;
    protected Object config;
    protected String type;

    protected ApplicationContext appContext;

    public SalesForceInvokeMessageProcessor getObject() throws Exception
    {
        SalesForceInvokeMessageProcessor invokerMessageProcessor = new SalesForceInvokeMessageProcessor();
        List<Object> args = new ArrayList<Object>();
        args.add(type);
        args.add(muleSObjects);
        invokerMessageProcessor.setArguments(args);
        invokerMessageProcessor.setMethodName("update");
        if (appContext.getBean(SalesForce.class) != null)
        {
            invokerMessageProcessor.setObject(appContext.getBean(SalesForce.class));

        } else
        {
            invokerMessageProcessor.setObject(config);

        }
        return invokerMessageProcessor;
    }

    public Class<SalesForceInvokeMessageProcessor> getObjectType()
    {
        return SalesForceInvokeMessageProcessor.class;
    }

    public boolean isSingleton()
    {
        return false;
    }

    public void setMuleSObjects(List<MuleSObject> sObjects)
    {
        this.muleSObjects = sObjects;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.appContext = applicationContext;
    }

    public void setConfig(Object config)
    {
        this.config = config;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
