package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * @see LargestRectangleInHistogram for more details
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;

        int[] dp = new int[matrix[0].length];
        int result = 0;
        for (char[] m : matrix) {
            for (int i = 0; i < m.length; i++) {
                dp[i] = (m[i] == '0' ? 0 : dp[i] + 1);
            }
            result = Math.max(result, getResult(dp));
        }
        return result;
    }

    private int getResult(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] <= heights[stack.peek()])) {
                int h = heights[stack.pop()];
                result = Math.max(result, h * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return result;
    }
}
