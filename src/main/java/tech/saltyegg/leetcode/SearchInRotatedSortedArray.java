package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/5/26.
 * Email: codeashobby@gmail.com
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int x = 0;
        int y = nums.length - 1;
        while (x <= y) {
            int m = x + (y - x) / 2;
            int rm = (m + l) % nums.length;
            if (nums[rm] == target) return rm;
            if (nums[rm] > target) {
                y = m - 1;
            } else {
                x = m + 1;
            }
        }

        return -1;
    }

}
