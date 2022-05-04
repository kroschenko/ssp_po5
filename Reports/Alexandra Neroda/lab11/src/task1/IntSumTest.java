package task1;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntSumTest {

    @Test
    public void accum() {
        int[] val = new int[]{1, 2, 3, 4, 5};
        IntSum is = new IntSum();
        int actual = is.accum(val); // реальность
        int expected = 15; // ожидание
        assertEquals(expected, actual); // проверка на эквивалентность
    }
}