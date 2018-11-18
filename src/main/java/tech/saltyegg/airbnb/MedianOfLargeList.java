package tech.saltyegg.airbnb;

public class MedianOfLargeList {

    public long search(int[] nums, int k, int left, int right) {
        int g = left + (right - left) / 2;
        int count = 0;
        int result = 0;
        for (int n : nums) {
            if (n <= g) {
                count++;
                result = Math.max(result, n);
            }
        }
        if (count == k) return result;
        if (count > k) return search(nums, k, Math.min(g, result + 1), right);
        return search(nums, k, left, result);
    }

    private double findMedian(int[] nums) {
        int len = nums.length;
        if (len % 2 == 1) {
            return search(nums, len / 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return (search(nums, len / 2 - 1, Integer.MIN_VALUE, Integer.MAX_VALUE) +
                search(nums, len / 2, Integer.MIN_VALUE, Integer.MAX_VALUE)) / 2.0;
    }
}
