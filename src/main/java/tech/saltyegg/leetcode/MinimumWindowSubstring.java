/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: For example,
 * <p/>
 * S = "ADOBECODEBANC"
 * <p/>
 * T = "ABC"
 * <p/>
 * Minimum window is "BANC".
 *
 * @author hzhou
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s == null || s.isEmpty()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0, mc = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                if (sMap.getOrDefault(c, 0) < tMap.get(c)) mc++;
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            if (mc == t.length()) {
                while (start < s.length() && (!sMap.containsKey(s.charAt(start)) || sMap.get(s.charAt(start)) > tMap.get(s.charAt(start)))) {
                    if (sMap.containsKey(s.charAt(start))) sMap.put(s.charAt(start), sMap.get(s.charAt(start)) - 1);
                    start++;
                }

                if (result.isEmpty() || i - start + 1 < result.length()) {
                    result = s.substring(start, i + 1);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        String s = "a";
        String t = "aa";
        String result = minWindow(s, t);
    }
}