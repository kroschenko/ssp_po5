package com.spp.labs.stack;

import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;


public class EmptyStackTest {
    Stack<String> s = new Stack<String>();
    
    @Before
    public void initBefore() {
        s.clear();
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
        
        assertTrue(s.isEmpty());
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        
        assertEquals(s.size(), 0);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        
        s.push("1");
        
        assertEquals(s.size(), 1);
        assertEquals(s.search("1"), 0);
        assertEquals(s.peek(), "1");
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() throws NoSuchElementException {
        System.out.println("pop");
        
        try {
            s.pop();
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() throws NoSuchElementException {
        System.out.println("peek");
        
        try {
            s.peek();
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }
    }

    /**
     * Test of search method, of class Stack.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        
        assertEquals(s.search("1"), -1);
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        assertEquals(s.toString(), "");
    }
}
