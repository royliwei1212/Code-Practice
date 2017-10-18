package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) return 0;

        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
            if (entry.getValue() < k) {
                set.add(entry.getKey());
            }
        }

        if (set.isEmpty()) return s.length();

        int result = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                result = Math.max(result, longestSubstring(s.substring(pre, i), k));
                pre = i + 1;
            }

        }
        result = Math.max(result, longestSubstring(s.substring(pre, s.length()), k));
        return result;
    }
}
