package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = map.values().stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        result += map.values().stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x - 1)
                .mapToInt(Integer::intValue)
                .sum();
        result += map.values().stream()
                .filter(x -> x % 2 != 0)
                .count() > 0 ? 1 : 0;
        return result;
    }
}
