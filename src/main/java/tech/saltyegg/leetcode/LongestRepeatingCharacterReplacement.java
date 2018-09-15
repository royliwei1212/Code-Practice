package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() <= k) return s.length();

        int pre = 0;
        int crt = 0;
        int maxCount = 1;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (crt < s.length()) {
            char c = s.charAt(crt);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, map.get(c));

            while (crt - pre + 1 - maxCount > k) {
                char p = s.charAt(pre);
                map.put(p, map.get(p) - 1);
                pre++;
            }
            result = Math.max(result, crt - pre + 1);
            crt++;
        }
        return result;
    }

}
