package tech.saltyegg.airbnb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HilbertCurve {

    public int hilbertCurve(int x, int y, int iter) {
        if (iter == 0) return 1;
        int len = (int) Math.pow(2, iter - 1);
        int num = len * len;

        if (x >= len && y >= len) {
            return 2 * num + hilbertCurve(x - len, y - len, iter - 1);
        } else if (x < len && y >= len) {
            return num + hilbertCurve(x, y - len, iter - 1);
        } else if (x < len && y < len) {
            return hilbertCurve(y, x, iter - 1);
        } else {
            return 3 * num + hilbertCurve(len - 1 - y, 2 * len - 1 - x, iter - 1);
        }
    }

    @Test
    public void test() {
        assertEquals(hilbertCurve(1, 1, 2), 3);
        assertEquals(hilbertCurve(0, 1, 1), 2);
        assertEquals(hilbertCurve(2, 2, 2), 9);
    }
}
