package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 5/11/15. codeashobby@gmail.com
 * <p/>
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            if (nums[i - 1] >= s) return 1;
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if (sum[nums.length] < s) return 0;
        int result = nums.length;
        for (int i = 0; i < sum.length - 1; i++) {
            int x = sum[i];
            int target = s + x;
            int loc = search(sum, i + 1, target);
            if (sum[loc] - sum[i] >= s) result = Math.min(result, loc - i);
        }
        return result;
    }

    private int search(int[] sum, int l, int target) {
        int r = sum.length - 1;
        if (target < sum[l]) return -1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sum[m] == target) return m;
            if (sum[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
