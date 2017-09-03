package tech.saltyegg.leetcode;

import java.util.Random;

/**
 * @author hzhou
 * @since 9/3/17
 */
public class ShuffleAnArray {

    private int[] origin;
    private int[] val;
    private Random rand;

    public ShuffleAnArray(int[] nums) {
        origin = new int[nums.length];
        val = new int[nums.length];
        rand = new Random();
        System.arraycopy(nums, 0, origin, 0, nums.length);
        System.arraycopy(nums, 0, val, 0, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < val.length; i++) {
            int ranInt = rand.nextInt(val.length);
            int x = val[ranInt];
            val[ranInt] = val[i];
            val[i] = x;
        }
        return val;
    }

}
