package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hzhou on 2016/5/22.
 * Email: i@hzhou.me
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length < 2) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0; x < words.length - 1; x++) {
            String a = words[x];
            for (int y = x + 1; y < words.length; y++) {
                String b = words[y];
                if (isPalindrome(a + b)) {
                    result.add(getPair(x, y));
                }

                if (isPalindrome(b + a)) {
                    result.add(getPair(y, x));
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String a) {
        if (a == null || a.isEmpty()) {
            return true;
        }
        StringBuilder sb = new StringBuilder(a);
        return a.equals(sb.reverse().toString());
    }

    private List<Integer> getPair(int a, int b) {
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}
