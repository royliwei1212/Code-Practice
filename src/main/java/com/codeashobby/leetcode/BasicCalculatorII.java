package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 2015/6/22.
 * Email: i@hzhou.me
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        s = s.replaceAll(" ", "");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int op = isOperator(c);
            int end = i + 1;
            if (op == 2) {
                int a = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                end = readNumber(s, i + 1);
                list.add(getResult(a, Integer.valueOf(s.substring(i + 1, end)), c));
            } else if (op == 1 && c == '-') {
                end = readNumber(s, i + 1);
                list.add(Integer.valueOf(s.substring(i, end)));
            }

            if (isNumber(c)) {
                end = readNumber(s, i);
                list.add(Integer.valueOf(s.substring(i, end)));
            }

            i = end;
        }

        int result = 0;
        for (int a : list) {
            result += a;
        }

        return result;
    }

    private int readNumber(String s, int start) {
        while (start < s.length()) {
            if (!isNumber(s.charAt(start))) {
                break;
            }
            start++;
        }
        return start;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private int isOperator(char c) {
        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    private int getResult(int x, int y, char c) {
        switch (c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                return 0;
        }
    }

    @Test
    public void test() {
        String s = "3+2*2";
        int result = calculate(s);

        s = "3+5 / 2 ";
        result = calculate(s);
    }
}
