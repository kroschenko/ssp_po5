package com.spp.labs.stack;

import org.junit.*;
import static org.junit.Assert.*;


public class NotEmptyStackTest {
    Stack<String> s = new Stack<String>();
    
    @Before
    public void initBefore() {
        s.clear();
        s.push("3");
        s.push("2");
        s.push("1");
    }
    
    @After
    public void initAfter() {
        
    }
    
    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        
        s.clear();
        
        assertTrue(s.isEmpty());
        assertEquals(s.size(), 0);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        
        assertFalse(s.isEmpty());
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        
        assertEquals(s.size(), 3);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        
        s.push("0");
        
        assertEquals(s.size(), 4);
        assertEquals(s.search("3"), 3);
        assertEquals(s.peek(), "0");
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        
        assertEquals(s.pop(), "1");
        assertEquals(s.size(), 2);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        
        assertEquals(s.peek(), "1");
    }

    /**
     * Test of search method, of class Stack.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        
        assertEquals(s.search("1"), 0);
        assertEquals(s.search("2"), 1);
        assertEquals(s.search("3"), 2);
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        assertEquals(s.toString(), "1 2 3 ");
    }
}
