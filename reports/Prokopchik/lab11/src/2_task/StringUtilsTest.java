package com.company.two_task;

import org.junit.*;

public class StringUtilsTest {
    @Test(expected = NullPointerException.class)
    public void keep_throwsNullPointerException_whenStrAndPatternIsNull() {
        StringUtils.keep(null, null);
    }
    @Test
    public void keep_return_whenStrIsNull() {
        Assert.assertNull(StringUtils.keep(null, "str"));
    }

    @Test
    public void repeat_returnsEmptyString_whenStrIsEmptyString() {
        Assert.assertEquals("", StringUtils.keep("", "str"));
    }

    @Test
    public void repeat_returnsEmptyString_whenPatternIsNull() {
        Assert.assertEquals("", StringUtils.keep("str", null));
    }

    @Test
    public void repeat_returnsEmptyString_whenPatternIsEmptyString() {
        Assert.assertEquals("", StringUtils.keep("str", ""));
    }

    @Test
    public void keep_returnsKeepString() {
        Assert.assertEquals("hll", StringUtils.keep("hello", "hl"));
        Assert.assertEquals("ell", StringUtils.keep("hello", "le"));
    }
}

