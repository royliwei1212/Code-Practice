package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * @author hzhou
 * @since 8/26/17
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return "0";

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : stack) {
            if (n == 0 && sb.length() == 0) continue;
            sb.append(n);
        }
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }

}
