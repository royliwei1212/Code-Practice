package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/26/17
 */
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k > nums1.length + nums2.length) {
            return new int[0];
        }

        int[] result = null;
        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(k, nums1.length); i++) {
            int[] sub1 = largestSubArray(nums1, i);
            int[] sub2 = largestSubArray(nums2, k - i);
            int[] ans = merge(sub1, sub2);

            if (result == null) {
                result = ans;
            } else {
                result = isLarger(result, 0, ans, 0) ? result : ans;
            }
        }

        return result;
    }

    private int[] largestSubArray(int[] nums, int k) {
        int[] result = new int[k];

        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (end > 0 && end + nums.length - i > k && nums[i] > result[end - 1]) {
                end--;
            }

            if (end < k) {
                result[end++] = nums[i];
            }
        }
        return result;
    }

    private boolean isLarger(int[] a, int x, int[] b, int y) {
        for (; x < a.length && y < b.length; x++, y++) {
            if (a[x] > b[y]) return true;
            if (a[x] < b[y]) return false;
        }

        return x != a.length;
    }

    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int x, y, z;
        x = y = z = 0;
        while (x < a.length || y < b.length) {
            result[z++] = isLarger(a, x, b, y) ? a[x++] : b[y++];
        }

        return result;
    }

}
