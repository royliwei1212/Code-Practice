package tech.saltyegg.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1, -1};
        int l = hl(nums, target, 0, nums.length - 1);
        if (nums[l] != target) return new int[]{-1, -1};
        int r = hl(nums, target + 1, l, nums.length - 1);
        if (nums[r] > target) r--;
        return new int[]{l, r};

    }

    private int hl(int[] nums, int target, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
