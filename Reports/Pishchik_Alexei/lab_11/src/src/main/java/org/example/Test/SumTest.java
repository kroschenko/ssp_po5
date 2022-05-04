package org.example.Test;
import org.example.Sum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    @Test
    public void accumTest() {
        int TestaccumInt = Sum.accum(23, 55, 64, 1, -24);
        assertEquals(119, TestaccumInt);
    }

    @Test
    public void longaccumTest(){
        long TestaccumLong = Sum.longaccum(312387847,682874745 );
        assertEquals(995262592, TestaccumLong);
    }
}
