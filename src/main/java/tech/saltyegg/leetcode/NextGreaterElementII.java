package tech.saltyegg.leetcode;

import java.util.Stack;

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            if (i < nums.length) stack.push(i);
        }

        for (int n : stack) result[n] = -1;

        return result;
    }
}
