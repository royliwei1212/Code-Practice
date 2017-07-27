package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        Map<Integer, Character> map = new HashMap<>();
        int length = parse(abbr, map);
        if (word.length() != length) {
            return false;
        }

        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            if (!Objects.equals(word.charAt(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int parse(String abbr, Map<Integer, Character> map) {
        int length = 0;
        int x = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                length += x + 1;
                map.put(length - 1, c);

                x = 0;
            } else {
                if (x == 0 && c == '0') return -1;
                x = 10 * x + c - '0';
            }
        }
        if (x > 0) {
            length += x;
        }
        return length;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation vwa = new ValidWordAbbreviation();
        Map<Integer, Character> map = new HashMap<>();
        int x = vwa.parse("i12iz4n", map);
        System.out.println();
    }
}
