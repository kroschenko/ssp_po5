package com.company;

import org.junit.*; // Импорт всех основных классов и аннотаций JUnit
import static org.junit.Assert.*; // Импорт утверждений
public class SumTest {
    @Test
    public void TestName () {
        long test = Sum.accum(2,0,7,7);
    assertEquals(15, test);
    }
}