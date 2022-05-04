package com.company.one_task;

import org.junit.*;

public class SumTest {
    @Test
    public void accum_returnSum_whenSmallNumbersArePassed() {
        Assert.assertEquals(7, Sum.accum(-10, 0, 5, 12));
    }

    @Test
    public void accum_returnSum_whenBigNumbersArePassed() {
        Assert.assertEquals(5_000_000_000L, Sum.accum(10, 3_000_000_000L, -10, 2_000_000_000L));
    }
}