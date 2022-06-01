package com.company;

import org.junit.*;

public class StringUtilsTest {
    @Test
    public void repeat_returnsRepeatedString() {
        Assert.assertEquals("ABCABC", StringUtils.repeat("ABC", 2));
    }

    @Test
    public void repeat_returnsEmptyString_whenRepeatCountIsZero() {
        Assert.assertEquals("", StringUtils.repeat("ABC", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_throwsIllegalArgumentException_whenRepeatCountIsNegative() {
        StringUtils.repeat("ABC", -3);
    }

    @Test(expected = NullPointerException.class)
    public void repeat_throwsNullPointerException_whenStrIsNull() {
        StringUtils.repeat(null, 10);
    }
}
