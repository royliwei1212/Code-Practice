package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2015/8/8.
 * Email: i@hzhou.me
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 1;
            if (map.containsKey(c)) {
                count += map.get(c);
            }
            map.put(c, count);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (!map.containsKey(c)) {
                return false;
            }
            int count = map.get(c) - 1;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }

        return map.isEmpty();
    }
}
