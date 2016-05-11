package com.codeashobby.leetcode;

/**
 * Created by hzhou on 2016/5/10.
 * Email: i@hzhou.me
 */
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int r = nums.length - 1;
        int l = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int a = 0;
            for (int i : nums) {
                if (i <= mid) {
                    a++;
                }
            }
            if (a > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindtheDuplicateNumber fdn = new FindtheDuplicateNumber();
        System.out.println(fdn.findDuplicate(new int[]{1, 1, 2}));
    }

}
