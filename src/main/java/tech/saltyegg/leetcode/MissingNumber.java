package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * Created by hzhou on 2016/5/8.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        return n * (n + 1) / 2 - sum;
    }
}
