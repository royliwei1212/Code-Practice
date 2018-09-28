package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.isEmpty()) return Collections.singletonList("");

        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        boolean contIter = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            String crt = queue.poll();
            if (isValid(crt)) {
                result.add(crt);
                contIter = false;
            }
            if (!contIter) continue;

            for (int i = 0; i < crt.length(); i++) {
                char c = crt.charAt(i);
                if (c != '(' && c != ')') continue;
                String newStr = crt.substring(0, i) + crt.substring(i + 1);
                if (!dict.contains(newStr)) {
                    queue.add(newStr);
                    dict.add(newStr);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);

            if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
