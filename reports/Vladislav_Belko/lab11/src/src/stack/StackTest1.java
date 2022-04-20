package stack;

import org.junit.*;
import static org.junit.Assert.*;

public class StackTest1 {

    Stack<String> stack;

    @Before
    public void setUpBeforTest(){
        stack = new Stack<>();
    }

    @Test ( expected = java.util.NoSuchElementException . class )
    public void testPop(){

        stack.pop();
    }

    @Test ( expected = java.util.NoSuchElementException . class )
    public void testPeek(){

        stack.peek();
    }

}