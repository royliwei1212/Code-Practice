package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by hzhou on 2015/8/9.
 * Email: i@hzhou.me
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int[] result = new int[nums.length + 1 - k];

        int index = 0;
        int start = 0;
        for (int i : nums) {

            if (queue.size() == k) {
                result[index++] = queue.peek();
                queue.remove(nums[start++]);
            }

            if (queue.size() < k) {
                queue.add(i);
            }
        }

        result[index] = queue.peek();
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(nums, 3);
    }
}
