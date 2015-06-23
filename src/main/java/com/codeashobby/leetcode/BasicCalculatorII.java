package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int op = isOperator(c);
            if (op == 2) {
                String a = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                int end = readNumber(s, i + 1);
                list.add(getResult(a, s.substring(i + 1, end), c) + "");
            } else if (op == 1) {
                list.add(c + "");
            }

            if (isNumber(c)) {
                int end = readNumber(s, i);
                list.add(s.substring(i, end));
            }
        }

        int result = Integer.valueOf(list.get(0));
        for (int i = 1; i < list.size() - 1; i = i + 2) {
            char c = list.get(i).charAt(0);
            String b = list.get(i + 1);
            result = getResult(result, b, c);
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

    private int getResult(String a, String b, char c) {
        int x = Integer.valueOf(a);
        int y = Integer.valueOf(b);
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

    private int getResult(int a, String b, char c) {
        int x = a;
        int y = Integer.valueOf(b);
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
