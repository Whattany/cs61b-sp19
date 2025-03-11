package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(10);
        arb.enqueue(9);
        arb.enqueue(8);
        arb.enqueue(7);
        arb.enqueue(10);
        arb.enqueue(9);
        arb.enqueue(8);
        arb.enqueue(7);
        arb.enqueue(10);
        arb.enqueue(9);
        assertEquals(arb.dequeue(), 10);
        assertEquals(arb.dequeue(), 9);
        assertEquals(arb.dequeue(), 8);
        assertEquals(arb.dequeue(), 7);
        arb.enqueue(8);
        arb.enqueue(7);
        arb.enqueue(10);
        arb.enqueue(9);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
