package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class WordPatternII {

    public boolean wordPatternMatch(String pattern, String str) {
        return helper(0, 0, pattern, str, new HashMap<>());
    }

    private boolean helper(int p, int s, String pattern, String str, Map<Character, String> dict) {
        if (p == pattern.length() && s == str.length()) {
            return true;
        }

        if (p == pattern.length() || s == str.length()) {
            return false;
        }

        char c = pattern.charAt(p);

        for (int i = s; i < str.length(); i++) {
            String sub = str.substring(s, i + 1);

            if (dict.getOrDefault(c, "").equals(sub)) {
                return helper(p + 1, i + 1, pattern, str, dict);
            } else if (!dict.containsKey(c)) {
                if (!dict.values().contains(sub)) {
                    dict.put(c, sub);
                    if (helper(p + 1, i + 1, pattern, str, dict)) return true;
                    dict.remove(c);
                }
            }
        }
        return false;
    }

}
