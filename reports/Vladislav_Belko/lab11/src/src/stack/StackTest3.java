package stack;

import org . junit .*;
import static org . junit . Assert .*;

public class StackTest3 {

    Stack<String> stack;

    @Before
    public void setUpBeforTest(){
        stack = new Stack<>();
        stack.push("5");
        stack.push("4");
        stack.push("3");
    }

    @Test
    public void testPush(){

        assertEquals("3", stack.pop());
    }

    @Test
    public void testPeek(){

        assertEquals("3", stack.peek());
    }

    @Test
    public void testToString(){

        assertEquals("3 - 4 - 5", stack.toString());
    }
}
