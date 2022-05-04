package spp.task2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static spp.task2.StringUtils.repeat;

public class StringUtilsTest {
    @Test
    public void repeat_when_valuesValidRepeatZero_should_returnExceptedValue() throws Exception {
        String result = repeat("e", "|", 0);
        assertEquals(result, "");
    }

    @Test
    public void repeat_when_valuesValidFirst_should_returnExceptedValue() throws Exception {
        String result = repeat("e", "|", 3);
        assertEquals(result, "e|e|e");
    }

    @Test
    public void repeat_when_valuesValidSecond_should_returnExceptedValue() throws Exception {
        String result = repeat("ABC", ",", 2);
        assertEquals(result, "ABC,ABC");
    }

    @Test
    public void repeat_when_valuesValidSeparatorZero_should_returnExceptedValue() throws Exception {
        String result = repeat("DBE", "", 2);
        assertEquals(result, "DBEDBE");
    }

    @Test
    public void repeat_when_valuesValidThird_should_returnExceptedValue() throws Exception {
        String result = repeat("DBE", ":", 1);
        assertEquals(result, "DBE");
    }

    @Test
    public void repeat_when_valuesValidFourth_should_returnExceptedValue() throws Exception {
        String result = repeat("", ":", 3);
        assertEquals(result, "::");
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_when_valuesInvalidRepeat_should_returnExceptedValue() throws Exception {
        String result = repeat("AV", "DV", -5);
    }

    @Test(expected = NullPointerException.class)
    public void repeat_when_valuesInvalidFirst_should_returnException() throws Exception {
        String result = repeat(null, "a", 1);
    }

    @Test(expected = NullPointerException.class)
    public void repeat_when_valuesInvalidSecond_should_returnException() throws Exception {
        String result = repeat("a", null, 2);
    }
}
