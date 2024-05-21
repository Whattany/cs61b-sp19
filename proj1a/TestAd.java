import static org.junit.Assert.*;

import org.junit.Test;

public class TestAd {
    @Test
    public  void testadd() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(9);
        a.addFirst(8);
        a.addFirst(6);
        a.addLast(5);
        a.addLast(4);
        a.addLast(3);
        a.addLast(2);
        a.addLast(1);
        a.addFirst(10);
        a.addFirst(11);
        a.addFirst(12);
        int b = a.get(3);

        int c = a.get(4);
        a.printDeque();



    }
}