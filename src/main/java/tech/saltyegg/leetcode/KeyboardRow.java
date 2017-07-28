package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = buildMap();
        for (String s : words) {
            if (s == null || s.isEmpty()) continue;
            char[] chars = s.toLowerCase().toCharArray();
            int x = map.get(chars[0]);
            for (char c : chars) {
                if (map.get(c) != x) {
                    x = -1;
                    break;
                }
            }
            if (x != -1) {
                result.add(s);
            }
        }

        String[] arr = new String[result.size()];
        return result.toArray(arr);
    }

    private Map<Character, Integer> buildMap() {
        char[] l1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] l2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] l3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        Map<Character, Integer> result = new HashMap<>();
        for (char c : l1) {
            result.put(c, 1);
        }
        for (char c : l2) {
            result.put(c, 2);
        }
        for (char c : l3) {
            result.put(c, 3);
        }
        return result;
    }
}
