package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class Testing {
    Stack<String> stack;

    @Before
    public void setUpBeforTest() {
        stack = new Stack<>();
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("TestItem");
        assertFalse(stack.isEmpty());
    }
    @Test
    public void size() {
        assertEquals(0,stack.size());
        stack.push("FirstItem");
        stack.push("SecondItem");
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void push() {
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
        stack.push("FirstItem");
        assertEquals(1,stack.size());
        assertFalse(stack.isEmpty());
        stack.push("SecondItem");
        assertEquals(2,stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("SecondItem", stack.peek());
    }

    @Test
    public void pop() {
        stack.push("FirstItem");
        stack.push("SecondItem");
        assertEquals(stack.pop(), "SecondItem");
        assertEquals(stack.pop(), "FirstItem");
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void peek() {
        stack.push("FirstItem");
        stack.push("SecondItem");
        assertEquals("SecondItem", stack.peek());
        stack.pop();
        assertEquals("FirstItem", stack.peek());
    }
}