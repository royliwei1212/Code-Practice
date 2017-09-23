package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/5/28.
 * Email: codeashobby@gmail.com
 * <p>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (l >= 0 && l < nums.length && nums[l] == target) return l;
        return -1;
    }

    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (r >= 0 && r < nums.length && nums[r] == target) return r;
        return -1;
    }
}
