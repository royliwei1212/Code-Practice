package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertSame;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int pre, crt, max;
        pre = 0;
        crt = max = 1;

        Set<Character> set = new HashSet<Character>();
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            crt = i;
            char c = s.charAt(i);
            if (set.contains(c)) {

                while (s.charAt(pre) != s.charAt(crt)) {
                    set.remove(s.charAt(pre));
                    pre++;
                }
                pre++;
            } else {
                set.add(c);
            }
            if (max < crt - pre + 1) {
                max = crt - pre + 1;
            }
        }
        return max;
    }

    @Test
    public void test() {
        String s = "abb";
        assertSame(2, lengthOfLongestSubstring(s));
    }
}
