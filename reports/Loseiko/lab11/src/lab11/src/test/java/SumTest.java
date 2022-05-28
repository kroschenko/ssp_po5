import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    @Test
    public void accumSuccess() {
        int accum = Sum.accum(1, 2, 3, 4, 5);
        assertEquals(15, accum);
    }

    @Test
    public void modaccumSuccess(){
        long accum = Sum.modaccum(1_000_000_000,1_000_000_000 );
        assertEquals(2_000_000_000, accum);
    }
}
