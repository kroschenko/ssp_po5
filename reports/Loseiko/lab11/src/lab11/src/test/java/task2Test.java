import org.junit.platform.commons.util.StringUtils;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class task2Test {
    @Test
    public void looseByNullRemove() throws NullPointerException {
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            task2.loose(null, null);
        });
        assertEquals(thrown.getClass(), NullPointerException.class);
    }

    @Test
    public void looseSuccess() {
        assertEquals("", task2.loose("", "hello"));
        assertEquals("hello", task2.loose("hello", null));
        assertEquals("hello", task2.loose("hello", ""));
        assertEquals("eo", task2.loose("hello", "hl"));
        assertEquals("o", task2.loose("hello", "hel"));
    }
}
