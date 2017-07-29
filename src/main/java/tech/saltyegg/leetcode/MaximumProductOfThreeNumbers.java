package tech.saltyegg.leetcode;

public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return -1;
        int a = findMax(0, nums);
        int b = findMax(1, nums);
        int c = findMax(2, nums);
        int x = findMin(nums.length - 1, nums);
        int y = findMin(nums.length - 2, nums);

        return Math.max(a * b * c, a * x * y);
    }

    private int findMax(int start, int[] nums) {
        int x = Integer.MIN_VALUE;
        int index = start;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > x) {
                x = nums[i];
                index = i;
            }
        }
        if (index != start) {
            int t = nums[start];
            nums[start] = nums[index];
            nums[index] = t;
        }
        return nums[start];
    }

    private int findMin(int end, int[] nums) {
        int x = Integer.MAX_VALUE;
        int index = end;
        for (int i = end; i >= 0; i--) {
            if (nums[i] < x) {
                x = nums[i];
                index = i;
            }
        }
        if (index != end) {
            int t = nums[end];
            nums[end] = nums[index];
            nums[index] = t;
        }
        return nums[end];
    }

}
