package org.example.Test;

import org.example.StringUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringUtilsTest {

    @Test
    public void testFirst() {
        Assertions.assertEquals("", StringUtils.repeat("e","|",0));
    }

    @Test
    public void testSecond() {
        assertEquals("e|e|e", StringUtils.repeat("e", "|", 3));
    }

    @Test
    public void testThird() {
        assertEquals("ABC , ABC ", StringUtils.repeat(" ABC ", ",", 2));
    }

    @Test
    public void testFourth() {
        assertEquals("DBEDBE", StringUtils.repeat("DBE", "", 2));
    }

    @Test
    public void testFifth() {
        assertEquals("DBE", StringUtils.repeat(" DBE ", ":", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSixth() {
        StringUtils.repeat("e", -2);
    }

    @Test
    public void testSeventh() {
        assertEquals("::", StringUtils.repeat("", ":", 3));
    }

    @Test(expected = NullPointerException.class)
    public void testEighth() {
        StringUtils.repeat(null , "a", 1);
    }

    @Test(expected = NullPointerException.class)
    public void testNinth() {
        StringUtils.repeat("a", null , 2);
    }
}
