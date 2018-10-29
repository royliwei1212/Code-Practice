package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 2015/8/9.
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        if (input == null || input.length() == 0) {
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!isOperator(c)) {
                continue;
            }

            List<Integer> p1 = diffWaysToCompute(input.substring(0, i));
            List<Integer> p2 = diffWaysToCompute(input.substring(i + 1, input.length()));

            for (int a : p1) {
                for (int b : p2) {
                    result.add(calc(a, b, c));
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        return result;

    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private int calc(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return Integer.MAX_VALUE;
        }
    }
}
