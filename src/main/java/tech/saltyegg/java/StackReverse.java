package tech.saltyegg.java;

import java.util.Stack;

/**
 * @author hzhou
 * @since 10/1/17
 */
public class StackReverse {

    public static int getAndRemoveLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) return;
        int val = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.toString());
//        System.out.println(getAndRemoveLast(stack));
//        System.out.println(stack.toString());
        reverse(stack);
        System.out.println(stack.toString());
    }
}
