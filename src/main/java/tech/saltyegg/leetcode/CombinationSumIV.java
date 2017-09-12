package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];

    }

}
