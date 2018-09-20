package tech.saltyegg.leetcode;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length % 2 == 0) return -1;
        if (nums.length == 1) return 0;

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (m == 0) break;
            int a = nums[m - 1];
            int b = nums[m];
            int c = nums[m + 1];
            if (a != b && b != c) return b;

            if (a == b) {
                if (m % 2 != 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            }

            if (c == b) {
                if (m % 2 == 0) {
                    l = m + 2;
                } else {
                    r = m - 2;
                }

            }


        }
        return nums[l];
    }
}
