package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p.isEmpty() || s.length() < p.length()) return result;

        Map<Character, Integer> ds = new HashMap<>();
        Map<Character, Integer> dp = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            ds.put(s.charAt(i), ds.getOrDefault(s.charAt(i), 0) + 1);
            dp.put(p.charAt(i), dp.getOrDefault(p.charAt(i), 0) + 1);
        }
        if (isEqual(ds, dp)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char c = s.charAt(i);
            ds.put(c, ds.getOrDefault(c, 0) + 1);
            ds.put(s.charAt(i - p.length()), ds.getOrDefault(s.charAt(i - p.length()), 0) - 1);
            if (isEqual(ds, dp)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    private boolean isEqual(Map<Character, Integer> map, Map<Character, Integer> src) {
        for (Map.Entry<Character, Integer> entry : src.entrySet()) {
            if (!map.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
