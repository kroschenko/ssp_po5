package com.spp.labs.lab11;

import org.junit.*;
import static org.junit.Assert.*;


public class SumTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAccum() {
        System.out.println("accum");
        int[] values = {1, 2, 3};
        int expResult = 6;
        int result = Sum.accum(values);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAccumLong() {
        System.out.println("accum");
        int[] values = {1000000000, 1000000000, 1000000000};
        long expResult = 3000000000L;
        long result = Sum.accumLong(values);
        assertEquals(expResult, result);
    }
    
}
