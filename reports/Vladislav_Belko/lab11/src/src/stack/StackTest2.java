package stack;

import org . junit .*;
import static org . junit . Assert .*;

public class StackTest2 {

    Stack<String> stack;

    @Before
    public void setUpBeforTest(){
        stack = new Stack<>();
    }

    @Test
    public void testIsEmpty(){

        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testSize(){

        assertEquals(0, stack.size());
    }

    @Test
    public void testPush(){

        stack.push("5");
        assertEquals("5", stack.pop());
    }

    @Test
    public void testPeek(){

        stack.push("5");
        assertEquals("5", stack.peek());
    }

    @Test
    public void testToString(){
        stack.push("5");
        stack.push("4");
        stack.push("3");
        assertEquals("3 - 4 - 5", stack.toString());
    }
}
