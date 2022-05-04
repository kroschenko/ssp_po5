package task2;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongSumTest {

    @Test
    public void accum() {
        long[] val = new long[]{Integer.MAX_VALUE, 2};
        LongSum ls = new LongSum();
        long actual = ls.accum(val); // реальность
        System.out.println(actual);
        long expected = Integer.MAX_VALUE + 2L; // ожидание
        System.out.println(expected);
        assertEquals(expected, actual); // проверка на эквивалентность
    }
}