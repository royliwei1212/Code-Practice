package tech.saltyegg.leetcode;

import java.util.Random;

public class RandomPickIndex {

    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (random.nextInt(count++) < 1) result = i;
        }
        return result;
    }
}
