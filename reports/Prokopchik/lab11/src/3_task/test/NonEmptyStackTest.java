package com.company.three_task.test;

import com.company.three_task.Stack;
import org.junit.*;

public class NonEmptyStackTest {
    private final Stack<String> stack = new Stack<>();

    @Before
    public void setUp() {
        stack.push("string1");
        stack.push("string2");
    }

    @Test
    public void assertIsEmpty() {
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void assertSize() {
        Assert.assertEquals(2, stack.size());
    }

    @Test
    public void assertPeek() {
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals("string2", stack.peek());
        Assert.assertEquals(2, stack.size());
    }

    @Test
    public void assertPush() {
        String str = "string3";
        stack.push(str);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(str + " string2 string1 ", stack.toString());
    }

    @Test
    public void assertPop() {
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals("string2", stack.pop());
        Assert.assertEquals(1, stack.size());
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
        Assert.assertEquals("string2 string1 ", stack.toString());
    }

    @After
    public void clearStack() {
        stack.clear();
    }
}
