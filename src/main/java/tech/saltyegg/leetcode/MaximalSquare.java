package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] nums = new int[matrix[0].length];
        int result = 0;
        for (char[] m : matrix) {
            for (int i = 0; i < m.length; i++) {
                nums[i] = m[i] == '0' ? 0 : nums[i] + 1;
            }
            result = Math.max(result, helper(nums));
        }
        return result;
    }

    private int helper(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || nums[i] <= nums[stack.peek()])) {
                int h = nums[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                int s = Math.min(h, w);
                result = Math.max(result, s * s);
            }
            stack.push(i);
        }
        return result;
    }
}
