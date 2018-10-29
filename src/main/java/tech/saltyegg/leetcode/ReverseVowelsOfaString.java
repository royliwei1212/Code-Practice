package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hzhou on 2016/5/6.
 */
public class ReverseVowelsOfaString {

    private Set<Character> vowels = new HashSet<Character>() {{
        add('A');
        add('a');
        add('E');
        add('e');
        add('I');
        add('i');
        add('O');
        add('o');
        add('U');
        add('u');

    }};

    public String reverseVowels(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r) {
                if (vowels.contains(chars[l])) {
                    break;
                } else {
                    l++;
                }
            }
            while (l < r) {
                if (vowels.contains(chars[r])) {
                    break;
                } else {
                    r--;
                }
            }

            if (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
