package stack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class StackClearTest {
    Stack<String> stack = null;
    ArrayList<String> stackData = null;

    @Before
    public void beforTest() {
        this.stack = new Stack<String>();
        this.stackData = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));

        for (final String item : stackData) {
            this.stack.push(item);
        }
    }

    @After
    public void afterTest() {
        this.stack.clear();
        this.stackData.clear();
    }

    @Test
    public final void test() {
        this.stack.clear();
        assertEquals(this.stack.isEmpty(), true);
    }
}
