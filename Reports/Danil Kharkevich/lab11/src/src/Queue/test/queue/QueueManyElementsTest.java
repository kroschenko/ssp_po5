package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueManyElementsTest {
    Queue<String> queue = new Queue<>();

    @Before
    public void init() throws Exception {
        queue.enqueue("Test1");
        queue.enqueue("Test2");
    }

    @After
    public void queueClear() throws Exception {
        queue.clear();
    }

    @Test
    public void clear_when_queueIsFilledWithTwoElements_should_returnEmptyResult() {
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertEquals("", queue.toString());
    }

    @Test
    public void isEmpty_when_queueIsFilledWithTwoElements_should_returnIsNotEmpty() {
        assertFalse(queue.isEmpty());
    }

    @Test
    public void size_when_queueIsFilledWithTwoElements_should_returnResultTwo() {
        assertEquals(2, queue.size());
    }

    @Test
    public void peek_when_queueIsFilledWithTwoElements_should_returnWorkingResult() {
        assertEquals(2, queue.size());
        assertEquals("Test1", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void enqueue_when_queueIsAddedWithOneElement_should_returnWorkingResultAndDecreasedSize() {
        queue.enqueue("Test3");
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        assertEquals("Test1 Test2 Test3 ", queue.toString());
    }

    @Test
    public void dequeue_when_queueIsErasedWithOneElement_should_returnWorkingResultAndErasedSize() {
        assertEquals(2, queue.size());
        assertEquals("Test1", queue.dequeue());
        assertEquals(1, queue.size());
    }

    @Test
    public void toString_when_queueIsFilledWithTwoElements_should_returnFilledString() {
        assertEquals("Test1 Test2 ", queue.toString());
    }
}
