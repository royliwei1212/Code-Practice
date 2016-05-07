package com.codeashobby.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 5/4/16.
 * Email: i@hzhou.me
 */
public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> map = getCountMap(s);
        if (!isPermutable(map)) {
            return Collections.emptyList();
        }

        Character center = getMiddleChar(map);

        //TODO
        return null;
    }

    private Map<Character, Integer> getCountMap(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = 1;
            if (map.containsKey(c)) {
                val += map.get(c);
            }
            map.put(c, val);
        }
        return map;
    }

    private boolean isPermutable(Map<Character, Integer> map) {
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
            }
        }
        return count < 2;
    }

    private Character getMiddleChar(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }

}
