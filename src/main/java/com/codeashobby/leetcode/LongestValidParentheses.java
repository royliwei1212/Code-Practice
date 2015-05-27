package com.codeashobby.leetcode;

import java.util.Stack;

/**
 * Created by hzhou on 2015/5/26.
 * Email: codeashobby@gmail.com
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    max = i + 1;
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }
        return max;
    }
}
