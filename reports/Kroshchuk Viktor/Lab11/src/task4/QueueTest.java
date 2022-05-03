package task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class QueueTest {
    private Queue<String> queue = new Queue<>();

    @Before
    public void before() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
    }

    @After
    public void after() {
        queue.cleanUp();
    }

    @Test
    public void isEmpty_SizeEqual3_False() {
        assertFalse(queue.isEmpty());
    }

    @Test
    public void isEmpty_SizeEqual0_True() {
        queue.cleanUp();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void size_SizeEqual3_Success() {
        assertEquals(3, queue.size());
    }

    @Test
    public void size_SizeEqual4_Success() {
        queue.enqueue("4");
        assertEquals(4, queue.size());
    }

    @Test
    public void peek_QueueIsEmpty_ThrowException() throws NoSuchElementException {
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            queue.cleanUp();
            queue.peek();
        });
        assertEquals(thrown.getClass(), NoSuchElementException.class);
    }

    @Test()
    public void peek_QueueIsNotEmpty_Return3() {
        assertEquals("3", queue.peek());
    }

    @Test
    public void cleanUp_SizeEqual3_Success() {
        assertEquals(3, queue.size());
        queue.cleanUp();
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueue_SizeEqual3_Success() {
        assertEquals(3, queue.size());
        queue.enqueue("4");
        assertEquals(4, queue.size());
    }

    @Test
    public void dequeue_SizeEqual3_Success() {
        assertEquals("1", queue.dequeue());
    }

    @Test
    public void dequeue_QueueIsEmpty_ThrowException() throws NoSuchElementException {
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            queue.cleanUp();
            assertEquals(0, queue.size());
            queue.dequeue();
        });
        assertEquals(thrown.getClass(), NoSuchElementException.class);
    }

    @Test
    public void dequeue_SizeEqual1_Success() {
        queue.cleanUp();
        queue.enqueue("str");
        assertEquals("str", queue.dequeue());
        assertEquals(0, queue.size());
    }
}