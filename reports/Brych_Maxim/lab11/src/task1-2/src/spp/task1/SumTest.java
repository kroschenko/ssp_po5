package spp.task1;


import org.junit.Test;

import static spp.task1.Sum.accum;
import static org.junit.Assert.assertEquals;
import static spp.task1.Sum.accumLong;

public class SumTest {
    @Test
    public void accum_when_valuesValid_should_returnExceptedValue() {
        long result = accum(1, 2, 5);
        assertEquals(result, 8);
    }

    @Test
    public void accum_when_valuesInvalid_should_returnExceptedValue() {
        long result = accum(Integer.MAX_VALUE, 12, 5);
        assertEquals(result, Integer.MIN_VALUE + 12 + 5 - 1);
    }

    @Test
    public void accumLong_when_valuesValid_should_returnExceptedValue() {
        long result = accumLong(1, 2, 5);
        assertEquals(result, 8);
    }

    @Test
    public void accumLong_when_valuesInvalid_should_returnExceptedValue() {
        long result = accumLong(Integer.MAX_VALUE, 12, 5);
        assertEquals(result, (long) (Integer.MAX_VALUE) + (long) 12 + (long) 5);
    }
}
