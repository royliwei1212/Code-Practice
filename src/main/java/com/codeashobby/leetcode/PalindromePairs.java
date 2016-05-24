package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;

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
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            dict.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String a = words[i];
            String reverse = getReverse(a);
            if (isPalindrome(a)) {
                if (dict.containsKey("") && !a.equals("")) {
                    result.add(getPair(i, dict.get("")));
                    result.add(getPair(dict.get(""), i));
                }
            }
            if (dict.containsKey(reverse) && !reverse.equals(a)) {
                result.add(getPair(i, dict.get(reverse)));
            }
            for (int x = 1; x < a.length(); x++) {
                String right = a.substring(x);
                String left = a.substring(0, x);
                String rl = getReverse(left);
                String rr = getReverse(right);
                if (isPalindrome(right) && dict.containsKey(rl)) {
                    result.add(getPair(i, dict.get(rl)));
                }
                if (isPalindrome(left) && dict.containsKey(rr)) {
                    result.add(getPair(dict.get(rr), i));
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            if (s.charAt(a) != s.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    private String getReverse(String a) {
        StringBuilder sb = new StringBuilder(a);
        return sb.reverse().toString();
    }

    private List<Integer> getPair(int a, int b) {
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }

    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();
        pp.palindromePairs(new String[]{"ab", "ba", "abc", "cba"});
    }
}
