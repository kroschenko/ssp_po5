package com.company;

import org.junit.*;
import static org.junit.Assert.*;

public class TestStringUtils {
    @Test
    public void testOne(){
        assertEquals("", StringUtils.repeat("e","|",0));
    }

    @Test
    public void testTwo(){
        assertEquals("e|e|e", StringUtils.repeat("e", "|", 3));
    }

    @Test
    public void testThree(){
        assertEquals("ABC , ABC ", StringUtils.repeat(" ABC ", ",", 2));
    }

    @Test
    public void testFour(){
        assertEquals(" DBEDBE ", StringUtils.repeat(" DBE ", "", 2));
    }

    @Test
    public void testFive(){
        assertEquals("DBE", StringUtils.repeat(" DBE ", ":", 1));
    }

    @Test ( expected = IllegalArgumentException.class )
    public void testSix(){
        StringUtils.repeat("e", -2);
    }

    @Test
    public void testSeven(){
        assertEquals("::", StringUtils.repeat("", ":", 3));
    }

    @Test (expected = NullPointerException.class )
    public void testEight(){
        StringUtils.repeat(null , "a", 1);
    }

    @Test (expected = NullPointerException.class )
    public void testNine(){
        StringUtils.repeat("a", null , 2);
    }
}
