package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 5/4/16.
 * Email: i@hzhou.me
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
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

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
            }
        }

        return count < 2;
    }
}
