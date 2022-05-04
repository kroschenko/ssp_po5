package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {
    private static StringUtils stringUtils = new StringUtils();
    @Test
    public void repeatZeroTimes() {
        assertEquals("", stringUtils.repeat("j", 0));
    }
    @Test
    public void repeatOneManyTimes() {
        assertEquals("jjjj", stringUtils.repeat("j", 4));
    }
    @Test
    public void repeatManyManyTimes() {
        assertEquals("ABCABC", stringUtils.repeat("ABC", 2));
    }
    @Test
    public void repeatNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                stringUtils.repeat("ABC", -5));
    }
    @Test
    public void repeatNull() {
        assertThrows(NullPointerException.class, () ->
                stringUtils.repeat(null, 1));
    }

}
