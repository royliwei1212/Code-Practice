package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] >= 3) return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int m1, m2;
        m1 = m2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (m1 >= n) {
                m1 = n;
            } else if (m2 >= n) {
                m2 = n;
            } else {
                return true;
            }
        }
        return false;
    }

}
