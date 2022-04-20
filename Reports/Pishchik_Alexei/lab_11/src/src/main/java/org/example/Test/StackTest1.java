package org.example.Test;

import org.example.Stack;
import org.junit.Before;
import org.junit.Test;

public class StackTest1 {
    Stack<String> stack;

    @Before
    public void setUpBeforTest() {
        stack = new Stack<>();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPop() {
        stack.pop();
    }

    @Test (expected = java.util.NoSuchElementException.class)
    public void testPeek() {
        stack.peek();
    }
}
