package stack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class StackPushTest {
    Stack<String> stack = null;
    ArrayList<String> stackData = null;

    @Before
    public void beforTest() {
        this.stack = new Stack<String>();
        this.stackData = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
    }

    @After
    public void afterTest() {
        this.stack.clear();
        this.stackData.clear();
    }

    @Test
    public final void test() {
        assertEquals(this.stack.isEmpty(), true);

        for (int i = 0, size = this.stackData.size(); i < size; ++i) {
            this.stack.push(this.stackData.get(i));
            assertEquals(this.stack.isEmpty(), false);
            assertEquals(this.stack.size(), i + 1);
            assertEquals(this.stack.peek(), this.stackData.get(i));
        }

        Collections.reverse(this.stackData);
        StringBuilder sb = new StringBuilder();

        for (final String item : stackData) {
            sb.append(item + " ");
        }

        assertEquals(this.stack.toString(), sb.toString());
    }
}
