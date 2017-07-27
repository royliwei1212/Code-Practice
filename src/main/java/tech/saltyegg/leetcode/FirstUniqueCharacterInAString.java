package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i != s.lastIndexOf(c)) {
                set.add(c);
            }
            if (i == s.lastIndexOf(c) && !set.contains(c)) {
                return i;
            }
        }
        return -1;
    }
}
