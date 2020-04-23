package tech.saltyegg.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int[] minLast = new int[nums.length + 1];

        minLast[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        // [-2147483648, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647]
        System.out.println(Arrays.toString(minLast));

        for (int num : nums) {
            // find the first number in minLast >= nums[i]
            int index = binarySearch(minLast, num);
            minLast[index] = num;
            System.out.println(num +" => "+Arrays.toString(minLast));
        }

        System.out.println(Arrays.toString(minLast));

        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }

        return 0;
    }

    // find the first number > num
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 3, 3, 3, 101, 18}));
    }
}
