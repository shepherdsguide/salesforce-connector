/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListUtilsTest {

    @Test
    public void evenSplitTest() {
        final List<List<Object>> sublists = ListUtils.split(getPopulatedList(10), 2, LinkedList.class);
        assertEquals(5, sublists.size());
        for (final List<Object> sublist : sublists) {
            assertEquals(2, sublist.size());
            assertTrue(sublist instanceof LinkedList<?>);
        }
    }

    @Test
    public void unevenSplitTest() {
        final List<List<Object>> sublists = ListUtils.split(getPopulatedList(10), 3, LinkedList.class);
        assertEquals(4, sublists.size());

        assertEquals(3, sublists.get(0).size());
        assertEquals(3, sublists.get(1).size());
        assertEquals(3, sublists.get(2).size());
        assertEquals(1, sublists.get(3).size());
    }

    @Test
    public void greaterThanSizeSplitTest() {
        final List<List<Object>> sublists = ListUtils.split(getPopulatedList(10), 20, LinkedList.class);
        assertEquals(1, sublists.size());
        assertEquals(10, sublists.get(0).size());
    }

    @Test
    public void emptyListSplitTest() {
        final List<List<Object>> sublists = ListUtils.split(Collections.emptyList(), 10, LinkedList.class);
        assertEquals(0, sublists.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeChunkSizeTest() {
        ListUtils.split(getPopulatedList(5), -10, LinkedList.class);
    }

    @Test
    public void invalidClassTest() {
        final List<List<Object>> sublists = ListUtils.split(getPopulatedList(10), 2, LinkedList.class);
        assertEquals(5, sublists.size());
        for (final List<Object> sublist : sublists) {
            assertEquals(2, sublist.size());
            assertTrue(sublist instanceof LinkedList<?>);
        }
    }

    private List<Object> getPopulatedList(final int size) {
        final List<Object> list = new ArrayList<Object>(10);
        for (int i = 0; i < 10; i++) {
            list.add(new Object());
        }

        return list;
    }
}
