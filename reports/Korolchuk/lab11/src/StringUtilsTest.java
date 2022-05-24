package com.spp.labs.lab11;


import org.junit.*;
import static org.junit.Assert.*;


public class StringUtilsTest {
    
    public StringUtilsTest() {
    }
    
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
    public void testSubstringBetween() {
        System.out.println("substringBetween");

        assertNull(StringUtils.substringBetween (null, "*", "*"));
        assertNull(StringUtils.substringBetween ("*", null, "*"));
        assertNull(StringUtils.substringBetween ("*", "*", null ));
        assertEquals(StringUtils.substringBetween ("", "", ""), "");
        assertNull(StringUtils.substringBetween ("", "", "]"));
        assertNull(StringUtils.substringBetween ("", "[", "]"));
        assertEquals(StringUtils.substringBetween ("yabcz", "", ""), "");
        assertEquals(StringUtils.substringBetween ("yabcz", "y", "z"), "abc");
        assertEquals(StringUtils.substringBetween ("yabczyabcz", "y", "z"), "abc");
        assertEquals(StringUtils.substringBetween ("wx[b]yz", "[", "]"), "b");
    }
    
    @Test
    public void testSubstringBetweenNullPointerException() throws NullPointerException {
        System.out.println("substringBetweenNullPointerException");
        
        try {
            StringUtils.substringBetween (null, null, null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException thrown");
        } 
    }
    
}
