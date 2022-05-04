package com.company.three_task.test;

import com.company.three_task.Stack;
import org.junit.*;

public class EmptyStackTest {
    private final Stack<String> stack = new Stack<>();

    @Test
    public void assertIsEmpty() {
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void assertSize() {
        Assert.assertEquals(0, stack.size());
    }
    @Test
    public void assertPush() {
        String str = "String";
        stack.push(str);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(str + " ", stack.toString());
    }
    @Test(expected = java.util.NoSuchElementException.class)
    public void assertPop() {
        stack.pop();
    }
    @Test(expected = java.util.NoSuchElementException.class)
    public void assertPeek() {
        stack.peek();
    }
    @Test
    public void assertClear() {
        stack.clear();

        Assert.assertTrue(stack.isEmpty());
        Assert.assertEquals(0, stack.size());
        Assert.assertEquals("", stack.toString());
    }

    @Test
    public void assertToString() {
        Assert.assertEquals("", stack.toString());
    }

    @After
    public void clearStack(){
        stack.clear();
    }
}