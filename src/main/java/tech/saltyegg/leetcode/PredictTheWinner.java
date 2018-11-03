package tech.saltyegg.leetcode;

public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        return helper(0, nums.length - 1, nums) >= 0;
    }

    public int helper(int left, int right, int[] nums) {
        if (left == right) return nums[left];
        return Math.max(nums[left] - helper(left + 1, right, nums),
                nums[right] - helper(left, right - 1, nums));
    }

    public boolean PredictTheWinner2(int[] nums) {
        int len = nums.length;
        if (len % 2 == 0) return true;
        int[] dp = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i] = nums[i];
            for (int j = i + 1; j < len; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[len - 1] >= 0;
    }

    public boolean PredictTheWinner3(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = nums[i];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int k = i + j;
                dp[j][k] = Math.max(nums[j] - dp[j + 1][k], nums[k] - dp[j][k - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
