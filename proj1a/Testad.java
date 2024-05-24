import org.junit.Assert.*;
import org.junit.Test;

public class Testad {
    @Test
    public void test() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        for (int i = 0, j = 0; i < 8; i++, j = j + 2) {
            a.addFirst(j);
            a.addLast(j + 1);
        }
        for (int i = 0, j = 0; i < 7; i++, j = j + 2) {
            a.removeLast();
            a.removeFirst();
        }


    }
}