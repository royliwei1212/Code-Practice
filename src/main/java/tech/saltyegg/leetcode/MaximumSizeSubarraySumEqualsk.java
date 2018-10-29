package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/7.
 */
public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            if (map.containsKey(dp[i])) continue;
            map.put(dp[i], i);
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            int x = dp[i];
            int y = x - k;
            if (map.containsKey(y)) {
                result = Math.max(result, i - map.get(y));
            }
        }
        return result;
    }

}
