package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class FindPermutation {

    public int[] findPermutation(String s) {
        if (s == null || s.isEmpty()) {
            return new int[0];
        }

        int[] result = new int[s.length() + 1];
        int cursor = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'D') {
                stack.push(i + 1);
            } else {
                result[cursor++] = i + 1;
                while (!stack.isEmpty()) {
                    result[cursor++] = stack.pop();
                }
            }
        }
        result[cursor++] = s.length() + 1;
        while (!stack.isEmpty()) {
            result[cursor++] = stack.pop();
        }
        return result;
    }

}
