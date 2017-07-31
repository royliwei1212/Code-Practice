package tech.saltyegg.leetcode;

import java.util.*;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p.isEmpty() || s.length() < p.length()) return result;

        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        int count = p.length();
        int l = 0;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.getOrDefault(c, 0) > 0) {
                count--;
            }
            dict.put(c, dict.getOrDefault(c, 0) - 1);
            if (count == 0) {
                result.add(l);
            }

            if (i + 1 - l == p.length()) {
                char lc = s.charAt(l);
                if (dict.getOrDefault(lc, 0) >= 0) {
                    count++;
                }
                dict.put(lc, dict.getOrDefault(lc, 0) + 1);
                l++;
            }
        }
        return result;
    }
}
