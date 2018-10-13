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
            int t = sum[i + 1] - sum[i + 1 - k];
            left[i] = t > max ? i + 1 - k : left[i - 1];
            max = Math.max(max, t);
        }

        right[nums.length - k] = nums.length - k;
        for (int i = nums.length - k - 1, max = sum[nums.length] - sum[nums.length - k]; i >= 0; i--) {
            int t = sum[i + k] - sum[i];
            right[i] = t > max ? i : right[i + 1];
            max = Math.max(max, t);
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

    // Time Limit Exceeded
    public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        if (nums == null || nums.length < 3 * k) return new int[0];
        int[] sum = new int[nums.length];
        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }

        for (int i = 1; i <= nums.length - k; i++) {
            sum[i] = sum[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        int[] result = new int[3];
        int max = 0;
        for (int i = 0; i <= nums.length - 3 * k; i++) {
            for (int j = i + k; j <= nums.length - 2 * k; j++) {
                for (int l = j + k; l <= nums.length - k; l++) {
                    int x = sum[i] + sum[j] + sum[l];
                    if (x > max) {
                        max = x;
                        result[0] = i;
                        result[1] = j;
                        result[2] = l;
                    }
                }
            }
        }
        return result;
    }

}
