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
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
