package com.codeashobby.leetcode;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return;
        }

        k = k % length;

        if (k == 0) {
            return;
        }

        int[] tmp = new int[k];
        int j = 0;
        // load data to tmp array
        for (int i = length - k; i < length; i++) {
            tmp[j++] = nums[i];
        }

        System.arraycopy(nums, 0, nums, k, length - 1 - k + 1);
        System.arraycopy(tmp, 0, nums, 0, k);
    }
}
