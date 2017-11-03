package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * Created by hzhou on 2015/6/22. Email: i@hzhou.me
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        if (s.isEmpty()) return 0;

        int num = 0;
        char f = '+';
        char c = '+';

        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length()) {
                c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = 10 * num + (c - '0');
                    continue;
                }
            }

            switch (f) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
            }
            f = c;
            num = 0;
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
