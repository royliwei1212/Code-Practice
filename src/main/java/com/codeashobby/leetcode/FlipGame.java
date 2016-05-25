package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hzhou on 2016/5/14.
 * Email: i@hzhou.me
 */
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.length() < 2) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            char a = chars[i];
            char b = chars[i + 1];
            if (a == '+' && b == '+') {
                chars[i] = chars[i + 1] = '-';
                result.add(arrayToStr(chars));
                chars[i] = chars[i + 1] = '+';
            }
        }
        return result;
    }

    private String arrayToStr(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

}
