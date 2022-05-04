package org.example.Test;

import org.example.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest3 {

    Stack<String> stack;

    @Before
    public void setUpBeforTest() {
        stack = new Stack<>();
        stack.push("555");
        stack.push("444");
        stack.push("333");
    }

    @Test
    public void testPush() {

        assertEquals("333", stack.pop());
    }

    @Test
    public void testPeek() {

        assertEquals("333", stack.peek());
    }

    @Test
    public void testToString() {

        assertEquals("333 - 444 - 555", stack.toString());
    }
}
