package queue;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueEmptyTest {
    Queue<String> queue = new Queue<>();

    @After
    public void queueClear() throws Exception {
        queue.clear();
    }

    @Test
    public void clear_when_queueIsCleaned_should_returnEmptyResult() {
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertEquals("", queue.toString());
    }

    @Test
    public void isEmptyResult_when_queueIsCleaned_should_returnIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void size_when_queueIsCleaned_should_returnNullSize() {
        assertEquals(0, queue.size());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void peek_when_queueIsCleaned_should_returnException() {
        queue.peek();
    }

    @Test
    public void enqueue_when_queueIsAddedWithOneElement_should_returnWorkingResult() {
        queue.enqueue("Test1");
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals("Test1 ", queue.toString());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void dequeue_when_queueIsCleaned_should_returnException() {
        queue.dequeue();
    }

    @Test
    public void toString_when_queueIsCleaned_should_returnEmptyString() {
        assertEquals("", queue.toString());
    }
}