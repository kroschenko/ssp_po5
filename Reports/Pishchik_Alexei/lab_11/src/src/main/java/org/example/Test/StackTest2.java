package org.example.Test;

import org.example.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest2 {
    Stack<String> stack;

    @Before
    public void setUpBeforTest() {
        stack = new Stack<>();
    }

    @Test
    public void testIsEmpty() {

        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testSize() {

        assertEquals(0, stack.size());
    }

    @Test
    public void testPush() {

        stack.push("555");
        assertEquals("555", stack.pop());
    }

    @Test
    public void testPeek() {

        stack.push("555");
        assertEquals("555", stack.peek());
    }

    @Test
    public void testToString() {
        stack.push("555");
        stack.push("444");
        stack.push("333");
        assertEquals("333 - 444 - 555", stack.toString());
    }
}
