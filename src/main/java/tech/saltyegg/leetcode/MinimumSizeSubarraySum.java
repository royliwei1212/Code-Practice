package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 5/11/15. codeashobby@gmail.com
 * <p/>
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int start, end, crtSum, minLength;
        start = end = crtSum = 0;
        minLength = length + 1;

        while (end < length) {

            while (crtSum < s && end < length) {
                crtSum += nums[end++];
            }

            while (crtSum >= s && start < length) {
                if (end - start < minLength) {
                    minLength = end - start;
                }
                crtSum -= nums[start++];
            }
        }

        return minLength > length ? 0 : minLength;
    }
}
