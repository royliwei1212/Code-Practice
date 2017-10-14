package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 1;
        int pre = -1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = map.getOrDefault(c, -1);
            if (lastIndex > pre) {
                pre = lastIndex;
            }
            map.put(c, i);
            result = Math.max(result, i - pre);
        }
        return result;
    }
}
