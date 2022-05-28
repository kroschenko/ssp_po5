import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private Queue<String> queue = new Queue<>();

    /**
     * Before.
     */
    @BeforeEach
    public void before() {
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
    }

    /**
     * After.
     */
    @AfterEach
    public void after() {
        queue.cleanUp();
    }

    /**
     * Is empty size equal 3 false.
     */
    @Test
    public void isEmpty_SizeEqual3_False() {
        assertFalse(queue.isEmpty());
    }

    /**
     * Is empty size equal 0 true.
     */
    @Test
    public void isEmpty_SizeEqual0_True() {
        queue.cleanUp();
        assertTrue(queue.isEmpty());
    }

    /**
     * Size size equal 3 success.
     */
    @Test
    public void size_SizeEqual3_Success() {
        assertEquals(3, queue.size());
    }

    /**
     * Size size equal 4 success.
     */
    @Test
    public void size_SizeEqual4_Success() {
        queue.enqueue("4");
        assertEquals(4, queue.size());
    }

    /**
     * Peek queue is empty throw exception.
     */
    @Test
    public void peek_QueueIsEmpty_ThrowException() throws NoSuchElementException {
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            queue.cleanUp();
            queue.peek();
        });
        assertEquals(thrown.getClass(), NoSuchElementException.class);
    }

    /**
     * Peek queue is not empty return 3.
     */
    @Test()
    public void peek_QueueIsNotEmpty_Return3() {
        assertEquals("3", queue.peek());
    }

    /**
     * Clean up size equal 3 success.
     */
    @Test
    public void cleanUp_SizeEqual3_Success() {
        assertEquals(3, queue.size());
        queue.cleanUp();
        assertEquals(0, queue.size());
    }

    /**
     * Enqueue size equal 3 success.
     */
    @Test
    public void enqueue_SizeEqual3_Success() {
        assertEquals(3, queue.size());
        queue.enqueue("4");
        assertEquals(4, queue.size());
    }

    /**
     * Dequeue size equal 3 success.
     */
    @Test
    public void dequeue_SizeEqual3_Success() {
        assertEquals("1", queue.dequeue());
    }

    /**
     * Dequeue queue is empty throw exception.
     */
    @Test
    public void dequeue_QueueIsEmpty_ThrowException() throws NoSuchElementException {
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            queue.cleanUp();
            assertEquals(0, queue.size());
            queue.dequeue();
        });
        assertEquals(thrown.getClass(), NoSuchElementException.class);
    }

    /**
     * Dequeue size equal 1 success.
     */
    @Test
    public void dequeue_SizeEqual1_Success() {
        queue.cleanUp();
        queue.enqueue("str");
        assertEquals("str", queue.dequeue());
        assertEquals(0, queue.size());
    }
}
