import org.junit.Assert.*;
import org.junit.Test;

public class TestOffByN {

    @Test
    public void testoffbyN() {
        CharacterComparator offBy5 = new OffByN(5);
        offBy5.equalChars('a', 'f');  // true
        offBy5.equalChars('f', 'a');  // true
        offBy5.equalChars('f', 'h');  // false
        offBy5.equalChars('f', 'f');  // false
    }
}
