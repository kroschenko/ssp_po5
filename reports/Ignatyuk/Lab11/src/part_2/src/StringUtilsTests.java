import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public final class StringUtilsTests {
    @Test
    public final void test() {
        assertThrows(NullPointerException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                StringUtils.indexOfDifference(null, null);
            }
        });

        assertThrows(NullPointerException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                StringUtils.indexOfDifference("i am a machine", null);
            }
        });

        assertThrows(NullPointerException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                StringUtils.indexOfDifference(null, "i am a robot");
            }
        });

        assertEquals(StringUtils.indexOfDifference("", ""), -1);
        assertEquals(StringUtils.indexOfDifference("i am a machine", ""), 0);
        assertEquals(StringUtils.indexOfDifference("", "i am a robot"), 0);
        assertEquals(StringUtils.indexOfDifference("ab", "abxyz"), 2);
        assertEquals(StringUtils.indexOfDifference("abcde", "abxyz"), 2);
        assertEquals(StringUtils.indexOfDifference("abcde", "xyz"), 0);
        assertEquals(StringUtils.indexOfDifference("i am a machine", "i am a robot"), 7);
    }
}
