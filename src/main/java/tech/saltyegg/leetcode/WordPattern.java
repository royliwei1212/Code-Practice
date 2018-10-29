package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/14.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.isEmpty() || str.isEmpty()) {
            return false;
        }

        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }

        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = array[i];
            if (!m1.containsKey(c) && !m2.containsKey(s)) {
                m1.put(c, s);
                m2.put(s, c);
            } else {
                if (m1.get(c) == null || !m1.get(c).equals(s) || m2.get(s) == null || m2.get(s) != c) {
                    return false;
                }
            }
        }
        return true;
    }

}
