package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            q.offer(c);
        }
        q.offer('+');
        return cal(q);
    }

    private int cal(Queue<Character> q) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                num = cal(q);
            } else {
                // @formatter:off
                switch(sign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
                // @formatter:on
                num = 0;
                sign = c;
                if (c == ')') {
                    break;
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
