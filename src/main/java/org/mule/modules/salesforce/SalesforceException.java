package org.mule.modules.salesforce;

import com.sforce.soap.partner.StatusCode;

/**
 * A runtime exception that wraps a {@link StatusCode}
 */
public class SalesforceException extends Exception {
    private StatusCode statusCode;

    public SalesforceException(Throwable e) {
        super(e);
    }

    public SalesforceException(String message, Throwable e) {
        super(message, e);
    }

    public SalesforceException(StatusCode statusCode, String message) {
        super(message);

        this.statusCode = statusCode;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
