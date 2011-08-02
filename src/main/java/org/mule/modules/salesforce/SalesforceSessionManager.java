package org.mule.modules.salesforce;

import com.sforce.ws.ConnectionException;

/**
 * Salesforce sesssion management interface.
 *
 * This interface allows to query what is he user connected,
 * what the session id is and it might if necessary issue
 * a re-login to refresh the session information.
 */
public interface SalesforceSessionManager {
    /**
     * Name of the user logged into Salesforce
     *
     * @return A string representing the user
     */
    String getUsername();

    /**
     * Id of the session
     *
     * @return A string representing the session id
     */
    String getSessionId();

    /**
     * Attempt to login and acquire a session id
     */
    public void login() throws ConnectionException;
}
