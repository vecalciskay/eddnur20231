package hanoi;

import edu.nur.edd.hanoi.TestHanoi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HanoiAlgorithmTest {

    @Test
    public void testHanoi() {
        TestHanoi h = new TestHanoi();
        String hanoi = h.resolverHanoi(0, 2, 1, 3);
        assertEquals("0 -> 20 -> 12 -> 10 -> 21 -> 01 -> 20 -> 2", hanoi);
    }

}
