package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class NumArray {

    private int[] cache;

    public NumArray(int[] nums) {
        cache = nums;
    }

    public void update(int i, int val) {
        if (i >= 0 && i < cache.length) cache[i] = val;
    }

    public int sumRange(int i, int j) {
        int result = 0;
        for (int x = i; x <= j; x++) {
            result += cache[x];
        }
        return result;
    }

}
