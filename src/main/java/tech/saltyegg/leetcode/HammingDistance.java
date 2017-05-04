package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 4/25/17
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((mask & z) > 0) {
                result++;
            }
        }
        return result;
    }
}
