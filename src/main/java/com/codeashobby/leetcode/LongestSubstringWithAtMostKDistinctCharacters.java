package com.codeashobby.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }

        Map<Character, Integer> dict = new HashMap<>();
        int pre = 0;
        int crt = 1;

        int result = 1;
        dict.put(s.charAt(0), 1);
        while (crt < s.length()) {
            Character c = s.charAt(crt);
            crt++;

            dict.put(c, dict.containsKey(c) ? dict.get(c) + 1 : 1);

            Character start = s.charAt(pre);
            while (dict.size() > k) {
                int count = dict.get(start);
                if (count == 1) {
                    dict.remove(start);
                } else {
                    dict.put(start, count - 1);
                }
                pre++;
                start = s.charAt(pre);
            }

            result = Math.max(result, crt - pre);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
        l.lengthOfLongestSubstringKDistinct("eceba", 2);

    }

}
