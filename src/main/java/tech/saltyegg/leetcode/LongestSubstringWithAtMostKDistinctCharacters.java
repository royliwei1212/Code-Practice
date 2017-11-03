package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k < 1) return 0;
        if (s.length() <= k) return s.length();

        int result = k;
        int pre = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char p = s.charAt(pre++);
                int count = map.get(p) - 1;
                if (count == 0) {
                    map.remove(p);
                } else {
                    map.put(p, count);
                }
            }
            result = Math.max(result, i - pre + 1);
        }
        return result;
    }

}
