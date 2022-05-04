package stack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class StackPopTest {
    Stack<String> stack = null;
    ArrayList<String> stackData = null;

    @Before
    public void beforTest() {
        this.stack = new Stack<String>();
        this.stackData = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));

        for (final String item : stackData) {
            this.stack.push(item);
        }

        Collections.reverse(this.stackData);
    }

    @After
    public void afterTest() {
        this.stack.clear();
        this.stackData.clear();
    }

    @Test
    public final void test() {
        for (int i = 0, size = this.stackData.size(); i < size; ++i) {
            assertEquals(this.stack.isEmpty(), false);
            assertEquals(this.stack.size(), this.stackData.size() - i);
            assertEquals(this.stack.peek(), this.stackData.get(i));
            this.stack.pop();
        }

        assertEquals(this.stack.isEmpty(), true);
    }
}
