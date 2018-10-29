package tech.saltyegg.leetcode;

import java.util.Stack;

import org.junit.Test;

/**
 * Created by hzhou on 2015/6/14.
 */
public class BasicCalculator {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int flag = 1;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '+' || c == '-') {
                result += flag * num;
                num = 0;
                flag = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(flag);
                result = 0;
                flag = 1;
            } else if (c == ')') {
                result += flag * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result;
    }

    // solution 2
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String str = convertReversePolishNotation(s);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (isOperator(c)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = calc(a, b, c);
                stack.push(result);
            } else {
                int end = readNumber(str, i);
                int num = Integer.valueOf(str.substring(i, end));
                stack.push(num);
                i = end;
            }
        }

        return stack.pop();

    }

    private String convertReversePolishNotation(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
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
                    sb.append(sc);
                }
            } else {
                // should be number here
                int end = readNumber(s, i);
                sb.append(s.substring(i, end)).append(' ');
                i = end - 1;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        }
        if (op == '-') {
            return a - b;
        }
        return -1;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    private int readNumber(String s, int start) {
        int end = start;
        while (end < s.length() && isNumber(s.charAt(end))) {
            end++;
        }
        return end;
    }

    @Test
    public void test() {
        String s = "(7)-(0)+(4)";
        int result = calculate(s);

        s = "(1+(4+5+2)-3)+(6+8)";
        result = calculate(s);
    }
}
