package tech.saltyegg.leetcode;

import java.util.Arrays;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) return -1;
        int sum = Arrays.stream(nums).sum();
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = sum - nums[i] - s;
            if (x == s) return i;
            s += nums[i];
        }
        return -1;
    }
}
