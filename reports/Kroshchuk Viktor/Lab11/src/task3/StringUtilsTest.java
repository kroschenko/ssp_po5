package task3;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test(expected = NullPointerException.class)
    public void byNullDistance() {
        StringUtils su = new StringUtils();
        int actual1 = su.levenshteinDistance(null, null);
        int expected1 = 0;
        assertEquals(expected1, actual1);
    }

    @Test
    public void levenshteinDistance() {
        StringUtils su = new StringUtils();

        int actual2 = su.levenshteinDistance(null, " ");
        int expected2 = -1;
        assertEquals(expected2, actual2);

        int actual3 = su.levenshteinDistance(" ", null);
        int expected3 = -1;
        assertEquals(expected3, actual3);

        int actual4 = su.levenshteinDistance(" ", null);
        int expected4 = -1;
        assertEquals(expected4, actual4);

        int actual5 = su.levenshteinDistance("", "a");
        int expected5 = 1;
        assertEquals(expected5, actual5);

        int actual6 = su.levenshteinDistance("frog", "fog");
        int expected6 = 1;
        assertEquals(expected6, actual6);

        int actual7 = su.levenshteinDistance("fly", "ant");
        int expected7 = 3;
        assertEquals(expected7, actual7);

        int actual8 = su.levenshteinDistance("hippo", "zzzzzzzz");
        int expected8 = 8;
        assertEquals(expected8, actual8);

    }
}