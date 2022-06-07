package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueOneElementTest {
    Queue<String> queue = new Queue<>();

    @Before
    public void init() throws Exception {
        queue.enqueue("Test1");
    }

    @After
    public void queueClear() throws Exception {
        queue.clear();
    }

    @Test
    public void clear_when_queueIsFilledWithOneElement_should_returnEmptyResult() {
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertEquals("", queue.toString());
    }

    @Test
    public void isEmpty_when_queueIsFilledWithOneElement_should_returnIsNotEmpty() {
        assertFalse(queue.isEmpty());
    }

    @Test
    public void size_when_queueIsFilledWithOneElement_should_returnResultOne() {
        assertEquals(1, queue.size());
    }

    @Test
    public void peek_when_queueIsFilledWithOneElement_should_returnWorkingResult() {
        assertEquals(1, queue.size());
        assertEquals("Test1", queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void enqueue_when_queueIsAddedWithOneElement_should_returnWorkingResultAndDecreasedSize() {
        queue.enqueue("Test2");
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals("Test1 Test2 ", queue.toString());
    }

    @Test
    public void dequeue_when_queueIsErasedWithOneElement_should_returnWorkingResultAndErasedSize() {
        assertEquals(1, queue.size());
        assertEquals("Test1", queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void toString_when_queueIsFilledWithTwoElements_should_returnFilledString() {
        assertEquals("Test1 ", queue.toString());
    }
}
