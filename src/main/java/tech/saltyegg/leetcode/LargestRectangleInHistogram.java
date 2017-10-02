/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * http://www.cnblogs.com/grandyang/p/4322653.html
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] <= heights[stack.peek()])) {
                int h = heights[stack.pop()];
                result = Math.max(result, h * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
            stack.push(i);
        }

        return result;
    }
}