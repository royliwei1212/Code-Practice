package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * @author hzhou
 * @since 9/12/17
 */
public class TernaryExpressionParser {

    // "T?T?F:5:3"
    public String parseTernary(String expression) {
        if (expression == null || expression.isEmpty()) return null;

        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char a = stack.pop();
                stack.pop();
                char b = stack.pop();
                stack.push(c == 'T' ? a : b);
            } else {
                stack.push(c);
            }
        }
        return stack.peek() + "";
    }

}
