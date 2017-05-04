package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by hzhou on 2016/5/25.
 * Email: i@hzhou.me
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : chars) {
            dict.put(c, dict.containsKey(c) ? dict.get(c) + 1 : 1);
        }
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            dict.put(c, dict.get(c) - 1);
            if (stack.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && dict.get(stack.peek()) > 0) {
                stack.pop();
            }

            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }


}
