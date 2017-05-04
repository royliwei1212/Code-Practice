package com.codeashobby.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 5/3/17
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
