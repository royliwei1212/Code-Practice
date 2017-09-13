package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = dp2[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp2[i] = Math.max(dp2[i], dp1[j] + 1);
                } else if (nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[i], dp2[j] + 1);
                }
            }
        }
        int result = Arrays.stream(dp1).max().orElse(1);
        result = Math.max(result, Arrays.stream(dp2).max().orElse(1));
        return result;

    }

}
