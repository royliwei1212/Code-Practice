package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * Created by hzhou on 2015/6/22. Email: i@hzhou.me
 */
public class BasicCalculatorII {

    public int calculate(String s) {
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
}
