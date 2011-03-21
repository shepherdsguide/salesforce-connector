SalesForce
==========

Mule SafeForce Connector

Installation
------------

The connector can either be installed for all applications running within the Mule instance or can be setup to be used
for a single application.

*All Applications*

Download the connector from the link above and place the resulting jar file in
/lib/user directory of the Mule installation folder.

*Single Application*

To make the connector available only to single application then place it in the
lib directory of the application otherwise if using Maven to compile and deploy
your application the following can be done:

Add the connector's maven repo to your pom.xml:

    <repositories>
        <repository>
            <id>muleforge.webdav.releases</id>
            <name>MuleForge Releases</name>
            <url>https://repository.muleforge.org/release/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-sfdc</artifactId>
        <version>3.0.1</version>
    </dependency>

Configuration
-------------

You can configure the connector as follows:

    <sfdc:config username="value" password="value" securityToken="value" proxyHost="value" proxyPort="value"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|name|Give a name to this configuration so it can be later referenced by config-ref.|yes||
|username||no|
|password||no|
|securityToken||no|
|proxyHost||no|
|proxyPort||no|













Create S Objects
----------------

Adds one or more new records to your organization�s data. This specific call
is different from create() in that it takes true sObjects versus mule specific
MuleSObjects

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|sObjects| Salesforce specific sObjects.|no||

Create
------

Adds one or more new records to your organization�s data. This call differs
from the original create object by allowing for the setting of the type as part
of the method call along with the passing of a MuleSObject which is just an object
which extends a hashmap.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|sObjects||no||

Convert Lead
------------

Converts a Lead into an Account, Contact, or (optionally) an Opportunity.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|leadId|                 ID of the Lead to convert. Required. For information on IDs, see ID Field Type.|no||
|contactId|              ID of the Contact into which the lead will be merged (this contact must be
                              associated with the specified accountId, and an accountId must be specified).
                              Required only when updating an existing contact.IMPORTANT if you are converting
                              a lead into a person account, do not specify the contactId or an error will result.
                              Specify only the accountId of the person account. If no contactID is specified,
                              then the API creates a new contact that is implicitly associated with the Account.
                              To create a new contact, the client application must be logged in with sufficient
                              access rights. To merge a lead into an existing contact, the client application
                              must be logged in with read/write access to the specified contact. The contact
                              name and other existing data are not overwritten (unless overwriteLeadSource is
                              set to true, in which case only the LeadSource field is overwritten).
                              For information on IDs, see ID Field Type.|no||
|accountId|              ID of the Account into which the lead will be merged. Required
                              only when updating an existing account, including person accounts.
                              If no accountID is specified, then the API creates a new account. To
                              create a new account, the client application must be logged in with
                              sufficient access rights. To merge a lead into an existing account,
                              the client application must be logged in with read/write access to the
                              specified account. The account name and other existing data are not overwritten.
                              For information on IDs, see ID Field Type.|no||
|overWriteLeadSource|    Specifies whether to overwrite the LeadSource field on the target Contact object
                              with the contents of the LeadSource field in the source Lead object (true), or
                              not (false, the default). To set this field to true, the client application
                              must specify a contactId for the target contact.|no||
|doNotCreateOpportunity| Specifies whether to create an Opportunity during lead conversion (false, the
                              default) or not (true). Set this flag to true only if you do not want to create
                              an opportunity from the lead. An opportunity is created by default.|no||
|opportunityName|        Name of the opportunity to create. If no name is specified, then this value
                              defaults to the company name of the lead. The maximum length of this field is
                              80 characters. If doNotCreateOpportunity argument is true, then no Opportunity
                              is created and this field must be left blank; otherwise, an error is returned.|no||
|convertedStatus|        Valid LeadStatus value for a converted lead. Required.
                              To obtain the list of possible values, the client application queries the
                              LeadStatus object, as in:
                              Select Id, MasterLabel from LeadStatus where IsConverted=true|no||
|sendEmailToOwner|       Specifies whether to send a notification email to the owner specified in the
                              ownerId (true) or not (false, the default).|no||

Delete
------

Use delete() to delete one or more existing records, such as individual accounts or contacts, in your
organization�s data. The delete() call is analogous to the DELETE statement in SQL.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|ids| Array of one or more IDs associated with the objects to delete. In version 7.0 and later,
           you can pass a maximum of 200 object IDs to the delete() call. In version 6.0 and earlier,
           the limit is 2,000.|no||

