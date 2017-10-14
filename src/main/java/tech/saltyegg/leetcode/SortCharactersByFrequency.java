package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/15/17
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;
        Map<Character, StringBuilder> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, new StringBuilder()).append(c));
        }
        return map.values().stream()
                .sorted((a, b) -> b.length() - a.length())
                .reduce((a, b) -> a.append(b.toString())).get().toString();
    }
}
