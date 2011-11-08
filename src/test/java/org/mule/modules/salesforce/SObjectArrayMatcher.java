package org.mule.modules.salesforce;

import com.sforce.soap.partner.sobject.SObject;
import org.mockito.ArgumentMatcher;

public class SObjectArrayMatcher extends ArgumentMatcher<SObject[]> {
    @Override
    public boolean matches(Object o) {
        if( o != null ) {
            if( o.getClass().isArray() ) {
                return true;
            }
        }

        return false;
    }
}
