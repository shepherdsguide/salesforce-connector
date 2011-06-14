package org.mule.components.config;

import org.mule.components.SalesForce;
import org.mule.components.model.MuleSObject;
import org.mule.components.transformer.MuleSObjectsToString;
import org.mule.components.transformer.SObjectToString;
import org.mule.config.spring.handlers.AbstractPojoNamespaceHandler;
import org.mule.config.spring.parsers.collection.ChildMapEntryDefinitionParser;
import org.mule.config.spring.parsers.generic.ChildDefinitionParser;
import org.mule.config.spring.parsers.generic.OrphanDefinitionParser;
import org.mule.config.spring.parsers.specific.InvokerMessageProcessorDefinitionParser;
import org.mule.config.spring.parsers.specific.MessageProcessorDefinitionParser;

public class SalesForceNamespaceHandler extends AbstractPojoNamespaceHandler
{
    public void init()
    {
        registerMuleBeanDefinitionParser("config", new OrphanDefinitionParser(SalesForce.class, true)).addIgnored(
                "name");

        registerMuleBeanDefinitionParser("create", new ChildDefinitionParser("messageProcessor",
                SalesForceCreateFactoryBean.class));

        registerMuleBeanDefinitionParser("sObject", new ChildDefinitionParser("muleSObject", MuleSObject.class));
        registerMuleBeanDefinitionParser("field", new ChildMapEntryDefinitionParser("field"));

        registerMuleBeanDefinitionParser("create-sobjects", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "createSObjects", new String[]{"sObjects"}));

        registerMuleBeanDefinitionParser("convert-lead", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "convertLead", new String[]{"leadId", "contactId", "accountId",
                        "overWriteLeadSource", "doNotCreateOpportunity", "opportunityName", "convertedStatus", "sendEmailToOwner"}));

        registerMuleBeanDefinitionParser("delete", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "delete", new String[]{"ids"}));

        registerMuleBeanDefinitionParser("empty-recycle-bin", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "emptyrecyclebin", new String[]{"ids"}));

        registerMuleBeanDefinitionParser("get-deleted-range", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "getDeletedRange", new String[]{"type", "startTime", "endTime"}));

        registerMuleBeanDefinitionParser("get-deleted", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "getDeleted", new String[]{"type", "duration"}));

        registerMuleBeanDefinitionParser("get-updated-range", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "getUpdatedRange", new String[]{"type", "startTime", "endTime"}));

        registerMuleBeanDefinitionParser("get-updated", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "getUpdated", new String[]{"type", "duration"}));

        registerMuleBeanDefinitionParser("query", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "query", new String[]{"query", "batchsize"}));

        registerMuleBeanDefinitionParser("retrieve", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "retrieve", new String[]{"fields", "type", "ids"}));

        registerMuleBeanDefinitionParser("retrieve-sobjects", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "retrieveSObjects", new String[]{"fields", "type", "ids"}));

        registerMuleBeanDefinitionParser("update-sobjects", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "updateSObjects", new String[]{"type", "sObjects"}));

        registerMuleBeanDefinitionParser("update", new ChildDefinitionParser("messageProcessor",
                SalesForceUpdateFactoryBean.class));

        registerMuleBeanDefinitionParser("upsert", new ChildDefinitionParser("messageProcessor",
                SalesForceUpsertFactoryBean.class));

        registerMuleBeanDefinitionParser("upsert-sobjects", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "upsertSObjects", new String[]{"externalIdFieldName", "sObjects"}));

        registerMuleBeanDefinitionParser("set-password", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "setPassword", new String[]{"userId", "password"}));

        registerMuleBeanDefinitionParser("reset-password", new InvokerMessageProcessorDefinitionParser("messageProcessor",
                SalesForce.class, "resetPassword", new String[]{"userId"}));

        registerBeanDefinitionParser("sobject-to-string-transformer", new MessageProcessorDefinitionParser(SObjectToString.class));

        registerBeanDefinitionParser("mule-sobjects-to-string-transformer", new MessageProcessorDefinitionParser(MuleSObjectsToString.class));

    }
}
