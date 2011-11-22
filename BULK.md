The Salesforce Bulk API is based is optimized for loading or deleting large sets of data. It allows you to query, insert, update, upsert, or delete a large number of records asynchronously by submitting a number of batches which are processed in the background by Salesforce.

Our connector simplifies the model heavily making it very transparent and really easy. While the connectors works with concepts like Jobs and Batches, you will rarely see them except maybe in responses.

Creating/Updating/Upserting Objects in Bulk
------------------------------------------

Creating objects in bulk is as easy as creating objects without the bulk portion of it. Let's do a quick recap as to how the regular create works:

	<sfdc:create type="Account">
	    <sfdc:objects>
	        <sfdc:object>
	            <Name>MuleSoft</Name>
	            <BillingStreet>30 Maiden Lane</BillingStreet>
	            <BillingCity>San Francisco</BillingCity>
	            <BillingState>CA</BillingState>
	            <BillingPostalCode>94108</BillingPostalCode>
	            <BillingCountry>US</BillingCountry>
	        </sfdc:object>
	    </sfdc:objects>
	</sfdc:create>
	
That Mule config extract will create an SObject of type Account with the properties that you see. You can have as many objects as you want inside the objects collection. The output of this message processor will be a list of SaveResult. A SaveResult is compound object between a status and an Id. Meaning that it will tell you whenever or not the object got created successfully and what the Id of that object is.

The Bulk version of the create operation is named _create-bulk_ and shares the exact same signature.

	<sfdc:create-bulk type="Account">
	    <sfdc:objects>
	        <sfdc:object>
	            <Name>MuleSoft</Name>
	            <BillingStreet>30 Maiden Lane</BillingStreet>
	            <BillingCity>San Francisco</BillingCity>
	            <BillingState>CA</BillingState>
	            <BillingPostalCode>94108</BillingPostalCode>
	            <BillingCountry>US</BillingCountry>
	        </sfdc:object>
	    </sfdc:objects>
	</sfdc:create-bulk>
	
There are no practical differences. Of course, since it is a Bulk operation (meaning that the actual creation process will be handled by Salesforce in the background) we don't reply with a collection of SaveResults, because we do not have them yet. Instead we reply with a BatchInfo object with contains the id of the batch and the id of the job we just created to upload those objects.

This change in behavior remains true for all operations that support bulk.

Monitoring a Batch
------------------

You can monitor a Bulk API batch in Salesforce.

To track the status of bulk data load jobs and their associated batches, click *_Your Name_ | Setup | Monitoring | Bulk Data Load Jobs*. Click on the Job ID to view the job detail page.

The job detail page includes a related list of all the batches for the job. The related list provides _View Request_ and _View Response_ links for each batch. If the batch is a CSV file, the links return the request or response in CSV format. If the batch is an XML file, the links return the request or response in XML format. These links are available for batches created in API version 19.0 and later.