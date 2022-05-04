import static org.junit.Assert.assertEquals;

import org.junit.Test;

public final class SumTest {

    @Test
    public final void test() {
        assertEquals(Sum.accum(Integer.MAX_VALUE, Integer.MAX_VALUE),
        (long) Integer.MAX_VALUE + Integer.MAX_VALUE);
    }
}
