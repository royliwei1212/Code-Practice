package tech.saltyegg.leetcode;

public class MaximumSumOfThreeNonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k * 3 > nums.length || k == 0) return new int[0];

        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[3];

        for (int i = k, max = sum[k] - sum[0]; i < nums.length; i++) {
            int t = sum[i + 1] - sum[i - k + 1];
            if (t > max) {
                max = t;
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }

        right[nums.length - k] = nums.length - k;
        for (int i = nums.length - k - 1, max = sum[nums.length] - sum[nums.length - k]; i >= 0; i--) {
            int t = sum[i + k] - sum[i];
            if (t > max) {
                right[i] = i;
                max = t;
            } else {
                right[i] = right[i + 1];
            }
        }

        int max = 0;
        for (int i = k; i <= nums.length - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int t = sum[l + k] - sum[l] + sum[r + k] - sum[r] + sum[i + k] - sum[i];
            if (t > max) {
                max = t;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }
        return result;
    }

}
