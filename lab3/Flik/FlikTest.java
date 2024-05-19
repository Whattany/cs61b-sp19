import static org.junit.Assert.*;
import org.junit.Test;
public class FlikTest {
    @Test
    public void testIsSameNumber() {
        int a = 10;
        int b = 10;
        boolean expect = true;
        assertEquals(expect, Flik.isSameNumber(a, b));
    }
}
