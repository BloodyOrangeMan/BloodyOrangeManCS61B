package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.dequeue();
        arb.enqueue(7);
        arb.peek();
        arb.dequeue();
        arb.enqueue(8);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