Emptyrecyclebin
---------------

The recycle bin lets you view and restore recently deleted records for 30 days before they are
permanently deleted. Your organization can have up to 5000 records per license in the Recycle Bin at any
one time. For example, if your organization has five user licenses, 25,000 records can be stored in the
Recycle Bin. If your organization reaches its Recycle Bin limit, Salesforce.com automatically removes
the oldest records, as long as they have been in the recycle bin for at least two hours.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|ids| Array of one or more IDs associated with the records to delete from the recycle bin.
           Maximum number of records is 200.|no||


Get Deleted
-----------

Retrieves the list of individual records that have been deleted between the range of now to the duration before now.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|type|     Object type. The specified value must be a valid object for your organization.|no||
|duration| The amount of time in minutes before now for which to return records from.|no||


Get Updated
-----------

Retrieves the list of individual objects that have been updated (added or changed) within the given from now to
the number of minutes previous

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|type|     Object type. The specified value must be a valid object for your organization.|no||
|duration||no||

Invalidate Sessions
-------------------

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|sessionIds||no||

Submit Request
--------------

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|comments||no||
|id||no||
|approverIds||no||

Process
-------

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|action||no||
|id||no||
|comments||no||
|approverIds||no||

Query
-----

Executes a query against the specified object and returns data that matches the specified criteria.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|query|     Query string that specifies the object to query, the fields to return, and any conditions for
                 including a specific object in the query.|no||
|batchsize| The amount of records to return|no||


Retrieve S Objects
------------------

Retrieves one or more records based on the specified IDs.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|fields| List of one or more fields in the specified object, separated by commas. You must specify valid
              field names and must have read-level permissions to each specified field. The fieldList defines
              the ordering of fields in the result.|no||
|type|   Object from which to retrieve data.|no||
|ids|    Array of one or more IDs of the objects to retrieve. You can pass a maximum of 2000 object IDs to
              the retrieve() call.|no||

Retrieve
--------

Retrieves one or more records based on the specified IDs.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|fields| List of one or more fields in the specified object, separated by commas. You must specify valid
              field names and must have read-level permissions to each specified field. The fieldList defines
              the ordering of fields in the result.|no||
|type|   Object from which to retrieve data.|no||
|ids|    Array of one or more IDs of the objects to retrieve. You can pass a maximum of 2000 object IDs to
              the retrieve() call.|no||

Update S Objects
----------------

Use this call to update one or more existing records, such as accounts or contacts, in your organization�s data.
The update() call is analogous to the UPDATE statement in SQL.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|sObjects||no||

Update
------

Use this call to update one or more existing records, such as accounts or contacts, in your organization�s data.
The update() call is analogous to the UPDATE statement in SQL.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|sObjects| Mule specific SObject which is extends a hashmap.|no||

Upsert
------

Creates new records and updates existing records; uses a custom field to determine the presence of existing
records. In most cases, we recommend that you use upsert() instead of create() to avoid creating unwanted
duplicate records (idempotent). Available in the API version 7.0 and later. You can process records for one
more than object type in an create() or update() call, but all records must have the same object type in an
upsert() call.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|externalIdFieldName| Contains the name of the field on this object with the external ID field attribute
                           for custom objects or the idLookup field property for standard objects. The idLookup
                           field property is usually on a field that is the object's ID field or name field, but
                           there are exceptions, so check for the presence of the property in the object you wish
                           to upsert().|no||
|sObjects||no||

Upsert S Object
---------------

Creates new records and updates existing records; uses a custom field to determine the presence of existing
records. In most cases, we recommend that you use upsert() instead of create() to avoid creating unwanted
duplicate records (idempotent). Available in the API version 7.0 and later. You can process records for one
more than object type in an create() or update() call, but all records must have the same object type in an
upsert() call.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|externalIdFieldName| Contains the name of the field on this object with the external ID field attribute
                           for custom objects or the idLookup field property for standard objects. The idLookup
                           field property is usually on a field that is the object's ID field or name field, but
                           there are exceptions, so check for the presence of the property in the object you wish
                           to upsert().|no||
|sObjects||no||














