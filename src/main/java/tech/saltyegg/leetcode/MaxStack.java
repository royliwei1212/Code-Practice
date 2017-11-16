package tech.saltyegg.leetcode;

import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> max;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (max.isEmpty()) {
            max.push(x);
        } else {
            max.push(Math.max(x, max.peek()));
        }
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        max.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        if (max.isEmpty()) return -1;
        int result = max.peek();
        Stack<Integer> tmp = new Stack<>();
        while (!stack.peek().equals(max.peek())) { // `stack.peek() != max.peek()` will not work
            tmp.push(stack.pop());
            max.pop();
        }
        stack.pop();
        max.pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return result;
    }
}
