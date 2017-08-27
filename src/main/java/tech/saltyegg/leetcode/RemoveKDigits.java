package tech.saltyegg.leetcode;

import java.util.Stack;

/**
 * @author hzhou
 * @since 8/26/17
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty() || num.length() < k) {
            return null;
        }

        if (num.length() == k) return "0";
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }

        int length = num.length() - k;
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.size() + num.length() - i > length && arr[i] < stack.peek()) {
                stack.pop();
            }

            if (stack.size() < length) {
                stack.push(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
