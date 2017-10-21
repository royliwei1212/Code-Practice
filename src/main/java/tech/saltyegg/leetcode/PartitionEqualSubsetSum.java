package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 10/21/17
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int j = sum / 2; j >= n; j--) {
                dp[j] = dp[j] || dp[j - n];
            }
        }
        return dp[sum / 2];
    }
}
