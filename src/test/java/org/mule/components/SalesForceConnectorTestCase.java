package org.mule.components;

import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;

import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.sobject.SObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SalesForceConnectorTestCase extends FunctionalTestCase
{

    private Document docBuilder;

    @Before
    public void initialise()
    {
        try
        {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        }
        catch (ParserConfigurationException e)
        {
            throw new RuntimeException(e);
        }

    }

    protected SalesForceConnector init()
    {

        SalesForceConnector sf = new SalesForceConnector();
        try
        {
            sf.initialise();
        }
        catch (InitialisationException e)
        {
            throw new RuntimeException(e);
        }

        sf.setUsername(System.getProperty("login"));
        sf.setPassword(System.getProperty("password"));
        sf.setSecurityToken(System.getProperty("securityKey"));

        return sf;
    }

    public void testConfig() throws Exception
    {
        SalesForceConnector sfdc = muleContext.getRegistry().get("salesforce");
        assertNotNull(sfdc.getUsername());
    }

    public void testContactCreate() throws Exception
    {
        SalesForceConnector sf = init();

        List<SObject> list = new ArrayList<SObject>();
        SObject sObject = new SObject();
        sObject.setType("Contact");

        Element el = docBuilder.createElement("FirstName");
        el.setTextContent("Mule");
        sObject.getAny().add(el);

        el = docBuilder.createElement("LastName");
        el.setTextContent("Developer");
        sObject.getAny().add(el);

        el = docBuilder.createElement("Department");
        el.setTextContent("Engineering");
        sObject.getAny().add(el);

        el = docBuilder.createElement("Title");
        el.setTextContent("Slacker Of An Engineer");
        sObject.getAny().add(el);

        el = docBuilder.createElement("Phone");
        el.setTextContent("333-333-3333");
        sObject.getAny().add(el);

        list.add(sObject);

        List<SaveResult> sr = sf.create(list);

        assertNotNull(sr);
        assertTrue(sr.size() > 0);
        assertTrue(sr.get(0).isSuccess());
        assertNotNull(sr.get(0).getId());

        // Now delete the item.
        List<String> ids = new ArrayList<String>();
        ids.add(sr.get(0).getId());
        List<DeleteResult> dr = sf.delete(ids);

        assertNotNull(dr);
        assertTrue(dr.size() > 0);
        assertTrue(dr.get(0).isSuccess());
    }

    public void testContactCreateAndDeleteConfig() throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("FirstName", "Mule");
        map.put("LastName", "Developer");
        map.put("Department", "Engineering");
        map.put("Title", "Slacker Of An Engineer");
        map.put("Phone", "333-333-3333");

        MuleClient client = new MuleClient(muleContext);
        MuleMessage result = client.send("vm://createContact", map, null);

        List<SaveResult> sr = (List<SaveResult>) result.getPayload();

        assertNotNull(sr);
        assertTrue(sr.size() > 0);
        assertTrue(sr.get(0).isSuccess());
        assertNotNull(sr.get(0).getId());

        // Now delete the item.
        List<String> ids = new ArrayList<String>();
        ids.add(sr.get(0).getId());
    }

    public void testContactCreateUpdateAndDeleteConfig() throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("FirstName", "Mule");
        map.put("LastName", "Developer");
        map.put("Department", "Engineering");
        map.put("Title", "Slacker Of An Engineer");
        map.put("Phone", "333-333-3333");

        MuleClient client = new MuleClient(muleContext);
        MuleMessage result = client.send("vm://createContact", map, null);

        List<SaveResult> sr = (List<SaveResult>) result.getPayload();

        assertNotNull(sr);
        assertTrue(sr.size() > 0);
        assertTrue(sr.get(0).isSuccess());
        assertNotNull(sr.get(0).getId());

        // Now delete the item.
        List<String> ids = new ArrayList<String>();
        ids.add(sr.get(0).getId());

        map.put("Id", sr.get(0).getId());
        map.put("LastName", "UpdateResult");

        result = client.send("vm://updateContact", map, null);

        sr = (List<SaveResult>) result.getPayload();
        assertNotNull(sr);
        assertTrue(sr.size() > 0);
        assertTrue(sr.get(0).isSuccess());
        assertNotNull(sr.get(0).getId());

        result = client.send("vm://deleteContact", ids, null);

        List<DeleteResult> dr = (List<DeleteResult>) result.getPayload();

        assertNotNull(dr);
        assertTrue(dr.size() > 0);
        assertTrue(dr.get(0).isSuccess());
    }

    public void testQueryAndRetrive() throws Exception
    {
        SalesForceConnector sf = init();

        QueryResult qr = sf.querySObject("SELECT Id, Name FROM Account WHERE Name='GenePoint'", 1);
        assertNotNull(qr);
        assertTrue(qr.getRecords().size() > 0);


        String Id = qr.getRecords().get(0).getId();
        List<String> Ids = new ArrayList<String>();
        Ids.add(Id);


        List<SObject> list = sf.retrieve("Name", "Account", Ids);
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    public void testQuery() throws Exception
    {
        SalesForceConnector sf = init();

        List<SObject> maps = sf.query("SELECT Id, Name FROM Account WHERE Name='GenePoint'", 1);
        assertNotNull(maps);
        assertTrue(maps.size() > 0);
    }

    public void testQueryConfig() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage result = client.send("vm://query", null, null);

        assertNotNull(result);
        assertNotNull(result.getPayload());
        List<HashMap<String, String>> maps = (List<HashMap<String, String>>) result.getPayload();
        assertTrue(maps.size() > 0);
    }

    public void testTransformerConfig() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage result = client.send("vm://transformerTest", null, null);

        assertNotNull(result);
    }


    @Override
    protected String getConfigResources()
    {
        return "sfdc-conf.xml";
    }
}
