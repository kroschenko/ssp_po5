package com.company;

import org.junit.*;

public class SumTest {
    @Test
    public void accum_returnsSum_whenSmallNumbersArePassed() {
        Assert.assertEquals(7, Sum.accum(-10, 0, 5, 12));
    }

    @Test
    public void accum_returnsSum_whenBigNumbersArePassed() {
        Assert.assertEquals(3_999_999_995L, Sum.accum(2_000_000_000, 2_000_000_000, 5, -10));
    }
}