package tech.saltyegg.leetcode;

import java.util.Stack;

import org.junit.Test;

public class ReversePolishNotation {

    @SuppressWarnings("Duplicates")
    public String convert(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop()).append('#');
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    char sc = stack.pop();
                    if (sc == '(') {
                        break;
                    }
                    sb.append(sc).append('#');
                }
            } else {
                // should be number here
                int end = readNumber(s, i);
                sb.append(s, i, end).append('#');
                i = end - 1;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append('#');
        }
        return sb.toString();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int readNumber(String s, int start) {
        int end = start;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }
        return end;
    }

    @Test
    public void test() {
        System.out.println(convert("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }
}
