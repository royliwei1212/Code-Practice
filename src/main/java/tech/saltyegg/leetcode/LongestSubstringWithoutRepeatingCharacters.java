package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertSame;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int pre, result;
        pre = 0;
        result = 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            char c = s.charAt(i);
            if (set.contains(c)) {

                while (s.charAt(pre) != s.charAt(i)) {
                    set.remove(s.charAt(pre));
                    pre++;
                }
                pre++;
            } else {
                set.add(c);
            }
            result = Math.max(result, i - pre + 1);
        }
        return result;
    }

    @Test
    public void test() {
        String s = "abb";
        assertSame(2, lengthOfLongestSubstring(s));
    }
}
