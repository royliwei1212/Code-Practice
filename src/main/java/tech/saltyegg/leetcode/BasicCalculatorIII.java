package tech.saltyegg.leetcode;

import java.util.Stack;

import org.junit.Test;

public class BasicCalculatorIII {
    public int calculate(String s) {
        return helper(s);
    }

    private int helper(String s) {
        if (!s.contains("(")) return calc(s);
        int r = s.indexOf(')');
        int l = r - 1;
        for (; l >= 0; l--) {
            if (s.charAt(l) == '(') break;
        }
        String ls = l > 0 ? s.substring(0, l) : "";
        String rs = r >= s.length() - 1 ? "" : s.substring(r + 1);
        return helper(ls + String.valueOf(helper(s.substring(l + 1, r))) + rs);
    }


    @SuppressWarnings("Duplicates")
    private int calc(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        char flag = '+';
        int result = 0, num = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= s.length(); i++) {
            char c = (i == s.length()) ? '#' : s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
                continue;
            }

            // @formatter:off
            switch(flag){
                case '+': stack.push(num); break;
                case '-': stack.push(-num); break;
                case '*': stack.push(stack.pop() * num); break;
                case '/': stack.push(stack.pop() / num); break;
            }
            // @formatter:on
            num = 0;
            flag = c;
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    @Test
    public void test() {
        String s = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println(calculate(s));
    }
}
